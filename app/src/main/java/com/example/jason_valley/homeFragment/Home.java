package com.example.jason_valley.homeFragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.jason_valley.R;
import com.example.jason_valley.most_popular.across;
import com.example.jason_valley.most_popular.beach;
import com.example.jason_valley.most_popular.comp;
import com.example.jason_valley.most_popular.dracula;
import com.example.jason_valley.most_popular.king_solomon;
import com.example.jason_valley.most_popular.mostly;
import com.example.jason_valley.recommended.alice;
import com.example.jason_valley.recommended.cleo;
import com.example.jason_valley.recommended.coming;
import com.example.jason_valley.recommended.fly;
import com.example.jason_valley.recommended.hacker;
import com.example.jason_valley.recommended.tarzan;
import com.github.barteksc.pdfviewer.PDFView;


public class Home extends Fragment {
    ScrollView home;

  //most popular
    CardView king;
    CardView mostly;
    CardView dracu;
    CardView beach;
    CardView across;
    CardView comp;

    CardView coming;
    CardView tarzan;
    CardView cleo;
    CardView hacker;
    CardView alice;
    CardView fly;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_home, container, false);

        //most papular button
         king = view.findViewById(R.id.king);
         mostly = view.findViewById(R.id.mostly);
         dracu = view.findViewById(R.id.dracu);
        beach = view.findViewById(R.id.beach);
        across = view.findViewById(R.id.across);
        comp = view.findViewById(R.id.comp);

        //most papular button
        coming = view.findViewById(R.id.coming);
        tarzan = view.findViewById(R.id.tarzan);
        cleo = view.findViewById(R.id.cleo);
        hacker= view.findViewById(R.id.hacker);
        alice = view.findViewById(R.id.alice);
        fly = view.findViewById(R.id.fly);

        home = view.findViewById(R.id.home);

         //most popular
         king.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, king_solomon.class, null).commit();
                home.setVisibility(View.GONE);
             }
         });
        mostly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, mostly.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        dracu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, dracula.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, beach.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        across.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.most_popular.across.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.most_popular.comp.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });

        /// Recommended
        coming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.coming.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        tarzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.tarzan.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        cleo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.cleo.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        hacker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.hacker.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        alice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.alice.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });
        fly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getChildFragmentManager().beginTransaction().setReorderingAllowed(true).replace(R.id.frag, com.example.jason_valley.recommended.fly.class, null).commit();
                home.setVisibility(View.GONE);
            }
        });













        return view;

    }
}