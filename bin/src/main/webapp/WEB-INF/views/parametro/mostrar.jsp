<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<div class="container">

	<ul class="breadcrumb">
	  <li><a href="<c:url value="/configuracion/" />">Configuración</a> <span class="divider">/</span></li>
	  <li class="active">Parámetros</li>
	</ul>
		
	<c:set var="action" value="Agregar" scope="request" />
	<c:set var="formAction" value="${contextPath}/parametro/agregar" scope="request" />
	<jsp:include page="/WEB-INF/views/parametro/form.jsp" />
	
	<div id="btnAdd">
		<a class="btn btn-primary"  data-toggle="modal" href="#formParametro"><i class="icon-user icon-white"></i> Agregar Parámetro</a>
	</div>
	
	<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover" id="lista">
	<thead>
		<tr>
			<th>Clave</th>
			<th>Nombre</th>
			<th>Valor</th>
			<th>Descripcion</th>
			<th width="80" class="txtCenter">Detalles</th>
   		<th width="80" class="txtCenter">Eliminar</th>
   		<th width="80" class="txtCenter">Editar</th>
		</tr>
	</thead>
	<c:forEach items="${parametros}" var="parametro">
		<tr id="row-${parametro.id}">
			<td>${parametro.clave}</td>
			<td>${parametro.nombre}</td>
			<td>${parametro.valor}</td>
			<td>${parametro.descripcion}</td>
			<td class="txtCenter"><a href="<c:url value="/parametro/detalle/${parametro.id}"/>">Ver</a></td>
			<td class="txtCenter"><a href="#" onClick="eliminar('parametro', ${parametro.id})"><i class="icon-trash"></i></a></td>  
			<td class="txtCenter"><a href="<c:url value="/parametro/editar/${parametro.id}"/>"><i class="icon-edit"></i></a></td>
		</tr>
	</c:forEach>
	</table>
	</div>