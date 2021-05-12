package com.company;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {

   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/film_pedia"; // REMEMBER TO CHANGE PORT NUMBER

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "Password"; // REMEMBER TO CHANGE!


   public static void testConnection(){
      Connection conn = null;
      Statement stmt = null;

      try{
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         try{
            if(stmt!=null)
               stmt.close();
         }catch(SQLException se2){
         }
         try{
            if(conn!=null)
               conn.close();
         }catch(SQLException se){
            se.printStackTrace();
         }
      }
   }

    public void seeAllFilms(){
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

             //Display values
             System.out.println("this will be showed with JPanel later");
             System.out.print(fn + " " + fg + " " + sfg + " " + fyor + "\n");
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

   public void getFilmByName(String name){
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

            if(fn.equals(name)){
               System.out.println("here we will show the movie info with JPanel");
               //Display values
               System.out.print(fn + " " + fg + " " + sfg + " " + fyor + "\n");
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

}
