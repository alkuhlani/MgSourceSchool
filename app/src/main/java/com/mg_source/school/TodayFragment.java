package com.mg_source.school;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class TodayFragment extends Fragment {
//

    public TodayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);

        String[] material = {new String(getString(R.string.holyhuran)),
                new String(getString(R.string.arabic)),
                new String(getString(R.string.english)),
                new String(getString(R.string.math))};

        // Inflate the layout for this fragment
        ListView listView = (ListView) view.findViewById(R.id.today_listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                material);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), SplashActivity.class));
                    case 1:
                        startActivity(new Intent(getActivity(), SplashActivity.class));
                    case 2:
                        startActivity(new Intent(getActivity(), SplashActivity.class));
                    case 3:
                        startActivity(new Intent(getActivity(), SplashActivity.class));
                }
            }
        });
        return view;
    }


}
