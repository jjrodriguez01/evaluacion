<%-- 
    Document   : inicio
    Created on : 16/03/2015, 12:03:15 AM
    Author     : jeisson
--%>

<%@page import="persistencia.UsuariosDAO"%>
<%@page import="modelo.UsuariosDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    if (request.getSession()!=null) {
                    UsuariosDTO udto = new UsuariosDTO();
                    UsuariosDAO udao = new UsuariosDAO();
                    HttpSession miSession=request.getSession(false);
                    udto = (UsuariosDTO)miSession.getAttribute("usuario");

                    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=udto.getNombreCompleto()%></title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
<%  }   %>