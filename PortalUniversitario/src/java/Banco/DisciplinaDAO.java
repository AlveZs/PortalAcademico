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
          obj = new Model.Disciplina(res.getString("disciplinas.Nome"),res.getInt("disciplinas.Semestre"),res.getString("cursos.Nome"),res.getString("tipo_disciplinas.Nome"),res.getString("disciplinas.Codigo"),res.getInt("disciplinas.Creditacao"),res.getInt("disciplinas.CargaHoraria"));
          disciplinas.add(obj);
        }
        res.close();
        con.close();
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }

    }
}
