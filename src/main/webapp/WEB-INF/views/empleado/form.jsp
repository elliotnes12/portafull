<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value="/static/resources/css/cfdi.css"/>">
	<link rel="stylesheet" href="<c:url value="/static/resources/css/redmond/jquery-ui-1.10.3.custom.min.css"/>">
	<script src="/CFDI33/static/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
  
  	
<style>
#formEmpleado {
	left: 37%;
	max-width: 900px !important;
	/*height : 500px;*/
	width: 90%;
}

#formEmpleado input, #formEmpleado select{
	height: initial;
	width: 100%;
}
#formEmpleado div.one-row{
	clear: both;
}
#formEmpleado label.error {
	display: none;
}
.first-div-row {
	margin-top: 15px;
}
.modal .modal-body {
    max-height: 420px;
    overflow-y: auto;
</style>


<script>
$(function() {
    $( "#datepicker" ).datepicker({ dateFormat : 'yy-mm-dd' });
  });
  
$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI33/empleado/');
	});

	cancelKeyPipe("#numEmpleado");
	cancelKeyPipe("#departamento");
	cancelKeyPipe("#puesto");
	<c:choose>
	<c:when test="${action == 'Detalle'}">
		$('form').submit(function(){
			redirect('<c:url value="/empleado/" />');
			return false;
		});
		bloquearFormulario();
	</c:when>
	<c:when test="${action == 'auditoria'}">
	$('form').submit(function(){
		redirect('<c:url value="/auditoria/empleado/" />');
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

	$.validator.addMethod(
	        "regexCurp",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "Ingrese un CURP válido."
	);
	
	$.validator.addMethod(
	        "numero",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "Ingrese un número válido."
	);

	$.validator.addMethod(
	        "antig",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "El valor no corresponde con el patrón necesario."
	);

	$.validator.addMethod("numeroDec", function(value, element,	regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
  	}, "Ingrese un n\u00famero Decimal v\u00e1lido.");

	
	$('#rfc').change( function() {
		if($('#rfc').val() != ""){
			$('#contrasena').rules("add",{
				norfc : "^((?!"+ document.getElementById('rfc').value + ")[0-9a-zA-ZñÑ#$*@_])+$",
				unaMayus : "([A-Z])+",
				unEsp : "([#$*@_])+",
				minlength : 13,
				maxlength : 13
				})
		}
	});
	$('#email').change(function() {
		var patt=/^([\w+-.%]+@[\w-.]+\.[A-Za-z]{2,4})+$/g;
		var result=patt.test($('#email').val());
		if (!result) {
			alert("Email no válido.")
			$('#email').focus();
		}
	});
	$("input").on('keydown', function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
	
	<c:choose>
	<c:when test="${action == 'Agregar'}">
	$('#empleado').validate({
		rules: {
			curp:{
				required: true,
				regexCurp : "[A-Z][AEIOUX][A-Z]{2}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[MH]([ABCMTZ]S|[BCJMOT]C|[CNPST]L|[GNQ]T|[GQS]R|C[MH]|[MY]N|[DH]G|NE|VZ|DF|SP)[BCDFGHJ-NP-TV-Z]{3}[0-9A-Z][0-9]?",
				minlength : 18,
				maxlength : 18
			},
			numSeguridadSocial:{
				numero : "^([0-9]{1,15})?$"
			},
			antiguedad:{
				required: false,
				antig : "^P(([1-9][0-9]{0,3})|[0])W|P(([1-9][0-9]?Y)?([1-9]|1[012])M)?([0]|[1-9]|[12][0-9]|3[01])D?"
			},
			tipoContrato:{
				required : true,
				valueNotEquals: "default"
			},
			tipoRegimen:{
				required : true,
				valueNotEquals: "default"
			},	
			numEmpleado: {
				required: true,
				maxlength : 15
			},
			periodicidadPago:{
				required: true,
				valueNotEquals: "default"
				},
			rfc: {
				required : true,
				regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?",
				minlength : 13,
				maxlength : 13
			},
			claveEntFed:{
				required: true,
				valueNotEquals: "default"
			},
			salarioBaseCotApor:{
				required : false,
				numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
			},
			cuentaBancaria:{
				required: false,
				numero : "[0-9]{10,18}?$"
			},
			salarioDiarioIntegrado:{
				required : false,
				numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
			},
			numDiasPagados:{
				required : true,
				numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
				},
			usoCFDI:{
				required: true,
				valueNotEquals: "default"
				},
			fechaInicioRelLaboral:{
				antig : "^[0-9]{4}-[0-9]{2}-[0-9]{2}?$"
				}	
			
		}
	});
	</c:when>
	<c:when test="${action == 'Editar'}">
	$('#empleado').validate({
		rules: {
			curp:{
				required: true,
				regexCurp : "[A-Z][AEIOUX][A-Z]{2}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[MH]([ABCMTZ]S|[BCJMOT]C|[CNPST]L|[GNQ]T|[GQS]R|C[MH]|[MY]N|[DH]G|NE|VZ|DF|SP)[BCDFGHJ-NP-TV-Z]{3}[0-9A-Z][0-9]?",
				minlength : 18,
				maxlength : 18
			},
			numSeguridadSocial:{
				numero : "^[0-9]{1,15}?$"
			},
			antiguedad:{
				required: false,
				antig : "^P(([1-9][0-9]{0,3})|[0])W|P(([1-9][0-9]?Y)?([1-9]|1[012])M)?([0]|[1-9]|[12][0-9]|3[01])D?"
			},
			tipoContrato:{
				required : true,
				valueNotEquals: "default"
			},
			tipoRegimen:{
				required : true,
				valueNotEquals: "default"
			},
			numEmpleado: {
				required: true,
				maxlength : 15
			},
			periodicidadPago:{
				required: true,
				valueNotEquals: "default"
			},
			rfc: {
				required : true,
				regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?",
				minlength : 13,
				maxlength : 13
			},
			claveEntFed:{
				required: true,
				valueNotEquals: "default"
			},
			salarioBaseCotApor:{
				required : false,
				numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
			},
			cuentaBancaria:{
				required: false,
				numero : "[0-9]{10,18}?$"
			},
			salarioDiarioIntegrado:{
				required : false,
				numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
			},
			numDiasPagados:{
				required : true,
				numeroDec  : "^(([1-9][0-9]{0,3})|[0])(.[0-9]{3})?$"
				},
			usoCFDI:{
				required: true,
				valueNotEquals: "default"
				},
			fechaInicioRelLaboral:{
				antig : "^[0-9]{4}-[0-9]{2}-[0-9]{2}?$"
				}
		}
	
	});
	</c:when>
	</c:choose>


		 
	});	
</script>
<style>
	#empleado input, #empleado select{
		height: initial;
		width: 100%;
	}
</style>
<form:form commandName="empleado" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${empleado.id}">
	<div id="formEmpleado" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Empleado</h3>
		</div>
		<div class="modal-body">
			<br/>
			<div class="one-row first-div-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="nombre">Nombre:</form:label>
					</div>
					<div class="span7">
						<form:input path="nombre" id="nombre"/>
						<form:errors class="invalid" path="nombre" />
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="rfc" class="required">R.F.C:</form:label>
					</div>
					<div class="span7">
						<form:input path="rfc" id="rfc" maxlength="13"/>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="numEmpleado" class="required">N&uacute;mero de Empleado:</form:label>
					</div>
					<div class="span7">
						<form:input path="numEmpleado"/>
						<form:errors class="invalid" path="numEmpleado" />
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="curp" class="required">CURP:</form:label>
					</div>
					<div class="span7">
						<form:input path="curp" maxlength="18"/>
						<form:errors class="invalid" path="curp" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="departamento">Departamento:</form:label>
					</div>
					<div class="span7">
						<form:input path="departamento" id="departamento"/>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="tipoRegimen" class="required">Tipo R&eacute;gimen:</form:label>
					</div>
					<div class="span7">
						<form:select path="tipoRegimen" id="tipoRegimen">
							<option value="default">Seleccionar</option>
							<c:forEach items="${regimenContratacion}" var="regimenContratacion" >
								<option value="${regimenContratacion.clave}" ${empleado.tipoRegimen eq regimenContratacion.clave ? 'selected':''}>${regimenContratacion.nombre}</option>
							</c:forEach>
						</form:select>
						<form:errors class="invalid" path="tipoRegimen" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="numSeguridadSocial">No. Seguridad Social:</form:label>
					</div>
					<div class="span7">
						<form:input path="numSeguridadSocial" maxlength = "15"/>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="numDiasPagados" class="required">No. D&iacute;as Pagados:</form:label>
					</div>
					<div class="span7">
						<form:input path="numDiasPagados" maxlength = "8"/>
						<form:errors class="invalid" path="numDiasPagados" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="cuentaBancaria">Cuenta Bancaria:</form:label>
					</div>
					<div class="span7">
						<form:input path="cuentaBancaria" id="cuentaBancaria" maxlength = "18"/>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="banco">Banco:</form:label>
					</div>
					<div class="span7">
						<form:select path="banco" id="banco">
							<option value="default">Seleccionar</option>
							<c:forEach items="${banco}" var="banco" >
								<option value="${banco.clave}" ${empleado.banco eq banco.clave ? 'selected':''}>${banco.nombre}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="fechaInicioRelLaboral">Fecha Inicio Relaci&oacute;n Laboral:</form:label>
					</div>
					<div class="span7">
						<form:input path="fechaInicioRelLaboral" type="text" id="datepicker"/>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="antiguedad">Antig&uuml;edad:</form:label>
					</div>
					<div class="span7">
						<form:input path="antiguedad" id="antiguedad" maxlength = "9"/>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="puesto">Puesto:</form:label>
					</div>
					<div class="span7">
						<form:input path="puesto" id="puesto" maxlength = "100"/>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="riesgoPuesto">Riesgo Puesto:</form:label>
					</div>
					<div class="span7">
						<form:select path="riesgoPuesto" id="riesgoPuesto">
							<option value="default">Seleccionar</option>
							<c:forEach items="${riesgoPuesto}" var="riesgoPuesto" >
								<option value="${riesgoPuesto.clave}" ${empleado.riesgoPuesto eq riesgoPuesto.clave ? 'selected':''}>${riesgoPuesto.nombre}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="tipoJornada">Tipo de Jornada:</form:label>
					</div>
					<div class="span7">
						<form:select path="tipoJornada" id="tipoJornada">
							<option value="default">Seleccionar</option>
							<c:forEach items="${tipoJornada}" var="tipoJornada" >
								<option value="${tipoJornada.clave}" ${empleado.tipoJornada eq tipoJornada.clave ? 'selected':''}>${tipoJornada.nombre}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="tipoContrato" class="required">Tipo de Contrato:</form:label>
					</div>
					<div class="span7">
						<form:select path="tipoContrato" id="tipoContrato">
							<option value="default">Seleccionar</option>
							<c:forEach items="${tipoContrato}" var="tipoContrato" >
								<option value="${tipoContrato.clave}" ${empleado.tipoContrato eq tipoContrato.clave ? 'selected':''}>${tipoContrato.nombre}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="salarioBaseCotApor">Salario Base de Cotizaci&oacute;n de Aportes:</form:label>
					</div>
					<div class="span7">
						<form:input path="salarioBaseCotApor" maxlength = "21"/>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="salarioDiarioIntegrado">Salario Diario Integrado:</form:label>
					</div>
					<div class="span7">
						<form:input path="salarioDiarioIntegrado" maxlength = "21"/>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="periodicidadPago" class="required">Periodicidad de Pago:</form:label>
					</div>
					<div class="span7">
						<form:select path="periodicidadPago" id="periodicidadPago">
							<option value="default">Seleccionar</option>
							<c:forEach items="${periodicidadPago}" var="periodicidadPago" >
								<option value="${periodicidadPago.clave}" ${empleado.periodicidadPago eq periodicidadPago.clave ? 'selected':''}>${periodicidadPago.nombre}</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="email">Correo Electr&oacute;nico:</form:label>
					</div>
					<div class="span7">
						<form:input path="email" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="claveEntFed" class="required">Entidad Federativa:</form:label>
					</div>
					<div class="span7">
						<form:select path="claveEntFed" id="claveEntFed">
							<option value="default">Seleccionar</option>
							<c:forEach items="${claveEntFed}" var="claveEntFed" >
								<option value="${claveEntFed.id}" ${empleado.claveEntFed eq claveEntFed.id ? 'selected':''}>${claveEntFed.nombre}</option>
							</c:forEach>
						</form:select>	
					</div>
				</div>
				<div class="span6">
					<div class="span5">
						<form:label path="sindicalizado">Sindicalizado:</form:label>
					</div>
					<div class="span7">
						<form:select path="sindicalizado" id="sindicalizado">
							<option value="default">Seleccionar</option>
							<option value="Sí" ${empleado.sindicalizado eq 'Sí' ? 'selected':''}>Sí</option>
							<option value="No" ${empleado.sindicalizado eq 'No' ? 'selected':''}>No</option>
						</form:select>	
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span5">
						<form:label path="usoCFDI" class="required">Uso CFDI:</form:label>
					</div>
					<div class="span7">
						<form:select path="usoCFDI">
							<option value="default">Seleccionar</option>
							<c:forEach items="${usosCFDI}" var="usoCFDI" >
								<form:option value="${usoCFDI.clave}">${usoCFDI.descripcion}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span5">
					<form:label path="" class="tinytext"><span class="required"></span> Campos Requeridos</form:label>
				</div>
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