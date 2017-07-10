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
public class SemestreDAO {
    public SemestreDAO() {
    }
    
    public void incluir(Model.Semestre sc){
        int n=0;
        Connection con = ConnectionFactory.getConnection();
        try{
        Statement stm = con.createStatement();
        String sql = "insert into sonaes.semestrecancelado (ano, semestre) values ("+sc.getAno()+","+sc.getSemestre()+")";
        n= stm.executeUpdate(sql);
        }
        catch(SQLException e){
           System.out.println(e.getMessage());
       }
        //finally{
        //    return n;
        //}    

    }
    
    public void ConsultaTodos(ArrayList<Model.Semestre> todos){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Semestre obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("select * from sonaes.semestrecancelado");
        while (res.next()){
          obj = new Model.Semestre(res.getInt("id"),res.getInt("ano"), res.getInt("semestre"));
          todos.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }

    public int deletar(Model.Semestre semestre){      
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from sonaes.semestrecancelado where ano = "+semestre.getAno()+" and semestre = "+semestre.getSemestre()+"";
      int retorno=0;
      try{
            Statement stm = minhaConexao.createStatement();
            retorno = stm.executeUpdate(sql);
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return retorno;
      }
   }    
    
}
