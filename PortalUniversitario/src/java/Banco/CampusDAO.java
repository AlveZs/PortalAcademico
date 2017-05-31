/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class CampusDAO {

    public CampusDAO() {
    }
       
    public void pesquisarCampus(ArrayList<Model.Campus> campus){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Campus obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("SELECT * FROM sonaes.campus;");
        while (res.next()){
          obj = new Model.Campus(res.getString("Nome"), res.getInt("Codigo"));
          obj.setNome(res.getString("Nome"));
          campus.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    } 
}
