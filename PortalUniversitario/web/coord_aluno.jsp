<%--
    Document   : coord_aluno
    Created on : 28/05/2017, 14:43:20
    Author     : joao
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Universitário | Coordenador</title>
        <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
        <link href="css/aluno.css" rel="stylesheet" type="text/css">
        <link href="css/modal.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/libs/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/modal.js"></script>
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
    <div id="ctx" align="center">
        <h1> Gerenciar Aluno </h1>
        <div class="separador"></div>
        <form method="post"action="AlunoController"name="consulta">
            <% Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
            ArrayList<Model.Curso> cursos = new ArrayList();
            ArrayList<Model.Departamento> departamentos = new ArrayList();
            resultados.pesquisarTodosCursos();
            resultados.pesquisarTodosDepartamentos();
            cursos = resultados.getCursos();
            departamentos = resultados.getDepartamentos();
            %>

            <%-- TESTE DO MODAL --%>
            <a href="#janela1" rel="modal" style="color:red">Janela modal</a>

            <div class="janela" id="janela1">
                <a href="#" class="fechar" style="color: red">X Fechar</a>
                <h4>Primeira janela modal</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam venenatis auctor tempus. Lorem ipsum dolor sit amet,</p>
                <p>Morbi dui lacus, placerat eget pretium vehicula, mollis id ligula. Nulla facilisi. </p>
            </div>
            <!-- mascara para cobrir o site -->
            <div id="mascara"></div>
            <%-- FIM DO TESTE DO MODAL --%>


            <table id="tab_dados_aluno"  width="800" border="0"  align="center">
                    <tr>
                        <td colspan="2"> <p> Matrícula:<br/> <input type="text" name="matricula" ><input type="button" name="buscar" value="Buscar" style="margin-left:30px"></p> </td>

                </tr>
                <tr>
                    <td colspan="4">
                        <p> Nome:<br/> <input class="campo_tabela" type="text" name="nome"> </p>
                    </td>
                </tr>
                <tr>
                    <td> <p> Email: <br> <input type="text" name="email" class="campo_tabela"> </p> </td>
                    <td colspan="2"> <p class="cols_centrais"> Telefone: <br> <input type="text" name="telefone"> </p> </td>
                </tr>
                <tr>
                    <td>
                            <div>
                                <p> Campus:<br/> <input type="text" name="campus" style="width:100px" > </p>
                            </div>
                            <div style="float:right">
                                <p> Departamento:<br/> <select name="departamento" style="width:120px;">
                               <option> </option>
                            <%
                                for(int i=0;i<departamentos.size();i++){ %>
                                <option value="<%= departamentos.get(i).getNome()%>"><%= departamentos.get(i).getNome()%></option>
                            <%}%>
                            </select> </p>
                        </div>

                    </td>
                    <td colspan="3">
                        <p class="cols_centrais"> Curso:<br/> <select name="curso" class="campo_tabela" >
                            <option> </option>
                            <%
                                for(int i=0;i<cursos.size();i++){ %>
                                <option value="<%= cursos.get(i).getNome()%>"><%= cursos.get(i).getNome()%></option>
                            <%}%>
                            </select></p>
                    </td>
                </tr>
                <tr>
                <td>
                            <p> Forma de Ingresso:<br/> <select name="forma_ingresso" class="campo_tabela" >
                            <option value="0"> </option>
                            <option value="1"> Vestibular</option>
                            <option value="2"> SISU</option>
                            <option value="3"> Mat. Esp. Portador Diploma</option>
                            <option value="4"> Mat. Esp. Transf. Inter</option>
                            <option value="5"> Mat. Esp. Trans. Ext.</option>
                        </select> </p>
                    </td>
                    <td>
                        <p class="cols_centrais"> Turno:<br/>
                            <select name="turno" style="width:100px">
                            <option value="0"> </option>
                            <option value="1"> Matutino </option>
                            <option value="2"> Vespertino </option>
                            <option value="3"> Noturno </option>
                            </select>
                        </p>
                    </td>
                    <td style="width: 260px;">
                        <div>
                            <p> Sems Início:<br/> <input type="text" name="sems_inicio" class="caixas" > </p>
                        </div>
                        <div style="margin-left: 5px;">
                            <p> Sems Cursados:<br/> <input type="text" name="sems_cursados" class="caixas" > </p>
                        </div>
                    </td>
                    <td>
                        <p> Creditação:<br/> <input type="text" name="creditacao" class="caixas" > </p>
                    </td>
                </tr>
            </table>

            <img src="img/fluxograma.jpg" width="747" height="540"/>

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
                    <div align="center">
                    <input type="submit" name="opcao" id="btn_novo" class="botao" value="cadastro">
                    <input type="submit" name="opcao" id="btn_alterar" class="botao" value="alterar">
                    <input type="reset" id="btn_limpar" class="botao" value="Limpar">
                    </div>
        </form>
    </div>
    </body>
</html>
