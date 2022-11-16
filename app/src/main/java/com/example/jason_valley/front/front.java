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
import com.example.jason_valley.databinding.ActivityMainBinding;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.login.dialog;
import com.example.jason_valley.login.signup;
import com.example.jason_valley.usermodel.Books;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;

public class front extends AppCompatActivity {

    TextInputEditText title, author, description, language,category ;
    ImageView picture;
    Button add;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.front);

       ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
//
//        title = findViewById(R.id.title);
//        author = findViewById(R.id.author);
//        description = findViewById(R.id.desc);
//        language = findViewById(R.id.lang);
//        category = findViewById(R.id.cat);
//        add = findViewById(R.id.add);
//        category = findViewById(R.id.cat);
            openLogin();
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });
    }
    //creating books
//   public void createBooks(){
//        String tit = title.getText().toString();
//       String aut = author.getText().toString();
//       String desc = description.getText().toString();
//       String lang = language.getText().toString();
//       String cat = category.getText().toString();
//
//       String path = "storage/self/primary/DCIM/Camera/"+tit+".jpg";
//       DataBase b = new DataBase(front.this);
//       Bitmap bitmap = BitmapFactory.decodeFile(path);
//       ByteArrayOutputStream byt = new ByteArrayOutputStream();
//       bitmap.compress(Bitmap.CompressFormat.PNG,0, byt);
//       byte[] img = byt.toByteArray();
//       Books book = new Books(-1,tit,aut,desc,null,lang,cat);
//       Boolean ins = b.createBooks(book,img);
//
//       if(ins) Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show();
//       else Toast.makeText(this, "Failed to AddBook", Toast.LENGTH_SHORT).show();
//   }

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