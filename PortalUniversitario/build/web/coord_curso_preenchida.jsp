<%-- 
    Document   : coord_curso
    Created on : 28/05/2017, 15:02:09
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Universitário | Curso</title>
        <link href="css/pag_coordenador.css" rel="stylesheet" type="text/css">
        <link href="css/curso.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file ="menu.jsp"%>
    <div>
    <form method="post" action="CursoController">
        <% Model.Curso curso = (Model.Curso)request.getAttribute("c");%>
        <% Model.Disciplina disciplina = (Model.Disciplina)request.getAttribute("d");%>
        <table align="center" border="0" cellspacing="10" cellpadding="3" class="tabelao" width="700">
            <th colspan="7">
            	<h1>Gerenciar Curso</h1>
                <div class="separador"></div>
            </th>
            <tr>
            	<td colspan="3"> <p>Código:<br/> <input type="text" name="codigo" value ="<%=curso.getCodigo()%>" class="in_menores">
                 <input type="submit" name="opcao" value="Buscar" id="btn_buscar" style="margin-left: 20px;"> </p></td> 	
            </tr>
            <tr>
                <td colspan="8"> <p>Nome:<br/> <input type="text" name="nome" value="<%=curso.getNome()%>" style="width:100%;"></p> </td>
            </tr>
            <tr>
            	<td colspan="4">
                    <p>Departamento:<br/>
                        <select name="departamento" class="cb_departamento">
                        <option value="0"><%=curso.getDepartamento()%></option>
                        </select>
                    </p>
            	</td>
            </tr>
                <td colspan="2">
                    <p>Qtd Min Sems:<br/> <input type="number" name="qtdMinSemestres" value="<%=curso.getMinSemestre()%>" class="in_menores"></p>
            	</td>
                <td colspan="2">
                    <p>Qtd Max Sems:<br/> <input type="number" name="qtdMaxSemestres" value="<%=curso.getMaxSemestre()%>" class="in_menores"></p>
            	</td>           
            	<td>
                    <p>Carga Horária:<br/> <input type="text" name="cargaHoraria" value="<%=curso.getCargaHoraria()%>" class="in_menores"></p></td>
                <td>
                    <p>Creditação:<br/> <input type="text" name="credito" value="<%=curso.getCreditacao()%> "class="in_menores"></p>
                
                </td>
            </tr>
            <tr>
            	<td colspan="7" style="text-align:center">
                    <p>Turno:<br/>                        
                        <input type="radio" name="turno" value="1" id="turnoM" <% if(curso.getTurno() == 1) out.print("checked"); %> >
                        <label for="turnoM">Matutino</label>
                        <input type="radio" name="turno" value="2" id="turnoV" <% if(curso.getTurno() == 2) out.print("checked"); %> >
                        <label for="turnoV">Vespertino</label>
                        <input type="radio" name="turno" value="3" id="turnoN" <% if(curso.getTurno() == 3) out.print("checked"); %> >
                        <label for="turnoN">Noturno</label> </p>
                    </p>
                </td>
            </tr>
            
            <tr>
                <td colspan="7" align="center">
                    <table border="1">
                        <tr class="subtabela_disciplina">
                            <td><b>Nome</b></td>
                            <td><b>Carga Horária</b></td>
                            <td><b>Creditação</b></td>
                            <td><b>Semestre</b></td>
                            <td><b>Código</b></td>
                            <td><b>Tipo</b></td>
                        </tr>
                    <%for(Model.Disciplina disc : disciplina.getDisciplinas()){%>
                        <tr class="subtabela_disciplina">
                            <td><%=disc.getNome()%></td>
                            <td><%=disc.getCargaHoraria()%></td>
                            <td><%=disc.getCreditacao()%></td>
                            <td><%=disc.getSemestre()%></td>
                            <td><%=disc.getCodigo()%></td>
                            <td><%=disc.getTipo()%></td>
                        </tr>    
                    <%}%>
                 </table>
                </td>
            </tr>
            
            <tr></tr>
            <tr align="center">
            <td height="56" colspan="7">
              <input type="button" value="Novo" id="btn_novo" class="botao" onClick="checkFields()">
              <input type="button" value="Alterar" id="btn_alterar" class="botao">
                      <input type="reset" value="Limpar" id="btn_limpar" class="botao">
            </td>
            </tr>
        </table>
    </form>
    </div>
    </body>
</html>
