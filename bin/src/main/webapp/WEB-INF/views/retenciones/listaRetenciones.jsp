<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/datepicker.css"/>" />
<script	src="<c:url value="/static/resources/js/bootstrap-datepicker.js"/>">
</script>
<script>

	$(document).ready(function() {
		<c:if test="${tieneAddendas}" >
			$('.mAddendas').show(0);
		</c:if>
<!--
		$("#reporteXLS").click(function(event) {
			window.open("/CFDI/rest/comprobante/xlsFile/" + $('#anio').val() + "-" +  $('#mes').val());
		});

		$('#zipFile').click(function() {
			window.open("/CFDI/rest/comprobante/zipFile/" + $('#anio').val() + "-" +  $('#mes').val());
		});
		-->
		$('#addendaSelect').change(function() {
	          if($(this).val() != "") {
	        	$('#modalAddenda').modal('hide');
	            window.open("/CFDI33/comprobante/addendaRetenciones/" + $(this).val() + "/" +$('#uuidAddenda').val());
	          }
	        });


		var oTable = $('#listaRetenciones').dataTable({
			"aoColumns" : [
			   			{"bVisible":false}, // fecha
			            null, // folio
			   			null, // razon social
			   			null, // ejercicio
			   			null, // monto total operacion
			   			null, // monto total retenciones
			   		 	{ "sSortDataType": "date-euro-pre" }, //ordar por la columna 12 fecha
			   			{ "bSearchable" : false, "bSortable":false }, // estatus
			   			//{ "bSearchable" : false, "bSortable":false }, // enviado
			   			{ "bSearchable" : false, "bSortable":false }, // opciones
			   			{"bSortable":false} // addenda
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
			"aaSorting": [[ 0, "desc" ]]
		   });


		 $(".filterHeader input").keyup( function () {
		        /* Filter on the column (the index) of this element */
		        oTable.fnFilter( this.value, $(".filterHeader input").index(this) );
		    } );

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
			var ddd = $('#anio').val() + "-" +  $('#mes').val();
			redirect('/CFDI33/comprobante/filtrarRetenciones/' + ddd + '/' + ddd );
		});




	});

	function cancelarRetenciones(id) {
		if (confirm("øDesea cancelar la retencion? ")) {
			modalCargando();
			$.get(context + "/rest/comprobante/cancelarRetenciones/" + id, function(cancelado) {
				if (cancelado == "1201 - Folio cancelado" || cancelado == "1202 - Folio previamente cancelado") {
					alert("Retencion cancelada");
					redirect('<c:url value="/comprobante/listarRetenciones/"></c:url>');
				} else {
					alert(cancelado);
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
		text-align: center !important;
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
		<li class="active">Lista Retenciones</li>
	</ul>
	<div id="btnAdd" style="padding-bottom: 10px;">
		<!--
		<a class="btn btn-primary" href="<c:url value="/comprobante/"/>">
			<i class="icon-user icon-white"></i> Emitir CFDI
		</a>

		<div align="left">
			 <a title="Descargar" id="reporteXLS" href="#">
			 	<img src="<c:url value="/static/resources/img/cfdi/excel.png" />" width="24" height="24"> Descargar Reporte
			 </a>

			 <a title="Descargar" id="zipFile" href="#">
			 	<img src="<c:url value="/static/resources/img/cfdi/zip.png" />" width="24" height="24"> Descargar Zip
			 </a>
		 </div>
	-->

		<div align="right">
			  Ver Retenciones de:

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

			  <select id="mes" class="input-large">
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
	<table cellpadding="0" cellspacing="0" border="0"
		class="table table-striped table-bordered table-hover" id="listaRetenciones">
		<thead>
			<tr>
				<th>F</th>
				<th>Folio</th>
				<th>Raz&oacute;n Social</th>
				<th>Ejercicio</th>
				<th>Monto Total Operaci&oacute;n</th>
				<th>Monto Total Retenciones</th>
				<th>Creaci&oacute;n</th>
				<th>Estatus</th>
				<!--  <th>Enviado</th>-->
				<th>Opciones</th>
				<th class="mAddenda">Addenda</th>
			</tr>
		</thead>
		<fmt:setLocale value="es_MX" scope="session"/>
		<c:forEach items="${retenciones}" var="retencion">
			<tr id="row-${retencion.id}">
				<td><fmt:formatDate value="${retencion.fechaRegistro}" pattern="yyyyMMddHHmmss"/></td>
				<td>${retencion.folio}</td>
				<td>${retencion.razonSocialReceptor}</td>
				<td>${retencion.ejercicio}</td>
				<td>${retencion.montoTotalOperacion}</td>
				<td>${retencion.montoTotalRetenciones}</td>
				<td><fmt:formatDate value="${retencion.fechaRegistro}" pattern="dd-MM-yyyy HH:mm"/></td>
				<td>
					<span class="${retencion.estatus eq 'emitido' ? 'badge badge-success' : 'badge badge-important'}">
						${retencion.estatus}
					</span>
				</td>
				<!--  <td style="text-align: center">
					<c:choose>
						<c:when test="${retencion.enviado == true}">
							<i class="icon-ok"></i>
						</c:when>
						<c:otherwise>
							<i class="icon-remove"></i>
						</c:otherwise>
					</c:choose>
				</td>-->
				<td>
				 <!--  <a title="Enviar por mail" src="#" href="<c:url value="/retenciones/email"/>/${retencion.uuid}">
				 	<img src="<c:url value="/static/resources/img/cfdi/email.png" />" width="24" height="24">
				 </a>-->
				 <a title="Descargar XML" href="<c:url value="/descargar/xmlRet" />/${retencion.uuid}">
				 	<img src="<c:url value="/static/resources/img/cfdi/xml.png" />" width="24" height="24">
				 </a>
				 <a title="Cancelar Retenci&oacute;n" href="#" onclick="cancelarRetenciones(${retencion.id})">
				 	<img src="<c:url value="/static/resources/img/cfdi/cancelar.png" />" width="24" height="24">
				 </a>
				 <a title="Descargar PDF" href="<c:url value="/descargar/pdfRet" />/${retencion.uuid}">
				 	<img src="<c:url value="/static/resources/img/cfdi/pdf.png" />" width="24" height="24">
				 </a>
				</td>
				<td class="mAddenda">
				  <a href="#modalAddenda" role="button" title="Agregar Addenda" data-toggle="modal" onClick="document.getElementById('uuidAddenda').value='${retencion.uuid}';">
				 	<img src="<c:url value="/static/resources/img/cfdi/addenda.png" />" width="24" height="24">
				  </a>
				</td>


			</tr>
		</c:forEach>
	</table>
</div>
