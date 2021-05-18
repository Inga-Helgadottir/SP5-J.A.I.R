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

      JLabel img = new JLabel(new ImageIcon("src/Film/Luca.jpg"));
      JLabel img1 = new JLabel(new ImageIcon("src/Film/Candyman.jpg"));
      JLabel img2 = new JLabel(new ImageIcon("src/Film/22 vs. Earth.jpg"));
      JLabel img3 = new JLabel(new ImageIcon("src/Film/The Mitchells vs the Machines.jpg"));
      JLabel img4 = new JLabel(new ImageIcon("src/Film/Love and Monsters.jpg"));
      JLabel img5 = new JLabel(new ImageIcon("src/Film/Funhouse.jpg"));
      JLabel img6 = new JLabel(new ImageIcon("src/Film/Thunder Force.jpg"));
      JLabel img7 = new JLabel(new ImageIcon("src/Film/Sleepers.jpg"));
      JLabel img8 = new JLabel(new ImageIcon("src/Film/Avengers Infinity War.jpg"));
      JLabel img9 = new JLabel(new ImageIcon("src/Film/Black Panther.jpg"));
      JLabel img10 = new JLabel(new ImageIcon("src/Film/The Wolf of Wall Street.jpg"));
      JLabel img11 = new JLabel(new ImageIcon("src/Film/The Dark Knight.jpg"));

      movieRecommendationCard.add(img);
      movieRecommendationCard.add(img1);
      movieRecommendationCard.add(img2);
      movieRecommendationCard.add(img3);
      movieRecommendationCard.add(img4);
      movieRecommendationCard.add(img5);
      movieRecommendationCard.add(img6);
      movieRecommendationCard.add(img7);
      movieRecommendationCard.add(img8);
      movieRecommendationCard.add(img9);
      movieRecommendationCard.add(img10);
      movieRecommendationCard.add(img11);

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
