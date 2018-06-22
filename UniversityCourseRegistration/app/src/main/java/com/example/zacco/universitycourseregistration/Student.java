package com.example.zacco.universitycourseregistration;

import com.google.firebase.database.IgnoreExtraProperties;

import java.lang.annotation.Annotation;
@IgnoreExtraProperties

public class Student {

    private String firstName;
    private String lastName;

    public void newStudent(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }



}
