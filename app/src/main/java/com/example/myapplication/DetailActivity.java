package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ArrayList<DetailData> detailData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.InitializeMovieData();

        ListView listView = (ListView) findViewById(R.id.detailListView);
        final DetailAdapter detailAdapter = new DetailAdapter(this, detailData);

        listView.setAdapter(detailAdapter);
    }

    private void InitializeMovieData() {
        detailData = new ArrayList<DetailData>();

        detailData.add(new DetailData("모르타르 마감" + "-" + "지붕", "전면수리 -------- 10년 / 100%",new DetailTextWatcher(10,100)));
        detailData.add(new DetailData("고분자도막방수" + "-" + "지붕", "전면수리 -------- 15년 / 100%",new DetailTextWatcher(15,100)));
        detailData.add(new DetailData("고분자시트방수" + "-" + "지붕", "전면수리 -------- 20년 / 100%",new DetailTextWatcher(20,100)));
        detailData.add(new DetailData("금속기와 잇기" + "-" + "지붕", "부분수리 -------- 5년 / 10%",new DetailTextWatcher(5,100)));
        detailData.add(new DetailData("아스팔트 슁글 잇기" + "-" + "지붕", "부분수리 -------- 5년 / 10%",new DetailTextWatcher(5,100)));
        detailData.add(new DetailData("돌 붙이기" + "-" + "외부", "부분수리 -------- 25년 / 5%",new DetailTextWatcher(25,100)));
        detailData.add(new DetailData("수성페인트칠" + "-" + "외부", "전면도장 -------- 5년 / 100%",new DetailTextWatcher(5,100)));
        detailData.add(new DetailData("출입문(자동문)" + "-" + "외부 창/문", "전면교체 -------- 15년 / 100%",new DetailTextWatcher(15,100)));

    }
}