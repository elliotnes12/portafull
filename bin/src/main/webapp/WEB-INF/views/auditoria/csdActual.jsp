<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form:form commandName="csdActual" action="${formAction}" method="POST">
<div class="container">

	<table cellpadding="0" cellspacing="0" border="0"
		class="table table-striped table-bordered table-hover" id="listaActual">
		<thead>
			<tr>
				<th>No. Serie</th>
				<th>Fecha Inicio</th>
				<th>Fecha Caducidad</th>
				<th>Fecha Registro</th>
				<th>Comentario</th>
			</tr>
		</thead>
			<tr id="row-${csdActual.id}">
				<td>${csdActual.noSerie}</td>
				<td>${csdActual.fechaInicio}</td>
				<td>${csdActual.fechaFin}</td>
				<td>${csdActual.fechaRegistro}</td>
				<td>${csdActual.comentario}</td>
			</tr>
	</table>
</div>
</form:form>