package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.Calculations;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onResume() {
        super.onResume();
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    private void calculateAnswer() {
        Calculations calculations= new Calculations();
        String temp_value=et_message.getText().toString();
        if(TextUtils.isEmpty(temp_value)){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
            temp_value="0.0";
            tv_displayAnswer.setText(temp_value);
        }
 else{
     Float temp=Float.parseFloat(temp_value);
            if(radioButton.isChecked()){
                temp=calculations.convertCelciusToFahrenhite(temp);

// convert it into Fahrenheit and display the answer
            }
            else if(radioButton2.isChecked()){
                temp=calculations.convertFahrenhiteToCelcius(temp);

            }
            else{
                Toast.makeText(this, "Please add a value",
                        Toast.LENGTH_LONG).show();
                temp_value="0.0";
            }
        }
    }
}