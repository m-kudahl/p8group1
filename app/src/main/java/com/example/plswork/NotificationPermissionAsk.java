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


/**
 * Måden vi spørger om lov til at sende notifikationer
 */
public class NotificationPermissionAsk extends AppCompatActivity {
    //a class that asks the user for permission to post notifications, used to define when permission is granted
    //denne vurder om man får adgang, hvis den returnerer et tal mindre end 123 - hvis den er over så no good
    public static final int MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS = 123;
    //a callback variable that takes a boolean value from the NotificationPermissionChecker to show if permission was granted
    private NotificationPermissionChecker callback;

    //a constructor that sets the permission value to either true or false depending on the users settings for notifications
    public NotificationPermissionAsk(NotificationPermissionChecker callback) {
        this.callback = callback;
    }

    //a method that asks for permission to post notifications
    //hvis ens build/system er over Tiramisu så skal man spørge om lov til at sende notifikationer, hvis ikke så er det automatisk
    public void askNotificationPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { //since this only applies to newer androids we only ask on those
            if (ContextCompat.checkSelfPermission(activity, Manifest.permission.POST_NOTIFICATIONS) //checks if the user already granted permission
                    == PackageManager.PERMISSION_GRANTED) {
                // permission already granted
                callback.onPermissionResult(true); //sets the callback to true, since permission is granted

            } else {
                // permission not yet granted, show why they should grant permission and request permission
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.POST_NOTIFICATIONS)) { //a check if the user previously denied notifications, if true we create a custom alertdialog that asks for permission
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity); //creates the dialog
                    builder.setMessage(R.string.please_grant_permission_to_show_notification_to_receive_news_from_your_municipality) //a message on why they should allow notifications
                            .setPositiveButton("Permission granted", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {  //if the user clicks ok they are asked by androids own permission asker
                                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.POST_NOTIFICATIONS}, MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS);
                                }
                            }).create().show();
                } else { //if the user did not deny permission for notifications earlier we just use androids own permission asker
                    ActivityCompat.requestPermissions(activity,
                            new String[]{Manifest.permission.POST_NOTIFICATIONS},
                            MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS);
                }
            }
        }
    }
}
