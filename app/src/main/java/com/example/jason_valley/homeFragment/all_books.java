package com.example.jason_valley.homeFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jason_valley.R;
import com.example.jason_valley.most_popular.les;
import com.example.jason_valley.usermodel.Books;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class all_books extends Fragment {
    PDFView pdf;
    ImageView images;
    TextView title;
    TextView author;
    TextView desc;
    TextView language;
    TextView genre;
    Button read;
    ScrollView all;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_books, container, false);
        pdf = view.findViewById(R.id.pdf);
        images = view.findViewById(R.id.img);
        title = view.findViewById(R.id.tit);
        author = view.findViewById(R.id.author);
        desc = view.findViewById(R.id.descript);
        language = view.findViewById(R.id.lang);
        genre = view.findViewById(R.id.genre);
        read = view.findViewById(R.id.read);
        pdf = view.findViewById(R.id.pdf);
        all = view.findViewById(R.id.all);
        Bundle bundle = this.getArguments();
        title.setText( bundle.getString("title"));
        author.setText(bundle.getString("author"));
        desc.setText(bundle.getString("desc"));
        language.setText(bundle.getString("lang"));
        genre.setText(bundle.getString("genre"));
        images.setImageResource(bundle.getInt("picture"));
        String name = bundle.getString("pdf");


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdf.fromAsset(name+".pdf").load();
                all.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });





        return view;
    }





}