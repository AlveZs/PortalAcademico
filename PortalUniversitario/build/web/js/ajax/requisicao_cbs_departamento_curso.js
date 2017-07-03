function ajaxLocao(url_servlet) {
  $.ajax({
    type: "POST",
    url: url_servlet, //endereço do servlet
    success: function(resultado) { //resultado conterá tudo que vier na função "out.println()" da servlet

      $("select[name=curso] option").remove(); //remove qualquer lixo que esteja no combobox

      var divideString = resultado.split(":"); //separa cada curso com seu departamento em armazena em um array

      for (var i = 0; i < divideString.length; i++) {
        var curso = divideString[i].split("-")[0]; //separa o curso do array e armazena em "curso"
        var departamento = divideString[i].split("-")[1]; //separa o departamento do array e armazena em "departamento"

        //coloca no combobox os cursos de cada departamento separadamente
        if ($("select[name=departamento]").val() == departamento)
          $("select[name=curso]").append("<option value='"+ curso +"'>"+ curso +"</option>");
      }
    }
  });
}

//Inicialização do jQuery na página
$(document).ready(function() {
  $("select[name=departamento]").on("change", function() {
    ajaxLocao("Relatorio_OfertaDisciplinaController");
  })
});
