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
    <title>Portal UniversitÃ¡rio | Disciplina</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
    <link href="css/disciplina.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->
        
     <div>
    <form method="post" action="DisciplinaController">
        <%
            Model.Resultados resultados = new Model.Resultados();
            ArrayList<Model.Campus> campi = new ArrayList();
            ArrayList<Model.Departamento> departamentos = new ArrayList();
            ArrayList<Model.Curso> cursos = new ArrayList();
            
            resultados.pesquisarTodosCampus();
            resultados.pesquisarTodosDepartamentos();
            resultados.pesquisarTodosCursos();
            
            campi = resultados.getCampus();
            departamentos = resultados.getDepartamentos();
            cursos = resultados.getCursos();
        %>
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="600">
            <th colspan="2">
            	<h1>Gerenciar Disciplina</h1>
                <div class="separador"></div>
            </th>
            <tr>
            	<td> <p>Código:<br/> <input class="in_menores" type="text" name="codigo"><input  id="btn_buscar" type="submit" name="opcao" value="Buscar"></p> </td>
            </tr> 
            <tr>
                    <td colspan="2"> <p>Nome:<br/> <input id="largura1" type="text" name="nome" ></p> </td>
            </tr>
            <tr>
            	<td colspan="2"> <div>
                	<p>Carga Horária:<br/> <input type="number" name="cargaHoraria" class="in_menores"></p>
                </div>
                <div>
	                <p>Creditação:<br/> <input type="number" min="1" name="creditacao" class="in_menores"></p>
                </div>
                <div>            
	            	<p>Semestre:<br/> <input type="number" min="1" name="semestre" class="in_menores"></p>
                </div>
                <div>
                    <p>Optativa:<br/> <input type="checkbox" name="optativa" value="2" style="margin: 10px 0 0 35px"></p>
                </div>
            </td>
            </tr>
            <tr>
            <td colspan="5">
            	<div>
                    <p> Campus:<br/> <select name="campus" id="cb_campus" style="width:120px; margin-right: 10px">
                        <option> </option>
                        <%for(int i=0;i<campi.size();i++){ %>
                            <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                        <%}%>
                    </select> </p>
                </div>
                <div>
                    <p> Departamento:<br/> <select name="departamento" id="cb_departamento" style="width:120px; margin-right: 10px" disabled="">
                        <option> </option>
                    </select> </p>
                </div>
                <div>
                    <p> Curso:<br/> <select name="curso" id="cb_curso" style="width:240px;" disabled="">
                        <option> </option>
                    </select> </p>
                </div>
            </td>
            </tr>
            <tr> 
            	<td align="center"> 
                    <input type="submit" name="opcao" value="Incluir" id="btn_novo" class="botao">
                    <input type="submit" name="opcao" value="Alterar" id="btn_alterar" class="botao">
                    <input type="submit" name="opcao" value="Deletar" class="botao"> 
                    <input type="reset" value="Limpar" id="btn_limpar" class="botao"> 
                </td>
            </tr>
        </table>
    </form>
    </div>
        
    </body>
</html>
