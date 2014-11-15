package com.witmergers.interfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by WP8Dev on 16-11-2014.
 */
public class AnotherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.another_activity);
        Intent intent = getIntent();
        int data = intent.getIntExtra("pos",0);

        FragmentB fragmentB = (FragmentB)getFragmentManager().findFragmentById(R.id.fragment_b);
        fragmentB.change(data);

    }
}
