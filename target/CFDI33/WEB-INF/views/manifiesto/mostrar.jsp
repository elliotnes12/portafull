<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
	<style>
		.container {
			margin: 0 auto;
			width: 95%;
		}
		.container input {
			height: 26px;
			width: 100%;
		}
		.inputfile {
			width: 0.1px;
			height: 0.1px;
			opacity: 0;
			overflow: hidden;
			position: absolute;
			z-index: -1;
		}
		.inputfile + label {
		    background-color: rgb(38,41,107);
		    color: white;
		    cursor: pointer;
		    display: inline-block;
		    font-size: 1.25em;
		    font-weight: 700;
		}

		.inputfile:focus + label,
		.inputfile + label:hover {
		    background-color: #9E8531;
		}
		label.file-label {
			padding: 5px;
			text-align: center;
			width: 100% !important;
		}
		.modal-header {
		    padding: 15px;
		    border-bottom: 1px solid #e5e5e5;
		}
	</style>
	<div class="container">
		<c:if test="${msg != null}">
		<div class="alert ${error == 1 ? 'alert-error': 'alert-success'} ">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${msg}
		</div>
		</c:if>
		<div class="modal-header">
			<h3>Firmar manifiesto</h3>
		</div>
		<p>A continuaci&oacute;n podr&aacute; firmar el manifiesto de timbrado con XPD:</p>
		<a class="btn btn-primary" target="_blank" href="https://portal.expidetufactura.com.mx:447/manifiesto/texto.txt">Leer manifiesto</a>
		<div class="row-fluid">
			<form method="POST" action="manifiesto/firmar" enctype="multipart/form-data">
				<div class="divRow">
					<div class="span6">
						<label for="rfc"><b>R.F.C. :</b></label>
						<input type="text" name="rfc" id="rfc" placeholder="R.F.C." />
					</div>
					<div class="span6">
						<label for="razonSocial"><b>Raz&oacute;n Social :</b></label>
						<input type="text" name="razonSocial" id="razonSocial" placeholder="Razón Social" />
					</div>
				</div>
				<div class="divRow">
					<div class="span6">
						<label for="email"><b>Correo electr&oacute;nico :</b></label>
						<input type="text" name="email" id="email" placeholder="Correo electrónico" />
					</div>
					<div class="span6">
						<label for="domicilioFiscal"><b>Domicilio Fiscal :</b></label>
						<input type="text" name="domicilioFiscal" id="domicilioFiscal" placeholder="Domicilio Fiscal" />
					</div>
				</div>
				<div class="divRow">
					<div class="span6">
						<div class="divRow">
							<label><b>Llave privada :</b></label>
							<input type="file" name="privada" id="private" class="inputfile" />
							<label for="private" class="file-label btn-large">
								<span><i class="icon-white icon-upload"></i>Llave privada&hellip;</span>
							</label>
							Seleccione el archivo .key de su CSD
						</div>
					</div>
					<div class="span6">
						<div class="divRow">
							<label><b>Certificado :</b></label>
							<input type="file" name="certificado" id="certificado" class="inputfile" />
							<label for="certificado" class="file-label btn-large">
								<span><i class="icon-white icon-upload"></i>Certificado&hellip;</span>
							</label>
							Seleccione el archivo .cer de su CSD
						</div>
					</div>
				</div>
				<div class="divRow">
					<div class="span6">
						<label for="password"><b>Contrase&ntilde;a de la llave privada :</b></label>
						<input type="password" name="password" placeholder="Contraseña de la llave privada" id="password" />
					</div>
				</div>
				<div style="clear: both;"></div>
				<div class="divRow">
					<div class="span6">
						<input type="submit" value="Firmar manifiesto" class="btn btn-primary" />
					</div>
					<div class="span6"></div>
				</div>
			</form>
		</div>
	</div>
	<script>
		var inputs = document.querySelectorAll( '.inputfile' );
		Array.prototype.forEach.call( inputs, function( input )
		{
			var label	 = input.nextElementSibling,
				labelVal = label.innerHTML;

			input.addEventListener( 'change', function( e )
			{
				var fileName = '';
				if( this.files && this.files.length > 1 )
					fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
				else
					fileName = e.target.value.split( '\\' ).pop();

				if( fileName )
					label.querySelector( 'span' ).innerHTML = fileName;
				else
					label.innerHTML = labelVal;
			});
		});
	</script>
