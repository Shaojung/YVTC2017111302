package com.example.yvtc.yvtc2017111302.data;

import android.content.Context;

/**
 * Created by yvtc on 2017/11/20.
 */

public class StudentDAOFactory {
    public static StudentDAO getStudentDAO(DAOType type, Context context)
    {
        switch(type)
        {
            case MEMORY:
                return new StudentDAOMemoryImpl();
            case FILE:
                return new StudentDAOFileImpl(context);
            case DB:
                return new StudentDAODBImpl(context);
            case CLOUD:
                return new StudentDAOCloudImpl(context);
        }
        return null;
    }
}
