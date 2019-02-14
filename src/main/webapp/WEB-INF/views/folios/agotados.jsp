<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<div class="hero-unit">
  <h1>¡Folios agotados!</h1>
  <p>Sus folios han sido agotados. Realice una recontratación para seguir facturando.</p>
  <p><a target="_blank" href="${urlContratar}" class="btn btn-primary btn-large">Contratar</a></p>
</div>