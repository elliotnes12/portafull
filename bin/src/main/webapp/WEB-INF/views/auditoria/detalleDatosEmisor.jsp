<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="auditoria" scope="request" />
<c:set var="formAction" value="${contextPath}/datosEmisor/" scope="request" />

<div class="container">
	<ul class="breadcrumb">
	  <li><a href="<c:url value="/Configuracion/" />">Configuración</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="/auditoria/" />">Auditoria</a> <span class="divider">/</span></li>
	  <li class="active">Datos Emisor / Detalle</li>
	</ul>
	<h2>Valor Actual</h2>
	<jsp:include page="/WEB-INF/views/datosEmisor/form.jsp"/>	
	<h2>Valor Anterior</h2>
	<jsp:include page="/WEB-INF/views/auditoria/datosEmisorAnterior.jsp"/>
</div>