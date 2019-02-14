<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<jsp:useBean id="random" class="java.util.Random" scope="application" />
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<!--
	<script src="<c:url value="/static/resources/js/cfdi1.js?${random.nextInt()}" />"></script>
	 -->
<link rel="stylesheet" type="text/css" href="/CFDI33/static/resources/css/datepicker.css" />
<link rel="stylesheet" href="<c:url value="/static/resources/css/cfdi.css"/>">
<style>
	.form-horizontal .control-group { margin-bottom: 5px; }
	.add-on{ height: auto !important; }
	.hideWide{display: none !important;}
	@media only screen and (max-width: 767px) {
		.hideWide{display: block !important;}
		.group{border: 1px solid #ccc;}
	}
</style>

<div class="hidden">
	<input type="hidden" id="confiIEPS" value="${configuracion.usarIEPS}" />
	<input type="hidden" id="tenantID" value="${tenantID}" />
	<input type="hidden" id="numeroDecimales" value="${configuracion.numeroDecimales}" />
	<input type="hidden" id="confiClave" value="${configuracion.usarClave}" />
	<input type="hidden" id="confiDescuentos" value="${configuracion.usarDescuento}" />
	<input type="hidden" id="descuentoPorcentaje" value="${configuracion.descuentoPorcentaje}" />
	<input type="hidden" id="tasaISH" value="${configuracion.tasaISH}" />
	<input type="hidden" id="ivaIeps" value="${configuracion.ivaIeps}" />
</div>

<form name="comprobante" id="comprobanteForm">
	<div class="containter">
		<div id="invoice">
			<!-- Header de la factura -->
			<div id="header-invoice" c.form-horizontal .controlslass="container-fluid">
				<div class="row-fluid">
					<div class="span2 ">
						<!-- Logotipo -->
						<img src="<c:url value="/images/logo/" />${datosE.tenantId}"
							class="img-polaroid">
					</div>
					<div class="span6">
						<!-- Datos Fiscales del Emisor -->
						<h4>${datosE.razonSocial}</h4>
						<input type="hidden" name="nombre" class="emisor"
							value="${datosE.razonSocial}">
						<p>
							<b>R.F.C. </b> <span>${datosE.rfc}<input type="hidden"
								name="rfc" class="emisor" value="${datosE.rfc}"></span>
						</p>
						<p>
							<span>${datosE.codigoPostal}<input type="hidden" name="codigoPostal" class="emisorDomicilio" value="${datosE.codigoPostal}"></span>
						</p>
						<div class="row-fluid">
							<div class="span4"><label>Lugar de Expedici&oacute;n </label></div>
							<div class="span8">
								<select class="comprobante" id="lugarExpedicion">
									<c:forEach items="${mapLugaresExpedicion}" var="mapLugarExpedicion">
										<option value="${mapLugarExpedicion.codigoPostal}" ${configuracion.lugarDeExpedicion eq mapLugarExpedicion.codigoPostal ? 'selected':''}>${mapLugarExpedicion.nombre}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4"><span>Regimen Fiscal:</span></div>
							<div class="span8">
								<select class="regimen" id="regimen">
									<c:forEach items="${regimenes}" var="regimen">
										<option value="${regimen.clave}" ${datosE.regimenFiscal eq regimen.clave ? 'selected':''}>${regimen.nombre}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>

					<div class="span4 row-fluid" id="divSeries">
						<!-- Serie y Folio -->
						<h6>COMPROBANTE FISCAL DIGITAL A TRAV&Eacute;S DE INTERNET</h6>
						<div class="divRow">
							<input type="hidden" name="tipoDeComprobante" value="${tipoComprobante}" class="comprobante" />
							<div class="contenido" style="width: 25%">
								<label>Serie</label>
								<input type="text" id="serie" name="serie" class="comprobante text-center"  value="${configuracion.serie}" />
							</div>
							<div class="contenido" style="width: 25%">
								<label>Folio</label>
								<input type="text" id="folio" name="folio" class="comprobante text-center" />
							</div>
							<div class="contenido" style="width: 45%">
								<label>Fecha</label>
								<select name="fecha" id="fecha" class="comprobante text-center">
									<option value="${fecha}">${fn:substring(fecha, 0, 10)}</option>
								</select>
							</div>
						</div>
						<div class="divRow">
							<div class="span4"><b>Tipo de CFDI </b> &nbsp;</div>
							<div class="span8">
								<select id="btnTipoComprobante">
									<optgroup label="Ingreso">
										<option value="fa" ${tipoComprobante == "fa" ? "selected" : ""}>Factura</option>
										<option value="rh" ${tipoComprobante == "rh" ? "selected" : ""}>Recibode Honorarios</option>
										<option value="ra" ${tipoComprobante == "ra" ? "selected" : ""}>Recibo
											de Arrendamiento</option>
										<option value="ca" ${tipoComprobante == "ca" ? "selected" : ""}>Nota
											de Cargo</option>
										<option value="rd" ${tipoComprobante == "rd" ? "selected" : ""}>Recibo
											de Donativo</option>
									</optgroup>
									<optgroup label="Egreso">
										<option value="cr" ${tipoComprobante == "cr" ? "selected" : ""}>Nota
											de Cr&eacute;dito</option>
										<option value="ct" ${tipoComprobante == "ct" ? "selected" : ""}>Constancia
											de retenci&oacute;n</option>
										<option value="co" ${tipoComprobante == "co" ? "selected" : ""}>Nota
											de Cargo</option>
									</optgroup>
									<optgroup label="Traslado">
										<option value="cp" ${tipoComprobante == "cp" ? "selected" : ""}>Carta
											Porte</option>
									</optgroup>
								</select>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- fin header -->

			<!-- Receptor -->
			<div class="divReceptor form-inline row-fluid">
				<div class="divRow">
					<h4 class="blue">Facturar a:</h4>
					<div class="span6" style="margin-left: 0px;">
						<div class="span4"><label for="razonSocial">Nombre/Raz&oacute;n Social </label></div>
						<div class="span8">
							<input class="receptor" id="razonSocial" autocomplete="off" name="nombre" type="text"	placeholder="Raz&oacute;n Social o Clave" />
						</div>
					</div>
					<div class="span6">
						<div class="span4"><label>R.F.C</label> </div>
						<div class="span8">
							<input type="text" id="rfc" name="rfc" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="receptor" placeholder="R.F.C." />
						</div>
					</div>
				</div>
				<div class="divRow">
					<div class="span6">
						<div class="span4"><label>Correo electr&oacute;nico: </label></div>
						<div class="span8">
							<input type="text" id="email" name="email" placeholder="correo@empresa.com.mx" class="input-large receptor" />
						</div>
					</div>
					<div class="span6">
						<div class="span4"><label>Residencia Fiscal</label></div>
						<div class="span8">
							<select class="receptorDomicilio" name="pais" id="pais">
								<option value="default">Seleccionar</option>
								<c:forEach items="${paises}" var="pais">
									<option value="${pais.nombre}" ${pais.id eq 'MEX' ? 'selected':''}>${pais.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="divRow">
					<div class="span6">
						<div class="span4"><label>Num. Reg. Id Trib:: </label></div>
						<div class="span8">
							<input type="text" id="numRegIdTrib" name="numRegIdTrib" class="input-large receptor" />
						</div>
					</div>
					<div class="span6">
						<div class="span4"><label>Uso CFDI</label></div>
						<div class="span8">
							<select class="receptor" name="usoCFDI" id="usoCFDI">
								<option value="default">Seleccionar</option>
								<c:forEach items="${usosCFDI}" var="usoCFDI" >
								<option value="${usoCFDI.clave}">${usoCFDI.descripcion}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="divRow" style="clear: both;">
					<h4 class="blue">Forma de pago:</h4>
					<div class="span6" style="margin-left: 0px;">
						<div class="span4">
							<label>Forma de pago:</label>
						</div>
						<div class="span8">
							<select class="comprobante" name="formaPago" id="formaPago">
								<option value="default">Seleccionar</option>
								<c:forEach items="${formasPago}" var="formaPago" >
									<option value="${formaPago.clave}" ${configuracion.formaPago eq formaPago.id ? 'selected':''}>${formaPago.descripcion}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="span6">
						<div class="span4"><label>Condiciones de pago:</label></div>
						<div class="span8">
							<input type="text" maxlength="1000" name="condicionesDePago" id="condicionesDePago" value="Pago en una sola exhibici&oacute;n" class="comprobante" />
						</div>
					</div>
				</div>
				<div class="divRow">
					<div class="span6">
						<div class="span4"><label>Moneda:</label></div>
						<div class="span8">
							<select id="moneda" name="moneda" class="input-medium comprobante" value="${configuracion.moneda}">
								<option value="">Seleccionar</option>
								<c:forEach items="${listaMonedas}" var="moneda">
									<option value="${moneda.clave}" numDecimales="${moneda.decimales}" ${configuracion.moneda eq moneda.clave ? 'selected':''}>${moneda.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="span6">
						<div class="span4"><label>Tipo de cambio:</label></div>
						<div class="span4">
							<input type="text" id="tipoCambio" name="tipoCambio" value="${configuracion.tipoCambio}" class="comprobante" />
						</div>
					</div>
				</div>
				<div class="divRow">
					<div class="span6">
						<div class="span4"><label>M&eacute;todo de pago: </label></div>
						<div class="span8">
							<select id="metodoDePago" name="metodoDePago" class="comprobante">
								<option value="">Seleccionar</option>
								<c:forEach items="${metodosPago}" var="metodoPago">
									<option value="${metodoPago.clave}" ${configuracion.metodoDePago eq metodoPago.clave ? 'selected':''}>${metodoPago.descripcion}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="span6"></div>
				</div>
				<div class="row-fluid">
					<div class="span6 form-horizontal">
						<h4 class="blue">Origen:</h4>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Origen:</label></div>
			      			<div class="span9"><input type="text" name="origen" class="cartaPorte" /></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Remitente:</label></div>
			      			<div class="span9"><input type="text" name="remitente" class="cartaPorte" /></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">R.F.C.:</label></div>
			      			<div class="span9"><input type="text" name="rfcOrigen" class="cartaPorte" /></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Domicilio:</label></div>
			      			<div class="span9"><textarea name="domicilioOrigen" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Se recoger&aacute; en:</label></div>
			      			<div class="span9"><textarea name="recogerEn" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Condujo:</label></div>
			      			<div class="span9"><textarea name="condujo" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">DE:</label></div>
			      			<div class="span9"><textarea name="deOrigen" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">A:</label></div>
			      			<div class="span9"><textarea name="aOrigen" class="cartaPorte"></textarea></div>
						</div>
					</div>
					<div class="span6 form-horizontal">
						<h4 class="blue">Destino:</h4>
						<div class="control-group">
			    			<div class="span3"><label for="d">Destino:</label></div>
			      			<div class="span9"><input type="text" name="destino" class="cartaPorte" /></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Destinatario:</label></div>
			      			<div class="span9"><input type="text" name="destinatario" class="cartaPorte" /></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">R.F.C.:</label></div>
			      			<div class="span9"><input type="text" name="rfcDestino" class="cartaPorte" /></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Domicilio:</label></div>
			      			<div class="span9"><textarea name="domicilioDestino" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Se entregar&aacute; en:</label></div>
			      			<div class="span9"><textarea name="entregarEn" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">Conducir&aacute;:</label></div>
			      			<div class="span9"><textarea name="conducira" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">DE:</label></div>
			      			<div class="span9"><textarea name="deDestino" class="cartaPorte"></textarea></div>
						</div>
						<div class="control-group">
			    			<div class="span3"><label for="origen">A:</label></div>
			      			<div class="span9"><textarea name="aDestino" class="cartaPorte"></textarea></div>
						</div>
					</div>
				</div>
			</div>
			<div style="clear:both"></div>
			<div class="row-fluid">
				<h4 class="blue">Conceptos:</h4>
				<div class="form-inline">
					<div class="span4">
		    			<div class="span5"><label>FLETE</label></div>
		    			<div class="span7">
			    			<div class="input-prepend">
			    				<span class="add-on">$ </span>
			      				<input type="text" name="flete" class="cartaPorte-concepto" />
			    			</div>
		    			</div>
					</div>
					<div class="span4">
		    			<div class="span5"><label>CARGO POR SEGURO</label></div>
		    			<div class="span7">
			    			<div class="input-prepend">
			    				<span class="add-on">$ </span>
			      				<input type="text" name="cargo" class="cartaPorte-concepto" />
			    			</div>
		    			</div>
					</div>
					<div class="span4">
		    			<div class="span5"><label>MANIOBRAS</label></div>
		    			<div class="span7">
			    			<div class="input-prepend">
			    				<span class="add-on">$ </span>
			      				<input type="text" name="maniobras" class="cartaPorte-concepto" />
			    			</div>
		    			</div>
					</div>
				</div>
				<div class="form-inline" style="clear: both;">
					<div class="span4">
		    			<div class="span5"><label>AUTOPISTAS, LIBRAMIENTOS y TRANSPORTADORES</label></div>
		    			<div class="span7">
			    			<div class="input-prepend">
			    				<span class="add-on">$ </span>
			      				<input type="text" name="autopistas" class="cartaPorte-concepto" />
			    			</div>
			    		</div>
					</div>
					<div class="span4">
		    			<div class="span5"><label>OTROS</label></div>
		    			<div class="span7">
			    			<div class="input-prepend">
			    				<span class="add-on">$ </span>
			      				<input type="text" name="otros" class="cartaPorte-concepto" />
							</div>
						</div>
	    			</div>
	    			<div class="span4"></div>
				</div>
			</div>
			<div style="clear: both;"></div>
			<div class="row-fluid divRow">
				<h4 class="blue">Extras:</h4>
				<div class="span1">
					<div class="text-center">N&uacute;mero</div>
					<div><input type="text" /></div>
				</div>
				<div class="span2">
					<div class="text-center">Clase</div>
					<div><input type="text" /></div>
				</div>
				<div class="span4">
					<div class="text-center">Que el remitente dice que contiene (V)</div>
					<div><input type="text" /></div>
				</div>
				<div class="span1">
					<div class="text-center">Peso (V)</div>
					<div><input type="text" /></div>
				</div>
				<div class="span1">
					<div class="text-center">M3</div>
					<div><input type="text" /></div>
				</div>
				<div class="span2">
					<div class="text-center">Peso Estimado</div>
					<div><input type="text" /></div>
				</div>
			</div>
			<div class="row-fluid divRow">
				<div class="span9">
					<div class="span4"><label for="observaciones">Observaciones: </label></div>
					<div class="span8">
						<textarea id="observaciones" name="observaciones"></textarea>
					</div>
				</div>
			</div>
			<div style="clear: both;"></div>
			<div class="row-fluid">
				<div class="span9">
					<div class="row-fluid">
						<%--------------------------- Complementos ------------------------------------------------%>
						<div class="accordion form-inline" id="accordion2">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion2" href="#collapseThree"> Agregar Firmas</a>
								</div>
								<div id="collapseThree" class="accordion-body collapse">
									<div class="accordion-inner">
										<div class="row">
											<table id="tFirmas" class="table span7"></table>
										</div>
										<div class="divRow row-fluid">
											<div class="span6">
												<div class="span4"><label>Nombre: </label></div>
												<div class="span8"><input type="text" id="nombreFirma" name="nombreFirma" /></div>
											</div>
											<div class="span6">
												<div class="span4"><label>Puesto: </label></div>
												<div class="span8"><input type="text" id="puestoFirma" name="puestoFirma" /></div>
											</div>
										</div>
										<div class="divRow row-fluid">
											<div class="span6">
												<div class="span4"><label>Extra:</label></div>
												<div class="span8"><input type="text" id="extraFirma" name="extraFirma" /></div>
											</div>
											<div class="span6"></div>
										</div>
										<div class="divRow separate clear right">
											<a class="btn btn-primary" id="btnAddFirma">Agregar</a>
										</div>
									</div>
								</div>
							</div>

							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour"> Agregar Descuento </a>
								</div>
								<div id="collapseFour" class="accordion-body collapse">
									<div class="accordion-inner">
										<div class="row-fluid">
											<div class="span6">
												<div class="span4"><label>Motivo del descuento: </label></div>
												<div class="span8">
													<input type="text" id="motivoDescuento" name="motivoDescuento" />
												</div>
											</div>
											<div class="span6">
												<div class="span4"><label>Monto del decuento: </label></div>
												<div class="span8">
													<input type="text" id="montoDescuento" name="montoDescuento" />
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"> Agregar Impuestos Locales </a>
								</div>
								<div id="collapseOne" class="accordion-body collapse">
									<div class="accordion-inner">
										<div class="row group">
											<div class="span3">
												<label>Tipo:</label>
												<select name="tipoImpuesto" class="impLoc1">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span3">
												<label>Nombre:</label>
												<input type="text" name="impLoc" class="impLoc1" />
											</div>
											<div class="span3">
												<label>Tasa(%):</label>
												<input type="text" class="impLoc1" module="1" name="tasade" />
											</div>
											<div class="span3">
												<label>Importe:</label>
												<input type="text" class="impLoc1" name="importe" />
											</div>
										</div>
										<div class="row group">
											<div class="span3">
												<label class="hideWide">Tipo:</label>
												<select name="tipoImpuesto" class="impLoc2">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span3">
												<label class="hideWide">Nombre:</label>
												<input type="text" class="impLoc2" name="impLoc" />
											</div>
											<div class="span3">
												<label class="hideWide">Tasa(%):</label>
												<input type="text" class="impLoc2" module="2" name="tasade" />
											</div>
											<div class="span3">
												<label class="hideWide">Importe:</label>
												<input type="text" class="impLoc2" name="importe" />
											</div>
										</div>
										<div class="row group">
											<div class="span3">
												<label class="hideWide">Tipo:</label>
												<select name="tipoImpuesto" class="impLoc3">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span3">
												<label class="hideWide">Nombre:</label>
												<input type="text" class="impLoc3" name="impLoc" />
											</div>
											<div class="span3">
												<label class="hideWide">Tasa(%):</label>
												<input type="text" class="impLoc3" module="3" name="tasade" />
											</div>
											<div class="span3">
												<label class="hideWide">Importe:</label>
												<input type="text" class="impLoc3" name="importe" />
											</div>
										</div>
										<div class="row group">
											<div class="span3">
												<label class="hideWide">Tipo:</label>
												<select name="tipoImpuesto" class="impLoc4">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span3">
												<label class="hideWide">Nombre:</label>
												<input type="text" class="impLoc4" name="impLoc" />
											</div>
											<div class="span3">
												<label class="hideWide">Tasa(%):</label>
												<input type="text" class="impLoc4" module="4" name="tasade" />
											</div>
											<div class="span3">
												<label class="hideWide">Importe:</label>
												<input type="text" class="impLoc4" name="importe" />
											</div>
										</div>
										<div class="row group">
											<div class="span3">
												<label class="hideWide">Tipo:</label>
												<select name="tipoImpuesto" class="impLoc5">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span3">
												<label class="hideWide">Nombre:</label>
												<input type="text" name="impLoc" class="impLoc5" />
											</div>
											<div class="span3">
												<label class="hideWide">Tasa(%):</label>
												<input type="text" class="impLoc5" module="5" name="tasade" />
											</div>
											<div class="span3">
												<label class="hideWide">Importe:</label>
												<input type="text" class="impLoc5" name="importe" />
											</div>
										</div>
										<div class="row group">
											<div class="span3">
												<label class="hideWide">Tipo:</label>
												<select name="tipoImpuesto" class="impLoc6">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span3">
												<label class="hideWide">Nombre:</label>
												<input type="text" name="impLoc" class="impLoc6" />
											</div>
											<div class="span3">
												<label class="hideWide">Tasa(%):</label>
												<input type="text" class="impLoc6" module="6" name="tasade" />
											</div>
											<div class="span3">
												<label class="hideWide">Importe:</label>
												<input type="text" class="impLoc6" name="importe" />
											</div>
										</div>
										<div class="row group">
											<div class="span3">
												<label class="hideWide">Tipo:</label>
												<select name="tipoImpuesto" class="impLoc7">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span3">
												<label class="hideWide">Nombre:</label>
												<input type="text" name="impLoc" class="impLoc7" />
											</div>
											<div class="span3">
												<label class="hideWide">Tasa(%):</label>
												<input type="text" class="impLoc7" module="7" name="tasade" />
											</div>
											<div class="span3">
												<label class="hideWide">Importe:</label>
												<input type="text" class="impLoc7" name="importe" />
											</div>
										</div>
									</div>
									<!-- accord inner -->
								</div>
							</div>
							<!-- accord group -->
						</div>
					</div>
				</div>
				<div id="divTotales" class="span3">
					<!--Body content-->
					<table id="tablaTotales" cellpadding="0" colspanding="0">
						<tr>
							<th><label>Subtotal </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="subTotal"
										readonly="readonly" value="0.00" type="text"
										class="comprobante"> <input
										name="totalImpuestosTrasladados" type="hidden">
								</div>
							</td>
						</tr>
						<tr>
							<th><label>Descuento </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="totalDescuento"
										readonly="readonly" value="0.00" type="text"
										class="comprobante">
								</div>
							</td>
						</tr>
						<tr>
							<th><label>I.E.P.S.: </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="totalIEPS"
										id="totalIEPS" readonly="readonly" value="0.00" type="text"
										class="comprobante">
								</div>
							</td>
						</tr>
						<tr>
							<th><label>I.V.A: </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="totalIVA"
										readonly="readonly" value="0.00" type="text"
										class="comprobante">
								</div>
							</td>
						</tr>
						<tr>
							<th><label>I.V.A.: Retenido</label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="totalIVARetenido"
										value="" placeholder="0.00" type="text" class="comprobante">
								</div>
							</td>
						</tr>

						<tr>
							<th><label>I.S.R.: Retenido</label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="totalISRRetenido"
										value="" placeholder="0.00" type="text" class="comprobante">
								</div>
							</td>
						</tr>
						<tr class="totalDeRetenciones">
							<th><label>Total Retenciones: </label></th>
							<td class="totalDeRetenciones">
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="totalDeRetenciones"
										readonly="readonly" value="0.00" type="text"
										class="comprobante totalDeRetenciones">
								</div>
							</td>
						</tr>
						<tr class="totalDeTraslados">
							<th><label>Total Traslados: </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="totalDeTraslados"
										readonly="readonly" value="0.00" type="text"
										class="comprobante">
								</div>
							</td>
						</tr>
						<tr>
							<th><label>Total: </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span> <input name="total"
										readonly="readonly" value="0.00" type="text"
										class="comprobante">
								</div>
							</td>
						</tr>
					</table>
				</div>
				<!-- fin totales -->
			</div>
			<!-- fin row -->
</form>
	<div class="divRow row-fluid">
		<div class="span3 offset3">
			<form id="formVistaPrevia" action="${contextPath}/comprobante/vistaPrevia" method="post" target="_blank">
				<input type="hidden" name="strComprobante" class="strComprobante">
				<label for="vistaPrevia" class="btn btn-success">
					<i class="icon-white icon-eye-open"></i> Vista previa
				</label>
				<input type="submit" id="vistaPrevia" value="Vista Previa" class="hide" />
			</form>
		</div>
		<form id="formGenerarComprobante" action="${contextPath}/comprobante/timbrarComprobante" method="post">
			<input type="hidden" name="strComprobante" class="strComprobante">
			<label for="generarComprobante" class="btn btn-success">
				<i class="icon-white icon-file"></i> Generar Comprobante
			</label>
			<input type="submit" id="generarComprobante" data-loading-text="Generando comprobante..." value="Generar Comprobante" class="hide" />
		</form>
	</div>
</div>
<!-- fin invoice -->
<script	src="https://portal1.expidetufactura.com.mx/js/nuevo_cfdi_carta_porte33.js?${random.nextInt()}" /></script>
<link rel="stylesheet" href="<c:url value="/static/resources/css/redmond/jquery-ui-1.10.3.custom.min.css"/>">
<script src="/CFDI33/static/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/CFDI33/static/resources/js/bootstrap-datepicker.js">
	
</script>
<script>
	function valid(f) {
		!(/^[A-z&#209;&#241;0-9]*$/i).test(f.value) ? f.value = f.value
				.replace(/[^A-z&#209;&#241;0-9]/ig, '') : null;
	}
</script>