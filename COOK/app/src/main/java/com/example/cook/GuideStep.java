package com.example.cook;

public class GuideStep {
    private int id;
    private String description;
    private int stepPicture;

    public GuideStep(int id) {
        this.id = id;
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
}
