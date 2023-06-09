package com.example.plswork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.ResourceBundle;

public class LoginActivity extends NotUserPages {

    private FirebaseAuth mAuth;

    /**
     * Her logger man ind
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        setupToolbar(this);
        EditText editTextEmail = findViewById(R.id.editTextEmailAddress);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button btn = (Button)findViewById(R.id.loginButton);
        Button createBtn = (Button) findViewById(R.id.createaccountButton);
        Button forgetPasswordBtn = findViewById(R.id.forgotButton);

        /**
         * Første knap er en forget password knap - hvis man glemmer sit password
         * Når man klikker her kommer der en alertbox, hvori man kan skrive sin email
         */
        forgetPasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle(R.string.reset_password);
                passwordResetDialog.setMessage(R.string.enter_your_email_to_receive_reset_link);
                passwordResetDialog.setView(resetMail);
                passwordResetDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //send reset link to user
                        String mail = resetMail.getText().toString();
                        //firebase's egen måde at sende mail med passwordreset

                        //OnSuccess giver besked hvis der er lykkedes
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(LoginActivity.this, "Reset link sent to your e-mail", Toast.LENGTH_SHORT);
                            }

                            //Giver besked hvis din mail ikke var der
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Email not found" + e.getMessage(), Toast.LENGTH_SHORT);

                            }
                        });
                    }
                });

                //hvis du siger nej til at reset så gør den det her (ingenting)
                passwordResetDialog.setNegativeButton(R.string.no , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the dialog

                    }
                });
                passwordResetDialog.create().show();
            }
        });
        //create button - bliver henvist til register activity siden
        createBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                 startActivity(intent);
             }
        });

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        // Get the email and password from the user
                        String email = editTextEmail.getText().toString();
                        String password = editTextPassword.getText().toString();

                        // Call the signInWithEmailAndPassword() method to sign in the user
                        login(email, password);

                    }
                });
    }

    //tager de to textfields email/password og smider dem ind i en FireBase metode der linker de to
    public void login(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    //hvis det lykkedes at logge ind, bliver man henvist til tablayout
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(LoginActivity.this, Tab_Layout.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}