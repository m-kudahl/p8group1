package com.example.plswork;

import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NotUserPages extends StandardPagesActivity {
    //a class for the pages which are not accessible for users logged in
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        isUserLoggedIn();
    }

    protected void isUserLoggedIn() {
        mAuth = FirebaseAuth.getInstance();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(this, Tab_Layout.class);
            startActivity(intent);
            finish();
        }
    }
}
