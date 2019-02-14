<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseCuentaTerceros">
            Complemento Concepto Por Cuenta de Terceros
        </a>
    </div>
    <div id="collapseCuentaTerceros" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>R.F.C.</label></div>
                        <div class="span7">
                            <input type="text" name="rfcCuentaTerceros" id="rfcCuentaTerceros" class="cuentaTerceros" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Nombre: </label></div>
                        <div class="span7">
                            <input type="text" name="nombreCuentaTerceros" id="nombreCuentaTerceros" class="cuentaTerceros" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <legend>Informaci&oacute;n Fiscal</legend>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>Calle:</label></div>
                        <div class="span7">
                            <input type="text" class="cuentaTercerosInformacionFiscal" name="calleCuentaTerceros" id ="calleCuentaTerceros" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>No. Exterior:</label></div>
                        <div class="span7">
                            <input type="text" class="cuentaTercerosInformacionFiscal" name="noExteriorCuentaTerceros" id ="noExteriorCuentaTerceros" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>No. Interior:</label></div>
                        <div class="span7">
                            <input type="text" class="cuentaTercerosInformacionFiscal" name="noInteriorCuentaTerceros" id ="noInteriorCuentaTerceros" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Colonia:</label></div>
                        <div class="span7">
                            <input type="text" class="cuentaTercerosInformacionFiscal" name="coloniaCuentaTerceros" id ="coloniaCuentaTerceros" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>Localidad:</label></div>
                        <div class="span7">
                            <input type="text" class="cuentaTercerosInformacionFiscal" name="localidadCuentaTerceros" id ="localidadCuentaTerceros" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Referencia:</label></div>
                        <div class="span7">
                            <input type="text" class="cuentaTercerosInformacionFiscal" name="referenciaCuentaTerceros" id ="referenciaCuentaTerceros" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>Municipio:</label></div>
                        <div class="span7">
                            <input type="text" class="cuentaTercerosInformacionFiscal" name="municipioCuentaTerceros" id ="municipioCuentaTerceros" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Estado:</label></div>
                        <div class="span7">
                            <select class="cuentaTercerosInformacionFiscal" name="estadoCuentaTerceros" id="estadoCuentaTerceros">
                                <option value="default">Seleccionar</option>
                                <option value="Fuera de México">Fuera de M&eacute;xico</option>
                                <c:forEach items="${estados}" var="estado" >
                                <option value="${estado.nombre}">${estado.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>Pa&iacute;s:</label></div>
                        <div class="span7">
                            <select class="cuentaTercerosInformacionFiscal" name="paisCuentaTerceros" id="paisCuentaTerceros">
                                <option value="default">Seleccionar</option>
                                <c:forEach items="${paises}" var="pais" >
                                <option value="${pais.nombre}" ${pais.id eq 'MX' ? 'selected':''}>${pais.nombre}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                        <div class="span6">
                            <div class="span5"><label>C&oacute;digo Postal:</label></div>
                            <div class="span7">
                                <input type="text" class="cuentaTercerosInformacionFiscal" name="codigoPostalCuentaTerceros" maxlength="5" id ="codigoPostalCuentaTerceros" />
                            </div>
                        </div>
                </div>
            </div>
            <div class="row-fluid">
                <fieldset>
                    <legend>Informaci&oacute;n Aduanera</legend>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>N&uacute;mero del Documento Aduanero:</label></div>
                            <div class="span7">
                                <input type="text" class="cuentaTercerosInformacionAduanera" id="numeroCuentaTerceros" name="numeroCuentaTerceros" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Fecha Expedici&oacute;n Documento Aduanero:</label></div>
                            <div class="span6">
                                <div id="mfechaAprobacion" class="input-append">
                                    <input type="text" id="fechaExpDocAduaneroCuentaTerceros" name="fechaExpDocAduaneroCuentaTerceros" class="cuentaTercerosInformacionAduanera" readonly="readonly">
                                    <span class="add-on">
                                        <i class="icon-calendar"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Aduana:</label></div>
                            <div class="span7">
                                <input type="text" class="cuentaTercerosInformacionAduanera" id="aduanaCuentaTerceros" name="aduanaCuentaTerceros" />
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="row-fluid">
                <fieldset>
                    <legend>Parte:</legend>
                    <h4 class="blue">Parte:</h4>
                    <div id="mParteCuentaTerceros">
                        <table id="tablaParteCuentaTerceros" class="table table-striped table-hover table-bordered text-center">
                            <thead>
                                <tr>
                                    <th class="span1">Cantidad</th>
                                    <th class="span1">Unidad</th>
                                    <th class="span4">N&uacute;mero de Identificación</th>
                                    <th class="span4">Descripci&oacute;n</th>
                                    <th class="span4">Valor Unitario</th>
                                    <th class="span4">Importe</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div class="row-fluid">
                        <div class="row">
                            <div class="span6">
                                <div class="span5"><label>Cantidad:</label></div>
                                <div class="span7">
                                    <input type="text" class="parteCuentaTerceros" id="cantidadCuentaTerceros" name="cantidadCuentaTerceros" />
                                </div>
                            </div>
                            <div class="span6">
                                <div class="span5"><label>Unidad:</label></div>
                                <div class="span7">
                                    <input type="text" class="parteCuentaTerceros" id="unidadCuentaTerceros" name="unidadCuentaTerceros" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="span6">
                                <div class="span5"><label>N&uacute;mero de Identificaci&oacute;n:</label></div>
                                <div class="span7">
                                    <input type="text" class="parteCuentaTerceros" id="noIdentificacionCuentaTerceros" name="noIdentificacionCuentaTerceros" />
                                </div>
                            </div>
                            <div class="span6">
                                <div class="span5"><label>Descripci&oacute;n:</label></div>
                                <div class="span7">
                                    <input type="text" class="parteCuentaTerceros" id="descripcionCuentaTerceros" name="descripcionCuentaTerceros" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="span6">
                                <div class="span5"><label>Valor Unitario:</label></div>
                                <div class="span7">
                                    <input type="text" class="parteCuentaTerceros" id="valorUnitarioParteCuentaTerceros" name="valorUnitarioParteCuentaTerceros" />
                                </div>
                            </div>
                            <div class="span6">
                                <div class="span5"><label>Importe:</label></div>
                                <div class="span7">
                                    <input type="text" class="parteCuentaTerceros" id="importeParteCuentaTerceros" name="importeParteCuentaTerceros" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="span2 offset9">
                                <input type="button" id="addParteCuentaTerceros" value="Agregar" class="btn btn-primary" />
                            </div>
                        </div>
                        <div>
                            <fieldset>
                                <%-- <label>Informaci&oacute;n Aduanera Partes o Componentes:</label> --%>
                                <h4 class="blue">Informaci&oacute;n Aduanera Partes o Componentes:</h4>
                                <div id="mInfoAduaneraPartesCuentaTerceros">
                                    <table id="tablaInfoAduaneraParteCuentaTerceros" class="table table-striped table-hover table-bordered text-center">
                                        <thead>
                                            <tr>
                                                <th class="span1">N&uacute;mero</th>
                                                <th class="span1">Fecha</th>
                                                <th class="span4">Aduana</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="row">
                                    <div class="span6">
                                        <div class="span5"><label>N&uacute;mero del Documento Aduanero:</label></div>
                                        <div class="span7">
                                            <input type="text" class="informacionAduaneraParteCuentaTerceros" id="numeroParteCuentaTerceros" name="numeroParteCuentaTerceros" />
                                        </div>
                                    </div>
                                    <div class="span6">
                                        <div class="span5"><label>Fecha Expedici&oacute;n Documento Aduanero:</label></div>
                                        <div class="span6">
                                            <div id="mfechaAprobacion" class="input-append">
                                                <input type="text" id="fechaExpDocAduaneroParteCuentaTerceros" name="fechaExpDocAduaneroParteCuentaTerceros" class="informacionAduaneraParteCuentaTerceros" readonly="readonly">
                                                <span class="add-on">
                                                    <i class="icon-calendar"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="span6">
                                        <div class="span5"><label>Aduana:</label></div>
                                        <div class="span7">
                                            <input type="text" class="informacionAduaneraParteCuentaTerceros" id="aduanaParteCuentaTerceros" name="aduanaParteCuentaTerceros" />
                                        </div>
                                    </div>
                                    <div class="span2 offset3">
                                        <input type="button" id="addInfoAduaneraParteCuentaTerceros" value="Agregar" class="btn btn-primary" />
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="row-fluid">
                <fieldset>
                    <legend>Cuenta Predial</legend>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>N&uacute;mero:</label></div>
                            <div class="span7">
                                <input type="text" class="cuentaPredialTerceros" id="numeroCuentaPredialTerceros" name="numeroCuentaPredialTerceros" />
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="row-fluid">
                <fieldset>
                    <legend>Impuestos:</legend>
                    <h4 class="blue">Retenciones:</h4>
                    <div id="mRetencionesCuentaTerceros">
                        <table id="tablaRetencionesCuentaTerceros" class="table table-striped table-hover table-bordered text-center">
                            <thead>
                                <tr>
                                    <th class="span1">Impuesto</th>
                                    <th class="span4">Importe</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Tipo Impuesto:</label></div>
                            <div class="span7">
                                <select id="impuestoRetencionesCuentaTerceros" name="impuestoRetencionesCuentaTerceros" class="retencionesCuentaTerceros">
                                    <option>ISR</option>
                                    <option>IVA</option>
                                </select>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Importe:</label></div>
                            <div class="span7">
                                <input type="text" class="retencionesCuentaTerceros" id="importeRetencionesCuentaTerceros" name="importeRetencionesCuentaTerceros" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span2 offset9">
                            <input type="button" id="addRetencionCuentaTerceros" value="Agregar" class="btn btn-primary" />
                        </div>
                    </div>
                    <h4 class="blue">Traslados:</h4>
                    <div id="mTrasladosCuentaTerceros">
                        <table id="tablaTrasladosCuentaTerceros" class="table table-striped table-hover table-bordered text-center">
                            <thead>
                                <tr>
                                    <th class="span1">Impuesto</th>
                                    <th class="span1">Tasa</th>
                                    <th class="span4">Importe</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Impuesto:</label></div>
                            <div class="span7">
                                <select id="impuestoTrasladosCuentaTerceros" name="impuestoTrasladosCuentaTerceros" class="trasladosCuentaTerceros">
                                    <option>IVA</option>
                                    <option>IEPS</option>
                                </select>
                            </div>
                        </div>
                        <div class="span6">     
                            <div class="span5"><label>Tasa:</label></div>
                            <div class="span7">
                                <input type="text" class="trasladosCuentaTerceros" id="tasaTrasladosCuentaTerceros" name="tasaTrasladosCuentaTerceros" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Importe:</label></div>
                            <div class="span7">
                                <input type="text" class="trasladosCuentaTerceros" id="importeTrasladosCuentaTerceros" name="importeTrasladosCuentaTerceros" />
                            </div>
                        </div>
                        <div class="span2 offset3">
                            <input type="button" id="addTrasladoCuentaTerceros" value="Agregar" class="btn btn-primary" />
                        </div>
                    </div>
                </fieldset>
            </div>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->