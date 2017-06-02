<%-- 
    Document   : logout
    Created on : 31/05/2017, 21:15:53
    Author     : Marcus Filipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    
  //session.setAttribute("tipoUser", null);
  session.invalidate();
  response.sendRedirect("index.jsp");
%>
