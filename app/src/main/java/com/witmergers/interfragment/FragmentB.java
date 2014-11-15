package com.witmergers.interfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by WP8Dev on 12-11-2014.
 */
public class FragmentB  extends Fragment{

    TextView t;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b,container,false);
        t = (TextView)view.findViewById(R.id.textView1);
        return view;
    }

    public void change(int a)
    {
     String [] description = getResources().getStringArray(R.array.descriptions);

     t.setText(description[a]);
    }
}

