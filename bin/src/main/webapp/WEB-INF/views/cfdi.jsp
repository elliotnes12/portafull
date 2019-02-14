

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
	<jsp:useBean id="random" class="java.util.Random" scope="application" />
	<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<link rel="stylesheet" href="<c:url value="/static/resources/css/cfdi.css"/>">
	<link rel="stylesheet" type="text/css" href="/CFDI33/static/resources/css/datepicker.css" />
	<div class="hidden">
		<input type="hidden" id="tenantID" value="${tenantID}">
		<input type="hidden" id="numeroDecimales" value="${configuracion.numeroDecimales}">
		<input type="hidden" id="confiClave" value="${configuracion.usarClave}">
		<input type="hidden" id="confiDescuentos" value="${configuracion.usarDescuento}">
		<input type="hidden" id="descuentoPorcentaje" value="${configuracion.descuentoPorcentaje}">
		<input type="hidden" id="complementoAIncluir" value="">
	</div>
<div class="containter">
	<div id="invoice">
		<form name="comprobante" id="comprobanteForm">
			<!-- Header de la factura -->
			<div id="header-invoice" class="container-fluid">
				<div class="row-fluid">
				<input type="hidden" name="numDecimales" class="comprobante" value="">
					<div class="span2" style="margin-left: 0px"><!-- Logotipo -->
						<img src="<c:url value="/images/logo/" />${datosE.tenantId}" class="img-polaroid">
					</div>
					<div class="span6"><!-- Datos Fiscales del Emisor -->
						<h4>${datosE.razonSocial}
							<!--  <button class="btn btn-prefactura comprobante" style="display:block;width:150px; height:30px;" onclick="document.getElementById('files').click()">Cargar prefactura</button>
							<input type='file' id="files" style="display:none">-->
						</h4>
						<input type="hidden" name="nombre" class="emisor" value="${datosE.razonSocial}">
						<p>
							<b>R.F.C. </b>
							<span>${datosE.rfc}<input type="hidden" name="rfc" class="emisor" value="${datosE.rfc}" id="emisorRfc"></span>
						</p>
						<div class="row-fluid">
							<div class="span4">
								<p>
									<b>C&oacute;digo Postal</b> <span>
										${datosE.codigoPostal}<input type="hidden" name="codigoPostal"
										class="emisorDomicilio" value="${datosE.codigoPostal}"
										id="emisorLugarExpedicion">
									</span>
								</p>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4"><label class="required">Lugar de Expedici&oacute;n </label></div>
							<div class="span8">
								<select class="comprobante" id="lugarExpedicion" name="lugarExpedicion">
									<option value="">Seleccionar</option>
									<c:forEach items="${mapLugaresExpedicion}" var="mapLugarExpedicion" >
										<option value="${mapLugarExpedicion.codigoPostal}" ${configuracion.lugarDeExpedicion eq mapLugarExpedicion.codigoPostal ? 'selected':''}>${mapLugarExpedicion.nombre}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span4"><span class="required">Regimen Fiscal</span></div>
							<div class="span8">
								<select class="regimen" id="regimen" name="regimen">
									<option value="">Seleccionar</option>
									<c:forEach items="${regimenes}" var="regimen" >
										<option value="${regimen.clave}" ${datosE.regimenFiscal eq regimen.clave ? 'selected':''}>${regimen.nombre}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="span4" id="divSeries" style="margin-top: 8px"><!-- Serie y Folio -->
						<h6>COMPROBANTE FISCAL DIGITAL A TRAV&Eacute;S DE INTERNET</h6>
						<input type="hidden" name="tipoDeComprobante" value="${tipoComprobante}" class="comprobante"/>
						<div class="contenido" style="width: 25%">
							<label>Serie</label>
							<input type="text" maxlength="25" id="serie" name="serie" class="input-small comprobante text-center" placeholder="" value="${configuracion.serie}">
						</div>
						<div class="contenido" style="width: 25%">
							<label>Folio</label>
							<input type="text" maxlength="40" id="folio" name="folio" class="input-small comprobante text-center" placeholder="">
						</div>
						<div class="contenido" style="width: 45%">
							<label>Fecha</label>
							<select name="fecha" id="fecha" class="input-medium comprobante text-center">
								<option value="${fecha}">${fn:substring(fecha, 0, 10)}</option>
							<!-- <option value="2014-12-31T19:00:00">2014-12-31</option>-->

							</select>
							<!-- <input type="text" value="${fecha}" id="fecha" name="fecha" class="input-medium comprobante text-center" placeholder=""> -->
						</div>
						<div class="row-fluid" style="margin-top: 10px;">
							<div class="span4 offset1"><b>Tipo de CFDI </b> &nbsp;</div>
							<div class="span7">
								<select id="btnTipoComprobante">
									<optgroup label="Ingreso">
										<option value="fa" ${tipoComprobante == "fa" ? "selected" : ""}>Factura</option>
										<c:if test="${gratuito == false}">
											<option value="rh" ${tipoComprobante == "rh" ? "selected" : ""}>Recibo de Honorarios</option>
											<option value="ra" ${tipoComprobante == "ra" ? "selected" : ""}>Recibo de Arrendamiento</option>
											<option value="ca" ${tipoComprobante == "ca" ? "selected" : ""}>Nota de Cargo</option>
											<option value="rd" ${tipoComprobante == "rd" ? "selected" : ""}>Recibo de Donativo</option>
										</c:if>
									</optgroup>
									<optgroup label="Egreso">
											<option value="cr" ${tipoComprobante == "cr" ? "selected" : ""}>Nota de Cr&eacute;dito</option>
										<c:if test="${gratuito == false}">
											<option value="ct" ${tipoComprobante == "ct" ? "selected" : ""}>Constancia de retenci&oacute;n</option>
											<option value="co" ${tipoComprobante == "co" ? "selected" : ""}>Nota de Cargo</option>
										</c:if>
									</optgroup>
									<optgroup label="Traslado">
											<option value="cp" ${tipoComprobante == "cp" ? "selected" : ""}>Carta Porte</option>
									</optgroup>
									<optgroup label="Pago">
											<option value="pa" ${tipoComprobante == "pa" ? "selected" : ""}>Pago</option>
									</optgroup>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div><!-- fin header -->

			<!-- Receptor -->
			<div class="divReceptor form-inline">
				<div class="divRow row-fluid">
					<h4 class="blue">Facturar a:</h4>
					<div class="span6" style="margin-left: 0px">
						<div class="span4"><label for="razonSocial">Nombre/Raz&oacute;n Social: </label></div>
						<div class="span8">
							<input class="receptor" maxlength="254" id="nombreReceptor" autocomplete="off" name="nombreReceptor" type="text" placeholder="Raz&oacute;n Social o Clave">
						</div>
					</div>
					<div class="span6">
						<div class="span3">
							<label for="rfc" class="required">R.F.C :</label>
						</div>
						<div class="span9">
							<input type="text" id="rfc" name="rfc" autocomplete="off" class="receptor" placeholder="R.F.C.">
						</div>
					</div>
				</div>
				<div class="divRow row-fluid">
					<div class="span6">
						<div class="span4">
							<label for="email" class="required">Correo electr&oacute;nico: </label>
						</div>
						<div class="span8">
							<input type="text" id="email" name="email" placeholder="correo@empresa.com.mx" class="receptor">
						</div>
					</div>
					<div class="span6">
						<div class="span3">
							<label for="usoCFDI" class="required">Uso CFDI:</label>
						</div>
						<div class="span9">
							<select class="receptor" name="usoCFDI" id="usoCFDI">
								<option value="default">Seleccionar</option>
								<c:forEach items="${usosCFDI}" var="usoCFDI" >
								<option value="${usoCFDI.clave}">${usoCFDI.clave} ${usoCFDI.descripcion}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="divRow row-fluid">
					<div class="span6">
						<div class="span4">
							<label for="pais">Residencia Fiscal <span class="underline"><strong>EXTRANJEROS</strong></span>:</label>
						</div>
						<div class="span8">
							<select class="receptor" name="residenciaFiscal" id="residenciaFiscal">
								<option value="default">Seleccionar</option>
								<c:forEach items="${paises}" var="pais" >
								<option value="${pais.id}">${pais.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="span6">
						<div class="span3">
							<label for="numRegIdTrib">Num. Reg. Id Trib: </label>
						</div>
						<div class="span9">
							<input type="text" id="numRegIdTrib" name="numRegIdTrib" maxlength="40" class="receptor">
						</div>
					</div>
				</div>
				<div class="row-fluid divRow">
					<h4 class="blue">Forma de pago:</h4>
					<div class="row-fluid divRow">
						<div class="span6">
							<div class="span4"><label for="formaPago">Forma de pago: </label></div>
							<div class="span8">
								<select class="comprobante" name="formaPago" id="formaPago">
									<option value="default">Seleccionar</option>
									<c:forEach items="${formasPago}" var="formaPago" >
										<option value="${formaPago.clave}" ${configuracion.formaPago eq formaPago.clave ? 'selected':''}>${formaPago.clave} ${formaPago.descripcion}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="span6">
							<div class="span3"><label>Condiciones de pago:</label></div>
							<div class="span6">
								<input type="text" maxlength="1000" name="condicionesDePago" id="condicionesDePago" value="Pago en una sola exhibici&oacute;n" class="comprobante">
							</div>
						</div>
					</div>
					<div class="row-fluid divRow">
						<div class="span6">
							<div class="span4"><label for="moneda" class="required">Moneda:</label></div>
							<div class="span8">
								<select id="moneda" name="moneda" class="comprobante" value="${configuracion.moneda}">
									<option value="">Seleccionar</option>
									<c:forEach items="${listaMonedas}" var="moneda" >
										<option value="${moneda.clave}" numDecimales="${moneda.decimales}" ${configuracion.moneda eq moneda.clave ? 'selected':''}>${moneda.nombre}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="span6">
							<div class="span3"><label for="tipoCambio">Tipo de cambio:</label></div>
							<div class="span4">
								<div class="input-prepend input-append">
									<span class="add-on">$ </span>
									<input type="text" id="tipoCambio" name="tipoCambio" value="${configuracion.tipoCambio}" class="comprobante">
								</div>
							</div>
						</div>
					</div>
					<div class="row-fluid divRow">
						<div class="span6">
							<div class="span4"><label>Método de pago:</label></div>
							<div class="span8">
								<select class="comprobante" name="metodoPago" id="metodoPago">
									<option value="default">Seleccionar</option>
									<c:forEach items="${metodosPago}" var="metodoPago" >
										<option value="${metodoPago.clave}" ${configuracion.metodoDePago eq metodoPago.clave ? 'selected':''}>${metodoPago.clave} ${metodoPago.descripcion}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="formAgregarConcepto"><!--Conceptos -->
				<h4 class="blue">Agregar conceptos</h4>
				<div class="row-fluid form-inline divRow">
					<div class="span3">
						<div class="span5"><label for="claveProdServ" class="required">Clave Prod/Serv:</label></div>
						<div class="span7">
							<input type="text" id="claveProdServ" name="claveProdServ" class="input" />
						</div>
					</div>
					<div class="span3">
						<a target="_blank" href="http://200.57.3.46:443/PyS/catPyS.aspx">Catálogo de Productos SAT</a>
					</div>
					<div class="span3">
						<a target="_blank" href="http://www.sat.gob.mx/informacion_fiscal/factura_electronica/paginas/criterios_catalogo_productos_servicios.aspx">Sugerencias de Claves SAT</a>
					</div>
					<div class="divClave span3">
						<div class="span5"><label for="clave">No. Identificación:</label></div>
						<div class="span7">
							<input type="text" maxlength="100" id="clave" name="clave" class="input" />
						</div>
					</div>
				</div>
				<div class="row-fluid divRow">
					<div class="span3"><!--Configurar Factura -->
						<!--
						<input type="checkbox" ${configuracion.usarDescuento ? "checked" : ""} name="mDes" class="mostrarDetalle" modulo="Descuento" >
						<label for="mDes">Descuentos</label>
						 -->
						<div class="span2 offset3">
							<input type="checkbox" ${configuracion.usarClave ? "checked" : ""} name="mClave" class="mostrarDetalle" modulo="Clave">
						</div>
						<div class="span7"><label for="mClave">No. Identificación</label></div>
					</div>
				</div>
				<div class="row-fluid form-inline divRow">
					<div class="span3">
						<div class="span5"><label for="cantidad" class="required">Cantidad:</label></div>
						<div class="span7">
							<input type="text" id="cantidad" name="cantidad" class="input" />
						</div>
					</div>
				</div>
				<div class="row-fluid form-inline divRow">
					<div class="span3">
						<div class="span5"><label for="claveUnidad" class="required">Clave Unidad Medida:</label></div>
						<div class="span7">
							<select id="claveUnidad" name="claveUnidad" class="input">
								<option value="">Seleccionar</option>
								<c:forEach items="${listaUnidades}" var="unidad" >
									<option value="${unidad.clave}" ${configuracion.unidadMedida eq unidad.clave ? 'selected':''}>${unidad.clave} - ${unidad.nombre}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="span3">
						<div class="span5"><label for="unidad">Unidad:</label></div>
						<div class="span7">
							<input type="text" maxlength="20" id="unidad" name="unidad" class="input">
						</div>
					</div>
					<c:if test="${tipoComprobante.equals('ra')}">
					<div class="span3">
						<div class="span5"><label>Cuenta Predial:</label></div>
						<div class="span7">
							<input type="text" id="numeroCuentaPredial" name="numeroCuentaPredial" class="input">
						</div>
					</div>
					</c:if>
				</div>
				<div class="row-fluid divRow">
					<div class="span3">
						<div class="span5"><label for="valorUnitario" class="required">Precio unitario:</label></div>
						<div class="span7">
							<div class="input-prepend input-append">
								<span class="add-on">$ </span>
								<input type="text" id="valorUnitario" name="valorUnitario" class="input-medium input">
							</div>
						</div>
					</div>
					<div class="span3">
						<span class="divDescuento">
							<div class="span5"><label>Descuento:</label></div>
							<div class="span7">
							<c:choose>
							<c:when test="${configuracion.descuentoPorcentaje eq true}">
								<span class="input-prepend input-append">
									<input type="text" id="descuento" name="descuento" class="input">
									<span class="add-on">%</span>
								</span>
							</c:when>
							<c:when test="${configuracion.descuentoPorcentaje eq false}">
								<span class="input-prepend input-append">
								<span class="add-on">$ </span>
									<input type="text" id="descuento" name="descuento" class="input">
								</span>
							</c:when>
							</c:choose>
							</div>
						</span>
					</div>
				</div>
				<div class="row-fluid">
					<div class="offset1 accordion" id="accordion3">
						<div class="accordion-group">
						    <div class="accordion-heading">
						        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapseConceptoTraslado">
						            <h5 class="blue clear">Traslados:</h5>
						        </a>
						    </div>
						    <div id="collapseConceptoTraslado" class="accordion-body collapse in">
						    	<div class="accordion-inner">
									<div class="divRow row-fluid">
										<div class="span4">
											<div class="span5"><label for="baseTrasladoConcepto" class="required">Base:</label></div>
											<div class="span7">
												<div class="input-prepend input-append">
													<span class="add-on">$ </span><input type="text" id="baseTrasladoConcepto" name="baseTrasladoConcepto" />
												</div>
											</div>
										</div>
										<div class="span4">
											<div class="span5"><label for="impuestoTrasladoConcepto" class="required">Impuesto:</label></div>
											<div class="span7">
												<select id="impuestoTrasladoConcepto" name="impuestoTrasladoConcepto">
													<option value="002">IVA</option>
													<option value="003">IEPS</option>
												</select>
											</div>
										</div>
										<div class="span4">
											<div class="span5"><label for="tipoFactorTrasladoConcepto" class="required">Tipo Factor:</label></div>
											<div class="span7">
												<select id="tipoFactorTrasladoConcepto" name="tipoFactorTrasladoConcepto">
													<option value="Tasa">Tasa</option>
													<option value="Exento">Exento</option>
												</select>
											</div>
										</div>
									</div>
									<div class="divRow row-fluid">
										<div class="span4">						
											<div class="span5"><label for="tasaCuotaTrasladoConcepto">Tasa o Cuota:</label></div>
											<div class="span7">
												<div class="divTasaCuotaTrasladoConceptoFijo">
													<select id="tasaCuotaTrasladoConceptoFijo" name="tasaCuotaTrasladoConceptoFijo" >
														<option value="0.000000" ${configuracion.iva eq 0 ? 'selected':''}>0.000000</option>
														<option value="0.080000" ${configuracion.iva eq 8 ? 'selected':''}>0.080000</option>
														<option value="0.160000" ${configuracion.iva eq 16 ? 'selected':''}>0.160000</option>
													</select>
												</div>
												<div class="divTasaCuotaTrasladoConceptoRango">
													<input type="text" id="tasaCuotaTrasladoConceptoRango" name="tasaCuotaTrasladoConceptoRango" maxlength="8"/>
												</div>
											</div>
										</div>
										<div class="span4">
											<div class="span5"><label for="importeTrasladoConcepto">Importe<sup>(1)</sup>:</label></div>
											<div class="span7">
												<div class="input-prepend input-append">
													<span class="add-on">$ </span>
													<input type="text" id="importeTrasladoConcepto" name="importeTrasladoConcepto" class="input" readonly="true"/>
												</div>
											</div>
										</div>
									</div>
									<div class="divRow clear separate right">
										<a href="#" id="btnAgregarTrasladoConcepto" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
									</div>
									<div class="divRow">
										<label>
											<sup>(1)El valor de este atributo debe ser mayor o igual que el límite inferior y menor o igual que el límite superior como lo establece el SAT. Consultar el anexo 20 para más información.</sup>
										</label>
									</div>
									<div id="mTrasladosConcepto" class="overloadedTable clear separate">
										<table id="tablaTrasladosConcepto" class="table-striped table-hover table-bordered text-center">
											<thead>
												<tr>
													<th class="span1">Base</th>
													<th class="span1">Impuesto</th>
													<th class="span1">Tipo Factor</th>
													<th class="span1">Tasa o Cuota</th>
													<th class="span1">Importe</th>
													<th class="span1"></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-group">
						    <div class="accordion-heading">
						        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapseConceptoRetencion">
									<h5 class="blue clear">Retenciones:</h5>
								</a>
							</div>
							<div id="collapseConceptoRetencion" class="accordion-body collapse">
						    	<div class="accordion-inner">
									<div class="divRow row-fluid">
										<div class="span4">
											<div class="span5"><label for="baseRetencionConcepto" class="required">Base:</label></div>
											<div class="span7">
												<div class="input-prepend input-append">
													<span class="add-on">$ </span>
													<input type="text" id="baseRetencionConcepto" name="baseRetencionConcepto" />
												</div>
											</div>
										</div>
										<div class="span4">
											<div class="span5"><label for="impuestoRetencionConcepto" class="required">Impuesto:</label></div>
											<div class="span7">
												<select id="impuestoRetencionConcepto" name="impuestoRetencionConcepto" >
													<option value="002">IVA</option>
													<option value="003">IEPS</option>
													<option value="001">ISR</option>
												</select>
											</div>
										</div>
										<div class="span4">
											<div class="span5"><label for="tipoFactorRetencionConcepto" class="required">Tipo Factor:</label></div>
											<div class="span7">
												<select id="tipoFactorRetencionConcepto" name="tipoFactorRetencionConcepto" >
													<option value="Tasa">Tasa</option>
												</select>
											</div>
										</div>
									</div>
									<div class="divRow row-fluid">
										<div class="span4">
											<div class="span5"><label for="tasaCuotaRetencionConcepto" class="required">Tasa o Cuota:</label></div>
											<div class="span7">
												<div class="divTasaCuotaRetencionConceptoFijo">
													<select id="tasaCuotaRetencionConceptoFijo" name="tasaCuotaRetencionConceptoFijo" >
													</select>
												</div>
												<div class="divTasaCuotaRetencionConceptoRango">
													<input type="text" id="tasaCuotaRetencionConceptoRango" name="tasaCuotaRetencionConceptoRango" maxlength="8"/>
												</div>
											</div>
										</div>
										<div class="span4">
											<div class="span5"><label for="importeRetencionConcepto" class="required">Importe <sup>(1)</sup>:</label></div>
											<div class="span7">
											<div class="input-prepend input-append">
												<span class="add-on">$ </span>
													<input type="text" id="importeRetencionConcepto" name="importeRetencionConcepto" readonly="true"/>
												</div>
											</div>
										</div>
									</div>
									<div class="divRow clear separate right">
										<a href="#" id="btnAgregarRetencionConcepto" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
									</div>
									<div class="divRow">
										<label>
											<sup>(1) El valor de este atributo debe ser mayor o igual que el límite inferior y menor o igual que el límite superior como lo establece el SAT. Consultar el anexo 20 para más información.</sup>
										</label>
									</div>
									<div id="mRetencionesConcepto" class="overloadedTable separate">
										<table id="tablaRetencionesConcepto" class="table table-striped table-hover table-bordered text-center">
											<thead>
												<tr>
													<th class="span1">Base</th>
													<th class="span1">Impuesto</th>
													<th class="span1">Tipo Factor</th>
													<th class="span1">Tasa o Cuota</th>
													<th class="span1">Importe</th>
													<th class="span1"></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-group">
						    <div class="accordion-heading">
						        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapseConceptoInfAduanera">
									<h5 class="blue clear">Informaci&oacute;n Aduanera:</h5>
								</a>
							</div>
							<div id="collapseConceptoInfAduanera" class="accordion-body collapse">
						    	<div class="accordion-inner">
									<div class="divRow row-fluid">
										<div class="span6">
											<div class="span4"><label for="numeroPedimentoConcepto" class="required">N&uacute;mero Pedimento:</label></div>
											<div class="span8">
												<input type="text" id="numeroPedimentoConcepto" name="numeroPedimentoConcepto" maxlength="21"/>
											</div>
										</div>
										<div class="divRow clear separate right">
											<a href="#" id="btnAgregarInformacionAduaneraConcepto" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
										</div>
										<div id="mInformacionAduaneraConcepto" class="clear overloadedTable">
											<table id="tablaInformacionAduaneraConcepto" class="table-striped table-hover table-bordered text-center" style="display: none">
												<thead>
													<tr>
														<th class="span1">N&uacute;mero Pedimento</th>
														<th class="span1"></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="accordion-group">
						    <div class="accordion-heading">
						        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion3" href="#collapseConceptoParte">
									<h5 class="blue clear">Parte:</h5>
								</a>
							</div>
							<div id="collapseConceptoParte" class="accordion-body collapse">
						    	<div class="accordion-inner">
									<div class="divRow row-fluid">
										<div class="divRow">
											<div class="span4">
												<div class="span5"><label for="claveProdServParte" class="required">Clave Prod/Serv:</label></div>
												<div class="span7">
													<input type="text" id="claveProdServParte" name="claveProdServParte" class="input" />
												</div>
											</div>
											<div class="span4">
												<div class="span5"><label for="claveParte">No. Identificaci&oacute;n:</label></div>
												<div class="span7">
													<input type="text" maxlength="100" id="claveParte" autocomplete="off"  name="claveParte" class="input" />
												</div>
											</div>
											<div class="span4">
												<div class="span5"><label for="cantidadParte" class="required">Cantidad:</label></div>
												<div class="span7">
													<input type="text" id="cantidadParte" name="cantidadParte" class="input" />
												</div>
											</div>
										</div>
										<div class="divRow">
											<div class="span4">
												<div class="span5"><label for="unidadParte">Unidad:</label></div>
												<div class="span7">
													<input type="text" maxlength="20" id="unidadParte" name="unidadParte" class="input">
												</div>
											</div>
											<div class="span4">
												<div class="span5"><label for="valorUnitarioParte">Precio unitario:</label></div>
												<div class="span7">
													<div class="input-prepend input-append">
													<span class="add-on">$ </span>
													<input type="text" id="valorUnitarioParte" name="valorUnitarioParte" class="input-medium input">
												</div>
												</div>
											</div>
											<div class="span4">
												<div class="span5"><label for="importeParte">Importe <sup>(1)</sup>:</label></div>
												<div class="span7">
													<input type="text" id="importeParte" name="importeParte" class="input" />
												</div>
											</div>
										</div>
										<div class="divRow">
											<div class="span8">
												<div class="span3"><label for="conceptoParte" class="required">Descripción:</label></div>
												<div class="span9">
													<textarea id="conceptoParte" maxlength="1000" name="conceptoParte" autocomplete="off" class="input" rows="3"></textarea>
												</div>
											</div>
										</div>
										<div style="clear: both;">
											<div class="divRow">
												<label>
													<sup>(1)El valor de este atributo debe ser mayor o igual que el límite inferior y menor o igual que el límite superior como lo establece el SAT. Consultar el anexo 20 para más información.</sup>
												</label>
											</div>
											<div class="divRow clear separate right">
												<a href="#" id="btnAgregarParte" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
											</div>
											<div id="mInformacionParteConcepto" class="clear overloadedTable">
											<table id="tablaInformacionParteConcepto" class="table-striped table-hover table-bordered text-center" style="display: none">
												<thead>
													<tr>
														<th class="span1">CveProdServ</th>
														<th class="span1">N. Ident</th>
														<th class="span1">Cantidad</th>
														<th class="span1">Unidad</th>
														<th class="span1">Precio Un.</th>
														<th class="span1">Importe</th>
														<th class="span1">Descripción</th>
														<th class="span1"></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										</div>
										<div class="divRow row-fluid clear">
											<div class="offset1">
												<div class="accordion-group">
												    <div class="accordion-heading">
												        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseConceptoParteInfAduanera">
															<h6 class="blue clear">Informaci&oacute;n Aduanera:</h6>
														</a>
													</div>
													<div id="collapseConceptoParteInfAduanera" class="accordion-body collapse">
												    	<div class="accordion-inner">
															<div class="divRow">
																<div class="span6">
																	<div class="span5"><label for="numeroPedimentoParte" class="required">N&uacute;mero Pedimento:</label></div>
																	<div class="span7">
																		<input type="text" id="numeroPedimentoParte" name="numeroPedimentoParte" maxlength="21"/>
																	</div>
																</div>
															</div>
															<div class="divRow right separate clear">
																<a href="#" id="btnAgregarInformacionAduaneraParte" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
															</div>
															<div id="mInformacionAduaneraParte" class="clear">
																<table id="tablaInformacionAduaneraParte" class="table-striped table-hover table-bordered text-center">
																	<thead>
																		<tr>
																			<th class="span1">N&uacute;mero Pedimento</th>
																			<th class="span1"></th>
																		</tr>
																	</thead>
																	<tbody>
																	</tbody>
																</table>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>	
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row-fluid divRow">
					<div class="span6">
						<div class="span3"><label for="concepto" class="required">Concepto:</label></div>
						<div class="span9">
							<textarea id="descripcion" maxlength="1000" name="descripcion" autocomplete="off" class="input" rows="3"></textarea>
						</div>
					</div>
					<div class="span1 offset3">
						<a href="#" id="btnAgregarConcepto" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar Concepto</a>
					</div>
				</div>
				<div class="divConfirmacion form-inline">
					<div class="divRow row-fluid">
						<h4 class="blue">Confirmación:</h4>
						<div class="span3" style="margin-left: 0px">
							<div class="span5"><label for="confirmacion">Confirmación:</label></div>
							<div class="span7">
								<input type="text" maxlength="5" id="confirmacion" name="confirmacion" class="comprobante" />
							</div>
						</div>
					</div>
				</div>
				<div id="mConceptos">
					<table id="tablaConceptos" class="table table-striped table-hover table-bordered text-center">
						<thead>
							<tr>
								<th class="span1">CvePrdSrv</th>
								<th class="span1">Cant</th>
								<th class="span1">CveUMed</th>
								<th class="span1">Unidad</th>
								<th class="span1 divClave">N.Id</th>
								<th class="span4" style="text-align:center">Concepto</th>
								<th class="span1">Precio</th>
								<th class="span1 divDescuento">Descuento</th>
								<th class="span1">Importe</th>
								<th class="span1">IVA</th>
								<th class="span1 divIEPS">IEPS</th>
								<th class="span1"></th>
								<th class="span1"></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div> <!-- Fin conceptos -->
			<div class="accordion" id="accordion4">
				<div class="divCFDIsRelacionados form-inline accordion-group">
					<div class="accordion-heading">
				    	<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion4" href="#collapseOneCFDIRel" style="padding: 0px">
							<h4 class="blue">CFDIs Relacionados:</h4>
				    	</a>
				    </div>
				    <div id="collapseOneCFDIRel" class="accordion-body collapse">
			        	<div class="accordion-inner">
							<div class="divRow row-fluid">
								<div class="row-fluid form-inline divRow">
									<div class="span5">
										<div class="span3"><label for="tipoRelacion">Tipo Relación:</label></div>
										<div class="span9">
											<select id="tipoRelacion" name="tipoRelacion" class="input cfdisRelacionados">
												<option value="">Seleccionar</option>
												<c:forEach items="${tipoRelaciones}" var="tipoRelacion" >
													<option value="${tipoRelacion.clave}" >${tipoRelacion.descripcion}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="span6">
										<div class="span3"><label for="uuid">UUID:</label></div>
										<div class="span8">
											<input type="text" maxlength="36" id="uuid" name="uuid" class="input cfdisRelacionados">
										</div>
									</div>
								</div>
								<div class="divRow clear separate right">
									<a href="#" id="btnAgregarUUID" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar UUID</a>
								</div>
							</div>
							<div id="mFoliosRelacionados" class="row-fluid">
								<div class="span2"></div>
								<div class="span10">
									<table id="tablaFoliosRelacionados" class="table table-striped table-hover table-bordered text-center" style="display: none">
										<thead>
											<tr>
												<th style="padding: 4px;">UUID</th>
												<th style="padding: 4px;"></th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span9">
					<c:if test="${gratuito == false}">
						<div class="row-fluid">
							<label class="">Observaciones: </label>
							<textarea id="observaciones" name="observaciones" class="span9"></textarea>
						</div>
					</c:if>
				</div>
			</div>
			<div class="row-fluid">
				<div id="divTotales" class="span3 offset9">
					<!--Body content-->
					<table id="tablaTotales" cellpadding="0" colspanding="0">
						<tr>
							<th><label>Subtotal </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span>
									<input name="subTotal" readonly="readonly" value="0.00" type="text" class="comprobante">
									<input name="totalImpuestosTrasladados" type="hidden">
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
							<th><label>I.E.P.S.:  </label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span>
									<input name="totalIEPS" id="totalIEPS" readonly="readonly" value="0.00" type="text" class="comprobante">
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
							<th><label>I.V.A.:  Retenido</label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span>
									<input name="totalIVARetenido" value="0.00" placeholder="0.00" type="text" class="comprobante">
								</div>
							</td>
						</tr>

						<tr>
							<th><label>I.S.R.:  Retenido</label></th>
							<td>
								<div class="input-prepend input-append">
									<span class="add-on">$</span>
									<input name="totalISRRetenido"  value="0.00" placeholder="0.00" type="text" class="comprobante">
								</div>
							</td>
						</tr>
						<tr class="totalDeRetenciones">
							<th><label>Total Retenciones:  </label></th>
							<td class="totalDeRetenciones">
								<div class="input-prepend input-append">
									<span class="add-on">$</span>
									<input name="totalDeRetenciones" readonly="readonly" value="0.00" type="text" class="comprobante totalDeRetenciones">
								</div>
							</td>
						</tr>
						<tr class="totalDeTraslados">
							<th><label>Total Traslados:  </label></th>
							<td>
								<div  class="input-prepend input-append">
									<span class="add-on">$</span>
									<input name="totalDeTraslados" readonly="readonly" value="0.00" type="text" class="comprobante">
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
				</div><!-- fin totales -->
			</div>
			<div class="row-fluid">
				<div class="span12">
					<c:if test="${gratuito == false}">
					<div class="row-fluid">
						<!-- Complementos -->
						<div class="accordion form-inline" id="accordion2">
							<c:if test="${addenda}">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseAddenda">
										Agregar Addenda
									</a>
								</div>
								<div id="collapseAddenda" class="accordion-body collapse">
									<div class="accordion-inner">
										<div class="row">
											<textarea cols="40" rows="4" id="textAddenda"></textarea>
										</div>
									</div>
								</div>
							</div>
							</c:if>
							<c:if test="${firmas}">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree">
										Agregar Firmas
									</a>
								</div>
								<div id="collapseThree" class="accordion-body collapse">
									<div class="accordion-inner">
									    <div class="row">
									    	<table id="tFirmas" class="table">
									    		<thead></thead>
									    		<tbody></tbody>
									    	</table>
									    </div>
										<div class="row-fluid">
											<div class="span5">
												<div class="span4"><label>Nombre: </label></div>
												<div class="span8">
													<input type="text" id="nombreFirma" name="nombreFirma">
												</div>
											</div>
											<div class="span5">
												<div class="span4"><label>Puesto: </label></div>
												<div class="span8">
													<input type="text" id="puestoFirma" name="puestoFirma">
												</div>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span5">
												<div class="span4"><label>Extra: </label></div>
												<div class="span8">
													<input type="text" id="extraFirma" name="extraFirma">
												</div>
											</div>
											<div class="span3 offset3">
												<a class="btn btn-primary" id="btnAddFirma">
													<i class="icon-white icon-plus"></i>
													Agregar
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							</c:if>
							<c:if test="${impuestosLocalesYFederales}">
							<div class="accordion-group">
								<div class="accordion-heading">
									<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseImpLocalesFed">
										Agregar Otros Derechos e impuestos (Locales y Federales)
									</a>
								</div>
								<div id="collapseImpLocalesFed" class="accordion-body collapse">
									<div class="accordion-inner">
										<div class="row-fluid">
											<div class="span3">
												<div class="contenido"><label>Tipo</label></div>
													<select name="tipoImpuesto" class="impLoc1">
														<option>Traslado</option>
														<option value="Retencion">Retenci&oacute;n</option>
													</select>
											</div>
											<div class="span4">
												<div class="contenido"><label>Nombre</label></div>
												<input type="text"  name="impLoc" class="impLoc1"/>
											</div>
											<div class="span2">
												<div class="contenido"><label>Tasa(%)</label></div>
												<input type="text" class="impLoc1" module="1" name="tasade"/>
											</div>
											<div class="span3">
												<div class="contenido"><label>Importe</label></div>
												<input type="text" class="impLoc1" name="importe"/>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span3">
												<!-- <label>Tipo:</label> -->
												<select name="tipoImpuesto" class="impLoc2">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span4">
												<!-- <label>Nombre:</label> -->
												<input type="text" class="impLoc2" name="impLoc"/>
											</div>
											<div class="span2">
												<!-- <label>Tasa(%):</label> -->
												<input type="text" class="impLoc2" module="2" name="tasade"/>
											</div>
											<div class="span3">
												<!-- <label>Importe:</label> -->
												<input type="text" class="impLoc2" name="importe"/>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span3">
												<!-- <label>Tipo:</label> -->
												<select name="tipoImpuesto" class="impLoc3">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span4">
												<!-- <label>Nombre:</label> -->
												<input type="text" class="impLoc3" name="impLoc"/>
											</div>
											<div class="span2">
												<!-- <label>Tasa(%):</label> -->
												<input type="text" class="impLoc3" module="3" name="tasade"/>
											</div>
											<div class="span3">
												<!-- <label>Importe:</label> -->
												<input type="text" class="impLoc3" name="importe"/>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span3">
												<!-- <label>Tipo:</label> -->
												<select name="tipoImpuesto" class="impLoc4">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span4">
												<!-- <label>Nombre:</label> -->
												<input type="text" class="impLoc4" name="impLoc"/>
											</div>
											<div class="span2">
												<!-- <label>Tasa(%):</label> -->
												<input type="text" class="impLoc4" module="4" name="tasade"/>
											</div>
											<div class="span3">
												<!-- <label>Importe:</label> -->
												<input type="text" class="impLoc4" name="importe"/>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span3">
												<!-- <label>Tipo:</label> -->
												<select name="tipoImpuesto" class="impLoc5">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span4">
												<!-- <label>Nombre:</label> -->
												<input type="text"  name="impLoc" class="impLoc5"/>
											</div>
											<div class="span2">
												<!-- <label>Tasa(%):</label> -->
												<input type="text" class="impLoc5" module="5" name="tasade"/>
											</div>
											<div class="span3">
												<!-- <label>Importe:</label> -->
												<input type="text" class="impLoc5" name="importe"/>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span3">
												<!-- <label>Tipo:</label> -->
												<select name="tipoImpuesto" class="input-medium impLoc6">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span4">
												<!-- <label>Nombre:</label> -->
												<input type="text"  name="impLoc" class="impLoc6"/>
											</div>
											<div class="span2">
												<!-- <label>Tasa(%):</label> -->
												<input type="text" class="input-mini impLoc6" module="6" name="tasade"/>
											</div>
											<div class="span3">
												<!-- <label>Importe:</label> -->
												<input type="text" class="input-medium impLoc6" name="importe"/>
											</div>
										</div>
										<div class="row-fluid">
											<div class="span3">
												
												<!-- <label>Tipo:</label> -->
												<select name="tipoImpuesto" class="input-medium impLoc7">
													<option>Traslado</option>
													<option value="Retencion">Retenci&oacute;n</option>
												</select>
											</div>
											<div class="span4">
												<!-- <label>Nombre:</label> -->
												<input type="text"  name="impLoc" class="impLoc7"/>
											</div>
											<div class="span2">
												<!-- <label>Tasa(%):</label> -->
												<input type="text" class="input-mini impLoc7" module="7" name="tasade"/>
											</div>
											<div class="span3">
												<!-- <label>Importe:</label> -->
												<input type="text" class="input-medium impLoc7" name="importe"/>
											</div>
										</div>
									</div><!-- accord inner -->
								</div>
							</div><!-- accord group -->
							</c:if>
							<c:if test="${renovacionSustitucionVehiculos}">
							<jsp:include page="/WEB-INF/views/complementos/renovacionSustitucionVehiculos.jsp" />
							</c:if>
							<c:if test="${registroFiscal}">
							<jsp:include page="/WEB-INF/views/complementos/registroFiscal.jsp" />
							</c:if>
							<c:if test="${detallista}">
							<jsp:include page="/WEB-INF/views/complementos/detallista.jsp" />
							</c:if>
							<c:if test="${donatorias}">
							<jsp:include page="/WEB-INF/views/complementos/donatorias.jsp" />
							</c:if>
							<c:if test="${pagoEspecie}">
							<jsp:include page="/WEB-INF/views/complementos/pagoEspecie.jsp" />
							</c:if>
							<c:if test="${notariosPublicos}">
							<jsp:include page="/WEB-INF/views/complementos/notariosPublicos.jsp" />
							</c:if>
							<c:if test="${consumoCombustible}">
							<jsp:include page="/WEB-INF/views/complementos/consumoCombustible.jsp" />
							</c:if>
							<c:if test="${vehiculoUsado}">
							<jsp:include page="/WEB-INF/views/complementos/vehiculoUsado.jsp" />
							</c:if>
							<c:if test="${valesDespensa}">
							<jsp:include page="/WEB-INF/views/complementos/valesDespensa.jsp" />
							</c:if>
							<c:if test="${serviciosParcialesConstruccion}">
							<jsp:include page="/WEB-INF/views/complementos/serviciosParcialesConstruccion.jsp" />
							</c:if>
							<c:if test="${aerolineas}">
							<jsp:include page="/WEB-INF/views/complementos/aerolineas.jsp" />
							</c:if>
							<c:if test="${divisas}">
							<jsp:include page="/WEB-INF/views/complementos/divisas.jsp" />
							</c:if>
							<c:if test="${turistaPasajeroExtranjero}">
							<jsp:include page="/WEB-INF/views/complementos/turistaPasajeroExtranjero.jsp" />
							</c:if>
							<c:if test="${personaFisicaIntegranteCoordinado}">
							<jsp:include page="/WEB-INF/views/complementos/personaFisicaIntegranteCoordinado.jsp" />
							</c:if>
							<c:if test="${ine}">
							<jsp:include page="/WEB-INF/views/complementos/ine.jsp" />
							</c:if>
							<c:if test="${leyendasFiscales}">
							<jsp:include page="/WEB-INF/views/complementos/leyendasFiscales.jsp" />
							</c:if>
							<c:if test="${enajenacionObrasArtesPlasticasAntiguedades}">
							<jsp:include page="/WEB-INF/views/complementos/enajenacionObrasArtesPlasticasAntiguedades.jsp" />
							</c:if>
							<c:if test="${certificadoDestruccion}">
							<jsp:include page="/WEB-INF/views/complementos/certificadoDestruccion.jsp" />
							</c:if>
							<c:if test="${estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT12}">
							<jsp:include page="/WEB-INF/views/complementos/estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT12.jsp" />
							</c:if>
							<c:if test="${comercioExterior11}">
							<jsp:include page="/WEB-INF/views/complementos/comercioExterior11.jsp" />
							</c:if>
							<c:if test="${conceptoCuentaTerceros}">
							<jsp:include page="/WEB-INF/views/complementos/conceptoCuentaTerceros.jsp" />
							</c:if>
							<c:if test="${conceptoInstitucionesEducativasPrivadas}">
							<jsp:include page="/WEB-INF/views/complementos/conceptoInstitucionesEducativasPrivadas.jsp" />
							</c:if>
							<c:if test="${conceptoVentaVehiculos}">
							<jsp:include page="/WEB-INF/views/complementos/conceptoVentaVehiculos.jsp" /> 
							</c:if>
						</div>
					</div>
					</c:if>
					<c:if test="${tipoComprobante.equals('pa')}">
						<jsp:include page="/WEB-INF/views/complementos/pagos.jsp" />
					</c:if>
				</div>
			</div>
		</form>
		<div style="clear: both;"></div>
		<div class="row-fluid row">
			<form id="formVistaPrevia" action="${contextPath}/comprobante/vistaPrevia" method="post" target="_blank" class="span3 offset3">
				<input type="hidden" name="strComprobante" class="strComprobante">
				<label for="vistaPrevia" class="btn btn-success">
					<i class="icon-white icon-eye-open"></i>
					Vista Previa
				</label>
				<input type="submit" id="vistaPrevia" value="Vista Previa" class="hide">
			</form>
			<form id="formGenerarComprobante" action="${contextPath}/comprobante/timbrarComprobante" method="post" class="span3">
				<input type="hidden" name="strComprobante" class="strComprobante">
				<label for="generarComprobante" class="btn btn-success">
					<i class="icon-white icon-file"></i>
					Generar Comprobante
				</label>
				<input type="submit" id="generarComprobante"  data-loading-text="Generando comprobante..." value="Generar Comprobante" class="hide" />
			</form>
			<!--<form id="formVistaPrefactura" class="span3">
				<input type="hidden" name="strComprobante"
					class="strComprobante">
				<label
					for="descargarPlantillaXml" class="btn btn-prefactura">
					<i class="icon-white icon-file"></i> Descargar prefactura
				</label>
				<input type="submit" id="descargarPlantillaXml"
					data-loading-text="Generando plantilla..."
					value="Descargar prefactura" class="hide" />
			</form>-->
		</div>
	</div>
</div>
<!--
<script src="<c:url value="/static/resources/js/cfdi1.js?${random.nextInt()}" />"></script>
 -->

 <c:choose>
 	<c:when test="${secure}">
 		<script src="https://portal1.expidetufactura.com.mx:447/js/cfdi_objeto33.js?${random.nextInt()}" charset="UTF-8" /></script>
 	</c:when>
 	<c:otherwise>
 		<script src="http://portal.expidetufactura.com.mx:86/js/cfdi_objeto33.js?${random.nextInt()}" charset="UTF-8" /></script>
 	</c:otherwise>
 </c:choose>
<link rel="stylesheet" href="<c:url value="/static/resources/css/redmond/jquery-ui-1.10.3.custom.min.css"/>">
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-122238418-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'UA-122238418-1');
</script>
<script src="/CFDI33/static/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/CFDI33/static/resources/js/bootstrap-datepicker.js"></script>
<% String msg = request.getParameter("msg");
if(msg != null){%>
<script>
	alert('<%=request.getParameter("msg")%>');
</script>
<%}%>
<style>
	.ui-autocomplete {
	    max-height: 150px;
	    overflow-y: auto;
	    /* prevent horizontal scrollbar */
		overflow-x: hidden;
	}
	.popover-content{
		font-size: 11px;
	}
	.underline {
  		text-decoration:underline;
	}
</style>