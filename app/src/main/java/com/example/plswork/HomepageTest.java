package com.example.plswork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.

public class HomepageTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_test);

        View view = findViewById(R.id.my_homepage);

        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heightPx = view.getHeight();
                int widthPx = view.getWidth();
                float density = getResources().getDisplayMetrics().density;
                int heightDp = (int) (heightPx / density);
                int widthDp = (int) (widthPx / density);
                Log.d("TAG", "Height in dp: " + heightDp + ", Width in dp: " + widthDp);
                view.getViewTreeObserver().removeOnGlobalLayoutListener( this);
            }
        });
    }

}