package com.example.zacco.universitycourseregistration;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.times;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;




@RunWith(AndroidJUnit4.class)
public class Login_Espresso {
    private String emailValid;
    private String passValid;
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule(LoginActivity.class);
    @Before
    public void initValidAndInvalidString(){
        emailValid = "test@test.com";
        passValid = "testpass";
        Intents.init();

    }

    //Tests that login works
    @Test
    public void checkPass() throws InterruptedException {
        activityRule.launchActivity(new Intent());
        onView(withId(R.id.email)).perform(typeText(emailValid));
        onView(withId(R.id.password)).perform(typeText(passValid));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_in_button)).perform(click());
        Thread.sleep(10000);
        intended(hasComponent(WelcomePage.class.getName()));
    }

    @After
    public void release(){
        Intents.release();
    }
}