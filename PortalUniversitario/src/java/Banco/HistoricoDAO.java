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
public class HistoricoDAO {

    public HistoricoDAO() {
    }

    public void pesquisarHistorico(ArrayList<Model.Historico> historico){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Historico obj;
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("SELECT historico.Matricula,disciplinas.Nome,situacao_disciplina_aluno.Nome FROM sonaes.historico join sonaes.disciplinas on historico.Fk_Disciplina=disciplinas.Id join sonaes.situacao_disciplina_aluno on historico.Fk_Situacao = situacao_disciplina_aluno.Id;");
        while (res.next()){
          obj = new Model.Historico(res.getString("disciplinas.Nome"), res.getString("situacao_disciplina_aluno.Nome"), res.getInt("historico.Matricula"));
          historico.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }
    
    public void pesquisarResultadosHistorico(ArrayList<Model.Disciplina> disciplina, int IDcurso){
        Connection con = ConnectionFactory.getConnection();
      try{
        Model.Disciplina obj;
        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery("SELECT disciplinas.Nome, disciplinas.Codigo, disciplinas.Semestre, tipo_disciplinas.Nome, COUNT(disciplinas.Nome) FROM sonaes.historico JOIN sonaes.disciplinas ON historico.Fk_Disciplina=disciplinas.Id JOIN sonaes.situacao_disciplina_aluno ON historico.Fk_Situacao = situacao_disciplina_aluno.Id JOIN sonaes.cursos ON cursos.Id = disciplinas.Fk_Cursos JOIN sonaes.tipo_disciplinas ON disciplinas.Fk_Tipo = tipo_disciplinas.Id AND (situacao_disciplina_aluno.Nome LIKE 'Reprovado%' OR situacao_disciplina_aluno.Nome LIKE 'Pendente') AND cursos.Id = "+IDcurso+" GROUP BY disciplinas.Nome ORDER BY disciplinas.Nome;");
        while (res.next()){
          obj =  new Model.Disciplina();
          obj.setNome(res.getString("disciplinas.Nome"));
          obj.setCodigo(res.getString("disciplinas.Codigo"));
          obj.setSemestre(res.getInt("disciplinas.Semestre"));
          obj.setTipo(res.getString("tipo_disciplinas.Nome"));
          obj.setQtdPendentes(res.getInt("COUNT(disciplinas.Nome)")); //Está sendo utilizado como contador de reprovações ou pendências
          disciplina.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }  
}
