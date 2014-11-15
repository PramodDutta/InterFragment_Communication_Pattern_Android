package com.witmergers.interfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements  FragmentA.Communicator{

    FragmentA fragmentA;
    FragmentB fragmentB;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getFragmentManager();
        fragmentA = (FragmentA)fragmentManager.findFragmentById(R.id.fragment_a);
        fragmentA.setCommunicator(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void respond(int data) {

        fragmentB = (FragmentB)fragmentManager.findFragmentById(R.id.fragment_b);
        int config = getResources().getConfiguration().orientation;

        if( config == Configuration.ORIENTATION_LANDSCAPE) {
            if (fragmentB != null && fragmentB.isVisible()) {

                fragmentB.change(data);
            }
        }
        if(config == Configuration.ORIENTATION_PORTRAIT)
        {

            Intent intent = new Intent(this,AnotherActivity.class);
            intent.putExtra("pos",data);
            startActivity(intent);

        }

    }
}
