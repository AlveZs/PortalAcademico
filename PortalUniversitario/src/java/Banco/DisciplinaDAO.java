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
 */
public class DisciplinaDAO {

    public DisciplinaDAO() {
    }
    
    public void pesquisarTodas(ArrayList<Model.Disciplina> disciplinas, int codCurso){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Disciplina obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("select * from sonaes.disciplinas join sonaes.cursos on disciplinas.Fk_Cursos = cursos.Id join sonaes.tipo_disciplinas on disciplinas.Fk_Tipo = tipo_disciplinas.Id where cursos.Codigo = ("+codCurso+")");
        while (res.next()){
          obj = new Model.Disciplina(res.getString("disciplinas.Nome"),res.getInt("disciplinas.Semestre"),res.getString("tipo_disciplinas.Nome"),res.getString("disciplinas.Codigo"),res.getInt("disciplinas.Creditacao"),res.getInt("disciplinas.CargaHoraria"));
          obj.getCurso().setNome(res.getString("cursos.Nome"));
          obj.getCurso().setId(res.getInt("disciplinas.Fk_Cursos"));
          disciplinas.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }
    
    public void pesquisarDisciplinas(ArrayList<Model.Disciplina> disciplinas){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Disciplina obj;  
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("SELECT disciplinas.Nome,disciplinas.Fk_Cursos, cursos.Nome, departamentos.Nome AS Departamento, campus.Nome AS Campus, tipo_disciplinas.Nome,disciplinas.CargaHoraria,disciplinas.Creditacao,disciplinas.Semestre,disciplinas.Codigo FROM sonaes.disciplinas join sonaes.cursos on disciplinas.Fk_Cursos = cursos.Id join sonaes.departamentos on cursos.Fk_Departamento = departamentos.Id join sonaes.campus on departamentos.Fk_Campus = campus.Id join sonaes.tipo_disciplinas on disciplinas.Fk_Tipo = tipo_disciplinas.Id;");
        while (res.next()){
          obj = new Model.Disciplina(res.getString("disciplinas.Nome"),res.getInt("disciplinas.Semestre"),res.getString("tipo_disciplinas.Nome"),res.getString("disciplinas.Codigo"),res.getInt("disciplinas.Creditacao"),res.getInt("disciplinas.CargaHoraria"));
          obj.getCurso().setNome(res.getString("cursos.Nome"));
          obj.getCurso().setId(res.getInt("disciplinas.Fk_Cursos"));
          disciplinas.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }
    
    public ResultSet pesquisarDisciplina(Model.Disciplina disciplina){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT disciplinas.Id,disciplinas.Nome,disciplinas.Creditacao, disciplinas.Fk_Cursos, departamentos.Nome AS Departamento, campus.Nome AS Campus,disciplinas.Fk_Tipo,disciplinas.CargaHoraria,disciplinas.Semestre,disciplinas.Codigo,cursos.Nome,tipo_disciplinas.Nome FROM sonaes.disciplinas join sonaes.cursos on disciplinas.Fk_Cursos = cursos.Id join sonaes.departamentos on cursos.Fk_Departamento = departamentos.Id join sonaes.campus on departamentos.Fk_Campus = campus.Id join sonaes.tipo_disciplinas on disciplinas.Fk_Tipo = tipo_disciplinas.Id where disciplinas.Codigo = '"+disciplina.getCodigo()+"'";
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

    public void incluir(Model.Disciplina disciplina){
        int n=0;
        Connection con = ConnectionFactory.getConnection();
        try{
        Statement stm = con.createStatement();
        String sql = "insert into sonaes.disciplinas (Nome,Fk_Cursos,Fk_Tipo,CargaHoraria,Creditacao,Semestre,Codigo) values ('"+disciplina.getNome()+"',"+disciplina.getCurso().getIdCurso()+","+disciplina.getIdTipo()+","+disciplina.getCargaHoraria()+","+disciplina.getCreditacao()+","+disciplina.getSemestre()+",'"+disciplina.getCodigo()+"')";
        n= stm.executeUpdate(sql);
        }
        catch(SQLException e){
           System.out.println(e.getMessage());
       }
    }
    
    public int alterar(Model.Disciplina disciplina){     
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update sonaes.disciplinas set Nome='"+disciplina.getNome()+"',Fk_Cursos="+disciplina.getCurso().getIdCurso()+",Fk_Tipo="+disciplina.getIdTipo()+",CargaHoraria="+disciplina.getCargaHoraria()+",Creditacao="+disciplina.getCreditacao()+",Semestre="+disciplina.getSemestre()+" where disciplinas.Codigo = '"+disciplina.getCodigo()+"'";
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
    public int deletar(Model.Disciplina disciplina){      
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from sonaes.disciplinas where disciplinas.Codigo = '"+disciplina.getCodigo()+"'";
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
