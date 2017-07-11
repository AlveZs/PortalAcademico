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
public class Usuario {
    private String nome, senha;
    private int tipoUser, matricula,id;
    private Campus campus = new Campus();
    private Departamento departamento = new Departamento();
    private Curso curso = new Curso();

    public Usuario() {
    }

    public Usuario(String nome, String senha, int tipoUser, int matricula) {
        this.nome = nome;
        this.senha = senha;
        this.tipoUser = tipoUser;
        this.matricula = matricula;
    }

    public Usuario(String nome, String senha, int tipoUser, int matricula, Campus campus, Departamento departamento, Curso curso) {
        this.nome = nome;
        this.senha = senha;
        this.tipoUser = tipoUser;
        this.matricula = matricula;
        this.campus = campus;
        this.departamento = departamento;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void incluir(){
        Banco.UsuarioDAO x = new Banco.UsuarioDAO();
        x.incluir(this);
    }

    public void alterar(){
        Banco.UsuarioDAO x = new Banco.UsuarioDAO();
        x.alterar(this);
    }

    public void deletar(){
        Banco.UsuarioDAO x = new Banco.UsuarioDAO();
        x.deletar(this);
    }

    public void pesquisarUsuario(){
        Banco.UsuarioDAO x = new Banco.UsuarioDAO();
        ResultSet resultado = x.pesquisarUsuario(this);
        try{
        while (resultado.next())
        {
            System.out.println("Entrou!");
            this.nome = resultado.getString("usuarios.nome");
            this.tipoUser = resultado.getInt("usuarios.tipUser");
            this.id= resultado.getInt("usuarios.id");
            if (tipoUser == 4 || tipoUser == 5 || tipoUser == 6) {
                System.out.println("entrou no IF");
                //this.curso.setNome(resultado.getString("cursos.Nome"));
                this.curso.setId(resultado.getInt("usuarios.Fk_Cursos"));
                //this.curso.getDepartamento().setNome(resultado.getString("departamentos.Nome"));
                //this.curso.getDepartamento().setNomeCampus(resultado.getString("campus.Nome"));
                this.curso.getDepartamento().setId(resultado.getInt("usuarios.Fk_Departamentos"));
                this.curso.getDepartamento().setCampus(resultado.getInt("usuarios.Fk_Campus"));
                this.curso.pesquisar();
                System.out.println(this.curso.getNome());
            }
            //this.campus.setNome(resultado.getString("campus.Nome"));
            this.campus.setId(resultado.getInt("usuarios.Fk_Campus"));
            //this.departamento.setNome(resultado.getString("departamentos.Nome"));
            this.departamento.setId(resultado.getInt("usuarios.Fk_Departamentos"));
            this.departamento.pesquisarDepartamentoPorId();
            this.senha = resultado.getString("usuarios.senha");
            System.out.println(this.departamento.getNome());
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }


}
