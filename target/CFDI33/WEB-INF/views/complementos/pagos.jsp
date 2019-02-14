<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css" href="/CFDI33/static/resources/css/datepicker.css" />

<script>
$(document).ready(function() {
	$('.divTasaCuotaTrasladoPagoFijo').show(0);
	
	$_Modal.createModal({
		 id:"modal",
		 background:"background-modal",
		 class_title:"content-title",
		 h_title:"CFDI3.3 Pagos",
		 clas_content:"contenido-modal",
		 h_contenido:"tablepagos",
		 class_footer:"footer-modal",
		 class_close:"close-modal"
	});

      
	cancelKeyPipe("#numOperacion");
	cancelKeyPipe("#nomBancoOrdExt");
	cancelKeyPipe("#seriePagos");
	cancelKeyPipe("#folioPagos");
	
	  oTable = $('#listaCfd').dataTable({
	    	    "bSort": true,
				"aoColumns" : [
						null, // tipo
						   null, // serie
						   null, // folio
						   { "bSearchable" : true}, // uuid
						   {"bVisible":false}, // confirmacion
						   null, // cliente
						   null, // subtotal
						   null, // iva
						   null, // total
						  { "sSortDataType": "date-euro-pre" }, //ordar por la columna 12 fecha
						  { "bSearchable" : true, "bSortable":false}, // estatus
						  {"bVisible":false}, // enviado
						  {"bVisible":false}, // opciones
						  {"bVisible":false}, // addenda
						  {"bVisible":false},
						   {"bVisible":false} // fecha  
					   ],
					   "bDestroy": true,
						   "oLanguage": {
								"sProcessing":     "Procesando...",
								"sLengthMenu":     "Mostrar _MENU_ registros",
								"sZeroRecords":    "No se encontraron resultados",
								"sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
								"sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
								"sInfoPostFix":    "",
								"sSearch":         "Buscar:",
								"sUrl":            "",
								"sInfoThousands":  ",",
								"sLoadingRecords": "Cargando...",
								"oPaginate": {
									"sFirst":    "Primero",
									"sLast":     "Ultimo",
									"sNext":     "Siguiente",
									"sPrevious": "Anterior"
								},
								"oAria": {
									"sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
									"sSortDescending": ": Activar para ordenar la columna de manera descendente"
								}
							},
							"aaSorting": [[ 9,"date-euro-pre"]]
	                });
	 $(".filterHeader input").keyup( function () {
	        /* Filter on the column (the index) of this element */
	        oTable.fnFilter( this.value, $(".filterHeader input").index(this) );
	    } );
	$("input.search_init").each(function(key,val){
		$(val).css('width',parseInt($(val).parent().css('width'))-8);
	});
	
	

$('#impuestoTrasladoPago').change(
        function() {
          if ($('#impuestoTrasladoPago').val() == "001") {
   				  $('#tipoFactorTrasladoPago').html("<option value='Tasa'>Tasa</option>");
          }
          if ($('#impuestoTrasladoPago').val() == "002") {
   				  $('#tipoFactorTrasladoPago').html("<option value='Tasa'>Tasa</option>");

            $('#tasaCuotaTrasladoPagoFijo').html("<option value='0.000000'>0.000000</option><option value='0.160000'>0.160000</option>");  
          }
          if ($('#impuestoTrasladoPago').val() == "003") {
   				  $('#tipoFactorTrasladoPago').html("<option value='Tasa'>Tasa</option><option value='Cuota'>Cuota</option>");

   				  $('#tasaCuotaTrasladoPagoFijo').html("<option value='0.265000'>0.265000</option><option value='0.300000'>0.300000</option><option value='0.530000'>0.530000</option><option value='0.500000'>0.500000</option><option value='1.600000'>1.600000</option><option value='0.304000'>0.304000</option>");
          }
        

        });


      $('#tipoFactorTrasladoPago').change(
        function() {
          if (($('#impuestoTrasladoPago').val() == "003")&&($('#tipoFactorTrasladoPago').val() == "Cuota")) {
        	  $('#tasaCuotaTrasladoPagoFijo').html("<option value='0.350000 '>0.350000</option><option value='0.059100'>0.059100</option><option value='3.000000'>3.000000</option><option value='0.298800'>0.298800</option>");

          }
          else{
        	  $('#tasaCuotaTrasladoPagoFijo').html("<option value='0.265000'>0.265000</option><option value='0.300000'>0.300000</option><option value='0.530000'>0.530000</option><option value='0.500000'>0.500000</option><option value='1.600000'>1.600000</option><option value='0.304000'>0.304000</option>");
          }
        }); 
});

/*
 * Accion para tabla modal de relacionados
 */


</script>


<div id="modal">
 <div id="content-modal"></div>
</div>
<div id="tablepagos">
   <div class="listaCfdoptions">
                 <select style="width:200px !important" id="mes" >
                    <option value="">Seleccione Mes</option>
                    <option value="01">Enero</option>
			  	    <option value="02">Febrero</option>
			  	    <option value="03">Marzo</option>
			  	    <option value="04">Abril</option>
			  	    <option value="05">Mayo</option>
			  	    <option value="06">Junio</option>
			  	    <option value="07">Julio</option>
			  	    <option value="08">Agosto</option>
			  	    <option value="09">Septiembre</option>
			  	    <option value="10">Octubre</option>
			  	    <option value="11">Noviembre</option>
			  	    <option value="12">Diciembre</option>
                 </select>
                 <select style="width:200px !important" id="anio">
                   <option value="">Seleccione A&ntilde;o</option>
                   <option value="2017">2017</option>
                   <option value="2018">2018</option>
                   <option value="2019">2019</option>
                 </select>
                 <a onclick="tablaPagos('search',event)" data-bandera="false" id="btnsearchPagos" class="listaCfdoptionsbtn btn btn-primary" href="">Buscar</a>
                 <input type="hidden" id="jsontable" />
            </div>
            
            
            <table data-name="relacionados" cellpadding="0" cellspacing="0" border="0"
			class="table table-striped table-bordered table-hover" id="listaCfd" style="font-size: 12px">
			<thead>
            
				<tr style="background:transparent!" class="filterHeader">
					<th rowspan="1" colspan="1">
						<input type="hidden" name="search_platform" placeholder="Tipo" value="" class="search_init span1" />
					</th>

					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_platform" placeholder="Serie" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_version" placeholder="Folio" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_uuid" placeholder="UUID" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_confirmacion" placeholder="Confirmacion" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_grade" placeholder="Cliente" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_engine" placeholder="Subtotal" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_browser" placeholder="iva" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_platform" placeholder="Total" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_version" placeholder="Creaci&oacute;n" value="" /></th>
					<th rowspan="1" colspan="1"><input style="width:100%!important" class="span1 search_init" type="text" name="search_grade" placeholder="Estatus" value="" /></th>
					<th style="display:none;" rowspan="1" colspan="1"></th>
					<th style="display:none;" rowspan="1" colspan="1"></th>
					<th style="display:none" rowspan="1" colspan="1"></th>
					<th style="display:none;" rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_version" value="" /></th>
					<th style="display:none;"  rowspan="1" colspan="1">Buscar Por <input type="hidden" name="search_platform" placeholder="Generacion" value="" class="search_init"></th>
				</tr>

				<tr>
					<th onclick="tablaPagos('clear',this)">Tipo</th>
					<th onclick="tablaPagos('clear',this)">Serie</th>
					<th onclick="tablaPagos('clear',this)">Folio</th>
					<th onclick="tablaPagos('clear',this)">UUID</th>
					<th onclick="tablaPagos('clear',this)">Confirmaci&oacute;n</th>
					<th onclick="tablaPagos('clear',this)">RFC Cliente</th>
					<th onclick="tablaPagos('clear',this)" class="cantidad">Subtotal</th>
					<th onclick="tablaPagos('clear',this)" class="cantidad">I.V.A.</th>
					<th onclick="tablaPagos('clear',this)" class="cantidad">Total</th>
					<th onclick="tablaPagos('clear',this)">Creaci&oacute;n</th>
					<th onclick="tablaPagos('clear',this)">Estatus</th>
					<th style="display:none">Enviado</th>
					<th style="display:none">Opciones</th>
					<th style="display:none" class="mAddenda">Addenda</th>
					<th style="display:none;">Razon Social</th>
					<th>F</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
</div>


<!-- Fin de la ventana modal -->

<div class="accordion-group">
    <input type="hidden" id="numeroDecimalesP" value="${configuracion.numeroDecimales}">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapsePagos">
            Complemento para Recepción de Pagos
        </a>
    </div>
    <div id="collapsePagos" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <h4 class="blue">Documentos Relacionados</h4>
                 <div class="row-fluid div-padding">
                       <div class="span6">
                        	<div class="span5"><label>Id Documento:</label></div>
                            <div  class="span7">
        	                    <input type="text"  class="doctoRelacionado"  name="idDocumento" id="idDocumento"/>
            	            </div>
                        </div>
                        <div class="span6">
                             <div  class="span7">
        	                    <a class='btn btn-primary' style='left: -14px;position: relative;height: 29px;top: -1px;font-size: 12px;' id="buscarRelacionado" href="javascript:void(0)" >Buscar</a>
            	            </div>
                        </div>
                    </div>
                    <div class="row-fluid div-padding">
                        <div class="span6">
                        	<div class="span5"><label>Serie:</label></div>
                            <div class="span7">
        	                    <input type="text" class="doctoRelacionado" name="seriePagos" id="seriePagos" maxlength="25"/>
            	            </div>
                        </div>
                    </div>
                    <div class="row-fluid div-padding">
                        <div class="span6">
                        	<div class="span5"><label>Folio:</label></div>
                            <div class="span7">
        	                    <input type="text" class="doctoRelacionado" name="folioPagos" id="folioPagos" maxlength="40"/>
            	            </div>
                        </div>
                        <div class="span6">
                        	<div class="span5"><label>Moneda:</label></div>
                            <div class="span7">
        	                    <select id="monedaDR" name="monedaDR" class="doctoRelacionado" value="${configuracion.moneda}">
    								<option value="">Seleccionar</option>
    								<c:forEach items="${listaMonedas}" var="moneda" >
    									<option value="${moneda.clave}" numDecimales="${moneda.decimales}" ${configuracion.moneda eq moneda.clave ? 'selected':''}>${moneda.nombre}</option>
    								</c:forEach>
    							</select>
            	            </div>
                        </div>
                    </div>
                    <div class="row-fluid div-padding">
                        <div class="span6">
                        	<div class="span5"><label>Tipo Cambio:</label></div>
                            <div class="span7">
                            	<div class="input-prepend input-append">
    								<span class="add-on">$ </span>
    								<input type="text" class="doctoRelacionado" name="tipoCambioDR" id="tipoCambioDR"/>
    							</div>
                            </div>
                        </div>
                        <div class="span6">
                        	<div class="span5"><label>Método De Pago:</label></div>
                            <div class="span7">
                            	<select class="doctoRelacionado" name="metodoDePagoDR" id="metodoDePagoDR">
    								<option value="default">Seleccionar</option>
    								<c:forEach items="${metodosPago}" var="metodoPago" >
    									<option value="${metodoPago.clave}" ${configuracion.metodoDePago eq metodoPago.clave ? 'selected':''}>${metodoPago.descripcion}</option>
    								</c:forEach>
    							</select>
            	            </div>
                        </div>
                    </div>
                    <div class="row-fluid div-padding">
                        <div class="span6">
                        	<div class="span5"><label>Num Parcialidad:</label></div>
                            <div class="span7">
        	                    <input type="text" class="doctoRelacionado" name="numParcialidad" id="numParcialidad"/>
            	            </div>
                        </div>
                        <div class="span6">
                        	<div class="span5"><label>Importe Saldo Ant:</label></div>
                            <div class="span7">
        	                    <div class="input-prepend input-append">
    								<span class="add-on">$ </span>
    								<input type="text" class="doctoRelacionado" name="impSaldoAnt" id="impSaldoAnt"/>
    							</div>
            	            </div>
                        </div>
                    </div>
                    <div class="row-fluid div-padding">
                        <div class="span6">
                        	<div class="span5"><label>Importe Pagado:</label></div>
                            <div class="span7">
        	                    <div class="input-prepend input-append">
    								<span class="add-on">$ </span>
    								<input type="text" class="doctoRelacionado" name="impPagado" id="impPagado"/>
    							</div>
            	            </div>
                        </div>
                        <div class="span6 div-padding">
                        	<div class="span5"><label>Imp Saldo Insoluto:</label></div>
                            <div class="span7">
        	                    <div class="input-prepend input-append">
    								<span class="add-on">$ </span>
    								<input type="text" class="doctoRelacionado" name="impSaldoInsoluto" id="impSaldoInsoluto" readonly="readonly"/>
    							</div>
            	            </div>
                        </div>
                    </div>
                    <div class="divRow clear separate right">
                        <a href="#" id="addDoctoRelacionado" class="btn btn-primary">
                            <i class="icon-white icon-plus"></i>
                            Agregar
                        </a>
                    </div>
                    <div id="mDoctoRelacionado" class="overloadedTable clear separate">
    					<table id="tablaDoctoRelacionado" class="table-striped table-hover table-bordered text-center">
    						<thead>
    							<tr>
    								<th class="span1">Id Doc</th>
    								<th class="span1">Serie</th>
    								<th class="span1">Folio</th>
    								<th class="span1">Moneda</th>
    								<th class="span1">T Cambio</th>
    								<th class="span1">M Pago</th>
    								<th class="span1">N Parc</th>
    								<th class="span1">ImpSaldoAnt</th>
    								<th class="span1">ImpPagado</th>
    								<th class="span1">ImpSaldoInsoluto</th>
    								<th class="span1"></th>
    							</tr>
    						</thead>
    						<tbody>
    						</tbody>
    					</table>
    				</div>
       		</div>
            <div class="divRow row-fluid">
                <div class="offset1">
                    <h4 class="blue">Pago</h4>
                    <div class="row-fluid">
                    <div class="span6">
                    	<div class="span5"><label>Fecha Pago:</label></div>
                        <div class="span7">
		                    <div id="mfechaFechaPago" class="input-append">
		                        <input type="text" id="fechaPago" name="fechaPago" readonly="readonly" class="pagos"/>
		                        <span class="add-on">
		                            <i class="icon-calendar"></i>
		                        </span>
		                    </div>
		                </div>
                    </div>
                    <div class="span6">
	                    <div class="span4">
    	                    <input type="text" class="pagos" name="horaPago" id="horaPago" placeholder="12:00:00" />
        	            </div>
                    </div>
                </div>
                <div class="row-fluid">
                	<div class="span6">
	                	<div class="span5"><label>Forma De Pago:</label></div>
                        	<div class="span7">
                        		<select class="pagos" name="formaDePagoP" id="formaDePagoP">
									<option value="default">Seleccionar</option>
									<c:forEach items="${formasPago}" var="formaPago" >
										<option value="${formaPago.clave}" ${configuracion.formaPago eq formaPago.id ? 'selected':''}>${formaPago.descripcion}</option>
									</c:forEach>
								</select>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Moneda:</label></div>
                        <div class="span7">
                        	<select id="monedaP" name="monedaP" class="pagos" value="${configuracion.moneda}">
								<option value="">Seleccionar</option>
								<c:forEach items="${listaMonedas}" var="moneda" >
									<option value="${moneda.clave}" numDecimales="${moneda.decimales}" ${configuracion.moneda eq moneda.clave ? 'selected':''}>${moneda.nombre}</option>
								</c:forEach>
							</select>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                	<div class="span6">
                        <div class="span5"><label>Tipo Cambio:</label></div>
                        <div class="span7">
                        	<div class="input-prepend input-append">
								<span class="add-on">$ </span>
								<input type="text" class="pagos" name="tipoCambioP" id="tipoCambioP"/>
							</div>
                        </div>
                    </div>
                    <div class="span6">
                    	<div class="span5"><label>Monto:</label></div>
                        <div class="span7">
                        	<div class="input-prepend input-append">
								<span class="add-on">$ </span>
								<input type="text" class="pagos" name="monto" id="monto"/>
							</div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                	<div class="span6">
                		<div class="span5"><label>Num Operación:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="numOperacion" id="numOperacion" maxlength="100"/>
                        </div>
                    </div>
                    <div class="span6">
                    	<div class="span5"><label>Rfc Emisor Cuenta Origen:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="rfcEmisorCtaOrd" id="rfcEmisorCtaOrd"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                	<div class="span6">
                		<div class="span5"><label>Nom Banco Ord Extr:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="nomBancoOrdExt" id="nomBancoOrdExt" maxlength="100"/>
                        </div>
                    </div>
                    <div class="span6">
                    	<div class="span5"><label>Cuenta Ordenante:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="ctaOrdenante" id="ctaOrdenante"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                	<div class="span6">
                		<div class="span5"><label>Rfc Emisor Cuenta Destino:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="rfcEmisorCtaBen" id="rfcEmisorCtaBen"/>
                        </div>
                    </div>
                    <div class="span6">
                    	<div class="span5"><label>Cuenta Beneficiario:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="ctaBeneficiario" id="ctaBeneficiario"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                	<div class="span6">
                		<div class="span5"><label>Tipo Cadena Pago:</label></div>
                        <div class="span7">
                        	<select id="tipoCadPago" name="tipoCadPago" class="pagos">
								<option value="">Seleccionar</option>
								<option value="01">SPEI</option>
							</select>
                        </div>
                    </div>
                    <div class="span6">
                    	<div class="span5"><label>Certificado Pago:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="certPago" id="certPago"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                	<div class="span6">
                		<div class="span5"><label>Cadena Pago:</label></div>
                        <div class="span7">
                            <input type="text" class="pagos" name="cadPago" id="cadPago"/>
                        </div>
                    </div>
                    <div class="span6">
                    	<div class="span5"><label>Sello Pago:</label></div>
                        	<div class="span7">
                            	<input type="text" class="pagos" name="selloPago" id="selloPago"/>
                        	</div>
               		</div>
           		</div>
                <div class="divRow separate right clear">
                    <a id="addPago" href="#" class="btn btn-primary">
                        <i class="icon-white icon-plus"></i>
                        Agregar
                    </a>
                </div>
                <div id="mPagos" class="overloadedTable clear separate">
					<table id="tablaPagos" class="table-striped table-hover table-bordered text-center">
						<thead>
							<tr>
								<th class="span1">Fecha</th>
								<th class="span1">F.Pago</th>
								<th class="span1">Moneda</th>
								<th class="span1">T.Cambio</th>
								<th class="span1">Monto</th>
								<th class="span1">NumOper</th>
								<th class="span1">RfcEmisorCtaOrd</th>
								<th class="span1">BancoOrdExt</th>										
								<th class="span1">CtaOrdenante</th>
								<th class="span1">RfcEmisorCtaBen</th>
								<th class="span1">CtaBenef</th>
								<th class="span1">T.Cad.Pago</th>
								<th class="span1">CertPago</th>
								<th class="span1">CadPago</th>
								<th class="span1">SelloPago</th>
								<th class="span1"></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
                </div>
             </div>
            <!--  <div class="divRow row-fluid">
                <div class="offset1">
                    <h4 class="blue">Impuestos</h4>
                    <div class="offset1">
                        <h5 class="blue clear">Traslados:</h5>
                        <div class="divRow row-fluid">
        					<div class="span6">
        						<div class="span5"><label for="impuestoTrasladoPago">Impuesto:</label></div>
        						<div class="span7">
        							<select id="impuestoTrasladoPago" name="impuestoTrasladoPago">
        								<option value="002">IVA</option>
        								<option value="003">IEPS</option>
        							</select>
        						</div>
        					</div>
        					<div class="span6">
        						<div class="span5"><label for="tipoFactorTrasladoPago">Tipo Factor:</label></div>
        						<div class="span7">
        							<select id="tipoFactorTrasladoPago" name="tipoFactorTrasladoPago">
        								<option value="Tasa">Tasa</option>
        							</select>
        						</div>
        					</div>
        				</div>
        				<div class="divRow row-fluid">
        					<div class="span6">						
        						<div class="span5"><label for="tasaCuotaTrasladoPago">Tasa o Cuota:</label></div>
        						<div class="span7">
        							<div class="divTasaCuotaTrasladoPagoFijo">
        								<select id="tasaCuotaTrasladoPagoFijo" name="tasaCuotaTrasladoPagoFijo" >
        									<option value="0.000000" ${configuracion.iva eq 0 ? 'selected':''}>0.000000</option>
        									<option value="0.160000" ${configuracion.iva eq 16 ? 'selected':''}>0.160000</option>
        								</select>
        							</div>
        						</div>
        					</div>
        					<div class="span6">
        						<div class="span5"><label for="importeTrasladoPago">Importe<sup>(1)</sup>:</label></div>
        						<div class="span7">
        							<div class="input-prepend input-append">
        								<span class="add-on">$ </span>
        								<input type="text" id="importeTrasladoPago" name="importeTrasladoPago" class="input" />
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="divRow clear separate right">
        					<a href="#" id="addAgregarTrasladoPago" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
        				</div>
        				<div class="divRow">
        					<label>
        						<sup>(1)El valor de este atributo debe ser mayor o igual que el límite inferior y menor o igual que el límite superior como lo establece el SAT. Consultar el anexo 20 para más información.</sup>
        					</label>
        				</div>
        				<div id="mTrasladosPago" class="overloadedTable clear separate">
        					<table id="tablaTrasladosPago" class="table-striped table-hover table-bordered text-center">
        						<thead>
        							<tr>
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
                    <div class="offset1">
                        <h5 class="blue clear">Retenciones:</h5>
                        <div class="divRow row-fluid">
        					<div class="span6">
        						<div class="span5"><label for="impuestoRetencionPago">Impuesto:</label></div>
        						<div class="span7">
        							<select id="impuestoRetencionPago" name="impuestoRetencionPago" >
        								<option value="002">IVA</option>
        								<option value="003">IEPS</option>
        							</select>
        						</div>
        					</div>
        					<div class="span6">
        						<div class="span5"><label for="importeRetencionPago">Importe <sup>(1)</sup>:</label></div>
        						<div class="span7">
        						<div class="input-prepend input-append">
        							<span class="add-on">$ </span>
        								<input type="text" id="importeRetencionPago" name="importeRetencionPago" />
        							</div>
        						</div>
        					</div>
        				</div>
        				<div class="divRow clear separate right">
        					<a href="#" id="addAgregarRetencionPago" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
        				</div>
        				<div class="divRow">
        					<label>
        						<sup>(1) El valor de este atributo debe ser mayor o igual que el límite inferior y menor o igual que el límite superior como lo establece el SAT. Consultar el anexo 20 para más información.</sup>
        					</label>
        				</div>
        				<div id="mRetencionesPago" class="overloadedTable separate">
        					<table id="tablaRetencionesPago" class="table table-striped table-hover table-bordered text-center">
        						<thead>
        							<tr>
        								<th class="span1">Impuesto</th>
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
            </div>-->
        </div>
    </div>
</div><!-- accord group -->
<script>
$('#buscarRelacionado').on('click', function (e) { 

	$$.showModal();
	$_Modal.viewModal();
    e.preventDefault(); 
    
});
function selectRowcfdiPagos(row,uuid,serie,folio,metodoPago,tipocambio,moneda){
    $$.rowSelect(row,uuid,serie,folio,metodoPago,tipocambio,moneda);   
}
function tablaPagos(state,object){
	
	   if (state == 'search')
	   {
		   $$.search();
	   }
	   else if (state == 'close')
	   {
		   $$.showModal('none');
	   }
	   else if(state == 'clear'){
		   $$.clear();
	   }
	   else if(state == 'buscar'){
		      
		   oTable.fnFilter( object.value, object.id);
	   }
}
</script>