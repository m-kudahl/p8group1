package com.example.plswork;

import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationManager {
    //To handle firebase notifications and notifications in general we need a notification channel
    //and a way to handle incoming notification - hvordan skal telefonen vibrere, hvor vigtig er notifikationen?
    //first we initiate the different variables, the channels ID, name and description
    private static final String CHANNEL_ID = "Youkraine_Notifications";
    private static final String CHANNEL_NAME = "Youkraine Notifications";
    private static final String CHANNEL_DESCRIPTION = "Notifications for users who subscribe to different topics";

    //A notification channel creating method, which we'll call in an activity to create a channel on when a user opens the app for the first time
    public static void createNotificationChannel(@NonNull Context context) {
        //Since creating a notification channel is first required in android version oreo or later, we check if the android version is oreo or later
        //if it is, we create the notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID, CHANNEL_NAME, android.app.NotificationManager.IMPORTANCE_DEFAULT);
            //we initiate some setting for when a notification is incoming, like what the description is, enable light, the notification color is set to red and we enable vibrations
            channel.setDescription(CHANNEL_DESCRIPTION);
            //we then retrieve the system service to handle notifications and create the channel
            android.app.NotificationManager notificationManager = context.getSystemService(android.app.NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    //To show the notifications on the device we use the NotificationCompat.builder to create the notification
    //we initiate some different variables, like the icon, the title, the message, priority and so on.
    public static void showNotification(@NonNull Context context, @NonNull String title, @NonNull String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.outline_person_black_24dp)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        // to show the notification we need to retrieve an instance of NotificationManagerCompat, which handles showing the notification
        //we then use the .notify() on the variable with the NotificationManangerCompat to set a unique ID, which are the system time in milliseconds, to not overwrite any notifications
        //lastly it also takes an input of the notification we just build in builder variable
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify((int) System.currentTimeMillis(), builder.build());
    }
}
