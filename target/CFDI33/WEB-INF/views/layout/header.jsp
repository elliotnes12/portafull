<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="mx.xpd.cfdi.constantes.URLConstants" %>

<c:set var="contextPath" value="/CFDI33" scope="request" /> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <%--<meta http-equiv="refresh" content="5"> <!-- TODO: Remover --%>
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
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/jquery-confirm.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/modal.css"/>" />
        <title>Sistema de facturaci&oacute;n Electr&oacute;nica</title>
        <!--[if lt IE 9]>
            <script src="js/html5shiv.min.js"></script>
            <script src="js/html5shiv-printshiv.min.js"></script>
        <![endif]-->
        <!-- <style>body{background-image: none;}</style> -->
    </head>
    <body>
        <div id="lineTop"></div>
        <div class="header top-bar" id="main-menu">
            <div style="margin:auto;max-width: 960px">
                <div>
                    <div id="logo" class="small-5">
                      <span class="flex__sectionLeft">
                        <a href="<c:url value="/login/inicio" />">
                        <img src="<c:url value="/static/resources/img/logo.svg"/>">
                        </a>
                      </span>
                      <span class="flex__sectionRight">
                        <a href="<%= URLConstants.INFO_RECOMIENDA %>" target="_blank">
                        <img src="<c:url value="/static/resources/img/PlecaRecomienda.png"/>">
                        </a>
                      </span>
                    </div>
                </div>
                <div id="avisoParent">
                    <div class="top-bar-right aviso">
                        <div class="small-centered">
                            <c:if test="${gratuito == false}">
                                <c:if test="${tipoPlan == false}">
                                    (${foliosDisponibles}) Folios Disponibles / Vigencia: ${ultimaCompra}
                                </c:if>
                                <c:if test="${tipoPlan == true}">
                                    Vigencia: ${fechaVencimiento}
                                </c:if>
                            </c:if>
                            <c:if test="${gratuito == true}">
                                Servicio Gratuito
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin: 0 -0.5rem 0 -0.5rem">
                <div id="menu">
                    <div id="menu-container">
                        <div style="height: inherit;margin:auto;max-width: 1080px;">
                            <div>
                                <ul class="menu vertical medium-horizontal" data-responsive-menu="drilldown medium-dropdown" data-back-button='<li class="js-drilldown-back"><a tabindex="0">Regresar</a></li>'>
                                    <li>
                                        <a href="<c:url value="/login/inicio" />">
                                            <!-- Inicio -->
                                            <i class="icon-home icon-white"></i>
                                        </a>
                                    </li>
                                    <li class="has-submenu">
                                        <a href="#">Cat&aacute;logos</a>
                                        <ul class="submenu menu vertical" data-submenu>
                                        	<c:if test="${gratuito == false}">
                                            	<li><a href="<c:url value="/cliente/" />">Clientes</a></li>
                                            </c:if>	
    					                    <li><a href="<c:url value="/lugarExpedicion/" />">Lugar de Expedici&oacute;n</a></li>
    					                    <c:if test="${gratuito == false}">
                                            	<li><a href="<c:url value="/productoServicio/" />">Productos/Servicios</a></li>
                                            	<li><a href="<c:url value="/empleado/" />">Empleados</a></li>
                                            <li class="divider" style="padding: 0;"></li>
                                            </c:if>
                                        </ul>
                                    </li>
                                    <li class="has-submenu">
                                        <a href="#">Configuraci&oacute;n</a>
                                        <ul class="submenu menu vertical" data-submenu>
                                            <li><a href="<c:url value="/datosEmisor/" />">Datos del emisor</a></li>
                                            <li><a href="<c:url value="/csd/" />">CSD</a></li>
                                            <c:if test="${gratuito == false}">
                                            	<!--  <li><a href="<c:url value="/grupoUsuario/" />">Grupo de Usuarios</a></li>
                                            	<li><a href="<c:url value="/usuario/" />">Usuarios</a></li>-->
                                            	<li><a href="<c:url value="/plantilla/" />">Plantillas</a></li>
                                            </c:if>
                                            <li><a href="<c:url value="/configuracionCFDI/" />">Preferencias</a></li>
                                            <li><a href="<c:url value="/manifiesto" />">Firmar Manifiesto</a></li>
                                        </ul>
                                    </li>
                                    <li class="has-submenu">
                                        <a href="#">Generar CFDIs</a>
                                        <ul class="submenu menu vertical" data-submenu>
                                            <li><a href="<c:url value="/comprobante/${tipoComprobante eq null ? 'fa' : tipoComprobante}" />">Factura</a></li>
                                            <c:if test="${gratuito == false}">
                                            	<li><a href="<c:url value="/comprobante/retenciones" />">Retenci&oacute;n</a></li>
                                            	<li><a href="<c:url value="/comprobante/nomina" />">Nómina (Manual)</a></li>
                                            	<li><a href="<c:url value="/nominas/" />">Nómina Excel</a></li>
                                            </c:if>	
                                        </ul>
                                    </li>
                                    <li class="has-submenu">
                                        <a href="#">CFDIs Generados</a>
                                        <ul class="submenu menu vertical" data-submenu>
                                            <li>
                                            	<a href="<c:url value="/comprobante/listar/" />">Facturas</a>
                                            </li>
	                                        <c:if test="${(tenantId == 'DON1209075R0') || (tenantId == 'PNO080901EX6')}" >
	                                        	<li><a href="http://expidetufactura.com.mx/comprobantes_pago/sistema/comprobantes">Recibos pago - DON1209075R0</a></li>
	                                        </c:if>  
	                                        <c:if test="${(tenantId == 'TIN150902G45')}" >
	                                        	<li><a href="http://expidetufactura.com.mx/apps/comprobantes_pago_TIN150902G45/sistema/comprobantes">Recibos pago - TIN150902G45</a></li>
	                                        </c:if>
	                                        <c:if test="${(tenantId == 'INP180301NI9')}" >
	                                        	<li><a href="http://xpd.mx/apps/comprobantes_pago_INP180301NI9/sistema/comprobantes">Recibos pago - INP180301NI9</a></li>
	                                        </c:if>    
                                            <c:if test="${gratuito == false}">
	                                            <li><a href="<c:url value="/comprobante/listarRetenciones/" />">Retenciones</a></li>
	                                        </c:if>  
                                            <c:if test="${gratuito == false}">
                                            	<li><a href="<c:url value="/nominas/listar" />">Nóminas</a></li>
                                            </c:if>	
                                        </ul>
                                    </li>
                                    <c:if test="${gratuito == false}">
	                                    <li class="has-submenu">
	                                        <a href="#">Descargas</a>
	                                        
	                                        	<ul class="submenu menu vertical" data-submenu>
	                                            	<li><a href="<%= URLConstants.PLANTILLA_NOMINA %>" target="_blank">Formato Excel para Nómina</a></li>
	                                        	</ul>
	                                    </li>
                                    </c:if>
                                    <li class="has-submenu">
                                        <a href="#">Ayuda</a>
                                        <ul class="submenu menu vertical" data-submenu>
                                            <li><a href="<%= URLConstants.MANUAL_PORTAL33 %>" target="_blank">Manual de usuario</a></li>
                                            <c:if test="${gratuito == false}">
                                            	<li><a href="<c:url value="/nominas/ayuda" />">Manual para creación de nomina</a></li>
                                            </c:if>	
                                            <li><a href="<%= URLConstants.EMISIONRECIBOPAGO_DOC %>" target="_blank">Emisión del Recibo de Pago</a></li>
                                            <li><a href="<%= URLConstants.USOSCOMPROBANTERECIBOPAGO_DOC %>" target="_blank">Usos del Comprobante de Recibo de Pago</a></li>
                                            <li><a href="<%= URLConstants.MANUAL_NUEVA_CANCELACION %>" target="_blank">Nuevo Esquema de Cancelación</a></li>
                                            <li><a href="<%= URLConstants.GUIALLENADOCOMPPAGOS_DOC %>" target="_blank">Guía de Llenado Comprobante de Pago</a></li>
                                        </ul>
                                    </li>
                                    <li class="has-submenu">
                                        <a href="#">Tutoriales</a>
                                        <ul class="submenu menu vertical" data-submenu>
                                            <li><a href="https://youtu.be/v-VrX0waiEY" target="_blank">Crear Factura</a></li>
                                            <li><a href="https://youtu.be/L2XALnGThyU" target="_blank">Activar un Complemento</a></li>
                                            <li><a href="https://youtu.be/1imO1q_Obkw" target="_blank">Lugar de Expedición</a></li>
                                            <li><a href="https://youtu.be/faoqtkPBqyk" target="_blank">Agregar CSD</a></li>
                                            <li><a href="https://youtu.be/lnxm-TSdYGU" target="_blank">Nómina Excel</a></li>
                                        </ul>
                                    </li>
                                    <li class="align-right">
                                        <a href="/CFDI33/<c:url value="j_spring_security_logout" />">Salir</a>
                                    </li>
                                </ul>
                            </div>
                            <!-- <div class="top-bar-right">
                                <ul class="menu vertical medium-horizontal" data-responsive-menu="drilldown medium-dropdown">
                                </ul>
                            </div> -->
                        </div>
                    </div>
                </div>
                <div id="menuBottom"></div>
            </div>
        </div>
        <div class="content">
            <div id="myModal">
                <div id="myModal2" class="modal hide" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-header">
                    <button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true" id="backFreeUser">×</button>
                    <h3 id="myModalLabel">Acceso para usuarios de pago.</h3>
                  </div>
                  <div class="modal-body">
                    <p>Esta característica s&oacute;lo esta disponible para usuarios de pago.</p>
                  </div>
                  <div class="modal-footer">
                    <a href="http://www.expidetufactura.com.mx/XPD/planes.html" target="_blank" class="btn btn-primary">Contratar</a>
                  </div>
                </div>
            </div>
            <script type="text/javascript" src="<c:url value="/static/resources/js/jquery.js"/>"></script>
            <script type="text/javascript" src="<c:url value="/static/resources/js/foundation.min.js"/>"></script>
            <script type="text/javascript" src="<c:url value="/static/resources/js/app.js"/>"></script>
            <script src="<c:url value="/static/resources/js/jquery.dataTables.js"/>"></script>
            <script src="<c:url value="/static/resources/js/jquery-validate.js"/>"></script>
            <script src="<c:url value="/static/resources/js/funciones.js"/>"></script>
            
        
           <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
           <script src="https://code.angularjs.org/1.2.20/angular-sanitize.min.js"></script>
           
           
           <script src="<c:url value="/static/resources/js/jsonTablepagos.js"/>"></script>
           <script src="<c:url value="/static/resources/js/modal.js"/>"></script>
           <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
            
            <script src="<c:url value="/static/resources/js/bootstrap.js"/>"></script>
            <script src="<c:url value="/static/resources/js/bootstrap-dataTables.js"/>"></script>
            <script src="<c:url value="/static/resources/js/jquery-confirm.min.js"/>"></script>
            
            <!-- <script type="text/javascript" src="<c:url value="/static/resources/js/app.js"/>"></script> -->
            <script>
                //<![CDATA[
                var txt="Sistema de Facturación Electrónica";
                var espera=200;
                var refresco=null;
                // function rotulo_title() {
                //     document.title=txt;
                //     txt=txt.substring(1,txt.length)+txt.charAt(0);
                //     refresco=setTimeout("rotulo_title()",espera);
                // }
                // rotulo_title();
                //]]>
            </script>