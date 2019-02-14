<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#btnAdd {
	padding-bottom: 10px;
}

#formUnidad {
	width: 480px !important;
	left: 54%;
}

#formUnidad .one-row label {
	display: inline-block;
	text-align: left;
}
#formUnidad .one-row input{
	height: initial;
	width: 100%;
}
#formUnidad label.error {
	display: none;
}

.first-div-row {
	margin-top: 15px;
}

.invalid {
	color: red;
	font: 65%/1 sans-serif;
}
</style>
<script>
	$(document).ready(function() {
		$('.close-editar').click(function() {
			redirect('/CFDI33/unidad/');
		});

		//$("#grupo option:eq('${usuario.grupo}'").prop('selected', true);

		<c:choose>
		<c:when test="${action == 'Detalle'}">
		$('form').submit(function() {
			redirect('<c:url value="/unidad/" />');
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

		$('#unidad').validate({
			rules : {
				clave : {
					required : true,
					clave : 'unidad',
					rangelength : [ 1, 12 ],
					alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
				},
				nombre : {
					required : true
				}				
			}
		});
	});
</script>

<form:form id="unidad" commandName="unidad"
	action="${formAction}" method="POST">

	<input type="hidden" name="id" id="id" value="${unidad.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior"
		value="${unidad.clave}">
	<div id="formUnidad"
		class="${action eq 'Agregar' ? 'modal hide' : ''} row-fluid">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>${action} Unidad</h3>
		</div>
		<div class="modal-body">
			<div style="height: 20px"></div>
			<div class="one-row first-div-row row-fluid">
				<div class="span10">
					<div class="span4">
						<form:label path="clave">Clave:</form:label>
					</div>
					<div class="span8">
						<form:input path="clave" />
						<form:errors class="invalid" path="clave" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span10">
					<div class="span4">
						<form:label path="nombre">Nombre:</form:label>
					</div>
					<div class="span8">
						<form:input path="nombre" />
						<form:errors class="invalid" path="nombre" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span10">
					<div class="span4">
						<form:label path="nombreCorto">Nombre corto:</form:label>
					</div>
					<div class="span8">
						<form:input path="nombreCorto"/>
						<form:errors class="invalid" path="nombreCorto" />
					</div>
				</div>
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