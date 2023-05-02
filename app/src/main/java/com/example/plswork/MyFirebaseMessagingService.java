package com.example.plswork;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private DatabaseReference mDatabase;



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Process the incoming message here
        super.onMessageReceived(remoteMessage);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        // Get the message data
        Map<String, String> data = remoteMessage.getData();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String userUid = currentUser.getUid();
        // Write the message data to the database
        mDatabase = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("users").child(userUid).child("messages");
        mDatabase.push().setValue(data);

    }

}
