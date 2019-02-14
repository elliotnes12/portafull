<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseECC12">
            Complemento Estado de Cuenta de Combustibles para Monederos Electr&oacute;nicos Autorizados por el SAT 1.2
        </a>
    </div>
    <div id="collapseECC12" class="accordion-body collapse">
        <div class="accordion-inner">
            <fieldset>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Tipo Operaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" name="tipoOperacionECC12"  id="tipoOperacionECC12" class="ecc12" value="Tarjeta" readonly="true" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Cuenta:</label></div>
                        <div class="span7">
                            <input type="text" id= "numeroDeCuentaECC12" name="numeroDeCuentaECC12"  class="ecc12" maxlength="50" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Subtotal:</label></div>
                        <div class="span7">
                            <input type="text" id="subTotalCombustiblesECC12" name="subTotalCombustiblesECC12" value="0" readonly="true" class="ecc12" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Total:</label></div>
                        <div class="span7">
                            <input type="text" name="totalCombustiblesECC12" id="totalCombustiblesECC12" value="0" readonly="true" class="ecc12" />
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
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id ="identificadorECC12" name="identificadorECC12" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span3"><label>Fecha:</label></div>
                        <div class="span4">
                            <div id="mfechaAprobacion" class="input-append">
                                <input type="text" class="conceptoConsumoCombustiblesECC12" id="fechaExpOperECC12" name="fechaExpOperECC12" />
                                <span class="add-on">
                                    <i class="icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                        <div class="span4 offset1">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" name="horaConsumoCombustiblesECC12" id="horaConsumoCombustiblesECC12" placeholder="hh:mm:ss" maxlength="8" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>R.F.C.:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id="rfcEnajCombustibleECC12" name="rfcEnajCombustibleECC12" maxlength="13"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Clave Estaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id="claveEstacionECC12" name="claveEstacionECC12" maxlength="10" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Cantidad:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id="cantidadConceptoECC12" name="cantidadConceptoECC12" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Tipo Combustible:</label></div>
                        <div class="span7">
                            <select id="noIdentificacionConceptoECC12" name="noIdentificacionConceptoECC12" class="conceptoConsumoCombustiblesECC12">
		                        <option value="">Seleccionar</option>
		                        <option value="1">Gasolina menor a 92 octanos</option>
		                        <option value="2">Gasolina mayor o igual a 92 octanos</option>
		                        <option value="3">Diesel</option>
		                        <option value="4">Diesel Marino</option>
		                        <option value="5">Otros</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Unidad:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id="unidadConceptoECC12" name="unidadConceptoECC12" maxlength="25" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Nombre Combustible:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id="nombreCombustibleECC12" name="nombreCombustibleECC12" maxlength="300" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Folio Operaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id="folioOperacionECC12" name="folioOperacionECC12" maxlength="50" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Precio Unitario:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" id="precioUnitarioECC12" name="precioUnitarioECC12" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Importe:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoConsumoCombustiblesECC12" readonly="true" id="importeCombustibleECC12" name="importeCombustibleECC12" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span3 offset9">
                        <input type="button" id="addConceptoECC12" value="Agregar" class="btn btn-primary" />
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
                                    <select id="impuestoTrasladoECC12" name="impuestoTrasladoECC12" class="trasladoConsumoCombustiblesECC12">
                                        <option>IVA</option>
                                        <option>IEPS</option>
                                    </select>
                                </div>
                            </div>
                            <div class="span4">
                                <div class="span6"><label>Tasa o Cuota:</label></div>
                                <div class="span4">
                                    <input type="text" class="trasladoConsumoCombustiblesECC12" id="tasaoCuotaECC12" name="tasaoCuotaECC12" />
                                </div>
                                <div class="span2"><label>%</label></div>
                            </div>
                            <div class="span4">
                                <div class="span6"><label>Importe:</label></div>
                                <div class="span6">
                                    <input type="text" class="trasladoConsumoCombustiblesECC12" id="importeTrasladoECC12" name="importeTrasladoECC12" />
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span3 offset9">
                                <input type="button" id="addTrasladoECC12" value="Agregar" class="btn btn-primary" />
                            </div>
                        </div>
                    </fieldset>
                </div>
            </fieldset>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->