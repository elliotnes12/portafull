<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#btnAdd {
	padding-bottom: 10px;
}
#formUsuario {
	width: 900px !important;
	left: 37%;
}

#formUsuario .one-row label {
	display: inline-block;
	width: 85px;
	text-align: right;	 
}
#formUsuario label.error {
	display: none;
}
.first-div-row {
	margin-top: 15px;
}
</style>

<script>

$(document).ready(function() {
	$('.close-editar').click(function() {
		redirect('/CFDI/auditoria/usuario/');
	});

	//$("#grupo option:eq('${usuario.grupo}'").prop('selected', true);
	
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/auditoria/usuario/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
</c:choose>

$('#usuarioAnterior').validate({
	rules: {
		clave: {
			required: true,
			clave : 'usuario'
		},
		password: {
			required : true
		},
		password1: {
			required: true,
			equalTo: "#password"
		}
	}
});

});


</script>

<form:form commandName="usuarioAnterior" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${usuario.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${usuario.clave}">
	
	<div id="formUsuario" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Usuario</h3>
		</div>

		<div class="modal-body">
			<div class="one-row first-div-row">
				<form:hidden path="id" class="input-small" />

				<form:label path="clave" >Clave:</form:label>
				<form:input path="clave" class="input-small"/>
				<form:errors path="clave"/>
				
				<form:label path="password" >Contraseña:</form:label>
				<input type="password" id="password" name="password" value="${usuario.password}" class="input-small" />
				<form:errors path="password"/>
				
				<label path="password1" >Repetir contraseña:</label>
				<input type="password" id="password1" name="password1" value="${usuario.password}" class="input-small" />
			</div>
			<div class="one-row">
				<form:label path="nombre" >Nombre:</form:label>
				<form:input path="nombre" class="input-xlarge"/>
				<form:errors path="nombre"/>
				
				<form:label path="grupo" >Grupo de usuario:</form:label>
				<form:select path="grupo">
					<form:option value="">Seleccionar</form:option>
					<c:forEach items="${mapGrupoUsuarios}" var="mapGrupoUsuario" >
						<form:option value="${mapGrupoUsuario.id}">${mapGrupoUsuario.nombre}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="grupo"/>
				
			</div>
			<div class="one-row">
				<form:label path="calle" >Calle:</form:label>
				<form:input path="calle" class="input-xlarge"/>
				<form:errors path="calle"/>
				
				<form:label path="noExterior" >Num. ext.:</form:label>
				<form:input path="noExterior" class="input-small"/>
				<form:errors path="noExterior"/>
				
				<form:label path="noInterior" >Num. int.:</form:label>
				<form:input path="noInterior" class="input-small"/>
				<form:errors path="noInterior"/>
			</div>
			<div class="one-row">
				<form:label path="calle" >Colonia:</form:label>
				<form:input path="calle" class="input-xlarge"/>
				<form:errors path="calle"/>
				
				<form:label path="codigoPostal" >Código Postal:</form:label>
				<form:input path="codigoPostal" class="input-small"/>
				<form:errors path="codigoPostal"/>
			</div>
			
			<div class="one-row">
				<form:label path="ciudad" >Ciudad:</form:label>
				<form:input path="ciudad" class="input-xlarge"/>
				<form:errors path="ciudad"/>
				
				<form:label path="estado" >Estado:</form:label>
				<form:select path="estado">
					<form:option value="">Seleccionar</form:option>
				</form:select>
				<form:errors path="estado"/>
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
				<form:label path="email" >Correo electronico</form:label>
				<form:input path="email" class="input-medium"/>
				<form:errors path="email"/>
			</div>
			<div class="one-row">
				<form:label path="comentarios" >Comentarios:</form:label>
				<form:textarea path="comentarios" class="input-xxlarge" />
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
