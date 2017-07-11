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
    
    private String  nome,tipo,codigo,situacao;
    private Curso curso = new Curso();
    private int creditacao,cargaHoraria,semestre,idTipo,id, qtdPendentes;

    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina() {
        curso = new Curso();
    }

    public Disciplina(String nome, int semestre,int idTipo, String codigo, int creditacao, int cargaHoraria) {
        this.nome = nome;
        this.semestre = semestre;
        this.idTipo = idTipo;
        this.codigo = codigo;
        this.creditacao = creditacao;
        this.cargaHoraria = cargaHoraria;
        curso = new Curso();
    }

    public Disciplina(String nome,int semestre, String tipo, String codigo, int creditacao, int cargaHoraria) {
        this.nome = nome;
        this.tipo = tipo;
        this.codigo = codigo;
        this.creditacao = creditacao;
        this.cargaHoraria = cargaHoraria;
        this.semestre = semestre;
        curso = new Curso();
    }
    
    public void incluir(){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        x.incluir(this);
    }
    
    public void alterar(){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        x.alterar(this);
    }
    
    public void deletar(){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        x.deletar(this);
    } 

    public void pesquisarTodos(int cod){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        x.pesquisarTodas(disciplinas,cod);
    }
    
    public void pesquisarDisciplina(){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        ResultSet resultado = x.pesquisarDisciplina(this);
        try{
        while (resultado.next())
        {
            this.nome = resultado.getString("disciplinas.Nome");
            this.cargaHoraria = resultado.getInt("disciplinas.CargaHoraria");
            this.creditacao = resultado.getInt("disciplinas.Creditacao");
            this.curso.setId(resultado.getInt("disciplinas.Fk_Cursos"));
            this.curso.setNome(resultado.getString("cursos.Nome"));
            this.curso.getDepartamento().setNome(resultado.getString("Departamento"));
            this.curso.getDepartamento().setNomeCampus(resultado.getString("Campus"));
            this.idTipo = resultado.getInt("disciplinas.Fk_Tipo");
            this.semestre = resultado.getInt("disciplinas.Semestre");
            this.id = resultado.getInt("disciplinas.Id");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }
    
    public void pesquisarIdCurso(){
       this.curso.pesquisarCodCurso();
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getQtdPendentes() {
        return qtdPendentes;
    }

    public void setQtdPendentes(int qtdPendentes) {
        this.qtdPendentes = qtdPendentes;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Disciplina(String nome, String tipo, String codigo, String situacao, int creditacao, int cargaHoraria, int semestre, int idTipo, int id, int qtdPendentes) {
        this.nome = nome;
        this.tipo = tipo;
        this.codigo = codigo;
        this.situacao = situacao;
        this.creditacao = creditacao;
        this.cargaHoraria = cargaHoraria;
        this.semestre = semestre;
        this.idTipo = idTipo;
        this.id = id;
        this.qtdPendentes = qtdPendentes;
    }
    
}
