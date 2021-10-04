package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ArrayList<DetailData> detailData1;
    ArrayList<DetailData> detailData2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.InitializeButtonData1();
        this.InitializeButtonData2();

        ListView listView = (ListView) findViewById(R.id.detailListView);
        final DetailAdapter detailAdapter1 = new DetailAdapter(this, detailData1);
        final DetailAdapter detailAdapter2 = new DetailAdapter(this, detailData2);

        listView.setAdapter(detailAdapter1);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(detailAdapter1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(detailAdapter2);
            }
        });

    }

    private void InitializeButtonData1() {
        detailData1 = new ArrayList<DetailData>();

        detailData1.add(new DetailData("지붕"+" - "+"모르타르 마감", "전면수리 -------- 10년 / 100%",10,100,"1993.08.27"));
        detailData1.add(new DetailData("지붕"+" - "+"고분자도막방수", "전면수리 -------- 15년 / 100%",15,100,"1998.08.27"));
        detailData1.add(new DetailData("지붕"+" - "+"고분자시트방수", "전면수리 -------- 20년 / 100%",20,100,"2003.08.27"));
        detailData1.add(new DetailData("지붕"+" - "+"금속기와 잇기", "부분수리 -------- 5년 / 10%",5,100,"1988.08.27"));
        detailData1.add(new DetailData("지붕"+" - "+"아스팔트 슁글 잇기", "부분수리 -------- 5년 / 10%",5,100,"1998.08.27"));
        detailData1.add(new DetailData("외부"+" - "+"돌 붙이기", "부분수리 -------- 25년 / 5%",25,100,"2008.08.27"));
        detailData1.add(new DetailData("외부"+" - "+"수성페인트칠", "전면도장 -------- 5년 / 100%",5,100,"1988.08.27"));
        detailData1.add(new DetailData("외부 창/문"+" - "+"출입문(자동문)", "전면교체 -------- 15년 / 100%",15,100,"1998.08.27"));

    }

    private void InitializeButtonData2() {
        detailData2 = new ArrayList<DetailData>();

        detailData2.add(new DetailData("천장"+" - "+"수성도료칠", "전면도장 -------- 10년 / 100%",5,100,"1993.08.27"));
        detailData2.add(new DetailData("천장"+" - "+"유성도료칠", "전면도장 -------- 15년 / 100%",5,100,"1998.08.27"));
        detailData2.add(new DetailData("천장"+" - "+"합성수지도료칠", "전면도장 -------- 20년 / 100%",5,100,"2003.08.27"));
        detailData2.add(new DetailData("내벽"+" - "+"수성도료칠", "전면도장 -------- 5년 / 10%",5,100,"1988.08.27"));
        detailData2.add(new DetailData("내벽"+" - "+"유성도료칠", "전면도장 -------- 5년 / 10%",5,100,"1998.08.27"));
        detailData2.add(new DetailData("내벽"+" - "+"합성수지도료칠", "전면도장 -------- 25년 / 5%",5,100,"2008.08.27"));
        detailData2.add(new DetailData("바닥"+" - "+"지하주차장(바닥)", "부분수리 -------- 5년 / 100%",15,50,"1988.08.27"));
        detailData2.add(new DetailData("계산"+" - "+"계단논슬립", "전면교체 -------- 15년 / 100%",20,100,"1998.08.27"));
        detailData2.add(new DetailData("계산"+" - "+"유성페인트칠", "전면도장 -------- 15년 / 100%",5,100,"1998.08.27"));

    }
}