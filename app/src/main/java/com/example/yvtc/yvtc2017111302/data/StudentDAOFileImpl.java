package com.example.yvtc.yvtc2017111302.data;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by yvtc on 2017/11/15.
 */

public class StudentDAOFileImpl implements StudentDAO {
    ArrayList<Student> data = new ArrayList();
    Context context;
    String DATA_FILE;
    public StudentDAOFileImpl(Context context)
    {
        this.context = context;
        DATA_FILE = context.getFilesDir().getAbsolutePath() + File.separator + "mydata.json";
    }

    private void saveData()
    {

    }

    private void loadData()
    {

    }

    @Override
    public void add(Student s) {

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
