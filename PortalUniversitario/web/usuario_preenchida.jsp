<%-- 
    Document   : usuario
    Created on : 06/06/2017, 19:14:58
    Author     : joao
--%>


<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Universitário | Usuario</title>
        <%@include file="menu.jsp" %>
        <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
        <link href="css/aluno.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form method="post" action="UsuarioController" name="usuarioForm">
            <%Model.Resultados resultado = (Model.Resultados)request.getAttribute("results");
            Model.Usuario usuario = (Model.Usuario)request.getAttribute("usr");
            resultado.pesquisarTodosCampus();
            resultado.pesquisarTodosCursos();
            resultado.pesquisarTodosDepartamentos();
            ArrayList<Model.Campus> campi = new ArrayList();
            ArrayList<Model.Curso> cursos = new ArrayList();
            ArrayList<Model.Departamento> departamentos = new ArrayList();
            campi = resultado.getCampus();
            cursos = resultado.getCursos();
            departamentos = resultado.getDepartamentos();
            int tipoUsr = usuario.getTipoUser();
            %>
            <table id="tab_dados_aluno" class="tabelao" width="750" border="0"  align="center">
                <th colspan="4">
                    <h1>Gerenciar Usuário</h1>
                    <div class="separador"></div>
                </th>
                <tr>
                    <td colspan="2"> <p> Matrícula:<br/> <input type="text" value="<%=usuario.getMatricula()%>" name="matricula" > <input type="submit" name="opcao" value="Buscar" style="margin-left:30px"> </p> </td>
                    <td>                                   
                        <p>Tipo: <select name="tipo" style="width:120px;">
                                <% if(tipoUsr == 1) {%>
                                    <option value="1" selected="selected"> Root </option>
                                <%}%>
                                <option value = "2" <% if(tipoUsr == 2) {%> selected="selected" <%}%> >Coordenador(a) Acadêmico</option>
                                <option value = "3" <% if(tipoUsr == 3) {%> selected="selected" <%}%> >Secretário(a) Acadêmico</option>
                                <option value = "4" <% if(tipoUsr == 4) {%> selected="selected" <%}%> >Coordenador(a) Curso</option>
                                <option value = "5" <% if(tipoUsr == 5) {%> selected="selected" <%}%> >Secretário(a) Curso</option>
                                <option value = "6" <% if(tipoUsr == 6) {%> selected="selected" <%}%> >Aluno(a)</option>        
                            }%>
                        </select></p> 
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <div>
                            <p> Campus:<br/> <select name="campus" id="cb_campus">
                                <option></option>
                                <%for(int i=0;i<campi.size();i++){ %>
                                    <option value="<%= campi.get(i).getId()%>" <% if(campi.get(i).getNome().equals(usuario.getCurso().getDepartamento().getNomeCampus())) {%> selected="selected" <%}%> ><%= campi.get(i).getNome()%></option>
                                <%}%>
                            </select> </p>
                        </div>
                        <div style="margin-left: 10px">
                            <p> Departamento:<br/> <select name="departamento" id="cb_departamento" style="width:120px;">
                                <option> </option>
                                <%
                                    for(int i=0;i<departamentos.size();i++) {
                                        if (usuario.getCampus().getNome().equals(departamentos.get(i).getNomeCampus())) {

                                %>
                                            <option value="<%= departamentos.get(i).getId()%>" <% if(departamentos.get(i).getNome().equals(usuario.getCurso().getDepartamento().getNome())) {%> selected="selected" <%}%> ><%= departamentos.get(i).getNome()%></option>
                                <%} }%>
                            </select> </p>
                        </div>
                        <div style="margin-left: 10px">
                            <p> Curso:<br/> <select name="curso"  id="cb_curso" class="cb_curso">
                                <% if(tipoUsr != 6 && tipoUsr != 5 && tipoUsr != 4) { %>
                                    <option> </option>
                                <%}
                                else {
                                    for(int i=0;i<cursos.size();i++) {
                                        if (usuario.getDepartamento().getNome().equals(cursos.get(i).getDepartamento().getNome())) {
                                %>
                                            <option value="<%=cursos.get(i).getIdCurso()%>" <% if(usuario.getCurso().getNome().equals(cursos.get(i).getNome())) { %> selected="selected" <%}%>> <%=cursos.get(i).getNome()%> </option>
                                <%} } }%>
                            </select></p>
                        </div>
                    </td>

                    <tr>
                        <td>
                            <p> Nome:<br/> <input type="text" value="<%=usuario.getNome()%>" name="nome"> 
                        </td>
                        <td>
                            <p> Senha:<br/> <input type="password" value="<%=usuario.getSenha()%>" name="senha">
                        </td>                                         
                    </tr>
                <tr></tr>
                <tr> 
                    <td align="center" colspan="3"> 
                        <input type="submit" name="opcao" value="Incluir" id="btn_novo" class="botao">
                        <input type="submit" name="opcao" value="Alterar" id="btn_alterar" class="botao">
                        <input type="submit" name="opcao" value="Deletar" class="botao"> 
                        <input type="reset" value="Limpar" id="btn_limpar" class="botao"> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
