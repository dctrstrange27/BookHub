package com.example.jason_valley.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context){
        super(context, "Login.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase bookHub) {
        bookHub.execSQL("create Table users(email text primary key,username text, password text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase bookHub, int i, int i1) {
        bookHub.execSQL("drop Table if exists users");
    }

    public Boolean createUser(String email,String username,String password){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        ContentValues cont =  new ContentValues();
        cont.put("email",email);
        cont.put("username",username);
        cont.put("password",password);
        long res = bookHub.insert("users",null,cont);
        return res != -1;
    }
    public Boolean doesExist(String email){
        System.out.println("ETO ang val : "+email);
        SQLiteDatabase bookHub = this.getWritableDatabase();
        Cursor cur = bookHub.rawQuery(String.format("select * from users where email= '%s'", email), null);
        return  cur.getCount() > 0;
    }

   public Boolean checkUser(String username, String password){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cur = bookHub.rawQuery("select * from users where username = ? and password = ?", new String[]{username,password});
       return  cur.getCount() > 0;
   }
}




