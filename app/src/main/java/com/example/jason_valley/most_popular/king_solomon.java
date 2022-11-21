package com.example.jason_valley.most_popular;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.example.jason_valley.R;
import com.github.barteksc.pdfviewer.PDFView;

public class king_solomon extends Fragment {
    PDFView showPdf;
    Button read;
    ScrollView kingdes;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_king_solomon, container, false);
        showPdf = view.findViewById(R.id.kingPdf);
        read = view.findViewById(R.id.read);
        kingdes = view.findViewById(R.id.kingDes);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPdf.fromAsset("solomon.pdf").load();
                kingdes.setVisibility(View.GONE);
                read.setVisibility(View.GONE);
            }
        });

        return view;
    }
}