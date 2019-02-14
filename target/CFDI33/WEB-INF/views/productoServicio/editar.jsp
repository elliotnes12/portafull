<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="Editar" scope="request" />
<c:set var="formAction" value="${contextPath}/productoServicio/editar" scope="request" />

<div class="container">
	<ul class="breadcrumb">
	  <li><a href="#">Configuración</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="/productoServicio" />">Producto y Servicio</a> <span class="divider">/</span></li>
	  <li class="active">Editar</li>
	</ul>
	<div class="row-fluid">
        <div class="span8 offset2">
    	   <jsp:include page="/WEB-INF/views/productoServicio/form.jsp" />
        </div>
    </div>
</div>