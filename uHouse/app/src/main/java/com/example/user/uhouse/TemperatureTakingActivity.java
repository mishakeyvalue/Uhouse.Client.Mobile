package com.example.user.uhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TemperatureTakingActivity extends AppCompatActivity {

    Spinner mTemperatureSpinner;
    LinearLayout mTemperatureTakingBtn;
    TextView mTextTemperature;
    ArrayList<String> mTemperatureList = new ArrayList<>();
    private static boolean WAS_CLICKED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_taking);
        mTemperatureSpinner = findViewById(R.id.temperature_spinner);
        mTemperatureList.add("Комната 1");
        mTemperatureList.add("Комната 2");
        mTemperatureList.add("Комната 3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mTemperatureList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTemperatureSpinner.setAdapter(adapter);

        mTextTemperature = findViewById(R.id.temperature_measuring_text);

        mTemperatureTakingBtn = findViewById(R.id.button_measuring);
        mTemperatureTakingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!WAS_CLICKED) {
                    Toast.makeText(TemperatureTakingActivity.this, "Измеряется...",
                            Toast.LENGTH_LONG).show();
                    mTemperatureTakingBtn.setBackgroundResource(R.drawable.border_colorful);
                    mTextTemperature.setText("30 C");
                    WAS_CLICKED = true;
                } else {
                    mTemperatureTakingBtn.setBackgroundResource(R.drawable.border);
                    WAS_CLICKED = false;
                }
            }
        });

    }
}
