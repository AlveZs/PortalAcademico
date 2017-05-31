package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;

public final class coord_005faluno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Portal Universitário | Coordenador</title>\n");
      out.write("        <link href=\"css/pag_coordenador.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"css/aluno.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-3.2.1.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            // Função responsável por inserir linhas na tabela\n");
      out.write("        function inserirLinha() {\n");
      out.write("\n");
      out.write("            // Captura a referência da tabela com id “minhaTabela”\n");
      out.write("            var table = document.getElementById(\"tab_disciplinas\");\n");
      out.write("            // Captura a quantidade de linhas já existentes na tabela menos a útlima\n");
      out.write("            var numLinhas = table.rows.length-1;\n");
      out.write("            // Captura a quantidade de colunas da última linha da tabela\n");
      out.write("            var numCols = table.rows[numLinhas-1].cells.length;\n");
      out.write("\n");
      out.write("            // Insere uma linha no fim da tabela.\n");
      out.write("            var novaLinha = table.insertRow(numLinhas);\n");
      out.write(" \n");
      out.write("            // Faz um loop para criar as colunas\n");
      out.write("            for (var j = 0; j < numCols; j++) {\n");
      out.write("                // Insere uma coluna na nova linha \n");
      out.write("                novaCelula = novaLinha.insertCell(j);\n");
      out.write("                // Insere um conteúdo na coluna\n");
      out.write("                novaCelula.innerHTML = \"Linha \"+ numLinhas + \" – Coluna \"+ j;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    ");
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
      out.write("        \t<li> <a href=\"AlunoController?opcao=preencher\"> Aluno </a> </li>\n");
      out.write("            <li> <a href=\"CursoController?opcao=preencher\"> Curso </a> </li>\n");
      out.write("            <li> <a href=\"coord_disciplina.jsp\"> Disciplina </a> </li>\n");
      out.write("\t\t\t<li> <a href=\"coord_semestre.jsp\"> <div></div> Semestre </a> </li>\n");
      out.write("            <li> <a href=\"processo.jsp\"> <div></div> Processos </a> </li>\n");
      out.write("            <li> <a href=\"#\"> Relatório </a>\n");
      out.write("            \t\t<ul>\n");
      out.write("                        <li> <a href=\"relatorio_integralizacao.jsp\"> <div></div> Integralização </a> </li>\n");
      out.write("                        <li> <a href=\"relatorio_formacao.jsp\"> <div></div> Formação </a> </li>\n");
      out.write("                        <li> <a href=\"relatorio_oferta_materias.jsp\"> <div></div> Ofertar Matérias </a> </li>\n");
      out.write("            \t\t</ul>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    <div id=\"ctx\" align=\"center\">\n");
      out.write("        <h1> Gerenciar Aluno </h1>\n");
      out.write("        <div class=\"separador\"></div>\n");
      out.write("        <form method=\"post\"action=\"AlunoController\"name=\"consulta\">\n");
      out.write("            ");
 Model.Aluno aluno = (Model.Aluno)request.getAttribute("alu");
            ArrayList<Model.Curso> cursos = new ArrayList<>();
            aluno.pesquisarTodos();
            cursos = aluno.getCursos();
            
      out.write("\n");
      out.write("            <table id=\"tab_dados_aluno\"  width=\"800\" border=\"0\"  align=\"center\">\n");
      out.write("                    <tr>\n");
      out.write("                    <td colspan=\"2\"> <p> Matrícula:<br/> <input type=\"text\" name=\"matricula\" ><input type=\"button\" name=\"buscar\" value=\"Buscar\" style=\"margin-left:30px\"> </p> </td>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"4\">\n");
      out.write("                        <p> Nome:<br/> <input class=\"campo_tabela\" type=\"text\" name=\"nome\"> </p>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td> <p> Email: <br> <input type=\"text\" name=\"email\" class=\"campo_tabela\"> </p> </td>\n");
      out.write("                    <td colspan=\"2\"> <p class=\"cols_centrais\"> Telefone: <br> <input type=\"text\" name=\"telefone\"> </p> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                            <div>\n");
      out.write("                                <p> Campus:<br/> <input type=\"text\" name=\"campus\" style=\"width:100px\" > </p>\n");
      out.write("                            </div>\n");
      out.write("                            <div style=\"float:right\">\n");
      out.write("                                <p> Departamento:<br/> <select name=\"departamento\" style=\"width:120px;\">\n");
      out.write("                                <option value=\"0\"></option>\n");
      out.write("                                <option value=\"1\"> DCET </option>\n");
      out.write("                                <option value=\"2\"> DCV </option>\n");
      out.write("                                <option value=\"3\"> DCH </option>\n");
      out.write("                            </select> </p>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td colspan=\"3\">\n");
      out.write("                        <p class=\"cols_centrais\"> Curso:<br/> <select name=\"curso\" class=\"campo_tabela\" >\n");
      out.write("                        <option value=\"0\"> </option>\n");
      out.write("                        <option value=\"1\"> Design </option>\n");
      out.write("                        <option value=\"2\"> Fisioterapia </option>\n");
      out.write("                        <option value=\"3\"> Licenciatura em História </option>\n");
      out.write("                        <option value=\"4\"> Sistemas de Infomação </option>\n");
      out.write("                        <option value=\"5\"> Urbanismo </option>\n");
      out.write("                        </select> </p> \n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                <td>\n");
      out.write("                            <p> Forma de Ingresso:<br/> <select name=\"forma_ingresso\" class=\"campo_tabela\" >\n");
      out.write("                            <option value=\"0\"> </option>\n");
      out.write("                            <option value=\"1\"> ENEM </option>\n");
      out.write("                            <option value=\"2\"> Vestibular </option>\n");
      out.write("                            <option value=\"3\"> Transferência Interna </option>\n");
      out.write("                            <option value=\"3\"> Transferência Externa </option>\n");
      out.write("                        </select> </p>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <p class=\"cols_centrais\"> Turno:<br/>\n");
      out.write("                            <select name=\"turno\" style=\"width:100px\">\n");
      out.write("                            <option value=\"0\"> </option>\n");
      out.write("                            <option value=\"1\"> Matutino </option>\n");
      out.write("                            <option value=\"2\"> Vespertino </option>\n");
      out.write("                            <option value=\"3\"> Noturno </option>\n");
      out.write("                            </select>\n");
      out.write("                        </p>\n");
      out.write("                    </td>\n");
      out.write("                    <td style=\"width: 260px;\">\n");
      out.write("                        <div>\n");
      out.write("                            <p> Sems Início:<br/> <input type=\"text\" name=\"sems_inicio\" class=\"caixas\" > </p>\n");
      out.write("                        </div>\n");
      out.write("                        <div style=\"margin-left: 5px;\">\n");
      out.write("                            <p> Sems Cursados:<br/> <input type=\"text\" name=\"sems_cursados\" class=\"caixas\" > </p>\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <p> Creditação:<br/> <input type=\"text\" name=\"creditacao\" class=\"caixas\" > </p>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            <img src=\"img/fluxograma.jpg\" width=\"747\" height=\"540\"/>\n");
      out.write("\n");
      out.write("          <table id=\"tab_disciplinas\" border=\"1\" cellpadding=\"5\" height=\"100\" width=\"800\" align=\"center\">\n");
      out.write("                    <th rowspan=\"2\"> Nome das Disciplinas: </th>\n");
      out.write("                <th rowspan=\"2\"> Código </th>\n");
      out.write("                <th colspan=\"2\"> Carga Horária: </th>\n");
      out.write("                <th rowspan=\"2\"> Semestre </th>\n");
      out.write("                <th rowspan=\"2\"> Situação </th>\n");
      out.write("                <th rowspan=\"2\"> Optativa </th>\n");
      out.write("                <tr>\n");
      out.write("                    <td> <i> Exigida:</i> </td>\n");
      out.write("                    <td> <i> Cumprida: </i> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Algoritmos</td>\n");
      out.write("                    <td>CPD063</td>\n");
      out.write("                    <td>60h</td>\n");
      out.write("                    <td>60h</td>\n");
      out.write("                    <td>1</td>\n");
      out.write("                    <td>Cumprida</td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Linguagem de Programação III</td>\n");
      out.write("                    <td>CPD023</td>\n");
      out.write("                     <td>60h</td>\n");
      out.write("                     <td>30h</td>\n");
      out.write("                     <td>4</td>\n");
      out.write("                     <td>Matriculado</td>\n");
      out.write("                     <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Teoria dos Grafos</td>\n");
      out.write("                    <td>MAT015</td>\n");
      out.write("                     <td>60h</td>\n");
      out.write("                     <td>0h</td>\n");
      out.write("                     <td>5</td>\n");
      out.write("                     <td>Apto a Cursar</td>\n");
      out.write("                     <td>X</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td> <input type=\"button\" onClick=\"inserirLinha()\" id=\"btn_add_linha\" value=\"+ Adicionar Disciplina\" style=\"font-size:17px\"> </td>\n");
      out.write("                    <td>---</td>\n");
      out.write("                    <td>---</td>\n");
      out.write("                    <td>---</td>\n");
      out.write("                    <td>---</td>\n");
      out.write("                    <td>---</td>\n");
      out.write("                    <td>---</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("                    <div align=\"center\">\n");
      out.write("                    <input type=\"button\" id=\"btn_novo\" class=\"botao\" value=\"Novo\">\n");
      out.write("                    <input type=\"button\" id=\"btn_alterar\" class=\"botao\" value=\"Alterar\">\n");
      out.write("                    <input type=\"reset\" id=\"btn_limpar\" class=\"botao\" value=\"Limpar\">\n");
      out.write("                    </div>\n");
      out.write("        </form>\n");
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
