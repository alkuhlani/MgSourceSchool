package com.mg_source.school;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialFragment extends Fragment {
    final String[] date_={"10-6-2017","9-6-2017","6-6-2017","3-6-2017"};

    public MaterialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_material, container, false);


        String[] _news = {new String(getString(R.string.parentCouncil)),
                new String(getString(R.string.bazaar)),
                new String(getString(R.string.honoring)),
                new String(getString(R.string.trip))};
//
        int[] imgs = {R.drawable.fathers,
                R.drawable.bazarstudent,
                R.drawable.thanksstudent,
                R.drawable.tripstudent};
        // Inflate the layout for this fragment
        ListView listView= (ListView) view.findViewById(R.id.material_listView);
        ArrayList<NewsListItem> listnews = new ArrayList<NewsListItem>();

        for(int i=0;i<date_.length;i++){
            listnews.add(new NewsListItem(i,_news[i],imgs[i]));
        }

        ListAdapter ad=new ListAdapter_(listnews);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView name= (TextView) view.findViewById(R.id.new_txt);
                Toast.makeText(getActivity(),name.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    class ListAdapter_ extends BaseAdapter {
        ArrayList<NewsListItem> listItems = new ArrayList<NewsListItem>();

        ListAdapter_(ArrayList<NewsListItem> listItems) {
            this.listItems = listItems;

        }

        @Override
        public int getCount() {
            return listItems.size();
        }

        @Override
        public Object getItem(int position) {
            return listItems.get(position).new_;

        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater=getActivity().getLayoutInflater();
            View view=layoutInflater.inflate(R.layout.new_row,null);
            TextView txt= (TextView) view.findViewById(R.id.new_txt);
            ImageView img= (ImageView) view.findViewById(R.id.new_img);
            TextView id= (TextView) view.findViewById(R.id.new_id);
            id.setText(date_[position]);
            img.setImageResource(listItems.get(position).img);
            txt.setText(listItems.get(position).new_);

            return view;
        }
    }

}
