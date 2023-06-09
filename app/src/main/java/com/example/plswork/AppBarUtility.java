package com.example.plswork;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import java.util.Locale;

public class AppBarUtility {

    /**
     * This method takes an input of the given activity as well as an integer which would be the app.bar.layout id (fx for MitID, etc.)
     * @param activity
     */
    public static void setupHomeButton(Activity activity) {

        //gotta make an appCompatButton here cause that is the type of the home button
        AppCompatButton homeButton = activity.findViewById(R.id.home_button);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Tab_Layout.class);
                activity.startActivity(intent);
            }
        });
    }

    /**
     * This method sets up an onclicklistener for the back button
     * @param activity
     */
    public static void setUpBackButton(Activity activity) {

        AppCompatButton backButton = activity.findViewById(R.id.back_button);
        //create an on click listener:
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
    }

    /**
     * this method sets up an on click listener for the profile button the app bar
     * @param activity
     */
    public static void setupProfileButton(Activity activity) {
        AppCompatButton profileButton = activity.findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, ProfilePage.class);
                activity.startActivity(intent);
            }
        });
    }

    /**
     * this method sets up an onclicklistener for the lang
     * @param activity
     */
    public static void setupLangButton(Activity activity) {

        AppCompatButton langButton = activity.findViewById(R.id.language_button);

            langButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // declare the current configuration as a variable
                    Configuration config = activity.getResources().getConfiguration();

                    // check if language in configuration is already Ukrainian
                    if (config.locale.getLanguage().equals("uk")) {

                        // set the locale to our default values (English) if already Ukrainian
                        Locale.setDefault(new Locale("en"));
                        config.locale = new Locale("en"); // Save config
                    } else {
                        // else set the locale to Ukrainian
                        Locale.setDefault(new Locale("uk"));
                        config.locale = new Locale("uk"); // Save config
                    }

                    // update the configuration with changes
                    activity.getResources().updateConfiguration(config, activity.getResources().getDisplayMetrics());

                    // recreate ALL activities with new changes - på tværs af activities - hvis man åbner appen
                    // starter den op på det sprog som man var i, da man lukkede
                    Intent intent = new Intent(activity, activity.getClass());
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    activity.startActivity(intent);
                }
            });
        }
    }
