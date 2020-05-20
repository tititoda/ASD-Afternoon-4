package com.example.cook;

public class GuideStep {
    private int id;
    private String description;
    private int stepPicture;
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
        GuideStep.next_id = Math.max(id, next_id) + 1;
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
