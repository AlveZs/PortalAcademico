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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Portal Universitário | Coordenador</title>\r\n");
      out.write("        <link href=\"css/aluno.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            // Função responsável por inserir linhas na tabela\r\n");
      out.write("        function inserirLinha() {\r\n");
      out.write("\r\n");
      out.write("            // Captura a referência da tabela com id “minhaTabela”\r\n");
      out.write("            var table = document.getElementById(\"tab_disciplinas\");\r\n");
      out.write("            // Captura a quantidade de linhas já existentes na tabela menos a útlima\r\n");
      out.write("            var numLinhas = table.rows.length-1;\r\n");
      out.write("            // Captura a quantidade de colunas da última linha da tabela\r\n");
      out.write("            var numCols = table.rows[numLinhas-1].cells.length;\r\n");
      out.write("\r\n");
      out.write("            // Insere uma linha no fim da tabela.\r\n");
      out.write("            var novaLinha = table.insertRow(numLinhas);\r\n");
      out.write("\r\n");
      out.write("            // Faz um loop para criar as colunas\r\n");
      out.write("            for (var j = 0; j < numCols; j++) {\r\n");
      out.write("                // Insere uma coluna na nova linha\r\n");
      out.write("                novaCelula = novaLinha.insertCell(j);\r\n");
      out.write("                // Insere um conteúdo na coluna\r\n");
      out.write("                novaCelula.innerHTML = \"Linha \"+ numLinhas + \" – Coluna \"+ j;\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
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
      out.write("    <div id=\"ctx\" align=\"center\">\r\n");
      out.write("        <h1> Gerenciar Aluno </h1>\r\n");
      out.write("        <div class=\"separador\"></div>\r\n");
      out.write("        <form method=\"post\"action=\"AlunoController\"name=\"consulta\">\r\n");
      out.write("            ");
 Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
            ArrayList<Model.Curso> cursos = new ArrayList();
            ArrayList<Model.Departamento> departamentos = new ArrayList();
            resultados.pesquisarTodosCursos();
            resultados.pesquisarTodosDepartamentos();
            cursos = resultados.getCursos();
            departamentos = resultados.getDepartamentos();
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <a href=\"#janela1\" class=\"modal\" style=\"color:red\">Janela modal</a>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"janela\" id=\"janela1\">\r\n");
      out.write("                <a href=\"#\" class=\"fechar\" style=\"color: red\">X Fechar</a>\r\n");
      out.write("                <h4>Primeira janela modal</h4>\r\n");
      out.write("                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam venenatis auctor tempus. Lorem ipsum dolor sit amet,</p>\r\n");
      out.write("                <p>Morbi dui lacus, placerat eget pretium vehicula, mollis id ligula. Nulla facilisi. </p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- mascara para cobrir o site -->\r\n");
      out.write("            <div id=\"mascara\"></div>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <table id=\"tab_dados_aluno\"  width=\"800\" border=\"0\"  align=\"center\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"2\"> <p> Matrícula:<br/> <input type=\"text\" name=\"matricula\" ><input type=\"button\" name=\"buscar\" value=\"Buscar\" style=\"margin-left:30px\"></p> </td>\r\n");
      out.write("\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td colspan=\"4\">\r\n");
      out.write("                        <p> Nome:<br/> <input class=\"campo_tabela\" type=\"text\" name=\"nome\"> </p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td> <p> Email: <br> <input type=\"text\" name=\"email\" class=\"campo_tabela\"> </p> </td>\r\n");
      out.write("                    <td colspan=\"2\"> <p class=\"cols_centrais\"> Telefone: <br> <input type=\"text\" name=\"telefone\"> </p> </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <p> Campus:<br/> <input type=\"text\" name=\"campus\" style=\"width:100px\" > </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div style=\"float:right\">\r\n");
      out.write("                                <p> Departamento:<br/> <select name=\"departamento\" style=\"width:120px;\">\r\n");
      out.write("                               <option> </option>\r\n");
      out.write("                            ");

                                for(int i=0;i<departamentos.size();i++){ 
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print( departamentos.get(i).getNome());
      out.write('"');
      out.write('>');
      out.print( departamentos.get(i).getNome());
      out.write("</option>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                            </select> </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td colspan=\"3\">\r\n");
      out.write("                        <p class=\"cols_centrais\"> Curso:<br/> <select name=\"curso\" class=\"campo_tabela\" >\r\n");
      out.write("                            <option> </option>\r\n");
      out.write("                            ");

                                for(int i=0;i<cursos.size();i++){ 
      out.write("\r\n");
      out.write("                                <option value=\"");
      out.print( cursos.get(i).getNome());
      out.write('"');
      out.write('>');
      out.print( cursos.get(i).getNome());
      out.write("</option>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                            </select></p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                            <p> Forma de Ingresso:<br/> <select name=\"forma_ingresso\" class=\"campo_tabela\" >\r\n");
      out.write("                            <option value=\"0\"> </option>\r\n");
      out.write("                            <option value=\"1\"> Vestibular</option>\r\n");
      out.write("                            <option value=\"2\"> SISU</option>\r\n");
      out.write("                            <option value=\"3\"> Mat. Esp. Portador Diploma</option>\r\n");
      out.write("                            <option value=\"4\"> Mat. Esp. Transf. Inter</option>\r\n");
      out.write("                            <option value=\"5\"> Mat. Esp. Trans. Ext.</option>\r\n");
      out.write("                        </select> </p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <p class=\"cols_centrais\"> Turno:<br/>\r\n");
      out.write("                            <select name=\"turno\" style=\"width:100px\">\r\n");
      out.write("                            <option value=\"0\"> </option>\r\n");
      out.write("                            <option value=\"1\"> Matutino </option>\r\n");
      out.write("                            <option value=\"2\"> Vespertino </option>\r\n");
      out.write("                            <option value=\"3\"> Noturno </option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td style=\"width: 260px;\">\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <p> Sems Início:<br/> <input type=\"text\" name=\"sems_inicio\" class=\"caixas\" > </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div style=\"margin-left: 5px;\">\r\n");
      out.write("                            <p> Sems Cursados:<br/> <input type=\"text\" name=\"sems_cursados\" class=\"caixas\" > </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <p> Creditação:<br/> <input type=\"text\" name=\"creditacao\" class=\"caixas\" > </p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("            <img src=\"img/fluxograma.jpg\" width=\"747\" height=\"540\"/>\r\n");
      out.write("\r\n");
      out.write("          <table id=\"tab_disciplinas\" border=\"1\" cellpadding=\"5\" height=\"100\" width=\"800\" align=\"center\">\r\n");
      out.write("                    <th rowspan=\"2\"> Nome das Disciplinas: </th>\r\n");
      out.write("                <th rowspan=\"2\"> Código </th>\r\n");
      out.write("                <th colspan=\"2\"> Carga Horária: </th>\r\n");
      out.write("                <th rowspan=\"2\"> Semestre </th>\r\n");
      out.write("                <th rowspan=\"2\"> Situação </th>\r\n");
      out.write("                <th rowspan=\"2\"> Optativa </th>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td> <i> Exigida:</i> </td>\r\n");
      out.write("                    <td> <i> Cumprida: </i> </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Algoritmos</td>\r\n");
      out.write("                    <td>CPD063</td>\r\n");
      out.write("                    <td>60h</td>\r\n");
      out.write("                    <td>60h</td>\r\n");
      out.write("                    <td>1</td>\r\n");
      out.write("                    <td>Cumprida</td>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Linguagem de Programação III</td>\r\n");
      out.write("                    <td>CPD023</td>\r\n");
      out.write("                     <td>60h</td>\r\n");
      out.write("                     <td>30h</td>\r\n");
      out.write("                     <td>4</td>\r\n");
      out.write("                     <td>Matriculado</td>\r\n");
      out.write("                     <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Teoria dos Grafos</td>\r\n");
      out.write("                    <td>MAT015</td>\r\n");
      out.write("                     <td>60h</td>\r\n");
      out.write("                     <td>0h</td>\r\n");
      out.write("                     <td>5</td>\r\n");
      out.write("                     <td>Apto a Cursar</td>\r\n");
      out.write("                     <td>X</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td> <input type=\"button\" onClick=\"inserirLinha()\" id=\"btn_add_linha\" value=\"+ Adicionar Disciplina\" style=\"font-size:17px\"> </td>\r\n");
      out.write("                    <td>---</td>\r\n");
      out.write("                    <td>---</td>\r\n");
      out.write("                    <td>---</td>\r\n");
      out.write("                    <td>---</td>\r\n");
      out.write("                    <td>---</td>\r\n");
      out.write("                    <td>---</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("                    <div align=\"center\">\r\n");
      out.write("                    <input type=\"submit\" name=\"opcao\" id=\"btn_novo\" class=\"botao\" value=\"cadastro\">\r\n");
      out.write("                    <input type=\"submit\" name=\"opcao\" id=\"btn_alterar\" class=\"botao\" value=\"alterar\">\r\n");
      out.write("                    <input type=\"reset\" id=\"btn_limpar\" class=\"botao\" value=\"Limpar\">\r\n");
      out.write("                    </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    </body>\r\n");
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
