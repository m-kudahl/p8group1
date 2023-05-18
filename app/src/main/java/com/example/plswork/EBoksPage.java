package com.example.plswork;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EBoksPage extends StandardPagesActivity {

    ImageButton appleButton, googleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eboks_page);
        setupToolbar(this);
        appleButton = findViewById(R.id.appleStoreButtonEBoks);
        googleButton = findViewById(R.id.googleStoreButtonEBoks);
        //Set up the apple button
        setupLinkImageButton(appleButton, "https://apps.apple.com/dk/app/mitid/id1555231176");
        //set up googleButton
        setupLinkImageButton(googleButton, "https://play.google.com/store/apps/details?id=dk.mitid.app.android&hl=en&gl=US");

    }
}