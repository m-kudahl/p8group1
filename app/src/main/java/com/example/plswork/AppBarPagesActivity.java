package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;

public class AppBarPagesActivity extends AppCompatActivity {

//måske kan man lave en konstruktor som bare kalder setupToolBar, istedet for at man skal gøre det for
    //samtlige undersider
    protected void setupToolbar(Activity activity) {
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        //set up the home button
        AppBarUtility.setupHomeButton(activity);
        //set up the back button
        AppBarUtility.setUpBackButton(activity);
        //set up profile button
        AppBarUtility.setupProfileButton(activity);
        //set up language button
        AppBarUtility.setupLangButton(activity);

    }
}