<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/datepicker.css"/>" />
<script	src="<c:url value="/static/resources/js/bootstrap-datepicker.js"/>">
</script>
<script>
function redondearValor(valor) {
    decimals = 2;
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

	$(document).ready(function() {
		<c:if test="${tieneAddendas}" >
			$('.mAddendas').show(0);
		</c:if>

		$("#reporteXLS").click(function(event) {
			window.open("/CFDI33/rest/comprobante/xlsFile/" + $('#anio').val() + "-" +  $('#mes').val());
		});

		$('#zipFile').click(function() {
			window.open("/CFDI33/rest/comprobante/zipFile/" + $('#anio').val() + "-" +  $('#mes').val());
		});

		$('#addendaSelect').change(function() {
	          if($(this).val() != "") {
	        	$('#modalAddenda').modal('hide');
	            window.open("/CFDI33/comprobante/addenda/" + $(this).val() + "/" +$('#uuidAddenda').val());
	          }
	        });
		
		$("#cancelacion").dataTable({});

		var oTable = $('#listaCfd').dataTable({
			"aoColumns" : [
			            null, // tipo
			   			null, // serie
			   			null, // folio
			   			{ "bSearchable" : true}, // uuid
			   			{ "bSearchable" : true}, // confirmacion
			   			null, // cliente
			   			null, // subtotal
			   			null, // iva
			   			null, // total
			   		 	{ "sSortDataType": "date-euro-pre" }, //ordar por la columna 12 fecha
			   			{ "bSearchable" : true, "bSortable":false}, // estatus
			   			{ "bSearchable" : false, "bSortable":false}, // enviado
			   			{ "bSearchable" : false, "bSortable":false}, // opciones
			   			{"bSortable":false}, // addenda
			   			null,
			   			{"bVisible":false} // fecha
			   ],
			   "oLanguage": {
			        "sProcessing":     "Procesando...",
			        "sLengthMenu":     "Mostrar _MENU_ registros",
			        "sZeroRecords":    "No se encontraron resultados",
			        "sEmptyTable":     "Ningun dato disponible en esta tabla",
			        "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
			        "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
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
			"aaSorting": [[ 15, "desc" ]]
		   });


		 $(".filterHeader input").keyup( function () {
		        /* Filter on the column (the index) of this element */
		        oTable.fnFilter( this.value, $(".filterHeader input").index(this) );
		    } );
		$("input.search_init").each(function(key,val){
			$(val).css('width',parseInt($(val).parent().css('width'))-8);
		});

		var datemin =  $('#datepicker_min').datepicker(
				{
				     changeMonth: true,
				     changeYear: true,
				     dateFormat: 'MM yy',

				     onClose: function() {
				        var iMonth = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
				        var iYear = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
				        $(this).datepicker('setDate', new Date(iYear, iMonth, 1));
				     },

				     beforeShow: function() {
				       if ((selDate = $(this).val()).length > 0)
				       {
				          iYear = selDate.substring(selDate.length - 4, selDate.length);
				          iMonth = jQuery.inArray(selDate.substring(0, selDate.length - 5),
				                   $(this).datepicker('option', 'monthNames'));
				          $(this).datepicker('option', 'defaultDate', new Date(iYear, iMonth, 1));
				          $(this).datepicker('setDate', new Date(iYear, iMonth, 1));
				       }
				    }
				  }

		);

		var datemax =  $('#datepicker_max').datepicker( {
		     onRender: function(date) {
		       return date.valueOf() < datemin.date.valueOf() ? 'disabled' : '';
		     }
		  })  .on('changeDate', function(ev){
		     if (ev.date.valueOf() < datemin.date.valueOf()){
		      alert("El rango de fechas es invalido");
		     }
		  }).data('datepicker');

		$("#buscar").click(function() {
			var anio = $('#anio').val();
			var mes = $('#mes').val();
			redirect('/CFDI33/comprobante/filtrar/' + anio + '/' + mes );
		});




	});

	function closeModal(){
		$(".jconfirm").css("display","none");
	}
	
function cancelarCfd(id, fecha, rfcReceptor, total, uuid) {
		if (confirm("øDesea cancelar el folio? ")) {
			modalCargando();
			$.get(context + "/rest/comprobante/cancelarNuevoEsquema/" + id + "/" + fecha + "/" + rfcReceptor + "/" + redondearValor(total).toFixed(2) + "/" + uuid, function(cancelado) {
				if (cancelado == "Cancelado sin aceptaciÛn" || cancelado == "En proceso Cancelable sin aceptaciÛn" || cancelado == "En proceso Cancelable con aceptaciÛn" || cancelado == "Cancelado Plazo vencido" || cancelado == "Cancelado con aceptaciÛn") {
					alert(cancelado);
					redirect('<c:url value="/comprobante/listar/"></c:url>');
				} else {
					if(cancelado.indexOf("No Cancelable") != -1){
						
						var strt = "",array = undefined;
						var imensaje = cancelado.indexOf("m=");
						var iendmensaje = cancelado.indexOf("]",imensaje);
						var m = cancelado.substring(imensaje+3,iendmensaje);
						
						if(cancelado.indexOf("rel") != -1)
						{
						   i = parseInt(cancelado.indexOf("rel")) + 4;
							
                           if(angular.isNumber(i)){

		                      strc  = cancelado.substring(i,cancelado.length);
		                      /*
		                       Eliminando caracteres y elementos de m·s 
		                      */
		                      strc = strc.replace("\\","");
		                      strc = strc.replace("[","");
		                      strc = strc.replace("]","");
		    				  array = strc.split(",");
		    				  array = array.filter(Boolean);
		                   }
						}        
                        if(angular.isArray(array))
                         {

                        	if(array.length > 0 )
     						{
                            
                        	   $.each(array,function(index,value){
     							  ch = value.split("?");
     							  value  = value.replace(/[?]/g,"/");
                                  pdf = value.replace("xml","pdf");
     							  strt = strt + "<tr><td>"+ch[4]+"</td><td>"+ch[5]+"</td><td><a target=\"_self\" download=\""+ch[4]+"\"  title=\"Descargar XML\" href=\""+value+"\"><img src=\"/CFDI33/static/resources/img/cfdi/xml.png\" width=\"24\" height=\"24\"></a></td><td><a href=\""+pdf+"\"><img src=\"/CFDI33/static/resources/img/cfdi/pdf.png\" /></a></td></tr>"; 
     				              
                        	   });
                        	    
                        	    var table = "<div class='table_close'><a onclick=\"closeModal()\" href='#'><img src=\"/CFDI33/static/resources/img/cfdi/cerrar.png\" /></a></div><table id=\"cancelacion\" class=\"table table-striped table-bordered table-hover\" id=\"cancelacion\" style=\"font-size: 12px\">"+
                                "<thead><tr><th id=\"table_th_uuid\">UUID</th>"+
                                "<th id=\"table_th_date\">Fecha</th>"+
                                "<th id=\"table_th_desc\">XML</th>"+
                                "<th id=\"table_th_desc\">PDF</th></tr></thead><tbody id=\"tcbody\">"+strt+"</tbody></table><div class='table_footer'></div>";
                        	    var tcbody = angular.element(document.getElementById("tableCancelados"));
     				           
     				           tcbody.html(table);
     						}
                              

                         }
                        $.alert({
                        	title: 'Cancelacion CFDI 3.3',
                            content: "<span id='title_cancelable'>CFDI UUID:<strong>"+uuid+"</strong> "+m+" por tener XML Relacionados. <br/>Si desea cancelar este comprobante, por favor Cancele primero los cfdis asociados.<br/></span>"+angular.element(document.getElementById("tableCancelados")).html(),
                        });
				    }
					else
				    {
						alert(cancelado);
					}
				}
				$('#divCargando').modal('hide');
			});
		}
	}

	function modalCargando() {
		$('#divCargando').modal({
			 backdrop: "static",
		  keyboard: false
		});
		$('#divCargando').show(0);
	}

</script>
<style>

	td {
		text-align: center;
	}
	td.right{
		text-align: right;
	}
	td.images{
		padding: 4px !important;
	}
	a img {
		cursor: pointer;
		border: none;
	}
	.divCargando {
		width: 250px;
		margin: auto;
		top: 50%;
		left: 50%;
		text-align: center;
	}
	.mAddendas {display:none;}
	#listaCfd th{
		padding: 4px !important;
	}
	.cantidad{
		width: 100px !important;
	}
	div.content{
		max-width: 95% !important;
	}
	div.container{
		max-width: 98% !important;
		width: 98% !important;
	}
	
</style>

<div class="modal hide fade" id="modalAddenda">
  <form action="" target="_blank">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
      <h3>Seleccionar addenda</h3>
    </div>
    <div class="modal-body">
      <form:select id="addendaSelect" path="addendaSelect" style="">
        <form:option value="">Seleccionar addenda</form:option>
        <c:forEach items="${addendas}" var="addenda">
        	<form:option value="${addenda.path}">${addenda.nombre}</form:option>
        </c:forEach>
      </form:select>
    </div>
    <div class="modal-footer">&nbsp;</div>
  </form>
</div>

<div>
	<input type="hidden" name="uuidAddenda" id="uuidAddenda" value="2">
</div>

<!-- Modal para agregar table de cfdi relacionados -->
<div class="modalcancel"><div id="tableCancelados" class="tableCancelados"></div></div>


<div id="divCargando" class="divCargando modal hide">
	<h4>Cancelando...</h4>
	<div style="width: 150px; margin: auto;">
		<div class="progress progress-striped active">
		  <div class="bar" style="width: 100%;"></div>
		</div>
	</div>
</div>

<c:if test="${msg != null}">
<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  ${msg}
</div>
</c:if>


<div class="container">
	<ul class="breadcrumb">
		<li><a href="#">Cat√°logos</a> <span
			class="divider">/</span></li>
		<li class="active">Lista CFDI's</li>
	</ul>
	<div id="btnAdd" style="padding-bottom: 10px;">
		<%--
		<a class="btn btn-primary" href="<c:url value="/comprobante/"/>">
			<i class="icon-user icon-white"></i> Emitir CFDI
		</a>
		--%>
		<div align="left">
			 <a title="Descargar" id="reporteXLS" href="#" class="btn btn-primary">
			 	<img src="<c:url value="/static/resources/img/cfdi/excel.png" />" width="24" height="24"> Descargar Reporte
			 </a>

			 <a title="Descargar" id="zipFile" href="#" class="btn btn-primary">
			 	<img src="<c:url value="/static/resources/img/cfdi/zip.png" />" width="24" height="24"> Descargar Zip
			 </a>
		 </div>


		<div align="right">
			  Ver CFDIs de:

			  <select id="anio" class="input-small">
			  	<option ${anio == "2019" ? 'selected' : ''}>2019</option>
			  	<option ${anio == "2018" ? 'selected' : ''}>2018</option>
			  	<option ${anio == "2017" ? 'selected' : ''}>2017</option>
			  	<!--  <option ${anio == "2016" ? 'selected' : ''}>2016</option>
			  	<option ${anio == "2015" ? 'selected' : ''}>2015</option>
			  	<option ${anio == "2014" ? 'selected' : ''}>2014</option>
			  	<option ${anio == "2013" ? 'selected' : ''}>2013</option>
			  	<option ${anio == "2012" ? 'selected' : ''}>2012</option>
			  	<option ${anio == "2011" ? 'selected' : ''}>2011</option>-->
			  </select>

			  <select id="mes" class="input-medium">
			  	<option value="01" ${mes == "01" ? 'selected' : ''}>Enero</option>
			  	<option value="02" ${mes == "02" ? 'selected' : ''}>Febrero</option>
			  	<option value="03" ${mes == "03" ? 'selected' : ''}>Marzo</option>
			  	<option value="04" ${mes == "04" ? 'selected' : ''}>Abril</option>
			  	<option value="05" ${mes == "05" ? 'selected' : ''}>Mayo</option>
			  	<option value="06" ${mes == "06" ? 'selected' : ''}>Junio</option>
			  	<option value="07" ${mes == "07" ? 'selected' : ''}>Julio</option>
			  	<option value="08" ${mes == "08" ? 'selected' : ''}>Agosto</option>
			  	<option value="09" ${mes == "09" ? 'selected' : ''}>Septiembre</option>
			  	<option value="10" ${mes == "10" ? 'selected' : ''}>Octubre</option>
			  	<option value="11" ${mes == "11" ? 'selected' : ''}>Noviembre</option>
			  	<option value="12" ${mes == "12" ? 'selected' : ''}>Diciembre</option>
			  </select>

			  <a href="#" class="btn btn-info" id="buscar" data-dismiss="modal">Buscar</a>
		 </div>
	</div>
	<div style="overflow-x: auto;">
		<table cellpadding="0" cellspacing="0" border="0"
			class="table table-striped table-bordered table-hover" id="listaCfd" style="font-size: 12px">
			<thead>

				<tr class="filterHeader">
					<th rowspan="1" colspan="1">
						<input type="hidden" name="search_platform" placeholder="Tipo" value="" class="search_init span1" />
					</th>

					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_platform" placeholder="Serie" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_version" placeholder="Folio" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_uuid" placeholder="UUID" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_confirmacion" placeholder="Confirmacion" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_grade" placeholder="Cliente" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_engine" placeholder="Subtotal" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_browser" placeholder="iva" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_platform" placeholder="Total" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_version" placeholder="CreaciÛn" value="" /></th>
					<th rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_grade" placeholder="Estatus" value="" /></th>
					<th rowspan="1" colspan="1"></th>
					<th rowspan="1" colspan="1"></th>
					<th rowspan="1" colspan="1"></th>
					<th style="display:none;" rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_version" value="" /></th>
					<th rowspan="1" colspan="1">Buscar Por <input type="hidden" name="search_platform" placeholder="Generacion" value="" class="search_init"></th>
				</tr>

				<tr>
					<th>Tipo</th>
					<th>Serie</th>
					<th>Folio</th>
					<th>UUID</th>
					<th>Confirmaci&oacute;n</th>
					<th>RFC Cliente</th>
					<th class="cantidad">Subtotal</th>
					<th class="cantidad">I.V.A.</th>
					<th class="cantidad">Total</th>
					<th>Creaci&oacute;n</th>
					<th>Estatus</th>
					<th>Enviado</th>
					<th>Opciones</th>
					<th class="mAddenda">Addenda</th>
					<th style="display:none;">Razon Social</th>
					<th>F</th>
				</tr>
			</thead>
			<tbody>
			<fmt:setLocale value="es_MX" scope="session"/>
			<c:forEach items="${cfds}" var="cfd">
				<tr id="row-${cfd.id}">
					<td>${cfd.tipoComprobante}</td>
					<td>${cfd.serie}</td>
					<td>${cfd.folio}</td>
					<td>${cfd.uuid}</td>
					<td>${cfd.confirmacion}</td>
					<td>${cfd.rfcReceptor}</td>
					<td class="right">$<fmt:formatNumber value="${cfd.subTotal}" pattern=" #,##0.00" /></td>
					<td class="right">$<fmt:formatNumber value="${cfd.iva}"  pattern=" #,##0.00" /></td>
					<td class="right">$<fmt:formatNumber value="${cfd.total}" pattern=" #,##0.00" /></td>
					<td><fmt:formatDate value="${cfd.fechaDate}" pattern="dd-MM-yyyy HH:mm"/></td>
					<td>
						<span class="<c:choose><c:when test="${cfd.estatus eq 'emitido'}">badge badge-success</c:when><c:when test="${cfd.estatus eq 'En proceso'}">badge badge-warning</c:when><c:otherwise>badge badge-important</c:otherwise> </c:choose>">
							${cfd.estatus}
						</span>
					</td>
					<td style="text-align: center">
						<c:choose>
							<c:when test="${cfd.enviado == true}">
								<i class="icon-ok"></i>
							</c:when>
							<c:otherwise>
								<i class="icon-remove"></i>
							</c:otherwise>
						</c:choose>
					</td>
					<td class="images">
					 <a title="Enviar por mail" src="#" href="<c:url value="/comprobante/email"/>/${cfd.uuid}/${cfd.fechaRegistro.toString().substring(0,7)}">
					 	<img src="<c:url value="/static/resources/img/cfdi/email.png" />" width="24" height="24">
					 </a>
					 <a title="Descargar XML" href="<c:url value="/descargar/xml" />/${cfd.uuid}/${cfd.fechaRegistro.toString().substring(0,7)}">
					 	<img src="<c:url value="/static/resources/img/cfdi/xml.png" />" width="24" height="24">
					 </a>
					 <a title="Cancelar CFDI" href="#" onclick="cancelarCfd(${cfd.id}, '${cfd.fechaRegistro.toString().substring(0,7)}', '${cfd.rfcReceptor}', '${cfd.total}', '${cfd.uuid}')">
					 	<img src="<c:url value="/static/resources/img/cfdi/cancelar2018.png" />" width="24" height="24">
					 </a>
					 <a title="Descargar PDF" href="<c:url value="/descargar/pdf" />/${cfd.uuid}/${cfd.fechaRegistro.toString().substring(0,7)}">
					 	<img src="<c:url value="/static/resources/img/cfdi/pdf.png" />" width="24" height="24">
					 </a>
					</td>
					<td class="mAddenda">
					  <a href="#modalAddenda" role="button" title="Agregar Addenda" data-toggle="modal" onClick="setAddenda('${cfd.uuid};')">
					 	<img src="<c:url value="/static/resources/img/cfdi/addenda.png" />" width="24" height="24">
					  </a>
					</td>
					<td style="display:none;">${cfd.razonSocialReceptor}</td>
					<td><fmt:formatDate value="${cfd.fechaDate}" pattern="yyyyMMddHHmmss"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<script>
		function setAddenda(uuid) {
			document.getElementById('uuidAddenda').value = uuid;
		}
	</script>
</div>
