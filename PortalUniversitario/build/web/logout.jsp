<%-- 
    Document   : logout
    Created on : 31/05/2017, 21:15:53
    Author     : Marcus Filipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  session.invalidate();
response.sendRedirect("index.jsp");
%>

