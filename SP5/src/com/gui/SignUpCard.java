package com.gui;

import com.company.DBConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpCard {
   private Container c;
   private static JLabel title;
   private static JLabel signInTitle;
   private static JLabel name;
   private static JTextField textFieldName;
   private static JLabel email;
   private static JTextField textFieldemail;
   private static JLabel passwordLabel;
   private static JPasswordField textPasswordField;
   private static JLabel success;
   private static JLabel success1;
   private JLabel add;;
   private static JButton sub;
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
   private static JTextField userText;
   private static JButton alreadyHaveAccount;
   private static JButton notAlreadyHaveAccount;
   private static JButton button;
   private static JPasswordField passwordText;
   private static JButton signIn;
   private JButton signout;

   public static JPanel createSignInCard(){
      JPanel c = new JPanel();
      c.setLayout(null);
      title = new JLabel("Create an account");
      title.setFont(new Font("Arial", Font.PLAIN, 30));
      title.setForeground(Color.red);
      title.setSize(300, 50);
      title.setLocation(100, 30);
      c.add(title);
      name = new JLabel("Name");
      name.setFont(new Font("Arial", Font.PLAIN, 20));
      name.setSize(100, 20);
      name.setLocation(100, 100);
      c.add(name);
      textFieldName = new JTextField();
      textFieldName.setFont(new Font("Arial", Font.PLAIN, 15));
      textFieldName.setSize(190, 20);
      textFieldName.setLocation(200, 100);
      c.add(textFieldName);
      email= new JLabel("E-mail");
      email.setFont(new Font("Arial", Font.PLAIN, 20));
      email.setSize(100, 20);
      email.setLocation(100, 200);
      c.add(email);
      textFieldemail = new JTextField();
      textFieldemail.setFont(new Font("Arial", Font.PLAIN, 15));
      textFieldemail.setSize(190, 20);
      textFieldemail.setLocation(200, 200);
      c.add(textFieldemail );
      passwordLabel = new JLabel("Password");
      passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
      passwordLabel.setSize(100, 20);
      passwordLabel.setLocation(100, 300);
      c.add(passwordLabel);
      textPasswordField = new JPasswordField();
      textPasswordField.setFont(new Font("Arial", Font.PLAIN, 20));
      textPasswordField.setSize(200, 20);
      textPasswordField .setLocation(200, 300);
      c.add(textPasswordField);
      sub = new JButton("Create an account");
      sub.setFont(new Font("Arial", Font.PLAIN, 15));
      sub.setSize(200, 20);
      sub.setLocation(400, 350);
      c.add(sub);
      JLabel alreadyAccount = new JLabel("Already have an account");
      alreadyAccount.setSize(600,30);
      alreadyAccount.setLocation(100,400);
      c.add(alreadyAccount);
      alreadyHaveAccount = new JButton("Return to signIn page");
      alreadyHaveAccount.setFont(new Font("Arial", Font.PLAIN, 15));
      alreadyHaveAccount.setSize(150, 20);
      alreadyHaveAccount.setLocation(100, 430);

      alreadyHaveAccount.addActionListener(e -> {
         GUI.outSideAppContentLayout.show(GUI.outsideAppCard, "SIGN_IN_CARD");
      });

      c.add(alreadyHaveAccount);
      success1= new JLabel("");
      success1.setBounds(10, 130, 300, 25);
      success1.setLocation(100,360);
      success1.setForeground(Color.red);
      c.add(success1);

      sub.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String user = textFieldName.getText();
            String email = textFieldemail.getText();
            String password = textPasswordField.getText();

            if(user.equals("") || email.equals("") || password.equals("")){
               success1.setText("Please fill out all the input fields...");
            }else if(!checkIfEmailIsValid(email)){
               success1.setText("The provided email was not valid. Please check it again...");
            }else{
               DBConnector.signUp(email, password, user);
               success1.setText("You have now been successfully registered!");

               textPasswordField.setText("");
               textFieldName.setText("");
               textFieldemail.setText("");
            }
         }
      });

      return c;
   }

   private static boolean checkIfEmailIsValid(String email){
      String regex = "^(.+)@(.+)$";
      Pattern pattern = Pattern.compile(regex);

      Matcher matcher = pattern.matcher(email);

      return matcher.matches(); // Returns true if the email matches the pattern else false
   }

}
