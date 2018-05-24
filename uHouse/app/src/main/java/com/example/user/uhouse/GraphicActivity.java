package com.example.user.uhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class GraphicActivity extends AppCompatActivity {
        Spinner mSpinnerTemperature;
        Spinner mSpinnerDay;
        GraphView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

         graph =  findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graph.addSeries(series1);
//        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(1, 2),
//                new DataPoint(2, 6),
//                new DataPoint(3, 4),
//                new DataPoint(4, 3),
//                new DataPoint(5, 7)
//        });
//        graph.addSeries(series2);

        mSpinnerTemperature=findViewById(R.id.graphic_spinner);
        ArrayList<String> list_for_first_spinner=new ArrayList<>();
        list_for_first_spinner.add("t, C");
        list_for_first_spinner.add("h, %");
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,list_for_first_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerTemperature.setAdapter(adapter);
        mSpinnerTemperature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).toString().equals("t, C")){
                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[] {
                            new DataPoint(0, 1),
                            new DataPoint(1, 5),
                            new DataPoint(2, 3),
                            new DataPoint(3, 2),
                            new DataPoint(4, 6)
                    });
                    graph.addSeries(series1);

                }else{
                    graph.removeAllSeries();
                    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
                            new DataPoint(1, 2),
                            new DataPoint(2, 6),
                            new DataPoint(3, 4),
                            new DataPoint(4, 3),
                            new DataPoint(5, 7)
                    });
                    graph.addSeries(series2);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mSpinnerDay=findViewById(R.id.graphic_spinner_day);
        ArrayList<String> list_for_second_spinner=new ArrayList<>();
        list_for_second_spinner.add("День");
        list_for_second_spinner.add("Неделя");
        list_for_second_spinner.add("Месяц");
        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,list_for_second_spinner);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerDay.setAdapter(adapter2);
        mSpinnerDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if(adapterView.getItemAtPosition(i).toString().equals("t, C")){
//                    LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[] {
//                            new DataPoint(0, 1),
//                            new DataPoint(1, 5),
//                            new DataPoint(2, 3),
//                            new DataPoint(3, 2),
//                            new DataPoint(4, 6)
//                    });
//                    graph.addSeries(series1);
//                }else{
//                    LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[] {
//                            new DataPoint(1, 2),
//                            new DataPoint(2, 6),
//                            new DataPoint(3, 4),
//                            new DataPoint(4, 3),
//                            new DataPoint(5, 7)
//                    });
//                    graph.addSeries(series2);
//                }
//
//
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}
