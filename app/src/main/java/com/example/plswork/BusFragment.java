package com.example.plswork;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class BusFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    Button RejsekortTopUp;
    Button WhichCardisRight;
    Button HowDoIUseTravelCard;
    Button GetTravelCard;
    Button WhatCanYouDo;
    Button HowDoYouPay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_bus, container, false);

        View view = inflater.inflate(R.layout.fragment_bus, container, false);

        Spinner spinner = view.findViewById(R.id.RegionSpinner);
        ArrayAdapter<CharSequence> RegionAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.RegionSpinner_values, android.R.layout.simple_spinner_item);
        RegionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(RegionAdapter);
        spinner.setOnItemSelectedListener(this);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RejsekortTopUp = (Button) getView().findViewById(R.id.RejsekortTopUp);
        WhichCardisRight = (Button) getView().findViewById(R.id.WhichCardisRight);
        HowDoIUseTravelCard = (Button) getView().findViewById(R.id.HowDoIUseTravelCard);
        GetTravelCard = (Button) getView().findViewById(R.id.GetTravelCard);
        WhatCanYouDo = (Button) getView().findViewById(R.id.WhatCanYouDo);
        HowDoYouPay = (Button) getView().findViewById(R.id.HowDoYouPay);

        RejsekortTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.rejsekort.dk/Hjaelp/Betaling");
            }
        } );

        //WhichCardisRight.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        gotoUrl("https://www.rejsekort.dk/Screening/Bestil-et-kort/Hvem-skal-bruge-rejsekortet");
        //    }
        //});
        HowDoIUseTravelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.rejsekort.dk/Hjaelp/Saadan-rejser-du");
            }
        });
        GetTravelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.rejsekort.dk/Bestil");
            }
        });
        WhatCanYouDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.midttrafik.dk/billetter-og-priser/midttrafik-app/");
            }
        });
        HowDoYouPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.midttrafik.dk/billetter-og-priser/midttrafik-app/sadan-gor-du/");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Alert Dialog")
                .setMessage("This is an alert dialog window in a fragment.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the OK button is clicked
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}