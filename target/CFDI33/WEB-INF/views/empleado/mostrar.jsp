<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="mx.xpd.cfdi.constantes.URLConstants" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<style>
	a img {
		cursor: pointer;
		border: none;
	}
	
	.divCargando {
		width: 250px;
		margin: auto;
		top: 50%;
		left: 50%;
		text-align: center;
	}
	
	.mAddendas {display:none;}
	
	.progress { height: 30px; }

</style>

<c:if test="${gratuito == true}">
	<script>
		usuarioGratuito();
	</script>
</c:if>

<script>
	$(document).ready(function() {
		  $('#listaEmpleados').dataTable( {
		    "aoColumns": [
		      null,
		      null,
		      null,
		      { "bSearchable": false },
		      { "bSearchable": false },
		      { "bSearchable": false }
		    ],
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
		
		  $('#subirEmpleadosForm').unbind('submit').bind('submit',  function() {  //submit( // .submit(function() {
				
			    //alert("0")
			    if ($('input[name=file').val() == "") {
			        alert("Seleccione su archivo");
			        return false;
			    }
			        
			    $('#modalLoad').modal();
				return true;

			});
	
	
	} );
	
		
	
</script>


<!-- Modal -->
<div id="modalLoad" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
   		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
   		<h3 id="modalLoadLabel">Espere un momento</h3>
	</div>
	<div class="modal-body">
  		<p>Su archivo, se esta subiendo al servidor ...</p>
	</div>
	<div class="modal-footer">
  		<p> By XPD</p>
	</div>
</div>

<div id="divCargando2" class="divCargando modal hide">
	<h4>Cancelando...</h4>
	<div style="width: 150px; margin: auto;">
		<div class="progress progress-striped active">
	  		<div class="bar" style="width: 100%;"></div>
		</div>
	</div>
</div>


<c:if test="${msg != null}">
	<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		${msg}
	</div>
</c:if>


<div class="container">
	
	<ul class="breadcrumb">
	  <li><a href="#">Configuracion</a> <span class="divider">/</span></li>
	  <li class="active">Empleados</li>
	</ul>
 		
	<c:set var="action" value="Agregar" scope="request" />
	<c:set var="formAction" value="${contextPath}/empleado/agregar" scope="request" />
	
	<jsp:include page="/WEB-INF/views/empleado/form.jsp" />
		

	<div class="row-fluid">
		<div class="span10 offset1">
			<p>
				<a class="btn btn-primary" target="_blank" href="<%= URLConstants.PLANTILLA_EMPLEADOSNOMINA %>">
					<i class="icon-download icon-white"></i>Descargar Formato Empleados
				</a>
			</p>
			<form:form method="post" enctype="multipart/form-data"  modelAttribute="uploadedFile" action="subirEmpleados" id="subirEmpleadosForm">  
				<style>
					#upload-file-selector {display:none;}
					.margin-correction {margin-right: 10px;}
				</style>
				<span id="fileselector">
			        <label class="btn btn-success" for="upload-file-selector">
			            <input id="upload-file-selector" name="file" type="file">
			            <i class="fa_icon icon-file icon-white margin-correction"></i>Seleccionar Cat&aacute;logo de empleados
			        </label>
			    </span>
		        <input type="submit" class="btn btn-primary" value="Subir archivo" />
			</form:form>  
			
			<c:if test="${totalRegistrosEmpleado > 0}">
			<div class="row">
				<style>
					.row{margin-left: 0px;}
				</style>
				<div class="alert alert-info">
				  		<strong> Total registros leidos:  ${totalRegistrosEmpleado} </strong>
				</div>

				<div class="alert alert-success">
				  		<strong> Total almacenados:: ${totalRegistrosEmpleado}</strong>
				</div>

				<c:if test="${totalErroresEmpleado > 0}">
					<div class="alert alert-error">
				  			<strong>Errores: ${totalErroresEmpleado}</strong>
				  			<a href="<c:url value="/empleado/errores/" />">Descargar errores</a>
					</div>
				</c:if>
			</div>
			</c:if>
			<div id="btnAdd" align="right" class="span3 offset9">
				<a class="btn btn-primary"  data-toggle="modal" href="#formEmpleado"><i class="icon-plus-sign icon-white"></i> Agregar Empleado</a>
			</div>
			<br>
			<div class="overflow">
				<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover" id="listaEmpleados">
					<thead>
						<tr>
							<th>Clave</th>
							<th>Nombre empleado</th>
							<th>RFC</th>
							<th width="80" class="txtCenter">Detalles</th>
			   				<th width="80" class="txtCenter">Eliminar</th>
			   				<th width="80" class="txtCenter">Editar</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${empleados}" var="empleado">
						<tr id="row-${empleado.id}">
							<td>${empleado.numEmpleado}</td>
							<td class="left">${empleado.nombre}</td>
							<td>${empleado.rfc}</td>
							<td class="txtCenter"><a href="<c:url value="/empleado/detalle/${empleado.id}"/>">Ver</a></td>
							<td class="txtCenter"><a href="#" onClick="eliminar('empleado', ${empleado.id})"><i class="icon-trash"></i></a></td>  
							<td class="txtCenter"><a href="<c:url value="/empleado/editar/${empleado.id}"/>"><i class="icon-edit"></i></a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>