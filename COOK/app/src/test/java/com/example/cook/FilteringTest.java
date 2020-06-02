package com.example.cook;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FilteringTest {
    int id = 1;
    String name = "Bolognese";
    String description = "description";
    int prepareTime = 4;
    int cookingTime = 5;
    int testImage = 1000;
    ArrayList<GuideStep> sbsDescription = new ArrayList();
    //        pasta = Tags[0];
    //        meat = Tags[1];
    //        dinner = Tags[2];
    //        breakfast = Tags[3];
    //        sweets = Tags[4];
    //        healthy = Tags[5];
    //        vegan = Tags[6];
    //        lunch = Tags[7];
    //        fast_food = Tags[8];
    //        soup = Tags[9];
    Boolean[] tags = new Boolean[]{true, false, true, false, true,
            false, true, false, true, false};
    Recipe testRecipe;

    @Before
    public void setUp(){
        testRecipe = new Recipe(id, name, description, prepareTime,
                cookingTime, testImage, sbsDescription, tags);
    }

    @Test
    public void tagsCorrectlyFiltered(){


        //creating an object
        ArrayList<Recipe> arrayListRecipe = new ArrayList<>();
        arrayListRecipe.add(testRecipe);
        ArrayList<Recipe> emptyRecipe = new ArrayList<>();
        assertEquals(FilterTags.getFilteredRecipe(1, arrayListRecipe), arrayListRecipe);
        assertEquals(FilterTags.getFilteredRecipe(2, arrayListRecipe), emptyRecipe);
        assertEquals(FilterTags.getFilteredRecipe(3, arrayListRecipe), arrayListRecipe);
        assertEquals(FilterTags.getFilteredRecipe(4, arrayListRecipe), emptyRecipe);
        assertEquals(FilterTags.getFilteredRecipe(5, arrayListRecipe), arrayListRecipe);
        assertEquals(FilterTags.getFilteredRecipe(6, arrayListRecipe), emptyRecipe);
        assertEquals(FilterTags.getFilteredRecipe(7, arrayListRecipe), arrayListRecipe);
        assertEquals(FilterTags.getFilteredRecipe(8, arrayListRecipe), emptyRecipe);
        assertEquals(FilterTags.getFilteredRecipe(9, arrayListRecipe), arrayListRecipe);
        assertEquals(FilterTags.getFilteredRecipe(10, arrayListRecipe), emptyRecipe);
    }


    @Test
    public void timeCorrectlySorted(){

        prepareTime = 10;
        Recipe testRecipe2 = new Recipe(id, name, description, prepareTime,
                cookingTime, testImage, sbsDescription, tags);
        prepareTime = 15;
        Recipe testRecipe3 = new Recipe(id, name, description, prepareTime,
                cookingTime, testImage, sbsDescription, tags);

        ArrayList<Recipe> arrayListRecipeSorted = new ArrayList<>();
        arrayListRecipeSorted.add(testRecipe);
        arrayListRecipeSorted.add(testRecipe2);
        arrayListRecipeSorted.add(testRecipe3);

        ArrayList<Recipe> arrayListRecipe2 = new ArrayList<>();
        arrayListRecipe2.add(testRecipe3);
        arrayListRecipe2.add(testRecipe2);
        arrayListRecipe2.add(testRecipe);

        ArrayList<Recipe> arrayListRecipe3 = new ArrayList<>();
        arrayListRecipe3.add(testRecipe2);
        arrayListRecipe3.add(testRecipe);
        arrayListRecipe3.add(testRecipe3);


        assertEquals(FilterTags.getTimeSortedRecipes(arrayListRecipeSorted), arrayListRecipeSorted);
        assertEquals(FilterTags.getTimeSortedRecipes(arrayListRecipe2), arrayListRecipeSorted);
        assertEquals(FilterTags.getTimeSortedRecipes(arrayListRecipe3), arrayListRecipeSorted);
    }

}
