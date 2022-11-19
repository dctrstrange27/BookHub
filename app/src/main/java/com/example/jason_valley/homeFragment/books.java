package com.example.jason_valley.homeFragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_valley.R;
import com.example.jason_valley.computer.crack;
import com.example.jason_valley.computer.economy;
import com.example.jason_valley.db.DataBase;
import com.example.jason_valley.front.front;
import com.example.jason_valley.horror.color;
import com.example.jason_valley.horror.invi;
import com.example.jason_valley.horror.raven;
import com.example.jason_valley.most_popular.across;
import com.example.jason_valley.most_popular.beach;
import com.example.jason_valley.most_popular.comp;
import com.example.jason_valley.most_popular.dracula;
import com.example.jason_valley.most_popular.king_solomon;
import com.example.jason_valley.most_popular.les;
import com.example.jason_valley.most_popular.mostly;
import com.example.jason_valley.most_popular.sher;
import com.example.jason_valley.recommended.alice;
import com.example.jason_valley.recommended.cleo;
import com.example.jason_valley.recommended.coming;
import com.example.jason_valley.recommended.fly;
import com.example.jason_valley.recommended.hacker;
import com.example.jason_valley.recommended.tarzan;
import com.example.jason_valley.usermodel.Books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class books extends Fragment {
    ScrollView book;
    HorizontalScrollView hori;
    HorizontalScrollView hori2;
    HorizontalScrollView hori3;
    HorizontalScrollView hori4;
    CardView king;
    CardView across;
    CardView cleo;
    CardView tarzan;
    CardView journey;
    //horror
    CardView beach;
    CardView color;
    CardView mostly;
    CardView invi;
    CardView raven;
    //fiction
    CardView alice;
    CardView dracu;
    CardView fly;
    CardView les;
    CardView sher;

    //computer
    CardView crack;
    CardView hacker;
    CardView economy;
    CardView coming;
    CardView jargon;





    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_books, container, false);
//        Button viewBooks = v.findViewById(R.id.view);
        //Adventure Books
        DataBase b = new DataBase(v.getContext());
        List<Books> books =  b.getAllBooks();
        List<String> title = new ArrayList<>();
        List<String> author = new ArrayList<>();
        List<String> desc = new ArrayList<>();
        List<String> lang = new ArrayList<>();
        List<String> cat = new ArrayList<>();
        hori = v.findViewById(R.id.hori);
        hori2 = v.findViewById(R.id.hori2);
        hori3 = v.findViewById(R.id.hori3);
        hori4 = v.findViewById(R.id.hori4);
        hori.scrollTo(hori.getRight()/2,0);

        ViewTreeObserver vto = hori.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                hori.scrollTo(hori.getChildAt(0).getWidth()/3, 0);
                hori2.scrollTo(hori2.getChildAt(0).getWidth()/10, 0);
                hori3.scrollTo(hori3.getChildAt(0).getWidth()/20, 0);
                hori4.scrollTo(hori4.getChildAt(0).getWidth()/2, 0);
            }
        });


        book = v.findViewById(R.id.books);

        //adventure
        king = v.findViewById(R.id.king);
        cleo = v.findViewById(R.id.cleo);
        tarzan = v.findViewById(R.id.tarzan);
        across = v.findViewById(R.id.across);
        journey = v.findViewById(R.id.journey);

        //horror
        beach = v.findViewById(R.id.beach);
        color = v.findViewById(R.id.color);
        mostly = v.findViewById(R.id.mostly);
        invi = v.findViewById(R.id.invi);
        raven = v.findViewById(R.id.raven);

        //Fiction
        alice = v.findViewById(R.id.alice);
        dracu = v.findViewById(R.id.dracu);
        fly = v.findViewById(R.id.fly);
        les = v.findViewById(R.id.les);
        sher = v.findViewById(R.id.sher);

        crack = v.findViewById(R.id.crack);
        hacker = v.findViewById(R.id.hacker);
        economy = v.findViewById(R.id.economy);
        coming = v.findViewById(R.id.coming);
        jargon = v.findViewById(R.id.jargon);


        for(int i = 0; i < books.size(); i++){
            title.add(books.get(i).getTitle());
            author.add(books.get(i).getAuthor());
            desc.add(books.get(i).getDescription());
            lang.add(books.get(i).getLanguage());
            cat.add(books.get(i).getCategory());
        }

        king.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, king_solomon.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        cleo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, cleo.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });
        across.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, across.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });
        tarzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, tarzan.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });
        //horror

        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, beach.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, color.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        invi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, raven.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });
        mostly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, mostly.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        raven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, invi.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        //fiction

        alice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, alice.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        dracu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, dracula.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        fly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.fly.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });
        les.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, les.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        sher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, sher.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });



        //computer

        crack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.computer.crack.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        economy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.computer.economy.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        hacker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, hacker.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });
        coming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.coming.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });

        jargon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, comp.class, null).commit();
                book.setVisibility(View.GONE);
            }
        });
















        return  v;
    }
}