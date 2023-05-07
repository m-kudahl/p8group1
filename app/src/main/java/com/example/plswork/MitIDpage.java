package com.example.plswork;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MitIDpage extends InformationPagesActivity {

    ImageButton appleButton, googleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mit_idpage);

        appleButton = findViewById(R.id.appleStoreButtonMitID);
        googleButton = findViewById(R.id.googleStoreButtonMitID);

        //Set up the apple button
        appleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupLinkImageButton("https://apps.apple.com/dk/app/mitid/id1555231176");
            }
        });

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=dk.mitid.app.android&hl=en&gl=US";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        //setting up back button and home button
        setupHomeButton(R.id.appbarMitID);
        setUpBackButton();
    }

}