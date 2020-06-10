package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Button buttonBMI = findViewById(R.id.buttonBMI);
        buttonBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editName = findViewById(R.id.editName);
                EditText editWeight = findViewById(R.id.editWeight);
                EditText  editHeight = findViewById(R.id.editHeight);
                TextView textResult = findViewById(R.id.textResult);
                String str1 = editWeight.getText().toString();
                String str2 = editHeight.getText().toString();
                String str3 = editName.getText().toString();
                float weight = Float.parseFloat(String.valueOf(str1));
                float height = Float.parseFloat(String.valueOf(str2));
                float bmiValue= calculateBMI(weight, height);
                String bmiInterpretation = interpretBMI(bmiValue);
                textResult.setText(String.valueOf("Hi  "+str3+ ",  Your BMI is    "+bmiValue + "     thus you are " + bmiInterpretation));
                Intent goToOutput = new Intent();
                goToOutput.setClass(InputActivity.this, OutputActivity.class);
                String userMessage= textResult.getText().toString();
                goToOutput.putExtra("BMI", userMessage);
                startActivity(goToOutput);

            }
        });
    }


    private float calculateBMI(float weight, float height) {
            return weight / (height * height);
    }
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
}
}
