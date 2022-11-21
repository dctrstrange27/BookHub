package com.example.jason_valley.recommended;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.jason_valley.R;
import com.github.barteksc.pdfviewer.PDFView;

public class fly extends Fragment {
    PDFView showPdf;
    Button read;
    ScrollView fly;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fly, container, false);
        showPdf = view.findViewById(R.id.mostlyPDF);
        read = view.findViewById(R.id.read);
        //     ScrollView
        fly = view.findViewById(R.id.fly);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPdf.fromAsset("fly.pdf").load();
                fly.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });

        return view;
    }
}