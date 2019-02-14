<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="Editar" scope="request" />
<c:set var="formAction" value="${contextPath}/parametro/editar" scope="request" />

<div class="container">
	<ul class="breadcrumb">
	  <li><a href="<c:url value="/configuracion" />">Configuraci�n</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="/Parametro/" />">Par�metros</a> <span class="divider">/</span></li>
	  <li class="active">Editar</li>
	</ul>
	
	<jsp:include page="/WEB-INF/views/parametro/form.jsp" />	
</div>