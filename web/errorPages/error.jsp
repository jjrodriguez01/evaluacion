<%-- 
    Document   : error
    Created on : 17/03/2015, 10:40:18 PM
    Author     : jeisson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- directiva q dice q esta es una pagina de error --%>
<%@ page isErrorPage="true" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lo sentimos pero algo salio mal</h1>
        <%=exception.toString()%>
        <br/>
        <% if (exception.getMessage()!=null) {
%>   

        <h6>Mas informacion:</h6>
        <br/>
        <%=exception.getMessage() %>
<%  }   %>
    </body>
</html>
