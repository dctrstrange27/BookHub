package com.example.jason_valley.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.jason_valley.usermodel.userModel;

public class DataBase extends SQLiteOpenHelper {
    public static final String users = "users";

    public DataBase(Context context){
        super(context, "USERS.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase bookHub) {
        String createTableStatement = "CREATE TABLE "+users+"(id Integer primary key autoincrement,email Text,username Text,password Text,download_books Integer, added_books Integer)";
        bookHub.execSQL(createTableStatement);
    }
    @Override
    public void onUpgrade(SQLiteDatabase bookHub, int i, int i1) {
        bookHub.execSQL("drop Table if exists USERS");
    }
    // creating Users
    public Boolean createUser(userModel userModel){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        ContentValues cont =  new ContentValues();
        cont.put("email", userModel.getEmail() );
        cont.put("username", userModel.getUsername());
        cont.put("password", userModel.getPassword() );
        long res = bookHub.insert(users,null,cont);
        return res != -1;
    }
    //check of Users Does Exist
    public Boolean doesExist(String email){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        Cursor cur = bookHub.rawQuery(String.format("select * from users where email= '%s'", email), null);
        return  cur.getCount() > 0;
    }

   public Boolean checkUser(String username, String password){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        Cursor cur = bookHub.rawQuery("select * from users where username = ? and password = ?", new String[]{username,password});
       return  cur.getCount() > 0;
   }
}




