package com.company;

import java.sql.*;

public class DBConnector {

   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3307/movie_pedia"; // REMEMBER TO CHANGE PORT NUMBER

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "kisshu25"; // REMEMBER TO CHANGE!


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

//    public Film readFilm(){
//
//    }

}
