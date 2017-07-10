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
public class AlunoDAO {

    public AlunoDAO() {
    }


    public int incluir(Model.Aluno aluno){

      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "insert into sonaes.aluno (matricula, nome, Fk_Curso, SemInicio, telefone, email, Fk_Forma_Ingresso, creditacao) values ("+aluno.getMatricula()+",'"+aluno.getNome()+"',"+aluno.getCurso().getIdCurso()+",'"+aluno.getSemestreInicio()+"','"+aluno.getTelefone()+"','"+aluno.getEmail()+"',"+aluno.getFormaIngressoCod()+" ,"+aluno.getCreditacao()+")";
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
    public int alterar(Model.Aluno aluno){

      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update sonaes.aluno set SemInicio ='"+aluno.getSemestreInicio()+"', Fk_Curso ="+aluno.getCurso().getIdCurso()+", telefone ='"+aluno.getTelefone()+"',email = '"+aluno.getEmail()+"',Fk_Forma_Ingresso="+aluno.getFormaIngressoCod()+", creditacao = "+aluno.getCreditacao()+", nome ='"+aluno.getNome()+"' where matricula = "+aluno.getMatricula()+"";
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

    public int deletar(Model.Aluno aluno){

      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from sonaes.aluno where matricula = "+aluno.getMatricula()+"";
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

    public ResultSet pesquisarIdAluno(Model.Aluno aluno){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT Id FROM sonaes.aluno where matricula = "+aluno.getMatricula()+"";
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

    public ResultSet pesquisarAluno(Model.Aluno aluno){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT aluno.Matricula, aluno.Nome, aluno.Fk_Curso, cursos.Nome, cursos.fk_turno, departamentos.Nome AS Departamento, campus.Nome AS Campus, aluno.email, aluno.telefone, aluno.SemInicio, aluno.Fk_Forma_Ingresso, aluno.sem_externo, formasingresso.nome, aluno.creditacao FROM aluno JOIN cursos ON aluno.Fk_Curso = cursos.Id JOIN departamentos ON cursos.Fk_Departamento = departamentos.Id JOIN campus ON departamentos.Fk_Campus = campus.Id JOIN formasingresso ON aluno.Fk_Forma_Ingresso = formasingresso.Id WHERE aluno.Matricula="+aluno.getMatricula()+";";
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


    public ResultSet pesquisarCurso(Model.Aluno aluno){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT Id FROM sonaes.cursos where Nome = ('"+aluno.getCurso()+"')";
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

    public ResultSet pesquisarFormaIngresso(Model.Aluno aluno){
        Connection minhaConexao = ConnectionFactory.getConnection();
            String sql;
            sql = "SELECT Id FROM sonaes.formasingresso where Nome = ('"+aluno.getFormaIngresso()+"')";
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

    public void pesquisarTodasFormaIngresso(ArrayList<String> formas_ingresso){
        Connection con = ConnectionFactory.getConnection();
        try {
            String obj;
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT Nome FROM sonaes.formasingresso");
            while (res.next()){
              obj = res.getString("Nome");
              formas_ingresso.add(obj);
            }
            res.close();
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void pesquisarTodosAlunos(ArrayList<Model.Aluno> alunos, String curso){
        Connection con = ConnectionFactory.getConnection();
        try{
          Model.Aluno obj;
          Statement stm = con.createStatement();
          ResultSet res = stm.executeQuery("SELECT Matricula,aluno.Nome FROM aluno join cursos on aluno.Fk_Curso = cursos.Id where cursos.Nome = '"+curso+"';");
          while (res.next()){
            obj = new Model.Aluno();
            obj.getCurso().setNome(curso);
            obj.getCurso().pesquisarCodCurso();
            obj.setNome(res.getString("Nome"));
            obj.setMatricula(res.getInt("Matricula"));
            alunos.add(obj);
          }
          res.close();
          con.close();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
