package com.example.plswork;

import android.app.Activity;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



import android.Manifest;




public class NotificationPermissionAsk extends AppCompatActivity {

    public static final int MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS = 123;
    private NotificationPermissionChecker callback;

    public NotificationPermissionAsk(NotificationPermissionChecker callback) {
        this.callback = callback;
    }

    // ...

    public void askNotificationPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.POST_NOTIFICATIONS)
                    == PackageManager.PERMISSION_GRANTED) {
                // permission already granted
                callback.onPermissionResult(true);

            } else {
                // permission not yet granted, show why they should grant permission and request permission
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.POST_NOTIFICATIONS)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage(R.string.please_grant_permission_to_show_notification_to_receive_news_from_your_municipality)
                            .setPositiveButton("Permission granted", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(activity,
                                            new String[]{Manifest.permission.POST_NOTIFICATIONS},
                                            MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS);
                                }
                            }).create().show();
                } else {
                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.POST_NOTIFICATIONS},
                            MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS);
                    // Don't call the callback here, it will be called in onRequestPermissionsResult
                }
            }
        }
    }
}
