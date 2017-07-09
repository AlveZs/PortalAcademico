<%@page import="java.util.ArrayList"%>
<%@ page import ="java.sql.*" %>
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
    <title>Portal Universitário | Disciplina</title>
    <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
    <link href="css/relatorio_oferta_materias.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="menu.jsp" %>
    <!-- Final do Template -->
    
    <% 
    Model.Resultados resultados = (Model.Resultados)request.getAttribute("results");
    ArrayList<Model.Curso> cursos = new ArrayList();
    ArrayList<Model.Departamento> departamentos = new ArrayList();
    ArrayList<Model.Aluno> alunos = new ArrayList();
    resultados.pesquisarTodosDepartamentos();
    cursos = resultados.getCursos();
    departamentos = resultados.getDepartamentos();
   
    %>
    
    <form method="post" action="Relatorio_FormacaoController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="800" id="tab_disciplinas">
            <th colspan="3">
                <h1>Relatório de Formação</h1>
                <div class="separador"></div>
            </th>
            
            <tr>
            <td>
            	<div>
                <p>Departamento:<br/> <select name="departamento">
                        <option value="0"></option>
                        <%
                            for(int i=0;i<departamentos.size();i++){ %>
                            <option value="<%= departamentos.get(i).getNome()%>" <% if(request.getParameter("departamento").equals(departamentos.get(i).getNome())) { %> selected="selected" <%}%> ><%= departamentos.get(i).getNome()%></option>
                        <%}%>
                    </select>
                    </p> </div>
                    <div style="margin-left:10px"> <p>Curso:<br/> <select name="curso" class="cb_curso">
                        <% for(int i=0;i<cursos.size();i++) {
                            if (request.getParameter("departamento").equals(cursos.get(i).getDepartamento())) {
                        %>
                                <option value="<%=cursos.get(i).getNome()%>" <% if(request.getParameter("curso").equals(cursos.get(i).getNome())) { %> selected="selected" <%}%>> <%=cursos.get(i).getNome()%> </option>
                        <%} }%>                   
                    </select>
                  </p> </div>
                     <div style="margin-left:10px"> <p>Situação:<br/> <select name="situacao" style="width: auto;">
                        <option value="0"></option>
                        <option value="1">Possivel Concluinte</option>
                        <option value="2">Jubilado</option>
                    </select>
                    </p>
                </div>
                <div> 
                    <input type="submit" name="opcao" value="Buscar" id="btn_buscar" onClick="checkFields()">
                </div>
            </td>
            </tr>
            
            <tr>
            <td>
            <%
                ArrayList<Model.Integralizacao> relFor = new ArrayList();
                String nomeCurso = request.getParameter("curso");
                resultados.pesquisarTodosAlunos(nomeCurso);
                alunos = resultados.getAlunos();
                for(Model.Aluno a : alunos) {
                    Model.Integralizacao obj = new Model.Integralizacao();
                    obj.getAluno().setNome(a.getNome());
                    obj.getAluno().setMatricula(a.getMatricula());
                    obj.getCurso().setNome(a.getCurso().getNome());
                    obj.pesquisarInfos();
                    obj.pesquisarQtdMat();
                    obj.pesquisarQtdAprovadas();
                    obj.pesquisarSemCancelados();
                    obj.calculaMateriasRestantes();
                    obj.calculaQtdSemestres();
                    relFor.add(obj);
                }
            %>
                <table border="1" align="center" width="500" style="margin-bottom:40px;">
                    <tr>
                    <th>Matricula:</th>
                    <th>Nome:</th>
                    <th>Semestres:</th>
                    <th>Materias restantes:</th>
                    <th>Situação:</th>
                    </tr>
                    
                <%for(Model.Integralizacao i: relFor){%>
                    <tr>
                        <td><%=i.getAluno().getMatricula()%></td>
                        <td><%=i.getAluno().getNome()%></td>
                        <td><%=i.getQtdtSemestres()%></td>
                        <td><%=i.getMateriasRestantes()%></td>
                        <td><%=i.verificaSituacao(nomeCurso)%></td>
                    </tr>
                <%}%>
                </table>
            </td>
            </tr>
        </table>
    </form>
</body>
</html>
