/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Departamento;
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
         
        String nome,opcao;
        int cargaHoraria, creditacao, codigo, minSemestre, maxSemestre, turno;
        Departamento departamento = new Departamento();
        request.setCharacterEncoding("UTF-8");
        
        RequestDispatcher dispatcher;
        
        opcao= request.getParameter("opcao");
        switch (opcao){
            case "Buscar":
                Model.Curso curso = new Model.Curso(Integer.parseInt(request.getParameter("codigo")));
                Model.Disciplina disciplina = new Model.Disciplina();
                disciplina.pesquisarTodos(Integer.parseInt(request.getParameter("codigo")));
                curso.pesquisarIdCurso();
                if(curso.getIdCurso()==0){
                    request.setAttribute("verNulo", "sim");
                    Model.Departamento dept = new Model.Departamento(); 
                    dept.pesquisar();
                    request.setAttribute("depart", dept);
                    dispatcher = request.getRequestDispatcher("coord_curso.jsp");
                    dispatcher.forward(request,response);
                }
                else{    
                    curso.pesquisar();
                    request.setAttribute("d", disciplina);
                    request.setAttribute("c", curso);
                    dispatcher = request.getRequestDispatcher("coord_curso_preenchida.jsp");
                    dispatcher.forward(request,response);
                }
                break;
            case "Incluir":
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nome = request.getParameter("nome");
                departamento.setId(Integer.parseInt(request.getParameter("departamento")));
                departamento.pesquisarDepartamentoPorId();
                cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
                creditacao = Integer.parseInt(request.getParameter("credito"));
                turno = Integer.parseInt(request.getParameter("turno"));
                minSemestre = Integer.parseInt(request.getParameter("qtdMinSemestres"));
                maxSemestre = Integer.parseInt(request.getParameter("qtdMaxSemestres"));
                Model.Curso curs = new Model.Curso(nome, departamento, cargaHoraria, creditacao, codigo,minSemestre,maxSemestre,turno);
                curs.incluir();
                request.setAttribute("verNulo", "nao");
                dispatcher = request.getRequestDispatcher("coord_curso.jsp");
                dispatcher.forward(request,response);
                break;
            case "preencher":
                request.setAttribute("verNulo", "nao");
                Model.Departamento dept = new Model.Departamento(); 
                dept.pesquisar();
                request.setAttribute("depart", dept);
                dispatcher = request.getRequestDispatcher("coord_curso.jsp");
                dispatcher.forward(request,response);
                break;
            case "Alterar":
                codigo = Integer.parseInt(request.getParameter("codigo"));
                nome = request.getParameter("nome");
                departamento.setId(Integer.parseInt(request.getParameter("departamento")));
                departamento.pesquisarDepartamentoPorId();
                cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
                creditacao = Integer.parseInt(request.getParameter("credito"));
                turno = Integer.parseInt(request.getParameter("turno"));
                minSemestre = Integer.parseInt(request.getParameter("qtdMinSemestres"));
                maxSemestre = Integer.parseInt(request.getParameter("qtdMaxSemestres"));
                Model.Curso cursoAlt = new Model.Curso(nome, departamento, cargaHoraria, creditacao, codigo,minSemestre,maxSemestre,turno);
                cursoAlt.alterar();
                request.setAttribute("verNulo", "nao");
                dispatcher = request.getRequestDispatcher("coord_curso.jsp");
                dispatcher.forward(request,response);
                break;
            case "Deletar":
                codigo = Integer.parseInt(request.getParameter("codigo"));
                Model.Curso cursoDel = new Model.Curso();
                cursoDel.setCodigo(codigo);
                cursoDel.deletar();
                request.setAttribute("verNulo", "nao");
                dispatcher = request.getRequestDispatcher("coord_curso.jsp");
                dispatcher.forward(request,response);
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
