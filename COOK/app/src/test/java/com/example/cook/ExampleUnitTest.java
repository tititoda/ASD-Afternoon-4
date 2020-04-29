package com.example.cook;

import android.media.Image;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    //Tests if the get/set methods are implemented correctly
    public void addRecipeGetSetCorrect(){
        // args for  testing
        int id = 1;
        String name = "Bolognese";
        String description = "description";
        int prepareTime = 4;
        int cookingTime = 5;
        int testImage = 1000;
        String sbsDescription = "step by step";
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
        String sbsDescription = "step by step";
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
    public void tagsCorrectlyFiltered(){
        int id = 1;
        String name = "Bolognese";
        String description = "description";
        int prepareTime = 4;
        int cookingTime = 5;
        int testImage = 1000;
        String sbsDescription = "step by step";
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
        ArrayList<Recipe> arrayListRecipe = new ArrayList<>();
        arrayListRecipe.add(testRecipe);
        ArrayList<Recipe> emptyRecipe = new ArrayList<>();
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(1, arrayListRecipe), arrayListRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(2, arrayListRecipe), emptyRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(3, arrayListRecipe), arrayListRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(4, arrayListRecipe), emptyRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(5, arrayListRecipe), arrayListRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(6, arrayListRecipe), emptyRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(7, arrayListRecipe), arrayListRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(8, arrayListRecipe), emptyRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(9, arrayListRecipe), arrayListRecipe);
        assertEquals("must return the recipe", FilterTags.getFilteredRecipe(10, arrayListRecipe), emptyRecipe);
    }


    @Test
    public void timeCorrectlySorted(){

        int id = 1;
        String name = "Bolognese";
        String description = "description";
        int prepareTime = 4;
        int cookingTime = 5;
        int testImage = 1000;
        String sbsDescription = "step by step";
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


        assertEquals("must return arrayListRecipeSorted", FilterTags.getTimeSortedRecipes(arrayListRecipeSorted), arrayListRecipeSorted);
        assertEquals("must return arrayListRecipeSorted", FilterTags.getTimeSortedRecipes(arrayListRecipe2), arrayListRecipeSorted);
        assertEquals("must return arrayListRecipeSorted", FilterTags.getTimeSortedRecipes(arrayListRecipe3), arrayListRecipeSorted);

    }
}