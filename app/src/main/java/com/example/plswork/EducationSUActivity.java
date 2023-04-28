package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EducationSUActivity extends AppCompatActivity {

    Button SUMitIDBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_suactivity);

        SUMitIDBtn = (Button) findViewById(R.id.buttonEducationSU);

        SUMitIDBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent(EducationSUActivity.this, MitIDpage.class));
            }
        });


    }
}