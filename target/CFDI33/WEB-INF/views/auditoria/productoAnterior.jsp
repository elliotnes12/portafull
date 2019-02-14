<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#btnAdd {
	padding-bottom: 10px;
}

#formProductoServicio {
	width: 700px !important;
	left: 45%;
}

#productoServicio .one-row label {
	display: inline-block;
	width: 85px;
	text-align: right;
}

#productoServicio label.error {
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
			redirect('/CFDI/auditoria/producto/');
		});

		//$("#grupo option:eq('${usuario.grupo}'").prop('selected', true);

		<c:choose>
		<c:when test="${action == 'Detalle'}">
		$('form').submit(function() {
			redirect('<c:url value="/auditoria/producto/" />');
			return false;
		});
		bloquearFormulario();
		</c:when>
		</c:choose>

		$('#productoServicio').validate({
			rules : {
				clave : {
					required : true,
					clave : 'productoServicio',
					rangelength : [ 3, 12 ]
				},
				nombre : {
					required : true
				},
				codigoMoneda : {
					required : true
				},
				precioUnitario : {
					required : true,
					number : true
				},
				tasaIva : {
					number : true
				}
			}
		});
	});
</script>

<form:form id="productoServicio" commandName="productoAnterior"
	action="${formAction}" method="POST">

	<input type="hidden" name="id" id="id" value="${productoServicio.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior"
		value="${productoServicio.clave}">
	<div id="formProductoServicio">
		<div class="modal-body">
			<div style="height: 20px"></div>
			<div class="one-row first-div-row">
				<form:label path="clave">Clave:</form:label>
				<form:input path="clave" />
				<form:errors class="invalid" path="clave" />
				<form:label path="nombre">Nombre:</form:label>
				<form:input path="nombre" />
				<form:errors class="invalid" path="nombre" />
			</div>
			<div class="one-row">
				<form:label path="codigoMoneda">Moneda:</form:label>
				<form:select path="codigoMoneda" items="${listaMonedas}" />
				<form:errors class="invalid" path="codigoMoneda" />
				<form:label path="precioUnitario">Precio Unitario:</form:label>
				<form:input path="precioUnitario" placeholder="0.00" />
				<form:errors class="invalid" path="precioUnitario" />
			</div>
			<div class="one-row">
				<form:label path="ivaExento">Iva Exento:</form:label>
				<form:checkbox path="ivaExento" />
				<form:label path="tasaIva">% I.V.A.: </form:label>
				<form:input path="tasaIva" placeholder="0.00" />
				<form:errors class="invalid" path="tasaIva" />
			</div>
			<div class="one-row"></div>
			<div class="one-row">
				<form:label path="comentario">Comentario: </form:label>
				<form:textarea path="comentario" />
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
		</div>
	</div>
</form:form>