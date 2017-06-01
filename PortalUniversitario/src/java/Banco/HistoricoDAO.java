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
}
