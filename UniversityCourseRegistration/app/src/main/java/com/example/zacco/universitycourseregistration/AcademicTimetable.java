package com.example.zacco.universitycourseregistration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class AcademicTimetable extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
//    private RecyclerViewAdapter recyclerViewAdapter;
    private TextView courseContent;
    private DatabaseReference databaseReference;
    private List<Task> allTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

      /*  Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Course")
                .limitToLast(50);

        FirebaseRecyclerOptions<Course> options =
                new FirebaseRecyclerOptions.Builder<Course>()
                        .setQuery(query, Course.class)
                        .build();

        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Course,CourseHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CourseHolder holder, int position, @NonNull Course model) {
                holder.bindData(model);
            }

            @Override
            public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView view = (TextView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.activity_academic_timetable, parent, false);
                return new CourseHolder(view);
            }

        };
*/


}
