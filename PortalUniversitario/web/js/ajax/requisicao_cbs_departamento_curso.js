function ajaxCampusDep(url_servlet) {
  $.ajax({
    type: "POST",
    url: url_servlet, //endereço do servlet
    success: function(resultado) { //resultado conterá tudo que vier na função "out.println()" da servlet

      $("select[name=departamento] option").remove(); //remove qualquer lixo que esteja no combobox de departamento
      $("select[name=curso] option").remove(); //remove qualquer lixo que esteja no combobox de curso

      var divideString = resultado.split("=");

      //var divideCursoDep = resultado.split(":"); //separa cada curso com seu departamento e armazena em um array
      //var divideDepCampus = resultado.split("?"); //separa cada departamento com seu campus e armazena em um array
      var arrayDepartamentos = []; //array criado para evitar repetição de departamentos para o campus selecionado

      for (var i = 0; i < divideString.length-1; i++) {
        //var campus = divideDepCampus[i].split(":")[1]; //captura o campus da string
        var curso = divideString[i].split("-");
        var departamento = curso[1].split(":");
        var campus = departamento[1].split("?");
        var cursoID = campus[1].split("/");
        var departamentoID = cursoID[1].split("*");
        var campusID = departamentoID[1];

        var dep = new Object();
        dep.nome = departamento[0];
        dep.ID = departamentoID[0];

        //var departamento = divideCursoDep[i].split("-")[1]; //separa o departamento do array e armazena em "departamento"
        for (var j = 0; j <= arrayDepartamentos.length; j++) {
          if (j == arrayDepartamentos.length) {
            if (campusID[0] == $("select[name=campus]").val()) {
              //Se chegar na última posição e não tiver encontrado o nome do dep, este será armazenado
              arrayDepartamentos.push(dep);
              break; //sai do FOR para não entrar em loop infinito
            }
            break;
          }
          if (dep.nome == arrayDepartamentos[j].nome) { //se o nome do departamento já existe no array, ele não armazena
            break; //sai do FOR com indice J
          }
        }
      }

      //Preenche os campos de departamento no seu combobox
      for (var i = 0; i < arrayDepartamentos.length; i++) {
        $("select[name=departamento]").append("<option value='"+ arrayDepartamentos[i].ID +"'>"+ arrayDepartamentos[i].nome +"</option>");
      }

      // chama a função para preencher os cambos do combobox de curso
      ajaxDepCurso("Relatorio_OfertaDisciplinaController");
    }
  });
}

function ajaxDepCurso(url_servlet) {
  $.ajax({
    type: "POST",
    url: url_servlet, //endereço do servlet
    success: function(resultado) { //resultado conterá tudo que vier na função "out.println()" da servlet

      $("select[name=curso] option").remove(); //remove qualquer lixo que esteja no combobox

      var divideString = resultado.split("=");
      //var divideCursoDep = resultado.split(":"); //separa cada curso com seu departamento em armazena em um array
      //var divideDepCampus = resultado.split("?"); //separa cada departamento com seu campus e armazena em um array

      for (var i = 0; i < divideString.length-1; i++) {
        /*var curso = divideDepCampus[i].split("-")[0]; //separa o curso do array e armazena em "curso"
        var departamento = divideCursoDep[i].split("-")[1]; //separa o departamento do array e armazena em "departamento"
        var campus = divideDepCampus[i].split(":")[1];*/

        var curso = divideString[i].split("-");
        var departamento = curso[1].split(":");
        var campus = departamento[1].split("?");
        var cursoID = campus[1].split("/");
        var departamentoID = cursoID[1].split("*");
        var campusID = departamentoID[1];

        var c = new Object();
        c.nome = curso[0];
        c.ID = cursoID[0];
        
        //coloca no combobox os cursos de cada departamento separadamente
        if ($("select[name=departamento]").val() == departamentoID[0]) {
          $("select[name=curso]").append("<option value='"+ c.ID +"'>"+ c.nome +"</option>");
        }
      }
    }
  });
}

//Inicialização do jQuery na página
$(document).ready(function() {
  //Torna os combobox dependentes
  $("select[name=campus]").on("change", function() {
    ajaxCampusDep("Relatorio_OfertaDisciplinaController");
    //Desabilita o combobox departamento e curso, caso o CB de Campus não tenha um item selecionado
    $("select[name=departamento]").attr('disabled', false);
    $("select[name=curso]").attr('disabled', false);
  });
  $("select[name=departamento]").on("change", function() {
    ajaxDepCurso("Relatorio_OfertaDisciplinaController");
  })
});
