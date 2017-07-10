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
            
    public void incluir(Model.Departamento departamento){
        int n=0;
        Connection con = ConnectionFactory.getConnection();
        try{
        Statement stm = con.createStatement();
        String sql = "insert into sonaes.departamentos (Nome,Codigo,Fk_Campus) values ('"+departamento.getNome()+"','"+departamento.getCodigo()+"',"+departamento.getCampus()+")";
        n= stm.executeUpdate(sql);
        }
        catch(SQLException e){
           System.out.println(e.getMessage());
       }
    }
    
    public int alterar(Model.Departamento departamento){   
        
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update sonaes.departamentos set Nome='"+departamento.getNome()+"', Fk_Campus = "+departamento.getCampus()+" where Codigo= "+departamento.getCodigo()+"";
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
     
    public int deletar(Model.Departamento departamento){      
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from sonaes.departamentos where Codigo = '"+departamento.getCodigo()+"'";
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
    
    
    public ResultSet pesquisarDepartamento(Model.Departamento departamento){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "select * from sonaes.departamentos join sonaes.campus on departamentos.Fk_Campus=campus.Id where departamentos.Codigo= "+departamento.getCodigo()+";";
            //sql = "select d.Nome AS nomeao, d.Id, d.Codigo, campus.* from sonaes.departamentos d join sonaes.campus on d.Fk_Campus=campus.Id having nomeao= "+departamento.getNome()+";";
            ResultSet resultado=null;
            try{
                Statement stm = minhaConexao.createStatement();
                resultado = stm.executeQuery(sql);
            }
            catch (SQLException e){
              System.out.println(e.getMessage());
          }
          finally{
              return resultado;
          }             
    }
    
    public void pesquisar(ArrayList<Model.Departamento> departamentos){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Departamento obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("select * from sonaes.departamentos;");
        while (res.next()){
          obj = new Model.Departamento(res.getString("departamentos.Nome"),res.getString("departamentos.codigo"), res.getInt("departamentos.Fk_Campus"));
          departamentos.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }
        
    public void pesquisarDepartamentos(ArrayList<Model.Departamento> departamentos){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Departamento obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("SELECT departamentos.Id,departamentos.Nome, departamentos.Codigo, campus.Nome, campus.Id FROM sonaes.departamentos join sonaes.campus on departamentos.Fk_Campus = campus.Id;");
        while (res.next()){
          obj = new Model.Departamento(res.getString("departamentos.Nome"),res.getString("campus.Nome"),res.getString("departamentos.codigo"));
          obj.setId(res.getInt("departamentos.Id"));
          obj.setCampus(res.getInt("campus.Id"));
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
