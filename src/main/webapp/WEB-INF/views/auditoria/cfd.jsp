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
	<!--<c:forEach items="${monedas}" var="moneda">
		<tr id="row-${moneda.id}">
			<td>${moneda.clave}</td>
			<td>${moneda.nombreCorto}</td>
			<td>${moneda.tipoCambio}</td>
			<td>${moneda.nombre}</td>
			  <td><a href="<c:url value="/rest/grupoUsuario/detalles/${usuario.grupo}"/>">Ver</a></td>
			<td class="txtCenter"><a href="<c:url value="/moneda/detalle/${moneda.id}"/>">Ver</a></td>
			<td class="txtCenter"><a href="#" onClick="eliminar('moneda', ${moneda.id})"><i class="icon-trash"></i></a></td>  
			<td class="txtCenter"><a href="<c:url value="/moneda/editar/${moneda.id}"/>"><i class="icon-edit"></i></a></td>
		</tr>
	</c:forEach>-->
	</table>
	</div>