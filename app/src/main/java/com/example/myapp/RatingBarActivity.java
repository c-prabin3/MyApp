package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RatingBarActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button btnSubmit;
    private String rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        ratingBar = findViewById(R.id.rtBar);
        btnSubmit = findViewById(R.id.button);
        btnSubmit.setOnClickListener(arg0 -> {
           rating = String.valueOf(ratingBar.getRating());
           Toast.makeText(getApplicationContext(), rating,Toast.LENGTH_SHORT).show();
        });
    }
}