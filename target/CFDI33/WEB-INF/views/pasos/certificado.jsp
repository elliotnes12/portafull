<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<div class="hero-unit">
  <h1>Cargar Certificado Sello Digital.</h1>
  <p>Debe cargar su Certificado de Sello Digital. <br> Si tiene dudas de donde obtenerlo, por favor 
  <a target="_blank" href="http://www.sat.gob.mx/informacion_fiscal/factura_electronica/Paginas/tramite_csd.aspx">de clic aquí.</a></p>
  <p><a href="<c:url value="/csd/" />" class="btn btn-primary btn-large">Cargar CSD</a></p>
</div>