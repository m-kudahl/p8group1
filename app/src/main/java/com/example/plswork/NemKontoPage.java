package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NemKontoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nem_konto_page);


        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.appbarNemKonto);
        AppBarUtility.setUpBackButton(this);
        AppBarUtility.setupLangButton(this, R.id.appbarNemKonto);
    }


}