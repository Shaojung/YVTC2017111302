package com.example.yvtc.yvtc2017111302;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yvtc.yvtc2017111302.data.Student;

public class DetailActivity extends AppCompatActivity {
    TextView tv2, tv3, tv4, tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv5 = (TextView) findViewById(R.id.textView5);

        int id = getIntent().getIntExtra("id", -1);
        Student stu = MainActivity.t.getOneStudent(id);
        tv2.setText(String.valueOf(stu.id));
        tv3.setText(stu.name);
        tv4.setText(stu.tel);
        tv5.setText(stu.addr);

    }
}
