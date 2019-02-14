var totalIVA = 0;
var mapConceptos = new Array();
var listaMetodoPago = "";
var conceptosDespensa = new Array();
var conceptosConsumoCombustibles  = new Array();
var determinadosConsumoCombustibles  = new Array();
var trasladosConsumoCombustibles  = new Array();
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
var subtotalCombustiblesECC11 = 0;
var totalCombustiblesECC11 = 0;
var totalImportesECC11 = 0;
var infoAduaneras  = new Array();
var infoAduanerasVentaVehiculos = new Array();
var partes = new Array();
var infoAduanerasParteVentaVehiculos  = new Array();
var retencionesCuentaTerceros  = new Array();
var trasladosCuentaTerceros  = new Array();
var infoAduanerasParteCuentaTerceros = new Array();
var cargoAerolineas = new Array();
var totalCargos = 0;
var ineEntidades = new Array();
var ineContabilidad = new Array();
var leyendas = new Array();
var SPEI_Tercero = new Array();
var mercancias = new Array();
var descripcionesEsp = new Array();

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

function validaTrasladosConsumoCombustibles(){
  if ($('input[name=impuestoTrasladoECC11]').val() == "") {
		alert("Debe seleccionar el Tipo de Impuesto Trasladado");
		$('#impuestoTrasladoECC11').focus();
		return false;
	}
  if ($('input[name=tasaoCuotaECC11]').val() == "") {
		alert("Debe introducir tasa o la cuota del impuesto que se traslada");
		$('#tasaoCuotaECC11').focus();
		return false;
	}
  if ($('input[name=importeTrasladoECC11]').val() == "") {
		alert("Debe introducir el Importe del Impuesto Trasladado");
		$('#importeTrasladoECC11').focus();
		return false;
	}
  if ($('input[name=importeTrasladoECC11]').val() < 0.01) {
		alert("El importe del impuesto trasladado debe ser mayor o igual a 0.01");
		$('#importeTrasladoECC11').focus();
		return false;
	}
else{
  return true;
}
}

function validaConceptoConsumoCombustiblesECC11(){
  if ($('input[name=identificadorECC11]').val() == "") {
		alert("Debe introducir el Identificador");
		$('#identificadorECC11').focus();
		return false;
	}
  if ($('input[name=fechaExpOperECC11]').val() == "") {
		alert("Debe introducir la Fecha");
		$('#fechaExpOperECC11').focus();
		return false;
	}
  if ($('input[name=horaConsumoCombustiblesECC11]').val() == "") {
		alert("Debe introducir la Hora");
		$('#horaConsumoCombustiblesECC11').focus();
		return false;
	}
  var fechaMin = new Date('2015-01-01');
  var fechaConsumo =  new Date($('input[name=fechaExpOperECC11]').val());
  if (fechaConsumo < fechaMin) {
		alert("La Fecha debe ser mayor o igual a 2015-01-01");
		$('#fechaExpOperECC11').focus();
		return false;
	}
  if ($('input[name=rfcEnajCombustibleECC11]').val() == "") {
		alert("Debe introducir el RFC");
		$('#rfcEnajCombustibleECC11').focus();
		return false;
	}
  if ($('input[name=claveEstacionECC11]').val() == "") {
		alert("Debe introducir la Clave de la Estación");
		$('#claveEstacionECC11').focus();
		return false;
	}
  if ($('input[name=cantidadConceptoECC11]').val() == "") {
		alert("Debe introducir el Volumen");
		$('#cantidadConceptoECC11').focus();
		return false;
	}
  if ($('input[name=cantidadConceptoECC11]').val() < 0.001) {
		alert("El volumen de combustible debe ser mayor o igual a 0.001");
		$('#cantidadConceptoECC11').focus();
		return false;
	}
  if ($('input[name=noIdentificacionConceptoECC11]').val() == "") {
		alert("Debe introducir la clave del producto del combustible");
		$('#noIdentificacionConceptoECC11').focus();
		return false;
	}
  if ($('input[name=nombreCombustibleECC11]').val() == "") {
		alert("Debe introducir el Nombre del Combustible");
		$('#nombreCombustibleECC11').focus();
		return false;
	}
  if ($('input[name=folioOperacionECC11]').val() == "") {
		alert("Debe introducir el Folio de la Operación");
		$('#folioOperacionECC11').focus();
		return false;
	}
  if ($('input[name=precioUnitarioECC11]').val() == "") {
		alert("Debe introducir el Precio Unitario");
		$('#precioUnitarioECC11').focus();
		return false;
	}
  if ($('input[name=precioUnitarioECC11]').val() < 0.001) {
		alert("El precio unitario del combustible debe ser mayor o igual a 0.001");
		$('#precioUnitarioECC11').focus();
		return false;
	}
  if ($('input[name=importeCombustibleECC11]').val() == "") {
		alert("Debe introducir el Importe");
		$('#importeCombustibleECC11').focus();
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

function validaCargoAerolineas(){
  if ($('input[name=codigoCargo]').val() == "") {
		alert("Debe introducir el Código del Cargo");
		$('#codigoCargo').focus();
		return false;
	}
  if ($('input[name=importeCargo]').val() == "") {
		alert("Debe introducir el Importe del Cargo");
		$('#importeCargo').focus();
		return false;
	}
else{
  return true;
}
}

function validaEntidadesINE(){
  if ($('#tipoComite').val() == "Ejecutivo Nacional")  {
      alert("Cuando el Tipo de Comité es Ejecutivo Nacional no se pueden agregar elementos Entidad");
      return false;
  }
  if (($('#tipoComite').val() == "Ejecutivo Estatal")&&($('#ambito').val() != ""))  {
      alert("Cuando el Tipo de Comité es Ejecutivo Estatal no se puede ingresar el Ámbito");
      return false;
  }
  if ($('#claveEntidad').val() == "")  {
		alert("Debe seleccionar la Clave de la Entidad");
		$('#claveEntidad').focus();
		return false;
	}
  if (($('#tipoProceso').val() == "Ordinario") && ($('#ambito').val() != "")){
   		alert("El campo Ámbito no debe registrarse para los procesos de Tipo Ordinario");
	  	return false;
	}
  if (($('#tipoProceso').val() != "Ordinario") && ($('#ambito').val() == "")){
   		alert("El campo Ámbito debe registrarse para los procesos de Tipo Campaña o Precampaña");
	  	return false;
	}
  if (ineEntidades.length > 0){
       for ( var i = 0; i < ineEntidades.length; i++) {
          if ((ineEntidades[i].claveEntidad == ($('#claveEntidad').val())) && (ineEntidades[i].ambito == ($('#ambito').val()))){
              alert("No se puede repetir una combinación de Entidad y Ámbito");
              return false;
          }
        }
      }
  return true;

}

function validaLeyendas(){
  if ($('input[name=textoLeyenda]').val() == "") {
		alert("Debe introducir el Texto de la Leyenda");
		$('#textoLeyenda').focus();
		return false;
	}
else{
  return true;
}
}

function validaSpei(){
  if ($('input[name=fechaSpei]').val() == "") {
		alert("Debe introducir la Fecha de Operación");
		$('#fechaSpei').focus();
		return false;
	}
  if ($('input[name=horaSpei]').val() == "") {
		alert("Debe introducir la Hora del acreditamiento");
		$('#horaSpei').focus();
		return false;
	}
  if ($('input[name=claveSpei]').val() == "") {
		alert("Debe introducir la Clave SPEI del Participante Emisor");
		$('#claveSpei').focus();
		return false;
	}
  if ($('input[name=selloSpei]').val() == "") {
		alert("Debe introducir el Sello digital del comprobante de pago");
		$('#selloSpei').focus();
		return false;
	}
  if ($('input[name=numeroCertificado]').val() == "") {
		alert("Debe introducir el Número de Certificado");
		$('#numeroCertificado').focus();
		return false;
	}
  if ($('input[name=cadenaCDA]').val() == "") {
		alert("Debe introducir la Cadena CDA");
		$('#cadenaCDA').focus();
		return false;
	}
  if ($('input[name=bancoOrdenante]').val() == "") {
		alert("Debe introducir el Banco Emisor");
		$('#bancoOrdenante').focus();
		return false;
	}
  if ($('input[name=nombreOrdenanteSpei]').val() == "") {
		alert("Debe introducir el Nombre del Ordenante");
		$('#nombreOrdenanteSpei').focus();
		return false;
	}
  if ($('input[name=tipoCuentaOrdenanteSpei]').val() == "") {
		alert("Debe introducir el Tipo de Cuenta del Ordenante");
		$('#tipoCuentaOrdenanteSpei').focus();
		return false;
	}
  if ($('input[name=cuentaOrdenanteSpei]').val() == "") {
		alert("Debe introducir la Cuenta del Ordenante");
		$('#cuentaOrdenanteSpei').focus();
		return false;
	}
  if ($('input[name=rfcOrdenanteSpei]').val() == "") {
		alert("Debe introducir el RFC del Ordenante");
		$('#rfcOrdenanteSpei').focus();
		return false;
	}
  if ($('input[name=bancoReceptor]').val() == "") {
		alert("Debe introducir el Banco Receptor");
		$('#bancoReceptor').focus();
		return false;
	}
  if ($('input[name=nombreBeneficiarioSpei]').val() == "") {
		alert("Debe introducir el Nombre del Beneficiario");
		$('#nombreBeneficiarioSpei').focus();
		return false;
	}
  if ($('input[name=tipoCuentaBeneficiarioSpei]').val() == "") {
		alert("Debe introducir el Tipo de Cuenta del Beneficiario");
		$('#tipoCuentaBeneficiarioSpei').focus();
		return false;
	}
  if ($('input[name=cuentaBeneficiarioSpei]').val() == "") {
		alert("Debe introducir la Cuenta del Beneficiario");
		$('#cuentaBeneficiarioSpei').focus();
		return false;
	}
  if ($('input[name=rfcBeneficiarioSpei]').val() == "") {
		alert("Debe introducir el RFC del Beneficiario");
		$('#rfcBeneficiarioSpei').focus();
		return false;
	}
  if ($('input[name=conceptoSpei]').val() == "") {
		alert("Debe introducir el Concepto");
		$('#conceptoSpei').focus();
		return false;
	} 
  if ($('input[name=montoSpei]').val() == "") {
		alert("Debe introducir el Monto");
		$('#montoSpei').focus();
		return false;
	} 
else{
  return true;
}
}


function validaMercancia(){
  if ($('#tipoOperacionComercioExt').val() =="A"){
      alert("Para el Complemento de Comercio Exterior si el Tipo de Operación es Exportación de Servicios, no se pueden ingresar Mercancias");
      $('input[name=NoIdentificacionMercanciaComercioExt]').val('');
      $('select[name=FraccionArancelariaMercanciaComercioExt]').val('');
      $('input[name=CantidadAduanaMercanciaComercioExt]').val('');
      $('select[name=UnidadAduanaMercanciaComercioExt]').val('');
      $('input[name=ValorUnitarioAduanaMercanciaComercioExt]').val('');
      $('input[name=ValorDolaresMercanciaComercioExt]').val('');
      return false;
    }
    if (($('select[name=UnidadAduanaMercanciaComercioExt]').val() == "99")&&($('select[name=FraccionArancelariaMercanciaComercioExt]').val() != "default")){
      alert("Si el atributo cce:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:unidad tienen el valor {99} que corresponde a los servicios, entonces no debe existir el atributo cce:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria");   
   		return false; 
    }  

  if ($('select[name=UnidadAduanaMercanciaComercioExt]').val() != "default"){
    if (($('select[name=UnidadAduanaMercanciaComercioExt]').val() != "99")&&($('input[name=ValorUnitarioAduanaMercanciaComercioExt]').val() <= 0)){
      alert("Si el valor del atributo cce:ComercioExterior:Mercancias:Mercancia:UnidadAduana es distinto de {99} que corresponde a los servicios, entonces el cce:ComercioExterior:Mercancias:Mercancia:ValorUnitarioAduana debe ser mayor que cero");  
   		return false; 
    }
  }
  
  
  if ((($('#CantidadAduanaMercanciaComercioExt').val() == "")&&($('#UnidadAduanaMercanciaComercioExt').val() == "default")&&  ($('#ValorUnitarioAduanaMercanciaComercioExt').val() == ""))||
(($('#CantidadAduanaMercanciaComercioExt').val() != "")&&($('#UnidadAduanaMercanciaComercioExt').val() != "default")&&  ($('#ValorUnitarioAduanaMercanciaComercioExt').val() != ""))){
  if ($('#CantidadAduanaMercanciaComercioExt').val() !=""){
    if ($('#ValorDolaresMercanciaComercioExt').val() !=1){
        $('input[name=ValorDolaresMercanciaComercioExt]').val(new Number($('input[name=CantidadAduanaMercanciaComercioExt]').val()*$('input[name=ValorUnitarioAduanaMercanciaComercioExt]').val()).toFixed(2));
    }
    else{
      $('input[name=ValorDolaresMercanciaComercioExt]').val(1);
    }
  }
  else{//no existe  CantidadAduanaMercanciaComercioExt
    if ($('#ValorDolaresMercanciaComercioExt').val() !=1){
      if ($('#UnidadAduanaMercanciaComercioExt').val() =="99"){
        $('input[name=ValorDolaresMercanciaComercioExt]').val(0);  
      }
      else{
        $('input[name=ValorDolaresMercanciaComercioExt]').val(calculaValorDolares($('#NoIdentificacionMercanciaComercioExt').val()));
      }
    }
    else{
      $('input[name=ValorDolaresMercanciaComercioExt]').val(1);
    }
  }
    }
  else{
    alert("Si registra alguno de los atributos Cantidad Aduana, Unidad Aduana o Valor Unitario Aduana de una Mercancia, entonces deben existir los 3 atributos");
    return false;
  }

  if (($('#CantidadAduanaMercanciaComercioExt').val() == "")&&(!validaCantidadConcepto($('#NoIdentificacionMercanciaComercioExt').val()))){
    alert("El atributo cfdi:Comprobante:Conceptos:Concepto:cantidad debe tener como valor mínimo incluyente {0.001} y debe cumplir con el patrón [0-9]{1,14}(.([0-9]{1,3}))?");
    return false;
  }
  if (($('#CantidadAduanaMercanciaComercioExt').val() == "")&&(!validaValorUnitarioConcepto($('#NoIdentificacionMercanciaComercioExt').val()))){
    alert("El atributo cfdi:Comprobante:Conceptos:Concepto:valorUnitario debe tener como valor mínimo incluyente {0.0001}, debe cumplir con el patrón [0-9]{1,16}(.([0-9]{1,4}))?");
    return false;
  }  
  return true;

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

function graficarTrasladosConsumoCombustibles() {

	$('#tablaTrasladosComplementoCombustibles tbody').html('');

  $.each(trasladosConsumoCombustibles, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['impuestoTraslado'] + '</td>';
		row += '<td>' + concepto['tasaoCuota'] + '</td>';
		row += '<td>' + concepto['importeTraslado'] + '</td>';

		row += '</tr>';

		$('#tablaTrasladosComplementoCombustibles').append(row);
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

function graficarMercancia() {

	$('#tablaInfoMercancia tbody').html('');

  $.each(mercancias, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['noIdentificacion'] + '</td>';
		row += '<td>' + concepto['fraccionArancelaria'] + '</td>';
		row += '<td>' + concepto['cantidadAduana'] + '</td>';
		row += '<td>' + concepto['unidadAduana'] + '</td>';
		row += '<td>' + concepto['valorUnitarioAduana'] + '</td>';
		row += '<td>' + concepto['valorDolares'] + '</td>';

    $.each(concepto['descripcionesEspecificas'], function(key, concepto2) {
      row += '<tr>';
      row += '<td></td>';
      row += '<td></td>';
      row += '<td></td>';
      row += '<td></td>';
      row += '<td></td>';
      row += '<td></td>';
		  row += '<td>' + concepto2['marca'] + '</td>';
      row += '<td>' + concepto2['modelo'] + '</td>';
      row += '<td>' + concepto2['subModelo'] + '</td>';
      row += '<td>' + concepto2['numeroSerie'] + '</td>';
      row += '</tr>';



    }); 
		row += '</tr>';

		$('#tablaInfoMercancia').append(row);
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

  if ($('#metodoDePago').val() == "default") {
		alert("Debe seleccionar el método de pago.");
		$('#metodoDePago').focus();
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
 	$('input[name=clave]').val('');
	
	if ($('#ish').is(':checked')) {
		$('select[name=tipoImpuesto].impLoc1').val('Traslado');
		$('input[name=impLoc].impLoc1').val('I.S.H');
		$('input[name=tasade].impLoc1').val($('#tasaISH').val());
		$('input[name=tasade].impLoc1').trigger('change');
	}
}

function agregarMetodoPago() {
  if ($('#metodoDePago').val() == "default") {
    alert("Debe seleccionar el método de pago.");
  }
  else{
    listaMetodoPago = listaMetodoPago.concat($('select[name=metodoDePago]').val()).concat(",");
    alert("Método de Pago agregado");
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

function validarConsumoCombustiblesECC11() {
  if ($('input[name=numeroDeCuentaECC11]').val() != "" && $('input[name=numeroDeCuentaECC11]').val() != undefined) {		
    var EstadoDeCuentaCombustible = new Object();
    EstadoDeCuentaCombustible.tipoOperacion = $('#tipoOperacionECC11').val();
    EstadoDeCuentaCombustible.numeroDeCuenta = $('#numeroDeCuentaECC11').val();
    if ($('input[name=subTotalCombustiblesECC11]').val() == "") {
      EstadoDeCuentaCombustible.subTotal = null;
    }    
    else{
      EstadoDeCuentaCombustible.subTotal = $('#subTotalCombustiblesECC11').val();
    }

    
    EstadoDeCuentaCombustible.total = $('#totalCombustiblesECC11').val();

    EstadoDeCuentaCombustible.conceptos = new Object();
    EstadoDeCuentaCombustible.conceptos.conceptoconsumodecombustibles = new Array();  
    EstadoDeCuentaCombustible.conceptos.conceptoconsumodecombustibles = conceptosConsumoCombustibles;

    EstadoDeCuentaCombustible.conceptos.conceptoconsumodecombustibles.traslados = new Object();  
    EstadoDeCuentaCombustible.conceptos.conceptoconsumodecombustibles.traslados.traslado = new Array();
    EstadoDeCuentaCombustible.conceptos.conceptoconsumodecombustibles.traslados.traslado = trasladosConsumoCombustibles; 

		return EstadoDeCuentaCombustible;
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

function validarAerolineas() {
  if ($('#tua').val() != undefined && $('#tua').val() != "")  {
		var aerolineas = new Object();
		aerolineas = $('.aerolineas').serializeObject();
    if ($('input[name=TotalCargos]').val() != "") {
      aerolineas.otrosCargos = new Object();
      aerolineas.otrosCargos.totalCargos = $('#TotalCargos').val();
      aerolineas.otrosCargos.cargo = cargoAerolineas;
    }
    

		return aerolineas;
  }
  return null;
}

function validarDivisas() {
if ($('select[name=tipoOperacionDivisas]').val() != undefined && $('select[name=tipoOperacionDivisas]').val() != "")  {
		var divisas = new Object();
		divisas = $('.divisas').serializeObject();
		return divisas;
  }
  return null;
}

function validarTurista() {
if ($('input[name=fechaTransito]').val()!= undefined && $('input[name=fechaTransito]').val() != "")  {
		var turista = new Object();
		turista = $('.turista').serializeObject();
    turista.fechadeTransito = $('input[name=fechaTransito]').val() + "T" + $('input[name=horaTransito]').val();
    turista.datosTransito = new Object();
    turista.datosTransito = $('.datosTransito').serializeObject();
    if ($('input[name=idTransporteTurista]').val() == "") {
        turista.datosTransito.idTransporteTurista = null;
      }    
    else{
        turista.datosTransito.idTransporteTurista = $('#idTransporteTurista').val();
      }
    if ($('input[name=empresaTransporte]').val() == "") {
        turista.datosTransito.empresaTransporte = null;
      }    
    else{
        turista.datosTransito.empresaTransporte = $('#empresaTransporte').val();
      }
		return turista;
  }
  return null;
}

function validarPFIC() {
if ($('input[name=claveVehicularPFIC]').val()!= undefined && $('input[name=claveVehicularPFIC]').val() != "")  {
		var pfic = new Object();
		pfic = $('.pfic').serializeObject();
    if ($('input[name=RFCPF]').val() == "") {
        pfic.RFCPF = null;
      }    
    else{
        pfic.RFCPF = $('#RFCPF').val();
      }
		return pfic;
  }
  return null;
}

function validarINE() {
  if ($('#tipoProceso').val() != undefined && $('#tipoProceso').val() != "")  {
		var ine = new Object();
    ine.tipoProceso = $('#tipoProceso').val();
    if ($('#tipoComite').val() == undefined || $('#tipoComite').val() == ""){
      ine.tipoComite = null;    
    }
    else{
      ine.tipoComite = $('#tipoComite').val();    
    }
		if ( $('#idContabilidad').val() == ""){
      ine.idContabilidad = null;
    }
    else{
      ine.idContabilidad = $('#idContabilidad').val();
    }

    if ($('input[name=claveEntidad]').val() != "") {
      ine.entidad = new Object();
      ine.entidad = ineEntidades;
    }
    

		return ine;
  }
  return null;
}

function validarLeyendas() {
  if (leyendas.length > 0)  {
		var leyendasFisc = new Object();
    leyendasFisc.leyenda = leyendas;
		return leyendasFisc;
  }
  return null;
}

function validarSpeis() {
  if (SPEI_Tercero.length > 0)  {
		var complemento_SPEI = new Object();
    complemento_SPEI.SPEI_Tercero = SPEI_Tercero;
		return complemento_SPEI;
  }
  return null;
}

function validarObrasArte() {
  if ($('#tipoBien').val() != undefined && $('#tipoBien').val() != "")  {
		var obrasArte = new Object();
    obrasArte.tipoBien = $('#tipoBien').val();
    if ($('#otrosTipoBien').val() == undefined || $('#otrosTipoBien').val() == ""){
      obrasArte.otrosTipoBien = null;    
    }
    else{
      obrasArte.otrosTipoBien = $('#otrosTipoBien').val();    
    }
    obrasArte.tituloAdquirido = $('#tituloAdquirido').val();
    if ($('#otrosTituloAdquirido').val() == undefined || $('#otrosTituloAdquirido').val() == ""){
      obrasArte.otrosTituloAdquirido = null;    
    }
    else{
      obrasArte.otrosTituloAdquirido = $('#otrosTituloAdquirido').val();    
    }
		if ( $('#subtotalObrasArte').val() == ""){
      obrasArte.subtotal = null;
    }
    else{
      obrasArte.subtotal = $('#subtotalObrasArte').val();
    }
    if ( $('#ivaObrasArte').val() == ""){
      obrasArte.iva = null;
    }
    else{
      obrasArte.iva = $('#ivaObrasArte').val();
    }
    obrasArte.fechaAdquisicion = $('#fechaAdquisicion').val();
    obrasArte.característicasDeObraoPieza = $('#característicasDeObraoPieza').val();
    

		return obrasArte;
  }
  return null;
}

function validarCertDestruccion() {
  if ($('#tipoSerie').val() != undefined && $('#tipoSerie').val() != "")  {
		var certDest = new Object();
    certDest.serie = $('#tipoSerie').val();
    if ($('#numFolDesVeh').val() == undefined || $('#numFolDesVeh').val() == ""){
      certDest.numFolDesVeh = null;    
    }
    else{
      certDest.numFolDesVeh = $('#numFolDesVeh').val();    
    }
    certDest.vehiculoDestruido = new Object();
    if ($('#marcaCertDest').val() == undefined || $('#marcaCertDest').val() == ""){
      certDest.vehiculoDestruido.marca = null;    
    }
    else{
      certDest.vehiculoDestruido.marca = $('#marcaCertDest').val();    
    }
		if ( $('#tipooClase').val() == ""){
      certDest.vehiculoDestruido.tipooClase = null;
    }
    else{
      certDest.vehiculoDestruido.tipooClase = $('#tipooClase').val();
    }
    if ( $('#anioCertDest').val() == ""){
      certDest.vehiculoDestruido.anio = null;
    }
    else{
      certDest.vehiculoDestruido.anio = $('#anioCertDest').val();
    }
    if ( $('#modeloCertDest').val() == ""){
      certDest.vehiculoDestruido.modelo = null;
    }
    else{
      certDest.vehiculoDestruido.modelo = $('#modeloCertDest').val();
    }
    if ( $('#nivCertDest').val() == ""){
      certDest.vehiculoDestruido.niv = null;
    }
    else{
      certDest.vehiculoDestruido.niv = $('#nivCertDest').val();
    }
    if ( $('#numSerieCertDest').val() == ""){
      certDest.vehiculoDestruido.numSerie = null;
    }
    else{
      certDest.vehiculoDestruido.numSerie = $('#numSerieCertDest').val();
    }
    if ( $('#numPlacasCertDest').val() == ""){
      certDest.vehiculoDestruido.numPlacas = null;
    }
    else{
      certDest.vehiculoDestruido.numPlacas = $('#numPlacasCertDest').val();
    }
    if ( $('#numMotorCertDest').val() == ""){
      certDest.vehiculoDestruido.numMotor = null;
    }
    else{
      certDest.vehiculoDestruido.numMotor = $('#numMotorCertDest').val();
    }
    if ( $('#numFolTarjCir').val() == ""){
      certDest.vehiculoDestruido.numFolTarjCir = null;
    }
    else{
      certDest.vehiculoDestruido.numFolTarjCir = $('#numFolTarjCir').val();
    }
    if ( $('#numPedImp').val() != ""){
      certDest.informacionAduanera = new Object();
      if ( $('#numPedImp').val() == ""){
        certDest.informacionAduanera.numPedImp = null;
      }
      else{
        certDest.informacionAduanera.numPedImp = $('#numPedImp').val();
      }
      if ( $('#fechaCertDest').val() == ""){
        certDest.informacionAduanera.fecha = null;
      }
      else{
        certDest.informacionAduanera.fecha = $('#fechaCertDest').val();
      }
      if ( $('#aduanaCertDest').val() == ""){
        certDest.informacionAduanera.aduana = null;
      }
      else{
        certDest.informacionAduanera.aduana = $('#aduanaCertDest').val();
      }
    }
    return certDest;
  }
  return null;
}

function validarComercioExterior() {
  if ($('#tipoOperacionComercioExt').val() != undefined && $('#tipoOperacionComercioExt').val() != "")  {
	  var comercioExterior = new Object();
    comercioExterior.tipoOperacion = $('#tipoOperacionComercioExt').val();
    if ($('#clavePedimento').val() == undefined || $('#clavePedimento').val() == ""){
      comercioExterior.claveDePedimento = null;    
    }
    else{
      comercioExterior.claveDePedimento = $('#clavePedimento').val();    
    }
    if ($('#certificadoOrigen').val() == undefined || $('#certificadoOrigen').val() == ""){
      comercioExterior.certificadoOrigen = null;    
    }
    else{
      comercioExterior.certificadoOrigen = $('#certificadoOrigen').val();    
    }
    if ( $('#numCertificadoOrigen').val() == ""){
      comercioExterior.numCertificadoOrigen = null;
    }
    else{
      comercioExterior.numCertificadoOrigen = $('#numCertificadoOrigen').val();
    }
    if ( $('#numExportadorConfiable').val() == ""){
      comercioExterior.numeroExportadorConfiable = null;
    }
    else{
      comercioExterior.numeroExportadorConfiable = $('#numExportadorConfiable').val();
    }
    if ($('#Incoterm').val() == undefined || $('#Incoterm').val() == ""){
      comercioExterior.incoterm = null;    
    }
    else{
      comercioExterior.incoterm = $('#Incoterm').val();    
    }
    if ($('#Subdivision').val() == undefined || $('#Subdivision').val() == ""){
      comercioExterior.subdivision = null;    
    }
    else{
      comercioExterior.subdivision = $('#Subdivision').val();    
    }
    if ( $('#ObservacionesComercioExt').val() == ""){
      comercioExterior.observaciones = null;
    }
    else{
      comercioExterior.observaciones = $('#ObservacionesComercioExt').val();
    }
    if ( $('#TipoCambioUSD').val() == ""){
      comercioExterior.tipoCambioUSD = null;
    }
    else{
      comercioExterior.tipoCambioUSD = $('#TipoCambioUSD').val();
    }
    if (( $('#TotalUSD').val() == "")||( $('#TotalUSD').val() == "0")){
      comercioExterior.totalUSD = null;
    }
    else{
      comercioExterior.totalUSD = $('#TotalUSD').val();
    }
    
    if ( $('#curpEmisorComercioExt').val() != ""){
      comercioExterior.emisor = new Object();
      comercioExterior.emisor.curp = $('#curpEmisorComercioExt').val();
    }

    comercioExterior.receptor = new Object();
    if ( $('#curpReceptorComercioExt').val() == ""){
      comercioExterior.receptor.curp = null;
    }
    else{
      comercioExterior.receptor.curp = $('#curpReceptorComercioExt').val();
    }
    comercioExterior.receptor.numRegIdTrib = $('#NumRegIdTribReceptorComercioExt').val();

    if (($('#NumRegIdTribDestinatarioComercioExt').val() != "")|| ($('#rfcDestinatarioComercioExt').val() != "")||
       ($('#curpDestinatarioComercioExt').val() != "")|| ($('#nombreDestinatarioComercioExt').val() != "")){
      comercioExterior.destinatario = new Object();
      if ( $('#NumRegIdTribDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.numRegIdTrib = null;
      }
      else{
        comercioExterior.destinatario.numRegIdTrib = $('#NumRegIdTribDestinatarioComercioExt').val();
      }
      if ( $('#rfcDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.rfc = null;
      }
      else{
        comercioExterior.destinatario.rfc = $('#rfcDestinatarioComercioExt').val();
      }
      if ( $('#curpDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.curp = null;
      }
      else{
        comercioExterior.destinatario.curp = $('#curpDestinatarioComercioExt').val();
      }
      if ( $('#nombreDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.nombre = null;
      }
      else{
        comercioExterior.destinatario.nombre = $('#nombreDestinatarioComercioExt').val();
      }
      comercioExterior.destinatario.domicilio = new Object();
      if ( $('#calleDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.domicilio.calle = null;      
      }
      else{
        comercioExterior.destinatario.domicilio.calle = $('#calleDestinatarioComercioExt').val();
      }
      
      if ( $('#numeroExteriorDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.domicilio.numeroExterior = null;
      }
      else{
        comercioExterior.destinatario.domicilio.numeroExterior = $('#numeroExteriorDestinatarioComercioExt').val();
      }
      if ( $('#numeroInteriorDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.domicilio.numeroInterior = null;
      }
      else{
        comercioExterior.destinatario.domicilio.numeroInterior = $('#numeroInteriorDestinatarioComercioExt').val();
      }
      if ( $('#coloniaDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.domicilio.colonia = null;
      }
      else{
        comercioExterior.destinatario.domicilio.colonia = $('#coloniaDestinatarioComercioExt').val();
      }
      if ( $('#localidadDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.domicilio.localidad = null;
      }
      else{
        comercioExterior.destinatario.domicilio.localidad = $('#localidadDestinatarioComercioExt').val();
      }
      if ( $('#referenciaDestinatarioComercioExt').val() == ""){
        comercioExterior.destinatario.domicilio.referencia = null;
      }
      else{
        comercioExterior.destinatario.domicilio.referencia = $('#referenciaDestinatarioComercioExt').val();
      }
      if ($('#paisDestinatarioComercioExt').val() == "ZZZ"){
        comercioExterior.destinatario.domicilio.estado = $('#estadoDestinatarioComercioExtAux').val();
        comercioExterior.destinatario.domicilio.localidad = $('#localidadDestinatarioComercioExtAux').val();
        comercioExterior.destinatario.domicilio.municipio = $('#municipioDestinatarioComercioExtAux').val();
        comercioExterior.destinatario.domicilio.codigoPostal = $('#codigoPostalDestinatarioComercioExtAux').val();
      }
      if ($('#paisDestinatarioComercioExt').val() == "MEX"){
        comercioExterior.destinatario.domicilio.estado = $('#estadoDestinatarioComercioExt').val();
        comercioExterior.destinatario.domicilio.localidad = $('#localidadDestinatarioComercioExt').val();
        comercioExterior.destinatario.domicilio.municipio = $('#municipioDestinatarioComercioExt').val();
        comercioExterior.destinatario.domicilio.codigoPostal = $('#codigoPostalDestinatarioComercioExt').val(); 
        comercioExterior.destinatario.domicilio.colonia = $('#coloniaDestinatarioComercioExt').val();
      }
      else{
        comercioExterior.destinatario.domicilio.estado = $('#estadoDestinatarioComercioExt').val();
        if ( $('#localidadDestinatarioComercioExtAux').val() == ""){
          comercioExterior.destinatario.domicilio.localidad = null;
        }
        else{
          comercioExterior.destinatario.domicilio.localidad = $('#localidadDestinatarioComercioExtAux').val();
        }
        if ($('#municipioDestinatarioComercioExtAux').val() == undefined || $('#municipioDestinatarioComercioExtAux').val() == ""){
          comercioExterior.destinatario.domicilio.municipio = null;
        }
        else{
          comercioExterior.destinatario.domicilio.municipio = $('#municipioDestinatarioComercioExtAux').val();
        }
        comercioExterior.destinatario.domicilio.codigoPostal = $('#codigoPostalDestinatarioComercioExtAux').val();
        comercioExterior.destinatario.domicilio.colonia = $('#coloniaDestinatarioComercioExtAux').val();
      }
      comercioExterior.destinatario.domicilio.pais = $('#paisDestinatarioComercioExt').val();


    }

    if (mercancias.length > 0){
      comercioExterior.mercancias = new Object();
      comercioExterior.mercancias.mercancia = new Array();
      comercioExterior.mercancias.mercancia = mercancias;
      comercioExterior.mercancias.mercancia.descripcionesEspecificas = new Object();
      comercioExterior.mercancias.mercancia.descripcionesEspecificas = descripcionesEsp;    
    }
    
	  return comercioExterior;
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

function validarImpuestosLocales() {
	var impuestosLocales = new Object();
	impuestosLocales.retencionesLocales = new Object();
	impuestosLocales.retencionesLocales.retencionesLocales = new Array();
	impuestosLocales.trasladosLocales = new Object();
	impuestosLocales.trasladosLocales.trasladosLocales = new Array();
	impuestosLocales.totalDeTraslados = 0;
	impuestosLocales.totalDeRetenciones = 0;
	var impLoc;
	for ( var i = 1; i <= 8; i++) {
		impLoc = $('.impLoc' + i).serializeObject();
		if ((impLoc.tasade == undefined) || (impLoc.tasade == "")) {
			return impuestosLocales;
		}
		if ((impLoc.importe == undefined) || (impLoc.importe == "")) {
			return impuestosLocales;
		}
    if ((impLoc.impLoc == undefined) || (impLoc.impLoc == "")) {
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
  if (listaMetodoPago.indexOf(",") > 0){
    comprobante.metodoDePago = listaMetodoPago.substring(0, listaMetodoPago.length-1);  
  }

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
  if ($('#estadoAux').val() !=""){
    comprobante.receptor.domicilio.estado = $('#estadoAux').val();  
  }
  
  delete comprobante.receptor.domicilio.estadoAux;  
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

  var estadodecuentacombustible = validarConsumoCombustiblesECC11();
	if (estadodecuentacombustible != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.estadodecuentacombustible = new Object();
		comprobante.complemento.estadodecuentacombustible.version = "1.1";
		comprobante.complemento.estadodecuentacombustible = estadodecuentacombustible;
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

  var aerolineas = validarAerolineas();
	if (aerolineas != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.aerolineas = aerolineas;
	}

  var divisas = validarDivisas();
	if (divisas != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.divisas = divisas;
	}

  var turista = validarTurista();
	if (turista != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.turista = turista;
	}

  var pfic = validarPFIC();
	if (pfic != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.pfic = pfic;
	}
 
	var ine = validarINE();
	if (ine != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.ine = ine;
	}
	
  var leyendasFisc = validarLeyendas();
	if (leyendasFisc != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.leyendasFisc = leyendasFisc;
	}

  var obrasArte = validarObrasArte();
	if (obrasArte != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.obrasarteantiguedades = obrasArte;
	}

  var certDestruccion = validarCertDestruccion();
	if (certDestruccion != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.certificadodedestruccion = certDestruccion;
	}

  var speis = validarSpeis();
	if (speis != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.complemento_SPEI = speis;
	}

  var comercioExterior = validarComercioExterior();
	if (comercioExterior != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.comercioExterior = comercioExterior;
	}

	if (mapImpuestosTraslados.length > 0) {
		var ivaIEPS = 0;
		comprobante.impuestos.totalImpuestosTrasladados = precise_round($('input[name=totalImpuestosTrasladados]').val(), numeroDecimales);
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
  
  if ($('#tipoProceso').val() =="Ordinario"){
      if ($('#tipoComite').val() == undefined || $('#tipoComite').val() == ""){
        alert("Para procesos de Tipo Ordinario se debe indicar el Tipo de Comité");        
        return false;
      }
    }

  if (($('#tipoProceso').val() =="Precampaña") || ($('#tipoProceso').val() =="Campaña")){
      if ( $('#tipoComite').val() != ""){
        alert("Para procesos de Tipo Precampaña o Campaña no se debe indicar el Tipo de Comité");        
        return false;
      }
      if ( $('#idContabilidad').val() != ""){
        alert("Para procesos de Tipo Precampaña o Campaña no se debe indicar la Clave de Contabilidad");        
        return false;
      }
      if ( ineEntidades.length < 1){
        alert("Para procesos de Tipo Precampaña o Campaña se debe agregar al menos una Entidad");        
        return false;
      }
    }
  if (($('#tipoComite').val() == "Ejecutivo Estatal") && ($('#idContabilidad').val() != ""))  {
    alert("Cuando el Tipo de Comité es Ejecutivo Estatal no se debe proporcionar la clave de Contabilidad");
    return false;
  }
  if (($('#tipoComite').val() == "Ejecutivo Estatal") && (ineEntidades.length < 1))  {
    alert("Cuando el Tipo de Comité es Ejecutivo Estatal debe agregarse al menos un elemento Entidad");
    return false;
  }
  if (($('#tipoComite').val() == "Directivo Estatal") && (ineEntidades.length < 1))  {
    alert("Cuando el Tipo de Comité es Directivo Estatal debe agregarse al menos un elemento Entidad");
    return false;
  }
  if ($('select[name=tipoBien]').val() != ''){
    if ($('select[name=tituloAdquirido]').val() == '')  {  
      alert("Debe seleccionar un valor del campo Titulo Adquirido");
      return false;
    }      
    if (($('select[name=tipoBien]').val() == '04') && ($('input[name=otrosTipoBien]').val() == ""))  {
      alert("Si se selecciona el valor Otros en el campo Tipo Bien, debe proporcionar información en el campo Otros Tipo Bien");
      return false;
    }
    if (($('select[name=tituloAdquirido]').val() == '05') && ($('input[name=otrosTituloAdquirido]').val() == ""))  {  
      alert("Si se selecciona el valor Otros en el campo Titulo Adquirido, debe proporcionar información en el campo Otros Titulo Adquirido");
      return false;
    } 
    if ($('input[name=fechaAdquisicion]').val() == '')  {  
      alert("Debe indicar la Fecha de Adquisición");
      return false;
    }      
    if ($('select[name=característicasDeObraoPieza]').val() == '')  {  
      alert("Debe seleccionar un valor del campo Características De Obra o Pieza");
      return false;
    }      
  }
  if ($('select[name=tipoSerie]').val() != ''){
    if ($('input[name=numFolDesVeh]').val() == '')  {  
      alert("Debe indicar el valor del campo Número de folio");
      return false;
    }      
    if ($('input[name=marcaCertDest]').val() == '') {
      alert("Debe indicar el valor del campo Marca");
      return false;
    }
    if ($('input[name=tipooClase]').val() == '') {
      alert("Debe indicar el valor del campo Tipo o Clase");
      return false;
    }
    if ($('input[name=anioCertDest]').val() == '')  {  
      alert("Debe indicar el valor del campo Año");
      return false;
    }      
    if ($('input[name=numPlacasCertDest]').val() == '')  {  
      alert("Debe indicar el valor del campo Número de Placas");
      return false;
    }
    if ($('input[name=numFolTarjCir]').val() == '')  {  
      alert("Debe indicar el valor del campo Folio Tarjeta de Circulación");
      return false;
    }
    if (($('input[name=numPedImp]').val() == '')&&($('input[name=fechaCertDest]').val() == '')&&($('input[name=aduanaCertDest]').val() == ''))  {      
    }
    else
      if (($('input[name=numPedImp]').val() != '')&&($('input[name=fechaCertDest]').val() != '')&&($('input[name=aduanaCertDest]').val() != ''))  {  
        }
      else{
        alert("Si proporciona información Aduanera debe indicar los 3 campos");
        return false;
      }      
  }

  if ($('#tipoOperacionComercioExt').val() != undefined && $('#tipoOperacionComercioExt').val() != "")  {
    if (($('#btnTipoComprobante').val() == "cr")||($('#btnTipoComprobante').val() == "ct")||($('#btnTipoComprobante').val() == "co")||($('#btnTipoComprobante').val() == "cp")||($('#btnTipoComprobante').val() == "cP")){
      alert("El Tipo de Comprobante debe ser de Ingreso, si se desea usar el Complemento de Comercio Exterior 1.0");
    	return false;
    }
    if ($('input[name=pais].emisorDomicilio').val() != "México") {
		  alert("El país del Emisor sólo puede ser México");
  		return false;
	  } 
    var re = new RegExp("^[0-9]{1,14}(\.([0-9]{1,6})?)?$");
    if (!re.test($('input[name=tipoCambio]').val())) {
		  alert("El tipo de cambio no cumple con el patrón [0-9]{1,14}(.([0-9]{1,6}))? establecido para el Complemento de Comercio Exterior 1.0");
  		return false;
	  } 
    if ($('input[name=rfc].receptor').val() != "XEXX010101000"){
      alert("El rfc del receptor debe ser XEXX010101000");
  		return false;
    }
    if ($('input[name=nombre].receptor').val() == ""){
      alert("Debe proporcionar el nombre del Receptor");
  		return false;
    }
     if ($('select[name=pais].receptorDomicilio').val() == "México"){
      alert("El país del Receptor debe ser diferente de México");
  		return false;
    }
    if ($('#tipoOperacionComercioExt').val() =="A"){
      if (($('#clavePedimento').val() !="")||($('#certificadoOrigen').val() !="")||($('#numCertificadoOrigen').val() !="")||    ($('#numExportadorConfiable').val() !="")||($('#Incoterm').val() !="")||($('#Subdivision').val() !="")||($('#TipoCambioUSD').val() !="")|| (mercancias.length > 0))  {
      alert("Si la clave registrada en el campo Tipo Operación es {A}, no deben existir los siguientes atributos: [ClaveDePedimento], [CertificadoOrigen], [NumCertificadoOrigen], [NumExportadorConfiable], [Incoterm], [Subdivisión], [TipoCambioUSD], [TotalUSD] y [Mercancias]");
      return false;
      }      
    }  //tipoOperacion es A  

    if (($('#tipoOperacionComercioExt').val() =="1")||($('#tipoOperacionComercioExt').val() =="2")){
      if (($('#clavePedimento').val() =="")||($('#certificadoOrigen').val() =="")||($('#Incoterm').val() =="")||($('#Subdivision').val() =="")||($('#TipoCambioUSD').val() =="")|| (mercancias.length < 1))  {
      alert("Si la clave registrada en el campo Tipo Operación es {1} ó {2}, deben existir los siguientes atributos: [ClaveDePedimento],[CertificadoOrigen], [Incoterm], [Subdivision], [TipoCambioUSD], [TotalUSD] y [Mercancias]");
      return false;
      }
      if (($('select[name=certificadoOrigen]').val() == "0")&&($('input[name=numCertificadoOrigen]').val() != "")){
        alert("Para el valor del campo Certificado Origen seleccionado no se debe registrar el campo Número Certificado Origen");
    		return false;
      }
      if (!validaNoIdentificacionConcepto()){
        alert("Cada concepto registrado en el elemento cfdi:Comprobante:Conceptos, debe tener registrado el atributo cfdi:Comprobante:Conceptos:Concepto:noIdentificacion, favor de verificar");
     		return false;
      }
      if (!validaNoIdentificacionConceptoRepetido()){
        alert("No se debe repetir el valor del atributo cfdi:Comprobante:Conceptos:Concepto:noIdentificacion, favor de verificar");
     		return false;
      }
      if (!validaNoIdentificacionConceptoYMercancia()){
        alert("Por cada concepto registrado en el elemento cfdi:Comprobante:Conceptos, debe existir una mercancía en el complemento cce:ComercioExterior, donde el atributo cce:ComercioExterior:Mercancias:Mercancia:NoIdentificacion sea igual al atributo cfdi:Comprobante:Conceptos:Concepto:noIdentificacion");
     		return false;
      }
      if (!validaFraccionArancelaria98010001()){
        alert("El valor del atributo cfdi:Comprobante:descuento debe ser mayor o igual a la suma de los campos cce:ComercioExterior:Mercancias:Mercancia:ValorDolares de todas las mercancías que tienen la fracción arancelaria 98010001 - (Importaciones o exportaciones de muestras y muestrarios)");
     		return false;
      }
      if (!validaCantidadUnidadValorUnitarioAduana()){
        alert("Si un elemento cce:ComercioExterior:Mercancias:Mercancia tiene los atributos CantidadAduana, UnidadAduana y ValorUnitarioAduana, entonces todos los elementos mercancía del comprobante deben tener los tres atributos.");
     		return false;
      }      
    }//tipoOperacion es 1 o 2

    
    if (($('input[name=rfc].emisor').val().length == 12)&&($('input[name=curpEmisorComercioExt]').val() != "")){
		  alert("Si el atributo [rfc] del nodo cfdi:Comprobante:Emisor es de longitud 12, entonces el campo cce:ComercioExterior:Emisor:Curp no debe existir.");
  		return false;
	  }

    if (($('select[name=pais].receptorDomicilio').val() == "Canadá")||($('select[name=pais].receptorDomicilio').val() == "Estados Unidos (los)")){
      var re = new RegExp("[0-9]{9}$");
      if (!re.test($('input[name=NumRegIdTribReceptorComercioExt]').val())) {
  		  alert("El campo Número de Identificación o Registro fiscal del Receptor no cumple con el patrón [0-9]{9} establecido ");
    		return false;
	    } 
    }

    if ($('select[name=paisDestinatarioComercioExt]').val() != "default"){
      if (($('input[name=NumRegIdTribDestinatarioComercioExt]').val() == "")&&($('input[name=rfcDestinatarioComercioExt]').val() == "")){
  		  alert("Debe existir al menos uno de los atributos [NumRegIdTrib] o [Rfc] de Destinatario");
    		return false;
  	  }
      if ($('input[name=NumRegIdTribDestinatarioComercioExt]').val() != ""){
        if (($('select[name=paisDestinatarioComercioExt]').val() == "CAN")||($('select[name=paisDestinatarioComercioExt]').val() == "USA")){
          var re = new RegExp("[0-9]{9}$");
          if (!re.test($('input[name=NumRegIdTribDestinatarioComercioExt]').val())) {
      	    alert("El campo Número de Identificación o Registro fiscal del Destinatario no cumple con el patrón [0-9]{9} establecido ");
       	  	return false;
  	      } 
        }
      }
      if ($('input[name=rfcDestinatarioComercioExt]').val() != ""){
        if ($('input[name=rfcDestinatarioComercioExt]').val() != ""){
          if (($('input[name=rfcDestinatarioComercioExt]').val() == "XAXX010101000")||($('input[name=rfcDestinatarioComercioExt]').val() == "XEXX010101000")){
	      	  alert("Si se desea registrar información en el campo cce:ComercioExterior:Destinatario:Rfc, no debe usar un rfc genérico");
        		return false;
	        }
        }
      }
      if ($('select[name=paisDestinatarioComercioExt]').val() == "CAN"){
        if (!validateCodigoPostalCanada($('input[name=codigoPostalDestinatarioComercioExtAux]').val())){
          alert("El Código Postal del país no cumple con el patrón [A-Z][0-9][A-Z] [0-9][A-Z][0-9]");
       		return false;
        }
      }
      if ($('select[name=paisDestinatarioComercioExt]').val() == "USA"){
        if (!validateCodigoPostalEEUU($('input[name=codigoPostalDestinatarioComercioExtAux]').val())){
          alert("El Código Postal del país no cumple con el patrón [0-9]{5}(-[0-9]{4})?");
       		return false;
        }
      }
    }
    
    
    

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

function validaEstado() {
	if ($('select[name=estado]').val() =='Otro') {
    $('input[name=estadoAux]').val("");
    $('.divEstadoAux').show(0);
    $('.divEstado').hide(1);
	}
  else{
    $('.divEstadoAux').hide(1); 
    $('.divEstado').show(0);
  }
}

function validaPais() {
  $('input[name=estadoAux]').val("");
	if ($('select[name=pais]').val() =='Países no declarados') {
    $('.divEstadoAux').show(0);
    $('.divEstado').hide(1);
	}
  else{
    $('.divEstadoAux').hide(1); 
    $('.divEstado').show(0);
  }
}

function validaPaisDestinatarioCCE() {
	if ($('select[name=paisDestinatarioComercioExt]').val() =='ZZZ') {
    $('.divEstadoDestinatarioComercioExtAux').show(0);
    $('.divEstadoDestinatarioComercioExt').hide(1);
	}
  else{
    $('.divEstadoDestinatarioComercioExtAux').hide(1); 
    $('.divEstadoDestinatarioComercioExt').show(0);
  }
  
  if ($('select[name=paisDestinatarioComercioExt]').val() =='MEX') {
    $('.divLocalidadDestinatarioComercioExt').show(0);
    $('.divLocalidadDestinatarioComercioExtAux').hide(1);
    $('.divMunicipioDestinatarioComercioExt').show(0);
    $('.divMunicipioDestinatarioComercioExtAux').hide(1);
    $('.divCodigoPostalDestinatarioComercioExt').show(0);
    $('.divCodigoPostalDestinatarioComercioExtAux').hide(1);
    $('.divColoniaDestinatarioComercioExt').show(0);
    $('.divColoniaDestinatarioComercioExtAux').hide(1);
	}
  else{
    $('.divLocalidadDestinatarioComercioExt').hide(1);
    $('.divLocalidadDestinatarioComercioExtAux').show(0);
    $('.divMunicipioDestinatarioComercioExt').hide(1);
    $('.divMunicipioDestinatarioComercioExtAux').show(0);
    $('.divCodigoPostalDestinatarioComercioExt').hide(1);
    $('.divCodigoPostalDestinatarioComercioExtAux').show(0);
    $('.divColoniaDestinatarioComercioExt').hide(1);
    $('.divColoniaDestinatarioComercioExtAux').show(0);
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

          $('#fechaTransito').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaAdquisicion').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});
          
          $('#fechaCertDest').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaExpOperECC11').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaSpei').datepicker({
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

          $('select[name=estado]').click(function() {
						validaEstado();
					});

          $('select[name=pais]').click(function() {
						validaPais();
					});
    
          $('select[name=paisDestinatarioComercioExt]').click(function() {
						validaPaisDestinatarioCCE();
					});

					$('#btnAgregarConcepto').click(function() {
						agregarConcepto();
						return false;
					});

          $('#btnAgregarMetodoPago').click(function() {
						agregarMetodoPago();
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


          $('#paisDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI/rest/estado/listarEstados/'+$(this).val(), {}, function(responseText) {
        				  $('#estadoDestinatarioComercioExt').html(responseText);
  			        });    
              }
            });

          $('#estadoDestinatarioComercioExt').change(
            function() {    
              if ($('#paisDestinatarioComercioExt').val() != "ZZZ") {
         			  $.get('/CFDI/rest/estado/listarMunicipios/'+$(this).val(), {}, function(responseText) {
        				  $('#municipioDestinatarioComercioExt').html(responseText);
  			        });    
                $.get('/CFDI/rest/estado/listarLocalidades/'+ $(this).val(), {}, function(responseText) {
        				  $('#localidadDestinatarioComercioExt').html(responseText);
  			        });    
              }
            }); 

            $('#municipioDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI/rest/estado/listarCodigosPostalesEstadoMunicipio/'+$('#estadoDestinatarioComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalDestinatarioComercioExt').html(responseText);
  			        });    
              }
            });

            $('#localidadDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI/rest/estado/listarCodigosPostalesEstadoMunicipioLocalidad/'+$('#estadoDestinatarioComercioExt').val()+'/'+$('#municipioDestinatarioComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalDestinatarioComercioExt').html(responseText);
  			        });    
              }
            });

             $('#codigoPostalDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI/rest/estado/listarColonias/'+$(this).val(), {}, function(responseText) {
        				  $('#coloniaDestinatarioComercioExt').html(responseText);
  			        });    
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

          $.validator.addMethod("regexNumCertificadoOrigen", function(value, element,
			    regexp) {
    		    var re = new RegExp(regexp);
		      return this.optional(element) || re.test(value);
	        }, "Ingrese un Número de Certificado Origen válido.");

          $.validator.addMethod("regexValor", function(value, element,
			    regexp) {
    		    var re = new RegExp(regexp);
		      return this.optional(element) || re.test(value);
	        }, "Ingrese un Valor válido.");


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

          $.validator.addMethod("horas", function(value, element,	regexp) {
        		var re = new RegExp(regexp);
        		return this.optional(element) || re.test(value);
          	}, "Ingrese una hora v\u00e1lida.");								

          $('input[name=precioUnitario]').change(function() {  
					  $('input[name=importeCombustible]').val(redondearValor2($('input[name=volumen]').val()*$('input[name=precioUnitario]').val()));
					});

          $('input[name=precioUnitarioECC11]').change(function() {  
					  $('input[name=importeCombustibleECC11]').val(redondearValor2($('input[name=cantidadConceptoECC11]').val()*$('input[name=precioUnitarioECC11]').val()));
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
												maxlength : 10
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
                      tua : {
												required : false,
                        numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
											},
                      importeCargo : {
												required : false,
                        numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
											},
                      horaTransito: {
												required : false,
                        horas : "^(?:(?:([01]?[0-9]|2[0-3]):)?([0-5]?[0-9]):)?([0-5]?[0-9])$"
											},
                      RFCPF : {
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
											},
                      cantidadConceptoECC11 : {
						            required : false,
						            numeroDec : "^[0-9]{1,14}(\.([0-9]{1,3})?)?$"
					            },
                      precioUnitarioECC11: {
						            required : false,
						            numeroDec : "^[0-9]{1,14}(\.([0-9]{1,3})?)?$"
					            },
                      importeECC11: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      tasaoCuotaECC11: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      importeTrasladoECC11: {
						            required : false,
						            numeroDec : "^[0-9]{1,14}(\.([0-9]{1,2})?)?$"
					            },
                      horaConsumoCombustiblesECC11: {
												required : false,
                        hora : "^(2[0-3]|[01]{1}?[0-9]):([012345]{1}?[0-9]):([012345]{1}?[0-9])$"
											},
                      rfcEmisorSpei : {
												minlength : 2,
												maxlength : 13
											},
                      rfcReceptorSpei : {
												minlength : 2,
												maxlength : 13
											},
                      horaSpei: {
												required : false,
                        hora : "^(2[0-3]|[01]{1}?[0-9]):([012345]{1}?[0-9]):([012345]{1}?[0-9])$"
											},
                      numCertificadoOrigen : {
												required : false,
                        minlength : 6,
												maxlength : 40,
                     regexNumCertificadoOrigen : "[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}|[A-Za-z0-9,#,+,%,(&) ]{6,40}"
											},
                      TipoCambioUSD : {
												required : false,
                        numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
											},
                      TotalUSD : {
												required : false,
                        numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
											},
                      curpEmisorComercioExt:{
             						regexCurp : "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]?"
		            			},
                      curpReceptorComercioExt:{
             						regexCurp : "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]?"
		            			},
                      NumRegIdTribReceptorComercioExt : {
												required : false,
                        minlength : 6,
												maxlength : 40
											},
                      NumRegIdTribDestinatarioComercioExt : {
												required : false,
                        minlength : 6,
												maxlength : 40
											},
                      rfcDestinatarioComercioExt : {
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z,\u00D1,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?"
											},
                      curpDestinatarioComercioExt:{
             						regexCurp : "[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]?"
		            			},
                      CantidadAduanaMercanciaComercioExt:{
                        numeroDec : "^[0-9]{1,14}(\.([0-9]{1,3})?)?$"
		            			},
                      ValorUnitarioAduanaMercanciaComercioExt:{
                        numeroDec : "^[0-9]{1,16}(\.([0-9]{1,2})?)?$"
		            			},
                      ValorDolaresMercanciaComercioExt:{
                        numeroDec : "^[0-9]{1,16}(\.([0-9]{1,2})?)?$"
		            			}
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

$('#btnConceptoConsumoCombustiblesECC11').click(function() {
  if (validaConceptoConsumoCombustiblesECC11() == true){
		var conceptoConsumoCombustibles = $('.conceptoConsumoCombustiblesECC11').serializeObject();
		conceptosConsumoCombustibles.push(conceptoConsumoCombustibles);
		graficarConceptoConsumoCombustibles();
    $('input[name=identificadorECC11]').val('');
    $('input[name=fechaExpOperECC11]').val('');
    $('input[name=rfcEnajCombustibleECC11]').val('');
    $('input[name=claveEstacionECC11]').val('');
    $('input[name=tarECC11]').val('');
    $('input[name=cantidadConceptoECC11]').val('');
    $('input[name=noIdentificacionConceptoECC11]').val('');
    $('input[name=unidadConceptoECC11]').val('');
    $('input[name=nombreCombustibleECC11]').val('');
    $('input[name=folioOperacionECC11]').val('');
    $('input[name=precioUnitarioECC11]').val('');
    $('input[name=importeCombustibleECC11]').val('');

	}
})

$('#btnTrasladosConsumoCombustibles').click(function() {
  if (validaTrasladosConsumoCombustibles() == true){
		var trasladoConsumoCombustibles = $('.trasladoConsumoCombustiblesECC11').serializeObject();
		trasladosConsumoCombustibles.push(trasladoConsumoCombustibles);
		graficarDeterminadosConsumoCombustibles();
    $('input[name=impuestoTrasladoECC11]').val('');
    $('input[name=tasaoCuotaECC11]').val('');
    $('input[name=importeTrasladoECC11]').val('');

	}
})

$('#addConceptoECC11').click(function(){
  if (trasladosConsumoCombustibles.length > 0){
	      var conceptoConsumoCombustibles = $('.conceptoConsumoCombustiblesECC11').serializeObject();
        if ($('select[name=tarECC11]').val() == "") {
            conceptoConsumoCombustibles.tarECC11 = null;
        }    
        else{
          conceptoConsumoCombustibles.tarECC11 = $('select[name=tarECC11]').val();
        }
        if ($('input[name=unidadConceptoECC11]').val() == "") {
            conceptoConsumoCombustibles.unidadConceptoECC11 = null;
        }    
        else{
          conceptoConsumoCombustibles.unidadConceptoECC11 = $('input[name=unidadConceptoECC11]').val();
        }
        conceptoConsumoCombustibles.fechaExpOper = $('input[name=fechaExpOperECC11]').val() + "T" + $('input[name=horaConsumoCombustiblesECC11]').val();
        conceptoConsumoCombustibles.traslados = new Object();
        conceptoConsumoCombustibles.traslados.traslado = trasladosConsumoCombustibles;
	      conceptosConsumoCombustibles.push(conceptoConsumoCombustibles);
 	      alert("Concepto Agregado.");
        subtotalCombustiblesECC11 = redondearValor2(eval(subtotalCombustiblesECC11) + eval($('input[name=importeCombustibleECC11]').val()));
        totalCombustiblesECC11 = eval(totalImportesECC11) + eval(subtotalCombustiblesECC11);
        $('input[name=subTotalCombustiblesECC11]').val(subtotalCombustiblesECC11);
        $('input[name=totalCombustiblesECC11]').val(totalCombustiblesECC11);
        $('input[name=identificadorECC11]').val('');
        $('input[name=fechaExpOperECC11]').val('');
        $('input[name=horaConsumoCombustiblesECC11]').val('');
        $('input[name=rfcEnajCombustibleECC11]').val('');
        $('input[name=claveEstacionECC11]').val('');
        $('select[name=tarECC11]').val('');
        $('input[name=cantidadConceptoECC11]').val('');
        $('select[name=noIdentificacionConceptoECC11]').val('');
        $('input[name=unidadConceptoECC11]').val('');
        $('input[name=nombreCombustibleECC11]').val('');
        $('input[name=folioOperacionECC11]').val('');
        $('input[name=precioUnitarioECC11]').val('');
        $('input[name=importeCombustibleECC11]').val('');
        trasladosConsumoCombustibles = new Array();
  }
  else{
    alert("Debe agregar los Impuestos Trasladados antes de agregar el Concepto");
  }
})

$('#addTrasladoECC11').click(function(){
if (($('#btnTipoComprobante').val() == "cr")||($('#btnTipoComprobante').val() == "ct")||($('#btnTipoComprobante').val() == "co")||($('#btnTipoComprobante').val() == "cp")||($('#btnTipoComprobante').val() == "cP")){
  alert("El Tipo de Comprobante debe ser de Ingreso, si se desea usar el Complemento de Estado de Cuenta de Combustibles para Monederos Electrónicos Autorizados por el SAT");
}
else{
  if (validaConceptoConsumoCombustiblesECC11() == true){
    if (validaTrasladosConsumoCombustibles() == true){
	    var trasladoConsumoCombustibles = $('.trasladoConsumoCombustiblesECC11').serializeObject();
	    trasladosConsumoCombustibles.push(trasladoConsumoCombustibles);
	    alert("Traslado de Impuesto Agregado.");
      totalImportesECC11 = redondearValor2(eval(totalImportesECC11) + eval(trasladoConsumoCombustibles.importeTrasladoECC11));
      $('input[name=impuestoTrasladoECC11]').val('');
      $('input[name=tasaoCuotaECC11]').val('');
      $('input[name=importeTrasladoECC11]').val('');
    }
  }
  else{
    alert("Debe agregar antes la información sobre el Concepto de Consumo de Combustibles");
  }
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

$('#addCargoAerolineas').click(function(){
    if (validaCargoAerolineas() == true){
      totalCargos = eval(totalCargos) + eval($('input[name=importeCargo').val())
      $('input[name=TotalCargos]').val(eval(totalCargos));
	    var Cargo = $('.cargoAerolineas').serializeObject();
	    cargoAerolineas.push(Cargo);
	    alert("Cargo Agregado.");
      $('input[name=importeCargo]').val('');
      $('input[name=codigoCargo]').val('');
    }

})

$('#btnINEEntidades').click(function(){
    if (validaEntidadesINE() == true){
      var ineEntidad = new Object();
      ineEntidad.claveEntidad = $('#claveEntidad').val();

      if ($('#ambito').val() == "") {
        ineEntidad.ambito = null;
      }    
      else{
        ineEntidad.ambito = $('#ambito').val();
      }
      

      ineEntidad.contabilidad = ineContabilidad;
      ineContabilidad = new Array();
	    ineEntidades.push(ineEntidad);
	    alert("Entidad Agregada.");
      $('input[name=idContabilidadEstatal]').val('');
      $('select[name=ambito]').val('');
      $('select[name=claveEntidad]').val('');
    }

})

$('#btnContabilidadEstatal').click(function(){
      var contabilidad = new Object();
      contabilidad.idContabilidad = $('#idContabilidadEstatal').val();
	    ineContabilidad.push(contabilidad);
	    alert("Clave de Contabilidad Agregada.");

})

$('#addLeyendas').click(function(){
    if (validaLeyendas() == true){
	    var leyenda = $('.leyendas').serializeObject();
      if ($('#disposicionFiscal').val() == "") {
        leyenda.disposicionFiscal = null;
      }    
      else{
        leyenda.disposicionFiscal = $('#disposicionFiscal').val();
      }
      if ($('#norma').val() == "") {
        leyenda.norma = null;
      }    
      else{
        leyenda.norma = $('#norma').val();
      }
	    leyendas.push(leyenda);
	    alert("Leyenda Agregada.");
      $('input[name=disposicionFiscal]').val('');
      $('input[name=norma]').val('');
      $('input[name=textoLeyenda]').val('');
    }

})

$('#addSpei').click(function(){
    if (validaSpei() == true){
	    var spei = $('.spei').serializeObject();
 	    var ordenante = $('.ordenante').serializeObject();
      spei.ordenante = ordenante;
      var beneficiario = $('.beneficiario').serializeObject();
      spei.beneficiario = beneficiario;
      if ($('#ivaSpei').val() == "") {
        spei.beneficiario.ivaSpei = null;
      }    
      else{
        spei.beneficiario.ivaSpei = $('#ivaSpei').val();
      }
	    SPEI_Tercero.push(spei);
	    alert("SPEI Agregado.");
      $('input[name=fechaSpei]').val('');
      $('input[name=horaSpei]').val('');
      $('input[name=claveSpei]').val('');
      $('input[name=selloSpei]').val('');
      $('input[name=numeroCertificado]').val('');
      $('input[name=cadenaCDA]').val('');
      $('input[name=bancoOrdenante]').val('');
      $('input[name=nombreOrdenanteSpei]').val('');
      $('input[name=tipoCuentaOrdenanteSpei]').val('');
      $('input[name=cuentaOrdenanteSpei]').val('');
      $('input[name=rfcOrdenanteSpei]').val('');
      $('input[name=bancoReceptor]').val('');
      $('input[name=nombreBeneficiarioSpei]').val('');
      $('input[name=tipoCuentaBeneficiarioSpei]').val('');
      $('input[name=cuentaBeneficiarioSpei]').val('');
      $('input[name=rfcBeneficiarioSpei]').val('');
      $('input[name=conceptoSpei]').val('');
      $('input[name=ivaSpei]').val('');
      $('input[name=montoSpei]').val('');
    }

})

$('#btnMercancias').click(function(){
  if (validaMercancia() == true){
    var mercancia = new Object();
    mercancia.noIdentificacion = $('#NoIdentificacionMercanciaComercioExt').val();
    if ( $('#FraccionArancelariaMercanciaComercioExt').val() == "default"){
      mercancia.fraccionArancelaria = null;
    }
    else{
      mercancia.fraccionArancelaria = $('#FraccionArancelariaMercanciaComercioExt').val();
    }
    if ( $('#CantidadAduanaMercanciaComercioExt').val() == ""){
      mercancia.cantidadAduana = null;
    }
    else{
      mercancia.cantidadAduana = $('#CantidadAduanaMercanciaComercioExt').val();
    }
    if ( $('#UnidadAduanaMercanciaComercioExt').val() == "default"){
      mercancia.unidadAduana = null;
    }
    else{
      mercancia.unidadAduana = $('#UnidadAduanaMercanciaComercioExt').val();
    }
    if ( $('#ValorUnitarioAduanaMercanciaComercioExt').val() == ""){
      mercancia.valorUnitarioAduana = null;
    }
    else{
      mercancia.valorUnitarioAduana = $('#ValorUnitarioAduanaMercanciaComercioExt').val();
    }      
    mercancia.valorDolares = $('#ValorDolaresMercanciaComercioExt').val();  
    if ($('input[name=ValorDolaresMercanciaComercioExt]').val() != ""){
      $('input[name=TotalUSD]').val(new Number(eval($('input[name=TotalUSD]').val())+eval($('input[name=ValorDolaresMercanciaComercioExt]').val())).toFixed(2));
    }
    mercancia.descripcionesEspecificas = descripcionesEsp;
    descripcionesEsp = new Array();
    mercancias.push(mercancia);
    alert("Mercancia Agregada.");
    graficarMercancia();
    $('input[name=NoIdentificacionMercanciaComercioExt]').val('');
    $('select[name=FraccionArancelariaMercanciaComercioExt]').val('');
    $('input[name=CantidadAduanaMercanciaComercioExt]').val('');
    $('select[name=UnidadAduanaMercanciaComercioExt]').val('');
    $('input[name=ValorUnitarioAduanaMercanciaComercioExt]').val('');
    $('input[name=ValorDolaresMercanciaComercioExt]').val('');
  }
})

$('#btnDescripcionesEspecificas').click(function(){
    if ($('#tipoOperacionComercioExt').val() =="A"){
      alert("Para el Complemento de Comercio Exterior si el Tipo de Operación es Exportación de Servicios, no se pueden ingresar Mercancias");
    }
    else{
      var descEspecifica = new Object();
      descEspecifica.marca = $('#marcaDescripcionComercioExt').val();
      if ( $('#modeloDescripcionComercioExt').val() == ""){
        descEspecifica.modelo = null;
      }
      else{
        descEspecifica.modelo = $('#modeloDescripcionComercioExt').val();
      }
      if ( $('#submodeloDescripcionComercioExt').val() == ""){
        descEspecifica.subModelo = null;
      }
      else{
        descEspecifica.subModelo = $('#submodeloDescripcionComercioExt').val();
      }
      if ( $('#numeroSerieDescripcionComercioExt').val() == ""){
        descEspecifica.numeroSerie = null;
      }
      else{
        descEspecifica.numeroSerie = $('#numeroSerieDescripcionComercioExt').val();
      }
	    descripcionesEsp.push(descEspecifica);
      alert("Descripción Específica Agregada.");
    }
  $('input[name=marcaDescripcionComercioExt]').val('');
  $('input[name=modeloDescripcionComercioExt]').val('');
  $('input[name=submodeloDescripcionComercioExt]').val('');
  $('input[name=numeroSerieDescripcionComercioExt]').val('');
})
});


function validateCodigoPostalCanada(cp){
  var codPostRegExp = new RegExp('[A-Z][0-9][A-Z] [0-9][A-Z][0-9]');
  return codPostRegExp.test(cp);
}
function validateCodigoPostalEEUU(cp){
  var codPostRegExp = new RegExp('[0-9]{5}-[0-9]{4}');
  return codPostRegExp.test(cp);
}

function validaNoIdentificacionConcepto(){
  var valido = true;
  for ( var i = 0; i < mapConceptos.length; i++) {  
    if (mapConceptos[i].clave == undefined){
      valido = false;
      break;
    }
  }
  return valido;
}

function validaNoIdentificacionConceptoRepetido(){
  var valido = true;
  var claveTemp = mapConceptos[0].clave;
  for ( var i = 1; i < mapConceptos.length; i++) {  
    if (claveTemp == mapConceptos[i].clave){
      valido = false;
      break;
    }
  }
  return valido;
}

function validaNoIdentificacionConceptoYMercancia(){
  var valido = true;
  if (mapConceptos.length != mercancias.length ){
    valido = false;
  }
  var arrConceptos = new Array();
  var arrMercancias = new Array();
  for ( var i = 0; i < mapConceptos.length; i++) {  
    arrConceptos[i] = mapConceptos[i].clave;
  }

  for ( var i = 0; i < mercancias.length; i++) {  
    arrMercancias[i] = mercancias[i].noIdentificacion;
  }

  valido = are_arrs_equal(arrConceptos, arrMercancias);
  
  return valido;
}

function are_arrs_equal(arr1, arr2){
    return arr1.sort().toString() === arr2.sort().toString()
}

function validaCantidadConcepto(clave){
  var valido = true;
  for ( var i = 0; i < mapConceptos.length; i++) {  
    if (clave == mapConceptos[i].clave){
      if (mapConceptos[i].cantidad < 0.001){
        valido = false;
        break;
      }
      var re = new RegExp("^[0-9]{1,14}(\.([0-9]{1,3})?)?$");
      if (!re.test(mapConceptos[i].cantidad)) {
        valido = false;
        break;
      } 

    }
  }
  return valido;
}

function validaValorUnitarioConcepto(clave){
  var valido = true;
  for ( var i = 0; i < mapConceptos.length; i++) {  
    if (clave == mapConceptos[i].clave){
      if (mapConceptos[i].valorUnitario < 0.001){
        valido = false;
        break;
      }
      var re = new RegExp("^[0-9]{1,16}(\.([0-9]{1,4})?)?$");
      if (!re.test(mapConceptos[i].valorUnitario)) {
        valido = false;
        break;
      } 

    }
  }
  return valido;
}


function validaFraccionArancelaria98010001(){
  var valido = true;
  var valorDolares = 0;
  for ( var i = 0; i < mercancias.length; i++) {  
    if (mercancias[i].fraccionArancelaria == '98010001'){
      valorDolares = valorDolares + mercancias[i].valorDolares;
    }
  }
  if (valorDolares != 0){
    if (descuento < valorDolares){
      valido = false;
    }
  }

  return valido;
}


function calculaValorDolares(clave){
  var producto = 0;
  for ( var i = 0; i < mapConceptos.length; i++) {  
    if (clave == mapConceptos[i].clave){
      producto = redondearValor2((mapConceptos[i].cantidad * mapConceptos[i].valorUnitario * eval($('#tipoCambio').val()) / eval($('#TipoCambioUSD').val())));
      return producto;
    } 
  }
}

function validaCantidadUnidadValorUnitarioAduana(){
  var valido = true;
  if (mercancias.length < 2){
    return valido;
  }
  var bandera = false;
  for ( var i = 0; i < mercancias.length; i++) {  
    if ((mercancias[i].cantidadAduana != null)&&(mercancias[i].unidadAduana != null)&&(mercancias[i].valorUnitarioAduana != null)){
      bandera = true;
      break;
    }
  }
  if (bandera){
    for ( var i = 0; i < mercancias.length; i++) {  
      if ((mercancias[i].cantidadAduana == null)||(mercancias[i].unidadAduana == null)||(mercancias[i].valorUnitarioAduana == null)){
        valido = false;
        return valido;
        break;
      }
    }      
  return valido
  }
  else{
    return valido;
  } 
}
