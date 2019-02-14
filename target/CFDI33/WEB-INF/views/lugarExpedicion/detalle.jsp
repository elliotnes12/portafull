<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="Detalle" scope="request" />
<c:set var="formAction" value="${contextPath}/lugarExpedicion/" scope="request" />

<div class="container">
	<ul class="breadcrumb">
	  <li><a href="#">Configuración</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="/lugarExpedicion/" />">Lugar de Expedición</a> <span class="divider">/</span></li>
	  <li class="active">Detalles</li>
	</ul>
    <style>
        #formLugar{margin: auto;}
    </style>
	<jsp:include page="/WEB-INF/views/lugarExpedicion/form.jsp" />
</div>
