package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView autocomplete;


    String[] cities = { "Randers", "Aalborg","Aarhus",
            "Copenhagen"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.inflateMenu(R.menu.main_menu);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(null);



        autocomplete = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}