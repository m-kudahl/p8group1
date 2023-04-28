package com.example.plswork;

import static com.example.plswork.R.id.cardEducation;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class EssentialsTab extends Fragment {

    CardView cardViewEducation;
    CardView cardViewNemKonto;
    CardView cardViewMitID;
    CardView cardViewBenefits;
    CardView cardViewEboks;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_essentials_tab, container, false);


        cardViewEducation = view.findViewById(R.id.cardEducation);
        cardViewNemKonto = view.findViewById(R.id.cardNemKonto);
        cardViewMitID = view.findViewById(R.id.cardMitID);
        cardViewBenefits = view.findViewById(R.id.cardBenefits);
        cardViewEboks = view.findViewById(R.id.cardEboks);
        cardViewEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EducationHomeActivity.class));
            }

        });

        cardViewNemKonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), NemKontoPage.class));
            }

        });

        cardViewMitID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MitIDpage.class));
            }

        });

        cardViewBenefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), BenefitsPage.class));
            }

        });

        cardViewEboks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EBoksPage.class));
            }

        });



    return view;
    }


}