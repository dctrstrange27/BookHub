package com.example.jason_valley.homeFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class mainHome extends AppCompatActivity {
    private int selection = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final ImageView home = findViewById(R.id.home);
        final ImageView search = findViewById(R.id.search);
        final ImageView lib = findViewById(R.id.books);
        LinearLayout bottom = findViewById(R.id.buttonBar);


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





    }
}