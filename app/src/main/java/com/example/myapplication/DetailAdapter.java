package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class DetailAdapter extends BaseAdapter {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.detail_list_layout, null);

        TextView titleView = (TextView) view.findViewById(R.id.titleTV);
        TextView descriptionView = (TextView) view.findViewById(R.id.descriptionTV);
        EditText originTime = (EditText) view.findViewById(R.id.originTimeET);
        EditText postTime = (EditText) view.findViewById(R.id.postTimeET);
        titleView.setText(sample.get(position).getTitle());
        descriptionView.setText(sample.get(position).getDescription());
        LocalDate ld = LocalDate.parse(sample.get(position).getRecentDate(),
                DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        originTime.setText(sample.get(position).getRecentDate());
        postTime.setText(ld.getYear() + sample.get(position).getYear() + "." + ld.getMonthValue() + "." + ld.getDayOfMonth());
//        DetailTextWatcher detailTextWatcher = sample.get(position).getDetailTextWatcher();
//        postTime.setTag("postTime"+position);
//        detailTextWatcher.setView(convertView);
//        detailTextWatcher.setViewGroup(parent);
//        detailTextWatcher.setTag("postTime"+position);
//        detailTextWatcher.setEditText(postTime);
        originTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {
            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (checkDate(s.toString())) {
                    System.out.println("changedTrue");
                    try {
                        LocalDate ld = LocalDate.parse(s.toString(),
                                DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                        System.out.println(ld.getYear() + sample.get(position).getYear() + "." + ld.getMonth().getValue() + "." + ld.getDayOfMonth());
                        postTime.setText(ld.getYear() + sample.get(position).getYear() + "." + ld.getMonthValue() + "." + ld.getDayOfMonth());
                    } catch (DateTimeParseException e) {
                        System.out.println("false");
                        postTime.setText("잘못된 날짜 형식입니다");
                    }
                } else {
                    System.out.println("false");
                    postTime.setText("잘못된 날짜 형식입니다");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (checkDate(editable.toString())) {
                    System.out.println("changedTrue");
                    try {
                        LocalDate ld = LocalDate.parse(editable.toString(),
                                DateTimeFormatter.ofPattern("yyyy.MM.dd"));
                        System.out.println(ld.getYear() + sample.get(position).getYear() + "." + ld.getMonth().getValue() + "." + ld.getDayOfMonth());
                        //originTime.setText(editable.toString());
                        postTime.setText(ld.getYear() + sample.get(position).getYear() + "." + ld.getMonthValue() + "." + ld.getDayOfMonth());
                    } catch (DateTimeParseException e) {
                        System.out.println("false");
                        postTime.setText("잘못된 날짜 형식입니다");
                    }
                } else {
                    System.out.println("false");
                    postTime.setText("잘못된 날짜 형식입니다");
                }
            }
        });
        //originTime.addTextChangedListener(detailTextWatcher);

        return view;
    }

    public static boolean checkDate(String checkDate) {
        try {
            simpleDateFormat.setLenient(false); //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
            simpleDateFormat.parse(checkDate); //대상 값 포맷에 적용되는지 확인
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}