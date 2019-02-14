<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<c:if test="${gratuito == true}">
	<script>
		usuarioGratuito();
	</script>
</c:if>


<c:set var="action" value="Editar" scope="request" />
<c:set var="formAction" value="${contextPath}/configuracionCFDI/editar" scope="request" />

<div class="container">
	<ul class="breadcrumb">
	  <li><a href="#">Configuración</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="/configuracionCFDI/" />">Configuración CFDI</a> <span class="divider">/</span></li>
	  <li class="active">Editar</li>
	</ul>	
	<jsp:include page="/WEB-INF/views/configuracionCFDI/form.jsp" />	
</div>