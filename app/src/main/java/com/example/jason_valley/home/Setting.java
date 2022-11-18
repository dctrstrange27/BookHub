package com.example.jason_valley.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jason_valley.R;
import com.example.jason_valley.home.Setting;
import com.example.jason_valley.homeFragment.Home;
import com.example.jason_valley.homeFragment.Search;
import com.example.jason_valley.homeFragment.books;
import com.example.jason_valley.homeFragment.mainHome;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

    }
}