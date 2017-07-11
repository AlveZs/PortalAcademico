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
public class Resultados {
    ArrayList<Aluno> alunos = new ArrayList();
    ArrayList<Curso> cursos = new ArrayList();
    ArrayList<Disciplina> disciplinas = new ArrayList();
    ArrayList<Departamento> departamentos = new ArrayList();
    ArrayList<Campus> campus = new ArrayList();
    ArrayList<Historico> historico = new ArrayList();
    ArrayList<String> formasIngresso = new ArrayList();

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public ArrayList<Campus> getCampus() {
        return campus;
    }

    public void setCampus(ArrayList<Campus> campus) {
        this.campus = campus;
    }

    public ArrayList<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<Historico> historico) {
        this.historico = historico;
    }
    
    public ArrayList<String> getFormasIngresso() {
        return formasIngresso;
    }

    public void setFormasIngresso(ArrayList<String> formasIngresso) {
        this.formasIngresso = formasIngresso;
    }
   
    public void pesquisarTodosDepartamentos(){
        Banco.DepartamentoDAO x = new Banco.DepartamentoDAO();
        x.pesquisarDepartamentos(departamentos);
    }

    public void pesquisarTodasDisciplinas(){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        x.pesquisarDisciplinas(disciplinas);
    }
    
    public void pesquisarTodosCursos(){
        Banco.CursoDAO x = new Banco.CursoDAO();
        x.pesquisarCursos(cursos);
    }
    
    public void pesquisarTodosCampus(){
        Banco.CampusDAO x = new Banco.CampusDAO();
        x.pesquisarCampus(campus);
    }
    
    public void pesquisarTodosAlunos(String curso){
        Banco.AlunoDAO x = new Banco.AlunoDAO();
        x.pesquisarTodosAlunos(alunos, curso);
    }    
    
    public void pesquisarHistorico(){
        Banco.HistoricoDAO x = new Banco.HistoricoDAO();
        x.pesquisarHistorico(historico);
    }
    
    public void pesquisarResultadosHistorico(int IDcurso){
        Banco.HistoricoDAO x = new Banco.HistoricoDAO();
        x.pesquisarResultadosHistorico(disciplinas, IDcurso);
    }
    
    public void pesquisarFormasIngresso() {
        Banco.AlunoDAO x = new Banco.AlunoDAO();
        x.pesquisarTodasFormaIngresso(formasIngresso);
    }
    
    
      public void PesquisarDisciplinasAluno(int matricula){
        Banco.DisciplinaDAO x = new Banco.DisciplinaDAO();
        x.PesquisarDisciplinasAluno(disciplinas,matricula);
    }
    
}
