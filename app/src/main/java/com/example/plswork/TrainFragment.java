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

        Spinner spinner = view.findViewById(R.id.RegionSpinner);    // Create a spinner with ID of spinner in FragmentTrain.xml
        ArrayAdapter<CharSequence> RegionAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.RegionSpinner_values, android.R.layout.simple_spinner_item);  // Gets values from RegionSpinner_values in strings.xml
        RegionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Sets the layout of the spinner to a simple dropdown menu
        spinner.setAdapter(RegionAdapter);  // Populates the spinner with the data from RegionAdapter
        spinner.setOnItemSelectedListener(this); // Uses method to display selected item
        return view;
    }

    //Initialize buttons using the ID's in fragment_train.xml
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
    //Here we define OnClickListeners for the buttons. When clicked they call a Dialog method
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


    //These are the Dialog methods. When called, they show an alert dialog (popupbox) with a title and message. If the "go to" button is clicked it opens the URL in a web browser
    public void Dialog_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.train_dialog1_title)
                .setMessage(R.string.train_dialog1_message)
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { //WE CAN DELETE WHICH HERE. Which is used to differentiate if there are 3+ buttons, not needed when we have two buttons and the code inside the onClick methods are specific to their button
                        String url = "https://www.rejsekort.dk/en/Screening/Bestil-et-kort/Hvem-skal-bruge-rejsekortet";
                        Intent intent = new Intent(Intent.ACTION_VIEW); // Intent is a messaging object. The .ActionView means that we intend to view something passed to it
                        intent.setData(Uri.parse(url)); //This converts the URL to a Uri object (String object that is an identifier for a resource) and sets the data of the intent to this URI object.
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
        builder.setTitle(R.string.train_dialog2_title)
                .setMessage(R.string.train_dialog2_message)
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
        builder.setTitle(R.string.train_dialog3_title)
                .setMessage(R.string.train_dialog3_message)
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
        builder.setTitle(R.string.train_dialog4_title)
                .setMessage(R.string.train_dialog4_message)
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
        builder.setTitle(R.string.train_dialog5_title)
                .setMessage(R.string.train_dialog5_message)
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
        builder.setTitle(R.string.train_dialog6_title)
                .setMessage(R.string.train_dialog6_message)
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
        builder.setTitle(R.string.train_dialog7_title)
                .setMessage(R.string.train_dialog7_message)
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
        builder.setTitle(R.string.train_dialog8_title)
                .setMessage(R.string.train_dialog8_message)
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
        builder.setTitle(R.string.train_dialog9_title)
                .setMessage(R.string.train_dialog9_message)
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
        builder.setTitle(R.string.train_dialog10_title)
                .setMessage(R.string.train_dialog10_message)
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.dsb.dk/en/about-dsb/";
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
        builder.setTitle(R.string.train_dialog11_title)
                .setMessage(R.string.train_dialog11_message)
                .setPositiveButton("Go to", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.midttrafik.dk/english/customer-service/travel-rules-for-midttrafik/";
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
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) { //method used by the spinner to display the selected item
        String text = parent.getItemAtPosition(i).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}