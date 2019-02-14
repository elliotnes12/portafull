<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<script>
	$(document).ready(function() {
		  $('#listaLugares').dataTable( {
		    "aoColumns": [
		      null,
		      null,
		      { "bSearchable": false },
		      { "bSearchable": false },
		      { "bSearchable": false }
		    ] ,
		    "oLanguage": {
		        "sProcessing":     "Procesando...",
		        "sLengthMenu":     "Mostrar _MENU_ registros",
		        "sZeroRecords":    "No se encontraron resultados",
		        "sEmptyTable":     "Ningun dato disponible en esta tabla",
		        "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
		        "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
		        "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
		        "sInfoPostFix":    "",
		        "sSearch":         "Buscar:",
		        "sUrl":            "",
		        "sInfoThousands":  ",",
		        "sLoadingRecords": "Cargando...",
		        "oPaginate": {
		            "sFirst":    "Primero",
		            "sLast":     "Ultimo",
		            "sNext":     "Siguiente",
		            "sPrevious": "Anterior"
		        },
		        "oAria": {
		            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
		            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
		        }
		    }
		    });
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
	  <li><a href="#">Configuraci&oacute;n</a> <span class="divider">/</span></li>
	  <li class="active">Lugar de Expedición</li>
	</ul>

	<c:set var="action" value="Agregar" scope="request" />
	<c:set var="formAction" value="${contextPath}/lugarExpedicion/agregar" scope="request" />
	<jsp:include page="/WEB-INF/views/lugarExpedicion/form.jsp" />
	<div class="row-fluid">
		<div class="span10 offset1">
			<div id="btnAdd" class="span4 offset8" align="right">
				<a class="btn btn-primary"  data-toggle="modal" href="#formLugar"><i class="icon-plus-sign icon-white"></i> Agregar Lugar de Expedición</a>
			</div>
			<div class="overflow">
				<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover" id="listaLugares">
					<thead>
						<tr>
							<th>Id Interno</th>
							<th>Nombre</th>
							<th width="80" class="txtCenter">Detalles</th>
				   		<th width="80" class="txtCenter">Eliminar</th>
				   		<th width="80" class="txtCenter">Editar</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${lugares}" var="lugar">
						<tr id="row-${lugar.id}">
							<td>${lugar.clave}</td>
							<td>${lugar.nombre}</td>
							<td class="txtCenter"><a href="<c:url value="/lugarExpedicion/detalle/${lugar.id}"/>">Ver</a></td>
							<td class="txtCenter"><a href="#" onClick="eliminar('lugarExpedicion', ${lugar.id})"><i class="icon-trash"></i></a></td>
							<td class="txtCenter"><a href="<c:url value="/lugarExpedicion/editar/${lugar.id}"/>"><i class="icon-edit"></i></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
