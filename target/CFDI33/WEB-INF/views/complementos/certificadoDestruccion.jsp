<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseCertDestruccion">
            Complemento Certificado de Destrucci&oacute;n
        </a>
    </div>
    <div id="collapseCertDestruccion" class="accordion-body collapse">
        <div class="accordion-inner">
            <fieldset>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Serie: </label></div>
                        <div class="span7">
                            <select class="certDestruccion" name="tipoSerie" id="tipoSerie">
                                <option value="">Seleccionar</option>
                                <option value="SERIE A"> Para veh&iacute;culos usados propiedad de personas f&iacute;sicas dedicadas al autotransporte federal de carga, de pasajeros o de turismo que no sean permisionarios propietarios de m&aacute;s de cinco unidades  </option>
                                <option value="SERIE B"> Para veh&iacute;culos usados propiedad de personas f&iacute;sicas dedicadas al autotransporte federal de carga, de pasajeros o de turismo que sean permisionarios propietarios de m&aacute;s de cinco unidades  </option>
                                <option value="SERIE C"> Para veh&iacute;culos usados propiedad de personas morales dedicadas al autotransporte federal de carga, de pasajeros o de turismo  </option>
                                <option value="SERIE D"> Para veh&iacute;culos usados propiedad de personas f&iacute;sicas o morales que sean permisionarios o concesionarios del servicio p&uacute;blico de autotransporte de pasajeros urbano o suburbano  </option>
                                <option value="SERIE E"> Para veh&iacute;culos usados propiedad de personas f&iacute;sicas que no sometieron a las formalidades aduaneras veh&iacute;culos usados de procedencia extranjera para importaci&oacute;n definitiva  </option>
                            </select>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de folio: </label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" name="numFolDesVeh" id="numFolDesVeh" maxlength="20" />
                        </div>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Veh&iacute;culo Destruido</legend>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Marca:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="marcaCertDest" name="marcaCertDest" maxlength="50" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Tipo o Clase:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="tipooClase" name="tipooClase" maxlength="50" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>A&ntilde;o:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="anioCertDest" name="anioCertDest" maxlength="4" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Modelo:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="modeloCertDest" name="modeloCertDest" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>NIV:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="nivCertDest" name="nivCertDest" maxlength="17" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Serie:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="numSerieCertDest" name="numSerieCertDest" maxlength="17" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Placas:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="numPlacasCertDest" name="numPlacasCertDest" maxlength="10" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Motor:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="numMotorCertDest" name="numMotorCertDest" maxlength="17" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Folio Tarjeta de Circulaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" class="certDestruccion" id="numFolTarjCir" name="numFolTarjCir" maxlength="40" />
                        </div>
                    </div>
                </div>
            </fieldset>
            <div class="row">
                <fieldset>
                    <legend>Informaci&oacute;n Aduanera</legend>
                    <fieldset>
                        <div class="row-fluid">
                            <div class="span6">
                                <div class="span5"><label>N&uacute;mero Pedimento Importaci&oacute;n:</label></div>
                                <div class="span7">
                                    <input type="text" class="certDestruccion" id="numPedImp" name="numPedImp" maxlength="40" />
                                </div>
                            </div>
                            <div class="span6">
                                <div class="span5"><label>Fecha:</label></div>
                                <div class="span7">
                                    <div id="mfechaCertDest" class="input-append">
                                        <input type="text" type="text" id="fechaCertDest" name="fechaCertDest" class="certDestruccion" />
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
                                    <input type="text" class="certDestruccion" id="aduanaCertDest" name="aduanaCertDest" />
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </fieldset>
            </div>
        </div>
    </div><!-- accord inner -->
</div><!-- accord group -->