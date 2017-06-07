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
        <%Model.Resultados resultado = (Model.Resultados)request.getAttribute("results");
        ArrayList<Model.Curso> cursos = new ArrayList();
        resultado.pesquisarTodosCursos();
        cursos = resultado.getCursos();
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
                	<p>Optativa:<br/> <input type="checkbox" name="optativa" style="margin: 10px 0 0 35px"></p>
                    </div>
            </td>
            </tr>
            <tr>
            <td>
            	<div>
                    <p> Curso:<br/> <select name="curso" id="sel_curso" style="width:120px;">
                            <option> </option>
                            <%for(int i=0;i<cursos.size();i++){ %>
                            <option value="<%= cursos.get(i).getIdCurso()%>"><%= cursos.get(i).getNome()%></option>
                            <%}%>
                        </select> </p>
                </div>
                <div style="margin-left:10px">
                        <p> Tipo:<br/><select name="tipo">
                        <option> </option>
                        <option value="1">Regular</option>
                        <option value="2">Optativa</option>
                        </select></p>
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
