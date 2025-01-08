package com.example.myapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTab= findViewById(R.id.btnPopup);
        btnTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Clicked Button",Toast.LENGTH_SHORT).show();
                PopupMenu popup = new PopupMenu(getApplicationContext(),btnTab);
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id= item.getItemId();
                        if(id==R.id.opt1){
                            Log.i("LIFE","Option 1");
                            Toast.makeText(getApplicationContext(),"Option 1 selected",Toast.LENGTH_LONG).show();
                        }
                        if(id==R.id.opt2){
                            Log.i("LIFE","Option 2");
                            Toast.makeText(getApplicationContext(),"Option 2 selected",Toast.LENGTH_LONG).show();
                        }
                        if(id==R.id.opt3){
                            Log.i("LIFE","Option 3");
                            Toast.makeText(getApplicationContext(),"Option 3 selected",Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
}