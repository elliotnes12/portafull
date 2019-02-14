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
	<c:forEach items="${csds}" var="csd">
		<tr id="row-${csd.id}">
			<td>${csd.ultimaActualizacion}</td>
			<td>${csd.triggerActivadoPor}</td>
			<td>${csd.accionRealizada}</td>				  
			<td class="txtCenter"><a href="<c:url value="/auditoria/detalle/csd/${csd.idAuditoria}"/>">Ver</a></td>
		</tr>
	</c:forEach>
	</table>
	</div>