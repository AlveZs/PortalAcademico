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
        <script>
            function nulo() {
                alert("Não existe resultado para esse código");
            }
        </script>
    </head>
    <body>
        
    <form method="post" action="ProcessoController" name="consulta">
        <% String verificaNulo = (String)request.getAttribute("verNulo");%> 
        <%  if (verificaNulo.equals("sim")){%>
            <script type="text/javascript">
                nulo();
            </script>   
        <%}%>        
    	<table id="tab_dados_aluno" class="tabelao" width="750" border="0"  align="center">
            <th colspan="5">
                <h1> Gerenciar Processos </h1>
                <div class="separador"></div>
            </th>
        	<tr>
                <td colspan="2"> <p> Código do processo:<br/> <input type="text" name="codProcesso" > <input type="submit" name="opcao" value="Buscar" style="margin-left:30px"> </p> </td>
                <td> <p> Matrícula<br/> <input type="text" name="matrícula"> </td>
            </tr>
            <tr>
            	<td>
                    <div>
                        <p> Situação:<br/> <select name="situacao" style="width:120px;">
                            <option value="Vazio"></option>
                            <option value="1"> Aprovado </option>
                            <option value="0"> Reprovado </option>
                        </select> </p>
                    </div>  
                </td>   
                <td style="width: 260px;">
                    <div>
                    	<p> Qtd. Total de Semestres:<br/> <input style="width: 150px;" type="text" name="qtdTotalSem" class="caixas" > </p>
                    </div>
                </td>
            </tr>
            <tr></tr>
            <tr> 
            	<td align="center" colspan="3"> 
                    <input type="submit" name="opcao" value="Incluir" id="btn_novo" class="botao">
                    <input type="submit" value="Alterar" id="btn_alterar" class="botao">
                    <input type="submit" name="opcao" value="Deletar" id="btn_deletar" class="botao"> 
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>
