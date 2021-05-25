package com.example.interviewbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class studentsBookActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView idTextView;
    TextView emailTextView;
    String name;
    String id;
    String email;
    Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_book);
        nameTextView = findViewById(R.id.nameTextView);
        idTextView = findViewById(R.id.idTextView);
        emailTextView = findViewById(R.id.emailTextView);
        mySpinner = findViewById(R.id.mySpinner);
        String[] date = {" ","7/1/2021","7/2/2021","7/3/2021"};

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");
        email = intent.getStringExtra("email");
        nameTextView.setText("your name is :"+ name);
        idTextView.setText("your ID is :"+ id);
        emailTextView.setText("your email is :"+ email);
        //confirm information

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, date);
        //create ArrayAdapter
        mySpinner.setAdapter(adapter);
        //set adapter to spinner
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = new initialFragment();
                String time = date[position];
                if(time == "7/1/2021")
                {
                    fragment = new JulyoneFragment();
                }
                if(time == "7/2/2021")
                {
                    fragment = new JulytwoFragment();
                }
                if(time == "7/3/2021")
                {
                    fragment = new JulythreeFragment();
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fragment ).commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}