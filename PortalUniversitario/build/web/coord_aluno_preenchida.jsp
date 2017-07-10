<%-- 
    Document   : coord_aluno_preenchida
    Created on : 07/06/2017, 23:49:57
    Author     : John_Peter
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Universitário | Coordenador</title>
        <link href="css/aluno.css" rel="stylesheet" type="text/css">
        <script type="text/javascript">
        // Função responsável por inserir linhas na tabela
        function inserirLinha() {

            // Captura a referência da tabela com id “minhaTabela”
            var table = document.getElementById("tab_disciplinas");
            // Captura a quantidade de linhas já existentes na tabela menos a útlima
            var numLinhas = table.rows.length-1;
            // Captura a quantidade de colunas da última linha da tabela
            var numCols = table.rows[numLinhas-1].cells.length;

            // Insere uma linha no fim da tabela.
            var novaLinha = table.insertRow(numLinhas);

            // Faz um loop para criar as colunas
            for (var j = 0; j < numCols; j++) {
                // Insere uma coluna na nova linha
                novaCelula = novaLinha.insertCell(j);
                // Insere um conteúdo na coluna
                novaCelula.innerHTML = "Linha "+ numLinhas + " – Coluna "+ j;
            }
        }
        </script>
    </head>
    <body>
    <%@include file="menu.jsp"%>
    
    <% 
    Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
    ArrayList<Model.Curso> cursos = new ArrayList();
    ArrayList<Model.Departamento> departamentos = new ArrayList();
    ArrayList<Model.Campus> campi = new ArrayList();
    ArrayList<String> formasIngresso = new ArrayList();
    resultados.pesquisarTodosCursos();
    resultados.pesquisarTodosDepartamentos();
    resultados.pesquisarTodosCampus();
    resultados.pesquisarFormasIngresso();
    cursos = resultados.getCursos();
    departamentos = resultados.getDepartamentos();
    campi = resultados.getCampus();
    formasIngresso = resultados.getFormasIngresso();
    %>
    
    
    <form method="post"action="AlunoController"name="consulta">

        <%-- TESTE DO MODAL --%>
        <!--<a href="#janela1" class="modal" style="color:red">Janela modal</a>

        <div class="janela" id="janela1">
            <%//Model.Disciplina disciplina = (Model.Disciplina)request.getAttribute("d");%>
            <a href="#" class="fechar">X Fechar</a>
            <h4>Primeira janela modal</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam venenatis auctor tempus. Lorem ipsum dolor sit amet,</p>
            <p>Morbi dui lacus, placerat eget pretium vehicula, mollis id ligula. Nulla facilisi. </p>
            <table>
                <tbody>
                    <tr class="subtabela_disciplina">
                        <td><b>Nome</b></td>
                        <td><b>Carga Horária</b></td>
                        <td><b>Creditação</b></td>
                        <td><b>Semestre</b></td>
                        <td><b>Código</b></td>
                        <td><b>Tipo</b></td>
                    </tr>
                    <%//for(Model.Disciplina disc : disciplina.getDisciplinas()){%>
                    <tr class="subtabela_disciplina">
                        <td><%//disc.getNome()%></td>
                        <td><%//disc.getCargaHoraria()%></td>
                        <td><%//disc.getCreditacao()%></td>
                        <td><%//disc.getSemestre()%></td>
                        <td><%//disc.getCodigo()%></td>
                        <td><%//disc.getTipo()%></td>
                    </tr>    
                    <%//}%>
                </tbody>
            </table>
        </div>-->
        <!-- mascara para cobrir o site -->
        <!--<div id="mascara"></div>-->
        <%-- FIM DO TESTE DO MODAL --%>

        <%
            Model.Aluno aluno = (Model.Aluno)request.getAttribute("x");
        %>
        <table id="tab_dados_aluno" class="tabelao" width="800" border="0"  align="center">
            <th colspan="7">
                <h1> Gerenciar Aluno </h1>
                <div class="separador"></div>
            </th>
            <tr>
                <td colspan="2"> <p> Matrícula:<br/> <input type="text" name="matricula" value="<%= aluno.getMatricula() %>"><input type="submit" name="opcao" value="Buscar" style="margin-left:30px"></p> </td>
            </tr>
            <tr>
                <td colspan="4">
                    <p> Nome:<br/> <input class="campo_tabela" type="text" name="nome" value="<%= aluno.getNome() %>"> </p>
                </td>
            </tr>
            <tr>
                <td> <p> Email: <br> <input type="text" name="email" class="campo_tabela" value="<%= aluno.getEmail()%>"> </p> </td>
                <td colspan="2"> <p class="cols_centrais"> Telefone: <br> <input type="text" name="telefone" value="<%= aluno.getTelefone()%>"> </p> </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <p> Campus:<br/> <select name="campus" id="cb_campus">
                            <option></option>
                            <%
                                for(int i=0;i<campi.size();i++){ %>
                                <option value="<%= campi.get(i).getId()%>" <% if(campi.get(i).getNome().equals(aluno.getCurso().getDepartamento().getNomeCampus())) {%> selected="selected" <%}%> ><%= campi.get(i).getNome()%></option>
                            <%}%>
                        </select> </p>
                    </div>
                    <div style="float:right">
                        <p> Departamento:<br/> <select name="departamento" id="cb_departamento" style="width:120px;">
                            <option> </option>
                            <%
                                for(int i=0;i<departamentos.size();i++) {
                                    if (aluno.getCurso().getDepartamento().getNomeCampus().equals(departamentos.get(i).getNomeCampus())) {

                            %>
                                        <option value="<%= departamentos.get(i).getId()%>" <% if(departamentos.get(i).getNome().equals(aluno.getCurso().getDepartamento().getNome())) {%> selected="selected" <%}%> ><%= departamentos.get(i).getNome()%></option>
                            <%} }%>
                        </select> </p>
                    </div>

                </td>
                <td colspan="3">
                    <p class="cols_centrais"> Curso:<br/> <select name="curso"  id="cb_curso" class="campo_tabela">
                        <option> </option>
                        <%
                            for(int i=0;i<cursos.size();i++) {
                                if (aluno.getCurso().getDepartamento().getNome().equals(cursos.get(i).getDepartamento().getNome())) {
                        %>
                                <option value="<%=cursos.get(i).getIdCurso()%>" <% if(aluno.getCurso().getNome().equals(cursos.get(i).getNome())) { %> selected="selected" <%}%> > <%=cursos.get(i).getNome()%> </option>
                        <%} }%>
                    </select> </p>
                </td>
            </tr>
            <tr>
                <td>
                    <p> Forma de Ingresso:<br/> <select name="forma_ingresso" class="campo_tabela" >
                        <option value="0"> </option>
                        <%
                            for(int i=0;i<formasIngresso.size();i++){ %>
                            <option value="<%= formasIngresso.get(i)%>" <% if(formasIngresso.get(i).equals(aluno.getFormaIngresso())) {%> selected="selected" <%}%> ><%= formasIngresso.get(i)%></option>
                        <%}%>
                    </select> </p>
                </td>
                <td>
                    <p class="cols_centrais"> Turno:<br/>
                        <select name="turno" style="width:100px">
                            <option value="0"> </option>
                            <option value="1" <% if(aluno.getCurso().getTurno() == 1) { %> selected="selected" <%}%> > Matutino </option>
                            <option value="2" <% if(aluno.getCurso().getTurno() == 2) { %> selected="selected" <%}%> > Vespertino </option>
                            <option value="3" <% if(aluno.getCurso().getTurno() == 3) { %> selected="selected" <%}%> > Noturno </option>
                        </select>
                    </p>
                </td>
                <td style="width: 260px;">
                    <div>
                        <p> Sems Início:<br/> <input type="text" name="sems_inicio" class="caixas" value="<%=aluno.getSemestreInicio()%>"> </p>
                    </div>
                    <div style="margin-left: 5px;">
                        <% 
                            Model.Integralizacao integ = new Model.Integralizacao();
                            integ.setAluno(aluno);
                            integ.pesquisarInfos();
                        %>
                        <p> Sems Cursados:<br/> <input type="text" name="sems_cursados" class="caixas" value="<%=integ.getQtdtSemestres()%>" > </p>
                    </div>
                </td>
                <td>
                    <p> Creditação:<br/> <input type="text" name="creditacao" class="caixas" value="<%=aluno.getCreditacao()%>"> </p>
                </td>
            </tr>
        
            <tr><td colspan="7">
            <table id="tab_disciplinas" border="1" cellpadding="5" height="100" width="800" align="center">
                <th rowspan="2"> Nome das Disciplinas: </th>
                <th rowspan="2"> Código </th>
                <th colspan="2"> Carga Horária: </th>
                <th rowspan="2"> Semestre </th>
                <th rowspan="2"> Situação </th>
                <th rowspan="2"> Optativa </th>
                <tr>
                    <td> <i> Exigida:</i> </td>
                    <td> <i> Cumprida: </i> </td>
                </tr>
                <!--código-->
                <tr>
                    <td>Algoritmos</td>
                    <td>CPD063</td>
                    <td>60h</td>
                    <td>60h</td>
                    <td>1</td>
                    <td>Cumprida</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Linguagem de Programação III</td>
                    <td>CPD023</td>
                     <td>60h</td>
                     <td>30h</td>
                     <td>4</td>
                     <td>Matriculado</td>
                     <td></td>
                </tr>
                <tr>
                    <td>Teoria dos Grafos</td>
                    <td>MAT015</td>
                     <td>60h</td>
                     <td>0h</td>
                     <td>5</td>
                     <td>Apto a Cursar</td>
                     <td>X</td>
                </tr>
                <tr>
                    <td> <input type="button" onClick="inserirLinha()" id="btn_add_linha" value="+ Adicionar Disciplina" style="font-size:17px"> </td>
                    <td>---</td>
                    <td>---</td>
                    <td>---</td>
                    <td>---</td>
                    <td>---</td>
                    <td>---</td>
                </tr>
            </table>
            </td></tr>
        
            <tr><td colspan="4" align="center">
                <div>
                    <input type="submit" name="opcao" id="btn_novo" class="botao" value="cadastro">
                    <input type="submit" name="opcao" id="btn_alterar" class="botao" value="alterar">
                    <input type="reset" id="btn_limpar" class="botao" value="Limpar">
                </div>
            </td></tr>
        </table>
    </form>
</body>
</html>
