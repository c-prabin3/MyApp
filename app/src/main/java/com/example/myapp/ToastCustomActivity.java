package com.example.myapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class ToastCustomActivity extends AppCompatActivity {
    private Button button;
    private Button btnSnackBar;
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        button = findViewById(R.id.btnClick);
        button.setOnClickListener(v -> {
            //Creating the LayoutInflater instance
            LayoutInflater li = getLayoutInflater();

            //Getting the View object as defined in the custom_toast.xml file
            View layout = li.inflate(R.layout.custom_toast, (ViewGroup)
                    findViewById(R.id.customToastLayout));

            //Creating the Toast object
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(layout);//setting the view of custom toast layout
            toast.show();
        });

        btnSnackBar = findViewById(R.id.btnSnackBar);
        btnSnackBar.setOnClickListener(v1 -> {
            LinearLayout coordinatorLayout = findViewById(R.id.main);
            Snackbar snackbar = Snackbar.make(coordinatorLayout, "Message Deleted", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", v -> {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Message Restored", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    });
            snackbar.show();
        });
    }
}
