package com.example.user.uhouse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 022 22.05.18.
 */

public class ScenarioAdapter extends RecyclerView.Adapter<ScenarioAdapter.ScenarioViewHolder> {
    private List<Scenario> scenariosList;

    public class ScenarioViewHolder extends RecyclerView.ViewHolder {
        ImageView mDevicePicture;
        ImageView mTimeManager;
        TextView mClockView;
        Button mButtonOn;
        Button mButtonOff;

        public ScenarioViewHolder(View view) {
            super(view);
            mDevicePicture=view.findViewById(R.id.device_picture);
            mTimeManager=view.findViewById(R.id.time_manager);
            mClockView=view.findViewById(R.id.clock_view);
            mButtonOn=view.findViewById(R.id.btn_on);
            mButtonOff=view.findViewById(R.id.btn_off);

        }
    }


    public ScenarioAdapter(List<Scenario> scenariosList) {
        this.scenariosList = scenariosList;
    }

    @Override
    public ScenarioAdapter.ScenarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scenario_list, parent, false);

        return new ScenarioAdapter.ScenarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ScenarioAdapter.ScenarioViewHolder holder, int position) {
        Scenario scenario = scenariosList.get(position);
        holder.mDevicePicture.setImageResource(scenario.getImage_src());
        holder.mClockView.setText(scenario.getTime_table());
    }

    @Override
    public int getItemCount() {
        return scenariosList.size();
    }
}
