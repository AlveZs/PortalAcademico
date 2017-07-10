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
public class IntegralizacaoDAO {

    public IntegralizacaoDAO() {
    }
    
    public ResultSet pesquisaNumeroSemestre(Model.Aluno aluno){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "select (year(curdate())-substring(aluno.SemInicio,1,4))*2 as Semestres, substring(aluno.SemInicio,6,6) as SemestreInicio,month(curdate()) as Mes from aluno where aluno.Matricula = '"+aluno.getMatricula()+"';";
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
    
    public ResultSet pesquisaSemCancelados(Model.Aluno aluno){
    Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select count(ano) as SemCancelados from semestrecancelado where ano between (select substring(aluno.SemInicio,1,4) from aluno where aluno.Matricula = '"+ aluno.getMatricula() +"') AND year(curdate())";
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
    
    public ResultSet pesquisaMateriasCurso(Model.Curso curso){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "select sum(qtdDisc) as discT from( select count(disciplinas.Codigo) as qtdDisc from disciplinas join cursos on disciplinas.Fk_Cursos = cursos.Id where cursos.Id ="+curso.getIdCurso()+" AND disciplinas.Fk_Tipo = 1 union select count(distinct disciplinas.Semestre) as qtdDisc from disciplinas join cursos on disciplinas.Fk_Cursos = cursos.Id where cursos.Id = "+curso.getIdCurso()+" AND disciplinas.Fk_Tipo = 2) as disc;";
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
    
    public ResultSet pesquisaMateriasAprovadas(Model.Aluno aluno){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "select historico.Matricula, count(situacao_disciplina_aluno.Nome) as Aprovadas from historico join situacao_disciplina_aluno on historico.Fk_Situacao = situacao_disciplina_aluno.Id join aluno on historico.Matricula=aluno.Matricula where situacao_disciplina_aluno.Nome ='Aprovado' AND aluno.Matricula = '"+aluno.getMatricula()+"' group by historico.Matricula;";
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
