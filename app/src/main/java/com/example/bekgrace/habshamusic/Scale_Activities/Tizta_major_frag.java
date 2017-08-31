package com.example.bekgrace.habshamusic.Scale_Activities.Scale_Fragements;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.bekgrace.habshamusic.R;
import com.example.bekgrace.habshamusic.Scale_Activities.SuperAwesomeCardFragment;


public class Tizta_major_frag extends SuperAwesomeCardFragment {

    // player
    private SeekBar songProgressBar;
    private MediaPlayer mp;
    private ImageButton playScale;
    private Handler mHandler = new Handler();

    //Slider layout
    SliderLayout sliderShow;

    // Buttons
    Button chords_on_piano;
    Button chords_on_guitar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tizta_major_, container, false);
        songProgressBar = (SeekBar) view.findViewById(R.id.songProgressBar);
        playScale = (ImageButton) view.findViewById(R.id.btn_play);

        //buttons
        chords_on_guitar = (Button)view.findViewById(R.id.chords_on_Guitar);
        chords_on_piano = (Button)view.findViewById(R.id.chords_on_Piano);

        // set Progress bar values
        songProgressBar.setProgress(0);
        songProgressBar.setMax(100);

        playScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playScale();
            }
        });

        // set Up slider
        sliderShow = (SliderLayout) view.findViewById(R.id.slider_tizta);
        sliderShow.stopAutoCycle();
        setUpSlider();

        // set up button pop up dialog
        chords_on_guitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("tizta_major_on_Guitar");
            }
        });

        chords_on_piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("tizta_major_on_piano");
            }
        });
        return view;
    }

    public void showImage(String detail){
        FragmentManager fm = getActivity().getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        com.example.bekgrace.habshamusic.Scale_Activities.Scale_Fragements.FullScren_image_fragment frag = com.example.bekgrace.habshamusic.Scale_Activities.Scale_Fragements.FullScren_image_fragment.newInstance(detail);
        frag.show(fm,"tag_me");
    }

    public static Tizta_major_frag newInstance() {

        Bundle args = new Bundle();

        Tizta_major_frag fragment = new Tizta_major_frag();
        fragment.setArguments(args);
        return fragment;
    }

    public void setUpSlider(){
        TextSliderView textSliderView = new TextSliderView(getActivity());
        textSliderView
                .description("Notes on middle C")
                .image(R.drawable.tizeta_notes_middle_c);

        sliderShow.addSlider(textSliderView);

        TextSliderView textSliderView_on_piano = new TextSliderView(getActivity());
        textSliderView_on_piano
                .description("On Piano")
                .image(R.drawable.tizta_major_c);

        sliderShow.addSlider(textSliderView_on_piano);

        TextSliderView textSliderView_on_guitar = new TextSliderView(getActivity());
        textSliderView_on_guitar
                .description("On Guitar")
                .image(R.drawable.tizeta_major_scale_guitar);

        sliderShow.addSlider(textSliderView_on_guitar);

    }

    public void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100);
    }

    public int getProgressPercentage(long currentDuration, long totalDuration){
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage =(((double)currentSeconds)/totalSeconds)*100;

        // return percentage
        return percentage.intValue();
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            long totalDuration = mp.getDuration();
            long currentDuration = mp.getCurrentPosition();
            // Updating progress bar
            int progress = (int)(getProgressPercentage(currentDuration, totalDuration));

            songProgressBar.setProgress(progress);

            // Running this thread after 100 milliseconds
            mHandler.postDelayed(this, 10);
        }
    };

    public void playScale(){
        mp = MediaPlayer.create(getActivity(), R.raw.acoustic_blues_scale);
        mp.start();
        updateProgressBar();
    }

}
