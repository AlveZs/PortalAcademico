<%-- 
    Document   : coord_curso
    Created on : 28/05/2017, 15:02:09
    Author     : joao
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Universitário | Curso</title>
        <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
        <link href="css/curso.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file ="menu.jsp"%>
    <div>
    <form method="post" action="CursoController">
        <% Model.Curso curso = (Model.Curso)request.getAttribute("c");%>
        <% Model.Disciplina disciplina = (Model.Disciplina)request.getAttribute("d");%>
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="700">
            <th colspan="7">
            	<h1>Gerenciar Curso</h1>
                <div class="separador"></div>
            </th>
            <tr>
            	<td colspan="3"> <p>Código:<br/> <input type="text" name="codigo" class="in_menores">
                 <input type="submit" name="opcao" value="Buscar" id="btn_buscar" style="margin-left: 20px;"> </p></td> 	
            </tr>
            <tr>
                <td colspan="8"> <p>Nome:<br/> <input type="text" name="nome" style="width:100%;"></p> </td>
            </tr>
            <tr>
                <td>
                    <p>Campus:<br/>
                        <%  Model.Resultados resultados = new Model.Resultados();
                            ArrayList<Model.Campus> campi = new ArrayList();
                            resultados.pesquisarTodosCampus();
                            campi = resultados.getCampus();
                        %>
                        <select name="campus" class="cb_campus">
                            <option> </option>
                            <%
                                for(int i=0;i<campi.size();i++){ %>
                                <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                            <%}%>
                        </select>
                    </p>
                </td>
            	<td colspan="4">
                    <p>Departamento:<br/>
                        <select name="departamento" class="cb_departamento" disabled="">
                            <option> </option>
                        </select>
                    </p>
            	</td>
            </tr>
            <tr>
                <td colspan="2">
                    <p>Qtd Min Sems:<br/> <input type="number" name="qtdMinSemestres" class="in_menores"></p>
            	</td>
                <td colspan="2">
                    <p>Qtd Max Sems:<br/> <input type="number" name="qtdMaxSemestres" class="in_menores"></p>
            	</td>
            	<td>
                    <p>Carga Horária:<br/> <input type="number" name="cargaHoraria" class="in_menores"></p></td>
                <td>
                    <p>Creditação:<br/> <input type="number" name="credito" class="in_menores"></p>
                
                </td>
            </tr>
            <tr>
            	<td colspan="7" style="text-align:center"> <p>Turno:<br/>
                     <input type="radio" name="turno" value="1" id="turnoM">
                     <label for="turnoM">Matutino</label>
                     <input type="radio" name="turno" value="2" id="turnoV">
                     <label for="turnoV">Vespertino</label>
                     <input type="radio" name="turno" value="3" id="turnoN">
                     <label for="turnoN">Noturno</label> </p>
                </td>
            </tr>
            
            <tr></tr>
            <tr align="center">
            	<td height="56" colspan="7">
                  <input type="submit" name="opcao" value="Incluir" id="btn_novo" class="botao" onClick="checkFields()">
                  <input type="submit" name="opcao" value="Alterar" id="btn_alterar" class="botao">
                  <input type="submit" name="opcao" value="Deletar" id="btn_deletar" class="botao">
                </td>
         	</tr>
        </table>
    </form>
    </div>
    </body>
</html>
