package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<MyBuildingListData> sample;

    public MyAdapter(Context context, ArrayList<MyBuildingListData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public MyBuildingListData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.building_list_layout, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.buildingIV);
        TextView address = (TextView)view.findViewById(R.id.addressTV);

        imageView.setImageResource(sample.get(position).getBuildingImage());
        address.setText(sample.get(position).getAddress());

        Button infoDetailButton = (Button)view.findViewById(R.id.infoDetailButton);
        infoDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext.getApplicationContext(), DetailActivity.class);
                mContext.startActivity(intent);
            }
        });

        return view;
    }
}