package com.example.plswork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EducationSUActivity extends InformationPagesActivity {

    Button SUMitIDBtn;

    private Button buttonEducationSU2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_suactivity);

        SUMitIDBtn = (Button) findViewById(R.id.buttonEducationSU);

        //link to MitID
        setupInternalLinkButton(SUMitIDBtn,MitIDpage.class);

        buttonEducationSU2 = findViewById(R.id.buttonEducationSU2);

        buttonEducationSU2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationSUActivity.this);
                builder.setTitle(R.string.educatioSUPopUp1);
                builder.setMessage(getString(R.string.educatioSUPopUp12) +
                        getString(R.string.educatioSUPopUp13));
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

    }
}