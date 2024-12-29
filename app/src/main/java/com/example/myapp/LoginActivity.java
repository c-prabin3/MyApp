package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnSignup;
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {

        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnLogin =findViewById(R.id.btnLogin);
        btnSignup =findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Clicked me!! ",Toast.LENGTH_LONG).show();
        });

        btnSignup.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),"Clicked me!! ",Toast.LENGTH_LONG).show();
        });
    }
}
