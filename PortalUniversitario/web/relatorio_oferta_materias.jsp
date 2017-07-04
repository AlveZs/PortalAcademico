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
    <title>Portal Universit�rio | Disciplina</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
    <link href="css/relatorio_oferta_materias.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->
    
    <% 
    Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
    ArrayList<Model.Departamento> departamentos = new ArrayList();
    
    resultados.pesquisarTodosDepartamentos();
    departamentos = resultados.getDepartamentos();
    %>
     <div>
    <form method="post" action="Relatorio_OfertaDisciplinaController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="800" id="tab_disciplinas">
            <th colspan="3">
                <h1>Relat�rio de Oferta de Mat�rias</h1>
                <div class="separador"></div>
            </th>
            <tr>
            <td>
            	<div>
                <p>Departamento:<br/> <select name="departamento">
                        <option value="0"></option>
                        <%
                            for(int i=0;i<departamentos.size();i++){ %>
                            <option value="<%= departamentos.get(i).getNome()%>"><%= departamentos.get(i).getNome()%></option>
                        <%}%>
                    </select>
                    </p> </div>
                    <div style="margin-left:10px"> <p>Curso:<br/> <select name="curso" style="width: 260px;">
                        <option value="0"></option>
                    </select>
                    </p></div>
                
                    <div> 
                        <input type="submit" name="opcao" value="Buscar" id="btn_buscar" onClick="checkFields()">
            	</div>
                </td>
            </tr>
        </table>
    </form>
    </div>
</body>
</html>
