<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	$("#clientes").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/cliente');
		});
	$("#lugares").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/lugarEmision');
		});
	$("#monedas").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/moneda');
		});
	$("#productos").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/producto');
		});
	$("#cfds").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/cfd');
		});
	$("#datosEmisor").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/datosEmisor');
		});
	$("#csds").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/csd');
		});
	$("#gruposUsuario").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/grupoUsuario');
		});
	$("#usuarios").click(function(event) {
		$("#tabla").load('/CFDI/auditoria/usuario');
		});
});
</script>
<div class="container">
	<ul class="breadcrumb">
	  <li><a href="<c:url value="/configuracion/" />">Configuración</a> <span class="divider">/</span></li>
	  <li class="active">Auditoria</li>
	</ul>
	<div class="btn-toolbar">
  		<div class="btn-group" data-toggle="buttons-radio">
		    <a class="btn" id="clientes">Clientes</a>
		    <a class="btn" id="lugares">Lugares de Emision</a>
		    <a class="btn" id="monedas">Monedas</a>
		    <a class="btn" id="productos">Productos y Servicios</a>
		    <a class="btn" id="cfds">CFD's Emitidos</a>
		    <a class="btn" id="datosEmisor">Datos del Emisor</a>
		    <a class="btn" id="csds">CSD del Emisor</a>
		    <a class="btn" id="gruposUsuario">Grupos de Usuarios</a>
		    <a class="btn" id="usuarios">Usuarios</a>
  		</div>
	</div>
	<div id="tabla">
	</div>
</div>