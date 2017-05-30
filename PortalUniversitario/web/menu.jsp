<%-- 
    Document   : menu
    Created on : 28/05/2017, 14:41:15
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div id="cabecalho">
        <a href="pag_coordenador.jsp"><img src="img/Logo_small_branca.png" width="119" height="91" /></a>
      <div id="boasvindas">
      		<p style="display: inline;"> Bem-Vindo, $coordenador! </p> 
            <a href="index.html" style="margin-left: 20px;">Sair</a> 
      </div>
	</div>
    <div id="barra_menu">
    	<ul class="menu">
        	<li> <a href="AlunoController?opcao=preencher"> Aluno </a> </li>
            <li> <a href="CursoController?opcao=preencher"> Curso </a> </li>
            <li> <a href="coord_disciplina.jsp"> Disciplina </a> </li>
			<li> <a href="coord_semestre.jsp"> <div></div> Semestre </a> </li>
            <li> <a href="processo.jsp"> <div></div> Processos </a> </li>
            <li> <a href="#"> Relatório </a>
            		<ul>
                        <li> <a href="relatorio_integralizacao.jsp"> <div></div> Integralização </a> </li>
                        <li> <a href="relatorio_formacao.jsp"> <div></div> Formação </a> </li>
                        <li> <a href="relatorio_oferta_materias.jsp"> <div></div> Ofertar Matérias </a> </li>
            		</ul>
            </li>
        </ul>
    </div>
    </body>
</html>
