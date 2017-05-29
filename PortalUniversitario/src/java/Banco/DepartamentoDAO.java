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
public class DepartamentoDAO {

    public DepartamentoDAO() {
    }
            
    
    public void pesquisar(ArrayList<Model.Departamento> departamentos){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Departamento obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("select * from sonaes.departamentos;");
        while (res.next()){
          obj = new Model.Departamento(res.getString("departamentos.Nome"),res.getInt("departamentos.codigo"), res.getInt("departamentos.Fk_Campus"));
          departamentos.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }
}
