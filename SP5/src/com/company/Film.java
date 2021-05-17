package com.company;

import java.util.ArrayList;

public class Film {
    private int id;
    private String title;

    public String getSummary() {
        return summary;
    }

    private String summary;
    private String releaseDate;
    private String imgPath;
    private ArrayList<String> directors;
    private ArrayList<String> actors;
    private ArrayList<String> genres;

    public Film(int id, String title, String summary, String releaseDate, String imgPath){
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getImgPath() {
        return imgPath;
    }

    public ArrayList<String> getDirectors() {
        return directors;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }
}