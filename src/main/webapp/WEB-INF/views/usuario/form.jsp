<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#btnAdd {
	padding-bottom: 10px;
}
#formUsuario {
	left: 37%;
	max-width: 900px;
	width: 100%;
}
#formUsuario input, #formUsuario select{
	height: initial;
	width: 100%;
}
#formUsuario .one-row label {
	display: inline-block;
	width: 100%;
	/*text-align: right;*/
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
	//$("#grupo option:eq('${usuario.grupo}'").prop('selected', true);
	$("form#usuario input").on('keydown', function(e) {
		if(e.keyCode == 13) {
			return false;
		}
	});
	$('.close-editar').click(function() {
		redirect('/CFDI33/usuario/');
	});
	$('#email').change(function() {
		var patt=/^([\w+-.%]+@[\w-.]+\.[A-Za-z]{2,4})+$/g;
		var result=patt.test($('#email').val());
		if (!result) {
			alert("Email no v·lido.")
			$('#email').focus();
		}
	});	
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/usuario/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
<c:when test="${action == 'auditoria'}">
$('form').submit(function(){
	redirect('<c:url value="/auditoria/usuario/" />');
	return false;
});
bloquearFormulario();
</c:when>
</c:choose>

$.validator.addMethod("valueNotEquals", function(value, element, arg){
	  return arg != value;
}, "Debe seleccionar una opcion.");

$.validator.addMethod(
		   "alfanumerico",
		   function(value, element, regexp) {
		       var re = new RegExp(regexp);
		       return this.optional(element) || re.test(value);
		   },
		   "Solo caracteres alfanumericos."
		);
$.validator.addMethod(
		   "norfc",
		   function(value, element, regexp) {
		       var re = new RegExp(regexp);
		       return this.optional(element) || re.test(value);
		   },
		   "La contraseÒa no debe de contener el rfc."
		);
$.validator.addMethod(
		   "unaMayus",
		   function(value, element, regexp) {
		       var re = new RegExp(regexp);
		       return this.optional(element) || re.test(value);
		   },
		   "Debe contener al menos una letra May˙scula."
		);
$.validator.addMethod(
		   "unEsp",
		   function(value, element, regexp) {
		       var re = new RegExp(regexp);
		       return this.optional(element) || re.test(value);
		   },
		   "Debe contener al menos un caracter Especial."
		);
<c:choose>
<c:when test="${action == 'Agregar'}">
$('#usuario').validate({
	rules: {
		clave: {
			required: true,
			clave : 'usuario',
			alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
		},
		password: {
			required : true,
			// norfc : "^((?!"+ document.getElementById('rfc').value + ")[0-9a-zA-ZÒ—#$*@_])+$",
			unaMayus : "([A-Z])+",
			unEsp : "([#$*@_])+",
			minlength : 8
		},
		password1: {
			required: true,
			equalTo: "#password"
		},
		codigoPostal : {
			required : true,
			number : true,
			minlength : 5,
			maxlength : 7
		},
		estado: {
			required : true,
			valueNotEquals: "default"
		},
		grupo: {
			required : true,
			valueNotEquals : "0"
		},
		nombre : {
			alfanumerico : "^([0-9a-zA-Z·ÈÌÛ˙¡…Õ”⁄—Ò ._-])+$"
		}
	}
});
</c:when>
<c:when test="${action == 'Editar'}">
$('#usuario').submit(function() {
	 var id =  $('#id').val();
	 var pass = $('#password').val();
	 var bandera = false;
	 var mensaje = '';
	 if(pass!=''){
		 $.ajax({
		      url : '/CFDI33/rest/usuario/' + id + '/' + pass,
		      async : false
		     }).done(function ( data ) {
		  if (data == 'passwordDuplicado') {
			  alert('No puede ingresar ese password')
			  bandera = false;
		   } else {
		    mensaje = data;
		    bandera = true;
		  }
		 })
		 if(mensaje=='noExiste'){
			 alert('El nombre de usuario que ingreso no existe.');
		 }

	}else bandera = true;
	return bandera;
		});
$('#usuario').validate({
	rules: {
		clave: {
			required: true,
			clave : 'usuario',
			alfanumerico : "^([0-9a-zA-Z._-])+$"
		},
		password : {
			norfc : "^((?!"+ document.getElementById('rfc').value + ")[0-9a-zA-Z#$*@_])+$",
			unaMayus : "([A-Z])+",
			unEsp : "([#$*@_])+",
			minlength : 8
		},
		password1: {
			equalTo: "#password"
		},
		codigoPostal : {
			required : true,
			number : true,
			minlength : 5,
			maxlength : 7
		},
		estado: {
			required : true,
			valueNotEquals: "default"
		},
		grupo : {
			required : true,
			valueNotEquals : "0"
		},
		nombre : {
			alfanumerico : "^([0-9a-zA-Z ._-])+$"
		}
	}
});
</c:when>
</c:choose>
});


</script>

<form:form commandName="usuario" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${usuario.id}">
	<input type="hidden" name="rfc" id="rfc" value="${rfc}">
	<input type="hidden" name="claveAnterior" id="claveAnterior" value="${usuario.clave}">

	<div id="formUsuario" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Usuario</h3>
		</div>

		<div class="modal-body">
			<br>
			<div class="one-row first-div-row">
				<form:hidden path="id" class="input-small" />
				<div class="row-fluid">
					<div class="span4">
						<div class="span5"><form:label path="clave" >Clave:</form:label></div>
						<div class="span7">
							<form:input path="clave" class="input-small"/>
							<form:errors path="clave"/>
						</div>
					</div>
				</div>
				<c:choose>
				<c:when test="${action == 'Agregar' or action == 'Editar'}">
				<div class="row-fluid">
					<div class="span4">
						<div class="span5"><form:label path="password" >Contrase&ntilde;a:</form:label></div>
						<div class="span7">
							<input type="password" id="password" name="password" value="${usuario.password}" class="input-small" />
							<form:errors path="password"/>
						</div>
					</div>
					<div class="span4">
						<div class="span5"><label path="password1" >Repetir contrase&ntilde;a:</label></div>
						<div class="span7"><input type="password" id="password1" name="password1" value="${usuario.password}" class="input-small" /></div>
					</div>
				</div>
				</c:when>
				</c:choose>
			</div>
			<div class="one-row row-fluid">
				<div class="span4">
					<div class="span5"><form:label path="nombre" >Nombre:</form:label></div>
					<div class="span7">
						<form:input path="nombre" class="input-large"/>
						<form:errors path="nombre"/>
					</div>
				</div>
				<div class="span4">
					<div class="span5"><form:label path="grupo" >Grupo de usuario:</form:label></div>
					<div class="span7">
						<form:select path="grupo">
							<form:option value="0">Seleccionar</form:option>
							<c:forEach items="${mapGrupoUsuarios}" var="mapGrupoUsuario" >
							<form:option value="${mapGrupoUsuario.id}">${mapGrupoUsuario.nombre}</form:option>
							</c:forEach>
						</form:select>
						<form:errors path="grupo"/>
					</div>
				</div>

			</div>
			<div class="one-row row-fluid">
				<div class="span4">
					<div class="span5"><form:label path="municipio" >Municipio:</form:label></div>
					<div class="span7">
						<form:input path="municipio" class="input-large"/>
						<form:errors path="municipio"/>
					</div>
				</div>
			</div>

			<div class="one-row row-fluid">
				<div class="span4">
					<div class="span5"><form:label path="estado" >Estado:</form:label></div>
					<div class="span7">
						<form:select path="estado" class="input-medium">
							<option value="default">Seleccionar</option>
							<option value="Fuera de MÈxico" ${cliente.estado eq "Fuera de MÈxico" ? 'selected':''}>Fuera de MÈxico</option>
							<c:forEach items="${estados}" var="estado" >
								<option value="${estado.nombre}" ${usuario.estado eq estado.nombre ? 'selected':''}>${estado.nombre}</option>
							</c:forEach>
						</form:select>
						<form:errors path="estado"/>
					</div>
				</div>
				<div class="span4">
					<div class="span5"><form:label path="codigoPostal" >C&oacute;digo Postal:</form:label></div>
					<div class="span7">
						<form:input path="codigoPostal" class="input-small"/>
						<form:errors path="codigoPostal"/>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span4">
					<div class="span5"><form:label path="email" >Correo electr&oacute;nico</form:label></div>
					<div class="span7">
						<form:input path="email" class="input-medium"/>
						<form:errors path="email"/>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span8">
					<div class="span2"><form:label path="comentarios" >Comentarios:</form:label></div>
					<div class="span10">
						<form:textarea path="comentarios" style="width: 100%" maxlength="255"/>
						<form:errors path="comentarios"/>
					</div>
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
