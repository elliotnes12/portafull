var totalIVA = 0;
var mapConceptos = new Array();
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
var totalImpuestosTrasladados = 0;
var totalImpuestosRetenidos = 0;
var subtotalCombustibles = 0;
var totalCombustibles = 0;
var totalImportes = 0;
var subtotalCombustiblesECC12 = 0;
var totalCombustiblesECC12 = 0;
var totalImportesECC12 = 0;
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
var cfdiRelacionadoArr = new Array();
var trasladoConceptoArr = new Array();
var retencionConceptoArr = new Array();
var trasladoArr = new Array();
var retencionArr = new Array();
var informacionAduaneraConceptoArr = new Array();
var informacionAduaneraParteArr = new Array();
var partesConcepto = new Array();
var arrayRegimenesMorales = ["601","603","609","610","620","622","623","624","628","607"];
var arrayRegimenesFisicas = ["605","606","608","610","611","612","614","616","621","622","629","630","615"];
var arrayUsoCFDIPersonasMorales = ["D01","D02","D03","D04","D05","D06","D07","D08","D09","D10"];
var doctoRelacionadoArr = new Array();
var trasladoPagoArr = new Array();
var retencionPagoArr = new Array();
var pagosArr = new Array();
var doctosRelacionadosArr = new Array();
var propietarios = new Array();
var domiciliosDestinatario = new Array();
var destinatarios = new Array();
var arrayUnidadAduana = ["01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","99"];
var usadosRenovacion = new Array();
var objEdit;
var indiceConceptoEditar;
var indiceTrasladoEditar;
var indiceRetencionEditar;
var blnTrasladoEliminar;
var blnRetencionEliminar;
var blnTrasladoAgregar;
var blnRetencionAgregar;
var indiceInformacionAduaneraConcepto;
var indiceParteConcepto;
var indiceInformacionAduaneraParte;
var indiceUUIDRelacionado;

function validaDeterminadosConsumoCombustibles(){
  if ($('input[name=tipoImpuesto]').val() == "") {
		alert("Debe seleccionar el Tipo de Impuesto");
		$('#tipoImpuesto').focus();
		return false;
	}
  if ($('input[name=tasaImpuesto]').val() == "") {
		alert("Debe introducir la Tasa o Cuota del Impuesto");
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
  if ($('input[name=horaExpOper]').val() == "") {
		alert("Debe introducir la Hora");
		$('#horaExpOper').focus();
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
  if ($('#tipoCombustibleCC11').val() == "")  {
		alert("Debe seleccionar la clave del tipo de combustible");
		$('#tipoCombustibleCC11').focus();
		return false;
	}
  if ($('input[name=volumen]').val() == "") {
		alert("Debe introducir la Cantidad");
		$('#volumen').focus();
		return false;
	}
  if ($('input[name=volumen]').val() < 0.001) {
		alert("El volumen de combustible debe ser mayor o igual a 0.001");
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

function validaTrasladosConsumoCombustibles12(){
  if ($('input[name=impuestoTrasladoECC12]').val() == "") {
		alert("Debe seleccionar el Tipo de Impuesto Trasladado");
		$('#impuestoTrasladoECC12').focus();
		return false;
	}
  if ($('input[name=tasaoCuotaECC12]').val() == "") {
		alert("Debe introducir tasa o la cuota del impuesto que se traslada");
		$('#tasaoCuotaECC12').focus();
		return false;
	}
  if ($('input[name=importeTrasladoECC12]').val() == "") {
		alert("Debe introducir el Importe del Impuesto Trasladado");
		$('#importeTrasladoECC12').focus();
		return false;
	}
  if ($('input[name=importeTrasladoECC12]').val() < 0.01) {
		alert("El importe del impuesto trasladado debe ser mayor o igual a 0.01");
		$('#importeTrasladoECC12').focus();
		return false;
	}
else{
  return true;
}
}

function validaConceptoConsumoCombustiblesECC12(){
  if ($('input[name=identificadorECC12]').val() == "") {
		alert("Debe introducir el Identificador");
		$('#identificadorECC12').focus();
		return false;
	}
  if ($('input[name=fechaExpOperECC12]').val() == "") {
		alert("Debe introducir la Fecha");
		$('#fechaExpOperECC12').focus();
		return false;
	}
  if ($('input[name=horaConsumoCombustiblesECC12]').val() == "") {
		alert("Debe introducir la Hora");
		$('#horaConsumoCombustiblesECC12').focus();
		return false;
	}
  var fechaMin = new Date('2015-01-01');
  var fechaConsumo =  new Date($('input[name=fechaExpOperECC12]').val());
  if (fechaConsumo < fechaMin) {
		alert("La Fecha debe ser mayor o igual a 2015-01-01");
		$('#fechaExpOperECC12').focus();
		return false;
	}
  if ($('input[name=rfcEnajCombustibleECC12]').val() == "") {
		alert("Debe introducir el RFC");
		$('#rfcEnajCombustibleECC12').focus();
		return false;
	}
  if ($('input[name=claveEstacionECC12]').val() == "") {
		alert("Debe introducir la Clave de la Estación");
		$('#claveEstacionECC12').focus();
		return false;
	}
  if ($('input[name=cantidadConceptoECC12]').val() == "") {
		alert("Debe introducir el Volumen");
		$('#cantidadConceptoECC12').focus();
		return false;
	}
  if ($('input[name=cantidadConceptoECC12]').val() < 0.001) {
		alert("El volumen de combustible debe ser mayor o igual a 0.001");
		$('#cantidadConceptoECC12').focus();
		return false;
	}
  if ($('#noIdentificacionConceptoECC12').val() == "")  {
		alert("Debe seleccionar la clave del tipo de combustible");
		$('#noIdentificacionConceptoECC12').focus();
		return false;
	}
  if ($('input[name=nombreCombustibleECC12]').val() == "") {
		alert("Debe introducir el Nombre del Combustible");
		$('#nombreCombustibleECC12').focus();
		return false;
	}
  if ($('input[name=folioOperacionECC12]').val() == "") {
		alert("Debe introducir el Folio de la Operación");
		$('#folioOperacionECC12').focus();
		return false;
	}
  if ($('input[name=precioUnitarioECC12]').val() == "") {
		alert("Debe introducir el Precio Unitario");
		$('#precioUnitarioECC12').focus();
		return false;
	}
  if ($('input[name=precioUnitarioECC12]').val() < 0.001) {
		alert("El precio unitario del combustible debe ser mayor o igual a 0.001");
		$('#precioUnitarioECC12').focus();
		return false;
	}
  if ($('input[name=importeCombustibleECC12]').val() == "") {
		alert("Debe introducir el Importe");
		$('#importeCombustibleECC12').focus();
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
  if ($('#ambito').val() == "Local"){
    if (($('#claveEntidad').val() == "NAC")||($('#claveEntidad').val() == "CR1")||($('#claveEntidad').val() == "CR2")||
      ($('#claveEntidad').val() == "CR3")||($('#claveEntidad').val() == "CR4")||($('#claveEntidad').val() == "CR5")){
      alert("No se pueden seleccionar las claves  NAC, CR1, CR2, CR3, CR4 y CR5 por que el Ambito es Local.");
	  	return false;
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

function validaPropietario(){
  if (($('#NumRegIdTribPropietarioComercioExt').val() == "")||($('select[name=ResidenciaFiscalPropietarioComercioExt]').val() == "")){
    alert("Debe proporcionar los campos Número de Identificación o Registro fiscal y Residencia fiscal del Propietario");
		$('#NumRegIdTribPropietarioComercioExt').focus();
		return false;
  }
  return true;
}

function validaDestinatario(){
  if (($('#NumRegIdTribDestinatarioComercioExt').val() == "")&&($('#nombreDestinatarioComercioExt').val() == "")){
    alert("Debe proporcionar los campos Número de Identificación o Nombre del Destinatario");
		$('#NumRegIdTribDestinatarioComercioExt').focus();
		return false;
  }
  if (domiciliosDestinatario < 1){
    alert("Debe agregar al menos un Domicilio del Destinatario");
		$('#paisDestinatarioComercioExt').focus();
		return false;
  }
  return true;
}

function validaDomicilioDestinatario(){
  if (($('#calleDestinatarioComercioExt').val() == "")||($('select[name=paisDestinatarioComercioExt]').val() == "")||
  ($('select[name=codigoPostalDestinatarioComercioExt]').val() == "")){
    alert("Debe proporcionar los campos Calle, Estado, Pais y Código Postal del Domicilio del Destinatario");
		$('#calleDestinatarioComercioExt').focus();
		return false;
  }
  else{
    if ($('input[name=NumRegIdTribDestinatarioComercioExt]').val() != ""){
        if ($('select[name=paisDestinatarioComercioExt]').val() == "default"){
            alert("Debe indicar el campo Pais del Domicilio del Destinatario");
         		return false;
        }
        if (($('select[name=paisDestinatarioComercioExt]').val() == "CAN")||($('select[name=paisDestinatarioComercioExt]').val() == "USA")){
          var re = new RegExp("[0-9]{9}$");
          if (!re.test($('input[name=NumRegIdTribDestinatarioComercioExt]').val())) {
      	    alert("El campo Número de Identificación o Registro fiscal del Destinatario no cumple con el patrón [0-9]{9} establecido ");
       	  	return false;
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
        if ((($('select[name=estadoDestinatarioComercioExt]').val() == "default")||($('select[name=estadoDestinatarioComercioExt]').val() == null))&&
        ($('input[name=estadoDestinatarioComercioExtAux]').val() == "")){ 
          alert("Debe indicar el campo Estado del Domicilio del Destinatario");
     	  	return false;
        }
        if ((($('select[name=codigoPostalDestinatarioComercioExt]').val() == "default")||
          ($('select[name=codigoPostalDestinatarioComercioExt]').val() == null))&&
          ($('input[name=codigoPostalDestinatarioComercioExtAux]').val() == "")){ 
            alert("Debe indicar el campo Código Postal del Domicilio del Destinatario");
       	  	return false;
        }
        if ($('select[name=paisDestinatarioComercioExt]').val() == "CAN"){
          if (!validateCodigoPostalCanada($('input[name=codigoPostalDestinatarioComercioExtAux]').val())){
            alert("El Código Postal del país en la sección Destinatario no cumple con el patrón [A-Z][0-9][A-Z] [0-9][A-Z][0-9]");
         		return false;
          }
        }
        if ($('select[name=paisDestinatarioComercioExt]').val() == "USA"){
          if (!validateCodigoPostalEEUU($('input[name=codigoPostalDestinatarioComercioExtAux]').val())){
            alert("El Código Postal del país en la sección Destinatario no cumple con el patrón [0-9]{5}(-[0-9]{4})?");
         		return false;
          }
        }

      }
  }
  return true;
}

function validaMercanciaNoIdentificacionFraccionArancelaria(noId, fraccAranc){
  var valido = true;
  for ( var i = 0; i < mercancias.length; i++) {  
    if ((noId == mercancias[i].noIdentificacion)&&(fraccAranc == mercancias[i].fraccionArancelaria)){
      valido = false;
      break;
    }
  }
  return valido;
}

function validaMercancia(){
  if (mercancias.length > 0){
    if (!validaMercanciaNoIdentificacionFraccionArancelaria($('#NoIdentificacionMercanciaComercioExt').val(), $('#FraccionArancelariaMercanciaComercioExt').val())){
      alert("En el elemento cce11:ComercioExterior:Mercancias, no se debe repetir elementos Mercancia donde el NoIdentificacion y la FraccionArancelaria sean iguales.");
  		return false;
   		$('#NoIdentificacionMercanciaComercioExt').focus();
    }
  }

  if (($('#CantidadAduanaMercanciaComercioExt').val() == "")&&(!validaCantidadConcepto($('#NoIdentificacionMercanciaComercioExt').val()))){
    alert("El atributo cfdi:Comprobante:Conceptos:Concepto:cantidad debe tener como valor mínimo incluyente {0.001} y debe cumplir con el patrón [0-9]{1,14}(.([0-9]{1,3}))?");
    return false;
  }
  if (($('#CantidadAduanaMercanciaComercioExt').val() == "")&&(!validaUnidadConcepto($('#NoIdentificacionMercanciaComercioExt').val()))){
    alert("El atributo cfdi:Comprobante:Conceptos:Concepto:Unidad debe tener un valor del catálogo catCFDI:c_UnidadAduana");
    return false;
  }  
  if (($('#CantidadAduanaMercanciaComercioExt').val() == "")&&(!validaValorUnitarioConcepto($('#NoIdentificacionMercanciaComercioExt').val()))){
    alert("El atributo cfdi:Comprobante:Conceptos:Concepto:ValorUnitario debe tener como valor mínimo incluyente {0.0001}, debe cumplir con el patrón [0-9]{1,16}(.([0-9]{1,4}))? y debe estar registrado con la cantidad de decimales que soporte la moneda en la que se expresan las cantidades del comprobante");
    return false;
  }  
    
  if (($('select[name=UnidadAduanaMercanciaComercioExt]').val() == "99")&&($('select[name=FraccionArancelariaMercanciaComercioExt]').val() != "default")){
    alert("Si el atributo cce:ComercioExterior:Mercancias:Mercancia:UnidadAduana tiene el valor {99} que corresponde a los servicios, entonces no debe existir el atributo cce:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria");   
 		return false; 
  }
  if (($('select[name=UnidadAduanaMercanciaComercioExt]').val() != "99")&&($('select[name=FraccionArancelariaMercanciaComercioExt]').val() == "default")){
    alert("Si el atributo cce:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:unidad tienen valor diferente a {99} que corresponde a los servicios, entonces debe existir el atributo cce:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria");   
 		return false; 
  }
  if ($('select[name=UnidadAduanaMercanciaComercioExt]').val() != "default"){
    if (($('select[name=UnidadAduanaMercanciaComercioExt]').val() != "99")&&($('input[name=ValorUnitarioAduanaMercanciaComercioExt]').val() <= 0)){
      alert("Si el valor del atributo cce:ComercioExterior:Mercancias:Mercancia:UnidadAduana es distinto de {99} que corresponde a los servicios, entonces el cce:ComercioExterior:Mercancias:Mercancia:ValorUnitarioAduana debe ser mayor que cero");  
   		return false; 
    }
  }    

  if (($('#CantidadAduanaMercanciaComercioExt').val() != "")||($('#UnidadAduanaMercanciaComercioExt').val() != "default")||  ($('#ValorUnitarioAduanaMercanciaComercioExt').val() != "")){
    if (($('#CantidadAduanaMercanciaComercioExt').val() == "")||($('#UnidadAduanaMercanciaComercioExt').val() == "default")||  ($('#ValorUnitarioAduanaMercanciaComercioExt').val() == "")){
      alert("Si registra alguno de los atributos Cantidad Aduana, Unidad Aduana o Valor Unitario Aduana de una Mercancia, entonces deben existir los 3 atributos");
      $('#CantidadAduanaMercanciaComercioExt').focus();
      return false;
    }
  }
  if (validaConceptosNoIdentificacionRepetido()){
    if (($('#CantidadAduanaMercanciaComercioExt').val() == "")||($('#UnidadAduanaMercanciaComercioExt').val() == "default")||  ($('#ValorUnitarioAduanaMercanciaComercioExt').val() == "")){
      alert("Si existe más de un registro concepto con el mismo NoIdentificacion, entonces debe indicar los 3 atributos Cantidad Aduana, Unidad Aduana y Valor Unitario Aduana de la Mercancía");
      $('#CantidadAduanaMercanciaComercioExt').focus();
      return false;
    }
  }
  if (validaMercanciasNoIdentificacionRepetido()){
    if (($('#CantidadAduanaMercanciaComercioExt').val() == "")||($('#UnidadAduanaMercanciaComercioExt').val() == "default")||  ($('#ValorUnitarioAduanaMercanciaComercioExt').val() == "")){
      alert("Si existe más de un registro mercancía con el mismo NoIdentificacion, entonces debe indicar los 3 atributos Cantidad Aduana, Unidad Aduana y Valor Unitario Aduana de la Mercancía");
      $('#CantidadAduanaMercanciaComercioExt').focus();
      return false;
    }
  }
  if (!validaMercanciaCantidadUnidadValorUnitarioAduana()){
      alert("Si un elemento cce11:ComercioExterior:Mercancias:Mercancia tiene los atributos CantidadAduana, UnidadAduana y ValorUnitarioAduana, entonces todos los elementos mercancía del comprobante deben tener los tres atributos");
      $('#CantidadAduanaMercanciaComercioExt').focus();
      return false;
  }
  
  return true;

}


function validaUsadosRenovacion(){
  if (($('#precioVehUsadoRenovacion').val() == "")||($('input[name=precioVehUsadoRenovacion]').val() == "")){
    alert("Debe proporcionar el Precio del Vehículo");
		$('#precioVehUsadoRenovacion').focus();
		return false;
  }
  if (($('#tipoVehRenovacion').val() == "")||($('select[name=tipoVehRenovacion]').val() == "")){
    alert("Debe indicar el Tipo de Vehículo");
		$('#tipoVehRenovacion').focus();
		return false;
  }  
  if (($('#marcaRenovacion').val() == "")||($('input[name=marcaRenovacion]').val() == "")){
    alert("Debe indicar la Marca");
		$('#marcaRenovacion').focus();
		return false;
  } 
  if (($('#tipooClaseRenovacion').val() == "")||($('input[name=tipooClaseRenovacion]').val() == "")){
    alert("Debe indicar el Tipo o Clase");
		$('#tipooClaseRenovacion').focus();
		return false;
  }  
  if (($('#anioRenovacion').val() == "")||($('input[name=anioRenovacion]').val() == "")){
    alert("Debe indicar el Año");
		$('#anioRenovacion').focus();
		return false;
  }  
  if (($('#numPlacasRenovacion').val() == "")||($('input[name=numPlacasRenovacion]').val() == "")){
    alert("Debe indicar el Número de Placas");
		$('#numPlacasRenovacion').focus();
		return false;
  }  
  if (($('#numFolTarjCirRenovacion').val() == "")||($('input[name=numFolTarjCirRenovacion]').val() == "")){
    alert("Debe indicar el Número de Tarjeta de Circulación");
		$('#numFolTarjCirRenovacion').focus();
		return false;
  }  
  if (($('#foliofiscalRenovacion').val() == "")||($('input[name=foliofiscalRenovacion]').val() == "")){
    alert("Debe indicar el Folio Fiscal");
		$('#foliofiscalRenovacion').focus();
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

function graficarPropietarios() {

	$('#tablaPropietario tbody').html('');
	if(propietarios.length > 0) {
		$('#tablaPropietario').show();
	} else {
		$('#tablaPropietario').hide();
	}
  $.each(propietarios, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['numRegIdTrib'] + '</td>';
		row += '<td>' + concepto['residenciaFiscal'] + '</td>';

		row += '<td><a class="eliminarPropietario" onClick="eliminarPropietario(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaPropietario').append(row);
  }); 

}

function graficarDestinatario() {

	$('#tablaDestinatario tbody').html('');
	if(destinatarios.length > 0) {
		$('#tablaDestinatario').show();
	} else {
		$('#tablaDestinatario').hide();
	}
  $.each(destinatarios, function(key, concepto) {
		var row = '<tr>';
  
    if (concepto['numRegIdTrib'] != null)
  		row += '<td>' + concepto['numRegIdTrib'] + '</td>';
    else
      row += '<td></td>';				
    if (concepto['nombre'] != null)
  		row += '<td>' + concepto['nombre'] + '</td>';
    else
      row += '<td></td>';				

		row += '<td><a class="eliminarDestinatario" onClick="eliminarDestinatario(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaDestinatario').append(row);
  }); 

}

function graficarDomicilioDestinatario() {

	$('#tablaDomicilioDestinatario tbody').html('');
	if(domiciliosDestinatario.length > 0) {
		$('#tablaDomicilioDestinatario').show();
	} else {
		$('#tablaDomicilioDestinatario').hide();
	}
  $.each(domiciliosDestinatario, function(key, concepto) {
		var row = '<tr>';

		row += '<td>' + concepto['pais'] + '</td>';		
		row += '<td>' + concepto['estado'] + '</td>';
		row += '<td>' + concepto['municipio'] + '</td>';
		row += '<td>' + concepto['localidad'] + '</td>';
		row += '<td>' + concepto['codigoPostal'] + '</td>';
 		row += '<td>' + concepto['calle'] + '</td>';
    if (concepto['colonia'] != null)
  		row += '<td>' + concepto['colonia'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['numeroExterior'] != null)
  		row += '<td>' + concepto['numeroExterior'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['numeroInterior'] != null)
  		row += '<td>' + concepto['numeroInterior'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['referencia'] != null)
  		row += '<td>' + concepto['referencia'] + '</td>';
    else
      row += '<td></td>';

		row += '<td><a class="eliminarDomicilioDestinatario" onClick="eliminarDomicilioDestinatario(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaDomicilioDestinatario').append(row);
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
    row += '<td></td>';
    row += '<td></td>';
    row += '<td></td>';
    row += '<td></td>'; 
    row += '<td><a class="eliminarMercancia" onClick="eliminarMercancia(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';      
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
    row += '<td></td>';
    row += '<td></td>';
    row += '<td></td>';
    row += '<td></td>';    
    if (concepto['descripcionesEspecificas'] == '')
    row += '<td><a class="eliminarMercancia" onClick="eliminarMercancia(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';
    row += '</tr>';
		$('#tablaInfoMercancia').append(row);
  }); 

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
				+ '"><i class="icon-remove"></i> Eliminar </a><a class="editarCFDIRelacionado" onClick="editarCFDIRelacionado(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-edit"></i> Editar </a></td></tr>';


		$('#tablaFoliosRelacionados').append(row);
  }); 

}

function graficarTrasladoConcepto() {

	$('#tablaTrasladosConcepto tbody').html('');
	if(trasladoConceptoArr.length > 0) {
		$('#tablaTrasladosConcepto').show();
	} else {
		$('#tablaTrasladosConcepto').hide();
	}
  $.each(trasladoConceptoArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['base'] + '</td>';
		row += '<td>' + concepto['impuesto'] + '</td>';
		row += '<td>' + concepto['tipoFactor'] + '</td>';
    if (concepto['tasaOCuota'] != null)
  		row += '<td>' + concepto['tasaOCuota'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['importe'] != null)
  		row += '<td>' + concepto['importe'] + '</td>';
    else
      row += '<td></td>';

		row += '<td><a class="eliminarTrasladoConcepto" onClick="eliminarTrasladoConcepto(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaTrasladosConcepto').append(row);
  }); 

}

function graficarRetencionConcepto() {

	$('#tablaRetencionesConcepto tbody').html('');
	if(retencionConceptoArr.length > 0) {
		$('#tablaRetencionesConcepto').show();
	} else {
		$('#tablaRetencionesConcepto').hide();
	}
  $.each(retencionConceptoArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['base'] + '</td>';
		row += '<td>' + concepto['impuesto'] + '</td>';
		row += '<td>' + concepto['tipoFactor'] + '</td>';
		row += '<td>' + concepto['tasaOCuota'] + '</td>';
		row += '<td>' + concepto['importe'] + '</td>';


		row += '<td><a class="eliminarRetencionConcepto" onClick="eliminarRetencionConcepto(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaRetencionesConcepto').append(row);
  }); 

}

function graficarInformacionAduaneraConcepto() {

	$('#tablaInformacionAduaneraConcepto tbody').html('');
	if(informacionAduaneraConceptoArr.length > 0) {
		$('#tablaInformacionAduaneraConcepto').show();
	} else {
		$('#tablaInformacionAduaneraConcepto').hide();
	}
  $.each(informacionAduaneraConceptoArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['numeroPedimento'] + '</td>';


		row += '<td><a class="eliminarInformacionAduaneraConcepto" onClick="eliminarInformacionAduaneraConcepto(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaInformacionAduaneraConcepto').append(row);
  }); 

}

function graficarPartesConcepto() {

	$('#tablaInformacionParteConcepto tbody').html('');

  if(partesConcepto.length > 0) {
		$('#tablaInformacionParteConcepto').show();
	} else {
		$('#tablaInformacionParteConcepto').hide();
	}

  $.each(partesConcepto, function(key, concepto) {

		var row = '<tr>';
		
		row += '<td>' + concepto['claveProdServ'] + '</td>';
    if (concepto['noIdentificacion'] != null)
  		row += '<td>' + concepto['noIdentificacion'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['cantidad'] != null)
  		row += '<td>' + concepto['cantidad'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['unidad'] != null)
  		row += '<td>' + concepto['unidad'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['valorUnitario'] != null)
  		row += '<td>' + concepto['valorUnitario'] + '</td>';
    else
      row += '<td></td>';				
    if (concepto['importe'] != null)
  		row += '<td>' + concepto['importe'] + '</td>';
    else
      row += '<td></td>';				
    row += '<td>' + concepto['descripcion'] + '</td>';
  
    row += '<td><a class="eliminarPartesConcepto" onClick="eliminarPartesConcepto(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';

		$('#tablaInformacionParteConcepto').append(row);
  });
}

function graficarInformacionAduaneraParte() {

	$('#tablaInformacionAduaneraParte tbody').html('');
	if(informacionAduaneraParteArr.length > 0) {
		$('#tablaInformacionAduaneraParte').show();
	} else {
		$('#tablaInformacionAduaneraParte').hide();
	}
  $.each(informacionAduaneraParteArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['numeroPedimento'] + '</td>';


		row += '<td><a class="eliminarInformacionAduaneraParte" onClick="eliminarInformacionAduaneraParte(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaInformacionAduaneraParte').append(row);
  }); 

}

function graficarTrasladoPago() {

	$('#tablaTrasladosPago tbody').html('');
	if(trasladoPagoArr.length > 0) {
		$('#tablaTrasladosPago').show();
	} else {
		$('#tablaTrasladosPago').hide();
	}
  $.each(trasladoPagoArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['impuesto'] + '</td>';
		row += '<td>' + concepto['tipoFactor'] + '</td>';
		row += '<td>' + concepto['tasaOCuota'] + '</td>';
		row += '<td>' + concepto['importe'] + '</td>';


		row += '<td><a class="eliminarTrasladoPago" onClick="eliminarTrasladoPago(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaTrasladosPago').append(row);
  }); 

}

function graficarRetencionPago() {

	$('#tablaRetencionesPago tbody').html('');
	if(retencionPagoArr.length > 0) {
		$('#tablaRetencionesPago').show();
	} else {
		$('#tablaRetencionesPago').hide();
	}
  $.each(retencionPagoArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['impuesto'] + '</td>';
		row += '<td>' + concepto['importe'] + '</td>';


		row += '<td><a class="eliminarRetencionPago" onClick="eliminarRetencionPago(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaRetencionesPago').append(row);
  }); 

}

function graficarPago() {

	$('#tablaPagos tbody').html('');
	if(pagosArr.length > 0) {
		$('#tablaPagos').show();
	} else {
		$('#tablaPagos').hide();
	}
  $.each(pagosArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['fechaPago'] + ' </td>';
		row += '<td>' + concepto['formaDePagoP'] + '</td>';
		row += '<td>' + concepto['monedaP'] + '</td>';
    if (concepto['tipoCambioP'] != null)
  		row += '<td>' + concepto['tipoCambioP'] + '</td>';
    else
      row += '<td></td>';
		row += '<td>' + concepto['monto'] + '</td>';
    if (concepto['numOperacion'] != null)
  		row += '<td>' + concepto['numOperacion'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['rfcEmisorCtaOrd'] != null)
  		row += '<td>' + concepto['rfcEmisorCtaOrd'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['nomBancoOrdExt'] != null)
  		row += '<td>' + concepto['nomBancoOrdExt'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['ctaOrdenante'] != null)
  		row += '<td>' + concepto['ctaOrdenante'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['rfcEmisorCtaBen'] != null)
  		row += '<td>' + concepto['rfcEmisorCtaBen'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['ctaBeneficiario'] != null)
  		row += '<td>' + concepto['ctaBeneficiario'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['tipoCadPago'] != null)
  		row += '<td>' + concepto['tipoCadPago'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['certPago'] != null)
  		row += '<td>' + concepto['certPago'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['cadPago'] != null)
  		row += '<td>' + concepto['cadPago'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['selloPago'] != null)
  		row += '<td>' + concepto['selloPago'] + '</td>';
    else
      row += '<td></td>';

		row += '<td><a class="eliminarPago" onClick="eliminarPago(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaPagos').append(row);
  }); 

}

function graficarDoctoRelacionado() {

	$('#tablaDoctoRelacionado tbody').html('');
	if(doctosRelacionadosArr.length > 0) {
		$('#tablaDoctoRelacionado').show();
	} else {
		$('#tablaDoctoRelacionado').hide();
	}
  $.each(doctosRelacionadosArr, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['idDocumento'] + ' </td>';
    if (concepto['serie'] != null)
  		row += '<td>' + concepto['serie'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['folio'] != null)
  		row += '<td>' + concepto['folio'] + '</td>';
    else
      row += '<td></td>';
		row += '<td>' + concepto['monedaDR'] + ' </td>';
    if (concepto['tipoCambioDR'] != null)
  		row += '<td>' + concepto['tipoCambioDR'] + '</td>';
    else
      row += '<td></td>';
		row += '<td>' + concepto['metodoDePagoDR'] + ' </td>';
    if (concepto['numParcialidad'] != null)
  		row += '<td>' + concepto['numParcialidad'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['impSaldoAnt'] != null)
  		row += '<td>' + concepto['impSaldoAnt'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['impPagado'] != null)
  		row += '<td>' + concepto['impPagado'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['impSaldoInsoluto'] != null)
  		row += '<td>' + concepto['impSaldoInsoluto'] + '</td>';
    else
      row += '<td></td>';

		row += '<td><a class="eliminarDoctoRelacionado" onClick="eliminarDoctoRelacionado(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaDoctoRelacionado').append(row);
  }); 

}


function graficarUsadosRenovacion() {

	$('#tablaUsadosRenovacion tbody').html('');
	if(usadosRenovacion.length > 0) {
		$('#tablaUsadosRenovacion').show();
	} else {
		$('#tablaUsadosRenovacion').hide();
	}
  $.each(usadosRenovacion, function(key, concepto) {
		var row = '<tr>';
		
		row += '<td>' + concepto['precioVehUsadoRenovacion'] + ' </td>';
    row += '<td>' + concepto['tipoVehRenovacion'] + ' </td>';
    row += '<td>' + concepto['marcaRenovacion'] + ' </td>';
    row += '<td>' + concepto['tipooClaseRenovacion'] + ' </td>';
    row += '<td>' + concepto['anioRenovacion'] + ' </td>';
    if (concepto['modeloRenovacion'] != null)
  		row += '<td>' + concepto['modeloRenovacion'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['nivRenovacion'] != null)
  		row += '<td>' + concepto['nivRenovacion'] + '</td>';
    else
      row += '<td></td>';  
    if (concepto['numSerieRenovacion'] != null)
  		row += '<td>' + concepto['numSerieRenovacion'] + '</td>';
    else
      row += '<td></td>';
    row += '<td>' + concepto['numPlacasRenovacion'] + ' </td>';
    if (concepto['numMotorRenovacion'] != null)
  		row += '<td>' + concepto['numMotorRenovacion'] + '</td>';
    else
      row += '<td></td>';
    row += '<td>' + concepto['numFolTarjCirRenovacion'] + ' </td>';
    if (concepto['numPedImRenovacion'] != null)
  		row += '<td>' + concepto['numPedImRenovacion'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['aduanaRenovacion'] != null)
  		row += '<td>' + concepto['aduanaRenovacion'] + '</td>';
    else
      row += '<td></td>';
    if (concepto['fechaRegularizacionRenovacion'] != null)
  		row += '<td>' + concepto['fechaRegularizacionRenovacion'] + '</td>';
    else
      row += '<td></td>';  
    row += '<td>' + concepto['foliofiscalRenovacion'] + ' </td>';

		row += '<td><a class="eliminarUsadosRenovacion" onClick="eliminarUsadosRenovacion(' + key
				+ ')" id="uuid-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


		$('#tablaUsadosRenovacion').append(row);
  }); 

}
function eliminarCFDIRelacionado(id) {
	cfdiRelacionadoArr.splice(id, 1);
	graficarCFDIRelacionado();
  if (cfdiRelacionadoArr.length == 0)
    $('#tipoRelacion').val("");
}

function editarCFDIRelacionado(id) {
	indiceUUIDRelacionado = id;
	$('#btnAgregarUUID').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	if (cfdiRelacionadoArr.length > 0){
		$('#tipoRelacion').attr("disabled", false);
		$('#uuid').val(cfdiRelacionadoArr[id].uuid);
	    $('#tipoRelacion').val(cfdiRelacionadoArr[id].tipoRelacion);
	}
}

function eliminarTrasladoConcepto(id) {
	trasladoConceptoArr.splice(id, 1);
	graficarTrasladoConcepto();
}

function editarTrasladoConcepto(id, i) {
	$('#btnAgregarTrasladoConcepto').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	indiceTrasladoEditar = i;
	$('#baseTrasladoConcepto').trigger('focus');
	$('#tipoFactorTrasladoConcepto').trigger('change');
	var obj = mapConceptos[id];
	var t = obj.impuestos.traslados.traslado[i];
	$('#baseTrasladoConcepto').val(t.base);
	$('#impuestoTrasladoConcepto').val(t.impuesto);
	$('#impuestoTrasladoConcepto').trigger('change');
	$('#tipoFactorTrasladoConcepto').val(t.tipoFactor);
	if ($('#tipoFactorTrasladoConcepto').val() == "Cuota"){
		$('.divTasaCuotaTrasladoConceptoRango').show(0);
        $('.divTasaCuotaTrasladoConceptoFijo').hide(0);
		$('#tasaCuotaTrasladoConceptoRango').val(t.tasaOCuota);
	}
	else{
		$('.divTasaCuotaTrasladoConceptoRango').hide(0);
        $('.divTasaCuotaTrasladoConceptoFijo').show(0);
		$('#tasaCuotaTrasladoConceptoFijo').val(t.tasaOCuota);
	}
	$('#importeTrasladoConcepto').val(t.importe);
}

function editarEliminarTrasladoConcepto(id, i) {
	blnTrasladoEliminar = true;
	indiceTrasladoEditar = i;
	trasladoConceptoArr.splice(i, 1);
	graficarTrasladoConcepto();
}

function eliminarRetencionConcepto(id) {
	retencionConceptoArr.splice(id, 1);
	graficarRetencionConcepto();
}

function editarRetencionConcepto(id, i) {
	$('#btnAgregarRetencionConcepto').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	indiceRetencionEditar = i;
	var obj = mapConceptos[id];
	var t = obj.impuestos.retenciones.retencion[i];
	$('#baseRetencionConcepto').val(t.base);
	$('#impuestoRetencionConcepto').val(t.impuesto);
	$('#tipoFactorRetencionConcepto').val(t.tipoFactor);
	$('#tipoFactorRetencionConcepto').trigger('change');
		
	if ((t.tipoFactor == "Tasa")&&(t.impuesto == "003")){
		$('#impuestoRetencionConcepto').trigger('focus');
		$('#impuestoRetencionConcepto').trigger('change');
		$('.divTasaCuotaRetencionConceptoFijo').show(0);
        $('.divTasaCuotaRetencionConceptoRango').hide(0);
		$('#tasaCuotaRetencionConceptoFijo').val(t.tasaOCuota);
	}
	else	
		if ((t.tipoFactor == "Cuota")&&(t.impuesto == "003")){
			$('#impuestoRetencionConcepto').trigger('change');
			$('.divTasaCuotaRetencionConceptoFijo').hide(0);
	        $('.divTasaCuotaRetencionConceptoRango').show(0);
	        $('#tipoFactorRetencionConcepto').val(t.tipoFactor);
			$('#tasaCuotaRetencionConceptoRango').val(t.tasaOCuota);
		}
		else{
			$('.divTasaCuotaRetencionConceptoFijo').hide(0);
	        $('.divTasaCuotaRetencionConceptoRango').show(0);
			$('#tasaCuotaRetencionConceptoRango').val(t.tasaOCuota);
		}
	$('#importeRetencionConcepto').val(t.importe);
}

function editarEliminarRetencionConcepto(id, i) {
	blnRetencionEliminar = true;
	indiceRetencionEditar = i;
	retencionConceptoArr.splice(i, 1);
	graficarRetencionConcepto();
}

function eliminarInformacionAduaneraConcepto(id) {
	informacionAduaneraConceptoArr.splice(id, 1);
	graficarInformacionAduaneraConcepto();
}

function editarInformacionAduaneraConcepto(id, i) {
	$('#btnAgregarInformacionAduaneraConcepto').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	indiceInformacionAduaneraConcepto = i;
	var obj = mapConceptos[id];
	var t = obj.informacionAduanera[i];
	$('#numeroPedimentoConcepto').val(t.numeroPedimento);
}

function editarEliminarInformacionAduaneraConcepto(id, i) {
	informacionAduaneraConceptoArr.splice(i, 1);
	graficarInformacionAduaneraConcepto();
}

function eliminarPartesConcepto(id) {
	partesConcepto.splice(id, 1);
	graficarPartesConcepto();
}


function editarPartesConcepto(id, i) {
	$('#btnAgregarParte').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	indiceParteConcepto = i;
	var obj = mapConceptos[id];
	var t = obj.parte[i];
	$('#claveProdServParte').val(t.claveProdServ);
	$('#claveParte').val(t.noIdentificacion);
	$('#cantidadParte').val(t.cantidad);
	$('#unidadParte').val(t.unidad);
	$('#valorUnitarioParte').val(t.valorUnitario);
	$('#importeParte').val(t.importe);
	$('#conceptoParte').val(t.descripcion);
}

function editarEliminarPartesConcepto(id, i) {
	partesConcepto.splice(i, 1);
	graficarPartesConcepto();
}


function eliminarInformacionAduaneraParte(id) {
	informacionAduaneraParteArr.splice(id, 1);
	graficarInformacionAduaneraParte();
}

function editarInformacionAduaneraParte(id, i, j) {
	$('#btnAgregarInformacionAduaneraParte').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	indiceInformacionAduaneraParte = j;
	var obj = mapConceptos[id];
	var t = obj.parte[i].informacionAduanera[j];
	$('#numeroPedimentoParte').val(t.numeroPedimento);
}

function eliminarDoctoRelacionado(id) {
	doctoRelacionadoArr.splice(id, 1);
	graficarDoctoRelacionado();
}

function eliminarTrasladoPago(id) {
	trasladoPagoArr.splice(id, 1);
	graficarTrasladoPago();
}

function eliminarRetencionPago(id) {
	retencionPagoArr.splice(id, 1);
	graficarRetencionPago();
}

function eliminarPago(id) {
	pagosArr.splice(id, 1);
	graficarPago();
}

function eliminarPropietario(id) {
	propietarios.splice(id, 1);
	graficarPropietarios();
}

function eliminarDestinatario(id) {
	destinatarios.splice(id, 1);
	graficarDestinatario();
}

function eliminarDomicilioDestinatario(id) {
	domiciliosDestinatario.splice(id, 1);
	graficarDomicilioDestinatario();
}

function eliminarMercancia(id) {

    var mercanciavalor = mercancias[id];
	if(typeof mercanciavalor != undefined)
	{
	 var valorunitario = mercancias[id].valorDolares;
	 var TotalUSD = document.getElementById("TotalUSD");
	 
	   if(TotalUSD != null){
		   total = Math.abs(TotalUSD.value); 
		   valorunitario = Math.abs(valorunitario);
		   
		   if(new Boolean(total) && total > 0){
			   total = total - valorunitario;
			   TotalUSD.value = new Number(total).toFixed(numeroDecimales);
		   }
	   } 
	}

	mercancias.splice(id, 1);
	graficarMercancia();
}

function eliminarData(id) {
	var obj = mapConceptos[id];
	if (obj.ivaExento == undefined) { 
		totalIVA -= obj.iva;
		$("input[name=totalIVA]").val(totalIVA)
	}
	if (obj.ieps != "") {
		var iepsD = redondearValor((obj.ieps / 100) *  (obj.valorUnitario * obj.cantidad));
 		if ($.isNumeric(iepsD)) {
			totalIEPS -= iepsD;
		}
	}
	// Eliminar Traslados y retenciones del concepto, de los arreglos trasladoArr y retencionArr respectivamente
	var concepto = mapConceptos[id];
	mapConceptos.splice(id, 1);
	if(concepto.impuestos != undefined) {
		if(concepto.impuestos.traslados != undefined && concepto.impuestos.traslados.traslado != undefined) {
			for(i=0;i<concepto.impuestos.traslados.traslado.length;i++) {
				var t = concepto.impuestos.traslados.traslado[i];
				var found = false;
				var index = -1;
				$.each(trasladoArr, function(k, v){
					if(!found){
						if(v.base === t.base && v.impuesto === t.impuesto && v.tipoFactor === t.tipoFactor && v.tasaOCuota === t.tasaOCuota && v.importe === t.importe){
							found = true;
							index = k;
						}
					}
				});
				if(found) {
					trasladoArr.splice(index ,1)
				}
			}
		}
		if(concepto.impuestos.retenciones != undefined && concepto.impuestos.retenciones.retencion != undefined) {
			for(i=0;i<concepto.impuestos.retenciones.retencion.length;i++) {
				var r = concepto.impuestos.retenciones.retencion[i];
				var found = false;
				var index = -1;
				$.each(retencionArr, function(k, v){
					if(!found){
						if(v.base === r.base && v.impuesto === r.impuesto && v.tipoFactor === r.tipoFactor && v.tasaOCuota === r.tasaOCuota && v.importe === r.importe){
							found = true;
							index = k;
						}
					}
				});
				if(found) {
					retencionArr.splice(index ,1)
				}
			}
		}
	}
	graficarConceptos();
}

function editarData(id) {
	$('#btnAgregarConcepto').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	
	$('#tablaTrasladosConcepto tbody').html('');
	$('#tablaTrasladosConcepto').show();
	$('#tablaRetencionesConcepto tbody').html('');
	$('#tablaRetencionesConcepto').show();
	objEdit = mapConceptos[id];
	indiceConceptoEditar = id;
	$('#claveProdServ').val(objEdit.claveProdServ);
	$('#claveProdServ').prop('disabled', true);
	if (objEdit.clave != null)
		$('#clave').val(objEdit.clave);
	$('#claveUnidad').val(objEdit.claveUnidad);
	$('#cantidad').val(objEdit.cantidad);
	$('#unidad').val(objEdit.unidad);
	$('#valorUnitario').val(objEdit.valorUnitario);
	$('#descuento').val(objEdit.descuento);
	$('#descripcion').val(objEdit.descripcion);

	// Editar Traslados y retenciones del concepto, de los arreglos trasladoArr y retencionArr respectivamente
	if(objEdit.impuestos != undefined) {
		if(objEdit.impuestos.traslados != undefined && objEdit.impuestos.traslados.traslado != undefined) {
			$('#baseTrasladoConcepto').val('');
			$('#importeTrasladoConcepto').val('');
						
			$('#tablaTrasladosConcepto tbody').html('');
			$('#tablaTrasladosConcepto').show();
			
			for(i=0;i<objEdit.impuestos.traslados.traslado.length;i++) {
				var t = objEdit.impuestos.traslados.traslado[i];
				trasladoConceptoArr[i] = t;
				var row = '<tr>';
				
				row += '<td>' + t.base + '</td>';
				row += '<td>' + t.impuesto+ '</td>';
				row += '<td>' + t.tipoFactor + '</td>';
		    if (t.tasaOCuota != null)
		  		row += '<td>' + t.tasaOCuota + '</td>';
		    else
		      row += '<td></td>';
		    if (t.importe != null)
		  		row += '<td>' + t.importe + '</td>';
		    else
		      row += '<td></td>';

		    row += '<td><a class="editarTrasladoConcepto" onClick="editarTrasladoConcepto('+ id + ',' + i +' )" id="uuid-' + i
						+ '"><i class="icon-edit"></i> Editar </a><a class="editarEliminarTrasladoConcepto" onClick="editarEliminarTrasladoConcepto('+ id + ',' + i +' )" id="uuid-' + i
						+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


				$('#tablaTrasladosConcepto').append(row);
			}
		}
		if(objEdit.impuestos.retenciones != undefined && objEdit.impuestos.retenciones.retencion != undefined) {
			$('#baseRetencionConcepto').val('');
			$('#importeRetencionConcepto').val('');
						
			$('#tablaRetencionesConcepto tbody').html('');
			$('#tablaRetencionesConcepto').show();
			
			for(i=0;i<objEdit.impuestos.retenciones.retencion.length;i++) {
				var t = objEdit.impuestos.retenciones.retencion[i];
				retencionConceptoArr[i] = t;
				var row = '<tr>';
				
				row += '<td>' + t.base + '</td>';
				row += '<td>' + t.impuesto+ '</td>';
				row += '<td>' + t.tipoFactor + '</td>';
		    if (t.tasaOCuota != null)
		  		row += '<td>' + t.tasaOCuota + '</td>';
		    else
		      row += '<td></td>';
		    if (t.importe != null)
		  		row += '<td>' + t.importe + '</td>';
		    else
		      row += '<td></td>';

		    row += '<td><a class="editarRetencionConcepto" onClick="editarRetencionConcepto('+ id + ',' + i +' )" id="uuid-' + i
						+ '"><i class="icon-edit"></i> Editar </a><a class="editarEliminarRetencionConcepto" onClick="editarEliminarRetencionConcepto('+ id + ',' + i +' )" id="uuid-' + i
						+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


				$('#tablaRetencionesConcepto').append(row);
			}
		}
	
	}
	
	if (objEdit.informacionAduanera != undefined){
		$('#tablaInformacionAduaneraConcepto tbody').html('');
		$('#tablaInformacionAduaneraConcepto').show();
		
		for(i=0;i<objEdit.informacionAduanera.length;i++) {
			var t = objEdit.informacionAduanera[i];
			informacionAduaneraConceptoArr[i] = t;
			var row = '<tr>';
			
			row += '<td>' + t.numeroPedimento + '</td>';
			
			row += '<td><a class="editarInformacionAduaneraConcepto" onClick="editarInformacionAduaneraConcepto('+ id + ',' + i +' )" id="id-' + i
					+ '"><i class="icon-edit"></i> Editar </a><a class="editarEliminarInformacionAduaneraConcepto" onClick="editarEliminarInformacionAduaneraConcepto('+ id + ',' + i +' )" id="id-' + i
					+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';

			$('#tablaInformacionAduaneraConcepto').append(row);
		}
	}
	
	if (objEdit.parte != undefined){
		$('#tablaInformacionParteConcepto tbody').html('');
		$('#tablaInformacionParteConcepto').show();
		
		$('#tablaInformacionAduaneraParte tbody').html('');
		$('#tablaInformacionAduaneraParte').show();
		
		for(i=0;i<objEdit.parte.length;i++) {
			var t = objEdit.parte[i];
			partesConcepto[i] = t;
			var row = '<tr>';
			
			row += '<td>' + t.claveProdServ + '</td>';
			row += '<td>' + t.noIdentificacion + '</td>';
			row += '<td>' + t.cantidad + '</td>';
			row += '<td>' + t.unidad + '</td>';
			row += '<td>' + t.valorUnitario + '</td>';
			row += '<td>' + t.importe + '</td>';
			row += '<td>' + t.descripcion + '</td>';
			
			row += '<td><a class="editarPartesConcepto" onClick="editarPartesConcepto('+ id + ',' + i +' )" id="id-' + i
					+ '"><i class="icon-edit"></i> Editar </a><a class="editarEliminarPartesConcepto" onClick="editarEliminarPartesConcepto('+ id + ',' + i +' )" id="id-' + i
					+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';


			$('#tablaInformacionParteConcepto').append(row);
									
			if (objEdit.parte[i].informacionAduanera != undefined){
				$('#tablaInformacionAduaneraParte tbody').html('');
				$('#tablaInformacionAduaneraParte').show();
				
				for(j=0;j<objEdit.parte[i].informacionAduanera.length;j++) {
					var pia = objEdit.parte[i].informacionAduanera[j];
					informacionAduaneraParteArr[j] = pia;
					var row = '<tr>';
					
					row += '<td>' + pia.numeroPedimento + '</td>';
					
					row += '<td><a class="editarInformacionAduaneraParte" onClick="editarInformacionAduaneraParte('+ id + ',' + i +',' + j +' )" id="id-' + i + j
							+ '"><i class="icon-edit"></i> Editar </a><a class="editarEliminarInformacionAduaneraParte" onClick="editarEliminarInformacionAduaneraParte('+ id + ',' + j +' )" id="id-' + j
							+ '"><i class="icon-remove"></i> Eliminar </a></td></tr>';

					$('#tablaInformacionAduaneraParte').append(row);
				}
				
			}
		}
	}
	
}

function agregarConcepto() {
  if ($('#btnTipoComprobante').val() == "pa"){
    if (mapConceptos.length > 0){
      alert("Para este Tipo de Comprobante se debe registrar solo un nodo concepto");
  		return false;
    }
  }
  if (($('#moneda').val() != "MXN")&&($('#moneda').val() != "XXX")) {
      if ($('#tipoCambio').val() == "") {
        alert("Para la Moneda seleccionada debe proporcionar el Tipo de Cambio");
		    $('#tipoCambio').focus();
    		return;
      }
	}
  if (($('#moneda').val() == "XXX")&&($('#tipoCambio').val() != "")) {
    alert("Para la Moneda seleccionada no debe existir el Tipo de Cambio");
	  $('#tipoCambio').focus();
    return;
  }
  if (($('#moneda').val() == "MXN")&&($('#tipoCambio').val() == "")) {

  }
  else{
    if (($('#moneda').val() == "MXN")&&($('#tipoCambio').val() != "1")) {
      alert("Para la Moneda seleccionada el campo de Tipo de Cambio debe tener el valor 1");
  	  $('#tipoCambio').focus();
      return;
    }
  }
  
  if (($('#btnTipoComprobante').val() == "cp")||($('#btnTipoComprobante').val() == "pa")) {
    if ($('#descuento').val() != "") {
      alert("Para este Tipo de Comprobante se debe omitir el Descuento de los Conceptos");
	    $('#descuento').focus();
   		return;
     }
     if ($('#formaPago').val() != "default") {
      alert("Para este Tipo de Comprobante se debe omitir la Forma de Pago");
	    $('#formaPago').focus();
   		return;
     } 
     if ($('#condicionesDePago').val() != "") {
      alert("Para este Tipo de Comprobante se deben omitir las Condiciones de Pago");
	    $('#condicionesDePago').focus();
   		return;
     }  
    if ($('#metodoPago').val() != "default") {
      alert("Para este Tipo de Comprobante se debe omitir el Método de Pago");
	    $('#metodoPago').focus();
   		return;
     } 
  }
  
  var obj = new Object();
	
  if ($('#claveProdServ').val() == "") {
		alert("Debe introducir la Clave del Producto / Servicio");
		$('#claveProdServ').focus();
		return;
	}
  
  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#claveProdServ').val() != "84111506") {
		  alert("Para este Tipo de Comprobante, la Clave del Producto / Servicio solo puede ser 84111506 - Servicios de facturación");
		  $('#claveProdServ').focus();
		  return;
	  }
  }
  obj.claveProdServ = $('#claveProdServ').val();

  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#clave').val() != "") {
		  alert("Para este Tipo de Comprobante, el No. Identificacion se debe omitir");
		  $('#clave').focus();
		  return;
	  }
  }

  if ($('#clave').val() == ""){
    obj.clave = null;
   }
  else{
    obj.clave = $('#clave').val();
  }	

  if ($('#cantidad').val() == "") {
		alert("Debe introducir la Cantidad");
		$('#cantidad').focus();
		return;
	}

  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#cantidad').val() != "1") {
		  alert("Para este Tipo de Comprobante, la Cantidad debe ser 1");
		  $('#cantidad').focus();
		  return;
	  }
  }
	if (parseFloat($('#cantidad').val()) < 0) {
		alert("La Cantidad debe ser mayor a 0");
		$('#cantidad').focus();
		return;
  }

  obj.cantidad = $('#cantidad').val();

  if ($('#claveUnidad').val() == "") {
		alert("Debe seleccionar la Clave de Unidad de Medida");
		$('#claveUnidad').focus();
		return;
	}

  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#claveUnidad').val() != "ACT") {
		  alert("Para este Tipo de Comprobante, la Clave Unidad debe ser ACT - Actividad");
		  $('#claveUnidad').focus();
		  return;
	  }
  }
  obj.claveUnidad = $('#claveUnidad').val();

  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#unidad').val() != "") {
		  alert("Para este Tipo de Comprobante, la Unidad se debe omitir");
		  $('#unidad').focus();
		  return;
	  }
  }
  if ($('#unidad').val() == ""){
    obj.unidad = null;
   }
  else{
    obj.unidad = $('#unidad').val();
  }	

  if ($('#descripcion').val() == "") {
		alert("Debe proporcionar la Descripción ");
		$('#descripcion').focus();
		return;
	}  

  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#descripcion').val() != "Pago") {
		  alert("Para este Tipo de Comprobante, la Descripción debe ser Pago");
		  $('#descripcion').focus();
		  return;
	  }  
  }
  obj.descripcion = $('#descripcion').val();

	if ($('#valorUnitario').val() == "") {
		alert("Debe introducir el Precio Unitario");
		$('#valorUnitario').focus();
		return;
	}
  
  if (($('#btnTipoComprobante').val() == "cp")||($('#btnTipoComprobante').val() == "pa")) {
  }
  else{
    if (parseFloat($('#valorUnitario').val()) < 0) {
  		alert("El Precio Unitario debe ser mayor a 0");
  		$('#valorUnitario').focus();
  		return;
    }
  }

  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#valorUnitario').val() != "0") {
		  alert("Para este Tipo de Comprobante, el Precio Unitario debe ser 0");
		  $('#valorUnitario').focus();
		  return;
	  }
  }
  obj.valorUnitario = $('#valorUnitario').val();

  if ($('#btnTipoComprobante').val() == "pa"){
    if ($('#descuento').val() != "") {
		  alert("Para este Tipo de Comprobante, el Descuento se debe omitir");
    		$('#descuento').focus();
    		return;
      }
  }
  if ($('#descuento').val() == ""){
    obj.descuento = null;
   }
  else{
    if ($.isNumeric($('#descuento').val())) {
      if (parseFloat($('#descuento').val()) < 0) {
    		alert("El Descuento debe ser mayor a 0");
    		$('#descuento').focus();
    		return;
      }
      else{
        if ($('#descuento').val().indexOf(".") > 0) {
          if (retr_dec($('#descuento').val()) > eval($('#numeroDecimales').val())) {
      	  	alert("El Descuento solo puede contener "+ $('#numeroDecimales').val() + " decimales de acuerdo a la Moneda seleccionada");
      	  	$('#descuento').focus();
    	  	  return;
          }   
    	  }
        obj.descuento = parseFloat($('#descuento').val());
        if ($('#descuentoPorcentaje').val() == 1 || $('#descuentoPorcentaje').val() == "true") {
      		descuento = (obj.valorUnitario * obj.cantidad) * (obj.descuento / 100);
 	        obj.descuento = descuento;
      	}

        obj.descuento = new Number(parseFloat(obj.descuento)).toFixed(numeroDecimales);
      }
    }
    else{
      alert("El Descuento debe ser mayor a 0");
    	$('#descuento').focus();
    	return;
    }
  }
	var importe = ((obj.valorUnitario * obj.cantidad));
	
  if (obj.descuento > importe){
    alert("El Descuento debe ser menor o igual al Importe");
    $('#descuento').focus();
    return;
  }

  if ((obj.claveProdServ == "84121603")||(obj.claveProdServ == "84121604")){
    if (trasladoConceptoArr[0].impuesto != "002"){
      alert("Para el Producto / Servicio indicado, debe agregar el IVA Trasladado");
      $('#baseTrasladoConcepto').focus();
      return;
    }
  }

	obj.ieps = obj.ieps == undefined ? "" : parseFloat(obj.ieps);
	

	if (!$('input[name=mClave]').is(':checked')) {
		delete obj.clave;
	}
  
	var porIva = (1 + ($('#iva').val()) / 100);	
	if ($('#ivaIncluido').is(':checked')) {
		obj.valorUnitario = redondearValor($('#valorUnitario').val() / porIva) + obj.descuento;		
	}

/*
	if ($('#ivaIncluido').is(':checked')) {
	        obj.valorUnitario = redondearValor(importe / porIva);
	}
*/
	if ($('#ivaIncluido').is(':checked')) {	       
                var x = parseFloat($('#ieps').val()) / 100;
                var y = parseFloat($('#iva').val()) / 100;
	}
	
	if ($('#btnAgregarConcepto').find("i").hasClass("icon-edit")){
		if (obj.clave != null){
			mapConceptos[indiceConceptoEditar].clave = obj.clave;
		}
		mapConceptos[indiceConceptoEditar].cantidad = obj.cantidad; 
		mapConceptos[indiceConceptoEditar].claveUnidad = obj.claveUnidad;
		mapConceptos[indiceConceptoEditar].unidad = obj.unidad;
		mapConceptos[indiceConceptoEditar].valorUnitario = obj.valorUnitario;
		mapConceptos[indiceConceptoEditar].descuento = obj.descuento;
		mapConceptos[indiceConceptoEditar].importe = importe;
		$('#claveProdServ').prop('disabled', false);
		
		totalIVA = 0.0;
		totalISRRetenido = 0.0;
		totalIVARetenido = 0.0;
		$('input[name=totalIVARetenido]').val('0.0');
				
		var indexTrasladoArr = 0;
		if (indiceTrasladoEditar != undefined){
			for (i=0;i<mapConceptos.length;i++){
				if (i == indiceConceptoEditar){
					indexTrasladoArr = indexTrasladoArr + indiceTrasladoEditar;
				}
				else{
					if (i < indiceConceptoEditar){
						indexTrasladoArr = indexTrasladoArr + mapConceptos[i].impuestos.traslados.traslado.length;
					}
					else{
						if (i == 0){
							indexTrasladoArr = i;
						}
					}
				}
			}
		}
		
		if (blnTrasladoEliminar){
			trasladoArr.splice(indexTrasladoArr, 1);
		}
		
		if ((blnTrasladoAgregar)&&(indiceTrasladoEditar == undefined)){
			var indexAddT = trasladoConceptoArr.length - 1;
	       	trasladoArr.push(trasladoConceptoArr[indexAddT]);
	    }

		if (trasladoArr.length == 0){
			if (obj.impuestos == undefined){
				obj.iva = null;
				obj.ieps = null;
				$('input[name=totalIEPS]').val('0.0');
				mapConceptos[indiceConceptoEditar] = obj;
			}
		}

		if ((trasladoConceptoArr.length > 0)||(retencionConceptoArr.length > 0)){
			obj.impuestos = new Object();
		}
		
		if (trasladoConceptoArr.length > 0){
			obj.iva = null;
			obj.ieps = null;
		    obj.impuestos.traslados = new Object();
		    obj.impuestos.traslados.traslado = trasladoConceptoArr;
		    $('input[name=totalIEPS]').val(0);
		    
		    for (var i=0;i<trasladoConceptoArr.length;i++){
		    	if (trasladoConceptoArr[i].impuesto == "002"){
		    		if (trasladoConceptoArr[i].tipoFactor != "Exento"){
		    			obj.iva += parseFloat(trasladoConceptoArr[i].importe);
					}
				}
				if (trasladoConceptoArr[i].impuesto == "003"){
					if (trasladoConceptoArr[i].tipoFactor != "Exento"){
						obj.ieps = trasladoConceptoArr[i].importe;
					}
				}
		    	
	    	}
		    
		    if ((!blnTrasladoEliminar)&&(indiceTrasladoEditar != undefined)){
		       	trasladoArr[indexTrasladoArr] =  trasladoConceptoArr[indiceTrasladoEditar];
		    }
		    
		}
 
		for (var i=0;i<trasladoArr.length;i++){
	      if (trasladoArr[i].impuesto == "002"){
	        if (trasladoArr[i].tipoFactor != "Exento"){
	          totalIVA += parseFloat(trasladoArr[i].importe);
	        }
	      }
	      if (trasladoArr[i].impuesto == "003"){
	        if (trasladoArr[i].tipoFactor != "Exento"){
	          $('input[name=totalIEPS]').val(redondearValor(eval ($('input[name=totalIEPS]').val()) + parseFloat(trasladoArr[i].importe)).toFixed(decimalesMoneda));
	        }
	      }
	    } 
		
		trasladoConceptoArr = new Array();
		graficarTrasladoConcepto();
		
		var indexRetencionArr = 0;
		if (indiceRetencionEditar != undefined){
			for (i=0;i<mapConceptos.length;i++){
				if (i == indiceConceptoEditar){
					indexRetencionArr = indexRetencionArr + indiceRetencionEditar;
				}
				else{
					if (i < indiceConceptoEditar){
						indexRetencionArr = indexRetencionArr + mapConceptos[i].impuestos.retenciones.retencion.length;
					}
					else{
						if (i == 0){
							indexRetencionArr = i;
						}
					}
				}
			}
		}
		
		if (blnRetencionEliminar){
			retencionArr.splice(indexRetencionArr, 1);
		}
		
		if ((blnRetencionAgregar)&&(indiceRetencionEditar == undefined)){
			var indexAddR = retencionConceptoArr.length - 1;
	       	retencionArr.push(retencionConceptoArr[indexAddR]);
	    }
		
		if (retencionArr.length == 0){
			obj.ivaRetenido = null;
			obj.isrRetenido = null;
			obj.iepsRetenido = null;
			$('input[name=totalIVARetenido]').val('0.0');
			$('input[name=totalISRRetenido]').val('0.0');
			
			mapConceptos[indiceConceptoEditar] = obj;
		}
		
		if (retencionConceptoArr.length > 0){
			obj.ivaRetenido = 0.0;
			obj.isrRetenido = 0.0;
			obj.isrRetenido = 0.0;
			
			$('input[name=totalIVARetenido]').val('0.0');
			$('input[name=totalISRRetenido]').val('0.0');
			    
		    obj.impuestos.retenciones = new Object();
		    obj.impuestos.retenciones.retencion = retencionConceptoArr;
		
		    for (var i=0;i<retencionConceptoArr.length;i++){
		    	if (retencionConceptoArr[i].impuesto == "002"){
		    		obj.ivaRetenido += parseFloat(retencionConceptoArr[i].importe);
				}
				if (retencionConceptoArr[i].impuesto == "001"){
					obj.isrRetenido = retencionConceptoArr[i].importe;
				}
				if (retencionConceptoArr[i].impuesto == "003"){
					obj.iepsRetenido = retencionConceptoArr[i].importe;
				}
		    }
				    
		    if ((!blnRetencionEliminar)&&(indiceRetencionEditar != undefined)){
		    	retencionArr[indexRetencionArr] =  retencionConceptoArr[indiceRetencionEditar];
		    }
		    
		}
		
		for (var i=0;i<retencionArr.length;i++){
	      if (retencionArr[i].impuesto == "002"){
	        $('input[name=totalIVARetenido]').val(redondearValor(eval ($('input[name=totalIVARetenido]').val()) + parseFloat(retencionArr[i].importe)).toFixed(decimalesMoneda));
	      }
	      if (retencionArr[i].impuesto == "001"){
	    	  $('input[name=totalISRRetenido]').val(redondearValor(eval ($('input[name=totalISRRetenido]').val()) + parseFloat(retencionArr[i].importe)).toFixed(decimalesMoneda));
	      }
	      if (retencionArr[i].impuesto == "003"){
	    	  $('input[name=totalIEPS]').val(redondearValor(eval ($('input[name=totalIEPS]').val()) + parseFloat(retencionArr[i].importe)).toFixed(decimalesMoneda));
	      }
	   } 
		
		retencionConceptoArr = new Array();
		graficarRetencionConcepto();
		
		obj.importe = importe;
		mapConceptos[indiceConceptoEditar] = obj;
		
		if (informacionAduaneraConceptoArr.length > 0){
			for (var i=0;i<informacionAduaneraConceptoArr.length; i++){
				if (i==0){
					obj.informacionAduanera = new Array();
				}
				obj.informacionAduanera.push(informacionAduaneraConceptoArr[i]);
			}
	    }
		
		if (partesConcepto.length > 0){
			obj.parte = partesConcepto;
	    }
		
		$('#btnAgregarConcepto').find("i").toggleClass("icon-plus icon-edit");
	}else{
		if (trasladoConceptoArr.length > 0){
		    obj.impuestos = new Object();
		    obj.impuestos.traslados = new Object();
		    obj.impuestos.traslados.traslado = trasladoConceptoArr;
		      
		    for (var i=0;i<trasladoConceptoArr.length;i++){
		      if (trasladoConceptoArr[i].impuesto == "002"){
		        if (trasladoConceptoArr[i].tipoFactor != "Exento"){
		          obj.iva = trasladoConceptoArr[i].importe;
		          totalIVA += parseFloat(trasladoConceptoArr[i].importe)
		        }
		      }
		      if (trasladoConceptoArr[i].impuesto == "003"){
		        if (trasladoConceptoArr[i].tipoFactor != "Exento"){
		          obj.ieps = trasladoConceptoArr[i].importe;
		          $('input[name=totalIEPS]').val(eval ($('input[name=totalIEPS]').val()) + parseFloat(trasladoConceptoArr[i].importe));
		        }
		      }

		      trasladoArr.push(trasladoConceptoArr[i]);
		    } 
		}
		trasladoConceptoArr = new Array();
		graficarTrasladoConcepto();
		
		if (retencionConceptoArr.length > 0){
		    if (obj.impuestos == null)
		          obj.impuestos = new Object();
		    obj.impuestos.retenciones = new Object();
		    obj.impuestos.retenciones.retencion = retencionConceptoArr;

		    for (var i=0;i<retencionConceptoArr.length;i++){
		      if (retencionConceptoArr[i].impuesto == "002"){
		        obj.ivaRetenido = retencionConceptoArr[i].importe;
		        $('input[name=totalIVARetenido]').val(redondearValor(eval ($('input[name=totalIVARetenido]').val()) + parseFloat(retencionConceptoArr[i].importe)).toFixed(decimalesMoneda));
		      
		      }
		      if (retencionConceptoArr[i].impuesto == "001"){
		        obj.isrRetenido = retencionConceptoArr[i].importe;
		        $('input[name=totalISRRetenido]').val(redondearValor(eval ($('input[name=totalISRRetenido]').val()) + parseFloat(retencionConceptoArr[i].importe)).toFixed(decimalesMoneda));
		      }
		       if (retencionConceptoArr[i].impuesto == "003"){
		        obj.iepsRetenido = retencionConceptoArr[i].importe;
		        $('input[name=totalIEPS]').val(eval ($('input[name=totalIEPS]').val()) + parseFloat(retencionConceptoArr[i].importe));
		      }

		      retencionArr.push(retencionConceptoArr[i]);
		    }
		  }
		  
		  retencionConceptoArr = new Array();
		  graficarRetencionConcepto(); 

		  obj.importe = importe;	
		  
		  if (informacionAduaneraConceptoArr.length > 0){
				for (var i=0;i<informacionAduaneraConceptoArr.length; i++){
					if (i==0){
						obj.informacionAduanera = new Array();
					}
					obj.informacionAduanera.push(informacionAduaneraConceptoArr[i]);
				}
		    }

			if ($('#numeroCuentaPredial').val() != undefined && $('input[name=numeroCuentaPredial]').val()!= ""){
				obj.cuentaPredial = new Object();
				obj.cuentaPredial.numero = $('input[name=numeroCuentaPredial]').val();
				$('input[name=numeroCuentaPredial]').val('');
			}
			else{
				delete obj.cuentaPredial;
			}

			if (partesConcepto.length > 0){
				obj.parte = partesConcepto;
		    }
			
		  mapConceptos.push(obj);
	}
	
	graficarConceptos();
	$('input[name=claveProdServ]').val('');
	$('input[name=cantidad]').val('');
  $('select[name=claveUnidad]').val('');
 	$('input[name=unidad]').val('');
	$('input[name=valorUnitario]').val('');
	$('#descripcion').val('');
 	$('input[name=clave]').val('');
  $('input[name=descuento]').val('');
	
  informacionAduaneraConceptoArr = new Array();
  partesConcepto = new Array();
  informacionAduaneraParteArr = new Array();
  graficarInformacionAduaneraConcepto();
  graficarPartesConcepto();
  graficarInformacionAduaneraParte();
  blnTrasladoEliminar = false;
  blnRetencionEliminar = false;
  blnTrasladoAgregar = false;
  blnRetencionAgregar = false;
  
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

function validarConsumoCombustiblesECC12() {
  if ($('input[name=numeroDeCuentaECC12]').val() != "" && $('input[name=numeroDeCuentaECC12]').val() != undefined) {		
    var EstadoDeCuentaCombustible12 = new Object();
    EstadoDeCuentaCombustible12.tipoOperacion = $('#tipoOperacionECC12').val();
    EstadoDeCuentaCombustible12.numeroDeCuenta = $('#numeroDeCuentaECC12').val();
    if ($('input[name=subTotalCombustiblesECC12]').val() == "") {
      EstadoDeCuentaCombustible12.subTotal = null;
    }    
    else{
      EstadoDeCuentaCombustible12.subTotal = $('#subTotalCombustiblesECC12').val();
    }
    
    EstadoDeCuentaCombustible12.total = $('#totalCombustiblesECC12').val();

    EstadoDeCuentaCombustible12.conceptos = new Object();
    EstadoDeCuentaCombustible12.conceptos.conceptoconsumodecombustibles = new Array();  
    EstadoDeCuentaCombustible12.conceptos.conceptoconsumodecombustibles = conceptosConsumoCombustibles;

    EstadoDeCuentaCombustible12.conceptos.conceptoconsumodecombustibles.traslados = new Object();  
    EstadoDeCuentaCombustible12.conceptos.conceptoconsumodecombustibles.traslados.traslado = new Array();
    EstadoDeCuentaCombustible12.conceptos.conceptoconsumodecombustibles.traslados.traslado = trasladosConsumoCombustibles; 

		return EstadoDeCuentaCombustible12;
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
    if ($('#motivoTrasladoComercioExt').val() == undefined || $('#motivoTrasladoComercioExt').val() == ""){
      comercioExterior.motivoTraslado = null;    
    }
    else{
      comercioExterior.motivoTraslado = $('#motivoTrasladoComercioExt').val();    
    }
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
    
    if ( ($('#calleEmisorComercioExt').val() != "") && ($('#paisEmisorComercioExt').val() != "") ){
      comercioExterior.emisor = new Object();
      if ( $('#curpEmisorComercioExt').val() != ""){
        comercioExterior.emisor.curp = $('#curpEmisorComercioExt').val();
      }
      comercioExterior.emisor.domicilio = new Object();

      if ( $('#calleEmisorComercioExt').val() == ""){
        comercioExterior.emisor.domicilio.calle = null;      
      }
      else{
        comercioExterior.emisor.domicilio.calle = $('#calleEmisorComercioExt').val();
      }
      if ( $('#numeroExteriorEmisorComercioExt').val() == ""){
        comercioExterior.emisor.domicilio.numeroExterior = null;
      }
      else{
        comercioExterior.emisor.domicilio.numeroExterior = $('#numeroExteriorEmisorComercioExt').val();
      }
      if ( $('#numeroInteriorEmisorComercioExt').val() == ""){
        comercioExterior.emisor.domicilio.numeroInterior = null;
      }
      else{
        comercioExterior.emisor.domicilio.numeroInterior = $('#numeroInteriorEmisorComercioExt').val();
      }
      if ( $('#coloniaEmisorComercioExt').val() == ""){
        comercioExterior.emisor.domicilio.colonia = null;
      }
      else{
        comercioExterior.emisor.domicilio.colonia = $('#coloniaEmisorComercioExt').val();
      }
      if ( $('#referenciaEmisorComercioExt').val() == ""){
        comercioExterior.emisor.domicilio.referencia = null;
      }
      else{
        comercioExterior.emisor.domicilio.referencia = $('#referenciaEmisorComercioExt').val();
      }
      if ($('#paisEmisorComercioExt').val() == "ZZZ"){
        comercioExterior.emisor.domicilio.estado = $('#estadoEmisorComercioExtAux').val();
        comercioExterior.emisor.domicilio.localidad = $('#localidadEmisorComercioExtAux').val();
        comercioExterior.emisor.domicilio.municipio = $('#municipioEmisorComercioExtAux').val();
        comercioExterior.emisor.domicilio.codigoPostal = $('#codigoPostalEmisorComercioExtAux').val();
      }
      if ($('#paisEmisorComercioExt').val() == "MEX"){
        comercioExterior.emisor.domicilio.estado = $('#estadoEmisorComercioExt').val();
        if ( $('#localidadEmisorComercioExt').val() == "default"){
          comercioExterior.emisor.domicilio.localidad = null;
        }
        else{
          comercioExterior.emisor.domicilio.localidad = $('#localidadEmisorComercioExt').val();
        }
        comercioExterior.emisor.domicilio.municipio = $('#municipioEmisorComercioExt').val();
        comercioExterior.emisor.domicilio.codigoPostal = $('#codigoPostalEmisorComercioExt').val(); 
        comercioExterior.emisor.domicilio.colonia = $('#coloniaEmisorComercioExt').val();
      }
    else{
        comercioExterior.emisor.domicilio.estado = $('#estadoEmisorComercioExt').val();
        if ( $('#localidadEmisorComercioExtAux').val() == ""){
          comercioExterior.emisor.domicilio.localidad = null;
        }
        else{
          comercioExterior.emisor.domicilio.localidad = $('#localidadEmisorComercioExtAux').val();
        }
        if ($('#municipioEmisorComercioExtAux').val() == undefined || $('#municipioEmisorComercioExtAux').val() == ""){
          comercioExterior.emisor.domicilio.municipio = null;
        }
        else{
          comercioExterior.emisor.domicilio.municipio = $('#municipioEmisorComercioExtAux').val();
        }
        comercioExterior.emisor.domicilio.codigoPostal = $('#codigoPostalEmisorComercioExtAux').val();
        comercioExterior.emisor.domicilio.colonia = $('#coloniaEmisorComercioExtAux').val();
      }
    comercioExterior.emisor.domicilio.pais = $('#paisEmisorComercioExt').val();
    }
    
    if (propietarios.length > 0){
      comercioExterior.propietario = new Object();
      var props = new Array();
      for ( var i = 0; i < propietarios.length; i++) {  
        var prop = new Object();
        prop.numRegIdTrib = propietarios[i].numRegIdTrib;
        prop.residenciaFiscal = propietarios[i].residenciaFiscal;
        props.push(prop);
      }    
      comercioExterior.propietario = props;
    }

    comercioExterior.receptor = new Object();
    if ( ($('#calleReceptorComercioExt').val() != "") && ($('#paisReceptorComercioExt').val() != "") ){
      comercioExterior.receptor.domicilio = new Object();

      if ( $('#calleReceptorComercioExt').val() == ""){
        comercioExterior.receptor.domicilio.calle = null;      
      }
      else{
        comercioExterior.receptor.domicilio.calle = $('#calleReceptorComercioExt').val();
      }
      if ( $('#numeroExteriorReceptorComercioExt').val() == ""){
        comercioExterior.receptor.domicilio.numeroExterior = null;
      }
      else{
        comercioExterior.receptor.domicilio.numeroExterior = $('#numeroExteriorReceptorComercioExt').val();
      }
      if ( $('#numeroInteriorReceptorComercioExt').val() == ""){
        comercioExterior.receptor.domicilio.numeroInterior = null;
      }
      else{
        comercioExterior.receptor.domicilio.numeroInterior = $('#numeroInteriorReceptorComercioExt').val();
      }
      if ( $('#coloniaReceptorComercioExt').val() == ""){
        comercioExterior.receptor.domicilio.colonia = null;
      }
      else{
        comercioExterior.receptor.domicilio.colonia = $('#coloniaReceptorComercioExt').val();
      }
      if ( $('#localidadReceptorComercioExt').val() == ""){
        comercioExterior.receptor.domicilio.localidad = null;
      }
      else{
        comercioExterior.receptor.domicilio.localidad = $('#localidadReceptorComercioExt').val();
      }
      if ( $('#referenciaReceptorComercioExt').val() == ""){
        comercioExterior.receptor.domicilio.referencia = null;
      }
      else{
        comercioExterior.receptor.domicilio.referencia = $('#referenciaReceptorComercioExt').val();
      }
      if (($('select[name=paisReceptorComercioExt]').val() !='MEX')&&($('select[name=paisReceptorComercioExt]').val() !='CAN')&&($('select[name=paisReceptorComercioExt]').val() !='USA')) {
        comercioExterior.receptor.domicilio.estado = $('#estadoReceptorComercioExtAux').val();
        comercioExterior.receptor.domicilio.localidad = $('#localidadReceptorComercioExtAux').val();
        comercioExterior.receptor.domicilio.municipio = $('#municipioReceptorComercioExtAux').val();
        comercioExterior.receptor.domicilio.codigoPostal = $('#codigoPostalReceptorComercioExtAux').val();
      }
      if ($('#paisReceptorComercioExt').val() == "MEX"){
        comercioExterior.receptor.domicilio.estado = $('#estadoReceptorComercioExt').val();
        comercioExterior.receptor.domicilio.localidad = $('#localidadReceptorComercioExt').val();
        comercioExterior.receptor.domicilio.municipio = $('#municipioReceptorComercioExt').val();
        comercioExterior.receptor.domicilio.codigoPostal = $('#codigoPostalReceptorComercioExt').val(); 
        comercioExterior.receptor.domicilio.colonia = $('#coloniaReceptorComercioExt').val();
      }
    else{
        if ($('#estadoReceptorComercioExt').val() == "default"){
              comercioExterior.receptor.domicilio.estado = $('#estadoReceptorComercioExtAux').val();
            }
            else{
              comercioExterior.receptor.domicilio.estado = $('#estadoReceptorComercioExt').val();
            }
        if ( $('#localidadReceptorComercioExtAux').val() == ""){
          comercioExterior.receptor.domicilio.localidad = null;
        }
        else{
          comercioExterior.receptor.domicilio.localidad = $('#localidadReceptorComercioExtAux').val();
        }
        if ($('#municipioReceptorComercioExtAux').val() == undefined || $('#municipioReceptorComercioExtAux').val() == ""){
          comercioExterior.receptor.domicilio.municipio = null;
        }
        else{
          comercioExterior.receptor.domicilio.municipio = $('#municipioReceptorComercioExtAux').val();
        }
        comercioExterior.receptor.domicilio.codigoPostal = $('#codigoPostalReceptorComercioExtAux').val();
        if ($('#coloniaReceptorComercioExtAux').val() == ""){
          comercioExterior.receptor.domicilio.colonia = null;
        }
        else{
          comercioExterior.receptor.domicilio.colonia = $('#coloniaReceptorComercioExtAux').val();
        }
      }
    comercioExterior.receptor.domicilio.pais = $('#paisReceptorComercioExt').val();
    }

    if (destinatarios.length > 0){
      comercioExterior.destinatario = destinatarios;
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

function validarRecepcionPagos() {
  if (pagosArr.length > 0){
	  var pagos = new Object();
    pagos.pago = new Array();
    pagos.pago = pagosArr;
   
	  return pagos;
  }
  return null;
}


function validarRenovSustVeh() {
  if ($('#tipoDeDecreto').val() != undefined && $('#tipoDeDecreto').val() != "")  {

		var renovacionysustitucionvehiculos = new Object();
    renovacionysustitucionvehiculos.tipoDeDecreto = $('#tipoDeDecreto').val();

    if ($('#vehEnajRenovacion').val() != "")  {
      renovacionysustitucionvehiculos.decretoRenovVehicular = new Object();
      renovacionysustitucionvehiculos.decretoRenovVehicular.vehEnaj = $('#vehEnajRenovacion').val();
      
      renovacionysustitucionvehiculos.decretoRenovVehicular.vehiculosUsadosEnajenadoPermAlFab = usadosRenovacion;

      renovacionysustitucionvehiculos.decretoRenovVehicular.vehiculoNuvoSemEnajenadoFabAlPerm = new Object();
      renovacionysustitucionvehiculos.decretoRenovVehicular.vehiculoNuvoSemEnajenadoFabAlPerm = $('.VehiculoNuvoRenovacion').serializeObject();

    }
    if ($('#vehEnajSustitucion').val() != "")  {
      renovacionysustitucionvehiculos.decretoSustitVehicular = new Object();
      renovacionysustitucionvehiculos.decretoSustitVehicular.vehEnaj = $('#vehEnajSustitucion').val();

       renovacionysustitucionvehiculos.decretoSustitVehicular.vehiculoNuvoSemEnajenadoFabAlPerm = new Object();
       renovacionysustitucionvehiculos.decretoSustitVehicular.vehiculoNuvoSemEnajenadoFabAlPerm = $('.VehiculoNuvoSustitucion').serializeObject();        
       renovacionysustitucionvehiculos.decretoSustitVehicular.vehiculoUsadoEnajenadoPermAlFab = new Object();
       renovacionysustitucionvehiculos.decretoSustitVehicular.vehiculoUsadoEnajenadoPermAlFab = $('.VehiculosUsadosSustitucion').serializeObject();     
    }

    return renovacionysustitucionvehiculos;

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
	
	impuestosLocales.totalDeTraslados = impuestosLocales.totalDeTraslados.toFixed(numeroDecimales);
	impuestosLocales.totalDeRetenciones = impuestosLocales.totalDeRetenciones.toFixed(numeroDecimales);
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
	return parseFloat(valor.toFixed(numeroDecimales));

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
	var decimalesMoneda = $("#moneda").find(':selected').attr('numdecimales');

  if ($('#formaPago').val() == "default"){
    comprobante.formaPago = null;
  }
  else{
    comprobante.formaPago = $('#formaPago').val();
  }

  if ($('#metodoPago').val() == "default"){
    comprobante.metodoPago = null;
  }
  else{
    comprobante.metodoPago = $('#metodoPago').val();
  }

  if ($('#condicionesDePago').val() == ""){
    comprobante.condicionesDePago = null;
  }
  else{
    comprobante.condicionesDePago = $('#condicionesDePago').val();
  }

  if ($('#confirmacion').val() == ""){
    comprobante.confirmacion = null;
  }
  else{
    comprobante.confirmacion = $('#confirmacion').val();
  }
  
	if (comprobante.descuento == 0) {
		delete comprobante.descuento;
	}  else {
		comprobante.descuento = redondearValor(comprobante.descuento);
	}

  if (comprobante.tipoCambio == "") {
		delete comprobante.tipoCambio;
	}  

  if ((trasladoArr.length > 0 )||(retencionArr.length > 0 )) {
    comprobante.impuestos =  new Object();
  }

  if (trasladoArr.length > 0 ) {
  	totalImpuestosTrasladados = 0;
    comprobante.impuestos.impuestoTraslados = new Object();
    comprobante.impuestos.impuestoTraslados.impuestoTraslado = trasladoArr;
    for (var i=0;i<trasladoArr.length;i++){
      totalImpuestosTrasladados = totalImpuestosTrasladados + eval(trasladoArr[i].importe);
    }
    if(!Number.isNaN(totalImpuestosTrasladados))
      comprobante.impuestos.totalImpuestosTrasladados = totalImpuestosTrasladados.toFixed(2);
	}
  
  if (retencionArr.length > 0 ) {
  	totalImpuestosRetenidos = 0;
    comprobante.impuestos.impuestoRetenciones = new Object();
    comprobante.impuestos.impuestoRetenciones.impuestoRetencion = retencionArr;    
    for (var i=0;i<retencionArr.length;i++){
      totalImpuestosRetenidos = totalImpuestosRetenidos + eval(retencionArr[i].importe);
    }
    comprobante.impuestos.totalImpuestosRetenidos = totalImpuestosRetenidos.toFixed(2);

	}

  if (cfdiRelacionadoArr.length > 0 ) {
		comprobante.cfdiRelacionados = new Object();
    comprobante.cfdiRelacionados.tipoRelacion = $('#tipoRelacion').val();    
    comprobante.cfdiRelacionados.cfdiRelacionado = cfdiRelacionadoArr;
	}

  if ($('#nombreAlumno').val() != undefined ) {	
    if ($('#nombreAlumno').val() != "" || $('#curp').val() != "" ) {
		  var instEducativas = $('.instEducativas').serializeObject();
		  var index = mapConceptos.length - 1;
		  mapConceptos[index].complementoConcepto = new Object();
		  //mapConceptos[index].complementoConcepto.complementoConcepto = new Object();
		  mapConceptos[index].complementoConcepto.instEducativas = instEducativas;
	  }  
  }
	


   if ($('#NivVentaVehiculos').val() != undefined ) {
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
  }

    if ($('#rfcCuentaTerceros').val() != undefined ) {
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
            if ($('input[name=noExteriorCuentaTerceros]').val() == "") {
                cuentaTerceros.informacionFiscalTercero.noExteriorCuentaTerceros = null;
	        }    
	        else{
	            cuentaTerceros.informacionFiscalTercero.noExteriorCuentaTerceros = $('input[name=noExteriorCuentaTerceros]').val();
	        }
            if ($('input[name=noInteriorCuentaTerceros]').val() == "") {
                cuentaTerceros.informacionFiscalTercero.noInteriorCuentaTerceros = null;
	        }    
	        else{
	            cuentaTerceros.informacionFiscalTercero.noInteriorCuentaTerceros = $('input[name=noInteriorCuentaTerceros]').val();
	        }
            if ($('input[name=coloniaCuentaTerceros]').val() == "") {
                cuentaTerceros.informacionFiscalTercero.coloniaCuentaTerceros = null;
	        }    
	        else{
	            cuentaTerceros.informacionFiscalTercero.coloniaCuentaTerceros = $('input[name=coloniaCuentaTerceros]').val();
	        }
            if ($('input[name=localidadCuentaTerceros]').val() == "") {
                cuentaTerceros.informacionFiscalTercero.localidadCuentaTerceros = null;
	        }    
	        else{
	            cuentaTerceros.informacionFiscalTercero.localidadCuentaTerceros = $('input[name=localidadCuentaTerceros]').val();
	        }
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
          if ($('input[name=aduanaCuentaTerceros]').val() == "") {
              cuentaTerceros.informacionAduanera.aduanaCuentaTerceros = null;
            }    
            else{
              cuentaTerceros.informacionAduanera.aduanaCuentaTerceros = $('input[name=aduanaCuentaTerceros]').val();
            }
        }

        if (partes.length > 0){
          cuentaTerceros.parte = new Object();
          cuentaTerceros.parte = partes;
       
        }

        if ($('#numeroCuentaPredialTerceros').val() != "" ) {
          cuentaTerceros.cuentaPredial = new Object();
          cuentaTerceros.cuentaPredial = $('.cuentaPredialTerceros').serializeObject();
        }

        if ((retencionesCuentaTerceros.length > 0)||(trasladosCuentaTerceros.length > 0)){
          cuentaTerceros.impuestos = new Object();
        }
        
        if (retencionesCuentaTerceros.length > 0){
          
          cuentaTerceros.impuestos.retenciones = new Object();  
          cuentaTerceros.impuestos.retenciones.retencion = new Object();
          cuentaTerceros.impuestos.retenciones.retencion = retencionesCuentaTerceros;            
        }
        
        if (trasladosCuentaTerceros.length > 0){
          cuentaTerceros.impuestos.traslados = new Object();  
          cuentaTerceros.impuestos.traslados.traslado = new Object();  
          cuentaTerceros.impuestos.traslados.traslado = trasladosCuentaTerceros;            
        }
        
		    var index = mapConceptos.length - 1;
		    mapConceptos[index].complementoConcepto = new Object();
		    //mapConceptos[index].complementoConcepto.complementoConcepto = new Object();
		    mapConceptos[index].complementoConcepto.cuentaTerceros = cuentaTerceros;
	    }
    }

	var propiedades = new Array("serie", "folio", "descuento", "ieps", "numCtaPago");
	limpiarObjecto(propiedades, comprobante);

	comprobante.emisor = $('.emisor').serializeObject();

	comprobante.noObjetoIva = noObjIva;

	comprobante.emisor.regimenFiscal = $('#regimen option:selected').val();


	comprobante.receptor = $('.receptor').serializeObject();
  if ($('input[name=nombreReceptor]').val() == "") {
    comprobante.receptor.nombre = null;
  }    
  else{
    comprobante.receptor.nombre = $('input[name=nombreReceptor]').val();
  }
  if ($('select[name=residenciaFiscal]').val() == "default") {
    comprobante.receptor.residenciaFiscal = null;
  }    
  else{
    comprobante.receptor.residenciaFiscal = $('select[name=residenciaFiscal]').val();
  }  
  if ($('input[name=numRegIdTrib]').val() == "") {
    comprobante.receptor.numRegIdTrib = null;
  }    
  else{
    comprobante.receptor.numRegIdTrib = $('input[name=numRegIdTrib]').val();
  }  
	//  if ($('#estadoAux').val() !=""){
  //  comprobante.receptor.domicilio.estado = $('#estadoAux').val();  
  //  }
  
  //delete comprobante.receptor.domicilio.estadoAux;  
	//propiedades = new Array("calle", "colonia", "localidad", "municipio", "codigoPostal", "noExterior", "noInterior");
//	limpiarObjecto(propiedades, comprobante.receptor.domicilio);

	var ivaTras = 0;
	/* limpiamos los conceptos */
	$.each(mapConceptos, function(key, value) {
    if ($('#btnTipoComprobante').val() != "pa"){
      mapConceptos[key].importe =	new Number(mapConceptos[key].importe).toFixed(numeroDecimales);;
    }
		if (mapConceptos[key]['ivaExento'] == undefined) {
			ivaTras += mapConceptos[key]["iva"];
		}
		
		propiedades = new Array("No. Identificación", "iva", "descuento", "ieps");
		$.each(propiedades, function(key1, value1) {
			if (mapConceptos[key][value1] == "") {
				delete mapConceptos[key][value1];
			}
		});

	});

	comprobante.conceptos = new Object();
	comprobante.conceptos.conceptos = mapConceptos;

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
		comprobante.complemento.consumodecombustibles.version = "1.1";
		comprobante.complemento.consumodecombustibles = consumocombustibles;
	}

  var estadodecuentacombustible12 = validarConsumoCombustiblesECC12();
	if (estadodecuentacombustible12 != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.estadodecuentacombustible12 = new Object();
		comprobante.complemento.estadodecuentacombustible12.version = "1.2";
		comprobante.complemento.estadodecuentacombustible12 = estadodecuentacombustible12;
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

  var pagos = validarRecepcionPagos();
	if (pagos != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.pagos = pagos;
	}

  var renovSustVeh = validarRenovSustVeh();
	if (renovSustVeh != null) {
		if (comprobante.complemento == undefined) {
			comprobante.complemento = new Object();
		}
		comprobante.complemento.renovacionysustitucionvehiculos = renovSustVeh;
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
	if(descuento > 0) {
		comprobante.descuento = redondearValor(descuento).toFixed(decimalesMoneda);
	} else {
		delete comprobante.descuento;
	}
	comprobante.total = new Number(comprobante.total).toFixed(decimalesMoneda);
	comprobante.subTotal = new Number(comprobante.subTotal).toFixed(decimalesMoneda);
	return JSON.stringify(comprobante, null, " ");
}

function validarFactura() {
  if ($('#lugarExpedicion').val() == "") {
		alert("Debe indicar el Lugar de Expedición");
		$('#lugarExpedicion').focus();
    return false;
  }
	if (mapConceptos.length == 0) {
		alert("Debe agregar al menos un concepto.");
		return false;
	}

 	if (($('#btnTipoComprobante').val() == "cp")||($('#btnTipoComprobante').val() == "pa")) {

  }
  else{
      if ($('#formaPago').val() == "default") {
    		alert("Debe indicar la Forma de Pago");
    		$('#formaPago').focus();
		    return false;
      }
      if ($('#metodoPago').val() == "default") {
    		alert("Debe indicar el Método de Pago");
    		$('#metodoPago').focus();
		    return false;
      }
      if ($('#condicionesDePago').val() == "") {
    		alert("Debe indicar las Condiciones de Pago");
    		$('#condicionesDePago').focus();
		    return false;
      }
    	if (($('input[name=total]').val() > 999999999999999999.999999)&&($('#confirmacion').val() == "")) {
    		alert("El valor Total es mayor que el valor máximo aplicable, debe proporcionar el campo Confirmación.");
    		$('#confirmacion').focus();
		    return false;
      }
      if (($('input[name=total]').val() <= 999999999999999999.999999)&&($('#confirmacion').val() != "")) {
    		alert("No debe proporcionar el campo Confirmación, ya que el campo Total está dentro del rango válido.");
    		$('#confirmacion').focus();
		    return false;
      }
	}

  if ($('#btnTipoComprobante').val() == "pa"){
     if ($('#moneda').val() != "XXX") {
        alert("Para el Tipo de CFDI Pago, el campo Moneda debe tener el valor XXX - 'Los códigos asignados para las transacciones en que intervenga ninguna moneda'.");
    		$('#moneda').focus();
		    return false;
      }
      if ($('#tipoCambio').val() != "") {
        alert("Para el Tipo de CFDI Pago, el campo Tipo de Cambio no se debe ingresar.");
    		$('#tipoCambio').focus();
		    return false;
      }
      if ($('#usoCFDI').val() != "P01") {
        alert("Para el Tipo de CFDI Pago, el campo Uso de CFDI debe ser P01 - Por definir.");
    		$('#usoCFDI').focus();
		    return false;
      }
      if (mapConceptos.length > 1) {
        alert("Para el Tipo de CFDI Pago, se debe registrar solo un nodo concepto.");
    		$('#confirmacion').focus();
		    return false;
      }
  }

	if ($('input[name=rfc].receptor').val().length == 12){
    if (arrayUsoCFDIPersonasMorales.indexOf($('#usoCFDI').val()) >= 0){
      alert("El valor del campo UsoCFDI no corresponde con el Tipo de Persona del Receptor");      
      $('#usoCFDI').focus();
	    return false;
    }
  }

  if (($('input[name=rfc].receptor').val() == "XAXX010101000")&&($('select[name=residenciaFiscal]').val() != "default")){
    alert("Al usar un RFC genérico nacional, no se debe registrar el campo Residencia Fiscal.");
    $('#residenciaFiscal').focus();
    return false;
  }

  if ($('input[name=rfc].receptor').val() == "XEXX010101000"){
    if (($('#tipoOperacionComercioExt').val() != undefined && $('#tipoOperacionComercioExt').val() != "")||($('input[name=numRegIdTrib].receptor').val() != ""))  {
      if ($('select[name=residenciaFiscal]').val() == "default"){
        alert("El campo Residencia Fiscal es requerido cuando se incluya el Complemento de Comercio Exterior o se registre el campo NumRegId Trib:");
        $('#residenciaFiscal').focus();
        return false;
      }    
    }    
    if ($('select[name=residenciaFiscal]').val() == "MEX"){
      alert("Al usar un RFC genérico extranjero en el Receptor, el campo Residencia Fiscal no puede ser México.");
      $('#residenciaFiscal').focus();
      return false;
    }
  }

  if (($('input[name=rfc].receptor').val() == "XAXX010101000")&&($('input[name=numRegIdTrib].receptor').val() != "")){
    alert("Al usar un RFC genérico nacional, no se debe registrar el campo NumRegIdTrib.");
    $('#numRegIdTrib').focus();
    return false;
  }

  if (($('select[name=residenciaFiscal]') == "USA")||($('select[name=residenciaFiscal]').val() == "CAN")){
    var re = new RegExp("^[0-9]{9}$");
    if (!re.test($('input[name=numRegIdTrib].receptor').val())) {
      alert("El campo NumRegIdTrib del Cliente, no cumple con el patrón [0-9]{9} correspondiente a la Residencia Fiscal seleccionada.");
      $('#numRegIdTrib').focus();
      return false;
    }
  }

  if (($('select[name=residenciaFiscal]').val() != "default")&&($('input[name=numRegIdTrib].receptor').val() == "")){
    alert("Al indicar el campo Residencia Fiscal, debe indicar el campo NumRegIdTrib.");
    $('#numRegIdTrib').focus();
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
    if ($('#btnTipoComprobante').val() == "pa"){
      alert("El Tipo de Comprobante no puede ser Pago, si se desea usar el Complemento de Comercio Exterior 1.1");
    	return false;
    }
    if ($('#btnTipoComprobante').val() == "cp"){
      if ($('select[name=motivoTrasladoComercioExt]').val() =='') {
        alert("Si el Tipo de Comprobante es de Traslado, debe indicar el Motivo de Traslado");
        $('#motivoTrasladoComercioExt').focus();
      	return false;
      }
      if ($('select[name=motivoTrasladoComercioExt]').val() =='05') {
        if (propietarios.length < 1){
          alert("Si el Tipo de Comprobante es de Traslado y el campo Motivo Traslado es Envío de mercancías propiedad de terceros, se debe registrar el nodo Propietario");
          $('input[name=NumRegIdTribPropietarioComercioExt]').focus();
        	return false;
        }
      }
      if ($('select[name=motivoTrasladoComercioExt]').val() !='02') {
        if ($('input[name=rfc].receptor').val() != "XEXX010101000"){
          alert("Si el Tipo de Comprobante es de Traslado y el campo Motivo Traslado es diferente de Reubicación de mercancías propias, el RFC del Receptor solo puede ser XEXX010101000");
          $('input[name=rfc].receptor').focus();
        	return false;
        }
      }
      if (destinatarios.length > 1){
        alert("Si el Tipo de Comprobante es de Traslado solo se puede registrar un destinatario");
          $('input[name=NumRegIdTribDestinatarioComercioExt]').focus();
        	return false;
      }
    }
    else{
      if (($('select[name=motivoTrasladoComercioExt]').val() !='')||(propietarios.length > 0)) {
        alert("Si el Tipo de Comprobante es diferente de Traslado el atributo MotivoTraslado y el nodo Propietario no deben existir.");
          $('select[name=motivoTrasladoComercioExt]').focus();
        	return false;
      }
    }
    if ($('input[name=nombreReceptor].receptor').val() == ""){
      alert("Es obligatorio proporcionar el Nombre del Receptor");
        $('input[name=nombreReceptor].receptor').focus();
      	return false;
    }
    if ($('select[name=motivoTrasladoComercioExt]').val() =='05') {
      if (propietarios.length < 1){
        alert("Si el campo Motivo Traslado es Envío de mercancías propiedad de terceros, debe agregar al menos 1 nodo Propietario");
        $('#NumRegIdTribPropietarioComercioExt').focus();
      	return false;
      }
    }
    else{
      if (propietarios.length > 0){
        alert("Si el campo Motivo Traslado es diferente de Envío de mercancías propiedad de terceros, no debe agregar el nodo Propietario");
        $('#NumRegIdTribPropietarioComercioExt').focus();
      	return false;
      }
    }
   

    if ($('#tipoOperacionComercioExt').val() =="A"){
      if (($('#motivoTrasladoComercioExt').val() !="")||($('#clavePedimento').val() !="")||($('#certificadoOrigen').val() !="")||($('#numCertificadoOrigen').val() !="")|| ($('#numExportadorConfiable').val() !="")||($('#Incoterm').val() !="")||($('#Subdivision').val() !="")||($('#TipoCambioUSD').val() !="")|| (mercancias.length > 0))  {
      alert("Si la clave registrada en el campo Tipo Operación es 'A', no deben existir los siguientes atributos: MotivoTraslado, ClaveDePedimento, CertificadoOrigen, NumCertificadoOrigen, NumExportadorConfiable, Incoterm, Subdivisión, TipoCambioUSD, TotalUSD y Mercancias");
      $('#motivoTrasladoComercioExt').focus();
      return false;
      }      
    }  //tipoOperacion es A  

    if (($('#tipoOperacionComercioExt').val() =="1")||($('#tipoOperacionComercioExt').val() =="2")){
      if (($('#clavePedimento').val() =="")||($('#certificadoOrigen').val() =="")||($('#Incoterm').val() =="")||($('#Subdivision').val() =="")||($('#TipoCambioUSD').val() =="")|| (mercancias.length < 1))  {
      alert("Si la clave registrada en el campo Tipo Operación es '1' ó '2', deben existir los siguientes atributos: ClaveDePedimento, CertificadoOrigen, Incoterm, Subdivision, TipoCambioUSD, TotalUSD y Mercancias");
      $('#clavePedimento').focus();
      return false;
      }
      if (!validaNoIdentificacionConcepto()){
        alert("Cada concepto registrado en el elemento cfdi:Comprobante:Conceptos, debe tener registrado el atributo cfdi:Comprobante:Conceptos:Concepto:noIdentificacion, favor de verificar");
     		return false;
      }
      if (!validaNoIdentificacionConceptoVsMercancia()){
        alert("Al menos uno de los elementos registrados en cfdi:Comprobante:Conceptos, debe tener un registro relacionado en el nodo mercancías, donde el atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion sea igual al atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion.");
     		return false;
      }
      if (!validaNoIdentificacionMercanciaConcepto()){
        alert("Por cada Mercancía registrada en el elemento cce11:ComercioExterior:Mercancias, debe existir al menos un Concepto registrado en cfdi:Comprobante:Conceptos donde el atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion sea igual al atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion.");
     		return false;
      }
      if (!validaFraccionArancelaria98010001()){
        alert("La suma de los valores del atributo cfdi:Comprobante:Conceptos:Concepto:Descuento debe ser mayor o igual a la suma de los campos cce:ComercioExterior:Mercancias:Mercancia:ValorDolares de las mercancías que tienen la fracción arancelaria 98010001 - (Importaciones o exportaciones de muestras y muestrarios)");
     		return false;
      }
      if (!validaCantidadUnidadValorUnitarioAduana()){
        alert("Si un elemento cce:ComercioExterior:Mercancias:Mercancia tiene los atributos CantidadAduana, UnidadAduana y ValorUnitarioAduana, entonces todos los elementos mercancía del comprobante deben tener los tres atributos.");
     		return false;
      }      
    }//tipoOperacion es 1 o 2

    if (($('select[name=certificadoOrigen]').val() == "0")&&($('input[name=numCertificadoOrigen]').val() != "")){
      alert("Para el valor del campo Certificado Origen seleccionado no se debe registrar el campo Número Certificado Origen");
  		return false;
    }
    if (!validaNumExportadorConfiable($('select[name=paisReceptorComercioExt]').val())){
      if ($('input[name=numExportadorConfiable]').val() != ""){
        alert("Para el país seleccionado en la sección Receptor de CCE 1.1, no debe indicar el campo Número de Exportador Confiable");
        $('#numExportadorConfiable').focus();
    		return false;
      }
    }
    if (!validaNumExportadorConfiable($('select[name=paisDestinatarioComercioExt]').val())){
      if ($('input[name=numExportadorConfiable]').val() != ""){
        alert("Para el país seleccionado en la sección Destinatario de CCE 1.1, no debe indicar el campo Número de Exportador Confiable");
        $('#numExportadorConfiable').focus();
    		return false; 
      }
    }
    
    if (($('input[name=rfc].emisor').val().length == 12)&&($('input[name=curpEmisorComercioExt]').val() != "")){
		  alert("Si el atributo [rfc] del nodo cfdi:Comprobante:Emisor es de longitud 12, entonces el campo cce11:ComercioExterior:Emisor:Curp no debe existir.");
      $('#curpEmisorComercioExt').focus();
  		return false;
	  }
    if (($('input[name=rfc].emisor').val().length == 13)&&($('input[name=curpEmisorComercioExt]').val() == "")){
		  alert("Si el atributo [rfc] del nodo cfdi:Comprobante:Emisor es de longitud 13, entonces el campo cce11:ComercioExterior:Emisor:Curp debe existir.");
      $('#curpEmisorComercioExt').focus();
  		return false;
	  }

    if ($('select[name=paisEmisorComercioExt]').val() != "MEX"){
      alert("Se debe indicar el Pais del Domicilio del Emisor");
      $('#paisEmisorComercioExt').focus();
   		return false;
    }
    if ($('select[name=estadoEmisorComercioExt]').val() == "default"){
      alert("Se debe indicar el Estado del Domicilio del Emisor");
      $('#estadoEmisorComercioExt').focus();
   		return false;
    }
    if ($('select[name=municipioEmisorComercioExt]').val() == "default"){
      alert("Se debe indicar el Municipio del Domicilio del Emisor");
      $('#municipioEmisorComercioExt').focus();
   		return false;
    }  
    if ($('select[name=codigoPostalEmisorComercioExt]').val() == "default"){
      alert("Se debe indicar el Código Postal del Domicilio del Emisor");
      $('#codigoPostalEmisorComercioExt').focus();
   		return false;
    }  
    if (($('select[name=ResidenciaFiscalPropietarioComercioExt]').val() == "Canadá")||
      ($('select[name=ResidenciaFiscalPropietarioComercioExt]').val() == "Estados Unidos (los)")){
      var re = new RegExp("[0-9]{9}$");
      if (!re.test($('input[name=NumRegIdTribPropietarioComercioExt]').val())) {
  		  alert("El campo Número de Identificación o Registro fiscal del Propietario no cumple con el patrón [0-9]{9} establecido ");
        $('#NumRegIdTribPropietarioComercioExt').focus();
    		return false;
	    } 
    }

    if ($('select[name=ResidenciaFiscalPropietarioComercioExt]').val() == "México"){
      var re = new RegExp("[A-Z&Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]$");
      if (!re.test($('input[name=NumRegIdTribPropietarioComercioExt]').val())) {
  		  alert("El campo Número de Identificación o Registro fiscal del Propietario no cumple con el patrón [A-Z&Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A] establecido ");
        $('#NumRegIdTribPropietarioComercioExt').focus();
    		return false;
	    } 
    }

    if ($('select[name=paisReceptorComercioExt]').val() == "default"){
      alert("Debe indicar el campo Pais del Domicilio del Receptor");
      $('#paisReceptorComercioExt').focus();
 	  	return false;
    }
    if ((($('select[name=estadoReceptorComercioExt]').val() == "default")||($('select[name=estadoReceptorComercioExt]').val() == null))&&
($('input[name=estadoReceptorComercioExtAux]').val() == "")){ 
      alert("Debe indicar el campo Estado del Domicilio del Receptor");
 	  	return false;
    }
    if ((($('select[name=codigoPostalReceptorComercioExt]').val() == "default")||($('select[name=codigoPostalReceptorComercioExt]').val() == null))&&
($('input[name=codigoPostalReceptorComercioExtAux]').val() == "")){    
      alert("Debe indicar el campo Código Postal del Domicilio del Receptor");
 	  	return false;
    }
    if ($('input[name=calleReceptorComercioExt]').val() == ""){    
      alert("Debe indicar el campo Calle del Domicilio del Receptor");
      $('#calleReceptorComercioExt').focus();
 	  	return false;
    }
    if ($('select[name=paisReceptorComercioExt]').val() == "CAN"){
        if (!validateCodigoPostalCanada($('input[name=codigoPostalReceptorComercioExtAux]').val())){
          alert("El Código Postal del país en la sección Receptor no cumple con el patrón [A-Z][0-9][A-Z] [0-9][A-Z][0-9]");
       		return false;
        }
      }
      if ($('select[name=paisReceptorComercioExt]').val() == "USA"){
        if (!validateCodigoPostalEEUU($('input[name=codigoPostalReceptorComercioExtAux]').val())){
          alert("El Código Postal del país en la sección Receptor no cumple con el patrón [0-9]{5}(-[0-9]{4})?");
       		return false;
        }
      }

  }
  
	return true;
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
	if (($('select[name=paisDestinatarioComercioExt]').val() !='MEX')&&($('select[name=paisDestinatarioComercioExt]').val() !='CAN')&&($('select[name=paisDestinatarioComercioExt]').val() !='USA')) {
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

function validaPaisReceptorCCE() {
if (($('select[name=paisReceptorComercioExt]').val() !='MEX')&&($('select[name=paisReceptorComercioExt]').val() !='CAN')&&($('select[name=paisReceptorComercioExt]').val() !='USA')) {
    $('.divEstadoReceptorComercioExtAux').show(0);
    $('.divEstadoReceptorComercioExt').hide(1);
	}
  else{
    $('.divEstadoReceptorComercioExtAux').hide(1); 
    $('.divEstadoReceptorComercioExt').show(0);
  }
  
  if ($('select[name=paisReceptorComercioExt]').val() =='MEX') {
    $('.divLocalidadReceptorComercioExt').show(0);
    $('.divLocalidadReceptorComercioExtAux').hide(1);
    $('.divMunicipioReceptorComercioExt').show(0);
    $('.divMunicipioReceptorComercioExtAux').hide(1);
    $('.divCodigoPostalReceptorComercioExt').show(0);
    $('.divCodigoPostalReceptorComercioExtAux').hide(1);
    $('.divColoniaReceptorComercioExt').show(0);
    $('.divColoniaReceptorComercioExtAux').hide(1);
	}
  else{
    $('.divLocalidadReceptorComercioExt').hide(1);
    $('.divLocalidadReceptorComercioExtAux').show(0);
    $('.divMunicipioReceptorComercioExt').hide(1);
    $('.divMunicipioReceptorComercioExtAux').show(0);
    $('.divCodigoPostalReceptorComercioExt').hide(1);
    $('.divCodigoPostalReceptorComercioExtAux').show(0);
    $('.divColoniaReceptorComercioExt').hide(1);
    $('.divColoniaReceptorComercioExtAux').show(0);
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
	if ($("#btnTipoComprobante").val() == "pa"){
		$('#usoCFDI').children().remove().end().append('<option selected value="P01">P01 Por definir</option>') ;
		$("#formaPago").children().remove().end().append('<option selected value="default">Seleccionar</option>') ;
		$("#condicionesDePago").val("");
		$("#moneda").children().remove().end().append('<option selected value="XXX">Los códigos asignados para las transacciones en qu</option>') ;
		$("#metodoPago").children().remove().end().append('<option selected value="default">Seleccionar</option>') ;
		$("#tipoCambio").val("");
		
		var obj = new Object();
		obj.claveProdServ = "84111506";
		obj.clave = null;
		obj.cantidad = "1";
		obj.claveUnidad = "ACT";
		obj.unidad = null;
		obj.descripcion = "Pago";
		obj.valorUnitario = "0";
		obj.descuento = null;
		obj.importe = 0;
		mapConceptos.push(obj);
		graficarConceptos();
	}

}

/**
* Obtener la cantidad total de importes retenidos y trasladados apartir de los arreglos
*/
function getImpuestos() {
	var totalImpuestos = {
		trasladados : 0.00,
		retenidos 	: 0.00
	};
	$.each(trasladoArr, function(k, v){
    if (v.importe != null){
   		totalImpuestos.trasladados += parseFloat(parseFloat(v.importe).toFixed(numeroDecimales));
    }

	});
	$.each(retencionArr, function(k, v){
		totalImpuestos.retenidos += parseFloat(parseFloat(v.importe).toFixed(numeroDecimales));
	});
	return totalImpuestos;
}

function graficarConceptos() {
	var row = '';
	var fields = new Array("claveProdServ", "cantidad", "claveUnidad", "unidad", "clave", "descripcion",
			"valorUnitario", "descuento", "importe", "iva", "ieps");
	var input = '<td>:value</td>';
	var subtotal = 0, totalDescuento = 0;
	var importe = 0, iva = 0;
	totalDescuento = descuento = 0;
	if (mapConceptos.length == 0) {
		totalIVA = 0;
		totalIEPS = 0;
		mapImpuestosTraslados = new Array();
		$('#tablaConceptos tbody').html('<tr><td colspan="11" class="noItemns">No ha seleccionado ning\u00FAn concepto.</td></tr>');
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
	var showIEPS = false;
	var decimalesMoneda = $("#moneda").find(':selected').attr('numdecimales');
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
				tipoImporte = false;
				input = '<td>:value</td>';
				if (value1 == "importe") {
					value['importe'] = importe;
							+ (value['ivaExcento'] != 'on' ? 0 : iva);
					tipoImporte = true;
				} else if (value1 == "descuento") {
					input = "<td class='divDescuento'>:value</td>";
					tipoImporte = true;
				} else if (value1 == "clave") {
					input = "<td class='divClave "
							+ ($("input[name=mClave]").is(':checked') ? ""
									: "hidden") + "'>:value</td>";
				}  else if (value1 == "ieps") {
					input = "<td class='divIEPS'>:value</td>";
					if(eval(value[value1]) != undefined && !showIEPS){
						showIEPS = true;
					}
        			tipoImporte = true;
				} else if (value1 == "iva") {
					if (value['ivaExento'] == 'on') {
						input = '<td>Exento</td>';
					}
					tipoImporte = true;
				}
	          	if (value[value1] == null){
	            	row += input.replace(':value', "");
	          	}
	          	else{
	          		if(!tipoImporte) {
						row += input.replace(':value', value[value1]);
	          		} else{
                    if ($('#btnTipoComprobante').val() != "pa"){
	          	    		row += input.replace(':value', parseFloat(value[value1]).toFixed(numeroDecimales));
                    }
                    else{
                      row += input.replace(':value', value[value1]);
                    }
	          		}
	          	}
		});
		if (descuento < 0) {
			descuento = 0;
		}
		row += '<td><a class="eliminarConcepto" onClick="eliminarData(' + key
				+ ')" id="concepto-' + key
				+ '"><i class="icon-remove"></i> Eliminar </a></td>';
		row += '<td><a class="editarConcepto" onClick="editarData(' + key
				+ ')" id="concepto-' + key
				+ '"><i class="icon-edit"></i> Editar </a></td>';
		row += '</tr>';
		$('#tablaConceptos tbody').html(row);
		if(showIEPS){
			$('.divIEPS').show(0);
		} else {
			$('.divIEPS').hide(0);
		}
	});
	impuestosCalculados = getImpuestos();
	/* Calculo de impuestos */
	var montoDescuento = ($('#montoDescuento').val() == "" || $('#montoDescuento').val() == undefined ? 0 : parseFloat($('#montoDescuento').val()));
	// descuento = totalDescuento + montoDescuento;
	subtotal = subtotal; + totalDescuento;
	subtotal -= montoDescuento;
	
	descuento = totalDescuento + montoDescuento;

	var total = parseFloat(subtotal + totalIEPS) - parseFloat(descuento) + parseFloat(totalIVA);

	if ($('input[name=totalIVARetenido]').val() != "") {
		total -= parseFloat($('input[name=totalIVARetenido]').val());
	}
	if ($('input[name=totalISRRetenido]').val() != "") {
		total -= parseFloat($('input[name=totalISRRetenido]').val());
	}
	// total = redondearValor(total) + montoDescuento;
	total = (subtotal + impuestosCalculados.trasladados) - (totalDescuento + impuestosCalculados.retenidos);
	var impuestosLocales = validarImpuestosLocales();

  if (impuestosLocales != undefined) {
		total = redondearValor(total - impuestosLocales.totalDeRetenciones);
		total = redondearValor(total + impuestosLocales.totalDeTraslados);
	}


	$('input[name=total]').val(total.toFixed(decimalesMoneda));
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
	$('input[name=totalDescuento]').val(descuento <= 0 ? 0.00 : (redondearValor(descuento)).toFixed(decimalesMoneda));

  if ($('#btnTipoComprobante').val() =="pa") {
    $('input[name=subTotal]').val("0");
    $('input[name=total]').val("0");
  }else{
    $('input[name=subTotal]').val((subtotal + montoDescuento).toFixed(decimalesMoneda));
  }
//	$('input[name=totalIEPS]').val(redondearValor(totalIEPS));
	$('input[name=totalIVA]').val(totalIVA.toFixed(decimalesMoneda));
}

function getFolio() {
	var serie = $('#serie').val();
	$.get('/CFDI33/rest/comprobante/folio/' + serie, function(response) {
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

// Cancelar la captura de | en los campos indicados
cancelKeyPipe("#serie");
cancelKeyPipe("#folio");
cancelKeyPipe("#condicionesDePago");
cancelKeyPipe("#nombreReceptor");

cancelKeyPipe("#clave");
cancelKeyPipe("#unidad");
cancelKeyPipe("#descripcion");

cancelKeyPipe("#claveParte");
cancelKeyPipe("#unidadParte");
cancelKeyPipe("#conceptoParte");

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



					numeroDecimales = ($('#numeroDecimales').val() == null || $('#numeroDecimales').val() == "") ? 2 : $('#numeroDecimales').val();
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

          $('#fechaExpOperECC12').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaSpei').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaPago').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaRegularizacionRenovacion').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

          $('#fechaRegularizacionSustitucion').datepicker({
						format : 'yyyy-mm-dd',
						language : 'es'
					});

					$('#btnTipoComprobante').change(function() {
						top.location.href = $('#btnTipoComprobante').val();
					});

					$('.divIEPS').hide(0);

					if ($('#confiClave').val() == "false") {
						$('.divClave').hide(0);
					} else {
						$('.divClave').show(0);
					}

          $('.divTasaCuotaTrasladoConceptoRango').hide(0);
          $('.divTasaCuotaTrasladoConceptoFijo').show(0);

          $('.divTasaCuotaRetencionConceptoRango').show(0);          
          $('.divTasaCuotaRetencionConceptoFijo').hide(0);          
          
          
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
								if(mapConceptos.length > 0){
									graficarConceptos();
								}
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
						if (parseFloat($(this).val()) > (parseFloat($('#valorUnitario').val()) * parseFloat($('#cantidad').val()))) {
							alert("El descuento no puede ser mayor al importe");
							$(this).focus();
						}
					});

          $('#regimen').change(
            function() {    
              if ($('input[name=rfc].emisor').val().length == 12){
                if (arrayRegimenesMorales.indexOf($('#regimen').val()) < 0){
				          alert("Su RFC tiene 12 posiciones, por lo que el Régimen Fiscal debe corresponder a Personas Morales");
          			}
		          }
		          if ($('input[name=rfc].emisor').val().length == 13){
                if (arrayRegimenesFisicas.indexOf($('#regimen').val()) < 0){
				          alert("Su RFC tiene 13 posiciones, por lo que el Régimen Fiscal debe corresponder a Personas Físicas");
			          }	
		          }
            });

          $('#residenciaFiscal').change(function() {
            if ($('input[name=rfc].receptor').val() == "XEXX010101000"){
                if (($('#tipoOperacionComercioExt').val() != undefined || $('#tipoOperacionComercioExt').val() != "")||($('input[name=numRegIdTrib].receptor').val() != ""))  {
                  if ($(this).val() != "default"){
                    alert("Este campo debe permanecer en “Seleccionar” a menos que el RFC pertenezca a un extranjero y se incluya el Complemento de Comercio Exterior o se registre el campo NumRegId Trib");
                  }
                }
            }
					});

          $('#numRegIdTrib').change(function() {
            if ($(this).val() != "default"){
              alert("Este campo no se debe proporcionar a menos que el RFC pertenezca a un extranjero");
            }
					});

          			$('#formVistaPrevia, #formGenerarComprobante, #formVistaPrefactura').unbind('submit').bind('submit',  //submit(
							function() {
								if (!validarFactura()) {
									return false;
								}
								$('.strComprobante').val(comprobanteToJSON());
                                                                if ($(this).attr('id') == "formGenerarComprobante")
								$('#generarComprobante').attr('disabled', 'disabled');
							});
					
					$("#descargarPlantillaXml").click(function() {
						if (validarFactura()) {
							var comprobante = new Object();

							comprobante.serie = $('#serie').val();
							comprobante.folio = $('#folio').val();
							comprobante.fecha = $('#fecha').val();
							comprobante.tipoComprobante = $('#btnTipoComprobante option:selected').val();
							comprobante.lugarExpedicion = $('#lugarExpedicion').val();
							comprobante.regimenFiscal = $('#regimen option:selected').val();
							comprobante.receptorNombre = $('#nombreReceptor').val();
							comprobante.receptorRfc = $('#rfc').val();
							comprobante.receptorEmail = $('#email').val();
							comprobante.receptorUsoCfdi = $('#usoCFDI option:selected').val();
							comprobante.receptorResidenciaFiscal = $('#residenciaFiscal option:selected').val();
							comprobante.receptorNumRegIdTrib = $('#numRegIdTrib').val();
							
							comprobante.emisorRfc = $('#emisorRfc').val();
							comprobante.formaPago = $('#formaPago option:selected').val();
							comprobante.condicionespago = $('#condicionesDePago').val();
							comprobante.moneda = $('#moneda option:selected').val();
							comprobante.tipoCambio = $('#tipoCambio').val();
							comprobante.metodoPago = $('#metodoPago option:selected').val();
							comprobante.confirmacion = $('#confirmacion').val();
							
							var conceptosList = new Array();
							
							mapConceptos.forEach(function(valor, indice, array) {
								var concepto = new Object();
								concepto.claveProdServ = valor.claveProdServ;
								concepto.noIdentificacion = valor.clave;
								concepto.cantidad = valor.cantidad;
								concepto.claveUnidad = valor.claveUnidad;
								concepto.unidad = valor.unidad;
								
								if (valor.cuentaPredial === undefined){}
								else{
									concepto.cuentaPredial = new Object();
									concepto.cuentaPredial.numero = valor.cuentaPredial.numero;
								}
								
								concepto.valorUnitario = valor.valorUnitario;
								concepto.descuento = valor.descuento;
								
								concepto.descripcion = valor.descripcion;
								concepto.importe = valor.importe;
//								concepto.ieps = valor.ieps;
//								concepto.iva = valor.iva;
//								concepto.ivaRetenido = valor.ivaRetenido;
								
								var impuestos = new Object();

								if (valor.impuestos === undefined || valor.impuestos.traslados === undefined || valor.impuestos.traslados.traslado === undefined) {
								} else
									impuestos.traslados = valor.impuestos.traslados.traslado;

								if (valor.impuestos === undefined || valor.impuestos.retenciones === undefined || valor.impuestos.retenciones.retencion === undefined) {
								} else
									impuestos.retenciones = valor.impuestos.retenciones.retencion;
								concepto.impuestos = impuestos;

								// Extraer Concepto>partes
								if (valor.parte === undefined || valor.parte == null) {}
								else {
									var partesList = new Array();
									valor.parte.forEach(function(valorParte, indexParte, array) {
										partesList.push(valorParte);
									});
									concepto.partes = partesList;
								}
								//Extraer informacion aduanera.
								if (valor.informacionAduanera === undefined || valor.informacionAduanera == null) {}
								else {
									var infoAduaneraList = new Array();
									valor.informacionAduanera.forEach(function(valorAduana, indexAduana, array) {
										infoAduaneraList.push(valorAduana);
									});
									concepto.informacionAduanera = infoAduaneraList;
								}
								conceptosList.push(concepto);
							});

							comprobante.conceptos = conceptosList;
							
							comprobante.tipoRelacion = $('#tipoRelacion').val();
							comprobante.cfdisRelacionados = cfdiRelacionadoArr;
							comprobante.observaciones = $('#observaciones').val();
							
							var encodedString = window.btoa(JSON.stringify(comprobante));
							
							$.ajax({
								async:false,
							    type: "POST",
							    contentType: "text/plain;charset=ISO-8859-1",
							    url: "/CFDI33/comprobante/descargarplantilla/",
							    data: encodedString,
							    success: function (data){
							    	var decodedString = decodeURIComponent(escape(window.atob( data )));
							    	
							    	var filename = comprobante.emisorRfc + " " + comprobante.receptorRfc + ".xml";
									var type = "text/plain;charset=UTF8";
									var a = document.createElement("a"), file = new Blob([ decodedString ], {type : type});
									if (window.navigator.msSaveOrOpenBlob)
										IE10 + window.navigator.msSaveOrOpenBlob(file, filename);
									else {
										var url = URL.createObjectURL(file);
										a.href = url;
										a.download = filename;
										document.body.appendChild(a);
										a.click();
										setTimeout( function() {
													document.body.removeChild(a);
													window.URL.revokeObjectURL(url);
												}, 0);
									}
									
							    },
							    error: function (xhr, ajaxOptions, thrownError){ 
							    	console.log("ERROR");
							    	alert(xhr.status);
							        alert(thrownError);
							    }
							});
						 }
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

          $('select[name=estado]').click(function() {
						validaEstado();
					});

          $('select[name=pais]').click(function() {
						validaPais();
					});
    
          $('select[name=paisDestinatarioComercioExt]').click(function() {
						validaPaisDestinatarioCCE();
					});

          $('select[name=paisReceptorComercioExt]').click(function() {
						validaPaisReceptorCCE();
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
								url: '/CFDI33/rest/cliente/listarRFC/' + term,
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
										url : '/CFDI33/rest/cliente/find/' + ui.item.id,
										async : false
									});
									cliente = $.parseJSON(response.responseText);
									$("#nombreReceptor").val(cliente.razonSocial);
									$("#rfc").val(cliente.rfc);
									$("#email").val(cliente.email);
                  $("#residenciaFiscal").val(cliente.residenciaFiscal);
                  $("#usoCFDI").val(cliente.usoCFDI);
                  $("#numRegIdTrib").val(cliente.numRegIdTrib);    
								}
							});
					$('#nombreReceptor').change(function() {
						if ($('#nombreReceptor').val().indexOf('<->') > 0) {
							$('#nombreReceptor').val($('#nombreReceptor').val().substring(0, $('#nombreReceptor').val().indexOf('<->')).trim());
						}
					});
					
					$('#nombreReceptor').autocomplete({
						source: function( request, response ) {
							var term = request.term;
							$.ajax({
								url: '/CFDI33/rest/cliente/listar/' + term,
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
								url : '/CFDI33/rest/cliente/find/' + ui.item.id,
								async : false
							});
							cliente = $.parseJSON(response.responseText);
							$("#rfc").val(cliente.rfc);
							$("#email").val(cliente.email);
							$("#residenciaFiscal").val(cliente.residenciaFiscal);
							$('#nombreReceptor').val(cliente.razonSocial);
              $("#usoCFDI").val(cliente.usoCFDI);
              $("#numRegIdTrib").val(cliente.numRegIdTrib);    
						}
					});

					$('#clave')
							.autocomplete(
									{
										source : function(request, response) {
										var term = request.term;
											$.ajax({
														url : '/CFDI33/rest/productoServicio/findByClave/'
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
											url : '/CFDI33/rest/productoServicio/find/'
													+  ui.item.id,
											async : false
										});
										productoServicio = $
												.parseJSON(response.responseText);

										$("#valorUnitario").val(productoServicio.precioUnitario);
										$("#claveProdServ").val(productoServicio.claveProdServ);
                    $("#claveUnidad").val(productoServicio.claveUnidad);
										$("#descripcion").val(productoServicio.nombre);
       							$("#moneda").val(productoServicio.codigoMoneda);
       							$("#unidad").val(productoServicio.unidad);
                    if ($("#cantidad").val() == "") $("#cantidad").val("1");
                    
                    $('#baseTrasladoConcepto').val($("#valorUnitario").val());
                    importeTRConcepto('baseTrasladoConcepto', 'tasaCuotaTrasladoConceptoFijo', 'importeTrasladoConcepto');


										//$("#iva").val(productoServicio.tasaIva);
									},
									open: function() {
										$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
									},
									close: function() {
										$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
									}
								});
					
					
					$('#descripcion').autocomplete({
						source: function( request, response ) {
							var term = request.term;
							$.ajax({
								url: '/CFDI33/rest/productoServicio/listar/' + term,
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
								url : '/CFDI33/rest/productoServicio/find/'
										+  ui.item.id,
								async : false
							});
							productoServicio = $
									.parseJSON(response.responseText);

							$("#valorUnitario").val(productoServicio.precioUnitario);
							$("#clave").val(productoServicio.clave);
              $("#claveProdServ").val(productoServicio.claveProdServ);
              $("#claveUnidad").val(productoServicio.claveUnidad);
 							$("#unidad").val(productoServicio.unidad);
 							$("#moneda").val(productoServicio.codigoMoneda);
              if ($("#cantidad").val() == "") $("#cantidad").val("1");

              $('#baseTrasladoConcepto').val($("#valorUnitario").val());
                    
              $('#importeTrasladoConcepto').val(eval($("#baseTrasladoConcepto").val())*eval($("#tasaCuotaTrasladoConceptoFijo").val()));  
							//$("#iva").val(productoServicio.tasaIva);
							
						},
						open: function() {
							$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
						},
						close: function() {
							$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
						}
					});
				if($("#claveProdServParte").length != 0){
					$("#claveProdServParte").autocomplete({
				        minLength:3,
				        source:function(request, response) {
				            $.getJSON("/CFDI33/rest/catalogoClaveProductoServicio/buscar/" + $("#claveProdServParte").val(), { }, 
				                      response);
				          },
				        focus:function(event, ui){
					        $("#claveProdServParte").val(ui.item.clave);
					        return false;
				        },
				        select:function(event, ui){
					        $("#claveProdServParte").val(ui.item.clave);
					        $("#conceptoParte").val(ui.item.label);
					        $("#cantidadParte").focus();
					        return false;
				        }
				    });
				    $("#claveProdServParte").autocomplete('option','appendTo',"#formAgregarConcepto");
				}

			    if($('#conceptoParte').length != 0){
					$('#conceptoParte').autocomplete({
						source: function( request, response ) {
							var term = request.term;
							$.ajax({
								url: '/CFDI33/rest/productoServicio/listar/' + term,
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
								url : '/CFDI33/rest/productoServicio/find/'
										+  ui.item.id,
								async : false
							});
							productoServicio = $
									.parseJSON(response.responseText);

							$("#valorUnitarioParte").val(productoServicio.precioUnitario);
							$("#claveProdServParte").val(productoServicio.clave);
							// $("#claveUnidad").val(productoServicio.claveUnidad);
							$("#unidadParte").val(productoServicio.unidad);
							if ($("#cantidadParte").val() == "") $("#cantidadParte").val("1");
						},
						open: function() {
							$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
						},
						close: function() {
							$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
						}
					});
			    }
          $('#valorUnitario').change(
            function() {
            	if($("#baseTrasladoConcepto").val() != "")
            		$("#baseTrasladoConcepto").trigger('focus');
            	if($("#baseRetencionConcepto").val() != "")
            		$("#baseRetencionConcepto").trigger('focus');
              // $('#baseTrasladoConcepto').val(getBaseConcepto(numeroDecimales));
              // $('#importeTrasladoConcepto').val(eval($("#baseTrasladoConcepto").val())*eval($("#tasaCuotaTrasladoConceptoFijo").val()));
            });

          $('#tipoFactorTrasladoConcepto').change(
            function() {
              if ($('#tipoFactorTrasladoConcepto').val() == "Exento") {
                  $('#tasaCuotaTrasladoConceptoFijo').html("<option value=''></option>");  
                }
                else{
                  $('#tasaCuotaTrasladoConceptoFijo').html("<option value='0.000000'>0.000000</option><option value='0.080000'>0.080000</option><option value='0.160000'>0.160000</option>");  
                }
            });

          $('#impuestoTrasladoConcepto').change(
            function() {
              if (($('#impuestoTrasladoConcepto').val() == "003")&&($('#tipoFactorTrasladoConcepto').val() == "Cuota")) {
                $('.divTasaCuotaTrasladoConceptoRango').show(0);
                $('.divTasaCuotaTrasladoConceptoFijo').hide(0);
              }
              else{
                $('.divTasaCuotaTrasladoConceptoRango').hide(0);
                $('.divTasaCuotaTrasladoConceptoFijo').show(0);
              }

              if ($('#impuestoTrasladoConcepto').val() == "001") {
       				  $('#tipoFactorTrasladoConcepto').html("<option value='Tasa'>Tasa</option>");
       				  $('#tipoFactorTrasladoConcepto').html("<option value='Exento'>Exento</option>");

              }
              if ($('#impuestoTrasladoConcepto').val() == "002") {
                $('#tipoFactorTrasladoConcepto').html("<option value='Tasa'>Tasa</option><option value='Exento'>Exento</option>");
                if ($('#tipoFactorTrasladoConcepto').val() == "Exento") {
                  $('#tasaCuotaTrasladoConceptoFijo').html("<option value=''></option>");  
                }
                else{
                  $('#tasaCuotaTrasladoConceptoFijo').html("<option value='0.000000'>0.000000</option><option value='0.080000'>0.080000</option><option value='0.160000'>0.160000</option>");  
                }
      				  
              }
              if ($('#impuestoTrasladoConcepto').val() == "003") {
       				  $('#tipoFactorTrasladoConcepto').html("<option value='Tasa'>Tasa</option><option value='Cuota'>Cuota</option><option value='Exento'>Exento</option>");

       				  $('#tasaCuotaTrasladoConceptoFijo').html("<option value='0.265000'>0.265000</option><option value='0.300000'>0.300000</option><option value='0.530000'>0.530000</option><option value='0.500000'>0.500000</option><option value='1.600000'>1.600000</option><option value='0.304000'>0.304000</option><option value='0.250000'>0.250000</option><option value='0.090000'>0.090000</option><option value='0.080000'>0.080000</option><option value='0.070000'>0.070000</option><option value='0.060000'>0.060000</option><option value='0.030000'>0.030000</option><option value='0.000000'>0.000000</option>");
              }

              if (($('#impuestoTrasladoConcepto').val() == "002")&&($('#tipoFactorTrasladoConcepto').val() == "Tasa")) {
              	importeTRConcepto('baseTrasladoConcepto', 'tasaCuotaTrasladoConceptoFijo', 'importeTrasladoConcepto');
              } else if (($('#impuestoTrasladoConcepto').val() == "003")&&($('#tipoFactorTrasladoConcepto').val() == "Tasa")) {
              	importeTRConcepto('baseTrasladoConcepto', 'tasaCuotaTrasladoConceptoFijo', 'importeTrasladoConcepto');
              } else {
              	importeTRConcepto('baseTrasladoConcepto', 'tasaCuotaTrasladoConceptoRango', 'importeTrasladoConcepto');
              }

            });


          $('#tipoFactorTrasladoConcepto').change(
            function() {
              if (($('#impuestoTrasladoConcepto').val() == "003")&&($('#tipoFactorTrasladoConcepto').val() == "Cuota")) {
                $('.divTasaCuotaTrasladoConceptoRango').show(0);
                $('.divTasaCuotaTrasladoConceptoFijo').hide(0);

              }
              else{
                $('.divTasaCuotaTrasladoConceptoRango').hide(0);
                $('.divTasaCuotaTrasladoConceptoFijo').show(0);
              }
            });  

          $('#impuestoRetencionConcepto').change(
            function() {
              if (($('#impuestoRetencionConcepto').val() == "003")&&($('#tipoFactorRetencionConcepto').val() == "Tasa")) {
                $('.divTasaCuotaRetencionConceptoFijo').show(0);          
                $('.divTasaCuotaRetencionConceptoRango').hide(0);
              }
              else{
                $('.divTasaCuotaRetencionConceptoFijo').hide(0);          
                $('.divTasaCuotaRetencionConceptoRango').show(0);
              }


              if ($('#impuestoRetencionConcepto').val() == "001") {
       				  $('#tipoFactorRetencionConcepto').html("<option value='Tasa'>Tasa</option>");
              }
              if ($('#impuestoRetencionConcepto').val() == "002") {
       				  $('#tipoFactorRetencionConcepto').html("<option value='Tasa'>Tasa</option>");
              }
              if ($('#impuestoRetencionConcepto').val() == "003") {
       				  $('#tipoFactorRetencionConcepto').html("<option value='Tasa'>Tasa</option><option value='Cuota'>Cuota</option>");

                $('#tasaCuotaRetencionConceptoFijo').html("<option value='0.265000'>0.265000</option><option value='0.300000'>0.300000</option><option value='0.530000'>0.530000</option><option value='0.500000'>0.500000</option><option value='1.600000'>1.600000</option><option value='0.304000'>0.304000</option><option value='0.250000'>0.250000</option><option value='0.090000'>0.090000</option><option value='0.080000'>0.080000</option><option value='0.070000'>0.070000</option><option value='0.060000'>0.060000</option>");
              }

              if (($('#impuestoRetencionConcepto').val() == "003")&&($('#tipoFactorRetencionConcepto').val() == "Tasa")) {
              	importeTRConcepto('baseRetencionConcepto', 'tasaCuotaRetencionConceptoFijo', 'importeRetencionConcepto');
              } else {
              	importeTRConcepto('baseRetencionConcepto', 'tasaCuotaRetencionConceptoRango', 'importeRetencionConcepto');
              }
            });

          $('#tipoFactorRetencionConcepto').change(
            function() {
              if (($('#impuestoRetencionConcepto').val() == "003")&&($('#tipoFactorRetencionConcepto').val() == "Tasa")) {
                $('.divTasaCuotaRetencionConceptoFijo').show(0);          
                $('.divTasaCuotaRetencionConceptoRango').hide(0);
              }
              else{
                $('.divTasaCuotaRetencionConceptoFijo').hide(0);          
                $('.divTasaCuotaRetencionConceptoRango').show(0);
              }
            });  


            $('#moneda').change(
            function() {
              $('#numeroDecimales').val($("#moneda").find(':selected').attr('numdecimales'));
            }); 

            $('#monedaP').change(
            function() {
              $('#numeroDecimalesP').val($("#monedaP").find(':selected').attr('numdecimalesP'));
            }); 


          $('#paisEmisorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarEstados/'+$(this).val(), {}, function(responseText) {
        				  $('#estadoEmisorComercioExt').html(responseText);
  			        });    
              }
            });

          $('#estadoEmisorComercioExt').change(
            function() {    
              if ($('#paisEmisorComercioExt').val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarMunicipios/'+$(this).val(), {}, function(responseText) {
        				  $('#municipioEmisorComercioExt').html(responseText);
  			        });    
                $.get('/CFDI33/rest/estado/listarLocalidades/'+ $(this).val(), {}, function(responseText) {
        				  $('#localidadEmisorComercioExt').html(responseText);
  			        });    
              }
            }); 

            $('#municipioEmisorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipio/'+$('#estadoEmisorComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalEmisorComercioExt').html(responseText);
  			        });    
              }
            });

            $('#localidadEmisorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipioLocalidad/'+$('#estadoEmisorComercioExt').val()+'/'+$('#municipioEmisorComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalEmisorComercioExt').html(responseText);
  			        });    
              }
            });

             $('#codigoPostalEmisorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarColonias/'+$(this).val(), {}, function(responseText) {
        				  $('#coloniaEmisorComercioExt').html(responseText);
  			        });    
              }
            });

          $('#paisReceptorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarEstados/'+$(this).val(), {}, function(responseText) {
        				  $('#estadoReceptorComercioExt').html(responseText);
  			        });    
              }
            });

          $('#estadoReceptorComercioExt').change(
            function() {    
              if ($('#paisReceptorComercioExt').val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarMunicipios/'+$(this).val(), {}, function(responseText) {
        				  $('#municipioReceptorComercioExt').html(responseText);
  			        });    
                $.get('/CFDI33/rest/estado/listarLocalidades/'+ $(this).val(), {}, function(responseText) {
        				  $('#localidadReceptorComercioExt').html(responseText);
  			        });    
              }
            }); 

            $('#municipioReceptorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipio/'+$('#estadoReceptorComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalReceptorComercioExt').html(responseText);
  			        });    
              }
            });

            $('#localidadReceptorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipioLocalidad/'+$('#estadoReceptorComercioExt').val()+'/'+$('#municipioReceptorComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalReceptorComercioExt').html(responseText);
  			        });    
              }
            });

             $('#codigoPostalReceptorComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarColonias/'+$(this).val(), {}, function(responseText) {
        				  $('#coloniaReceptorComercioExt').html(responseText);
  			        });    
              }
            });

          $('#paisDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarEstados/'+$(this).val(), {}, function(responseText) {
        				  $('#estadoDestinatarioComercioExt').html(responseText);
  			        });    
              }
            });

          $('#estadoDestinatarioComercioExt').change(
            function() {    
              if ($('#paisDestinatarioComercioExt').val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarMunicipios/'+$(this).val(), {}, function(responseText) {
        				  $('#municipioDestinatarioComercioExt').html(responseText);
  			        });    
                $.get('/CFDI33/rest/estado/listarLocalidades/'+ $(this).val(), {}, function(responseText) {
        				  $('#localidadDestinatarioComercioExt').html(responseText);
  			        });    
              }
            }); 

            $('#municipioDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipio/'+$('#estadoDestinatarioComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalDestinatarioComercioExt').html(responseText);
  			        });    
              }
            });

            $('#localidadDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipioLocalidad/'+$('#estadoDestinatarioComercioExt').val()+'/'+$('#municipioDestinatarioComercioExt').val()+'/'+$(this).val(), {}, function(responseText) {
        				  $('#codigoPostalDestinatarioComercioExt').html(responseText);
  			        });    
              }
            });

             $('#codigoPostalDestinatarioComercioExt').change(
            function() {    
              if ($(this).val() != "ZZZ") {
         			  $.get('/CFDI33/rest/estado/listarColonias/'+$(this).val(), {}, function(responseText) {
        				  $('#coloniaDestinatarioComercioExt').html(responseText);
  			        });    
              }
            });

            $("#claveProdServ").autocomplete({
			        minLength:3,
			        source:function(request, response) {
			            $.getJSON("/CFDI33/rest/catalogoClaveProductoServicio/buscar/" + $("#claveProdServ").val(), { }, 
			                      response);
			          },
			        focus:function(event, ui){
				        $("#claveProdServ").val(ui.item.clave);
				        return false;
			        },
			        select:function(event, ui){
				        $("#claveProdServ").val(ui.item.clave);
				        $("#descripcion").val(ui.item.label);
				        // $("#complementoAIncluir").val(ui.item.complementoAIncluir);
				        $("#cantidad").focus();
				        return false;
			        }
		        });
		        $("#claveProdServ").autocomplete('option','appendTo',"#formAgregarConcepto");
					
		function importeTRConcepto(baseInput, tasaInput, importeInput) {
			base = $("#" + baseInput).val();
			tasa = $("#" + tasaInput).val();
			if( !isNaN(base) && !isNaN(tasa) && base != '' && tasa != '') {
				decimalesMoneda = $("#moneda").find(':selected').attr('numdecimales');
				$("#" + importeInput).val( (base * tasa).toFixed(numeroDecimales) );
			} else {
				$("#" + importeInput).val('');
			}
		}
        $('#tasaCuotaTrasladoConceptoFijo').change(function() {
        	importeTRConcepto('baseTrasladoConcepto', 'tasaCuotaTrasladoConceptoFijo', 'importeTrasladoConcepto');
		});

        $('#tasaCuotaTrasladoConceptoRango').change(function() {
        	importeTRConcepto('baseTrasladoConcepto', 'tasaCuotaTrasladoConceptoRango', 'importeTrasladoConcepto');
		});
		$('#tasaCuotaRetencionConceptoFijo').change(function() {
			importeTRConcepto('baseRetencionConcepto', 'tasaCuotaRetencionConceptoFijo', 'importeRetencionConcepto');
		});

        $('#tasaCuotaRetencionConceptoRango').change(function() {
        	importeTRConcepto('baseRetencionConcepto', 'tasaCuotaRetencionConceptoRango', 'importeRetencionConcepto');
		});
		$.validator.addMethod("porcentajeTraslado",function(value){
			impuesto = $("#impuestoTrasladoConcepto").val();
			if(impuesto == '003'){
				return (parseFloat(value) >= 0 && parseFloat(value) <= 43.77) || (value == '');
			}
		}, "Debe proporcionar un decimal entre 0.000000 y 43.77");
		$.validator.addMethod("porcentajeRetencion",function(value){
			impuesto = $("#impuestoRetencionConcepto").val();
      if(impuesto == '001'){
				return (parseFloat(value) >= 0 && parseFloat(value) <= 0.35) || (value == '');
			}
			if(impuesto == '002'){
				return (parseFloat(value) >= 0 && parseFloat(value) <= 0.16) || (value == '');
			}
			if(impuesto == '003'){
				return (parseFloat(value) >= 0 && parseFloat(value) <= 43.77) || (value == '');
			}
		}, "Debe capturar un decimal válido; ISR entre 0 y 0.35, IVA entre 0 y 0.160000, IEPS entre 0 y 43.77");

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
					
					$('#rfcCuentaTerceros').change(function() {
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
					  $('input[name=importeCombustible]').val(redondearValor(eval($('input[name=volumen]').val()*$('input[name=precioUnitario]').val())).toFixed(2));
					});

          $('input[name=precioUnitarioECC12]').change(function() {  
            $('input[name=importeCombustibleECC12]').val(redondearValor(eval($('input[name=precioUnitarioECC12]').val()*$('input[name=cantidadConceptoECC12]').val())).toFixed(2));
					});

					$('#comprobanteForm')
							.validate(
									{
										rules : {
 											moneda : {
												required : true
											},
                      tipoCambio : {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      lugarExpedicion : {
												required : true,
                        valueNotEquals : ""
											},
					tasaCuotaTrasladoConceptoRango:{
						required:false,
						porcentajeTraslado:"",
            numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
					},
					tasaCuotaRetencionConceptoRango:{
						required:false,
						porcentajeRetencion:"",
            numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
					},
                      confirmacion : {
                        regexValor : "^[0-9a-zA-Z]{5}$"
											},
                      regimen : {
												required : true,
 												valueNotEquals : ""
											},  											
                      rfc : {
												required : true,
												minlength : 12,
												maxlength : 13,
												regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
											},
                      usoCFDI : {
												required : true,
 												valueNotEquals : "default"
											},  
                      uuid : {
                        regexValor : "^[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}$"
											},
											email : {
												required : true,
                        regexValor : "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"
											},
											cantidad : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
											valorUnitario : {
												//required : true,
												number : true,
												numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      descuento : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      baseTrasladoConcepto : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      importeTrasladoConcepto : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      baseRetencionConcepto : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      importeRetencionConcepto : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      numeroPedimentoConcepto : {
                        regexValor : "^[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}?$"
											},
                      numeroCuentaPredial : {
                        regexValor : "^[0-9]{1,150}?$"
											},
                        valorUnitarioParte : {
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      numeroPedimentoParte : {
                        regexValor : "^[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}?$"
											},
											iva : {
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
                        numeroDec : "^[0-9]{1,14}(\.[0-9]{3})$"
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
                        numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      importeImpuesto: {
						            required : false,
						            numeroDec : "^[0-9]{1,14}(\.([0-9]{1,2})?)?$"
					            },
                      horaExpOper: {
												required : false,
                        hora : "^(2[0-3]|[01]{1}?[0-9]):([012345]{1}?[0-9]):([012345]{1}?[0-9])$"
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
											    regex : "[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"	
											},
                      cantidadCuentaTerceros: {
                    	  number : true,
						            numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
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
                      cantidadConceptoECC12 : {
						            required : false,
						            numeroDec : "^[0-9]{1,14}\.[0-9]{1,3}$"
					            },
                      precioUnitarioECC12: {
						            required : false,
						            numeroDec : "^[0-9]{1,14}(\.([0-9]{1,3})?)?$"
					            },
                      importeECC12: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,2})?)?$"
					            },
                      tasaoCuotaECC12: {
						            required : false,
						            numeroDec : "^[0-9]+(\.([0-9]{1,6})?)?$"
					            },
                      importeTrasladoECC12: {
						            required : false,
						            numeroDec : "^[0-9]{1,14}(\.([0-9]{1,2})?)?$"
					            },
                      horaConsumoCombustiblesECC12: {
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
												maxlength : 40
											},
                      numExportadorConfiable: {
												required : false,
                        minlength : 1,
												maxlength : 50
											},
                      ObservacionesComercioExt: {
												required : false,
                        minlength : 1,
												maxlength : 300
											},
                      TipoCambioUSD : {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      TotalUSD : {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      curpEmisorComercioExt:{
             						regexCurp : "^[A-Z][AEIOUX][A-Z]{2}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[MH]([ABCMTZ]S|[BCJMOT]C|[CNPST]L|[GNQ]T|[GQS]R|C[MH]|[MY]N|[DH]G|NE|VZ|DF|SP)[BCDFGHJ-NP-TV-Z]{3}[0-9A-Z][0-9]?"
		            			},
                      calleEmisorComercioExt: {
												required : false,
                        minlength : 1,
												maxlength : 100,
                        regexValor : "^[^|]{1,100}$"
											},
                      numeroExteriorEmisorComercioExt: {
												required : false,
                        minlength : 1,
												maxlength : 55
											},
                      numeroInteriorEmisorComercioExt: {
												required : false,
                        minlength : 1,
												maxlength : 55
											},
                      referenciaEmisorComercioExt: {
												required : false,
                        minlength : 1,
												maxlength : 250
											},
                      calleReceptorComercioExt: {
												required : false,
                        minlength : 1,
												maxlength : 100,
                        regexValor : "^[^|]{1,100}$"
											},
                      calleDestinatarioComercioExt: {
												required : false,
                        minlength : 1,
												maxlength : 100,
                        regexValor : "^[^|]{1,100}$"
											},
                      NumRegIdTribPropietarioComercioExt : {
												required : false,
                        minlength : 6,
												maxlength : 40
											},
                      NumRegIdTribDestinatarioComercioExt : {
												required : false,
                        minlength : 6,
												maxlength : 40
											},
                      CantidadAduanaMercanciaComercioExt:{
                        numeroDec : "^[0-9]{1,14}(\.([0-9]{1,3})?)?$"
		            			},
                      ValorUnitarioAduanaMercanciaComercioExt:{
                        numeroDec : "^[0-9]{1,16}(\.([0-9]{1,2})?)?$"
		            			},
                      ValorDolaresMercanciaComercioExt:{
                        numeroDec : "^[0-9]{1,16}(\.([0-9]{1,2})?)?$"
		            			},
                      tipoCambioP : {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      monto : {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      rfcEmisorCtaOrd: {
												minlength : 12,
												maxlength : 13,
												regex : "^XEXX010101000|[A-Z&amp;Ñ]{3}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
											},
                      ctaOrdenante: {
												minlength : 10,
												maxlength : 50,
												regex : "^[A-Z0-9_]{10,50}?"
											},
                      rfcEmisorCtaBen: {
												minlength : 12,
												maxlength : 13,
												regex : "^XEXX010101000|[A-Z&amp;Ñ]{3}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
											},
                      ctaBeneficiario: {
												minlength : 10,
												maxlength : 50,
												regex : "^[A-Z0-9_]{10,50}?"
											},
                      cadPago: {
												minlength : 1,
												maxlength : 8192
											},
                      idDocumento: {
												minlength : 16,
												maxlength : 36,
												regex : "^([a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12})|([0-9]{3}-[0-9]{2}-[0-9]{9})?"
											},
                      tipoCambioDR: {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      numParcialidad: {
												required : false,
                        numero : "^[1-9][0-9]{0,2}?$"
											},
                      impSaldoAnt: {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      impPagado: {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      impSaldoInsoluto: {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      importeRetencionPago: {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      importeTrasladoPago: {
												required : false,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      tasade:{
                        numeroDec : "^[0-9]{1,16}(\.([0-9]{1,2})?)?$"
                      },
                      importe:{
                        numeroDec : "^[0-9]{1,16}(\.([0-9]{1,2})?)?$"
                      },
                      precioVehUsadoRenovacion : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      precioVehUsadoSustitucion : {
												number : true,
                        numeroDec : "^[0-9]{1,18}(\.([0-9]{1,6})?)?$"
											},
                      rfcVehiculoNuvoRenovacion: {
												minlength : 12,
												maxlength : 13,
												regex : "^XEXX010101000|[A-Z&amp;Ñ]{3}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
											},
                      rfcVehiculoNuvoSustitucion: {
												minlength : 12,
												maxlength : 13,
												regex : "^XEXX010101000|[A-Z&amp;Ñ]{3}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?"
											},
                      anioRenovacion: {
						            required : false,
						            anio : "^([0-9]{4})?$"
					            },
                      anioVehiculoNuvoRenovacion: {
						            required : false,
						            anio : "^([0-9]{4})?$"
					            },
                      anioSustitucion: {
						            required : false,
						            anio : "^([0-9]{4})?$"
					            },
                      anioVehiculoNuvoSustitucion: {
						            required : false,
						            anio : "^([0-9]{4})?$"
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


$('input[name=totalIVA]').dblclick(function () {
 $(this).removeAttr('readonly');
})

$('input[name=totalIVA]').change(function () {
	$('input[name=totalIVA]').attr('readonly', 'readonly');
	totalIVA = $('input[name=totalIVA]').val(); 
	$('input[name=totalImpuestosTrasladados]').val(totalIVA + totalIEPS);
})

$('input[name=valorUnitarioParte]').change(function () {
	$('input[name=importeParte]').attr('readonly', 'readonly');
  if ($('input[name=valorUnitarioParte]').val() != ""){
  	$('input[name=importeParte]').val(eval($('input[name=valorUnitarioParte]').val()) * eval($('input[name=cantidadParte]').val()) );
  }
  else{
    $('input[name=importeParte]').val('');
  }
})
	// Visualización de complementos
	$("#tipoDeDecreto").on('change',function(){
	    $("#renovacion").hide();
	    $("#sustitucion").hide();
	    if($(this).val() == '01') {
	        $("#renovacion").show();
	    }
	    if($(this).val() == '02') {
	        $("#sustitucion").show();
	    }
	});
	
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


// Evita que los botones agregar regresen al inicio de la pantalla cada que se da click
$("#invoice a.btn-primary").on('click',function(e){e.preventDefault()});
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
        conceptoConsumoCombustibles.fechaExpOper = $('input[name=fechaExpOper]').val() + "T" + $('input[name=horaExpOper]').val();
        conceptoConsumoCombustibles.determinados = new Object();
        conceptoConsumoCombustibles.determinados.determinado = determinadosConsumoCombustibles;
	      conceptosConsumoCombustibles.push(conceptoConsumoCombustibles);
 	      alert("Concepto Agregado.");
        subtotalCombustibles = redondearValor2(eval(subtotalCombustibles) + eval($('input[name=importeCombustible]').val()));
        totalCombustibles = redondearValor2(eval(totalImportes) + eval(subtotalCombustibles));
        $('input[name=subTotalCombustibles]').val(subtotalCombustibles);
        $('input[name=totalCombustibles]').val(totalCombustibles);
        $('input[name=identificador]').val('');
        $('input[name=fechaExpOper]').val('');
        $('input[name=horaExpOper]').val('');
        $('input[name=rfcEnajCombustible]').val('');
        $('input[name=claveEstacion]').val('');
        $('select[name=tipoCombustibleCC11]').val('');
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

$('#btnConceptoConsumoCombustiblesECC12').click(function() {
  if (validaConceptoConsumoCombustiblesECC12() == true){
		var conceptoConsumoCombustibles = $('.conceptoConsumoCombustiblesECC12').serializeObject();
		conceptosConsumoCombustibles.push(conceptoConsumoCombustibles);
		graficarConceptoConsumoCombustibles();
    $('input[name=identificadorECC12]').val('');
    $('input[name=fechaExpOperECC12]').val('');
    $('input[name=rfcEnajCombustibleECC12]').val('');
    $('input[name=claveEstacionECC12]').val('');
    $('input[name=cantidadConceptoECC12]').val('');
    $('input[name=noIdentificacionConceptoECC12]').val('');
    $('input[name=unidadConceptoECC12]').val('');
    $('input[name=nombreCombustibleECC12]').val('');
    $('input[name=folioOperacionECC12]').val('');
    $('input[name=precioUnitarioECC12]').val('');
    $('input[name=importeCombustibleECC12]').val('');

	}
})

$('#btnTrasladosConsumoCombustibles12').click(function() {
  if (validaTrasladosConsumoCombustibles12() == true){
		var trasladoConsumoCombustibles = $('.trasladoConsumoCombustiblesECC12').serializeObject();
		trasladosConsumoCombustibles.push(trasladoConsumoCombustibles);
		graficarDeterminadosConsumoCombustibles();
    $('input[name=impuestoTrasladoECC12]').val('');
    $('input[name=tasaoCuotaECC12]').val('');
    $('input[name=importeTrasladoECC12]').val('');

	}
})

$('#addConceptoECC12').click(function(){
  if (trasladosConsumoCombustibles.length > 0){
	      var conceptoConsumoCombustibles = $('.conceptoConsumoCombustiblesECC12').serializeObject();
        if ($('input[name=unidadConceptoECC12]').val() == "") {
            conceptoConsumoCombustibles.unidadConceptoECC12 = null;
        }    
        else{
          conceptoConsumoCombustibles.unidadConceptoECC12 = $('input[name=unidadConceptoECC12]').val();
        }
        conceptoConsumoCombustibles.fechaExpOperECC12 = $('input[name=fechaExpOperECC12]').val() + "T" + $('input[name=horaConsumoCombustiblesECC12]').val();
        conceptoConsumoCombustibles.traslados = new Object();
        conceptoConsumoCombustibles.traslados.traslado = trasladosConsumoCombustibles;
	      conceptosConsumoCombustibles.push(conceptoConsumoCombustibles);
 	      alert("Concepto Agregado.");
        subtotalCombustiblesECC12 = redondearValor2(eval(subtotalCombustiblesECC12) + eval($('input[name=importeCombustibleECC12]').val()));
        totalCombustiblesECC12 = redondearValor2(eval(totalImportesECC12) + eval(subtotalCombustiblesECC12));
        $('input[name=subTotalCombustiblesECC12]').val(subtotalCombustiblesECC12);
        $('input[name=totalCombustiblesECC12]').val(totalCombustiblesECC12);
        $('input[name=identificadorECC12]').val('');
        $('input[name=fechaExpOperECC12]').val('');
        $('input[name=horaConsumoCombustiblesECC12]').val('');
        $('input[name=rfcEnajCombustibleECC12]').val('');
        $('input[name=claveEstacionECC12]').val('');
        $('input[name=cantidadConceptoECC12]').val('');
        $('select[name=noIdentificacionConceptoECC12]').val('');
        $('input[name=unidadConceptoECC12]').val('');
        $('input[name=nombreCombustibleECC12]').val('');
        $('input[name=folioOperacionECC12]').val('');
        $('input[name=precioUnitarioECC12]').val('');
        $('input[name=importeCombustibleECC12]').val('');
        trasladosConsumoCombustibles = new Array();
  }
  else{
    alert("Debe agregar los Impuestos Trasladados antes de agregar el Concepto");
  }
})

$('#addTrasladoECC12').click(function(){
if (($('#btnTipoComprobante').val() == "cr")||($('#btnTipoComprobante').val() == "ct")||($('#btnTipoComprobante').val() == "co")||($('#btnTipoComprobante').val() == "cp")){
  alert("El Tipo de Comprobante debe ser de Ingreso, si se desea usar el Complemento de Estado de Cuenta de Combustibles para Monederos Electrónicos Autorizados por el SAT");
}
else{
  if (validaConceptoConsumoCombustiblesECC12() == true){
    if (validaTrasladosConsumoCombustibles12() == true){
	    var trasladoConsumoCombustibles = $('.trasladoConsumoCombustiblesECC12').serializeObject();
	    trasladosConsumoCombustibles.push(trasladoConsumoCombustibles);
	    alert("Traslado de Impuesto Agregado.");
      totalImportesECC12 = redondearValor2(eval(totalImportesECC12) + eval(trasladoConsumoCombustibles.importeTrasladoECC12));
      $('input[name=impuestoTrasladoECC12]').val('');
      $('input[name=tasaoCuotaECC12]').val('');
      $('input[name=importeTrasladoECC12]').val('');
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

$('#btnPropietario').click(function(){
  if (validaPropietario() == true){
    var propietario = new Object();
    propietario.numRegIdTrib = $('#NumRegIdTribPropietarioComercioExt').val();
    propietario.residenciaFiscal = $('#ResidenciaFiscalPropietarioComercioExt').val();

    propietarios.push(propietario);
    alert("Propietario Agregado.");
    graficarPropietarios();
    $('input[name=NumRegIdTribPropietarioComercioExt]').val('');
    $('select[name=ResidenciaFiscalPropietarioComercioExt]').val('');
  }
})

$('#btnDestinatario').click(function(){
  if (validaDestinatario() == true){
    var destinatario = new Object();
    if ($('#NumRegIdTribDestinatarioComercioExt').val() == "") {
      destinatario.numRegIdTrib = null;
    }    
    else{
      destinatario.numRegIdTrib = $('#NumRegIdTribDestinatarioComercioExt').val();
    }
    if ($('#nombreDestinatarioComercioExt').val() == "") {
      destinatario.nombre = null;
    }    
    else{
      destinatario.nombre = $('#nombreDestinatarioComercioExt').val();
    }
    
    if (domiciliosDestinatario.length > 0){
      destinatario.domicilio = new Array(); 
      destinatario.domicilio = domiciliosDestinatario;
    }
    
    domiciliosDestinatario = new Array(); 
    destinatarios.push(destinatario);
    alert("Destinatario Agregado.");
    graficarDestinatario();
    graficarDomicilioDestinatario();
    $('input[name=NumRegIdTribDestinatarioComercioExt]').val('');
    $('input[name=nombreDestinatarioComercioExt]').val('');
  }
})

$('#btnDomicilioDestinatario').click(function(){
  if (validaDomicilioDestinatario() == true){
    var domicilio = new Object();
    domicilio.calle = $('#calleDestinatarioComercioExt').val();
    if ($('#numeroExteriorDestinatarioComercioExt').val() == "") {
      domicilio.numeroExterior = null;
    }    
    else{
      domicilio.numeroExterior = $('#numeroExteriorDestinatarioComercioExt').val();
    }
    if ($('#numeroInteriorDestinatarioComercioExt').val() == "") {
      domicilio.numeroInterior = null;
    }    
    else{
      domicilio.numeroInterior = $('#numeroInteriorDestinatarioComercioExt').val();
    }
    if (($('select[name=paisDestinatarioComercioExt]').val() !='MEX')&&($('select[name=paisDestinatarioComercioExt]').val() !='CAN')&&($('select[name=paisDestinatarioComercioExt]').val() !='USA')) {
      domicilio.estado = $('#estadoDestinatarioComercioExtAux').val();
      domicilio.localidad = $('#localidadDestinatarioComercioExtAux').val();
      domicilio.municipio = $('#municipioDestinatarioComercioExtAux').val();
      domicilio.codigoPostal = $('#codigoPostalDestinatarioComercioExtAux').val();
    }
    if ($('#paisDestinatarioComercioExt').val() == "MEX"){
      domicilio.estado = $('#estadoDestinatarioComercioExt').val();
      domicilio.localidad = $('#localidadDestinatarioComercioExt').val();
      domicilio.municipio = $('#municipioDestinatarioComercioExt').val();
      domicilio.codigoPostal = $('#codigoPostalDestinatarioComercioExt').val(); 
      domicilio.colonia = $('#coloniaDestinatarioComercioExt').val();
    }
    if (($('#paisDestinatarioComercioExt').val() == "USA")||($('#paisDestinatarioComercioExt').val() == "CAN")){
      domicilio.estado = $('#estadoDestinatarioComercioExt').val();
      domicilio.localidad = $('#localidadDestinatarioComercioExtAux').val();
      domicilio.municipio = $('#municipioDestinatarioComercioExtAux').val();
      domicilio.codigoPostal = $('#codigoPostalDestinatarioComercioExtAux').val(); 
      domicilio.colonia = $('#coloniaDestinatarioComercioExtAux').val();
    }
    else{
      if ($('#coloniaDestinatarioComercioExtAux').val() == ""){
        domicilio.colonia = null;
      }
      else{
        domicilio.colonia = $('#coloniaDestinatarioComercioExtAux').val();
      }
      
    }
    if ($('#referenciaDestinatarioComercioExt').val() == "") {
      domicilio.referencia = null;
    }    
    else{
      domicilio.referencia = $('#referenciaDestinatarioComercioExt').val();
    }
    domicilio.pais = $('#paisDestinatarioComercioExt').val();
    domiciliosDestinatario.push(domicilio);
    alert("Domicilio Agregado.");
    graficarDomicilioDestinatario();
    $('select[name=paisDestinatarioComercioExt]').val('');
    $('select[name=estadoDestinatarioComercioExt]').val('');
    $('input[name=estadoDestinatarioComercioExtAux]').val('');
    $('select[name=municipioDestinatarioComercioExt]').val('');
    $('input[name=municipioDestinatarioComercioExtAux]').val('');
    $('select[name=localidadDestinatarioComercioExt]').val('');
    $('input[name=localidadDestinatarioComercioExtAux]').val('');
    $('select[name=codigoPostalDestinatarioComercioExt]').val('');
    $('input[name=codigoPostalDestinatarioComercioExtAux]').val('');
    $('select[name=coloniaDestinatarioComercioExt]').val('');
    $('input[name=coloniaDestinatarioComercioExtAux]').val('');
    $('input[name=calleDestinatarioComercioExt]').val('');
    $('input[name=numeroExteriorDestinatarioComercioExt]').val('');
    $('input[name=numeroInteriorDestinatarioComercioExt]').val('');
    $('input[name=referenciaDestinatarioComercioExt]').val('');
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
    $('#ValorDolaresMercanciaComercioExt').val(redondearValor($('#CantidadAduanaMercanciaComercioExt').val() * $('#ValorUnitarioAduanaMercanciaComercioExt').val()));      
    mercancia.valorDolares = $('#ValorDolaresMercanciaComercioExt').val();  
    if ($('input[name=ValorDolaresMercanciaComercioExt]').val() != ""){
      $('input[name=TotalUSD]').val(new Number(eval($('input[name=TotalUSD]').val())+eval($('input[name=ValorDolaresMercanciaComercioExt]').val())).toFixed(numeroDecimales));
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
    	cfdiRelacionado.tipoRelacion = $('#tipoRelacion').val();
    	if ($('#btnAgregarUUID').find("i").hasClass("icon-edit")){
    		alert("act");
    		alert("indiceUUIDRelacionado "+indiceUUIDRelacionado);
    		cfdiRelacionadoArr[indiceUUIDRelacionado] = cfdiRelacionado;
        	alert("UUID Actualizado.");
        	$('#btnAgregarUUID').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
    	}
    	else{
    	    cfdiRelacionadoArr.push(cfdiRelacionado);
    	    alert("UUID Agregado.");
    	}
      
      graficarCFDIRelacionado();
      $('input[name=uuid]').val('');
      $('#uuid').focus();
    }
  }
})

$('#btnAgregarTrasladoConcepto').click(function(){
  if (validaTrasladoConcepto() == true){
    var traslado = new Object();
    traslado.base = $('#baseTrasladoConcepto').val();
    traslado.impuesto = $('#impuestoTrasladoConcepto').val();
    traslado.tipoFactor = $('#tipoFactorTrasladoConcepto').val();
    if ( $('#tipoFactorTrasladoConcepto').val() == "Exento"){
      traslado.tasaOCuota = null;
      traslado.importe = null;
    }
    else{
      if ($('.divTasaCuotaTrasladoConceptoRango').is(':hidden')){
        traslado.tasaOCuota = $('#tasaCuotaTrasladoConceptoFijo').val();
      }
      else{
      	traslado.tasaOCuota = parseFloat($('#tasaCuotaTrasladoConceptoRango').val()).toFixed(6);
      }

      if ( $('#importeTrasladoConcepto').val() == ""){
        traslado.importe = null;
      }
      else{
        traslado.importe = $('#importeTrasladoConcepto').val();
      }
    }
    
    if ($('#btnAgregarTrasladoConcepto').find("i").hasClass("icon-edit")){	
       	trasladoConceptoArr[indiceTrasladoEditar] = traslado;
    	alert("Traslado Concepto Actualizado.");
    	$('#btnAgregarTrasladoConcepto').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
	}
    else{
    	trasladoConceptoArr.push(traslado);
        alert("Traslado Concepto Agregado.");
    }
    if ($('#btnAgregarConcepto').find("i").hasClass("icon-edit")){
    	blnTrasladoAgregar = true;
    }
    
    graficarTrasladoConcepto();
    $('input[name=baseTrasladoConcepto]').val('');
    $('select[name=impuestoTrasladoConcepto]').val('');
    $('select[name=tipoFactorTrasladoConcepto]').val('');
    $('input[name=tasaCuotaTrasladoConceptoRango]').val('');
    $('select[name=tasaCuotaTrasladoConceptoFijo]').val('');
    $('input[name=importeTrasladoConcepto]').val('');
    $('.divTasaCuotaTrasladoConceptoRango').hide(0);
    $('.divTasaCuotaTrasladoConceptoFijo').show(0);    

    $('select[name=tasaCuotaTrasladoConceptoFijo]').val('');
    $('#tasaCuotaTrasladoConceptoFijo').html("<option value='0.000000'>0.000000</option><option value='0.080000'>0.080000</option><option value='0.160000'>0.160000</option>");  
  }
})


$('#btnAgregarRetencionConcepto').click(function(){
  if (validaRetencionConcepto() == true){
    var retencion = new Object();
    retencion.base = $('#baseRetencionConcepto').val();
    retencion.impuesto = $('#impuestoRetencionConcepto').val();
    retencion.tipoFactor = $('#tipoFactorRetencionConcepto').val();
    if ($('.divTasaCuotaRetencionConceptoRango').is(':hidden')){
      retencion.tasaOCuota = $('#tasaCuotaRetencionConceptoFijo').val();
    }
    else{
    	retencion.tasaOCuota = parseFloat($('#tasaCuotaRetencionConceptoRango').val()).toFixed(6);
    }
    if ( $('#importeRetencionConcepto').val() == ""){
      retencion.importe = null;
    }
    else{
      retencion.importe = $('#importeRetencionConcepto').val();
    }
    if ($('#btnAgregarRetencionConcepto').find("i").hasClass("icon-edit")){
    	retencionConceptoArr[indiceRetencionEditar] = retencion;
		alert("Retención Concepto Actualizado.");
		$('#btnAgregarRetencionConcepto').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");
    }
    else{
    	retencionConceptoArr.push(retencion);
        alert("Retención Concepto Agregado.");
    }
    if ($('#btnAgregarConcepto').find("i").hasClass("icon-edit")){
    	blnRetencionAgregar = true;
    }
    
    graficarRetencionConcepto();
    $('input[name=baseRetencionConcepto]').val('');
    $('select[name=impuestoRetencionConcepto]').val('');
    $('select[name=tipoFactorRetencionConcepto]').val('');
    $('input[name=tasaCuotaRetencionConceptoRango]').val('');
    $('select[name=tasaCuotaRetencionConceptoFijo]').val('');
    $('input[name=importeRetencionConcepto]').val('');
    $('.divTasaCuotaRetencionConceptoRango').show(0);          
    $('.divTasaCuotaRetencionConceptoFijo').hide(0);  

    $('select[name=tasaCuotaRetencionConceptoFijo]').val('');
    $('#tipoFactorRetencionConcepto').html("<option value='Tasa'>Tasa</option>");  
    $('#tasaCuotaRetencionConceptoFijo').html("");  
  }
})

$('#btnAgregarInformacionAduaneraConcepto').click(function(){
  if (validaInformacionAduaneraConcepto() == true){
    var informacionAduanera = new Object();
    informacionAduanera.numeroPedimento = $('#numeroPedimentoConcepto').val();
        
    if ($('#btnAgregarInformacionAduaneraConcepto').find("i").hasClass("icon-edit")){	
       	informacionAduaneraConceptoArr[indiceInformacionAduaneraConcepto] = informacionAduanera;
    	alert("Información Aduanera Concepto Actualizado.");
    	$('#btnAgregarInformacionAduaneraConcepto').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");    
    }
    else{
    	informacionAduaneraConceptoArr.push(informacionAduanera);
    	alert("Información Aduanera Concepto Agregado.");
    }
       
    graficarInformacionAduaneraConcepto();
    $('input[name=numeroPedimentoConcepto]').val('');
  }
})

$('#btnAgregarParte').click(function(){
  if (validaParte() == true){
	    var parte = new Object();
      parte.claveProdServ = $('#claveProdServParte').val();
      if ($('input[name=claveParte]').val() == "") {
        parte.noIdentificacion = null;
      }    
      else{
        parte.noIdentificacion = $('#claveParte').val();
      }
      parte.cantidad = $('#cantidadParte').val();

      if ($('input[name=unidadParte]').val() == "") {
        parte.unidad = null;
      }    
      else{
        parte.unidad = $('#unidadParte').val();
      }
      parte.descripcion = $('#conceptoParte').val();

      if ($('input[name=valorUnitarioParte]').val() == "") {
        parte.valorUnitario = null;
      }    
      else{
        parte.valorUnitario = $('#valorUnitarioParte').val();
      }
      if ($('input[name=importeParte]').val() == "") {
        parte.importe = null;
      }    
      else{
        parte.importe = $('#importeParte').val();
      }
      parte.informacionAduanera = informacionAduaneraParteArr;

      if ($('#btnAgregarParte').find("i").hasClass("icon-edit")){
       	  partesConcepto[indiceParteConcepto] = parte;
    	  alert("Información de Partes Actualizada.");
    	  $('#btnAgregarParte').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");    
      }else{
    	  partesConcepto.push(parte);
    	  alert("Información de Partes Agregada.");  
      }
	    
      graficarPartesConcepto();
      $('input[name=claveProdServParte]').val('');
      $('input[name=claveParte]').val('');
      $('input[name=cantidadParte]').val('');
      $('input[name=unidadParte]').val('');
      $('input[name=valorUnitarioParte]').val('');
      $('input[name=importeParte]').val('');
      $('#conceptoParte').val('');
  }
})

$('#btnAgregarInformacionAduaneraParte').click(function(){
  if (validaInformacionAduaneraParte() == true){
    var informacionAduanera = new Object();
    informacionAduanera.numeroPedimento = $('#numeroPedimentoParte').val();
    
    if ($('#btnAgregarInformacionAduaneraParte').find("i").hasClass("icon-edit")){	
       	informacionAduaneraParteArr[indiceInformacionAduaneraParte] = informacionAduanera;
    	alert("Información Aduanera de Parte Actualizada.");
    	$('#btnAgregarInformacionAduaneraParte').find("i").toggleClass("icon-edit icon-white icon-plus icon-white");    
    }else{
    	informacionAduaneraParteArr.push(informacionAduanera);
        alert("Información Aduanera de Parte Agregada");
    }
    
    graficarInformacionAduaneraParte();
    $('input[name=numeroPedimentoParte]').val('');
  }
})


$('#addPago').click(function(){
    if (validaPago() == true){
      var pago = new Object();
      pago.fechaPago = $('#fechaPago').val()+'T'+$('#horaPago').val();
      pago.formaDePagoP = $('#formaDePagoP').val();
      pago.monedaP = $('#monedaP').val();

      if ($('#tipoCambioP').val() == undefined || $('#tipoCambioP').val() == ""){
        pago.tipoCambioP = null;    
      }
      else{
        pago.tipoCambioP = $('#tipoCambioP').val();    
      }

      pago.monto = $('#monto').val();  

      if ($('#numOperacion').val() == undefined || $('#numOperacion').val() == ""){
        pago.numOperacion = null;    
      }
      else{
        pago.numOperacion = $('#numOperacion').val();    
      }

      if ($('#rfcEmisorCtaOrd').val() == undefined || $('#rfcEmisorCtaOrd').val() == ""){
        pago.rfcEmisorCtaOrd = null;    
      }
      else{
        pago.rfcEmisorCtaOrd = $('#rfcEmisorCtaOrd').val();    
      }

      if ($('#nomBancoOrdExt').val() == undefined || $('#nomBancoOrdExt').val() == ""){
        pago.nomBancoOrdExt = null;    
      }
      else{
        pago.nomBancoOrdExt = $('#nomBancoOrdExt').val();    
      }

      if ($('#ctaOrdenante').val() == undefined || $('#ctaOrdenante').val() == ""){
        pago.ctaOrdenante = null;    
      }
      else{
        pago.ctaOrdenante = $('#ctaOrdenante').val();    
      }

      if ($('#rfcEmisorCtaBen').val() == undefined || $('#rfcEmisorCtaBen').val() == ""){
        pago.rfcEmisorCtaBen = null;    
      }
      else{
        pago.rfcEmisorCtaBen = $('#rfcEmisorCtaBen').val();    
      }

      if ($('#ctaBeneficiario').val() == undefined || $('#ctaBeneficiario').val() == ""){
        pago.ctaBeneficiario = null;    
      }
      else{
        pago.ctaBeneficiario = $('#ctaBeneficiario').val();    
      }

      if ($('#tipoCadPago').val() == undefined || $('#tipoCadPago').val() == ""){
        pago.tipoCadPago = null;    
      }
      else{
        pago.tipoCadPago = $('#tipoCadPago').val();    
      }

      if ($('#certPago').val() == undefined || $('#certPago').val() == ""){
        pago.certPago = null;    
      }
      else{
        pago.certPago = $('#certPago').val();    
      }

      if ($('#cadPago').val() == undefined || $('#cadPago').val() == ""){
        pago.cadPago = null;    
      }
      else{
        pago.cadPago = $('#cadPago').val();    
      }         

      if ($('#selloPago').val() == undefined || $('#selloPago').val() == ""){
        pago.selloPago = null;    
      }
      else{
        pago.selloPago = $('#selloPago').val();    
      }  

      if (doctosRelacionadosArr.length > 0){
        pago.doctoRelacionado = new Object();
        pago.doctoRelacionado = doctosRelacionadosArr;
      }
      if (trasladoPagoArr.length > 0){
       	var totalImpuestosTrasladadosPagos = 0;
        pago.impuestos = new Object();
        pago.impuestos.traslados = trasladoPagoArr;

        for (var i=0;i<trasladoPagoArr.length;i++){
          totalImpuestosTrasladadosPagos = totalImpuestosTrasladadosPagos + eval(trasladoPagoArr[i].importe);
        }
        pago.impuestos.totalImpuestosTrasladados = totalImpuestosTrasladadosPagos.toFixed(numeroDecimales);
      }
      if (retencionPagoArr.length > 0){
       	var totalImpuestosRetenidosPagos = 0;
        pago.impuestos = new Object();
        pago.impuestos.retenciones = retencionPagoArr;

        for (var i=0;i<retencionPagoArr.length;i++){
          totalImpuestosRetenidosPagos = totalImpuestosRetenidosPagos + eval(retencionPagoArr[i].importe);
        }
        pago.impuestos.totalImpuestosRetenidos = totalImpuestosRetenidosPagos.toFixed(numeroDecimales);
      }
       
      pagosArr.push(pago);
      alert("Pago Agregado.");
      graficarPago();
      $('input[name=fechaPago]').val('');
      $('input[name=horaPago]').val('');
      $('input[name=formaDePagoP]').val('');
      $('input[name=monedaP]').val('');
      $('input[name=tipoCambioP]').val('');
      $('input[name=monto]').val('');
      $('input[name=numOperacion]').val('');
      $('input[name=rfcEmisorCtaOrd]').val('');
      $('input[name=nomBancoOrdExt]').val('');
      $('input[name=ctaOrdenante]').val('');
      $('input[name=rfcEmisorCtaBen]').val('');
      $('input[name=ctaBeneficiario]').val('');
      $('input[name=tipoCadPago]').val('');
      $('input[name=certPago]').val('');
      $('input[name=cadPago]').val('');
      $('input[name=selloPago]').val('');
      doctosRelacionadosArr = new Array();
    }

})

$('#addDoctoRelacionado').click(function(){
    if (validaDoctoRelacionado() == true){
      var doctoRelacionado = new Object();
      doctoRelacionado.idDocumento = $('#idDocumento').val();
      if ($('#seriePagos').val() == undefined || $('#seriePagos').val() == ""){
        doctoRelacionado.serie = null;    
      }
      else{
        doctoRelacionado.serie = $('#seriePagos').val();    
      }
      if ($('#folioPagos').val() == undefined || $('#folioPagos').val() == ""){
        doctoRelacionado.folio = null;    
      }
      else{
        doctoRelacionado.folio = $('#folioPagos').val();    
      }
      doctoRelacionado.monedaDR = $('#monedaDR').val();
      if ($('#tipoCambioDR').val() == undefined || $('#tipoCambioDR').val() == ""){
        doctoRelacionado.tipoCambioDR = null;    
      }
      else{
        doctoRelacionado.tipoCambioDR = $('#tipoCambioDR').val();    
      }
      doctoRelacionado.metodoDePagoDR = $('#metodoDePagoDR').val();
      if ($('#numParcialidad').val() == undefined || $('#numParcialidad').val() == ""){
        doctoRelacionado.numParcialidad = null;    
      }
      else{
        doctoRelacionado.numParcialidad = $('#numParcialidad').val();    
      }
      if ($('#impSaldoAnt').val() == undefined || $('#impSaldoAnt').val() == ""){
        doctoRelacionado.impSaldoAnt = null;    
      }
      else{
        doctoRelacionado.impSaldoAnt = $('#impSaldoAnt').val();    
      }
      if ($('#impPagado').val() == undefined || $('#impPagado').val() == ""){
        doctoRelacionado.impPagado = null;    
      }
      else{
        doctoRelacionado.impPagado = $('#impPagado').val();    
      }
      if ($('input[name=impPagado]').val() != ""){
        $('#numeroDecimalesP').val($("#monedaDR").find(':selected').attr('numdecimales'));
      	$('input[name=impSaldoInsoluto]').val(redondearValor(eval($('input[name=impSaldoAnt]').val()) - eval($('input[name=impPagado]').val())).toFixed(eval($('#numeroDecimalesP').val())));
      }
      else{
        $('input[name=impSaldoInsoluto]').val(redondearValor(eval($('input[name=impSaldoAnt]').val()) - eval($('input[name=monto]').val())).toFixed(eval($('#numeroDecimalesP').val())));
      }
      doctoRelacionado.impSaldoInsoluto = $('#impSaldoInsoluto').val();    

      doctosRelacionadosArr.push(doctoRelacionado);
      alert("Documento Relacionado Agregado.");
      graficarDoctoRelacionado();
      $('input[name=idDocumento]').val('');
      $('input[name=seriePagos]').val('');
      $('input[name=folioPagos]').val('');
      $('input[name=monedaDR]').val('');
      $('input[name=tipoCambioDR]').val('');
      $('input[name=metodoDePagoDR]').val('');
      $('input[name=numParcialidad]').val('');
      $('input[name=impSaldoAnt]').val('');
      $('input[name=impPagado]').val('');
      $('input[name=impSaldoInsoluto]').val('');
    }

})

$('#btnUsadosRenovacion').click(function(){
  if (validaUsadosRenovacion() == true){
    var usado = new Object();
    usado =  $('.VehiculosUsadosRenovacion').serializeObject();

    usadosRenovacion.push(usado);
    alert("Vehículo Agregado.");
    graficarUsadosRenovacion();
    $('input[name=precioVehUsadoRenovacion]').val('');
    $('select[name=tipoVehRenovacion]').val('');
    $('input[name=marcaRenovacion]').val('');
    $('input[name=tipooClaseRenovacion]').val('');
    $('input[name=anioRenovacion]').val('');
    $('input[name=modeloRenovacion]').val('');
    $('input[name=nivRenovacion]').val('');
    $('input[name=numSerieRenovacion]').val('');
    $('input[name=numPlacasRenovacion]').val('');
    $('input[name=numMotorRenovacion]').val('');
    $('input[name=numFolTarjCirRenovacion]').val('');
    $('input[name=numPedImRenovacion]').val('');
    $('input[name=aduanaRenovacion]').val('');
    $('input[name=fechaRegularizacionRenovacion]').val('');
    $('input[name=foliofiscalRenovacion]').val('');
  }
});

/** obtiene la base de los traslados y retenciones
 *  valorUnitario * cantidad
*/
function getBaseConcepto(decimales) {
		cantidad = $("#cantidad").val();
		descuento = document.getElementById("descuento");
		precioUnitario = $("#valorUnitario").val();
		
		
		if(decimales != undefined && decimales > 0 && decimales <= 6){
			
			if(descuento.nextElementSibling != null)
			 {
				var  subtotal = cantidad * precionUnitario;
				var  porcentajeDesc = subtotal * Math.abs(descuento.value) / 100;
				
			    return (subtotal - porcentajeDesc ).toFixed(decimales);
			 }
			else
			 {
				return (cantidad * precioUnitario - Math.abs(descuento.value)).toFixed(decimales);
			 }
		} else {
			if(descuento.nextElementSibling != null)
			 {
				var  subtotal = cantidad * precioUnitario;
				var  porcentajeDesc = subtotal * Math.abs(descuento.value) / 100;
				
			    return (subtotal - porcentajeDesc ).toFixed(6);
			 }
			else
			 {
				return (cantidad * precioUnitario - Math.abs(descuento.value)).toFixed(6);
			 }
		}
		if(decimales != undefined && decimales > 0 && decimales <= 6){
			if(descuento.nextElementSibling != null)
			 {
				var  subtotal = cantidad * precionUnitario;
				var  porcentajeDesc = subtotal * Math.abs(descuento.value) / 100;
				
			    return (subtotal - porcentajeDesc ).toFixed(decimales);
			 }
			else
			 {
				return (cantidad * precioUnitario - Math.abs(descuento.value)).toFixed(6);
			 }
		} else {
			return (cantidad * precioUnitario - Math.abs(descuento.value)).toFixed(6);
		}
}
// Al cambiar la cantidad se disparan los eventos para cambiar los valores base de retencion y de traslados
$("#cantidad").on('change', function(){
	if($('#baseTrasladoConcepto').val() != ""){
		$('#baseTrasladoConcepto').trigger('focus');
		$('#tasaCuotaTrasladoConceptoFijo').trigger('change');
	}
	if($('#baseRetencionConcepto').val() != "") {
		$('#baseRetencionConcepto').trigger('focus');
		$('#tasaCuotaRetencionConceptoRango').trigger('change');
	}
});
var actionTrasladoConcepto = function(){
  if ($('#valorUnitario').val() != ""){
        $('input[name=baseTrasladoConcepto]').val(getBaseConcepto());
        $('#tasaCuotaTrasladoConceptoFijo').trigger('change');
  }
};
$('#baseTrasladoConcepto').on({
	'click' : actionTrasladoConcepto,
	'focus' : actionTrasladoConcepto
});
var actionRetencionConcepto = function(){
  if ($('#valorUnitario').val() != ""){
        $('input[name=baseRetencionConcepto]').val(getBaseConcepto());
        $('#tasaCuotaRetencionConceptoRango').trigger('change');
  }
};
$('#baseRetencionConcepto').on({
	'click' : actionRetencionConcepto,
	'focus' : actionRetencionConcepto
});

$('#addAgregarTrasladoPago').click(function(){
  if (validaTrasladoPago() == true){
    var traslado = new Object();
    traslado.impuesto = $('#impuestoTrasladoPago').val();
    traslado.tipoFactor = $('#tipoFactorTrasladoPago').val();
    traslado.tasaOCuota = $('#tasaCuotaTrasladoPagoFijo').val();
    traslado.importe = $('#importeTrasladoPago').val();
    
         
    trasladoPagoArr.push(traslado);
    alert("Traslado Pago Agregado.");
    graficarTrasladoPago();
    $('input[name=importeTrasladoPago]').val('');

    $('select[name=tasaCuotaTrasladoPagoFijo]').val('');
    $('#tipoFactorTrasladoPago').html("<option value='Tasa'>Tasa</option>");  
    $('#tasaCuotaTrasladoPagoFijo').html("<option value='0.000000'>0.000000</option><option value='0.160000'>0.160000</option>");  
    
  }
})

$('#addAgregarRetencionPago').click(function(){
  if (validaRetencionPago() == true){
    var retencion = new Object();
    retencion.impuesto = $('#impuestoRetencionPago').val();
    retencion.importe = $('#importeRetencionPago').val();
             
    retencionPagoArr.push(retencion);
    alert("Retención Pago Agregado.");
    graficarRetencionPago();
    $('input[name=importeRetencionPago]').val('');

  }
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

function validaNoIdentificacionConceptoVsMercancia(){
  var valido = false;

  for ( var i = 0; i < mapConceptos.length; i++) {
    for ( var j = 0; j < mercancias.length; j++) {
      if (mapConceptos[i].clave == mercancias[j].noIdentificacion){
        valido = true;
        return valido;
      }
    }
  }

  return valido;
}

function validaNoIdentificacionMercanciaConcepto(){
  for ( var i = 0; i < mercancias.length; i++) {  
      var valido = false;
      for ( var j = 0; j < mapConceptos.length; j++) {
        if (mercancias[i].noIdentificacion == mapConceptos[j].clave ){
          valido = true;
          continue;
        }
      }
  }
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

function validaUnidadConcepto(clave){
  var valido = true;
  for ( var i = 0; i < mapConceptos.length; i++) {  
    if (clave == mapConceptos[i].clave){
      if (arrayUnidadAduana.indexOf(mapConceptos[i].unidad) < 0){
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
      if (mapConceptos[i].valorUnitario < 0.0001){
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
  var valorDescuento = 0;
  var valorDolares = 0;
  
  var noIdent = "";
  for ( var i = 0; i < mercancias.length; i++) {  
    if (mercancias[i].fraccionArancelaria == '98010001'){
      noIdent = mercancias[i].noIdentificacion;
      for ( var j = 0; j < mapConceptos.length; j++) {  
        if (mapConceptos[j].noIdentificacion == noIdent){
          valorDescuento = valorDescuento + mercancias[i].descuento;
        }
      }
      valorDolares = valorDolares + mercancias[i].valorDolares;
    }
  }
  if (valorDolares != 0){
    if (valorDescuento < valorDolares){
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


function validaUUID(){
  var re = new RegExp("^[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}?$");
  if (!re.test($('#uuid').val())) {
    alert("El campo UUID no cumple con el patrón [a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}");
    $('#uuid').focus();
		return false;
  }
  else{
  		return true;
  }
}

function validaTrasladoConcepto(){
  if ($('#btnTipoComprobante').val() == "pa"){
 		  alert("Para este Tipo de Comprobante, no se deben registrar Impuestos en los Conceptos");
      return false; 
  }
  else{
    if ( $('#baseTrasladoConcepto').val() == ""){
      alert("Debe proporcionar el campo Base");
      $('#baseTrasladoConcepto').focus();
		  return false;
    }
    if (!$.isNumeric($('#baseTrasladoConcepto').val())) {
      alert("Debe proporcionar un valor numérico para el campo Base");
      $('#baseTrasladoConcepto').focus();
		  return false;
    }
    else{
      if (eval($('#baseTrasladoConcepto').val()) <= 0) {
        alert("La Base del Tralado debe ser mayor a 0");
       	$('#baseTrasladoConcepto').focus();
	      return;
      }
    }
    
    if ($('.divTasaCuotaTrasladoConceptoRango').is(':hidden')){
      if ( $('#tipoFactorTrasladoConcepto').val() != "Exento"){
        if ( $('#tasaCuotaTrasladoConceptoFijo').val() == ""){
          alert("Debe proporcionar el campo Tasa Cuota");
          $('#tasaCuotaTrasladoConceptoFijo').focus();
  	    	return false;
        }
      }
    }
    else{
      if ( $('#tasaCuotaTrasladoConceptoRango').val() == ""){
        alert("Debe proporcionar el campo Tasa Cuota");
        $('#tasaCuotaTrasladoConceptoRango').focus();
	    	return false;
      }
      if (!$.isNumeric($('#tasaCuotaTrasladoConceptoRango').val())) {
         alert("Debe proporcionar un valor numérico para el campo Tasa Cuota");
         $('#tasaCuotaTrasladoConceptoRango').focus();
	    	 return false;
      }
    }
    if ( $('#importeTrasladoConcepto').val() == ""){
      alert("Debe proporcionar el campo Importe");
      $('#importeTrasladoConcepto').focus();
		  return false;
    }
    if (!$.isNumeric($('#importeTrasladoConcepto').val())) {
         alert("Debe proporcionar un valor numérico para el campo Importe");
         $('#importeTrasladoConcepto').focus();
	    	 return false;
    }  
    else{
      return true;
    }
  }
}

function validaRetencionConcepto(){
  if ($('#btnTipoComprobante').val() == "pa"){
    alert("Para este Tipo de Comprobante, no se deben registrar Impuestos en los Conceptos");
		return false;
  }
  if ( $('#baseRetencionConcepto').val() == ""){
    alert("Debe proporcionar el campo Base");
    $('#baseRetencionConcepto').focus();
		return false;
  }
  if (!$.isNumeric($('#baseRetencionConcepto').val())) {
    alert("Debe proporcionar un valor numérico para el campo Base");
    $('#baseRetencionConcepto').focus();
		return false;
  }
  else{
    if (eval($('#baseRetencionConcepto').val()) <= 0) {
      alert("La Base de la Retención debe ser mayor a 0");
     	$('#baseRetencionConcepto').focus();
	    return;
    }
  }
  if ($('.divTasaCuotaRetencionConceptoRango').is(':hidden')){
    if ( $('#tasaCuotaRetencionConceptoFijo').val() == ""){
      alert("Debe proporcionar el campo Tasa Cuota");
      $('#tasaCuotaRetencionConceptoFijo').focus();
	  	return false;
    }
  }
  else{
    if ( $('#tasaCuotaRetencionConceptoRango').val() == ""){
      alert("Debe proporcionar el campo Tasa Cuota");
      $('#tasaCuotaRetencionConceptoRango').focus();
	  	return false;
    }
    if (!$.isNumeric($('#tasaCuotaRetencionConceptoRango').val())) {
       alert("Debe proporcionar un valor numérico para el campo Tasa Cuota");
       $('#tasaCuotaRetencionConceptoRango').focus();
	  	 return false;
    }
    if (eval($('#tasaCuotaRetencionConceptoRango').val()) < 0.0000000 ||eval($('#tasaCuotaRetencionConceptoRango').val()) > 43.77  ){
      alert("El valor del campo Tasa Cuota debe estar dentro del Rango 0.0000000 y 43.77");
      $('#tasaCuotaRetencionConceptoRango').focus();
	  	return false;
    }
  }
  
  if ( $('#importeRetencionConcepto').val() == ""){
    alert("Debe proporcionar el campo Importe");
    $('#importeRetencionConcepto').focus();
		return false;
  }
  if (!$.isNumeric($('#importeRetencionConcepto').val())) {
       alert("Debe proporcionar un valor numérico para el campo Importe");
       $('#importeRetencionConcepto').focus();
	  	 return false;
  } 
  else{
    return true;
  }
}

function validaInformacionAduaneraConcepto(){
  if ($('#btnTipoComprobante').val() == "pa"){
    alert("Para este Tipo de Comprobante el Concepto no debe llevar Información Aduanera");
    $('#numeroPedimentoConcepto').focus();
		return false;
  }
  if ( $('#numeroPedimentoConcepto').val() == ""){
    alert("Debe proporcionar el campo Número Pedimento");
    $('#numeroPedimentoConcepto').focus();
		return false;
  }
  else{
    var re = new RegExp("^[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}?$");
      if (!re.test($('#numeroPedimentoConcepto').val())) {
        alert("El campo Número Pedimento no cumple con el patrón [0-9]{2} [0-9]{2} [0-9]{4} [0-9]{7}");
        $('#numeroPedimentoConcepto').focus();
    		return false;
      }
      else 
       return true;
  }
}

function validaInformacionAduaneraParte(){
  if ($('#btnTipoComprobante').val() == "pa"){
    alert("Para este Tipo de Comprobante el Concepto no debe llevar Partes");
    $('#numeroPedimentoParte').focus();
		return false;
  }
  if ( $('#numeroPedimentoParte').val() == ""){
    alert("Debe proporcionar el campo Número Pedimento");
    $('#numeroPedimentoParte').focus();
		return false;
  }
  else{
    return true;
  }
}

function validaTrasladoPago(){
  if ( $('#importeTrasladoPago').val() == ""){
    alert("Debe proporcionar el campo Importe");
    $('#importeTrasladoPago').focus();
		return false;
  }
  if (!$.isNumeric($('#importeTrasladoPago').val())) {
       alert("Debe proporcionar un valor numérico para el campo Importe");
       $('#importeTrasladoPago').focus();
	  	 return false;
  }  
  if (retr_dec($('#importeTrasladoPago').val()) > eval($('#numeroDecimalesP').val())) {
  	alert("El Importe del Traslado solo puede contener "+ $('#numeroDecimalesP').val() + " decimales de acuerdo a la Moneda seleccionada");
  	$('#importeTrasladoPago').focus();
	  return false;
  }
  if (trasladoPagoArr.length > 0){
    var yaExiste = false;
    for (var i = 0;i<trasladoPagoArr.length;i++){
      if ((trasladoPagoArr[i].impuesto == $('#impuestoTrasladoPago').val())&&(trasladoPagoArr[i].tipoFactor == $('#tipoFactorTrasladoPago').val())&&
        (trasladoPagoArr[i].tasaOCuota == $('#tasaCuotaTrasladoPagoFijo').val())){
          alert("Debe haber sólo un registro con la misma combinación de impuesto, factor y tasa por cada traslado.");
          yaExiste = true;
        	break;
      }
    }
    if (yaExiste)
      return false;
    else
      return true;
  }
  else{
    return true;
  }
}

function validaRetencionPago(){
  if ( $('#importeRetencionPago').val() == ""){
    alert("Debe proporcionar el campo Importe");
    $('#importeRetencionPago').focus();
		return false;
  }
  if (!$.isNumeric($('#importeRetencionPago').val())) {
       alert("Debe proporcionar un valor numérico para el campo Importe");
       $('#importeRetencionPago').focus();
	  	 return false;
  }  
  if (retr_dec($('#importeRetencionPago').val()) > eval($('#numeroDecimalesP').val())) {
  	alert("El Importe de la Retención solo puede contener "+ $('#numeroDecimalesP').val() + " decimales de acuerdo a la Moneda seleccionada");
  	$('#importeRetencionPago').focus();
	  return;
  }
  if (retencionPagoArr.length > 0){
    var yaExiste = false;
    for (var i = 0;i<retencionPagoArr.length;i++){
      if (retencionPagoArr[i].impuesto == $('#impuestoTrasladoPago').val()){
          alert("Debe haber sólo un registro por cada tipo de impuesto retenido.");
          yaExiste = true;
        	break;
      }
    }
    if (yaExiste)
      return false;
    else
      return true;
  }
  else{
    return true;
  }
}

function validaPago(){
  if ( $('#fechaPago').val() == ""){
    alert("Debe indicar la Fecha de Pago en formato aaaa-mm-dd");
    $('#fechaPago').focus();
		return false;
  }
  if ( $('#horaPago').val() == ""){
    alert("Debe indicar la Hora de Pago en formato hh:mm:ss");
    $('#horaPago').focus();
		return false;
  }
  if ( $('#formaDePagoP').val() == ""){
    alert("Debe indicar la Forma de Pago");
    $('#formaDePagoP').focus();
		return false;
  }
  if ( $('#monedaP').val() == ""){
    alert("Debe indicar la Moneda");
    $('#monedaP').focus();
		return false;
  }
  if ( $('#monto').val() == ""){
    alert("Debe indicar el Monto");
    $('#monto').focus();
		return false;
  }
  if (retr_dec($('#monto').val()) > eval($('#numeroDecimalesP').val())) {
  	alert("El Importe del Monto solo puede contener "+ $('#numeroDecimalesP').val() + " decimales de acuerdo a la Moneda seleccionada");
  	$('#monto').focus();
	  return false;
  }
  if (doctosRelacionadosArr.length > 0){
    var decimalesMoneda = $("#moneda").find(':selected').attr('numdecimales');
    var sumaImpPagado = 0;
    for (var i=0;i<doctosRelacionadosArr.length;i++){
      sumaImpPagado = sumaImpPagado + eval(doctosRelacionadosArr[i].impPagado);
    }
    sumaImpPagado = redondearValor(sumaImpPagado);

    if (eval($('#monto').val()) < sumaImpPagado){
      alert("La suma de los valores registrados en el nodo DoctoRelacionado, atributo ImpPagado es mayor que el valor del campo Monto.");
   		$('#monto').focus();
	    return false;
    }
  }
  
  if (($('input[name=monto]').val() > 999999999999999999.999999)&&($('#confirmacion').val() == "")) {
    		alert("El valor del Monto es mayor que el valor máximo aplicable, debe proporcionar el campo Confirmación.");
    		$('#confirmacion').focus();
		    return false;
      }
      if (($('input[name=monto]').val() <= 999999999999999999.999999)&&($('#confirmacion').val() != "")) {
    		alert("No debe proporcionar el campo Confirmación, ya que el campo Monto está dentro del rango válido.");
    		$('#confirmacion').focus();
		    return false;
      }
  if ( $('#formaDePagoP').val() == "99"){
    alert("La Forma de Pago debe ser diferente de 99 - Por definir");
    $('#formaDePagoP').focus();
		return false;
  }
  if ( $('#formaDePagoP').val() == "01"){
    if ( $('#rfcEmisorCtaOrd').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo RFC del Emisor de la cuenta ordenante no se debe proporcionar");
      $('#rfcEmisorCtaOrd').focus();
	  	return false;
    }
    if ( $('#ctaOrdenante').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante no se debe proporcionar");
      $('#ctaOrdenante').focus();
	  	return false;
    }
    if ( $('#rfcEmisorCtaBen').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo RFC del Emisor de la cuenta destino no se debe proporcionar");
      $('#rfcEmisorCtaBen').focus();
	  	return false;
    }
    if ( $('#ctaBeneficiario').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Cuenta Beneficiario no se debe proporcionar");
      $('#ctaBeneficiario').focus();
	  	return false;
    }
    if ( $('#tipoCadPago').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Tipo Cadena Pago no se debe proporcionar");
      $('#tipoCadPago').focus();
	  	return false;
    }
    if ( ($('#certPago').val() != "") || ($('#cadPago').val() != "") || ($('#selloPago').val() != "")){
      alert("Para la Forma de Pago seleccionada, no debe indicar los campos Certificado Pago, Cadena Pago y Sello Pago");
      $('#certPago').focus();
     	return false;
    }
    if ( $('#nomBancoOrdExt').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Nombre del Banco emisor de la cuenta ordenante en caso de extranjero no se debe proporcionar");
      $('#nomBancoOrdExt').focus();
	  	return false;
    }
  }
  if ( $('#formaDePagoP').val() == "02"){
	if ( $('#ctaOrdenante').val() != ""){
		var re = new RegExp("^[0-9]{11}|[0-9]{18}$");
	    if (!re.test($('input[name=ctaOrdenante]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante, no cumple con el patrón [0-9]{11}|[0-9]{18}");
	      $('#ctaOrdenante').focus();
	      return false;
	    }
	}  
	if ( $('#ctaBeneficiario').val() != ""){
		re = new RegExp("^[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}$");
	    if (!re.test($('input[name=ctaBeneficiario]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Beneficiario, no cumple con el patrón [0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}");
	      $('#ctaBeneficiario').focus();
	      return false;
	    }
	}
    if ( $('#tipoCadPago').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Tipo Cadena Pago no se debe proporcionar");
      $('#tipoCadPago').focus();
	  	return false;
    }
    if ( ($('#certPago').val() != "") || ($('#cadPago').val() != "") || ($('#selloPago').val() != "")){
      alert("Para la Forma de Pago seleccionada, no debe indicar los campos Certificado Pago, Cadena Pago y Sello Pago");
      $('#certPago').focus();
     	return false;
    }
    if ( $('#rfcEmisorCtaOrd').val() == "XEXX010101000"){
      if ( $('#nomBancoOrdExt').val() == ""){
        alert("Para la Forma de Pago seleccionada debe proporcionar el Nombre del Banco emisor de la cuenta ordenante en caso de extranjero");
        $('#nomBancoOrdExt').focus();
		    return false;
      }  
    }
  }
  if ( $('#formaDePagoP').val() == "03"){
	if ( $('#ctaOrdenante').val() != ""){
		var re = new RegExp("^[0-9]{10}|[0-9]{16}|[0-9]{18}$");
	    if (!re.test($('input[name=ctaOrdenante]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante, no cumple con el patrón [0-9]{10}|[0-9]{16}|[0-9]{18}");
	      $('#ctaOrdenante').focus();
	      return false;
	    }
	}
	if ( $('#ctaBeneficiario').val() != ""){
		re = new RegExp("^[0-9]{10}|[0-9]{18}$");
	    if (!re.test($('input[name=ctaBeneficiario]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Beneficiario, no cumple con el patrón [0-9]{10}|[0-9]{18}");
	      $('#ctaBeneficiario').focus();
	      return false;
	    }
	}
    if ( $('#rfcEmisorCtaOrd').val() == "XEXX010101000"){
      if ( $('#nomBancoOrdExt').val() == ""){
        alert("Para la Forma de Pago seleccionada debe proporcionar el Nombre del Banco emisor de la cuenta ordenante en caso de extranjero");
        $('#nomBancoOrdExt').focus();
		    return false;
      }  
    }

    if ( $('#tipoCadPago').val() != ""){
      if ( ($('#certPago').val() == "") || ($('#cadPago').val() == "") || ($('#selloPago').val() == "")){
        alert("Al seleccionar el campo Tipo Cadena Pago, debe indicar también los campos Certificado Pago, Cadena Pago y Sello Pago");
        $('#certPago').focus();
       	return false;
      }
    }
  }
  if ( ($('#formaDePagoP').val() == "04") || ($('#formaDePagoP').val() == "28") ){
	if ( $('#ctaOrdenante').val() != ""){
		var re = new RegExp("^[0-9]{16}$");
	    if (!re.test($('input[name=ctaOrdenante]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante, no cumple con el patrón [0-9]{16}");
	      $('#ctaOrdenante').focus();
	      return false;
	    }
	}
	if ( $('#ctaBeneficiario').val() != ""){
		re = new RegExp("^[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}$");
	    if (!re.test($('input[name=ctaBeneficiario]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Beneficiario, no cumple con el patrón [0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}");
	      $('#ctaBeneficiario').focus();
	      return false;
	    }
	}
    
    if ( $('#tipoCadPago').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Tipo Cadena Pago no se debe proporcionar");
      $('#tipoCadPago').focus();
	  	return false;
    }
    if ( ($('#certPago').val() != "") || ($('#cadPago').val() != "") || ($('#selloPago').val() != "")){
      alert("Para la Forma de Pago seleccionada, no debe indicar los campos Certificado Pago, Cadena Pago y Sello Pago");
      $('#certPago').focus();
     	return false;
    }
    if ( $('#rfcEmisorCtaOrd').val() == "XEXX010101000"){
      if ( $('#nomBancoOrdExt').val() == ""){
        alert("Para la Forma de Pago seleccionada debe proporcionar el Nombre del Banco emisor de la cuenta ordenante en caso de extranjero");
        $('#nomBancoOrdExt').focus();
		    return false;
      }  
    }
  }
  if ( $('#formaDePagoP').val() == "05"){
	if ( $('#ctaOrdenante').val() != ""){
		var re = new RegExp("^[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}$");
	    if (!re.test($('input[name=ctaOrdenante]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante, no cumple con el patrón [0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}");
	      $('#ctaOrdenante').focus();
	      return false;
	    }
	}
	if ( $('#ctaBeneficiario').val() != ""){
		re = new RegExp("^[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}$");
	    if (!re.test($('input[name=ctaBeneficiario]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Beneficiario, no cumple con el patrón [0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}");
	      $('#ctaBeneficiario').focus();
	      return false;
	    }
	}
    if ( $('#tipoCadPago').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Tipo Cadena Pago no se debe proporcionar");
      $('#tipoCadPago').focus();
	  	return false;
    }
    if ( ($('#certPago').val() != "") || ($('#cadPago').val() != "") || ($('#selloPago').val() != "")){
      alert("Para la Forma de Pago seleccionada, no debe indicar los campos Certificado Pago, Cadena Pago y Sello Pago");
      $('#certPago').focus();
     	return false;
    }
    if ( $('#nomBancoOrdExt').val() != ""){
      alert("Para la Forma de Pago seleccionada no debe proporcionar el Nombre del Banco emisor de la cuenta ordenante en caso de extranjero");
      $('#nomBancoOrdExt').focus();
      return false;
    }  
  }
  if ( $('#formaDePagoP').val() == "06"){
	if ( $('#ctaOrdenante').val() != ""){
		var re = new RegExp("^[0-9]{10}$");
	    if (!re.test($('input[name=ctaOrdenante]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante, no cumple con el patrón [0-9]{10}");
	      $('#ctaOrdenante').focus();
	      return false;
	    }
	}
    if ( $('#rfcEmisorCtaBen').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo RFC del Emisor Cuenta de Beneficiario no se debe proporcionar");
      $('#rfcEmisorCtaBen').focus();
	  	return false;
    }
    if ( $('#ctaBeneficiario').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Cuenta de Benenficiario no se debe proporcionar");
      $('#ctaBeneficiario').focus();
	  	return false;
    }
    if ( $('#tipoCadPago').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Tipo Cadena Pago no se debe proporcionar");
      $('#tipoCadPago').focus();
	  	return false;
    }
    if ( ($('#certPago').val() != "") || ($('#cadPago').val() != "") || ($('#selloPago').val() != "")){
      alert("Para la Forma de Pago seleccionada, no debe indicar los campos Certificado Pago, Cadena Pago y Sello Pago");
      $('#certPago').focus();
     	return false;
    }
    if ( $('#nomBancoOrdExt').val() != ""){
      alert("Para la Forma de Pago seleccionada no debe proporcionar el Nombre del Banco emisor de la cuenta ordenante en caso de extranjero");
      $('#nomBancoOrdExt').focus();
      return false;
    }  
  }
  if ( ($('#formaDePagoP').val() == "08") || ($('#formaDePagoP').val() == "12") || ($('#formaDePagoP').val() == "13") || 
    ($('#formaDePagoP').val() == "14") || ($('#formaDePagoP').val() == "15") || ($('#formaDePagoP').val() == "17") || 
    ($('#formaDePagoP').val() == "23") || ($('#formaDePagoP').val() == "24") || ($('#formaDePagoP').val() == "25") || 
    ($('#formaDePagoP').val() == "26") || ($('#formaDePagoP').val() == "27") || ($('#formaDePagoP').val() == "30")){
    if ( $('#rfcEmisorCtaOrd').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo RFC del Emisor de la cuenta ordenante no se debe proporcionar");
      $('#rfcEmisorCtaOrd').focus();
	  	return false;
    }
    if ( $('#ctaOrdenante').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante no se debe proporcionar");
      $('#ctaOrdenante').focus();
	  	return false;
    }
    if ( $('#rfcEmisorCtaBen').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo RFC del Emisor Cuenta de Beneficiario no se debe proporcionar");
      $('#rfcEmisorCtaBen').focus();
	  	return false;
    }
    if ( $('#ctaBeneficiario').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Cuenta de Benenficiario no se debe proporcionar");
      $('#ctaBeneficiario').focus();
	  	return false;
    }
    if ( $('#tipoCadPago').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Tipo Cadena Pago no se debe proporcionar");
      $('#tipoCadPago').focus();
	  	return false;
    }
    if ( ($('#certPago').val() != "") || ($('#cadPago').val() != "") || ($('#selloPago').val() != "")){
      alert("Para la Forma de Pago seleccionada, no debe indicar los campos Certificado Pago, Cadena Pago y Sello Pago");
      $('#certPago').focus();
     	return false;
    }
    if ( $('#nomBancoOrdExt').val() != ""){
      alert("Para la Forma de Pago seleccionada no debe proporcionar el Nombre del Banco emisor de la cuenta ordenante en caso de extranjero");
      $('#nomBancoOrdExt').focus();
      return false;
    }  
  }
  if ( $('#formaDePagoP').val() == "29"){
	if ( $('#ctaOrdenante').val() != ""){
		var re = new RegExp("^[0-9]{15,16}$");
	    if (!re.test($('input[name=ctaOrdenante]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Ordenante, no cumple con el patrón [0-9]{15,16}");
	      $('#ctaOrdenante').focus();
	      return false;
	    }
	}
	if ( $('#ctaBeneficiario').val() != ""){
		re = new RegExp("^[0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}$");
	    if (!re.test($('input[name=ctaBeneficiario]').val())) {
	      alert("Para la Forma de Pago seleccionada el campo Cuenta Beneficiario, no cumple con el patrón [0-9]{10,11}|[0-9]{15,16}|[0-9]{18}|[A-Z0-9_]{10,50}");
	      $('#ctaBeneficiario').focus();
	      return false;
	    }
	}
    if ( $('#tipoCadPago').val() != ""){
      alert("Para la Forma de Pago seleccionada el campo Tipo Cadena Pago no se debe proporcionar");
      $('#tipoCadPago').focus();
	  	return false;
    }
    if ( ($('#certPago').val() != "") || ($('#cadPago').val() != "") || ($('#selloPago').val() != "")){
      alert("Para la Forma de Pago seleccionada, no debe indicar los campos Certificado Pago, Cadena Pago y Sello Pago");
      $('#certPago').focus();
     	return false;
    }
    if ( $('#rfcEmisorCtaOrd').val() == "XEXX010101000"){
      if ( $('#nomBancoOrdExt').val() == ""){
        alert("Para la Forma de Pago seleccionada debe proporcionar el Nombre del Banco emisor de la cuenta ordenante en caso de extranjero");
        $('#nomBancoOrdExt').focus();
		    return false;
      }  
    }  
  }
  if ( $('#monedaP').val() == "XXX"){
    alert("El campo moneda no debe contener el valor XXX - Los códigos asignados para las transacciones en que intervenga ninguna moneda");
    $('#monedaP').focus();
   	return false;
  }
  if ( $('#monedaP').val() != "MXN"){
    if ( $('#tipoCambioP').val() == ""){
      alert("Si la moneda es diferente de MXN, debe existir información en el atributo Tipo Cambio");
      $('#tipoCambioP').focus();
     	return false;
    }
  }
  if ( $('#monedaP').val() == "MXN"){
    if ( $('#tipoCambioP').val() != ""){
      alert("Si la moneda es MXN, no debe existir información en el atributo Tipo Cambio");
      $('#tipoCambioP').focus();
     	return false;
    }
  }   
  //if ((trasladoPagoArr.length < 1)&&(retencionPagoArr.length < 1)){
  //  alert("Debe existir al menos un elemento hijo con una retención o traslado.");
  //  $('#importeTrasladoPago').focus();
  // 	return false;
  //}
  //else{
  //  return true;
  //}
  return true;
}


function validaDoctoRelacionado(){
  if ( $('#idDocumento').val() == ""){
    alert("Debe proporcionar el campo Id Documento");
    $('#idDocumento').focus();
		return false;
  }
  if ( $('#monedaDR').val() == ""){
    alert("Debe proporcionar el campo Moneda");
    $('#monedaDR').focus();
		return false;
  }
  if ( $('#monedaDR').val() == "XXX"){
    alert("No debe indicar el valor XXX - Los códigos asignados para las transacciones en que intervenga ninguna moneda, en el campo Moneda");
    $('#monedaDR').focus();
		return false;
  }
  if ( $('#monedaP').val() == $('#monedaDR').val()){
    if ( $('#tipoCambioDR').val() != ""){
      alert("Las Monedas de las Secciones Pago y Documento Relacionado son iguales, no se debe registrar un valor en el atributo TipoCambioDR");
      $('#tipoCambioDR').focus();
		  return false;
    }
  }
  else{
    if ( $('#tipoCambioDR').val() == ""){
      alert("Las Monedas de las Secciones Pago y Documento Relacionado son diferentes, se debe registrar un valor en el atributo TipoCambioDR");
      $('#tipoCambioDR').focus();
		  return false;
    }
    if ( $('#monedaDR').val() == "MXN"){
      if ( $('#tipoCambioDR').val() != "1"){
        alert("Al seleccionar la moneda MXN y ser diferente a Moneda de la sección Pago, el valor del Tipo de Cambio debe ser 1");
        $('#tipoCambioDR').focus();
  		  return false;
      }
    }
  }

$('#numeroDecimalesP').val($("#monedaDR").find(':selected').attr('numdecimales'));
  if (retr_dec($('#impSaldoAnt').val()) > eval($('#numeroDecimalesP').val())) {
  	alert("El Importe del Saldo Anterior solo puede contener "+ $('#numeroDecimalesP').val() + " decimales de acuerdo a la Moneda seleccionada");
  	$('#impSaldoAnt').focus();
	  return false;
  }
  if ( $('#impPagado').val() != ""){
    if (retr_dec($('#impPagado').val()) > eval($('#numeroDecimalesP').val())) {
    	alert("El Importe Pagado solo puede contener "+ $('#numeroDecimalesP').val() + " decimales de acuerdo a la Moneda seleccionada");
    	$('#impPagado').focus();
	    return false;
    }
  }
  if ((doctosRelacionadosArr.length > 1)||((doctosRelacionadosArr.length > 0)&&($('#tipoCambioDR').val() != ""))){
    if ( $('#impPagado').val() == ""){
      alert("Si existe más de un documento relacionado o existe un documento relacionado y el TipoCambioDR tiene un valor es obligatorio el campo Importe Pagado.");
    	$('#impPagado').focus();
	    return false;
    }
  }
  if ( $('#impSaldoInsoluto').val() != ""){
    if (retr_dec($('#impSaldoInsoluto').val()) > eval($('#numeroDecimalesP').val())) {
    	alert("El Importe Saldo Insoluto solo puede contener "+ $('#numeroDecimalesP').val() + " decimales de acuerdo a la Moneda seleccionada");
    	$('#impSaldoInsoluto').focus();
	    return false;
    }
  }
  if ( $('#metodoDePagoDR').val() == ""){
    alert("Debe proporcionar el campo Método De Pago");
    $('#metodoDePagoDR').focus();
		return false;
  }
  if ( $('#metodoDePagoDR').val() == "PPD"){
    if ( ($('#numParcialidad').val() == "") || ($('#impSaldoAnt').val() == "")){
      alert("Si el valor del campo metodoDePagoDR es PPD - Pago en parcialidades se deben registrar los atributos NumParcialidad, ImpSaldoAnt e ImpSaldoInsoluto.");
      $('#numParcialidad').focus();
	  	return false;
    }
  }
  if (($('input[name=impPagado]').val() == "")&&($('input[name=monto]').val() == "")){
      alert("Al no proporcionar el campo Importe Pagado, debe proporcionar el campo Monto de la sección Pago");
      $('#monto').focus();
  		return false;
  }
  else{
    return true;
  }
}

function retr_dec(num) {
  return (num.split('.')[1] || []).length;
}

function validaParte(){
  if ($('#btnTipoComprobante').val() == "pa"){
    alert("Para este Tipo de Comprobante el Concepto no debe llevar Partes");
    $('#claveProdServParte').focus();
		return false;
  }

  if ( $('#claveProdServParte').val() == ""){
    alert("Debe proporcionar la Clave del Producto / Servicio");
    $('#claveProdServParte').focus();
		return false;
  }
  if ( $('#cantidadParte').val() == ""){
    alert("Debe proporcionar la Cantidad");
    $('#cantidadParte').focus();
		return false;
  }
  if ( $('#conceptoParte').val() == ""){
    alert("Debe proporcionar el Concepto");
    $('#conceptoParte').focus();
		return false;
  }
  if ($('#numeroPedimentoParte').val() != ""){
    alert("Si desea agregar la Información Aduanera de la Parte, presione el botón Agregar de dicha sección ");
    $('#numeroPedimentoParte').focus();
		return false;
  }
  else{
    return true;
  }
}

function validaNumExportadorConfiable(paisAux){
 var arrayPaisesUE =["DEU","AUT","BEL","BGR","CYP","HRV","DNK","SVK","SVN","ESP","EST","FIN","FRA","GRC","HUN","IRL","ITA","LVA","LTU","LUX",
"MLT","NLD","POL","PRT","GBR","CZE","ROU","SWE"]; 
  if (arrayPaisesUE.indexOf(paisAux) < 0){
	    return false;
    }
  else{
	    return true;
    }
}

function validaConceptosNoIdentificacionRepetido(){
  var repetidos = false;
  if (mapConceptos.length > 0){
    var aux = "";
    for ( var i = 0; i < mapConceptos.length; i++) {  
        aux = mapConceptos[i].noIdentificacion;
        for ( var j = 0; j < mapConceptos.length; j++) {  
          if ((mapConceptos[j].noIdentificacion == aux)&&(i!=j)){
            repetidos = true;
          }
        }
    }
  }
  else{
    return false;
  }
  return repetidos;
}

function validaMercanciasNoIdentificacionRepetido(){
  var repetidos = false;
  if (mercancias.length > 0){
    var aux = "";
    for ( var i = 0; i < mercancias.length; i++) {  
        aux = mercancias[i].noIdentificacion;
        for ( var j = 0; j < mercancias.length; j++) {  
          if ((mercancias[j].noIdentificacion == aux)&&(i!=j)){
            repetidos = true;
          }
        }
    }
  }
  else{
    return false;
  }
  return repetidos;
}

function validaMercanciaCantidadUnidadValorUnitarioAduana(){
  var existeCantidadUnidadValorUnitarioAduana = false;
  if (mercancias.length > 0){
    var aux = "";
    for ( var i = 0; i < mercancias.length; i++) {  
      if ((mercancias[i].cantidadAduana != "")&&(mercancias[i].unidadAduana != "")&&(mercancias[i].valorUnitarioAduana != "")){
        existeCantidadUnidadValorUnitarioAduana = true;
        break;
      }
    }
    if (existeCantidadUnidadValorUnitarioAduana){
      for ( var i = 0; i < mercancias.length; i++) {
        if ((mercancias[i].cantidadAduana == "")||(mercancias[i].unidadAduana == "")||(mercancias[i].valorUnitarioAduana == "")){
          return false
          break;
        }
      }
      return true;
    }
    else{
      return true;
    }
  }
  else{
    return true;
  }
}

function b64DecodeUnicode(str) {
	return decodeURIComponent(Array.prototype.map.call(atob(str), function(c) {
		return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2)
	}).join(''))
}
function handleFileSelect(evt) {
	var xml = "";
	var files = evt.target.files;

	f = files[0];
	var reader = new FileReader();
	reader.onload = (function(theFile) {
		return function(e) {
			xml = e.target.result;
			var encodedString = window.btoa(xml);
			$.ajax({
				async:false,
				url : '/CFDI33/comprobante/cargarxmlprefactura/',
				type : "post",
				data : encodedString,
				success : function(data) {
					if(data.respuesta.correcto == true){
						$('#serie').val(data.serie);
						$('#folio').val(data.folio);
						$('#fecha').val(data.fecha);
						if(data.lugarExpedicion != ""){
							$('#lugarExpedicion').val(data.lugarExpedicion);
						}
						console.log(data);
						$("#btnTipoComprobante").val(data.tipoComprobante);
						$("#regimen").val(data.regimenFiscal);
						
						$("#nombreReceptor").val(data.receptorNombre);
						$("#rfc").val(data.receptorRfc);
						$("#email").val(data.receptorEmail);
						$("#usoCFDI").val(data.receptorUsoCfdi);
						$("#residenciaFiscal").val(data.receptorResidenciaFiscal);
						$("#numRegIdTrib").val(data.receptorNumRegIdTrib);
						
						$("#formaPago").val(data.formaPago);
						$("#condicionesDePago").val(data.condicionespago);
						$("#moneda").val(data.moneda);
						$("#tipoCambio").val(data.tipoCambio);
						$("#metodoPago").val(data.metodoPago);
						$("#confirmacion").val(data.confirmacion);
						$('#tipoRelacion').val(data.tipoRelacion);
						$('#observaciones').val(data.observaciones);
						
						data.conceptos.forEach(function(itemConcepto, indexConcepto, array) {
							if(itemConcepto.descuento == null || itemConcepto.descuento == "")
								itemConcepto.descuento = "0";
							if(itemConcepto.iva == null || itemConcepto.iva == "")
								itemConcepto.iva = "0";
							if(itemConcepto.noIdentificacion == "")
								itemConcepto.noIdentificacion = null;
							if(itemConcepto.unidad == "")
								itemConcepto.unidad = null;
							
							if(itemConcepto.cantidad == null || itemConcepto.cantidad == "")
								itemConcepto.cantidad = "0";
							
							mapConceptos.push(construirConcepto(itemConcepto));
						});
						
						if (data.cfdisRelacionados == null || data.cfdisRelacionados === undefined){}
						else{
							data.cfdisRelacionados.forEach(function(itemCfdi, indexConcepto, array) {
								cfdiRelacionadoArr.push(itemCfdi);
							});
						}
						trasladoConceptoArr = new Array();
						graficarTrasladoConcepto();
						
						retencionConceptoArr = new Array();
						graficarRetencionConcepto();
						graficarConceptos();
						graficarCFDIRelacionado();
						
						alert("Se ha cargado la prefactura exitosamente");
						$('#rfc').focus();
						$('#email').focus();
						$('#usoCFDI').focus();
						$('#residenciaFiscal').focus();
						$('#nombreReceptor').focus();
					}else{
						alert(data.respuesta.mensaje);
						location.href ="/CFDI33/comprobante/fa";
					}
						
					
				},
				error : function(data) {
					console.log("Error");
					console.log(data);
				}
			});

		};
	})(f);
	reader.readAsText(f);
}

//document.getElementById('files').addEventListener('change', handleFileSelect, false);

function construirConcepto(itemConcepto) {
	console.log("Construir concepto:");
	console.log(itemConcepto);
	trasladoConceptoArr = new Array();
	
	if((itemConcepto.impuestos != undefined && itemConcepto.impuestos != null) && (itemConcepto.impuestos.traslados != undefined && itemConcepto.impuestos.traslados != null)){
		itemConcepto.impuestos.traslados.forEach(function(itemTraslado, indexTraslado, array) {
			var traslado = new Object();
			traslado.base = itemTraslado.base;
			traslado.impuesto = itemTraslado.impuesto;
			traslado.tipoFactor = itemTraslado.tipoFactor;
			
			if(parseFloat(itemTraslado.tasaOCuota) > 0)
				traslado.tasaOCuota = parseFloat(itemTraslado.tasaOCuota).toFixed(6);
			if(parseFloat(itemTraslado.importe) > 0)
				traslado.importe = itemTraslado.importe;
			trasladoConceptoArr.push(traslado);
		});
	}
	
	retencionConceptoArr = new Array();
	if((itemConcepto.impuestos != undefined && itemConcepto.impuestos != null) && (itemConcepto.impuestos.retenciones != undefined && itemConcepto.impuestos.retenciones != null)){
		itemConcepto.impuestos.retenciones.forEach(function(itemRetencion, indexTraslado, array) {
			var retencion = new Object();
			retencion.base = itemRetencion.base;
			retencion.impuesto = itemRetencion.impuesto;
			retencion.tipoFactor = itemRetencion.tipoFactor;
			retencion.tasaOCuota = parseFloat(itemRetencion.tasaOCuota).toFixed(6);
			retencion.importe = itemRetencion.importe;
			retencionConceptoArr.push(retencion);
		});
	}
	var obj = new Object();

	obj.claveProdServ = itemConcepto.claveProdServ;
	obj.clave = itemConcepto.noIdentificacion
	obj.cantidad = itemConcepto.cantidad
	obj.claveUnidad = itemConcepto.claveUnidad
	obj.unidad = itemConcepto.unidad
	obj.descripcion = itemConcepto.descripcion
	obj.valorUnitario = (itemConcepto.valorUnitario != null && itemConcepto.valorUnitario != "") ?   itemConcepto.valorUnitario : "";
	obj.descuento = (itemConcepto.descuento != null && itemConcepto.descuento != "") ?   parseFloat(itemConcepto.descuento) : "";
	obj.ieps = (itemConcepto.ieps != null && itemConcepto.ieps != "") ?   itemConcepto.ieps : "";
	obj.valorUnitario = (itemConcepto.valorUnitario != null && itemConcepto.valorUnitario != "") ? itemConcepto.valorUnitario : "";
	
	var importe = ((obj.valorUnitario * obj.cantidad))
	
	if (trasladoConceptoArr.length > 0) {
		obj.impuestos = new Object();
		obj.impuestos.traslados = new Object();
		obj.impuestos.traslados.traslado = trasladoConceptoArr;
		
		for (var i = 0; i < trasladoConceptoArr.length; i++) {
			if (trasladoConceptoArr[i].impuesto == "002") {
				obj.iva = trasladoConceptoArr[i].importe;
				totalIVA += parseFloat(trasladoConceptoArr[i].importe)
			}
			if (trasladoConceptoArr[i].impuesto == "003") {
				obj.ieps = trasladoConceptoArr[i].importe;
				$('input[name=totalIEPS]').val(
						eval($('input[name=totalIEPS]').val())
								+ parseFloat(trasladoConceptoArr[i].importe));
			}
			trasladoArr.push(trasladoConceptoArr[i]);
		}
		if(Number.isNaN(totalIVA))
			totalIVA = 0;
	}
	
	if (retencionConceptoArr.length > 0) {
		if (obj.impuestos == null)
			obj.impuestos = new Object();
		obj.impuestos.retenciones = new Object();
		obj.impuestos.retenciones.retencion = retencionConceptoArr;
		
		for (var i = 0; i < retencionConceptoArr.length; i++) {
			if (retencionConceptoArr[i].impuesto == "002") {
				obj.ivaRetenido = retencionConceptoArr[i].importe;
				$('input[name=totalIVARetenido]').val(
						eval($('input[name=totalIVARetenido]').val())
								+ parseFloat(retencionConceptoArr[i].importe));
			}
			if (retencionConceptoArr[i].impuesto == "001") {
				obj.isrRetenido = retencionConceptoArr[i].importe;
				$('input[name=totalISRRetenido]').val(
						eval($('input[name=totalISRRetenido]').val())
								+ parseFloat(retencionConceptoArr[i].importe));
			}
			if (retencionConceptoArr[i].impuesto == "003") {
				obj.iepsRetenido = retencionConceptoArr[i].importe;
				$('input[name=totalIEPS]').val(
						eval($('input[name=totalIEPS]').val())
								+ parseFloat(retencionConceptoArr[i].importe));
			}
			retencionArr.push(retencionConceptoArr[i]);
		}
	}
	
	if (informacionAduaneraConceptoArr.length > 0) {
		for (var i = 0; i < informacionAduaneraConceptoArr.length; i++) {
			if (i == 0) {
				obj.informacionAduanera = new Array();
			}
			obj.informacionAduanera.push(informacionAduaneraConceptoArr[i]);
		}
	}
	
	if (itemConcepto.informacionAduanera == null || itemConcepto.informacionAduanera === undefined){}
	else{
		obj.informacionAduanera = itemConcepto.informacionAduanera;
	}
	
	//obj.cuentaPredial = new Object();
	//obj.cuentaPredial.numero =
	
	obj.parte = itemConcepto.partes;
	obj.importe = importe;
	
	console.log("Concepto Construido:");
	console.log(obj);
	if(obj.iva === undefined || obj.iva == 0)
		obj.iva = null;
	return obj;
}

$(document).keypress(
    function(event){
     if ((event.which == '13')&&(event.target.name != 'observaciones')) {
        event.preventDefault();
      }
});