package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends AppCompatActivity {
    private ListView listView;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

        listView=findViewById(R.id.Listview);

        String[] pl = {"BE Computer", "BCA", "BE CIVIL", "BBA"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListViewDemoActivity.this,
                android.R.layout.simple_list_item_1,pl);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent1, view, position1, id) -> {
            String pl1 = parent1.getItemAtPosition(position1).toString();
            Toast.makeText(getApplicationContext(), pl1,Toast.LENGTH_SHORT).show();
        });

        sp = findViewById(R.id.country);
        List<String>spinnerArray = new ArrayList<>();
        spinnerArray.add("Nepal");
        spinnerArray.add("Canada");
        spinnerArray.add("Russia");
        spinnerArray.add("China");
        spinnerArray.add("USA");
        spinnerArray.add("Portugal");
        spinnerArray.add("Japan");
        spinnerArray.add("Korea");
        spinnerArray.add("Other");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sp1= parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),sp1,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}