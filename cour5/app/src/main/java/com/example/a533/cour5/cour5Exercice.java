package com.example.a533.cour5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;

public class cour5Exercice extends AppCompatActivity {

FirebaseAuth  auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cour5_exercice);
        auth = FirebaseAuth.getInstance();
        sendUserToSignUpOrLoginActivity();
    }

    protected void onStart(){
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser){
        if(currentUser == null){

        }
    }


    private void sendUserToSignUpOrLoginActivity(){
        Intent sendToSignUpOrLogin = new Intent (this,SignUpOrLoginActivity.class);
        startActivity(sendToSignUpOrLogin);
    }

}
