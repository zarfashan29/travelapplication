package com.app.travelapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home1Activity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdaptar adaptar = new ImageAdaptar(this);
        viewPager.setAdapter(adaptar);
        button =(Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home1Activity.this,packages.class);
                startActivity(intent);


            }
        });

    }
}
