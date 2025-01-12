package com.example.myapp;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        webview=findViewById(R.id.webView);

        WebSettings settings= webview.getSettings();
        settings.getJavaScriptEnabled();
        webview.setWebViewClient(new WebViewClient());

        if(isOnline()){
            webview.loadUrl("https://www.google.com");
        }else{
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }

    }
    public boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(WebViewActivity.CONNECTIVITY_SERVICE);
         return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}