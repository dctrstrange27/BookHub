package com.example.jason_valley.front;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jason_valley.R;

import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.homeFragment.books;
import com.example.jason_valley.login.dialog;
import com.example.jason_valley.login.signup;
import com.example.jason_valley.usermodel.Books;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class front extends AppCompatActivity {

    TextInputEditText title, author, description, language,category ;
    ImageView picture;
    Button add;
    Bitmap bitmap;
    DataBase b = new DataBase(front.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.front);
       ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

//        add = findViewById(R.id.add);
          Boolean c =  b.checkBooks("Cleopatra");
          if(!c) addAdvetureBook();
          openLogin();
//        add = findViewById(R.id.login);
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//              Toast.makeText(front.this,"Books Already Exist",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
    //creating books
   public void addAdvetureBook(){

//       String aut = author.getText().toString();
//       String desc = description.getText().toString();
//       String lang = language.getText().toString();
//       String cat = category.getText().toString();s


       //Adventure
       Books across_asia_on_a_bicycle = new Books(
               -1,"Across Asia on a Bicycle",
               "TThomas Gaskell Allen and William Lewis Sachtleben",
               "A fast moving narrative, interesting and full of twists of fate. Two young men take on the world in bygone times, when nations allowed such things. Riders of today will wonder at the challenge - but the same lure that drives cross-country cycling today is certainly in these pages.",
               "english",
               "adventure");
       Books journey = new Books(
               -1,"A Journey to the Centre of the Earth",
               "Jules Verne",
               "Journey to the Center of the Earth is a classic 1864 science fiction novel by Jules Verne. The story involves German professor Otto Lidenbrock who believes there are volcanic tubes going toward the centre of the Earth.",
               "english",
               "adventure");
       Books cleopatra= new Books(
               -1,
               "Cleopatra",
               " Miranda Kate ",
               "Cleopatra mixes historical action with supernatural events, and could be described as a historical fantasy novel",
               "english",
               "adventure");
       Books king_of_solomon = new Books(
               -1,
               "King Solomon's Mines",
               "H. Rider Haggard",
               "It tells of a search of an unexplored region of Africa by a group of adventurers led by Allan Quatermain for the missing brother of one of the party.",
               "english",
               "adventure");
       Books tarzan = new Books(
               -1,
               "Tarzan of the Apes",
               "Edgar Rice Burroughs",
               "This is the story of the ape-man Tarzan, raised in the wild by the great ape Kala, and how he learns the secrets of the jungle to survive—how to talk with the animals, swing through the trees, and fight the great predators.",
               "english",
               "adventure");

       Boolean i1 = b.createBooks(across_asia_on_a_bicycle);
       Boolean i2 = b.createBooks(journey);
       Boolean i3 = b.createBooks(cleopatra);
       Boolean i4 = b.createBooks(king_of_solomon);
       Boolean i5 = b.createBooks(tarzan);












       if(i1 && i2 && i3 && i4 && i5)Toast.makeText(this, "Books Added", Toast.LENGTH_SHORT).show();
       Toast.makeText(this, "Failed to AddBook", Toast.LENGTH_SHORT).show();
   }

    public void openLogin(){
        Button login =  findViewById(R.id.login);
        Button signup =  findViewById(R.id.signup);
        Intent goToLogin = new Intent(this, com.example.jason_valley.login.login.class);
        Intent goToSignup = new Intent(this, com.example.jason_valley.login.signup.class);
        //route
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToLogin);
            }});
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   startActivity(goToSignup);}});
    }

}