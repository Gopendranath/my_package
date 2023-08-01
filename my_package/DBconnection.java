/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_package;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.*;

/**
 *
 * @author anubhav_pc
 */
public class DBconnection {
    
    public static void main(String[] args){
       // static Connection con = null;
      String JdbcURL = "jdbc:mysql://localhost:3306/library?" + "autoReconnect=true&useSSL=false";
      String Username = "root";
      String password = "*anusql123#";
      Connection con = null;
      try {
         con = DriverManager.getConnection(JdbcURL, Username, password);
         System.out.println("Your JDBC URL is as follows:" + JdbcURL);
      } catch (Exception exec) {
         exec.printStackTrace();
      }
    }
}
    
    /*public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?usessl=false" , "root","*anusql123#");
            return con;
        }
        catch(Exception e)
        {
            System.out.println(e);
         //   e.printStackTrace();
         return null;
        }
    }
    }*/
               
    
    
    

