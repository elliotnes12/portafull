<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #btnAdd {padding-bottom: 10px;}
    #formDatosEmisor {width: 90% !important;left: 37%; margin:auto}
    #formDatosEmisor label.error {display: none;}
    #formDatosEmisor input, #formDatosEmisor select{height: initial;width: 100%;}
    .first-div-row {margin-top: 15px;}
    .modal-body {
        max-height: none !important;
        overflow-y: hidden !important;
    }
</style>

<script>
$(document).ready(function() {
    var rutaBD = $("#rutalogoBD").val();
    var mostrarLogo = $("#rutalogo").val();
    
    cancelKeyPipe("#razonSocial");

$.validator.addMethod("valueNotEquals", function(value, element, arg){
          return arg != value;
         }, "Debe seleccionar una opcion.");

$.validator.addMethod(
            "regex",
            function(value, element, regexp) {
                var re = new RegExp(regexp);
                return this.optional(element) || re.test(value);
            },
            "Ingrese un RFC válido."
    );
    
$('#datosEmisor').validate({
    rules: {
    	razonSocial: {
            required: true
        },
        rfc: {
            required: true,
            regex: '[A-Z&amp;Ñ]{3,4}[0-9]{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])[A-Z0-9]{2}[0-9A]?'
            		
        },
        regimenFiscal: {
            required: true,
            valueNotEquals: ""
            },
        codigoPostal: {
            required: true,
            },
        email: {
            required: true
        }
    }
});

    $("#rfc").attr("disabled", true);

    $('#estado').change(
    		
            function() {    
              if ($('#pais').val() != "ZZZ") {
            	  $.get('/CFDI33/rest/estado/listarMunicipios/'+$(this).val(), {}, function(responseText) {
                          $('#delegacionMunicipio').html(responseText);
                    });    
                  $.get('/CFDI33/rest/estado/listarLocalidades/'+ $(this).val(), {}, function(responseText) {
                          $('#localidad').html(responseText);
                    });
                  $.get('/CFDI33/rest/estado/listarCodigosPostalesEstado/'+$('#estado').val(), {}, function(responseText) {
                      $('#codigoPostal').html(responseText);
                	});    
              }
            }); 
    $('#delegacionMunicipio').change(
            function() {    
              if ($(this).val() != "ZZZ") {
                      $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipio/'+$('#estado').val()+'/'+$(this).val(), {}, function(responseText) {
                          $('#codigoPostal').html(responseText);
                    });    
              }
            });

    $('#localidad').change(
            function() {    
              if ($(this).val() != "ZZZ") {
                      $.get('/CFDI33/rest/estado/listarCodigosPostalesEstadoMunicipioLocalidad/'+$('#estado').val()+'/'+$('#delegacionMunicipio').val()+'/'+$(this).val(), {}, function(responseText) {
                          $('#codigoPostal').html(responseText);
                    });    
              }
            });

    var arrayRegimenesMorales = ["601","603","609","610","620","622","623","624","628","607"];
    var arrayRegimenesFisicas = ["605","606","608","610","611","612","614","616","621","622","629","630","615"];

    $('#email').change(function() {
    	var patt=/^([\w+-.%]+@[\w-.]+\.[A-Za-z]{2,4})+$/g;
    	var result=patt.test($('#email').val());
    	if (!result) {
    		alert("Email no válido.")
    		$('#email').focus();
    	}
    });
         
	$('#regimenFiscal').change(function() {
		if ($('#rfc').val().length == 12){
			if (arrayRegimenesMorales.indexOf($('#regimenFiscal').val()) < 0){
				alert("Su RFC tiene 12 posiciones, por lo que el Régimen Fiscal debe corresponder a Personas Morales");
			}
		}
		if ($('#rfc').val().length == 13){
            if (arrayRegimenesFisicas.indexOf($('#regimenFiscal').val()) < 0){
				alert("Su RFC tiene 13 posiciones, por lo que el Régimen Fiscal debe corresponder a Personas Físicas");
			}	
		}
	})
});
</script>
<form:form commandName="datosEmisor" action="${formAction}" enctype="multipart/form-data" method="POST">
    <input type="hidden" name="id" id="id" value="${datosEmisor.id}">
    <input type="hidden" name="rutalogo" id="rutalogo" value='<c:url value="/images/logo/" />${datosEmisor.tenantId}'>
    <input type="hidden" name="rutalogoBD" id="rutalogoBD" value="${datosEmisor.logo}">
    
    <div id="formDatosEmisor" class="${action eq 'Agregar' ? 'modal hide' : ''}">
        <div class="modal-header">
            <button type="button" class="close close-editar" data-dismiss="modal" aria-hidden="true">&times;</button>
            <h3>${action} Datos del Emisor</h3>
        </div>

        <div class="modal-body">
            <div class="one-row first-div-row">
                <form:hidden path="id" class="input-small" />
                <div class="row-fluid">
                    <div class="span8">
                        <div class="span2"><form:label path="razonSocial" class="required">Raz&oacute;n social:</form:label></div>
                        <div class="span10">
                            <form:input path="razonSocial"/>
                            <form:errors path="razonSocial"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span4">
                    <div class="span4"><form:label path="rfc">R.F.C.:</form:label></div>
                    <div class="span8">
                        <form:input path="rfc" class="input-large"/>
                        <form:errors path="rfc"/>
                    </div>
                </div>
                <div class="span4">
                    <div class="span4">
                        <form:label path="regimenFiscal" class="required">R&eacute;gimen Fiscal:</form:label>
                    </div>
                    <div class="span8">
                        <form:select path="regimenFiscal">
                        	<form:option value="">Seleccionar</form:option>
                        	<c:forEach items="${regimenes}" var="regimen" >
								<option value="${regimen.clave}" ${datosEmisor.regimenFiscal eq regimen.clave ? 'selected':''}>${regimen.nombre}</option>
							</c:forEach>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span4">
                    <div class="span4"><form:label path="estado" >Estado:</form:label></div>
                    <div class="span8">
                        <form:select path="estado">
                        	<form:option value="">Seleccionar</form:option>
                        	<c:forEach items="${estados}" var="estado" >
								<option value="${estado.id}" ${datosEmisor.estado eq estado.id ? 'selected':''}>${estado.nombre}</option>
							</c:forEach>
                        </form:select>
                        <form:errors path="estado"/>
                    </div>
                </div>
                <div class="span4">
               		<div class="span4"><form:label path="delegacionMunicipio">Municipio:</form:label></div>
                    <div class="span8">
                        <form:select path="delegacionMunicipio">
                        	<form:option value="">Seleccionar</form:option>
                        	<c:forEach items="${delegacionesMunicipio}" var="delegacionMunicipio" >
								<option value="${delegacionMunicipio.clave}" ${datosEmisor.delegacionMunicipio eq delegacionMunicipio.clave ? 'selected':''}>${delegacionMunicipio.nombre}</option>
							</c:forEach>
                        </form:select>
                 	</div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span4">
                    <div class="span4"><form:label path="localidad">Localidad:</form:label></div>
                    <div class="span8">
                        <form:select path="localidad">
                        	<form:option value="">Seleccionar</form:option>
                            <c:forEach items="${localidades}" var="localidad" >
                                <option value="${localidad.clave}" ${datosEmisor.localidad eq localidad.clave ? 'selected':''}>${localidad.nombre}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="span4">
                    <div class="span4"><form:label path="codigoPostal" class="required">C&oacute;digo Postal:</form:label></div>
                    <div class="span8">
                       <form:select path="codigoPostal">
                       	<c:forEach items="${cps}" var="cp" >
								<option value="${cp.cp}" ${datosEmisor.codigoPostal eq cp.cp ? 'selected':''}>${cp.cp}</option>
							</c:forEach>
                        </form:select>
                        <form:errors path="codigoPostal"/>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span4">
                    <div class="span4"><form:label path="email" class="required">Correo Electr&oacute;nico:</form:label></div>
                    <div class="span8">
                        <form:input path="email"/>
                    </div>
                </div>
            </div>
            <div class="row-fluid" style="padding-top: 25px">
                <!-- <form:label path="logo">Seleccione el logo:</form:label>
                <input type="file" name="archivo" />
                <img width="100" height="100" id="imagenLogo"> -->
                <div class="span4">
                    <label for="logoUser" class="btn btn-primary">
                        <i class="icon-arrow-up icon-white"></i>
                        Seleccione el logo:
                    </label>
                    <input id="logoUser" type="file" name="archivo" class="hide" onchange="readURL(this)" />
                </div>
                <div class="span2" style="min-height: 150px">
                    <img id="imagenLogo" src="#" class="hide">
                </div>
                <script>
                    function readURL(input){
                        if(input.files && input.files[0]){
                            var reader = new FileReader();
                            reader.onload = function (e) {
                                $('#imagenLogo')
                                    .attr('src', e.target.result)
                                    .width(125)
                                    .height(150)
                                    .show();
                            };
                            reader.readAsDataURL(input.files[0]);
                        }
                    }
                </script>
            </div>
        </div>
        
        <div class="modal-footer">
        <c:choose>
<c:when test="${action == 'Detalle'}">
            <button type="submit" class="btn btn-primary">Regresar</button>
</c:when>
<c:otherwise>   
            <a href="${contextPath}/login/inicio" class="btn close-editar" data-dismiss="modal">Cancelar</a>
            <button type="submit" class="btn btn-primary">Aceptar</button>
</c:otherwise>
</c:choose>
        </div>
    </div>
</form:form>
