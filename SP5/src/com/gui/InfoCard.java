package com.gui;

import com.company.Film;

import javax.swing.*;

public class InfoCard {

   public static JPanel createInfoCard(Film film){
      JPanel infoCard = new JPanel();
      infoCard.setBackground(ColorManager.paleYellow);

      return infoCard;
   }
}
