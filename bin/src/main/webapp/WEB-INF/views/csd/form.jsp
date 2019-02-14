<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
	#btnAdd {
		padding-bottom: 10px;
	}

	#formCsd {
		max-width: 670px !important;
		left: 50%;
	}

	#formCsd .one-row label {
		display: inline-block;
		width: 125px;
		text-align: left;
	}

	#formCsd label.error {
		display: none;
	}

	.first-div-row {
		margin-top: 15px;
	}

	.invalid {
		color: red;
		font: 75%/1 sans-serif;
	}
	#csd input{
		height: initial;
		width: 100%;
	}
	#csd textarea{
		width: 100%;
	}
</style>
<script>
	$(document).ready(function() {
		$('.close-editar').click(function() {
			redirect('/CFDI33/csd/');
		});

		<c:choose>
		<c:when test="${action == 'Detalle'}">
		$('form').submit(function() {
			redirect('<c:url value="/csd/" />');
			return false;
		});
		bloquearFormulario();
		</c:when>
		</c:choose>

		$('#csd').validate({
			rules : {
				contrasena : {
					required : true
				}
			}
		});
	});
</script>

<form:form id="csd" commandName="csd" enctype="multipart/form-data"
	action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${csd.id}">
	<div id="formCsd" class="">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>${action} Certificado de Sello Digital</h3>
		</div>
		<div class="modal-body row-fluid">
		<br>
			<div class="one-row">
				<c:if test="${error != null}">
					<div class="invalid">${error}</div>
				</c:if>
			</div>
			<c:choose>
				<c:when test="${action == 'Agregar'}">
					<div class="one-row first-div-row span10">
						<div class="span3">
							<form:label path="contrasena">Contrase&ntilde;a CSD:</form:label>
						</div>
						<div class="span8">
							<form:password path="contrasena" />
							<form:errors class="invalid" path="contrasena" />
						</div>
					</div>
					<div class="one-row span10">
						<div class="span3">
							<form:label path="archivoKey">Archivo key (*.key):</form:label>
						</div>
						<div class="span8">
							<input type="file" name="archivo[]" />
							<form:errors class="invalid" path="archivoKey" />
						</div>
					</div>
					<div class="one-row span10">
						<div class="span3">
							<form:label path="archivoKey">Certificado (*.cer):</form:label>
						</div>
						<div class="span8">
							<input type="file" name="archivo[]" />
							<form:errors class="invalid" path="certificado" />
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="one-row span10">
						<div class="span3">
							<form:label path="nombreArchivoKey">Archivo key:</form:label>
						</div>
						<div class="span8">
							<form:label path="nombreArchivoKey">${csd.nombreArchivoKey}</form:label>
						</div>
					</div>
					<div class="one-row span10">
						<div class="span3">
							<form:label path="nombreArchivoKey">Archivo cer:</form:label>
						</div>
						<div class="span8">
							<form:label path="nombreArchivoKey">${csd.nombreArchivoCer}</form:label>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			<div class="one-row span10">
				<div class="span3">
					<form:label path="usar">Usar:</form:label>
				</div>
				<div class="span8">
					<form:checkbox path="usar" />
					<form:errors class="invalid" path="usar" />
				</div>
			</div>
			<div class="one-row span10">
				<div class="span3">
					<form:label path="comentario">Comentarios:</form:label>
				</div>
				<div class="span8">
					<form:textarea path="comentario" maxlength="255"/>
					<form:errors class="invalid" path="comentario" />
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