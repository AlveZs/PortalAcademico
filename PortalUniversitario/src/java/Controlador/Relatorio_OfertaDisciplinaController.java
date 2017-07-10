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
 * @author John_Peter
 */
@WebServlet(name = "Relatorio_OfertaDisciplinaController", urlPatterns = {"/Relatorio_OfertaDisciplinaController"})
public class Relatorio_OfertaDisciplinaController extends HttpServlet {

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

        String opcao;
        
        Model.Resultados resultados = new Model.Resultados();
        request.setAttribute("results", resultados);
        RequestDispatcher dispatcher;
        
        ArrayList<Model.Curso> cursos = new ArrayList();
        resultados.pesquisarTodosCursos();
        cursos = resultados.getCursos();
        
        ArrayList<Model.Departamento> departamentos = new ArrayList();
        resultados.pesquisarTodosDepartamentos();
        departamentos = resultados.getDepartamentos();
        
        StringBuilder sb = new StringBuilder(""); //cria uma lista de String
        
        for(int i=0; i<cursos.size(); i++) {
            for (int j=0; j<departamentos.size(); j++) {
                if (cursos.get(i).getDepartamento().getNome().equals(departamentos.get(j).getNome())) {
                    cursos.get(i).getDepartamento().setNomeCampus(departamentos.get(j).getNomeCampus());
                    cursos.get(i).getDepartamento().setId(departamentos.get(j).getId());
                    departamentos.get(j).pesquisarDepartamento();
                    cursos.get(i).getDepartamento().setCampus(departamentos.get(j).getCampus());
                }
            }
            sb.append(cursos.get(i).getNome() + "-" + cursos.get(i).getDepartamento().getNome() + ":" + cursos.get(i).getDepartamento().getNomeCampus()+ "?" + cursos.get(i).getIdCurso() + "/" + cursos.get(i).getDepartamento().getId() + "*" + cursos.get(i).getDepartamento().getCampus() + "=");
        }
        
        out.println(sb); //Saída que será lida pelo AJAX
        
        request.setCharacterEncoding("UTF-8");
        opcao = request.getParameter("opcao");
        
        switch (opcao) {
            case "Buscar":
                dispatcher = request.getRequestDispatcher("relatorio_oferta_materias_preenchida.jsp");
                dispatcher.forward(request, response);
                break;
            case "preencher":
                dispatcher = request.getRequestDispatcher("relatorio_oferta_materias.jsp");
                dispatcher.forward(request,response);
                break;
            default:
                //alteração
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
