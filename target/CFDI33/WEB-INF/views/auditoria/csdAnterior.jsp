<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form commandName="csdAnterior" action="${formAction}" method="POST">
<div class="container">

	<table cellpadding="0" cellspacing="0" border="0"
		class="table table-striped table-bordered table-hover" id="listaAnterior">
		<thead>
			<tr>
				<th>No. Serie</th>
				<th>Fecha Inicio</th>
				<th>Fecha Caducidad</th>
				<th>Fecha Registro</th>
				<th>Comentario</th>
				<th>Activado Por</th>
				<th>Accion Realizada</th>
				<th>Ultima Actualizacion</th>
			</tr>
		</thead>
		
			<tr id="row-${csdAnterior.id}">
				<td>${csdAnterior.noSerie}</td>
				<td>${csdAnterior.fechaInicio}</td>
				<td>${csdAnterior.fechaFin}</td>
				<td>${csdAnterior.fechaRegistro}</td>
				<td>${csdAnterior.comentario}</td>
				<td>${csdAnterior.triggerActivadoPor}</td>
				<td>${csdAnterior.accionRealizada}</td>
				<td>${csdAnterior.ultimaActualizacion}</td>
			</tr>
	</table>
</div>
</form:form>