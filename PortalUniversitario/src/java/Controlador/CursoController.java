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
@WebServlet(name = "CursoController", urlPatterns = {"/CursoController"})
public class CursoController extends HttpServlet {

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
        String nome,departamento,opcao;
        int cargaHoraria, creditacao, codigo, minSemestre, maxSemestre, turno;
        opcao= request.getParameter("opcao");
        switch (opcao){
            case "Buscar":
                Model.Curso curso = new Model.Curso(Integer.parseInt(request.getParameter("codigo")));
                Model.Disciplina disciplina = new Model.Disciplina();
                disciplina.pesquisarTodos(Integer.parseInt(request.getParameter("codigo")));
                curso.pesquisar();
                request.setAttribute("d", disciplina);
                request.setAttribute("c", curso);
                RequestDispatcher dispatcher = request.getRequestDispatcher("coord_curso_preenchida.jsp");
                dispatcher.forward(request,response);
                break;
            case "Incluir":
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nome = request.getParameter("nome");
                departamento = request.getParameter("departamento");
                cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
                creditacao = Integer.parseInt(request.getParameter("credito"));
                turno = Integer.parseInt(request.getParameter("turno"));
                Model.Curso curs = new Model.Curso(nome, departamento, cargaHoraria, creditacao, codigo, turno);
                curs.incluir();
                break;
            case "preencher":
                Model.Departamento dept = new Model.Departamento(); 
                dept.pesquisar();
                request.setAttribute("depart", dept);
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("coord_curso.jsp");
                dispatcher2.forward(request,response);
                break;
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
