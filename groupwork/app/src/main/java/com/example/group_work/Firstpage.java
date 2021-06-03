package com.example.group_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class Firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

    }
    public void signup(View view){
        Intent i = new Intent(getApplicationContext(),Signup.class);
        startActivity(i);

    }
    public void signin(View view){
        Intent i = new Intent(getApplicationContext(), Loginpage.class);
        startActivity(i);

    }
    public void skip(View view){
        Intent i = new Intent(getApplicationContext(),Homepage.class);
        startActivity(i);

    }
}