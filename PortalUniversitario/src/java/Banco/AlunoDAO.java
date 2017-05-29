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
public class AlunoDAO {
    
    public int incluir(Model.Aluno aluno){   
        
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "insert into sonaes.aluno (matricula, nome, Fk_Curso, SemInicio, telefone, email, Fk_Forma_Ingresso, creditacao) values ('"+aluno.getMatricula()+"','"+aluno.getNome()+"','"+aluno.getCurso()+"','"+aluno.getSemestreInicio()+"','"+aluno.getTelefone()+"','"+aluno.getEmail()+"','"+aluno.getFormaIngresso()+"' , '"+aluno.getCreditacao()+"')";
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
