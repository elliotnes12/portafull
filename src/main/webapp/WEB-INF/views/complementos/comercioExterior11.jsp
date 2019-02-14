<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script>
$(document).ready(function() {
	function cancelKeyPipe(input) {
		$(input).on('keydown', function(e) {
			if(e.key == '|') {
				return false;
			}
		});
		$(input).on('change',function(e) {
			if(/\|/.test($(this).val())) {
				$(this).val(cleanStringPipe($(this).val()));
			}
		});
	}
});

$(document).ready(function() {
	// Cancelar la captura de | en los campos indicados
	cancelKeyPipe("#estadoReceptorComercioExtAux");
	cancelKeyPipe("#estadoDestinatarioComercioExtAux");
	cancelKeyPipe("#nombreDestinatarioComercioExt");
	cancelKeyPipe("#marcaDescripcionComercioExt");
	cancelKeyPipe("#modeloDescripcionComercioExt");
	cancelKeyPipe("#submodeloDescripcionComercioExt");
	cancelKeyPipe("#numeroSerieDescripcionComercioExt");
	cancelKeyPipe("#NoIdentificacionMercanciaComercioExt");
	cancelKeyPipe("#numCertificadoOrigen");
	cancelKeyPipe("#numExportadorConfiable");
	cancelKeyPipe("#ObservacionesComercioExt");
	cancelKeyPipe("#calleEmisorComercioExt");
	cancelKeyPipe("#calleReceptorComercioExt");
	cancelKeyPipe("#calleDestinatarioComercioExt");
	cancelKeyPipe("#numeroExteriorDestinatarioComercioExt");
	cancelKeyPipe("#numeroInteriorDestinatarioComercioExt");
	cancelKeyPipe("#numeroExteriorEmisorComercioExt");
	cancelKeyPipe("#numeroInteriorEmisorComercioExt");
	cancelKeyPipe("#numeroExteriorReceptorComercioExt");
	cancelKeyPipe("#numeroInteriorReceptorComercioExt");
	cancelKeyPipe("#referenciaEmisorComercioExt");
	cancelKeyPipe("#referenciaReceptorComercioExt");
	cancelKeyPipe("#referenciaDestinatarioComercioExt");
	cancelKeyPipe("#coloniaReceptorComercioExt");
	cancelKeyPipe("#coloniaDestinatarioComercioExtAux");
	cancelKeyPipe("#localidadDestinatarioComercioExt");
	cancelKeyPipe("#localidadReceptorComercioExtAux");
	cancelKeyPipe("#municipioDestinatarioComercioExt");
	cancelKeyPipe("#municipioReceptorComercioExtAux");
});
</script>
<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseComercioExt11">
            Complemento Comercio Exterior 1.1
        </a>
    </div>
    <div id="collapseComercioExt11" class="accordion-body collapse">
        <div class="accordion-inner">
        	<div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Motivo Traslado: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="motivoTrasladoComercioExt" id="motivoTrasladoComercioExt">
                            <option value="">Seleccionar</option>
                            <option value="01">Envío de mercancias facturadas con anterioridad </option>
                            <option value="02">Reubicación de mercancías propias </option>
                            <option value="03">Envío de mercancías objeto de contrato de consignación </option>
                            <option value="04">Envío de mercancías para posterior enajenación </option>
                            <option value="05">Envío de mercancías propiedad de terceros </option>
                            <option value="99">Otros </option>
                        </select>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label class="required">Tipo Operaci&oacute;n: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="tipoOperacionComercioExt" id="tipoOperacionComercioExt">
                            <option value="">Seleccionar</option>
                            <option value="2">Exportaci&oacute;n </option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Clave de Pedimento: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="clavePedimento" id="clavePedimento">
                            <option value="">Seleccionar</option>
                            <option value="A1">IMPORTACION O EXPORTACION DEFINITIVA</option>
                        </select>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Certificado Origen: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="certificadoOrigen" id="certificadoOrigen">
                            <option value="">Seleccionar</option>
                            <option value="0">No Funge como certificado de origen</option>
                            <option value="1">Funge como certificado de origen</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>N&uacute;mero Certificado Origen: </label></div>
                    <div class="span7">
                        <input class="comercioExt" type="text" name="numCertificadoOrigen" id="numCertificadoOrigen" maxlength = "40" />
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>N&uacute;mero de Exportador Confiable: </label></div>
                    <div class="span7">
                        <input class="comercioExt" type="text" name="numExportadorConfiable" id="numExportadorConfiable" maxlength = "50" />
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Clave del INCOTERM: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="Incoterm" id="Incoterm">
                            <option value="">Seleccionar</option>
                            <option value="CFR">COSTE Y FLETE (PUERTO DE DESTINO CONVENIDO)</option>
                            <option value="CIF">COSTE, SEGURO Y FLETE (PUERTO DE DESTINO CONVENIDO)</option>
                            <option value="CPT">TRANSPORTE PAGADO HASTA (EL LUGAR DE DESTINO CONVENIDO)</option>
                            <option value="CIP">TRANSPORTE Y SEGURO PAGADOS HASTA (LUGAR DE DESTINO CONVENIDO)</option>
                            <option value="DAF">ENTREGADA EN FRONTERA (LUGAR CONVENIDO)</option>
                            <option value="DAP">ENTREGADA EN LUGAR</option>
                            <option value="DAT">ENTREGADA EN TERMINAL</option>
                            <option value="DES">ENTREGADA SOBRE BUQUE (PUERTO DE DESTINO CONVENIDO)</option>
                            <option value="DEQ">ENTREGADA EN MUELLE (PUERTO DE DESTINO CONVENIDO)</option>
                            <option value="DDU">ENTREGADA DERECHOS NO PAGADOS (LUGAR DE DESTINO CONVENIDO)</option>
                            <option value="DDP">ENTREGADA DERECHOS PAGADOS (LUGAR DE DESTINO CONVENIDO)</option>
                            <option value="EXW">EN FABRICA (LUGAR CONVENIDO)</option>
                            <option value="FCA">FRANCO TRANSPORTISTA (LUGAR DESIGNADO)</option>
                            <option value="FAS">FRANCO AL COSTADO DEL BUQUE (PUERTO DE CARGA CONVENIDO)</option>
                            <option value="FOB">FRANCO A BORDO (PUERTO DE CARGA CONVENIDO)</option>
                        </select>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Subdivisi&oacute;n: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="Subdivision" id="Subdivision">
                            <option value="">Seleccionar</option>
                            <option value="0">no tiene subdivisi&oacute;n</option>
                            <option value="1">si tiene subdivisi&oacute;n </option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Observaciones: </label></div>
                    <div class="span7">
                        <textarea class="comercioExt" name="ObservacionesComercioExt" id="ObservacionesComercioExt" maxlength = "300"></textarea>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Tipo Cambio USD: </label></div>
                    <div class="span7">
                        <input class="comercioExt" type="text" name="TipoCambioUSD" id="TipoCambioUSD" />
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Total USD: </label></div>
                    <div class="span7">
                        <input class="comercioExt" type="text" name="TotalUSD" id="TotalUSD" value="0" readonly="true" />
                    </div>
                </div>
            </div>
            <h4 class="blue">Emisor:</h4>
            <div class="Emisor row-fluid">
            	<div class="row">
	                <div class="span6">
	                    <div class="span5"><label>C.U.R.P. : </label></div>
	                    <div class="span7">
	                        <input type="text" name="curpEmisorComercioExt"  id="curpEmisorComercioExt" class="emisorComercioExt" />
	                    </div>
	                </div>
                </div>
                <div class="row">
                   <fieldset>
                       <legend>Domicilio</legend>
                       <div class="row-fluid">
                           <fieldset>
                               <div class="row">
                                   <div class="span6">
                                       <div class="span5"><label for="paisEmisorComercioExt">Pa&iacute;s</label></div>
                                       <div class="span7">
                                           <select class="domicilioEmisorComercioExt" name="paisEmisorComercioExt" id="paisEmisorComercioExt">
                                               <option value="default" selected>Seleccionar</option>
                                               <option value="MEX">México</option>
                                           </select>
                                       </div>
                                   </div>
                                   <div class="span6">
                                       <div class="span5"><label>Estado: </label></div>
                                       <div class="span7">
                                           <span class="divEstadoEmisorComercioExt">
                                               <select class="domicilioEmisorComercioExt" name="estadoEmisorComercioExt" id="estadoEmisorComercioExt">
                                               </select>
                                           </span>
                                           <span hidden class="divEstadoEmisorComercioExtAux">
                                               <input type="text" id="estadoEmisorComercioExtAux" name="estadoEmisorComercioExtAux" class="domicilioEmisorComercioExt" />
                                           </span>
                                       </div>
                                   </div>
                               </div>
                               <div class="row">
                                   <div class="span6">
                                       <div class="span5"><label>Municipio: </label></div>
                                       <div class="span7">
                                           <span class="divMunicipioEmisorComercioExt">
                                               <select class="domicilioEmisorComercioExt" name="municipioEmisorComercioExt" id="municipioEmisorComercioExt">
                                               </select>
                                           </span>
                                           <span hidden class="divMunicipioEmisorComercioExtAux">
                                               <input type="text" name="municipioEmisorComercioExtAux"  id="municipioEmisorComercioExtAux" class="domicilioEmisorComercioExt" maxlength = "120" />
                                           </span>
                                       </div>
                                   </div>
                                   <div class="span6">
	                                   <div class="span5"><label>Localidad: </label></div>
	                                   <div class="span7">
	                                       <span class="divLocalidadEmisorComercioExt">
	                                           <select class="domicilioEmisorComercioExt" name="localidadEmisorComercioExt" id="localidadEmisorComercioExt">
	                                           </select>
	                                       </span>
	                                       <span hidden class="divLocalidadEmisorComercioExtAux">
	                                           <input type="text" name="localidadEmisorComercioExtAux" id="localidadEmisorComercioExtAux" class="domicilioEmisorComercioExt" maxlength = "120" />
	                                       </span>
	                                   </div>
	                               </div>
                               </div>
                           </fieldset>
                       </div>
                       <fieldset>
                           <div class="row">
                               <div class="span6">
                                   <div class="span5"><label>C&oacute;digo Postal: </label></div>
                                   <div class="span7">
                                       <span class="divCodigoPostalEmisorComercioExt">
                                           <select class="domicilioEmisorComercioExt" name="codigoPostalEmisorComercioExt" id="codigoPostalEmisorComercioExt">
                                           </select>
                                       </span>
                                       <span hidden class="divCodigoPostalEmisorComercioExtAux">
                                           <input type="text" name="codigoPostalEmisorComercioExtAux"  id="codigoPostalEmisorComercioExtAux" class="domicilioEmisorComercioExt" maxlength = "120" />
                                       </span>
                                   </div>
                               </div>
                               <div class="span6">
                                   <div class="span5"><label>Colonia: </label></div>
                                   <div class="span7">
                                       <span class="divColoniaEmisorComercioExt">
                                           <select class="domicilioEmisorComercioExt" name="coloniaEmisorComercioExt" id="coloniaEmisorComercioExt">
                                           </select>
                                       </span>
                                       <span hidden class="divColoniaEmisorComercioExtAux">
                                           <input type="text" name="coloniaEmisorComercioExtAux"  id="coloniaEmisorComercioExtAux" class="domicilioEmisorComercioExt" maxlength = "120" />
                                       </span>
                                   </div>
                               </div>
                           </div>
                       </fieldset>
                       <fieldset>
                           <div class="row">
                               <div class="span6">
                                   <div class="span5"><label>Calle: </label></div>
                                   <div class="span7">
                                       <input type="text" name="calleEmisorComercioExt"  id="calleEmisorComercioExt" class="domicilioEmisorComercioExt" maxlength = "100" />
                                   </div>
                               </div>
                               <div class="span6">
                                   <div class="span5"><label>N&uacute;mero Exterior: </label></div>
                                   <div class="span7">
                                       <input type="text" name="numeroExteriorEmisorComercioExt"  id="numeroExteriorEmisorComercioExt" class="domicilioEmisorComercioExt" maxlength = "55" />
                                   </div>
                               </div>
                           </div>
                           <div class="row">
                           		<div class="span6">
                                    <div class="span5"><label>N&uacute;mero Interior: </label></div>
                                    <div class="span7">
                                        <input type="text" name="numeroInteriorEmisorComercioExt"  id="numeroInteriorEmisorComercioExt" class="domicilioEmisorComercioExt" maxlength = "55" />
                                    </div>
                                </div>
                               <div class="span6">
                                   <div class="span5"><label>Referencia: </label></div>
                                   <div class="span7">
                                       <input type="text" name="referenciaEmisorComercioExt"  id="referenciaEmisorComercioExt" class="domicilioEmisorComercioExt" maxlength = "250" />
                                   </div>
                               </div>
                           </div>
                       </fieldset>
                   </fieldset>
               </div>
            </div>
            <h4 class="blue">Propietario:</h4>
            <div class="Propietario row-fluid">
                <div class="span6">
                    <div class="span5"><label>N&uacute;mero de Identificaci&oacute;n o Registro fiscal: </label></div>
                    <div class="span7">
                        <input type="text" name="NumRegIdTribPropietarioComercioExt"  id="NumRegIdTribPropietarioComercioExt" class="propietarioComercioExt" maxlength = "40" />
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Residencia fiscal: </label></div>
                    <div class="span7">
                        <select class="propietarioComercioExt" name="ResidenciaFiscalPropietarioComercioExt" id="ResidenciaFiscalPropietarioComercioExt">
                        	<option value="" selected>Seleccionar</option>
                            <c:forEach items="${paises}" var="pais" >
								<option value="${pais.id}"}>${pais.nombre}</option>
							</c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="span2 offset9">
                        <a id="btnPropietario" class="btn btn-primary">Agregar</a>
                    </div>
                </div>
                <div id="mPropietario" class="overloadedTable clear separate">
					<table id="tablaPropietario" class="table-striped table-hover table-bordered text-center" style="display: none">
						<thead>
							<tr>
								<th class="span1">NumRegIdTrib</th>
								<th class="span1">ResidenciaFiscal</th>
								<th class="span1"></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
            </div>
            <h4 class="blue">Receptor:</h4>
            <div class="Receptor row-fluid">
                <div class="row">
                    <fieldset>
                        <legend>Domicilio</legend>
                        <div class="row-fluid">
                            <fieldset>
                                <div class="row">
                                    <div class="span6">
                                        <div class="span5"><label for="paisReceptorComercioExt">Pa&iacute;s</label></div>
                                        <div class="span7">
                                            <select class="domicilioReceptorComercioExt" name="paisReceptorComercioExt" id="paisReceptorComercioExt">
                                                <option value="default" selected>Seleccionar</option>
                                                <c:forEach items="${paises}" var="pais" >
													<option value="${pais.id}" ${pais.id eq 'MX' ? 'selected':''}>${pais.nombre}</option>
												</c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6">
                                        <div class="span5"><label>Estado: </label></div>
                                        <div class="span7">
                                            <span class="divEstadoReceptorComercioExt">
                                                <select class="domicilioReceptorComercioExt" name="estadoReceptorComercioExt" id="estadoReceptorComercioExt" maxlenght="30" >
                                                </select>
                                            </span>
                                            <span hidden class="divEstadoReceptorComercioExtAux">
                                                <input type="text" id="estadoReceptorComercioExtAux" name="estadoReceptorComercioExtAux" class="domicilioReceptorComercioExt" />
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="span6">
                                        <div class="span5"><label>Municipio: </label></div>
                                        <div class="span7">
                                            <span class="divMunicipioReceptorComercioExt">
                                                <select class="domicilioReceptorComercioExt" name="municipioReceptorComercioExt" id="municipioReceptorComercioExt">
                                                </select>
                                            </span>
                                            <span hidden class="divMunicipioReceptorComercioExtAux">
                                                <input type="text" name="municipioReceptorComercioExtAux"  id="municipioReceptorComercioExtAux" class="domicilioReceptorComercioExt" maxlength = "120" />
                                            </span>
                                        </div>
                                    </div>
                                    <div class="span6">
	                                    <div class="span5"><label>Localidad: </label></div>
	                                    <div class="span7">
	                                        <span class="divLocalidadReceptorComercioExt">
	                                            <select class="domicilioReceptorComercioExt" name="localidadReceptorComercioExt" id="localidadReceptorComercioExt">
	                                            </select>
	                                        </span>
	                                        <span hidden class="divLocalidadReceptorComercioExtAux">
	                                            <input type="text" name="localidadReceptorComercioExtAux" id="localidadReceptorComercioExtAux" class="domicilioReceptorComercioExt" maxlength = "120" />
	                                        </span>
	                                    </div>
	                                </div>
                                </div>
                            </fieldset>
                        </div>
                        <fieldset>
                            <div class="row">
                                <div class="span6">
                                    <div class="span5"><label>C&oacute;digo Postal: </label></div>
                                    <div class="span7">
                                        <span class="divCodigoPostalReceptorComercioExt">
                                            <select class="domicilioReceptorComercioExt" name="codigoPostalReceptorComercioExt" id="codigoPostalReceptorComercioExt">
                                            </select>
                                        </span>
                                        <span hidden class="divCodigoPostalReceptorComercioExtAux">
                                            <input type="text" name="codigoPostalReceptorComercioExtAux"  id="codigoPostalReceptorComercioExtAux" class="domicilioReceptorComercioExt" maxlength = "120" />
                                        </span>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="span5"><label>Colonia: </label></div>
                                    <div class="span7">
                                        <span class="divColoniaReceptorComercioExt">
                                            <select class="domicilioReceptorComercioExt" name="coloniaReceptorComercioExt" id="coloniaReceptorComercioExt">
                                            </select>
                                        </span>
                                        <span hidden class="divColoniaReceptorComercioExtAux">
                                            <input type="text" name="coloniaReceptorComercioExtAux"  id="coloniaReceptorComercioExtAux" class="domicilioReceptorComercioExt" maxlength = "120" />
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <fieldset>
                            <div class="row">
                                <div class="span6">
                                    <div class="span5"><label>Calle: </label></div>
                                    <div class="span7">
                                        <input type="text" name="calleReceptorComercioExt"  id="calleReceptorComercioExt" class="domicilioReceptorComercioExt" maxlength = "100" />
                                    </div>
                                </div>
                                <div class="span6">
                                   <div class="span5"><label>N&uacute;mero Exterior: </label></div>
                                   <div class="span7">
                                       <input type="text" name="numeroExteriorReceptorComercioExt"  id="numeroExteriorReceptorComercioExt" class="domicilioReceptorComercioExt" maxlength = "55" />
                                   </div>
                                </div>
                            </div>
                            <div class="row">
                            	<div class="span6">
                                    <div class="span5"><label>N&uacute;mero Interior: </label></div>
                                    <div class="span7">
                                        <input type="text" name="numeroInteriorReceptorComercioExt"  id="numeroInteriorReceptorComercioExt" class="domicilioReceptorComercioExt" maxlength = "55" />
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="span5"><label>Referencia: </label></div>
                                    <div class="span7">
                                        <input type="text" name="referenciaReceptorComercioExt"  id="referenciaReceptorComercioExt" class="domicilioReceptorComercioExt" maxlength = "250" />
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </fieldset>
                </div>
            </div>
            <h4 class="blue">Destinatario:</h4>
            <div class="Destinatario row-fluid">
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Identificaci&oacute;n o Registro fiscal: </label></div>
                        <div class="span7">
                            <input type="text" name="NumRegIdTribDestinatarioComercioExt"  id="NumRegIdTribDestinatarioComercioExt" class="destinatarioComercioExt" maxlength = "40" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Nombre: </label></div>
                        <div class="span7">
                            <textarea name="nombreDestinatarioComercioExt"  id="nombreDestinatarioComercioExt" class="destinatarioComercioExt" maxlength = "300"></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span2 offset9">
                        <a id="btnDestinatario" class="btn btn-primary">Agregar</a>
                    </div>
                </div>
                <div id="mDestinatario" class="overloadedTable clear separate">
					<table id="tablaDestinatario" class="table-striped table-hover table-bordered text-center" style="display: none">
						<thead>
							<tr>
								<th class="span1">NumRegIdTrib</th>
								<th class="span1">Nombre</th>
								<th class="span1"></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
                <div class="row">
                    <fieldset>
                        <legend>Domicilio</legend>
                        <div class="row-fluid">
                            <fieldset>
                                <div class="row">
                                    <div class="span6">
                                        <div class="span5"><label for="paisDestinatarioComercioExt">Pa&iacute;s</label></div>
                                        <div class="span7">
                                            <select class="domicilioDestinatarioComercioExt" name="paisDestinatarioComercioExt" id="paisDestinatarioComercioExt">
                                                <option value="default" selected>Seleccionar</option>
                                                <c:forEach items="${paises}" var="pais" >
													<option value="${pais.id}" ${pais.id eq 'MX' ? 'selected':''}>${pais.nombre}</option>
												</c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="span6">
                                        <div class="span5"><label>Estado: </label></div>
                                        <div class="span7">
                                            <span class="divEstadoDestinatarioComercioExt">
                                                <select class="domicilioDestinatarioComercioExt" name="estadoDestinatarioComercioExt" id="estadoDestinatarioComercioExt">
                                                </select>
                                            </span>
                                            <span hidden class="divEstadoDestinatarioComercioExtAux">
                                                <input type="text" id="estadoDestinatarioComercioExtAux" name="estadoDestinatarioComercioExtAux" class="domicilioDestinatarioComercioExt" maxlenght="30"/>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="span6">
                                        <div class="span5"><label>Municipio: </label></div>
                                        <div class="span7">
                                            <span class="divMunicipioDestinatarioComercioExt">
                                                <select class="domicilioDestinatarioComercioExt" name="municipioDestinatarioComercioExt" id="municipioDestinatarioComercioExt">
                                                </select>
                                            </span>
                                            <span hidden class="divMunicipioDestinatarioComercioExtAux">
                                                <input type="text" name="municipioDestinatarioComercioExtAux"  id="municipioDestinatarioComercioExtAux" class="domicilioDestinatarioComercioExt" maxlength = "120" />
                                            </span>
                                        </div>
                                    </div>
                                    <div class="span6">
	                                    <div class="span5"><label>Localidad: </label></div>
	                                    <div class="span7">
	                                        <span class="divLocalidadDestinatarioComercioExt">
	                                            <select class="domicilioDestinatarioComercioExt" name="localidadDestinatarioComercioExt" id="localidadDestinatarioComercioExt">
	                                            </select>
	                                        </span>
	                                        <span hidden class="divLocalidadDestinatarioComercioExtAux">
	                                            <input type="text" name="localidadDestinatarioComercioExtAux" id="localidadDestinatarioComercioExtAux" class="domicilioDestinatarioComercioExt" maxlength = "120" />
	                                        </span>
	                                    </div>
	                                </div>
                                </div>
                            </fieldset>
                        </div>
                        <fieldset>
                            <div class="row">
                                <div class="span6">
                                    <div class="span5"><label>C&oacute;digo Postal: </label></div>
                                    <div class="span7">
                                        <span class="divCodigoPostalDestinatarioComercioExt">
                                            <select class="domicilioDestinatarioComercioExt" name="codigoPostalDestinatarioComercioExt" id="codigoPostalDestinatarioComercioExt">
                                            </select>
                                        </span>
                                        <span hidden class="divCodigoPostalDestinatarioComercioExtAux">
                                            <input type="text" name="codigoPostalDestinatarioComercioExtAux"  id="codigoPostalDestinatarioComercioExtAux" class="domicilioDestinatarioComercioExt" maxlength = "120" />
                                        </span>
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="span5"><label>Colonia: </label></div>
                                    <div class="span7">
                                        <span class="divColoniaDestinatarioComercioExt">
                                            <select class="domicilioDestinatarioComercioExt" name="coloniaDestinatarioComercioExt" id="coloniaDestinatarioComercioExt">
                                            </select>
                                        </span>
                                        <span hidden class="divColoniaDestinatarioComercioExtAux">
                                            <input type="text" name="coloniaDestinatarioComercioExtAux"  id="coloniaDestinatarioComercioExtAux" class="domicilioDestinatarioComercioExt" maxlength = "120" />
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <fieldset>
                            <div class="row">
                                <div class="span6">
                                    <div class="span5"><label>Calle: </label></div>
                                    <div class="span7">
                                        <input type="text" name="calleDestinatarioComercioExt"  id="calleDestinatarioComercioExt" class="domicilioDestinatarioComercioExt" maxlength = "100" />
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="span5"><label>N&uacute;mero Exterior: </label></div>
                                    <div class="span7">
                                    	<input type="text" name="numeroExteriorDestinatarioComercioExt"  id="numeroExteriorDestinatarioComercioExt" class="domicilioDestinatarioComercioExt" maxlength = "55" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                            	<div class="span6">
                                    <div class="span5"><label>N&uacute;mero Interior: </label></div>
                                    <div class="span7">
                                        <input type="text" name="numeroInteriorDestinatarioComercioExt"  id="numeroInteriorDestinatarioComercioExt" class="domicilioDestinatarioComercioExt" maxlength = "55" />
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="span5"><label>Referencia: </label></div>
                                    <div class="span7">
                                        <input type="text" name="referenciaDestinatarioComercioExt"  id="referenciaDestinatarioComercioExt" class="domicilioDestinatarioComercioExt" maxlength = "250" />
                                    </div>
                                </div>
                            </div>
                            <div class="row">
			                    <div class="span2 offset9">
			                        <a id="btnDomicilioDestinatario" class="btn btn-primary">Agregar</a>
			                    </div>
			                </div>
			                <div id="mDomicilioDestinatario" class="overloadedTable clear separate">
								<table id="tablaDomicilioDestinatario" class="table-striped table-hover table-bordered text-center" style="display: none">
									<thead>
										<tr>
											<th class="span1">Pais</th>
											<th class="span1">Estado</th>
											<th class="span1">Municipio</th>
											<th class="span1">Localidad</th>
											<th class="span1">Código Postal</th>
											<th class="span1">Colonia</th>
											<th class="span1">Calle</th>
											<th class="span1">N.Ext.</th>
											<th class="span1">N.Int.</th>
											<th class="span1">Ref</th>
											<th class="span1"></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
                        </fieldset>
                    </fieldset>
                </div>
            </div><!-- accord group -->
            <h4 class="blue">Mercanc&iacute;a:</h4>
            <div class="Mercancias row-fluid">
                <div id="mInfoMercancia">
                    <table id="tablaInfoMercancia" class="table table-striped table-hover table-bordered text-center">
                        <thead>
                            <tr>
                                <th class="span1">N.Ident.</th>
                                <th class="span4">Fracci&oacute;n Arancelaria</th>
                                <th class="span1">Cantidad</th>
                                <th class="span1">Unidad</th>
                                <th class="span1">V.Unitario</th>
                                <th class="span1">V.Dolares</th>
                                <th class="span1">Marca</th>
                                <th class="span1">Modelo</th>
                                <th class="span1">SubModelo</th>
                                <th class="span1">N.Serie</th>
                                <th class="span1"></th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Identificaci&oacute;n: </label></div>
                        <div class="span7">
                            <input type="text" name="NoIdentificacionMercanciaComercioExt"  id="NoIdentificacionMercanciaComercioExt" class="mercanciaComercioExt" maxlength = "100" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Fracci&oacute;n Arancelaria: </label></div>
                        <div class="span7">
                            <select class="mercanciaComercioExt" name="FraccionArancelariaMercanciaComercioExt" id="FraccionArancelariaMercanciaComercioExt">
                                <option value="default">Seleccionar</option>
                                <c:forEach items="${fraccionesArancelarias}" var="fraccionArancelaria" >
                                <option value="${fraccionArancelaria.codigo}">${fraccionArancelaria.codigo} - ${fraccionArancelaria.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>Cantidad Aduana: </label></div>
                        <div class="span7">
                            <input type="text" name="CantidadAduanaMercanciaComercioExt"  id="CantidadAduanaMercanciaComercioExt" class="mercanciaComercioExt" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Unidad Aduana: </label></div>
                        <div class="span7">
                            <select class="mercanciaComercioExt" name="UnidadAduanaMercanciaComercioExt" id="UnidadAduanaMercanciaComercioExt">
                                <option value="default">Seleccionar</option>
                                <c:forEach items="${unidadesMedidaComercioExt}" var="unidadMedida" >
                                <option value="${unidadMedida.codigo}">${unidadMedida.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>Valor Unitario Aduana: </label></div>
                        <div class="span7">
                            <input type="text" name="ValorUnitarioAduanaMercanciaComercioExt"  id="ValorUnitarioAduanaMercanciaComercioExt" class="mercanciaComercioExt" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Valor Dolares: </label></div>
                        <div class="span7">
                            <input type="text" name="ValorDolaresMercanciaComercioExt"  id="ValorDolaresMercanciaComercioExt" class="mercanciaComercioExt" readonly="true"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span2 offset9">
                        <a id="btnMercancias" class="btn btn-primary">Agregar</a>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <fieldset>
                    <legend>Descripciones Espec&iacute;ficas</legend>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Marca: </label></div>
                            <div class="span7">
                                <input type="text" name="marcaDescripcionComercioExt"  id="marcaDescripcionComercioExt" class="descripcionEspecificaComercioExt" maxlength = "35" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Modelo: </label></div>
                            <div class="span7">
                                <input type="text" name="modeloDescripcionComercioExt"  id="modeloDescripcionComercioExt" class="descripcionEspecificaComercioExt" maxlength = "80" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                            <div class="span6">    
                            <div class="span5"><label>Submodelo: </label></div>
                            <div class="span7">
                                <input type="text" name="submodeloDescripcionComercioExt"  id="submodeloDescripcionComercioExt" class="descripcionEspecificaComercioExt" maxlength = "50" />
                            </div>
                            </div>
                            <div class="span6">
                            <div class="span5"><label>N&uacute;mero de Serie: </label></div>
                            <div class="span7">
                                <input type="text" name="numeroSerieDescripcionComercioExt"  id="numeroSerieDescripcionComercioExt" class="descripcionEspecificaComercioExt" maxlength = "40" />
                            </div>
                            </div>
                    </div>
                    <div class="row">
                        <div class="span2 offset9">
                            <a id="btnDescripcionesEspecificas" class="btn btn-primary">Agregar</a>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
    </div><!-- accord inner -->
</div><!-- accord group -->