package com.company;

import java.util.ArrayList;

public class User {
    private int id;
    private String email;
    private String password;
    private String name;

    private ArrayList<Film> likedFilms = new ArrayList<Film>();

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // For user created by data from database
    public User(int id, String email, String name){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Film> getLikedFilms() {
        return likedFilms;
    }

    public void setLikedFilms(Film film)
    {
        this.likedFilms.add(film);
    }
}
