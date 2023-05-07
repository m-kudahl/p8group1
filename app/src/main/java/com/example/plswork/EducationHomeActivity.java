package com.example.plswork;

import android.os.Bundle;
import android.widget.Button;


public class EducationHomeActivity extends InformationPagesActivity {


    Button DiplomVerificationBtn, EducationOptionsBtn, SUBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_home);

        DiplomVerificationBtn = (Button) findViewById(R.id.DiplomVerification);
        EducationOptionsBtn = (Button) findViewById(R.id.EducationOptions);
        SUBtn = (Button) findViewById(R.id.SU);

        //Diplom knappen
        setupInternalLinkButton(DiplomVerificationBtn,EducationDiplomActivity.class);

        //Options knappen
        setupInternalLinkButton(DiplomVerificationBtn,EducationOptionsActivity.class);

        //SU knappen
        setupInternalLinkButton(DiplomVerificationBtn,EducationSUActivity.class);


        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.my_toolbar);
        AppBarUtility.setUpBackButton(this);

    }
}