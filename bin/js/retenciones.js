var mapImpuestos = new Array();
var conceptosDespensa = new Array();
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



function eliminarData(id) {
	mapImpuestos.splice(id, 1);
	graficarImpuestos();
}

function agregarImpuesto() {
	var obj = $('#formAgregarImpuesto .input').serializeObject();
	var impuesto = $('#impuesto option:selected').val();
	var tipoPagoRet = $('#tipoPagoRet option:selected').val()
					
	if ($('#montoRet').val() == "") {
		alert("Debe introducir el Importe del Impuesto Retenido");
		$('#montoRet').focus();
		return;
	}
	if (!$.isNumeric($('#montoRet').val())) {
		$('#montoRet').focus();
		alert("Debe introducir un Importe del Impuesto Retenido de tipo num\u00E9rico");
		return false;
	}
	
	if ($('#tipoPagoRet').val() == "") {
		alert("Debe seleccionar el Tipo de Pago");
		$('#tipoPagoRet').focus();
		return;
	}
	
	
	
	obj.montoRet = parseFloat(obj.montoRet);
	if (obj.baseRet != "")
		obj.baseRet = parseFloat(obj.baseRet);
	obj.impuesto = impuesto;
	obj.tipoPagoRet = tipoPagoRet;
	
	
	mapImpuestos.push(obj);
	graficarImpuestos();

	$('input[name="baseRet"]').val('');
	$('input[name=montoRet]').val('');
	$("#impuesto").get(0).selectedIndex = 0;
	$("#tipoPagoRet").get(0).selectedIndex = 0;
	
}

function graficarImpuestos() {
	$("#tablaImpuestos > tbody").empty();
	var row = '';
	var fields = new Array("baseRet", "impuesto", "montoRet", "tipoPagoRet");
	var input = '<td>:value</td>';
	var montoTotalRetenciones = 0;
	if (mapImpuestos.length == 0) {
		$('#tablaImpuestos tbody').html('<tr><td colspan="9" class="noItemns">No ha seleccionado ning\u00FAn impuesto.</td></tr>');
		return;
	}

	$.each(mapImpuestos, function(key, value) {
		var row = '<tr>';
		row += '<td>' + value['baseRet'] + '</td>';
		if (value['impuesto']== "01")
			row += '<td>ISR</td>';
		if (value['impuesto']== "02")
			row += '<td>IVA</td>';
		if (value['impuesto']== "03")
			row += '<td>IEPS</td>';
		if (value['impuesto']== "")
			row += '<td></td>';
		row += '<td>' + value['montoRet'] + '</td>';
		row += '<td>' + value['tipoPagoRet'] + '</td>';
		

		row += '<td><a class="eliminarImpuesto" onClick="eliminarData(' + key
		+ ')" id="impuesto-' + key
		+ '"><i class="icon-remove"></i> Eliminar </a></td>';
		
		row += '</tr>';
		$('#tablaImpuestos tbody').append(row);
		

		

	});

	

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

function validarDetallista() {

if ($('#glnBuyer').val() != undefined && $('#glnBuyer').val() != "" && $('#glnSeller').val() != "")  {

 var detallista = new Object();
detallista.documentStatus = $('#documentStatus').val();
detallista.type = "SimpleInvoiceType";
detallista.contentVersion = "1.3.1";
detallista.documentStructureVersion="AMC8.1";

detallista.requestForPaymentIdentification = new Object();
detallista.requestForPaymentIdentification.entityType = $('#entityType').val();

/*
var specialInstruction = new Object();
specialInstruction.code = "ZZZ";
specialInstruction.content = new Array();
specialInstruction.content.push("w");
detallista.specialInstruction = new Array();
detallista.specialInstruction.push(specialInstruction);
*/

var referenceIdentification = new Object();
referenceIdentification = $('#deliveryNote').val();

detallista.deliveryNote = new Object();
detallista.deliveryNote.referenceIdentification = new Array();
detallista.deliveryNote.referenceIdentification.push(referenceIdentification);
detallista.deliveryNote.referenceDate = $('#deliveryDate').val();



referenceIdentification = new Object();
referenceIdentification.type = "ON";
referenceIdentification.value = $('#orderIdentification').val();

detallista.orderIdentification = new Object();
detallista.orderIdentification.referenceIdentification = new Array();
detallista.orderIdentification.referenceIdentification.push(referenceIdentification);
detallista.orderIdentification.referenceDate = $('#orderDate').val();

var referenceIdentification = new Object();
referenceIdentification.type = $('#additionalInformation').val();
referenceIdentification.value = "1";


detallista.additionalInformation = new Object();
detallista.additionalInformation.referenceIdentification = new Array();
detallista.additionalInformation.referenceIdentification.push(referenceIdentification);

detallista.buyer = new Object();
detallista.buyer.gln = $('#glnBuyer').val();
detallista.buyer.contactInformation = new Object();
detallista.buyer.contactInformation.personOrDepartmentName = new Object();
detallista.buyer.contactInformation.personOrDepartmentName.text = $('#contactBuyer').val();

detallista.seller = new Object();
detallista.seller.gln = $('#glnSeller').val();
detallista.seller.alternatePartyIdentification = new Object();
detallista.seller.alternatePartyIdentification.type = $('#alternatePartyIdentification').val();
detallista.seller.alternatePartyIdentification.value = $('#alternatePartyIdentificationValue').val();


var allowanceCharge = new Object();
allowanceCharge.allowanceChargeType = $('#allowanceChargeType').val()
allowanceCharge.settlementType = $('#settlementType').val()
allowanceCharge.specialServicesType = $('#specialServicesTypeAllowanceCharge').val();

allowanceCharge.monetaryAmountOrPercentage = new Object();
allowanceCharge.monetaryAmountOrPercentage.rate = new Object();
allowanceCharge.monetaryAmountOrPercentage.rate.base = "INVOICE_VALUE";
allowanceCharge.monetaryAmountOrPercentage.rate.percentage = $('#percentage').val();	

detallista.allowanceCharge = new Array();
detallista.allowanceCharge.push(allowanceCharge);

detallista.totalAmount = new Object();
//detallista.totalAmount.amount = new Object(); 
detallista.totalAmount.amount = $('#totalAmount').val();



var totalAllowanceCharge = new Object();

totalAllowanceCharge
//detallista.totalAmountCharge.amount = new Object(); 
totalAllowanceCharge.amount = $('#totalAmountCharge').val();
//detallista.totalAmountCharge.specialServicesType = new Object();
totalAllowanceCharge.specialServicesType = $('#totalspecialServicesType').val();
totalAllowanceCharge.allowanceOrChargeType = $('#totalAllowanceOrChargeType').val();


detallista.totalAllowanceCharge = new Array();
detallista.totalAllowanceCharge.push(totalAllowanceCharge);


//detallista.lineItem = new Object();
detallista.lineItem = lineItems;
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


function retencionesToJSON() {
	var retenciones = $('.retenciones').serializeObject();
		
	//var propiedades = new Array("serie", "folio", "descuento", "ieps", "numCtaPago", "condicionesDePago");
	//limpiarObjecto(propiedades, retenciones);

	retenciones.emisor = $('.emisor').serializeObject();
	retenciones.receptor = $('.receptor').serializeObject();
	if ($('#nacionalidad').val() == "Nacional") {
		retenciones.receptor.receptorNacional = $('.receptorNacional').serializeObject();
	}
	if ($('#nacionalidad').val() == "Extranjero") {
		retenciones.receptor.receptorExtranjero = $('.receptorExtranjero').serializeObject();
	}
	
	retenciones.periodo = $('.periodo').serializeObject();
	retenciones.totales = $('.totales').serializeObject();
	retenciones.totales.impuestos = new Object();
	retenciones.totales.impuestos = mapImpuestos;
	
	var arrendamientoEnFideicomiso = validarArrFid();
	if (arrendamientoEnFideicomiso != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.arrendamientoEnFideicomiso = new Object();
		retenciones.complemento.arrendamientoEnFideicomiso = arrendamientoEnFideicomiso;
	}
	
	var intereses = validarIntereses();
	if (intereses != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.intereses = new Object();
		retenciones.complemento.intereses = intereses;
	}
	
	var intereseshipotecarios = validarInteresesHipotecarios();
	if (intereseshipotecarios != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.intereseshipotecarios = new Object();
		retenciones.complemento.intereseshipotecarios = intereseshipotecarios;
	}
	
	var operacionesconderivados = validarOperacionesConDerivados();
	if (operacionesconderivados != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.operacionesconderivados = new Object();
		retenciones.complemento.operacionesconderivados = operacionesconderivados;
	}
	
	var planesderetiro = validarPlanesDeRetiro();
	if (planesderetiro != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.planesderetiro = new Object();
		retenciones.complemento.planesderetiro = planesderetiro;
	}
	
	var premios = validarPremios();
	if (premios != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.premios = new Object();
		retenciones.complemento.premios = premios;
	}
	
	var sectorFinanciero = validarSectorFinanciero();
	if (sectorFinanciero != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.sectorFinanciero = new Object();
		retenciones.complemento.sectorFinanciero = sectorFinanciero;
	}
	
	var enajenaciondeAcciones = validarEnajenacionAcciones();
	if (enajenaciondeAcciones != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.enajenaciondeAcciones = new Object();
		retenciones.complemento.enajenaciondeAcciones = enajenaciondeAcciones;
	}
	
	
	var pagosaExtranjeros = validarPagosAExtranjeros();
	if (pagosaExtranjeros != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.pagosaExtranjeros = new Object();
		retenciones.complemento.pagosaExtranjeros = $('.pagosExtranjeros').serializeObject();
				
		if ($('#esBenefEfectDelCobro').val() == "SI") {
			retenciones.complemento.pagosaExtranjeros.beneficiario = new Object();
			retenciones.complemento.pagosaExtranjeros.beneficiario = pagosaExtranjeros;
		}
		if ($('#esBenefEfectDelCobro').val() == "NO") {
			retenciones.complemento.pagosaExtranjeros.noBeneficiario  = new Object();
			retenciones.complemento.pagosaExtranjeros.noBeneficiario = pagosaExtranjeros;
		}
		
	}
	
	var dividendos = validarDividendos();
	if (dividendos != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.dividendos = new Object();
		retenciones.complemento.dividendos = dividendos;
	
	}
	
	
	var fidNoEmp = validarFidNoEmp();
	if (fidNoEmp != null) {
		if (retenciones.complemento == undefined) {
			retenciones.complemento = new Object();
		}
		retenciones.complemento.fideicomisonoempresarial = new Object();
		retenciones.complemento.fideicomisonoempresarial = fidNoEmp;
	
	}
	
		
	return JSON.stringify(retenciones, null, " ");
}

function validarArrFid() {
	if ($('#pagProvEfecPorFiduc').val() != "" && $('#rendimFideicom').val() != "" && $('#deduccCorresp').val() != "") {
		arrFid = new Object();
		arrFid.pagProvEfecPorFiduc = $('#pagProvEfecPorFiduc').val();
		arrFid.rendimFideicom = $('#rendimFideicom').val();
		arrFid.deduccCorresp = $('#deduccCorresp').val();
		if ($('#montTotRetArr').val() != ""){
			arrFid.montTotRetArr = $('#montTotRetArr').val();
		}
		else{
			arrFid.montTotRetArr = null;
		}
		if ($('#montResFiscDistFibras').val() != ""){
			arrFid.montResFiscDistFibras = $('#montResFiscDistFibras').val();
		}
		else{
			arrFid.montResFiscDistFibras = null;
		}
		if ($('#montOtrosConceptDistr').val() != ""){
			arrFid.montOtrosConceptDistr = $('#montOtrosConceptDistr').val();
		}
		else{
			arrFid.montOtrosConceptDistr = null;
		}
		if ($('#descrMontOtrosConceptDistr').val() != ""){
			arrFid.descrMontOtrosConceptDistr = $('#descrMontOtrosConceptDistr').val();
		}
		else{
			arrFid.descrMontOtrosConceptDistr = null;
		}
		
			
		return arrFid;
	}
	return null;
}

function validarIntereses() {
	if ($('#sistFinanciero').val() != "" && $('#retiroAORESRetInt').val() != "" && $('#operFinancDerivad').val() != "" && $('#montIntNominal').val() != "" && $('#montIntReal').val() != "" && $('#perdida').val() != "") {
		arrIntereses = new Object();
		arrIntereses.sistFinanciero = $('#sistFinanciero').val();
		arrIntereses.retiroAORESRetInt = $('#retiroAORESRetInt').val();
		arrIntereses.operFinancDerivad = $('#operFinancDerivad').val();
		arrIntereses.montIntNominal = $('#montIntNominal').val();
		arrIntereses.montIntReal = $('#montIntReal').val();
		arrIntereses.perdida = $('#perdida').val();
				
		return arrIntereses;
	}
	return null;
}

function validarInteresesHipotecarios() {
	if ($('#creditoDeInstFinanc').val() != "" && $('#saldoInsoluto').val() != "" ) {
		arrInteresesHipot = new Object();
		arrInteresesHipot.creditoDeInstFinanc = $('#creditoDeInstFinanc').val();
		arrInteresesHipot.saldoInsoluto = $('#saldoInsoluto').val();
		if ($('#propDeducDelCredit').val() != ""){
			arrInteresesHipot.propDeducDelCredit = $('#propDeducDelCredit').val();
		}
		else{
			arrInteresesHipot.propDeducDelCredit = null;
		}
		if ($('#montTotIntNominalesDev').val() != ""){
			arrInteresesHipot.montTotIntNominalesDev = $('#montTotIntNominalesDev').val();
		}
		else{
			arrInteresesHipot.montTotIntNominalesDev = null;
		}
		if ($('#montTotIntNominalesDevYPag').val() != ""){
			arrInteresesHipot.montTotIntNominalesDevYPag = $('#montTotIntNominalesDevYPag').val();
		}
		else{
			arrInteresesHipot.montTotIntNominalesDevYPag = null;
		}
		if ($('#montTotIntRealPagDeduc').val() != ""){
			arrInteresesHipot.montTotIntRealPagDeduc = $('#montTotIntRealPagDeduc').val();
		}
		else{
			arrInteresesHipot.montTotIntRealPagDeduc = null;
		}
		if ($('#numContrato').val() != ""){
			arrInteresesHipot.numContrato = $('#numContrato').val();
		}
		else{
			arrInteresesHipot.numContrato = null;
		}
		
				
		return arrInteresesHipot;
	}
	return null;
}

function validarOperacionesConDerivados() {
	if ($('#montGanAcum').val() != "" && $('#montPerdDed').val() != "") {
		arrOperacionesConDerivados = new Object();
		arrOperacionesConDerivados.montGanAcum = $('#montGanAcum').val();
		arrOperacionesConDerivados.montPerdDed = $('#montPerdDed').val();
				
		return arrOperacionesConDerivados;
	}
	return null;
}

function validarPlanesDeRetiro() {
	if ($('#sistemaFinanc').val() != "" && $('#montIntRealesDevengAniooInmAnt').val() != "" && $('#huboRetirosAnioInmAntPer').val() != "" && $('#huboRetirosAnioInmAnt').val() != "") {
		arrPlanesDeRetiro = new Object();
		arrPlanesDeRetiro.sistemaFinanc = $('#sistemaFinanc').val();
		if ($('#montTotAportAnioInmAnterior').val() != ""){
			arrPlanesDeRetiro.montTotAportAnioInmAnterior = $('#montTotAportAnioInmAnterior').val();
		}
		else{
			arrPlanesDeRetiro.montTotAportAnioInmAnterior = null;
		}
				
		arrPlanesDeRetiro.montIntRealesDevengAniooInmAnt = $('#montIntRealesDevengAniooInmAnt').val();
		arrPlanesDeRetiro.huboRetirosAnioInmAntPer = $('#huboRetirosAnioInmAntPer').val();
		if ($('#montTotRetiradoAnioInmAntPer').val() != ""){
			arrPlanesDeRetiro.montTotRetiradoAnioInmAntPer = $('#montTotRetiradoAnioInmAntPer').val();
		}
		else{
			arrPlanesDeRetiro.montTotRetiradoAnioInmAntPer = null;
		}
		if ($('#montTotExentRetiradoAnioInmAnt').val() != ""){
			arrPlanesDeRetiro.montTotExentRetiradoAnioInmAnt = $('#montTotExentRetiradoAnioInmAnt').val();
		}
		else{
			arrPlanesDeRetiro.montTotExentRetiradoAnioInmAnt = null;
		}
		if ($('#montTotExedenteAnioInmAnt').val() != ""){
			arrPlanesDeRetiro.montTotExedenteAnioInmAnt = $('#montTotExedenteAnioInmAnt').val();
		}
		else{
			arrPlanesDeRetiro.montTotExedenteAnioInmAnt = null;
		}
				
		arrPlanesDeRetiro.huboRetirosAnioInmAnt = $('#huboRetirosAnioInmAnt').val();
		if ($('#montTotRetiradoAnioInmAnt').val() != ""){
			arrPlanesDeRetiro.montTotRetiradoAnioInmAnt = $('#montTotRetiradoAnioInmAnt').val();
		}
		else{
			arrPlanesDeRetiro.montTotRetiradoAnioInmAnt = null;
		}
		
					
		return arrPlanesDeRetiro;
	}
	return null;
}

function validarPremios() {
	if ($('#entidadFederativa').val() != "" && $('#montTotPago').val() != "" && $('#montTotPagoGrav').val() != "" && $('#montTotPagoExent').val() != "") {
		arrPremios = new Object();
		arrPremios.entidadFederativa = $('#entidadFederativa').val();
		arrPremios.montTotPago = $('#montTotPago').val();
		arrPremios.montTotPagoGrav = $('#montTotPagoGrav').val();
		arrPremios.montTotPagoExent = $('#montTotPagoExent').val();
						
		return arrPremios;
	}
	return null;
}

function validarSectorFinanciero() {
	if ($('#idFideicom').val() != "" && $('#descripFideicom').val() != "" ) {
		arrSectorFinanciero = new Object();
		arrSectorFinanciero.idFideicom = $('#idFideicom').val();
		arrSectorFinanciero.descripFideicom = $('#descripFideicom').val();
		if ($('#nomFideicom').val() != ""){
			arrSectorFinanciero.nomFideicom = $('#nomFideicom').val();
		}
		else{
			arrSectorFinanciero.nomFideicom = null;
		}
						
		return arrSectorFinanciero;
	}
	return null;
}

function validarEnajenacionAcciones() {
	if ($('#contratoIntermediacion').val() != "" && $('#ganancia').val() != "" && $('#perdidaEnajAcc').val() != "") {
		arrEnajenacionAcciones = new Object();
		arrEnajenacionAcciones.contratoIntermediacion = $('#contratoIntermediacion').val();
		arrEnajenacionAcciones.ganancia = $('#ganancia').val();
		arrEnajenacionAcciones.perdida = $('#perdidaEnajAcc').val();
						
		return arrEnajenacionAcciones;
	}
	return null;
}

function validarPagosAExtranjeros() {
	if ($('#esBenefEfectDelCobro').val() != "") {
		arrPagosAExtranjeros = new Object();
		if ($('#esBenefEfectDelCobro').val() == "SI") {
			if ($('#rfcBenef').val() != "" && $('#curpBenef').val() != "" && $('#nomDenRazSocBenef').val() != "" && $('#conceptoPago').val() != "" && $('#descripcionConcepto').val() != "") {
				arrPagosAExtranjeros.rfcBenef = $('#rfcBenef').val();
				arrPagosAExtranjeros.curpBenef = $('#curpBenef').val();
				arrPagosAExtranjeros.nomDenRazSocBenef = $('#nomDenRazSocBenef').val();
				arrPagosAExtranjeros.conceptoPago = $('#conceptoPago').val();
				arrPagosAExtranjeros.descripcionConcepto = $('#descripcionConcepto').val();
			}
		}
		if ($('#esBenefEfectDelCobro').val() == "NO") {
			if ($('#paisDeResidParaEfecFisc').val() != "" && $('#conceptoPago').val() != "" && $('#descripcionConcepto').val() != "") {
				arrPagosAExtranjeros.paisDeResidParaEfecFisc = $('#paisDeResidParaEfecFisc').val();
				arrPagosAExtranjeros.conceptoPago = $('#conceptoPago').val();
				arrPagosAExtranjeros.descripcionConcepto = $('#descripcionConcepto').val();
			}
			
		}
					
		return arrPagosAExtranjeros;
	}
	return null;
}

function validarDividendos() {
	if ($('#proporcionRem').val() != ""){
		dividendos = new Object();
		dividendos.remanente = new Object();
		dividendos.remanente.proporcionRem = $('#proporcionRem').val();
				
		if ($('#cveTipDivOUtil').val() == "" && $('#montISRAcredRetMexico').val() == "" && $('#montISRAcredRetExtranjero').val() == "" && $('#tipoSocDistrDiv').val() == "") {
			dividendos.dividOUtil = null;
		}
		if ($('#cveTipDivOUtil').val() != "" && $('#montISRAcredRetMexico').val() != "" && $('#montISRAcredRetExtranjero').val() != "" && $('#tipoSocDistrDiv').val() != "") {
			dividendos.dividOUtil = new Object();
			dividendos.dividOUtil.cveTipDivOUtil = $('#cveTipDivOUtil').val();
			dividendos.dividOUtil.montISRAcredRetMexico = $('#montISRAcredRetMexico').val();
			dividendos.dividOUtil.montISRAcredRetExtranjero = $('#montISRAcredRetExtranjero').val();
			if ($('#montRetExtDivExt').val() != ""){
				dividendos.dividOUtil.montRetExtDivExt = $('#montRetExtDivExt').val();
			}
			else{
				dividendos.dividOUtil.montRetExtDivExt = null;
			}
			
			dividendos.dividOUtil.tipoSocDistrDiv = $('#tipoSocDistrDiv').val();
			if ($('#montISRAcredNal').val() != ""){
				dividendos.dividOUtil.montISRAcredNal = $('#montISRAcredNal').val();
			}
			else{
				dividendos.dividOUtil.montISRAcredNal = null;
			}
			if ($('#montDivAcumNal').val() != ""){
				dividendos.dividOUtil.montDivAcumNal = $('#montDivAcumNal').val();
			}
			else{
				dividendos.dividOUtil.montDivAcumNal = null;
			}
			if ($('#montDivAcumExt').val() != ""){
				dividendos.dividOUtil.montDivAcumExt = $('#montDivAcumExt').val();
			}
			else{
				dividendos.dividOUtil.montDivAcumExt = null;
			}
			
				
		}
		return dividendos;
	}
	else{
		if ($('#cveTipDivOUtil').val() != "" && $('#montISRAcredRetMexico').val() != "" && $('#montISRAcredRetExtranjero').val() != "" && $('#tipoSocDistrDiv').val() != "") {
			dividendos = new Object();
			dividendos.dividOUtil = new Object();
			dividendos.dividOUtil.cveTipDivOUtil = $('#cveTipDivOUtil').val();
			dividendos.dividOUtil.montISRAcredRetMexico = $('#montISRAcredRetMexico').val();
			dividendos.dividOUtil.montISRAcredRetExtranjero = $('#montISRAcredRetExtranjero').val();
			if ($('#montRetExtDivExt').val() != ""){
				dividendos.dividOUtil.montRetExtDivExt = $('#montRetExtDivExt').val();
			}
			else{
				dividendos.dividOUtil.montRetExtDivExt = null;
			}
			
			dividendos.dividOUtil.tipoSocDistrDiv = $('#tipoSocDistrDiv').val();
			if ($('#montISRAcredNal').val() != ""){
				dividendos.dividOUtil.montISRAcredNal = $('#montISRAcredNal').val();
			}
			else{
				dividendos.dividOUtil.montISRAcredNal = null;
			}
			if ($('#montDivAcumNal').val() != ""){
				dividendos.dividOUtil.montDivAcumNal = $('#montDivAcumNal').val();
			}
			else{
				dividendos.dividOUtil.montDivAcumNal = null;
			}
			if ($('#montDivAcumExt').val() != ""){
				dividendos.dividOUtil.montDivAcumExt = $('#montDivAcumExt').val();
			}
			else{
				dividendos.dividOUtil.montDivAcumExt = null;
			}
			return dividendos;
		}
		
		
	}
	
	return null;
	
}


function validarFidNoEmp() {
	if ($('#montTotEntradasPeriodo').val() != "" && $('#partPropAcumDelFideicom').val() != "" && $('#propDelMontTot').val() != "" 
		&& $('#conceptoIntIngresos').val() != "" && $('#montTotEgresPeriodo').val() != "" && $('#partPropDelFideicom').val() != "" && $('#propDelMontTotSalidas').val() != ""
		&& $('#conceptoS').val() != "" && $('#montRetRelPagFideic').val() != "" && $('#descRetRelPagFideic').val() != "") {
		arrFidNoEmp = new Object();
		arrFidNoEmp.ingresosOEntradas = new Object();
		arrFidNoEmp.ingresosOEntradas.montTotEntradasPeriodo = $('#montTotEntradasPeriodo').val();
		arrFidNoEmp.ingresosOEntradas.partPropAcumDelFideicom = $('#partPropAcumDelFideicom').val();
		arrFidNoEmp.ingresosOEntradas.propDelMontTot = $('#propDelMontTot').val();
		arrFidNoEmp.ingresosOEntradas.integracIngresos = new Object();
		arrFidNoEmp.ingresosOEntradas.integracIngresos.concepto = $('#conceptoIntIngresos').val();
				
		arrFidNoEmp.deduccOSalidas = new Object();
		arrFidNoEmp.deduccOSalidas.montTotEgresPeriodo = $('#montTotEgresPeriodo').val();
		arrFidNoEmp.deduccOSalidas.partPropDelFideicom = $('#partPropDelFideicom').val();
		arrFidNoEmp.deduccOSalidas.propDelMontTot = $('#propDelMontTotSalidas').val();
		arrFidNoEmp.deduccOSalidas.integracEgresos = new Object();
		arrFidNoEmp.deduccOSalidas.integracEgresos.conceptoS = $('#conceptoS').val();
		
		arrFidNoEmp.retEfectFideicomiso = new Object();
		arrFidNoEmp.retEfectFideicomiso.montRetRelPagFideic = $('#montRetRelPagFideic').val();
		arrFidNoEmp.retEfectFideicomiso.descRetRelPagFideic = $('#descRetRelPagFideic').val();
			
		return arrFidNoEmp;
		}
		
					
		
	
	return null;
}

function validarRetenciones() {
	if ($('#CveRetenc').val() == "") {
		alert("Debe seleccionar la Clave de Retenci\u00F3n");
		return false;
	}
	if ($('#nacionalidad').val() == "") {
		alert("Debe seleccionar la Nacionalidad");
		return false;
	}else{
		if ($('#nacionalidad').val() == "Nacional") {
			if ($('#rfcReceptor').val() == "") {
				alert("Debe proporcionar el RFC del receptor");
				return false;
			}
		}
		if ($('#nacionalidad').val() == "Extranjero") {
			if ($('#nomDenRazSocREx').val() == "") {
				alert("Debe proporcionar el nombre, denominaci\u00F3n o raz\u00F3n social del receptor");
				return false;
			}
		}
	}
	if ($('#mesIni').val() == "") {
		alert("Debe seleccionar el Mes Inicial del Per\u00EDodo");
		return false;
	}
	if ($('#mesFin').val() == "") {
		alert("Debe seleccionar el Mes Final del Per\u00EDodo");
		return false;
	}
	if ($('#ejerc').val() == "") {
		alert("Debe seleccionar el Ejercicio Fiscal");
		return false;
	}
	
	if ($('#montoTotOperacion').val() == "") {
		alert("Debe proporcionar el Monto Total de la Operaci\u00F3n");
		return false;
	}
	if ($('#montoTotGrav').val() == "") {
		alert("Debe proporcionar el Monto Total Gravado");
		return false;
	}
	if ($('#montoTotExent').val() == "") {
		alert("Debe proporcionar el Monto Total Exento");
		return false;
	}
	if ($('#montoTotRet').val() == "") {
		alert("Debe proporcionar el Monto Total de las Retenciones");
		return false;
	}
	
			
	
	
	return true;
}

function getFolio() {
	$.get('/CFDI/rest/comprobante/folioRet/', function(response) {
		$('#FolioInt').val(response);
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
	/* Seleccionar Folio */
	getFolio();
	$('#serie').change(getFolio);
	
	$('#btnTipoComprobante').change(function() {
		top.location.href = $('#btnTipoComprobante').val();
		});
	
	$('.nacionalidad').change(function() {
		var selection = $('#nacionalidad').val();
		$('.box').hide();
	    $('#'+$(this).val()).show();
	});
	
	$('#esBenefEfectDelCobro').change(function() {
		var selection = $('#esBenefEfectDelCobro').val();
		$('.benef').hide();
	    $('#'+$(this).val()).show();
	});

	$('#formRetenciones').submit(function() {
		return false;
	});

	$('#formVistaPreviaRetenciones, #formGenerarRetenciones').submit(				
			function() {
				if (!validarRetenciones()) {
					return false;
				}
				
				var strRetenciones = retencionesToJSON();
				$('.strRetenciones').val(retencionesToJSON());
                if ($(this).attr('id') == "formGenerarRetenciones")
                	$('#generarRetenciones').attr('disabled', 'disabled');
			});

	$('#FechaExp').attr('readonly', 'readonly');

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
	
		
	$('#btnAgregarImpuesto').click(function() {
		agregarImpuesto();
		return false;
	});


	var map = {};
	var objects = [];

	$.validator.addMethod("regex", function(value, element,
			regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Ingrese un RFC valido.");
	
	$.validator.addMethod("regexCurp", function(value, element,
			regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Ingrese un CURP valido.");

	$.validator.addMethod("numero", function(value, element,
			regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Ingrese un n\u00famero v\u00e1lido.");
	
	$.validator.addMethod("numeroDec", function(value, element,
			regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Ingrese un n\u00famero Decimal v\u00e1lido.");
	
	$.validator.addMethod("alfanumerico", 
			
			function(value,
			element, regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Solo caracteres alfanumericos.");
	

	$('#formRetenciones')
	.validate(
			{
				rules : {
					CURPE:{
						regexCurp : "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]?"
					},
					rfcRecep : {
						required : true,
						minlength : 12,
						maxlength : 13,
						regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
					},
					CveRetenc : {
						required : true,
						valueNotEquals : ""
					},
					nacionalidad : {
						required : true,
						valueNotEquals : ""
					},
					curpR:{
						regexCurp : "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]?"
					},
					mesInicio : {
						required : true,
						valueNotEquals : ""
					},
					mesFinal : {
						required : true,
						valueNotEquals : ""
					},
					ejercicio : {
						required : true,
						valueNotEquals : ""
					},
					montoTotOperacion : {
						required : true,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montoTotGrav : {
						required : true,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montoTotExent : {
						required : true,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montoTotRet : {
						required : true,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					baseRet : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montoRet : {
						required : true,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					pagProvEfecPorFiduc : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					rendimFideicom : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					deduccCorresp : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotRetArr : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montResFiscDistFibras : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montOtrosConceptDistr : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},		
					montIntNominal : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montIntReal : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					perdida : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					saldoInsoluto : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					propDeducDelCredit : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotIntNominalesDev : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotIntNominalesDevYPag : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotIntRealPagDeduc : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montGanAcum : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montPerdDed : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotAportAnioInmAnterior : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montIntRealesDevengAniooInmAnt : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotRetiradoAnioInmAntPer : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotExentRetiradoAnioInmAnt : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotExedenteAnioInmAnt : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotRetiradoAnioInmAnt : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotPago : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotPagoGrav : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotPagoExent : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					ganancia : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					perdidaEnajAcc : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					rfcBenef : {
						required : false,
						minlength : 12,
						maxlength : 13,
						regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
					},
					curpBenef:{
						required : false,
						regexCurp : "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]?"
					},
					proporcionRem : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montISRAcredRetMexico : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montISRAcredRetExtranjero : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montRetExtDivExt : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montISRAcredNal : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montDivAcumNal : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montDivAcumExt : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					proporcionRem : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotEntradasPeriodo : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					partPropAcumDelFideicom : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					propDelMontTot : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					montTotEgresPeriodo : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					partPropDelFideicom : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					},
					propDelMontTotSalidas : {
						required : false,
						numeroDec : "^[0-9]+\.([0-9]{1,6})?$"
					},
					montRetRelPagFideic : {
						required : false,
						numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
					}
				}
			});
					



$('#FolioInt').change(function () {
	if (!$.isNumeric($('#FolioInt').val())) {
		alert("El folio debe ser numero");
		$('#FolioInt').val(getFolio());
		$('#FolioInt').focus();		
	}
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
		var conceptoDespensa = $('.conceptoDespensa').serializeObject();
		conceptosDespensa.push(conceptoDespensa);
		graficarConceptoDespensa();
	})


				});



function activarDetalle(modulo) {
	$('.div' + modulo + ' input[type=text]').val('');
	$('.div' + modulo).toggle(0);
        if (modulo == "IEPS" && $('#ish').is(':checked'))
	$('.div' + modulo).hide(0);
}
