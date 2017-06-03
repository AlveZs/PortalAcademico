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
    <form method="post" action="AlunoController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="600">
            <th colspan="2">
            	<h1>Gerenciar Disciplina</h1>
                <div class="separador"></div>
            </th>
            <tr>
            	<td> <p>Código:<br/> <input class="in_menores" type="text" name="codigo"><input  id="btn_buscar" type="button" value="Buscar"></p> </td>
            </tr> 
            <tr>
                    <td colspan="2"> <p>Nome:<br/> <input id="largura1" type="text" name="nome" ></p> </td>
            </tr>
            <tr>
            	<td colspan="2"> <div>
                	<p>Carga Horária:<br/> <input type="number" name="cargaHoraria" class="in_menores"></p>
                </div>
                <div>
	                <p>Creditação:<br/> <input type="number" min="1980" max="2099" name="creditacao" class="in_menores"></p>
                </div>
                <div>            
	            	<p>Semestre:<br/> <input type="number" min="1" max="2" name="semestre" class="in_menores"></p>
                </div>
                <div>
                	<p>Optativa:<br/> <input type="checkbox" name="optativa" style="margin: 10px 0 0 35px"></p>
                    </div>
            </td>
            </tr>
            <tr>
            <td>
            	<div>
                	<p> Docente:<br/> <input type="text" name="docente"></p>
                </div>
                <div style="margin-left:10px">
                	<p> Turma:<br/> <input type="number" min="1" max="2" name="semestre" style="width:80px"></p>
                </div>
                <div style="margin-left:10px">
                	<p>Prioridade:<br/> <input type="text" name="prioridade" style="width: 130px;"></p>
                </div>
            </td>
            </tr>
            <tr> 
            	<td align="center"> 
                    <input type="button" value="Novo" id="btn_novo" class="botao">
                    <input type="button" value="Alterar" id="btn_alterar" class="botao"> 
                    <input type="reset" value="Limpar" id="btn_limpar" class="botao"> 
                </td>
            </tr>
        </table>
    </form>
    </div>
        
    </body>
</html>
