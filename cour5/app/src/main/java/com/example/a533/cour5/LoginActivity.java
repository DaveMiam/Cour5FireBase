package com.example.a533.cour5;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        setListener();
    }


    private void setListener(){
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               signUpUser();
            }
        });
        findViewById(R.id.button_deco).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deco();
            }
        });
    }
    private void signUpUser() {
        EditText userEmail = findViewById(R.id.editTextEmailLogin);
        EditText password = findViewById(R.id.editTextPasswordLogin);


        auth.signInWithEmailAndPassword(userEmail.getText().toString(),
                password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();
                    updateUI(user);
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to sign up", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void updateUI(FirebaseUser currentUser){
        if(currentUser == null){

        }
    }

    private void deco(){
        auth.signOut();
        Toast.makeText(getApplicationContext(), "Deconnexion", Toast.LENGTH_SHORT).show();
        Intent sendToSignUpOrLogin = new Intent(this,cour5Exercice.class);
        startActivity(sendToSignUpOrLogin);
        }


}
