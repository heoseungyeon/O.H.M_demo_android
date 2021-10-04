package com.example.myapplication;

public class DetailData {
    private String title;
    private String description;
    private int year;
    private int percent;
    private String recentDate;
    private DetailTextWatcher detailTextWatcher;

    public DetailData(String title, String description, int year, int percent, String recentDate) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.percent = percent;
        this.recentDate = recentDate;
    }

    public DetailData(String title, String description, int year, int percent) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.percent = percent;
    }

    public DetailData(String title, String description, DetailTextWatcher detailTextWatcher) {
        this.title = title;
        this.description = description;
        this.detailTextWatcher = detailTextWatcher;
    }

    public DetailData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public DetailTextWatcher getDetailTextWatcher() {
        return detailTextWatcher;
    }

    public void setDetailTextWatcher(DetailTextWatcher detailTextWatcher) {
        this.detailTextWatcher = detailTextWatcher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getRecentDate() {
        return recentDate;
    }

    public void setRecentDate(String recentDate) {
        this.recentDate = recentDate;
    }
}
