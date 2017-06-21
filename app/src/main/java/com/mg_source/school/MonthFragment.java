package com.mg_source.school;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonthFragment extends Fragment {


    public MonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_month, container, false);
        String[] material2 = {new String(getString(R.string.holyhuran)),
                new String(getString(R.string.isalmic)),
                new String(getString(R.string.arabic)),
                new String(getString(R.string.english)),
                new String(getString(R.string.math)),
                new String(getString(R.string.science)),
                new String(getString(R.string.medal)),
                new String(getString(R.string.certificate))};


        // Inflate the layout for this fragment
        ListView listView = (ListView) view.findViewById(R.id.month_listView);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                material2);
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
                    case 4:
                        startActivity(new Intent(getActivity(), SplashActivity.class));
                    case 5:
                        startActivity(new Intent(getActivity(), SplashActivity.class));
                }
            }
        });


////////////////////////////


        return view;
    }

}
