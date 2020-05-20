package com.example.cook;

import android.media.Image;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddRecipeTest {


    //Tests if the get/set methods are implemented correctly
    @Test
    public void addRecipeGetSetCorrect(){
        // args for  testing
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
        //creating an object
        Recipe testRecipe = new Recipe();

        testRecipe.setId(id);
        assertEquals("return must be equal to id", testRecipe.getId(), id);
        testRecipe.setName(name);
        assertEquals("return must be equal to name", testRecipe.getName(), name);
        testRecipe.setDescription(description);
        assertEquals("return must be equal to description",
                testRecipe.getDescription(), description);
        testRecipe.setPrep_time(prepareTime);
        assertEquals("return must be equal to prepareTime", testRecipe.getPrep_time(), prepareTime);
        testRecipe.setCooking_time(cookingTime);
        assertEquals("return must be equal to cookingTime",
                testRecipe.getCooking_time(),  cookingTime);
        testRecipe.setSBSDescription(sbsDescription);
        assertEquals("return must be equal to step by step description",
                testRecipe.getSBSDescription(), sbsDescription);
        testRecipe.setPasta(tags[0]);
        assertEquals("return must be equal to tags 0", testRecipe.isPasta(), tags[0]);
        testRecipe.setMeat(tags[1]);
        assertEquals("return must be equal to tags 1", testRecipe.isMeat(), tags[1]);
        testRecipe.setDinner(tags[2]);
        assertEquals("return must be equal to tags 2", testRecipe.isDinner(), tags[2]);
        testRecipe.setBreakfast(tags[3]);
        assertEquals("return must be equal to tags 3", testRecipe.isBreakfast(), tags[3]);
        testRecipe.setSweets(tags[4]);
        assertEquals("return must be equal to tags 4", testRecipe.isSweets(), tags[4]);
        testRecipe.setHealthy(tags[5]);
        assertEquals("return must be equal to tags 5", testRecipe.isHealthy(), tags[5]);
        testRecipe.setVegan(tags[6]);
        assertEquals("return must be equal to tags 6", testRecipe.isVegan(), tags[6]);
        testRecipe.setLunch(tags[7]);
        assertEquals("return must be equal to tags 7", testRecipe.isLunch(), tags[7]);
        testRecipe.setFast_food(tags[8]);
        assertEquals("return must be equal to tags 8", testRecipe.isFast_food(), tags[8]);
        testRecipe.setSoup(tags[9]);
        assertEquals("return must be equal to tags 9", testRecipe.isSoup(), tags[9]);


    }

    /* public recipes(int id, String name, String description, int prep_time, int cooking_time,
       Image food_picture, Boolean[] Tags)
    Tests if the member variables are set correctly by the constructor */
    @Test
    public void addRecipeMembersConstructedCorrect(){
        // args for constructing class
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

        //creating an object
        Recipe testRecipe = new Recipe(id, name, description, prepareTime,
                cookingTime, testImage, sbsDescription, tags);

        //assert test statements
        assertEquals("return must be equal to id", testRecipe.getId(), id);
        assertEquals("return must be equal to name", testRecipe.getName(), name);
        assertEquals("return must be equal to description",
                testRecipe.getDescription(), description);
        assertEquals("return must be equal to prepareTime", testRecipe.getPrep_time(), prepareTime);
        assertEquals("return must be equal to cookingTime",
                testRecipe.getCooking_time(),  cookingTime);
        assertEquals("return must be equal to step by step description",
                testRecipe.getSBSDescription(),  sbsDescription);
        assertEquals("return must be equal to tags 0", testRecipe.isPasta(), tags[0]);
        assertEquals("return must be equal to tags 1", testRecipe.isMeat(), tags[1]);
        assertEquals("return must be equal to tags 2", testRecipe.isDinner(), tags[2]);
        assertEquals("return must be equal to tags 3", testRecipe.isBreakfast(), tags[3]);
        assertEquals("return must be equal to tags 4", testRecipe.isSweets(), tags[4]);
        assertEquals("return must be equal to tags 5", testRecipe.isHealthy(), tags[5]);
        assertEquals("return must be equal to tags 6", testRecipe.isVegan(), tags[6]);
        assertEquals("return must be equal to tags 7", testRecipe.isLunch(), tags[7]);
        assertEquals("return must be equal to tags 8", testRecipe.isFast_food(), tags[8]);
        assertEquals("return must be equal to tags 9", testRecipe.isSoup(), tags[9]);
    }

    @Test
    public void testAddRecipe() {

        int id = 10;
        String name = "Spaghetti";
        String description = "description";
        int prepareTime = 4;
        int cookingTime = 5;
        Image testImage = null;
        ArrayList<GuideStep> sbsDescription = new ArrayList();
        Boolean[] tags = new Boolean[]{true, false, true, false, true,
                false, true, false, true, false};


        Recipe testRecipe = new Recipe(id, name, description, prepareTime,
                cookingTime, 0, sbsDescription, tags);

        assertEquals(testRecipe.getRecipeObjectCount(), 15);

    }
}
