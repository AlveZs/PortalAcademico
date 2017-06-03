<%-- 
    Document   : cad_Processo
    Created on : 28/05/2017, 17:43:35
    Author     : Marcus Filipe

- Cadastro de processos: Data, nome e matricula do aluno, situação (aprovado ou reprovado) e qtd de semestres adicionais além da qtd total de semestres.
--%>

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
        
       <div id="ctx" align="center">
        <h1> Gerenciar Processos </h1>
        <div class="separador"></div>
    <form method="post" name="consulta">        
    	<table id="tab_dados_aluno"  width="750" border="0"  align="center">
        	<tr>
                <td colspan="2"> <p> Matrícula:<br/> <input type="text" name="matricula" > <input type="button" name="buscar" value="Buscar" style="margin-left:30px"> </p> </td>
                <td> <p> Data<br/> <input type="date" name="data"> </td>
            </tr>
            <tr>
            	<td colspan="4">
                	<p> Nome:<br/> <input style="width:100%" type="text" name="nome"> </p>
                </td>
            </tr>
            <tr>
            	<td>
                	<div>
                            <p> Situação:<br/> <select name="situacao" style="width:120px;">
                            <option value="0"></option>
                            <option value="1"> Aprovado </option>
                            <option value="2"> Reprovado </option>
                        </select> </p>
                    </div>  
                </td>   
                <td style="width: 260px;">
                    <div>
                    	<p> Qtd. Total de Semestres:<br/> <input style="width: 150px;" type="text" name="qtdTotalSem" class="caixas" > </p>
                    </div>
                </td>
                <td>
                    <div>
                        <p> Qtd. Adicional de Semestres:<br/> <input style="width: 150px; margin-right: 150px; " type="text" name="qtdAdicionalSem" class="caixas" > </p>
                    </div>
                </td>
            </tr>
            <tr></tr>
            <tr> 
            	<td align="center" colspan="3"> 
                    <input type="button" value="Novo" id="btn_novo" class="botao">
                    <input type="button" value="Alterar" id="btn_alterar" class="botao"> 
                    <input type="reset" value="Limpar" id="btn_limpar" class="botao"> 
                </td>
            </tr>
        </table>
    </body>
</html>
