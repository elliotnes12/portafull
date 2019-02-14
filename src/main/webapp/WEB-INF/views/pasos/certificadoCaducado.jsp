<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<div class="hero-unit">
  <h1>Su Certificado Sello Digital ha caducado.</h1>
  <p>Debe generar y cargar un nuevo Certificado de Sello Digital. <br> Si tiene dudas de donde obtenerlo, por favor 
  <a target="_blank" href="http://www.sat.gob.mx/sitio_internet/e_sat/comprobantes_fiscales/15_15564.html">de clic aquí.</a></p>
  <p><a href="<c:url value="/csd/" />" class="btn btn-primary btn-large">Cargar nuevo CSD</a></p>
</div>