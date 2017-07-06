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
            ArrayList<Model.Departamento> depts = new ArrayList();
            campi = resultado.getCampus();
            cursos = resultado.getCursos();
            depts = resultado.getDepartamentos();
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
                            <%switch(tipoUsr){
                                case 2:%>
                                    <option value = "2">Coordenador(a) Acadêmico</option>
                                    <option value = "3">Secretário(a) Acadêmico</option>
                                    <option value = "4">Coordenador(a) Curso</option>
                                    <option value = "5">Secretário(a) Curso</option>
                                    <option value = "7">Aluno(a)</option>
                                    <%break;
                                case 3:%>
                                    <option value = "3">Secretário(a) Acadêmico</option>
                                    <option value = "2">Coordenador(a) Acadêmico</option>
                                    <option value = "4">Coordenador(a) Curso</option>
                                    <option value = "5">Secretário(a) Curso</option>
                                    <option value = "7">Aluno(a)</option>
                                    <%break;
                                case 4:%>
                                    <option value = "4">Coordenador(a) Curso</option>
                                    <option value = "3">Secretário(a) Acadêmico</option>
                                    <option value = "2">Coordenador(a) Acadêmico</option>
                                    <option value = "5">Secretário(a) Curso</option>
                                    <option value = "7">Aluno(a)</option>
                                    <%break;
                                case 5:%>
                                    <option value = "5">Secretário(a) Curso</option>
                                    <option value = "4">Coordenador(a) Curso</option>
                                    <option value = "3">Secretário(a) Acadêmico</option>
                                    <option value = "2">Coordenador(a) Acadêmico</option>
                                    <option value = "7">Aluno(a)</option>
                                    <%break;
                                case 7:%>
                                    <option value = "7">Aluno(a)</option>
                                    <option value = "5">Secretário(a) Curso</option>
                                    <option value = "4">Coordenador(a) Curso</option>
                                    <option value = "3">Secretário(a) Acadêmico</option>
                                    <option value = "2">Coordenador(a) Acadêmico</option>
                                    <%break;         
                            }%>
                        </select></p> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>
                            <p> Campus:<br/> <select name="campus" style="width:120px;">
                                <option value="<%=usuario.getCampus().getId()%>"> <%=usuario.getCampus().getNome()%></option>
                                <%for(int i=0;i<campi.size();i++){ 
                                    if(!campi.get(i).getNome().equals(usuario.getCampus().getNome())){%>
                                        <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                                    <%}%>
                                <%}%>
                            </select> </p>
                        </div>  
                    </td>
                    <td>
                        <div>
                            <p> Departamento: <br/> <select name="departamento" style="width:120px;">
                                <option value="<%=usuario.getDepartamento().getId()%>"><%=usuario.getDepartamento().getNome()%> </option>
                                    <%for(int i=0;i<depts.size();i++){ 
                                        if(!depts.get(i).getNome().equals(usuario.getDepartamento().getNome())){%>
                                            <option value="<%= depts.get(i).getId()%>"><%= depts.get(i).getNome()%></option>
                                        <%}%>
                                    <%}%>
                            </select> </p>
                        </div>  
                    </td> 
                    <td>
                        <div>
                            <p> Curso:<br/> <select name="curso" style="width:120px;">
                                <option value="<%=usuario.getCurso().getIdCurso()%>"> <%=usuario.getCurso().getNome()%></option>
                                    <%for(int i=0;i<cursos.size();i++){ 
                                        if(!cursos.get(i).getNome().equals(usuario.getCurso().getNome())){%>
                                            <option value="<%= cursos.get(i).getIdCurso()%>"><%= cursos.get(i).getNome()%></option>
                                        <%}%>
                                    <%}%>
                            </select> </p>
                        </div>
                    </td>
                    <tr>
                        <td>
                            <p> Nome:<br/> <input type="text" value="<%=usuario.getNome()%>" name="nome"> 
                        </td>
                        <td>
                            <div>
                                <p> Senha:<br/> <input type="password" value="<%=usuario.getSenha()%>" name="senha">
                            </div>
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
