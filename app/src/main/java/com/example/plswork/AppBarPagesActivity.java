package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class AppBarPagesActivity extends AppCompatActivity {


    protected void setupToolbar(Activity activity) {
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        //set up the home button
        AppBarUtility.setupHomeButton(activity);
        //set up the back button
        AppBarUtility.setUpBackButton(activity);
        //set up profile button
        AppBarUtility.setupProfilePage(activity);
        //set up language button
        AppBarUtility.setupLangButton(activity);

    }
}