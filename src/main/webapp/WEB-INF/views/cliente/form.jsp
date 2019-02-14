<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>


$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI33/cliente/');
	});
	cancelKeyPipe("#razonSocial");
	$("form#cliente input").on('keydown', function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
	
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/cliente/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
<c:when test="${action == 'auditoria'}">
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
        "Ingrese un RFC v·lido."
);

$.validator.addMethod(
        "alfanumerico",
        function(value, element, regexp) {
            var re = new RegExp(regexp);
            return this.optional(element) || re.test(value);
        },
        "Debe de ser Alfanumerico."
);



$('#email').change(function() {
	var patt=/^([\w+-.%]+@[\w-.]+\.[A-Za-z]{2,4})+$/g;
	var result=patt.test($('#email').val());
	if (!result) {
		alert("Email no valido.")
		$('#email').focus();
	}
});

$('#residenciaFiscal').change(function() {
	alert("Este campo debe permanecer en 'Seleccionar' a menos que el RFC pertenezca a un extranjero.");
});

$('#numRegIdTrib').change(function() {
	alert("Este campo no se debe proporcionar a menos que el RFC pertenezca a un extranjero.");
});

<c:choose>
<c:when test="${action == 'Agregar'}">
$('#cliente').validate({
	rules: {
		clave: {
			required: true,
			clave: 'cliente',
			alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
		},
		rfc: {
			required : true,
			minlength : 12,
			maxlength : 13,
			regex : "[A-Z&amp;—]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
		},
		email: {
			required : true
		},
		usoCFDI: {
			required : true
		}
	}
});
</c:when>
<c:when test="${action == 'Editar'}">
$('#cliente').validate({
	rules: {
		clave: {
			required: true,
			clave: 'cliente',
			alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
		},
		rfc: {
			required : true,
			minlength : 12,
			maxlength : 13,
			regex : "[A-Z&amp;—]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
		},
		email: {
			required : true
		},
		usoCFDI: {
			required : true
		}
	}
});
</c:when>
</c:choose>



});
</script>
<style>
	#cliente input, #cliente select{
		height: initial;
		width: 100%;
	}
</style>
<form:form commandName="cliente" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${cliente.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${cliente.clave}">
	<div id="formCliente" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Cliente</h3>
		</div>
		<div class="modal-body">
			<br/>
			<div class="one-row first-div-row row-fluid">
				<div class="span5">
					<div class="span4">
						<form:label path="clave" class="required">Clave:</form:label>
					</div>
					<div class="span8">
						<form:input path="clave" id="clave"/>
						<form:errors class="invalid" path="clave" />
					</div>
				</div>
			</div>
			<div class = "one-row row-fluid">
				<div class="span5">
					<div class="span4">
						<form:label path="razonSocial">RazÛn Social:</form:label>
					</div>
					<div class="span8">
						<form:input path="razonSocial" id="razonSocial"/>
						<form:errors class="invalid" path="razonSocial" />
					</div>
				</div>
				<div class="span5">
					<div class="span4">
						<form:label path="rfc" class="required">R.F.C:</form:label>
					</div>
					<div class="span8">
						<form:input path="rfc"/>
						<form:errors class="invalid" path="rfc" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span5">
					<div class="span4">
						<form:label path="usoCFDI" class="required">Uso CFDI:</form:label>
					</div>
					<div class="span8">
						<form:select path="usoCFDI">
							<option value="">Seleccionar</option>
							<c:forEach items="${usosCFDI}" var="usoCFDI" >
								<form:option value="${usoCFDI.clave}">${usoCFDI.clave} ${usoCFDI.descripcion}</form:option>
							</c:forEach>
						</form:select>
						<form:errors class="invalid" path="usoCFDI" />
					</div>
				</div>
				<div class="span5">
					<div class="span4">
						<form:label path="email" class="required">Email:</form:label>
					</div>
					<div class="span8">
						<form:input path="email"/>
						<form:errors class="invalid" path="email" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span5">
					<div class="span4">
						<form:label path="residenciaFiscal">Residencia Fiscal:</form:label>
					</div>
					<div class="span8">
						<form:select path="residenciaFiscal" id="residenciaFiscal" name="residenciaFiscal">
							<option value="default">Seleccionar</option>
							<option value="MEX">MÈxico</option>
							<c:forEach items="${paises}" var="pais" >
								<option value="${pais.id}" ${cliente.residenciaFiscal eq pais.id ? 'selected':''}>${pais.nombre}</option>
							</c:forEach>
						</form:select>
						<form:errors class="invalid" path="residenciaFiscal" />
					</div>
				</div>
				<div class="span5">
					<div class="span4">
						<form:label path="numRegIdTrib">NumRegIdTrib:</form:label>
					</div>
					<div class="span8">
						<form:input path="numRegIdTrib" maxlength="40"/>
						<form:errors class="invalid" path="numRegIdTrib" />
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