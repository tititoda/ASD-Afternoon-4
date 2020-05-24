package com.example.cook;

import android.app.Activity;
import android.media.Image;
import java.lang.String;

import java.util.ArrayList;
import java.util.HashMap;

public class Recipe {
    private static int recipeObjectCount = 0;

    public static boolean initialised = false;

    public static boolean new_recipe_added = false;

    public static boolean edit_recipe = false;
    public static Recipe recipe_to_edit;
    public static int recipe_to_edit_index;

    public static ArrayList<Recipe> allRecipe = new ArrayList<>();
    public static ArrayList<Recipe> favoriteRecipe = new ArrayList<>();

    public static String pastaString = "pasta";
    public static String meatString = "meat";
    public static String dinnerString = "dinner";
    public static String breakfastString = "breakfast";
    public static String sweetsString = "sweets";
    public static String healthyString = "healthy";
    public static String veganString = "vegan";
    public static String lunchString = "lunch";
    public static String fastFoodString = "fast food";
    public static String soupString = "soup";

    private int id;
    private String name;
    private String description;
    private int prep_time;
    private int cooking_time;
    private ArrayList<GuideStep> sbs_description;
    private int food_picture;
    private boolean pasta, meat, dinner, breakfast, sweets, healthy, vegan,
            lunch, fast_food, soup;


    //constructor
    public Recipe(){
        recipeObjectCount++;
    };

    public Recipe(int id, String name, String description, int prep_time, int cooking_time,
                  int food_picture, ArrayList<GuideStep> sbs_description, Boolean[] Tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prep_time = prep_time;
        this.sbs_description = sbs_description;
        this.cooking_time = cooking_time;
        this.food_picture = food_picture;
        this.pasta = Tags[0];
        this.meat = Tags[1];
        this.dinner = Tags[2];
        this.breakfast = Tags[3];
        this.sweets = Tags[4];
        this.healthy = Tags[5];
        this.vegan = Tags[6];
        this.lunch = Tags[7];
        this.fast_food = Tags[8];
        this.soup = Tags[9];
        recipeObjectCount++;
    };


    public String getStringTagForListView(){
        String tempTag = new String();
        char fill = ' ';
        if(this.pasta)
            tempTag = tempTag + fill + pastaString;
        if(this.meat)
            tempTag = tempTag + fill + meatString;
        if(this.dinner)
            tempTag = tempTag + fill + dinnerString;
        if(this.breakfast)
            tempTag = tempTag + fill + breakfastString;
        if(this.sweets)
            tempTag = tempTag + fill + sweetsString;
        if(this.healthy)
            tempTag = tempTag + fill + healthyString;
        if(this.vegan)
            tempTag = tempTag + fill + veganString;
        if(this.lunch)
            tempTag = tempTag + fill + lunchString;
        if(this.fast_food)
            tempTag = tempTag + fill + fastFoodString;
        if(this.soup)
            tempTag = tempTag + fill + soupString;
        //trim string for listView (first fill char)
        return tempTag.substring(1, tempTag.length());
    }

    public static Recipe getRecipeByName(String recipeName)
    {
        for(Recipe temp : allRecipe)
        {
            if((temp.getName().compareTo(recipeName)) == 0)
                return temp;
        }
        return null;//new Recipe();
    }

    public static int getRecipeObjectCount() {
        return recipeObjectCount;
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

    public int getFood_picture() {
        return food_picture;
    }

    public void setFood_picture(int food_picture) {
        this.food_picture = food_picture;
    }

    public ArrayList<GuideStep> getSBSDescription() { return sbs_description; }

    public void setSBSDescription(ArrayList<GuideStep> sbs_description) { this.sbs_description = sbs_description; }

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

}
