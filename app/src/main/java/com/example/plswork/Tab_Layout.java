package com.example.plswork;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Tab_Layout extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabLayoutViewPage viewPagerAdapter;
    CardView cardViewEducation;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tablayout);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        viewPagerAdapter = new TabLayoutViewPage(this);
        viewPager2.setAdapter(viewPagerAdapter);

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


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

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
}
