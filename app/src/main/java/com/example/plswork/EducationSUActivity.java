package com.example.plswork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EducationSUActivity extends AppCompatActivity {

    Button SUMitIDBtn;

    private Button buttonEducationSU2;

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

        buttonEducationSU2 = findViewById(R.id.buttonEducationSU2);

        buttonEducationSU2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationSUActivity.this);
                builder.setTitle("How do I apply for SU as a Ukrainian refugee?");
                builder.setMessage("If you are a refugee from Ukraine, you may apply for equal status with Danish citizens, if you fall within Section 2(2) of the Act on Integration of Aliens in Denmark" +
                        "\n\nPlease be aware that if you want to apply for equal status with Danish citizens because you fall within Section 2(4) (other aliens granted family reunification) of the Act on Integration of Aliens in Denmark, you must have obtained the right to reside in Denmark according to this rule on 1 July 2019 or later.");
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });


    }
}