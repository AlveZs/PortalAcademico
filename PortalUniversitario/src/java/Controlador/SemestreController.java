/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SemestreController", urlPatterns = {"/SemestreController"})
public class SemestreController extends HttpServlet {

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
        int ano, semestre;
        String opcao;
        opcao = request.getParameter("opcao");
        switch (opcao){
            case "Buscar":
                Model.Semestre sc = new Model.Semestre();
                sc.listarTodos(); 
                request.setAttribute("sc", sc);
                RequestDispatcher dispatcher = request.getRequestDispatcher("semestre_preenchida.jsp");
                dispatcher.forward(request,response);                
                break;
            case "Incluir":
                ano = Integer.parseInt(request.getParameter("ano"));
                semestre = Integer.parseInt(request.getParameter("semestre"));
                Model.Semestre scancelado = new Model.Semestre(ano,semestre);
                scancelado.incluir();
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("coord_semestre.jsp");
                dispatcher2.forward(request,response);                   
                break;
            case "Deletar":
                ano = Integer.parseInt(request.getParameter("ano"));
                semestre =Integer.parseInt(request.getParameter("semestre"));
                Model.Semestre scDel = new Model.Semestre(ano, semestre);
                scDel.deletar();
                RequestDispatcher dispatcher3 = request.getRequestDispatcher("coord_semestre.jsp");
                dispatcher3.forward(request,response);  
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
