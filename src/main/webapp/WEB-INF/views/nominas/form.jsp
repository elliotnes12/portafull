<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<style>
		td {
			text-align: center;
		}
		td.right{
			text-align: right !important;
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
		.progress { height: 30px; }
		input{height: initial;}
		#listaCfd th{
			padding: 4px !important;
		}
		.cantidad{
			width: 100px !important;
		}
		.btn{
			height: 34px;
		}
		#buscar{
			margin-top: -8px;
		}
		#formNomina12{
			margin-left: 1%;
			text-align: left;
		}
		@media (max-width: 639px){
			input[type=submit].btn {
			    width: 100% !important;
			}
		}
	</style>
	<script>
	$(document).ready(function(){
		$('#formNomina12').unbind('submit').bind('submit',  function() {  //submit( // .submit(function() {
			alert("Sus nóminas se están procesando...")
		if ($('input[name=file12').val() == "") {
		alert("Seleccione su archivo");
		return false;
		}
		$('#myModal').modal();
			return true;
		});
		$('a.toggle-vis').on( 'click', function (e) {
			e.preventDefault();
	        var iCol = $(this).attr('data-column');
	        var oTable = $('#listaCfd').dataTable();
	        var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
			oTable.fnSetColumnVis( iCol, bVis ? false : true );
	    } );
	})
	</script>
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-122238418-1"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());
	  gtag('config', 'UA-122238418-1');
	</script>
	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">Espere un momento</h3>
		</div>
		<div class="modal-body">
			<p>Su archivo, se esta subiendo al servidor ...</p>
		</div>
		<div class="modal-footer">
			<p> By XPD</p>
		</div>
	</div>
	<c:if test="${msg != null}">
	<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		${msg}
	</div>
	</c:if>
	<div class="container">
		<br>
		<ul class="breadcrumb">
			<li><a href="#">CatÃ¡logos</a> <span class="divider">/</span></li>
			<li class="active">Lista CFDI's</li>
		</ul>
		<div style="padding: 15px;">
			<div>
				<h3>Generar Nómina Excel</h3>
			</div>
			<div style="margin:0 auto;max-width: 480px;padding: 30px;">
				<form:form method="post" id="formNomina12" enctype="multipart/form-data"  modelAttribute="uploadedFile" action="timbrar12">
					<label for="file12" class="btn btn-success">
						<i class="icon-arrow-up icon-white"></i>
						Seleccionar archivo n&oacute;mina
					</label>
					<input type="file" name="file12" id="file12" class="hide" />
					<form:errors path="file12"/>
						<input type="submit" class="btn btn-primary" value="Subir nómina" />
					</form:form>
			</div>
			<c:if test="${totalFilas > 0}">
				<div class="row-fluid">
					<!--	  	<button type="button" class="close" data-dismiss="alert">&times;</button> -->
					<div class="alert alert-info">
						<strong> Total a generar:  ${totalFilas} </strong>
					</div>
					<div class="alert alert-success">
						<strong>Generadas: ${totalProcesar}</strong>
					</div>
					<div class="alert alert-error">
						<strong>Errores: ${totalErrores}</strong>
					</div>
					<h2>Generando n&oacute;minas</h2>
					<div class="progress progress-striped active">
						<div class="bar bar-success" style="width: ${((totalProcesar + totalErrores) * 100) / totalFilas}%;"> ${totalProcesar + totalErrores}  </div>
					</div>
				</div>
			</c:if>
			<c:if test="${totalFilas == (totalProcesar + totalErrores)}">
				<a href="<c:url value="/nominas/errores/" />">Descargar errores</a>
			</c:if>
				<%--
				<a class="btn btn-primary" href="<c:url value="/comprobante/"/>">
							<i class="icon-user icon-white"></i> Emitir CFDI
				</a>
				-->
				<!--
				<div align="left">
							<a title="Descargar" id="reporteXLS" href="#">
										<img src="<c:url value="/static/resources/img/cfdi/excel.png" />" width="24" height="24"> Descargar Reporte
							</a>
				</div>
				--%>
			</div>
			
