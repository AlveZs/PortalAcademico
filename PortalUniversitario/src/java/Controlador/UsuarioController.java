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
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
                String nome, senha, opcao;
                int tipoUser, matricula, campus, departamento, curso;
                opcao= request.getParameter("opcao");         
                RequestDispatcher dispatcherDefault = request.getRequestDispatcher("UsuarioController?opcao=preencher");
            switch (opcao){
                case "Buscar":
                    Model.Resultados resultadosBusca = new Model.Resultados();
                    request.setAttribute("results", resultadosBusca);
                    Model.Usuario usuarioBusca = new Model.Usuario();
                    usuarioBusca.setMatricula(Integer.parseInt(request.getParameter("matricula")));
                    usuarioBusca.pesquisarUsuario();
                    request.setAttribute("usr", usuarioBusca);
                    RequestDispatcher dispatcherBusca = request.getRequestDispatcher("usuario_preenchida.jsp");
                    dispatcherBusca.forward(request, response);                    
                    /*
                    Model.Resultados resultadosBusca = new Model.Resultados();
                    request.setAttribute("results", resultadosBusca);
                    Model.Departamento departBusca = new Model.Departamento();
                    departBusca.setCodigo(request.getParameter("codDept"));
                    departBusca.pesquisarDepartamento();
                    request.setAttribute("depart", departBusca);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("departamento_preenchida.jsp");
                    dispatcher.forward(request, response);
                    */
                    break;
                case "preencher":
                    Model.Resultados resultados = new Model.Resultados();
                    request.setAttribute("results", resultados);
                    RequestDispatcher dispatcherUsr = request.getRequestDispatcher("usuario.jsp");
                    dispatcherUsr.forward(request,response);
                    break;
                case "Incluir":
                    nome = request.getParameter("nome");
                    matricula = Integer.parseInt(request.getParameter("matricula"));
                    campus = Integer.parseInt(request.getParameter("campus"));
                    tipoUser = Integer.parseInt(request.getParameter("tipo"));
                    curso = Integer.parseInt(request.getParameter("curso"));
                    departamento = Integer.parseInt(request.getParameter("departamento"));
                    senha = request.getParameter("senha");
                    Model.Usuario usuario = new Model.Usuario(nome, senha, tipoUser, matricula);
                    usuario.getDepartamento().setId(departamento);
                    usuario.getDepartamento().pesquisarDepartamento();
                    usuario.getCampus().setId(campus);
                    if (curso!=0) {
                        usuario.getCurso().setId(curso);
                        usuario.getCurso().pesquisar();
                    }
                    usuario.incluir();
                    dispatcherDefault.forward(request, response);
                    /*
                    nome = request.getParameter("nome");
                    codigo = request.getParameter("codDept");
                    campus = Integer.parseInt(request.getParameter("campus"));
                    Model.Departamento departInc = new Model.Departamento(nome, codigo, campus);
                    departInc.incluir();
                    dispatcher2.forward(request,response);
                    */
                    break;
                case "Alterar":
                    nome = request.getParameter("nome");
                    matricula = Integer.parseInt(request.getParameter("matricula"));
                    campus = Integer.parseInt(request.getParameter("campus"));
                    tipoUser = Integer.parseInt(request.getParameter("tipo"));
                    curso = Integer.parseInt(request.getParameter("curso"));
                    departamento = Integer.parseInt(request.getParameter("departamento"));
                    senha = request.getParameter("senha");
                    Model.Usuario usuarioAlt = new Model.Usuario(nome, senha, tipoUser, matricula);
                    usuarioAlt.getDepartamento().setId(departamento);
                    usuarioAlt.getDepartamento().pesquisarDepartamento();
                    usuarioAlt.getCampus().setId(campus);
                    if (curso!=0) {
                        usuarioAlt.getCurso().setId(curso);
                        usuarioAlt.getCurso().pesquisar();
                    }
                    usuarioAlt.alterar();
                    dispatcherDefault.forward(request, response);
                    /*
                    campus = Integer.parseInt(request.getParameter("campus"));
                    nome = request.getParameter("nome");
                    codigo = request.getParameter("codDept");
                    Model.Departamento departAlt = new Model.Departamento(nome, codigo, campus);
                    departAlt.alterar();
                    dispatcher2.forward(request,response);
                    */
                    break;
                case "Deletar":
                    Model.Usuario usuarioDel = new Model.Usuario();
                    usuarioDel.setMatricula(Integer.parseInt(request.getParameter("matricula")));
                    usuarioDel.deletar();
                    dispatcherDefault.forward(request, response);
                    /*
                    Model.Departamento departDel = new Model.Departamento();
                    departDel.setCodigo(request.getParameter("codDept"));
                    departDel.deletar();
                    dispatcher2.forward(request,response);
                    */
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
