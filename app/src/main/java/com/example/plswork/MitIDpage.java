package com.example.plswork;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MitIDpage extends StandardPagesActivity {

    ImageButton appleButton, googleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mit_idpage);
        setupToolbar(this);

        appleButton = findViewById(R.id.appleStoreButtonMitID);
        googleButton = findViewById(R.id.googleStoreButtonMitID);

        //Set up the apple button
        setupLinkImageButton(appleButton, "https://apps.apple.com/dk/app/mitid/id1555231176");
        //set up googleButton
        setupLinkImageButton(googleButton, "https://play.google.com/store/apps/details?id=dk.mitid.app.android&hl=en&gl=US");
    }

}