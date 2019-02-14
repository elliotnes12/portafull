<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<c:set var="action" value="Detalle" scope="request" />
<c:set var="formAction" value="${contextPath}/cliente/" scope="request" />

<div class="container">
	<ul class="breadcrumb">
	  <li><a href="#">Configuración</a> <span class="divider">/</span></li>
	  <li><a href="<c:url value="/cliente/" />">Clientes</a> <span class="divider">/</span></li>
	  <li class="active">Detalles</li>
	</ul>
    <style>
        #formCliente {
            /*height : 500px;*/
            left: 37%;
            margin: auto;
            max-width: 900px !important;width: 900px;}
        #formCliente .one-row label {display: inline-block;width: 110px;text-align: left;}
        #formCliente label.error {display: none;}
        .first-div-row {margin-top: 15px;}
        .modal .modal-body {max-height: 420px;overflow-y: auto;}
    </style>
	<jsp:include page="/WEB-INF/views/cliente/form.jsp" />	
</div>