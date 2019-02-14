<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp"/>
<script>
	$(document).ready(function() {
		  $('#listaMoneda').dataTable( {
		    "aoColumns": [
		      null,
		      null,
		      null,
		      null,
		      { "bSearchable": false },
		      { "bSearchable": false },
		      { "bSearchable": false }
		    ] } );
		} );
</script>
<div class="container">
<c:if test="${msg != null}">
<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  ${msg}
</div>
</c:if>

	<ul class="breadcrumb">
	  <li><a href="#">Configuraci�n</a> <span class="divider">/</span></li>
	  <li class="active">Monedas</li>
	</ul>
		
	<c:set var="action" value="Agregar" scope="request" />
	<c:set var="formAction" value="${contextPath}/moneda/agregar" scope="request" />
	<jsp:include page="/WEB-INF/views/moneda/form.jsp" />
	<div class="row-fluid">
	<div class="span10 offset1">
	<div id="btnAdd" class="span3 offset9" align="right">
		<a class="btn btn-primary"  data-toggle="modal" href="#formMoneda"><i class="icon-plus-sign icon-white"></i> Agregar Moneda</a>
	</div>
	
	<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover" id="listaMoneda">
		<thead>
			<tr>
				<th>Clave</th>
				<th>Nombre Corto</th>
				<th>Tipo de Cambio</th>
				<th>Nombre</th>
				<th width="80" class="txtCenter">Detalles</th>
	   		<th width="80" class="txtCenter">Eliminar</th>
	   		<th width="80" class="txtCenter">Editar</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${monedas}" var="moneda">
			<tr id="row-${moneda.id}">
				<td>${moneda.clave}</td>
				<td>${moneda.nombreCorto}</td>
				<td>${moneda.tipoCambio}</td>
				<td>${moneda.nombre}</td>
				<td class="txtCenter"><a href="<c:url value="/moneda/detalle/${moneda.id}"/>">Ver</a></td>
				<td class="txtCenter"><a href="#" onClick="eliminar('moneda', ${moneda.id})"><i class="icon-trash"></i></a></td>  
				<td class="txtCenter"><a href="<c:url value="/moneda/editar/${moneda.id}"/>"><i class="icon-edit"></i></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</div>
