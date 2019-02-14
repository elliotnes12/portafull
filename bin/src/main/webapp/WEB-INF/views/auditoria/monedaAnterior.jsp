<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#formMoneda {
	width: 900px !important;
	left: 37%;
}

#formMoneda .one-row label {
	display: inline-block;
	width: 85px;
	text-align: right;	 
}
#formMoneda label.error {
	display: none;
}
.first-div-row {
	margin-top: 15px;
}
</style>

<script>
	
	
$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI/auditoria/moneda');
	});

	/*$.get("<c:url value="/rest/grupoUsuario/listar/id" />" + $(this).val(), function(grupoUsuarios) {
		$.each(grupoUsuarios, function(index, value) {
			$('#grupo').append("<option value='" + value.id +"'>" + value.nombre +"</option>");
		}); 
	});*/
	
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/auditoria/moneda/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
</c:choose>

$('#moneda').validate({
	rules: {
		clave: {
			required: true,
			clave: 'moneda'
		},
		nombreCorto: {
			required : true
		}
	}
});
	 
});
</script>

<form:form commandName="monedaAnterior" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${moneda.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${moneda.clave}">
	<div id="formMoneda" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Moneda</h3>
		</div>
		<div> 
				<div class="one-row first-div-row">
					<form:label path="clave">Clave:</form:label>
					<form:input path="clave"/>
					<form:errors class="invalid" path="clave"/>
				</div>
				<div class="one-row">
					<form:label path="nombreCorto">Nombre Corto:</form:label>
					<form:input path="nombreCorto"/>
					<form:errors class="invalid" path="nombreCorto"/>
				</div>
				<div class="one-row">
					<form:label path="tipoCambio">Tipo de Cambio:</form:label>
					<form:input path="tipoCambio"/>
					<form:errors class="invalid" path="tipoCambio"/>
				</div>
				<div class="one-row">
					<form:label path="nombre">Nombre:</form:label>
					<form:input path="nombre"/>
					<form:errors class="invalid" path="nombre"/>
				<div class="one-row">
					<form:label path="triggerActivadoPor">Activado Por:</form:label>
					<form:input path="triggerActivadoPor"/>
					<form:errors class="invalid" path="triggerActivadoPor"/>
				</div>
				</div>
				<div class="one-row">
					<form:label path="accionRealizada">Accion Realizada:</form:label>
					<form:input path="accionRealizada"/>
					<form:errors class="invalid" path="accionRealizada"/>
				</div>
				<div class="one-row">
					<form:label path="ultimaActualizacion">Ultima Actualizacion:</form:label>
					<form:input path="ultimaActualizacion"/>
					<form:errors class="invalid" path="ultimaActualizacion"/>
				</div>
				
		</div>
</div>
</form:form>		