package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SignIn implements ActionListener {
    private  static JRadioButton listlabel;
    private static JLabel userlabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private Integer age []= {0,1};

    public void sign() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Sign in");
        frame.setSize(700,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        userlabel= new JLabel("E-mail");
        userlabel.setBounds(10,20,80,25);
        panel.add(userlabel);
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);
        listlabel= new JRadioButton("Ælder end 13 år ");
        listlabel.setBounds(100,80,165,25);
        panel.add(listlabel);
        button = new JButton("Login");
        button.setBounds(10,80,80,25);
        button.addActionListener(new SignIn());
        panel.add(button);
        success = new JLabel("");
        success.setBounds(10,130,300,25);
        panel.add(success);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String user = userText.getText();
        String password = passwordText.getText();

        Main.currentUser = DBConnector.getUser(user, password);

        if (Main.currentUser == null) {
            success.setText("Failed to login. Incorrect email or password...");
        }else{
            success.setText("Login successful! Welcome back " + Main.currentUser.getName());
        }

    }
}



