package com.example.plswork;

import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserPages extends StandardPagesActivity {

    //user pages requires the user to be logged in so we need to get the user authentication
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        //we want to use the superclass' onStart method
        super.onStart();
        // we check if the user is logged in on the user pages
        isUserLoggedIn();
    }
    //the check if the user is logged in, if not the user is redirected to the login page
    protected void isUserLoggedIn() {
        mAuth = FirebaseAuth.getInstance();


        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
