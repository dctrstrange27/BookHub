package com.example.jason_valley.front;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.jason_valley.R;
import com.example.jason_valley.login.login;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class front extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.front);
        openLogin();
    }

    public void openLogin(){
        Button login = (Button) findViewById(R.id.login);
        Button signup = (Button) findViewById(R.id.signup);
        Intent goToLogin = new Intent(this, com.example.jason_valley.login.login.class);
        Intent goToSignup = new Intent(this, com.example.jason_valley.login.signup.class);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToLogin);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   startActivity(goToSignup);}
        });

    }

}