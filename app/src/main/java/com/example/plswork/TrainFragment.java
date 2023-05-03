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


    Button WhatIsDSB, WhatIsMidttrafik, RejsekortTopUp, WhichCardisRight, HowDoIUseTravelCard, GetTravelCard, WhatCanYouDo, HowDoYouPay, WhatCanYouDoDSB, HowDoYouPayDSB, HowDoIBuyTickets;

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
        WhatIsMidttrafik = (Button) getView().findViewById(R.id.WhatIsMidttrafik);
        WhatIsDSB = (Button) getView().findViewById(R.id.WhatIsDSB);

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
        WhatIsDSB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Dialog_10(); }
        });
        WhatIsMidttrafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { Dialog_11(); }
        });
    }



    public void Dialog_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Which card is right for me?")
                .setMessage("There is a wide selection of Rejsekort cards that you can choose from depending on your needs. Rejsekort.dk has a guide that can help you choose the correct Rejsekort based on a few questions. Most will only require the regular Rejsekort, but if you are young, and are travelling regularly from one place to another, studying etc. there may be better options for you!")
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
                .setMessage("How do I use my travel card? \n" +
                        "\n" +
                        "With a Rejsekort, you must begin all journeys by checking in through a check-in card reader, which are placed outside, on a peron. If you change the means of transportation during your journey, you must remember to check in again. \n" +
                        "At the end of your journey, you must check out through a check-out card reader.  \n" +
                        "For more information visit: ")
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
        builder.setTitle("What can you do with the Midttrafik app?")
                .setMessage("You can pay for your travel and look up your journey via the Journey Planner (Rejseplanen) to help plan your trip. This will provide you with an overview of arrivals and departures of the transport options suitable for your route. \n" +
                        "\n" +
                        "\tYou can also download Midttrafik live, where you can “trace” busses in real time. ")
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
                .setMessage("You can top up your Rejsekort either by making a top up agreement or by manually depositing money on your card. This can be done at the Rejsekort self-service webpage, or by visiting a physical Rejsekort vending machine at a train station. Please note that if you use the webpage it can take up to 24 hours for your funds to become available on your card.  \n" +
                        "For more information visit: ")
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
        builder.setTitle("How do you pay with the Midttrafik app?")
                .setMessage("First you must choose what kind of ticket or travel pass you wish to purchase, then you must select how many zones (minimum 2) you wish to travel. Enter the date and time of depature and then press 'fortsæt' and then 'godkend køb'. You can pay either by card or with Mobilepay (Danish mobile phone transaction app).  For more information visit the website")
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
        builder.setTitle("What can you do with the DSB app?")
                .setMessage("You can plan journeys and buy tickets with the DSB app, there are different tickets that vary in price. Some of the cheaper tickets are DSB Orange or DSB Orange Fri, which are bought in advance if available. You can also reserve a seat in a different seating zone, such as standard zone, family zone or silent zone. For more information go to the website")
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
        builder.setTitle("How do you pay with the DSB app?")
                .setMessage("First you must select at route. Then you must choose ticket type and finally you can choose to reserve a seat. Lastly you must accept terms and conditions and then you choose a method of payment before entering the relevant payment information. You can pay either by card or with Mobilepay (Danish mobile phone transaction app). For more information go to the website")
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
                .setMessage("You can pay by cash or card in either one of the physical ticket machines at train stations - these accept Danish coins and at selected stations you can also pay with banknotes, or you can pay by cash or card in the integrated kiosk (7/11) that is located inside the train station. ")
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
    public void Dialog_10() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("What is DSB?")
                .setMessage("DSB (Danske Stats Baner) is the national application for travelling by train in Denmark. You will need it when you travel outside of your region by train. You can buy cheaper orange tickets, if you order them in good time. ")
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
    public void Dialog_11() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("What is Midttrafik?")
                .setMessage("Every Danish region has their own traffic company with their own traffic app. The Midttrafik app is your regional travel app for the Midtjylland region and can be used to plan travels within the region.  ")
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
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}