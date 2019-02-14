<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#formClienteAnterior {
	width: 900px !important;
	left: 37%;
	height : 500px;
	overflow : auto;
}

#formClienteAnterior .one-row label {
	display: inline-block;
	width: 100px;
	text-align: right;	 
}
#formClienteAnterior label.error {
	display: none;
}
.first-div-row {
	margin-top: 15px;
}

.modal .modal-body {
    max-height: 420px;
    overflow-y: auto;
}
</style>

<script>
	
	
$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI/auditoria/cliente/');
	});

	/*$.get("<c:url value="/rest/grupoUsuario/listar/id" />" + $(this).val(), function(grupoUsuarios) {
		$.each(grupoUsuarios, function(index, value) {
			$('#grupo').append("<option value='" + value.id +"'>" + value.nombre +"</option>");
		}); 
	});*/
	
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/auditoria/cliente/" />');
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
        "Ingrese un RFC válido."
);

$('#clienteAnterior').validate({
	rules: {
		clave: {
			required: true,
			clave: 'cliente'
		},
		razonSocial: {
			required : true
		},
		contrasena: {
			required : true
		},
		password1: {
			required: true,
			equalTo: "#contrasena"
		},
		rfc: {
			required : true,
			regex : "[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
		},
		pais: {
			required : true,
			valueNotEquals: "default"
		},
		estado: {
			required : true,
			valueNotEquals: "default"
		},
		codigoPostal: {
			required : true
		},
		email1: {
			required : true, 
			email : true
		} 
	}
});
	 
});
</script>

<form:form commandName="clienteAnterior" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${cliente.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${cliente.clave}">
	<div id="formClienteAnterior" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Auditoria Cliente</h3>
		</div>
		<div> 
		<div class="one-row first-div-row">
			<form:label path="clave">Clave:</form:label>
			<form:input path="clave" id="clave"/>
			<form:errors class="invalid" path="clave" />
			<form:label path="razonSocial">Razon Social:</form:label>
			<form:input path="razonSocial" id="razonSocial"/>
			<form:errors class="invalid" path="razonSocial" />
		</div>
		<div class = "one-row">
			<form:label path="rfc">R.F.C:</form:label>
			<form:input path="rfc"/>
			<form:errors class="invalid" path="rfc" />
		</div>
		<div class="one-row">
			<form:label path="pais">Residencia Fiscal:</form:label>
			<form:select path="pais" id="residenciaFiscal" name="residenciaFiscal">
					<form:option value="default"> Seleccione </form:option>
					<form:option value="Mexico">Mexico</form:option>
			</form:select>
			<form:errors class="invalid" path="residenciaFiscal" />
		</div>
		<div class="one-row">
			<form:label path="email">Email:</form:label>
			<form:input path="email" id="email1"/>
			<form:errors class="invalid" path="email" />
		</div>
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
</form:form>		