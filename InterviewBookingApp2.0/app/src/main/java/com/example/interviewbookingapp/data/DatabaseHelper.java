package com.example.interviewbookingapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.interviewbookingapp.model.Students;
import com.example.interviewbookingapp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" + Util.STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Util.STUDENT_NAME + " TEXT ," + Util.STUDENT_EMAIL + " TEXT ," + Util.STUDENT_TIME + " TEXT)";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_STUDENT_TABLE = "DROP TABLE IF EXISTS";
        db.execSQL(DROP_STUDENT_TABLE, new String[]{Util.TABLE_NAME});
        onCreate(db);
    }

    public long insertStudent(Students student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.STUDENT_ID, student.getStudent_id());
        contentValues.put(Util.STUDENT_NAME, student.getStudent_name());
        contentValues.put(Util.STUDENT_EMAIL,student.getStudent_email());
        contentValues.put(Util.STUDENT_TIME, student.getStudent_time());
        long newRowId = db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    public List<Students> fetchAllStudents()
    {
        List<Students> studentsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        if(cursor.moveToNext()){
            do{
                Students student = new Students();
                student.setStudent_id(cursor.getInt(0));
                student.setStudent_name(cursor.getString(1));
                student.setStudent_email(cursor.getString(2));
                student.setStudent_time(cursor.getString(3));

                studentsList.add(student);
            }while(cursor.moveToNext());
        }
        return studentsList;
    }

    public void deleteStudent(Students student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, Util.STUDENT_NAME + " =? " , new String[]{String.valueOf(student.getStudent_name())});
        db.delete(Util.TABLE_NAME, Util.STUDENT_ID + " =? ", new String[]{String.valueOf(student.getStudent_id())});
        db.delete(Util.TABLE_NAME, Util.STUDENT_EMAIL + " =? " , new String[]{String.valueOf(student.getStudent_email())});
        db.delete(Util.TABLE_NAME, Util.STUDENT_TIME + " =? ", new String[]{String.valueOf(student.getStudent_time())});
        db.close();
    }

}
