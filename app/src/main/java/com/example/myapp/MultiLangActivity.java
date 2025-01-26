package com.example.myapp;

import static com.example.myapp.R.string.app_login;
import static com.example.myapp.R.string.app_login;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MultiLangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_multi_lang);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.setting,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (R.id.nepali == item.getItemId()) {
                setLocale("ne");
                recreate();
            } else {
                setLocale("en");
                recreate();
            }
            return true;
        }

        public void setLocale(String lang) {
        Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.setLocale(locale);
            getBaseContext().getResources().updateConfiguration(configuration,
                    getBaseContext().getResources().getDisplayMetrics());

            //for saving language it will be used in next time
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putString("app_lang", lang);
            editor.apply();
        }
        public void loadLocale() {
            //for default language
            SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
            String lang = sp.getString("app_lang", "");
            setLocale(lang);
        }
}