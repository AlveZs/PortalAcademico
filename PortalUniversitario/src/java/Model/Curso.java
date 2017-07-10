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
 * @author Marcus Filipe
 */
public class Curso {

    private String nome;
    private Departamento departamento = new Departamento();
    private int cargaHoraria, creditacao, codigo, minSemestre, maxSemestre, turno, codDept,idCurso;

    public Curso(String nome, Departamento departamento, int cargaHoraria, int creditacao, int codigo, int minSemestre, int maxSemestre, int turno) {
        this.nome = nome;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.creditacao = creditacao;
        this.codigo = codigo;
        this.minSemestre = minSemestre;
        this.maxSemestre = maxSemestre;
        this.turno = turno;
    }

    public Curso(String nome, Departamento departamento, int cargaHoraria, int creditacao, int codigo, int turno) {
        this.nome = nome;
        this.departamento = departamento;
        this.cargaHoraria = cargaHoraria;
        this.creditacao = creditacao;
        this.codigo = codigo;
        this.turno = turno;
    }
    
    public Curso(String nome, String nomeDepartamento, int cargaHoraria, int creditacao, int codigo, int minSemestre, int maxSemestre, int turno) {
        this.nome = nome;
        this.departamento = new Departamento(nomeDepartamento);
        this.cargaHoraria = cargaHoraria;
        this.creditacao = creditacao;
        this.codigo = codigo;
        this.minSemestre = minSemestre;
        this.maxSemestre = maxSemestre;
        this.turno = turno;
    }

    public Curso(String nome, String nomeDepartamento, int cargaHoraria, int creditacao, int codigo, int turno) {
        this.nome = nome;
        this.departamento = new Departamento(nomeDepartamento);        
        this.cargaHoraria = cargaHoraria;
        this.creditacao = creditacao;
        this.codigo = codigo;
        this.turno = turno;
    }

    public Curso(int codigo) {
        this.codigo = codigo;
        this.departamento = new Departamento();
    }

    public Curso() {
        this.departamento = new Departamento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCreditacao() {
        return creditacao;
    }

    public void setCreditacao(int creditacao) {
        this.creditacao = creditacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getMinSemestre() {
        return minSemestre;
    }

    public void setMinSemestre(int minSemestre) {
        this.minSemestre = minSemestre;
    }

    public int getMaxSemestre() {
        return maxSemestre;
    }

    public void setMaxSemestre(int maxSemestre) {
        this.maxSemestre = maxSemestre;
    }

    public int getCodDept() {
        return codDept;
    }

    public void setCodDept(int codDept) {
        this.codDept = codDept;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setId(int id) {
        this.idCurso = id;
    }

    public void pesquisarCodDept(){
        Banco.CursoDAO x = new Banco.CursoDAO();
        ResultSet resultado = x.pesquisarCodDept(this);
        try{
        while (resultado.next())
        {
            departamento.setId(resultado.getInt("Id"));
            this.codDept = resultado.getInt("Id");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }

    public void pesquisarIdCurso(){
        Banco.CursoDAO x = new Banco.CursoDAO();
        ResultSet resultado = x.pesquisarIdCurso(this);
        try{
        while (resultado.next())
        {
            this.idCurso = resultado.getInt("Id");
            this.nome = resultado.getString("Nome");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }
    
    public void pesquisarCodCurso(){
        Banco.CursoDAO x = new Banco.CursoDAO();
        ResultSet resultado = x.pesquisarCodCurso(this);
        try{
        while (resultado.next())
        {
            this.codigo = resultado.getInt("Codigo");
            this.idCurso = resultado.getInt("Id");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }

    public void incluir(){
        Banco.CursoDAO x = new Banco.CursoDAO();
        x.incluir(this);
    }

    public void pesquisar(){
        Banco.CursoDAO x = new Banco.CursoDAO();
        ResultSet resultado = x.pesquisar(this);
        try{
        while (resultado.next())
        {
            this.nome = resultado.getString("cursos.Nome");
            this.departamento.setNome(resultado.getString("departamentos.Nome"));
            this.departamento.setCodigo(resultado.getString("departamentos.Codigo"));
            this.departamento.setNomeCampus(resultado.getString("campus.Nome"));
            this.departamento.setCampus(resultado.getInt("campus.Id"));
            this.creditacao = resultado.getInt("creditacao");
            this.cargaHoraria = resultado.getInt("CargaHoraria");
            this.minSemestre = resultado.getInt("Min_Semestre");
            this.maxSemestre = resultado.getInt("Max_Semestre");
            this.turno = resultado.getInt("fk_turno");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }
    
}
