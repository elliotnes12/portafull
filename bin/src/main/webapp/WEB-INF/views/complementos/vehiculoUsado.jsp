<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseVehiculoUsado">
            Complemento Veh&iacute;culo Usado
        </a>
    </div>
    <div id="collapseVehiculoUsado" class="accordion-body collapse">
        <div class="accordion-inner">
            <fieldset>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Monto Adquisici&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" name="montoAdquisicion" id="montoAdquisicion" class="vehiculoUsado"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Monto Enajenaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" name="montoEnajenacion" id="montoEnajenacion" class="vehiculoUsado"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Clave Vehicular:</label></div>
                        <div class="span7">
                            <input type="text" name="claveVehicular" maxlength="7" id="claveVehicular" class="vehiculoUsado"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Marca:</label></div>
                        <div class="span7">
                            <input type="text" name="marca" id="marca" maxlength="50" class="vehiculoUsado"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Tipo:</label></div>
                        <div class="span7">
                            <input type="text" name="tipo" id="tipo" maxlength="50" class="vehiculoUsado"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Modelo:</label></div>
                        <div class="span7">
                            <input type="text" name="modelo" id="modelo" class="vehiculoUsado"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero Motor:</label></div>
                        <div class="span7">
                            <input type="text" name="numeroMotor" id="numeroMotor" maxlength="17" class="vehiculoUsado"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero Serie:</label></div>
                        <div class="span7">
                            <input type="text" name="numeroSerie" id="numeroSerie" maxlength="17" class="vehiculoUsado"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>NIV:</label></div>
                        <div class="span7">
                            <input type="text" name="NIV" id="NIV" maxlength="17" class="vehiculoUsado"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Valor:</label></div>
                        <div class="span7">
                            <input type="text" name="valor" id="valor" class="vehiculoUsado"/>
                        </div>
                    </div>
                </div>
            </fieldset>
        </div><!-- accord inner -->
        <fieldset>
            <legend>Informaci&oacute;n Aduanera:</legend>
            <div class="row">
                <h4 class="blue">Informaci&oacute;n Aduanera:</h4>
                <div id="mInfoAduanera">
                    <table id="tablaInfoAduanera" class="table table-striped table-hover table-bordered text-center">
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
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero del Documento Aduanero:</label></div>
                        <div class="span7">
                            <input type="text" class="informacionAduanera" id="numero" name="numero"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Fecha Expedici&oacute;n Documento Aduanero:</label></div>
                        <div class="span6">
                            <div id="mfechaAprobacion" class="input-append">
                                <input type="text" id="fechaExpDocAduanero" name="fechaExpDocAduanero" class="informacionAduanera" readonly="readonly" />
                                <span class="add-on">
                                    <i class="icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Aduana:</label></div>
                        <div class="span7">
                            <input type="text" class="informacionAduanera" id="aduana" name="aduana">
                        </div>
                    </div>
                    <div class="span3 offset3">
                        <input type="button" id="addInfoAduanera" value="Agregar" class="btn btn-primary" />
                    </div>
                </div>
            </div>
        </fieldset>
    </div>
</div><!-- accord group -->