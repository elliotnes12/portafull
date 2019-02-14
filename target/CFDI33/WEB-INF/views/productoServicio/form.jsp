<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>
	#btnAdd {
		padding-bottom: 10px;
	}

	#formProductoServicio {
		left: 45%;
		max-width: 700px !important;
		width: 80%;
	}

	#productoServicio .one-row label {
		display: inline-block;
		/*width: 85px;*/
		text-align: left;
	}
	#productoServicio input, #productoServicio select{
		height: initial;
		width: 100%;
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
			redirect('/CFDI33/productoServicio/');
		});

		$("form#productoServicio input").on('keydown', function(e) {
			if(e.keyCode == 13) {
				return false;
			}
		});
		//$("#grupo option:eq('${usuario.grupo}'").prop('selected', true);		

		toggleIva();
		$("#checkBoxIva").click(function() {
			toggleIva();
		});

		<c:choose>
		<c:when test="${action == 'Detalle'}">
		$('form').submit(function() {
			redirect('<c:url value="/productoServicio/" />');
			return false;
		});
		
		bloquearFormulario();
		</c:when>
		
		<c:when test="${action == 'auditoria'}">
		$('form').submit(function() {
			redirect('<c:url value="/auditoria/productoServicio/" />');
			return false;
		});
		bloquearFormulario();
		</c:when>				
		</c:choose>

		$.validator.addMethod("regex", function(value, element, regexp) {
			var re = new RegExp(regexp);
			return this.optional(element) || re.test(value);
		}, "Ingrese un numero v·lido.");

		$.validator.addMethod("alfanumerico", function(value, element, regexp) {
			var re = new RegExp(regexp);
			return this.optional(element) || re.test(value);
		}, "Solo caracteres alfanumericos.");

		$.validator.addMethod("valueNotEquals", function(value, element, arg){
			  return arg != value;
			 }, "Debe seleccionar una opcion.");

		$('#productoServicio').validate({
			rules : {
				buscar : {
					required : true,
					rangelength : [ 3, 12 ],
					alfanumerico : "^([0-9a-zA-ZÒ—._-])+$"
				},
				nombre : {
					required : true
				},
				codigoMoneda : {
					required : true,
					valueNotEquals: "default"
				},
				precioUnitario : {
					required : true,
					number : true,
					regex : "^[0-9]+(\.([0-9]{1,4})?)?$"
				}
			}
		});
		$("#buscar").autocomplete({
			minLength:3,
			source:function(request, response) {
			    $.getJSON("<c:url value="/rest/catalogoClaveProductoServicio/buscar/"/>" + $("#buscar").val(), { }, 
			              response);
			  },
				// "<c:url value="/rest/productoServicio/catalogoProductosServicios/"/>",
			focus:function(event, ui){
				$("#buscar").val(ui.item.clave + " - " + ui.item.label);
				return false;
			},
			select:function(event, ui){
				$("#buscar").val(ui.item.clave);
				$("#nombre").val(ui.item.label);
				$("#claveProdServ").val(ui.item.clave);
				$("#iepsTrasladado").val(ui.item.iepsTrasladado);
				$("#complementoAIncluir").val(ui.item.complementoAIncluir);
				return false;
			}
		});
		$("#buscar").autocomplete('option','appendTo',"#claveAutocomplete");
	});

	function toggleIva() {
		if ($("#checkBoxIva").is(":checked")) {
			$("#inputIva").attr("disabled", true);
		} else {
			$("#inputIva").removeAttr("disabled");
		}
	}
</script>
<style>
	.input-append .add-on, .input-prepend .add-on{
		height: auto;
	}
	.ui-autocomplete {
	    max-height: 100px;
	    overflow-y: auto;
	    /* prevent horizontal scrollbar */
		overflow-x: hidden;
	}
</style>
<form:form id="productoServicio" commandName="productoServicio"
	action="${formAction}" method="POST">

	<input type="hidden" name="id" id="id" value="${productoServicio.id}">
	<input type="hidden" name="claveAnterior" id="claveAnterior"
		value="${productoServicio.clave}">
	<div id="formProductoServicio"
		class="${action eq 'Agregar' ? 'modal hide' : ''} row-fluid">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal"
				aria-hidden="true">&times;</button>
			<h3>${action} Producto/Servicio</h3>
		</div>
		<div class="modal-body">
			<div style="height: 20px"></div>
			<div class="one-row first-div-row">
				<div class="span6" id="claveAutocomplete">
					<div class="span4">
						<label for="buscar">Clave :</label>
					</div>
					<div class="span8">
						<form:input path="clave" class="span8" maxlength="15"/>
						<form:errors class="invalid" path="clave" />
					</div>
				</div>
				<div class="span6">
					<div class="span4">
						<form:label path="nombre" class="required">Nombre:</form:label>
					</div>
					<div class="span8">
						<form:input path="nombre" class="span8"/>
						<form:errors class="invalid" path="nombre" />
					</div>
				</div>
			</div>
			<div class="one-row first-div-row">
				<div class="span6" id="claveAutocomplete">
					<%-- <form:label path="clave">Clave:</form:label>
					<form:input path="clave" />
					<form:errors class="invalid" path="clave" /> --%>
					<div class="span4">
						<label for="buscar" class="required">Clave Prod Serv:</label>
					</div>
					<div class="span8">
						<input type="text" name="buscar" id="buscar" value="${productoServicio.claveProdServ}" class="span4"/>
						<input type="hidden" id="claveProdServ" name="claveProdServ" value="${productoServicio.claveProdServ}"/>
					</div>
				</div>
				<div class="span6">
					<a target="_blank" href="http://200.57.3.46:443/PyS/catPyS.aspx">Cat·logo de Productos SAT</a>
				</div>
				<div class="span6">
					<a target="_blank" href="http://www.sat.gob.mx/informacion_fiscal/factura_electronica/paginas/criterios_catalogo_productos_servicios.aspx">Sugerencias de Claves SAT</a>
				</div>
			</div>
			<div class="one-row" style="clear: both;">
				<div class="span6">
					<div class="span4">
						<form:label path="codigoMoneda" class="required">Moneda:</form:label>
					</div>
					<div class="span8">
						<form:select path="codigoMoneda" id="codigoMoneda" name="codigoMoneda">
							<option value="default">Seleccionar</option>
							<c:forEach items="${listaMonedas}" var="moneda" >
								<option value="${moneda.clave}"   ${productoServicio.codigoMoneda eq moneda.clave ? 'selected':''}>${moneda.nombre}</option>
							</c:forEach>
						</form:select>	
					</div>
				</div>
				<div class="span6">
					<div class="span4">
						<form:label path="precioUnitario" class="required">Precio Unitario:</form:label>
					</div>
					<div class="span5">
						<div class="input-prepend">
							<span class="add-on">$</span>
							<form:input path="precioUnitario" placeholder="0.00" />
						</div>
						<form:errors class="invalid" path="precioUnitario" />
					</div>
				</div>
			</div>
			<div class="one-row" style="clear: both;">
				<div class="span6">
					<div class="span4">
						<form:label path="claveUnidad">Clave Unidad Medida:</form:label>
					</div>
					<div class="span8">
						<form:select path="claveUnidad" id="claveUnidad" name="claveUnidad">
							<option value="default">Seleccionar</option>
							<c:forEach items="${listaUnidades}" var="unidad" >
								<option value="${unidad.clave}" ${productoServicio.claveUnidad eq unidad.clave ? 'selected':''}>${unidad.clave} - ${unidad.nombre}</option>
							</c:forEach>
						</form:select>	
					</div>
				</div>
				<div class="span6">
					<div class="span4">
						<form:label path="unidad">Unidad:</form:label>
					</div>
					<div class="span8">
						<form:input path="unidad" class="span6" maxlength="20"/>
						<form:errors class="invalid" path="unidad" />
					</div>
				</div>
			</div>
			<div class="one-row" style="clear: both;">
				<div class="span6">
					<div class="span4">
						<form:label path="iepsTrasladado">IEPS Trasladado:</form:label>
					</div>
					<div class="span8">
						<form:select path="iepsTrasladado" id="iepsTrasladado" name="iepsTrasladado" disabled="true">
							<option value="default">Seleccionar</option>
							<option value="Opcional" ${productoServicio.iepsTrasladado eq 'Opcional' ? 'selected':''}>Opcional</option>
							<option value="No" ${productoServicio.iepsTrasladado eq 'No' ? 'selected':''}>No</option>
						</form:select>
					</div>
				</div>
				<div class="span6">
					<div class="span4">
						<form:label path="complementoAIncluir">Complemento a incluir:</form:label>
					</div>
					<div class="span8">
						<form:input path="complementoAIncluir" disabled="true"/>
						<form:errors class="invalid" path="complementoAIncluir" />
					</div>
				</div>
			</div>
			<div class="one-row row-fluid" style="clear: both;">
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
				<c:otherwise>
					<a href="#" class="btn close-editar" data-dismiss="modal">Cancelar</a>
					<button type="submit" class="btn btn-primary">Agregar</button>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</form:form>
<link rel="stylesheet" href="<c:url value="/static/resources/css/redmond/jquery-ui-1.10.3.custom.min.css"/>">
<script src="/CFDI33/static/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
