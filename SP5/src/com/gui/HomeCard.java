package com.gui;

import com.company.Film;
import com.company.DBConnector;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class HomeCard {

   static JPanel homeMainContainer;

   static CardLayout homeCardLayout = new CardLayout();
   static final String MOVIE_RECOMMENDATIONS = "Card containing movie recommendations sorted by genres";
   static final String MOVIE_MATCH_CARD = "Card containing the movie that was searched";
   static final String MOVIE_NO_MATCH_CARD = "Card containing a message saying no match was found";

   static JPanel movieRecommendationsCard;
   static JPanel movieMatchCard;
   static JPanel movieNoMatchCard;

   static Film movieSearchResult = null;

   static FontManager fontManager = new FontManager();

   public static JPanel createHomeCard(){
      JPanel homeCard = new JPanel(new BorderLayout());
      homeCard.setBackground(Color.gray);

      JPanel searchFieldContainer = createSearchField();
      homeMainContainer = new JPanel(homeCardLayout);
         movieRecommendationsCard = createMovieRecommendationsCard();
         movieMatchCard = createMovieMatchCard();
         movieNoMatchCard = createMovieNoMatchCard();

         homeMainContainer.add(movieRecommendationsCard, "MOVIE_RECOMMENDATIONS");
         homeMainContainer.add(movieMatchCard, "MOVIE_MATCH_CARD");
         homeMainContainer.add(movieNoMatchCard, "MOVIE_NO_MATCH_CARD");

      homeCard.add(searchFieldContainer, BorderLayout.PAGE_START);
      homeCard.add(homeMainContainer, BorderLayout.CENTER);

      return homeCard;
   }

   private static JPanel createSearchField(){
      JPanel searchFieldContainer = new JPanel();

      JTextField searchField = new JTextField("Search...");
      searchField.setHorizontalAlignment(JTextField.CENTER);
      searchField.setPreferredSize(new Dimension(350, 35));

      searchField.addMouseListener(new MouseAdapter(){
         @Override
         public void mouseClicked(MouseEvent e){
            searchField.setText("");
         }
      });

      searchField.addActionListener( new AbstractAction() {
         @Override
         public void actionPerformed(ActionEvent e) {

            String userInput = searchField.getText();

            movieSearchResult = DBConnector.findFilm(userInput);

            if(movieSearchResult != null){
               homeMainContainer.add(movieMatchCard = createMovieMatchCard(), "MOVIE_MATCH_CARD");
               homeCardLayout.show(homeMainContainer, "MOVIE_MATCH_CARD");
            }else{
               homeCardLayout.show(homeMainContainer, "MOVIE_NO_MATCH_CARD");
            }

         }
      });

      searchFieldContainer.add(searchField);

      return searchFieldContainer;
   }

   private static JPanel createMovieRecommendationsCard(){
      JPanel movieRecommendationCard = new JPanel();
      movieRecommendationCard.setBackground(ColorManager.pink);
      String[] arr = {"Luca", "Candyman", "22 vs. Earth",
              "The Mitchells vs the Machines", "Love and Monsters",
              "Funhouse", "Thunder Force", "Sleepers",
              "Avengers Infinity War", "Black Panther",
              "The Wolf of Wall Street", "The Dark Knight"};


      for (String a: arr) {
         DBConnector db = new DBConnector();
         Film f = db.findFilm(a);
         JLabel img = new JLabel(new ImageIcon(f.getImgPath()));
         movieRecommendationCard.add(img);
         img.addMouseListener(new MouseListener()
         {
            @Override
            public void mouseClicked(MouseEvent e)
            {
               GUI.mainContainer.add(InfoCard.createInfoCard(f), "INFO_CARD");
               GUI.insideAppContentLayout.show(GUI.mainContainer, "INFO_CARD");
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
               img.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
               img.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
         });
      }

      return movieRecommendationCard;
   }

   private static JPanel createMovieMatchCard(){
      JPanel movieMatchCard = new JPanel(new BorderLayout());

      if(movieSearchResult != null){
         JLabel searchResult = new JLabel(BorderLayout.CENTER);
         movieMatchCard.setBackground(Color.white);

         searchResult.setText(movieSearchResult.getTitle());
         searchResult.setFont(fontManager.anton40);
         searchResult.setHorizontalTextPosition(searchResult.CENTER);
         searchResult.setVerticalTextPosition(searchResult.TOP);
         searchResult.setIconTextGap(50);

         ImageIcon movieCover = new ImageIcon(movieSearchResult.getImgPath());
         searchResult.setIcon(movieCover);
         searchResult.setHorizontalAlignment(searchResult.CENTER);

         searchResult.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               GUI.mainContainer.add(InfoCard.createInfoCard(movieSearchResult), "INFO_CARD");
               GUI.insideAppContentLayout.show(GUI.mainContainer, "INFO_CARD");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               searchResult.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               searchResult.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
         });

         movieMatchCard.add(searchResult);
      }

      return movieMatchCard;
   }

   private static JPanel createMovieNoMatchCard(){
      JPanel movieNoMatchCard = new JPanel(new BorderLayout());
      movieNoMatchCard.setBackground(Color.red);

      JLabel msg = new JLabel("Sorry, no movie from our database seems to match your search input...");
      msg.setHorizontalAlignment(SwingConstants.CENTER);
      movieNoMatchCard.add(msg,  BorderLayout.CENTER);

      return movieNoMatchCard;
   }

}
