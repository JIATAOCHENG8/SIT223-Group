package com.example.interviewbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewbookingapp.data.DatabaseHelper;
import com.example.interviewbookingapp.model.Students;

public class timeSlotActivity extends AppCompatActivity {
    DatabaseHelper db;
    TextView dateTextView;
    TextView m8TextView;
    TextView m8hTextView;
    TextView m9TextView;
    TextView m9hTextView;
    TextView m10TextView;
    TextView m10hTextView;
    TextView a13TextView;
    TextView a13hTextView;
    TextView a14TextView;
    TextView a14hTextView;
    TextView a15TextView;
    TextView a15hTextView;
    TextView slotTextView;
    String temp;
    int id;
    String name;
    String email;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_slot2);
        dateTextView = findViewById(R.id.dateTextView);
        m8TextView = findViewById(R.id.m8TextView);
        m8hTextView = findViewById(R.id.m8hTextView);
        m9TextView = findViewById(R.id.m9TextView);
        m9hTextView = findViewById(R.id.m9hTextView);
        m10TextView = findViewById(R.id.m10TextView);
        m10hTextView = findViewById(R.id.m10hTextView);
        a13TextView = findViewById(R.id.a13TextView);
        a13hTextView = findViewById(R.id.a13hTextView);
        a14TextView = findViewById(R.id.a14TextView);
        a14hTextView = findViewById(R.id.a14hTextView);
        a15TextView = findViewById(R.id.a15TextView);
        a15hTextView = findViewById(R.id.a15hTextView);
        slotTextView = findViewById(R.id.slotTextView);
        Button bookButton = findViewById(R.id.bookButton);
        db = new DatabaseHelper(this);

        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        temp = intent.getStringExtra("id");
        id = Integer.parseInt(temp);
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        dateTextView.setText(date);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = date + slotTextView.getText().toString();
                long result = db.insertStudent(new Students(id,name,email,time));
                if(result>0) {
                    Toast.makeText(timeSlotActivity.this, "Book Successfully!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText( timeSlotActivity.this,"Book error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        m8TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    slotTextView.setText(m8TextView.getText());
            }
        });
        m8hTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(m8hTextView.getText());
            }
        });
        m9TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(m9TextView.getText());
            }
        });
        m9hTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(m9hTextView.getText());
            }
        });
        m10TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(m10TextView.getText());
            }
        });
        m10hTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(m10hTextView.getText());
            }
        });
        a13TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(a13TextView.getText());
            }
        });
        a13hTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(a13hTextView.getText());
            }
        });
        a14TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(a14TextView.getText());
            }
        });
        a14hTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(a14hTextView.getText());
            }
        });
        a15TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(a15TextView.getText());
            }
        });
        a15hTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slotTextView.setText(a15hTextView.getText());
            }
        });


    }


}