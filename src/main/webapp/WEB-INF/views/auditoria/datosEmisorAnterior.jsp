<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#btnAdd {
	padding-bottom: 10px;
}

#formDatosEmisor {
	width: 1200px !important;
	left: 37%;
}

#formDatosEmisor .one-row label {
	display: inline-block;
	width: 85px;
	text-align: right;	 
}
#formDatosEmisor label.error {
	display: none;
}
.first-div-row {
	margin-top: 15px;
}

</style>

<script>
$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI/datosEmisor/');
	});

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
	
$('#datosEmisor').validate({
	rules: {
		rfc: {
			required: true,
			regex: '[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?'
		},
		tipoPersona: {
			required: true,
			valueNotEquals: "0"
			},
		calle: {
			required: true,
			},
		pais: {
			required : true,
			valueNotEquals: "0"
			},
		estado: {
			required : true,
			valueNotEquals: "0"
			},
		codigoPostal: {
			required : true
			},
		delegacionMunicipio: {
			required : true
			},
	}
});
});
</script>
<form:form commandName="datosAnterior" action="${formAction}" enctype="multipart/form-data" method="POST">
	<input type="hidden" name="id" id="id" value="${datosEmisor.id}">
	
	<div id="formDatosEmisor" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Datos del Emisor</h3>
		</div>

		<div class="modal-body">
			<div class="one-row first-div-row">
				<form:hidden path="id" class="input-small" />

				<form:label path="razonSocial" >Razón social:</form:label>
				<form:input path="razonSocial" class="input-xlarge"/>
				<form:errors path="razonSocial"/>
				
				<form:label path="rfc" >R.F.C.:</form:label>
				<form:input path="rfc" class="input-large"/>
				<form:errors path="rfc"/>
				
				<form:label path="tipoPersona" >Tipo:</form:label>
				<form:select path="tipoPersona">
					<form:option value="0">Seleccionar</form:option>
					<form:option value="1">Persona Fisica</form:option>
					<form:option value="2">Persona Moral</form:option>
				</form:select>
				<form:errors path="tipoPersona"/>	
			</div>
			<div class="one-row">
				<form:label path="calle" >Calle:</form:label>
				<form:input path="calle" class="input-xlarge"/>
				<form:errors path="calle"/>
				
				<form:label path="noExterior" >No.Exterior:</form:label>
				<form:input path="noExterior" class="input-small"/>
				<form:errors path="noExterior"/>
				
				<form:label path="noInterior" >No.Interior:</form:label>
				<form:input path="noInterior" class="input-small"/>
				<form:errors path="noInterior"/>
				
				<form:label path="codigoPostal">Código Postal:</form:label>
				<form:input path="codigoPostal" class="input-small"/>
				<form:errors path="codigoPostal"/>
			</div>
			<div class="one-row">
				<form:label path="colonia" >Colonia:</form:label>
				<form:input path="colonia" class="input-xlarge"/>
				<form:errors path="colonia"/>
				
				<form:label path="delegacionMunicipio" >Delegación/Municipio:</form:label>
				<form:input path="delegacionMunicipio" class="input-xlarge"/>
				<form:errors path="delegacionMunicipio"/>
				
				<form:label path="ciudad" >Ciudad:</form:label>
				<form:input path="ciudad" class="input-xlarge"/>
				<form:errors path="ciudad"/>
			</div>
			<div class="one-row">
				
				<form:label path="estado" >Estado:</form:label>
				<form:select path="estado">
					<form:option value="0">Seleccionar</form:option>
					<form:option value="1">Puebla</form:option>
				</form:select>
				<form:errors path="estado"/>
				
				<form:label path="referencia" >Referencia:</form:label>
				<form:input path="referencia" class="input-xlarge"/>
				<form:errors path="referencia"/>
				
				<form:label path="pais" >País:</form:label>
				<form:select path="pais">
					<form:option value="0">Seleccionar</form:option>
					<form:option value="1">México</form:option>
				</form:select>
				<form:errors path="pais"/>
			</div>
			<div class="one-row">
				<form:label path="telefono1" >Télefono 1:</form:label>
				<form:input path="telefono1" class="input-medium"/>
				<form:errors path="telefono1"/>
				
				<form:label path="telefono2" >Télefono 2:</form:label>
				<form:input path="telefono2" class="input-medium"/>
				<form:errors path="telefono2"/>
				
				<form:label path="fax" >Fax:</form:label>
				<form:input path="fax" class="input-medium"/>
				<form:errors path="fax"/>
			</div>
			<div class="one-row">
				<form:label path="email" >Correo electrónico:</form:label>
				<form:input path="email" class="input-xlarge" id="email1"/>
				<form:errors path="email"/>
				
				<form:label path="logo" >Seleccione el logo:</form:label>
				<input type="file" name="archivo"/>
			</div>
			<div class="one-row">
				<form:label path="comentarios" >Comentarios:</form:label>
				<form:textarea path="comentarios" class="input-xxlarge"/>
				<form:errors path="comentarios"/>
			</div>
			<div class="one-row">
				<form:label path="triggerActivadoPor" >Activado Por:</form:label>
				<form:textarea path="triggerActivadoPor" class="input-medium"/>
				<form:errors path="triggerActivadoPor"/>
			</div>
			<div class="one-row">
				<form:label path="accionRealizada" >Accion Realizada:</form:label>
				<form:textarea path="accionRealizada" class="input-medium"/>
				<form:errors path="accionRealizada"/>
			</div>
			<div class="one-row">
				<form:label path="ultimaActualizacion" >Ultima Actualizacion:</form:label>
				<form:textarea path="ultimaActualizacion" class="input-medium"/>
				<form:errors path="ultimaActualizacion"/>
			</div>
			
		</div>
	</div>
</form:form>

