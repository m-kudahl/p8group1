package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandingActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(LandingActivity.this, Tab_Layout.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.appbarLanding);
        AppBarUtility.setUpBackButton(this);
        AppBarUtility.setupLangButton(this, R.id.appbarLanding);


    }
        public void goToRegister (View view) {
            Intent intent = new Intent (this, RegisterActivity.class);
            startActivity(intent);
    }
    public void goToLogin (View view) {
        Intent intent = new Intent (this, Tab_Layout.class);
        startActivity(intent);
    }

}