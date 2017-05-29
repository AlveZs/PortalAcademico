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
            sql = "select * from sonaes.cursos join sonaes.departamentos on cursos.Fk_Departamento = departamentos.Id where cursos.Codigo=("+curso.getCodigo()+")";
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
        
    public ResultSet pesquisarCod(Model.Curso curso){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT Id FROM sonaes.departamentos where Nome = ("+curso.getDepartamento()+")";
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
