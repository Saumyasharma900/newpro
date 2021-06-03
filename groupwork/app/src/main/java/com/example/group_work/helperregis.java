package com.example.group_work;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
public class helperregis extends SQLiteOpenHelper {
    public helperregis( Context context) {
        super(context, "register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table userdetails(name text primary key,contact text, email text , pass text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists userdetails");
    }
    public boolean insertdata(String name, String contact, String email, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("email",email);
        cv.put("pass",pass);
        long result = db.insert("userdetails" , null,cv);
        if (result==-1){
            return false;

        }
        else {
            return true;
        }

    }
    public boolean updatedata(String name, String contact, String email, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("contact",contact);
        cv.put("email",email);
        cv.put("pass",pass);

        Cursor cursor = db.rawQuery("Select * from userdetails where name = ?",new String[]{name});
        if (cursor.getCount()>0)
        {
        long result = db.update("userdetails" ,cv,"name=?",new String[]{name});
        if (result==-1){
            return false;

        }
        else {
            return true;
        }}else {
            return false;
        }

    }
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from userdetails where name = ? and pass = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
