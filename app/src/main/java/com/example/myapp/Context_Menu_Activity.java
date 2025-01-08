package com.example.myapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.zip.Inflater;

public class Context_Menu_Activity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_context_menu);

        textView=findViewById(R.id.tvMessage);
        editText=findViewById(R.id.etPressLong);

        registerForContextMenu(textView);
        registerForContextMenu(editText);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
       if(v.getId()==R.id.tvMessage){
           getMenuInflater().inflate(R.menu.context_menu_1,menu);
       }else if(v.getId()==R.id.etPressLong){
           getMenuInflater().inflate(R.menu.context_menu_2,menu);
       }
    }
}