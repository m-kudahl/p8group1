package com.example.plswork;

import static com.example.plswork.NotificationPermissionAsk.MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Tab_Layout extends AppBarPagesActivity implements NotificationPermissionChecker {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabLayoutViewPage viewPagerAdapter;
    CardView cardViewEducation;
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

        // Get a reference to the included layout
        View includedLayout = findViewById(R.id.appbarHomeActivity);

        // Get a reference to the specific Button within the included layout
        Button myBackButton = includedLayout.findViewById(R.id.back_button);
        Button myHomeButton = includedLayout.findViewById(R.id.home_button);


        // Disable and make the Button invisible
        myBackButton.setEnabled(false);
        myBackButton.setVisibility(View.INVISIBLE);

        // Disable and make the Button invisible
        myHomeButton.setEnabled(false);
        myHomeButton.setVisibility(View.INVISIBLE);

        AppBarUtility.setupLangButton(this, R.id.appbarHomeActivity);


        Button toolbarProfileBtn = (Button) findViewById(R.id.profile_button);
        toolbarProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tab_Layout.this, ProfilePage.class);
                startActivity(intent);
            }
        });




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
    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            // Permission granted, you can show the notification now
        } else {
            // Permission denied, show a message or take appropriate action
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_POST_NOTIFICATIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, you can show the notification now
                } else {
                    // Permission denied, show a message or take appropriate action
                }
                return;
            }
        }

    }
}
