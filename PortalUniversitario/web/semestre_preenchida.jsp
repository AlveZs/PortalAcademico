<%-- 
    Document   : semestre_preenchida
    Created on : 07/06/2017, 22:31:13
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Portal Universitário | Semestre</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
    <link href="css/semestre.css" rel="stylesheet" type="text/css">
</head>
    <body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->  
        <div>
        <form method="post" action="SemestreController">
            <% Model.Semestre sc = (Model.Semestre)request.getAttribute("sc");%>
            <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="600">
                <th colspan="4">
                    <h1>Semestres Cancelados</h1>
                    <div class="separador"></div>
                </th>
                <tr align="center">
                    <td><b>Ano</b></td>
                    <td><b>Semestre</b></td>
                </tr>
                <%for(Model.Semestre semestre : sc.getTodos()){%>
                    <tr align="center">
                        <td><%=semestre.getAno()%></td>
                        <td><%=semestre.getSemestre()%></td>
                    </tr>
                <%}%>
                
                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="Voltar" name="opcao">
                    </td>
                </tr>
            </table>             
        </form>
        </div>
    </body>
</html>
