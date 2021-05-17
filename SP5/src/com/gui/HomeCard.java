package com.gui;

import com.company.Film;
import com.company.DBConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeCard{

   static JPanel homeMainContainer;

   static CardLayout homeCardLayout = new CardLayout();
   static final String MOVIE_RECOMMENDATIONS = "Card containing movie recommendations sorted by genres";
   static final String MOVIE_MATCH_CARD = "Card containing the movie that was searched";
   static final String MOVIE_NO_MATCH_CARD = "Card containing a message saying no match was found";

   static JPanel movieRecommendationsCard;
   static JPanel movieMatchCard;
   static JPanel movieNoMatchCard;

   static Film movieSearchResult = null;

   public static JPanel createHomeCard(){
      JPanel homeCard = new JPanel(new BorderLayout());
      homeCard.setBackground(Color.gray);

      JPanel searchFieldContainer = createSearchField();
      homeMainContainer = new JPanel(homeCardLayout);
         movieRecommendationsCard = createMovieRecommendationsCard();
         movieMatchCard = createMovieMatchCard(null);
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
               movieMatchCard = createMovieMatchCard(movieSearchResult);
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

      return movieRecommendationCard;
   }

   private static JPanel createMovieMatchCard(Film film){
      JPanel movieMatchCard = new JPanel();
      movieMatchCard.setBackground(Color.green);
      //todo: Remove background color and replace with movie title and img
      //todo: Remove placeholderBtn and replace with the movie cover
      JButton placeholderBtn = new JButton("See info");
      placeholderBtn.addActionListener(e -> {
         GUI.infoCard = InfoCard.createInfoCard(film);
         GUI.insideAppContentLayout.show(GUI.mainContainer, "INFO_CARD");
      });

      movieMatchCard.add(placeholderBtn); //todo: Remove

      return movieMatchCard;
   }

   private static JPanel createMovieNoMatchCard(){
      JPanel movieNoMatchCard = new JPanel();
      movieNoMatchCard.setBackground(Color.red);
      //todo: Remove background color and replace with a message accompanied with an img

      return movieNoMatchCard;
   }

}
