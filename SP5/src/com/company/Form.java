package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form extends JFrame implements ActionListener {
   private Container c;
   private JLabel title;
   private JLabel name;
   private JTextField textFieldName;
   private JLabel email;
   private JTextField textFieldemail;
   private JLabel passwordLabel;
   private JPasswordField textPasswordField;
   private JLabel success;
   private JLabel add;;
   private JButton sub;
   private JPanel background;
   private JLabel label ;
   public void MyFrame() {
      setTitle("Movie dictionary");
      setBounds(300, 90, 900, 600);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(700, 700);

      c = getContentPane();
      c.setLayout(null);
      title = new JLabel("Registration Form");
      title.setFont(new Font("Arial", Font.PLAIN, 30));
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
      email= new JLabel("e-mail");
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
      sub = new JButton("Submit");
      sub.setFont(new Font("Arial", Font.PLAIN, 15));
      sub.setSize(100, 20);
      sub.setLocation(100, 350);
      sub.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

         }
      });
      c.add(sub);
      success = new JLabel("");
      success.setSize(600,30);
      success.setLocation(100,400);
      c.add(success);
      label= new JLabel("");

      setVisible(true);

   }

   public void actionPerformed(ActionEvent e) {
      String user = textFieldName.getText();
      String email = textFieldemail.getText();
      String passeword = textPasswordField.getText();
      success.setText("Registration Successfully.");
      textPasswordField.setText("");
      textFieldName.setText("");
      textFieldemail.setText("");

   }
}