package com.example.interviewbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class studentsActivity extends AppCompatActivity {
    EditText nameText;
    EditText idText;
    EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
    }

    public void studentLoginClick(View view) {
        nameText = findViewById(R.id.nameText);
        idText = findViewById(R.id.idText);
        emailText = findViewById(R.id.emailText);
        String name = nameText.getText().toString();
        String id = idText.getText().toString();
        String email = emailText.getText().toString();
        Intent anIntent = new Intent(this,studentsBookActivity.class);
        anIntent.putExtra("name",name);
        anIntent.putExtra("id",id);
        anIntent.putExtra("email",email);
        startActivity(anIntent);
    }
}