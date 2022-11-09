package com.example.jason_valley.login;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class login extends AppCompatActivity {
    TextInputEditText username, password;
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

        username = (TextInputEditText) findViewById(R.id.userl);
        password = (TextInputEditText) findViewById(R.id.passl);
        login = (Button) findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                DataBase db = new DataBase(login.this);

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(login.this, "Missing Payloads!", Toast.LENGTH_LONG).show();
                    return;
                }else {
                    Boolean checkUser = db.checkUser(user,pass);
                    if(!checkUser){
                        Toast.makeText(login.this, "wrong Credentials", Toast.LENGTH_LONG).show();
                        return;
                    }
                    Toast.makeText(login.this, "Login Success!", Toast.LENGTH_LONG).show();
                    Intent goToHome = new Intent(getApplicationContext(), home.class);
                    startActivity(goToHome);
                }

            }
        });







    }
}