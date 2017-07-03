<%-- 
    Document   : menu
    Created on : 28/05/2017, 14:41:15
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
    
if((session.getAttribute("tipoUser")== null))
    response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">    
        <link href="css/modal.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/libs/jquery/jquery.js"></script>
        <script type="text/javascript" src="js/modal.js"></script>
        <script type="text/javascript" src="js/ajax/requisicao_cbs_departamento_curso.js"></script>
    </head>
    <body>
    <div id="cabecalho">
        <a href="pag_coordenador.jsp"><img src="img/Logo_small_branca.png" width="119" height="91" /></a>
      <div id="boasvindas">
          <p style="display: inline;"> Bem-Vindo, <%= session.getAttribute("nome")%>! </p> 
            <a href="logout.jsp" style="margin-left: 20px;">Sair</a> 
      </div>
	</div>
    <div id="barra_menu">
    	<ul class="menu">
        	<li> <a href="AlunoController?opcao=preencher" id="aluno"> Aluno </a> </li>
                <li> <a href="CursoController?opcao=preencher" id="curso"> Curso </a> </li>           
            <li> <a href="processo.jsp" id="processo"> <div></div> Processos </a> </li>
            <li> <a href="#" id="relatorio"> Relatório </a>
            		<ul>
                            <li> <a href="relatorio_integralizacao.jsp" id="integralizacao"> <div></div> Integralização </a> </li>
                            <li> <a href="relatorio_formacao.jsp" id="formacao"> <div></div> Formação </a> </li>
                            <li> <a href="Relatorio_OfertaDisciplinaController?opcao=preencher" id="oferta"> <div></div> Ofertar Matérias </a> </li>
            		</ul>
            </li>
             <li> <a href="DisciplinaController?opcao=preencher" id="disciplina"> Disciplina </a> </li>
            <li> <a href="coord_semestre.jsp" id="semestre"> <div></div> Semestre </a> </li>
            <li> <a href="UsuarioController?opcao=preencher" id="usuario"> <div></div> Usuário </a> </li>
            <li> <a href="DepartamentoController?opcao=preencher" id="departamento"> <div></div> Departamento  </a> </li>
        </ul>
    </div>
            
        <script>
            var sessao = <%= session.getAttribute("tipoUser") %>;
            //document.write(sessao);
            
            if(sessao != 1){ //se nao for root
                    document.getElementById("usuario").disabled = true;
                    document.getElementById("usuario").style.display = "none";
                    document.getElementById("departamento").disabled = true;
                    document.getElementById("departamento").style.display = "none";
                   
                   if(sessao != 2){ //se nao foor coord acad
                        document.getElementById("semestre").disabled = true;
                        document.getElementById("semestre").style.display = "none";
                        document.getElementById("disciplina").disabled = true;
                        document.getElementById("disciplina").style.display = "none";
                            
                              if(sessao != 4){
                                    document.getElementById("relatorio").disabled = true;
                                    document.getElementById("relatorio").style.display = "none";
                                    document.getElementById("integralizacao").disabled = true;
                                    document.getElementById("integralizacao").style.display = "none";
                                    document.getElementById("formacao").disabled = true;
                                    document.getElementById("formacao").style.display = "none";
                                    document.getElementById("oferta").disabled = true;
                                    document.getElementById("oferta").style.display = "none";
                                    document.getElementById("processo").disabled = true;
                                    document.getElementById("processo").style.display = "none";
                                    document.getElementById("curso").disabled = true;
                                    document.getElementById("curso").style.display = "none";
                                 }
                   }
            }
        </script>
            
    </body>
</html>
