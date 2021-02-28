package com.omerkeskin.instaclonefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etMail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        etMail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void onBtnSignInClicked(View view){
        String email = etMail.getText().toString();
        String password = etPassword.getText().toString();

        if(email.matches("")){
            Toast.makeText(getApplicationContext(), "Fill mail info",Toast.LENGTH_LONG).show();
        }else if(password.matches("")){
            Toast.makeText(getApplicationContext(), "Fill password info",Toast.LENGTH_LONG).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(getApplicationContext(), "Login success",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }


    }

    public void onBtnSignUpClicked(View view){
        String email = etMail.getText().toString();
        String password = etPassword.getText().toString();
        if(email.matches("")){
            Toast.makeText(getApplicationContext(), "Fill mail info",Toast.LENGTH_LONG).show();
        }else if(password.matches("")){
            Toast.makeText(getApplicationContext(), "Fill password info",Toast.LENGTH_LONG).show();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(getApplicationContext(), "User created",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });


        }

    }

}