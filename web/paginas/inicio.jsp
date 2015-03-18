<%-- 
    Document   : inicio
    Created on : 16/03/2015, 12:03:15 AM
    Author     : jeisson
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="persistencia.Fachada"%>
<%@page import="persistencia.UsuariosDAO"%>
<%@page import="modelo.UsuariosDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- directiva q indica q si se produce una excepcion la mande a la pagina q las captura --%>
<%@page isThreadSafe="false" import="java.util.*" errorPage="../errorPages/error.jsp" %>
<% 
    if (request.getSession()!=null) {
                    UsuariosDTO udto = new UsuariosDTO();
                    UsuariosDAO udao = new UsuariosDAO();
                    HttpSession miSession=request.getSession(false);
                    udto = (UsuariosDTO)miSession.getAttribute("usuario");
                    Fachada facade = new Fachada();
                    
                    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap/css/bootstrap.min.css">
        <script type="text/javascript"  src="../js/jquery-1.9.1.js"></script>
        <script type="text/javascript"  src="../css/bootstrap/js/bootstrap.min.js"></script>
        <title><%=udto.getNombreCompleto()%></title>
        <style>
            body{
                margin: 0 10%;
                font-family: tahoma, lucida, verdana;
            }
        </style>
    </head>
    <body>
            <header class="row">
                <div class="col-lg-12">
                    <hgroup>
                        <h1>Aplicacion Gestion De Libros</h1>
                        <h2>Bienvenido <%=udto.getNombreCompleto()%></h2>
                    </hgroup>
                </div>
            </header>
        <main class="container">
            <section>
            <article>
                <div class="row">
                    <div class="col-md-12">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="index.jsp">Prestamos</a></li>
                        <li role="presentation"><a href="personas.jsp">Multas</a></li>
                        <li role="presentation"><a href="reportes.jsp">Reportes</a></li>
                    </ul>
                </div>
                </div>
            </article>
            </section>
            <section>
                <div class="row">
                    <div class="col-md-9 col-sm-9 col-xs-6">
                        <h3>Registrar Prestamo</h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-9 col-sm-9 col-xs-6">
                        
                        <table class="table table-striped table-hover">
                            <tr>
                                <th>Usuario</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Prestar Libro</th>
                            </tr>
                            <% 
                            ArrayList<UsuariosDTO> usu = new ArrayList();
                            usu = (ArrayList) facade.listarUsuarios();
                            
                            for(UsuariosDTO u: usu){
                            %>
                            <tr>
                                <td><%=u.getUserName()%></td>
                                <td><%=u.getNombreCompleto()%></td>
                                <td><%=u.getEmail()%></td>
                                <td><a href="?id=<%=u.getIdUser()%>">Prestar Libro</a></td>
                            </tr>
                            <%   }  %>
                        </table>
                            <%
if (request.getParameter("id")!=null) {
%>
<button id="btnpresta" class="btn btn-group-lg btn-primary" data-toggle="modal" data-target="#prestamos">Click para realizar el prestamo</button>
<script>
    (document).ready(function(){
        $("#btnpresta").trigger("click");
    });
</script>

<div class="modal fade" id="prestamos" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
 <%  boolean multado = facade.estaMultado(Long.parseLong(request.getParameter("id"))); 
    if (multado) {
 %>
 <h1>Este usuario esta multado, no se le puede prestar nada<%=multado%></h1>
 <%
        }else{
int cantidad = facade.tieneCupo(Long.parseLong(request.getParameter("id")));
if (cantidad < 2) {
%>
<h1>Registrar Prestamo<%=multado%>  <%=cantidad%></h1>
            </div>
<div class="modal-body">
    <form action="Control">
        
    </form>
</div>
        </div>
<%
   }else{
%>
<h1>El usuario tiene 2 prestamos  <%=multado%>  <%=cantidad%></h1>
<%
}
%>

<%
    }
 %>    
    </div>
</div>
    <%
}
%>
                    </div>
            </section>
        </main>
    </body>
</html>
<%  }   %>