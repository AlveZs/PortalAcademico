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
@WebServlet(name = "ProcessoController", urlPatterns = {"/ProcessoController"})
public class ProcessoController extends HttpServlet {

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
        String opcao;
        int situacao,qtdSemestres,codProcesso,aluno;
        request.setCharacterEncoding("UTF-8");
        opcao= request.getParameter("opcao");
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("processo.jsp");
        switch (opcao){
            case "Buscar":
                Model.Processo processoBusca = new Model.Processo();
                processoBusca.setCodProcesso(Integer.parseInt(request.getParameter("codProcesso")));
                processoBusca.pesquisar();
                if(processoBusca.getId()==0){
                    request.setAttribute("verNulo", "sim");
                    dispatcher2.forward(request,response);
                }
                else{
                    request.setAttribute("proc", processoBusca);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("processo_preenchida.jsp");
                    dispatcher.forward(request,response);
                }
                break;
            case "Incluir":
                aluno = Integer.parseInt(request.getParameter("matrícula"));
                situacao = Integer.parseInt(request.getParameter("situacao"));
                qtdSemestres = Integer.parseInt(request.getParameter("qtdTotalSem"));
                codProcesso = Integer.parseInt(request.getParameter("codProcesso"));
                Model.Processo processoInc = new Model.Processo(situacao, qtdSemestres, codProcesso);
                processoInc.getAluno().setMatricula(aluno);
                processoInc.getAluno().pesquisarIdAluno();
                processoInc.incluir();
                request.setAttribute("verNulo", "nao");
                dispatcher2.forward(request,response);
                break;
            case "preencher":
                request.setAttribute("verNulo", "nao");
                dispatcher2.forward(request,response);
                break;
            case "Alterar":
                aluno = Integer.parseInt(request.getParameter("matrícula"));
                situacao = Integer.parseInt(request.getParameter("situacao"));
                qtdSemestres = Integer.parseInt(request.getParameter("qtdTotalSem"));
                codProcesso = Integer.parseInt(request.getParameter("codProcesso"));
                Model.Processo processoAlt = new Model.Processo(situacao, qtdSemestres, codProcesso);
                processoAlt.getAluno().setMatricula(aluno);
                processoAlt.getAluno().pesquisarIdAluno();
                processoAlt.alterar();
                request.setAttribute("verNulo", "nao");
                dispatcher2.forward(request,response);
                break;
            case "Deletar":
                Model.Processo processoDel = new Model.Processo();
                processoDel.setCodProcesso(Integer.parseInt(request.getParameter("codProcesso")));
                processoDel.deletar();
                request.setAttribute("verNulo", "nao");
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
