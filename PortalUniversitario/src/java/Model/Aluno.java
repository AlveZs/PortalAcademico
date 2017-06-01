/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcus Filipe
 */
public class Aluno {
    
    private String matricula,nome,telefone,email,semestreInicio,formaIngresso;
    private Curso curso = new Curso();
    private int creditacao,formaIngressoCod,cursoCod;
    private ArrayList<Curso> cursos = new ArrayList<>();

    public Aluno(String matricula, String nome, String telefone, String email, String semestreInicio, String formaIngresso, int creditacao) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.semestreInicio = semestreInicio;
        this.formaIngresso = formaIngresso;
        this.creditacao = creditacao;
    }

    public Aluno() {
    }
    
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSemestreInicio() {
        return semestreInicio;
    }

    public void setSemestreInicio(String semestreInicio) {
        this.semestreInicio = semestreInicio;
    }

    public String getFormaIngresso() {
        return formaIngresso;
    }

    public void setFormaIngresso(String formaIngresso) {
        this.formaIngresso = formaIngresso;
    }

    public int getCreditacao() {
        return creditacao;
    }

    public void setCreditacao(int creditacao) {
        this.creditacao = creditacao;
    }

    public int getFormaIngressoCod() {
        return formaIngressoCod;
    }

    public void setFormaIngressoCod(int formaIngressoCod) {
        this.formaIngressoCod = formaIngressoCod;
    }

    public int getCursoCod() {
        return cursoCod;
    }

    public void setCursoCod(int cursoCod) {
        this.cursoCod = cursoCod;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void incluir(){
        Banco.AlunoDAO x = new Banco.AlunoDAO();
        x.incluir(this);        
    }
    
    public void alterar(){
        Banco.AlunoDAO x = new Banco.AlunoDAO();
        x.alterar(this);        
    }
    
    public void deletar(){
        Banco.AlunoDAO x = new Banco.AlunoDAO();
        x.deletar(this);        
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
       
    
    public void pesquisarCodFormaIng(){
        Banco.AlunoDAO x = new Banco.AlunoDAO();
        ResultSet resultado = x.pesquisarFormaIngresso(this);
        try{
        while (resultado.next())
        {
            this.formaIngressoCod = resultado.getInt("Id");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }
    
    public void pesquisarCurso(){
        Banco.AlunoDAO x = new Banco.AlunoDAO();
        ResultSet resultado = x.pesquisarCurso(this);
        try{
        while (resultado.next())
        {
            this.cursoCod = resultado.getInt("Id");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }
    
    public void pesquisarTodos(){
        Banco.CursoDAO x = new Banco.CursoDAO();
        x.pesquisarTodos(cursos);
    }
    
    public void pesquisarIdCurso(){
       this.curso.pesquisarCodCurso();
    }
    
}
