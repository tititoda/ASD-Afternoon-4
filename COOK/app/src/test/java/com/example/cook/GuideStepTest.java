package com.example.cook;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GuideStepTest {

    int idOne = 0;
    int idTwo = 1;
    String description = "description";
    int picture = 0;
    GuideStep guideStepOne;
    GuideStep guideStepTwo;


    @Before
    public void setUp(){
        guideStepOne = new GuideStep(idOne);
        guideStepTwo = new GuideStep(idTwo, description, picture);
    }

    @Test
    public void testGuideStepOneSetCorrectly(){
        assertEquals(guideStepOne.getId(), idOne);
        assertEquals(guideStepOne.getDescription(), "");
        assertEquals(guideStepOne.getStepPicture(), GuideStep.NO_PICTURE);
    }

    @Test
    public void testGuideStepTwoSetCorrectly(){
        assertEquals(guideStepTwo.getId(), idTwo);
        assertEquals(guideStepTwo.getDescription(), description);
        assertEquals(guideStepTwo.getStepPicture(), picture);
    }

    @Test
    public void testGuideStepGetId(){
        assertEquals(guideStepOne.getId(), idOne);
    }

    @Test
    public void testGuideStepSetId(){
        int newId = 3;
        guideStepTwo.setId(newId);
        assertEquals(guideStepTwo.getId(), newId);
    }

    @Test
    public void testGuideStepGetDescription(){
        assertEquals(guideStepTwo.getDescription(), description);
    }

    @Test
    public void testGuideStepSetDescription(){
        String newDescription = "newdescription";
        guideStepTwo.setDescription(newDescription);
        assertEquals(guideStepTwo.getDescription(), newDescription);
    }

    @Test
    public void testGuideStepGetPicture(){
        assertEquals(guideStepTwo.getStepPicture(), picture);
    }

    @Test
    public void testGuideStepSetPicture(){
        int newPicture = 3;
        guideStepTwo.setId(newPicture);
        assertEquals(guideStepTwo.getId(), newPicture);
    }
}
