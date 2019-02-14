<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#formPlantilla {
	left: 37%;
	margin: auto;
	width: 90%;
}

#formPlantilla input, #formPlantilla select{
		height: initial;
		width: 100%;
	}
#formPlantilla label.error {
	display: none;
}
#formPlantilla h5{
	text-align:center;
}
#formPlantilla img{
	width:80px;
	height:80px;
}
.first-div-row {
	margin-top: 15px;
}

</style>

<script>
$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI33/login/inicio');
	});

<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/plantilla/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
</c:choose>

$('#plantilla').validate({
	rules: {
		factura: {
			required : true
		},
		notaCredito: {
			required : true
		},
		notaCargo: {
			required : true
		},
		reciboHonorarios: {
			required : true
		}
	}
});
});
</script>


<c:if test="${msg != null}">
<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  ${msg}
</div>
</c:if>


<form:form commandName="plantilla" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${plantilla.id}">

		<div id="formPlantilla" class="${action eq 'Agregar' ? 'modal hide' : ''}">
			<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Plantilla</h3>
		</div>

		<div class="modal-body">
			<div class="row-fluid">
				<form:hidden path="id" class="input-small" />
				<div class="span5" style="margin-left: 0;">
					<div class="span5"><form:label path="factura">Factura:</form:label></div>
					<div class="span7">
						<form:select path="factura">
							<optgroup label="Sin Claves">
								<form:option value="1">Plantilla 1</form:option>
								<form:option value="2">Plantilla 2</form:option>
								<form:option value="3">Plantilla 3</form:option>
								<form:option value="4">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Con Claves">
								<form:option value="5">Plantilla 1</form:option>
								<form:option value="6">Plantilla 2</form:option>
								<form:option value="7">Plantilla 3</form:option>
								<form:option value="8">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Sin Claves">
								<form:option value="9">Plantilla 1</form:option>
								<form:option value="10">Plantilla 2</form:option>
								<form:option value="11">Plantilla 3</form:option>
								<form:option value="12">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Con Claves">
								<form:option value="13">Plantilla 1</form:option>
								<form:option value="14">Plantilla 2</form:option>
								<form:option value="15">Plantilla 3</form:option>
								<form:option value="16">Plantilla 4</form:option>
							</optgroup>
							<c:forEach var="plantillaValor" items="${plantillas}">
								<option ${plantilla.factura eq plantillaValor.id ? 'selected' : ''} value="${plantillaValor.id}">${plantillaValor.nombre}
								</option>
							</c:forEach>
						</form:select>
						<form:errors path="factura"/>
					</div>
				</div>
				<div class="span5">
					<div class="span5"><form:label path="notaCargo">Nota de Cargo:</form:label></div>
					<div class="span7">
						<form:select path="notaCargo">
							<optgroup label="Sin Claves">
								<form:option value="1">Plantilla 1</form:option>
								<form:option value="2">Plantilla 2</form:option>
								<form:option value="3">Plantilla 3</form:option>
								<form:option value="4">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Con Claves">
								<form:option value="5">Plantilla 1</form:option>
								<form:option value="6">Plantilla 2</form:option>
								<form:option value="7">Plantilla 3</form:option>
								<form:option value="8">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Sin Claves">
								<form:option value="9">Plantilla 1</form:option>
								<form:option value="10">Plantilla 2</form:option>
								<form:option value="11">Plantilla 3</form:option>
								<form:option value="12">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Con Claves">
								<form:option value="13">Plantilla 1</form:option>
								<form:option value="14">Plantilla 2</form:option>
								<form:option value="15">Plantilla 3</form:option>
								<form:option value="16">Plantilla 4</form:option>
							</optgroup>
							<c:forEach var="plantillaValor" items="${plantillas}">
								<option ${plantilla.notaCargo eq plantillaValor.id ? 'selected' : ''} value="${plantillaValor.id}">${plantillaValor.nombre}
								</option>
							</c:forEach>
						</form:select>
						<form:errors path="notaCargo"/>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<div class="span5"><form:label path="notaCredito">Nota de Cr&eacute;dito:</form:label></div>
					<div class="span7">
						<form:select path="notaCredito">
							<optgroup label="Sin Claves">
								<form:option value="1">Plantilla 1</form:option>
								<form:option value="2">Plantilla 2</form:option>
								<form:option value="3">Plantilla 3</form:option>
								<form:option value="4">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Con Claves">
								<form:option value="5">Plantilla 1</form:option>
								<form:option value="6">Plantilla 2</form:option>
								<form:option value="7">Plantilla 3</form:option>
								<form:option value="8">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Sin Claves">
								<form:option value="9">Plantilla 1</form:option>
								<form:option value="10">Plantilla 2</form:option>
								<form:option value="11">Plantilla 3</form:option>
								<form:option value="12">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Con Claves">
								<form:option value="13">Plantilla 1</form:option>
								<form:option value="14">Plantilla 2</form:option>
								<form:option value="15">Plantilla 3</form:option>
								<form:option value="16">Plantilla 4</form:option>
							</optgroup>
							<c:forEach var="plantillaValor" items="${plantillas}">
								<option ${plantilla.notaCredito eq plantillaValor.id ? 'selected' : ''} value="${plantillaValor.id}">${plantillaValor.nombre}
								</option>
							</c:forEach>
						</form:select>
						<form:errors path="notaCredito"/>
					</div>
				</div>
				<div class="span5">
					<div class="span5"><form:label path="reciboHonorarios">Recibo de Honorarios:</form:label></div>
					<div class="span7">
						<form:select path="reciboHonorarios">
							<optgroup label="Sin Claves">
								<form:option value="1">Plantilla 1</form:option>
								<form:option value="2">Plantilla 2</form:option>
								<form:option value="3">Plantilla 3</form:option>
								<form:option value="4">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Con Claves">
								<form:option value="5">Plantilla 1</form:option>
								<form:option value="6">Plantilla 2</form:option>
								<form:option value="7">Plantilla 3</form:option>
								<form:option value="8">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Sin Claves">
								<form:option value="9">Plantilla 1</form:option>
								<form:option value="10">Plantilla 2</form:option>
								<form:option value="11">Plantilla 3</form:option>
								<form:option value="12">Plantilla 4</form:option>
							</optgroup>
							<optgroup label="Similar Con Claves">
								<form:option value="13">Plantilla 1</form:option>
								<form:option value="14">Plantilla 2</form:option>
								<form:option value="15">Plantilla 3</form:option>
								<form:option value="16">Plantilla 4</form:option>
							</optgroup>
							<c:forEach var="plantillaValor" items="${plantillas}">
								<option ${plantilla.reciboHonorarios eq plantillaValor.id ? 'selected' : ''} value="${plantillaValor.id}">${plantillaValor.nombre}
								</option>
							</c:forEach>
						</form:select>
						<form:errors path="reciboHonorarios"/>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span5">
					<div class="span5"><form:label path="factura">Carta Porte:</form:label></div>
					<div class="span7">
						<form:select path="cartaPorte">
								<form:option value="500">Plantilla Carta Porte</form:option>
								<c:forEach var="plantillaValor" items="${plantillas}">
									<option ${plantilla.cartaPorte eq plantillaValor.id ? 'selected' : ''} value="${plantillaValor.id}">${plantillaValor.nombre}
									</option>
								</c:forEach>
							</form:select>
						<form:errors path="factura"/>
					</div>
				</div>
				<div class="span5">
					<div class="span5"><form:label path="nomina">N&oacute;mina:</form:label></div>
					<div class="span7">
						<form:select path="nomina">
							<form:option value="200">Plantilla N&oacute;mina</form:option>
							<c:forEach var="plantillaValor" items="${plantillas}">
								<option ${plantilla.nomina eq plantillaValor.id ? 'selected' : ''} value="${plantillaValor.id}">${plantillaValor.nombre}
								</option>
							</c:forEach>
						</form:select>
						<form:errors path="nomina"/>
					</div>
				</div>
			</div>
			<div class="one-row">
			<ul class="thumbnails">
			  <li class="span2">
			  <div class="thumbnail">
				    <a href="<c:url value="/static/resources/pdf/xpd/plantilla1.pdf"/>" class="thumbnail">
				      <img src="<c:url value="/static/resources/img/iconoPlantilla.png"/>">
				     </a>
				     <h5>Plantilla 1</h5>
			     </div>
			  </li>
			  <li class="span2">
			  <div class="thumbnail">
				    <a href="<c:url value="/static/resources/pdf/xpd/plantilla2.pdf"/>" class="thumbnail">
				      <img src="<c:url value="/static/resources/img/iconoPlantilla.png"/>">
				     </a>
				     <h5>Plantilla 2</h5>
			     </div>
			  </li>
			  <li class="span2">
			  <div class="thumbnail">
				    <a href="<c:url value="/static/resources/pdf/xpd/plantilla3.pdf"/>" class="thumbnail">
				      <img src="<c:url value="/static/resources/img/iconoPlantilla.png"/>">
				     </a>
				     <h5>Plantilla 3</h5>
			     </div>
			     <li class="span2">
			  <div class="thumbnail">
				    <a href="<c:url value="/static/resources/pdf/xpd/plantilla4.pdf"/>" class="thumbnail">
				      <img src="<c:url value="/static/resources/img/iconoPlantilla.png"/>">
				     </a>
				     <h5>Plantilla 4</h5>
			     </div>
			  </li>
			</ul>

			</div>
		</div>
		<div class="modal-footer">
		<c:choose>
<c:when test="${action == 'Detalle'}">
			<button type="submit" class="btn btn-primary">Regresar</button>
</c:when>
<c:otherwise>
			<a href="#" class="btn close-editar" data-dismiss="modal">Cancelar</a>
			<button type="submit" class="btn btn-primary">Cargar</button>
</c:otherwise>
</c:choose>

		</div>
	</div>
</form:form>
