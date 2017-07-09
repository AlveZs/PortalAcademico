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
public class Integralizacao {
    private int semInicio,qtdSemestres,mesAtual,qtdSemestresCancelados,semAtual,materiasRestantes,materiasCurso,materiasAprovadas;
    private Aluno aluno =  new Aluno();
    private Curso curso = new Curso();
    

    public Integralizacao() {
    }

    public int getMesAtual() {
        return mesAtual;
    }

    public void setMesAtual(int mesAtual) {
        this.mesAtual = mesAtual;
    }

    public int getQtdSemestresCancelados() {
        return qtdSemestresCancelados;
    }

    public void setQtdSemestresCancelados(int qtdSemestresCancelados) {
        this.qtdSemestresCancelados = qtdSemestresCancelados;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getSemInicio() {
        return semInicio;
    }

    public void setSemInicio(int semInicio) {
        this.semInicio = semInicio;
    }

    public int getQtdtSemestres() {
        return qtdSemestres;
    }

    public void setQtdSemestres(int qtdSemestre) {
        this.qtdSemestres = qtdSemestres;
    }

    public int getSemAtual() {
        return semAtual;
    }

    public void setSemAtual(int semAtual) {
        this.semAtual = semAtual;
    }

    public int getMateriasRestantes() {
        return materiasRestantes;
    }

    public void setMateriasRestantes(int materiasRestantes) {
        this.materiasRestantes = materiasRestantes;
    }

    public int getMateriasCurso() {
        return materiasCurso;
    }

    public void setMateriasCurso(int materiasCurso) {
        this.materiasCurso = materiasCurso;
    }

    public int getMateriasAprovadas() {
        return materiasAprovadas;
    }

    public void setMateriasAprovadas(int materiasAprovadas) {
        this.materiasAprovadas = materiasAprovadas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    
    public void pesquisarInfos(){
        Banco.IntegralizacaoDAO x = new Banco.IntegralizacaoDAO();
        ResultSet resultado = x.pesquisaNumeroSemestre(this.aluno);
        try{
        while (resultado.next())
        {
            this.qtdSemestres = resultado.getInt("Semestres");
            this.mesAtual = resultado.getInt("Mes");
            this.semInicio = resultado.getInt("SemestreInicio");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }
    
    public void pesquisarSemCancelados(){
        Banco.IntegralizacaoDAO x = new Banco.IntegralizacaoDAO();
        ResultSet resultado = x.pesquisaSemCancelados(aluno);
        try{
        while (resultado.next())
        {
            this.qtdSemestresCancelados = resultado.getInt("SemCancelados");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }
    
    public void calculaQtdSemestres(){
        if(mesAtual<=6)
            semAtual = 1;
        else
            semAtual = 2;
        if (semInicio != semAtual){
            qtdSemestres += 1;
            qtdSemestres -= qtdSemestresCancelados;
        }
        else{
            
            qtdSemestres -= qtdSemestresCancelados;
        }
    }
    
    public void pesquisarQtdMat(){
        Banco.IntegralizacaoDAO x = new Banco.IntegralizacaoDAO();
        ResultSet resultado = x.pesquisaMateriasCurso(curso);
        try{
        while (resultado.next())
        {
            this.materiasCurso = resultado.getInt("discT");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }
    
    public void pesquisarQtdAprovadas(){
        Banco.IntegralizacaoDAO x = new Banco.IntegralizacaoDAO();
        ResultSet resultado = x.pesquisaMateriasAprovadas(aluno);
        try{
        while (resultado.next())
        {
            this.materiasAprovadas = resultado.getInt("Aprovadas");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }    
    }    
    
    public void calculaMateriasRestantes(){
        materiasRestantes = materiasCurso - materiasAprovadas;
    }
    
    public String verificaSituacao(String nomeCurso){
        int materiasSemestre,materiasRestantes,semRestantes;
        float mediaAluno,valorAlarme;
        curso.setNome(nomeCurso);
        curso.pesquisarCodCurso();
        curso.pesquisar();
        semRestantes = curso.getMaxSemestre() - qtdSemestres;
        materiasSemestre = materiasCurso/curso.getMinSemestre();
        materiasRestantes = materiasCurso - materiasAprovadas;
        valorAlarme = materiasCurso/curso.getMaxSemestre();
        this.calculaQtdSemestres();
        if(qtdSemestres!=0){
            mediaAluno = materiasAprovadas/qtdSemestres;
            if((materiasSemestre * semRestantes >= materiasCurso - materiasAprovadas) && mediaAluno>valorAlarme) {
                return "Integralizado";
            }
            else if ((materiasSemestre * semRestantes >= materiasCurso - materiasAprovadas) && mediaAluno<=valorAlarme)
                return "Atenção";
            else if (((materiasSemestre * semRestantes >= materiasCurso - materiasAprovadas)) && (qtdSemestres > curso.getMaxSemestre()-3 && qtdSemestres<curso.getMaxSemestre())){
                return "Crítica";
            }
            else
                return "Jubilado";
        }
        else
            return "Calouro";
    }
}
