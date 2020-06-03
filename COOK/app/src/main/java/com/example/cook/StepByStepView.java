package com.example.cook;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StepByStepView extends AppCompatActivity {
    public static ArrayList<GuideStep> guideStep;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_by_step_guide);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewStepByStep = findViewById(R.id.recyclerView);
        recyclerViewStepByStep.setLayoutManager(layoutManager);


        //bc we do not have pictures
        for (GuideStep step : guideStep){
            step.setStepPicture(R.drawable.bananabread);
        }


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getApplicationContext(), guideStep);
        recyclerViewStepByStep.setAdapter(adapter);

    }

}
