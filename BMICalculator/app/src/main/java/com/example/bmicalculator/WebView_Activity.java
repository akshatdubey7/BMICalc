package com.example.bmicalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;


public class WebView_Activity extends AppCompatActivity {


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_);


        WebView BMIWeb = (WebView) findViewById(R.id.BMIWeb);
        BMIWeb.getSettings().setJavaScriptEnabled(true);
        BMIWeb.loadUrl("https://healthyeating.sfgate.com/improve-bmi-level-8137.html");
    }
}
