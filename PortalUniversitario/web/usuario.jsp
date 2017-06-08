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
        <script>
            $(document).ready(function() {
                $("#tipo").on('change', function(){
                    if ($("#tipo").val() !== "2" && $("#tipo").val() !== "3")
                        $("#cb_curso").attr("disabled", false);
                    else
                        $("#cb_curso").attr("disabled", true);
                });
            });
        </script>
    </head>
    <body>
        <form method="post" action="UsuarioController" name="usuarioForm">
            <%Model.Resultados resultado = (Model.Resultados)request.getAttribute("results");
            resultado.pesquisarTodosCampus();
            resultado.pesquisarTodosCursos();
            resultado.pesquisarTodosDepartamentos();
            ArrayList<Model.Campus> campi = new ArrayList();
            ArrayList<Model.Curso> cursos = new ArrayList();
            ArrayList<Model.Departamento> depts = new ArrayList();
            campi = resultado.getCampus();
            cursos = resultado.getCursos();
            depts = resultado.getDepartamentos();
            %>
            <table id="tab_dados_aluno"  width="750" border="1"  align="center">
                <tr>
                    <td colspan="2"> <p> Matrícula:<br/> <input type="text" name="matricula" > <input type="submit" name="opcao" value="Buscar" style="margin-left:30px"> </p> </td>
                    <td>                                   
                        <p>Tipo: <select name="tipo" id="tipo" style="width:120px;">
                            <option> </option>
                            <option value = "2">Coordenador(a) Acadêmico</option>
                            <option value = "3">Secretário(a) Acadêmico</option>
                            <option value = "4">Coordenador(a) Curso</option>
                            <option value = "5">Secretário(a) Curso</option>
                            <option value = "7">Aluno(a)</option>
                        </select></p> 
                    </td>
                </tr>
                <tr>
                    <td>
                            <div>
                                <p> Campus:<br/> <select name="campus" style="width:120px;">
                                <option> </option>
                                <%for(int i=0;i<campi.size();i++){ %>
                                <option value="<%= campi.get(i).getId()%>"><%= campi.get(i).getNome()%></option>
                                <%}%>
                                </select> </p>
                        </div>  
                    </td>
                    <td>
                            
                        <div>
                            <p> Departamento: <br/> <select name="departamento" style="width:120px;">
                            <option> </option>
                            <%for(int i=0;i<depts.size();i++){ %>
                            <option value="<%= depts.get(i).getId()%>"><%= depts.get(i).getNome()%></option>
                            <%}%>
                            </select> </p>
                        </div>  
                    </td> 
                    <td>
                         <div>
                             <p> Curso:<br/> <select name="curso" id="cb_curso" style="width:120px;" disabled="disabled">
                            <option> </option>
                            <%for(int i=0;i<cursos.size();i++){ %>
                            <option value="<%= cursos.get(i).getIdCurso()%>"><%= cursos.get(i).getNome()%></option>
                            <%}%>
                            </select> </p>
                        </div>   
                    </td>
                    <tr>
                        <td>
                            <p> Nome:<br/> <input type="text" name="nome"> 
                        </td>
                        <td>
                            <div>
                                <p> Senha:<br/> <input type="password" name="senha">
                            </div>
                        </td>                                         
                    </tr>
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
