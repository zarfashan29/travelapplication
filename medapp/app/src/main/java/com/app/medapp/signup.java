package com.app.medapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    EditText username, mail, pass, c_pass;
    Button sign_up;
    ProgressBar p_bar;
    RadioButton doc,pat;
    TextView spec;
private FirebaseAuth firebaseAuth;
    @androidx.annotation.RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sign Up");
        username = (EditText) findViewById(R.id.username);
        mail = (EditText) findViewById(R.id.mail);
        pass = (EditText) findViewById(R.id.pass);
        c_pass = (EditText) findViewById(R.id.c_pass);
        pat = (RadioButton) findViewById(R.id.pat);
        doc = (RadioButton) findViewById(R.id.doc);
        sign_up = (Button) findViewById(R.id.sign_up);
        p_bar = (ProgressBar)findViewById(R.id.p_bar);

        firebaseAuth = FirebaseAuth.getInstance();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString().trim();
                String email = mail.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String confirm_password = c_pass.getText().toString().trim();
                String patient = pat.getText().toString().trim();
                String doctor = doc.getText().toString().trim();

                if(TextUtils.isEmpty(Username)){
                    Toast.makeText(signup.this, "please enter your Username",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(signup.this, "please enter your email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(signup.this, "please enter your password",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confirm_password)){
                    Toast.makeText(signup.this, "please enter your password",Toast.LENGTH_SHORT).show();
                    return;

                }
                if(password.length()<6){
                    Toast.makeText(signup.this, "password too short",Toast.LENGTH_SHORT).show();

                }

                p_bar.setVisibility(View.VISIBLE);

                if(password.equals(confirm_password)){
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    p_bar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        Toast.makeText(signup.this,"resgistration done",Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(signup.this,"Authentication failed",Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });



                }


            }
        });
    }}