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
    <title>Portal Universit�rio | Forma��o</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->  
    <div id="ctx" align="center">
        <h1>Relat�rio de Forma��o</h1>
        <div class="separador">
    </div>
    <form method="post" action="FormacaoController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabela_menu">	
                <tr>
                <td>
                    <div> <p>Departamento:<br/> <select name="departamento">
                        <option value="0"></option>
                        <option value="1">DCET</option>
                        <option value="2">DCV</option>
                    </select>
                    </p> </div>
                    <div style="margin-left:10px;"> <p>Curso:<br/> <select name="curso" style="width: auto;">
                        <option value="0"></option>
                        <option value="1">Sistemas de Informação</option>
                        <option value="2">Engenharia Civil</option>
                    </select>
                    </p></div>
                    <div style="margin-left:10px"> <p>Situa��o:<br/> <select name="curso" style="width: auto;">
                        <option value="0"></option>
                        <option value="1">Possivel Concluinte</option>
                        <option value="2">Jubilado</option>
                    </select>
                    </p>
                    </div>
                    <div> 
                        <input type="button" value="Buscar" id="btn_buscar" onClick="checkFields()">
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
                <td>070112453</td>
                <td>Sergio B.</td>
                <td>9</td>
                <td>6</td>
                <td>Possivel Concluinte</td>
            </tr>
            <tr>
                <td>070912453</td>
                <td>Irineu</td>
                <td>10</td>
                <td>20</td>
                <td>Jubilado</td>
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
