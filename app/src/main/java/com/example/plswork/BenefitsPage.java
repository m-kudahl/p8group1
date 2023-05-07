
package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BenefitsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefits_page);

        //appbar
        AppBarUtility.setupHomeButton(this, R.id.appbarBenefits);
        AppBarUtility.setUpBackButton(this);
        AppBarUtility.setupLangButton(this, R.id.appbarBenefits);
    }

}
