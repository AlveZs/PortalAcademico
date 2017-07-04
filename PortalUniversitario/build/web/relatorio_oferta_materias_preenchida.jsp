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
    <title>Portal Universit�rio | Disciplina</title>
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
    resultados.pesquisarTodosDepartamentos();
    cursos = resultados.getCursos();
    departamentos = resultados.getDepartamentos();
    int minSemestres = 0;
    %>
     <div>
    <form method="post" action="Relatorio_OfertaDisciplinaController">
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="800" id="tab_disciplinas">
            <th colspan="3">
                <h1>Relat�rio de Oferta de Mat�rias</h1>
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
                    <div style="margin-left:10px"> <p>Curso:<br/> <select name="curso" style="width: 260px;">
                        <% for(int i=0;i<cursos.size();i++) {
                            if (request.getParameter("departamento").equals(cursos.get(i).getDepartamento())) {
                        %>
                                <option value="<%=cursos.get(i).getNome()%>" <% if(request.getParameter("curso").equals(cursos.get(i).getNome())) { %> selected="selected" <%}%>> <%=cursos.get(i).getNome()%> </option>
                        <%} }%>
                    </p></div>
                
                    <div> 
                        <input type="submit" name="opcao" value="Buscar" id="btn_buscar" onClick="checkFields()">
            	</div>
            </td>
            </tr>
                <%
                resultados.pesquisarResultadosHistorico(request.getParameter("curso"));

                ArrayList<Model.Disciplina> disciplinas = new ArrayList<Model.Disciplina>();
                //Deixei o nome da classe na constru��o do ArrayList porque por alguma raz�o, o GlassFish buga se tirar

                disciplinas = resultados.getDisciplinas();
                
                for(int i=0;i<cursos.size();i++)
                    if(request.getParameter("curso").equals(cursos.get(i).getNome()))
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
                                        <h3> <%=i+1%>� Semestre </h3>
                                    </th>
                                    </tr>
                                    <tr>
                                    <th>Disciplina:</th>
                                    <th>C�digo:</th>
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
