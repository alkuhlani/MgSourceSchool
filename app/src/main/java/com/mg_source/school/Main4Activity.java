package com.mg_source.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        String[] scTitles = {new String(getString(R.string.sc01)),
                new String(getString(R.string.sc02)),
                new String(getString(R.string.sc03)),
                new String(getString(R.string.sc04))};
        String[] scDesc = {new String(getString(R.string.sc1)),
                new String(getString(R.string.sc2)),
                new String(getString(R.string.sc3)),
                new String(getString(R.string.sc4))};
        Log.e("0", "0");
        ListView listView = (ListView) findViewById(R.id.scListView);
        Log.e("0", "1");
        ArrayList<Stuednt_Com> listSC = new ArrayList<Stuednt_Com>();
        Log.e("0", "2");
        int[] imgs = {R.drawable.sc,
                R.drawable.scc,
                R.drawable.sccc,
                R.drawable.scccc};

        Log.e("0", "3");
        for (int i = 0; i < imgs.length; i++) {
            listSC.add(new Stuednt_Com(imgs[i], scTitles[i], scDesc[i]));
        }
        Log.e("0", "4");
        ListAdapter ad = new ListViewSC(listSC);
        Log.e("0", "5");
        listView.setAdapter(ad);
    }

    class ListViewSC extends BaseAdapter {

        ArrayList<Stuednt_Com> listItems = new ArrayList<Stuednt_Com>();

        ListViewSC(ArrayList<Stuednt_Com> listItems) {
            this.listItems = listItems;
            Log.e("1", "0");
        }

        @Override
        public int getCount() {
            Log.e("1", "1");
            return listItems.size();

        }

        @Override
        public Object getItem(int position) {
            Log.e("1", "2");
            return listItems.get(position).getImg();

        }

        @Override
        public long getItemId(int position) {
            Log.e("1", "3");
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.e("1", "4");
            LayoutInflater layoutInflater = getLayoutInflater();
            Log.e("1", "5");
            View view = layoutInflater.inflate(R.layout.student_comu_row, null);
            Log.e("1", "6");
            TextView title = (TextView) view.findViewById(R.id.sc_title_txt);
            Log.e("1", "7");
            TextView desc = (TextView) view.findViewById(R.id.sc_desc_txt);
            Log.e("1", "8");
            ImageView img = (ImageView) view.findViewById(R.id.sc_img);
            Log.e("1", "9");
            title.setText(listItems.get(position).getTitle());
            Log.e("1", "10");
            desc.setText(listItems.get(position).getDesc());
            img.setImageResource(listItems.get(position).getImg());

            return view;
        }
    }
}
