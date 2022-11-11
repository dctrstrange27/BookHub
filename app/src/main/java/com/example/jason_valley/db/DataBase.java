package com.example.jason_valley.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.jason_valley.usermodel.loggedIn;
import com.example.jason_valley.usermodel.userModel;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String users = "users";
    public static final String newUser = "newUser";
    public static final String email = "email";

    public DataBase(Context context){
        super(context, "USERS.db",null,2);
    }
    @Override
    public void onCreate(SQLiteDatabase bookHub) {
        String user = "CREATE TABLE "+users+" (id Integer primary key autoincrement,"+email+" Text,username Text,password Text)";
        String userLog =  "CREATE TABLE "+newUser+" (id Integer primary key autoincrement, email Text, username Text, password Text, picture Blob, verified Bool, viewBooks Integer, borrowBooks Integer)";
        bookHub.execSQL(user);
        bookHub.execSQL(userLog);

    }
    @Override
    public void onUpgrade(SQLiteDatabase bookHub, int i, int i1) {
        bookHub.execSQL("drop Table if exists users");
        bookHub.execSQL("drop Table if exists newUser");
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
    
   public Cursor checkUser(String email){
        SQLiteDatabase  db = this.getWritableDatabase();
        String query = "SELECT * FROM "+users+" WHERE email='" +email+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
   }

   //getUserData
    public Boolean newUserLogIn(loggedIn loggedIn){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        ContentValues cont =  new ContentValues();
        cont.put("email", loggedIn.getEmail());
        cont.put("username", loggedIn.getUsername());
        cont.put("password", loggedIn.getPassword());
        cont.put("picture", loggedIn.getPicture());
        cont.put("verified", loggedIn.getVerified());
        cont.put("viewBooks", loggedIn.getViewBooks());
        cont.put("borrowBooks", loggedIn.getBorrowBooks());
        long res = bookHub.insert(newUser,null,cont);
        return res != -1;
    }

    public List<userModel> getUserDetails(String email){
        List<userModel> fetch = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String querL = "SELECT * FROM users WHERE email='" +email+"'";
        Cursor res = db.rawQuery(querL,null);
        if(res.moveToNext()){
            int id = res.getInt(0);
            String e = res.getString(1);
            String username = res.getString(2);
            String pass = res.getString(3);
            userModel newUser = new userModel(id,e,username,pass);
            fetch.add(newUser);
        }
       return fetch;
    }
    public Boolean checkNewUser(String email){
        SQLiteDatabase  db = this.getWritableDatabase();
        String query = "SELECT * FROM "+newUser+" WHERE email='" +email+"'";
        Cursor cursor = db.rawQuery(query,null);
        return  cursor.getCount() > 0;
    }






    //delete specific users
    public Cursor deleteUser(String email){
        SQLiteDatabase  db = this.getWritableDatabase();
        String query = "DELETE * FROM users WHERE email='" +email+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public void deleteAllUser(){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        bookHub.delete(users, null, null);
    }



}






