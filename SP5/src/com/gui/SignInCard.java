package com.gui;

import com.company.DBConnector;

import javax.swing.*;

public class SignInCard {

   public static JPanel createSignInCard(){
    JPanel signInCard = new JPanel();
      //todo: Remove or style the placeholder button
      JButton placeholderBtn = new JButton("Go to signUp");

      placeholderBtn.addActionListener(e -> {
         GUI.outSideAppContentLayout.show(GUI.outsideAppCard, "SIGN_UP_CARD");
      });

      signInCard.add(placeholderBtn); // todo: Remove

    return signInCard;
   }

}
