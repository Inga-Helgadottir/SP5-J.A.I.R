package com.gui;

import com.company.Main;

import javax.swing.*;
import java.awt.*;

public class GUI {

   static JFrame appWindow;
   final static CardLayout mainAppLayout = new CardLayout();
   final String OUTSIDE_APP_CARD = "Card containing login and signup form content";
   final String INSIDE_APP_CARD = "Card containing home, info and liked content";

   static JPanel outsideAppCard;
   static JPanel insideAppCard;

   final static CardLayout outSideAppContentLayout = new CardLayout();
   final String SIGN_IN_CARD = "Card containing signIn content";
   final String SIGN_UP_CARD = "Card containing signUp content";

   static JPanel signInCard;
   static JPanel signUpCard;

   final static CardLayout insideAppContentLayout = new CardLayout();
   final String HOME_CARD = "Card containing home content";
   final String INFO_CARD = "Card containing info about a movie";
   final String USER_CARD = "Card containing info about the user and a logout button";
   final String LIKED_CARD = "Card containing liked content";

   static JPanel mainContainer;
   static JPanel homeCard;
   static JPanel infoCard;
   static JPanel userCard;
   static JPanel likedCard;

   public void createAppWindow(){
      appWindow = new JFrame();
      appWindow.setTitle("My movie DB");
      appWindow.setSize(800, 800);
      appWindow.getContentPane().setBackground(ColorManager.black);

      // Manage mainAppCards
      appWindow.setLayout(mainAppLayout);
      outsideAppCard = createOutsideAppCard();
      insideAppCard = createInsideAppCard();
      appWindow.add(outsideAppCard, "OUTSIDE_APP_CARD");
      appWindow.add(insideAppCard, "INSIDE_APP_CARD");
      mainAppLayout.show(appWindow.getContentPane(), "OUTSIDE_APP_CARD"); //todo Change back to OUTSIDE_APP_CARD when done

      appWindow.setVisible(true);
      appWindow.setIconImage(setAppIcon().getImage());
      appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   private ImageIcon setAppIcon(){
      return new ImageIcon("src\\img\\appLogo\\appLogo_mini.png");
   }

   private JPanel createOutsideAppCard(){
      outsideAppCard = new JPanel(outSideAppContentLayout);
      outsideAppCard.setBackground(ColorManager.yellow);

      signInCard = SignInCard.createSignInCard();
      signUpCard = SignUpCard.createSignInCard();

      outsideAppCard.add(signInCard, "SIGN_IN_CARD");
      outsideAppCard.add(signUpCard, "SIGN_UP_CARD");

      outsideAppCard.setVisible(true);

      return outsideAppCard;
   }

   private JPanel createInsideAppCard(){
      JPanel insideAppCard = new JPanel(new BorderLayout());
      insideAppCard.setBackground(ColorManager.black);

      mainContainer = new JPanel(insideAppContentLayout);
         homeCard = HomeCard.createHomeCard();
         infoCard = InfoCard.createInfoCard(null);
         userCard = UserCard.createUserCard();
         likedCard = LikedCard.createLikedCard();

         mainContainer.add(homeCard, "HOME_CARD");
         mainContainer.add(infoCard, "INFO_CARD");
         mainContainer.add(userCard, "USER_CARD");
         mainContainer.add(likedCard, "LIKED_CARD");

         insideAppContentLayout.show(mainContainer, "HOME_CARD");

      JPanel navContainer = createNavComponent();

      insideAppCard.add(mainContainer, BorderLayout.CENTER);
      insideAppCard.add(navContainer, BorderLayout.PAGE_END);

      insideAppCard.setVisible(true);

      return insideAppCard;
   }

   private JPanel createNavComponent(){
      JPanel nav = new JPanel(new GridLayout(1, 3));
      nav.setBackground(ColorManager.pink);

      // Create buttons
      JButton homeBtn = createNavBtn("src\\img\\navIcons\\home-solid.png");
      JButton userBtn = createNavBtn("src\\img\\navIcons\\user-solid.png");
      JButton likedBtn = createNavBtn("src\\img\\navIcons\\thumbs-up-solid.png");

      // Add eventListeners to the buttons
      homeBtn.addActionListener(e -> insideAppContentLayout.show(mainContainer,"HOME_CARD"));

      mainContainer.add(UserCard.createUserCard(), "USER_CARD");
      userBtn.addActionListener(e -> {
         mainContainer.add(UserCard.createUserCard(), "USER_CARD");
         insideAppContentLayout.show(mainContainer,"USER_CARD");
      });

      mainContainer.add(LikedCard.createLikedCard(), "LIKED_CARD");
      likedBtn.addActionListener(e -> {
         mainContainer.add(LikedCard.createLikedCard(), "LIKED_CARD");
         insideAppContentLayout.show(mainContainer,"LIKED_CARD");
      });

      nav.add(homeBtn);
      nav.add(userBtn);
      nav.add(likedBtn);

      nav.setVisible(true);
      return nav;
   }

   public JButton createNavBtn(String iconPath){
      JButton navBtn = new JButton();
      navBtn.setFocusable(false);

      ImageIcon btnIcon = new ImageIcon(iconPath);

      navBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      navBtn.setIcon(btnIcon);
      navBtn.setContentAreaFilled(false);
      navBtn.setBorderPainted(false);
      navBtn.setBackground(ColorManager.black);

      return navBtn;
   }

}
