<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#formLugar {
	/*height : 500px;*/
	left: 37%;
	max-width: 900px !important;
	overflow : auto;
	width: 90%;
}

#formLugar input, #formLugar select{
	height: initial;
	width: 100%;
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
		redirect('/CFDI33/lugarExpedicion/');
	});

	$("form#lugar input").on('keydown', function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/lugarExpedicion/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
<c:when test="${action == 'auditoria'}">
$('form').submit(function(){
	redirect('<c:url value="/auditoria/lugarExpedicion/" />');
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
		   "Solo caracteres alfanumericos."
		);

$('#lugar').validate({
	rules: {
		clave: {
			required: true,
			clave: 'lugarExpedicion',
			alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
		},
		nombre: {
			required : true
		},
		codigoPostal : {
			required: true,	
			number : true,
			maxlength : 7
		},
		pais: {
			required : true,
			valueNotEquals: "default"
		}
	}
});

$('#estado').change(
		
        function() {    
          if ($('#pais').val() != "ZZZ") {
        	  $.get('/CFDI33/rest/estado/listarMunicipios/'+$(this).val(), {}, function(responseText) {
                      $('#delegacionMunicipio').html(responseText);
                });    
              $.get('/CFDI33/rest/estado/listarLocalidades/'+ $(this).val(), {}, function(responseText) {
                      $('#localidad').html(responseText);
                }); 
              $.get('/CFDI33/rest/estado/listarCodigosPostalesEstado/'+$('#estado').val(), {}, function(responseText) {
                  $('#codigoPostal').html(responseText);
            	});   
          }
        }); 
$('#delegacionMunicipio').change(
        function() {    
          if ($(this).val() != "ZZZ") {
                  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipio/'+$('#estado').val()+'/'+$(this).val(), {}, function(responseText) {
                      $('#codigoPostal').html(responseText);
                });    
          }
        });

$('#localidad').change(
        function() {    
          if ($(this).val() != "ZZZ") {
                  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipioLocalidad/'+$('#estado').val()+'/'+$('#delegacionMunicipio').val()+'/'+$(this).val(), {}, function(responseText) {
                      $('#codigoPostal').html(responseText);
                });    
          }
        });
});
</script>

<form:form commandName="lugar" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${lugar.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${lugar.clave}">
	<div id="formLugar" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Lugar de Expedici&oacute;n</h3>
		</div>
		<div  class="modal-body">
		<br/>
		<div class="first-div-row one-row row-fluid">
			<div class="span5">
				<div class="span4">
					<form:label path="clave" class="required">Id. Interno:</form:label>
				</div>
				<div class="span8">
					<form:input path="clave"/>
					<form:errors class="invalid" path="clave"/>
				</div>
			</div>
			<div class="span5">
				<div class="span4">
					<form:label path="nombre" class="required">Nombre:</form:label>
				</div>
				<div class="span8">
					<form:input path="nombre"/>
					<form:errors class="invalid" path="nombre"/>
				</div>
			</div>
		</div>
		<div class="one-row row-fluid">
			<div class="span5">
				<div class="span4">
					<form:label path="estado">Estado:</form:label>
				</div>
				<div class="span8">
					<form:select path="estado">
						<option value="">Seleccionar</option>
						<c:forEach items="${estados}" var="estado" >
							<option value="${estado.id}" ${lugar.estado eq estado.id ? 'selected':''}>${estado.nombre}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="span5">
				<div class="span4">
					<form:label path="delegacionMunicipio">Deleg/Municipio:</form:label>
				</div>
				<div class="span8">
					<form:select path="delegacionMunicipio">
						<option value="">Seleccionar</option>
	               		<c:forEach items="${delegacionesMunicipio}" var="delegacionMunicipio" >
							<option value="${delegacionMunicipio.clave}" ${lugar.delegacionMunicipio eq delegacionMunicipio.clave ? 'selected':''}>${delegacionMunicipio.nombre}</option>
						</c:forEach>
	                 </form:select>
				</div>
			</div>
		</div>
		<div class="one-row row-fluid">
			<div class="span5">
				<div class="span4">
					<form:label path="localidad">Localidad:</form:label>
				</div>
				<div class="span8">
					<form:select path="localidad">
						<option value="">Seleccionar</option>
	                	<c:forEach items="${localidades}" var="localidad" >
							<option value="${localidad.clave}" ${lugar.localidad eq localidad.clave ? 'selected':''}>${localidad.nombre}</option>
						</c:forEach>
	                </form:select>
				</div>
			</div>
			<div class="span5">
				<div class="span4">
					<form:label path="codigoPostal" class="required">C&oacute;digo Postal:</form:label>
				</div>
				<div class="span8">
					<form:select path="codigoPostal">
	               		<c:forEach items="${cps}" var="cp" >
						<option value="${cp.cp}" ${lugar.codigoPostal eq cp.cp ? 'selected':''}>${cp.cp}</option>
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
