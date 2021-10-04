package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MapActivity extends AppCompatActivity {

    private MarkerEventListener markerEventListener = new MarkerEventListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        MapView mapView = new MapView(this);

        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(37.6297118, 127.0763445);
        //true면 앱 실행 시 애니메이션 효과가 나오고 false면 애니메이션이 나오지않음.
        mapView.setMapCenterPoint(mapPoint, true);

        //mapView.setPOIItemEventListener(markerEventListener);
//        // 구현한 CalloutBalloonAdapter 등록
        //mapView.setCalloutBalloonAdapter(new CustomCalloutBalloonAdapter());



        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("맥도날드 과학기술대점");
        marker.setTag(0);
        marker.setMapPoint(mapPoint);
        // 기본으로 제공하는 BluePin 마커 모양.
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        mapView.addPOIItem(marker);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);

        mapViewContainer.addView(mapView);


    }
    // CalloutBalloonAdapter 인터페이스 구현
    class CustomCalloutBalloonAdapter implements CalloutBalloonAdapter {
        private final View mCalloutBalloon;

        public CustomCalloutBalloonAdapter() {
            mCalloutBalloon = getLayoutInflater().inflate(R.layout.balloon_layout, null);
        }

        @Override
        public View getCalloutBalloon(MapPOIItem poiItem) {
            if(poiItem == null) return null;
            ((TextView) mCalloutBalloon.findViewById(R.id.ball_tv_name)).setText(poiItem.getItemName());
            ((TextView) mCalloutBalloon.findViewById(R.id.ball_tv_address)).setText("서울특별시 노원구 공릉동 공릉로 229");
            System.out.println("+"+mCalloutBalloon.toString());
            return mCalloutBalloon;
        }

        @Override
        public View getPressedCalloutBalloon(MapPOIItem poiItem) {
            return null;
        }
    }

    class MarkerEventListener implements MapView.POIItemEventListener {

        @Override
        public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {
            // 마커 클릭 시
            System.out.println("111");
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(intent);
        }

        @Override
        public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {
            // 말풍선 클릭 시 (Deprecated)
            // 이 함수도 작동하지만 그냥 아래 있는 함수에 작성하자
        }

        @Override
        public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
            // 말풍선 클릭 시
            System.out.println("222");
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            startActivity(intent);
        }

        @Override
        public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {
            // 마커의 속성 중 isDraggable = true 일 때 마커를 이동시켰을 경우
        }
    }

}