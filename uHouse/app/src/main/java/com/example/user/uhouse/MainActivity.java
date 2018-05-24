package com.example.user.uhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLightBtn;
    LinearLayout mDisinfectionBtn;
    LinearLayout mTemperatureTakingBtn;
    LinearLayout mGraphicBtn;
    LinearLayout mScenarioBtn;
    LinearLayout mHelpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLightBtn=findViewById(R.id.light_button);
        mLightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LightActivity.class);
                startActivity(intent);
            }
        });
        mDisinfectionBtn=findViewById(R.id.disinfection_button);
        mDisinfectionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DisinfectionActivity.class);
                startActivity(intent);
            }
        });
        mTemperatureTakingBtn=findViewById(R.id.temperature_taking__button);
        mTemperatureTakingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TemperatureTakingActivity.class);
                startActivity(intent);
            }
        });

        mGraphicBtn=findViewById(R.id.graphic_button);
        mGraphicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,GraphicActivity.class);
                startActivity(intent);
            }
        });
        mScenarioBtn=findViewById(R.id.scenario_button);
        mScenarioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ScenarioActivity.class);
                startActivity(intent);
            }
        });
        mHelpBtn=findViewById(R.id.help__button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.notification:
                Toast.makeText(this,"Notification",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
