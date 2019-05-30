package com.example.zacco.universitycourseregistration;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

/* TODO */

@RunWith(AndroidJUnit4.class)
public class Welcome_Espresso {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule(WelcomePage.class);
    @Before
    public void initValidAndInvalidString(){
        Intents.init();

    }

    //Tests that Welcomepage works
    @Test
    public void checkPass() throws InterruptedException {
        activityRule.launchActivity(new Intent());
        Espresso.closeSoftKeyboard();
        Thread.sleep(10000);
        onView(withId(R.id.Welcome)).check(matches(withText("Welcome Test to The University of Maximegalon Course Registration!")));
        Thread.sleep(10000);
    }

    @Test
    public void buttonIsEnabled() {
        onView(withId(R.id.registeredclasses)).check(matches(isEnabled()));
        onView(withId(R.id.courses)).check(matches(isEnabled()));
        onView(withId(R.id.schedule)).check(matches(isEnabled()));
        onView(withId(R.id.logout)).check(matches(isEnabled()));
    }

    @Test
    public void buttonIsDisplayed() {
        onView(withId(R.id.registeredclasses)).check(matches(isDisplayed()));
        onView(withId(R.id.courses)).check(matches(isDisplayed()));
        onView(withId(R.id.schedule)).check(matches(isDisplayed()));
        onView(withId(R.id.logout)).check(matches(isDisplayed()));
    }

    @Test
    public void buttonIsNotSelectable() {
        onView(withId(R.id.registeredclasses)).check(matches(not(isSelected())));
        onView(withId(R.id.courses)).check(matches(not(isSelected())));
        onView(withId(R.id.schedule)).check(matches(not(isSelected())));
        onView(withId(R.id.logout)).check(matches(not(isSelected())));
    }

    @Test
    public void buttonIsClickable() {
        onView(withId(R.id.registeredclasses)).check(matches(isClickable()));
        onView(withId(R.id.courses)).check(matches(isClickable()));
        onView(withId(R.id.schedule)).check(matches(isClickable()));
        onView(withId(R.id.logout)).check(matches(isClickable()));
    }
    @Test
    public void buttonWithText() {
        onView(withId(R.id.registeredclasses)).check(matches(withText("Registered Classes")));
        onView(withId(R.id.courses)).check(matches(withText("Academic Timetable")));
        onView(withId(R.id.schedule)).check(matches(withText("Student Detail Schedule")));
        onView(withId(R.id.logout)).check(matches(withText("Logout")));
    }

    @After
    public void release(){
        Intents.release();
    }
}