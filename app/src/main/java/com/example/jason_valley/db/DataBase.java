package com.example.jason_valley.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jason_valley.usermodel.loggedIn;
import com.example.jason_valley.usermodel.Books;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String users = "users";
    public static final String email = "email";
    public static final String books = "BOOKS";

    public DataBase(Context context){
        super(context, "BOOKHUB.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase bookHub) {
        String userLog =  "CREATE TABLE "+users+" (id Integer primary key autoincrement, email Text, username Text, password Text, picture Text, verified Bool, viewBooks Integer)";
        String bookQuery = "CREATE TABLE "+books+" (id Integer primary key autoincrement, title Text, author Text, description Text, language Text, category Text, image Text, pdf Text)";
        bookHub.execSQL(userLog);
        bookHub.execSQL(bookQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase bookHub, int i, int i1) {
        bookHub.execSQL("drop Table if exists users");
        bookHub.execSQL("drop Table if exists newUser");
        bookHub.execSQL("drop Table if exists BOOOKS");
    }
    // creating Users
//    public Boolean createUser(Books Books){
//        SQLiteDatabase bookHub = this.getWritableDatabase();
//        ContentValues cont =  new ContentValues();
//        cont.put("email", Books.getEmail() );
//        cont.put("username", Books.getUsername());
//        cont.put("password", Books.getPassword() );
//        long res = bookHub.insert(users,null,cont);
//        return res != -1;
//    }
    //check of Users Does Exist
    public Boolean doesExist(String email){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        Cursor cur = bookHub.rawQuery(String.format("select * from "+users+" where email= '%s'", email), null);
        return  cur.getCount() > 0;
    }
    
   public Cursor checkUser(String email){
        SQLiteDatabase  db = this.getWritableDatabase();
        String query = "SELECT * FROM "+users+" WHERE email='" +email+"'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
   }
   //getUserData
    public Boolean createUser(loggedIn loggedIn){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        ContentValues cont =  new ContentValues();
        cont.put("email", loggedIn.getEmail());
        cont.put("username", loggedIn.getUsername());
        cont.put("password", loggedIn.getPassword());
        cont.put("picture", loggedIn.getPicture());
        cont.put("verified", loggedIn.getVerified());
        cont.put("viewBooks", loggedIn.getViewBooks());
        long res = bookHub.insert(users,null,cont);
        return res != -1;
    }

    public List<loggedIn> getAllUser(){
        List<loggedIn> getUsers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String querL = "SELECT * FROM " + users;
        Cursor res = db.rawQuery(querL,null);
        System.out.println("user:   "+res.toString());
        if(res.moveToFirst()){
            do {
                int _id = res.getInt(0);
                String email = res.getString(1);
                String username = res.getString(2);
                String pass = res.getString(3);
                String picture = res.getString(4);
                boolean verified = res.getInt(5) == 1;
                int view = res.getInt(6);
                loggedIn newBook = new loggedIn(_id,email,username,pass,picture,verified,view);
                System.out.println(newBook.toString());
                getUsers.add(newBook);
            }while (res.moveToNext());
        }
        res.close();
        db.close();
        return getUsers;
    }
    public List<loggedIn> getUser(String email){
        List<loggedIn> userInfo = new ArrayList<>();
        SQLiteDatabase  db = this.getWritableDatabase();
        String query = "SELECT * FROM "+users+" WHERE email='" +email+"'";
        Cursor res = db.rawQuery(query,null);
        if(res.moveToFirst()){
            do {
                int _id = res.getInt(0);
                String e = res.getString(1);
                String usrname = res.getString(2);
                String pass = res.getString(3);
                String pic = res.getString(4);
                boolean veri = res.getInt(5) == 1;
                int view = res.getInt(6);
                loggedIn newlog = new loggedIn(_id,e,usrname,pass,pic,veri,view);
                System.out.println(newlog.toString());
                userInfo.add(newlog);
            }while (res.moveToNext());
        }
        res.close();
        db.close();
        return userInfo;
    }

    public List<Books> getAllBooks(){
        List<Books> fetch = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String querL = "SELECT * FROM " + books;
        Cursor res = db.rawQuery(querL,null);
        System.out.println("count: "+res.toString() );
        if(res.moveToFirst()){
            do {
                int _id = res.getInt(0);
                String tit = res.getString(1);
                String author = res.getString(2);
                String des = res.getString(3);
                String lang = res.getString(4);
                String cat = res.getString(5);
                String img = res.getString(6);
                String pdf = res.getString(7);
                Books newBook = new Books(_id,tit,author,des,lang,cat,img,pdf);
//                System.out.println(newBook.toString());
                fetch.add(newBook);
            }while (res.moveToNext());
        }
        res.close();
        db.close();
       return fetch;
    }

    public Boolean checkNewUser(String email){
        SQLiteDatabase  db = this.getWritableDatabase();
        String query = "SELECT * FROM "+users+" WHERE email='" +email+"'";
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

    public Boolean createBooks(Books b){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        ContentValues cont =  new ContentValues();
        cont.put("title", b.getTitle());
        cont.put("author", b.getAuthor() );
        cont.put("description", b.getDescription() );
        cont.put("language", b.getLanguage());
        cont.put("category", b.getCategory());
        cont.put("image", b.getImages());
        cont.put("pdf", b.getPdf());
        long res = bookHub.insert(books,null,cont);
        System.out.println(res);
        return res != -1;

    }

    public Boolean checkBooks(String title){
        SQLiteDatabase  db = this.getWritableDatabase();
        String query = "SELECT * FROM "+books+" WHERE title='" +title+"'";
        Cursor cursor = db.rawQuery(query,null);
        return  cursor.getCount() > 0;
    }
    public void deleteBooks(){
        SQLiteDatabase bookHub = this.getWritableDatabase();
        bookHub.delete(books, null, null);
    }

    public boolean update(String username,String password, String email){
        SQLiteDatabase  db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("username", username);
        cont.put("password", password);
        long res =  db.update(users,cont,"email=?",new String[]{email});
        return res != -1;
    }





}






