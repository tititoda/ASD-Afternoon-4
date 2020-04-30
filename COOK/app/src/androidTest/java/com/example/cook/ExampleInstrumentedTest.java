package com.example.cook;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

import androidx.test.espresso.action.ScrollToAction;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withInputType;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule
            = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.cook", appContext.getPackageName());
    }

    @Test
    public void addRecipe() throws InterruptedException {
        onView(withId(R.id.floatingActionButtonAddRecipe)).perform(click());

        onView(withId(R.id.inputName)).perform(typeText("test name"));
        onView(withId(R.id.inputDescription)).perform(typeText("test description"));
        onView(withId(R.id.inputPreparationTime)).perform(typeText("13"));
        onView(withId(R.id.inputCookingTime)).perform(typeText("13"));

        onView(withId(R.id.inputSbs)).perform(scrollTo());
        onView(withId(R.id.inputSbs)).perform(typeText("test sbs"));

        onView(withId(R.id.tag0)).perform(scrollTo());
        onView(withId(R.id.tag0)).perform(click());

        onView(withId(R.id.submitRecipe)).perform(scrollTo());
        onView(withId(R.id.submitRecipe)).perform(click());
    }

}
