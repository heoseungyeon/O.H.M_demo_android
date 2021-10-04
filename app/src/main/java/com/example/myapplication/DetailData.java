package com.example.myapplication;

public class DetailData {
    private String title;
    private String description;
    private DetailTextWatcher detailTextWatcher;

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
}
