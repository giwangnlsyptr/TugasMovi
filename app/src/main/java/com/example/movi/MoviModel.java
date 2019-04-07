package com.example.movi;

public class MoviModel {
    private String title;
    private int poster;

    public MoviModel(String title, int poster) {
        this.title = title;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public int getPoster() {
        return poster;
    }
}

