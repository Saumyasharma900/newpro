package com.example.group_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage extends AppCompatActivity {
EditText t1,t2;
Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        t1 = findViewById(R.id.username);
        t2= findViewById(R.id.password);
        signin = findViewById(R.id.signin);
        helperregis  db = new helperregis(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernametxt = t1.getText().toString();
                String passwordtxt = t2.getText().toString();

                Boolean checkinsert = db.checkusernamepassword( usernametxt,passwordtxt);
                if (checkinsert==true){

                    Toast.makeText(Loginpage.this,"Login Successful",Toast.LENGTH_LONG).show();
                    Intent i= new Intent(getApplicationContext(),Homepage.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Loginpage.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}