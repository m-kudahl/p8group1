package com.example.plswork;

import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserPages extends StandardPagesActivity {


    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        isUserLoggedIn();
    }

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
