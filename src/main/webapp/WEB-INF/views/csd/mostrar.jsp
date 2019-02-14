<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<script>
	$(document).ready(function() {
		$('.btn-primary').click(function() {
			redirect('/CFDI33/csd/nuevo');
		});

		  $('#listaCsds').dataTable( {
		    "aoColumns": [
		      null,
		      null,
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
	<c:if test="${msg != null}">
	<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		${msg}
	</div>
	</c:if>
	<div class="span10 offset1">
		<ul class="breadcrumb">
			<li><a href="#">Configuración</a>
				<span class="divider">/</span></li>
			<li class="active">CSD</li>
		</ul>

		<div id="btnAdd" class="span5 offset7" style="margin-bottom: 15px">
			<a class="btn btn-primary" data-toggle="modal" href="#formCsd">
				<i class="icon-plus icon-white"></i>
				Agregar Certificado de Sello Digital
			</a>
		</div>
		<table cellpadding="0" cellspacing="0" border="0"
			class="table table-striped table-bordered table-hover" id="listaCsds">
			<thead>
				<tr>
					<th>No. Serie</th>
					<th width="80">Fecha Inicio</th>
					<th width="80">Fecha Caducidad</th>
					<th width="80">Fecha Registro</th>
					<th>Comentario</th>
					<th width="80" class="txtCenter">En uso</th>
					<th>Acciones</th>
					<!-- <th width="80" class="txtCenter">Detalles</th>
					<th width="80" class="txtCenter">Eliminar</th>
					<th width="80" class="txtCenter">Editar</th> -->
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listaCSDs}" var="csd">
				<tr id="row-${csd.id}">
					<td>${csd.noSerie}</td>
					<td><fmt:formatDate value="${csd.fechaInicio}"
							pattern="dd-MM-yyyy" /></td>
					<td><fmt:formatDate value="${csd.fechaFin}"
							pattern="dd-MM-yyyy" /></td>
					<td><fmt:formatDate value="${csd.fechaRegistro}"
							pattern="dd-MM-yyyy" /></td>
					<td>${csd.comentario}</td>
					<td class="txtCenter"><c:choose>
							<c:when test="${csd.usar == true}">
								<i class="icon-ok"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-remove"></i>
							</c:otherwise>
						</c:choose></td>
					<td class="txtCenter">
						<a href="<c:url value="/csd/detalle/${csd.id}"/>" title="Ver detalle">
							<i class="icon-eye-open"></i>
						</a>
						<a href="<c:url value="/csd/editar/${csd.id}"/>" title="Modificar">
							<i class="icon-edit"></i>
						</a>
						<a href="#" onClick="eliminar('csd', ${csd.id})" title="Eliminar">
							<i class="icon-trash"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>