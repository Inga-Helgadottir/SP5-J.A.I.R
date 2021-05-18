package com.gui;

import javax.swing.*;
import java.awt.*;

public class UserCard {

   public static JPanel createUserCard(){
      JPanel userCard = new JPanel();
      userCard.setLayout(null);
      JLabel jLabelName = new JLabel("Name");
      jLabelName.setFont(new Font("Arial", Font.PLAIN, 30));
      jLabelName.setForeground(Color.black);
      jLabelName.setSize(300, 50);
      jLabelName.setLocation(100, 30);

      JLabel jLabelMail = new JLabel("Mail");
      jLabelMail.setFont(new Font("Arial", Font.PLAIN, 30));
      jLabelMail.setForeground(Color.black);
      jLabelMail.setSize(300, 50);
      jLabelMail.setLocation(100, 100);
      JButton signOut= new JButton("Sign out");
      signOut.setForeground(Color.black);
      signOut.setSize(100, 30);
      signOut.setLocation(100, 170);
      //JLabel jLabelGetName = new JLabel(Main.currentUser.getName());
      //JLabel jLabelGetMail = new JLabel(Main.currentUser.getEmail());
      userCard.setBackground(ColorManager.cyan);
      userCard.add(jLabelName);
      userCard.add(jLabelMail);
      userCard.add(signOut);
      signOut.addActionListener(e -> {
         GUI.outSideAppContentLayout.show(GUI.outsideAppCard, "SIGN_IN_CARD");
      });
      return userCard;
   }
}
