package com.example.jason_valley.homeFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.R;

import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.home.Setting;
import com.example.jason_valley.login.login;
import com.example.jason_valley.login.signup;
import com.example.jason_valley.usermodel.loggedIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mainHome extends AppCompatActivity {
    private int selection = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        DataBase b = new DataBase(mainHome.this);
        TextView loginName = findViewById(R.id.name);
//        int checklogin = login.check();
//        int checSignup = signup.check();
//        String email = "";
//        if(checklogin > 0){
//            email = login.getEmail();
//        }
//        if(checSignup > 0){
//            email = signup.getEmail();
//        }
//        List<loggedIn> userInfo = b.getUser(email);
//        loginName.setText(userInfo.get(0).getUsername());
        router();
    }
    public  void router(){
        final ImageView home = findViewById(R.id.home);
        final ImageView search = findViewById(R.id.search);
        final ImageView lib = findViewById(R.id.books);
        final ImageView settings = findViewById(R.id.settings);
        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, Home.class, null).commit();
        home.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                home.startAnimation(AnimationUtils.loadAnimation(mainHome.this, R.anim.anim_item));
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, Home.class, null).commit();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.startAnimation(AnimationUtils.loadAnimation(mainHome.this, R.anim.anim_item));
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, Search.class, null).commit();
            }
        });
        lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lib.startAnimation(AnimationUtils.loadAnimation(mainHome.this, R.anim.anim_item));
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.fragmentContainer, books.class, null).commit();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings.startAnimation(AnimationUtils.loadAnimation(mainHome.this, R.anim.anim_item));
                Intent goToSetting = new Intent(getApplicationContext(), Setting.class);
                startActivity(goToSetting);
            }
        });
    }


}