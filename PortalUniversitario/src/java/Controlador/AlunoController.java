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
    
   
        String matricula,nome,curso,telefone,email,semestreInicio,formaIngresso,opcao;
        int creditacao;
        
        opcao = request.getParameter("opcao");
        
    switch (opcao) {
      case "preencher":
            Model.Resultados resultados = new Model.Resultados(); 
            request.setAttribute("results", resultados);
            RequestDispatcher dispatcher2 = request.getRequestDispatcher("coord_aluno.jsp");
            dispatcher2.forward(request,response);
            break;
        case "cadastro":
            matricula = request.getParameter("matricula");
            nome = request.getParameter("nome");
            curso = request.getParameter("curso");
            telefone = request.getParameter("telefone");
            email = request.getParameter("email");
            semestreInicio = request.getParameter("semestreInicio");
            formaIngresso = request.getParameter("formaIngresso");
            creditacao = Integer.parseInt(request.getParameter("creditacao"));
            Model.Aluno aluno = new Model.Aluno(matricula,nome,curso,telefone,email,semestreInicio,formaIngresso,creditacao);
            aluno.incluir();
            break;
        case "consulta":
            Banco.AlunoDAO x = new Banco.AlunoDAO();
            request.setAttribute("resultado_banco",x);          
            if(opcao.equals("consulta"))
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("Balanco.jsp");
                dispatcher.forward(request, response);
            }
            break;
        default:
            //alteração
            break;
    }
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
 

