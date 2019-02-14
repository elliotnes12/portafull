<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseConsumoCombustibles">
            Complemento Consumo de Combustibles 1.1
        </a>
    </div>
    <div id="collapseConsumoCombustibles" class="accordion-body collapse">
        <div class="accordion-inner">
            <fieldset>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Tipo Operaci&oacute;n:</label></div>
                        <div class="span7">
                            <input type="text" name="tipoOperacion"  id="tipoOperacion" class="consumoCombustibles" value="monedero electrónico" readonly="true"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero de Cuenta:</label></div>
                        <div class="span7">
                            <input type="text" id= "numeroDeCuenta" name="numeroDeCuenta"  class="consumoCombustibles"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Subtotal:</label></div>
                        <div class="span7">
                            <input type="text" id="subTotalCombustibles" name="subTotalCombustibles" value="0" readonly="true" class="consumoCombustibles"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Total:</label></div>
                        <div class="span7">
                            <input type="text" name="totalCombustibles" id="totalCombustibles" value="0" readonly="true" class="consumoCombustibles"/>
                        </div>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <legend>Conceptos Cubiertos:</legend>
                <div class="row">
                    <h4 class="blue">Conceptos Complemento Combustible:</h4>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>Identificador:</label></div>
                            <div class="span7">
                                <input type="text" class="conceptoConsumoCombustibles" id ="identificador" name="identificador"/>
                            </div>
                        </div>
                        <div class="span6">
                        <div class="span3"><label>Fecha:</label></div>
                        <div class="span4">
                            <div id="mfechaAprobacion" class="input-append">
                                <input type="text" class="conceptoConsumoCombustibles" id="fechaExpOper" name="fechaExpOper" />
                                <span class="add-on">
                                    <i class="icon-calendar"></i>
                                </span>
                            </div>
                        </div>
                        <div class="span4 offset1">
                            <input type="text" class="conceptoConsumoCombustibles" name="horaExpOper" id="horaExpOper" placeholder="hh:mm:ss" maxlength="8" />
                        </div>
                    </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>R.F.C.:</label></div>
                            <div class="span7">
                                <input type="text" class="conceptoConsumoCombustibles" id="rfcEnajCombustible" name="rfcEnajCombustible"/>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Clave Estaci&oacute;n:</label></div>
                            <div class="span7">
                                <input type="text" class="conceptoConsumoCombustibles" id="claveEstacion" name="claveEstacion" maxlength="10"/>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                        	<div class="span5"><label>Tipo Combustible:</label></div>
	                        <div class="span7">
	                            <select id="tipoCombustibleCC11" name="tipoCombustibleCC11" class="conceptoConsumoCombustibles">
			                        <option value="">Seleccionar</option>
			                        <option value="1">Gasolina menor a 92 octanos</option>
			                        <option value="2">Gasolina mayor o igual a 92 octanos</option>
			                        <option value="3">Diesel</option>
			                        <option value="4">Diesel Marino</option>
			                        <option value="5">Otros</option>
	                            </select>
	                        </div>
	                    </div>
	                    <div class="span6">  
                            <div class="span5"><label>Cantidad:</label></div>
                            <div class="span7">
                                <input type="text" class="conceptoConsumoCombustibles" id="volumen" name="volumen"/>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                        	<div class="span5"><label>Nombre Combustible:</label></div>
	                            <div class="span7">
	                                <input type="text" class="conceptoConsumoCombustibles" id="nombreCombustible" name="nombreCombustible" maxlength="300"/>
	                            </div>
	                    </div>
	                    <div class="span6">
                            <div class="span5"><label>Folio Operaci&oacute;n:</label></div>
                            <div class="span7">
                                <input type="text" class="conceptoConsumoCombustibles" id="folioOperacion" name="folioOperacion"/>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>Valor Unitario:</label></div>
	                            <div class="span7">
	                                <input type="text" class="conceptoConsumoCombustibles" id="precioUnitario" name="precioUnitario"/>
	                            </div>
	                        </div>
	                        <div class="span6">
                            	<div class="span5"><label>Importe:</label></div>
                            	<div class="span7">
                                	<input type="text" class="conceptoConsumoCombustibles" readonly="true" id="importeCombustible" name="importeCombustible"/>
                            	</div>
                        	</div>
                        </div>
                        <div class="row-fluid">
		                    <div class="span3 offset9">
		                        <input type="button" id="addConcepto" value="Agregar" class="btn btn-primary" />
		                    </div>
		                </div>
                       <div class="row-fluid">
                    <fieldset>
                        <legend>Impuestos Determinados:</legend>
                        <h4 class="blue">Impuestos:</h4>
                        <div class="row-fluid">
                            <div class="span4">
                                <div class="span6"><label>Tipo Impuesto:</label></div>
                                <div class="span6">
                                    <select id="tipoImpuesto" name="tipoImpuesto" class="determinadoConsumoCombustibles">
                                        <option>IVA</option>
                                        <option>IEPS</option>
                                    </select>
                                </div>
                            </div>
                            <div class="span4">
                                <div class="span6"><label>Tasa o Cuota:</label></div>
                                <div class="span4">
                                    <input type="text" class="determinadoConsumoCombustibles" id="tasaImpuesto" name="tasaImpuesto"/>
                                </div>
                            </div>
                            <div class="span4">
                                <div class="span6"><label>Importe:</label></div>
                                <div class="span6">
                                    <input type="text" class="determinadoConsumoCombustibles" id="importeImpuesto" name="importeImpuesto"/>
                                </div>
                            </div>
                        </div>
                        <div class="row-fluid">
                            <div class="span3 offset9">
                                <input type="button" id="addDeterminado" value="Agregar" class="btn btn-primary" />
                            </div>
                        </div>
                    </fieldset>
                </div>
            </fieldset>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->