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
public class Departamento {

    private String nome, nomeCampus, codigo;
    private int campus,id;
    private ArrayList<Departamento> dept = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String nome) {
        this.nome = nome;
    }

    public Departamento(String nome, String nomeCampus, String codigo) {
        this.nome = nome;
        this.nomeCampus = nomeCampus;
        this.codigo = codigo;
    }

    public Departamento(String nome, String codigo, int campus) {
        this.nome = nome;
        this.codigo = codigo;
        this.campus = campus;
    }

    public void incluir(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        x.incluir(this);
    }

    public void alterar(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        x.alterar(this);
    }

    public void deletar(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        x.deletar(this);
    }

    public void pesquisar(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        x.pesquisar(dept);
    }

    public void pesquisarDepartamento(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        ResultSet resultado = x.pesquisarDepartamento(this);
        try{
        while (resultado.next())
        {
            this.campus = resultado.getInt("Fk_Campus");
            this.nome = resultado.getString("departamentos.Nome");
            this.nomeCampus = resultado.getString("campus.nome");
            this.id = Integer.parseInt(resultado.getString("departamentos.Id"));
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }

    public void pesquisarDepartamentoPorId(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        ResultSet resultado = x.pesquisarDepartamentoPorId(this);
        try{
        while (resultado.next())
        {
            System.out.println("Entrou no dep");
            this.campus = resultado.getInt("Fk_Campus");
            this.nome = resultado.getString("departamentos.Nome");
            this.nomeCampus = resultado.getString("campus.nome");
            this.codigo = resultado.getString("departamentos.Codigo");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCampus() {
        return campus;
    }

    public void setCampus(int campus) {
        this.campus = campus;
    }

    public String getNomeCampus() {
        return nomeCampus;
    }

    public void setNomeCampus(String nomeCampus) {
        this.nomeCampus = nomeCampus;
    }

    public ArrayList<Departamento> getDept() {
        return dept;
    }

    public void setDept(ArrayList<Departamento> dept) {
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}
