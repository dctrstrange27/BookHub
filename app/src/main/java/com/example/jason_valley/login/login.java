package com.example.jason_valley.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.homeFragment.mainHome;

import com.google.android.material.textfield.TextInputEditText;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class login extends AppCompatActivity {
    TextInputEditText password;
    static int check = 0;
    static TextInputEditText email;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);
        //clickable to SIGN UP
        TextView register = findViewById(R.id.signup);
        Intent regis = new Intent(this, com.example.jason_valley.login.signup.class);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase db = new DataBase(login.this);
                db.deleteAllUser();
                startActivity(regis);
            }
        });
        email = findViewById(R.id.userl);
        password = findViewById(R.id.passl);
        login = findViewById(R.id.btnlogin);
        login.setOnClickListener(aegi -> {
            String e = email.getText().toString();
            String pass = password.getText().toString();
            DataBase db = new DataBase(login.this);


            if (e.equals("") || pass.equals("")) {
                Toast.makeText(login.this, "Missing Payloads!", Toast.LENGTH_LONG).show();
                return;
            } else {
                if (doesExist(e)) {
                    Cursor res = db.checkUser(e);
                    String passw = null;
                    if (res.moveToNext()) {
                        passw = res.getString(3);
                    }
                    BCrypt.Result checkPass = BCrypt.verifyer().verify(pass.toCharArray(), passw);
                    if (checkPass.verified) {
                        Toast.makeText(login.this, "Login Success!", Toast.LENGTH_LONG).show();
                        Intent goToHome = new Intent(getApplicationContext(), mainHome.class);
                        startActivity(goToHome);

                        check = 1;
                    } else {
                        Toast.makeText(login.this, "wrong credentials! Check email and password", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(login.this, "User not Existing!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public static int check(){
        return check;
    }
    public static String getEmail(){
        return check > 0 ? email.getText().toString() : null;
    }
    public static Boolean ifLogin(){
        return true;
    }

    public Boolean doesExist(String eUser) {
        DataBase db = new DataBase(login.this);
        return db.doesExist(eUser);
    }
    //Delete specific users
    public void deleteUser() {
        DataBase db = new DataBase(login.this);
        String user = "dctrrohan@gmail.com";
        Cursor res = db.deleteUser(user);
        if (res.moveToNext()) {
            Toast.makeText(login.this, "Deleted user: " + user, Toast.LENGTH_LONG).show();
        }
    }
}