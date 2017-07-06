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
            <%Model.Departamento departamento = (Model.Departamento)request.getAttribute("depart");
            Model.Resultados resultado = (Model.Resultados)request.getAttribute("results");
            ArrayList <Model.Campus> campi = new ArrayList();
            resultado.pesquisarTodosCampus();
            campi = resultado.getCampus();
            %>
            <table id="tab_dados_aluno" class="tabelao" width="750" border="0"  align="center">
                <th colspan="4">
                    <h1>Gerenciar Departamento</h1>
                    <div class="separador"></div>
                </th>
                <tr>
                        <td colspan="2"> <p> Código:<br/> <input type="text" name="codDept" value="<%=departamento.getCodigo()%>" > <input type="submit" name="opcao" value="Buscar" style="margin-left:30px"> </p> </td>
                        <td> <p> Nome:<br/> <input type="text" name="nome" value="<%=departamento.getNome()%>"> </td>
                </tr>
                <tr>
                    <td>
                            <div>
                                <p> Campus:<br/> <select name="campus" style="width:120px;">
                                    <option value="<%=departamento.getCampus()%>"><%=departamento.getNomeCampus()%></option>
                                    <%for(int i=0;i<campi.size();i++){ 
                                        if(!campi.get(i).getNome().equals(departamento.getNomeCampus())){%>
                                            <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                                        <%}%>
                                    <%}%>
                                </select> </p>
                        </div>  
                    </td>   
                </tr>
                <tr></tr>
                <tr> 
                    <td align="center" colspan="3"> 
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
