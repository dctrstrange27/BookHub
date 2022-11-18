package com.example.jason_valley.homeFragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.R;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.front.front;
import com.example.jason_valley.usermodel.Books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class books extends Fragment {
    DataBase b;
    List<Books> books =  b.getAllBooks();
    List<String> title = new ArrayList<>();
    List<String> author = new ArrayList<>();
    List<String> desc = new ArrayList<>();
    List<String> lang = new ArrayList<>();
    List<String> cat = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_books, container, false);
//        Button viewBooks = v.findViewById(R.id.view);

        //Adventure Books
        b =  new DataBase(v.getContext());
        setFields();
        TextView adv_1_name = v.findViewById(R.id.adv_1_name);
        adv_1_name.setText(title.get(0));
        return  v;
    }
    public void setFields(){
        for(int i = 0; i < books.size(); i++){
            title.add(books.get(i).getTitle());
            author.add(books.get(i).getAuthor());
            desc.add(books.get(i).getDescription());
            lang.add(books.get(i).getLanguage());
            cat.add(books.get(i).getCategory());
        }

    }
}