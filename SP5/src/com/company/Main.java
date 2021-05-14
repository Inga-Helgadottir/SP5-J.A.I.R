package com.company;

import java.util.ArrayList;

public class Main {
    public static User currentUser = null;
    public static ArrayList<Film> films;

    public static void main(String[] args) {
        SignIn signIn = new SignIn();
        signIn.sign();
    }

    public static void startMenu(){

    }
}
/*
To do:
 - Beslut hvordan resten af projektet skal se ud
 - Flyt login til databasen
 - Lav klasserne færdige
 */
