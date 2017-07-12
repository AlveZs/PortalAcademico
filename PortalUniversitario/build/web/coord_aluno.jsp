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
            
        function nulo() {
            alert("Não existe resultado para essa matrícula");
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
        <% String verificaNulo = (String)request.getAttribute("verNulo");%> 
        <% if (verificaNulo.equals("sim")){%>
            <script type="text/javascript">
                nulo();
            </script>   
        <%}%>
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
        </div>
        <!-- mascara para cobrir o site -->
        <!--<div id="mascara"></div>-->
        <%-- FIM DO TESTE DO MODAL --%>


        <table id="tab_dados_aluno" class="tabelao" width="800" border="0"  align="center">
            <th colspan="7">
                <h1> Gerenciar Aluno </h1>
                <div class="separador"></div>
            </th>
            <tr>
                <td colspan="2"> <p> Matrícula:<br/> <input type="text" name="matricula" ><input type="submit" name="opcao" value="Buscar" style="margin-left:30px"></p> </td>
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
                        <p> Campus:<br/> <select name="campus" id="cb_campus">
                            <option></option>
                            <%
                                for(int i=0;i<campi.size();i++){
                            %>
                            <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                            <%}%>
                        </select> </p>
                    </div>
                    <div style="float:right">
                       <p> Departamento:<br/> <select name="departamento" id="cb_departamento" style="width:120px;" disabled="true">
                       <option></option>
                        </select> </p>
                    </div>
                </td>
                <td colspan="3">
                    <p class="cols_centrais"> Curso:<br/> <select name="curso"  id="cb_curso" class="campo_tabela" disabled="true">
                        <option></option>
                    </select></p>
                </td>
            </tr>
            <tr>
                <td>
                    <p> Forma de Ingresso:<br/> <select name="forma_ingresso" class="campo_tabela" >
                        <option value=""> </option>
                        <%
                            for(int i=0;i<formasIngresso.size();i++){%>
                            <option value="<%= formasIngresso.get(i)%>"><%= formasIngresso.get(i)%></option>
                        <%}%>
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
                        <p> Sems Externos:<br/> <input type="text" name="sems_externos" class="caixas" > </p>
                    </div>
                </td>
                <td>
                    <p> Creditação:<br/> <input type="text" name="creditacao" class="caixas" > </p>
                </td>
            </tr>
            
            <tr><td colspan="4" align="center">
                <div>
                    <input type="submit" name="opcao" id="btn_novo" class="botao" value="cadastro">
                    <input type="submit" name="opcao" id="btn_alterar" class="botao" value="alterar">
                    <input type="submit" name="opcao" id="btn_deletar" class="botao" value="deletar">
                </div>
            </td></tr>
        </table>
    </form>
</body>
</html>
