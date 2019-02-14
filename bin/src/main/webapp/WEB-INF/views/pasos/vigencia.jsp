<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<div class="hero-unit">
  <h1>Su plan ha vencido.</h1>
  <p>La vigencia de un a&ntilde;o de su plan contratado ha caducado, necesita realizar una recompra para continuar.</p>
  <p>&Uacute;ltima compra: <b>${param.vigencia}</b></p>
  <p>Contactar con agente</p>
  <ul style="list-style-type: none;">
  	<li><b>Nombre: </b>${Nombre}</li>
  	<li><b>Tel&eacute;fono: </b>${Telefono}</li>
  	<li><b>Email: </b>${Email}</li>
  </ul>
</div>