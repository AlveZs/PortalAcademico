/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marcus Filipe
 */
public class Disciplina {
    
    private String  nome,curso,tipo,codigo;
    private int creditacao,cargaHoraria,semestre;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina() {
    }



    public Disciplina(String nome, int semestre, String curso, String tipo, String codigo, int creditacao, int cargaHoraria) {
        this.nome = nome;
        this.semestre = semestre;
        this.curso = curso;
        this.tipo = tipo;
        this.codigo = codigo;
        this.creditacao = creditacao;
        this.cargaHoraria = cargaHoraria;
    }

    public void pesquisarTodos(int cod){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        x.pesquisarTodas(disciplinas,cod);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditacao() {
        return creditacao;
    }

    public void setCreditacao(int creditacao) {
        this.creditacao = creditacao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
