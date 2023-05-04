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


    Button RejsekortTopUp, WhichCardisRight, HowDoIUseTravelCard, GetTravelCard, WhatCanYouDo, HowDoYouPay, HowDoIBuyTickets, WhatIsMidttrafikBus;

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
        HowDoIBuyTickets = (Button) getView().findViewById(R.id.HowDoIBuyTickets);
        WhatIsMidttrafikBus = (Button) getView().findViewById(R.id.WhatIsMidttrafikBus);

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
            public void onClick(View view) { Dialog_1(); }
        });
        HowDoIBuyTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_9();
            }
        });

        WhatIsMidttrafikBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog_10();
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void Dialog_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.which_card_is_right_for_me)
                .setMessage(R.string.Bus_which_card_is_right_for_me_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/en/Screening/Bestil-et-kort ";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }

    public void Dialog_2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.how_do_i_use_my_travel_card)
                .setMessage(R.string.Bus_how_do_i_use_my_travel_card_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/Hjaelp/Saadan-rejser-du?sc_lang=en";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }

    public void Dialog_5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.how_do_i_top_up_my_travel_card)
                .setMessage(R.string.Bus_how_do_i_top_up_my_travel_card_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/en/hjaelp/betaling ";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }

    public void Dialog_3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.get_travel_card)
                .setMessage(R.string.BUS_get_travel_card_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.rejsekort.dk/Bestil";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }
    public void Dialog_10() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.what_is_midttrafik)
                .setMessage(R.string.what_is_midttrafik_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.midttrafik.dk/billetter-og-priser/midttrafik-app/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }

    public void Dialog_4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.what_can_you_do_with_the_app)
                .setMessage(R.string.what_can_you_do_with_the_app_Midttrafik_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.midttrafik.dk/billetter-og-priser/midttrafik-app/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }



    public void Dialog_6() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.how_do_you_pay_with_the_app)
                .setMessage(R.string.how_do_you_pay_with_the_app_Midttrafik_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.midttrafik.dk/billetter-og-priser/midttrafik-app/sadan-gor-du/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do something when the Cancel button is clicked
                    }
                })
                .show();
    }
    public void Dialog_9() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.how_do_i_buy_tickets)
                .setMessage(R.string.how_do_i_buy_tickets_Midttrafik_MESSAGE)
                .setPositiveButton(R.string.Dialog_go_to, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://www.midttrafik.dk/english/prices/";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.Dialog_cancel, new DialogInterface.OnClickListener() {
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