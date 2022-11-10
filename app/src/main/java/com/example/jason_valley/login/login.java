package com.example.jason_valley.login;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.home.home;
import com.google.android.material.textfield.TextInputEditText;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class login extends AppCompatActivity {
    TextInputEditText email, password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
       setContentView(R.layout.login);

       //clickable to SIGN UP
        TextView register = (TextView)findViewById(R.id.signup);
        Intent regis = new Intent(this, com.example.jason_valley.login.signup.class);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(regis);
            }
        });





        email = (TextInputEditText) findViewById(R.id.userl);
        password = (TextInputEditText) findViewById(R.id.passl);
        login = (Button) findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                String e = email.getText().toString();
                String pass = password.getText().toString();
                DataBase db = new DataBase(login.this);
                if(e.equals("") || pass.equals("")){
                    Toast.makeText(login.this, "Missing Payloads!", Toast.LENGTH_LONG).show();
                    return;
                }else {
                    Cursor res = db.checkUser(e);
                    String passw = null;
                    if(res.moveToNext()){passw = res.getString(3);}
                    BCrypt.Result checkPass = BCrypt.verifyer().verify(pass.toCharArray(),passw);
                    //Boolean checkUser = db.checkUser(e,pass);
                    if(checkPass.verified){
                        Toast.makeText(login.this, "Login Success!", Toast.LENGTH_LONG).show();
                        Intent goToHome = new Intent(getApplicationContext(), home.class);
                        startActivity(goToHome);
                    }else {
                        Toast.makeText(login.this, "wrong credentials! Check email and password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    public  void deleteUser(){
        DataBase db = new DataBase(login.this);
        String user = "dcrrohan@gmail.com";
        Cursor res = db.deleteUser(user);
        if(res.moveToNext()){
            System.out.println("deleted user: "+res.getString(1)+" "+res.getString(2)+" "+res.getString(3));
        }
    }
}