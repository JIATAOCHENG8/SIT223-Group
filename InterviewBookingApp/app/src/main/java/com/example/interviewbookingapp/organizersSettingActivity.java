package com.example.interviewbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class organizersSettingActivity extends AppCompatActivity {
    TextView organizersNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizers_setting);
        organizersNameTextView = findViewById(R.id.organizersNmaeTextView);
        Intent intent = getIntent();
        String name;
        name = intent.getStringExtra("name");
        organizersNameTextView.setText("Welcome "+name);
    }
}