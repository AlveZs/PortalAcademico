/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 */
public class ConnectionFactory {
    public static Connection getConnection(){
      Connection con = null;
      try      {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
          con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "123456");
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return con;
      }
    }
}
