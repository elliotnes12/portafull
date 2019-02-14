<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<script src="/CFDI33/static/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
<link rel="stylesheet" href="<c:url value="/static/resources/css/redmond/jquery-ui-1.10.3.custom.min.css"/>">
<script src="/CFDI33/static/resources/js/bootstrap-datepicker.js"></script>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-122238418-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'UA-122238418-1');
</script>
<c:choose>
<c:when test="${secure}">
<script src="https://portal1.expidetufactura.com.mx:447/js/nomina33.js?${random.nextInt()}" /></script>
</c:when>
<c:otherwise>
<script src="http://portal.expidetufactura.com.mx:86/js/nomina33.js?${random.nextInt()}" /></script>
</c:otherwise>
</c:choose>
<% String msg = request.getParameter("msg");
if(msg != null){%>
<script>
	alert('<%=request.getParameter("msg")%>');
</script>
<%}%>
<style>
h4.blue {background: #26296B;border: 1px solid #26296B;color: white;font-size: 16px;font-weight: bold;padding: 2px;}
h5.blue {background: #26296B;border: 1px solid #26296B;color: white;font-size: 13px;font-weight: bold;padding: 2px;}
.tablaTotal {background:  #f5f5f5;margin: 0 auto;width: 98%;}
.txt-none {color: #f5f5f5;}
input, select,.add-on {font-size: 13px;height: 26px !important;padding: 2px !important;}
.obligatorio {background: #DEF2F6 !important;}
.mTabla {/*height: 100px;*/margin: 0 auto;margin-top: 10px;max-height: 200px;overflow: auto;width: 98%;}
.mTabla th {background: #26296B;color: white;padding: 3px;}
.subCat {margin: 0 auto;margin-top: 10px;overflow: auto;width: 98%;}
/*#formNomina input{text-align: left;}*/
div.invoice{box-shadow: 3px 3px 10px 3px #777777;-moz-box-shadow: 3px 3px 10px 3px #777777;-webkit-box-shadow: 3px 3px 10px 3px #777777;margin: auto;padding: 5px;width: 95%;}
#formNomina select{width: 100%;}
#formNomina input{width: 100%;}
#formNomina input.fecha{cursor: pointer;text-align: right;}
#formNomina div.input-prepend{width: 95%;}
#formNomina input.right{text-align: right;}
#divSeries div.contenido{display: inline-block;margin-left: 0;}
#divSeries label{border:1px solid;text-align: center;}
.invoice div.input-prepend input, .invoice div.input-append input {
    max-width: 96%;
}
.separate {
    margin-top: 5px;
    margin-bottom: 5px;
}
.right {
    float: right !important;
}
.clear {
    clear: both;
}
</style>
<script>
$(document).ready(function() {
	function cancelKeyPipe(input) {
		$(input).on('keydown', function(e) {
			if(e.key == '|') {
				return false;
			}
		});
		$(input).on('change',function(e) {
			if(/\|/.test($(this).val())) {
				$(this).val(cleanStringPipe($(this).val()));
			}
		});
	}
});
</script>
<div class="invoice">
    <form action="" id="formNomina">
        <%-- CABEZERA --%>
        <div id="header-invoice" class="container-fluid">
            <div class="row-fluid">
                <div class="span2"><!-- Logotipo -->
                    <img src="<c:url value="/images/logo/" />${datosE.tenantId}" class="img-polaroid">
                </div>
                <div class="span6"><%-- Datos Fiscales del Emisor --%>
                    <h4>${datosE.razonSocial}</h4>
                    <input type="hidden" name="nombre" class="emisor" value="${datosE.razonSocial}">
                    <p>
						<b>R.F.C. </b>
						<span>${datosE.rfc}<input type="hidden" name="rfc" class="emisor" value="${datosE.rfc}"></span>
					</p>
                    <p>
                    	<b>Código Postal</b>
                        <span> ${datosE.codigoPostal}<input type="hidden" name="codigoPostal" class="emisorDomicilio" value="${datosE.codigoPostal}"/></span>
                    </p>
					<div class="row-fluid">
						<div class="span4"><label>Lugar de Expedici&oacute;n </label></div>
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
						<div class="span4"><span>Regimen Fiscal:</span></div>
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
                <div class="span4" id="divSeries"><%-- Serie y Folio --%>
                    <h6>COMPROBANTE FISCAL DIGITAL A TRAV&Eacute;S DE INTERNET</h6>
                    <input type="hidden" name="tipoDeComprobante" value="${tipoComprobante}" class="comprobante"/>
                    <div class="contenido" id="divSerie" style="width: 25%">
                        <label for="serie">Serie</label>
                        <input type="text" id="serie" name="serie" maxlength="25" class="comprobante text-center" value="NOMINA" />
                    </div>
                    <div class="contenido" style="width: 25%">
                        <label for="folio">Folio</label>
                        <input type="text" id="folio" name="folio" maxlength="40" class="comprobante text-center" />
                    </div>
                    <div class="contenido" style="width: 45%">
                        <label for="fecha">Fecha</label>
                        <select name="fecha" id="fecha" class=" comprobante text-center" style="width: 100%;">
                            <option value="${fecha}" selected="selected">${fn:substring(fecha, 0, 10)}</option>
                        </select>
                    </div>
                </div>
                <div class="span4" style="padding: 0; height: 36px; margin-top: 3px;">
                    <b>Tipo de CFDI: </b>
                    <select id="btnTipoComprobante" style="width: 175px;">
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
                        <!--  <option value="fa" ${tipoComprobante == "rn" ? "selected" : ""}>Recibo de n&oacute;mina</option>-->
                        <optgroup label="Nómina">
                        	<option value="tn" ${tipoComprobante == "tn" ? "selected" : ""}>Tipo N&oacute;mina</option>
                        </optgroup>
                        <optgroup label="Pago">
								<option value="pa" ${tipoComprobante == "pa" ? "selected" : ""}>Pago</option>
						</optgroup>
                        
                    </select>
                </div>
            </div>
        </div>
        <%-- EMISOR --%>
        <div class="Emisor">
            <h4 class="blue">Emisor:</h4>
            <div class="row-fluid">
                <div class="span6 row-fluid">
                    <div class="span4"><label for="curpEmisor">C.U.R.P.</label></div>
                    <div class="span8"><input type="text" value="" id="curpEmisor" name="curpEmisor" class="nominaEmisor" /></div>
                </div>
                <div class="span6 contenido">
                    <div class="span4"><label for="registroPatronal">Registro patronal: </label></div>
                    <div class="span8"><input type="text" id="registroPatronal" maxlength="20" size="20" name="registroPatronal" class="nominaEmisor" /></div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6 contenido">
                    <div class="span4"><label for="rfcPatronOrigen">R.F.C. Patr&oacute;n Origen </label></div>
                    <div class="span8"><input type="text" value="" id="rfcPatronOrigen" name="rfcPatronOrigen" class="nominaEmisor" /></div>
                </div>
            </div>
            <div class="accordion-group row-fluid">
                <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseEntidadSNCF">
                        Entidad SNCF
                    </a>
                </div>
                <div id="collapseEntidadSNCF" class="accordion-body collapse">
                    <div class="accordion-inner">
                        <div class="span6 row-fluid">
                            <div class="span4"><label for="origenRecurso">Origen Recurso </label></div>
                            <div class="span8"><select class="entidadSNCF" name="origenRecurso" id="origenRecurso" >
                                <option value="default">Seleccionar</option>
                                <c:forEach items="${origenRecurso}" var="origenRecurso" >
                                <option value="${origenRecurso.clave}" >${origenRecurso.nombre}</option>
                                </c:forEach>
                            </select></div>
                        </div>
                        <div class="span6 row-fluid">
                            <div class="span4"><label for="montoRecursoPropio">Monto Recurso Propio </label></div>
                            <div class="span8"><input type="text" id="montoRecursoPropio" name="montoRecursoPropio" class=" entidadSNCF" /></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%-- FORMA DE PAGO --%>
        <div class="">
            <h4 class="blue">Forma de pago:</h4>
            <div class="row-fluid">
                <div class="span4 row-fluid">
                    <div class="span5"><label for="metodoDePago">M&eacute;todo de pago: </label></div>
                    <div class="span7"><select class="comprobante  comprobante obligatorio" name="metodoPago" id="metodoPago" module="metodoPago">
                        <option value="PUE" selected>Pago en una sola exhibición</option>
                    </select></div>
                </div>
                <div class="span4 row-fluid">
                    <div class="span5"><label for="moneda">Moneda:</label></div>
                    <div class="span7">
                        <select id="moneda" name="moneda" class=" comprobante" value="${configuracion.moneda}">
                            <option value="MXN">MXN</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span4 row-fluid">
                    <div class="span5"><label for="tipoCambio">Tipo de cambio:</label></div>
                    <div class="span7">
                        <div class="input-prepend input-append">
                            <span class="add-on">$ </span>
                            <input type="text" id="tipoCambio" name="tipoCambio" value="${configuracion.tipoCambio}" class=" comprobante" readonly="readonly" style="width: 95%" />
                        </div>
                    </div>
                </div>
                <div class="span4 row-fluid">
                    <div class="span5"><label for="formaPago">Forma de pago:</label></div>
                    <div class="span7">
                        <select class="comprobante" name="formaPago" id="formaPago">
							<option value="99">Por definir</option>
						</select>	
                    </div>
                </div>
            </div>
        </div>
        <%-- DATOS DEL RECIBO --%>
        <div class="panel1">
            <h4 class="blue">Datos del recibo:</h4>
            <div class="panel1-body">
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span4"><label for="razonSocial">Nombre del empleado: </label></div>
                        <div class="span8">
                            <input class="receptor obligatorio" id="razonSocial" autocomplete="off" name="nombre" type="text" placeholder="Raz&oacute;n Social o Clave" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span4"><label for="curpReceptor">C.U.R.P.: </label></div>
                        <div class="span8"><input type="text" id="curpReceptor" name="curpReceptor" class="input obligatorio nominaReceptor" maxlength="18"></div>
                    </div>
                </div>
                <div class="row-fluid">
                        <div class="span6">
                            <div class="span4"><label for="rfc">R.F.C.: </label></div>
                            <div class="span8"><input type="text" id="rfc" name="rfc" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class=" obligatorio receptor" placeholder="R.F.C."></div>
                        </div>
                    <div class="span4">
                        <div class="span6"><label for="numEmpleado">Num. Empleado: </label></div>
                        <div class="span6"><input class="input obligatorio nominaReceptor" maxlength="15" type="text" id="numEmpleado" name="numEmpleado"></div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span4"><label for="tipoContrato">Tipo de Contrato: </label></div>
                        <div class="span8"><select  class="obligatorio nominaReceptor select" id="tipoContrato" name="tipoContrato">
                            <option value="">Seleccionar</option>
                            <c:forEach items="${tipoContrato}" var="tipoContrato" >
                            <option value="${tipoContrato.clave}" ${empleado.tipoContrato eq tipoContrato.clave ? 'selected':''}>${tipoContrato.nombre}</option>
                            </c:forEach>
                        </select></div>
                    </div>
                    <div class="span6">
                        <div class="span4"><label for="tipoRegimen">Tipo R&eacute;gimen: </label></div>
                        <div class="span8"><select name="tipoRegimen" id="tipoRegimen" class="obligatorio nominaReceptor select">
                            <option value="">Seleccionar</option>
                            <c:forEach items="${tipoRegimen}" var="tipoRegimen" >
                            <option value="${tipoRegimen.clave}" ${empleado.tipoRegimen eq tipoRegimen.clave ? 'selected':''}>${tipoRegimen.nombre}</option>
                            </c:forEach>
                        </select></div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="span6"><label for="fechaPago">Fecha pago: </label></div>
                        <div class="span6"><input  type="text" id="fechaPago" name="fechaPago" class="input  fecha obligatorio nomina" readonly="readonly"></div>
                    </div>
                    <div class="span4 offset2">
                        <div class="span6"><label for="fechaInicialPago">Fecha inicial pago: </label></div>
                        <div class="span6"><input  type="text" id="fechaInicialPago" name="fechaInicialPago"  class="input  fecha obligatorio nomina" readonly="readonly"></div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="span6"><label for="fechaFinalPago">Fecha final pago: </label></div>
                        <div class="span6"><input type="text" id="fechaFinalPago" name="fechaFinalPago" class="input  fecha obligatorio nomina" readonly="readonly"></div>
                    </div>
                    <div class="span4 offset2">
                        <div class="span6"><label for="periodicidadPago">PeriodicidadPago: </label></div>
                        <div class="span6"><select class="nominaReceptor obligatorio" id="periodicidadPago" name="periodicidadPago">
                            <option value="">Seleccionar</option>
                            <c:forEach items="${periodicidadPago}" var="periodicidadPago" >
                            <option value="${periodicidadPago.clave}">${periodicidadPago.nombre}</option>
                            </c:forEach>
                        </select></div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="span6"><label for="numDiasPagados">N&uacute;mero de d&iacute;as Pagados: </label></div>
                        <div class="span6"><input type="text" id="numDiasPagados" name="numDiasPagados" value="15" class="input span1 obligatorio nomina"></div>
                    </div>
                    <div class="span4 offset2">
                        <div class="span6"><label for="claveEntFed">Entidad Federativa: </label></div>
                        <div class="span6"><select name="claveEntFed" class="obligatorio nominaReceptor" id="claveEntFed">
                            <option value="">Seleccionar</option>
                            <c:forEach items="${claveEntFed}" var="claveEntFed" >
                            <option value="${claveEntFed.id}" ${empleado.claveEntFed eq claveEntFed.id ? 'selected':''}>${claveEntFed.nombre}</option>
                            </c:forEach>
                        </select></div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="span6"><label for="usoCFDI">Uso CFDI: </label></div>
                        <div class="span6"><select class="receptor" name="usoCFDI" id="usoCFDI">
								<option value="P01">Por definir</option>
							</select></div>
                    </div>
                </div>
                <div class="accordion" id="accordion2">
                    <!-- inicio tab -->
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                Datos Extra del recibo
                            </a>
                        </div>
                        <div id="collapseOne" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <div class="row-fluid">
                                    <div class="span4" title="N&uacute;mero de Seguridad Social">
                                        <div class="span5"><label for="numSeguridadSocial">N.S.S.: </label></div>
                                        <div class="span7"><input type="text" id="numSeguridadSocial" name="numSeguridadSocial" class="nominaReceptor" maxlength="15"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="cuentaBancaria">Cuenta Bancaria: </label></div>
                                        <div class="span8"><input type="text" id="cuentaBancaria" name="cuentaBancaria" class="nominaReceptor" maxlength="18"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="banco">Banco: </label></div>
                                        <div class="span8"><select name="banco" class="nominaReceptor" id="banco">
                                            <option value="">Seleccionar</option>
                                            <c:forEach items="${banco}" var="banco" >
                                            <option value="${banco.clave}" ${empleado.banco eq banco.clave ? 'selected':''}>${banco.nombre}</option>
                                            </c:forEach>
                                        </select></div>
                                    </div>
                                </div>
                                <!-- <br> -->
                                <div class="row-fluid">
                                    <div class="span4">
                                        <div class="span5"><label for="departamento">Departamento: </label></div>
                                        <div class="span7"><input class="nominaReceptor" type="text" id="departamento" name="departamento" maxlength="100"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="puesto">Puesto: </label></div>
                                        <div class="span8"><input class="nominaReceptor" type="text" id="puesto" name="puesto" maxlength="100"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="tipoJornada">Tipo de Jornada: </label></div>
                                        <div class="span8"><select  class="nominaReceptor select" id="tipoJornada" name="tipoJornada">
                                            <option value="">Seleccionar</option>
                                            <c:forEach items="${tipoJornada}" var="tipoJornada" >
                                            <option value="${tipoJornada.clave}" ${empleado.tipoJornada eq tipoJornada.clave ? 'selected':''}>${tipoJornada.nombre}</option>
                                            </c:forEach>
                                        </select></div>
                                    </div>
                                </div>
                                <!-- <br> -->
                                <div class="row-fluid">
                                    <div class="span4">
                                        <div class="span5"><label for="fechaInicioRelLaboral">Fecha Inicio Relaci&oacute;n Laboral: </label></div>
                                        <div class="span7"><input class="nominaReceptor fecha fecha" type="text" id="fechaInicioRelLaboral" name="fechaInicioRelLaboral" readonly="readonly"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="antiguedad">Antig&uuml;edad: </label></div>
                                        <div class="span8"><input class="nominaReceptor" type="text" id="antiguedad" name="antiguedad"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="riesgoPuesto">Riesgo Puesto: </label></div>
                                        <div class="span8"><select class="nominaReceptor" id="riesgoPuesto" name="riesgoPuesto">
                                            <option value="">Seleccionar</option>
                                            <c:forEach items="${riesgoPuesto}" var="riesgoPuesto" >
                                            <option value="${riesgoPuesto.clave}" ${empleado.riesgoPuesto eq riesgoPuesto.clave ? 'selected':''}>${riesgoPuesto.nombre}</option>
                                            </c:forEach>
                                        </select></div>
                                    </div>
                                </div>
                                <!-- <br> -->
                                <div class="row-fluid">
                                    <div class="span4">
                                        <div class="span5"><label for="salarioBaseCotApor">Salario Base CotApor: </label></div>
                                        <div class="span7"><div class="input-prepend input-append">
                                            <span class="add-on">$ </span>
                                            <input class=" nominaReceptor" type="text" id="salarioBaseCotApor" name="salarioBaseCotApor">
                                        </div></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="salarioDiarioIntegrado">Salario Diario Integrado: </label></div>
                                        <div class="span8"><div class="input-prepend input-append">
                                            <span class="add-on">$ </span>
                                            <input class=" nominaReceptor" type="text" id="salarioDiarioIntegrado" name="salarioDiarioIntegrado">
                                        </div></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span4"><label for="sindicalizado">Sindicalizado: </label></div>
                                        <div class="span8"><select  class="nominaReceptor select" id="sindicalizado" name="sindicalizado">
                                            <option value="">Seleccionar</option>
                                            <option value="Sí" ${empleado.sindicalizado eq 'Sí' ? 'selected':''}>Sí</option>
                                            <option value="No" ${empleado.sindicalizado eq 'No' ? 'selected':''}>No</option>
                                        </select></div>
                                    </div>
                                </div>
                                <!-- <br> -->
                                <div class="">
                                    <input class="nomina" type="hidden" id="email" name="email">
                                </div>
                            </div>
                        </div>
                    </div>  <!-- fin tab -->
                </div>
                <div class="accordion-group">
                    <div class="accordion-heading">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseSubContratacion">
                            SubContrataci&oacute;n
                        </a>
                    </div>
                    <div id="collapseSubContratacion" class="accordion-body collapse">
                        <div class="accordion-inner">
                            <div class="row-fluid">
                                <div class="span4">
                                    <div class="span5"><label for="rfcLabora">RFC Labora: </label></div>
                                    <div class="span7"><input type="text" id="rfcLabora" name="rfcLabora" class="input subContratacion obligatorio"></div>
                                </div>
                                <div class="span4">
                                    <div class="span5"><label for="porcentajeTiempo">Porcentaje Tiempo: </label></div>
                                    <div class="span7"><input type="text" id="porcentajeTiempo" name="porcentajeTiempo" class="input subContratacion obligatorio"></div>
                                </div>
                            </div>
                            <div class="divRow separate right clear">
                                <label class="btn btn-primary" for="addSubContratacion">
                                    <i class="icon-plus icon-white"></i>
                                    Agregar
                                </label>
                                <input type="button" id="addSubContratacion" value="Agregar" class="hide">
                            </div>
                        </div>
                    </div>
                </div>  <!-- fin tab -->
            </div>
        </div>
        <div class="panel1">
            <h4 class="blue"></h4>
            <div class="panel1-body">
                <div class="row-fluid">
                    <div class="span4">
                        <div class="span6"><label for="tipoNomina">Tipo de N&oacute;mina: </label></div>
                        <div class="span6"><select class="nomina select  obligatorio" name="tipoNomina" id="tipoNomina">
                            <c:forEach items="${tipoNomina}" var="tipoNomina" >
                            <option value="${tipoNomina.clave}" ${tipoNomina.clave eq 'O' ? 'selected':''}>${tipoNomina.nombre}</option>
                            </c:forEach>
                        </select></div>
                    </div>
                </div>
                <!-- <br> -->
                <div class="row-fluid">
                    <div class="span4">
                        <div class="span6"><label for="totalPercepciones">Total Percepciones: </label></div>
                        <div class="span6"><input type="text" id="totalPercepciones" name="totalPercepciones" value="0.0" class="input nomina" readonly="true"></div>
                    </div>
                    <div class="span4">
                        <div class="span6"><label for="totalDeducciones">Total Deducciones: </label></div>
                        <div class="span6"><input type="text" id="totalDeducciones" name="totalDeducciones" value="0.0" class="input nomina" readonly="true"></div>
                    </div>
                    <div class="span4">
                        <div class="span6"><label for="totalOtrosPagos">Total Otros Pagos: </label></div>
                        <div class="span6"><input type="text" id="totalOtrosPagos" name="totalOtrosPagos" value="0.0" class="input nomina" readonly="true"></div>
                    </div>
                </div>
            </div>
        </div>
        <%-- PERCEPCIONES --%>
        <div class="percepciones panel1 row-fluid">
            <h4 class="blue">Percepciones:</h4>
            <div class="offset1">
                <div class="panel-body percepcion">
                    <h5 class="blue">Percepci&oacute;n:</h5>
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span4"><label for="tipoPercepcion">Tipo: </label></div>
                            <div class="span8"><select name="tipoPercepcion" module="Percepcion" id="tipoPercepcion" class=" input obligatorio concepto">
                                <option value="">Seleccionar</option>
                                <c:forEach items="${tipoPercepcion}" var="tipoPercepcion" >
                                <option value="${tipoPercepcion.clave}" >${tipoPercepcion.nombre}</option>
                                </c:forEach>
                            </select></div>
                        </div>
                        <div class="span4">
                            <div class="span4"><label for="conceptoPercepcion">Concepto: </label></div>
                            <div class="span8"><input type="text" class="input  obligatorio" id="conceptoPercepcion" name="concepto" maxlength="100"></div>
                        </div>
                        <div class="span4">
                            <div class="span4"><label for="clave">Clave:</label></div>
                            <div class="span8">
                                <input type="text" id="clave" name="clave" maxlength="15" class=" input obligatorio " />
                                <input type="hidden" class="idClave input" name="id" value="0">
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span4"><label for="importeGravado">Importe Gravado</label></div>
                            <div class="span8">
                                <div class="input-prepend">
                                    <span class="add-on">$</span>
                                    <input type="text" id="importeGravado" name="importeGravado" class="numero  input obligatorio text-right" />
                                </div>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="span4"><label for="importeExento">Importe Exento</label></div>
                            <div class="span8">
                                <div class="input-prepend">
                                    <span class="add-on">$</span>
                                    <input type="text" id="importeExento" name="importeExento" class="numero  input obligatorio text-right" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="divRow separate clear right">
                        <label class="btn btn-primary" for="agregarPercepcion">
                            <i class="icon-plus icon-white"></i>
                            AGREGAR
                        </label>
                        <input id="agregarPercepcion" class="add hide" module="percepcion" type="button" value="  AGREGAR  " />
                    </div>
                    <!-- <br> -->
                    <div class="mTabla">
                        <table id="tabla-percepciones" class="table table-striped mTabla">
                            <thead>
                                <tr>
                                    <th>Tipo<br />Percepci&oacute;n</th>
                                    <th>Clave</th>
                                    <th class="span5">Concepto</th>
                                    <th>Importe Gravado</th>
                                    <th>Importe Exento</th>
                                    <th>Eliminar</th>
                                    <!-- <th style="display:none;">Editar</th> -->
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseAccionesOTitulos">
                                Acciones O T&iacute;tulos
                            </a>
                        </div>
                        <div id="collapseAccionesOTitulos" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <div class="row-fluid">
                                    <div class="span4">
                                        <div class="span6"><label for="valorMercado">Valor Mercado: </label></div>
                                        <div class="span6"><input class="accionesOTitulos" type="text" id="valorMercado" name="valorMercado"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span6"><label for="precioAlOtorgarse">Precio Al Otorgarse: </label></div>
                                        <div class="span6"><input class="accionesOTitulos" type="text" id="precioAlOtorgarse" name="precioAlOtorgarse"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>  <!-- fin div Acciones O TÃ­tulos-->
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseHorasExtra">
                                Horas extra
                            </a>
                        </div>
                        <div id="collapseHorasExtra" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <div class="row-fluid">
                                    <div class="span4">
                                        <div class="span6"><label for="dias">D&iacute;as : </label></div>
                                        <div class="span6"><input type="text" class="horasExtra" id="dias" name="dias" module="horasExtra"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span6"><label for="tipoHoras">Tipo Horas: </label></div>
                                        <div class="span6"><select name="tipoHoras" id="tipoHoras" module="horasExtra" class="horasExtra">
                                            <option value="">Seleccionar</option>
                                            <c:forEach items="${tipoHoras}" var="tipoHoras" >
                                            <option value="${tipoHoras.clave}" >${tipoHoras.nombre}</option>
                                            </c:forEach>
                                        </select></div>
                                    </div>
                                </div>
                                <div class="row-fluid">
                                    <div class="span4">
                                        <div class="span6"><label for="numeroHorasExtra">Horas Extra: </label></div>
                                        <div class="span6"><input type="text" class="horasExtra" id="numeroHorasExtra" name="numeroHorasExtra" module="horasExtra"></div>
                                    </div>
                                    <div class="span4">
                                        <div class="span6"><label for="importePagado">Importe pagado:</label></div>
                                        <div class="span6"><div class="input-prepend">
                                            <span class="add-on">$</span>
                                            <input type="text" id="importePagado" name="importePagado" class="horasExtra" module="horasExtra"/>
                                        </div></div>
                                    </div>
                                </div>
                                <div class="divRow separate clear right">
                                    <div class="">
                                        <label for="agregarHorasExtra" class="btn btn-primary">
                                            <i class="icon-plus icon-white"></i>
                                            AGREGAR
                                        </label>
                                        <input type="button" id="agregarHorasExtra" module="horasExtra" class="hide" value="  AGREGAR  " />
                                    </div>
                                </div>
                            </div>
                            <!-- <br> -->
                            <div class="mTabla">
                                <table id="tabla-horasExtra" class="table table-striped mTabla">
                                    <thead>
                                        <tr>
                                            <th>D&iacute;as</th>
                                            <th>Tipo</th>
                                            <th>Horas Extras</th>
                                            <th>Importe Pagado</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </div>  <!-- fin div horas extra-->
                </div> <!-- fin Percepcion-->
                <div class="panel-body subCat">
                    <h5 class="blue">Jubilaci&oacute;n Pensi&oacute;n Retiro:</h5>
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span6"><label for="totalUnaExhibicion">Total Una Exhibici&oacute;n: </label> </div>
                            <div class="span6"><input class="jubilacionPensionRetiro" type="text" id="totalUnaExhibicion" name="totalUnaExhibicion"></div>
                        </div>
                        <div class="span4">
                            <div class="span6"><label for="totalParcialidad">Total Parcialidad: </label></div>
                            <div class="span6"><input class="jubilacionPensionRetiro" type="text" id="totalParcialidad" name="totalParcialidad"></div>
                        </div>
                        <div class="span4">
                            <div class="span6"><label for="montoDiario">Monto Diario: </label></div>
                            <div class="span6"><input class="jubilacionPensionRetiro" type="text" id="montoDiario" name="montoDiario"></div>
                        </div>
                    </div>
                    <!-- <br> -->
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span6"><label for="ingresoAcumulable">Ingreso Acumulable: </label></div>
                            <div class="span6"><input class="jubilacionPensionRetiro" type="text" id="ingresoAcumulable" name="ingresoAcumulable"></div>
                        </div>
                        <div class="span4">
                            <div class="span6"><label for="ingresoNoAcumulable">Ingreso No Acumulable: </label></div>
                            <div class="span6"><input class="jubilacionPensionRetiro" type="text" id="ingresoNoAcumulable" name="ingresoNoAcumulable"></div>
                        </div>
                    </div>
                </div> <!-- fin div JubilaciÃ³n PensiÃ³n Retiro-->
                <div class="panel-body subCat">
                    <h5 class="blue">Separaci&oacute;n Indemnizaci&oacute;n:</h5>
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span6"><label for="totalPagado">Total Pagado: </label></div>
                            <div class="span6"><input class="separacionIndemnizacion" type="text" id="totalPagado" name="totalPagado"></div>
                        </div>
                        <div class="span4">
                            <div class="span6"><label for="numAniosServicio">N&uacute;mero A&ntilde;os Servicio: </label></div>
                            <div class="span6"><input class="separacionIndemnizacion" type="text" id="numAniosServicio" name="numAniosServicio"></div>
                        </div>
                        <div class="span4">
                            <div class="span6"><label for="ultimoSueldoMensOrd">&Uacute;ltimo Sueldo Mensual Ordinario: </label> </div>
                            <div class="span6"><input class="separacionIndemnizacion" type="text" id="ultimoSueldoMensOrd" name="ultimoSueldoMensOrd"></div>
                        </div>
                    </div>
                    <!-- <br> -->
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span6"><label for="ingresoAcumulableSeparacionIndemnizacion">Ingreso Acumulable: </label></div>
                            <div class="span6"><input class="separacionIndemnizacion" type="text" id="ingresoAcumulableSeparacionIndemnizacion" name="ingresoAcumulableSeparacionIndemnizacion"></div>
                        </div>
                        <div class="span4">
                            <div class="span6"><label for="ingresoNoAcumulableSeparacionIndemnizacion">Ingreso No Acumulable: </label></div>
                            <div class="span6"><input class="separacionIndemnizacion" type="text" id="ingresoNoAcumulableSeparacionIndemnizacion" name="ingresoNoAcumulableSeparacionIndemnizacion"></div>
                        </div>
                    </div>
                </div>  <!-- fin div SeparaciÃ³n IndemnizaciÃ³n-->
                <!-- <br> -->
                <div class="panel-footer1">
                    <h3>Sumatoria Percepciones</h3>
                    <div class="row-fluid">
                        <div class="span4 offset4">
                            <label for="totalSueldos">Total Sueldos: </label>
                        </div>
                        <div class="span3">
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="totalSueldos" name="totalSueldos" readonly="readonly" value="0.00" class=" input text-right" />
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4 offset4">
                            <label>Total Separaci&oacute;n Indemnizaci&oacute;n: </label>
                        </div>
                        <div class="span3">
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="totalSeparacionIndemnizacion" name="totalSeparacionIndemnizacion" readonly="readonly" value="0.00" class=" input text-right" />
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4 offset4">
                            <label>Total Jubilaci&oacute;n Pensi&oacute;n Retiro: </label>
                        </div>
                        <div class="span3">
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="totalJubilacionPensionRetiro" name="totalJubilacionPensionRetiro" readonly="readonly" value="0.00" class=" input text-right" />
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4 offset4">
                            <label>Total Gravado: </label>
                        </div>
                        <div class="span3">
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="totalGravado" name="totalGravado" readonly="readonly" value="0.00" class=" input text-right" />
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4 offset4">
                            <label>Total Exento: </label>
                        </div>
                        <div class="span3">
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="totalExento" name="totalExento" readonly="readonly" value="0.00" class=" input text-right" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
        </div>
        <%-- DEDUCCIONES --%>
        <div class="deducciones panel1 row-fluid">
            <h4 class="blue">Deducciones:</h4>
            <div class="offset1">
                <div class="panel-body deduccion">
                    <h5 class="blue">Deducci&oacute;n:</h5>
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span4"><label for="tipoDeduccion">Tipo: </label></div>
                            <div class="span8"><select name="tipoDeduccion" id="tipoDeduccion" module="Deduccion" class=" input obligatorio concepto">
                                <option value="">Seleccionar</option>
                                <c:forEach items="${tipoDeduccion}" var="tipoDeduccion" >
                                <option value="${tipoDeduccion.clave}" >${tipoDeduccion.nombre}</option>
                                </c:forEach>
                            </select></div>
                        </div>
                        <div class="span4">
                            <div class="span4"><label for="conceptoDeduccion">Concepto: </label></div>
                            <div class="span8"><input type="text" class="input  obligatorio" id="conceptoDeduccion" name="conceptoDeduccion" maxlength="100"></div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span4"><label for="claveDeduccion">Clave:</label></div>
                            <div class="span8">
                                <input type="text" id="claveDeduccion" name="claveDeduccion" maxlength="15" class=" input obligatorio" />
                                <input type="hidden" class="idClave input" name="id" value="0">
                            </div>
                        </div>
                        <div class="span4">
                            <div class="span4"><label for="importeDeduccion">Importe: </label></div>
                            <div class="span8"><div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="importeDeduccion" name="importeDeduccion" class=" numero  input obligatorio text-right" />
                            </div></div>
                        </div>
                    </div>
                    <div class="divRow separate clear right">
                        <label for="agregarDeduccion" class="btn btn-primary">
                            <i class="icon-plus icon-white"></i>
                            AGREGAR
                        </label>
                        <input id="agregarDeduccion" type="button" module="deduccion" class="add hide" value="  AGREGAR  " />
                    </div>
                    <!-- <br> -->
                    <div class="mTabla">
                        <table id="tabla-deducciones" class="table table-striped mTabla">
                            <thead>
                                <tr>
                                    <th>Tipo<br />Deducci&oacute;n</th>
                                    <th>Clave</th>
                                    <th class="span5">Concepto</th>
                                    <th>Importe</th>
                                    <th>Eliminar</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div><!-- fin Deduccion-->
                <!-- <br> -->
                <div class="panel-footer1">
                    <h3>Sumatoria Deducciones</h3>
                    <div class="row-fluid">
                        <div class="span3 offset5">
                            <label>Total Otras Deducciones: </label>
                        </div>
                        <div class="span3">
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="totalOtrasDeducciones" name="totalOtrasDeducciones" readonly="readonly" value="0.00" class=" input text-right">
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span3 offset5">
                            <label>Total Impuestos Retenidos: </label>
                        </div>
                        <div class="span3">
                            <div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="totalImpuestosRetenidos" name="totalImpuestosRetenidos" readonly="readonly" value="0.00" class=" input text-right" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%-- OTROS PAGOS --%>
        <div class="otrosPagos panel1">
            <h4 class="blue">Otros Pagos:</h4>
            <div class="offset1">
                <div class="panel-body otroPago">
                    <h5 class="blue">Otro Pago:</h5>
                    <div class="row-fluid">
                        <div class="span5">
                            <div class="span4"><label for="tipoOtroPago">Tipo Otro Pago : </label></div>
                            <div class="span8"><select name="tipoOtroPago" id="tipoOtroPago" module="OtroPago" class=" input obligatorio concepto">
                                <option value="">Seleccionar</option>
                                <c:forEach items="${tipoOtroPago}" var="tipoOtroPago" >
                                <option value="${tipoOtroPago.clave}" >${tipoOtroPago.nombre}</option>
                                </c:forEach>
                            </select></div>
                        </div>
                        <div class="span5">
                            <div class="span4"><label for="conceptoOtroPago">Concepto: </label></div>
                            <div class="span8"><input type="text" class="input  obligatorio" id="conceptoOtroPago" name="conceptoOtroPago" maxlength="100"></div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span5">
                            <div class="span4"><label for="claveOtroPago">Clave: </label></div>
                            <div class="span8"><input type="text" class="input input-micro obligatorio" id="claveOtroPago" name="claveOtroPago"></div>
                            <input type="hidden" class="idClave input" name="id" value="0">
                        </div>
                        <div class="span5">
                            <div class="span4"><label for="importeOtroPago">Importe :</label></div>
                            <div class="span8"><div class="input-prepend">
                                <span class="add-on">$</span>
                                <input type="text" id="importeOtroPago" name="importeOtroPago" class="numero  input obligatorio text-right" />
                            </div></div>
                        </div>
                    </div>
                    <div class="divRow separate clear right">
                        <div class="span2 offset1">
                            <label for="agregarOtroPago" class="btn btn-primary">
                                <i class="icon-plus icon-white"></i>
                                AGREGAR
                            </label>
                            <input id="agregarOtroPago" type="button" module="otroPago" class="add hide" value="  AGREGAR  " />
                        </div>
                    </div>
                    <br>
                    <div class="mTabla">
                        <table id="tabla-otrosPagos" class="table table-striped mTabla">
                            <thead>
                                <tr>
                                    <th>Tipo Otro Pago</th>
                                    <th>Clave</th>
                                    <th class="span5">Concepto</th>
                                    <th>Importe</th>
                                    <th>Eliminar</th>
                                    <!-- <th style="display:none;">Editar</th> -->
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseSubsidioAlEmpleo">
                                Subsidio Al Empleo
                            </a>
                        </div>
                        <div id="collapseSubsidioAlEmpleo" class="accordion-body collapse">
                            <div class="accordion-inner row-fluid">
                                <div class="span4">
                                    <div class="span5"><label for="subsidioCausado">Subsidio Causado: </label></div>
                                    <div class="span7"><input class="subsidioAlEmpleo" type="text" id="subsidioCausado" name="subsidioCausado"></div>
                                </div>
                            </div>
                        </div>
                    </div>  <!-- fin div SubsidioAlEmpleo-->
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseCompensacionSaldosAFavor">
                                Compensaci&oacute;n Saldos A Favor
                            </a>
                        </div>
                        <div id="collapseCompensacionSaldosAFavor" class="accordion-body collapse">
                            <div class="accordion-inner row-fluid">
                                <div class="span4">
                                    <div class="span5"><label for="saldoAFavor">Saldo A Favor: </label></div>
                                    <div class="span7"><input class="compensacionSaldosAFavor" type="text" id="saldoAFavor" name="saldoAFavor" readonly="readonly" value="0.00"></div>
                                </div>
                                <div class="span4">
                                    <div class="span5"><label for="anioCompensacionSaldosAFavor">A&ntilde;o: </label></div>
                                    <div class="span7"><input class="compensacionSaldosAFavor" type="text" id="anioCompensacionSaldosAFavor" name="anioCompensacionSaldosAFavor"></div>
                                </div>
                                <div class="span4">
                                    <div class="span5"><label for="remanenteSalFav">Remanente Saldo Favor: </label></div>
                                    <div class="span7"><input class="compensacionSaldosAFavor" type="text" id="remanenteSalFav" name="remanenteSalFav"></div>
                                </div>
                            </div>
                        </div>
                    </div>  <!-- fin div CompensacionSaldosAFavor-->
                </div><!-- fin OtroPago-->
            </div>
        </div>
        <%-- INCAPACIDADES --%>
        <div class="incapacidades panel1">
            <h4 class="blue">Incapacidades:</h4>
            <div class="offset1">
                <div class="panel-body incapacidad">
                    <h5 class="blue">Incapacidad:</h5>
                    <div class="row-fluid">
                        <div class="span4">
                            <div class="span5"><label for="diasIncapacidad">D&iacute;as Incapacidad: </label></div>
                            <div class="span7">
                                <input type="text" id="diasIncapacidad" name="diasIncapacidad" class=" input obligatorio concepto" />
                                <input type="hidden" class="idClave input" name="id" value="0">
                            </div>
                        </div>
                        <div class="span4">
                            <div class="span5"><label for="tipoIncapacidad">Tipo Incapacidad: </label></div>
                            <div class="span7">
                                <select name="tipoIncapacidad" id="tipoIncapacidad" module="Incapacidad" class=" input obligatorio concepto">
                                    <option value="">Seleccionar</option>
                                    <c:forEach items="${tipoIncapacidad}" var="tipoIncapacidad" >
                                    <option value="${tipoIncapacidad.clave}" >${tipoIncapacidad.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="span5"><label for="importeMonetario">Importe Monetario: </label></div>
                            <div class="span7">
                                <div class="input-prepend">
                                    <span class="add-on">$</span>
                                    <input type="text" id="importeMonetario" name="importeMonetario" class=" numero  input obligatorio text-right" />
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="divRow separate clear right">
                        <label for="agregarIncapacidad" class="btn btn-primary">
                            <i class="icon-plus icon-white"></i>
                            AGREGAR
                        </label>
                        <input id="agregarIncapacidad" type="button" module="incapacidad" class="add hide" value="  AGREGAR  " />
                    </div>
                    <!-- <br> -->
                    <div class="mTabla">
                        <table id="tabla-incapacidades" class="table table-striped mTabla">
                            <thead>
                                <tr>
                                    <th>D&iacute;as</th>
                                    <th>Tipo Incapacidad</th>
                                    <th>Importe Monetario</th>
                                    <th>Eliminar</th>
                                    <!-- <th style="display:none;">Editar</th> -->
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div><!-- fin Incapacidad-->
            </div>
        </div>
        <%-- CONCEPTO --%>
        <div class="percepcion panel1">
            <h4 class="blue">Concepto:</h4>
            <div class="panel-body" style="overflow-y: auto;">
                <table  class="table table-striped tablaTotal text-center  mTabla">
                    <thead>
                        <tr>
                            <td>CveProdServ</td>
                            <td>Cantidad</td>
                            <td>Cve Unidad</td>
                            <td>Concepto</td>
                            <td>P. Unitario</td>
                            <td>Importe</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="claveProdServ" readonly="readonly" value="84111505" class="concepto">
                            </td>
                            <td>
                                <input type="text" name="cantidad" readonly="readonly" value="1" class="concepto">
                            </td>
                            <td>
                                <input type="text" name="claveUnidad" readonly="readonly" value="ACT" class="concepto">
                            </td>
                            <td>
                                <textarea  type="text" name="descripcion" readonly="readonly" value="1" class="concepto" style="height: 30px;min-height: 26px;">Pago de nómina</textarea>
                            </td>
                            <td>
                                <div class="input-prepend" style="width: 90%">
                                    <span class="add-on">$</span>
                                    <input type="text" name="valorUnitario" readonly="readonly" value="0.00" class="concepto  text-right">
                                </div>
                            </td>
                            <td>
                                <div class="input-prepend" style="width: 90%">
                                    <span class="add-on">$</span>
                                    <input type="text" name="importe" readonly="readonly" value="0.00" class="concepto  text-right">
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div> <!-- End CONCEPTO panel -->
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
											<option value="04">Sustitución de los CFDI previos</option>
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
		<!--  <div class="span7">
	        <br>
	    	<label>Observaciones:</label><br>
	    	<textarea name="observaciones" class="comprobante span7" rows="5"></textarea>
	   	</div>-->
        <div>
            <div class="row-fluid">
                <div class="span5 offset7">
                    <br>
                    <table id="tablaTotales" cellpadding="0" colspanding="0" style="margin-right: 10px;">
                        <tbody>
                            <tr>
                                <th><label>Subtotal: </label></th>
                                <td>
                                    <div class="input-prepend input-append">
                                        <span class="add-on">$</span>
                                        <input name="subTotal" readonly="readonly" value="0.00" type="text" class="comprobante text-right">
                                        <input name="totalImpuestosTrasladados" type="hidden">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th><label>Descuento: </label></th>
                                <td>
                                    <div class="input-prepend input-append">
                                        <span class="add-on">$</span>
                                        <input name="descuento" readonly="readonly" value="0.00" type="text" class="comprobante text-right">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th><label>I.S.R.:</label></th>
                                <td>
                                    <div class="input-prepend input-append">
                                        <span class="add-on">$</span>
                                        <input name="totalISRRetenido" readonly="readonly" value="0.00" type="text" class="comprobante text-right">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th><label>Neto a pagar:  </label></th>
                                <td>
                                    <div class="input-prepend input-append">
                                        <span class="add-on">$</span>
                                        <input name="total" readonly="readonly" value="0.00" type="text" class="comprobante text-right">
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div style="clear: both;"></div>
    </form>
    <br><br>
    <div class="row-fluid">
        <form action="${contextPath}/comprobante/vistaPrevia" class="span3 offset3" id="formVistaPrevia" method="post" target="_blank">
            <input type="hidden" name="strComprobante" class="strComprobante">
            <label for="vistaPrevia" class="btn btn-success">
                <i class="icon-eye-open icon-white"></i>
                Vista previa
            </label>
            <input type="submit" id="vistaPrevia" value="Vista Previa" class="hide" style="font-size: 16px;font-weight: bold">
        </form>
        <form action="${contextPath}/comprobante/timbrarComprobante" class="span3" id="formGenerarComprobante" method="post">
            <input type="hidden" name="strComprobante" class="strComprobante">
            <label for="generarComprobante" class="btn btn-success">
                <i class="icon-file icon-white"></i>
                Generar Comprobante
            </label>
            <input type="submit" id="generarComprobante" data-loading-text="Generando comprobante..." value="Generar Comprobante" class="hide" style="font-size: 16px;font-weight: bold">
        </form>
    </div>
</div>