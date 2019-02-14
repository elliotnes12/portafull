<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reestablecer contraseña</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap-responsive.css"/>"/>
		<script src="<c:url value="/static/resources/js/jquery.js"/>"></script>
		<script src="<c:url value="/static/resources/js/bootstrap.js"/>"></script>
		<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }
	 .error {
	 	color: red;
	 }
      .form-signin {
        max-width: 500px;
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
			$(document).ready(function() {

				$('#form1').submit(function() { 

					var pass  = $('#password').val();
					var pass1 = $('#password1').val();

					if (pass.length < 8) {
						alert("Debe contener al menos 8 caracteres.");
						return false;						
					}

					if (!pass.match(/([A-Z])+/g)) {
						alert("Debe contener una mayuscula");
						return false;						
					}

					if (!pass.match(/([0-9])+/g)) {
						alert("Debe contener al menos un número.");
						return false;						
					}

					if (!pass.match(/([*$#@])+/g)) {
						alert("Debe contener un caracter especial como: * $ # ó @");
						return false;						
					}

					if (pass != pass1) {
						alert("Las contraseñas deben ser iguales.");
						return false;						
					}
					
					 var id =  $('#id').val();
					 var pass = $('#password').val();
					 var bandera = false;
					 var mensaje = '';
					 $.ajax({
					      url : '/CFDI33/rest/usuario/' + id + '/' + pass, 
					      async : false
					     }).done(function ( data ) {
					  if (data == 'passwordDuplicado') {
						  alert('No puede ingresar ese password');
						  bandera = false;
					   } else {
					    mensaje = data;
					    bandera = true;
					  }
					 })
					 if(mensaje=='passwordCorrecto'){
						 alert('Cambio de password exitoso.');
					 }
					 if(mensaje=='noExiste'){
						 alert('El nombre de usuario que ingreso no existe.');
					 }
					 return bandera;
					});
				/*
				$.validator.addMethod(
						   "norfc",
						   function(value, element, regexp) {
						       var re = new RegExp(regexp);
						       return this.optional(element) || re.test(value);
						   },
						   "La contraseña no debe de contener el rfc del cliente."
						);
				$.validator.addMethod(
						   "unaMayus",
						   function(value, element, regexp) {
						       var re = new RegExp(regexp);
						       return this.optional(element) || re.test(value);
						   },
						   "Debe contener al menos una letra Mayúscula."
						);
				$.validator.addMethod(
						   "unEsp",
						   function(value, element, regexp) {
						       var re = new RegExp(regexp);
						       return this.optional(element) || re.test(value);
						   },
						   "Debe contener al menos un caracter Especial."
						);
		
				$('#form1').validate({
					rules: {
						password: {
							required : true,
							// norfc : "^((?!"+ document.getElementById('rfc').value + ")[0-9a-zA-ZñÑ#$*@_])+$",
							unaMayus : "([A-Z])+",
							unEsp : "([#$*@_])+",
							minlength : 8
						},
						password1: {
							required: true,
							equalTo: "#password"
						}
					}
				});
		*/
			});
		</script>
	</head>
<body>
   <div class="container">
       <form name="form1" id="form1" action="/CFDI33/login/passwordEditado" class="form-signin" method='POST'>
       <input type="hidden" name="id" id="id" value="${usuario.id}">
       <input type="hidden" name="rfc" id="rfc" value="${rfc}">
       
     	<p>
     		Su contraseña ha sido reiniciada, por favor, ingrese una nueva.<br>
     		<sub>Utilice el tabulador para cambiar entre campos</sub>
     	</p> 
     	<p>La contraseña, debe tener al menos una mayúscula, un número y algún caracter especial ( $, #, @, * )</p>
        <br>
		<label id="labelPassword" name="labelPassword">Nueva Contraseña:</label>
		<input type="password" id="password" name="password" value="${usuario.password}" class="input-xlarger" />
		
		<label id="labelPass2" name="labelPass2" >Repetir nueva contraseña:</label>
		<input type="password" id="password1" name="password1" value="${usuario.password}" class="input-xlarger" />
        
        <div>
        <input class="btn btn-large btn-primary" name="submit" type="submit" value="Cambiar" />
        </div>
      </form>
    </div>

</body>
</html>