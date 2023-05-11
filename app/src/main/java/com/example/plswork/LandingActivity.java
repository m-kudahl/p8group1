package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LandingActivity extends NotUserPages {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


        setupToolbar(this);


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