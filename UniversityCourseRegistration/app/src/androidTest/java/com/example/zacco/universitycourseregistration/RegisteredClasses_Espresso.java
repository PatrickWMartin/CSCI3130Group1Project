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

/* TODO */

@RunWith(AndroidJUnit4.class)
public class RegisteredClasses_Espresso {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule(WelcomePage.class);
    @Before
    public void initValidAndInvalidString(){
        Intents.init();
    }


    @After
    public void release(){
        Intents.release();
    }
}