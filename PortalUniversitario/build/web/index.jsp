<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Portal Universitário</title>
<link href="css/indexcss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function redireciona() {
		if (document.forms.item(0).elements.item(0).value == "admin")
			location.href="pag_coordenador.jsp";
		else if (document.forms.item(0).elements.item(0).value == "aluno")
			location.href="aluno_consulta.html";
		else if (document.forms.item(0).elements.item(0).value == "")
			alert("O campo 'Login' está vazio!");
		else
			alert("Login inválido!");
	}
</script>
</head>

<body>
    <div id="corpo" align="center">
    <img src="img/Logo_small_branca.png" />
	  
        <div id="formulario">
              <form>
                <p> Login: <input type="text" name="login" > </p>
                <p> Senha: <input type="password" name="senha" > </p>
                <input id="logar" type="button" name="Logar" value="Logar" onClick="redireciona()">
              </form>
        </div>
    </div>
</body>
</html>
