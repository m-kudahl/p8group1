package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EBoksPage extends AppCompatActivity {

    ImageButton appleButton, googleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eboks_page);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.inflateMenu(R.menu.main_menu);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);

        appleButton = findViewById(R.id.appleStoreButtonEBoks);
        googleButton = findViewById(R.id.googleStoreButtonEBoks);
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

        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.appbarEBoks);
        AppBarUtility.setUpBackButton(this);

    }
}