/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joao
 */
@WebServlet(name = "DepartamentoController", urlPatterns = {"/DepartamentoController"})
public class DepartamentoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        request.setCharacterEncoding("UTF-8");
            String nome, nomeCampus, codigo,opcao;
            int campus;
            opcao= request.getParameter("opcao");
            RequestDispatcher dispatcher;
            switch (opcao){
                case "Buscar":
                    Model.Resultados resultadosBusca = new Model.Resultados();
                    request.setAttribute("results", resultadosBusca);
                    Model.Departamento departBusca = new Model.Departamento();
                    departBusca.setCodigo(request.getParameter("codDept"));
                    departBusca.pesquisarDepartamento();
                    request.setAttribute("depart", departBusca);
                    dispatcher = request.getRequestDispatcher("departamento_preenchida.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "preencher":
                    Model.Resultados resultados = new Model.Resultados();
                    request.setAttribute("results", resultados);
                    dispatcher = request.getRequestDispatcher("departamento.jsp");
                    dispatcher.forward(request,response);
                    break;
                case "Incluir":
                    nome = request.getParameter("nome");
                    codigo = request.getParameter("codDept");
                    campus = Integer.parseInt(request.getParameter("campus"));
                    Model.Departamento departInc = new Model.Departamento(nome, codigo, campus);
                    departInc.incluir();
                    dispatcher = request.getRequestDispatcher("departamento.jsp");
                    dispatcher.forward(request,response);
                    break;
                case "Alterar":
                    campus = Integer.parseInt(request.getParameter("campus"));
                    nome = request.getParameter("nome");
                    codigo = request.getParameter("codDept");
                    Model.Departamento departAlt = new Model.Departamento(nome, codigo, campus);
                    departAlt.alterar();
                    dispatcher = request.getRequestDispatcher("departamento.jsp");
                    dispatcher.forward(request,response);
                    break;
                case "Deletar":
                    Model.Departamento departDel = new Model.Departamento();
                    departDel.setCodigo(request.getParameter("codDept"));
                    departDel.deletar();
                    dispatcher = request.getRequestDispatcher("departamento.jsp");
                    dispatcher.forward(request,response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
