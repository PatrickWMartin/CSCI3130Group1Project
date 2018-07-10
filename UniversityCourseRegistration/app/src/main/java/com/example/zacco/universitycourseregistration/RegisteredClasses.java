package com.example.zacco.universitycourseregistration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class RegisteredClasses extends ListActivity {

    private FirebaseAuth auth;

    String currentClasses[] = {"Loading....."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_classes);
        populateRegistered();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currentClasses);
        setListAdapter(arrayAdapter);
    }

    public void populateRegistered() {
        auth = FirebaseAuth.getInstance();
        Log.v("Method","populateRegistered Called");
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Students/"+auth.getUid()+"/Courses");
        Log.v("Check", dbRef.getKey());
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,Object> courseMap = (HashMap<String,Object>) dataSnapshot.getValue();
                Log.w("check",""+ courseMap.get("Course1"));
                getArray(courseMap);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("DATASNAPSHOT", "Datasnapshot error");
            }
        });
    }

    public void getArray(Map<String, Object> map) {
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            i++;
            currentClasses[i] = (String) entry.getValue();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currentClasses);
        setListAdapter(arrayAdapter);
    }
}
