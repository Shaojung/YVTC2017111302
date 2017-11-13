package com.example.yvtc.yvtc2017111302.data;

import java.util.ArrayList;

/**
 * Created by yvtc on 2017/11/13.
 */

public class StudentDAOTest1 {
    ArrayList<Student> data = new ArrayList();
    public void add(Student s)
    {
        data.add(s);
    }
    public ArrayList<Student> getData()
    {
        return data;
    }
}
