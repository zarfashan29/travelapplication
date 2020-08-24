package com.app.travelapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class packages extends AppCompatActivity {

    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages);
        
        int sliders[] ={
                R.drawable.us1,
                R.drawable.us2,
                R.drawable.us3,
                R.drawable.us4,
                R.drawable.us5,
                R.drawable.us6

        };
        viewFlipper=findViewById(R.id.flipper);
        for (int slide: sliders){
            sliderFlipper(slide);
        }
    }
    public void sliderFlipper(int image){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this, android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this, android.R.anim.fade_out);
    }
}
