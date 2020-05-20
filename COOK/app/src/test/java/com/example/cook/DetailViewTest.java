package com.example.cook;

import android.media.Image;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class DetailViewTest{

    // args for constructing class
    int id = 1;
    String name = "Bolognese";
    String description = "description";
    int prepareTime = 4;
    int cookingTime = 5;
    int testImage = 1000;
    ArrayList<GuideStep> sbsDescription = new ArrayList();
    Boolean[] tags = new Boolean[]{true, false, true, false, true,
            false, true, false, true, false};

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

}