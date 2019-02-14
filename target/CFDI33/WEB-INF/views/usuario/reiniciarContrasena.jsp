<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>






<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Iniciar sesión</title>
		<link rel="stylesheet" type="text/css" href="/CFDI33/static/resources/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="/CFDI33/static/resources/css/bootstrap-responsive.css"/>
		<script src="/CFDI/static/resources/js/jquery.js"></script>
		<script src="/CFDI/static/resources/js/bootstrap.js"></script>
		<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
		<script type="text/javascript">
		/*
			$(document).ready(function() {
				$('#login').submit(function() { 
					 var usuario =  $('#j_username').val();
					 var rfc = $('#rfc').val();
					 var bandera = false;
					 var mensaje = '';
					 $.ajax({
					      url : '/CFDI/rest/usuario/bloqueado/' + usuario +'/' + rfc, 
					      async : false
					     }).done(function ( data ) {
					  if (data == 'correcto') {
						  bandera = true;
					   } else {
					    mensaje = data;
					    bandera = false;
					  }
					 })
					 if(mensaje=='bloqueado'){
						 alert('Su cuenta ha sido bloqueda. Favor de esperar 15 min.');
					 }
					 if(mensaje=='noExiste'){
						 alert('El nombre de usuario que ingreso no existe.');
					 }
					 return bandera;
					})
			});
			*/
		</script>
	</head>
<body onload='document.login.rfc.focus();'>

   <div class="container">
   
	${mensaje} 
	
      <form id="login" name='login' class="form-signin" action="/CFDI33/usuario/password" method='POST'>
        <h2 class="form-signin-heading">
        	<img src="/CFDI33/static/resources/img/logo.png" /><br><br>
        </h2>
		<label>Clave de cliente:</label>
		<input type="text" class="input-block-level" id="rfc" name="rfc" placeholder="Clave de Cliente">
        <label>Usuario:</label>
        <input type="text" class="input-block-level" name='usuario' id="usuario"/>

        <label>Correo electrónico:</label>
        <input type="text" class="input-block-level" name='email' id="email"/>
      
     	<label>Contraseña:</label>
        <input type="password" class="input-block-level" name='password' id="password"/>
        <input class="btn btn-large btn-primary" name="submit" type="submit" value="Generar Contraseña" />
                
      </form>
    </div>

</body>
</html>