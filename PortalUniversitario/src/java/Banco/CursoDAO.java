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
 * @author Marcus Filipe
 */
public class CursoDAO {

    public CursoDAO() {
    }
    
    public ResultSet pesquisar(Model.Curso curso){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "select * from sonaes.cursos join sonaes.departamentos on cursos.Fk_Departamento = departamentos.Id join sonaes.campus on departamentos.Fk_Campus = campus.Id where cursos.Codigo=("+curso.getCodigo()+")";
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
        
    public void pesquisarTodos(ArrayList<Model.Curso> cursos){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Curso obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("SELECT Nome FROM sonaes.cursos");
        while (res.next()){
          obj = new Model.Curso();
          obj.setNome(res.getString("Nome"));
          cursos.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }
    
    public void pesquisarCursos(ArrayList<Model.Curso> cursos){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Curso obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("SELECT cursos.Id,cursos.Nome, departamentos.Nome, departamentos.Codigo, cursos.CargaHoraria, cursos.Creditacao,cursos.Codigo, Min_Semestre,Max_Semestre, fk_turno FROM sonaes.cursos join sonaes.departamentos on cursos.Fk_Departamento = departamentos.Id;");
        while (res.next()){
          obj = new Model.Curso(res.getString("cursos.Nome"),res.getString("departamentos.Nome"),res.getInt("CargaHoraria"),res.getInt("Creditacao"),res.getInt("Codigo"),res.getInt("Min_Semestre"),res.getInt("Max_Semestre"),res.getInt("fk_turno"));
//          obj.setNome(res.getString("Nome"));
          obj.getDepartamento().setCodigo(res.getString("departamentos.Codigo"));
          obj.getDepartamento().pesquisarDepartamento();
          obj.setId(res.getInt("cursos.Id"));
          cursos.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }      
        
        
    public ResultSet pesquisarCodDept(Model.Curso curso){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT Id FROM sonaes.departamentos where Nome = ('"+curso.getDepartamento()+"')";
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
    
    public ResultSet pesquisarCodCurso(Model.Curso curso){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT Codigo,Id FROM sonaes.cursos where Nome = '"+curso.getNome()+"' COLLATE utf8_unicode_ci;";
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
        
    public void incluir(Model.Curso curso){
        int n=0;
        Connection con = ConnectionFactory.getConnection();
        try{
        Statement stm = con.createStatement();
        String sql = "insert into sonaes.cursos (Nome, Fk_Departamento,CargaHoraria,Creditacao,Codigo,Min_Semestre,Max_Semestre, fk_turno) values ('"+curso.getNome()+"',"+curso.getCodDept()+", "+curso.getCargaHoraria()+","+curso.getCreditacao()+","+curso.getCodigo()+","+curso.getMinSemestre()+","+curso.getMaxSemestre()+","+curso.getTurno()+")";
        n= stm.executeUpdate(sql);
        }
        catch(SQLException e){
           System.out.println(e.getMessage());
       }
    } 
}
