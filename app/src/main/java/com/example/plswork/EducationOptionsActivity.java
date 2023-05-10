package com.example.plswork;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EducationOptionsActivity extends StandardPagesActivity {

    //TextView textView;

    private Button buttonEducationOptions1;

    private Button buttonEducationOptions2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_options);

        buttonEducationOptions1 = findViewById(R.id.buttonEducationOptions1);
        buttonEducationOptions1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                showPopUp(v,getString(R.string.educatioOptionsPopUp1),getString(R.string.educatioOptionsPopUp12) + getString(R.string.educatioOptionsPopUp13));
            }
        });
        AppBarUtility.setupLangButton(this);
        buttonEducationOptions2 = findViewById(R.id.buttonEducationOptions2);
        buttonEducationOptions2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                showPopUp(v,getString(R.string.educatioOptionsPopUp2),
                        getString(R.string.educatioOptionsPopUp22) +
                                getString(R.string.educatioOptionsPopUp23) +
                                getString(R.string.educatioOptionsPopUp24) +
                                getString(R.string.educatioOptionsPopUp25));
            }
        });
    }
}