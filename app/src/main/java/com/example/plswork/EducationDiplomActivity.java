package com.example.plswork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EducationDiplomActivity extends AppCompatActivity {

    private Button buttonEducationDiplom1;

    private Button buttonEducationDiplom2;

    private TextView buttonEducationDiplom3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_diplom);

        buttonEducationDiplom1 = findViewById(R.id.buttonEducationDiplom1);

        buttonEducationDiplom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationDiplomActivity.this);
                builder.setTitle("What are the the required document to be included in the application?");
                builder.setMessage("1. Diploma/certificate in the original language for each qualification that you want to have assessed. If you have more than one higher education qualification (e.g. a bachelor’s degree and a master’s degree), please enclose all of the documents." +
                        "\n\n2. Transcript in the original language for each qualification that you want to have assessed. If you are unable to provide the transcript, please list in your own words the subjects studied and passed." +
                        "\n\n3. Translation of the diploma/certificate for each qualification that you want to have assessed, unless it is in Norwegian, Swedish, English, German, French, or Spanish. If you attach a Diploma Supplement issued in one of the languages mentioned, translation is not necessary (see point 5)." +
                        "\n\n4. Translation of transcript for each qualification that you want to have assessed, unless it is in Norwegian, Swedish, English, German, French, or Spanish. If you attach a Diploma Supplement issued in one of the languages mentioned, translation is not necessary (see point 5)." +
                        "\n\n5. If you have a Diploma Supplement, please enclose it. The Diploma Supplement is issued by the higher education institutions in the EU/EEA countries." +
                        "\n\n6. If you want assessment of a degree, please enclose the entrance qualification, e.g. high school certificate." +
                        "\n\n7. If the name on any of the documents is different from the name you are currently using: Name change documentation, e.g. marriage certificate." +
                        "\n\n8. If your qualifications have been assessed before: Former assessment(s) or recognition decision(s)." +
                        "\n\n\nThe Danish Agency for Higher Education and Science may ask you for further documentation of your qualifications, including original documents. ");
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

        buttonEducationDiplom2 = findViewById(R.id.buttonEducationDiplom2);

        buttonEducationDiplom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationDiplomActivity.this);
                builder.setTitle("How do I fill in the online application?");
                builder.setMessage("The form has five steps:" +
                        "\n\n1. You as an applicant: Name, address etc. Most of the fields are filled in automatically." +
                        "\n\n2. The purpose of your application. You will also be asked if you want the assessment in Danish or English. You can only get the assessment in one language. We recommend Danish if you are going to apply for jobs or education in Denmark." +
                        "\n\n3. Education: Please give information about each of the education programmes that you have completed, except short programmes/courses." +
                        "\n\n4. Other information, e.g. professional experience." +
                        "\n\n5. Sending the application. Here you can check all of your information." +
                        "\n\n\nWhen you have sent the application, you will get a receipt.");
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });


        buttonEducationDiplom3 = findViewById(R.id.buttonEducationDiplom3);

        buttonEducationDiplom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a dialog box or alert dialog to show the information
                AlertDialog.Builder builder = new AlertDialog.Builder(EducationDiplomActivity.this);
                builder.setTitle("How do I fill in the PDF application?");
                builder.setMessage("The form has four steps:" +
                        "\n\n1. Fill in the application form. Fields marked * are required. " +
                        "\n\n2. Sign the form." +
                        "\n\n3. Enclose all of the required documentation." +
                        "\n\n4. Send the application, or hand it in at Haraldsgade 53, Copenhagen Ø." +
                        "\n\n\nLetter post:" +
                        "\nSend to: Danish Agency for Higher Education and Science, Haraldsgade 53, DK-2100 Copenhagen Ø." +
                        "\n\n\nDigital post:" +
                        "\nIf you have a Danish CPR number and NemID/MitID you can send your application by Digital Post, unless you are to submit original documents.");
                builder.setPositiveButton("OK", null);
                builder.show();
            }
        });

        //appbar buttons
        AppBarUtility.setupHomeButton(this, R.id.my_toolbar);
        AppBarUtility.setUpBackButton(this);
    }
}