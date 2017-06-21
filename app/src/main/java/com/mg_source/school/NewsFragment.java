package com.mg_source.school;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    String[] date_ = {"10-6-2017", "9-6-2017", "6-6-2017", "3-6-2017"};


//    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
//    SimpleAdapter adapter;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] _news = {new String(getString(R.string.parentCouncil)),
                new String(getString(R.string.bazaar)),
                new String(getString(R.string.honoring)),
                new String(getString(R.string.trip))};
        //
        int[] imgs = {R.drawable.fathers,
                R.drawable.bazarstudent,
                R.drawable.thanksstudent,
                R.drawable.tripstudent};
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ListView listView = (ListView) view.findViewById(R.id.news_listView);
        ArrayList<NewsListItem> listnews = new ArrayList<NewsListItem>();

        List ls = new ArrayList();
        for (int i = 0; i < date_.length; i++) {
            listnews.add(new NewsListItem(i, _news[i], imgs[i]));
        }

        ListAdapter ad = new ListViewAdapter_(listnews);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name = (TextView) view.findViewById(R.id.new_txt);
                Toast.makeText(getActivity(), name.getText(), Toast.LENGTH_SHORT).show();
            }
        });
//        HashMap<String, String> map = new HashMap<String, String>();
//        for (int i = 0; i < _news.length; i++) {
//            map = new HashMap<String, String>();
//            map.put("new", _news[i]);
//            map.put("img", Integer.toString(imgs[i]));
//            data.add(map);
//        }
//
//        String[] from = {"new_", "img"};
//        int[] to = {R.id.new_txt, R.id.new_img};

        // Inflate the layout for this fragment

//        adapter = new SimpleAdapter(getActivity(), data, R.layout.new_row, from, to);
//        setListAdapter(adapter);


//        return super.onCreateView(inflater, container, savedInstanceState);

        return view;
    }

    //    @Override
//    public void onStart() {
//        super.onStart();
//        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), data.get(position).get("new_"), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    class ListViewAdapter_ extends BaseAdapter {
        ArrayList<NewsListItem> listItems = new ArrayList<NewsListItem>();

        ListViewAdapter_(ArrayList<NewsListItem> listItems) {
            this.listItems = listItems;

        }

        @Override
        public int getCount() {
            return listItems.size();
        }

        @Override
        public Object getItem(int position) {
            return listItems.get(position).id;

        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = getActivity().getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.new_row, null);
            TextView txt = (TextView) view.findViewById(R.id.new_txt);
            ImageView img = (ImageView) view.findViewById(R.id.new_img);
            TextView id = (TextView) view.findViewById(R.id.new_id);
            id.setText(date_[position]);
            img.setImageResource(listItems.get(position).img);
            txt.setText(listItems.get(position).new_);

            return view;
        }
    }


}
