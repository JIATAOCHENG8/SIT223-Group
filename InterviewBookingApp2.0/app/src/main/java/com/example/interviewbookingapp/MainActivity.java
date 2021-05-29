package com.example.interviewbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button studentsButton;
    Button organizersButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentsButton = findViewById(R.id.studentsButton);
        organizersButton = findViewById(R.id.organizersButton);

    }

    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.studentsButton:
                Intent Intent_one = new Intent(this,studentsActivity.class);
                startActivity(Intent_one);
                break;
            case R.id.organizersButton:
                Intent Intent_two = new Intent(this,organizersActivity.class);
                startActivity(Intent_two);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}