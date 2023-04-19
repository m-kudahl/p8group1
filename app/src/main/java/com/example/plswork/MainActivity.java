package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autocomplete;

    String[] cities = { "Randers", "Aalborg","Aarhus",
            "Copenhagen"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);
    }
}