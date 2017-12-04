package com.example.yvtc.yvtc2017111302.data;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by yvtc on 2017/12/4.
 */

public class StudentDAOCloudImpl implements StudentDAO {
    ArrayList<Student> data;
    Context context;
    FirebaseDatabase database;
    DatabaseReference myRef;
    final String TAG = "CloudImpl";
    int MaxID;
    public StudentDAOCloudImpl(Context context)
    {
        this.context = context;
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("studentdata");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
                data = gson.fromJson(value, listType);
                if (data!=null)
                {
                    if (data != null && data.size() > 0)
                    {
                        MaxID = data.get(0).id;
                    }
                    for (Student s : data)
                    {
                        if (MaxID < s.id)
                        {
                            MaxID = s.id;
                        }
                    }
                }
                else
                {
                    data = new ArrayList<>();
                }

                MaxID += 1;
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    private void saveData()
    {
        Gson gson = new Gson();
        String str = gson.toJson(data);
        myRef.setValue(str);
    }

    @Override
    public void add(Student s) {
        s.id = MaxID;
        data.add(s);
        MaxID++;
        saveData();
    }

    @Override
    public Student[] getData() {
        return new Student[0];
    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void delete(Student s) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Student getOneStudent(int id) {
        return null;
    }

    @Override
    public Student[] searchByName(String name) {
        return new Student[0];
    }
}
