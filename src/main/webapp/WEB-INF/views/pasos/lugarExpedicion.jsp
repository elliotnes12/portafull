<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<div class="hero-unit">
  <h1>Seleccionar Lugar Expedición.</h1>
  <p>Debe seleccionar su Lugar de Expedición, para poder continuar.
  <p><a href="<c:url value="/lugarExpedicion" />" class="btn btn-primary btn-large">Seleccionar</a></p>
</div>