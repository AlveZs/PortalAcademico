package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Menu</title>\n");
      out.write("        <link href=\"css/pag_coordenador.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <div id=\"cabecalho\">\n");
      out.write("        <a href=\"pag_coordenador.jsp\"><img src=\"img/Logo_small_branca.png\" width=\"119\" height=\"91\" /></a>\n");
      out.write("      <div id=\"boasvindas\">\n");
      out.write("      \t\t<p style=\"display: inline;\"> Bem-Vindo, $coordenador! </p> \n");
      out.write("            <a href=\"index.html\" style=\"margin-left: 20px;\">Sair</a> \n");
      out.write("      </div>\n");
      out.write("\t</div>\n");
      out.write("    <div id=\"barra_menu\">\n");
      out.write("    \t<ul class=\"menu\">\n");
      out.write("        \t<li> <a href=\"coord_aluno.jsp\"> Aluno </a> </li>\n");
      out.write("            <li> <a href=\"CursoController?opcao=preencher\"> Curso </a> </li>\n");
      out.write("            <li> <a href=\"coord_disciplina.jsp\"> Disciplina </a> </li>\n");
      out.write("\t\t\t<li> <a href=\"coord_semestre.jsp\"> <div></div> Semestre </a> </li>\n");
      out.write("            <li> <a href=\"processo.jsp\"> <div></div> Processos </a> </li>\n");
      out.write("            <li> <a href=\"#\"> Relatório </a>\n");
      out.write("            \t\t<ul>\n");
      out.write("            \t\t\t<li> <a href=\"relatorio_integralizacao.jsp\"> <div></div> Integralização </a> </li>\n");
      out.write("                        <li> <a href=\"relatorio_formacao.jsp\"> <div></div> Formação </a> </li>\n");
      out.write("                        <li> <a href=\"relatorio_oferta_materias.jsp\"> <div></div> Ofertar Matérias </a> </li>\n");
      out.write("            \t\t</ul>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
