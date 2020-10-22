package com.example.ptimanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


public class PdfFragment extends Fragment {

    PDFView pdfView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_pdf, container, false);
        pdfView=v.findViewById(R.id.pdfView);
        pdfView.fromAsset("Bangla PK.pdf").load();
        return v;
    }
}