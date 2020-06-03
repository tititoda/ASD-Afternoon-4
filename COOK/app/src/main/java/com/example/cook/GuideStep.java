package com.example.cook;

import java.util.ArrayList;
import java.util.Collections;

public class GuideStep {
    private int id;
    private String description;
    private int stepPicture;
    //private int nextId;
    public static int NO_PICTURE = -1;
    public static int NO_ID = -1;
    public static int next_id = 0;

    public GuideStep(int id) {
        this.id = id;
        this.description = "";
        this.stepPicture = NO_PICTURE;
    }
    public GuideStep(int id, String description, int stepPicture) {
        this.id = id;
        this.description = description;
        this.stepPicture = stepPicture;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getStepPicture() {
        return stepPicture;
    }
    public void setStepPicture(int stepPicture) {
        this.stepPicture = stepPicture;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<GuideStep> addGuideStep(ArrayList<GuideStep> currentSteps, String description, int stepPicture){
        int id = 0;
        if(currentSteps.size() != 0)
            id = currentSteps.get(currentSteps.size() -1).getId();
        currentSteps.add(new GuideStep(id, description, stepPicture));
        return currentSteps;
    }

    public static ArrayList<GuideStep> reorderGuideStep(ArrayList<GuideStep> currentSteps, int swap[]){
        if(swap.length != 2)
            return currentSteps;
        Collections.swap(currentSteps, swap[0], swap[1]);
        return currentSteps;
    }

}
