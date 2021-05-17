package com.company;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {

   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3307/film_pedia"; // REMEMBER TO CHANGE PORT NUMBER

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "kisshu25"; // REMEMBER TO CHANGE PASSWORD!

   public static User getUser(String email, String password){
      Connection conn = null;
      PreparedStatement pstmt = null;

      User userMatch = null;

      try{
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         String sql =
         "SELECT * FROM film_pedia.film_user\n" +
         "WHERE user_email = ? AND user_password = ?";

         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, email);
         pstmt.setString(2, password);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int id = rs.getInt("id");
            String userEmail = rs.getString("user_email");
            String fullName = rs.getString("user_name");

            userMatch = new User(id, userEmail, fullName);
            getUserLikedList(userMatch);
         }

         rs.close();
      }catch(SQLException se){
         se.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(pstmt!=null)
               pstmt.close();
         }catch(SQLException se2){
         }

         try{
            if(conn!=null){
               conn.close();
            }
         }catch(SQLException se){
            se.printStackTrace();
         }
      }
      return userMatch;
   }

   private static void getUserLikedList(User user){
      Connection conn = null;
      PreparedStatement pstmt = null;

      try {
         conn = DriverManager.getConnection(DB_URL,USER,PASS);

         String sql =
         "SELECT film_user.id AS user_id, " +
         "films.id AS film_id, " +
         "films.film_name, " +
         "film_description, " +
         "film_genre, " +
         "films.secondary_film_genre, " +
         "films.film_year_of_release, " +
         "films.film_image\n" +
         "FROM liked_list\n" +
         "INNER JOIN film_user ON liked_list.film_user_id = film_user.id\n" +
         "INNER JOIN films ON liked_list.film_id = films.id\n" +
         "WHERE film_user.id = ?\n" +
         "ORDER BY film_id";

         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, user.getId());
         ResultSet rs = pstmt.executeQuery();

         while (rs.next()){
            int id = rs.getInt("film_id");
            String title = rs.getString("film_name");
            String summary = rs.getString("film_description");
            String releaseDate = rs.getString("film_year_of_release");
            String imgPath = rs.getString("film_image");
            String genre1 = rs.getString("film_genre");
            String genre2 = rs.getString("secondary_film_genre");

            ArrayList<String> genres = new ArrayList<String>(); //todo Consider creating a table for genres
            genres.add(genre1);
            genres.add(genre2);

            ArrayList<String> directors = new ArrayList<String>(); //todo Needs a connection table to films to get data
            ArrayList<String> actors = new ArrayList<String>(); //todo Needs a connection table to films to get data

            user.getLikedFilms().add(new Film(id, title, summary, releaseDate, imgPath));
            //user.getLikedFilms().add(new Film(id, title, releaseDate, imgPath, directors, actors, genres));
         }

         rs.close();
      }catch(SQLException se){
         se.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(pstmt!=null)
               pstmt.close();
         }catch(SQLException se2){
         }

         try{
            if(conn!=null){
               conn.close();
            }
         }catch(SQLException se){
            se.printStackTrace();
         }
      }
   }

   public static boolean signUp(String email, String password, String fullName){
      Connection conn = null;
      PreparedStatement pstmt = null;

      boolean signedUp = false;

      if(!checkIfEmailExists(email)){
         try{
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String sql =
            "INSERT INTO film_user(user_email, user_password, user_name)\n" +
            "VALUES(?, ?, ?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, fullName);

            pstmt.addBatch();
            pstmt.executeBatch();

            signedUp = true;
         }catch (SQLException ex) {
            System.out.println(ex.getMessage());
         }
      }

       return signedUp;
   }

   private static boolean checkIfEmailExists(String email){
       boolean alreadyRegistered = false;

      Connection conn = null;
      PreparedStatement pstmt = null;

      try{
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         String sql =
         "SELECT user_email FROM film_pedia.film_user\n" +
         "WHERE user_email = ?";

         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, email);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            alreadyRegistered = true;
         }

         rs.close();
      }catch(SQLException se){
         se.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(pstmt!=null)
               pstmt.close();
         }catch(SQLException se2){
         }

         try{
            if(conn!=null){
               conn.close();
            }
         }catch(SQLException se){
            se.printStackTrace();
         }
      }

       return alreadyRegistered;
   }

   public static Film findFilm(String userInput){
      Connection conn = null;
      PreparedStatement pstmt = null;

      Film match = null;

      try{
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         String sql =
         "SELECT * FROM film_pedia.films\n" +
         "WHERE films.film_name = ?";

         pstmt = conn.prepareStatement(sql);

         pstmt.setString(1, userInput);

         ResultSet rs = pstmt.executeQuery();

         while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("film_name");
            String summary = rs.getString("film_description");
            String releaseDate = rs.getString("film_year_of_release");
            String imgPath = rs.getString("film_image");
            String genre1 = rs.getString("film_genre");
            String genre2 = rs.getString("secondary_film_genre");


            match = new Film(id, title, summary, releaseDate, imgPath);
         }

         rs.close();
      }catch(SQLException se){
         se.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(pstmt!=null)
               pstmt.close();
         }catch(SQLException se2){
         }

         try{
            if(conn!=null){
               conn.close();
            }
         }catch(SQLException se){
            se.printStackTrace();
         }
      }

      return match;
   }

   public void seeAllFilms(){
      Connection conn = null;
      Statement stmt = null;
      try
      {
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         //STEP 4: Execute a query
         System.out.println("Creating statement...");

         stmt = conn.createStatement();
         String sql = "SELECT * FROM films";

         ResultSet rs = stmt.executeQuery(sql);

         while (rs.next())
         {
            String fn = rs.getString("film_name");
            String fg = rs.getString("film_genre");
            String sfg = rs.getString("secondary_film_genre");
            String fyor = rs.getString("film_year_of_release");
            String fd = rs.getString("film_description");
            String fi = rs.getString("film_image");
            //--------------------------------------------------------------------------------
            System.out.println("this will be showed with JPanel later");
         }
         //STEP 6: Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException se)
      {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch (Exception e)
      {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally
      {
         //finally block used to close resources
         try
         {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2)
         {
         }// nothing we can do
         try
         {
            if (conn != null)
               conn.close();
         } catch (SQLException se)
         {
            se.printStackTrace();
         }//end finally try
      }//end try
   }

   public Film getFilmByName(String name){
      Connection conn = null;
      Statement stmt = null;
      try
      {
         //STEP 2: Register JDBC driver
         //Class.forName("com.mysql.jdbc.Driver");

         //STEP 3: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         //STEP 4: Execute a query
         System.out.println("Creating statement...");

         stmt = conn.createStatement();
         String sql = "SELECT * FROM films";

         ResultSet rs = stmt.executeQuery(sql);

         //STEP 5: Extract data from result set
         while (rs.next())
         {
            int id = rs.getInt("id");
            String fn = rs.getString("film_name");
            String fg = rs.getString("film_genre");
            String sfg = rs.getString("secondary_film_genre");
            String fyor = rs.getString("film_year_of_release");
            String fd = rs.getString("film_description");
            String fimg = rs.getString("film_image");
            //--------------------------------------------------------------------------------
            if(fn.equals(name)){
               System.out.println("here we will show the movie info with JPanel");
               Film film = new Film(id, fn, fd, fyor, fimg);
               return film;
             }

         }
         //STEP 6: Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException se)
      {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch (Exception e)
      {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally
      {
         //finally block used to close resources
         try
         {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2)
         {
         }// nothing we can do
         try
         {
            if (conn != null)
               conn.close();
         } catch (SQLException se)
         {
            se.printStackTrace();
         }//end finally try
      }//end try
      return null;
   }

   public void getFilmByGenre(String genre){
      Connection conn = null;
      Statement stmt = null;
      try
      {
         //STEP 2: Register JDBC driver
         //Class.forName("com.mysql.jdbc.Driver");

         //STEP 3: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         //STEP 4: Execute a query
         System.out.println("Creating statement...");

         stmt = conn.createStatement();
         String sql = "SELECT * FROM films";

         ResultSet rs = stmt.executeQuery(sql);

         //STEP 5: Extract data from result set
         while (rs.next())
         {
            String fn = rs.getString("film_name");
            String fg = rs.getString("film_genre");
            String sfg = rs.getString("secondary_film_genre");
            String fyor = rs.getString("film_year_of_release");
            String fd = rs.getString("film_description");
            String fimg = rs.getString("film_image");
            //--------------------------------------------------------------------------------
            if(fg.equals(genre) || sfg.equals(genre)){
               System.out.println("here we will show the movie info with JPanel");
            }

         }
         //STEP 6: Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException se)
      {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch (Exception e)
      {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally
      {
         //finally block used to close resources
         try
         {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2)
         {
         }// nothing we can do
         try
         {
            if (conn != null)
               conn.close();
         } catch (SQLException se)
         {
            se.printStackTrace();
         }//end finally try
      }//end try
   }

   public void showLikedList(){
      Connection conn = null;
      Statement stmt = null;
      try
      {
         //STEP 2: Register JDBC driver
         //Class.forName("com.mysql.jdbc.Driver");

         //STEP 3: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         //STEP 4: Execute a query
         System.out.println("Creating statement...");

         stmt = conn.createStatement();
         String sql = "SELECT * FROM liked_list";

         ResultSet rs = stmt.executeQuery(sql);

         //STEP 5: Extract data from result set
         while (rs.next())
         {
            String fn = rs.getString("film_id");
            String fg = rs.getString("film_user_id");
            //-------------------------------------------------------------------------------
            if(fg.equals("1")){//change later to current users id
               getFilmById(fn);
            }
         }
         //STEP 6: Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException se)
      {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch (Exception e)
      {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally
      {
         //finally block used to close resources
         try
         {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2)
         {
         }// nothing we can do
         try
         {
            if (conn != null)
               conn.close();
         } catch (SQLException se)
         {
            se.printStackTrace();
         }//end finally try
      }//end try
   }

   public void getFilmById(String id){
      Connection conn = null;
      Statement stmt = null;
      try
      {
         conn = DriverManager.getConnection(DB_URL, USER, PASS);

         stmt = conn.createStatement();
         String sql = "SELECT * FROM films";

         ResultSet rs = stmt.executeQuery(sql);

         while (rs.next()) {
            String fi = rs.getString("id");
            String fn = rs.getString("film_name");
            String fg = rs.getString("film_genre");
            String sfg = rs.getString("secondary_film_genre");
            String fyor = rs.getString("film_year_of_release");
            String fd = rs.getString("film_description");
            String fimg = rs.getString("film_image");
            //--------------------------------------------------------------------------------
            if (fi.equals(id)) {
               System.out.println("this will be showed with JPanel later");
            }
         }
         rs.close();
         stmt.close();
         conn.close();
      } catch (SQLException se)
      {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch (Exception e)
      {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally
      {
         //finally block used to close resources
         try
         {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2)
         {
         }// nothing we can do
         try
         {
            if (conn != null)
               conn.close();
         } catch (SQLException se)
         {
            se.printStackTrace();
         }//end finally try
      }//end try
   }

}
