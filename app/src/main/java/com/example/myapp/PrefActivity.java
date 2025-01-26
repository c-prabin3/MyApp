package com.example.myapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrefActivity extends AppCompatActivity {
    private Button btnRead;
    private Button btnWrite;
    private TextView tvResult;
    private EditText etText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);
        tvResult = findViewById(R.id.txtView);
        etText = findViewById(R.id.etText);

        btnWrite.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("my-pef", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("name", etText.getText().toString());
            editor.putBoolean("status",true);
            editor.apply();
            etText.setText("");
            Toast.makeText(getApplicationContext(),"Write Shared Preferences:"+etText.getText().toString(),Toast.LENGTH_SHORT).show();
        });

        btnRead.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("my-pef", MODE_PRIVATE);
            tvResult.setText(sp.getString("name", "Not Found")+" Status "+sp.getBoolean("status",false));
            Toast.makeText(getApplicationContext(),"Read Shared Preferences:"+tvResult.getText().toString(),Toast.LENGTH_SHORT).show();
            etText.setText("");
        });


    }
}