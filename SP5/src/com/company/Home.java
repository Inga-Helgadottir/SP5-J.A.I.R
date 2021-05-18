package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
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
   private JButton trial;
   private JLabel background= new JLabel();
   private JLabel label ;

   public void homeFrame() {
      setSize(700,700);
      setTitle("Movie dictionary");
      setVisible(true);
      setLocation(400,400);
      this.setLayout(new GridBagLayout());

      this.setPreferredSize(new Dimension(1064, 600));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setLayout(null);
      setLayout(new FlowLayout());
      JLabel LI = new JLabel();
      LI.setSize(500,500);


      c = getContentPane();
      c.setLayout(null);
      c.add(LI);
      name = new JLabel("Welcome to Movie dictionary");
      name.setFont(new Font("Arial", Font.PLAIN, 40));
      name.setForeground(Color.RED);
      name.setSize(900, 100);
      name.setLocation(400, 300);
      c.add(name);
      title= new JLabel("Movie dictionary");
      title.setFont(new Font("Arial", Font.PLAIN, 20));
      title.setSize(900, 100);
      title.setForeground(Color.BLUE);
      title.setLocation(300, 50);
      c.add(title);

      sub = new JButton("Sign in");
      sub.setFont(new Font("Arial", Font.PLAIN, 15));
      sub.setSize(100, 20);
      sub.setLocation(50, 50);

      sub.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            SignIn signIn= new SignIn();
            signIn.sign();
            dispose();

         }
      });
      LI.add(sub);
      setVisible(true);
      trial = new JButton("Start your fre trial");
      trial.setFont(new Font("Arial", Font.PLAIN, 15));
      trial.setForeground(Color.BLUE);
      trial.setSize(250, 20);
      trial.setLocation(550, 400);
      trial.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Form f = new Form();
            f.MyFrame();
            dispose();

         }
      });
      c.add(trial);

      setVisible(true);

   }

   public void actionPerformed(ActionEvent e) {


   }
}


