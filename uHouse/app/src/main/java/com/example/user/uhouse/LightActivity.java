package com.example.user.uhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class LightActivity extends AppCompatActivity {
    Spinner mLightSpinner;
    LinearLayout mBtnTurnOn;
    LinearLayout mBtnTurnOff;
    ArrayList<String> LIGHT_LIST = new ArrayList<>();
    private static boolean WAS_CLICKED_OFF_BUTTON = false;
    private static boolean WAS_CLICKED_ON_BUTTON = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        mLightSpinner = findViewById(R.id.light_spinner);
        LIGHT_LIST.add("Лампа 1");
        LIGHT_LIST.add("Лампа 2");
        LIGHT_LIST.add("Добавить лампу");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, LIGHT_LIST);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLightSpinner.setAdapter(dataAdapter);
        mBtnTurnOff = findViewById(R.id.button_turn_off);
        mBtnTurnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!WAS_CLICKED_OFF_BUTTON) {
                    Toast.makeText(LightActivity.this, "Выключено", Toast.LENGTH_SHORT).show();
                    mBtnTurnOff.setBackgroundResource(R.drawable.border_colorful);
                    WAS_CLICKED_OFF_BUTTON = true;
                } else {
                    mBtnTurnOff.setBackgroundResource(R.drawable.border);
                    WAS_CLICKED_OFF_BUTTON = false;
                }
            }
        });
        mBtnTurnOn = findViewById(R.id.button_turn_on);
        mBtnTurnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!WAS_CLICKED_ON_BUTTON) {
                    Toast.makeText(LightActivity.this, "Включено", Toast.LENGTH_SHORT).show();
                    mBtnTurnOn.setBackgroundResource(R.drawable.border_colorful);
                    WAS_CLICKED_ON_BUTTON = true;
                } else {
                    mBtnTurnOn.setBackgroundResource(R.drawable.border);
                    WAS_CLICKED_ON_BUTTON = false;
                }
            }
        });
    }
}
