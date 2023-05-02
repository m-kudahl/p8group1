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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

public class RegisterActivity extends AppCompatActivity {
    AutoCompleteTextView autocomplete;
    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;
    String[] cities = { "Randers", "Aalborg","Aarhus",
            "Copenhagen"};

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(RegisterActivity.this, Tab_Layout.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();



        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.citiesAutoComplete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);

        Button btn = (Button)findViewById(R.id.registerButton);
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        EditText nameEditText = findViewById(R.id.editTextName);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Authenticate the user with Firebase Authentication
                FirebaseAuth mAuth = FirebaseAuth.getInstance();

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String fullName = nameEditText.getText().toString();
                String municipality = autocomplete.getText().toString();
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
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Authentication successful, continue with adding data to database
                                    FirebaseMessaging.getInstance().getToken()
                                            .addOnCompleteListener(new OnCompleteListener<String>() {
                                                @Override
                                                public void onComplete(@NonNull Task<String> task) {
                                                    if (!task.isSuccessful()) {
                                                        Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                                                        return;
                                                    }

                                                    // Get new FCM registration token
                                                    String token = task.getResult();

                                                    // Save the token to the Realtime Database
                                                    FirebaseUser currentUser = mAuth.getCurrentUser();
                                                    String uid = currentUser.getUid();
                                                    mDatabase = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users");
                                                    writeNewUser(uid, fullName, email, municipality, token);
                                                }
                                            });
                                    FirebaseMessaging.getInstance().subscribeToTopic(municipality)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    String msg = "Subscribed";
                                                    if (!task.isSuccessful()) {
                                                        msg = "Subscribe failed";
                                                    }
                                                    Log.d(TAG, msg);
                                                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                    // Redirect the user to the login page
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    // Authentication failed, display an error message
                                    Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.appbarRegister);
        AppBarUtility.setUpBackButton(this);
    }
    public void writeNewUser(String userId, String name, String email, String municipality, String token) {
        User user = new User(email, name, municipality, userId);
        user.setUserToken(token);
        mDatabase.child(user.getUserId()).setValue(user);


    }
}
