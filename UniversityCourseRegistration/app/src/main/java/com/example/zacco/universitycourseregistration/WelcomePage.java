package com.example.zacco.universitycourseregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
    }
    /** Called when the user taps the button */
    public void logout(View view) {
        // Do something in response to button
        Intent startNewActivity = new Intent(this, LoginActivity.class);
        startActivity(startNewActivity);
    }
    public void goToRegisteredClasses(View view) {
        // Do something in response to button
        Intent startNewActivity = new Intent(this, RegisteredClasses.class);
        startActivity(startNewActivity);
    }
    public void goToAcademicTimetable(View view) {
        // Do something in response to button
        Intent startNewActivity = new Intent(this, AcademicTimetable.class);
        startActivity(startNewActivity);
    }
    public void goToSchedule(View view) {
        // Do something in response to button
        Intent startNewActivity = new Intent(this, StudentSchedule.class);
        startActivity(startNewActivity);
    }
}
