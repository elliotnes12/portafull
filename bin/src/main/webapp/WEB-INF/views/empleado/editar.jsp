<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="Editar" scope="request" />
<c:set var="formAction" value="${contextPath}/empleado/editar" scope="request" />

<div class="container">
	<ul class="breadcrumb">
	  <li><a href="#">Configuración</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="empleado" />">Empleado</a> <span class="divider">/</span></li>
	  <li class="active">Editar</li>
	</ul>
	<div>
	   <jsp:include page="/WEB-INF/views/empleado/form.jsp" />
    </div>
</div>