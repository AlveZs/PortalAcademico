/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class Semestre {
    private int ano, semestre, id;
    private ArrayList<Semestre> todos = new ArrayList();

    public Semestre(int ano, int semestre) {
        this.ano = ano;
        this.semestre = semestre;
    }

    public Semestre() {
    }

    public Semestre(int id, int ano, int semestre) {
        this.ano = ano;
        this.semestre = semestre;
        this.id = id;
    }

    public ArrayList<Semestre> getTodos() {
        return todos;
    }

    public void setTodos(ArrayList<Semestre> todos) {
        this.todos = todos;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public void incluir(){
        Banco.SemestreDAO scDao = new Banco.SemestreDAO();
        scDao.incluir(this);
    }
    public void deletar(){
        Banco.SemestreDAO scDao = new Banco.SemestreDAO();
        scDao.deletar(this);
    }
    public void listarTodos(){
        Banco.SemestreDAO scDao = new Banco.SemestreDAO();
        scDao.ConsultaTodos(todos);
    }    
}
