package com.example.marcus.letsquitsmoking.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.marcus.letsquitsmoking.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Points extends android.app.Fragment {

    TextView points;

    Context appContext;
    public Points() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //appContext.getSh
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        points = (TextView) view.findViewById(R.id.getPoints);
        /////////////////////////////////////////////
        SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
        int xy = pref.getInt("FIRST",12);
        String sata = pref.getString("date","");
        /////////////////////////////////////////////
        //points.setText(Integer.toString(xy));
        points.setText(sata);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.appContext=context;
    }
}

