package com.example.zacco.universitycourseregistration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisteredClasses extends ListActivity {

    ListView simpleList;
    private FirebaseAuth auth;
    private DatabaseReference dbRef;

    String currentClasses[] = {"Math", "Eng", "Science"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_classes);
        populateRegistered();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, currentClasses);
        setListAdapter(arrayAdapter);
    }

    public void populateRegistered(){
        auth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference().child("Students");
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot students : dataSnapshot.getChildren()){
                    Log.v("what",""+ students.getKey());
                    Log.v("tmz", "" + students.child("First Name").getValue());
                    String key = students.getKey();
                    if(key.equals(auth.getUid())){

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("check", "failed");
            }
        });
    }

}
