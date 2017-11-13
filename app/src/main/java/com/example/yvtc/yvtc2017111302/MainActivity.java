package com.example.yvtc.yvtc2017111302;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.yvtc.yvtc2017111302.data.Student;
import com.example.yvtc.yvtc2017111302.data.StudentDAOMemoryImpl;
import com.example.yvtc.yvtc2017111302.data.StudentDAOTest1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static StudentDAOMemoryImpl t = new StudentDAOMemoryImpl();
    RecyclerView mRecyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        t.add(new Student("Bob", "123", "123"));
        t.add(new Student("Mary", "123", "123"));
        mAdapter = new MyAdapter(MainActivity.this, t.getData());
        mRecyclerView.setAdapter(mAdapter);



//        t.add(new Student("Bob", "123", "aabb"));
//        t.add(new Student("Mary", "234", "ccdd"));
//
//        Student[] mylist = t.getData();
//        for (Student s: mylist)
//        {
//            Log.d("DATAS", s.toString());
//        }
//
//        Student editStudent = mylist[0];
//        editStudent.tel = "987";
//        t.update(editStudent);
//
//        Student[] mylist1 = t.getData();
//        for (Student s: mylist1)
//        {
//            Log.d("DATAS", "update:" + s.toString());
//        }
    }
}
