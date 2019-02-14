<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<div class="hero-unit">
  <h1>Seleccionar Régimen Fiscal</h1>
  <p>Debe seleccionar su Régimen Fiscal, para poder continua.
  	<br>Si desconoce su Régimen Fiscal, por favor, <a target="_blank" href="http://www.sat.gob.mx/sitio_internet/asistencia_contribuyente/principiantes/comprobantes_fiscales/66_22080.html">
  	de clic en aquí.</a>
  	</p>
  <p><a href="<c:url value="/regimenFiscal" />" class="btn btn-primary btn-large">Seleccionar</a></p>
</div>