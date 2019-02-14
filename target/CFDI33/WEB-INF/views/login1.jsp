<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Iniciar sesión</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap-responsive.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/login.css"/>"/>
		<script src="<c:url value="/static/resources/js/jquery.js"/>"></script>
		<script src="<c:url value="/static/resources/js/bootstrap.js"/>"></script>

		<script type="text/javascript">
			$(document).ready(function() {
/*
				if ($('#j_username').val().indexOf('|') > 0) {
					var data = $('#j_username').val();
					data = data.substr(0, data.indexOf('|'));
					$('#j_username').val(data);
				}
*/				
			$('#j_username').change(function() {
				$('#j_username').val($('#j_username').val().toUpperCase());
			});
			
			$('#login').submit(function() { 
					 var usuario =  $('#j_username').val();
					 var rfc = $('#rfc').val();
					 var bandera = false;
					 var mensaje = '';
					 

					 $('#j_username').val($('#j_username').val().trim()); // + "|" + $('#rfc').val());
					 $('#j_password').val($('#j_password').val().trim());
					 
					 $.ajax({
					     //  url : '/CFDI/rest/usuario/bloqueado/' + usuario +'/' + rfc, 
					      url : '/CFDI/rest/usuario/bloqueado/' + rfc +'/' + usuario,
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
		</script>
	</head>
<body onload='document.login.rfc.focus();'>
<!-- 
	<div style="background:white;"><h2 style="text-align:center; margin: 5px;">
	Si aún no  realizas la migración de tu sistema, solicitala 
	<a href="mailto:soporte@xpd.mx?Subject=Solicitud Migración&body=Solicito la migración de mi cuenta con RFC: " target="_top">
	aquí.</a>	
	</h2></div>
 -->
 
 
   <div class="container">
   <!-- 
   	<br>
	<center>
	<a target="_blank" href="http://portal.expidetufactura.com.mx/banner">
		<img src="http://portal.expidetufactura.com.mx/banner/banner.png" >
	</a>
	</center>
   -->
  <!--  
	<div class="row center" style="margin-top: 8px; text-align: center; background: white;">
		<br>
		<center>AVISO IMPORTANTE</center>
		Por el momento sólo se podrá ingresar con el usuario <b>admin</b>
		<br>
		<br>
		<br>
	</div> 
 -->  
 
	<c:if test="${loginError eq 'true'}">
		<div class="alert alert-error">
			Tu intento de acceso no es correcto, intenta nuevamente.<br/> Causa :
			Nombre de usuario o password incorrectos.
		</div>
	</c:if>
	
	<c:if test="${bloqueado eq 'true'}">
		<div class="alert alert-error">
			No puede acceder a su cuenta en este momento.<br/> Causa :
			Ha excedido el numero de intentos espere 15 minutos.
		</div>
	</c:if>

	<h2 class="form-signin-heading">
	     	<img src="<c:url value="/static/resources/img//logo_xpd_login.png"/>" /><br><br>
	</h2>
      <form id="login" name='login' class="form-signin" action="<c:url value='/j_spring_security_check'/>" method='POST'>
       
		<table>
			<tr>
				<td>Clave del Cliente:</td>
				<td>Usuario:</td>
				<td>Contraseña:</td>
			</tr>
			<tr>
				
				<td><input type="text" class="input-block-level" autocomplete="on" name='j_username' id="j_username"/></td>
				<td><input type="text" class="input-block-level" value="admin" id="rfc" name="rfc"></td>
				<td><input type="password" class="input-block-level" name='j_password' id="j_password"/></td>
			</tr>
			<tr><td><input name="submit" type="submit" value="Entrar" /></td></tr>
			<tr>
		  <td colspan="3">
		  <div class="row center" style="margin-top: 8px; text-align: center;">
        	<a href="/CFDI/usuario/reset">¿Olvidaste tu contraseña?</a>
        </div>
		  </td>
		</tr>
		</table>
		

      </form>
      
      <br><br>
      <img alt="" src="<c:url value="/static/resources/img/telsop.png"/>">
    </div>

</body>
</html>