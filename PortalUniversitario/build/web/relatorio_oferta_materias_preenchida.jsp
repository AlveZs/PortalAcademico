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
    ArrayList<Model.Campus> campi = new ArrayList();
    resultados.pesquisarTodosDepartamentos();
    resultados.pesquisarTodosCampus();
    cursos = resultados.getCursos();
    departamentos = resultados.getDepartamentos();
    campi = resultados.getCampus();
    int minSemestres = 0;
    %>
     <div>
    <form method="post" action="Relatorio_OfertaDisciplinaController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="800" id="tab_disciplinas">
            <th colspan="3">
                <h1>Relatório de Oferta de Matérias</h1>
                <div class="separador"></div>
            </th>
            <tr>
            <td>
                <div>
                    <p>Campus:<br/> <select name="campus">
                        <option value="0"></option>
                        <%
                            for(int i=0;i<campi.size();i++){ %>
                            <option value="<%= campi.get(i).getId()%>" <% if(Integer.parseInt(request.getParameter("campus")) == campi.get(i).getId()) { %> selected="selected" <%}%> ><%= campi.get(i).getNome()%></option>
                        <%}%>
                    </select> </p>
                </div>
            	<div style="margin-left:10px">
                    <p>Departamento:<br/> <select name="departamento">
                        <option value="0"></option>
                        <% for(int i=0;i<departamentos.size()/2;i++) {
                            if (Integer.parseInt(request.getParameter("campus")) == departamentos.get(i).getCampus()) {
                        %>
                            <option value="<%=departamentos.get(i).getId()%>" <% if(Integer.parseInt(request.getParameter("departamento")) == departamentos.get(i).getId()) { %> selected="selected" <%}%>> <%=departamentos.get(i).getNome()%> </option>
                        <%} }%>
                    </select></p>
                </div>
                    
                <div style="margin-left:10px"> <p>Curso:<br/> <select name="curso" class="cb_curso">
                    <option value="0"></option>
                    <% for(int i=0;i<cursos.size();i++) {
                        if (Integer.parseInt(request.getParameter("departamento")) == cursos.get(i).getDepartamento().getId()) {
                    %>
                            <option value="<%=cursos.get(i).getIdCurso()%>" <% if(Integer.parseInt(request.getParameter("curso")) == cursos.get(i).getIdCurso()) { %> selected="selected" <%}%>> <%=cursos.get(i).getNome()%> </option>
                    <%} }%>
                </select></p></div>
                
                <div> 
                    <input type="submit" name="opcao" value="Buscar" id="btn_buscar" onClick="checkFields()">
                </div>
            </td>
            </tr>
                <%
                resultados.pesquisarResultadosHistorico(Integer.parseInt(request.getParameter("curso")));

                ArrayList<Model.Disciplina> disciplinas = new ArrayList<Model.Disciplina>();
                //Deixei o nome da classe na construï¿½ï¿½o do ArrayList porque por alguma razï¿½o, o GlassFish buga se tirar

                disciplinas = resultados.getDisciplinas();
                
                for(int i=0;i<cursos.size();i++)
                    if(Integer.parseInt(request.getParameter("curso")) == cursos.get(i).getIdCurso())
                        minSemestres = cursos.get(i).getMinSemestre();
                
                int flag;
                for (int i=0; i<=minSemestres; i++) {
                    flag = 0;
                    for (int j=0; j<disciplinas.size(); j++) {
                        if (i+1 == disciplinas.get(j).getSemestre()) {
                            if (flag == 0) {
                                %>
                                <tr>
                                <td>
                                <table border="1" align="center" width="500" style="margin-bottom:40px;">
                                    <tr>
                                    <th colspan="4">
                                        <h3> <%=i+1%>º Semestre </h3>
                                    </th>
                                    </tr>
                                    <tr>
                                    <th>Disciplina:</th>
                                    <th>Código:</th>
                                    <th>Demanda:</th>
                                    <th>Optativa:</th>
                                    </tr>
                                    <tr>
                                        <td><%=disciplinas.get(j).getNome()%></td>
                                        <td><%=disciplinas.get(j).getCodigo()%></td>
                                        <td><%=disciplinas.get(j).getQtdPendentes()%> alunos</td>
                                        <td> <% if (disciplinas.get(j).getTipo().equals("Optativa")) { %> X <%}%> </td>  
                                    </tr>
                                <%
                                flag = 1;
                            }
                            else {
                                %>
                                <tr>
                                    <td><%=disciplinas.get(j).getNome()%></td>
                                    <td><%=disciplinas.get(j).getCodigo()%></td>
                                    <td><%=disciplinas.get(j).getQtdPendentes()%> alunos</td>
                                    <td> <% if (disciplinas.get(j).getTipo().equals("Optativa")) { %> X <%}%> </td>  
                                </tr>
                            <%
                            }
                        }
                    }
                    if (flag == 1) {
                    %>
                        </table>        
                        </td>
                        </tr>
                    <%
                    }
                }
                %>
        </table>
    </form>
    </div>
</body>
</html>
