package com.example.plswork;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

import java.util.Locale;

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

        View backButton = activity.findViewById(R.id.back_button);
        //create an on click listener:
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
    }

    public static void setupLangButton(Activity activity, int langButtonId) {

        AppCompatButton langButton = activity.findViewById(R.id.language_button);

            langButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // get the current locale
                    Configuration config = activity.getResources().getConfiguration();

                    // check if language is already Ukrainian
                    if (config.locale.getLanguage().equals("uk")) {
                        // set the locale to our default values (English)
                        config.setLocale(Locale.getDefault());
                    } else {
                        // else set the locale back to Ukrainian
                        config.setLocale(new Locale("uk"));
                    }

                    // update the configuration
                    activity.getResources().updateConfiguration(config, activity.getResources().getDisplayMetrics());

                    // recreate the activity to apply the new locale
                    activity.recreate();
                }
            });
        }
    }
