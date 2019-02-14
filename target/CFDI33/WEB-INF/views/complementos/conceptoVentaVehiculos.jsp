<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseVentaVehiculos">
            Complemento Concepto de Venta de Veh&iacute;culos
        </a>
    </div>
    <div id="collapseVentaVehiculos" class="accordion-body collapse">
        <div class="accordion-inner row-fluid">
            <div class="row">
                <div class="span6">
                    <div class="span5"><label>Clave Vehicular</label></div>
                    <div class="span7">
                        <input type="text" id="ClaveVehicularVentaVehiculos" name="ClaveVehicularVentaVehiculos" class="ventaVehiculos" />
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Niv</label></div>
                    <div class="span7">
                        <input type="text" id="NivVentaVehiculos" name="NivVentaVehiculos" class="ventaVehiculos" />
                    </div>
                </div>
            </div>
            <fieldset>
                <legend>Informaci&oacute;n Aduanera:</legend>
                <div class="row">
                    <h4 class="blue">Informaci&oacute;n Aduanera:</h4>
                    <div id="mInfoAduaneraVentaVehiculos">
                        <table id="tablaInfoAduaneraVentaVehiculos" class="table table-striped table-hover table-bordered text-center">
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
                                <input type="text" class="informacionAduaneraVentaVehiculos" id="numeroVentaVehiculos" name="numeroVentaVehiculos" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Fecha Expedici&oacute;n Documento Aduanero:</label></div>
                            <div class="span6">
                                <div id="mfechaAprobacion" class="input-append">
                                    <input type="text" id="fechaExpDocAduaneroVentaVehiculos" name="fechaExpDocAduaneroVentaVehiculos" class="informacionAduaneraVentaVehiculos">
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
                                <input type="text" class="informacionAduaneraVentaVehiculos" id="aduanaVentaVehiculos" name="aduanaVentaVehiculos" />
                            </div>
                        </div>
                        <div class="span2 offset3">
                            <input type="button" id="addInfoAduaneraVentaVehiculos" value="Agregar" class="btn btn-primary" />
                        </div>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Parte:</legend>
                <div>
                    <h4 class="blue">Parte:</h4>
                    <div id="mParte">
                        <table id="tablaParte" class="table table-striped table-hover table-bordered text-center">
                            <thead>
                                <tr>
                                    <th class="span1">Cantidad</th>
                                    <th class="span1">Unidad</th>
                                    <th class="span4">N&uacute;mero de Identificaci&oacute;n</th>
                                    <th class="span4">Descripci&oacute;n</th>
                                    <th class="span4">Valor Unitario</th>
                                    <th class="span4">Importe</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Cantidad:</label></div>
                            <div class="span7">
                                <input type="text" class="parteVentaVehiculos" id="cantidadParteVentaVehiculos" name="cantidadParteVentaVehiculos" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Unidad:</label></div>
                            <div class="span7">
                                <input type="text" class="parteVentaVehiculos" id="unidadParteVentaVehiculos" name="unidadParteVentaVehiculos" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>N&uacute;mero de Identificaci&oacute;n:</label></div>
                            <div class="span7">
                                <input type="text" class="parteVentaVehiculos" id="noIdentificacionParteVentaVehiculos" name="noIdentificacionParteVentaVehiculos" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Descripci&oacute;n:</label></div>
                            <div class="span7">
                                <input type="text" class="parteVentaVehiculos" id="descripcionParteVentaVehiculos" name="descripcionParteVentaVehiculos" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Valor Unitario:</label></div>
                            <div class="span7">
                                <input type="text" class="parteVentaVehiculos" id="valorUnitarioParteVentaVehiculos" name="valorUnitarioParteVentaVehiculos" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Importe:</label></div>
                            <div class="span7">
                                <input type="text" class="parteVentaVehiculos" id="importeParteVentaVehiculos" name="importeParteVentaVehiculos" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span2 offset9">
                            <input type="button" id="addParteVentaVehiculos" value="Agregar" class="btn btn-primary" />
                        </div>
                    </div>
                    <fieldset>
                        <div class="row">
                            <!-- <label>Informaci&oacute;n Aduanera Partes o Componentes:</label> -->
                            <h4 class="blue">Informaci&oacute;n Aduanera Partes o Componentes:</h4>
                            <div id="mInfoAduaneraVentaVehiculos">
                                <table id="tablaInfoAduaneraParteVentaVehiculos" class="table table-striped table-hover table-bordered text-center">
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
                                        <input type="text" class="informacionAduaneraParteVentaVehiculos" id="numeroParteVentaVehiculos" name="numeroParteVentaVehiculos" />
                                    </div>
                                </div>
                                <div class="span6">
                                    <div class="span5"><label>Fecha Expedici&oacute;n Documento Aduanero:</label></div>
                                    <div class="span6">
                                        <div id="mfechaAprobacion" class="input-append">
                                            <input type="text" id="fechaExpDocAduaneroParteVentaVehiculos" name="fechaExpDocAduaneroParteVentaVehiculos" class="informacionAduaneraParteVentaVehiculos">
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
                                        <input type="text" class="informacionAduaneraParteVentaVehiculos" id="aduanaParteVentaVehiculos" name="aduanaParteVentaVehiculos" />
                                    </div>
                                </div>
                                <div class="span2 offset3">
                                    <input type="button" id="addInfoAduaneraParteVentaVehiculos" value="Agregar" class="btn btn-primary" />
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </fieldset>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->