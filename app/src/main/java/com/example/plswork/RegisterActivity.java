package com.example.plswork;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class RegisterActivity extends NotUserPages {
    public AutoCompleteTextView autocomplete;
    //the database reference
    private DatabaseReference mDatabase;

    //the users authentication
    private FirebaseAuth mAuth;
    //an array of cities the user can choose between
    public String[] cities = { "Randers", "Aalborg","Aarhus",
            "Copenhagen"};


    /**
     * Her opretter man en bruger
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();



        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.citiesAutoComplete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        //arrayliste af municipalities - en slags edit text view
        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);

        Button btn = (Button)findViewById(R.id.registerButton);
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        EditText nameEditText = findViewById(R.id.editTextName);

        setupToolbar(this);

        //when the register button is clicked we create the user
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sets the variables to the users inputted text in the textfields
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String fullName = nameEditText.getText().toString();
                String municipality = autocomplete.getText().toString();
                //if any of the fields are empty we display a message
                if (municipality.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please select your municipality", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please write a password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(fullName.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please select your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please write an email", Toast.LENGTH_SHORT).show();
                    return;
                }

                //to check if the account creating process were a success before redirecting the user
                //we use the Runnable object - er den sidste hændelse en success, hvis ikke stopper vi processen
                //med at oprette brugere
                Runnable writeUserToDBSuccess = new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                };
                //if there were any problems with creating the account, we show a message instead
                Runnable writeUserToDBFailure = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegisterActivity.this, "Account creation unsuccessful",
                                Toast.LENGTH_SHORT).show();
                    }
                };
                //if subscribing to municipality were a success we proceed with adding the user to the database
                Runnable subscribeToTopicSuccess = new Runnable() {
                    @Override
                    public void run() {
                        FirebaseUser currentUser = mAuth.getCurrentUser();
                        String uid = currentUser.getUid();
                        writeNewUser(uid, fullName, email, municipality, writeUserToDBSuccess, writeUserToDBFailure);
                    }
                };
                //if subscribing to municipality were a failure we show an error message
                Runnable subscribeToTopicFailure = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegisterActivity.this, "Account creation unsuccessful",
                                Toast.LENGTH_SHORT).show();
                    }
                };
                //if authenticating the user were a success we subscribe the user to the municipality
                Runnable createUserSuccess = new Runnable() {
                    @Override
                    public void run() {
                        subscribeToMunicipality(municipality, subscribeToTopicSuccess, subscribeToTopicFailure);
                    }
                };
                //if authenticating the user were a failure we show an error message
                Runnable createUserFailure = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegisterActivity.this, "Account creation unsuccessful",
                                Toast.LENGTH_SHORT).show();
                    }
                };
                //we start by running the createNewAccount method which authenticates the user
                //if that's a success, the user is subscribed to the municipality chosen
                //if the subscription is a success the user is added to the database
                createNewAccount(email, password, createUserSuccess, createUserFailure);




            }
        });
        //appbar buttons
        AppBarUtility.setupHomeButton(this);
        AppBarUtility.setUpBackButton(this);
    }
    public void createNewAccount(String email, String password, Runnable createUserSuccess, Runnable createUserFailure) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Authentication successful, continue with subscribing the user to the database by using the createUserSuccess runnable
                            createUserSuccess.run();
                        } else {
                            // Authentication failed, createUserFailure runnable is run
                            createUserFailure.run();

                        }
                    }
                });

    }

    //subscribes the user to their municipality to show targeted notifications
    public void subscribeToMunicipality(String municipality, Runnable subscribeToTopicSuccess, Runnable subscribeToTopicFailure) {
        FirebaseMessaging.getInstance().subscribeToTopic(municipality)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            subscribeToTopicSuccess.run(); //if the subscription is a success we run the subscribeToTopicSuccess runnable
                        } else {
                            Log.w(TAG, "Failed subscribing to topic", task.getException());
                            subscribeToTopicFailure.run(); //if the subscription is a failure we run the subscribeToTopicFailure runnable
                        }
                    }
                });
    }
    public void writeNewUser(String userId, String name, String email, String municipality, Runnable writeUserToDBSuccess, Runnable writeUserToDBFailure) {
        mDatabase = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users");
        User user = new User(email, name, municipality, userId);

        mDatabase.child(user.getUserId()).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Failed uploading to DB", task.getException());
                            writeUserToDBFailure.run(); //if adding the user to the database is a failure we run the writeUserToDBFailure runnable
                        } else {
                            writeUserToDBSuccess.run(); //if adding the user to the database is a success we run the writeUserToDBSuccess runnable
                        }
                    }
                });


    }

}
