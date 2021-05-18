package com.gui;

import com.company.DBConnector;
import com.company.Film;
import com.company.Main;

import javax.swing.*;
import java.awt.*;

public class InfoCard {

   public static JPanel createInfoCard(Film film){
      JPanel infoCard = new JPanel(new GridLayout(1, 2));
      infoCard.setBackground(ColorManager.paleYellow);

      String font = "MV Bold";
      JPanel panel = new JPanel();
      panel.setLocation(0, 0);
      panel.setBackground(ColorManager.white);

      JPanel panel2 = new JPanel() {
         @Override
         public Dimension getPreferredSize() {
            return new Dimension(400, 500);
         }
      };

      panel2.setBackground(ColorManager.white);

      if(film != null){
         panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
         panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));

         JLabel img = new JLabel(new ImageIcon(film.getImgPath()));

         JLabel label = new JLabel(film.getTitle());
         label.setFont(new Font(font, Font.BOLD, 25));

         JLabel year = new JLabel("Release date : " + film.getReleaseDate());
         year.setFont(new Font(font, Font.LAYOUT_LEFT_TO_RIGHT, 17));

         String[] arr = splitAboutText(film.getSummary());

         JLabel about = new JLabel(arr[0]);
         about.setFont(new Font(font, Font.LAYOUT_LEFT_TO_RIGHT, 20));

         JLabel about2 = new JLabel(arr[1]);
         about2.setFont(new Font(font, Font.LAYOUT_LEFT_TO_RIGHT, 20));

         JLabel about3 = new JLabel(arr[2]);
         about3.setFont(new Font(font, Font.LAYOUT_LEFT_TO_RIGHT, 20));

         JLabel about4 = new JLabel(arr[3]);
         about4.setFont(new Font(font, Font.LAYOUT_LEFT_TO_RIGHT, 20));

         GUI g = new GUI();
         JButton likedBtn = g.createNavBtn("src\\img\\navIcons\\thumbs-up-solid.png");
         JButton unLikedBtn = g.createNavBtn("src\\img\\navIcons\\thumbs-down-solid.png");

         int currentUserId = Main.currentUser.getId();

         likedBtn.addActionListener(e -> {
            DBConnector db = new DBConnector();
            db.addToLikedList(film.getId(), currentUserId);
         });

         unLikedBtn.addActionListener(e -> {
            DBConnector db = new DBConnector();
            db.removeFromLikedList(film.getId(), currentUserId);
         });

         panel.add(img);
         panel2.add(label);
         panel2.add(about);
         panel2.add(about2);
         panel2.add(about3);
         panel2.add(about4);
         panel2.add(year);
         panel2.add(likedBtn);
         panel2.add(unLikedBtn);

         infoCard.add(panel, BorderLayout.WEST);
         infoCard.add(panel2, BorderLayout.WEST);
         infoCard.setVisible(true);
      }

      return infoCard;
   }

   public static String[] splitAboutText(String str) {
      int len = str.length();
      int n = 4;
      int temp = 0, chars = len / n;
      String[] equalStr = new String[n];

      if (len % n != 0) {
         System.out.println("Sorry this string cannot be divided into " + n + " equal parts.");
      } else {
         for (int i = 0; i < len; i = i + chars) {
            String part = str.substring(i, i + chars);
            equalStr[temp] = part;
            temp++;
         }
      }
      return equalStr;
   }
}
