<%-- 
    Document   : ValidarLogin
    Created on : 30/05/2017, 17:01:29
    Author     : Marcus Filipe
--%>

<%@ page import ="java.sql.*" %>
<%
    try{
        String matricula = request.getParameter("matricula");   
        String senha = request.getParameter("senha");
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost", "root", "123456");    
        PreparedStatement pst = conn.prepareStatement("Select matricula,senha from sonaes.usuarios where matricula=? and senha=?");
        pst.setString(1, matricula);
        pst.setString(2, senha);
        ResultSet rs = pst.executeQuery();                        
        if(rs.next()){ 
            
            PreparedStatement prst = conn.prepareStatement("Select tipUser,nome from sonaes.usuarios where matricula=?");
            prst.setString(1, matricula);
            ResultSet res = prst.executeQuery();
            
            while (res.next()){        
                session.setAttribute("tipoUser", res.getInt("tipUser"));
                session.setAttribute("nome", res.getString("nome"));
            }   
            
            response.sendRedirect("menu.jsp");        
        }else{
           response.sendRedirect("index.jsp");
        }
   }
   catch(SQLException e){
       response.sendRedirect("erro.jsp");
       System.out.println(e.getMessage());

   }      
%>
