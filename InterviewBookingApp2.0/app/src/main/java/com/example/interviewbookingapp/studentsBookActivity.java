package com.example.interviewbookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class studentsBookActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView idTextView;
    TextView emailTextView;
    TextView timeTextView;
    String name;
    String id;
    String email;
    CalendarView calendarView;
    String time;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_book);
        nameTextView = findViewById(R.id.nameTextView);
        idTextView = findViewById(R.id.idTextView);
        emailTextView = findViewById(R.id.emailTextView);
        calendarView = findViewById(R.id.calendarView);
        timeTextView = findViewById(R.id.timeTextView);
        confirmButton = findViewById(R.id.confirmButton);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");
        email = intent.getStringExtra("email");
        nameTextView.setText("your name is :"+ name);
        idTextView.setText("your ID is :"+ id);
        emailTextView.setText("your email is :"+ email);
        //confirm information

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month = month+1;
                timeTextView.setText( month +"/" + dayOfMonth + "/" + year );
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = timeTextView.getText().toString();
                Intent intent = new Intent(studentsBookActivity.this,timeSlotActivity.class);
                intent.putExtra("date",time);
                intent.putExtra("name",name);
                intent.putExtra("id",id);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

    }
}