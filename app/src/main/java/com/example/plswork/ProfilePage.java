package com.example.plswork;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfilePage extends UserPages {



    private RecyclerView recyclerView;
    private List<Notification> notifications;
    private NotificationRecyclerView notificationRecyclerView;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        mAuth = FirebaseAuth.getInstance();

        // Get the RecyclerView from the profilepage layout file
        recyclerView = findViewById(R.id.recyclerView);
        //since we dont want the recyclerview to change in size, we just set its size to fixed
        recyclerView.setHasFixedSize(true);

        // We want to store the recyclerviews inside a linearlayout to ensure that they're stacked vertically
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Initialize the notifications list and adapter
        notifications = new ArrayList<>();
        notificationRecyclerView = new NotificationRecyclerView(notifications);
        //the setAdapter(adapter) tells the recyclerView that we want to populate it with an arraylist of notifications
        recyclerView.setAdapter(notificationRecyclerView);

        // Call method to fetch data from database
        fetchNotificationsFromDatabase();
        setupToolbar(this);


        Button logOutBtn = (Button) findViewById(R.id.logOutBtn);
        TextView name = findViewById(R.id.textViewEditName);
        TextView email = findViewById(R.id.textViewEditEmail);
        TextView municipality = findViewById(R.id.textViewEditMunicipality);
        Button editProfile = findViewById(R.id.editProfileButton);
        Button deleteAccount = findViewById(R.id.deleteProfileBtn);

        //setting the currentUser variable to the userid
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //if the user is not null we update the dynamic text views to the users data
        if (currentUser != null) {
            String userUid = currentUser.getUid();
            dynamicTextView(userUid, name, "userFullName");
            dynamicTextView(userUid, email, "userEmail");
            dynamicTextView(userUid, municipality, "userMunicipality");
        }


        //the delete account button
        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder deleteAccountDialog = new AlertDialog.Builder(v.getContext()); //a dialog box that asks if the user is sure
                deleteAccountDialog.setTitle(R.string.delete_account);
                deleteAccountDialog.setMessage(R.string.are_you_sure_you_want_to_delete_your_account);
                deleteAccountDialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (currentUser != null) {
                            deleteAccount(); //if the user clicked yes to delete the profile it is deleted by using the deleteAccount method
                        }
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
                Intent intent = new Intent(ProfilePage.this, EditProfileActivity.class);
                startActivity(intent); //if the edit profile button is clicked redirect the user to that page
            }
        });
        /**
         * Clear task og starter ny (session)
         */
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut(); //if the logout button is clicked we sign the user out
                Intent intent = new Intent(ProfilePage.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); //clear tasks and start new
                startActivity(intent); //redirect the user to the login page
            }
        });
    }


    /**
     * Tager alle notifkationerne fra databasen og smider dem ind i recycle view efter dato
     */
    private void fetchNotificationsFromDatabase() { //a method for fetching notifications from DB
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) { //only does this if the user is not null
            String userUid = currentUser.getUid();
            DatabaseReference databaseRef = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users/" + userUid + "/messages");

            // Use a query to order the notifications by timestamp in descending order
            Query query = databaseRef.orderByChild("timestamp");

            //kommer der nye notikationer, hvis ja så opdaterer den
            ValueEventListener valueEventListener = new ValueEventListener() {

                //listen for any new notifications or changes

                //the datasnapshot is an object containing the data of the notifications
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // Clear the list of notifications to avoid duplicates
                    notifications.clear();

                    //loop over all the notifications the user has and create a notification class
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        // Get the Notification object from the snapshot
                        Notification notification = snapshot.getValue(Notification.class);

                        // Add the Notification to the list
                        if (notifications != null) {
                            notifications.add(notification);
                        }
                    }
                    //bare start med ny istedet for ældste:
                    //reverse the order of the list, so the newest notification is displayed first in the recyclerView
                    Collections.reverse(notifications);


                    // Notify the recyclerView of the data change
                    if (notificationRecyclerView != null) {
                        notificationRecyclerView.notifyDataSetChanged();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w(TAG, "Failed loading notifications", databaseError.toException());
                }

            };
            //listen for any new notifications or changes

            query.addListenerForSingleValueEvent(valueEventListener);

        }
    }
    //when this activity is ended we want to cut the connection to the database, so we use the onDestroy method
    //to stop looking for changes in the database to update UI
    //For at lukke forbindelsen til databasen
    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser !=null) {
            String userUid = currentUser.getUid();
            DatabaseReference databaseRef = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users/" + userUid + "/messages");
            Query query = databaseRef.orderByChild("timestamp");
            ValueEventListener valueEventListener = new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // No need to do anything here
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.w(TAG, "Failed loading notifications", databaseError.toException());
                }

            };
            query.removeEventListener(valueEventListener);
        }
    }
    //ændrer sig efter hvilken kommune man er i osv:
    //a method for dynamic text views takes input as the users id, the textview we want to change, and the type of data we want to occupy it with
    public void dynamicTextView(String uid, TextView yourView, String path){
        //creates a connection to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/");
        //since we want data from a particular user we set the reference to that user
        DatabaseReference myRef = database.getReference("users/" + uid);

        //a listener to that users database, so if changes occur the data is updated
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String text = snapshot.child(path).getValue(String.class); //set the text variable to the value we're looking for
                yourView.setText(text); //sets the chosen textview to the value from the database


            }

            //if theres a database error we log the error message
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());


            }
        });
    }
    //the method for deletion of accounts
    //sådan fjerner man en account fra Databasen og mAuth - ifølge firebase
    public void deleteAccount() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) { //we only want to run this code if the user is actually logged in
            String userUid = currentUser.getUid();

            // deletes the user from firebase auth
            currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) { //if deletion was successful we also want to delete them from the database
                        //connects to the database on the specific users location
                        DatabaseReference deleteUser = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("users/" + userUid);
                        //removes the data from that users location
                        deleteUser.removeValue()
                                .addOnSuccessListener(new OnSuccessListener<Void>() { //if it were successful we provide the user with a message
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(ProfilePage.this, R.string.account_deleted, Toast.LENGTH_SHORT).show();

                                    }
                                }).addOnFailureListener(new OnFailureListener() { //if not we provide with an error message
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ProfilePage.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                                    }
                                });
                        //after deletion the user is shown an account deleted message and redirected to the main page

                        Toast.makeText(ProfilePage.this, R.string.account_deleted, Toast.LENGTH_SHORT);
                        Intent intent = new Intent(ProfilePage.this, Tab_Layout.class);
                        startActivity(intent);

                    } else {
                        //if by any reason it were not possible to delete the user they're shown an error message
                        Toast.makeText(ProfilePage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}
