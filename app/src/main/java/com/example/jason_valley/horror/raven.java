package com.example.jason_valley.horror;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.jason_valley.R;
import com.example.jason_valley.most_popular.across;
import com.github.barteksc.pdfviewer.PDFView;

public class raven extends Fragment {
    PDFView showPdf;
    Button read;
    ScrollView raven;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_raven, container, false);
        showPdf = view.findViewById(R.id.mostlyPDF);
        read = view.findViewById(R.id.read);
        //     ScrollView
        raven = view.findViewById(R.id.raven);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPdf.fromAsset("The-Raven--The-Masque-of-the-Red-Death--The-Cask-of-Amontillado.pdf").load();
                raven.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });

        return view;
    }
}