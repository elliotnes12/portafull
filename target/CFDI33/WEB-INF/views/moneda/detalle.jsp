<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<c:set var="action" value="Detalle" scope="request" />
<c:set var="formAction" value="${contextPath}/moneda/" scope="request" />
<div class="container">
    <ul class="breadcrumb">
        <li><a href="#">Configuraci�n</a> <span class="divider">/</span></li>
        <li><a href="<c:url value="/moneda/" />">Monedas</a> <span class="divider">/</span></li>
        <li class="active">Detalles</li>
    </ul>
    <div style="margin: auto;max-width:480px">
        <jsp:include page="/WEB-INF/views/moneda/form.jsp" />
    </div>
</div>
