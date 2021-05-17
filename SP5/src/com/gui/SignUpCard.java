package com.gui;

import com.company.DBConnector;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpCard {

   public static JPanel createSignInCard(){
      JPanel signInCard = new JPanel();

      //todo: Remove or style the placeholder button
      JButton placeholderBtn = new JButton("Cancel signUp");

      placeholderBtn.addActionListener(e -> {
         GUI.outSideAppContentLayout.show(GUI.outsideAppCard, "SIGN_IN_CARD");
      });

      signInCard.add(placeholderBtn); //todo: Remove

      return signInCard;
   }

   private boolean checkIfEmailIsValid(String email){
      String regex = "^(.+)@(.+)$";
      Pattern pattern = Pattern.compile(regex);

      Matcher matcher = pattern.matcher(email);

      return matcher.matches(); // Returns true is the email matches the pattern else false
   }

}
