package com.witmergers.interfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by WP8Dev on 12-11-2014.
 */
public class FragmentA extends Fragment implements AdapterView.OnItemClickListener

{
    Communicator communicator;
    ListView listVeiw;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_a, container, false);
        listVeiw = (ListView)view.findViewById(R.id.listView1   );
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getActivity(),R.array.chapter,android.R.layout.simple_list_item_1);
        listVeiw.setAdapter(arrayAdapter);
        listVeiw.setOnItemClickListener(this);
        return view;

    }



    public void setCommunicator(Communicator communicator)
    {
        this.communicator = communicator;

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


           communicator.respond(i);

    }


    public interface Communicator
    {

            public void respond(int data);


    }




}
