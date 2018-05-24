package com.example.user.uhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class DisinfectionActivity extends AppCompatActivity {
    Spinner mDisinfectionSpinner;
    LinearLayout mBtnTurnOn;
    LinearLayout mBtnTurnOff;
    ArrayList<String> DISINFECTION_LIST = new ArrayList<>();
    private static boolean WAS_CLICKED_OFF_BUTTON = false;
    private static boolean WAS_CLICKED_ON_BUTTON = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disinfection);
        mDisinfectionSpinner = findViewById(R.id.disinfection_spinner);
        DISINFECTION_LIST.add("Дезинфектор 1");
        DISINFECTION_LIST.add("Дезинфектор 2");
        DISINFECTION_LIST.add("Добавить дезинфектор");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, DISINFECTION_LIST);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDisinfectionSpinner.setAdapter(adapter);
        mBtnTurnOff = findViewById(R.id.button_turn_off);
        mBtnTurnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!WAS_CLICKED_OFF_BUTTON) {
                    Toast.makeText(DisinfectionActivity.this, "Выключено", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(DisinfectionActivity.this, "Включено", Toast.LENGTH_SHORT).show();
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
