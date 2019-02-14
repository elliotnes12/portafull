<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	#formConfiguracionCFDI {
		margin: auto;
		width: 90%;
	}
	#formConfiguracionCFDI input, #formConfiguracionCFDI select{
		height: initial;
		width: 100%;
	}
	.first-div-row {
		margin-top: 15px;
	}
	div.input-prepend input, div.input-append input{
		max-width: 95% !important;
	}
	div.input-prepend .add-on, div.input-append .add-on{
		height: initial;
	}
	.modal-body {
		max-height: none !important;
	    overflow-y: hidden !important; 
	}
	ul#complementosConfig >li{
		list-style-type: none;
	}
	#complementosConfig input[type=checkbox] {
		width: 20px;
	}
</style>

<script>
$(document).ready(function() {
	var valor = $("#valorUsarIEPS").val();
	var configuracion = ${complementosConfig};
	$.each(configuracion, function(key, value){
		$("#"+key).prop('checked', true);
	});
	if(valor==2){
			$('#porCantidad').attr('checked', true);
		}else{
			$('#porPrecio').attr('checked', true);
		}

	toggleIva();
		$("#checkBoxIva").click(function(){
	 		toggleIva();
	 	});
	toggleIeps();
		$("#usarIEPS").click(function(){
			toggleIeps();
		});
	toggleMostrarSimbolo();
		$("#porCantidad").click(function(){
			toggleMostrarSimbolo();
		});
	toggleMostrarSimboloPrecio();
		$("#porPrecio").click(function(){
			toggleMostrarSimboloPrecio();
		});
<c:choose>
<c:when test="${action == 'Detalle'}">
	$('form').submit(function(){
		redirect('<c:url value="/configuracionCFDI/" />');
		return false;
	});
	bloquearFormulario();
</c:when>
</c:choose>

$.validator.addMethod(
		   "numero",
		   function(value, element, regexp) {
		       var re = new RegExp(regexp);
		       return this.optional(element) || re.test(value);
		   },
		   "Ingrese un numero valido."
		);

$('#moneda').change(function() {
	 /*
	 var elementos = document.getElementById('moneda');
	 console.log(elementos.selectedIndex);
	 var valor = elementos.options[elementos.selectedIndex].getAttribute('tipoCambio');
	 console.log(valor);
	 document.getElementById("tipoCambio").value = valor;
	 */
	 $('#tipoCambio').val($('#moneda :selected').attr('tipoCambio'))
});


$('#configuracionCFDI').validate({
	rules: {
		lugarDeExpedicion: {
			required : true
		},
		moneda: {
			required : true
		},
		tipoCambio: {
			required : true,
			numero : "^[0-9]+(\.([0-9]{1,4})?)?$"
		},
		valorIEPS:{
			numero : "^[0-9]+(\.([0-9]{1,4})?)?$"
		},
		iva:{
			numero : "^[0-9]+(\.([0-9]{1,4})?)?$"
		}
	}
});
});

function toggleIva() {
	if ($("#checkBoxIva").is(":checked")) {
		$("#inputIva").attr("disabled", true);
	} else {
		$("#inputIva").removeAttr("disabled");
	}
}
function toggleIeps(){
	if($("#usarIEPS").is(":checked")){
		$("#porPrecio").removeAttr("disabled");
		$("#porCantidad").removeAttr("disabled");
		$("#appendedInput").removeAttr("disabled");
		$("#radioPrecio").css("display", "inline-block");
		$("#radioCantidad").css("display", "inline-block");
		$("#labelIEPS").css("display", "inline-block");
		$("#divValorIEPS").css("display", "inline-block");
	} else {
		$("#porPrecio").attr("disabled", true);
		$("#porCantidad").attr("disabled", true);
		$("#appendedInput").attr("disabled", true);
		$("#radioPrecio").css("display", "none");
		$("#radioCantidad").css("display", "none");
		$("#labelIEPS").css("display", "none");
		$("#divValorIEPS").css("display", "none");
	}
}

function toggleMostrarSimbolo(){
	if($("#porCantidad").is(":checked")){
		$('#precio').attr('style','visibility: hidden');
		$('#cantidad').attr('style','visibility: visible');
	} else{
		$('#precio').attr('style','visibility: visible');
		$('#cantidad').attr('style','visibility: hidden');
	}
}

function toggleMostrarSimboloPrecio(){
	if($("#porPrecio").is(":checked")){
		$('#cantidad').attr('style','visibility: hidden');
		$('#precio').attr('style','visibility: visible');
	} else{
		$('#cantidad').attr('style','visibility: visible');
		$('#precio').attr('style','visibility: hidden');
	}
}
</script>

<form:form commandName="configuracionCFDI" action="${formAction}" method="POST">
	<input type="hidden" name="id" id="id" value="${configuracionCFDI.id}">
	<div id="formConfiguracionCFDI" class="${action eq 'Agregar' ? 'modal hide' : ''}">
		<div class="modal-header">
			<button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h3>${action} Configuracion CFDI</h3>
		</div>

		<div class="modal-body">
			<div class="row-fluid">
				<form:hidden path="id" class="input-small" />
				<div class="span6" style="margin-left: 0;">
					<div class="span4"><form:label path="serie">Serie: </form:label></div>
					<div class="span8">
						<form:input path="serie" class="input-small"/>
						<form:errors path="serie"/>
					</div>
				</div>
				<div class="span6">
					<div class="span4"><form:label path="numeroDecimales" >N&uacute;mero decimales: </form:label></div>
					<div class="span8">
						<form:input path="numeroDecimales" class="input-small"/>
						<form:errors path="numeroDecimales"/>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<div class="span4"><form:label path="lugarDeExpedicion">Lugar de Expedici&oacute;n: </form:label></div>
					<div class="span8">
						<form:select path="lugarDeExpedicion">
							<form:option value="0">Seleccionar</form:option>
							<c:forEach items="${mapLugaresEmision}" var="mapLugarEmision" >
								<form:option value="${mapLugarEmision.codigoPostal}">${mapLugarEmision.nombre}</form:option>
							</c:forEach>
						</form:select>
						<form:errors path="lugarDeExpedicion"/>
					</div>
				</div>
				<div class="span6">
					<div class="span4"><form:label path="unidadMedida">Clave Unidad Medida:</form:label></div>
					<div class="span8">
						<form:select path="unidadMedida">
								<form:option value="0">Seleccionar</form:option>
								<c:forEach items="${listaUnidades}" var="unidad" >
									<option value="${unidad.clave}" ${configuracionCFDI.unidadMedida eq unidad.clave ? 'selected':''}>${unidad.clave} - ${unidad.nombre}</option>
								</c:forEach>
							</form:select>
						<form:errors path="unidadMedida"/>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span4"><form:label path="formaPago">Forma de pago:</form:label></div>
					<div class="span8">
						<form:select path="formaPago">
								<form:option value="0">Seleccionar</form:option>
								<c:forEach items="${formasPago}" var="formaPago" >
									<form:option value="${formaPago.clave}">${formaPago.clave} ${formaPago.descripcion}</form:option>
								</c:forEach>
							</form:select>
						<form:errors path="formaPago"/>
					</div>
				</div>
				<div class="span6">
					<div class="span4"><form:label path="metodoDePago">M&eacute;todo de pago:</form:label></div>
					<div class="span8">
						<form:select path="metodoDePago">
								<form:option value="0">Seleccionar</form:option>
								<c:forEach items="${metodosPago}" var="metodoPago" >
									<form:option value="${metodoPago.clave}">${metodoPago.clave} ${metodoPago.descripcion}</form:option>
								</c:forEach>
							</form:select>
						<form:errors path="metodoDePago"/>
					</div>
				</div>
			</div>
			<div class="one-row row-fluid">
				<div class="span6">
					<div class="span4"><form:label path="moneda">Moneda:</form:label></div>
					<div class="span8">
						<form:select path="moneda">
						<form:option value="0">Seleccionar</form:option>
						<c:forEach items="${listaMonedas}" var="moneda" >
							<form:option value="${moneda.clave}">${moneda.nombre}</form:option>
						</c:forEach>
					</form:select>	
					</div>
				</div>
				<div class="span6">
					<div class="span4"><form:label path="tipoCambio" >Tipo Cambio:</form:label></div>
					<div class="span4">
						<div class="input-prepend">
							<span class="add-on">$</span>
		  					<form:input class="span2" type="text" path="tipoCambio"/>
							<form:errors path="tipoCambio"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
					<div class="span4"><form:label path="usarDescuento">Descuento</form:label></div>
					<div class="span1"><form:checkbox path="usarDescuento" /></div>
				</div>
				<div class="span6">
					<div class="span4"><form:label path="usarDescuento">Usar Descuento por %</form:label></div>
					<div class="span1"><form:checkbox path="descuentoPorcentaje" /></div>
				</div>
			</div>
			<div class= "row-fluid">
				<div class="span6">
					<div class="span4"><form:label path="usarClave" >Clave</form:label></div>
					<div class="span1"><form:checkbox path="usarClave" /></div>
				</div>
				<div class="span6">
					<div class="span4"><label class="inline" for="guardarProductos">Guardar Productos</label></div>
					<div class="span1"><input type="checkbox" id="guardarProductos" name="guardarProductos" ${configuracionCFDI.guardarProductos == true ? 'checked' : ''} /></div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span6">
			  		<div class="span4"><label for="tipoComprobante">Comprobante por Default:</label></div>
					<div class="span8">
						<select id="tipoComprobante" name="tipoComprobante">
							<option value="fa" ${configuracionCFDI.tipoComprobante == "fa" ? "selected" : ""}>Factura</option>
							<option value="rh" ${configuracionCFDI.tipoComprobante == "rh" ? "selected" : ""}>Recibo de Honorarios</option>
							<option value="ra" ${configuracionCFDI.tipoComprobante == "ra" ? "selected" : ""}>Recibo de Arrendamiento</option>
							<option value="ca" ${configuracionCFDI.tipoComprobante == "ca" ? "selected" : ""}>Nota de Cargo</option>
							<option value="cr" ${configuracionCFDI.tipoComprobante == "cr" ? "selected" : ""}>Nota de Cr&eacute;dito</option>
							<option value="rd" ${configuracionCFDI.tipoComprobante == "rd" ? "selected" : ""}>Recibo de Donativo</option>
							<option value="cp" ${configuracionCFDI.tipoComprobante == "cp" ? "selected" : ""}>Carta Porte</option>
						</select>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="span2"><form:label path="emailConfig">Configuraci&oacute;n Email:</form:label></div>
					<div class="span10">
						<form:textarea path="emailConfig" style="width: 100%;" rows="5"/>
						<form:errors path="emailConfig"/>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">

					<div class="accordion" id="accordion2">
					  <div class="accordion-group">
					    <div class="accordion-heading">
					      <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
					        Configuraci&oacute;n de complementos visibles
					      </a>
					    </div>
					    <div id="collapseOne" class="accordion-body collapse">
					      <div class="accordion-inner">
					      	<ul id="complementosConfig">
					      		<li>
					        		<input type="checkbox" id="addenda" name="complementos[addenda]" value="1" />
					        		Agregar Addendas
					        	</li>
					        	<li>
					        		<input type="checkbox" id="firmas" name="complementos[firmas]" value="1" />
					        		Agregar Firmas
					        	</li>
					        	<li>
					        		<input type="checkbox" id="impuestosLocalesYFederales" name="complementos[impuestosLocalesYFederales]" value="1" />
					        		Agregar Otros Derechos e impuestos (Locales y Federales)
					        	</li>
					        	<li>
					        		<input type="checkbox" id="detallista" name="complementos[detallista]" value="1" />
					        		Detallista
					        	</li>
					        	<li>
					        		<input type="checkbox" id="renovacionSustitucionVehiculos" name="complementos[renovacionSustitucionVehiculos]" value="1" />
					        		Renovaci&oacute;n y sustituci&oacute;n de veh&iacute;culos
					        	</li>
					        	<li>
					        		<input type="checkbox" id="registroFiscal" name="complementos[registroFiscal]" value="1" />
					        		Complemento Registro Fiscal
					        	</li>
					        	<li>
					        		<input type="checkbox" id="donatorias" name="complementos[donatorias]" value="1" />
					        		Complemento Donatarias
					        	</li>
					        	<li>
					        		<input type="checkbox" id="pagoEspecie" name="complementos[pagoEspecie]" value="1" />
					        		Complemento Pago en especie
					        	</li>
					        	<li>
					        		<input type="checkbox" id="notariosPublicos" name="complementos[notariosPublicos]" value="1" />
					        		Complemento Notarios P&uacute;blicos
					        	</li>
					        	<li>
					        		<input type="checkbox" id="consumoCombustible" name="complementos[consumoCombustible]" value="1" />
					        		Complemento Consumo de Combustibles 1.1
					        	</li>
					        	<li>
					        		<input type="checkbox" id="vehiculoUsado" name="complementos[vehiculoUsado]" value="1" />
					        		Complemento Veh&iacute;culo Usado
					        	</li>
					        	<li>
					        		<input type="checkbox" id="valesDespensa" name="complementos[valesDespensa]" value="1" />
					        		Complemento Vales de Despensa
					        	</li>
					        	<li>
					        		<input type="checkbox" id="serviciosParcialesConstruccion" name="complementos[serviciosParcialesConstruccion]" value="1" />
					        		Complemento Servicios Parciales de Construcci&oacute;n
					        	</li>
					        	<li>
					        		<input type="checkbox" id="aerolineas" name="complementos[aerolineas]" value="1" />
					        		Complemento Aerol&iacute;­neas
					        	</li>
					        	<li>
					        		<input type="checkbox" id="divisas" name="complementos[divisas]" value="1" />
					        		Complemento Divisas
					        	</li>
					        	<li>
					        		<input type="checkbox" id="turistaPasajeroExtranjero" name="complementos[turistaPasajeroExtranjero]" value="1" />
					        		Complemento Turista Pasajero Extranjero
					        	</li>
					        	<li>
					        		<input type="checkbox" id="personaFisicaIntegranteCoordinado" name="complementos[personaFisicaIntegranteCoordinado]" value="1" />
					        		Complemento Persona F&iacute;sica integrante de Coordinado
					        	</li>
					        	<li>
					        		<input type="checkbox" id="ine" name="complementos[ine]" value="1" />
					        		Complemento INE
					        	</li>
					        	<li>
					        		<input type="checkbox" id="leyendasFiscales" name="complementos[leyendasFiscales]" value="1" />
					        		Complemento Leyendas Fiscales
					        	</li>
					        	<li>
					        		<input type="checkbox" id="enajenacionObrasArtesPlasticasAntiguedades" name="complementos[enajenacionObrasArtesPlasticasAntiguedades]" value="1" />
					        		Complemento Enajenaci&oacute;n de Obras de Artes Pl&aacute;sticas y Antig&uuml;edades
					        	</li>
					        	<li>
					        		<input type="checkbox" id="certificadoDestruccion" name="complementos[certificadoDestruccion]" value="1" />
					        		Complemento Certificado de Destrucci&oacute;n
					        	</li>
					        	<li>
					        		<input type="checkbox" id="estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT12" name="complementos[estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT12]" value="1" />
					        		Complemento Estado de Cuenta de Combustibles para Monederos Electr&oacute;nicos Autorizados por el SAT 1.2
					        	</li>
					        	<li>
					        		<input type="checkbox" id="comercioExterior11" name="complementos[comercioExterior11]" value="1" />
					        		Complemento Comercio Exterior 1.1
					        	</li>
 				        	    <li>
					        		<input type="checkbox" id="conceptoCuentaTerceros" name="complementos[conceptoCuentaTerceros]" value="1" />
					        		Complemento Concepto Por Cuenta de Terceros
					        	</li>
					        	<li>
					        		<input type="checkbox" id="conceptoInstitucionesEducativasPrivadas" name="complementos[conceptoInstitucionesEducativasPrivadas]" value="1" />
					        		Complemento Concepto de Instituciones Educativas Privadas
					        	</li>
					        	<li>
					        		<input type="checkbox" id="conceptoVentaVehiculos" name="complementos[conceptoVentaVehiculos]" value="1" />
					        		Complemento Concepto de Venta de Veh&iacute;­culos
					        	</li>
					        </ul>
					      </div>
					    </div>
					  </div>
					</div>

				</div>
			</div>
		</div>
		<div class="modal-footer" style="clear: both;">
	<c:choose>
<c:when test="${action == 'Detalle'}">
			<button type="submit" class="btn btn-primary">Regresar</button>
</c:when>
<c:otherwise>
			<a href="${contextPath}/login/inicio" class="btn close-editar" data-dismiss="modal">Cancelar</a>
			<button type="submit" class="btn btn-primary">Aceptar</button>
</c:otherwise>
</c:choose>

		</div>
	</div>
</form:form>
