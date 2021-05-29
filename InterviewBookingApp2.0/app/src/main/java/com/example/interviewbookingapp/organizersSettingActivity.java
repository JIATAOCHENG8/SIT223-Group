package com.example.interviewbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.interviewbookingapp.data.DatabaseHelper;
import com.example.interviewbookingapp.model.Students;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class organizersSettingActivity extends AppCompatActivity {
    TextView organizersNameTextView;
    TextView bookIdText;
    TextView bookNameText;
    TextView bookEmailText;
    TextView bookTimeText;

    ArrayList<Integer> studentsIdArrayList;
    ArrayList<String> studentsNameArrayList;
    ArrayList<String> studentsEmailArrayList;
    ArrayList<String> studentsTimeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizers_setting);
        organizersNameTextView = findViewById(R.id.organizersNmaeTextView);
        bookIdText = findViewById(R.id.bookIdText);
        bookNameText = findViewById(R.id.bookNameText);
        bookEmailText = findViewById(R.id.bookEmailText);
        bookTimeText = findViewById(R.id.bookTimeText);
        Button sendButton = findViewById(R.id.sendButton);

        studentsIdArrayList = new ArrayList<>();
        studentsNameArrayList = new ArrayList<>();
        studentsEmailArrayList = new ArrayList<>();
        studentsTimeArrayList = new ArrayList<>();

        DatabaseHelper db = new DatabaseHelper(this);
        Intent intent = getIntent();
        String name;
        name = intent.getStringExtra("name");
        organizersNameTextView.setText("Welcome "+name);



        List<Students> studentsList = db.fetchAllStudents();
        for(Students student : studentsList) {
            studentsIdArrayList.add(student.getStudent_id());
            studentsNameArrayList.add(student.getStudent_name());
            studentsEmailArrayList.add(student.getStudent_email());
            studentsTimeArrayList.add(student.getStudent_time());
            db.deleteStudent(student);
        }


            int num = 0;

       /* for(int i=0;i<studentsList.size();i++){
            studentsTimeArrayList.remove(i);
            studentsIdArrayList.remove(i);
            studentsNameArrayList.remove(i);
            studentsEmailArrayList.remove(i);
        }*/
          //  studentsTimeArrayList.remove(num);
          //  studentsIdArrayList.remove(num);
          //  studentsNameArrayList.remove(num);
          //  studentsEmailArrayList.remove(num);
            bookIdText.setText(studentsIdArrayList.get(num).toString());
            bookNameText.setText(studentsNameArrayList.get(num));
            bookEmailText.setText(studentsEmailArrayList.get(num));
            bookTimeText.setText(studentsTimeArrayList.get(num));


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(organizersSettingActivity.this,"Send Successfully!",Toast.LENGTH_LONG).show();
            }
        });

    }
}