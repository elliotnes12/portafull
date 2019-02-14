var totalIVA = 0;
var mapConceptos = new Array();
var conceptosDespensa = new Array();
var conceptosConsumoCombustibles  = new Array();
var determinadosConsumoCombustibles  = new Array();
var adquirientes = new Array();
var enajenantes = new Array();
var mapImpuestosTraslados = new Array();
var lineItems = new Array();
var numeroDecimales = 2;
var firmas = new Array();
var subtotal, descuento = 0, totalIVA = 0, totalIEPS = 0;
var ivaDescuentoRestado = 0;
var tasaIEPS = "";
var noObjIva = 0;
var subtotalCombustibles = 0;
var totalCombustibles = 0;
var totalImportes = 0;
var infoAduaneras  = new Array();
var infoAduanerasVentaVehiculos = new Array();
var partes = new Array();
var infoAduanerasParteVentaVehiculos  = new Array();
var retencionesCuentaTerceros  = new Array();
var trasladosCuentaTerceros  = new Array();
var infoAduanerasParteCuentaTerceros = new Array();
var specialInstructionArr = new Array();
var referenceIdentificationArr = new Array();
var additionalInformationArr = new Array();
var deliveryNoteArr = new Array();
var customsArr = new Array();
var currencyArr = new Array();
var allowanceChargeArr = new Array();
var totalAllowanceChargeArr = new Array();
var lineItemArr = new Array();
var alternateTradeItemIdentificationArr = new Array();
var addAditionalQuantityArr = new Array();
var CustomsLineItemArr = new Array();
var extendedAttributesArr = new Array();
var allowanceChargeLineItemArr = new Array();
var tradeItemTaxInformationArr = new Array();

function validaDeterminadosConsumoCombustibles(){
  if ($('input[name=tipoImpuesto]').val() == "") {
		alert("Debe seleccionar el Tipo de Impuesto");
		$('#tipoImpuesto').focus();
		return false;
	}
  if ($('input[name=tasaImpuesto]').val() == "") {
		alert("Debe introducir la Tasa del Impuesto");
		$('#tasaImpuesto').focus();
		return false;
	}
  if ($('input[name=importeImpuesto]').val() == "") {
		alert("Debe introducir el Importe del Impuesto");
		$('#importeImpuesto').focus();
		return false;
	}
else{
  return true;
}
}
function validaConceptoConsumoCombustibles(){
  if ($('input[name=identificador]').val() == "") {
		alert("Debe introducir el Identificador");
		$('#identificador').focus();
		return false;
	}
  if ($('input[name=fechaExpOper]').val() == "") {
		alert("Debe introducir la Fecha");
		$('#fechaExpOper').focus();
		return false;
	}
  if ($('input[name=rfcEnajCombustible]').val() == "") {
		alert("Debe introducir el RFC");
		$('#rfcEnajCombustible').focus();
		return false;
	}
  if ($('input[name=claveEstacion]').val() == "") {
		alert("Debe introducir la Clave de la Estación");
		$('#claveEstacion').focus();
		return false;
	}
  if ($('input[name=volumen]').val() == "") {
		alert("Debe introducir el Volumen");
		$('#volumen').focus();
		return false;
	}
  if ($('input[name=nombreCombustible]').val() == "") {
		alert("Debe introducir el Nombre del Combustible");
		$('#nombreCombustible').focus();
		return false;
	}
  if ($('input[name=folioOperacion]').val() == "") {
		alert("Debe introducir el Folio de la Operación");
		$('#folioOperacion').focus();
		return false;
	}
  if ($('input[name=precioUnitario]').val() == "") {
		alert("Debe introducir el Precio Unitario");
		$('#precioUnitario').focus();
		return false;
	}
  if ($('input[name=importeCombustible]').val() == "") {
		alert("Debe introducir el Importe");
		$('#importeCombustible').focus();
		return false;
	}
else{
  return true;
}
}

function validaRetencionCuentaTerceros(){
  if ($('input[name=impuestoRetencionesCuentaTerceros]').val() == "") {
		alert("Debe seleccionar el Tipo de Impuesto");
		$('#impuestoRetencionesCuentaTerceros').focus();
		return false;
	}
  if ($('input[name=importeRetencionesCuentaTerceros]').val() == "") {
		alert("Debe introducir el Importe del Impuesto");
		$('#importeRetencionesCuentaTerceros').focus();
		return false;
	}
else{
  return true;
}
}

function validaTrasladosCuentaTerceros(){
  if ($('input[name=impuestoTrasladosCuentaTerceros]').val() == "") {
		alert("Debe seleccionar el Tipo de Impuesto");
		$('#impuestoTrasladosCuentaTerceros').focus();
		return false;
	}
  if ($('input[name=tasaTrasladosCuentaTerceros]').val() == "") {
		alert("Debe introducir la Tasa del Impuesto");
		$('#tasaTrasladosCuentaTerceros').focus();
		return false;
	}
  if ($('input[name=importeTrasladosCuentaTerceros]').val() == "") {
		alert("Debe introducir Importe del Impuesto");
		$('#importeTrasladosCuentaTerceros').focus();
		return false;
	}
else{
  return true;
}
}

function validaConceptoValesDespensa(){
  if ($('input[name=identificadorValesDespensa]').val() == "") {
		alert("Debe introducir el Identificador");
		$('#identificadorValesDespensa').focus();
		return false;
	}
  if ($('input[name=fechaValesDespensa]').val() == "") {
		alert("Debe introducir la Fecha");
		$('#fechaValesDespensa').focus();
		return false;
	}
  if ($('input[name=horaValesDespensa]').val() == "") {
		alert("Debe introducir la Hora");
		$('#horaValesDespensa').focus();
		return false;
	}
  if ($('input[name=minutosValesDespensa]').val() == "") {
		alert("Debe introducir los Minutos");
		$('#minutosValesDespensa').focus();
		return false;
	}
  if ($('input[name=segundosValesDespensa]').val() == "") {
		alert("Debe introducir los Segundos");
		$('#segundosValesDespensa').focus();
		return false;
	}
  if ($('input[name=rfcValesDespensa]').val() == "") {
		alert("Debe introducir el RFC");
		$('#rfcValesDespensa').focus();
		return false;
	}
  if ($('input[name=curpValesDespensa]').val() == "") {
		alert("Debe introducir el CURP");
		$('#curpValesDespensa').focus();
		return false;
	}
  if ($('input[name=nombreValesDespensa]').val() == "") {
		alert("Debe introducir el Nombre");
		$('#nombreValesDespensa').focus();
		return false;
	}
  if ($('input[name=importeValesDespensa]').val() == "") {
		alert("Debe introducir el Importe");
		$('#importeValesDespensa').focus();
		return false;
	}
else{
  return true;
  }
}

function validaInfoAduanera(){
  if ($('input[name=numero]').val() == "") {
		alert("Debe introducir el Número del Documento Aduanero");
		$('#numero').focus();
		return false;
	}
  if ($('input[name=fechaExpDocAduanero]').val() == "") {
		alert("Debe introducir la Fecha de Expedición del Documento Aduanero");
		$('#numero').focus();
		return false;
	}
else{
  return true;
}
}


function validaInfoAduaneraVentaVehiculos(){
  if (partes.length > 0) {
		alert("Ya agregó Información de Partes para este complemento, por lo que no se puede agregar Información Aduanera");
		return false;
	}  
  if ($('input[name=numeroVentaVehiculos]').val() == "") {
		alert("Debe introducir el Número del Documento Aduanero");
		$('#numeroVentaVehiculos').focus();
		return false;
	}
  if ($('input[name=fechaExpDocAduaneroVentaVehiculos]').val() == "") {
		alert("Debe introducir la Fecha de Expedición del Documento Aduanero");
		$('#fechaExpDocAduaneroVentaVehiculos').focus();
		return false;
	}
else{
  return true;
}
}

function validaInfoAduaneraParteVentaVehiculos(){
  if (($('input[name=cantidadParteVentaVehiculos]').val() == "")&&($('input[name=descripcionParteVentaVehiculos]').val() == "")) {
		alert("Antes de agregar Información Aduanera para Partes o Componentes, debe agregar información de la Sección Parte");
		$('#cantidadParteVentaVehiculos').focus();
		return false;
	}  
  if ($('input[name=numeroParteVentaVehiculos]').val() == "") {
		alert("Debe introducir el Número del Documento Aduanero");
		$('#numeroParteVentaVehiculos').focus();
		return false;
	}
  if ($('input[name=fechaExpDocAduaneroParteVentaVehiculos]').val() == "") {
		alert("Debe introducir la Fecha de Expedición del Documento Aduanero");
		$('#fechaExpDocAduaneroParteVentaVehiculos').focus();
		return false;
	}
else{
  return true;
}
}

function validaParteVentaVehiculos(){
  if (infoAduanerasVentaVehiculos.length > 0) {
		alert("Ya agregó Información Aduanera para este complemento, por lo que no se puede agregar Información de Partes");
		return false;
	}
  if ($('input[name=cantidadParteVentaVehiculos]').val() == "") {
		alert("Debe introducir la Cantidad de Bienes o Servicios");
		$('#cantidadParteVentaVehiculos').focus();
		return false;
	}
  if ($('input[name=descripcionParteVentaVehiculos]').val() == "") {
		alert("Debe introducir la Descripción del Bien o Servicio");
		$('#descripcionParteVentaVehiculos').focus();
		return false;
	}
else{
  return true;
}
}


function validaParteCuentaTerceros(){
  if ($('input[name=numeroCuentaTerceros]').val() != "" && $('input[name=fechaExpDocAduaneroCuentaTerceros]').val() != "") {
		alert("Ya agregó Información Aduanera para este complemento, por lo que no se puede agregar Información de Partes");
		return false;
	}
  if ($('input[name=numeroCuentaPredialTerceros]').val() != "" ) {
		alert("Ya agregó Información para Cuenta Predial para este complemento, por lo que no se puede agregar Información de Partes");
		return false;
	}
  if ($('input[name=cantidadCuentaTerceros]').val() == "") {
		alert("Debe introducir la Cantidad de Bienes o Servicios");
		$('#cantidadCuentaTerceros').focus();
		return false;
	}
  if ($('input[name=descripcionCuentaTerceros]').val() == "") {
		alert("Debe introducir la Descripción del Bien o Servicio");
		$('#descripcionCuentaTerceros').focus();
		return false;
	}
else{
  return true;
}
}


function validaInfoAduaneraParteCuentaTerceros(){
  if (($('input[name=cantidadCuentaTerceros]').val() == "")&&($('input[name=descripcionCuentaTerceros]').val() == "")) {
		alert("Antes de agregar Información Aduanera para Partes o Componentes, debe agregar información de la Sección Parte");
		$('#cantidadCuentaTerceros').focus();
		return false;
	}  
  if ($('input[name=numeroParteCuentaTerceros]').val() == "") {
		alert("Debe introducir el Número del Documento Aduanero");
		$('#numeroParteCuentaTerceros').focus();
		return false;
	}
  if ($('input[name=fechaExpDocAduaneroParteCuentaTerceros]').val() == "") {
		alert("Debe introducir la Fecha de Expedición del Documento Aduanero");
		$('#fechaExpDocAduaneroParteCuentaTerceros').focus();
		return false;
	}
else{
  return true;
}
}
function graficarConceptoDespensa() {

	$('#tablaConceptosDespensa tbody').html('');

  $.each(conceptosDespensa, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['identificadorValesDespensa'] + '</td>';
		row += '<td>' + concepto['fechaValesDespensa'] + '</td>';
		row += '<td>' + concepto['rfcValesDespensa'] + '</td>';
		row += '<td>' + concepto['curpValesDespensa'] + '</td>';
		row += '<td>' + concepto['nombreValesDespensa'] + '</td>';
		if (concepto['numSeguridadSocial'] != null)
  		row += '<td>' + concepto['numSeguridadSocial'] + '</td>';
    else
      row += '<td></td>';
    row += '<td>' + concepto['importeValesDespensa'] + '</td>';

		row += '</tr>';

		$('#tablaConceptosDespensa').append(row);
  }); 

}

function graficarInformacionAduanera() {

	$('#tablaInfoAduanera tbody').html('');

  $.each(infoAduaneras, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['numero'] + '</td>';
		row += '<td>' + concepto['fechaExpDocAduanero'] + '</td>';
    if (concepto['aduana'] != null)
  		row += '<td>' + concepto['aduana'] + '</td>';
    else
      row += '<td></td>';
		row += '</tr>';

		$('#tablaInfoAduanera').append(row);
  }); 

}

function graficarInformacionAduaneraVentaVehiculos() {

	$('#tablaInfoAduaneraVentaVehiculos tbody').html('');

  $.each(infoAduanerasVentaVehiculos, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['numero'] + '</td>';
		row += '<td>' + concepto['fechaExpDocAduanero'] + '</td>';
    if (concepto['aduana'] != null)
  		row += '<td>' + concepto['aduana'] + '</td>';
    else
      row += '<td></td>';
		row += '</tr>';

		$('#tablaInfoAduaneraVentaVehiculos').append(row);
  }); 
}


function graficarInformacionAduaneraParteVentaVehiculos() {

	$('#tablaInfoAduaneraParteVentaVehiculos tbody').html('');

  $.each(infoAduanerasParteVentaVehiculos, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['numero'] + '</td>';
		row += '<td>' + concepto['fechaExpDocAduanero'] + '</td>';
    if (concepto['aduana'] != null)
  		row += '<td>' + concepto['aduana'] + '</td>';
    else
      row += '<td></td>';
		row += '</tr>';

		$('#tablaInfoAduaneraParteVentaVehiculos').append(row);
  });
}

function graficarPartesVentaVehiculos() {

	$('#tablaParte tbody').html('');

  $.each(partes, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['cantidad'] + '</td>';
    if (concepto['unidad'] != null)
  		row += '<td>' + concepto['unidad'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['noIdentificacion'] != null)
  		row += '<td>' + concepto['noIdentificacion'] + '</td>';
    else
      row += '<td></td>';
    row += '<td>' + concepto['descripcion'] + '</td>';
    if (concepto['valorUnitario'] != null)
  		row += '<td>' + concepto['valorUnitario'] + '</td>';
    else
      row += '<td></td>';				
    if (concepto['importe'] != null)
  		row += '<td>' + concepto['importe'] + '</td>';
    else
      row += '<td></td>';				
  
		row += '</tr>';

		$('#tablaParte').append(row);
  });
}

function graficarPartesCuentaTerceros() {

	$('#tablaParteCuentaTerceros tbody').html('');

  $.each(partes, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['cantidad'] + '</td>';
    if (concepto['unidad'] != null)
  		row += '<td>' + concepto['unidad'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['noIdentificacion'] != null)
  		row += '<td>' + concepto['noIdentificacion'] + '</td>';
    else
      row += '<td></td>';
    row += '<td>' + concepto['descripcion'] + '</td>';
    if (concepto['valorUnitario'] != null)
  		row += '<td>' + concepto['valorUnitario'] + '</td>';
    else
      row += '<td></td>';				
    if (concepto['importe'] != null)
  		row += '<td>' + concepto['importe'] + '</td>';
    else
      row += '<td></td>';				
  
		row += '</tr>';

		$('#tablaParteCuentaTerceros').append(row);
  });
}

function graficarDeterminadosConsumoCombustibles() {

	$('#tablaDeterminadosComplementoCombustibles tbody').html('');

  $.each(determinadosConsumoCombustibles, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['tipoImpuesto'] + '</td>';
		row += '<td>' + concepto['tasaImpuesto'] + '</td>';
		row += '<td>' + concepto['importeImpuesto'] + '</td>';

		row += '</tr>';

		$('#tablaDeterminadosComplementoCombustibles').append(row);
  }); 

}

function graficarConceptoConsumoCombustibles() {

	$('#tablaConceptosComplementoCombustibles tbody').html('');

  $.each(conceptosConsumoCombustibles, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['identificador'] + '</td>';
		row += '<td>' + concepto['fechaExpOper'] + '</td>';
		row += '<td>' + concepto['rfcEnajCombustible'] + '</td>';
		row += '<td>' + concepto['claveEstacion'] + '</td>';
		row += '<td>' + concepto['volumen'] + '</td>';
		row += '<td>' + concepto['nombreCombustible'] + '</td>';
    row += '<td>' + concepto['folioOperacion'] + '</td>';
    row += '<td>' + concepto['precioUnitario'] + '</td>';
    row += '<td>' + concepto['importeCombustible'] + '</td>';


		row += '</tr>';

		$('#tablaConceptosComplementoCombustibles').append(row);
  }); 

}


function eliminarData(id) {
	var obj = mapConceptos[id];
	if (obj.ivaExento == undefined) { 
		totalIVA -= obj.iva;
	}
	if (obj.ieps != "") {
		var iepsD = redondearValor((obj.ieps / 100) *  (obj.valorUnitario * obj.cantidad));
 		if ($.isNumeric(iepsD)) {
			totalIEPS -= iepsD;
		}
	}
	mapConceptos.splice(id, 1);
	graficarConceptos();
}

function agregarConcepto() {
	var obj = $('#formAgregarConcepto .input').serializeObject();
	obj.descripcion = $('#formAgregarConcepto textarea').val();
	
	if ($('#valorUnitario').val() == "") {
		alert("Debe introducir el precio");
		$('#valorUnitario').focus();
		return;
	}

	if ($('input[name=rfc].emisor').val() != "ISA091217NP3" && parseFloat($('#valorUnitario').val()) < 0) {
		alert("Debe introducir una cantidad positiva");
		$('#valorUnitario').focus();
		return;
  }

	
	if ($('#unidad').val() == "") {
		alert("Debe introducir la unida de medida.");
		$('#unidad').focus();
		return;
	}

	if (!$.isNumeric($('#cantidad').val())) {
		$('#cantidad').focus();
		alert("Debe agregar cantidad");
		return false;
	} else if (!$.isNumeric($('#valorUnitario').val())) {
		$('#valorUnitario').focus();
		alert("Debe agregar el precio");
		return false;
	} else if (!$.isNumeric($('#iva').val())) {
		$('#iva').focus();
		alert("Debe agregar el iva");
		return false;
	}

	obj.cantidad = new Number(obj.cantidad).toFixed(numeroDecimales); //parseFloat(obj.cantidad);
	obj.descuento = obj.descuento == "" ? "" : parseFloat(obj.descuento);
	obj.ieps = obj.ieps == "" ? "" : parseFloat(obj.ieps);
	obj.iva = obj.iva == "" ? "" : parseFloat(obj.iva);
	obj.valorUnitario = redondearValor(obj.valorUnitario);

	if (!$('input[name=mClave]').is(':checked')) {
		delete obj.clave;
	}

	if ($('#cuentaPredial').val() != undefined && $('#cuentaPredial').val() != "") {
	 obj.cuentaPredial = new Object();
	 obj.cuentaPredial.numero = $('#cuentaPredial').val();
	} else {
	 delete obj.cuentaPredial;
	}

	
	if ($('#descuentoPorcentaje').val() == 1 || $('#descuentoPorcentaje').val() == "true") {
		descuento = obj.valorUnitario * (obj.descuento / 100);
		obj.descuento = descuento;
	}
        obj.descuento *= obj.cantidad;

	var porIva = (1 + ($('#iva').val()) / 100);	
	if ($('#ivaIncluido').is(':checked')) {
		if ($('#ish').is(':checked')) {
			var tasaISH = parseFloat($('#tasaISH').val()) / 100;
			porIva += tasaISH; // 0.02;
		}
		
	}
	if ($('#ivaIncluido').is(':checked') && !$('input[name=mIEPS]').is(':checked')) {
//			var tasaISH = parseFloat($('#ieps').val()) / 100;
//			porIva += tasaISH; // 0.02;
//		}f
		obj.valorUnitario = redondearValor($('#valorUnitario').val() / porIva) + obj.descuento;		
	}
	

	var importe = redondearValor(((obj.valorUnitario * obj.cantidad) - obj.descuento)); 	

/*
	if ($('#ivaIncluido').is(':checked')) {
	        obj.valorUnitario = redondearValor(importe / porIva);
	}
*/

	if ($('#ivaIncluido').is(':checked')) {	       
                var x = parseFloat($('#ieps').val()) / 100;
                var y = parseFloat($('#iva').val()) / 100;
		if ($('input[name=mIEPS]').is(':checked')) {
			obj.valorUnitario = redondearValor((importe + descuento) / (1 + x + y + (x * y))) + obj.descuento;
		}		
	}

	importe = redondearValor(((obj.valorUnitario * obj.cantidad))); // - obj.descuento));

	var iepsData = 0;
	if (obj.ieps != "") {
		tasaIEPS = obj.ieps;
		
		if ($('input[name=tipoIEPS]:checked').val() == "0") iepsData = ((obj.ieps / 100) * importe);
		if ($('input[name=tipoIEPS]:checked').val() == "1") iepsData = (obj.ieps * obj.cantidad);
		totalIEPS += iepsData;
	}
	
	if (obj.ivaExento == true) {
		obj.iva = 0;
	}

  var objIva = $('#noObjetoIva').val() != undefined && $('#noObjetoIva').is(':checked');
  
	var ivaIEPS1 = 0;
	if (obj.ivaExento == false || obj.ivaExento == undefined && !objIva) {
		if (mapImpuestosTraslados[obj.iva] == undefined) {
			mapImpuestosTraslados[obj.iva] = 0;
		}
		iva = redondearValor(parseFloat(importe - obj.descuento) * (obj.iva / 100));
		totalIVA += parseFloat(iva);
		iva = new Number(parseFloat(iva)).toFixed(numeroDecimales);
		obj.iva = iva;
		mapImpuestosTraslados[obj.iva] += iva;
	}

	
        
	obj.importe = importe;	

  if (objIva) {
		obj.iva = 0;
		noObjIva += parseFloat(obj.importe);
  }
	obj.importe = new Number(parseFloat(obj.importe)).toFixed(numeroDecimales);
	obj.valorUnitario = new Number(parseFloat(obj.valorUnitario)).toFixed(numeroDecimales);
	mapConceptos.push(obj);
	graficarConceptos();
	// $('input[name=unidad]').val('');
	$('input[name=cantidad]').val('');
	$('input[name=valorUnitario]').val('');
	$('#concepto').val('');
	
	if ($('#ish').is(':checked')) {
		$('select[name=tipoImpuesto].impLoc1').val('Traslado');
		$('input[name=impLoc].impLoc1').val('I.S.H');
		$('input[name=tasade].impLoc1').val($('#tasaISH').val());
		$('input[name=tasade].impLoc1').trigger('change');
	}
}

function validarPagoEnEspcie() {
  if ($('input[name=cvePIC]').val() != "" && $('input[name=cvePIC]').val() != undefined) {
		var pagoEnEspecie = new Object();
		pagoEnEspecie = $('.pagoEspecie').serializeObject();
		return pagoEnEspecie;
  }
  return null;
}

function validarRegistroFiscal() {
  if ($('input[name=folio].registroFiscal').val() != "" && $('input[name=folio].registroFiscal').val() != undefined) {
		var pagoEnEspecie = new Object();
		pagoEnEspecie = $('.registroFiscal').serializeObject();
		return pagoEnEspecie;
  }
  return null;
}


function validarNotario() {
  if ($('input[name=numNotaria]').val() != "" && $('input[name=numNotaria]').val() != undefined) {		
		var notario = new Object();
		notario.datosNotario = $('.notario').serializeObject();
		notario.datosOperacion = $('.operacion').serializeObject();

		notario.descInmuebles = new Object();
		var descInmueble = $('.inmueble').serializeObject();
		notario.descInmuebles.descInmueble = new Array();
		notario.descInmuebles.descInmueble.push(descInmueble);


		notario.datosEnajenante = new Object();
		notario.datosEnajenante.coproSocConyugalE = $('#adquirienteSIoNoE').val();
		
		if (enajenantes.length <= 0) {
			var datosUnEnajenante = $('.enajenante').serializeObject();
			delete datosUnEnajenante.porcentaje;
			notario.datosEnajenante.datosUnEnajenante = datosUnEnajenante;	
		} else {
				notario.datosEnajenante.datosEnajenantesCopSC = new Object();
				notario.datosEnajenante.datosEnajenantesCopSC.datosEnajenanteCopSC = enajenantes;
		}

		notario.datosAdquiriente = new Object();
		notario.datosAdquiriente.coproSocConyugalE  = $('#adquirienteSIoNo').val();

	  if (adquirientes.length <= 0) {
			var datosUnAdquiriente = $('.adquiriente').serializeObject();
			delete datosUnAdquiriente.porcentaje;
			notario.datosAdquiriente.datosUnAdquiriente = datosUnAdquiriente;		
		} else {
				notario.datosAdquiriente.datosAdquirientesCopSC = new Object();
				notario.datosAdquiriente.datosAdquirientesCopSC.datosAdquirienteCopSC = adquirientes;
		}
		return notario;
	}
	return null;
}

function validarConsumoCombustibles() {
  if ($('input[name=numeroDeCuenta]').val() != "" && $('input[name=numeroDeCuenta]').val() != undefined) {		
    var ConsumoDeCombustibles = new Object();
    ConsumoDeCombustibles.tipoOperacion = $('#tipoOperacion').val();
    ConsumoDeCombustibles.numeroDeCuenta = $('#numeroDeCuenta').val();
    if ($('input[name=subTotalCombustibles]').val() == "") {
      ConsumoDeCombustibles.subTotal = null;
    }    
    else{
      ConsumoDeCombustibles.subTotal = $('#subTotalCombustibles').val();
    }

    
    ConsumoDeCombustibles.total = $('#totalCombustibles').val();

    ConsumoDeCombustibles.conceptos = new Object();
    ConsumoDeCombustibles.conceptos.conceptoconsumodecombustibles = new Array();  
    ConsumoDeCombustibles.conceptos.conceptoconsumodecombustibles = conceptosConsumoCombustibles;

    ConsumoDeCombustibles.conceptos.conceptoconsumodecombustibles.determinados = new Object();  
    ConsumoDeCombustibles.conceptos.conceptoconsumodecombustibles.determinados.determinado = new Array();
    ConsumoDeCombustibles.conceptos.conceptoconsumodecombustibles.determinados.determinado = determinadosConsumoCombustibles; 

		return ConsumoDeCombustibles;
	}
	return null;
}


function validarVehiculoUsado() {
if ($('input[name=montoAdquisicion]').val() != undefined){
  if ($('input[name=montoAdquisicion]').val() != "" && $('input[name=montoEnajenacion]').val() != "" && $('input[name=claveVehicular]').val() != ""
    && $('input[name=marca]').val() != "" && $('input[name=tipo]').val() != "" && $('input[name=modelo]').val() != "" 
    && $('input[name=valor]').val() != "") {
      var VehiculoUsado = new Object();
      VehiculoUsado.montoAdquisicion = $('#montoAdquisicion').val();
      VehiculoUsado.montoEnajenacion = $('#montoEnajenacion').val();
      VehiculoUsado.claveVehicular = $('#claveVehicular').val();
      VehiculoUsado.marca = $('#marca').val();
      VehiculoUsado.tipo = $('#tipo').val();
      VehiculoUsado.modelo = $('#modelo').val();
      if ($('input[name=numeroMotor]').val() == "") {
        VehiculoUsado.numeroMotor = null;
      }    
      else{
        VehiculoUsado.numeroMotor = $('#numeroMotor').val();
      }
      if ($('input[name=numeroSerie]').val() == "") {
        VehiculoUsado.numeroSerie = null;
      }    
      else{
        VehiculoUsado.numeroSerie = $('#numeroSerie').val();
      }
      if ($('input[name=NIV]').val() == "") {
        VehiculoUsado.NIV = null;
      }    
      else{
        VehiculoUsado.NIV = $('#NIV').val();
      }
      VehiculoUsado.valor = $('#valor').val();

      VehiculoUsado.informacionAduanera = new Object();
      VehiculoUsado.informacionAduanera = infoAduaneras;

		  return VehiculoUsado;
	  }
  }
  else{
    return null;
  }
	
}

function validarValesDespensa() {
if ($('input[name=numeroDeCuentaValesDespensa]').val() != undefined){
  if ($('input[name=numeroDeCuentaValesDespensa]').val() != "" && $('input[name=totalValesDespensa]').val() != "" ) {
      var ValesDespensa = new Object();
      ValesDespensa.tipoOperacion = $('#tipoOperacion').val();
      if ($('input[name=registroPatronal]').val() == "") {
        ValesDespensa.registroPatronal = null;
      }    
      else{
        ValesDespensa.registroPatronal = $('#registroPatronal').val();
      }
      ValesDespensa.numeroDeCuentaValesDespensa = $('#numeroDeCuentaValesDespensa').val();
      ValesDespensa.totalValesDespensa = $('#totalValesDespensa').val();
                  
		  return ValesDespensa;
	  }
  }
  else{
    return null;
  }
	
}

function validarParcialesConstruccion() {
  if ($('#numPerLicoAut').val() != undefined && $('#numPerLicoAut').val() != "" && $('#numPerLicoAut').val() != "")  {
		var parcialesConstruccion = new Object();
		parcialesConstruccion = $('.construccion').serializeObject();
    parcialesConstruccion.inmueble = new Object();
    parcialesConstruccion.inmueble.calle = $('#calleConstruccion').val();
    if ($('input[name=noExteriorConstruccion]').val() == "") {
        parcialesConstruccion.inmueble.noExterior = null;
      }    
      else{
        parcialesConstruccion.inmueble.noExterior = $('#noExteriorConstruccion').val();
      }
    if ($('input[name=noInteriorConstruccion]').val() == "") {
        parcialesConstruccion.inmueble.noInterior = null;
      }    
      else{
        parcialesConstruccion.inmueble.noInterior = $('#noInteriorConstruccion').val();
      }
    if ($('input[name=coloniaConstruccion]').val() == "") {
        parcialesConstruccion.inmueble.colonia = null;
      }    
      else{
        parcialesConstruccion.inmueble.colonia = $('#coloniaConstruccion').val();
      }
    if ($('input[name=localidadConstruccion]').val() == "") {
        parcialesConstruccion.inmueble.localidad = null;
      }    
      else{
        parcialesConstruccion.inmueble.localidad = $('#localidadConstruccion').val();
      }
    if ($('input[name=referenciaConstruccion]').val() == "") {
        parcialesConstruccion.inmueble.referencia = null;
      }    
      else{
        parcialesConstruccion.inmueble.referencia = $('#referenciaConstruccion').val();
      }
      parcialesConstruccion.inmueble.municipio = $('#municipioConstruccion').val();
      parcialesConstruccion.inmueble.estado = $('#estadoConstruccion').val();
      parcialesConstruccion.inmueble.codigoPostal = $('#codigoPostalConstruccion').val();

		return parcialesConstruccion;
  }
  return null;
}

function validarDetallista() {

if ($('#documentStatus').val() != 'undefined' )  {

 var detallista = new Object();
detallista.documentStatus = $('#documentStatus').val();
detallista.type = "SimpleInvoiceType";
detallista.contentVersion = "1.3.1";
detallista.documentStructureVersion="AMC8.1";

detallista.requestForPaymentIdentification = new Object();
detallista.requestForPaymentIdentification.entityType = $('#entityType').val();

if (specialInstructionArr.length > 0){
  detallista.specialInstruction = specialInstructionArr;
}

detallista.orderIdentification = new Object();
detallista.orderIdentification.referenceIdentification = new Array();
detallista.orderIdentification.referenceIdentification = referenceIdentificationArr;
detallista.orderIdentification.referenceDate = $('#orderDate').val();

if (additionalInformationArr.length > 0){
  detallista.additionalInformation = new Object();
  detallista.additionalInformation.referenceIdentification = new Array();
  detallista.additionalInformation.referenceIdentification = additionalInformationArr;
}

if (deliveryNoteArr.length > 0){
  var referenceIdentification = new Object();
  referenceIdentification = $('#deliveryNote').val();

  detallista.deliveryNote = new Object();
  detallista.deliveryNote.referenceIdentification = new Array();
  detallista.deliveryNote.referenceIdentification.push(deliveryNoteArr);
  detallista.deliveryNote.referenceDate = $('#deliveryDate').val();
}


detallista.buyer = new Object();
detallista.buyer.gln = $('#glnBuyer').val();
detallista.buyer.contactInformation = new Object();
detallista.buyer.contactInformation.personOrDepartmentName = new Object();
detallista.buyer.contactInformation.personOrDepartmentName.text = $('#contactBuyer').val();

if ($('input[name=glnSeller]').val() != "") {
  detallista.seller = new Object();
  detallista.seller.gln = $('#glnSeller').val();
  detallista.seller.alternatePartyIdentification = new Object();
  detallista.seller.alternatePartyIdentification.type = $('#alternatePartyIdentificationSeller').val();
}

if ($('input[name=glnShipTo]').val() != "") {
  detallista.shipTo = new Object();
  detallista.shipTo.gln = $('#glnShipTo').val();
  detallista.shipTo.nameAndAddress = new Object();
  detallista.shipTo.nameAndAddress.name = $('#nameShipTo').val();
  detallista.shipTo.nameAndAddress.streetAddressOne = $('#streetAddressOneShipTo').val();
  detallista.shipTo.nameAndAddress.city = $('#cityShipTo').val();
  detallista.shipTo.nameAndAddress.postalCode = $('#postalCodeShipTo').val();
}

if ($('input[name=glnInvoiceCreator]').val() != "") {
  detallista.invoiceCreator = new Object();
  detallista.invoiceCreator.gln = $('#glnInvoiceCreator').val();
  detallista.invoiceCreator.alternatePartyIdentification = new Object();
  detallista.invoiceCreator.alternatePartyIdentification.type = $('#alternatePartyIdentificationInvoiceCreator').val();
  detallista.invoiceCreator.nameAndAddress = new Object();
  detallista.invoiceCreator.nameAndAddress.name = $('#nameInvoiceCreator').val();
  detallista.invoiceCreator.nameAndAddress.streetAddressOne = $('#streetAddressOneInvoiceCreator').val();
  detallista.invoiceCreator.nameAndAddress.city = $('#cityInvoiceCreator').val();
  detallista.invoiceCreator.nameAndAddress.postalCode = $('#postalCodeInvoiceCreator').val();
}

if (customsArr.length > 0){
  detallista.Customs = customsArr;
}

if (currencyArr.length > 0){
  detallista.currency = new Array();
  detallista.currency.push(currencyArr);
}


if ($('input[name=paymentTermsEvent]').val() != "" && $('input[name=PaymentTermsRelationTime]').val() != "" 
&& $('input[name=valuePaymentTerms]').val() != "") {
  detallista.paymentTerms = new Object();
  detallista.paymentTerms = $('.paymentTerms').serializeObject();
}

if (allowanceChargeArr.length > 0){
  var allowanceCharge = new Object();
  detallista.allowanceCharge = new Array();
  detallista.allowanceCharge.push(allowanceChargeArr);
}

if (lineItemArr.length > 0){
  detallista.lineItem = new Array();
  detallista.lineItem.push(lineItemArr);
}

if ($('input[name=totalAmount]').val() != "") {
  detallista.totalAmount = new Object();
  detallista.totalAmount.amount = $('#totalAmount').val();
}

if (totalAllowanceChargeArr.length > 0){
  detallista.totalAllowanceCharge = new Array();
  detallista.totalAllowanceCharge.push(totalAllowanceChargeArr);
}


//detallista.lineItem = new Object();

/*
 = new Object();

$.each(lineItems, function(key, value) {
detallista.lineItem.push(lineItems);
})
*/




 return detallista;
} 
 return null;

}

function validarDonatarias() {
	if ($('#noAprobacion').val() != undefined && $('#noAprobacion').val() != "" && $('#fechaAprobacion').val() != "") {
		donataria = new Object();
		donataria.noAutorizacion = $('#noAprobacion').val();
		donataria.fechaAutorizacion = $('#fechaAprobacion').val();
		return donataria;
	}
	return null;
}

function validarImpuestosLocales() {
	var impuestosLocales = new Object();
	impuestosLocales.retencionesLocales = new Object();
	impuestosLocales.retencionesLocales.retencionesLocales = new Array();
	impuestosLocales.trasladosLocales = new Object();
	impuestosLocales.trasladosLocales.trasladosLocales = new Array();
	impuestosLocales.totalDeTraslados = 0;
	impuestosLocales.totalDeRetenciones = 0;
	var impLoc;
	for ( var i = 1; i <= 7; i++) {
		impLoc = $('.impLoc' + i).serializeObject();
		if (impLoc.tasade == "") {
			return impuestosLocales;
		}
		if (impLoc.importe == "") {
			return impuestosLocales;
		}
		if (impLoc.impLoc == "") {
			return impuestosLocales;
		}
		if (impLoc.tipoImpuesto == "Traslado") {
			impuestosLocales.trasladosLocales.trasladosLocales.push(impLoc);
			impuestosLocales.totalDeTraslados += parseFloat(impLoc.importe);
		} else if (impLoc.tipoImpuesto == "Retencion") {
			impuestosLocales.retencionesLocales.retencionesLocales.push(impLoc);
			impuestosLocales.totalDeRetenciones += parseFloat(impLoc.importe);
		}

	}
	
	impuestosLocales.totalDeTraslados = impuestosLocales.totalDeTraslados.toFixed(2);
	impuestosLocales.totalDeRetenciones = impuestosLocales.totalDeRetenciones.toFixed(2);
}

function limpiarObjecto(propiedades, obj) {
	$.each(propiedades, function(key, value) {
		if (obj[value] == "") {
			delete obj[value];
		}
	});
}
function redondearValor2(valor) {
	
 	a = "" + valor;
	if (a.indexOf('.') == -1) {
		a = a + ".00";
	} else {
		a.substr(0, a.indexOf(".") + (1 + numeroDecimales));
	}
	return parseFloat(valor.toFixed(2));

	//return parseFloat(valor).toFixed(numeroDecimales);
}

function precise_round(num, decimals) {
    var parts = num.split('.');
    var hasMinus = parts.length > 0 && parts[0].length > 0 && parts[0].charAt(0) == '-';
    var integralPart = parts.length == 0 ? '0' : (hasMinus ? parts[0].substr(1) : parts[0]);
    var decimalPart = parts.length > 1 ? parts[1] : '';
    if (decimalPart.length > decimals) {
        var roundOffNumber = decimalPart.charAt(decimals);
        decimalPart = decimalPart.substr(0, decimals);
        if ('56789'.indexOf(roundOffNumber) > -1) {
            var numbers = integralPart + decimalPart;
            var i = numbers.length;
            var trailingZeroes = '';
            var justOneAndTrailingZeroes = true;
            do {
                i--;
                var roundedNumber = '1234567890'.charAt(parseInt(numbers.charAt(i)));
                if (roundedNumber === '0') {
                    trailingZeroes += '0';
                } else {
                    numbers = numbers.substr(0, i) + roundedNumber + trailingZeroes;
                    justOneAndTrailingZeroes = false;
                    break;
                }
            } while (i > 0);
            if (justOneAndTrailingZeroes) {
                numbers = '1' + trailingZeroes;
            }
            integralPart = numbers.substr(0, numbers.length - decimals);
            decimalPart = numbers.substr(numbers.length - decimals);
        }
    } else {
        for (var i = decimalPart.length; i < decimals; i++) {
            decimalPart += '0';
        }
    }
    return (hasMinus ? '-' : '') + integralPart + (decimals > 0 ? '.' + decimalPart : '');
}

/*
function redondearValor(valor) {
	
 	a = "" + valor;
	if (a.indexOf('.') == -1) {
		a = a + ".00";
	} else {
		a.substr(0, a.indexOf(".") + (1 + numeroDecimales));
	}
	return parseFloat(valor.toFixed(numeroDecimales));

	//return parseFloat(valor).toFixed(numeroDecimales);
}
*/

function redondearValor(valor) {
    decimals = numeroDecimales;
    num = valor;
 var sign = num >= 0 ? 1 : -1;
    return parseFloat((Math.round((num*Math.pow(10,decimals))+(sign*0.001))/Math.pow(10,decimals)).toFixed(decimals));
	
 	a = "" + valor;
	if (a.indexOf('.') == -1) {
		a = a + ".00";
	} else {
		a.substr(0, a.indexOf(".") + (1 + numeroDecimales));
	}
	return parseFloat(parseFloat(valor).toFixed(numeroDecimales));

	//return parseFloat(valor).toFixed(numeroDecimales);
}


function comprobanteToJSON() {
	if ($('#pais option:selected').val() == "") {
		$('#pais option[value=México]').attr('selected','selected');
	}
	
	var comprobante = $('.comprobante').serializeObject();
	if (comprobante.descuento = 0) {
		delete comprobante.descuento;
	}  else {
		comprobante.descuento = redondearValor(comprobante.descuento);
	}
	
	if ($('#nombreAlumno').val() != "" || $('#curp').val() != "" ) {
		var instEducativas = $('.instEducativas').serializeObject();
		var index = mapConceptos.length - 1;
		mapConceptos[index].complementoConcepto = new Object();
		//mapConceptos[index].complementoConcepto.complementoConcepto = new Object();
		mapConceptos[index].complementoConcepto.instEducativas = instEducativas;
	}

  if ($('#ClaveVehicularVentaVehiculos').val() != "" || $('#NivVentaVehiculos').val() != "" ) {
		var ventaVehiculos = $('.ventaVehiculos').serializeObject();
    ventaVehiculos.informacionAduanera = new Object();
    ventaVehiculos.informacionAduanera = infoAduanerasVentaVehiculos;

    ventaVehiculos.parte = new Object();
    ventaVehiculos.parte = partes;

    ventaVehiculos.parte.informacionAduanera = new Object();
    ventaVehiculos.parte.informacionAduanera = infoAduanerasParteVentaVehiculos;
		var index = mapConceptos.length - 1;
		mapConceptos[index].complementoConcepto = new Object();
		//mapConceptos[index].complementoConcepto.complementoConcepto = new Object();
		mapConceptos[index].complementoConcepto.ventaVehiculos = ventaVehiculos;
	}

  if ($('#rfcCuentaTerceros').val() != "" ) {
		var cuentaTerceros = $('.cuentaTerceros').serializeObject();
    if ($('input[name=nombreCuentaTerceros]').val() == "") {
        cuentaTerceros.nombreCuentaTerceros = null;
      }    
      else{
        cuentaTerceros.nombreCuentaTerceros = $('input[name=nombreCuentaTerceros]').val();
      }

    if ($('#calleCuentaTerceros').val() != "" && $('#municipioCuentaTerceros').val() != "" && $('#estadoCuentaTerceros').val() != ""
      && $('#codigoPostalCuentaTerceros').val() != "") {    
        cuentaTerceros.informacionFiscalTercero = new Object();
        cuentaTerceros.informacionFiscalTercero = $('.cuentaTercerosInformacionFiscal').serializeObject();
        if ($('input[name=referenciaCuentaTerceros]').val() == "") {
        cuentaTerceros.informacionFiscalTercero.referenciaCuentaTerceros = null;
      }    
      else{
        cuentaTerceros.informacionFiscalTercero.referenciaCuentaTerceros = $('input[name=referenciaCuentaTerceros]').val();
      }
    }

    if ($('#numeroCuentaTerceros').val() != "" && $('#fechaExpDocAduaneroCuentaTerceros').val() != "") {
      cuentaTerceros.informacionAduanera = new Object();
      cuentaTerceros.informacionAduanera = $('.cuentaTercerosInformacionAduanera').serializeObject();
    }

    if (partes.length > 0){
      cuentaTerceros.parte = new Object();
      cuentaTerceros.parte = partes;
   
    }

    if ($('#numeroCuentaPredialTerceros').val() != "" ) {
      cuentaTerceros.cuentaPredial = new Object();
      cuentaTerceros.cuentaPredial = $('.cuentaPredialTerceros').serializeObject();
    }

    cuentaTerceros.impuestos = new Object();
    cuentaTerceros.impuestos.retenciones = new Object();  
    cuentaTerceros.impuestos.retenciones.retencion = new Object();
    cuentaTerceros.impuestos.retenciones.retencion = retencionesCuentaTerceros;    

    cuentaTerceros.impuestos.traslados = new Object();  
    cuentaTerceros.impuestos.traslados.traslado = new Object();  
    cuentaTerceros.impuestos.traslados.traslado = trasladosCuentaTerceros;    
  
    
		var index = mapConceptos.length - 1;
		mapConceptos[index].complementoConcepto = new Object();
		//mapConceptos[index].complementoConcepto.complementoConcepto = new Object();
		mapConceptos[index].complementoConcepto.cuentaTerceros = cuentaTerceros;
	}


	var propiedades = new Array("serie", "folio", "descuento", "ieps", "numCtaPago", "condicionesDePago");
	limpiarObjecto(propiedades, comprobante);

	comprobante.emisor = $('.emisor').serializeObject();
	comprobante.emisor.domicilioFiscal = $('.emisorDomicilio').serializeObject();
	propiedades = new Array("colonia", "localidad", "noExterior", "noInterior");
	limpiarObjecto(propiedades, comprobante.emisor.domicilioFiscal);

	comprobante.noObjetoIva = noObjIva;

	var regimenFiscal = new Array();
	var regimen = new Object();
	regimen.regimen = $('#regimen option:selected').val();
	regimenFiscal.push(regimen);
	
	comprobante.emisor.regimenFiscal = regimenFiscal;


	comprobante.receptor = $('.receptor').serializeObject();
	comprobante.receptor.domicilio = $('.receptorDomicilio').serializeObject();
	propiedades = new Array("calle", "colonia", "localidad", "municipio", "codigoPostal", "noExterior", "noInterior");
	limpiarObjecto(propiedades, comprobante.receptor.domicilio);

	var ivaTras = 0;
	/* limpiamos los conceptos */
	$.each(mapConceptos, function(key, value) {
    mapConceptos[key].importe =	new Number(mapConceptos[key].importe).toFixed(numeroDecimales);;
		if (mapConceptos[key]['ivaExento'] == undefined) {
			ivaTras += mapConceptos[key]["iva"];
		}
		
		propiedades = new Array("clave", "iva", "descuento", "ieps");
		$.each(propiedades, function(key1, value1) {
			if (mapConceptos[key][value1] == "") {
				delete mapConceptos[key][value1];
			}
		});

	});

        



	comprobante.conceptos = new Object();
	comprobante.conceptos.conceptos = mapConceptos;

	comprobante.impuestos = new Object();

	var impuestosLocales = validarImpuestosLocales();
	if (impuestosLocales != undefined && (impuestosLocales.retencionesLocales.retencionesLocales.length > 0
			|| impuestosLocales.trasladosLocales.trasladosLocales.length > 0)) {
		comprobante.complemento = new Object();
		if (impuestosLocales.retencionesLocales.retencionesLocales.length == 0) {
			delete impuestosLocales.retencionesLocales;
		} else if (impuestosLocales.trasladosLocales.trasladosLocales.length == 0) {
			delete impuestosLocales.trasladosLocales;
		}
		impuestosLocales.totalDeRetenciones = $('input[name=totalDeRetenciones]').val();
		impuestosLocales.totalDeTraslados  =  $('input[name=totalDeTraslados]').val();
		comprobante.complemento.impuestosLocales = impuestosLocales;
		
	}

	var donatarias = validarDonatarias();
	if (donatarias != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.donatarias = new Object();
		comprobante.complemento.donatarias = donatarias;
	}
	
	
	var detallista = validarDetallista();
	if (detallista != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.detallista = new Object();
		comprobante.complemento.detallista = detallista;
	}

	var notario = validarNotario();
	if (notario != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.notario = new Object();
		comprobante.complemento.notario.version = "1.0";
		comprobante.complemento.notariosPublicos = notario;
	}

  var consumocombustibles = validarConsumoCombustibles();
	if (consumocombustibles != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.consumodecombustibles = new Object();
		comprobante.complemento.consumodecombustibles.version = "1.0";
		comprobante.complemento.consumodecombustibles = consumocombustibles;
	}

    var vehiculousado = validarVehiculoUsado();
	  if (vehiculousado != null) {
		  if (comprobante.complemento == undefined) {
			  comprobante.complemento = new Object();
		  }
		  comprobante.complemento.vehiculousado = new Object();
		  comprobante.complemento.vehiculousado.version = "1.0";
		  comprobante.complemento.vehiculousado = vehiculousado;
	  }

   var ventavehiculos = validarVehiculoUsado();
	  if (ventavehiculos != null) {
		  if (comprobante.complemento == undefined) {
			  comprobante.complemento = new Object();
		  }
		  comprobante.complemento.vehiculousado = new Object();
		  comprobante.complemento.vehiculousado.version = "1.0";
		  comprobante.complemento.vehiculousado = vehiculousado;
	  }
	
	var pagoEnEspecie = validarPagoEnEspcie();
	if (pagoEnEspecie != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.pagoEnEspecie = pagoEnEspecie;
		comprobante.complemento.pagoEnEspecie.version = "1.0";
	}
	
	var registroFiscal = validarRegistroFiscal();
	if (registroFiscal != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.registroFiscal = registroFiscal;
		comprobante.complemento.registroFiscal.version = "1.0";
	}

  var valesDespensa = validarValesDespensa();
	if (valesDespensa != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.valesDespensa = valesDespensa;
		comprobante.complemento.valesDespensa.version = "1.0";
    valesDespensa.conceptos = new Object();
    valesDespensa.conceptos.conceptovalesdespensa = new Array();  
    valesDespensa.conceptos.conceptovalesdespensa = conceptosDespensa;
	}

  var parcialesConstruccion = validarParcialesConstruccion();
	if (parcialesConstruccion != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.parcialesConstruccion = parcialesConstruccion;
	}

 
	
	
	if (mapImpuestosTraslados.length > 0) {
		var ivaIEPS = 0;
		comprobante.impuestos.totalImpuestosTrasladados = redondearValor2(parseFloat($('input[name=totalImpuestosTrasladados]').val()));
		comprobante.impuestos.totalImpuestosTrasladados = new Number(parseFloat(comprobante.impuestos.totalImpuestosTrasladados)).toFixed(numeroDecimales);
		comprobante.impuestos.traslados = new Object();
		comprobante.impuestos.traslados.traslados = new Array();
	
	//	if (($('#ieps').val() != "") && $('#totalIEPS').val() != "" && $('#totalIEPS').val() != 0) {
		if ((tasaIEPS != "") && $('#totalIEPS').val() != "" && $('#totalIEPS').val() != 0) {
			
			var traslado = new Object();
			traslado.tasa = tasaIEPS; // ($('#ieps').val() == "") ? 0 :  parseFloat($('#ieps').val());
			traslado.importe =  redondearValor(parseFloat($('#totalIEPS').val()));
			traslado.impuesto = "IEPS"; 
			if (traslado.tasa == 0 && traslado.importe == null) {
				traslado.importe = 0;
			}
			if(traslado.importe != null &&  traslado.importe != 0) {
				comprobante.impuestos.traslados.traslados.push(traslado);
				comprobante.impuestos.totalImpuestosTrasladados = redondearValor(parseFloat(totalIVA + totalIEPS)); 
			}
		}
		traslado = new Object();
		traslado.tasa = new Number($('#iva').val()).toFixed(2);
		traslado.importe = redondearValor(totalIVA); // ivaTras + ivaIEPS);cwobj
		traslado.importe = new Number(parseFloat(traslado.importe)).toFixed(numeroDecimales);
		traslado.impuesto = "IVA"; 
		if (traslado.tasa == 0 && traslado.importe == null) {
			traslado.importe = 0;
		}
		comprobante.impuestos.traslados.traslados.push(traslado);
/*
		$.each(mapImpuestosTraslados, function(key, value) {
			if (value != undefined) {
				var traslado = new Object();
				traslado.tasa = key;
				traslado.importe = redondearValor(value);
				traslado.impuesto = "IVA";
				comprobante.impuestos.traslados.traslados.push(traslado);
			}
		});
*/
	} else {
		var ivaIEPS = 0;
                comprobante.impuestos.totalImpuestosTrasladados = redondearValor2(parseFloat($('input[name=totalImpuestosTrasladados]').val()));
                if (($('#ieps').val() != "") && $('#totalIEPS').val() != "" && $('#totalIEPS').val() != 0) {
                	comprobante.impuestos.traslados = new Object();
	                comprobante.impuestos.traslados.traslados = new Array();
                        var traslado = new Object();
                        traslado.tasa = ($('#ieps').val() == "") ? 0 :  parseFloat($('#ieps').val());
                        traslado.importe =  redondearValor(parseFloat($('#totalIEPS').val()));
                        traslado.impuesto = "IEPS";
                        if (traslado.tasa == 0 && traslado.importe == null) {
                                traslado.importe = 0;
                        }
                        if(traslado.importe != null &&  traslado.importe != 0) {
                                comprobante.impuestos.traslados.traslados.push(traslado);
                                comprobante.impuestos.totalImpuestosTrasladados = redondearValor(parseFloat(totalIVA + totalIEPS));
                        }
                }
	}
	if ($('input[name=totalIVARetenido]').val() != "" || $('input[name=totalISRRetenido]').val() != "") {
		comprobante.impuestos.retenidos = new Object();
		comprobante.impuestos.retenidos.retenciones = new Array();
		comprobante.impuestos.totalImpuestosRetenidos = 0;
		if ($('input[name=totalIVARetenido]').val() != "") {
			var retencion = new Object();
			retencion.impuesto = "IVA";
			retencion.importe = new Number(($('input[name=totalIVARetenido]').val())).toFixed(numeroDecimales);
			comprobante.impuestos.totalImpuestosRetenidos += redondearValor(retencion.importe);
			comprobante.impuestos.retenidos.retenciones.push(retencion);
		}

		if ($('input[name=totalISRRetenido]').val() != "") {
			var retencion = new Object();
			retencion.impuesto = "ISR";
			retencion.importe = new Number(($('input[name=totalISRRetenido]').val())).toFixed(numeroDecimales);
			comprobante.impuestos.totalImpuestosRetenidos += redondearValor(retencion.importe);
			comprobante.impuestos.retenidos.retenciones.push(retencion);
		}
		comprobante.impuestos.totalImpuestosRetenidos = new Number((comprobante.impuestos.totalImpuestosRetenidos)).toFixed(numeroDecimales);
	}

	if ((mapImpuestosTraslados.length == 0 && parseFloat($('#totalIEPS').val()) <= 0 )&&(comprobante.impuestos.totalImpuestosRetenidos == undefined || comprobante.impuestos.totalImpuestosRetenidos == 0)
	     	) {
		comprobante.impuestos = new Object();
	}
	
	if (firmas.length > 0) {
		comprobante.firmas = new Object();
		comprobante.firmas.numeroFirmas = firmas.length;
		comprobante.firmas.firmas = firmas;
	}
	comprobante.observaciones = $('#observaciones').val();
	if ($('#motivoDescuento').val() != "") {
		comprobante.motivoDescuento = $('#motivoDescuento').val();
	}
	comprobante.descuento = descuento;
	comprobante.total = new Number(comprobante.total).toFixed(numeroDecimales);
	comprobante.subTotal = new Number(comprobante.subTotal).toFixed(numeroDecimales);
	return JSON.stringify(comprobante, null, " ");
}

function validarFactura() {
	if (mapConceptos.length == 0) {
		alert("Debe agregar al menos un concepto.");
		return false;
	}
	
	if ($('#tipoDeComprobante').val() == "cp") {
		if ($('#observaciones').val() == "") {
			alert("Carta porte no vÃ¡lida. Debe utilizar el archivo EXCEL de Carta Portal");
		}
	}
	
	if (!$('#comprobanteForm').valid()) {
		return false;
	}
	return true;
}

function seleccionarCalculoIEPS() {
	switch ($('input[name=calculoIEPS]:checked').val()) {
	case "0":
		$('#divIEPS span:eq(1)').hide(0);
		$('#divIEPS span:eq(0)').show(0);
		break;
	case "1":
		$('#divIEPS span:eq(0)').hide(0);
		$('#divIEPS span:eq(1)').show(0);
		break;
	}
}

function dateToYMD(date) {
	var d = date.getDate();
	var m = date.getMonth() + 1;
	var y = date.getFullYear();
	return '' + (d <= 9 ? '0' + d : d) + '-' + (m <= 9 ? '0' + m : m) + '-' + y;
}

function activarDetalle(modulo) {
	$('.div' + modulo + ' input[type=text]').val('');
	$('.div' + modulo).toggle(0);
        if (modulo == "IEPS" && $('#ish').is(':checked'))
	$('.div' + modulo).hide(0);
}

function iniciaFactura() {
	seleccionarCalculoIEPS();
}



function graficarConceptos() {
	var row = '';
	var fields = new Array("cantidad", "unidad", "clave", "descripcion",
			"valorUnitario", "descuento", "importe", "iva", "ieps");
	var input = '<td>:value</td>';
	var subtotal = 0, totalDescuento = 0;
	var importe = 0, iva = 0;
	totalDescuento = descuento = 0;
	if (mapConceptos.length == 0) {
		totalIVA = 0;
		totalIEPS = 0;
		mapImpuestosTraslados = new Array();
		$('#tablaConceptos tbody').html('<tr><td colspan="9" class="noItemns">No ha seleccionado ning\u00FAn concepto.</td></tr>');
		$('input[name=total]').val("0.00");
		$('#totalIEPS').val('0.00');
		$('input[name=totalDescuento]').val("0.00");
		$('input[name=subTotal]').val("0.00");
		$('input[name=totalIVA]').val("0.00");
		$('input[name=totalIEPS]').val("0.00");

		$('input[name=totalImpuestosTrasladados]').val("0.00");

		$('select[name=tipoImpuesto].impLoc1').val('Traslado');
                $('input[name=impLoc].impLoc1').val('');
                $('input[name=tasade].impLoc1').val('0.0');
                $('input[name=tasade].impLoc1').trigger('change');

		return;
	}

	subtotal = total = totalDescuento = totalISR = 0.0;
	$.each(mapConceptos, function(key, value) {
		row += '<tr>';
		descuento = 0;
		if (value['descuento'] != undefined && value['descuento'] != '') {
			descuento = redondearValor(/*value['cantidad'] **/ value['descuento']);
		}

		//importe = redondearValor((value['cantidad'] * value['valorUnitario']));
		importe = parseFloat(value['importe']);
		//ieps = redondearValor((value['cantidad'] * value['valorUnitario']));
		// if (value['ivaExento'] != 'on') {
		// iva = redondearValor(importe * value['iva'] * 0.01);
		// }
		totalDescuento += descuento;
		subtotal += importe;
		// totalIVA += iva;
		/* Para cada elemento */

		$.each(fields,
				function(key1, value1) {
					input = '<td>:value</td>';
					if (value1 == "importe") {
						value['importe'] = importe
								+ (value['ivaExcento'] != 'on' ? 0 : iva);
					} else if (value1 == "descuento") {
						input = "<td class='divDescuento'>:value</td>";
					} else if (value1 == "clave") {
						input = "<td class='divClave "
								+ ($("input[name=mClave]").is(':checked') ? ""
										: "hidden") + "'>:value</td>";
					} else if (value1 == "ieps") {
						input = "<td class='divIEPS "
								+ ($("input[name=mIEPS]").is(':checked') ? ""
										: "hidden") + "'>:value</td>";
					} else if (value1 == "iva") {
						if (value['ivaExento'] == 'on') {
							input = '<td>Exento</td>';
						}
					}
					row += input.replace(':value', value[value1]);
				});
		if (descuento < 0) {
			descuento = 0;
		}
		row += '<td><a class="eliminarConcepto" onClick="eliminarData(' + key
				+ ')" id="concepto-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td>';
		row += '</tr>';
		$('#tablaConceptos tbody').html(row);
	});
	/* Calculo de impuestos */
	var montoDescuento = ($('#montoDescuento').val() == "" || $('#montoDescuento').val() == undefined ? 0 : parseFloat($('#montoDescuento').val()));
	// descuento = totalDescuento + montoDescuento;
	
	subtotal = subtotal; + totalDescuento;
	subtotal -= montoDescuento;
	
	 descuento = totalDescuento + montoDescuento;

	totalIVAsinIEPS = totalIVA;
	if (($('#ivaIeps').val() != "false" && $('#ivaIeps').val() != "") && totalIVA != 0 && totalIEPS != 0) {
		totalIVA = (subtotal - descuento + totalIEPS) * 0.16;	
	}


	var total = parseFloat(subtotal + totalIEPS) - parseFloat(descuento) + parseFloat(totalIVA);

	if ($('input[name=totalIVARetenido]').val() != "") {
		total -= parseFloat($('input[name=totalIVARetenido]').val());
	}
	if ($('input[name=totalISRRetenido]').val() != "") {
		total -= parseFloat($('input[name=totalISRRetenido]').val());
	}
	total = redondearValor(total) + montoDescuento;

	var impuestosLocales = validarImpuestosLocales();

  if (impuestosLocales != undefined) {
		total = redondearValor(total - impuestosLocales.totalDeRetenciones);
		total = redondearValor(total + impuestosLocales.totalDeTraslados);
	}


	$('input[name=total]').val(total);
	if (impuestosLocales != undefined && impuestosLocales.totalDeRetenciones != 0) {
		$('.totalDeRetenciones').show(0);
		$('input[name=totalDeRetenciones]').val(redondearValor2(impuestosLocales.totalDeRetenciones));
	} else {
		$('input[name=totalDeRetenciones]').hide(0);
	}
	if (impuestosLocales != undefined && impuestosLocales.totalDeTraslados != 0) {
		$('.totalDeTraslados').show(0);
		$('input[name=totalDeTraslados]').val(redondearValor2(impuestosLocales.totalDeTraslados));
	} else {
		$('.totalDeTraslados').hide(0);
	}
	$('input[name=totalDescuento]').val(descuento <= 0 ? 0 : (redondearValor(descuento)));
	$('input[name=subTotal]').val(redondearValor(subtotal + montoDescuento));
	
	
	$('input[name=totalIEPS]').val(redondearValor(totalIEPS));
	$('input[name=totalIVA]').val(redondearValor(totalIVA));
	$('input[name=totalImpuestosTrasladados]').val(redondearValor(totalIVA));
	// totalIVA = totalIVAsinIEPS;
}

function getFolio() {
	var serie = $('#serie').val();
	$.get('/CFDI/rest/comprobante/folio/' + serie, function(response) {
		$('#folio').val(response);
	});
}

function eliminarFirma(index) {
  delete firmas[index];
  mostrarFirmas();
}

function mostrarFirmas() {
	$('#tFirmas').html('');
	var fila;
	$.each(firmas, function(v,k) {
		if (k != undefined) {
			fila = $("<tr></tr>");
		    fila.append("<td>"+ k.nombre +"</td>");
		    fila.append("<td>"+ k.puesto +"</td>");
		    fila.append("<td>"+ k.extra +"</td>");
		    fila.append("<td><a onClick='eliminarFirma("+ v +")'><i class='icon icon-remove'> </i></a></td>");
			$('#tFirmas').append(fila);
		}
	});
}

Array.prototype.remove = function(from, to) {
  var rest = this.slice((to || from) + 1 || this.length);
  this.length = from < 0 ? this.length + from : from;
  return this.push.apply(this, rest);
};

$(document).ready(function() {



$('#btnLineItem').click(function() {


var lineItem = new Object();
lineItem.type = "SimpleInvoiceLineItemType";
lineItem.number = lineItems.length + 1;
lineItem.tradeItemIdentification = new Object();
lineItem.tradeItemIdentification.gtin = $('#gtinLine').val();

var alternateTradeItemIdentification = new Object();
alternateTradeItemIdentification.type  = $('#alternateTradeItemIdentificationType').val();
alternateTradeItemIdentification.value = $('#alternateTradeItemIdentification').val();

lineItem.alternateTradeItemIdentification = new Array();
lineItem.alternateTradeItemIdentification.push(alternateTradeItemIdentification);

lineItem.tradeItemDescriptionInformation = new Object();
lineItem.tradeItemDescriptionInformation.language = "ES";
lineItem.tradeItemDescriptionInformation.longText = $('#tradeItemDescriptionInformation').val();
lineItem.invoicedQuantity = new Object();
lineItem.invoicedQuantity.unitOfMeasure = $('#invoicedQuantityService').val();
lineItem.invoicedQuantity.value = $('#invoicedQuantityValue').val();
lineItem.grossPrice = new Object();
lineItem.grossPrice.amount = $('#grossPrice').val();
lineItem.netPrice = new Object();
lineItem.netPrice.amount = $('#netPrice').val();

lineItem.totalLineAmount = new Object();
lineItem.totalLineAmount.grossAmount = new Object();
lineItem.totalLineAmount.grossAmount.amount = $('#grossAmount').val();
lineItem.totalLineAmount.netAmount = new Object();
lineItem.totalLineAmount.netAmount.amount = $('#netAmount').val();

lineItems.push(lineItem);

alert("Concepto Agregado");

$('#gtin').val('');
$('#alternateTradeItemIdentificationType').val('');
$('#alternateTradeItemIdentification').val('');
$('#tradeItemDescriptionInformation').val('');
$('#invoicedQuantityService').val('');
$('#invoicedQuantityValue').val('');
$('#grossPrice').val('');
$('#netPrice').val('');
$('#grossAmount').val('');
$('#netAmount').val('');

});


/*
if ($('input[name=rfc].emisor').val() == "ISJ090116BG8") {
//alert("Activar detallista");
//
//

  $('#collapseDetallista').html("<h1>&nbsp;&nbsp;&nbsp; Complemento detallista activando</h1>");

}
*/


$('input[name=mIEPS]').click(function() {
 if($('#ish').is(':checked')) {
   alert('Desactive el ISH');
   return false;
 }
});

$('#ish').click(function() {
 if($('input[name=mIEPS]').is(':checked')) {
   alert('Desactive el IEPS');
   return false;
 }
});


$('#ivaIncluido').click(function() {
 if($('#ivaExento').is(':checked')) {
   alert('Desactive el iva incluido');
   return false;
 }
});

$('#ivaExento').click(function() {
 if($('#ivaIncluido').is(':checked')) {
   alert('Desactive el iva incluido');
   return false;
 }
});



					numeroDecimales = ($('#numeroDecimales').val() == null || $('#numeroDecimales').val() == "") ?
							2 : $('#numeroDecimales').val();
					
					$('#btnAddFirma').click(function(){
					  var firma = new Object();
					  firma.nombre = $('#nombreFirma').val();
					  firma.puesto = $('#puestoFirma').val();
					  firma.extra  = $('#extraFirma').val();
					  firmas.push(firma);
					  mostrarFirmas();
					});
					
					$('input[name=tasade]').change(function() {  
					  var valor = parseFloat($(this).val());
					  var result = (valor * (parseFloat($('input[name=subTotal]').val()) - parseFloat($('input[name=totalDescuento]').val()))) / 100
					  $('input[name=importe].impLoc' + $(this).attr('module')).val(redondearValor(result))
					  $('input[name=importe].impLoc' + $(this).attr('module')).trigger( "change" );
					})


					$('#orderDate').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

					$('#deliveryDate').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#ReferenceDate').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#ProductionDate').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

					$('#fechaInstNotarial').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

					
					$('#fechaAprobacion').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaExpOper').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaExpDocAduanero').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaExpDocAduaneroVentaVehiculos').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaExpDocAduaneroParteVentaVehiculos').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaValesDespensa').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaExpDocAduaneroCuentaTerceros').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaExpDocAduaneroParteCuentaTerceros').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

					$('#btnTipoComprobante').change(function() {
						top.location.href = $('#btnTipoComprobante').val();
					});

					if ($('input[name=mIEPS]:checked').val() == undefined
							|| $('#confiIEPS').val() == "false") {
						$('.divIEPS').hide(0);
					} else {
						if (!$('#ish').is(':checked'))
						$('.divIEPS').show(0);
					}

					if ($('#confiClave').val() == "false") {
						$('.divClave').hide(0);
					} else {
						$('.divClave').show(0);
					}
/*
					if ($('#confiDescuentos').val() == "false") {
						$('.divDescuento').hide(0);
						$('.divDescuento').css('visibility', 'hidden');
					} else {
						$('.divDescuento').show(0);
						$('.divDescuento').css('visibility', 'visible');
					}
*/
					$('input[name=importe]').change(
							function() {
								if ($(this).val() == "") {
									$('input[name=importe]:first').parent()
											.find('input').val('');
								}
								graficarConceptos();
							});
					$('input[name=totalIVARetenido]').change(function() {
						graficarConceptos();
					});
					
					$('input[name=montoDescuento]').change(function() {
						totalIVA += ivaDescuentoRestado;
						if ($('#montoDescuento').val() != "" && totalIVA > 0) {
							ivaDescuentoRestado = (parseFloat($('#montoDescuento').val()) * 0.16); 
							totalIVA -= ivaDescuentoRestado;
						}
						graficarConceptos();
					});

					$('#ieps').parent().append(' <label>Cantidad</label> <input type="radio" value="1" name="tipoIEPS"> <label>Precio</label> <input type="radio" checked value="0" name="tipoIEPS">')

					$('input[name=totalISRRetenido]').change(function() {
						graficarConceptos();
						// var ivaRet =
						// parseFloat($('input[name=totalISRRetenido]').val());
						// var total = parseFloat($('input[name=total]').val());
						// $('input[name=total]').val(total - ivaRet);
					});

					/* Seleccionar Folio */
					getFolio();
					$('#serie').change(getFolio);

					$('#comprobanteForm').submit(function() {
						return false;
					});

					$('#descuento').change(function() {
						if (parseFloat($(this).val()) > parseFloat($('#valorUnitario').val())) {
							alert("El descuento no puede ser mayor al precio");
							$(this).focus();
						}
					});

					$('#formVistaPrevia, #formGenerarComprobante').unbind('submit').bind('submit',  //submit(
							function() {
								if (!validarFactura()) {
									return false;
								}
								$('.strComprobante').val(comprobanteToJSON());
                                                                if ($(this).attr('id') == "formGenerarComprobante")
								$('#generarComprobante').attr('disabled', 'disabled');
							});

					// $('#fecha').val(dateToYMD(new Date()));
					$('#fecha').attr('readonly', 'readonly');

					/** ************ */
					$.fn.serializeObject = function() {
						var o = {};
						var a = this.serializeArray();
						$.each(a, function() {
							if (o[this.name]) {
								if (!o[this.name].push) {
									o[this.name] = [ o[this.name] ];
								}
								o[this.name].push(this.value || '');
							} else {
								o[this.name] = this.value || '';
							}
						});
						return o;
					};
					/** ************ */

					$('.mostrarDetalle').click(function() {
						activarDetalle($(this).attr('modulo'));
					});

					$('input[name=calculoIEPS]').click(function() {
						seleccionarCalculoIEPS();
					});

					$('#btnAgregarConcepto').click(function() {
						agregarConcepto();
						return false;
					});

					iniciaFactura();

					var map = {};
					var objects = [];
					/** ******************************************** */
					$('#rfc').autocomplete({
						source: function( request, response ) {
							var term = request.term;
							$.ajax({
								url: '/CFDI/rest/cliente/listarRFC/' + term,
								success: function( data ) {
									response( $.map( data, function( item ) {
										return {
											id   : item.id,
											label: item.name,
											value: item.name
										};
									}));
								}
							});
						},
						minLength: 1,
						select: function( event, ui ) {
									response = $.ajax({
										url : '/CFDI/rest/cliente/find/' + ui.item.id,
										async : false
									});
									cliente = $.parseJSON(response.responseText);
									$("#razonSocial").val(cliente.razonSocial);
									$("#rfc").val(cliente.rfc);
									$("#calle").val(cliente.calle);
									$("#noInterior").val(cliente.numeroInterior);
									$("#noExterior").val(cliente.numeroExterior);
									$("#colonia").val(cliente.colonia);
									$("#codigoPostal").val(cliente.codigoPostal);
									$("#email").val(cliente.email);
									$("#municipio").val(cliente.municipio);
									$("#pais").val(cliente.pais);
									$("#estado").val(cliente.estado);
                  $("#referencia").val(cliente.referencia);
								}
							});
					$('#razonSocial').change(function() {
						if ($('#razonSocial').val().indexOf('<->') > 0) {
							$('#razonSocial').val($('#razonSocial').val().substring(0, $('#razonSocial').val().indexOf('<->')).trim());
						}
					});
					
					// $('#razonSocial').val($('#razonSocial').val().substring(0, $('#razonSocial').val().indexOf('-')).trim())
					$('#razonSocial').autocomplete({
						source: function( request, response ) {
							var term = request.term;
							$.ajax({
								url: '/CFDI/rest/cliente/listar/' + term,
								success: function( data ) {
									response( $.map( data, function( item ) {
										return {
											id   : item.id,
											label: item.name,
											value: item.name.substring(0, item.name.indexOf(' <->')).trim()
										};
									}));
								}
							});
						},
						minLength: 1,
						select: function( event, ui ) {
							response = $.ajax({
								url : '/CFDI/rest/cliente/find/' + ui.item.id,
								async : false
							});
							cliente = $.parseJSON(response.responseText);
							$("#rfc").val(cliente.rfc);
							$("#calle").val(cliente.calle);
							$("#noInterior").val(cliente.numeroInterior);
							$("#noExterior").val(cliente.numeroExterior);
							$("#colonia").val(cliente.colonia);
							$("#localidad").val(cliente.localidad);
							$("#codigoPostal").val(cliente.codigoPostal);
							$("#email").val(cliente.email);
							$("#municipio").val(cliente.municipio);
							$("#pais").val(cliente.pais);
							$("#estado").val(cliente.estado);
							$('#razonSocial').val(cliente.razonSocial);
              $("#referencia").val(cliente.referencia);
							// $('#razonSocial').val($('#razonSocial').val().substring(0, $('#razonSocial').val().indexOf('-')).trim());
							//return item;
						}
					});

					$('#clave')
							.autocomplete(
									{
										source : function(request, response) {
										var term = request.term;
											$.ajax({
														url : '/CFDI/rest/productoServicio/findByClave/'
																+  term,
														success: function( data ) {
															response( $.map( data, function( item ) {
																return {
																	id   : item.id,
																	label: item.clave,
																	value: item.clave
																};
															}));
														}
													});
									},
									minLength: 2,				
									select: function( event, ui ) {
							
										response = $
										.ajax({
											url : '/CFDI/rest/productoServicio/find/'
													+  ui.item.id,
											async : false
										});
										productoServicio = $
												.parseJSON(response.responseText);
										if ($("#valorUnitario").val() == "")
										$("#valorUnitario").val(productoServicio.precioUnitario);
										$("#concepto").val(productoServicio.nombre);
										$("#iva").val(productoServicio.tasaIva);
										// $("#descuento").val("");
										// if($("#ieps").val() == ) $("#ieps").val("");
										if ($("#cantidad").val() == "") $("#cantidad").val("1");
										// $("#unidad").val("1");
										if (productoServicio.ivaExento == true) {
											$("#ivaExento").prop("checked", true);
											$("#iva").val(0);
											$("#iva").prop("disabled", true);
										} else {
											$("#ivaExento").prop("checked", false);
											$("#iva").prop("disabled", false);
										}
										
									},
									open: function() {
										$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
									},
									close: function() {
										$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
									}
								});
					
/*					
					$('#unidad').typeahead({

					    source: function (query, process) {
					    	response = $
							.ajax({
								url :  '/CFDI/rest/unidad/ajax/all/a',
								async : false
							});
					    	data = $.parseJSON(response.responseText);
					    	process(data);
					    }

					});
					
*/					
					
					$('#concepto').autocomplete({
						source: function( request, response ) {
							var term = request.term;
							$.ajax({
								url: '/CFDI/rest/productoServicio/listar/' + term,
								// dataType: "jsonp",
								success: function( data ) {
									response( $.map( data, function( item ) {
										return {
											id   : item.id,
											label: item.name,
											value: item.name
										};
									}));
								}
							});
						},
						minLength: 2,
						select: function( event, ui ) {
							
							response = $
							.ajax({
								url : '/CFDI/rest/productoServicio/find/'
										+  ui.item.id,
								async : false
							});
							productoServicio = $
									.parseJSON(response.responseText);
							if ($("#valorUnitario").val() == "")
							$("#valorUnitario").val(productoServicio.precioUnitario);
							$("#clave").val(productoServicio.clave);
							$("#iva").val(productoServicio.tasaIva);
							// $("#descuento").val("");
							// if($("#ieps").val() == ) $("#ieps").val("");
							if ($("#cantidad").val() == "") $("#cantidad").val("1");
							// $("#unidad").val("1");
							if (productoServicio.ivaExento == true) {
								$("#ivaExento").prop("checked", true);
								$("#iva").val(0);
								$("#iva").prop("disabled", true);
							} else {
								$("#ivaExento").prop("checked", false);
								$("#iva").prop("disabled", false);
							}
							
						},
						open: function() {
							$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
						},
						close: function() {
							$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
						}
					});
					
/*
					$('#concepto')
							.typeahead(
									{
										source : function(query, process) {
											map = {};
											objects = [];
											response = $
													.ajax({
														url : '/CFDI/rest/productoServicio/listar/' + query,
														async : false
													});
											data = $
													.parseJSON(response.responseText);
											// var data =
											// [{"id":1,"label":"machin"},{"id":2,"label":"truc"}]
											$.each(data, function(i, object) {
												map[object.name] = object;
												objects.push(object.name);
											});
											process(objects);
										},
										updater : function(item) {
											response = $
													.ajax({
														url : '/CFDI/rest/productoServicio/find/'
																+ map[item].id,
														async : false
													});
											productoServicio = $
													.parseJSON(response.responseText);
											$("#valorUnitario")
													.val(
															productoServicio.precioUnitario);
											$("#clave").val(
													productoServicio.clave);
											// $("#iva").val(productoServicio.tasaIva);
											$("#descuento").val("");
											$("#ieps").val("");
											$("#cantidad").val("1");
											// $("#unidad").val("1");
											if (productoServicio.ivaExento == true) {
												$("#ivaExento").prop("checked",
														true);
												$("#iva").val(0);
												$("#iva")
														.prop("disabled", true);
											} else {
												$("#ivaExento").prop("checked",
														false);
												$("#iva").prop("disabled",
														false);
											}
											return item;
										}
									});
*/
					$('#ivaExento').change(function() {
						if ($('#ivaExento').prop('checked') === true) {
							$("#iva").prop("disabled", true);
							$("#iva").prop("required", false);
						} else {
							$("#iva").prop("disabled", false);
							$("#iva").prop("required", true);
						}
					});

					$.validator.addMethod("valueNotEquals", function(value,
							element, arg) {
						return arg != value;
					}, "Debe seleccionar una opcion.");

					$.validator.addMethod("regex", function(value, element,
							regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					}, "Ingrese un RFC valido.");

					$.validator.addMethod("numero", function(value, element,
							regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					}, "Ingrese un n\u00famero v\u00e1lido.");

					$('#rfc').change(function() {
						$(this).val($(this).val().toUpperCase());
						$(this).val($(this).val().replace(' ', ''));
						$(this).val($(this).val().replace('-', ''));
					});
					
					$.validator.addMethod("emailMultiple", function(value,
							element, regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					}, "Email no v\u00e1lido.");
					
					$.validator.addMethod("regexCurp", function(value, element,
			    regexp) {
    		    var re = new RegExp(regexp);
		      return this.optional(element) || re.test(value);
	        }, "Ingrese un CURP valido.");

					$.validator.addMethod("alfanumerico", 
							
							function(value,
							element, regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					}, "Solo caracteres alfanumericos.");

          $.validator.addMethod("numeroDec", function(value, element,	regexp) {
        		var re = new RegExp(regexp);
        		return this.optional(element) || re.test(value);
          	}, "Ingrese un n\u00famero Decimal v\u00e1lido.");

          $.validator.addMethod("anio", function(value, element,	regexp) {
        		var re = new RegExp(regexp);
        		return this.optional(element) || re.test(value);
          	}, "Ingrese un año v\u00e1lido.");		

          $.validator.addMethod("hora", function(value, element,	regexp) {
        		var re = new RegExp(regexp);
        		return this.optional(element) || re.test(value);
          	}, "Ingrese una hora v\u00e1lida.");	

          $.validator.addMethod("minutos", function(value, element,	regexp) {
        		var re = new RegExp(regexp);
        		return this.optional(element) || re.test(value);
          	}, "Ingrese una dato v\u00e1lido.");									

          $('input[name=precioUnitario]').change(function() {  
					  $('input[name=importeCombustible]').val(redondearValor2($('input[name=volumen]').val()*$('input[name=precioUnitario]').val()));
					});

					$('#comprobanteForm')
							.validate(
									{
										rules : {
											rfc : {
												required : true,
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
											},
											clave : {
												alfanumerico : "^([0-9a-zA-Z._-])+$"
											},
											lugarDeExpedicion : {
												required : true
											},
											razonSocial : {
												required : true
											},
											metodoPago : {
												required : true
											},
											moneda : {
												required : true
											},
											tipoCambio : {
												required : true,
												// tipoCambio : true,
												numero : "^[0-9]+(\.([0-9]{1,4})?)?$"
											},
											pais : {
												required : true,
												valueNotEquals : "default"
											},
											estado : {
												required : true,
												valueNotEquals : "default"
											},
											codigoPostal : {
												// number : true,
												minlength : 5,
												maxlength : 7
											},
											email : {
												required : true,
												// emailMultiple : "^([\w+-.%]+@[\w-.]+\.[A-Za-z]{2,4};?( )?)+$"
											},
											cantidad : {
											  //	required : true,
												number : true
											},
											unidad : {
											   //	required : true
											},
											valorUnitario : {
												//required : true,
												number : true,
												//numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
											},
											concepto : {
												// required : true
											},
											iva : {
												number : true,
												numero : "^[0-9]+(\.([0-9]{1,4})?)?$"
											},
											descuento : {
												number : true,
												numero : "^[0-9]+(\.([0-9]{1,4})?)?$"
											},
											ieps : {
												number : true,
												numero : "^[0-9]+(\.([0-9]{1,4})?)?$"
											},
                      rfcEnajCombustible : {
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
											},
                      volumen : {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      precioUnitario: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      importe: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      tasaImpuesto: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      importeImpuesto: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      montoAdquisicion: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      montoEnajenacion: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      modelo: {
						            required : false,
						            anio : "^([0-9]{4})?$"
					            },
                      valor: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      cantidadParteVentaVehiculos: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      valorUnitarioParteVentaVehiculos: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      importeParteVentaVehiculos: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      rfcValesDespensa : {
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
											},
                      curpValesDespensa:{
    						regexCurp : "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]?"
		            			},
                      importeValesDespensa: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      totalValesDespensa: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      horaValesDespensa: {
						            required : false,
						            hora : "^(2[0-3]|[01]?[0-9])$"
					            },
                      minutosValesDespensa: {
						            required : false,
						            minutos : "^([0-5]?[0-9])$"
					            },
                      segundosValesDespensa: {
						            required : false,
						            minutos : "^([0-5]?[0-9])$"
					            },
                      rfcCuentaTerceros : {
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
											},
                      cantidadCuentaTerceros: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
											codigoPostalCuentaTerceros : {
												// number : true,
												minlength : 5,
												maxlength : 5
											},
                      valorUnitarioParteCuentaTerceros: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      importeParteCuentaTerceros: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      importeRetencionesCuentaTerceros: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      tasaTrasladosCuentaTerceros: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      importeTrasladosCuentaTerceros: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      codigoPostalConstruccion : {
												// number : true,
												minlength : 5,
												maxlength : 5
											},
										}
									});

					$('#moneda').change(
							function() {
								$('#tipoCambio').val(
										$('#moneda :selected').attr(
												'tipoCambio'));
							});


$('input[name=total]').dblclick(function () {
 $(this).removeAttr('readonly');
})

$('input[name=total]').change(function () {
	$('input[name=total]').attr('readonly', 'readonly');
})


$('input[name=subTotal]').dblclick(function () {
 $(this).removeAttr('readonly');
})

$('input[name=subTotal]').change(function () {
	$('input[name=subTotal]').attr('readonly', 'readonly');
})

$('#folio').change(function () {
	if (!$.isNumeric($('#folio').val())) {
		alert("El folio debe ser numero");
		$('#folio').val(getFolio());
		$('#folio').focus();		
	}
})




$('input[name=totalIVA]').dblclick(function () {
 $(this).removeAttr('readonly');
})

$('input[name=totalIVA]').change(function () {
	$('input[name=totalIVA]').attr('readonly', 'readonly');
	totalIVA = $('input[name=totalIVA]').val(); 
	$('input[name=totalImpuestosTrasladados]').val(totalIVA + totalIEPS);
})



$('#adquirienteSIoNo').change(function() {

 if ($('#adquirienteSIoNo :selected').val() == "No") {
	$('#addAquiriente').hide();
	$('.porcentajeAdquriente').hide();
 } else {
	$('#addAquiriente').show();
	$('.porcentajeAdquriente').show();
 }

})


$('#adquirienteSIoNoE').change(function() {

 if ($('#adquirienteSIoNoE :selected').val() == "No") {
	$('#addEnajenante').hide();
	$('.porcentajeEnajenante').hide();
 } else {
	$('#addEnajenante').show();
	$('.porcentajeEnajenante').show();
 }

})

$('#addAquiriente').click(function(){


	var datosAdquirienteCopSC = $('.adquiriente').serializeObject();
	adquirientes.push(datosAdquirienteCopSC);
	alert("Adquiriente Agregado.");
});

$('#addEnajenante').click(function(){


	var datosEnajenanteCopSC = $('.enajenante').serializeObject();
	datosEnajenanteCopSC.porcentaje =	$(".enajetante").val()
	enajenantes.push(datosEnajenanteCopSC);
	alert("Enajenante Agregado.");
});

// $('#adquirienteSIoNo :selected').val()

	$('#addAquiriente').hide();
	$('.porcentajeAdquriente').hide();
	$('#addEnajenante').hide();
	$('.porcentajeEnajenante').hide();

	$('#btnConceptoDespensa').click(function() {
    if (validaConceptoValesDespensa() == true){
		  var conceptoDespensa = $('.conceptoDespensa').serializeObject();
      if ($('input[name=numSeguridadSocial]').val() == "") {
        conceptoDespensa.numSeguridadSocial = null;
      }    
      else{
        conceptoDespensa.numSeguridadSocial = $('input[name=numSeguridadSocial]').val();
      }
      var fechaDespensa = $('input[name=fechaValesDespensa]').val() + 'T' + $('input[name=horaValesDespensa]').val() + ':' 
+ $('input[name=minutosValesDespensa]').val() + ':' + $('input[name=segundosValesDespensa]').val();
      conceptoDespensa.fechaValesDespensa = fechaDespensa;
		  conceptosDespensa.push(conceptoDespensa);
		  graficarConceptoDespensa();
      $('input[name=identificadorValesDespensa]').val('');
      $('input[name=fechaValesDespensa]').val('');
      $('input[name=horaValesDespensa]').val('');
      $('input[name=minutosValesDespensa]').val('');
      $('input[name=segundosValesDespensa]').val('');
      $('input[name=rfcValesDespensa]').val('');
      $('input[name=curpValesDespensa]').val('');
      $('input[name=nombreValesDespensa]').val('');
      $('input[name=numSeguridadSocial]').val('');
      $('input[name=importeValesDespensa]').val('');
    }
	})

$('#btnConceptoConsumoCombustibles').click(function() {
  if (validaConceptoConsumoCombustibles() == true){
		var conceptoConsumoCombustibles = $('.conceptoConsumoCombustibles').serializeObject();
		conceptosConsumoCombustibles.push(conceptoConsumoCombustibles);
		graficarConceptoConsumoCombustibles();
    $('input[name=identificador]').val('');
    $('input[name=fechaExpOper]').val('');
    $('input[name=rfcEnajCombustible]').val('');
    $('input[name=claveEstacion]').val('');
    $('input[name=volumen]').val('');
    $('input[name=nombreCombustible]').val('');
    $('input[name=folioOperacion]').val('');
    $('input[name=precioUnitario]').val('');
    $('input[name=importeCombustible]').val('');

	}
})

$('#btnDeterminadosConsumoCombustibles').click(function() {
  if (validaDeterminadosConsumoCombustibles() == true){
		var determinadoConsumoCombustibles = $('.determinadoConsumoCombustibles').serializeObject();
		determinadosConsumoCombustibles.push(determinadoConsumoCombustibles);
		graficarDeterminadosConsumoCombustibles();
    $('input[name=tipoImpuesto]').val('');
    $('input[name=tasaImpuesto]').val('');
    $('input[name=importeImpuesto]').val('');

	}
})


$('#addConcepto').click(function(){
  if (determinadosConsumoCombustibles.length > 0){
	      var conceptoConsumoCombustibles = $('.conceptoConsumoCombustibles').serializeObject();
        conceptoConsumoCombustibles.fechaExpOper = $('input[name=fechaExpOper]').val() + 'T00:00:00';
        conceptoConsumoCombustibles.determinados = new Object();
        conceptoConsumoCombustibles.determinados.determinado = determinadosConsumoCombustibles;
	      conceptosConsumoCombustibles.push(conceptoConsumoCombustibles);
 	      alert("Concepto Agregado.");
        subtotalCombustibles = redondearValor2(eval(subtotalCombustibles) + eval($('input[name=importeCombustible]').val()));
        totalCombustibles = eval(totalImportes) + eval(subtotalCombustibles);
        $('input[name=subTotalCombustibles]').val(subtotalCombustibles);
        $('input[name=totalCombustibles]').val(totalCombustibles);
        $('input[name=identificador]').val('');
        $('input[name=fechaExpOper]').val('');
        $('input[name=rfcEnajCombustible]').val('');
        $('input[name=claveEstacion]').val('');
        $('input[name=volumen]').val('');
        $('input[name=nombreCombustible]').val('');
        $('input[name=folioOperacion]').val('');
        $('input[name=precioUnitario]').val('');
        $('input[name=importeCombustible]').val('');
        determinadosConsumoCombustibles = new Array();
  }
  else{
    alert("Debe agregar los Impuestos Determinados antes de agregar el Concepto");
  }
})


$('#addDeterminado').click(function(){
  if (validaConceptoConsumoCombustibles() == true){
    if (validaDeterminadosConsumoCombustibles() == true){
	    var determinadoConsumoCombustibles = $('.determinadoConsumoCombustibles').serializeObject();
	    determinadosConsumoCombustibles.push(determinadoConsumoCombustibles);
	    alert("Impuesto Determinado Agregado.");
      totalImportes = redondearValor2(eval(totalImportes) + eval(determinadoConsumoCombustibles.importeImpuesto));
      $('input[name=tipoImpuesto]').val('');
      $('input[name=tasaImpuesto]').val('');
      $('input[name=importeImpuesto]').val('');
    }
  }
  else{
    alert("Debe agregar antes la información sobre el Concepto de Consumo de Combustibles");
  }
})

$('#addParteVentaVehiculos').click(function(){
  if (validaParteVentaVehiculos() == true){
      var ventaVehiculos = $('.ventaVehiculos').serializeObject();
      ventaVehiculos.partes = new Object();
	    var parte = new Object();
      parte.cantidad = $('#cantidadParteVentaVehiculos').val();
      if ($('input[name=unidadParteVentaVehiculos]').val() == "") {
        parte.unidad = null;
      }    
      else{
        parte.unidad = $('#unidadParteVentaVehiculos').val();
      }
      if ($('input[name=noIdentificacionParteVentaVehiculos]').val() == "") {
        parte.noIdentificacion = null;
      }    
      else{
        parte.noIdentificacion = $('#noIdentificacionParteVentaVehiculos').val();
      }
      parte.descripcion = $('#descripcionParteVentaVehiculos').val();
      if ($('input[name=valorUnitarioParteVentaVehiculos]').val() == "") {
        parte.valorUnitario = null;
      }    
      else{
        parte.valorUnitario = $('#valorUnitarioParteVentaVehiculos').val();
      }
      if ($('input[name=importeParteVentaVehiculos]').val() == "") {
        parte.importe = null;
      }    
      else{
        parte.importe = $('#importeParteVentaVehiculos').val();
      }
      parte.infoAduana = infoAduanerasParteVentaVehiculos;

	    partes.push(parte);
      ventaVehiculos.parte = partes;
	    alert("Información de Partes Agregada.");
      graficarPartesVentaVehiculos();
      $('input[name=cantidadParteVentaVehiculos]').val('');
      $('input[name=unidadParteVentaVehiculos]').val('');
      $('input[name=noIdentificacionParteVentaVehiculos]').val('');
      $('input[name=descripcionParteVentaVehiculos]').val('');
      $('input[name=valorUnitarioParteVentaVehiculos]').val('');
      $('input[name=importeParteVentaVehiculos]').val('');

  }
})

$('#addInfoAduaneraVentaVehiculos').click(function(){
  if (validaInfoAduaneraVentaVehiculos() == true){
      var ventaVehiculos = $('.ventaVehiculos').serializeObject();
      ventaVehiculos.infoAduanerasVentaVehiculos = new Object();
	    var infoAduanera = new Object();
      infoAduanera.numero = $('#numeroVentaVehiculos').val();
      infoAduanera.fechaExpDocAduanero = $('#fechaExpDocAduaneroVentaVehiculos').val();
      if ($('input[name=aduanaVentaVehiculos]').val() == "") {
        infoAduanera.aduana = null;
      }    
      else{
        infoAduanera.aduana = $('#aduanaVentaVehiculos').val();
      }
	    infoAduanerasVentaVehiculos.push(infoAduanera);
      ventaVehiculos.infoAduanera = infoAduanerasVentaVehiculos;
	    alert("Información Aduanera Agregada.");
      graficarInformacionAduaneraVentaVehiculos();
      $('input[name=numeroVentaVehiculos]').val('');
      $('input[name=fechaExpDocAduaneroVentaVehiculos]').val('');
      $('input[name=aduanaVentaVehiculos]').val('');

  }
})

$('#addInfoAduaneraParteVentaVehiculos').click(function(){
  if (validaInfoAduaneraParteVentaVehiculos() == true){
	    var infoAduanera = new Object();
      infoAduanera.numero = $('#numeroParteVentaVehiculos').val();
      infoAduanera.fechaExpDocAduanero = $('#fechaExpDocAduaneroParteVentaVehiculos').val();
      if ($('input[name=aduanaParteVentaVehiculos]').val() == "") {
        infoAduanera.aduana = null;
      }    
      else{
        infoAduanera.aduana = $('#aduanaParteVentaVehiculos').val();
      }
	    infoAduanerasParteVentaVehiculos.push(infoAduanera);
	    alert("Información Aduanera Agregada.");
      graficarInformacionAduaneraParteVentaVehiculos();
      $('input[name=numeroParteVentaVehiculos]').val('');
      $('input[name=fechaExpDocAduaneroParteVentaVehiculos]').val('');
      $('input[name=aduanaParteVentaVehiculos]').val('');

  }
})

$('#addInfoAduanera').click(function(){
  var vehiculoUsado = $('.vehiculoUsado').serializeObject();
  if (validaInfoAduanera() == true){
      vehiculoUsado.infoAduaneras = new Object();
	    var infoAduanera = new Object();
      infoAduanera.numero = $('#numero').val();
      infoAduanera.fechaExpDocAduanero = $('#fechaExpDocAduanero').val();
      if ($('input[name=aduana]').val() == "") {
        infoAduanera.aduana = null;
      }    
      else{
        infoAduanera.aduana = $('#aduana').val();
      }
	    infoAduaneras.push(infoAduanera);
      vehiculoUsado.infoAduaneras = infoAduaneras;
	    alert("Información Aduanera Agregada.");
      graficarInformacionAduanera();
      $('input[name=numero]').val('');
      $('input[name=fechaExpDocAduanero]').val('');
      $('input[name=aduana]').val('');

  }
})

$('#addInfoAduaneraParteCuentaTerceros').click(function(){
  if (validaInfoAduaneraParteCuentaTerceros() == true){
	    var infoAduanera = new Object();
      infoAduanera.numeroCuentaTerceros = $('#numeroParteCuentaTerceros').val();
      infoAduanera.fechaExpDocAduaneroCuentaTerceros = $('#fechaExpDocAduaneroParteCuentaTerceros').val();
      if ($('input[name=aduanaParteCuentaTerceros]').val() == "") {
        infoAduanera.aduanaCuentaTerceros = null;
      }    
      else{
        infoAduanera.aduanaCuentaTerceros = $('#aduanaParteCuentaTerceros').val();
      }
	    infoAduanerasParteCuentaTerceros.push(infoAduanera);
	    alert("Información Aduanera Agregada.");
      $('input[name=numeroParteCuentaTerceros]').val('');
      $('input[name=fechaExpDocAduaneroParteCuentaTerceros]').val('');
      $('input[name=aduanaParteCuentaTerceros]').val('');

  }
})

$('#addRetencionCuentaTerceros').click(function(){
    if (validaRetencionCuentaTerceros() == true){
	    var retencionCuentaTerceros = $('.retencionesCuentaTerceros').serializeObject();
	    retencionesCuentaTerceros.push(retencionCuentaTerceros);
	    alert("Retención Agregada.");
      $('input[name=impuestoRetencionesCuentaTerceros]').val('');
      $('input[name=importeRetencionesCuentaTerceros]').val('');
    }

})

$('#addTrasladoCuentaTerceros').click(function(){
    if (validaTrasladosCuentaTerceros() == true){
	    var trasladoCuentaTerceros = $('.trasladosCuentaTerceros').serializeObject();
	    trasladosCuentaTerceros.push(trasladoCuentaTerceros);
	    alert("Traslado Agregado.");
      $('input[name=impuestoTrasladosCuentaTerceros]').val('');
      $('input[name=tasaTrasladosCuentaTerceros]').val('');
      $('input[name=importeTrasladosCuentaTerceros]').val('');
    }

})

$('#addParteCuentaTerceros').click(function(){
  if (validaParteCuentaTerceros() == true){
      var cuentaTerceros = $('.cuentaTerceros').serializeObject();
      cuentaTerceros.partes = new Object();
	    var parte = new Object();
      parte.cantidad = $('#cantidadCuentaTerceros').val();
      if ($('input[name=unidadCuentaTerceros]').val() == "") {
        parte.unidad = null;
      }    
      else{
        parte.unidad = $('#unidadCuentaTerceros').val();
      }
      if ($('input[name=noIdentificacionCuentaTerceros]').val() == "") {
        parte.noIdentificacion = null;
      }    
      else{
        parte.noIdentificacion = $('#noIdentificacionCuentaTerceros').val();
      }
      parte.descripcion = $('#descripcionCuentaTerceros').val();
      if ($('input[name=valorUnitarioParteCuentaTerceros]').val() == "") {
        parte.valorUnitario = null;
      }    
      else{
        parte.valorUnitario = $('#valorUnitarioParteCuentaTerceros').val();
      }
      if ($('input[name=importeParteCuentaTerceros]').val() == "") {
        parte.importe = null;
      }    
      else{
        parte.importe = $('#importeParteCuentaTerceros').val();
      }
     
      parte.infoAduana = infoAduanerasParteCuentaTerceros;
      infoAduanerasParteCuentaTerceros = new Array();
	    partes.push(parte);
      cuentaTerceros.parte = partes;
	    alert("Información de Partes Agregada.");
      graficarPartesCuentaTerceros();
      $('input[name=cantidadCuentaTerceros]').val('');
      $('input[name=unidadCuentaTerceros]').val('');
      $('input[name=noIdentificacionCuentaTerceros]').val('');
      $('input[name=descripcionCuentaTerceros]').val('');
      $('input[name=valorUnitarioParteCuentaTerceros]').val('');
      $('input[name=importeParteCuentaTerceros]').val('');

  }
})

$('#addSpecialInstruction').click(function(){
	    var specialInstruction = $('.specialInstruction').serializeObject();
	    specialInstructionArr.push(specialInstruction);
	    alert("Instrucción Comercial Agregada.");
      $('input[name=textSpecialInstruction]').val('');
})

$('#addOrderIdentification').click(function(){
      referenceIdentification = new Object();
      referenceIdentification.type = "ON";
      referenceIdentification.value = $('#referenceIdentificationOrder').val();
	    referenceIdentificationArr.push(referenceIdentification);
	    alert("Número de orden de compra Agregada.");
      $('input[name=referenceIdentificationOrder]').val('');
})

$('#addAdditionalInformation').click(function(){
      referenceIdentification = new Object();
      referenceIdentification.type = $('#additionalInformation').val();
      referenceIdentification.value = $('#referenceIdentificationAdditional').val();
	    additionalInformationArr.push(referenceIdentification);
	    alert("Referencia Adicional Agregada.");
      $('input[name=referenceIdentificationAdditional]').val('');
})

$('#addReferenceIdentificationDeliveryNote').click(function(){
	    var deliveryNote = $('.deliveryNote').serializeObject();
	    deliveryNoteArr.push(deliveryNote);
	    alert("Información de recepción de mercancia Agregada.");
      $('input[name=referenceIdentificationDeliveryNote]').val('');
})

$('#addCustoms').click(function(){
      var customs = $('.Customs').serializeObject();      
	    customsArr.push(customs);
	    alert("Ubicación de la aduana Agregada.");
      $('input[name=glnCustoms]').val('');
})

$('#addCurrencyFunction').click(function(){
	    var currency = $('.currency').serializeObject();
	    currencyArr.push(currency);
	    alert("Tipo de divisa Agregada.");
      $('input[name=rateOfChange]').val('');
})

$('#addAllowanceCharge').click(function(){
      allowanceCharge = new Object();
      allowanceCharge.allowanceChargeType = $('#allowanceChargeType').val();
      allowanceCharge.settlementType = $('#settlementType').val();
      allowanceCharge.sequenceNumber = $('#sequenceNumber').val();

      allowanceCharge.monetaryAmountOrPercentage = new Object();
      allowanceCharge.monetaryAmountOrPercentage.rate = new Object();
      allowanceCharge.monetaryAmountOrPercentage.rate.base = "INVOICE_VALUE";
      allowanceCharge.monetaryAmountOrPercentage.rate.percentage = $('#percentageAllowanceCharge').val();

      allowanceCharge.specialServicesType = new Object();
      allowanceCharge.specialServicesType =  $('#specialServicesType').val();

	    allowanceChargeArr.push(allowanceCharge);
	    alert("Cargos o descuentos globales mercantiles Agregados");
      $('input[name=sequenceNumber]').val('');
      $('input[name=percentageAllowanceCharge]').val('');
})

$('#addTotalAllowanceCharge').click(function(){
	    var totalAllowanceCharge = $('.TotalAllowanceCharge').serializeObject();
	    totalAllowanceChargeArr.push(totalAllowanceCharge);
	    alert("Monto total de cargos o descuentos Agregado.");
      $('input[name=AmountTotalAllowanceCharge]').val('');
})

$('#addLineItem').click(function(){
	    lineItem = new Object();
      lineItem.type = $('#typeLineItem').val();
      lineItem.number = $('#numberLineItem').val();
      lineItem.tradeItemIdentification = new Object();
      lineItem.tradeItemIdentification.gtin = new Object();
      lineItem.tradeItemIdentification.gtin = $('#gtinLineItem').val(); 

      lineItem.alternateTradeItemIdentification = alternateTradeItemIdentificationArr;      
  
      lineItem.tradeItemDescriptionInformation = new Object();
      lineItem.tradeItemDescriptionInformation.language = $('#languageLineItem').val();  
      lineItem.tradeItemDescriptionInformation.longText = $('#longText').val();  

      lineItem.invoicedQuantity = new Object();
      lineItem.invoicedQuantity.value = $('#invoicedQuantity').val();  
      lineItem.invoicedQuantity.unitOfMeasure = $('#unitOfMeasureLineItem').val();  

      lineItem.addAditionalQuantity = addAditionalQuantityArr;

      lineItem.grossPrice = new Object();
      lineItem.grossPrice.Amount = $('#grossPrice').val();  

      lineItem.netPrice = new Object();
      lineItem.netPrice.Amount = $('#netPrice').val();  

      lineItem.AdditionalInformation = new Object();
      lineItem.AdditionalInformation.referenceIdentification = $('#referenceIdentificationType').val();

      lineItem.Customs = CustomsLineItemArr;

      lineItem.LogisticUnits = new Object();
      lineItem.LogisticUnits.serialShippingContainerCode = new Object();
      lineItem.LogisticUnits.serialShippingContainerCode.type = $('#serialShippingContainerCode').val();  

      lineItem.palletInformation = new Object();
      lineItem.palletInformation.palletQuantity = $('#palletQuantity').val();  
      lineItem.palletInformation.description = $('#descriptionPalletInformation').val();
      lineItem.palletInformation.transport = new Object();
      lineItem.palletInformation.transport.methodOfPayment = $('#methodOfPayment').val();    

      lineItem.extendedAttributes = extendedAttributesArr;

      lineItem.allowanceCharge = allowanceChargeLineItemArr;

      lineItem.tradeItemTaxInformation = tradeItemTaxInformationArr;

      lineItem.totalLineAmount = new Object();
      lineItem.totalLineAmount.grossAmount = $('#grossAmount').val();
      lineItem.totalLineAmount.netAmount = $('#netAmount').val();

	    lineItemArr.push(lineItem);
	    alert("Línea de detalle Agregada.");
      $('input[name=typeLineItem]').val('');
      $('input[name=numberLineItem]').val('');
      $('input[name=gtinLineItem]').val('');
})

$('#addAlternateTradeItemIdentification').click(function(){
      var alternateTradeItemIdentification = new Object();
      alternateTradeItemIdentification.type = $('#alternateTradeItemIdentificationType').val();  
      alternateTradeItemIdentification.value = $('#alternateTradeItemIdentification').val();  
      alternateTradeItemIdentificationArr.push(alternateTradeItemIdentification);
	    alert("Número de identificación adicional Agregado.");
      $('input[name=alternateTradeItemIdentification]').val('');
})

$('#addAditionalQuantity').click(function(){
      var addAditionalQuantity = new Object();
      addAditionalQuantity.aditionalQuantity = $('#aditionalQuantity').val();  
      addAditionalQuantity.QuantityType = $('#QuantityType').val();  
      addAditionalQuantityArr.push(addAditionalQuantity);
	    alert("Cantidad adicional Agregada.");
      $('input[name=aditionalQuantity]').val('');
})

$('#addCustomsLineItem').click(function(){
      var CustomsLineItem = new Object();
      CustomsLineItem.gln = $('#glnCustomsLineItem').val();  
      CustomsLineItem.alternatePartyIdentification =  new Object();
      CustomsLineItem.alternatePartyIdentification.type = $('#QuantityType').val();  
      CustomsLineItem.referenceDate = $('#ReferenceDate').val();  
      CustomsLineItem.nameAndAddress = $('#nameCustomLineItem').val();  
      CustomsLineItemArr.push(CustomsLineItem);
	    alert("Identificador de la aduana Agregada.");
      $('input[name=glnCustomsLineItem]').val('');
      $('input[name=alternatePartyIdentification]').val('');
      $('input[name=mReferenceDate]').val('');
})

$('#addExtendedAtributes').click(function(){
      var extendedAttributes = new Object();
      extendedAttributes.lotNumber = new Object();
      extendedAttributes.lotNumber.value = $('#lotNumber').val();  
      extendedAttributes.lotNumber.productionDate = $('#ProductionDate').val();  

      extendedAttributesArr.push(extendedAttributes);
	    alert("Información adicional de lote Agregado.");
      $('input[name=lotNumber]').val('');
      $('input[name=mProductionDate]').val('');
})


$('#addAllowanceChargeLineItem').click(function(){
      var allowanceChargeLineItem = new Object();
      allowanceChargeLineItem.allowanceChargeType = $('#allowanceChargeTypeLineItem').val();  
      allowanceChargeLineItem.settlementType = $('#settlementTypeLineItem').val();  
      allowanceChargeLineItem.sequenceNumber = $('#sequenceNumberAllowanceChargeLineItem').val();  
      allowanceChargeLineItem.specialServicesType  = $('#specialServicesTypeLineItem').val();
      allowanceChargeLineItem.monetaryAmountOrPercentage = new Object();
      allowanceChargeLineItem.monetaryAmountOrPercentage.percentagePerUnit = $('#percentagePerUnitLineItem').val();    
      allowanceChargeLineItem.monetaryAmountOrPercentage.ratePerUnit = $('#ratePerUnitLineItem').val();    

      allowanceChargeLineItemArr.push(allowanceChargeLineItem);
	    alert("Información de cargos o descuentos globales por línea Agregada.");
      $('input[name=sequenceNumberAllowanceChargeLineItem]').val('');
      $('input[name=percentagePerUnitLineItem]').val('');
      $('input[name=ratePerUnitLineItem]').val('');

})

$('#addTradeItemTaxInformation').click(function(){
      var tradeItemTaxInformation = new Object();
      tradeItemTaxInformation.taxTypeDescription = $('#taxTypeDescription').val();  
      tradeItemTaxInformation.referenceNumber = $('#referenceNumber').val();  
      tradeItemTaxInformation.tradeItemTaxAmount = new Object();
      tradeItemTaxInformation.tradeItemTaxAmount.taxPercentage = $('#taxPercentage').val();    
      tradeItemTaxInformation.tradeItemTaxAmount.taxAmount = $('#taxAmount').val();    
      tradeItemTaxInformation.taxCategory = $('#taxCategory').val();  

      tradeItemTaxInformationArr.push(tradeItemTaxInformation);
	    alert("Información de cargos o descuentos globales por línea Agregada.");
      $('input[name=referenceNumber]').val('');
      $('input[name=taxPercentage]').val('');
      $('input[name=taxAmount]').val('');

})

});

