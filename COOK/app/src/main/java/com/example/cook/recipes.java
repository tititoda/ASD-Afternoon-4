package com.example.cook;

import android.media.Image;

public class recipes {
    public int id;
    public String name;
    public String description;
    public int prep_time;
    public int cooking_time;

    public Image food_picture;

    public boolean pasta, meat, dinner, breakfast, sweets, healthy, vegan,
            lunch, fast_food, soup, salad;

    //constructor
    public recipes(int id, String name, String description, int prep_time, int cooking_time,
                   Image food_picture, boolean pasta, boolean meat, boolean dinner, boolean breakfast,
                   boolean sweets, boolean healthy, boolean vegan, boolean lunch, boolean fast_food,
                   boolean soup, boolean salad) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prep_time = prep_time;
        this.cooking_time = cooking_time;
        this.food_picture = food_picture;
        this.pasta = pasta;
        this.meat = meat;
        this.dinner = dinner;
        this.breakfast = breakfast;
        this.sweets = sweets;
        this.healthy = healthy;
        this.vegan = vegan;
        this.lunch = lunch;
        this.fast_food = fast_food;
        this.soup = soup;
        this.salad = salad;
    }



    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(int prep_time) {
        this.prep_time = prep_time;
    }

    public int getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    public Image getFood_picture() {
        return food_picture;
    }

    public void setFood_picture(Image food_picture) {
        this.food_picture = food_picture;
    }

    public boolean isPasta() {
        return pasta;
    }

    public void setPasta(boolean pasta) {
        this.pasta = pasta;
    }

    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isDinner() {
        return dinner;
    }

    public void setDinner(boolean dinner) {
        this.dinner = dinner;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isSweets() {
        return sweets;
    }

    public void setSweets(boolean sweets) {
        this.sweets = sweets;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isLunch() {
        return lunch;
    }

    public void setLunch(boolean lunch) {
        this.lunch = lunch;
    }

    public boolean isFast_food() {
        return fast_food;
    }

    public void setFast_food(boolean fast_food) {
        this.fast_food = fast_food;
    }

    public boolean isSoup() {
        return soup;
    }

    public void setSoup(boolean soup) {
        this.soup = soup;
    }

    public boolean isSalad() {
        return salad;
    }

    public void setSalad(boolean salad) {
        this.salad = salad;
    }
}
