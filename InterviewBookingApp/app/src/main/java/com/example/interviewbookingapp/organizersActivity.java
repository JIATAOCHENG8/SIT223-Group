package com.example.interviewbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class organizersActivity extends AppCompatActivity {
    EditText oNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizers);
        oNameText = findViewById(R.id.oNameText);
    }

    public void organizersLoginButton(View view) {
        String name;
        name = oNameText.getText().toString();

        Intent anIntent = new Intent(this,organizersSettingActivity.class);
        anIntent.putExtra("name",name);
        startActivity(anIntent);
    }
}