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
    
     <div>
    <form method="post" action="AlunoController">
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
                        <option value="1">DCET</option>
                        <option value="2">DCV</option>
                        <option value="3">DCH</option>
                    </select>
                    </p> </div>
                    <div style="margin-left:10px"> <p>Curso:<br/> <select name="curso" style="width: 260px;">
                        <option value="0"></option>
                        <option value="1">Sistemas de Informação</option>
                        <option value="2">Engenharia Civil</option>
                    </select>
                    </p></div>
                
                    <div> 
                        <input type="button" value="Buscar" id="btn_buscar" onClick="checkFields()">
            	</div>
                </td>
            </tr>
            <tr>
                <td>
                <table border="1" align="center" width="500" style="margin-bottom:40px;">
                    <tr>
                    <th colspan="6">
                    	<h3> 3º Semestre</h3>
                    </th>
                    </tr>
                    <tr>
                    <th>Disciplina:</th>
                    <th>Código:</th>
                    <th>Professor(a):</th>
                    <th>Demanda:</th>
                    <th>Optativa:</th>
                    </tr>
                    <tr>
                        <td>Inglês Instrumental</td>
                        <td>CPD025</td>
                        <td>Edvan Cardoso</td>
                        <td>26 alunos</td>
                        <td>  </td>  
                    </tr>
                    <tr>
                        <td>Algorítmos</td>
                        <td>CPD020</td>
                        <td>Jorge Farias</td>
                        <td>15 alunos</td> 
                        <td>  </td>             
                    </tr>
                </table>        
                </td>
                </tr>
                
                <tr>
                <td>
                <table border="1" align="center" width="500" style="margin-bottom:40px;">
                    <tr>
                    <th colspan="6">
                        <h3> 5º Semestre</h3>
                    </th>
                    </tr>
                    <tr>
                    <th>Disciplina:</th>
                    <th>Código:</th>
                    <th>Professor(a):</th>
                    <th>Demanda:</th>
                    <th>Optativa:</th>
                    </tr>
                    <tr>
                        <td>Cálculo II</td>
                        <td>MAT169</td>
                        <td>Julian Quezada</td>
                        <td>50 alunos</td>
                        <td>  </td>
                    </tr>
                    <tr>
                        <td>L.P. I</td>
                        <td>CPD028</td>
                        <td>Antonio Atta</td>
                        <td>10 alunos</td>
                        <td>  </td>
                    </tr>
                </table>        
                </td>
            </tr>
            <tr>
                <td>
                    <table border="1" align="center" width="500" style="margin-bottom:40px;">
                    <tr>
                    <th colspan="6">
                        <h3> 7º Semestre</h3>
                    </th>
                    </tr>
                    <tr>
                    <th>Disciplina:</th>
                    <th>Código:</th>
                    <th>Professor(a):</th>
                    <th>Demanda:</th>
                    <th>Optativa:</th>
                    </tr>
                    <tr>
                        <td>Compiladores</td>
                        <td>CPD027</td>
                        <td>Antonio Atta</td>
                        <td>50 alunos</td>
                        <td>  </td>
                    </tr>
                    <tr>
                        <td>Teoria dos Grafos</td>
                        <td>MAT117</td>
                        <td>Julian Quezada</td>
                        <td>8 alunos</td>
                        <td> X </td>
                    </tr>
                </table>        
                </td>
            </tr>
        </table>
    </form>
    </div>
</body>
</html>
