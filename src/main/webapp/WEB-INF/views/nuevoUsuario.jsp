<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="/CFDI33" scope="request" /> 
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

        <link rel="stylesheet" href="<c:url value="/static/resources/css/foundation.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/static/resources/css/estilos.css"/>">
        <link rel="stylesheet" href="<c:url value="/static/resources/css/layout.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap-responsive.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap-dataTable.css"/>"/>
        <title>Sistema de facturaci&oacute;n Electr&oacute;nica</title>
        <!--[if lt IE 9]>
            <script src="js/html5shiv.min.js"></script>
            <script src="js/html5shiv-printshiv.min.js"></script>
        <![endif]-->
		<style>
			#header {
				height: 90px;
				margin: 0 auto;
				width: 50%;
			}

			#logo {
				background: url('<c:url value="/static/resources/img/" />//logo.svg') no-repeat;
				cursor: pointer;
				height: 90px;
				margin:0 auto;
				width: 300px;
			}
			.container{
				background-color: #f5f5f5;
				height: 100%;
			}
			.form{
				border: 1px solid #ffffff;
				border-radius: 10px;
				margin:8px;
			}
			.form h1{
				font-size: 28px;
			}
			#headerRight {
				display: block;
				max-width: 700px !important;
				right: 20px;
				left: auto;
			}
			.right {
				float: right !important;
			}

			#salirHeader {
				float: right;
				margin-right: 10px;
				width: 100px;
			}

			#menuHeader {
				margin-bottom: 0px;
				width: 280px;
				margin: 0 auto;
				height: 18px;
				overflow: hidden;
			}
			#menuHeader li{
			 list-style: none;
			 float: left;
			 margin-left: 10px;
			}
					
					#menu, 
			#menu ul{
			 z-index: 2000;
			}
			#myModal2 {
				margin-top: 200px;
			}	
						.txtCenter { text-align: center !important; }
						
						#profilePopover {
				display: block;
				max-width: 450px;
			 right: 5px;
				left: auto;
			 height: auto;
			}

			#logo {
				height: 100px;
			}

			.divRight {
				float: right !important;
			}

			#profilePopover h3 {
				text-align: center;
			}

			#profilePopover .popover-content li {
				list-style: none;
			 float: left;
			 margin-left:10px;
			 width: auto;
			 height: 30px;;
			}
			.form input{
				height: 30px;
			}
		</style>
	</head>
	
	<body>
		<div class="container">
			<div id="header">
				<div id="logo"><a title="Página principal" href="/"></a></div>
				<div class="popover bottom" id="profilePopover">
					<!-- <div class="arrow"></div>
					<h3 class="popover-title">Registrar Usuario</h3>
					<div class="popover-content">
						<ul id="menuHeader">
						</ul>
					</div> -->
				</div>
			</div>
			<div class="form">
				<h1>Registrar Usuario Gratuito</h1>
				<c:choose>
					<c:when test="${registrado == true}">
						<h3 style="color: green;">${mensaje}</h3>
					</c:when>
					<c:otherwise>
						<h3 style="color: red;">${mensaje}</h3>			
					</c:otherwise>
				</c:choose>
				<form:form id="registroForm" class="form-horizontal"
					action="${contextPath}/registrarUsuario/registrar"
					commandName="registroForm">
					<div style="float: left">
						<span class="lead">Informaci&oacute;n Personal</span>
						<form:label path="rfc">R.F.C.:</form:label>
						<form:input path="rfc" />
						<form:label path="razonSocial">Raz&oacute;n Social:</form:label>
						<form:input path="razonSocial" />
						<form:label path="email">Correo electr&oacute;nico:</form:label>
						<form:input path="email" />
					</div>
					<div style="float: left; margin-left: 100px">
						<span class="lead">Direcci&oacute;n:</span>
						<form:label path="estado">Estado :</form:label>
						<form:select path="estado">
							<option value="">Seleccionar estado</option>
                        	<c:forEach items="${estados}" var="estado" >
								<option value="${estado.id}" ${datosEmisor.estado eq estado.id ? 'selected':''}>${estado.nombre}</option>
							</c:forEach>
                        </form:select>
                        <form:errors path="estado"/>

						<form:label path="delegacionMunicipio">Municipio :</form:label>
						<form:select path="delegacionMunicipio"></form:select>
						<form:label path="localidad">Localidad :</form:label>
						<form:select path="localidad"></form:select>
						<form:label path="codigoPostal">C&oacute;digo Postal :</form:label>
						<form:select path="codigoPostal"></form:select>
                        <form:errors path="codigoPostal"/>
					</div>
					<div class="modal-footer" style="clear: both;">
						<button type="submit" class="btn btn-primary">Registrar</button>
					</div>
				</form:form>
			</div>
		</div>
		<script src="<c:url value="/static/resources/js/jquery.js"/>"></script>
		<script src="<c:url value="/static/resources/js/jquery.dataTables.js"/>"></script>
		<script src="<c:url value="/static/resources/js/bootstrap-dataTables.js"/>"></script>
		<script src="<c:url value="/static/resources/js/jquery-validate.js"/>"></script>
		<script src="<c:url value="/static/resources/js/funciones.js"/>"></script>
		<script src="<c:url value="/static/resources/js/bootstrap.js"/>"></script>
		<script>
			$(document).ready(function() {

				$.validator.setDefaults({
				    showErrors: function (errorMap, errorList) {                         
				       
				    	$.each( this.successList , function(index, value) {
							  $(value).popover('hide');
						  });
						  
						
						  $.each( errorList , function(index, value) { 

							  console.log(value.message);
							  
							   var _popover = $(value.element).popover({
									trigger: 'manual',
									placement: 'right',
									content: value.message,
									template: '<div class="popover errorPopover"><div class="arrow"></div><div class="popover-inner"><div class="popover-content"><p></p></div></div></div>'
								});
						
							   _popover.data('popover').options.content = value.message;
							   if (!$(value.element).is('select') && !$(value.element).hasClass('contrasena')) {
								   $(value.element).focus();   
							   }
							   $(value.element).popover('show');

						  });
				    }
				});
				
				$.validator.addMethod("regex", function(value, element,
						regexp) {
					var re = new RegExp(regexp);
					return this.optional(element) || re.test(value);
				}, "Ingrese un RFC válido.");

				$('#registroForm').validate({
					rules : {
						rfc : {
							required : true,
							rangelength : [ 12, 13 ],
							regex : '[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?'
						},
						razonSocial : {
							rangelength : [ 3, 100 ],
							required : true
						},
						email : {
							required : true,
							email : true
						},
						password : {
							required : true
						},
						calle : {
							required : true
						},
						noExterior : {
							required : true
						},
						colonia : {
							required : true
						},
						pais : {
							required : true
						},
						estado : {
							required : true
						},
						ciudad : {
							required : true
						},
						// codigoPostal : {
						// 	rangelength : [ 5, 5 ],
						// 	required : true
						// },
						delegacion : {
							required : true
						}
					}
				});
				$('#estado').change(
				        function() {
				        	  $.get('/CFDI33/rest/estado/listarMunicipios/'+$(this).val(), {}, function(responseText) {
				                      $('#delegacionMunicipio').html(responseText);
				                });
				              $.get('/CFDI33/rest/estado/listarLocalidades/'+ $(this).val(), {}, function(responseText) {
				                      $('#localidad').html(responseText);
				                });
				              $("#codigoPostal").html("");
				        });
				$('#delegacionMunicipio').change(
				        function() {
				          if ($(this).val() != "ZZZ") {
				                  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipio/'+$('#estado').val()+'/'+$(this).val(), {}, function(responseText) {
				                      $('#codigoPostal').html(responseText);
				                });
				          }
				        });
				$('#localidad').change(
				        function() {
				          if ($(this).val() != "ZZZ") {
				                  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipioLocalidad/'+$('#estado').val()+'/'+$('#delegacionMunicipio').val()+'/'+$(this).val(), {}, function(responseText) {
				                      $('#codigoPostal').html(responseText);
				                });
				          }
				        });
			});
		</script>
	</body>
</html>
