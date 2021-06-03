package com.example.group_work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.contact);
        t3 = findViewById(R.id.email);
        t4 = findViewById(R.id.pass);
        btn = findViewById(R.id.registerbtn);
        helperregis  db = new helperregis(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametxt = t1.getText().toString();
                String contactxt = t2.getText().toString();
                String emailtxt = t3.getText().toString();
                String passtxt = t4.getText().toString();

                Boolean checkinsert = db.insertdata( nametxt,contactxt,emailtxt,passtxt);
                if (checkinsert==true){

                    Toast.makeText(Signup.this,"New entry inserted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Signup.this,"Not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}