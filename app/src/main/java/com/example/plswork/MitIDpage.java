package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MitIDpage extends AppCompatActivity {

    ImageButton appleButton, googleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mit_idpage);

        // Get a reference to the included layout
        View includedLayout = findViewById(R.id.appbarMitID);

        // Get a reference to the specific TextView within the included layout
        Button myHomeButton = includedLayout.findViewById(R.id.back_button);

        // Disable the TextView
        myHomeButton.setEnabled(false);

        appleButton = findViewById(R.id.appleStoreButtonMitID);
        googleButton = findViewById(R.id.googleStoreButtonMitID);

        appleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://apps.apple.com/dk/app/e-boks-dk/id482926022";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=com.eboks.activities&hl=da&gl=US&pli=1";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        //appbar
        AppBarUtility.setupHomeButton(this, R.id.appbarMitID);
        AppBarUtility.setUpBackButton(this);
    }

}