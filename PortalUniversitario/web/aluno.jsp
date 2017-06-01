<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title> Portal Universitï¿½rio | Aluno </title>
  </head>
  <body>
    <%@ include file="menu.jsp" %>
    
    <table class='tabelao' align='center'>
        <thead> <th>ALUNO</th> </thead>
    <tr><td>
    <form class="" action="index.html" method="post">
        <table class="tab_menu_resultado" align='center' width='800'>
        <thead>
            <td colspan='4' class="td_buscar"> Buscar: <input type="text" name="txt_buscar"> <input type="button" name="bt_ok" value="Ok"></td>
            <td><input type="button" name="bt_+" value="+" onclick="alert('criar aluno')"></td>
        </thead>
      </table>
    </td></tr>
    <tr><td>
      <table border="1" align="center" class='tab_resultado' width='800'>
        <thead>
          <th>Matrícula</th>
          <th>Nome</th>
          <th>Curso</th>
          <th>Semestre</th>
        </thead>
        <tbody>
          <tr class="modal" href="#janela1">
            <td>071519553</td>
            <td>João Pedro de Azevedo Hegouet</td>
            <td>Bacharelado em Sistemas de Informação</td>
            <td>4</td>
            <td>
                <input type="button" name="bt_editar" id="bt_editar" value="E" onclick="window.location='AlunoController?opcao=preencher'">
                <input type="button" name="bt_excluir" value="X" onclick="alert('apaga campo')">
            </td>
          </tr>
          <tr>
            <td>251054</td>
            <td>hua hsphd as</td>
            <td>dsada sads da</td>
            <td>5</td>
          </tr>
        </tbody>
      </table>
    </form>
    </tr></td>
    </table>

    <%-- Modal --%>
    <div class="janela" id="janela1">
        <a href="#" class="fechar">X Fechar</a>
        <table>
            <thead>
                <th>Info</th>
                <th>Disciplinas</th>
            </thead>
            <tbody>
                <tr>
                    <td>Nome</td>
                    <td>Vesh</td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- mascara para cobrir o site -->
    <div id="mascara"></div>
    <%-- FIM DO TESTE DO MODAL --%>
  </body>
</html>
