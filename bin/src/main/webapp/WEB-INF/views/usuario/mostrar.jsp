<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<div class="container">

<c:if test="${msg != null}">
<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  ${msg}
</div>
<style>
	input{
		height: initial;
	}
</style>
</c:if>
<div class="row-fluid">
	<ul class="breadcrumb">
	  <li><a href="#">Configuraci�n</a> <span class="divider">/</span></li>
	  <li class="active">Usuarios</li>
	</ul>

	<c:set var="action" value="Agregar" scope="request" />
	<c:set var="formAction" value="${contextPath}/usuario/agregar" scope="request" />
	<jsp:include page="/WEB-INF/views/usuario/form.jsp" />
	<div class="span10 offset1">
		<div class="span3 offset9">
			<div id="btnAdd">
				<a class="btn btn-primary"  data-toggle="modal" href="#formUsuario"><i class="icon-plus icon-white"></i> Agregar Usuario</a>
			</div>
		</div>

		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered table-hover" id="lista">
			<thead>
				<tr>
					<th>Clave</th>
					<th>Nombre</th>
					<th>Grupo</th>
					<th>Acciones</th>
					<!-- <th width="80" class="txtCenter">Detalles</th>
		   		<th width="80" class="txtCenter">Eliminar</th>
		   		<th width="80" class="txtCenter">Editar</th> -->
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr id="row-${usuario.id}">
					<td>${usuario.clave}</td>
					<td>${usuario.nombre}</td>
					<td><a href="<c:url value="/grupoUsuario/detalle/${usuario.grupo}"/>"><span class="mostrarGrupo" grupo-id="${usuario.grupo}">Ver</span></a></td>
					<td class="txtCenter">
						<a href="<c:url value="/usuario/detalle/${usuario.id}"/>" title="Ver detalles">
							<i class="icon-eye-open"></i>
						</a>
						<a href="<c:url value="/usuario/editar/${usuario.id}"/>" title="Modificar"><i class="icon-edit"></i></a>
						<a href="#" onClick="eliminar('usuario', ${usuario.id})" title="Eliminar"><i class="icon-trash"></i></a>
					</td>
					<!-- <td class="txtCenter">
					<td class="txtCenter"> -->
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
