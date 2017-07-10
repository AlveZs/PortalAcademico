<!DOCTYPE html>
    <%@page import="java.util.ArrayList"%>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<!-- Inicio do Template -->
<head>
    <meta charset="utf-8">
    <title>Portal Universitário | Formação</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->  
    <% 
      Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
      ArrayList<Model.Campus> campi = new ArrayList();
      ArrayList<Model.Departamento> departamentos = new ArrayList();
      
      resultados.pesquisarTodosCampus();
      resultados.pesquisarTodosDepartamentos();
      campi = resultados.getCampus();
      departamentos = resultados.getDepartamentos();
    %>
 
    <form method="post" action="Relatorio_FormacaoController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" id="tab_disciplinas">
            <th>
                <h1>Relatório de Formação</h1>
                <div class="separador"></div>
            </th>

            <tr>
            <td>
                <div>
                    <p>Campus:<br/> <select name="campus">
                        <option value="0"></option>
                        <%
                            for(int i=0;i<campi.size();i++){ %>
                            <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                        <%}%>
                    </select></p>
                </div>
                <div style="margin-left:10px;">
                    <p>Departamento:<br/> <select name="departamento" disabled="">
                        <option value="0"></option>
                    </select></p>
                </div>
                <div style="margin-left:10px;">
                    <p>Curso:<br/> <select name="curso" class="cb_curso" disabled="">
                        <option value="0"></option>
                    </select></p>
                </div>
                <div style="margin-left:10px">
                    <p>Situação:<br/> <select name="situacao" style="width: 180px;">
                        <option value="0"></option>
                        <option value="1">Possivel Concluinte</option>
                        <option value="2">Jubilado</option>
                    </select></p>
                </div>
                <div> 
                    <input type="submit" name="opcao" value="Buscar" id="btn_buscar" onClick="checkFields()">
                </div>
            </td>
            </tr>
            <tr>
                <td> Total de Alunos: 2</td>
            </tr>
        </table>
    </form>
</body>
</html>
