/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Marcus Filipe
 */
public class Departamento {
    
    private String nome;
    private int codigo, campus;
    private ArrayList<Departamento> dept = new ArrayList<>();

    public Departamento() {
    }

    
    
    public Departamento(String nome, int codigo, int campus) {
        this.nome = nome;
        this.codigo = codigo;
        this.campus = campus;
    }
    
    public void pesquisar(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        x.pesquisar(dept);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
        this.campus = campus;
    }

    public ArrayList<Departamento> getDept() {
        return dept;
    }

    public void setDept(ArrayList<Departamento> dept) {
        this.dept = dept;
    }
    
    
       
    
}
