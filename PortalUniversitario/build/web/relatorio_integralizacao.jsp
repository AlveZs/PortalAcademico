<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<!-- Inicio do Template -->
<head>
    <meta charset="utf-8">
    <title>Portal Universitário | Integralização</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->
    
    <%
        Model.Resultados resultados = (Model.Resultados) request.getAttribute("results");
        ArrayList<Model.Departamento> departamentos = new ArrayList<Model.Departamento>();
        
        resultados.pesquisarTodosDepartamentos();
        departamentos = resultados.getDepartamentos();
    %>
    
    <div>
        
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
                        <option value="<%= departamentos.get(i).getNome()%>"><%= departamentos.get(i).getNome()%></option>
                    <%}%>
                </select>
                </p> </div>
                <div style="margin-left:10px"> <p>Curso:<br/> <select name="curso" class="cb_curso">
                    <option value="0"></option>
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
    </div>
</body>
</html>
