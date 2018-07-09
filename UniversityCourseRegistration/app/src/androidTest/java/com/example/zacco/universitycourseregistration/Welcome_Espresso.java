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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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

    @After
    public void release(){
        Intents.release();
    }

}