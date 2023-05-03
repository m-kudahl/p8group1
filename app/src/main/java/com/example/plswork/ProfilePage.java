package com.example.plswork;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.InstallationTokenResult;

public class ProfilePage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            Intent intent = new Intent(ProfilePage.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {


            boolean forceRefresh = true;
            FirebaseInstallations.getInstance().getToken(forceRefresh)
                    .addOnCompleteListener(new OnCompleteListener<InstallationTokenResult>() {
                        @Override
                        public void onComplete(@NonNull Task<InstallationTokenResult> task) {
                            if (task.isSuccessful()) {
                                String token = task.getResult().getToken();
                                Log.d(TAG, "Firebase Installation Token: " + token);
                            } else {
                                Log.e(TAG, "Failed to get Firebase Installation Token: ", task.getException());
                            }
                        }
                    });
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        mAuth = FirebaseAuth.getInstance();

        Button logOutBtn = (Button) findViewById(R.id.logOutBtn);
        TextView name = findViewById(R.id.textViewEditName);
        TextView email = findViewById(R.id.textViewEditEmail);
        TextView municipality = findViewById(R.id.textViewEditMunicipality);
        Button editProfile = findViewById(R.id.editProfileButton);
        Button deleteAccount = findViewById(R.id.deleteProfileBtn);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userUid = currentUser.getUid();
            dynamicTextView(userUid, name, "userFullName");
            dynamicTextView(userUid, email, "userEmail");
            dynamicTextView(userUid, municipality, "userMunicipality");
        }

        AppBarUtility.setupHomeButton(this, R.id.my_toolbar);
        AppBarUtility.setUpBackButton(this);

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder deleteAccountDialog = new AlertDialog.Builder(v.getContext());
                deleteAccountDialog.setTitle(R.string.delete_account);
                deleteAccountDialog.setMessage(R.string.are_you_sure_you_want_to_delete_your_account);
                deleteAccountDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String userUid = currentUser.getUid();
                        currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    DatabaseReference deleteUser = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users/"+userUid);
                                    deleteUser.removeValue()
                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void unused) {
                                                            Toast.makeText(ProfilePage.this, "Account Deleted", Toast.LENGTH_SHORT).show();

                                                        }
                                                    }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Toast.makeText(ProfilePage.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                                }
                                            });

                                    Toast.makeText(ProfilePage.this, "Account deleted", Toast.LENGTH_SHORT);
                                    Intent intent = new Intent(ProfilePage.this, Tab_Layout.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(ProfilePage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

                    }
                });
                deleteAccountDialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close dialog
                    }
                });
                deleteAccountDialog.create().show();
            }
        });
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilePage.this, EditProfile.class);
                startActivity(intent);
            }
        });

        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(ProfilePage.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    public void dynamicTextView(String uid, TextView yourView, String path){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("users/" + uid);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.child(path).getValue(String.class);
                yourView.setText(text);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());


            }
        });
    }
}