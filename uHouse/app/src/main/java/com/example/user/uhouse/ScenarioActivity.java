package com.example.user.uhouse;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScenarioActivity extends AppCompatActivity {
    List<Scenario> scenarioList = new ArrayList<>();
    RecyclerView recyclerView;
    ScenarioAdapter mAdapter;
    Spinner mScenarioSpinner;
    Spinner mAddDeviceSpinner;
    TextView mAddDevice;
    TextView mClockView;
    TimePicker mTimePicker;
    static boolean mWasClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario);


        recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new ScenarioAdapter(scenarioList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        prepareScenarioData();

        mScenarioSpinner = findViewById(R.id.scenario_spinner);
        final ArrayList<String> roomList = new ArrayList<>();
        roomList.add("Комната 1");
        roomList.add("Комната 2");
        roomList.add("Добавить комнату");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, roomList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mScenarioSpinner.setAdapter(adapter);
        mScenarioSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).toString().equals("Добавить комнату")) {
                    roomList.add(roomList.size() - 1, "Комната " + (roomList.size()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, roomList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mScenarioSpinner.setAdapter(adapter);

        mAddDeviceSpinner = findViewById(R.id.add_device_spinner);

        ArrayList<String> list_devices = new ArrayList<>();
        list_devices.add("");
        list_devices.add("Дезинфекция");
        list_devices.add("Измерение температуры");
        list_devices.add("Освещение");

        ArrayAdapter<String> device_adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list_devices);
        device_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mAddDeviceSpinner.setAdapter(device_adapter);

        mAddDeviceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()) {
                    case "Освещение":
                        Scenario scenario = new Scenario(R.drawable.lamp, "00:00");
                        scenarioList.add(scenario);
                        mAdapter.notifyDataSetChanged();
                        Toast.makeText(ScenarioActivity.this, "Устройство добавлено!", Toast.LENGTH_SHORT).show();
                        mAddDeviceSpinner.setVisibility(View.GONE);
                        mWasClicked = false;
                        break;
                    case "Измерение температуры":
                        scenario = new Scenario(R.drawable.thermometer, "00:00");
                        scenarioList.add(scenario);
                        mAdapter.notifyDataSetChanged();
                        Toast.makeText(ScenarioActivity.this, "Устройство добавлено!", Toast.LENGTH_SHORT).show();
                        mAddDeviceSpinner.setVisibility(View.GONE);
                        mWasClicked = false;
                        break;
                    case "Дезинфекция":
                        scenario = new Scenario(R.drawable.disinfection, "00:00");
                        scenarioList.add(scenario);
                        mAdapter.notifyDataSetChanged();
                        Toast.makeText(ScenarioActivity.this, "Устройство добавлено!", Toast.LENGTH_SHORT).show();
                        mAddDeviceSpinner.setVisibility(View.GONE);
                        mWasClicked = false;
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mAddDevice = findViewById(R.id.add_device);
        mAddDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mWasClicked) {
                    mAddDeviceSpinner.setVisibility(View.VISIBLE);
                    mWasClicked = true;
                } else {
                    mAddDeviceSpinner.setVisibility(View.GONE);
                    mWasClicked = false;
                }


            }
        });



    }

    private void prepareScenarioData() {
        Scenario scenario = new Scenario(R.drawable.lamp, "00:00");
        scenarioList.add(scenario);

        scenario = new Scenario(R.drawable.disinfection, "22:15");
        scenarioList.add(scenario);

        mAdapter.notifyDataSetChanged();
    }

   public void time_picker(View v){
       mTimePicker = findViewById(R.id.timePicker);
            mTimePicker.setVisibility(View.VISIBLE);
       mClockView=findViewById(R.id.clock_view);

       Calendar now = Calendar.getInstance();

       mTimePicker.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
       mTimePicker.setCurrentMinute(now.get(Calendar.MINUTE));

       mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

           @Override
           public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
               mClockView.setText("Часы: " + hourOfDay + "\n" + "Минуты: "
                       + minute);
           }
       });


   }
}
