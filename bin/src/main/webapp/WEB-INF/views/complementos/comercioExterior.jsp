<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseComercioExt">
            Complemento Comercio Exterior
        </a>
    </div>
    <div id="collapseComercioExt" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Tipo Operaci&oacute;n: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="tipoOperacionComercioExt" id="tipoOperacionComercioExt">
                            <option value="">Seleccionar</option>
                            <option value="A">Exportaci&oacute;n de servicios </option>
                            <option value="2">Exportaci&oacute;n </option>
                        </select>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Clave de Pedimento: </label></div>
                    <div class="span7">
                        <select class="comercioExt" name="clavePedimento" id="clavePedimento">
                            <option value="">Seleccionar</option>
                            <option value="A1">IMPORTACION O EXPORTACION DEFINITIVA</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
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
                <div class="span6">
                    <div class="span5"><label>N&uacute;mero Certificado Origen: </label></div>
                    <div class="span7">
                        <input class="comercioExt" type="text" name="numCertificadoOrigen" id="numCertificadoOrigen" maxlength = "40" />
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>N&uacute;mero de Exportador Confiable: </label></div>
                    <div class="span7">
                        <input class="comercioExt" type="text" name="numExportadorConfiable" id="numExportadorConfiable" maxlength = "50" />
                    </div>
                </div>
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
            </div>
            <div class="row-fluid">
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
                <div class="span6">
                    <div class="span5"><label>C.U.R.P. : </label></div>
                    <div class="span7">
                        <input type="text" name="curpEmisorComercioExt"  id="curpEmisorComercioExt" class="emisorComercioExt" />
                    </div>
                </div>
            </div>
            <h4 class="blue">Receptor:</h4>
            <div class="Receptor row-fluid">
                <div class="span6">
                    <div class="span5"><label>C.U.R.P. : </label></div>
                    <div class="span7">
                        <input type="text" name="curpReceptorComercioExt"  id="curpReceptorComercioExt" class="receptorComercioExt" />
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>N&uacute;mero de Identificaci&oacute;n o Registro fiscal: </label></div>
                    <div class="span7">
                        <input type="text" name="NumRegIdTribReceptorComercioExt"  id="NumRegIdTribReceptorComercioExt" class="receptorComercioExt" maxlength = "40" />
                    </div>
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
                        <div class="span5"><label>R.F.C. : </label></div>
                        <div class="span7">
                            <input type="text" name="rfcDestinatarioComercioExt"  id="rfcDestinatarioComercioExt" class="destinatarioComercioExt" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>C.U.R.P. : </label></div>
                        <div class="span7">
                            <input type="text" name="curpDestinatarioComercioExt"  id="curpDestinatarioComercioExt" class="destinatarioComercioExt" />
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
                                                <input type="text" id="estadoDestinatarioComercioExtAux" name="estadoDestinatarioComercioExtAux" class="domicilioDestinatarioComercioExt" />
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
                                </div>
                            </fieldset>
                        </div>
                        <fieldset>
                            <div class="row">
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
                            </div>
                            <div class="row">
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
                                    <div class="span6">
                                        <div class="span6"><label>N&uacute;mero Exterior: </label></div>
                                        <div class="span6">
                                            <input type="text" name="numeroExteriorDestinatarioComercioExt"  id="numeroExteriorDestinatarioComercioExt" class="domicilioDestinatarioComercioExt" maxlength = "55" />
                                        </div>
                                    </div>
                                    <div class="span6">
                                        <div class="span6"><label>N&uacute;mero Interior: </label></div>
                                        <div class="span6">
                                            <input type="text" name="numeroInteriorDestinatarioComercioExt"  id="numeroInteriorDestinatarioComercioExt" class="domicilioDestinatarioComercioExt" maxlength = "55" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="span6">
                                    <div class="span5"><label>Referencia: </label></div>
                                    <div class="span7">
                                        <input type="text" name="referenciaDestinatarioComercioExt"  id="referenciaDestinatarioComercioExt" class="domicilioDestinatarioComercioExt" maxlength = "250" />
                                    </div>
                                </div>
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
                                <th class="span1">N. Ident.</th>
                                <th class="span4">Fracci&oacute;n Arancelaria</th>
                                <th class="span1">Cantidad</th>
                                <th class="span1">Unidad</th>
                                <th class="span1">Valor Unitario</th>
                                <th class="span1">Valor Dolares</th>
                                <th class="span1">Marca</th>
                                <th class="span1">Modelo</th>
                                <th class="span1">SubModelo</th>
                                <th class="span1">N. Serie</th>
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
                        <div class="span5"><label>Valor UnitarioAduana: </label></div>
                        <div class="span7">
                            <input type="text" name="ValorUnitarioAduanaMercanciaComercioExt"  id="ValorUnitarioAduanaMercanciaComercioExt" class="mercanciaComercioExt" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Valor Dolares: </label></div>
                        <div class="span7">
                            <input type="text" name="ValorDolaresMercanciaComercioExt"  id="ValorDolaresMercanciaComercioExt" class="mercanciaComercioExt" />
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