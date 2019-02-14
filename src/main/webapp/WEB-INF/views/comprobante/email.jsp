<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<style>
#btnAdd {
	padding-bottom: 10px;
}

#formEnviarEmail {
	width: 730px !important;
	left: 40%;
}

.modal-left {
	width: 360px;
	float: left;
}

.modal-right {
	width: 330px;
	margin-bottom: 20px;
	float: right;
}

#formEnviarEmail .one-row label {
	display: inline-block;
	width: 85px;
	text-align: right;
}

#formEnviarEmail label.error {
	display: none;
}

.first-div-row {
	margin-top: 15px;
}

.invalid {
	color: red;
	font: 65%/1 sans-serif;
}
.modal-footer {
	width: 730px;
	float: right;
}
.descripcion {
	width: 250px;
	margin-left: 35px; 
	margin-bottom: 10px; 
	background-color: #D8D8D8;
}
.radios {
	margin-right: 15px;
}
</style>
<script>
	$(document).ready(function() {
		$('.close-editar').click(function() {
			redirect('/CFDI33/comprobante/listar/');
		});

		$('#emailReceptor').change(function() {
			var patt=/^([\w+-.%]+@[\w-.]+\.[A-Za-z]{2,4};?( )?)+$/g;
			var result=patt.test($('#emailReceptor').val());
			if (!result) {
				alert("Email no valido.")
				$('#emailReceptor').focus();
			}
		});

		$('#emailEmisor').change(function() {
			var patt=/^([\w+-.%]+@[\w-.]+\.[A-Za-z]{2,4};?( )?)+$/g;
			var result=patt.test($('#emailEmisor').val());
			if (!result) {
				alert("Email no valido.")
				$('#emailEmisor').focus();
			}
		});		

		$('#formEnviarEmail').validate({
			rules : {
				emailReceptor : {
					required : true
				},
				emailEmisor : {
					required : true
				},
			 	asunto: {
					required : true
				},
				textoEnviar : {
					required : true
				}
			}
		});
	});
</script>

<form:form id="formEnviarEmail" name="formEnviarEmail" commandName="email" 
	action="/CFDI33/rest/comprobante/enviarEmail/${uuid}/${fecha}" method="POST">
	<input type="hidden" name="uuid" id="uuid" value="${uuid}">
	<input type="hidden" name="fecha" id="fecha" value="${fecha}">
	<div id="enviarEmail">
		<div>
				<div style="height: 20px"></div>
				<div class="one-row first-div-row">
					<form:label path="emailReceptor">Para: </form:label>
					<form:input path="emailReceptor" id="emailReceptor" class="input-xxlarge"/>
					<form:errors class="invalid" path="emailReceptor" />
				</div>
				<div class="one-row first-div-row">
					<form:label path="emailEmisor">De: </form:label>
					<form:input path="emailEmisor" id="emailEmisor" class="input-xxlarge" readonly="true"/>
					<form:errors class="invalid" path="emailEmisor" />
				</div>
				<div class="one-row first-div-row">
					<form:label path="emailReplyTo">Responder a: </form:label>
					<form:input path="emailReplyTo" id="emailReplyTo" class="input-xxlarge" readonly="true"/>
				</div>
				<div class="one-row first-div-row">
					<form:label path="asunto">Asunto: </form:label>
					<form:input path="asunto" id="asunto" class="input-xxlarge"/>
					<form:errors class="invalid" path="asunto" />
				</div>
				<div class="one-row first-div-row">
					<form:textarea path="textoEnviar" style="width:532px;height:150px;margin-left:87px;"/>
					<form:errors class="invalid" path="textoEnviar" />
				</div>	
			
			<div class="modal-footer">
						<a href="#" class="btn close-editar" data-dismiss="modal">Cancelar</a>
						<button type="submit" class="btn btn-primary">Enviar</button>
			</div>
	</div>
	</div>
</form:form>