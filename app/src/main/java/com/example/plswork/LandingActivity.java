package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandingActivity extends AppCompatActivity {

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
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }

}