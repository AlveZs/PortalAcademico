<%-- 
    Document   : relatorio_integralizacao_preenchida
    Created on : 06/07/2017, 08:57:13
    Author     : joao
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Portal Universitário | Integralização </title>
</head>
<body>
        <%@include file="menu.jsp" %>
    <!-- Final do Template -->
    
    <%
        Model.Resultados resultados = (Model.Resultados) request.getAttribute("results");
        ArrayList<Model.Departamento> departamentos = new ArrayList<Model.Departamento>();
        ArrayList<Model.Curso> cursos = new ArrayList<Model.Curso>();
        
        resultados.pesquisarTodosDepartamentos();
        resultados.pesquisarTodosCursos();
        departamentos = resultados.getDepartamentos();
        cursos = resultados.getCursos();
    %>
    

    <form method="post" action="IntegralizacaoController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" id="tab_disciplinas">
            <th>
                <h1>Relatório de Integralização</h1>
                <div class="separador"></div>
            </th>

            <tr>
            <td>
                <div> <p>Departamento:<br/> <select name="departamento">
                    <option value="0"></option>
                    <%
                    for(int i=0;i<departamentos.size();i++){ %>
                        <option value="<%= departamentos.get(i).getNome()%>" <% if(request.getParameter("departamento").equals(departamentos.get(i).getNome())) { %> selected="selected" <%}%> ><%= departamentos.get(i).getNome()%></option>
                    <%}%>
                </select>
                </p> </div>
                <div style="margin-left:10px"> <p>Curso:<br/> <select name="curso" class="cb_curso">
                    <% for(int i=0;i<cursos.size();i++) {
                        if (request.getParameter("departamento").equals(cursos.get(i).getDepartamento())) {
                    %>
                            <option value="<%=cursos.get(i).getNome()%>" <% if(request.getParameter("curso").equals(cursos.get(i).getNome())) { %> selected="selected" <%}%>> <%=cursos.get(i).getNome()%> </option>
                    <%} }%>
                </select>
                </p></div>
                <div> 
                    <input type="submit" value="Buscar" id="btn_buscar" onClick="checkFields()">
                </div>
            </td>
            </tr>
            <tr>
            <td>
            <table id="tab_disciplinas" border="1" align="center">
                <th>Matricula:</th>
                <th>Aluno:</th>
                <th>Semestres concluidos:</th>
                <th>Materias restantes:</th>
                <th>Situacao:</th>
                <tr>
                    <td>070912453</td>
                    <td>Irineu</td>
                    <td>10</td>
                    <td>20</td>
                    <td>Alarmante</td>
                </tr>
                <tr>
                    <td>070112453</td>
                    <td>Sergio B.</td>
                    <td>9</td>
                    <td>6</td>
                    <td>Dentro do prazo</td>
                </tr>
            </table>
            </td>
            </tr>

            <tr>
                <td> Total de Alunos: 2</td>
            </tr>
        </table>
    </form>
</body>
</html>