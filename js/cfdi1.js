var mapConceptos = new Array();
var mapImpuestosTraslados = new Array();
var numeroDecimales = 2;
var firmas = new Array();
var subtotal, descuento = 0, totalIVA = 0, totalIEPS = 0;
var ivaDescuentoRestado = 0;
var tasaIEPS = "";

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

	obj.cantidad = parseFloat(obj.cantidad);
	obj.descuento = obj.descuento == "" ? "" : parseFloat(obj.descuento);
	obj.ieps = obj.ieps == "" ? "" : parseFloat(obj.ieps);
	obj.iva = obj.iva == "" ? "" : parseFloat(obj.iva);
	obj.valorUnitario = parseFloat(obj.valorUnitario);
	
	if ($('#descuentoPorcentaje').val() == 1 || $('#descuentoPorcentaje').val() == "true") {
		descuento = obj.valorUnitario * (obj.descuento / 100);
		obj.descuento = descuento;
	}
	if ($('#ivaIncluido').is(':checked')) {
		var porIva = (1 + ($('#iva').val()) / 100);
		if ($('#ish').is(':checked')) {
			var tasaISH = parseFloat($('#tasaISH').val()) / 100;
			porIva += tasaISH; // 0.02;
		}
		obj.valorUnitario = redondearValor($('#valorUnitario').val() / porIva) + obj.descuento;
	}
	
	var importe = redondearValor(((obj.valorUnitario * obj.cantidad) - obj.descuento)); 	
	if (obj.ieps != "") {
		tasaIEPS = obj.ieps;
		
		if ($('input[name=tipoIEPS]:checked').val() == "0") totalIEPS += (obj.ieps / 100) * importe;
		if ($('input[name=tipoIEPS]:checked').val() == "1") totalIEPS += (obj.ieps * obj.cantidad);
	}
	
	if (obj.ivaExento == true) {
		obj.iva = 0;
	}


	if (obj.ivaExento == false || obj.ivaExento == undefined) {
		if (mapImpuestosTraslados[obj.iva] == undefined) {
			mapImpuestosTraslados[obj.iva] = 0;
		}
		var descuento = (obj.descuento == "") ? 0 : obj.descuento;
		if ($('#descuentoPorcentaje').val() == 1 || $('#descuentoPorcentaje').val() == true) {
			descuento = obj.valorUnitario * (obj.descuento / 100);
			obj.descuento = descuento;
		}
		
		iva = importe * (obj.iva / 100);
		totalIVA += iva;
		obj.iva = iva;
		mapImpuestosTraslados[obj.iva] += iva;
	}
	
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

function validarDonatarias() {
	if ($('#noAprobacion').val() != "" && $('#fechaAprobacion').val() != "") {
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
	for ( var i = 1; i <= 5; i++) {
		impLoc = $('.impLoc' + i).serializeObject();
		if (impLoc.importe == "") {
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

function comprobanteToJSON() {
	if ($('#pais option:selected').val() == "") {
		$('#pais option[value=México]').attr('selected','selected');
	}
	
	var comprobante = $('.comprobante').serializeObject();
	if (comprobante.descuento = 0) {
		delete comprobante.descuento;
	} 
	
	if ($('#nombreAlumno').val() != "" || $('#curp').val() != "" ) {
		var instEducativas = $('.instEducativas').serializeObject();
		var index = mapConceptos.length - 1;
		mapConceptos[index].complementoConcepto = new Object();
		//mapConceptos[index].complementoConcepto.complementoConcepto = new Object();
		mapConceptos[index].complementoConcepto.instEducativas = instEducativas;
	}

	var propiedades = new Array("serie", "folio", "descuento", "ieps", "numCtaPago");
	limpiarObjecto(propiedades, comprobante);

	comprobante.emisor = $('.emisor').serializeObject();
	comprobante.emisor.domicilioFiscal = $('.emisorDomicilio').serializeObject();
	propiedades = new Array("colonia", "localidad", "noExterior", "noInterior");
	limpiarObjecto(propiedades, comprobante.emisor.domicilioFiscal);

	comprobante.receptor = $('.receptor').serializeObject();
	comprobante.receptor.domicilio = $('.receptorDomicilio').serializeObject();
	propiedades = new Array("calle", "colonia", "localidad", "municipio", "codigoPostal", "noExterior", "noInterior");
	limpiarObjecto(propiedades, comprobante.receptor.domicilio);

	var ivaTras = 0;
	/* limpiamos los conceptos */
	$.each(mapConceptos, function(key, value) {
		
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

        // ivaTras -= parseFloat($('input[name=totalDescuento]').val()) * 0.16;

	comprobante.conceptos = new Object();
	comprobante.conceptos.conceptos = mapConceptos;

	comprobante.impuestos = new Object();

	var impuestosLocales = validarImpuestosLocales();
	if (impuestosLocales.retencionesLocales.retencionesLocales.length > 0
			|| impuestosLocales.trasladosLocales.trasladosLocales.length > 0) {
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
	
	if (mapImpuestosTraslados.length > 0) {
		var ivaIEPS = 0;
		comprobante.impuestos.totalImpuestosTrasladados = redondearValor2(parseFloat($('input[name=totalImpuestosTrasladados]').val()));
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
		traslado.tasa = parseFloat($('#iva').val());
		traslado.importe = redondearValor(totalIVA); // ivaTras + ivaIEPS);
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
			retencion.importe = parseFloat($('input[name=totalIVARetenido]').val());
			comprobante.impuestos.totalImpuestosRetenidos += redondearValor(retencion.importe);
			comprobante.impuestos.retenidos.retenciones.push(retencion);
		}

		if ($('input[name=totalISRRetenido]').val() != "") {
			var retencion = new Object();
			retencion.impuesto = "ISR";
			retencion.importe = parseFloat($('input[name=totalISRRetenido]').val());
			comprobante.impuestos.totalImpuestosRetenidos += redondearValor(retencion.importe);
			comprobante.impuestos.retenidos.retenciones.push(retencion);
		}
		comprobante.impuestos.totalImpuestosRetenidos = redondearValor2(comprobante.impuestos.totalImpuestosRetenidos);
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
	return JSON.stringify(comprobante, null, " ");
}

function validarFactura() {
	if (mapConceptos.length == 0) {
		alert("Debe agregar al menos un concepto.");
		return false;
	}
	
	if ($('#tipoDeComprobante').val() == "cp") {
		if ($('#observaciones').val() == "") {
			alert("Carta porte no válida. Debe utilizar el archivo EXCEL de Carta Portal");
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
	descuento = 0;
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
		$('input[name=totalImpuestosTrasladados]').val("0.00");
		return;
	}

	subtotal = total = totalDescuento = totalISR = 0.0;
	$.each(mapConceptos, function(key, value) {
		row += '<tr>';

		if (value['descuento'] != undefined && value['descuento'] != '') {
			descuento = redondearValor(value['cantidad'] * value['descuento']);
		}

		importe = redondearValor((value['cantidad'] * value['valorUnitario']));
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
	var montoDescuento = ($('#montoDescuento').val() == "" ? 0 : parseFloat($('#montoDescuento').val()));
	descuento = totalDescuento + montoDescuento;

	totalIVAsinIEPS = totalIVA;
	if (($('#ivaIeps').val() != "false" && $('#ivaIeps').val() != "") && totalIVA != 0 && totalIEPS != 0) {
		totalIVA = (subtotal + totalIEPS) * 0.16;
		
	}

	var total = parseFloat(subtotal + totalIEPS) - parseFloat(descuento) + parseFloat(totalIVA);

	if ($('input[name=totalIVARetenido]').val() != "") {
		total -= parseFloat($('input[name=totalIVARetenido]').val());
	}
	if ($('input[name=totalISRRetenido]').val() != "") {
		total -= parseFloat($('input[name=totalISRRetenido]').val());
	}
	total = redondearValor(total);

	var impuestosLocales = validarImpuestosLocales();

	total = redondearValor(total - impuestosLocales.totalDeRetenciones);
	total = redondearValor(total + impuestosLocales.totalDeTraslados);

	$('input[name=total]').val(total);
	if (impuestosLocales.totalDeRetenciones != 0) {
		$('.totalDeRetenciones').show(0);
		$('input[name=totalDeRetenciones]').val(redondearValor2(impuestosLocales.totalDeRetenciones));
	} else {
		$('input[name=totalDeRetenciones]').hide(0);
	}
	if (impuestosLocales.totalDeTraslados != 0) {
		$('.totalDeTraslados').show(0);
		$('input[name=totalDeTraslados]').val(redondearValor2(impuestosLocales.totalDeTraslados));
	} else {
		$('.totalDeTraslados').hide(0);
	}
	$('input[name=totalDescuento]').val(descuento <= 0 ? 0 : (redondearValor(descuento)));
	$('input[name=subTotal]').val(redondearValor(subtotal));
	
	
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

$(document)
		.ready(

				function() {
		//			$('#descuento').val('0');
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

					
					$('#fechaAprobacion').datepicker({
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

					$('#formVistaPrevia, #formGenerarComprobante').submit(
							function() {
								if (!validarFactura()) {
									return false;
								}
								$('.strComprobante').val(comprobanteToJSON());
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
					$('#rfc').typeahead(
							{
								// minLength: 3,
								source : function(query, process) {
									map = {};
									objects = [];
									response = $.ajax({
										url : '/CFDI/rest/cliente/listarRFC/' + query,
										async : false
									});
									data = $.parseJSON(response.responseText);
									$.each(data, function(i, object) {
										map[object.name] = object;
										objects.push(object.name);
									});
									process(objects);
								},
								updater : function(item) {
									response = $.ajax({
										url : '/CFDI/rest/cliente/find/'
												+ map[item].id,
										async : false
									});
									cliente = $.parseJSON(response.responseText);
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
									return item;
								}
							});
					$('#razonSocial').change(function() {
						if ($('#razonSocial').val().indexOf('<->') > 0) {
							$('#razonSocial').val($('#razonSocial').val().substring(0, $('#razonSocial').val().indexOf('<->')).trim());
						}
					});
					
					// $('#razonSocial').val($('#razonSocial').val().substring(0, $('#razonSocial').val().indexOf('-')).trim())
					$('#razonSocial').typeahead(
							{
								// minLength: 3,
								source : function(query, process) {
									map = {};
									objects = [];
									response = $.ajax({
										url : '/CFDI/rest/cliente/listar/' + query,
										async : false
									});
									data = $.parseJSON(response.responseText);
									$.each(data, function(i, object) {
										object.value = object.name.substring(0, object.name.indexOf('-')).trim();
										map[object.name] = object;
										objects.push(object.name);
									});
									process(objects);
								},
								updater : function(item) {
									response = $.ajax({
										url : '/CFDI/rest/cliente/find/'
												+ map[item].id,
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
									// $('#razonSocial').val($('#razonSocial').val().substring(0, $('#razonSocial').val().indexOf('-')).trim());
									return item;
								}
							});

					$('#clave')
							.typeahead(
									{
										source : function(query, process) {
											map = {};
											objects = [];
											response = $
													.ajax({
														url : '/CFDI/rest/productoServicio/listar',
														async : false
													});
											data = $
													.parseJSON(response.responseText);
											$.each(data, function(i, object) {
												map[object.clave] = object;
												objects.push(object.clave);
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
											if ($("#valorUnitario").val() == "")
											$("#valorUnitario").val(productoServicio.precioUnitario);
											$("#concepto").val(productoServicio.nombre);
											// $("#iva").val(productoServicio.tasaIva);
											if ($("#descuento").val() == "") $("#descuento").val("");
										        if ($("#ieps").val() == "") $("#ieps").val("");
											if ($('#cantidad').val() == "") $("#cantidad").val("1");
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
							// $("#iva").val(productoServicio.tasaIva);
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
					
					
					$.validator.addMethod("alfanumerico", 
							
							function(value,
							element, regexp) {
						var re = new RegExp(regexp);
						return this.optional(element) || re.test(value);
					}, "Solo caracteres alfanumericos.");
					

					$('#comprobanteForm')
							.validate(
									{
										rules : {
											rfc : {
												required : true,
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z,Ã‘,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
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
												numero : "^[0-9]+(\.([0-9]{1,6})?)?$"
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
											}
										}
									});

					$('#moneda').change(
							function() {
								$('#tipoCambio').val(
										$('#moneda :selected').attr(
												'tipoCambio'));
							});

				});
