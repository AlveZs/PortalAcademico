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
public class ProcessosDAO {

    public ProcessosDAO() {
    }
    
    public void incluir(Model.Processo processo){
        int n=0;
        Connection con = ConnectionFactory.getConnection();
        try{
        Statement stm = con.createStatement();
        String sql = "insert into sonaes.processos (aluno,situacao,codProcesso,qtdSemestres) values ('"+processo.getAluno().getId()+"',"+processo.getSituacao()+","+processo.getCodProcesso()+","+processo.getQtdSemestres()+")";
        n= stm.executeUpdate(sql);
        }
        catch(SQLException e){
           System.out.println(e.getMessage());
       }
    }
    
    public ResultSet pesquisar(Model.Processo processo){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT * FROM sonaes.processos join sonaes.aluno on processos.aluno = aluno.Id where codProcesso = ("+processo.getCodProcesso()+")";
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
    
    public int alterar(Model.Processo processo){   
        
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update sonaes.processos set aluno = '"+processo.getAluno().getId()+"', situacao = "+processo.getSituacao()+", qtdSemestres = "+processo.getQtdSemestres()+"  where codProcesso = "+processo.getCodProcesso()+"";
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
    
    public int deletar(Model.Processo processo){   
        
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from sonaes.processos where codProcesso = "+processo.getCodProcesso()+"";
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
