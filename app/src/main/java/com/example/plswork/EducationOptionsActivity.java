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
                builder.setTitle("How to apply for a transfer");
                builder.setMessage("To apply for a transfer, it is required that you fulfil the general and specific admission requirements of the particular Danish higher education programme, and that there are available study places at the higher education programme." +
                        "\n\nThe higher education institutions in Denmark set their own procedures for applications for transfers, so you need to contact them directly in order to know more about the possibilities for a transfer. The individual higher education institution will also be able to guide you regarding ongoing higher education programmes at the institution.");
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
                builder.setTitle("How do I apply for admission?");
                builder.setMessage("If you haven’t passed the equivalent of the first year of a Danish higher education programme, you can apply for admission to the higher education programme in quota" +
                        "\n\nYou can apply on https://www.optagelse.dk. Application deadlines are 15th of March every year. The higher education institutions have the option of giving a dispensation from application deadlines given unusual circumstances." +
                        "\n\nIn the 2022 admission round there are 12 English taught higher education programmes on an academy profession level or professional bachelor level, where Ukrainian applicants with an Ukrainian upper secondary diploma do not have to pass a test in order to be admitted." +
                        "\nIf you want to apply for a bachelor’s programme and you have a Ukrainian upper secondary diploma, you must have passed at least one year of studies at a higher education programme besides your Ukrainian upper secondary education.");
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.my_toolbar);
        AppBarUtility.setUpBackButton(this);

    }
}