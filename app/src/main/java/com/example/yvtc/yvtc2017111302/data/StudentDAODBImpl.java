package com.example.yvtc.yvtc2017111302.data;

import android.content.Context;

/**
 * Created by yvtc on 2017/11/20.
 */

public class StudentDAODBImpl implements StudentDAO {
    Context context;
    public StudentDAODBImpl(Context context)
    {
        this.context = context;
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
