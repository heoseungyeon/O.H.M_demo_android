package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<DetailData> sample;

    public DetailAdapter(Context context, ArrayList<DetailData> data) {
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
    public DetailData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.detail_list_layout, null);

        TextView titleView = (TextView)view.findViewById(R.id.titleTV);
        TextView descriptionView = (TextView)view.findViewById(R.id.descriptionTV);
        EditText originTime = (EditText)view.findViewById(R.id.originTimeET);
        EditText postTime = (EditText)view.findViewById(R.id.postTimeET);

        titleView.setText(sample.get(position).getTitle());
        descriptionView.setText(sample.get(position).getDescription());
        DetailTextWatcher detailTextWatcher = sample.get(position).getDetailTextWatcher();
        detailTextWatcher.setEditText(postTime);
        originTime.addTextChangedListener(detailTextWatcher);

        return view;
    }
}