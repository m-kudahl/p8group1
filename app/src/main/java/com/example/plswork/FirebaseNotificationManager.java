package com.example.plswork;

import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class FirebaseNotificationManager extends FirebaseMessagingService {

    private DatabaseReference mDatabase;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Process the incoming message here
        super.onMessageReceived(remoteMessage);

        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
        NotificationManager.showNotification(getApplicationContext(), title, message);

        Map<String, String> messageData = remoteMessage.getData();

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userUid = currentUser.getUid();
            mDatabase = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
            DatabaseReference messages = mDatabase.child("users").child(userUid).child("messages").push();
            String messageID = messages.getKey();

            Map<String, Object> messageMap = new HashMap<>();
            messageMap.put("title", title);
            messageMap.put("message", message);
            long timestamp = System.currentTimeMillis();
            Date date = new Date(timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            sdf.setTimeZone(TimeZone.getDefault());
            String formattedDate = sdf.format(date);
            messageMap.put("timestamp", formattedDate);

            messages.setValue(messageMap);

            Intent broadcastIntent = new Intent("com.example.plswork.NEW_MESSAGE");
            broadcastIntent.putExtra("title", title);
            broadcastIntent.putExtra("message", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent);
        }
    }



}





