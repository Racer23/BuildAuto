package com.example.testing.testingexample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Created by on 15/6/4.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    private static final String STRING_TO_BE_TYPED = "Peter";
    private Calculator mCalculator;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void sayHello(){
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard()); //line 1

        onView(withText("Say hello!")).perform(click()); //line 2

        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
        onView(withId(R.id.textView)).check(matches(withText(expectedText))); //line 3
    }

    @Test
    public void methodTest(){
        assertEquals(7d, mCalculator.sum(1d, 5d), 0);
        assertEquals(1d, mCalculator.substract(5d, 4d), 0);
        assertEquals(4d, mCalculator.divide(20d, 5d), 0);
        assertEquals(10d, mCalculator.multiply(2d, 5d), 0);
    }

}
