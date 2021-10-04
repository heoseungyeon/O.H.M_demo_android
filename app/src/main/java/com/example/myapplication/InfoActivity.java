package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    ArrayList<MyBuildingListData> myBuildingListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        this.InitializeMovieData();

        ListView listView = (ListView) findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this, myBuildingListData);

        listView.setAdapter(myAdapter);

        ImageButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
        public void InitializeMovieData ()
        {
            myBuildingListData = new ArrayList<MyBuildingListData>();

            myBuildingListData.add(new MyBuildingListData(R.drawable.orm1, "서울 노원구 공릉로 231"));
            myBuildingListData.add(new MyBuildingListData(R.drawable.orm1, "서울 노원구 공릉로 232"));
            myBuildingListData.add(new MyBuildingListData(R.drawable.orm1, "서울 노원구 공릉로 233"));
        }
    }