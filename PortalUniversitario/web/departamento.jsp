<%-- 
    Document   : departamento
    Created on : 02/06/2017, 09:16:06
    Author     : joao
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Universitário | Processos</title>
        <%@include file="menu.jsp" %>
        <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
        <link href="css/aluno.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form method="post" action="DepartamentoController" name="departamentoForm">
            <%Model.Resultados resultado = (Model.Resultados)request.getAttribute("results");
            ArrayList <Model.Campus> campi = new ArrayList();
            resultado.pesquisarTodosCampus();
            campi = resultado.getCampus();
            %>
            <table id="tab_dados_aluno" class="tabelao" width="750" border="0"  align="center">
                <th colspan="2">
                    <h1>Gerenciar Departamento</h1>
                    <div class="separador"></div>
                </th>
                <tr>
                    <td colspan="2"> <p> Código:<br/> <input type="text" name="codDept" > <input type="submit" name="opcao" value="Buscar" style="margin-left:30px"> </p> </td>
                </tr>
                <tr>
                    <td> <p> Nome:<br/> <input type="text" name="nome" style="width:350px;"> </td>
                    <td>
                        <div>
                            <p> Campus:<br/> <select name="campus" style="width:200px;">
                            <option> </option>
                                <%for(int i=0;i<campi.size();i++){ %>
                                <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                                <%}%>
                            </select> </p>
                        </div>  
                    </td>
                </tr>
                <tr></tr>
                <tr> 
                    <td align="center" colspan="2"> 
                        <input type="submit" name="opcao" value="Incluir" id="btn_novo" class="botao">
                        <input type="submit" name="opcao" value="Alterar" id="btn_alterar" class="botao">
                        <input type="submit" name="opcao" value="Deletar" class="botao"> 
                        <input type="reset" value="Limpar" id="btn_limpar" class="botao"> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
