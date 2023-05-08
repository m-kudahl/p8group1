package com.example.plswork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformationPagesActivity extends AppBarPagesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //setup imagebuttons when u have the url
    protected void setupLinkImageButton(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    //Class<?> is a generic type in Java that represents a class of any type. Used when the type of the class is not known initially and could be any type. ? is a wildcard
    //Knappe der skaber interne links fra den aktuelle side til en anden side i applikationen.
    protected void setupInternalLinkButton(Button button, Class<?> activityClass) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), activityClass));
            }
        });
    }
    //Making a recallable method for pop-up messages that we only need to input a title, a message and a view on the onClick.
    public void showPopUp(View view, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}