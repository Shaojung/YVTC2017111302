package com.example.yvtc.yvtc2017111302.data;

import android.content.Context;

/**
 * Created by yvtc on 2017/11/20.
 */

public class StudentDAOFactory {
    public static StudentDAO getStudentDAO(int type, Context context)
    {
        switch(type)
        {
            case 1:
                return new StudentDAOMemoryImpl();
            case 2:
                return new StudentDAOFileImpl(context);
        }
        return null;
    }
}
