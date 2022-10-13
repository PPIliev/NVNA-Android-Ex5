package com.example.burgers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fave extends AppCompatActivity {
    TextView tv_list, tv_list2, tv_list3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fave);

        tv_list = findViewById(R.id.tv_list);
        tv_list2 = findViewById(R.id.tv_list2);
        tv_list3 = findViewById(R.id.tv_list3);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tv_list.setText(extras.getString("faveone"));
            tv_list2.setText(extras.getString("favetwo"));
            tv_list3.setText(extras.getString("favethree"));


        }

    }

}