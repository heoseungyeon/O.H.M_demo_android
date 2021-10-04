package com.example.myapplication;

public class MyBuildingListData {
    private int buildingImage;
    private String address;

    public MyBuildingListData(int buildingImage, String address) {
        this.buildingImage = buildingImage;
        this.address = address;
    }

    public int getBuildingImage() {
        return buildingImage;
    }

    public void setBuildingImage(int buildingImage) {
        this.buildingImage = buildingImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
