<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<c:set var="action" value="Detalle" scope="request" />
<c:set var="formAction" value="${contextPath}/unidad/" scope="request" />
<div class="container">
    <ul class="breadcrumb">
        <li><a href="#">Configuración</a> <span class="divider">/</span></li>
        <li><a href="<c:url value="/unidad/" />">Unidad</a> <span class="divider">/</span></li>
        <li class="active">Detalles</li>
    </ul>
    <div style="margin: auto;width: 480px">
        <jsp:include page="/WEB-INF/views/unidad/form.jsp" />
    </div>
</div>
