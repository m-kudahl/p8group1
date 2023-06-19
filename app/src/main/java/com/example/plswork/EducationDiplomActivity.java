package com.example.plswork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EducationDiplomActivity extends StandardPagesActivity {

    //Declaration of buttons
    private Button buttonEducationDiplom1;
    private Button buttonEducationDiplom2;
    private TextView buttonEducationDiplom3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_diplom);

        //Initializing button
        buttonEducationDiplom1 = findViewById(R.id.buttonEducationDiplom1);
        setupToolbar(this);

        //Adds clicklistener - a dialog / pop-up box shows up that contains strings
        buttonEducationDiplom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationDiplomActivity.this);
                builder.setTitle(R.string.educationDiplomPopUp1);
                builder.setMessage(getString(R.string.educationDiplomPopUp11) +
                        getString(R.string.educationDiplomPopUp12) +
                        getString(R.string.educationDiplomPopUp13) +
                        getString(R.string.educationDiplomPopUp14) +
                        getString(R.string.educationDiplomPopUp15) +
                        getString(R.string.educationDiplomPopUp16) +
                        getString(R.string.educationDiplomPopUp17) +
                        getString(R.string.educationDiplomPopUp18) +
                        getString(R.string.educationDiplomPopUp19));
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

        //Initalizing next button
        buttonEducationDiplom2 = findViewById(R.id.buttonEducationDiplom2);

        //Adds clicklistener - a dialog / pop-up box shows up that contains strings
        buttonEducationDiplom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationDiplomActivity.this);
                builder.setTitle(R.string.educationDiplomPopUp2);
                builder.setMessage(getString(R.string.educationDiplomPopUp20) +
                        getString(R.string.educationDiplomPopUp21) +
                        getString(R.string.educationDiplomPopUp22) +
                        getString(R.string.educationDiplomPopUp23) +
                        getString(R.string.educationDiplomPopUp24) +
                        getString(R.string.educationDiplomPopUp25) +
                        getString(R.string.educationDiplomPopUp26));
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

        //Initializing last button
        buttonEducationDiplom3 = findViewById(R.id.buttonEducationDiplom3);

        //Adds clicklistener - a dialog / pop-up box shows up that contains strings
        buttonEducationDiplom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationDiplomActivity.this);
                builder.setTitle(R.string.educationDiplomPopUp3);
                builder.setMessage(getString(R.string.educationDiplomPopUp30) +
                        getString(R.string.educationDiplomPopUp31) +
                        getString(R.string.educationDiplomPopUp32) +
                        getString(R.string.educationDiplomPopUp33) +
                        getString(R.string.educationDiplomPopUp34) +
                        getString(R.string.educationDiplomPopUp35) +
                        getString(R.string.educationDiplomPopUp36) +
                        getString(R.string.educationDiplomPopUp37) +
                        getString(R.string.educationDiplomPopUp38));
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

    }
}