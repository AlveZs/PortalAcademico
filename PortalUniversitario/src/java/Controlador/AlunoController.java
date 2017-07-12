/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
@WebServlet(name = "AlunoController", urlPatterns = {"/AlunoController"})
public class AlunoController extends HttpServlet {
  
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
try (PrintWriter out = response.getWriter()) {

    String nome,telefone,email,semestreInicio,formaIngresso,opcao;
    int matricula,creditacao, curso, semExternos;
    
    Model.Resultados resultadosBusca = new Model.Resultados();
    request.setAttribute("results", resultadosBusca);
    RequestDispatcher dispatcher;
    
    //request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8"); //o outro método está dando problema :/
    opcao = request.getParameter("opcao");
        
    switch (opcao) {
        case "Buscar":
            Model.Aluno alunoBusca = new Model.Aluno();
            alunoBusca.setMatricula(Integer.parseInt(request.getParameter("matricula")));
            alunoBusca.pesquisarAluno();
            if (alunoBusca.getId()==0){
                request.setAttribute("verNulo", "sim");
                dispatcher = request.getRequestDispatcher("coord_aluno.jsp");
                dispatcher.forward(request,response);
            }
            else{
                  Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
                ArrayList<Model.Disciplina> disc = new ArrayList();
                resultados.PesquisarDisciplinasAluno(Integer.parseInt(request.getParameter("matricula")));
                 disc = resultados.getDisciplinas();
                  request.setAttribute("y",disc);
                
                request.setAttribute("x", alunoBusca);
                dispatcher = request.getRequestDispatcher("coord_aluno_preenchida.jsp");
                dispatcher.forward(request, response);
            }
            break;
      case "preencher":
            request.setAttribute("verNulo", "nao");
            dispatcher = request.getRequestDispatcher("coord_aluno.jsp");
            dispatcher.forward(request,response);
            break;
        case "cadastro":
            matricula = Integer.parseInt(request.getParameter("matricula"));
            nome = request.getParameter("nome");
            curso = Integer.parseInt(request.getParameter("curso"));
            telefone = request.getParameter("telefone");
            email = request.getParameter("email");
            semExternos = Integer.parseInt(request.getParameter("sems_externos"));
            semestreInicio = request.getParameter("sems_inicio");
            formaIngresso = request.getParameter("forma_ingresso");
            creditacao = Integer.parseInt(request.getParameter("creditacao"));
            //turno = Integer.parseInt(request.getParameter("turno"));
            Model.Aluno aluno = new Model.Aluno(matricula,nome,telefone,email,semestreInicio,formaIngresso,creditacao);
            //aluno.setTurno(turno);
            aluno.getCurso().setId(curso);
            aluno.getCurso().pesquisar();
            aluno.setSemExternos(semExternos);
            aluno.incluir();
            request.setAttribute("verNulo", "nao");
            dispatcher = request.getRequestDispatcher("coord_aluno.jsp");
            dispatcher.forward(request,response);
            break;
        case "alterar":
            Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
            ArrayList<Model.Disciplina> disc = new ArrayList();
            resultados.PesquisarDisciplinasAluno(Integer.parseInt(request.getParameter("matricula")));
            disc = resultados.getDisciplinas();
            request.setAttribute("y",disc);
            matricula = Integer.parseInt(request.getParameter("matricula"));
            nome = request.getParameter("nome");
            curso = Integer.parseInt(request.getParameter("curso"));
            telefone = request.getParameter("telefone");
            email = request.getParameter("email");
            semExternos = Integer.parseInt(request.getParameter("sems_externos"));
            semestreInicio = request.getParameter("sems_inicio");
            formaIngresso = request.getParameter("forma_ingresso");
            creditacao = Integer.parseInt(request.getParameter("creditacao"));
            Model.Aluno alunoAlt = new Model.Aluno(matricula,nome,telefone,email,semestreInicio,formaIngresso,creditacao);
            alunoAlt.getCurso().setId(curso);
            alunoAlt.getCurso().pesquisar();
            alunoAlt.setSemExternos(semExternos);
            alunoAlt.alterar();
            request.setAttribute("x", alunoAlt);
            dispatcher = request.getRequestDispatcher("coord_aluno_preenchida.jsp");
            dispatcher.forward(request,response);
            break;
        case "deletar":
            matricula = Integer.parseInt(request.getParameter("matricula"));
            Model.Aluno alunoDel = new Model.Aluno();
            alunoDel.setMatricula(matricula);
            alunoDel.deletar();
            request.setAttribute("verNulo", "nao");
            dispatcher = request.getRequestDispatcher("coord_aluno.jsp");
            dispatcher.forward(request,response);
            break;
        default:
            //alteração
    }}
 } 





    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
} 
 

