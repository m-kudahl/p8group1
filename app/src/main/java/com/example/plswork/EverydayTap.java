package com.example.plswork;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class EverydayTap extends Fragment {

    CardView cardViewTransport;
    CardView cardViewHelth;
    CardView cardViewWork;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_everyday_tap, container, false);

        cardViewTransport = view.findViewById(R.id.cardTransport);
        cardViewHelth = view.findViewById(R.id.cardHelth);
        cardViewWork = view.findViewById(R.id.cardWork);

        cardViewTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainTransport.class));
            }

        });

        cardViewHelth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Tab_Layout.class));
            }

        });

        cardViewWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Tab_Layout.class));
            }

        });
        return view;
    }
}