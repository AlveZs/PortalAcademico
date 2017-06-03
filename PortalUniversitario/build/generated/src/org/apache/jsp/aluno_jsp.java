package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aluno_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menu.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title> Portal Universitï¿½rio | Aluno </title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/modal.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Menu</title>\r\n");
      out.write("        <link href=\"css/pag_coordenador.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/libs/jquery/jquery.js\"></script>\r\n");
      out.write("        <link href=\"css/modal.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/modal.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    <div id=\"cabecalho\">\r\n");
      out.write("        <a href=\"pag_coordenador.jsp\"><img src=\"img/Logo_small_branca.png\" width=\"119\" height=\"91\" /></a>\r\n");
      out.write("      <div id=\"boasvindas\">\r\n");
      out.write("      \t\t<p style=\"display: inline;\"> Bem-Vindo, $coordenador! </p>\r\n");
      out.write("            <a href=\"index.jsp\" style=\"margin-left: 20px;\">Sair</a>\r\n");
      out.write("      </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <div id=\"barra_menu\">\r\n");
      out.write("    \t<ul class=\"menu\">\r\n");
      out.write("        \t<li> <a href=\"AlunoController?opcao=preencher\"> Aluno </a> </li>\r\n");
      out.write("            <li> <a href=\"CursoController?opcao=preencher\"> Curso </a> </li>\r\n");
      out.write("            <li> <a href=\"coord_disciplina.jsp\"> Disciplina </a> </li>\r\n");
      out.write("\t\t\t<li> <a href=\"coord_semestre.jsp\"> <div></div> Semestre </a> </li>\r\n");
      out.write("            <li> <a href=\"processo.jsp\"> <div></div> Processos </a> </li>\r\n");
      out.write("            <li> <a href=\"#\"> Relatório </a>\r\n");
      out.write("            \t\t<ul>\r\n");
      out.write("                        <li> <a href=\"relatorio_integralizacao.jsp\"> <div></div> Integralização </a> </li>\r\n");
      out.write("                        <li> <a href=\"relatorio_formacao.jsp\"> <div></div> Formação </a> </li>\r\n");
      out.write("                        <li> <a href=\"relatorio_oferta_materias.jsp\"> <div></div> Ofertar Matérias </a> </li>\r\n");
      out.write("            \t\t</ul>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form class=\"\" action=\"index.html\" method=\"post\">\r\n");
      out.write("      <p>Buscar: <input type=\"text\" name=\"txt_buscar\"> <input type=\"button\" name=\"bt_ok\" value=\"Ok\"></p>\r\n");
      out.write("      <table border=\"1\" align=\"center\">\r\n");
      out.write("        <thead>\r\n");
      out.write("          <th>Matrícula</th>\r\n");
      out.write("          <th>Nome</th>\r\n");
      out.write("          <th>Curso</th>\r\n");
      out.write("          <th>Semestre</th>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("          <tr class=\"modal\" href=\"#janela1\">\r\n");
      out.write("            <td>071519553</td>\r\n");
      out.write("            <td>João Pedro de Azevedo Hegouet</td>\r\n");
      out.write("            <td>Bacharelado em Sistemas de Informação</td>\r\n");
      out.write("            <td>4</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                <input type=\"button\" name=\"bt_editar\" id=\"bt_editar\" value=\"E\">\r\n");
      out.write("                <input type=\"button\" name=\"bt_excluir\" value=\"X\">\r\n");
      out.write("            </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("          <tr>\r\n");
      out.write("            <td>251054</td>\r\n");
      out.write("            <td>hua hsphd as</td>\r\n");
      out.write("            <td>dsada sads da</td>\r\n");
      out.write("            <td>5</td>\r\n");
      out.write("          </tr>\r\n");
      out.write("        </tbody>\r\n");
      out.write("      </table>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div class=\"janela\" id=\"janela1\">\r\n");
      out.write("        <a href=\"#\" class=\"fechar\">X Fechar</a>\r\n");
      out.write("        <h4>Primeira janela modal</h4>\r\n");
      out.write("        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam venenatis auctor tempus. Lorem ipsum dolor sit amet,</p>\r\n");
      out.write("        <p>Morbi dui lacus, placerat eget pretium vehicula, mollis id ligula. Nulla facilisi. </p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- mascara para cobrir o site -->\r\n");
      out.write("    <div id=\"mascara\"></div>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
