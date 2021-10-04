package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DetailTextWatcher implements TextWatcher {

    private int year;
    private int percent;
    private String preText;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
    private EditText editText;
    private String tag;
    private View view;
    private ViewGroup viewGroup;

    public DetailTextWatcher(int year, int percent) {
        this.year = year;
        this.percent = percent;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    public void setViewGroup(ViewGroup viewGroup) {
        this.viewGroup = viewGroup;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int before, int count) {
        preText = s.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        System.out.println("getTag() : "+this.editText.getTag());
        if (checkDate(s.toString())) {
            System.out.println("changedTrue");
            LocalDate ld = LocalDate.parse(s.toString(),
                    DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            System.out.println(ld.getYear() + year + "." + ld.getMonth() + "." + ld.getDayOfMonth());
            this.editText.setText(ld.getYear() + year + "." + ld.getMonth() + "." + ld.getDayOfMonth());
        } else {
            System.out.println("false");
            this.editText.setText("잘못된 날짜 형식입니다");
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void afterTextChanged(Editable editable) {
        System.out.println("changed");
        if (checkDate(editable.toString())) {
            System.out.println("changedAfterTrue");
            LocalDate ld = LocalDate.parse(editable.toString(),
                    DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            this.editText.setText(ld.getYear() + year + "." + ld.getMonth() + "." + ld.getDayOfMonth());
        } else {
            System.out.println("false");
            this.editText.setText("잘못된 날짜 형식입니다");
        }
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
