package com.example.plswork;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Hvis man er en user kan man komme ind på denne side
 *
 * Formålet med siden er at man kan redigere sine profilindstillinger
 */
public class EditProfileActivity extends UserPages {

    public String[] cities = { "Randers", "Aalborg","Aarhus",
            "Copenhagen"};
    //For at få brugerens user id:
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        mAuth = FirebaseAuth.getInstance();

        AutoCompleteTextView autocomplete = (AutoCompleteTextView)
                findViewById(R.id.citiesUserAutoComplete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        Button btn = (Button)findViewById(R.id.editProfileUserButton);
        EditText nameEditText = findViewById(R.id.editTextUserFullName);
        setupToolbar(this);

        btn.setOnClickListener(new View.OnClickListener() {
            /**
             * Knap til at ændre municipality for brugeren
             * @param v
             */
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String municipality = autocomplete.getText().toString();

                FirebaseUser currentUser = mAuth.getCurrentUser();
                String userUid = currentUser.getUid();
                if (name.isEmpty()) {

                } else {
                    updateValue(userUid, name, "/userFullName");
                }

                if(municipality.isEmpty()){
                //her opdaterer man sin municipality fra nuværende til den nye - unsubscriber til nuværende og subscriber til ny
                } else {
                    FirebaseDatabase database = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/");
                    DatabaseReference myRef = database.getReference("users/" + userUid + "/userMunicipality");
                    myRef.addValueEventListener(new ValueEventListener() {
                        //når dataen i snapshottet ændres sker det her
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String userMunicipality = snapshot.getValue(String.class);
                            FirebaseMessaging.getInstance().unsubscribeFromTopic(userMunicipality)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            FirebaseMessaging.getInstance().subscribeToTopic(municipality)
                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void aVoid) {
                                                            Log.d(TAG, "User subscribed to new_topic");
                                                        }
                                                    })
                                                    .addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Log.e(TAG, "Failed to subscribe user to new_topic", e);
                                                        }
                                                    });
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.e(TAG, "Failed to unsubscribe user from current_topic", e);
                                        }
                                    });

                        }
                        //hvis der er en fejl med at oprette connection - er der her en exception handler
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });

                    updateValue(userUid, municipality, "/userMunicipality");
                }

                Intent intent = new Intent(EditProfileActivity.this, ProfilePage.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Opdaterer den værdi man vil ændre i databasen
     * @param uid - user id
     * @param updateValue - value man opdaterer
     * @param path - path til den value
     */
    public void updateValue(String uid, String updateValue, String path) {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("users/" + uid + path);

        myRef.setValue(updateValue).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Municipality updated successfully.");
                } else {
                    Log.w(TAG, "Error updating municipality.", task.getException());
                }
            }
        });
    }

}