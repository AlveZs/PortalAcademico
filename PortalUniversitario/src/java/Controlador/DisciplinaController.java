/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Curso;
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
@WebServlet(name = "DisciplinaController", urlPatterns = {"/DisciplinaController"})
public class DisciplinaController extends HttpServlet {

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
            String  nome,codigo, opcao;
            int creditacao,cargaHoraria,semestre,idTipo,curso;            
            opcao= request.getParameter("opcao");
            RequestDispatcher dispatcherDefault = request.getRequestDispatcher("DisciplinaController?opcao=preencher");
            switch (opcao){
                case "Buscar":
                    Model.Resultados resultadosBusca = new Model.Resultados();
                    request.setAttribute("results", resultadosBusca);
                    Model.Disciplina disciplinaBusca = new Model.Disciplina();
                    disciplinaBusca.setCodigo(request.getParameter("codigo"));
                    disciplinaBusca.pesquisarDisciplina();
                    request.setAttribute("disc", disciplinaBusca);
                    RequestDispatcher dispatcherBusca = request.getRequestDispatcher("disciplina_preenchida.jsp");
                    dispatcherBusca.forward(request, response);  
                    break;
                case "preencher":
                    RequestDispatcher dispatcherDisc = request.getRequestDispatcher("coord_disciplina.jsp");
                    dispatcherDisc.forward(request,response);
                    break;
                case "Incluir":
                    nome = request.getParameter("nome");
                    codigo = request.getParameter("codigo");
                    creditacao = Integer.parseInt(request.getParameter("creditacao"));
                    cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
                    semestre = Integer.parseInt(request.getParameter("semestre"));
                    if (request.getParameter("optativa") == null)
                        idTipo = 1;
                    else
                        idTipo = Integer.parseInt(request.getParameter("optativa"));
                    curso = Integer.parseInt(request.getParameter("curso"));
                    Model.Disciplina disciplinaInc = new Model.Disciplina(nome, semestre, idTipo, codigo, creditacao, cargaHoraria);
                    disciplinaInc.getCurso().setId(curso);
                    disciplinaInc.getCurso().pesquisar();
                    disciplinaInc.incluir();
                    dispatcherDefault.forward(request, response);
                    break;
                case "Alterar":
                    nome = request.getParameter("nome");
                    codigo = request.getParameter("codigo");
                    creditacao = Integer.parseInt(request.getParameter("creditacao"));
                    cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
                    semestre = Integer.parseInt(request.getParameter("semestre"));
                    if (request.getParameter("optativa") == null)
                        idTipo = 1;
                    else
                        idTipo = Integer.parseInt(request.getParameter("optativa"));
                    curso = Integer.parseInt(request.getParameter("curso"));
                    Model.Disciplina disciplinaAlt = new Model.Disciplina(nome, semestre, idTipo, codigo, creditacao, cargaHoraria);
                    disciplinaAlt.getCurso().setId(curso);
                    disciplinaAlt.getCurso().pesquisar();
                    disciplinaAlt.alterar();
                    dispatcherDefault.forward(request, response);
                    break;
                case "Deletar":
                    Model.Disciplina disciplinaDel = new Model.Disciplina();
                    disciplinaDel.setCodigo(request.getParameter("codigo"));    
                    disciplinaDel.deletar();
                    dispatcherDefault.forward(request, response);
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
