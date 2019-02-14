<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#formLugar {
	width: 900px !important;
	left: 37%;
	height : 500px;
	overflow : auto;
}

#formLugar .one-row label {
	display: inline-block;
	width: 100px;
	text-align: right;	 
}
#formLugar label.error {
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
		redirect('/CFDI/auditoria/lugarEmision/');
	});
	
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/auditoria/lugarEmision/" />');
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

$('#lugar').validate({
	rules: {
		clave: {
			required: true,
			clave: 'lugarEmision'
		},
		nombre: {
			required : true
		},
		calle: {
			required : true
		},
		colonia: {
			required : true
		},
		municipio: {
			required : true
		},
		pais: {
			required : true,
			valueNotEquals: "default"
		},
		estado: {
			required : true,
			valueNotEquals: "default"
		},
		ciudad: {
			required : true
		},
		email: {
			required : true, 
			email : true
		} 
	}
});
	 
});
</script>

<form:form commandName="lugarAnterior" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${lugar.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${lugar.clave}">
	<div id="formLugar" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Lugar de Emision</h3>
		</div>
		<div class="first-div-row one-row">
			<form:label path="clave">Clave:</form:label>
			<form:input path="clave" class="input-small"/>
			<form:errors class="invalid" path="clave"/>
			<form:label path="nombre">Nombre:</form:label>
			<form:input path="nombre"/>
			<form:errors class="invalid" path="nombre"/>
		</div>
		<div class = "one-row">
			<form:label path="calle">Calle:</form:label>
			<form:input path="calle"/>
			<form:errors class="invalid" path="calle"/>
			<form:label path="numeroExterior">No. Exterior:</form:label>
			<form:input path="numeroExterior" class="input-small"/>
			<form:errors class="invalid" path="numeroExterior"/>
			<form:label path="numeroInterior">No. Interior:</form:label>
			<form:input path="numeroInterior" class="input-small"/>
			<form:errors class="invalid" path="numeroInterior"/>
		</div>
		<div class="one-row">
			<form:label path="colonia">Colonia:</form:label>
			<form:input path="colonia"/>
			<form:errors class="invalid" path="colonia"/>
			<form:label path="codigoPostal">Codigo Postal:</form:label>
			<form:input path="codigoPostal"/>
			<form:errors class="invalid" path="codigoPostal"/>
		</div>
		<div class="one-row">
			<form:label path="referencia">Referencia:</form:label>
			<form:input path="referencia"/>
			<form:errors class="invalid" path="referencia"/>
			<form:label path="estado">Estado:</form:label>
			<form:select path="estado">
				<form:option value="default"> Seleccione </form:option>
				<form:option value="Puebla">Puebla</form:option>
			</form:select> 
			<form:errors class="invalid" path="estado"/>
		</div>			
		<div class="one-row">
			<form:label path="municipio">Deleg/Municipio:</form:label>
			<form:input path="municipio"/>
			<form:errors class="invalid" path="municipio"/>
			<form:label path="pais">Pais:</form:label>
			<form:select path="pais">
				<form:option value="default"> Seleccione </form:option>
				<form:option value="Mexico">Mexico</form:option>
			</form:select> 
			<form:errors class="invalid" path="pais"/>
		</div>
		<div class="one-row">
			<form:label path="ciudad">Ciudad:</form:label>
			<form:input path="ciudad"/>
			<form:errors class="invalid" path="ciudad"/>
		</div>
		<div class="one-row">
			<form:label path="telefono">Telefono:</form:label>
			<form:input path="telefono"/>
			<form:errors class="invalid" path="telefono"/>
			<form:label path="email">Email:</form:label>
			<form:input path="email"/>
			<form:errors class="invalid" path="email"/>
		</div>
		<div class="one-row">
			<form:label path="triggerActivadoPor">Activado Por:</form:label>
			<form:input path="triggerActivadoPor"/>
			<form:errors class="invalid" path="triggerActivadoPor"/>
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