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
 * @author joao
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }
    
    public void incluir(Model.Usuario usuario){
        int n=0;
        Connection con = ConnectionFactory.getConnection();
        try{
        Statement stm = con.createStatement();
        String sql = "insert into sonaes.usuarios (tipUser,nome,Fk_Campus,Fk_Departamentos,Fk_Cursos,matricula,senha) values ("+usuario.getTipoUser()+",'"+usuario.getNome()+"',"+usuario.getCampus().getId()+","+usuario.getDepartamento().getId()+","+usuario.getCurso().getIdCurso()+","+usuario.getMatricula()+",'"+usuario.getSenha()+"')";
        n= stm.executeUpdate(sql);
        }
        catch(SQLException e){
           System.out.println(e.getMessage());
       }
    }
    
    public int alterar(Model.Usuario usuario){     
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update sonaes.usuarios set tipUser = "+usuario.getTipoUser()+", nome= '"+usuario.getNome()+"', Fk_Campus= "+usuario.getCampus().getId()+", Fk_Departamentos = "+usuario.getDepartamento().getId()+", Fk_Cursos="+usuario.getCurso().getIdCurso()+",matricula = "+usuario.getMatricula()+", senha='"+usuario.getSenha()+"' where usuarios.matricula = '"+usuario.getMatricula()+"'";
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
    
    public int deletar(Model.Usuario usuario){      
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from sonaes.usuarios where usuarios.matricula = '"+usuario.getMatricula()+"'";
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
    
    public ResultSet pesquisarUsuario(Model.Usuario usuario){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT usuarios.tipUser,usuarios.nome,campus.Nome,departamentos.Nome,cursos.Nome,usuarios.matricula,usuarios.senha,usuarios.Fk_Campus,usuarios.Fk_Departamentos,usuarios.Fk_Cursos FROM sonaes.usuarios join sonaes.campus on usuarios.Fk_Campus = campus.Id join sonaes.departamentos on usuarios.Fk_Departamentos = departamentos.Id join sonaes.cursos on usuarios.Fk_Cursos = cursos.Id where usuarios.matricula= "+usuario.getMatricula()+";";
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
    
}
