package com.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeCard{
   static CardLayout homeCardLayout = new CardLayout();
   static final String MOVIE_RECOMMENDATIONS = "Card containing movie recommendations sorted by genres";
   static final String MOVIE_MATCH_CARD = "Card containing the movie that was searched";
   static final String MOVIE_NO_MATCH_CARD = "Card containing a message saying no match was found";

   static JPanel movieRecommendationsCard;
   static JPanel movieMatchCard;
   static JPanel movieNoMatchCard;

   //Film movieSearchResult = null;

   public static JPanel createHomeCard(){
      JPanel homeCard = new JPanel(new BorderLayout());
      homeCard.setBackground(Color.gray);

      JPanel searchFieldContainer = createSearchField();
      JPanel homeMainContainer = new JPanel();
      homeMainContainer.setLayout(homeCardLayout);
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
            System.out.println(searchField.getText()); //todo: Remove

            String userInput = searchField.getText().toLowerCase();
            /*todo: Connect to the database and try to find a match.
               If a match is found, create a movie obj and return it here.
               If no match was found return null.
               */

            //movieSearchResult = DBConnector.findFilm(userInput);
            /*
            if(movieSearchResult != null){
               homeCardLayout.show(homeCard, MOVIE_MATCH_CARD);
            }else{
               homeCardLayout.show(homeCard, MOVIE_MATCH_CARD);
            }
            */
         }
      });

      searchFieldContainer.add(searchField);

      return searchFieldContainer;
   }

   private static JPanel createMovieRecommendationsCard(){
      JPanel movieRecommendationCard = new JPanel();
      movieRecommendationCard.setBackground(ColorManager.pink);

      return movieRecommendationCard;
   }

   private static JPanel createMovieMatchCard(){
      JPanel movieMatchCard = new JPanel();

      return movieMatchCard;
   }

   private static JPanel createMovieNoMatchCard(){
      JPanel movieNoMatchCard = new JPanel();

      return movieNoMatchCard;
   }

}
