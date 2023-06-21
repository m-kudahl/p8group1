package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandingActivity extends NotUserPages {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


        setupToolbar(this);

        // Get a reference to the included layout
        View includedLayout = findViewById(R.id.appbarLanding);

        // Get a reference to the specific Button within the included layout
        Button myBackButton = includedLayout.findViewById(R.id.back_button);
        Button myHomeButton = includedLayout.findViewById(R.id.home_button);

        // Disable and make the Button invisible
        myBackButton.setEnabled(false);
        myBackButton.setVisibility(View.INVISIBLE);

        // Disable and make the Button invisible
        myHomeButton.setEnabled(false);
        myHomeButton.setVisibility(View.INVISIBLE);

    }
    //button til register page
        public void goToRegister (View view) {
            Intent intent = new Intent (this, RegisterActivity.class);
            startActivity(intent);
    }
    //button til login page
    public void goToLogin (View view) {
        Intent intent = new Intent (this, Tab_Layout.class);
        startActivity(intent);
    }

}