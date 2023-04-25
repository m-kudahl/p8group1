package com.example.plswork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText nameText, emailText, passwordText;
    Button registerButton;

    User user;
    FirebaseAuth mAuth;
    AutoCompleteTextView autocomplete;


    String[] cities = { "Randers", "Aalborg","Aarhus",
            "Copenhagen"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.inflateMenu(R.menu.main_menu);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);



        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);
        nameText = findViewById(R.id.editTextName);
        emailText = findViewById(R.id.editTextTextEmailAddress);
        passwordText = findViewById(R.id.editTextTextPassword);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, name, municipal;
                email = emailText.getText().toString();
                password = passwordText.getText().toString();
                name = nameText.getText().toString();
                municipal = autocomplete.getText().toString();

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(municipal)){
                    Toast.makeText(MainActivity.this, "Enter municipal", Toast.LENGTH_SHORT).show();
                    return;
                }
                user = new User(email, name, municipal);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                myDatabaseRef = database.getReference("")
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(MainActivity.this, "Account created", Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(MainActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });


    }
}