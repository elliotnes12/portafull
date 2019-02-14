<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#formParametro {
	width: 900px !important;
	left: 37%;
}

#formParametro .one-row label {
	display: inline-block;
	width: 85px;
	text-align: right;	 
}
#formParametro label.error {
	display: none;
}
.first-div-row {
	margin-top: 15px;
}
</style>

<script>
	
	
$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI/parametro/');
	});

	/*$.get("<c:url value="/rest/grupoUsuario/listar/id" />" + $(this).val(), function(grupoUsuarios) {
		$.each(grupoUsuarios, function(index, value) {
			$('#grupo').append("<option value='" + value.id +"'>" + value.nombre +"</option>");
		}); 
	});*/
	
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/parametro/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
</c:choose>
$.validator.addMethod(
		   "alfanumerico",
		   function(value, element, regexp) {
		       var re = new RegExp(regexp);
		       return this.optional(element) || re.test(value);
		   },
		   "Solo caracteres alfanumericos."
		);

$('#parametro').validate({
	rules: {
		clave: {
			required: true,
			clave: 'parametro',
			alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
		},
		nombre: {
			required : true,
			alfanumerico : "^([0-9a-zA-Z·ÈÌÛ˙¡…Õ”⁄—Ò ._-])+$"
		},
		valor: {
			required : true
		}
	}
});
	 
});
</script>

<form:form commandName="parametro" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${parametro.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${parametro.clave}">
	<div id="formParametro" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Par·metro</h3>
		</div>
		<div> 
				<div class="one-row first-div-row">
					<form:label path="clave">Clave:</form:label>
					<form:input path="clave"/>
					<form:errors class="invalid" path="clave"/>
				</div>
				<div class="one-row">
					<form:label path="nombre">Nombre:</form:label>
					<form:input path="nombre"/>
					<form:errors class="invalid" path="nombre"/>
				</div>
				<div class="one-row">
					<form:label path="valor">Valor:</form:label>
					<form:input path="valor"/>
					<form:errors class="invalid" path="valor"/>
				</div>
				<div class="one-row">
					<form:label path="descripcion">Descripcion:</form:label>
					<form:input path="descripcion"/>
					<form:errors class="invalid" path="descripcion"/>
				</div>
				
		</div>
		<div class="modal-footer">
<c:choose>
<c:when test="${action == 'Detalle'}">
			<button type="submit" class="btn btn-primary">Regresar</button>
</c:when>
<c:otherwise>
			<a href="#" class="btn close-editar" data-dismiss="modal">Cancelar</a>
			<button type="submit" class="btn btn-primary">Agregar</button>
</c:otherwise>
</c:choose>
		</div>
</div>
</form:form>		