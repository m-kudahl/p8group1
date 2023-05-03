package com.example.plswork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EducationOptionsActivity extends AppCompatActivity {

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
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationOptionsActivity.this);
                builder.setTitle(R.string.educatioOptionsPopUp1);
                builder.setMessage(getString(R.string.educatioOptionsPopUp12) +
                        getString(R.string.educatioOptionsPopUp13));
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

        buttonEducationOptions2 = findViewById(R.id.buttonEducationOptions2);

        buttonEducationOptions2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationOptionsActivity.this);
                builder.setTitle(R.string.educatioOptionsPopUp2);
                builder.setMessage(getString(R.string.educatioOptionsPopUp22) +
                        getString(R.string.educatioOptionsPopUp23) +
                        getString(R.string.educatioOptionsPopUp24) +
                        getString(R.string.educatioOptionsPopUp25));
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.my_toolbar);
        AppBarUtility.setUpBackButton(this);

    }
}