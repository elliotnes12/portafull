<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseECC">
            Complemento Estado de Cuenta de Combustibles para Monederos Electr&oacute;nicos Autorizados por el SAT
        </a>
    </div>
    <div id="collapseECC" class="accordion-body collapse">
        <div class="accordion-inner">
            <fieldset>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Tipo Operaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" name="tipoOperacionECC11"  id="tipoOperacionECC11" class="ecc11" value="Tarjeta" readonly="true" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Cuenta:</label></div>
                        <div class="span7">
                            <input type="text" id= "numeroDeCuentaECC11" name="numeroDeCuentaECC11"  class="ecc11" maxlength="50" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Subtotal:</label></div>
                        <div class="span7">
                            <input type="text" id="subTotalCombustiblesECC11" name="subTotalCombustiblesECC11" value="0" readonly="true" class="ecc11" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Total:</label></div>
                        <div class="span7">
                            <input type="text" name="totalCombustiblesECC11" id="totalCombustiblesECC11" value="0" readonly="true" class="ecc11" />
                        </div>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Conceptos Cubiertos:</legend>
                <h4 class="blue">Conceptos Complemento Combustible:</h4>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Identificador:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id ="identificadorECC11" name="identificadorECC11" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span3"><label>Fecha:</label></div>
                        <div class="span4">
                            <div id="mfechaAprobacion" class="input-append">
                                <input type="text" class="conceptoConsumoCombustiblesECC11" id="fechaExpOperECC11" name="fechaExpOperECC11" />
                                <span class="add-on">
                                    <i class="icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                        <div class="span4 offset1">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" name="horaConsumoCombustiblesECC11" id="horaConsumoCombustiblesECC11" placeholder="hh:mm:ss" maxlength="8" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>R.F.C.:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id="rfcEnajCombustibleECC11" name="rfcEnajCombustibleECC11" maxlength="13"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Clave Estaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id="claveEstacionECC11" name="claveEstacionECC11" maxlength="10" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>TAR:</label></div>
                        <div class="span7">
                            <select id="tar" name="tar" class="conceptoConsumoCombustiblesECC11">
                        <option value="">Seleccionar</option>
                        <option>617</option>
                        <option>619</option>
                        <option>624</option>
                        <option>652</option>
                        <option>654</option>
                        <option>655</option>
                        <option>656</option>
                        <option>658</option>
                        <option>659</option>
                        <option>660</option>
                        <option>661</option>
                        <option>667</option>
                        <option>693</option>
                        <option>602</option>
                        <option>603</option>
                        <option>604</option>
                        <option>605</option>
                        <option>606</option>
                        <option>607</option>
                        <option>608</option>
                        <option>609</option>
                        <option>611</option>
                        <option>612</option>
                        <option>613</option>
                        <option>614</option>
                        <option>615</option>
                        <option>620</option>
                        <option>621</option>
                        <option>622</option>
                        <option>623</option>
                        <option>625</option>
                        <option>657</option>
                        <option>664</option>
                        <option>665</option>
                        <option>666</option>
                        <option>669</option>
                        <option>695</option>
                        <option>696</option>
                        <option>697</option>
                        <option>699</option>
                        <option>627</option>
                        <option>628</option>
                        <option>629</option>
                        <option>630</option>
                        <option>631</option>
                        <option>632</option>
                        <option>633</option>
                        <option>636</option>
                        <option>637</option>
                        <option>638</option>
                        <option>639</option>
                        <option>640</option>
                        <option>641</option>
                        <option>644</option>
                        <option>645</option>
                        <option>646</option>
                        <option>647</option>
                        <option>648</option>
                        <option>649</option>
                        <option>650</option>
                        <option>663</option>
                        <option>668</option>
                        <option>672</option>
                        <option>673</option>
                        <option>674</option>
                        <option>675</option>
                        <option>676</option>
                        <option>677</option>
                        <option>678</option>
                        <option>681</option>
                        <option>682</option>
                        <option>683</option>
                        <option>684</option>
                        <option>685</option>
                        <option>688</option>
                        <option>689</option>
                        <option>690</option>
                        <option>698</option>
                            </select>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Cantidad:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id="cantidadConceptoECC11" name="cantidadConceptoECC11" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Identificaci&oacute;n:</label></div>
                        <div class="span7">
                            <select id="noIdentificacionConceptoECC11" name="noIdentificacionConceptoECC11" class="conceptoConsumoCombustiblesECC11">
                        <option value="">Seleccionar</option>
                        <option>32011</option>
                        <option>32012</option>
                        <option>34006</option>
                        <option>34008</option>
                        <option>Otros</option>
                            </select>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Unidad:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id="unidadConceptoECC11" name="unidadConceptoECC11" maxlength="25" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Nombre Combustible:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id="nombreCombustibleECC11" name="nombreCombustibleECC11" maxlength="300" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Folio Operaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id="folioOperacionECC11" name="folioOperacionECC11" maxlength="50" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Precio Unitario:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" id="precioUnitarioECC11" name="precioUnitarioECC11" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Importe:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC11" readonly="true" id="importeCombustibleECC11" name="importeCombustibleECC11" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span3 offset9">
                        <input type="button" id="addConceptoECC11" value="Agregar" class="btn btn-primary" />
                    </div>
                </div>
                <div class="row-fluid">
                    <fieldset>
                        <legend>Traslados:</legend>
                        <h4 class="blue">Impuestos:</h4>
                        <div class="row-fluid">
                            <div class="span4">
                                <div class="span6"><label>Tipo Impuesto:</label></div>
                                <div class="span6">
                                    <select id="impuestoTrasladoECC11" name="impuestoTrasladoECC11" class="trasladoConsumoCombustiblesECC11">
                                        <option>IVA</option>
                                        <option>IEPS</option>
                                    </select>
                                </div>
                            </div>
                            <div class="span4">
                                <div class="span6"><label>Tasa o Cuota:</label></div>
                                <div class="span4">
                                    <input type="text" class="trasladoConsumoCombustiblesECC11" id="tasaoCuotaECC11" name="tasaoCuotaECC11" />
                                </div>
                                <div class="span2"><label>%</label></div>
                            </div>
                            <div class="span4">
                                <div class="span6"><label>Importe:</label></div>
                                <div class="span6">
                                    <input type="text" class="trasladoConsumoCombustiblesECC11" id="importeTrasladoECC11" name="importeTrasladoECC11" />
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span3 offset9">
                                <input type="button" id="addTrasladoECC11" value="Agregar" class="btn btn-primary" />
                            </div>
                        </div>
                    </fieldset>
                </div>
            </fieldset>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->