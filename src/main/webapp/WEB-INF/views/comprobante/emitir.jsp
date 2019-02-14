<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<jsp:include page="/WEB-INF/views/layout/header.jsp" />
		<script src="<c:url value="/static/resources/js/cfdi.js" />"></script>
		<link rel="stylesheet" href="css/cfdi.css">
		<title>Generar CFDI</title>
	</head>


	<body>
		<style type="text/css">
			.blue { border: 1px solid #00ace7; }
			#divSerie label { padding-right: 5px; }
			#divExpedidoEn { 
				margin-top: 65px 5px 0; 
				width: 98%;
			}
			#header-invoice h6 { margin: 3px; }
			#header-invoice [class*="span"] { text-align: center; }
			#header-invoice input { margin: 0; }
			#header-invoice p {
				text-align: left;
				margin: 0 0 3px;
			}
			#divSerie input {
				margin: 0;
				width: 100%;
			}
			.blue th {
				background: #00ace7;
				color: #fff;
			}
			#lExpedidoEn {
				width: 120px;
				display: inline-block;
			}
			.add-on {
				padding: 2px 5px !important;
			}
			.divRow {
				margin-bottom: 5px;
			}
			#fecha {
				text-align: center;
			}
			/***********/
			label { font-size: 12px; }
	  input { padding: 2px 5px !important;	}
	  select { height: 30px; }
		</style>
	
	<script  type="text/javascript">
		var map = {};
		var objects = [];
		$(document).ready(function() {
			
			$('#razonSocial').typeahead({
				source : function(query, process) {
					map = {};
					objects = [];
					response = $.ajax({
							url : 'http://localhost:8080/CFDI/rest/cliente/listar/id', 
							async : false
					})
					data = $.parseJSON(response.responseText);
					$.each(data, function(i, object) {
						map[object.name] = object;
						objects.push(object.name);
					});
					process(objects);
				}, 
				updater: function(item) {
					response = $.ajax({
						url : 'http://localhost:8080/CFDI/rest/cliente/find/' + map[item].id, 
						async : false
					})
					cliente = $.parseJSON(response.responseText);
					$("#rfc").val(cliente.rfc);
					$("#email").val(cliente.email);
					$("#pais").val(cliente.pais);
					return item;
				}
			}); 

			$('#clave').typeahead({
				source : function(query, process) {
					map = {};
					objects = [];
					response = $.ajax({
							url : 'http://localhost:8080/CFDI/rest/productoServicio/listar', 
							async : false
					})
					data = $.parseJSON(response.responseText);
					 //var data = [{"id":1,"label":"machin"},{"id":2,"label":"truc"}] 
					$.each(data, function(i, object) {
						map[object.clave] = object;
						objects.push(object.clave);
					});
					process(objects);
				}, 
				updater: function(item) {
					response = $.ajax({
						url : 'http://localhost:8080/CFDI/rest/productoServicio/find/' + map[item].id, 
						async : false
					})
					productoServicio = $.parseJSON(response.responseText);
					$("#precioUnitario").val(productoServicio.precioUnitario);
					$("#concepto").val(productoServicio.nombre);
					$("#iva").val(productoServicio.tasaIva);
					$("#descuento").val("");
					$("#ieps").val("");
					$("#cantidad").val("1");
					//$("#unidad").val("1");
					if(productoServicio.ivaExento == true){
						$("#ivaExento").prop("checked", true);
						$("#iva").val(0);
						$("#iva").prop("disabled", true);
					}else{
						$("#ivaExento").prop("checked", false);
						$("#iva").prop("disabled", false);
					}
					return item;
				}
			});

			$('#concepto').typeahead({
				source : function(query, process) {
					map = {};
					objects = [];
					response = $.ajax({
							url : 'http://localhost:8080/CFDI/rest/productoServicio/listar', 
							async : false
					})
					data = $.parseJSON(response.responseText);
					 //var data = [{"id":1,"label":"machin"},{"id":2,"label":"truc"}] 
					$.each(data, function(i, object) {
						map[object.name] = object;
						objects.push(object.name);
					});
					process(objects);
				}, 
				updater: function(item) {
					response = $.ajax({
						url : 'http://localhost:8080/CFDI/rest/productoServicio/find/' + map[item].id, 
						async : false
					})
					productoServicio = $.parseJSON(response.responseText);
					$("#precioUnitario").val(productoServicio.precioUnitario);
					$("#clave").val(productoServicio.clave);
					$("#iva").val(productoServicio.tasaIva);
					$("#descuento").val("");
					$("#ieps").val("");
					$("#cantidad").val("1");
					//$("#unidad").val("1");
					if(productoServicio.ivaExento == true){
						$("#ivaExento").prop("checked", true);
						$("#iva").val(0);
						$("#iva").prop("disabled", true);
					}else{
						$("#ivaExento").prop("checked", false);
						$("#iva").prop("disabled", false);
					}
					return item;
				}
			});

			$('#ivaExento').change(function() {
			    if ($('#ivaExento').prop('checked') === true) {
			    	$("#iva").prop("disabled", true);
			    }
			    else $("#iva").prop("disabled", false);
			});
			
		});

	
	</script>

		
	
		<div class="containter">
			<div id="invoice">
				<!-- Header de la factura -->
				<div id="header-invoice" class="container-fluid">
					<div class="row-fluid">
						<div class="span2 "><!-- Logotipo -->
							<img src="/CFDI/static/resources/img/logo.jpg" class="img-polaroid">
						</div>
						<div class="span6"><!-- Datos Fiscales del Emisor -->
							
						
							<h4>${datosE.razonSocial}</h4>
							<input type="hidden" name="razonSocial" value="${datosE.razonSocial}">
							<p>
								<b>R.F.C. </b><span>${datosE.rfc}</span>
							</p>
							
							<p>
								<span>${datosE.calle}</span>
								<span> ${datosE.noExterior}</span>
								<span> ${datosE.noInterior}</span>
								<span> ${datosE.colonia}</span>
								<span> ${datosE.delegacionMunicipio}</span>,
								<span> ${datosE.ciudad}</span>,
								<span> ${datosE.estado}</span>
							</p>
							<table class="blue table-bordered">
									<tr>
											<th class=""><label>Lugar de Expedición </label></th>
											<td class="tetx-center"><input type="text" value="${configuracion.lugarDeExpedicion}" id="lugarDeExpedicion" name="lugarDeExpedicion comprobante" class="input-xlarge" placeholder=""></td>
									</tr>
								</table>
						</div>
			
						<div class="span4 row-fluid"><!-- Serie y Folio -->
								<h6>COMPROBANTE FISCAL DIGITAL A TRAVÉS DE INTERNET</h6>
								<table id="divSerie" class="span3 blue table-bordered">
									<tr><th><label>Serie</label></th></tr>
									<tr><td><input type="text" id="serie" name="serie" class="input-small comprobante" placeholder="" value="${configuracion.serie}"></td></tr>
								</table>
								<table class="span3 blue table-bordered">
									<tr><th><label>Folio</label></th></tr>
									<tr><td><input type="text" id="folio" name="folio" class="input-small comprobante" placeholder=""></td></tr>
								</table>
								<table class="span5 blue table-bordered">
									<tr><th><label>Fecha</label></th></tr>
									<tr><td><input type="text" id="fecha" name="fecha" class="input-medium comprobante" placeholder=""></td></tr>
								</table>
								<!--
								<table id="divExpedidoEn2" class="span5 blue table-bordered">
									<tr>
											<th><label id="lExpedidoEn">Expedido en</label></th>
											<td><input type="text" id="serie" name="serie" class="input-large" placeholder=""></td>
									</tr>
								-->
								</table>
						</div>
					</div>
				</div>
				<!-- Receptor -->
				<div class="divReceptor form-inline">
					<div class="divRow">
						<h4 class="blue">Facturar a:</h4>
						<label for="razonSocial">Nombre/Razón Social  </label>
						<div class="input-prepend">
					  <span class="add-on"><i class="icon-search"></i></span>
					  <input class="span9 receptor" id="razonSocial" autocomplete="off" name="razonSocial" type="text" placeholder="Razón Social o Clave">
						</div>
						<label>R.F.C</label> <input type="text" id="rfc" name="rfc" class="input-large receptor" placeholder="R.F.C.">
					</div>
					<div class="divRow">
						<label>Calle</label> <input type="text" id="calle" name="calle" class="input-large receptorDomicilio">
						<label>No. interior</label> <input type="text" id="noInterior" name="noInterior" class="input-small receptorDomicilio">
						<label>No. exterior</label> <input type="text" id="noExterior" name="noExterior" class="input-small receptorDomicilio">
						<label>Colonia</label> <input type="text" id="colonia" name="colonia" class="input-large receptorDomicilio">
						<label>Código Postal</label> <input type="text" id="codigoPostal" name="codigoPostal" class="input-small receptorDomicilio">
					</div>
					<div class="divRow">
							<label>Correo electrónico: </label> <input type="text" id="email" name="email" placeholder="correo@empresa.com.mx" class="input-large receptorDomicilio">
						<label>Municipio</label> <input type="text" id="municipio" name="municipio" class="input-large receptorDomicilio">
						<label>País</label>
						<select class="receptorDomicilio" name="pais" id="pais">
							<option>Seleccionar</option>
							<option value="mexico">Mexico</option>
						</select>
						<label>Estado</label>
						<select class="receptorDomicilio" name="estado" id="estado">
							<option>Seleccionar</option>
							<option value="puebla">Puebla</option>
						</select>
					</div> 
					<div class="">
						<h4 class="blue">Forma de pago:</h4>
						<label>Método de pago: </label> <input type="text" value="${configuracion.metodoDePago}" id="metodoPago" name="metodoPago" class="input-large comprobante">
						<label>Número de cuenta: </label> <input type="text" value="${configuracion.numeroDeCtaPago}" id="NumCtaPago" name="NumCtaPago" class="input-medium comprobante">
						<label>Moneda:</label> <input type="text" id="moneda" value="${configuracion.moneda}" name="moneda" class="input-medium comprobante">
						<label>Tipo de cambio:</label>
						<div class="input-prepend input-append">
							<span class="add-on">$ </span>
							<input type="text" id="tipoCambio" name="tipoCambio" value="${configuracion.tipoCambio}" class="input-mini comprobante">
						</div>
					</div>

					<div id="formAgregarConcepto"><!--Conceptos -->
						<h4 class="blue">Agregar conceptos</h4>
						<div class="row-fluid">
			    <div class="span9">
			     <label>Cantidad:</label>
								<input type="text" id="cantidad" name="cantidad" class="input-mini input">
								<span class="divClave">
								<label>Clave:</label>
								<input type="text" id="clave" autocomplete="off"  name="clave" class="input-small input">
								</span>
								<label>Unidad:</label>
								<input type="text" id="unidad" name="unidad" class="input-large input" value="${configuracion.unidadMedida}">
			    </div>
			    <div class="span3"><!--Configurar Factura -->
		     	<input type="checkbox" ${configuracion.usarDescuento ? "checked" : ""} class="mostrarDetalle" modulo="Descuento" > <label for="mDes">Descuentos</label>
								<input type="checkbox" ${configuracion.usarClave ? "checked" : ""} class="mostrarDetalle" modulo="Clave"> <label for="mClave">Clave</label>
								<input type="checkbox" ${configuracion.usarIEPS ? "checked" : ""} class="mostrarDetalle" modulo="IEPS"> <label for="mClave">I.E.P.S</label>
			    </div>
			  	</div>
			  	<div class="row-fluid">
			    <div class="span9">
			     <label>Precio unitario:</label>
								<div class="input-prepend input-append">
									<span class="add-on">$ </span>
									<input type="text" id="precioUnitario" name="precioUnitario" class="input-medium input">											
								</div>
								<span class="divDescuento">
									<label>Descuento:</label>
									<div class="input-prepend input-append">
										<span class="add-on">$ </span>
										<input type="text" id="descuento" name="descuento" class="input-medium input">
									</div>
								</span>
								<input type="checkbox" name="ivaExento" id="ivaExento" > <label for="mDes">IVA Exento</label>
								<label>I.V.A.:</label>
								<div class="input-prepend input-append">
									<input type="text" id="iva" name="iva" class="input-mini input" value="${configuracion.iva}">
									<span class="add-on">%</span>
								</div>
								<span class="divIEPS">
								<label>I.E.P.S.:</label>
								<div id="divIEPS" class="input-prepend input-append">
									<span class="add-on">$</span>
									<input type="text" id="ieps" name="ieps" class="input-mini input"> 
									<span class="add-on">%</span>
								</div>
								</span>
			    </div>
			    <div class="divIEPS span3"><!--Configurar Factura -->
			     	<label>Calcular I.E.P.S</label>
									<input type="radio" class="calculoIEPS" name="calculoIEPS" value="0" checked> <label for="mClave">Por cantidad</label>
									<input type="radio" class="calculoIEPS" name="calculoIEPS" value="1"> <label for="mClave">Por porcentaje</label>
			    </div>
			  	</div>
			  	<div class="row-fluid">
			    <div class="span9">
			    	<label>Concepto:</label>
								<textarea id="concepto" name="concepto" autocomplete="off" class="span9 input" rows="3"></textarea>
								<a href="#" id="btnAgregarConcepto" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar Concepto</a>
			    </div>
			  	</div>

			  	<div id="mConceptos">
			  		<table id="tablaConceptos" class="table table-striped table-hover table-bordered text-center"> 
								<thead>
									<tr>
									<th class="span1">Cantidad</th>
									<th class="span1">Unidad</th>
									<th class="divClave">Clave</th>
									<th class="span3">Concepto</th>
									<th class="span1">Precio</th>
									<th class="span1 divDescuento">Decuento</th>
									<th class="span1">Importe</th>
									<th class="span1">IVA</th>
									<th class="span1 divIEPS">IEPS</th>
									<th class="span1"></th>
									</tr>
									</thead>
									<tbody>
									</tbody>
							</table>
			  	</div>
					</div> <!-- Fin conceptos -->
					
					<div class="row-fluid">
						<div class="span9">
							<label class="">Observaciones: </label>
							<textarea class="span9"></textarea>
						</div>
						<div id="divTotales" class="span3">
							<!--Body content-->
							<table id="tablaTotales" cellpadding="0" colspanding="0">
								<tr>
									<th><label>Subtotal </label></th>
									<td>
										<div class="input-prepend input-append">
											<span class="add-on">$</span>
											<input name="subtotal" readonly="readonly" value="0.00" type="text" class="comprobante">
										</div>
									</td>
								</tr>
								<tr>
									<th><label>Descuento </label></th>
									<td>
										<div class="input-prepend input-append">
											<span class="add-on">$</span>
											<input name="totalDescuento" readonly="readonly" value="0.00" type="text" class="comprobante">
										</div>
									</td>
								</tr>
								<tr>
									<th><label>I.V.A:  </label></th>
									<td>
										<div class="input-prepend input-append">
											<span class="add-on">$</span>
											<input name="totalIVA"  readonly="readonly"value="0.00" type="text" class="comprobante">
										</div>
									</td>
								</tr>
								<tr>
									<th><label>Total:  </label></th>
									<td>
										<div class="input-prepend input-append">
											<span class="add-on">$</span>
											<input name="total" readonly="readonly" value="0.00" type="text" class="comprobante">
										</div>
									</td>
								</tr>
							</table>
						</div>
					
					</div>
					<a class="btn btn-primary" id="vistaPrevia">Vista Previa</a>

				</div>

	</div>
</div>
	</body>