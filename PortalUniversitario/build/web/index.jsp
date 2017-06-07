<%-- 
    Document   : login2
    Created on : 29/05/2017, 17:51:08
    Author     : Marcus Filipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Portal Universitário</title>
<link href="css/indexcss.css" rel="stylesheet" type="text/css" />
<script>
    
    response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("some_token")==null)
      response.sendRedirect("index.jsp");
    
</script>
</head>

<body>
    
    <div id="corpo" align="center">
    <img src="img/Logo_small_branca.png" />
	  
        <div id="formulario">
              <form action="ValidarLogin.jsp" method="post">
                <p> Login: <input type="text" name="matricula" > </p>
                <p> Senha: <input type="password" name="senha" > </p>
                <input id="logar" type="submit" name="Logar" value="Logar">
              </form>
        </div>
    </div>
</body>
</html>
