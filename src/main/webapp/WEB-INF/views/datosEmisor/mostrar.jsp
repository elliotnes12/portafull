<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="Editar" scope="request" />
<c:set var="formAction" value="${contextPath}/datosEmisor/editar" scope="request" />

<div class="container">
	<c:if test="${imagenError eq 'true'}">
		<div class="alert alert-error">
			La imagen debe ser .jpg y no debe ser mayor de 500kb.
		</div>
	</c:if>
	<ul class="breadcrumb">
	  <li><a href="#">Configuración</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="/datosEmisor/" />">Datos del Emisor</a> <span class="divider">/</span></li>
	  <li class="active">Editar</li>
	</ul>	
	<jsp:include page="/WEB-INF/views/datosEmisor/form.jsp" />	
</div>