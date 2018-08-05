package com.example.marcus.letsquitsmoking.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.marcus.letsquitsmoking.R;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rank extends android.app.Fragment {

    Context appContext;
    TextView rank,next,nxtrnk,progCur,progNe;
    Button share;
    ShareDialog shareDialog;
    ProgressBar progressBar;
    ImageView imageRa;

    public Rank() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        FacebookSdk.sdkInitialize(appContext.getApplicationContext());
        rank = (TextView)view.findViewById(R.id.currentRank);
        next = (TextView)view.findViewById(R.id.nextRank);
        nxtrnk = (TextView)view.findViewById(R.id.nxtrank);
        share = (Button)view.findViewById(R.id.buttonShare);
        progressBar = (ProgressBar)view.findViewById(R.id.progressPoint);
        progCur = (TextView)view.findViewById(R.id.curpoint);
        progNe = (TextView)view.findViewById(R.id.nxtpoint);
        imageRa = (ImageView)view.findViewById(R.id.imageRank);

        shareDialog = new ShareDialog(this);

        SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
        final int xy = pref.getInt("FIRST",12);
        if(xy>=0 && xy<100){
            rank.setText("PRIVATE SOLDIER");
            next.setText("PRIVATE FIRST CLASS");
            progNe.setText("100 Points");
            imageRa.setImageResource(R.drawable.private_soldier);
        }
        else if(xy>=100 && xy<200){
            rank.setText("PRIVATE FIRST CLASS");
            next.setText("SPECIALIST");
            progNe.setText("200 Points");
            imageRa.setImageResource(R.drawable.private_one);
        }
        else if(xy>=200 && xy<300){
            rank.setText("SPECIALIST");
            next.setText("SERGEANT");
            progNe.setText("300 Points");
            imageRa.setImageResource(R.drawable.specialist);
        }
        else if(xy>=300 && xy<400){
            rank.setText("SERGEANT");
            next.setText("LIEUTENANT");
            progNe.setText("400 Points");
            imageRa.setImageResource(R.drawable.sergent);
        }
        else if(xy>=400 && xy<500){
            rank.setText("SERGEANT");
            next.setText("LIEUTENANT");
            progNe.setText("500 Points");
            imageRa.setImageResource(R.drawable.sergent);
        }
        else if(xy>=500 && xy<600){
            rank.setText("LIEUTENANT");
            next.setText("CAPTAIN");
            progNe.setText("600 Points");
            imageRa.setImageResource(R.drawable.liutenant);
        }
        else if(xy>=600 && xy<700){
            rank.setText("LIEUTENANT");
            next.setText("CAPTAIN");
            progNe.setText("700 Points");
            imageRa.setImageResource(R.drawable.liutenant);
        }
        else if(xy>=700 && xy<800){
            rank.setText("CAPTAIN");
            next.setText("MAJOR");
            progNe.setText("800 Points");
            imageRa.setImageResource(R.drawable.captain);
        }
        else if(xy>=800 && xy<900){
            rank.setText("CAPTAIN");
            next.setText("MAJOR");
            progNe.setText("900 Points");
            imageRa.setImageResource(R.drawable.captain);
        }
        else if(xy>=900 && xy<1000){
            rank.setText("MAJOR");
            next.setText("COMMANDER");
            progNe.setText("1000 Points");
            imageRa.setImageResource(R.drawable.major);
        }
        else if(xy>=1000){
            rank.setText("COMMANDER");
            next.setText("");
            nxtrnk.setText("");
            progNe.setText("MAXIMUM");
            imageRa.setImageResource(R.drawable.commander);
        }
        int k = xy/100;
        int g = xy - k*100;

        progCur.setText("Gained Points: "+Integer.toString(xy));
        if(xy <1000){
            progressBar.setProgress(g);
        }
        else if(xy>=1000){
            progressBar.setProgress(100);
        }

        final int r = xy;

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setQuote("Earned "+ Integer.toString(r)+" points in Let's Quit Smoking and Ranked "+rank.getText()+".")
                        .setContentUrl(Uri.parse("https://www.youtube.com/watch?v=FvUnEphzl2E"))
                        .build();
                if(ShareDialog.canShow(ShareLinkContent.class)){
                    shareDialog.show(content);
                }
            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.appContext=context;
    }

}

