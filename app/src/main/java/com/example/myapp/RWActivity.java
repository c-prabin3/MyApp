package com.example.myapp;

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

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;

public class RWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rwactivity);

        TextView tvResult = findViewById(R.id.txtView);
        EditText etMessage = findViewById(R.id.etText);
        Button btnRead = findViewById(R.id.btnRead);
        Button btnWrite = findViewById(R.id.btnWrite);
        
        btnWrite.setOnClickListener(v -> {
            try{
                OutputStream outputStream = openFileOutput("myfile.txt",
                        MODE_APPEND);

                outputStream.write(etMessage.getText().toString().getBytes());
                outputStream.close();
                Toast.makeText(getApplicationContext(), "The Data inserted is Successful", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Sorry: " +
                        e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream =
                            openFileInput("myfile.txt");
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    StringBuffer sb = new StringBuffer();
                    int c;
                    while ((c = dataInputStream.read()) != -1) {
                        sb.append((char) c);
                    }
                    Toast.makeText(getApplicationContext(), "The data read from file is success", Toast.LENGTH_LONG).show();
                    tvResult.setText(sb.toString());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Sorry: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}