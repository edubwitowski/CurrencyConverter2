package com.example.user.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double myPeso;
    double myDollar;
    int myResult;
    double currentRate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled();
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText measure = (EditText) findViewById(R.id.myCurrency);
        final RadioButton peso = (RadioButton) findViewById(R.id.myPeso);
        final RadioButton dollar = (RadioButton) findViewById(R.id.myDollar);
        final TextView result = (TextView) findViewById(R.id.myResult);
        Button convert = (Button)findViewById(R.id.myConvert);

        convert.setOnClickListener((view) -> {
            measurementEntered = Double.parseDouble(measure.getText().toString());
            DecimalFormat tenth = new DecimalFormat("#.#");
            if(dollar.isChecked()){
                if (measurementEntered <= 50) {
                    convertedMeasurement = measurementEntered * conversionRate;
                    result.setText(tenth.format(convertedMeasurement) + " pesos ");

                } else {
                    Toast.makeText(context: MainActivity.this, "  Peso must be less than 50",
                            Toast.LENGTH_LONG).show();

                }
            }
            if (peso.isChecked()) {
                if(measurementEntered <=185 ) {
                    convertedMeasurement = measurementEntered / conversionRate;
                    result.setText(tenth.format(convertedMeasurement) + " inches ");
                }else{
                    Toast.makeText(MainActivity.this, " centimeters must be less than " + "185", Toast.Length_Long).show();

                }
            }
        })

    }
}
