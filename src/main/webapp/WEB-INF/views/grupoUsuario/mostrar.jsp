<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<script>
$(document).ready( function() {
	  $('#listaGrupoUsuario').dataTable( {
	    "aoColumns": [
	      null,
	      null,
	      null,
	      null,
	      // { "bSearchable": false },
	      // { "bSearchable": false },
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
<div class="container row-fluid">
	<ul class="breadcrumb">
		<li><a href="#">Configuración</a>
			<span class="divider">/</span></li>
		<li class="active">Grupo Usuario</li>
	</ul>

	<c:set var="action" value="Agregar" scope="request" />
	<c:set var="formAction" value="${contextPath}/grupoUsuario/agregar"
		scope="request" />

	<jsp:include page="/WEB-INF/views/grupoUsuario/form.jsp" />
	<div class="span10 offset1">
		<div class="span4 offset8" style="margin-bottom: 15px">
			<div id="btnAdd">
				<a class="btn btn-primary" data-toggle="modal"
					href="#formGrupoUsuario"><i class="icon-plus icon-white"></i>
					Agregar Grupo Usuario</a>
			</div>
		</div>
		<table cellpadding="0" cellspacing="0" border="0"
			id="listaGrupoUsuario"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Clave</th>
					<th>Nombre</th>
					<th>Hora Inicial</th>
					<th>Hora Final</th>
					<th>Acciones</th>
					<!-- <th width="80" class="txtCenter">Detalles</th>
					<th width="80" class="txtCenter">Eliminar</th>
					<th width="80" class="txtCenter">Editar</th> -->
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listaGrupoUsuarios}" var="grupoUsuario">
				<tr id="row-${grupoUsuario.id}">
					<td>${grupoUsuario.clave}</td>
					<td>${grupoUsuario.nombre}</td>
					<td><fmt:formatDate value="${grupoUsuario.horaInicial}" pattern="hh:mm:ss a" /></td>
					<td><fmt:formatDate value="${grupoUsuario.horaFinal}"
							pattern="hh:mm:ss a" /></td>
					<td class="txtCenter">
						<a href="<c:url value="/grupoUsuario/detalle/${grupoUsuario.id}"/>" title="Ver detalle">
							<i class="icon-eye-open"></i>
						</a>
					<!-- </td>
					<td class="txtCenter"> -->
						<a href="<c:url value="/grupoUsuario/editar/${grupoUsuario.id}"/>" title="Modificar">
							<i class="icon-edit"></i>
						</a>
						<a href="#" onClick="eliminar('grupoUsuario', ${grupoUsuario.id})" title="Eliminar">
							<i class="icon-trash"></i>
						</a>
					<!-- </td>
					<td class="txtCenter"> -->
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
