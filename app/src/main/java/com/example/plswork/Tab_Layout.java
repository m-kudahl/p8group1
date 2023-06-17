package com.example.plswork;

import static com.example.plswork.NotificationPermissionAsk.MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Tab_Layout extends AppBarPagesActivity implements NotificationPermissionChecker {
    //a class to display the main page in a tab_layout
    public TabLayout tabLayout;
    public ViewPager2 viewPager2;
    public TabLayoutViewPage viewPagerAdapter;
    //since we ask for permission to post notifications on this page it has a NotificationPermissionAsk object
    private NotificationPermissionAsk notificationPermissionAsk;

    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tablayout);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        viewPagerAdapter = new TabLayoutViewPage(this);
        viewPager2.setAdapter(viewPagerAdapter);
        mAuth = FirebaseAuth.getInstance();

        //not sure exactly what this LocalBroadcastManager does or is so maybe it should just be removed?
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String title = intent.getStringExtra("title");
                String message = intent.getStringExtra("message");
                // Handle the received message here, for example, update the UI or show a Toast.
            }
        }, new IntentFilter("com.example.plswork.NEW_MESSAGE"));

        //ask the user for permission to post notifications

        notificationPermissionAsk = new NotificationPermissionAsk(this);
        notificationPermissionAsk.askNotificationPermission(this);
        NotificationManager.createNotificationChannel(this);

        setupToolbar(this);






        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();

            }
        });
    }
    //using the interface we check if the permission is true
    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            // Permission granted, you can show the notification now
        } else {

        }
    }
    //this is probably not used since we use the interface to check for permission
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, you can show the notification now
                } else {

                }
            }
        }

    }
}
