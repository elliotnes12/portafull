<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />

<link class="include" rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/jquery.jqplot.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap-arrows.css"/>" />

<style>
	#tablaFolios {float: left;margin-right: 30px;margin-top: 50px;width: 250px;}
	#chart1 {width: 100%;height: 350px;margin: 0px auto;position: relative;float: left;}
	.divYears {width: 80%;text-align: center;clear: both;margin:0 auto;}
	#left1,#left3 {width: 20%;}
	#left2 {width: 60%;}
	#left3 {float: right;}
	#left1,#left2 {float: left;}
	div.content{padding-top: 0;}
</style>

	<div class="row-fluid" style="margin: auto;">

	<!--
	<br>
	<center>
	<a target="_blank" href="http://portal.expidetufactura.com.mx/banner">
		<img src="http://portal.expidetufactura.com.mx/banner/banner.png" >
	</a>
	</center>
	<br>
	 -->
	 	<div id="tabla" class="span10 offset1" style="display: none;">
	 		<a class="btn btn-primary" href="#" onclick='toggleViews()' style="float: right;">Mostrar Gr&aacute;fico Folios</a>
	 		<div style="margin:auto;width: inherit;font-size: 12px;">
				<table class="table table-bordered" id="tablaFolios">
					<thead>
						<tr>
							<th colspan="14">Resumen de Folios:</th>
						</tr>
						<tr>
							<th></th>
							<th>ENE</th>
							<th>FEB</th>
							<th>MAR</th>
							<th>ABR</th>
							<th>MAY</th>
							<th>JUN</th>
							<th>JUL</th>
							<th>AGO</th>
							<th>SEP</th>
							<th>OCT</th>
							<th>NOV</th>
							<th>DEC</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<!--  <tr>
							<td>Folios disponibles</td>
							<td>${foliosDisponibles }</td>
						</tr>-->
						<tr>
							<td>Emitidos</td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td class="emitidos"></td>
							<td id="tdEmitidos">${foliosEmitidos }</td>
						</tr>
						<tr>
							<td>Cancelados</td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td class="cancelados"></td>
							<td id="tdCancelados">${foliosCancelados }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div style="clear:both;"></div>
		<div id="grafico" class="span10 offset1">
			<a class="btn btn-primary" href="#" onclick='toggleViews()' style="float: right;">Mostrar Tabla Folios</a>
			<div id="chart1"></div>
		</div>
		<div style="clear: both;"></div>
		<div class="page-header divYears">
			<div id="left1">
				<span rel="270" id="yearAntes" title="ver a&ntilde;o anterior" style="cursor: pointer;" class="arrow-info"></span>
			</div>
			<div id="left2">
				<h1>
					<small id="years">2013</small>
				</h1>
			</div>
			<div id="left3">
				<span rel="90" id="yearDespues" title="ver a&ntilde;o siguiente" style="cursor: pointer;" class="arrow-info"></span>
			</div>
		</div>
	</div>
	<span><c:out value="${emitidos}"/></span>
	<div id="welcomeMSG" class="modal hide fade" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
		    <h3 id="myModalLabel">Bienvenido al PORTAL DE FACTURACI&Oacute;N XPD</h3>
		</div>
		<div class="modal-body">
			<p>Bacon ipsum dolor amet ball tip capicola kielbasa burgdoggen, pancetta rump flank. Pancetta fatback prosciutto beef kevin boudin strip steak. Shoulder turducken pancetta ground round jerky, corned beef short ribs bresaola filet mignon ribeye shank. Tenderloin rump corned beef kevin chuck swine biltong shank. Pork chop sausage turducken, beef biltong burgdoggen kevin andouille tail pastrami chuck short loin landjaeger. Porchetta rump flank sausage beef pancetta picanha meatball hamburger prosciutto drumstick brisket pork loin chuck.</p>
		    <ul>
		    	<li>CFDI 3.3</li>
		    	<li>N&oacute;mina 1.2</li>
		    </ul>
		</div>
		<div class="modal-footer">
		</div>
	</div>
	<!--[if lt IE 9]>
	<script language="javascript" type="text/javascript" src="../excanvas.js"></script>
	<![endif]-->
	<script class="include" type="text/javascript" src="<c:url value="/static/resources/js/plotly.min.js"/>"></script>

	<script src="<c:url value="/static/resources/js/bootstrap-arrows.min.js"/>"></script>
	<c:if test="${banner != null}">
	<script type="text/javascript">
	var data = ${banner};
	function showModal(){
		var dataAvalible = false;
		if(data.image != "" && data.image != "null") {
			var image = "";
			var img = new Image();
			var hei = 0, wid = 0;
			img.onload = function() {
				hei = this.height;
				wid = this.width;
			};
			img.src = data.image;
			if(data.urlRedirect != "" && data.urlRedirect != "null") {
				image = '<a href="'+data.urlRedirect+'" target="_blank">' + img.outerHTML + '</a>';
			} else {
				image = img.outerHTML;
			}
			$(".modal-body").html("<div style='margin:0 auto;max-width:80%;width:"+img.width+"px'>" + image + "</div>");
			dataAvalible = true;
		}
		if(data.text != "" && data.text != "null") {
			$(".modal-body").append(data.text);
			dataAvalible = true;
		}
		if(dataAvalible) {
			$("#welcomeMSG").modal();
		}
	}
	</script>
	</c:if>
	<c:if test="${banner == null}">
	<script type="text/javascript">function showModal(){}</script>
	</c:if>
	<script class="code" type="text/javascript">
		function toggleViews(){
			$("#grafico").toggle(200);$("#tabla").toggle(200);
		}

		$(document).ready(function() {
			try{
				showModal();
				$('#years').css('color', 'blue')

				$('.arrow, [class^=arrow-]').bootstrapArrows();

				var year = new Date().getFullYear();
				graficar(year);

				$('#yearAntes').click(function() {
					--year;
					graficar(year);
					});

				$('#yearDespues').click(function() {
					++year;
					graficar(year);
					});
			}catch(err){
			}
		});
		function sum(a, b){ return a + b; }
		function graficar(year) {
			var meses = null;
			var emitidos = [];
			var cancelados = [];
			var tEmitidos = 0;
			var tCancelados = 0;
			$('#years').html("Resumen " + year);
			var dataYaxis = {
	 					min: 0,
						tickInterval: 1,
						tickOptions : {
							formatString : '%d'
						}
					}
			$.ajax({
				url : '/CFDI33/rest/comprobante/foliosPorMes/' + year,
				async : false
			}).done(function(response) {
				meses = response[0];
				emitidos = response[1];
				cancelados = response[2];

				tEmitidos = emitidos.reduce(sum, 0);
				tCancelados = cancelados.reduce(sum, 0);
				$.each(emitidos,function(k, v){
					$($("td.emitidos")[k]).html(v);
				});
				$.each(cancelados,function(k, v){
					$($("td.cancelados")[k]).html(v);
				});
				$("#tdEmitidos").html(""+tEmitidos);
				$("#tdCancelados").html(""+tCancelados);

				$.each(emitidos, function (key, value) {
					  if (value >  4) {
					    delete dataYaxis.tickInterval;
					  }
					});
				$.each(cancelados, function (key, value) {
					  if (value >  4) {
					    delete dataYaxis.tickInterval;
					  }
					});
			});

			// Can specify a custom tick Array.
			// Ticks should match up one for each y value (category) in the series.
			var ticks = meses;
			var trace1 = {
			  x: ticks,
			  y: emitidos,
			  name: 'Emitidos',
			  // orientation: 'h',
			  marker: {
			    color: 'rgba(32,44,108,0.6)',
			    width: 1
			  },
			  type: 'scatter'
			};

			var trace2 = {
			  x: ticks,
			  y: cancelados,
			  name: 'Cancelados',
			  // orientation: 'h',
			  type: 'scatter',
			  marker: {
			    color: 'rgba(158,133,49,0.6)',
			    width: 1
			  }
			};
			
			var data = [trace1, trace2];

			var layout = {
			  title: 'Folios',
			  barmode: 'group'
			};
			Plotly.newPlot('chart1', data, layout, {displayModeBar:false});
		}
	</script>

