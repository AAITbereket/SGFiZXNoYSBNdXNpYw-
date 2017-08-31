package com.example.bekgrace.habshamusic.Scale_Activities.Scale_Fragements;

import android.app.DialogFragment;
import android.graphics.Point;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.bekgrace.habshamusic.R;

public class FullScren_image_fragment extends DialogFragment {

    public ImageView image;

    public static FullScren_image_fragment newInstance(String argument1){

            if(argument1.equals("tizta_major_on_piano")){
                FullScren_image_fragment ret = new FullScren_image_fragment()
                        {
                            @Override
                            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                                if (getDialog() != null) {
                                    getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                                    getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                                }
                                View root = inflater.inflate(R.layout.my_fragment, container, false);
                                image = (ImageView) root.findViewById(R.id.main_image);
                                image.setImageResource(R.drawable.tizta_major_chords_on_piano);
                                return root;
                            }
                        };
                return ret;
        }
        else if(argument1.equals("tizta_major_on_Guitar")){
                FullScren_image_fragment ret = new FullScren_image_fragment()
                {
                    @Override
                    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                        if (getDialog() != null) {
                            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        }
                        View root = inflater.inflate(R.layout.my_fragment, container, false);
                        image = (ImageView) root.findViewById(R.id.main_image);
                        image.setImageResource(R.drawable.tizta_major_chords_on_guitar);
                        return root;
                    }
                };
                return ret;
        }
        else if (argument1.equals("dorian_on_piano")){

        }

        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.MY_DIALOG);
    }

    @Override
    public void onStart() {
        super.onStart();
        // change dialog width
        if (getDialog() != null) {

            int fullWidth = getDialog().getWindow().getAttributes().width;

            Display display = getActivity().getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            fullWidth = size.x;

            final int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                    .getDisplayMetrics());

            int w = fullWidth - padding;
            int h = getDialog().getWindow().getAttributes().height;

            getDialog().getWindow().setLayout(w, h);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (getDialog() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }

        View root = inflater.inflate(R.layout.my_fragment, container, false);

        image = (ImageView) root.findViewById(R.id.main_image);

        return root;
    }

}
