package com.company;

import com.gui.GUI;
import java.util.ArrayList;

public class Main {

    public static User currentUser;
    public static ArrayList<Film> films;

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createAppWindow();
    }

}
