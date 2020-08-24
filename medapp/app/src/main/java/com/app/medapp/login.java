package com.app.medapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    public void btn_signup(View view) {
        startActivity(new Intent(getApplicationContext(),signup.class));
    }
    public void btn_log(View view){
        startActivity(new Intent(getApplicationContext() ,MainActivity.class));
    }
}
