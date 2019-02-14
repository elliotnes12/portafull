<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/bootstrap-timepicker.css"/>" />
<script
	src="<c:url value="/static/resources/js/bootstrap-timepicker.js"/>"></script>
<style>
#btnAdd {
	padding-bottom: 10px;
}

#formGrupoUsuario {
	left: 40%;
	max-width: 800px;
	width: 100%;
}

.modal-left {
	width: 360px;
	float: left;
}

.modal-right {
	width: 330px;
	margin-bottom: 20px;
	float: right;
}

#formGrupoUsuario .one-row label {
	/*display: inline-block;*/
	/*width: 85px;
	text-align: right;*/
}
#formGrupoUsuario input{
	height: initial;
	width: 100;
}
.input-append .add-on, .input-prepend .add-on{
	height: initial;
}
#formGrupoUsuario label.error {
	display: none;
}

.first-div-row {
	margin-top: 15px;
}

.invalid {
	color: red;
	font: 65%/1 sans-serif;
}
.modal-footer {
	width: 730px;
	float: right;
}
.descripcion {
	width: 250px;
	margin-left: 35px;
	margin-bottom: 10px;
	background-color: #D8D8D8;
}
.radios {
	margin-right: 15px;
}
</style>
<script>
	$(document).ready(function() {
		//$("#grupo option:eq('${usuario.grupo}'").prop('selected', true);
		$('.close-editar').click(function() {
			redirect('/CFDI33/grupoUsuario/');
		});
		<c:choose>
		<c:when test="${action == 'Detalle'}">
		$('form').submit(function() {
			redirect('<c:url value="/grupoUsuario/" />');
			return false;
		});
		bloquearFormulario();
		</c:when>
		</c:choose>

		$('.btnDatepicker').timepicker({
			minuteStep : 1,
			showSeconds : false,
			showMeridian : true
		});

		$.validator.addMethod(
				   "alfanumerico",
				   function(value, element, regexp) {
				       var re = new RegExp(regexp);
				       return this.optional(element) || re.test(value);
				   },
				   "Solo caracteres alfanumericos."
				);

		$('#grupoUsuario').validate({
			rules : {
				clave : {
					required : true,
					clave : 'grupoUsuario',
					rangelength : [ 2, 12 ],
					alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
				},
				nombre : {
					required : true,
					alfanumerico : "^([0-9a-zA-Z·ÈÌÛ˙¡…Õ”⁄—Ò ._-])+$"
				}
			}
		});
	});
</script>

<form:form id="grupoUsuario" commandName="grupoUsuario"
	action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${grupoUsuario.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior"
		value="${grupoUsuario.clave}">
	<div id="formGrupoUsuario"
		class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>${action} Grupo Usuario</h3>
		</div>
		<div class="modal-body row-fluid">
			<div class="span6">
				<div style="height: 20px"></div>
				<div class="one-row first-div-row">
					<div class="span4"><form:label path="clave">Clave:</form:label></div>
					<div class="span8">
						<form:input path="clave" />
						<form:errors class="invalid" path="clave" />
					</div>
				</div>
				<div class="one-row">
					<div class="span4"><form:label path="nombre">Nombre:</form:label></div>
					<div class="span8">
						<form:input path="nombre" />
						<form:errors class="invalid" path="nombre" />
					</div>
				</div>
				<div class="one-row">
					<div class="span4"><label>Hora Inicial:</label></div>
					<div class="span8">
						<div class="input-append bootstrap-timepicker">
							<form:input path="horaInicialJsp"
								class="input-small btnDatepicker" />
							<span class="add-on"><i class="icon-time"></i></span>
						</div>
					</div>
				</div>
				<div class="one-row">
					<div class="span4"><label>Hora Final:</label></div>
					<div class="span8">
						<div class="input-append bootstrap-timepicker">
							<form:input path="horaFinalJsp" class="input-small btnDatepicker" />
							<span class="add-on"><i class="icon-time"></i></span>
						</div>
					</div>
				</div>
				<div style="clear: both;"></div>
				<div class="one-row descripcion" >
					<div><i class="icon-pencil" style="margin-left: 5px;margin-right: 15px;"></i>Ver y Editar m&oacute;dulo</div>
					<div><i class="icon-eye-open" style="margin-left: 5px;margin-right: 15px;"></i>&Uacute;nicamente ver m&oacute;dulo</div>
					<div><i class="icon-eye-close" style="margin-left: 5px;margin-right: 15px;"></i>Denegar todo acceso al m&oacute;dulo</div>
				</div>
			</div>
			<div class="span6">
				<div style="width: 160px; float: left;" >&nbsp</div>
				<i class="icon-pencil radios"></i>
				<i class="icon-eye-open radios"></i>
				<i class="icon-eye-close radios" ></i>
				<br/>
				<c:forEach items="${grupoUsuario.permisos}" var="permiso" varStatus="status">
					<div style="width: 160px; float: left;"><strong>${permiso.nombreModulo}:</strong></div>
						<input type="hidden" name="permisos[${status.index}].id" value="${permiso.id}" ${permiso.nombreModulo eq 'Base' ? 'disabled' : ''}/>
						<input ${permiso.permiso eq 0 ? 'checked' : ''} ${permiso.nombreModulo eq 'Base' ? 'readonly' : ''} style="margin-right: 15px;" type="radio" name="permisos[${status.index}].permiso" value="0"/>
						<input ${permiso.permiso eq 1 ? 'checked' : ''} ${permiso.nombreModulo eq 'Base' ? 'readonly' : ''} style="margin-right: 15px;" type="radio" name="permisos[${status.index}].permiso" value="1"/>
						<input ${permiso.permiso eq 2 ? 'checked' : ''} ${permiso.nombreModulo eq 'Base' ? 'readonly' : ''} style="margin-right: 15px;" type="radio" name="permisos[${status.index}].permiso" value="2"/><br/>
				</c:forEach>
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
	</div>
</form:form>
