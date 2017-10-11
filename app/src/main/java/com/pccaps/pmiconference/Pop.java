package com.pccaps.pmiconference;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;


import static com.pccaps.pmiconference.Tab3.list;
import static com.pccaps.pmiconference.Tab3.popChoice;

/**
 * Created by User1 on 10/3/2017.
 */

public class Pop extends Activity{

    TextView textView;
//<<<<<<< HEAD
//=======
    Event jim = new Event("Jim", 3, 5, "Library", "PMI", "", 5,3);
//>>>>>>> 6b47ae8283a8ffb7774146bf266de8141c556fe8

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width =dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout(width,height);

        textView = (TextView) findViewById(R.id.poptext);
        textView.setText(String.valueOf(list.get(popChoice)));

    }
}
