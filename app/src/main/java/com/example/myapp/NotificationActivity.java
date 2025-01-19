package com.example.myapp;

import android.app.Notification;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotificationActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etDetail;
    private Button btnOne;
    private Button btnTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        etTitle = findViewById(R.id.etTitle);
        etDetail = findViewById(R.id.etDetail);
        btnOne = findViewById(R.id.btnCh1);
        btnTwo = findViewById(R.id.btnCh2);

        btnOne.setOnClickListener(view -> {
            Notification notification = new
                    NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_1_ID)
                    .setContentTitle(etTitle.getText().toString())
                    .setTicker("one")
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText(etDetail.getText().toString())
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();
            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            notificationManager.notify(1, notification);
        });
        btnTwo.setOnClickListener(view -> {
            Notification notification2 = new
                    NotificationCompat.Builder(getApplicationContext(),
                    App.CHANNEL_2_ID)
                    .setContentTitle(etTitle.getText().toString())
                    .setTicker("two")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText(etDetail.getText().toString())
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                    .build();
            if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                    android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            notificationManager.notify(2, notification2);
        });
    }
}