package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Bundle BMIn = getIntent().getExtras();
        if(BMIn==null){
            return;
        }
        String BMI = BMIn.getString("BMI");
        final TextView textBMI = (TextView) findViewById(R.id.textBMI);
        textBMI.setText(BMI);


        Button Web = (Button) findViewById(R.id.Web);

        Web.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(OutputActivity.this, WebView_Activity.class);
                startActivity(intent);
            }

        });
    }


}
