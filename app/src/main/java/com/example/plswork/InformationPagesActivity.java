package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformationPagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Set up the home button
    protected void setupHomeButton(int appBarLayoutId) {
        AppBarUtility.setupHomeButton(this, appBarLayoutId);
    }

    // Set up the back button
    protected void setUpBackButton() {
        AppBarUtility.setUpBackButton(this);
    }

    //setup imagebuttons when u have the url
    protected void setupImageButton(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    //Class<?> is a generic type in Java that represents a class of any type. Used when the type of the class is not known initially and could be any type.
    protected void setupButton(Button button, Class<?> activityClass) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), activityClass));
            }
        });
    }
}