package com.example.bekgrace.habshamusic.Main_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bekgrace.habshamusic.Melody_songs.Songs_Main_Activity;
import com.example.bekgrace.habshamusic.R;
import com.example.bekgrace.habshamusic.Scale_Activities.Scale_MainActivity;

import customfonts.MyTextView;

public class Menu_Activity extends AppCompatActivity {

    MyTextView learn_scales, practice_ear, melody_songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);
        ui_Setup();

        learn_scales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Activity.this, Scale_MainActivity.class);
                startActivity(intent);
            }
        });

        melody_songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Activity.this, Songs_Main_Activity.class);
                startActivity(intent);
            }
        });

        practice_ear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu_Activity.this, Scale_MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void ui_Setup(){
        learn_scales = (MyTextView)findViewById(R.id.learn_scales);
        practice_ear = (MyTextView)findViewById(R.id.practice_ear);
        melody_songs = (MyTextView)findViewById(R.id.melody_songs);
    }

}
