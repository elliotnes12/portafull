<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">	
	<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover" id="listaAuditoriaMoneda">
	<thead>
		<tr>
			<th>Fecha</th>
			<th>Usuario</th>
			<th>Accion Realizada</th>
			<th width="80" class="txtCenter">Detalles</th>
		</tr>
	</thead>
	<c:forEach items="${lugares}" var="lugar">
		<tr id="row-${lugar.id}">
			<td>${lugar.ultimaActualizacion}</td>
			<td>${lugar.triggerActivadoPor}</td>
			<td>${lugar.accionRealizada}</td>				  
			<td class="txtCenter"><a href="<c:url value="/auditoria/detalle/lugarEmision/${lugar.idAuditoria}"/>">Ver</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>