package com.gui;

import com.company.DBConnector;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignInCard {

   private Container c;
   private JLabel title;
   private static JLabel signInTitle;
   private JLabel name;
   private JTextField textFieldName;
   private JLabel email;
   private JTextField textFieldemail;
   private static JLabel passwordLabel;
   private JPasswordField textPasswordField;
   private static JLabel success;
   private JLabel success1;
   private JLabel add;;
   private JButton sub;
   private JPanel background;
   private JLabel label ;
   private JFrame jFrame;
   private JPanel panel;
   private JPanel panelForm;
   private JPanel panelSignIn;
   private JButton buttonForm;
   private JButton buttonSignin;
   private CardLayout cardLayout;
   private Container container;
   private  JPanel mainPanel;
   private JRadioButton listlabel;
   private static JLabel userlabel;
   static JTextField userText;
   private JButton alreadyHaveAccount;
   private static JButton notAlreadyHaveAccount;
   private static JButton button;
   static JPasswordField passwordText;
   private JButton signIn;
   private JButton signout;

   public static JPanel createSignInCard(){
      JPanel centerPanel = new JPanel();

      centerPanel.setLayout(null);
      signInTitle = new JLabel("Sign in");
      signInTitle.setFont(new Font("Arial", Font.PLAIN, 30));
      signInTitle.setForeground(Color.red);
      signInTitle.setSize(300, 50);
      signInTitle.setLocation(100, 30);
      centerPanel.add(signInTitle);
      userlabel = new JLabel("E-mail");
      userlabel.setFont(new Font("Arial", Font.PLAIN, 20));
      userlabel.setSize(100, 20);
      userlabel.setLocation(100, 100);
      centerPanel.add(userlabel);
      userText = new JTextField();
      userText.setFont(new Font("Arial", Font.PLAIN, 20));
      userText.setSize(190, 20);
      userText.setLocation(200, 100);
      centerPanel.add(userText);
      passwordLabel = new JLabel("Password");
      passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
      passwordLabel.setSize(190, 20);
      passwordLabel.setLocation(100, 200);
      centerPanel.add(passwordLabel);
      passwordText = new JPasswordField();
      passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
      passwordText.setSize(190, 20);
      passwordText.setLocation(200, 200);
      centerPanel.add(passwordText);
      button = new JButton("Sign in");
      button.setFont(new Font("Arial", Font.PLAIN, 15));
      button.setSize(100, 20);
      button.setLocation(400, 250);
      centerPanel.add(button);
      success = new JLabel("");
      success.setBounds(10, 130, 300, 25);
      centerPanel.add(success);
      JLabel notAlreadyAccount = new JLabel(" Don't have an account");
      notAlreadyAccount.setSize(600,30);
      notAlreadyAccount.setLocation(100,300);
      centerPanel.add(notAlreadyAccount);
      notAlreadyHaveAccount = new JButton("Create an account here");
      notAlreadyHaveAccount.setFont(new Font("Arial", Font.PLAIN, 15));
      notAlreadyHaveAccount.addActionListener(e -> {
         GUI.outSideAppContentLayout.show(GUI.outsideAppCard, "SIGN_UP_CARD");
      });
      notAlreadyHaveAccount.setSize(200, 20);
      notAlreadyHaveAccount.setLocation(100, 330);
      centerPanel.add(notAlreadyHaveAccount);

      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String user = userText.getText();
            String password = passwordText.getText();

            if(user.equals("") || password.equals("")){
               success.setText("Please fill out all the input fields...");
            }else{
               Main.currentUser = DBConnector.getUser(user, password);

               if (Main.currentUser == null) {
                  success.setText("Failed to login. Incorrect email or password...");
               } else {
                  GUI.mainAppLayout.show(GUI.appWindow.getContentPane(), "INSIDE_APP_CARD");
               }
            }
         }
      });

      return centerPanel;
   }


}
