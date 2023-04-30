package com.example.plswork;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

public class AppBarUtility {
    //This method takes an input of the given activity as well as an integer which would be the app.bar.layout id (fx for MitID, etc.)
    public static void setupHomeButton(Activity activity, int appBarLayoutId) {

        //referring to the home button within the layout that we included
        View includedLayout = activity.findViewById(appBarLayoutId);
        //gotta make an appCompatButton here cause that is the type of the home button
        AppCompatButton homeButton = includedLayout.findViewById(R.id.home_button);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Tab_Layout.class);
                activity.startActivity(intent);
            }
        });
    }
    public static void setUpBackButton(Activity activity) {

        View backButton = activity.findViewById(R.id.back_button)
        //create an on click listener:
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });


    }
}
