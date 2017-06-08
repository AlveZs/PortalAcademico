/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author joao
 */
public class Processo {
    int qtdSemestres,codProcesso,situacao;
    Aluno aluno = new Aluno();

    public Processo() {
    }
    
    public Processo(int situacao, int qtdSemestres, int codProcesso) {
        this.situacao = situacao;
        this.qtdSemestres = qtdSemestres;
        this.codProcesso = codProcesso;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public int getQtdSemestres() {
        return qtdSemestres;
    }

    public void setQtdSemestres(int qtdSemestres) {
        this.qtdSemestres = qtdSemestres;
    }

    public int getCodProcesso() {
        return codProcesso;
    }

    public void setCodProcesso(int codProcesso) {
        this.codProcesso = codProcesso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void incluir(){
        Banco.ProcessosDAO x = new Banco.ProcessosDAO();
        x.incluir(this);
    }
    
    public void alterar(){
        Banco.ProcessosDAO x = new Banco.ProcessosDAO();
        x.alterar(this);
    }
    
    public void deletar(){
        Banco.ProcessosDAO x = new Banco.ProcessosDAO();
        x.deletar(this);
    }
    
    public void pesquisar(){
        Banco.ProcessosDAO x = new Banco.ProcessosDAO();
        ResultSet resultado = x.pesquisar(this);
        try{
        while (resultado.next())
        {
            this.aluno.setMatricula(resultado.getInt("aluno.matricula"));
            this.codProcesso = resultado.getInt("codProcesso");
            this.qtdSemestres = resultado.getInt("qtdSemestres");
            this.situacao = resultado.getInt("situacao");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }
    
}
