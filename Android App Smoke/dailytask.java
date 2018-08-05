package com.example.marcus.letsquitsmoking.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.marcus.letsquitsmoking.R;

import java.util.HashSet;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyTask extends android.app.Fragment{

    Context appContext;
    Button task1, task2, task3, task4, task5, taskBonus;
    public String list[] =
            {
                "Watch a funny movie on TV",
                "Read a book",
                "Clean out a closet in the house",
                "Get your camera out and take some pictures",
                "Do a jigsaw puzzle or find one online at Jigzone.com",
                "Do a crossword puzzle",
                "Go for a walk",
                "work out",
                "Take a day trip",
                "Play outdoor games",
                "Watch the sunset",
                "Practice smiling in the mirror",
                "Practice meditation",
                "Do some deep breathing for a few minutes",
                "Listen to a relaxation tape or some favorite music"
            };

    public DailyTask() {
        // Required empty public constructor


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_daily_activity,container,false);
        task1 = (Button)view.findViewById(R.id.buttonTask1);
        task2 = (Button)view.findViewById(R.id.buttonTask2);
        task3 = (Button)view.findViewById(R.id.buttonTask3);
        task4 = (Button)view.findViewById(R.id.buttonTask4);
        task5 = (Button)view.findViewById(R.id.buttonTask5);
        taskBonus = (Button)view.findViewById(R.id.buttonTaskBonus);

        int number, smokingLimit = 5;
        int duplicate[] = new int[5];
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();

        final SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
        int shuffle = pref.getInt("flagShuffle",0);

        Log.d("flagShuffle outside if",pref.getInt("flagShuffle",0)+"");
        if(shuffle == 1){

            Log.d("flagShuffle value",shuffle+"");
            while (set.size()<5){
                number = random.nextInt(15);
                set.add(number);
            }

            int i =0;
            for (int randomNumbers:set){
                duplicate[i] = randomNumbers;
                i++;
            }
//            task2.setText(list[duplicate[0]]+" : 20 PTS");
//            task3.setText(list[duplicate[1]]+ " : 15 PTS");
//            task4.setText(list[duplicate[2]]+ " : 10 PTS");
//            task5.setText(list[duplicate[3]]+ " : 5 PTS");
//            taskBonus.setText(list[duplicate[4]]+ " : 20 PTS");
            ///// storing shulled task////////////
            pref.edit().putString("tb2", list[duplicate[0]]).apply();
            pref.edit().putString("tb3", list[duplicate[1]]).apply();
            pref.edit().putString("tb4", list[duplicate[2]]).apply();
            pref.edit().putString("tb5", list[duplicate[3]]).apply();
            pref.edit().putString("tbB", list[duplicate[4]]).apply();
            /// flag for green/////

            pref.edit().putInt("flagShuffle", 0).apply();
            pref.edit().commit();
        }

        task2.setText(pref.getString("tb2","")+" : 20 PTS");
        task3.setText(pref.getString("tb3","")+ " : 15 PTS");
        task4.setText(pref.getString("tb4","")+ " : 10 PTS");
        task5.setText(pref.getString("tb5","")+ " : 5 PTS");
        taskBonus.setText(pref.getString("tbB","")+ " : 20 PTS");
        task1.setText("Smoke not more than " + smokingLimit + " cigarettes today! : 25 PTS" );

        if(pref.getInt("ta1",0)==2){
            task1.setBackground(getResources().getDrawable(R.drawable.rb_green));
            String cemp = task1.getText().toString();
            task1.setText(cemp+" Completed");
        }
        if(pref.getInt("ta2",0)==2){
            task2.setBackground(getResources().getDrawable(R.drawable.rb_green));
            String cemp = task2.getText().toString();
            task2.setText(cemp+" Completed");
        }
        if(pref.getInt("ta3",0)==2){
            task3.setBackground(getResources().getDrawable(R.drawable.rb_green));
            String cemp = task3.getText().toString();
            task3.setText(cemp+" Completed");
        }
        if(pref.getInt("ta4",0)==2){
            task4.setBackground(getResources().getDrawable(R.drawable.rb_green));
            String temp = task4.getText().toString();
            task4.setText(temp+" Completed");
        }
        if(pref.getInt("ta5",0)==2){
            task5.setBackground(getResources().getDrawable(R.drawable.rb_green));
            String temp = task5.getText().toString();
            task5.setText(temp+" Completed");
        }
        if(pref.getInt("ta6",0)==2){
            taskBonus.setBackground(getResources().getDrawable(R.drawable.rb_green));
            String temp = taskBonus.getText().toString();
            taskBonus.setText(temp+" Completed");
        }

        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pref.getInt("ta1",0)==1){
                    SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editShPr = pref.edit();
                    task1.setBackground(getResources().getDrawable(R.drawable.rb_green));
                    String temp = task1.getText().toString();
                    task1.setText(temp+" Completed");
                    int xy = pref.getInt("FIRST",0);
                    xy += 25;
                    editShPr.putInt("FIRST",xy);
                    editShPr.putInt("ta1",2);
                    editShPr.apply();
                    editShPr.commit();
                }

            }
        });

        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
                SharedPreferences.Editor editShPr = pref.edit();
                if(pref.getInt("ta2",0)==1){
                    task2.setBackground(getResources().getDrawable(R.drawable.rb_green));
                    String temp = task2.getText().toString();
                    task2.setText(temp+" Completed");
                    int xy = pref.getInt("FIRST",0);
                    xy += 20;
                    editShPr.putInt("FIRST",xy);
                    editShPr.putInt("ta2",2);
                    editShPr.apply();
                }
                editShPr.commit();
            }
        });

        task3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
                SharedPreferences.Editor editShPr = pref.edit();
                if(pref.getInt("ta3",0)==1){
                    task3.setBackground(getResources().getDrawable(R.drawable.rb_green));
                    String temp = task3.getText().toString();
                    task3.setText(temp+" Completed");
                    int xy = pref.getInt("FIRST",0);
                    xy += 15;
                    editShPr.putInt("FIRST",xy);
                    editShPr.putInt("ta3",2);
                    editShPr.apply();
                    editShPr.commit();
                }
            }
        });

        task4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
                SharedPreferences.Editor editShPr = pref.edit();
                if(pref.getInt("ta4",0)==1){
                    task4.setBackground(getResources().getDrawable(R.drawable.rb_green));
                    String temp = task4.getText().toString();
                    task4.setText(temp+" Completed");
                    int xy = pref.getInt("FIRST",0);
                    xy += 10;
                    editShPr.putInt("FIRST",xy);
                    editShPr.putInt("ta4",2);
                    editShPr.apply();
                }
                editShPr.commit();
            }
        });

        task5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
                SharedPreferences.Editor editShPr = pref.edit();
                if(pref.getInt("ta5",0)==1){
                    task5.setBackground(getResources().getDrawable(R.drawable.rb_green));
                    String temp = task5.getText().toString();
                    task5.setText(temp+" Completed");
                    int xy = pref.getInt("FIRST",0);
                    xy += 5;
                    editShPr.putInt("FIRST",xy);
                    editShPr.putInt("ta5",2);
                    editShPr.apply();
                }
                editShPr.commit();
            }
        });

        taskBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = appContext.getSharedPreferences("MYFIRSTPREFE", Context.MODE_PRIVATE);
                SharedPreferences.Editor editShPr = pref.edit();
                if(pref.getInt("ta6",0)==1){
                    taskBonus.setBackground(getResources().getDrawable(R.drawable.rb_green));
                    String temp = taskBonus.getText().toString();
                    taskBonus.setText(temp+" Completed");
                    int xy = pref.getInt("FIRST",0);
                    xy += 20;
                    editShPr.putInt("FIRST",xy);
                    editShPr.putInt("ta6",2);
                    editShPr.apply();
                }
                editShPr.commit();
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.appContext=context;
    }
}

