package com.example.burgers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Cart extends AppCompatActivity {
    TextView tv_one, tv_two, tv_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tv_one = findViewById(R.id.tv_one);
        tv_two = findViewById(R.id.tv_two);
        tv_three = findViewById(R.id.tv_three);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getInt("mack") > 0) {
                tv_one.setText("Биг мак: " + extras.getInt("mack"));
            }
            if (extras.getInt("mcchicken") > 0) {
                tv_two.setText("Макчикън: " + extras.getInt("mcchicken"));
            }
            if (extras.getInt("fish") > 1) {
                tv_three.setText("Филе-о-фиш: " + extras.getInt("fish"));
            }

        }


    }
}
