package com.example.cook;



import android.app.Activity;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class Recipe_InterfaceTest {

    int id = 0;
    String name = "Bolognese";
    String description = "description";
    int prepareTime = 20;
    int cookingTime = 30;
    int testImage = 1000;
    ArrayList<GuideStep> sbsDescription = new ArrayList();
    Boolean[] tags = new Boolean[]{true, true, true, false, false,
            false, false, false, false, false};
    int test_count = 0;
    Recipe testRecipe;

    @Before
    public void setUp() throws Exception {
        testRecipe = new Recipe(id, name, description, prepareTime,
                cookingTime, testImage, sbsDescription, tags);
    }

    @Test
    public void testGetId(){
        assertEquals(id, testRecipe.getId());
    }
    @Test
    public void testSetId(){
        int newId = 2;
        testRecipe.setId(newId);
        assertEquals(newId, testRecipe.getId());
    }
    @Test
    public void testGetName(){
        assertEquals(name, testRecipe.getName());
    }
    @Test
    public void testSetName(){
        String newName = "new name";
        testRecipe.setName(newName);
        assertEquals(newName, testRecipe.getName());
    }
    @Test
    public void testDescription(){
        assertEquals(description, testRecipe.getDescription());
    }
    @Test
    public void testSetDescription(){
        String newDescription = "new description";
        testRecipe.setDescription(newDescription);
        assertEquals(newDescription, testRecipe.getDescription());
    }
    @Test
    public void testGetPrepTime(){
        assertEquals(prepareTime, testRecipe.getPrep_time());
    }
    @Test
    public void testSetPrepTime(){
        int newTime = 10;
        testRecipe.setPrep_time(newTime);
        assertEquals(newTime, testRecipe.getPrep_time());
    }
    @Test
    public void testGetCookingTime(){
        assertEquals(cookingTime, testRecipe.getCooking_time());
    }
    @Test
    public void testSetCookingTime(){
        int newTime = 11;
        testRecipe.setCooking_time(newTime);
        assertEquals(newTime, testRecipe.getCooking_time());
    }
    @Test
    public void testGetImage(){
        assertEquals(testImage, testRecipe.getFood_picture());
    }
    @Test
    public void testSetImage(){
        int newImage = 12;
        testRecipe.setFood_picture(newImage);
        assertEquals(newImage, testRecipe.getFood_picture());
    }
    @Test
    public void testGetSBS(){
        assertEquals(sbsDescription, testRecipe.getSBSDescription());
    }
    @Test
    public void testSetSBS(){
        testRecipe.setSBSDescription(sbsDescription);
        assertEquals(sbsDescription, testRecipe.getSBSDescription());
    }
    @Test
    public void testGetTags(){
        assertEquals(tags[0], testRecipe.isPasta());
        assertEquals(tags[1], testRecipe.isMeat());
        assertEquals(tags[2], testRecipe.isDinner());
        assertEquals(tags[3], testRecipe.isBreakfast());
        assertEquals(tags[4], testRecipe.isSweets());
        assertEquals(tags[5], testRecipe.isHealthy());
        assertEquals(tags[6], testRecipe.isVegan());
        assertEquals(tags[7], testRecipe.isLunch());
        assertEquals(tags[8], testRecipe.isFast_food());
        assertEquals(tags[9], testRecipe.isSoup());
    }
    @Test
    public void testSetTags(){
        Boolean[] newTags = new Boolean[]{true, true, true, true, true,
                false, false, false, false, false};
        testRecipe.setPasta(true);
        testRecipe.setMeat(true);
        testRecipe.setDinner(true);
        testRecipe.setBreakfast(true);
        testRecipe.setSweets(true);
        testRecipe.setHealthy(false);
        testRecipe.setVegan(false);
        testRecipe.setLunch(false);
        testRecipe.setFast_food(false);
        testRecipe.setSoup(false);

        assertEquals(newTags[0], testRecipe.isPasta());
        assertEquals(newTags[1], testRecipe.isMeat());
        assertEquals(newTags[2], testRecipe.isDinner());
        assertEquals(newTags[3], testRecipe.isBreakfast());
        assertEquals(newTags[4], testRecipe.isSweets());
        assertEquals(newTags[5], testRecipe.isHealthy());
        assertEquals(newTags[6], testRecipe.isVegan());
        assertEquals(newTags[7], testRecipe.isLunch());
        assertEquals(newTags[8], testRecipe.isFast_food());
        assertEquals(newTags[9], testRecipe.isSoup());
    }

    @Test
    public void testTagsForListView(){
        String testString = "pasta meat dinner";

        assertEquals(testRecipe.getStringTagForListView(), testString);
    }

    @Test
    public void testGetRecipeByName(){
        ArrayList<Recipe> testList = mock(ArrayList.class);
        when(testList.get(0)).thenReturn(testRecipe);

        Recipe.allRecipe.add(testRecipe);

        assertEquals(testList.get(0), Recipe.getRecipeByName(name));
    }

    @Test
    public void testRecipeObjectCount(){
        assertEquals(13, Recipe.getRecipeObjectCount());
}


}
