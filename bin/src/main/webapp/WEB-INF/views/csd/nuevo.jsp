<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="Agregar" scope="request" />
<c:set var="formAction" value="${contextPath}/csd/agregar"
	scope="request" />

<div class="container">
	<ul class="breadcrumb">
		<li><a href="<c:url value="/configuracion/" />">Configuración</a>
			<span class="divider">/</span></li>
		<li><a href="<c:url value="/csd" />">CSD</a> <span
			class="divider">/</span></li>
		<li class="active">Nuevo</li>
	</ul>

	<jsp:include page="/WEB-INF/views/csd/form.jsp" />
</div>