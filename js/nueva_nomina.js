 var numeroDecimales = 2;
 var percepciones = new Array();
 var deducciones  = new Array();
 var horasExtras   = new Array();
 var listaMetodoPago = "";

 var val;
 var fields = new Array();
 
 Date.daysBetween = function( date1, date2 ) {
  //Get 1 day in milliseconds
  var one_day=1000*60*60*24;

  // Convert both dates to milliseconds
  var date1_ms = date1; // .getTime();
  var date2_ms = date2; // .getTime();

  // Calculate the difference in milliseconds
  var difference_ms = date2_ms - date1_ms;
    
  // Convert back to days and return
  return Math.round(difference_ms/one_day); 
}

 function limpiarObjecto(propiedades, obj) {
$.each(propiedades, function(key, value) {
	if (obj[value] == "") {
		delete obj[value];
	}
});
}

 function getData1(percepciones) {
  var percepciones1 = new Array();
  $.each(percepciones,function(key, value) {
   if (value.eliminado) return;
   var percepcion = new Object;
   percepcion.percepcion = value;
   percepciones1.push(percepcion);
  });
  return percepciones1;
 }
 
 function getData2(deducciones) {
  var deducciones1 = new Array();
  $.each(deducciones,function(key, value) {
   if (value.eliminado) return;
   var deduccion = new Object;
   deduccion.deduccion = value;
   deducciones1.push(deduccion);
  });
  return deducciones1;
 }

  function agregarMetodoPago() {
    listaMetodoPago = listaMetodoPago.concat($('select[name=metodoDePago]').val()).concat(",");
    alert("Metodo de Pago agregado");
}


 function comprobanteToJSON() {
 /*
  if (parseFloat($('input[name=total]').val() < 1) {
   alert("El total no puede ser cero, ni negativo.");
   return "";
*/
  


  
  

  
  var comprobante = $('.comprobante').serializeObject();
  if (listaMetodoPago.indexOf(",") > 0){
    comprobante.metodoDePago = listaMetodoPago.substring(0, listaMetodoPago.length-1);  
  }


	var propiedades = new Array("serie", "folio", "descuento", "ieps", "numCtaPago","tipoCambio");
	limpiarObjecto(propiedades, comprobante);
	
	comprobante.emisor = $('.emisor').serializeObject();
	comprobante.emisor.domicilioFiscal = $('.emisorDomicilio').serializeObject();
	propiedades = new Array("colonia", "localidad", "noExterior", "noInterior");
	limpiarObjecto(propiedades, comprobante.emisor.domicilioFiscal);
	
	var regimenFiscal = new Array();
	var regimen = new Object();
	regimen.regimen = $('#regimen option:selected').val();
	regimenFiscal.push(regimen);
	
	comprobante.emisor.regimenFiscal = regimenFiscal;
	
	comprobante.receptor = $('.receptor').serializeObject();
	// propiedades = new Array("calle", "colonia", "localidad", "municipio", "codigoPostal", "noExterior", "noInterior");
	// limpiarObjecto(propiedades, comprobante.receptor.domicilio);


  comprobante.complemento = new Object();
  comprobante.complemento.nomina = $('.nomina').serializeObject();

  var propiedades = new Array("numSeguridadSocial", "clabe", "departamento", "puesto", "tipoContrato", "tipoJornada", 
				"fechaInicioRelLaboral", "antiguedad", "salarioBaseCotApor", "salarioDiarioIntegrado", "riesgoPuesto");
  limpiarObjecto(propiedades, comprobante.complemento.nomina);




  comprobante.complemento.nomina.percepciones = new Object();
  comprobante.complemento.nomina.percepciones.percepciones = new Array();


   if ($('#registroPatronal').val() != "") {
     comprobante.complemento.nomina.registroPatronal = $('#registroPatronal').val();
   } 
   if ($('#numSeguridadSocial').val() != "") {
     comprobante.complemento.nomina.numSeguridadSocial = $('#numSeguridadSocial').val();
   } 
   if ($('#clabe').val() != "") {
     comprobante.complemento.nomina.clabe = $('#clabe').val();
   } 


  $.each(percepciones,function(key, value) {
	   if (value.eliminado) return;
	   comprobante.complemento.nomina.percepciones.percepciones.push(value);
	});

	
	comprobante.complemento.nomina.percepciones.totalGravado = redondearValor2(parseFloat($('input[name=totalGravado].percepciones').val()));
	comprobante.complemento.nomina.percepciones.totalExento  = redondearValor2(parseFloat($('input[name=totalExento].percepciones').val()));

  if (deducciones.length > 0) { 
  	if (parseFloat(comprobante.descuento) >= 0 ) {
	  	comprobante.complemento.nomina.deducciones = new Object();
	  	comprobante.complemento.nomina.deducciones.deducciones = new Array();
		  

	  	$.each(deducciones, function(key, value) {
			   if (value.eliminado) return;
			   comprobante.complemento.nomina.deducciones.deducciones.push(value);
	  	});
	  	comprobante.complemento.nomina.deducciones.totalGravado = redondearValor2(parseFloat($('input[name=totalGravado].deducciones').val()));
	  	comprobante.complemento.nomina.deducciones.totalExento  = redondearValor2(parseFloat($('input[name=totalExento].deducciones').val()));
  	}
  }
 
	if (horasExtras.length > 0) {
		comprobante.complemento.nomina.horasExtras = new Object();
		comprobante.complemento.nomina.horasExtras.horasExtra = new Array();
 		$.each(horasExtras, function(key, value) {
			comprobante.complemento.nomina.horasExtras.horasExtra.push(value);
		})
//		comprobante.complemento.nomina.horasExtras.horasExtra = horasExtras;
        }

 	comprobante.conceptos = new Object();
	comprobante.conceptos.conceptos = new Array();

	comprobante.impuestos = new Object();
	comprobante.impuestos.totalISRRetenido = parseFloat($('input[name=totalISRRetenido]').val());
	comprobante.impuestos.retenidos = new Object();
	comprobante.impuestos.retenidos.retenciones = new Array();
	var retencion = new Object();
	retencion.impuesto = "ISR";
	retencion.importe = parseFloat($('input[name=totalISRRetenido]').val());
	comprobante.impuestos.retenidos.retenciones.push(retencion);

  var concepto = $('.concepto').serializeObject();
  comprobante.conceptos.conceptos.push(concepto);
  
  return JSON.stringify(comprobante, null, " ");
  
 }

 function eliminarData(tipo, id) {
	 var arreglo;
		switch(tipo) {
 		case "percepciones" : arreglo = percepciones; break;
 		case "deducciones"  : arreglo = deducciones; break;
		}
 	arreglo[id].eliminado = true;
 	graficarPercepciones(arreglo, tipo);
	}
	

function graficarHorasExtra(campos, data, nombreTabla) {
	var row = "";
	$.each(data, function (key, fila) {
	  row += "<tr>";
	  $.each(campos, function (key, value) {
	   row += "<td>" + fila[value] + "</td>"   
	 })
	  row += "</tr>";
	})

	$('#' + nombreTabla + " tbody").html(row);

}

	function graficarPercepciones(percepciones, tipoGrafica) {
 			var row = "";
 			var fields1 = fields[tipoGrafica];
 		 var totalExento = 0;
 		 var totalGravado = 0;
 		 var totalISR = 0;
 			$.each(percepciones, function(key, value) {
  			 if (value.eliminado) return;   			 
 					row += '<tr>';
 					
 					if (tipoGrafica == "deducciones" && value.tipoDeduccion == "002") {
  					totalISR += parseFloat(value.importeExento) + parseFloat(value.importeGravado);
 					}
      
      totalExento  += parseFloat(value.importeExento);
      totalGravado += parseFloat(value.importeGravado);
 					

 				$.each(fields1,function(key1, value1) {
 					row += '<td>' + value[value1]  + '</td>';								
     });
     row += '<td><div onclick="eliminarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'
     //row += '<td><div onclick="editarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'

 				row += '</tr>';
 		 });
    $("#tabla-" + tipoGrafica + " tbody").html(row);
    var item = '.' + tipoGrafica.substr(0, tipoGrafica.length - 2);
    $(item + ' input[name=totalExento]') .val(redondearValor2(parseFloat(totalExento)));
    $(item + ' input[name=totalGravado]').val(redondearValor2(parseFloat(totalGravado)));
    
    if(tipoGrafica == "percepciones") {
      var subtotal = totalExento + totalGravado;
      subtotal = redondearValor2(parseFloat(subtotal));
      $('input[name=importe]').val(subtotal)
      $('input[name=valorUnitario]').val(subtotal);
      $('input[name=subTotal]').val(subtotal);
    } else {
      var subtotal = (totalExento + totalGravado) - totalISR;
      $('input[name=descuento]').val(redondearValor2(parseFloat(subtotal)));
      $('input[name=totalISRRetenido]').val(redondearValor2(parseFloat(totalISR)));
    }
    
    var total = parseFloat($('input[name=subTotal]').val()) - (parseFloat($('input[name=descuento]').val()) + parseFloat($('input[name=totalISRRetenido]').val()));
    $('input[name=total]').val(redondearValor2(parseFloat(total)));

 }

$(document).ready(function() {

$('#razonSocial').autocomplete({
source: function( request, response ) {
	var term = request.term;
	$.ajax({
		url: '/CFDI/empleado/find/' + term,
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
		url : '/CFDI/empleado/findID/' +  ui.item.id,
		async : false
	});
	var empleado = $.parseJSON(response.responseText);
	$('#rfc').val(empleado.rfc);
	$('#curp').val(empleado.curp);
	$('#numEmpleado').val(empleado.numEmpleado);
	$('#tiporegimen').val(empleado.tipoRegimen);
	$('#clabe').val(empleado.clabe);
	$('#banco').val(empleado.banco);
	$('#numSeguridadSocial').val(empleado.numSeguridadSocial);
	$('#departamento').val(empleado.departamento);
	$('#puesto').val(empleado.puesto);
	$('#tipoContrato').val(empleado.tipoContrato);
	$('#tipoJornada').val(empleado.tipoJornada);
	$('#fechaInicioRelLaboral').val(empleado.fechaInicioRelLaboral);
	$('#antiguedad').val(empleado.antiguedad);
	$('#salarioBaseCotApor').val(empleado.salarioBaseCotApor);
	$('#salarioDiarioIntegrado').val(empleado.salarioDiarioIntegrado);
	$('#riesgoPuesto').val(empleado.riesgoPuesto);
	$('#periodicidadPago').val(empleado.periodicidadPago);
	$('#numDiasPagados').val(empleado.numDiasPagados);
  $('#email').val(empleado.email);


	

	
},
open: function() {
	$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
},
close: function() {
	$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
}
});


$('#rfc').change(function() {
						$(this).val($(this).val().toUpperCase());
						$(this).val($(this).val().replace(' ', ''));
						$(this).val($(this).val().replace('-', ''));
					});

$('#btnAgregarMetodoPago').click(function() {
						agregarMetodoPago();
						return false;
					});

 $('#agregarHorasExtra').click(function() {

   var hE = $('.horasExtra').serializeObject();
   if (hE.Dias == "") {
	alert("El número de días es obligatorio");
	return;
   }
   if (hE.HorasExtra == "") {
	alert("El número de horas es obligatorio");
	return;
   }
   if (hE.ImportePagado == "") {
	alert("El importe pagado es obligatorio");
	return;
   }
   horasExtras.push(hE);
   var campos = new Array("tipoHoras", "dias", "numeroHorasExtra", "importePagado");
   graficarHorasExtra(campos, horasExtras, "tabla-horasExtra");

 });


  /* iniciamos valores */
 fields['percepciones'] = new Array('clave', 'tipoPercepcion', 'concepto','importeGravado', 'importeExento');
 fields['deducciones'] = new Array('clave', 'tipoDeduccion', 'concepto','importeGravado', 'importeExento');

 $('#antiguedad').addClass("span1");
 $('#antiguedad').wrap('<div class="input-prepend input-append"></div>');
 $('#antiguedad').parent().append('<span class="add-on"> Semanas</span>')
 $('#antiguedad').tooltip();
 $('#antiguedad').attr('title', 'Numero de semanas de antiguedad.');

 $('#btnTipoComprobante').change(function() {
  top.location.href = $('#btnTipoComprobante').val();
 });

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

	$('.numero').keyup(function () {
  if (this.value != this.value.replace(/[^0-9\.]/g, '')) {
     this.value = this.value.replace(/[^0-9\.]/g, '');
  }
 });


 $('select.concepto').change(function() {
  $('#concepto' + $(this).attr('module')).val($(this).children(':selected').text());
 });
					
	$('.add').click(function() {
	 var modulo =  '.' + $(this).attr('module');
	 var valido = true;
	 $.each($(modulo + ' .obligatorio'), function(key, value) {
 	  if (!valido) return;
 	  if (value.value == "") {
 	   alert(value.name + " es obligatorio");
 	   valido = false;
  	 return;
 	  }
 	 });
 	 if (!valido) return;
	 var percepcion = $(modulo +' .input').serializeObject();
              if (percepcion.clave.length != 3) {
			alert('La clave debe ser de tres digitos'); 
			retur;
		}
		percepcion.eliminado = false;
		var arreglo = "", tipoC = "";
		switch($(this).attr('module')) {
 		 case "percepcion" : arreglo = percepciones;
 		                tipoC = "percepciones";
 		                break;
 		 case "deduccion" : arreglo = deducciones;
 		                tipoC = "deducciones";
 		                break;
		}
		arreglo[percepcion.id] = percepcion;
  $(modulo + ' .idClave').val(arreglo.length);
	 graficarPercepciones(arreglo, tipoC);
	});
	
	$('.fecha').datepicker({	format: 'yyyy-mm-dd', autoClose: true	});

 
 var now = new Date();
 $("#fechaPago").datepicker('setValue', now);	

 if (now.getDay() < 15) {
  nowTmp = new Date(now.getFullYear(), now.getMonth(), 1); 
 } else {
  nowTmp = new Date(now.getYear(), now.getMonth(), 15);
 }
 $("#fechaInicialPago").datepicker('setValue', nowTmp);	
 if (now.getDay() < 15) {
  nowTmp = new Date(now.getFullYear(), now.getMonth(), 15); 
 } else {
  nowTmp = new Date(now.getYear(), now.getMonth(), 30);
 }
 $("#fechaFinalPago").datepicker('setValue', nowTmp);	

 $('#formVistaPrevia, #formGenerarComprobante').submit(
			function() {
				if (!validarNomina()) {
					return false;
				}
				
				var strComprobante = comprobanteToJSON();
				$('.strComprobante').val(strComprobante);
			});

	// $('#fecha').val(dateToYMD(new Date()));
	$('#fecha').attr('readonly', 'readonly');


	//$('#accordion2').css('display', 'none');
	//$('#accordion2 .nomina').removeClass('nomina');
	
	getFolio();	
	
	$('#periodicidadPago').typeahead({ source : ['diario', ' semanal', ' quincenal', ' catorcenal mensual', ' bimestral', ' unidad de obra', ' comisión', ' precio alzado'] });
 
});

function ponerFecha(selector, date) {
 $(selector).val(date.getFullYear() + '-' + date.getMonth() + "-" + date.getDate()); 
}

function validarNomina() {
  var valido = true;
  if ($('#metodoDePago').val() == "default") {
		alert("Debe seleccionar el metodo de pago.");
		$('#metodoDePago').focus();
    valido = false;
		return valido;
	} 
  $.each($('.obligatorio.nomina'), function(key, val) {
    if (valido && val.value == "") {
	valido = false;
        alert('El campo ' + val.getAttribute('id') + ' es obligatorio.')
     }
  });
  return valido;
}


function getFolio() {
	var serie = $('#serie').val();
	$.get('/CFDI/rest/comprobante/folio/' + serie, function(response) {
		$('#folio').val(response);
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
}
