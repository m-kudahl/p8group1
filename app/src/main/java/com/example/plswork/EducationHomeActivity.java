package com.example.plswork;

import android.os.Bundle;
import android.widget.Button;


public class EducationHomeActivity extends StandardPagesActivity {


    Button DiplomVerificationBtn, EducationOptionsBtn, SUBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_home);

        DiplomVerificationBtn = (Button) findViewById(R.id.DiplomVerification);
        EducationOptionsBtn = (Button) findViewById(R.id.EducationOptions);
        SUBtn = (Button) findViewById(R.id.SU);
        setupToolbar(this);

        //Diplom knappen
        setupInternalLinkButton(DiplomVerificationBtn,EducationDiplomActivity.class);

        //Options knappen
        setupInternalLinkButton(EducationOptionsBtn,EducationOptionsActivity.class);

        //SU knappen
        setupInternalLinkButton(SUBtn,EducationSUActivity.class);

    }
}