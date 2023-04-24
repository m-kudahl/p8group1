package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autocomplete;

    String[] cities = { "Randers", "Aalborg","Aarhus",
            "Copenhagen"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Kode der åbner EducationActivity i stedet for MainActivity
        Intent EducationActivityIntent = new Intent(
                this, EducationSUActivity.class
        );
        startActivity(EducationActivityIntent);
        //Slutter her

        setContentView(R.layout.activity_main);


        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);
    }
}