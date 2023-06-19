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

    /**
     * Der bliver sendt en remotemessage fra Firebase
     * @param remoteMessage Remote message that has been received.
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Process the incoming message here
        super.onMessageReceived(remoteMessage);

        String title = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
        NotificationManager.showNotification(getApplicationContext(), title, message);

        Map<String, String> messageData = remoteMessage.getData();
        //hvis man er en bruger, tager den dit bruger id og gemmer beskeden under timestamp som gemmer
        //en titel og en "message"
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userUid = currentUser.getUid();
            mDatabase = FirebaseDatabase.getInstance("https://p8-g1-bc27c-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
            DatabaseReference messages = mDatabase.child("users").child(userUid).child("messages").push();
            String messageID = messages.getKey();
            //måden den refererer til title/message i databasen
            Map<String, Object> messageMap = new HashMap<>();
            messageMap.put("title", title);
            messageMap.put("message", message);
            //en måde at omregne tid på - systemtiden på telefonen, som gemmes som en long
            //den omdanner tiden i millisekunder til en datoformat (millisekunder siden 1. januar 1970)
            long timestamp = System.currentTimeMillis();
            Date date = new Date(timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            sdf.setTimeZone(TimeZone.getDefault());
            String formattedDate = sdf.format(date);
            messageMap.put("timestamp", formattedDate);

            messages.setValue(messageMap);

            //skal display en notifikation, når man klikker på den bliver man sendt videre til tablayout (tror vi)
            Intent broadcastIntent = new Intent("com.example.plswork.NEW_MESSAGE");
            broadcastIntent.putExtra("title", title);
            broadcastIntent.putExtra("message", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(broadcastIntent);
        }
    }



}





