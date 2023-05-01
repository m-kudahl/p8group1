package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class EducationHomeActivity extends AppCompatActivity {


    Button DiplomVerificationBtn, EducationOptionsBtn, SUBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_home);

        DiplomVerificationBtn = (Button) findViewById(R.id.DiplomVerification);
        EducationOptionsBtn = (Button) findViewById(R.id.EducationOptions);
        SUBtn = (Button) findViewById(R.id.SU);

        DiplomVerificationBtn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                startActivity(new Intent(EducationHomeActivity.this, EducationDiplomActivity.class));
            }
        });

        EducationOptionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationHomeActivity.this, EducationOptionsActivity.class));
            }
        });

        SUBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationHomeActivity.this, EducationSUActivity.class));
            }
        });

    }
}