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
    <title>Portal Universitário | Semestre</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
    <link href="css/semestre.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->  
    <div>
    <form method="post" action="SemestreController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="600">
        	<tr>
            <th colspan="4">
            	<h1>Cancelar Semestre</h1>
                <div class="separador"></div>
            </th>
            </tr>
            <tr align="center">
                <td><div><p> Ano:<br/> <input type="number" min ="1900" max="2099" name="ano" class="caixas" > </p></div>
                <div><p> Semestre:<br/> <input type="number" min="1" max="2" name="semestre" class="caixas"> </p></div></td>
            </tr>
            <tr align="center">
            	<td height="56" colspan="4">
                  <input type="submit" name = "opcao" value="Incluir" id="btn_novo" class="botao" onClick="checkFields()">
                  <input type="submit" name="opcao" value="Buscar" id="btn_novo" class="botao">
                  <input type="submit" name="opcao" value="Deletar" id="btn_novo" class="botao">
                  <input type="reset" value="Limpar" id="btn_limpar" class="botao">
                </td>
            </tr>
        </table>
    </form>
    </div>
    </body>
    
</html>
