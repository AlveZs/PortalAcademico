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

    String nome,curso,telefone,email,semestreInicio,formaIngresso,opcao;
    int matricula,creditacao;
    
    Model.Resultados resultadosBusca = new Model.Resultados();
    request.setAttribute("results", resultadosBusca);
    RequestDispatcher dispatcher;
    
    request.setCharacterEncoding("UTF-8");
    opcao = request.getParameter("opcao");
        
    switch (opcao) {
        case "Buscar":
            Model.Aluno alunoBusca = new Model.Aluno();
            alunoBusca.setMatricula(Integer.parseInt(request.getParameter("matricula")));
            alunoBusca.pesquisarAluno();
            request.setAttribute("x", alunoBusca);
            dispatcher = request.getRequestDispatcher("coord_aluno_preenchida.jsp");
            dispatcher.forward(request, response);
            break;
      case "preencher":
            dispatcher = request.getRequestDispatcher("coord_aluno.jsp");
            dispatcher.forward(request,response);
            break;
        case "cadastro":
            matricula = Integer.parseInt(request.getParameter("matricula"));
            nome = request.getParameter("nome");
            curso = request.getParameter("curso");
            telefone = request.getParameter("telefone");
            email = request.getParameter("email");
            semestreInicio = request.getParameter("sems_inicio");
            formaIngresso = request.getParameter("forma_ingresso");
            creditacao = Integer.parseInt(request.getParameter("creditacao"));
            //turno = Integer.parseInt(request.getParameter("turno"));
            Model.Aluno aluno = new Model.Aluno(matricula,nome,telefone,email,semestreInicio,formaIngresso,creditacao);
            //aluno.setTurno(turno);
            aluno.getCurso().setNome(curso);
            aluno.pesquisarIdCurso();
            aluno.incluir();
            break;
        case "consulta":
            Banco.AlunoDAO x = new Banco.AlunoDAO();
            request.setAttribute("resultado_banco",x);          
            if(opcao.equals("consulta"))
            {
                dispatcher = request.getRequestDispatcher("Balanco.jsp");
                dispatcher.forward(request, response);
            }
            break;
        case "alterar":
            matricula = Integer.parseInt(request.getParameter("matricula"));
            nome = request.getParameter("nome");
            curso = request.getParameter("curso");
            telefone = request.getParameter("telefone");
            email = request.getParameter("email");
            semestreInicio = request.getParameter("sems_inicio");
            formaIngresso = request.getParameter("forma_ingresso");
            creditacao = Integer.parseInt(request.getParameter("creditacao"));
            Model.Aluno alunoAlt = new Model.Aluno(matricula,nome,telefone,email,semestreInicio,formaIngresso,creditacao);
            alunoAlt.getCurso().setNome(curso);
            alunoAlt.pesquisarIdCurso();
            alunoAlt.alterar();
            break;
        case "deletar":
            matricula = Integer.parseInt(request.getParameter("matricula"));
            Model.Aluno alunoDel = new Model.Aluno();
            alunoDel.setMatricula(matricula);
            alunoDel.deletar();
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
 

