<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#formMoneda {
	/*width: 480px !important;
	left: 37%;*/
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
		redirect('/CFDI33/moneda/');
	});

	/*$.get("<c:url value="/rest/grupoUsuario/listar/id" />" + $(this).val(), function(grupoUsuarios) {
		$.each(grupoUsuarios, function(index, value) {
			$('#grupo').append("<option value='" + value.id +"'>" + value.nombre +"</option>");
		});
	});*/

<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/moneda/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
<c:when test="${action == 'auditoria'}">
$('form').submit(function(){
	redirect('<c:url value="/auditoria/moneda/" />');
	return false;
});
bloquearFormulario();
</c:when>
</c:choose>

$.validator.addMethod("valueNotEquals", function(value, element, arg){
	  return arg != value;
}, "Debe seleccionar una opcion.");

$.validator.addMethod(
   "regex",
   function(value, element, regexp) {
       var re = new RegExp(regexp);
       return this.optional(element) || re.test(value);
   },
   "Ingrese un numero v·lido."
);
$.validator.addMethod(
		   "alfanumerico",
		   function(value, element, regexp) {
		       var re = new RegExp(regexp);
		       return this.optional(element) || re.test(value);
		   },
		   "Solo caracteres alfanumericos."
		);

$('#moneda').validate({
	rules: {
		clave: {
			required: true,
			clave: 'moneda',
			alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
		},
		nombreCorto: {
			required : true
		},
		tipoCambio:{
			required : true,
			number: true,
			regex : "^[0-9]+(\.([0-9]{1,4})?)?$"

		}
	}
});

});
</script>

<form:form commandName="moneda" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${moneda.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${moneda.clave}">
	<div id="formMoneda" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Moneda</h3>
		</div>
		<div  class="modal-body row-fluid">
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
					<form:input path="tipoCambio" class="input-prepend"/>
					<form:errors class="invalid" path="tipoCambio"/>
				</div>
				<div class="one-row">
					<form:label path="nombre">Nombre:</form:label>
					<form:input path="nombre"/>
					<form:errors class="invalid" path="nombre"/>
				</div>

		</div>
		<div class="modal-footer">
<c:choose>
<c:when test="${action == 'Detalle'}">
			<button type="submit" class="btn btn-primary">Regresar</button>
</c:when>
<c:when test="${action == 'auditoria'}">

</c:when>
<c:otherwise>
			<a href="#" class="btn close-editar" data-dismiss="modal">Cancelar</a>
			<button type="submit" class="btn btn-primary">Agregar</button>
</c:otherwise>
</c:choose>
		</div>
</div>
</form:form>
