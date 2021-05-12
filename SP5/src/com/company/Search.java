package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    DBConnector db = new DBConnector();

    public void findFilmByName(String name){
        db.getFilmByName(name);
    }

    public void seeAllFilms(){
        db.seeAllFilms();
    }

//    public ArrayList<Film> getAllFilmsofGenre(){
//
//    }
}
