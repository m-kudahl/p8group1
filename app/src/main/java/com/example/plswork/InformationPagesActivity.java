package com.example.plswork;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class InformationPagesActivity extends AppBarPagesActivity {

    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * setup imagebuttons when u have the url
     * @param url - the link for the given website
     */
    protected void setupLinkImageButton(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    /**
     * Knappe der skaber interne links fra den aktuelle side til en anden side i applikationen.
     * @param button - takes a regular button input
     * @param activityClass - Class<?> is a generic type in Java that represents a class of any type. Used when the type of the class is not known initially and could be any type. ? is a wildcard
     */
    protected void setupInternalLinkButton(Button button, Class<?> activityClass) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), activityClass));
            }
        });
    }

    /**
     * This simply sets up an imagebutton onclick.
     * @param view - the button I want to apply this to
     * @param url - the link
     */
    public void setupLinkImageButton(View view, String url) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    /**
     * Making a recallable method for pop-up messages so that we only need to input a title, a message and a view on the onClick.
     * @param view
     * @param title
     * @param message
     */
    public void showPopUp(View view, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}