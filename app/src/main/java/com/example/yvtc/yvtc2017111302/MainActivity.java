package com.example.yvtc.yvtc2017111302;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

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
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View v = rv.findChildViewUnder(e.getX(), e.getY());
                int position = rv.getChildLayoutPosition(v);
                // Toast.makeText(MainActivity.this, "posi:" + position, Toast.LENGTH_SHORT).show();
                if (position >= 0)
                {
                    Intent it = new Intent(MainActivity.this, DetailActivity.class);
                    it.putExtra("id", t.getData()[position].id);
                    startActivity(it);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter = new MyAdapter(MainActivity.this, t.getData());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent(MainActivity.this, AddActivity.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }
}
