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


public class TrainFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    Button RejsekortTopUp, WhichCardisRight, HowDoIUseTravelCard, GetTravelCard, WhatCanYouDo, HowDoYouPay, WhatCanYouDoDSB, HowDoYouPayDSB, HowDoIBuyTickets;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_bus, container, false);

        View view = inflater.inflate(R.layout.fragment_train, container, false);

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
        WhatCanYouDoDSB = (Button) getView().findViewById(R.id.WhatCanYouDoDSB);
        HowDoYouPayDSB = (Button) getView().findViewById(R.id.HowDoYouPayDSB);
        HowDoIBuyTickets = (Button) getView().findViewById(R.id.HowDoIBuyTickets);

        RejsekortTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_5();
            }
        } );
        HowDoIUseTravelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_2();
            }
        });
        GetTravelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_3();
            }
        });
        WhatCanYouDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_4();
            }
        });
        HowDoYouPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_6();
            }
        });
        WhichCardisRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_1();
            }
        });
        WhatCanYouDoDSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Dialog_7(); }
        });
        HowDoYouPayDSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Dialog_8(); }
        });
        HowDoIBuyTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Dialog_9(); }
        });
    }



    public void Dialog_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Which card is right for me?")
                .setMessage("There are many different types of travel cards. If you have trouble deciding which one to get, you can use the Rejsekort tool to figure it out")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/Screening/Bestil-et-kort/Hvem-skal-bruge-rejsekortet";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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

    public void Dialog_2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("How do I use my travel card?")
                .setMessage("You must check in on the blue point in the bus, and then you must also check out at another blue point in the bus before leaving")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/Hjaelp/Saadan-rejser-du?sc_lang=en";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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
    public void Dialog_3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Get travel card")
                .setMessage("Use the Rejsekort website to order a travel card")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/Bestil?sc_lang=en";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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

    public void Dialog_4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("What can you do with the app?")
                .setMessage("You can use the app to buy different types of tickets as well as a travel pass")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.midttrafik.dk/english/tickets/midttrafik-app/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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

    public void Dialog_5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("How do I top up my travel card?")
                .setMessage("You can either use the Rejsekort self-service or a rejsekort vending machine located at a train station. For more information visit Rejsekort.dk")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/Hjaelp/Betaling?sc_lang=en";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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

    public void Dialog_6() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("How do you pay with the app?")
                .setMessage("First you must choose what kind of ticket or travel pass you wish to purchase, then you must select how many zones (minimum 2) you wish to travel. Enter the date and time of depature and then press 'fortsæt' and then 'godkend køb' For more information visit the website")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.midttrafik.dk/english/tickets/midttrafik-app/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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

    public void Dialog_7() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("What can you do with the app?")
                .setMessage("With the DSB app you can buy tickets, travel passes and plan a route. For more information go to the website")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.dsb.dk/find-produkter-og-services/dsb-app/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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

    public void Dialog_8() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("How do you pay with the app?")
                .setMessage("First you must select at route. Then you must choose ticket type and finally you can choose to reserve a seat. Lastly you must accept terms and conditions and then you choose a method of payment before entering the relevant payment information. For more information go to the website")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.dsb.dk/find-produkter-og-services/dsb-app/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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
    public void Dialog_9() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("How do I buy tickets?")
                .setMessage("You can buy a train ticket using the vending machines located at train stations. Depending on which company owns the vending machines your options for payment may vary. All of them accept credit card, but only DSB and some local vending machines accept cash in the form of coins. For more information visit the DSB website.")
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.dsb.dk/kundeservice/las-mere-om-billetautomaterne2/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
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