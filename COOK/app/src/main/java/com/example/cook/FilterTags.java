package com.example.cook;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilterTags
{
    public FilterTags(){ }


  /*
  filters all recipes that contain the given tag (position)
  @return array list of all recipes containing the given tag
  */
    public static ArrayList<Recipe> getFilteredRecipe(int position, ArrayList<Recipe> recipe){
        ArrayList<Recipe> recipeSorted = new ArrayList<>();
        //filtering recipes
        switch(position) {
            case 1:
                for (Recipe temp : recipe) {
                    if (temp.isPasta())
                        recipeSorted.add(temp);
                }
                break;
            case 2:
                for (Recipe temp : recipe) {
                    if (temp.isMeat())
                        recipeSorted.add(temp);
                }
                break;
            case 3:
                for (Recipe temp : recipe) {
                    if (temp.isDinner())
                        recipeSorted.add(temp);
                }
                break;
            case 4:
                for (Recipe temp : recipe) {
                    if (temp.isBreakfast())
                        recipeSorted.add(temp);
                }
                break;
            case 5:
                for (Recipe temp : recipe) {
                    if (temp.isSweets())
                        recipeSorted.add(temp);
                }
                break;
            case 6:
                for (Recipe temp : recipe) {
                    if (temp.isHealthy())
                        recipeSorted.add(temp);
                }
                break;
            case 7:
                for (Recipe temp : recipe) {
                    if (temp.isVegan())
                        recipeSorted.add(temp);
                }
                break;
            case 8:
                for (Recipe temp : recipe) {
                    if (temp.isLunch())
                        recipeSorted.add(temp);
                }
                break;
            case 9:
                for (Recipe temp : recipe) {
                    if (temp.isFast_food())
                        recipeSorted.add(temp);
                }
                break;
            case 10:
                for (Recipe temp : recipe) {
                    if (temp.isSoup())
                        recipeSorted.add(temp);
                }
                break;
            default:
                return recipe;

        }
        return recipeSorted;
    }


    /*
    sorts the given recipe array list by time from lowest to highest
    @return sorted array list with the same items
    */
    public static ArrayList<Recipe> getTimeSortedRecipes(ArrayList<Recipe> recipe){
        // get a copy of the array list to not remove the real one
        ArrayList<Recipe> recipeToBeSorted = (ArrayList)recipe.clone();
        ArrayList<Recipe> recipeSorted = new ArrayList<>();

        //sort algorithm (bad one)
        while(recipeSorted.size() != recipe.size())
        {
            Recipe lowestRecipe = new Recipe();
            int lowest = Integer.MAX_VALUE;
            for(Recipe temp : recipeToBeSorted)
            {
                int time = temp.getPrep_time() + temp.getCooking_time();
                if(time < lowest)
                {
                    lowest = time;
                    lowestRecipe = temp;
                }
            }
            recipeSorted.add(lowestRecipe);
            recipeToBeSorted.remove(lowestRecipe);
        }

        return recipeSorted;
    }


}
