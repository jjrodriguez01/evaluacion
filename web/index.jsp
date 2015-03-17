<%-- 
    Document   : registro
    Created on : 15/03/2015, 08:32:11 PM
    Author     : jeisson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.min.css">
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
        <title>Inicio - Evaluacion</title>
        <style>
            body{
                padding-top: 50px;
            }
        </style>
        <script>
            $(document).ready(function(){
                $("#reg").on("click", function(){
                    $("#primer").removeClass("active");
                    $("#ultimo").addClass("active");
                    $("#login").fadeOut();
                    $("#registro").removeClass();
                });
                $("#ingreso").on("click", function(){
                    $("#ultimo").removeClass("active");
                    $("#primer").addClass("active");
                    $("#registro").addClass("hidden");
                    $("#login").fadeIn();
                });
            });
        </script>
    </head>
    <body>
<main class="container">
    <div class="row">
        <section id="dd" class="col-md-3 col-sm-4 col-xs-4">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" id="primer" class="active"><a id="ingreso">Ingresar</a></li>
                <li role="presentation" id="ultimo" class=""><a id="reg">Registrarse</a></li>
            </ul>
        </section>
        <section class="col-md-9 col-sm-8 col-xs-8">
            <article id="login">
                <div class="container">
                    <form action="Control" role="form" class="form-horizontal">
    <div class="form-group col-md-7 col-sm-6 col-xs-6">
      <label for="usu">Usuario:</label>
      <input type="text" class="form-control" name="usu" placeholder="Ingrese su usuario" maxlength="40">
    </div>
    <div class="form-group col-md-7 col-sm-6 col-xs-6">
      <label for="pass">Contraseña:</label>
      <input type="password" class="form-control" name="pass" placeholder="Ingrese su contraseña" maxlength="40">
    </div>
    <div class="col-md-7 col-sm-6 col-xs-6">                   
        <button type="submit" class="btn btn-default" name="Ingresar" >Ingresar</button>
    </div>
    
  </form>
                </div>
            </article>
            <article id="registro" class="hidden">
                <div class="container">
  <h2>Registro de usuarios</h2>
  <form action="Control" class="form-horizontal" role="form">
    <div class="form-group">
      <label class="control-label col-sm-2" for="id">Id usuario:</label>
      <div class="col-md-7 col-sm-6 col-xs-6">
        <input type="number" class="form-control" name="id" placeholder="Documento">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="nombres">Nombres</label>
      <div class="col-md-7 col-sm-6 col-xs-6">          
          <input type="text" class="form-control" name="nombres" placeholder="Nombre Completo" maxlength="45">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email</label>
      <div class="col-md-7 col-sm-6 col-xs-6">          
          <input type="email" class="form-control" name="email" placeholder="Correo" maxlength="45">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="usu">Usuario</label>
      <div class="col-md-7 col-sm-6 col-xs-6">          
          <input type="text" class="form-control" name="usu" placeholder="Nombre De Usuario" maxlength="45">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pass">Contraseña</label>
      <div class="col-md-7 col-sm-6 col-xs-6">          
          <input type="password" class="form-control" name="pass" placeholder="Contraseña" maxlength="45">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default" name="rusu" value="Registrar">Registrar</button>
      </div>
    </div>
  </form>
  <% if (request.getParameter("registrado")!=null) {
  %> 
  <div class="alert alert-warning alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong><%=request.getParameter("registrado")%></strong>
</div>
  <%
            } 
  %>
</div>
            </article>
            <% if(request.getParameter("desautorizado")!=null){ %>
<div class="alert alert-warning alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong><%=request.getParameter("desautorizado")%></strong>
</div>
<%   }   %>
        </section>
    </div>
</main>
    </body>
</html>
