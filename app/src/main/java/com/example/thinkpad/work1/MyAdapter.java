package com.example.thinkpad.work1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2016/10/10.
 */

public class MyAdapter extends BaseAdapter {
    String[]  mData;
    LayoutInflater inflater;

    public MyAdapter(String[] mData, LayoutInflater inflater) {
        this.mData = mData;
        this.inflater = inflater;
    }

    @Override

    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_title, null);
        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        tv_title.setText(mData[position]);

        return convertView;
    }
}
