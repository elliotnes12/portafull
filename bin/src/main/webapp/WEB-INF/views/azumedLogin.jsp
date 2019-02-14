<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta name="title" content="Sistema de autofacturaci&oacute;n XPD">
        <meta name="description" content="Sistema de Facturación Electrónica XPD">
        <meta name="keywords" content="Facturación Electrónica, Timbrado, Expide Tu Factura, Folios, Timbrado Masivo, Facturación en linea, paquetes de facturación, planes de facturacion, Distribucuion de Facturación Electrónica, XPD">
        <link rel="shortcut icon" href="<c:url value="/static/resources/img/favicon.ico"/>" type="image/x-icon">
        <link rel="icon" href="<c:url value="/static/resources/img/favicon.ico"/>" type="image/x-icon">
        <link rel="stylesheet" href="<c:url value="/static/resources/css/foundation-full.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/static/resources/css/estilos.css"/>">
        <link rel="stylesheet" href="<c:url value="/static/resources/css/login.css"/>">
        <title>Sistema de facturaci&oacute;n Electr&oacute;nica</title>
        <!--[if lt IE 9]>
            <script src="<c:url value="/static/resources/js/html5shiv.min.js"/>"></script>
            <script src="<c:url value="/static/resources/js/html5shiv-printshiv.min.js"/>"></script>
        <![endif]-->
    </head>
    <body>
        <div class="header">
            <div class="small-12 medium-6 large-6 columns">
            	<div style="margin:auto;width: 50%">
                    <a href="https://www.expidetufactura.com.mx/">
                        <img src="<c:url value="/static/resources/img/logo.png"/>" style="display: block;margin: auto;">
                    </a>
                    </div>
                </div>
                <div class="small-12 medium-6 large-6 columns" style="vertical-align: center">
                	<div style="margin:auto;width: 50%">
                    <a href="https://www.expidetufactura.com.mx/">
                        <img src="<c:url value="/static/resources/img/azumed.png"/>" style="display: block;margin: auto;">
                    </a>
                    </div>
                </div>
                
            
        </div>
        <!--  <div class="header">
            <div class="small-7 medium-5 small-centered medium-centered columns">
                <div style="margin:auto;">
                    <a href="http://www.sat.gob.mx/informacion_fiscal/normatividad/Paginas/RMF_2018_versiones_anticipadas.aspx" target="_blank">
                        <img src="<c:url value="/static/resources/img/Aviso2602a.png"/>" style="display: block;margin: auto;">
                    </a>
                </div>
            </div>
        </div>-->
        <div class="clearfix"></div>
        <style>
            .alert {padding: 8px 35px 8px 14px;margin-bottom: 20px;text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);background-color: #fcf8e3;border: 1px solid #fbeed5;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;font-size: 15px}
            .alert, .alert h4 {color: #c09853;}
            .alert-danger, .alert-error {color: #b94a48;background-color: #f2dede;border-color: #eed3d7;}
        </style>
        <div class="content">
            <div class="row" id="login">
                <div class="small-7 medium-5 small-centered medium-centered columns">
                    <c:if test="${loginError eq 'true'}">
                        <div class="alert alert-error">
                            Tu intento de acceso no es correcto, intenta nuevamente.<br/> Causa :
                            Nombre de usuario o password incorrectos.
                        </div>
                    </c:if>
                    <c:if test="${bloqueado eq 'true'}">
                        <div class="alert alert-error">
                            No puede acceder a su cuenta en este momento.<br/> Causa :
                            Ha excedido el n&uacute;mero de intentos espere 15 minutos.
                        </div>
                    </c:if>
                    <div class="login">
                        <div class="login-header" style="text-align: center;width: 100%">
                            <h3>BIENVENIDO</h3>
                        </div>
                        <form id="login-form" action="<c:url value='/j_spring_security_check'/>" method='POST'>
                            <input type="text" placeholder="Clave del Cliente" name='j_username' id="j_username">
                            <input type="text" placeholder="Usuario" value="admin" id="rfc" name="rfc">
                            <input type="hidden" placeholder="origen" value="azumed" id="origen" name="origen">
                            <input type="password" placeholder="Contrase&ntilde;a" name='j_password' id="j_password">
                            <div style="text-align: right;">
                                <input class="button" type="submit" value="ENTRAR">
                            </div>
                        </form>
                    </div>
                    <div>
                        <span style="display: inline-block;">
                            <img src="<c:url value="/static/resources/img/aviso.png"/>" alt="">
                        </span>
                        <span style="display: inline-block;"><a href="/CFDI33/usuario/reset">¿Olvidaste tu contrase&ntilde;a?</a></span>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <div class="row">
                <div class="small-2 small-centered" style="max-width: 75px">
                    <a href="http://www.sat.gob.mx/informacion_fiscal/factura_electronica/Paginas/pac_cpa.aspx" target="_blank">
                        <img src="<c:url value="/static/resources/img/logosat.svg"/>" alt="">
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="small-12 medium-6 large-6 columns">
                    <a href="http://goo.gl/forms/7MBC366dXz" target="_blank">
                        <img src="<c:url value="/static/resources/img/encuesta.png"/>">
                    </a>
                </div>
                <div class="small-12 medium-6 large-6 columns" style="vertical-align: center">
                    <img src="<c:url value="/static/resources/img/telefonos.png"/>" style="margin-top: 25px;">
                </div>
            </div>
            <div align="center" style="margin: auto;max-width: 600px">
                <img src="<c:url value="/static/resources/img/planes.svg"/>" alt="">
            </div>
        </div>
        
        <!-- Global site tag (gtag.js) - Google Analytics -->

		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-122238418-1"></script>
		
		<script>
		
		  window.dataLayer = window.dataLayer || [];
		
		  function gtag(){dataLayer.push(arguments);}
		
		  gtag('js', new Date());
				
		  gtag('config', 'UA-122238418-1');
		
		</script>

        <script type="text/javascript" src="<c:url value="/static/resources/js/jquery.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/static/resources/js/foundation.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/static/resources/js/app.js"/>"></script>
        <script>
            //<![CDATA[
            var txt=" • Sistema de Facturación Electrónica";
            var espera=200;
            var refresco=null;
            function rotulo_title() {
                document.title=txt;
                txt=txt.substring(1,txt.length)+txt.charAt(0);
                refresco=setTimeout("rotulo_title()",espera);
            }
            rotulo_title();
            //]]>
        </script>
        <script type="text/javascript">
			$(document).ready(function() {
            setTimeout(function(){$(".alert").hide(750);},5000);
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

			$('#login-form').submit(function() {
					 var usuario =  $('#j_username').val();
					 var rfc = $('#rfc').val();
					 var origen = $('#origen').val();
					 var bandera = false;
					 var mensaje = '';


					 $('#j_username').val($('#j_username').val().trim()); // + "|" + $('#rfc').val());
					 $('#j_password').val($('#j_password').val().trim());

					 $.ajax({
					     //  url : '/CFDI/rest/usuario/bloqueado/' + usuario +'/' + rfc,
					      url : '/CFDI33/rest/usuario/bloqueado/' + rfc +'/' + usuario + '/' + origen,
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
						 alert('Su cuenta ha sido bloqueda por 15 minutos. Favor de esperar e intentar nuevamente.');
					 }
					 if(mensaje=='noExiste'){
						 alert('El nombre de usuario que ingreso no existe.');
					 }
					 return bandera;
					})
			});
		</script>
    </body>
</html>
