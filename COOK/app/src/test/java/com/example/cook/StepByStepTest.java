package com.example.cook;



import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StepByStepTest {

    int idOne = GuideStep.NO_ID;
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
    public void RecipeHasStepByStepGuide(){
        assertEquals(guideStepOne.getId(), GuideStep.NO_ID);
    }
    @Test
    public void RecipeHasNoStepByStepGuide(){
        assertFalse(guideStepTwo.getId() == GuideStep.NO_ID);
    }


    @Test
    public void TestAddNewStep(){
        ArrayList<GuideStep> arrayListAddStep = new ArrayList<>();
        arrayListAddStep.add(guideStepTwo);
        arrayListAddStep = GuideStep.addGuideStep(arrayListAddStep, description, picture);
        assertEquals(arrayListAddStep.get(0).getId(), arrayListAddStep.get(1).getId());
        assertEquals(arrayListAddStep.get(0).getDescription(), arrayListAddStep.get(1).getDescription());
        assertEquals(arrayListAddStep.get(0).getStepPicture(), arrayListAddStep.get(1).getStepPicture());
    }

    @Test
    public void TestEditExistingGuideStep(){
        GuideStep testStep  = new GuideStep(0, "", 0);
        testStep.setId(idTwo);
        testStep.setDescription(description);
        testStep.setStepPicture(picture);
        assertEquals(testStep.getId(), guideStepTwo.getId());
        assertEquals(testStep.getDescription(), guideStepTwo.getDescription());
        assertEquals(testStep.getStepPicture(), guideStepTwo.getStepPicture());
    }

    @Test
    public void TestDeleteGuideStep(){
        ArrayList<GuideStep> arrayListAddStep = new ArrayList<>();
        arrayListAddStep.add(guideStepOne);
        arrayListAddStep.add(guideStepTwo);
        arrayListAddStep.remove(guideStepTwo);
        assertEquals(arrayListAddStep.get(0).getId(), guideStepOne.getId());
        assertEquals(arrayListAddStep.get(0).getDescription(), guideStepOne.getDescription());
        assertEquals(arrayListAddStep.get(0).getStepPicture(), guideStepOne.getStepPicture());
    }

    @Test
    public void TestReorderGuideStep(){
        ArrayList<GuideStep> arrayListAddStep = new ArrayList<>();
        arrayListAddStep.add(guideStepOne);
        arrayListAddStep.add(guideStepTwo);
        int[] swap = {0,1};
        arrayListAddStep = GuideStep.reorderGuideStep(arrayListAddStep, swap);
        assertEquals(arrayListAddStep.get(0).getId(), guideStepTwo.getId());
        assertEquals(arrayListAddStep.get(0).getDescription(), guideStepTwo.getDescription());
        assertEquals(arrayListAddStep.get(0).getStepPicture(), guideStepTwo.getStepPicture());
        assertEquals(arrayListAddStep.get(1).getId(), guideStepOne.getId());
        assertEquals(arrayListAddStep.get(1).getDescription(), guideStepOne.getDescription());
        assertEquals(arrayListAddStep.get(1).getStepPicture(), guideStepOne.getStepPicture());


    }

}
