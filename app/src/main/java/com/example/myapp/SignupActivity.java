package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnSignup;
    private Button btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmail = findViewById(R.id.etEmail);
        etPassword= findViewById(R.id.etPassword);

        btnSignup = findViewById(R.id.btnSignup);
        btnLogin = findViewById(R.id.btnLogin);

        btnSignup.setOnClickListener(view -> {
                    Toast.makeText(getApplicationContext(), "Clicked Me!!", Toast.LENGTH_LONG).show();
                }
        );

        btnLogin.setOnClickListener(view ->{
                    Toast.makeText(getApplicationContext(),"Clicked Me!!",Toast.LENGTH_LONG).show();
                }
        );


    }
}
