 var numeroDecimales = 2;
 var subContrataciones = new Array();
 var percepciones = new Array();
 var deducciones  = new Array();
 var horasExtras   = new Array();
 var listaMetodoPago = "";
 var accionesOTitulos = "";
 var jubilacionPensionRetiro = "";
 var separacionIndemnizacion = "";
 var otrosPagos  = new Array();
 var subsidioAlEmpleo = "";
 var compensacionSaldosAFavor = "";
 var incapacidades  = new Array();
 var cfdiRelacionadoArr = new Array();  

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
    if ($('#metodoDePago').val() == "default") {
      alert("Debe seleccionar el metodo de pago.");
    }
    else{
      listaMetodoPago = listaMetodoPago.concat($('select[name=metodoDePago]').val()).concat(",");
      alert("Metodo de Pago agregado");
    }
}


 function comprobanteToJSON() {
  
  var comprobante = $('.comprobante').serializeObject();
  
  if ($('input[name=totalDeducciones]').val() == "0.0")
    comprobante.descuento = null;

  if ($('#confirmacion').val() == ""){
    comprobante.confirmacion = null;
  }
  else{
    comprobante.confirmacion = $('#confirmacion').val();
  }

  if (cfdiRelacionadoArr.length > 0 ) {
		comprobante.cfdiRelacionados = new Object();
    comprobante.cfdiRelacionados.tipoRelacion = $('#tipoRelacion').val();    
    comprobante.cfdiRelacionados.cfdiRelacionado = cfdiRelacionadoArr;
	}

	var propiedades = new Array("serie", "folio", "descuento", "ieps", "numCtaPago","tipoCambio");
	limpiarObjecto(propiedades, comprobante);
	
	comprobante.emisor = $('.emisor').serializeObject();
	
	comprobante.emisor.regimenFiscal = $('#regimen option:selected').val();
	
	comprobante.receptor = $('.receptor').serializeObject();
	// propiedades = new Array("calle", "colonia", "localidad", "municipio", "codigoPostal", "noExterior", "noInterior");
	// limpiarObjecto(propiedades, comprobante.receptor.domicilio);


  comprobante.complemento = new Object();
  comprobante.complemento.nomina12 = $('.nomina').serializeObject();
  comprobante.complemento.nomina12.version = "1.2";

  var propiedades = new Array("numSeguridadSocial", "clabe", "departamento", "puesto", "tipoContrato", "tipoJornada", 
				"fechaInicioRelLaboral", "antiguedad", "salarioBaseCotApor", "salarioDiarioIntegrado", "riesgoPuesto");
  limpiarObjecto(propiedades, comprobante.complemento.nomina12);

  //VALIDACIONES EMISOR
  if (($('input[name=curpEmisor]').val() != "")||($('input[name=registroPatronal]').val() != "")||($('input[name=rfcPatronOrigen]').val() != "")){
    comprobante.complemento.nomina12.emisor = new Object();
    comprobante.complemento.nomina12.emisor = $('.nominaEmisor').serializeObject();
    if ($('input[name=curpEmisor]').val() == ""){
      comprobante.complemento.nomina12.emisor.curp = null;
    }
    else{
      comprobante.complemento.nomina12.emisor.curp = $('input[name=curpEmisor]').val();
    }
    if ($('input[name=registroPatronal]').val() == ""){
      comprobante.complemento.nomina12.emisor.registroPatronal = null;
    }
    else{
      comprobante.complemento.nomina12.emisor.registroPatronal = $('input[name=registroPatronal]').val();
    }
    if ($('input[name=rfcPatronOrigen]').val() == ""){
      comprobante.complemento.nomina12.emisor.rfcPatronOrigen = null;
    }
    else{
      comprobante.complemento.nomina12.emisor.rfcPatronOrigen = $('input[name=rfcPatronOrigen]').val();
    }
    if ($('select[name=origenRecurso]').val() != "default"){
      comprobante.complemento.nomina12.emisor.entidadSNCF = new Object();
      comprobante.complemento.nomina12.emisor.entidadSNCF = $('.entidadSNCF').serializeObject();
      if ($('input[name=montoRecursoPropio]').val() == ""){
          comprobante.complemento.nomina12.emisor.entidadSNCF.montoRecursoPropio = null;
      }
      else{
          comprobante.complemento.nomina12.emisor.entidadSNCF.montoRecursoPropio = $('input[name=montoRecursoPropio]').val();
      }
    }  
  }
  
  //VALIDACIONES RECEPTOR
  comprobante.complemento.nomina12.receptor = new Object();
  comprobante.complemento.nomina12.receptor = $('.nominaReceptor').serializeObject();
  if ($('input[name=numSeguridadSocial]').val() == ""){
      comprobante.complemento.nomina12.receptor.numSeguridadSocial = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.numSeguridadSocial = $('input[name=numSeguridadSocial]').val();
  }
  if ($('input[name=fechaInicioRelLaboral]').val() == ""){
      comprobante.complemento.nomina12.receptor.fechaInicioRelLaboral = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.fechaInicioRelLaboral = $('input[name=fechaInicioRelLaboral]').val();
  }
  if ($('input[name=antiguedad]').val() == ""){
      comprobante.complemento.nomina12.receptor.antiguedad = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.antiguedad = $('input[name=antiguedad]').val();
  }
  if ($('select[name=sindicalizado]').val() == ""){
      comprobante.complemento.nomina12.receptor.sindicalizado = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.sindicalizado = $('select[name=sindicalizado]').val();
  }
  if ($('select[name=tipoJornada]').val() == ""){
      comprobante.complemento.nomina12.receptor.tipoJornada = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.tipoJornada = $('select[name=tipoJornada]').val();
  }
  if ($('input[name=departamento]').val() == ""){
      comprobante.complemento.nomina12.receptor.departamento = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.departamento = $('input[name=departamento]').val();
  }
  if ($('input[name=puesto]').val() == ""){
      comprobante.complemento.nomina12.receptor.puesto = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.puesto = $('input[name=puesto]').val();
  }
  if ($('select[name=riesgoPuesto]').val() == ""){
      comprobante.complemento.nomina12.receptor.riesgoPuesto = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.riesgoPuesto = $('select[name=riesgoPuesto]').val();
  }
  if ($('select[name=banco]').val() == ""){
      comprobante.complemento.nomina12.receptor.banco = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.banco = $('select[name=banco]').val();
  }
  if ($('input[name=cuentaBancaria]').val() == ""){
      comprobante.complemento.nomina12.receptor.cuentaBancaria = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.cuentaBancaria = $('input[name=cuentaBancaria]').val();
  }
  if ($('input[name=salarioBaseCotApor]').val() == ""){
      comprobante.complemento.nomina12.receptor.salarioBaseCotApor = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.salarioBaseCotApor = $('input[name=salarioBaseCotApor]').val();
  }
  if ($('input[name=salarioDiarioIntegrado]').val() == ""){
      comprobante.complemento.nomina12.receptor.salarioDiarioIntegrado = null;
  }
  else{
    comprobante.complemento.nomina12.receptor.salarioDiarioIntegrado = $('input[name=salarioDiarioIntegrado]').val();
  }
  if (subContrataciones.length > 0){
      comprobante.complemento.nomina12.receptor.subContratacion = new Object();
      comprobante.complemento.nomina12.receptor.subContratacion = subContrataciones;
  }

  //VALIDACIONES PERCEPCIONES
  if (percepciones.length > 0) {
      comprobante.complemento.nomina12.percepciones = new Object();
      comprobante.complemento.nomina12.percepciones.percepcion = new Array();

      $.each(percepciones,function(key, value) {
    	   if (value.eliminado) return;
    	   comprobante.complemento.nomina12.percepciones.percepcion.push(value);
    	});

      if (jubilacionPensionRetiro != ""){
        comprobante.complemento.nomina12.percepciones.jubilacionPensionRetiro = new Object();
        comprobante.complemento.nomina12.percepciones.jubilacionPensionRetiro = jubilacionPensionRetiro;
      }
      if (separacionIndemnizacion != ""){
        comprobante.complemento.nomina12.percepciones.separacionIndemnizacion = new Object();
        comprobante.complemento.nomina12.percepciones.separacionIndemnizacion = separacionIndemnizacion;
      }
      if (eval($('input[name=totalSueldos]').val()) > 0){
        comprobante.complemento.nomina12.percepciones.totalSueldos = $('input[name=totalSueldos]').val();
      }
      if (eval($('input[name=totalSeparacionIndemnizacion]').val()) > 0){
        comprobante.complemento.nomina12.percepciones.totalSeparacionIndemnizacion = $('input[name=totalSeparacionIndemnizacion]').val();
      }
      if (eval($('input[name=totalJubilacionPensionRetiro]').val()) > 0){
        comprobante.complemento.nomina12.percepciones.totalJubilacionPensionRetiro = $('input[name=totalJubilacionPensionRetiro]').val();
      }
      
      
     	comprobante.complemento.nomina12.percepciones.totalGravado = redondearValor2(parseFloat($('input[name=totalGravado]').val()));
    	comprobante.complemento.nomina12.percepciones.totalExento  = redondearValor2(parseFloat($('input[name=totalExento]').val()));

  }
  else{
    comprobante.complemento.nomina12.totalPercepciones = null;
  }

  //VALIDACIONES DEDUCCIONES
  if (deducciones.length > 0) { 
	  	comprobante.complemento.nomina12.deducciones = new Object();
	  	comprobante.complemento.nomina12.deducciones.deduccion = new Array();
		  

	  	$.each(deducciones, function(key, value) {
			   if (value.eliminado) return;
			   comprobante.complemento.nomina12.deducciones.deduccion.push(value);
	  	});

      if (eval($('input[name=totalOtrasDeducciones]').val()) > 0){
        comprobante.complemento.nomina12.deducciones.totalOtrasDeducciones = redondearValor2(parseFloat($('input[name=totalOtrasDeducciones]').val()));
      }

      if (eval($('input[name=totalImpuestosRetenidos]').val()) > 0){
  	  	comprobante.complemento.nomina12.deducciones.totalImpuestosRetenidos = redondearValor2(parseFloat($('input[name=totalImpuestosRetenidos]').val()));
      }

  }
  else{
    comprobante.complemento.nomina12.totalDeducciones = null;
  }

  //VALIDACIONES OTROS PAGOS
  if (otrosPagos.length > 0) {
      comprobante.complemento.nomina12.otrosPagos = new Object();
      comprobante.complemento.nomina12.otrosPagos.otroPago = new Array();

      $.each(otrosPagos,function(key, value) {
    	   if (value.eliminado) return;
    	   comprobante.complemento.nomina12.otrosPagos.otroPago.push(value);
    	});

  }
  else{
    comprobante.complemento.nomina12.totalOtrosPagos = null;
  }

  //VALIDACIONES INCAPACIDADES
  if (incapacidades.length > 0) {
      comprobante.complemento.nomina12.incapacidades = new Object();
      comprobante.complemento.nomina12.incapacidades.incapacidad = new Array();

      $.each(incapacidades,function(key, value) {
    	   if (value.eliminado) return;
    	   comprobante.complemento.nomina12.incapacidades.incapacidad.push(value);
    	});

  }
 
 	comprobante.conceptos = new Object();
	comprobante.conceptos.conceptos = new Array();

  var concepto = $('.concepto').serializeObject();
  if ($('input[name=totalDeducciones]').val() != "0.0"){
    concepto.descuento = $('input[name=totalDeducciones]').val();
  }
  comprobante.conceptos.conceptos.push(concepto);
  
  return JSON.stringify(comprobante, null, " ");
  
 }

 function eliminarData(tipo, id) {
	 var arreglo;
		switch(tipo) {
 		case "percepciones" : arreglo = percepciones; break;
    case "deducciones"  : arreglo = deducciones; break;
    case "otrosPagos"  : arreglo = otrosPagos; break;
    case "incapacidades"  : arreglo = incapacidades; break;
    case "horasExtra"  : arreglo = horasExtra; break;
		}
  arreglo[id].eliminado = true;
 	switch(tipo) {
 		case "percepciones" : graficarPercepciones(arreglo, tipo); break;
 		case "deducciones"  : graficarDeducciones(arreglo, tipo); break;
 		case "otrosPagos"  : graficarOtrosPagos(arreglo, tipo); break;
 		case "incapacidades"  : graficarIncapacidades(arreglo, tipo); break;
 		case "horasExtra"  : graficarHorasExtra(arreglo, tipo); break;
		}
	}
	

function graficarHorasExtra(campos, data, nombreTabla) {
	var row = "";
  tipoGrafica = "horasExtra";
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
 		 var totalSueldos = 0;
     var totalSeparacionIndemnizacion = 0;
     var totalJubilacionPensionRetiro = 0;
 		 var totalISR = 0;
 			$.each(percepciones, function(key, value) {
  			 if (value.eliminado){
            $('input[name=totalSueldos]').val(totalSueldos);
            $('input[name=totalSeparacionIndemnizacion]').val(totalSeparacionIndemnizacion);
            $('input[name=totalJubilacionPensionRetiro]').val(totalJubilacionPensionRetiro);
            $('input[name=totalGravado]').val(totalGravado);
            $('input[name=totalExento]').val(totalExento);
            return; 
          }
 				 row += '<tr>';
         if ((value.tipoPercepcion == "022")||(value.tipoPercepcion == "023")||(value.tipoPercepcion == "025")){
            totalSeparacionIndemnizacion = totalSeparacionIndemnizacion + parseFloat(value.importeGravado) + parseFloat(value.importeExento);    
            $('input[name=totalSeparacionIndemnizacion]').val(redondearValor2(totalSeparacionIndemnizacion));
          } 
 			
         if ((value.tipoPercepcion != "022")&&(value.tipoPercepcion != "023")&&(value.tipoPercepcion != "025")&&
            (value.tipoPercepcion != "039")&&(value.tipoPercepcion != "044")){
              totalSueldos = totalSueldos + parseFloat(value.importeGravado) + parseFloat(value.importeExento);    
              $('input[name=totalSueldos]').val(redondearValor2(totalSueldos));
          }

         if ((value.tipoPercepcion == "039")||(value.tipoPercepcion == "044")){
            totalJubilacionPensionRetiro = totalJubilacionPensionRetiro + parseFloat(value.importeGravado) + parseFloat(value.importeExento);    
            $('input[name=totalJubilacionPensionRetiro]').val(redondearValor2(totalJubilacionPensionRetiro));
          }		

         totalExento = totalExento + parseFloat(value.importeExento);    
         $('input[name=totalExento]').val(redondearValor2(totalExento));
         totalGravado = totalGravado + parseFloat(value.importeGravado);    
         $('input[name=totalGravado]').val(redondearValor2(totalGravado));

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
    
      var subtotal = totalExento + totalGravado + eval($('input[name=totalOtrosPagos]').val());
      subtotal = redondearValor2(parseFloat(subtotal)).toFixed(2);
      $('input[name=importe]').val(subtotal)
      $('input[name=valorUnitario]').val(subtotal);
      $('input[name=subTotal]').val(subtotal);
      
    
      var total = parseFloat($('input[name=subTotal]').val()) - parseFloat($('input[name=totalDeducciones]').val());
      $('input[name=total]').val(redondearValor2(parseFloat(total)));

      $('select[name=tipoPercepcion]').val('');    
      $('input[name=concepto]').val('');
      $('input[name=clave]').val('');
      $('input[name=importeGravado]').val('');
      $('input[name=importeExento]').val('');
      $('input[name=valorMercado]').val('');
      $('input[name=precioAlOtorgarse]').val('');
      $('input[name=totalUnaExhibicion]').val('');    
      $('input[name=totalParcialidad]').val('');
      $('input[name=montoDiario]').val('');
      $('input[name=ingresoAcumulable]').val('');
      $('input[name=ingresoNoAcumulable]').val('');
      $('input[name=totalPagado]').val('');    
      $('input[name=numAniosServicio]').val('');
      $('input[name=ultimoSueldoMensOrd]').val('');    
      $('input[name=ingresoAcumulableSeparacionIndemnizacion]').val('');    
      $('input[name=ingresoNoAcumulableSeparacionIndemnizacion]').val('');    
      
      $('input[name=totalPercepciones]').val(redondearValor2(totalSueldos + totalSeparacionIndemnizacion + totalJubilacionPensionRetiro));
    
  }

  function graficarDeducciones(deducciones, tipoGrafica) {
 		 var row = "";
  	 var fields1 = fields[tipoGrafica];
 		 var totalOtrasDeducciones = 0;
 		 var totalImpuestosRetenidos = 0;
 			$.each(deducciones, function(key, value) {
  			 if (value.eliminado){
            $('input[name=totalOtrasDeducciones]').val(totalOtrasDeducciones);
            $('input[name=totalImpuestosRetenidos]').val(totalImpuestosRetenidos);
            return;  
         } 
         row += '<tr>';
     
         if (value.tipoDeduccion != "002") {
			  	  totalOtrasDeducciones += parseFloat(value.importeDeduccion);
            $('input[name=totalOtrasDeducciones]').val(redondearValor2(totalOtrasDeducciones));
 				 } 					
         if (value.tipoDeduccion == "002") {
  	  			totalImpuestosRetenidos += parseFloat(value.importeDeduccion) ;
            $('input[name=totalImpuestosRetenidos]').val(redondearValor2(totalImpuestosRetenidos));
	       }    			 
				 

    		 $.each(fields1,function(key1, value1) {
   					row += '<td>' + value[value1]  + '</td>';								
         });
         row += '<td><div onclick="eliminarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'
       //row += '<td><div onclick="editarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'

  			 row += '</tr>';
   		 });

      $("#tabla-" + tipoGrafica + " tbody").html(row);
      var item = '.' + tipoGrafica.substr(0, tipoGrafica.length - 2);
      
      var subtotal = totalPercepciones + totalOtrosPagos;
      subtotal = redondearValor2(parseFloat(subtotal)).toFixed(2);
      $('input[name=totalDeducciones]').val(redondearValor2(totalOtrasDeducciones + totalImpuestosRetenidos));
      $('input[name=descuento]').val($('input[name=totalDeducciones]').val());
      if ($('input[name=descuento]').val() == "0.00"){
        comprobante.descuento = null;
      }
      $('input[name=totalISRRetenido]').val(redondearValor2(parseFloat(totalImpuestosRetenidos)));
      
      
      var total = parseFloat($('input[name=subTotal]').val()) - parseFloat($('input[name=totalDeducciones]').val());
      $('input[name=total]').val(redondearValor2(parseFloat(total)));

      $('select[name=tipoDeduccion]').val('');    
      $('input[name=conceptoDeduccion]').val('');
      $('input[name=claveDeduccion]').val('');
      $('input[name=importeDeduccion]').val('');
      
 }

  function graficarOtrosPagos(otrosPagos, tipoGrafica) {
 		 var row = "";
  	 var fields1 = fields[tipoGrafica];
 		 var totalOtrosPagos = 0;
 			$.each(otrosPagos, function(key, value) {
  			 if (value.eliminado){
            $('input[name=totalOtrosPagos]').val(totalOtrosPagos);
            return;  
         } 
         row += '<tr>';
			  	  totalOtrosPagos += parseFloat(value.importeOtroPago);
    		 $.each(fields1,function(key1, value1) {
   					row += '<td>' + value[value1]  + '</td>';								
         });
         row += '<td><div onclick="eliminarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'
       //row += '<td><div onclick="editarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'

  			 row += '</tr>';
   		 });

      $("#tabla-" + tipoGrafica + " tbody").html(row);
      var item = '.' + tipoGrafica.substr(0, tipoGrafica.length - 2);
      
      $('input[name=totalOtrosPagos]').val(redondearValor2(totalOtrosPagos));

      var subtotal = eval($('input[name=totalPercepciones]').val()) + eval($('input[name=totalOtrosPagos]').val());
      subtotal = redondearValor2(parseFloat(subtotal)).toFixed(2);
      $('input[name=importe]').val(subtotal)
      $('input[name=valorUnitario]').val(subtotal);
      $('input[name=subTotal]').val(subtotal);

      var total = parseFloat($('input[name=subTotal]').val()) - parseFloat($('input[name=totalDeducciones]').val());
      $('input[name=total]').val(redondearValor2(parseFloat(total)));

      $('select[name=tipoOtroPago]').val('');    
      $('input[name=conceptoOtroPago]').val('');
      $('input[name=claveOtroPago]').val('');
      $('input[name=importeOtroPago]').val('');
      $('input[name=subsidioCausado]').val('');
      $('input[name=saldoAFavor]').val('0.0');
      $('input[name=anioCompensacionSaldosAFavor]').val('');
      $('input[name=remanenteSalFav]').val('');


 }

  function graficarIncapacidades(incapacidades, tipoGrafica) {
 		 var row = "";
  	 var fields1 = fields[tipoGrafica];
 			$.each(incapacidades, function(key, value) {
         if (value.eliminado){ 
          return;  
         } 
         row += '<tr>';
    		 $.each(fields1,function(key1, value1) {
   					row += '<td>' + value[value1]  + '</td>';								
         });
         row += '<td><div onclick="eliminarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'
       //row += '<td><div onclick="editarData(\'' + tipoGrafica + '\', ' + value['id'] +  ')"><i class="icon-remove"></i> </div></td>'

  			 row += '</tr>';
   		 });

      $("#tabla-" + tipoGrafica + " tbody").html(row);
      var item = '.' + tipoGrafica.substr(0, tipoGrafica.length - 2);
      
      $('input[name=diasIncapacidad]').val('');
      $('select[name=tipoIncapacidad]').val('');    
      $('input[name=claveOtroPago]').val('');
      $('input[name=importeMonetario]').val('');
 }

$(document).ready(function() {
// Cancelar la captura de | en los campos indicados
cancelKeyPipe("#registroPatronal");
cancelKeyPipe("#numEmpleado");
cancelKeyPipe("#departamento");
cancelKeyPipe("#puesto");
cancelKeyPipe("#clave");
cancelKeyPipe("#conceptoPercepcion");
cancelKeyPipe("#claveDeduccion");
cancelKeyPipe("#conceptoDeduccion");
cancelKeyPipe("#claveOtroPago");
cancelKeyPipe("#conceptoOtroPago");

$('#razonSocial').autocomplete({
source: function( request, response ) {
	var term = request.term;
	$.ajax({
		url: '/CFDI33/empleado/find/' + term,
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
		url : '/CFDI33/empleado/findID/' +  ui.item.id,
		async : false
	});
	var empleado = $.parseJSON(response.responseText);
	$('#rfc').val(empleado.rfc);
	$('#curpReceptor').val(empleado.curp);
	$('#numEmpleado').val(empleado.numEmpleado);
	$('#tipoRegimen').val(empleado.tipoRegimen);
	$('#cuentaBancaria').val(empleado.cuentaBancaria);
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
  $('#claveEntFed').val(empleado.claveEntFed);
  $('#sindicalizado').val(empleado.sindicalizado);
  $('#usoCFDI').val(empleado.usoCFDI);


	

	
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

 $('#agregarHorasExtra').click(function() {
   var hE = $('.horasExtra').serializeObject();
   if (hE.dias == "") {
  	alert("El N\u00EDmero de d\u00EDas es obligatorio");
	  return;
   }
   if (eval(hE.dias) < 1) {
  	alert("El Valor M\u00EDnimo para el N\u00EDmero de d\u00EDas es 1");
	  return;
   } 
   if (hE.tipoHoras == "") {
  	alert("El Tipo de Horas es obligatorio");
	  return;
   }
   if (hE.numeroHorasExtra == "") {
	  alert("El N\u00EDmero de horas es obligatorio");
	  return;
   }
   if (eval(hE.numeroHorasExtra) < 1) {
  	alert("El Valor M\u00EDnimo para las Horas Extra es 1");
	  return;
   }  
   if (hE.importePagado == "") {
	  alert("El Importe pagado es obligatorio");
	  return;
   }
   horasExtras.push(hE);

   var campos = new Array("dias", "tipoHoras", "numeroHorasExtra", "importePagado");
   graficarHorasExtra(campos, horasExtras, "tabla-horasExtra");

    $('input[name=dias]').val('');    
    $('select[name=tipoHoras]').val('');    
    $('input[name=numeroHorasExtra]').val('');
    $('input[name=importePagado]').val('');

 });


  /* iniciamos valores */
 fields['percepciones'] = new Array('tipoPercepcion', 'clave', 'concepto','importeGravado', 'importeExento');
 fields['deducciones'] = new Array('tipoDeduccion', 'claveDeduccion', 'conceptoDeduccion','importeDeduccion');
 fields['otrosPagos'] = new Array('tipoOtroPago', 'claveOtroPago', 'conceptoOtroPago','importeOtroPago');
 fields['incapacidades'] = new Array('diasIncapacidad', 'tipoIncapacidad','importeMonetario');

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

   if (modulo == ".percepcion"){ 
      if (percepcion.clave.length <  3) {
			  alert('La clave debe ser de al menos tres d\u00EDgitos'); 
  			return;
		  }

      percepcion.eliminado = false;
 		  var arreglo = "", tipoC = "";

      if (redondearValor2(parseFloat(percepcion.importeGravado) + parseFloat(percepcion.importeExento)) <= 0){
    		alert('La suma de los importes de los atributos Importe Gravado e Importe Exento debe ser mayor que cero.'); 
        return;
      }

      if ((percepcion.tipoPercepcion == "022")||(percepcion.tipoPercepcion == "023")||(percepcion.tipoPercepcion == "025")){
          if (($('input[name=totalPagado]').val() == "")||($('input[name=numAniosServicio]').val() == "")||
            ($('input[name=ultimoSueldoMensOrd]').val() == "")||($('input[name=ingresoAcumulableSeparacionIndemnizacion]').val() == "")||
            ($('input[name=ingresoNoAcumulableSeparacionIndemnizacion]').val() == ""))    {
    		      alert("Debe proporcionar todos los campos de la secci\u00F3n Separaci\u00F3n Indemnizaci\u00F3n");
    		      $('#totalPagado').focus();
    		      return ;
	        }
          if ((eval($('input[name=numAniosServicio]').val()) < 0)||(eval($('input[name=numAniosServicio]').val()) > 99)){
            alert("Los valores permitidos en el campo N\u00famero A\u00F1os Servicio deben estar en el rango 0 - 99");
            return;
          }
      }

      if ((percepcion.tipoPercepcion == "039")||(percepcion.tipoPercepcion == "044")){
          if (($('input[name=ingresoAcumulable]').val() == "")||($('input[name=ingresoNoAcumulable]').val() == ""))    {
    		      alert("Debe proporcionar al menos los campos Ingreso Acumulable e Ingreso No Acumulable de la secci\u00F3n Jubilaci\u00F3n Pensi\u00F3n Retiro");
    		      $('#ingresoAcumulable').focus();
    		      return ;
	        }
      }
      
      if (percepcion.tipoPercepcion == "039"){
        if ($('input[name=totalUnaExhibicion]').val() == "")    {
          alert("Si selecciona el Tipo de Percepcion 'Jubilaciones, pensiones o haberes de retiro en una exhibici\u00F3n', debe proporcionar el campo Total Una Exhibici\u00F3n de la secci\u00F3n Jubilaci\u00F3n Pensi\u00F3n Retiro");
    		      $('#totalUnaExhibicion').focus();
    		      return ;
    	   }   
         if (($('input[name=totalParcialidad]').val() != "")||($('input[name=montoDiario]').val() != ""))    {
          alert("Si selecciona el Tipo de Percepcion 'Jubilaciones, pensiones o haberes de retiro en una exhibici\u00F3n' No debe indicar los campos Total Parcialidad ni Monto Diario de la secci\u00F3n Jubilaci\u00F3n Pensi\u00F3n Retiro");
    		      $('#totalParcialidad').focus();
    		      return ;
    	   }    
      }

      if (percepcion.tipoPercepcion == "044"){
        if (($('input[name=totalParcialidad]').val() == "")||($('input[name=montoDiario]').val() == ""))    {
          alert("Si selecciona el Tipo de Percepcion 'Jubilaciones, pensiones o haberes de retiro en parcialidades', debe proporcionar los campos Total Parcialidad y Monto Diario de la secci\u00F3n Jubilaci\u00F3n Pensi\u00F3n Retiro");
    		  $('#totalParcialidad').focus();
    		  return ;
    	   }
        if ($('input[name=totalUnaExhibicion]').val() != "")  {
          alert("Si selecciona el Tipo de Percepcion 'Jubilaciones, pensiones o haberes de retiro en parcialidades' No debe indicar el campo Total Una Exhibici\u00F3n de la secci\u00F3n Jubilaci\u00F3n Pensi\u00F3n Retiro");
    		      $('#totalUnaExhibicion').focus();
    		      return ;
    	   }        
      }

      if (percepcion.tipoPercepcion == "045"){
        if (($('input[name=valorMercado]').val() == "")||($('input[name=precioAlOtorgarse]').val() == ""))    {
          alert("Si selecciona el Tipo de Percepcion 'Ingresos en acciones o t\u00EDtulos valor que representan bienes', debe proporcionar los campos Valor Mercado y Precio Al Otorgarse de la secci\u00F3n Acciones O T\u00EDtulos");
    		  $('#valorMercado').focus();
    		  return ;
    	   }
        if (eval($('input[name=valorMercado]').val() < 0.000001)){
        	alert("El Valor M\u00EDnimo para el campo Valor Mercado es 0.000001");
          return;      
        }
        if (eval($('input[name=precioAlOtorgarse]').val() < 0.000001)){
        	alert("El Valor M\u00EDnimo para el campo Valor Precio Al Otorgarse es 0.000001");
          return;      
        }
      }

      if (percepcion.tipoPercepcion == "019"){
        if (horasExtras.length < 1)    {
          alert("Si selecciona el Tipo de Percepcion 'Horas extra', debe agregar informaci\u00F3n de la secci\u00F3n Horas Extra");
    		  $('#dias').focus();
    		  return ;
    	   }
        else{
          percepcion.horasExtra = new Array();
          percepcion.horasExtra = horasExtras;
          horasExtras = new Array();
        }
      }

      if (($('input[name=valorMercado]').val() != "")&&($('input[name=precioAlOtorgarse]').val() != "")){
          percepcion.accionesOTitulos = new Object();
          percepcion.accionesOTitulos = $('.accionesOTitulos').serializeObject();
      }

      if (($('input[name=ingresoAcumulable]').val() != "")&&($('input[name=ingresoNoAcumulable]').val() != "")){
        jubilacionPensionRetiro = new Object();
        jubilacionPensionRetiro = $('.jubilacionPensionRetiro').serializeObject();
        if ($('input[name=totalUnaExhibicion]').val() == ""){
          jubilacionPensionRetiro.totalUnaExhibicion = null;
        }
        else{
          jubilacionPensionRetiro.totalUnaExhibicion = $('input[name=totalUnaExhibicion]').val();
        }
        if ($('input[name=totalParcialidad]').val() == ""){
          jubilacionPensionRetiro.totalParcialidad = null;
        }
        else{
          jubilacionPensionRetiro.totalParcialidad = $('input[name=totalParcialidad]').val();
        }
        if ($('input[name=montoDiario]').val() == ""){
          jubilacionPensionRetiro.montoDiario = null;
        }
        else{
          jubilacionPensionRetiro.montoDiario = $('input[name=montoDiario]').val();
        }
      }
      
      if (percepcion.tipoPercepcion == "014"){
        if (incapacidades.length < 1){
          alert("Debe agregar la informaci\u00F3n de los datos de Incapacidades");
    		  $('#diasIncapacidad').focus();
    		  return ;
    	   }
      }


      if (($('input[name=totalPagado]').val() != "")&&($('input[name=numAniosServicio]').val() != "")&&
      ($('input[name=ultimoSueldoMensOrd]').val() != "")&&($('input[name=ingresoAcumulableSeparacionIndemnizacion]').val() != "")&&
      ($('input[name=ingresoNoAcumulableSeparacionIndemnizacion]').val() != ""))  {
        separacionIndemnizacion = new Object();
        separacionIndemnizacion = $('.separacionIndemnizacion').serializeObject();
        separacionIndemnizacion.numAniosServicio = Math.round(($('input[name=numAniosServicio]').val()));
      }


		  percepcion.eliminado = false;
     }

     if (modulo == ".deduccion"){
        if (percepcion.claveDeduccion.length <  3) {
  			  alert('La clave debe ser de al menos tres d\u00EDgitos'); 
    			return;
  		  } 

        percepcion.eliminado = false;
   		  var arreglo = "", tipoC = "";

        if (percepcion.tipoDeduccion == "006"){
        if (incapacidades.length < 1){
          alert("Debe agregar la informaci\u00F3n de los datos de Incapacidades");
    		  $('#diasIncapacidad').focus();
    		  return ;
    	   }
      }
		    percepcion.eliminado = false;
     }

     if (modulo == ".otroPago"){ 
        if (percepcion.claveOtroPago.length <  3) {
			    alert('La clave debe ser de al menos tres d\u00EDgitos'); 
    			return;
		    }

        percepcion.eliminado = false;
   		  var arreglo = "", tipoC = "";

        if (percepcion.tipoOtroPago == "002"){
          if ($('input[name=subsidioCausado]').val() == "")   {
    		      alert("Debe proporcionar informaci\u00F3n de la secci\u00F3n Subsidio Al Empleo");
    		      $('#subsidioCausado').focus();
    		      return ;
	        }
          if (eval($('input[name=subsidioCausado]').val()) < eval(percepcion.importeOtroPago)){
     		      alert("El valor del campo Subsidio Causado debe ser mayor o igual que el valor del campo Importe de la Informaci\u00F3n de Otro Pago");
    		      $('#subsidioCausado').focus();
    		      return ;
          }
          if ($('input[name=subsidioCausado]').val() != ""){
            percepcion.subsidioAlEmpleo = new Object();
            percepcion.subsidioAlEmpleo = $('.subsidioAlEmpleo').serializeObject();
          }
        }
      
        if (percepcion.tipoOtroPago == "004"){
          if (($('input[name=saldoAFavor]').val() == "")||($('input[name=anioCompensacionSaldosAFavor]').val() == "")||
            ($('input[name=remanenteSalFav]').val() == "") )  {
    		      alert("Debe proporcionar informaci\u00F3n de la secci\u00F3n Compensaci\u00F3n Saldos A Favor");
    		      $('#saldoAFavor').focus();
    		      return ;
	        }
          if (eval($('input[name=anioCompensacionSaldosAFavor]').val()) < 2016){
  	        alert("El valor m\u00EDnimo para el campo A\u00F1o de la secci\u00F3n Compensaci\u00F3n Saldos A Favor es 2016");
 		        $('#anioCompensacionSaldosAFavor').focus();
		        return ;
          }        
           if (($('input[name=saldoAFavor]').val() != "")&&($('input[name=anioCompensacionSaldosAFavor]').val() != "")&&
            ($('input[name=remanenteSalFav]').val() != "")){
              $('input[name=saldoAFavor]').val(eval(percepcion.importeOtroPago) + eval($('input[name=remanenteSalFav]').val()));
              percepcion.compensacionSaldosAFavor = new Object();
              percepcion.compensacionSaldosAFavor = $('.compensacionSaldosAFavor').serializeObject();
            } 
        
        
        }

        

		    percepcion.eliminado = false;
     }  
   
     if (modulo == ".incapacidad"){ 

        percepcion.eliminado = false;
   		  var arreglo = "", tipoC = "";

        if (($('select[name=tipoPercepcion]').val() == "")&&($('select[name=tipoDeduccion]').val() == "")){
          alert("Solo puede agregar Incapacidades si selecciona el Tipo de Percepci\u00F3n Subsidios por incapacidad o la Deducci\u00F3n Descuento por incapacidad");
          $('#tipoPercepcion').focus();
	        return ;
        }
        if ($('select[name=tipoPercepcion]').val() != ""){
          if ($('input[name=importeMonetario]').val() != 
            eval(parseFloat($('input[name=importeGravado]').val()) + parseFloat($('input[name=importeExento]').val()))){
           	alert("El Importe Monetario de la Incapacidad deber ser igual a la suma del Importe Gravado mas el Importe Exento de la Percepci\u00F3n");
            return;      
          }
        }
        if ($('select[name=tipoDeduccion]').val() != ""){
          if ($('input[name=importeMonetario]').val() != $('input[name=importeDeduccion]').val()){
           	alert("El Importe Monetario de la Incapacidad deber ser igual al Importe de la Deducci\u00F3n");
            return;      
          }
        }
        
		    percepcion.eliminado = false;
     } 
      
		var arreglo = "", tipoC = "";
		switch($(this).attr('module')) {
 		 case "percepcion" : arreglo = percepciones;
 		                tipoC = "percepciones";
                    arreglo[percepcion.id] = percepcion;
                    $(modulo + ' .idClave').val(arreglo.length);
                  	graficarPercepciones(arreglo, tipoC);
 		                break;
 		 case "deduccion" : arreglo = deducciones;
 		                tipoC = "deducciones";
                    arreglo[percepcion.id] = percepcion;
                    $(modulo + ' .idClave').val(arreglo.length);
                	  graficarDeducciones(arreglo, tipoC);
 		                break;
     case "otroPago" : arreglo = otrosPagos;
 		                tipoC = "otrosPagos";
                    arreglo[percepcion.id] = percepcion;
                    $(modulo + ' .idClave').val(arreglo.length);
                	  graficarOtrosPagos(arreglo, tipoC);
 		                break;
     case "incapacidad" : arreglo = incapacidades;
 		                tipoC = "incapacidades";
                    arreglo[percepcion.id] = percepcion;
                    $(modulo + ' .idClave').val(arreglo.length);
                	  graficarIncapacidades(arreglo, tipoC);
 		                break;
		}
		


	});

$('#btnAgregarUUID').click(function(){
  if (validaUUID() == true){
    if ($('#tipoRelacion').val() == ""){
      alert("Debe indicar el Tipo de Relación.");
      $('#tipoRelacion').focus();
      return false;
    }
    else{
      var cfdiRelacionado = new Object();
      cfdiRelacionado.uuid = $('#uuid').val();
      cfdiRelacionadoArr.push(cfdiRelacionado);
      alert("UUID Agregado.");
      graficarCFDIRelacionado();
      $('input[name=uuid]').val('');
      $('#uuid').focus();
    }
  }
})

	
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

 $('#formVistaPrevia, #formGenerarComprobante').unbind('submit').bind('submit',
			function() {
				if (!validarNomina()) {
					return false;
				}
				
				var strComprobante = comprobanteToJSON();
        if ($(this).attr('id') == "formGenerarComprobante")
								$('#generarComprobante').attr('disabled', 'disabled');
				$('.strComprobante').val(strComprobante);
			});

	$('#fecha').attr('readonly', 'readonly');


	//$('#accordion2').css('display', 'none');
	//$('#accordion2 .nomina').removeClass('nomina');
	
  $.validator.addMethod("regexCurp", function(value, element,
			    regexp) {
    		    var re = new RegExp(regexp);
		      return this.optional(element) || re.test(value);
	        }, "Ingrese un CURP v\u00e1lido.");

  $.validator.addMethod("numeroDec", function(value, element,	regexp) {
        		var re = new RegExp(regexp);
        		return this.optional(element) || re.test(value);
          	}, "Ingrese un n\u00famero Decimal v\u00e1lido.");

  $.validator.addMethod("valueNotEquals", function(value, element, arg){
		  return arg != value;
		 }, "Debe seleccionar una opci\u00F3n.");

  $.validator.addMethod(
	        "regex",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "Ingrese un RFC v\u00e1lido."
	);

  $.validator.addMethod(
	        "numero",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "Ingrese un n\u00famero v\u00e1lido."
	);

	$.validator.addMethod(
	        "antig",
	        function(value, element, regexp) {
	            var re = new RegExp(regexp);
	            return this.optional(element) || re.test(value);
	        },
	        "El valor no corresponde con el patr\u00F3n necesario."
	);

	$.validator.addMethod("numeroDec", function(value, element,	regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
  	}, "Ingrese un n\u00famero Decimal v\u00e1lido.");

  $.validator.addMethod("regexValor", function(value, element,regexp) {
    var re = new RegExp(regexp);
    return this.optional(element) || re.test(value);
  }, "Ingrese un Valor v\u00e1lido.");

  $('#formNomina')
							.validate(
									{
										rules : {
											rfc : {
												required : true,
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
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
                      uuid : {
                        regexValor : "^[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}$"
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
                      registroPatronal : {
												minlength : 1,
												maxlength : 20,
												regex : "([A-Z]|[a-z]|[0-9]|Ñ|ñ|!|&quot;|%|&amp;|&apos;| ́|-|:|;|&gt;|=|&lt;|@|_|,|\{|\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü){1,20}?"
							  			},
										  curpEmisor:{
    						regexCurp : "[A-Z][AEIOUX][A-Z]{2}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[MH]([ABCMTZ]S|[BCJMOT]C|[CNPST]L|[GNQ]T|[GQS]R|C[MH]|[MY]N|[DH]G|NE|VZ|DF|SP)[BCDFGHJ-NP-TV-Z]{3}[0-9A-Z][0-9]?"
		            			},
                      rfcPatronOrigen : {
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
							  			},
                      montoRecursoPropio: {
						            numeroDec : "^[0-9]{1,18}(\.([0-9]{1,2})?)?$"
					            },
                      curpReceptor:{
				                required : true,
    						regexCurp : "[A-Z][AEIOUX][A-Z]{2}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[MH]([ABCMTZ]S|[BCJMOT]C|[CNPST]L|[GNQ]T|[GQS]R|C[MH]|[MY]N|[DH]G|NE|VZ|DF|SP)[BCDFGHJ-NP-TV-Z]{3}[0-9A-Z][0-9]?"
		            			},
                      rfc : {
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
							  			},
                      numSeguridadSocial : {
												minlength : 1,
												maxlength : 15,
												regex : "^([0-9]{1,15})?$"
							  			},
			                antiguedad:{
				                required: false,
                        antig : "P(([1-9][0-9]{0,3})|0)W|P([1-9][0-9]?Y)?(([1-9]|1[012])M)?(0|[1-9]|[12][0-9]|3[01])D?"
			                },
			                tipoContrato:{
				                required : true,
				                valueNotEquals: "default"
			                },
			                tipoRegimen:{
				                required : true,
				                valueNotEquals: "default"
			                },	
			                numEmpleado: {
				                required: true,
				                maxlength : 15
			                },
			                periodicidadPago:{
				                required: true,
				                valueNotEquals: "default"
				                },
			                claveEntFed:{
				                required: true,
				                valueNotEquals: "default"
			                },
			                salarioBaseCotApor:{
				                required : false,
				                numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
			                },
			                cuentaBancaria:{
				                required: false,
                        minlength : 10,
												maxlength : 18,
				                numero : "[0-9]{10,18}?$"
			                },
			                salarioDiarioIntegrado:{
				                required : false,
				                numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
			                },
			                numDiasPagados:{
				                required : true,
                        numeroDec : "^(([1-9][0-9]{0,4})|[0])(.[0-9]{3})?$"
				              },
			                rfcLabora: {
				                required : false,
				                regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
			                },
                      porcentajeTiempo : {
												maxlength : 7,
                        numeroDec : "^(([1-9][0-9]{0,3})|[0])(.[0-9]{1,3})?$"
                      },
                      valorMercado :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,6})?$"
                      },
                      precioAlOtorgarse :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,6})?$"
                      },
                      dias:{
                        numero : "^[0-9]{1,4}?$"
                      },
                      numeroHorasExtra:{
                        numeroDec : "^[0-9]{1,18}?$"
                      },
                      importePagado :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      totalUnaExhibicion :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      totalParcialidad :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      montoDiario :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      ingresoAcumulable :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      ingresoNoAcumulable :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      totalPagado :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      numAniosServicio:{
                        numero : "^[0-9]{1,2}?$"
                      },
                      ultimoSueldoMensOrd :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      ingresoAcumulableSeparacionIndemnizacion :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      ingresoNoAcumulableSeparacionIndemnizacion :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      diasIncapacidad :{
                        numero : "^[0-9]{1,4}?$"
                      },
                      importeGravado :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      importeExento :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      importeDeduccion :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      importeOtroPago :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      subsidioCausado :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      remanenteSalFav :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      importeMonetario :{
                        numeroDec : "^[0-9]{1,18}(.[0-9]{1,2})?$"
                      },
                      confirmacion : {
                        regexValor : "^[0-9a-zA-Z]{5}$"
											}
                  }
									});
	
  getFolio();	
	
	$('#periodicidadPago').typeahead({ source : ['diario', ' semanal', ' quincenal', ' catorcenal mensual', ' bimestral', ' unidad de obra', ' comisión', ' precio alzado'] });

  
  $('#addSubContratacion').click(function(){
    if (validaSubContratacion() == true){
	    var subContratacion = $('.subContratacion').serializeObject();
	    subContrataciones.push(subContratacion);
	    alert("SubContrataci\u00F3n Agregada.");
      $('input[name=rfcLabora]').val('');
      $('input[name=porcentajeTiempo]').val('');
    }

  })

  function validaSubContratacion(){
    if ($('input[name=rfcLabora]').val() == "") {
		  alert("Debe introducir el RFC de la persona que subcontrata");
		  $('#rfcLabora').focus();
		  return false;
	  }
    if ($('input[name=porcentajeTiempo]').val() == "") {
		  alert("Debe introducir el porcentaje del tiempo que prest\u00F3 sus servicios con el RFC que lo subcontrata");
		  $('#porcentajeTiempo').focus();
		  return false;
	  }
    else{
      return true;
    }
  }
  
 
});

function ponerFecha(selector, date) {
 $(selector).val(date.getFullYear() + '-' + date.getMonth() + "-" + date.getDate()); 
}

function validarNomina() {
  var valido = true;
  $.each($('.obligatorio.nomina'), function(key, val) {
   if (valido && val.value == "") {
  	valido = false;
    alert('El campo ' + val.getAttribute('id') + ' es obligatorio.');
    }
  });
  $.each($('.obligatorio.nominaReceptor'), function(key, val) {
    if (valido && val.value == "") {
	    valido = false;
      alert('El campo ' + val.getAttribute('id') + ' es obligatorio.');
     }
  });
  if (($('#tipoNomina').val() == "O")&&($('#periodicidadPago').val() == "99")) {
  	alert("Para el Tipo de N\u00F3mina Ordinaria no se puede usar la Periodicidad de Pago seleccionada");
 		$('#periodicidadPago').focus();
    valido = false;
		return valido;
	} 
  if (($('#tipoNomina').val() == "E")&&($('#periodicidadPago').val() != "99")) {
  	alert("Para el Tipo de N\u00F3mina Extraordinaria no se puede usar la Periodicidad de Pago seleccionada");
 		$('#periodicidadPago').focus();
    valido = false;
		return valido;
	}
  if ($('#fechaInicialPago').val() > $('#fechaFinalPago').val()){
    alert("La Fecha Inicial de Pago debe de ser menor o igual a la Fecha Final de Pago.");
 		$('#fechaInicialPago').focus();
    valido = false;
		return valido;
  }
  if ($('#registroPatronal').val() != ""){
    if (($('#numSeguridadSocial').val() == "")||($('#fechaInicioRelLaboral').val() == "")||($('#antiguedad').val() == "")||
      ($('#riesgoPuesto').val() == "")||($('#salarioDiarioIntegrado').val() == "")){
        alert("Al proporcionar el Registro Patronal los campos N\u00FAmero Seguridad Social, Fecha Inicio Relaci\u00F3n Laboral, Antiguedad, Riesgo Puesto y Salario Diario Integrado tambien deben indicarse");
 		    $('#numSeguridadSocial').focus();
     valido = false;
		  return valido;
      }
  }
  if ((eval($('#tipoContrato').val()) <= 8)&&($('#registroPatronal').val() == "")){
    alert("Para este Tipo de Contrato debe proporcionarse el campo Registro Patronal");
 		$('#registroPatronal').focus();
    valido = false;
		return valido;
  }
  if ((eval($('#tipoContrato').val()) > 8)&&($('#registroPatronal').val() != "")){
    alert("Para este Tipo de Contrato no debe proporcionarse el campo Registro Patronal");
 		$('#registroPatronal').focus();
    valido = false;
		return valido;
  }
  if ($('#origenRecurso').val() == "IM"){
    if ($('#montoRecursoPropio').val() == ""){
      alert("Si el campo Origen Recurso es Ingresos Mixtos, debe proporcionar el campo Monto Recurso Propio");
   		$('#montoRecursoPropio').focus();
      valido = false;
	  	return valido;
    }
    if (eval($('#montoRecursoPropio').val()) >= 
      eval(parseFloat($('input[name=totalPercepciones]').val()) + parseFloat($('input[name=totalOtrosPagos]').val()))){
      alert("El valor del campo Monto Recurso Propio debe ser menor a la suma de los valores de los atributos TotalPercepciones y TotalOtrosPagos");
   		$('#montoRecursoPropio').focus();
      valido = false;
	  	return valido;
    }
  }
  else{
    if ($('#montoRecursoPropio').val() != ""){
      alert("Si el campo Origen Recurso es diferente a Ingresos Mixtos, no debe proporcionar el campo Monto Recurso Propio");
   		$('#montoRecursoPropio').focus();
      valido = false;
	  	return valido;
    }
  } 
  if ($('#fechaInicioRelLaboral').val() > $('#fechaFinalPago').val()){
    alert("La Fecha de Inicio de la Relaci\u00F3n Laboral debe de ser menor o igual a la Fecha Final de Pago.");
 		$('#fechaInicioRelLaboral').focus();
    valido = false;
		return valido;
  }
  if ((eval($('#numDiasPagados').val()) < 0.001)||(eval($('#numDiasPagados').val()) > 36160.000)){
    alert("Los valores permitidos en el campo N\u00famero de D\u00EDas Pagados deben estar en el rango 0.001 - 36160.000");
    $('#numDiasPagados').focus();
    valido = false;
	  return valido;
    }
  /*var validaAntiguedad = validateAntiguedad();
  if (validaAntiguedad != ""){
    alert(validaAntiguedad);
 		$('#antiguedad').focus();
    valido = false;
		return valido;
  }*/
  if (eval($('#tipoContrato').val()) < 09){
    if (eval($('#tipoRegimen').val()) > 4){
      alert("Para el Tipo de Contrato seleccionado no puede indicarse este Tipo Regimen.");
 	  	$('#tipoRegimen').focus();
      valido = false;
	  	return valido;
    }
  }
  else{
    if (eval($('#tipoRegimen').val()) < 5){
      alert("Para el Tipo de Contrato seleccionado no puede indicarse este Tipo Regimen.");
 	  	$('#tipoRegimen').focus();
      valido = false;
	  	return valido;
    }
  }
  if ($('#cuentaBancaria').val() !=""){
    if (($('#cuentaBancaria').val().length == 10)||($('#cuentaBancaria').val().length == 11)||
      ($('#cuentaBancaria').val().length == 16)||($('#cuentaBancaria').val().length == 18)){
      }
    else{
      alert("La longitud del campo cuentaBancaria solo puede ser de 10, 11, 16 o 18 posiciones");
    	$('#cuentaBancaria').focus();
      valido = false;
     	return valido;  
    }
    if ($('#cuentaBancaria').val().length == 18){
      if ($('#banco').val() != ""){
        alert("Si se registra una cuenta CLABE (n\u00FAmero con 18 posiciones), no debe existir el atributo Banco");
      	$('#banco').focus();
        valido = false;
       	return valido;  
      }
    }
    else{
      if ($('#banco').val() == ""){
        alert("Si se registra una cuenta de tarjeta de d\u00E9bito a 16 posiciones o una cuenta bancaria a 11 posiciones o un n\u00FAmero de tel\u00E9fono celular a 10 posiciones, debe indicar el banco");
      	$('#banco').focus();
        valido = false;
       	return valido;  
      }
    }
  }
  
  if (subContrataciones.length > 0){
      var sumaPorcentajeTiempo = 0;
      for (var i in subContrataciones) {
        sumaPorcentajeTiempo = sumaPorcentajeTiempo +eval(subContrataciones[i].porcentajeTiempo);
      }
      if (sumaPorcentajeTiempo != 100){
        alert("La suma de los valores PorcentajeTiempo registrados debe ser igual a 100");
      	$('#porcentajeTiempo').focus();
        valido = false;
       	return valido;  
      }
  }
  if ((percepciones.length < 1)&&(otrosPagos.length < 1)){
    alert("Debe agregar Percepciones u Otros Pagos");
    valido = false;
  	return valido;  
  }

  return valido;
}


function getFolio() {
	var serie = $('#serie').val();
	$.get('/CFDI33/rest/comprobante/folio/' + serie, function(response) {
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

function validateAntiguedad(){
  var valida = "";
  if ($('#antiguedad').val() != ""){
    var re = new RegExp("P(([1-9][0-9]{0,3})|[0])W");
    if (re.test($('#antiguedad').val())) {
      fecha = daysBetween($('#fechaInicioRelLaboral').val(), $('#fechaFinalPago').val());
      antiguedadReal = (fecha + 1) / 7; 
      var temp = $('#antiguedad').val().replace('P','');
      temp = temp.replace('W','');
      var antiguedadXML = parseInt(temp);
      if (antiguedadXML > antiguedadReal) {
					valida = "El campo Antiguedad no es menor o igual al cociente de (la suma del numero de dias transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago mas uno) dividido entre siete ("+antiguedadReal +")";
  		}

    }
    else{
      antiguedadReal = getAniosMesesDiasByFecha($('#fechaInicioRelLaboral').val(), $('#fechaFinalPago').val());  
      if ($('#antiguedad').val() != antiguedadReal) {
					valida = "El campo Antiguedad no cumple con el n\u00FAmero de a\u00F1os, meses y dias transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago ( intente con "+antiguedadReal + ")";
			}
  }
}
  

  return valida;
}

function treatAsUTC(date) {
    var result = new Date(date);
    result.setMinutes(result.getMinutes() - result.getTimezoneOffset());
    return result;
}

function daysBetween(startDate, endDate) {
    var millisecondsPerDay = 24 * 60 * 60 * 1000;
    return (treatAsUTC(endDate) - treatAsUTC(startDate)) / millisecondsPerDay;
}

function getAniosMesesDiasByFecha(startDate, endDate) {
  var strAntiguedadReal = "";
  var fechaI = startDate.split("-");
  var diaInicio = parseInt(fechaI[2]);
  var mesInicio = parseInt(fechaI[1]);
  var anioInicio = parseInt(fechaI[0]);

  var fechaF = endDate.split("-");
  var diaActual = parseInt(fechaF[2]);
  var mesActual = parseInt(fechaF[1]);
  var anioActual = parseInt(fechaF[0]);

  var b = 0;
  var dias = 0;
  var mes = 0;
  var anios = 0;
  var meses = 0;
  mes = mesInicio - 1;

  if (mes == 2) {
      if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
          b = 29;
      } else {
          b = 28;
      }
  } else if (mes <= 7) {
      if (mes == 0) {
          b = 31;
      } else if (mes % 2 == 0) {
          b = 30;
      } else {
          b = 31;
      }
  } else if (mes > 7) {
      if (mes % 2 == 0) {
          b = 31;
      } else {
          b = 30;
      }
  }

  if (mesInicio <= mesActual) {
      anios = anioActual - anioInicio;
      if (diaInicio <= diaActual) {
          meses = mesActual - mesInicio;
          dias = b - (diaInicio - diaActual) - b;
      } else {
          if (mesActual == mesInicio) {
              anios = anios - 1;
          }
          meses = (mesActual - mesInicio - 1 + 12) % 12;
          dias = b - (diaInicio - diaActual) - b;
      }
  } else {
      anios = anioActual - anioInicio - 1;
      if (diaInicio > diaActual) {
          meses = mesActual - mesInicio - 1 + 12;
          dias = b - (diaInicio - diaActual) - b;
      } else {
          meses = mesActual - mesInicio + 12;
          dias = (diaActual - diaInicio) - b;
      }
  }
  dias = Math.abs(dias);
  meses = Math.abs(meses);
  anios = Math.abs(anios);

  //Se arma la cadena para compararla con la contenida en el atributo de Antiguedad
  strAntiguedadReal = "P" + anios + "Y" + meses + "M" + dias + "D";
if (anios=="0")
  	strAntiguedadReal = "P" + meses + "M" + dias + "D";
				
	if (anios=="0" && meses=="0")
		strAntiguedadReal = "P" + dias + "D";

  return strAntiguedadReal;
}

function graficarCFDIRelacionado() {

	$('#tablaFoliosRelacionados tbody').html('');
	if(cfdiRelacionadoArr.length > 0) {
		$('#tablaFoliosRelacionados').show();
    $('#tipoRelacion').attr("disabled", "disabled");
	} else {
		$('#tablaFoliosRelacionados').hide();
 		$('#tipoRelacion').removeAttr("disabled");
	}
  $.each(cfdiRelacionadoArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['uuid'] + '</td>';

		row += '<td><a class="eliminarCFDIRelacionado" onClick="eliminarCFDIRelacionado(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaFoliosRelacionados').append(row);
  }); 

}

function eliminarCFDIRelacionado(id) {
	cfdiRelacionadoArr.splice(id, 1);
	graficarCFDIRelacionado();
  $('#tipoRelacion').val("");
}

function validaUUID(){
  var re = new RegExp("^[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}?$");
  if (!re.test($('#uuid').val())) {
    alert("El campo UUID no cumple con el patr\u00F3n [a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}");
    $('#uuid').focus();
		return false;
  }
  else{
  		return true;
  }
}

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

function cleanStringPipe(str) {
	if(/\|/.test(str)) {
		return str.replace(/\|/g, "");
	}
}