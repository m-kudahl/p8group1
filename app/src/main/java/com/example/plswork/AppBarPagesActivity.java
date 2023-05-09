package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AppBarPagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set up the home button
        AppBarUtility.setupHomeButton(this);
        //set up the back button
        AppBarUtility.setUpBackButton(this);
        //set up profile button
        AppBarUtility.setupProfilePage(this);
        //set up language button
        AppBarUtility.setupLangButton(this);

    }
}