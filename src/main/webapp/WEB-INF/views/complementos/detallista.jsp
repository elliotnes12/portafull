<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseDetallista">
            Complemento Detallista
        </a>
    </div>
    <div id="collapseDetallista" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row row-fluid">
                <div class="span6">
                    <div class="span5"><label for="entityType">Tipo de Documento</label></div>
                    <div class="span7">
                        <select name="ENTITY_TYPE" id="entityType">
                            <option value="INVOICE">Factura</option>
                            <option value="PARTIAL_INVOICE">Factura a plazos</option>
                            <option value="AUTO_INVOICE">Auto factura</option>
                            <option value="CREDIT_NOTE">Nota de cr&eacute;dito</option>
                            <option value="DEBIT_NOTE">Nota de d&eacute;bito</option>
                            <option value="HONORARY_RECEIPT">Recibo de honorarios</option>
                            <option value="LEASE_RECEIPT">Recibo de arrendamiento</option>
                        </select>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label for="documentStatus">Status documento:</label></div>
                    <div class="span7">
                        <select id="documentStatus">
                            <option value="ORIGINAL">Original</option>
                            <option value="DELETE">Cancela</option>
                            <option value="COPY">Copia</option>
                            <option value="REEMPLAZA">Reemplazar</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row">
                <fieldset>
                    <legend>Comprador</legend>
                    <div class="row-fluid">
                        <div class="span6"> 
                            <div class="span5"><label for="glnBuyer">*N&uacute;mero de comprador (GLN):</label></div>
                            <div class="span7">
                                <input type="text" id="glnBuyer">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>*Contacto de compras:</label></div>
                            <div class="span7">
                                <input type="text" id="contactBuyer">
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Vendedor</legend>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label for="glnSeller">*No. Global de Localizaci&oacute;n (GLN):</label></div>
                            <div class="span7"><input type="text" id="glnSeller"></div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label for="alternatePartyIdentification">*Identificaci&oacute;n secundaria:</label></div>
                            <div class="span7">
                                <select id="alternatePartyIdentification">
                                    <option value="SELLER_ASSIGNED_IDENTIFIER_FOR_A_PARTY">N&uacute;mero interno</option>
                                    <option value="IEPS_REFERENCE">Referencia asignada para el IEPS</option>
                                </select>
                                <input type="text" id="alternatePartyIdentificationValue">
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Informaci&oacute;n Adicional</legend>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label for="additionalInformation">Tipo de descuento o cargo</label></div>
                            <div class="span7">
                                <select id="additionalInformation">
                                    <option>AAE</option>
                                    <option>CK</option>
                                    <option>ACE</option>
                                    <option>ATZ</option>
                                    <option>DQ</option>
                                    <option>IV</option>
                                    <option>ON</option>
                                    <option>AWR</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Asignaci&oacute;n de carga</legend>
                    <div class="row-fluid">
                        <div class="span6">    
                            <div class="span5"><label>Tipo de servicio especial</label></div>
                            <div class="span7">
                                <select id="allowanceChargeType">
                                    <option>ALLOWANCE_GLOBAL</option>
                                    <option>CHARGE_GLOBAL</option>
                                </select>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Imputaci&oacute;n del descuento o cargo</label></div>
                            <div class="span7">
                                <select id="settlementType">
                                    <option>BILL_BACK</option>
                                    <option>OFF_INVOICE</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>Tipo de descuento o cargo</label></div>
                            <div class="span7">
                                <select id="specialServicesTypeAllowanceCharge">
                                    <option>AA</option>
                                    <option>AJ</option>
                                    <option>ADO</option>
                                    <option>ADT</option>
                                    <option>ADS</option>
                                    <option>ABZ</option>
                                    <option>DA</option>
                                    <option>EAA</option>
                                    <option>EAB</option>
                                    <option>PI</option>
                                    <option>TAE</option>
                                    <option>SAB</option>
                                    <option>RAA</option>
                                    <option>PAD</option>
                                    <option>FG</option>
                                    <option>FA</option>
                                    <option>TD</option>
                                    <option>TS</option>
                                    <option>TX</option>
                                    <option>TZ</option>
                                    <option>ZZZ</option>
                                    <option>VAB</option>
                                    <option>UM</option>
                                    <option>DI</option>
                                    <option>CAC</option>
                                    <option>COD</option>
                                    <option>EAB</option>
                                    <option>FC</option>
                                    <option>FI</option>
                                    <option>HD</option>
                                    <option>QD</option>
                                </select>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Importe monetario:</label></div>
                            <div class="span7">
                                <div class="input-prepend input-append">
                                    <span class="add-on">$</span>
                                    <input id="percentage" value="0.00" type="text">
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Pedido</legend>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>*No. de pedido:</label></div>
                            <div class="span7">
                                <input type="text" id="orderIdentification">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Fecha de la orden:</label></div>
                            <div class="span7">
                                <div id="mOrderDate" class="input-append">
                                    <input type="text" id="orderDate" readonly="readonly">
                                    <span class="add-on">
                                        <i class="icon-calendar"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Nota de entrega</legend>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>*No. de pedido:</label></div>
                            <div class="span7">
                                <input type="text" id="deliveryNote">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Fecha asignada:</label></div>
                            <div class="span7">
                                <div id="mOrderDate" class="input-append">
                                    <input type="text" class="input-small" id="deliveryDate" readonly="readonly">
                                    <span class="add-on">
                                        <i class="icon-calendar"></i>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Cantidad Total:</legend>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>Monto: </label></div>
                            <div class="span7">
                                <div class="input-prepend input-append">
                                    <span class="add-on">$</span>
                                    <input id="totalAmount" value="0.00" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Cargos o descuentos consolidados</label></div>
                            <div class="span7">
                                <select id="totalAllowanceOrChargeType">
                                    <option>ALLOWANCE</option>
                                    <option>CHARGE</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>TipoDescuento</label></div>
                            <div class="span7">
                                <select id="totalspecialServicesType">
                                    <option>AA</option>
                                    <option>ADS</option>
                                    <option>ADO</option>
                                    <option>ABZ</option>
                                    <option>DA</option>
                                    <option>EAA</option>
                                    <option>PI</option>
                                    <option>TAE</option>
                                    <option>SAB</option>
                                    <option>RAA</option>
                                    <option>PAD</option>
                                    <option>FG</option>
                                    <option>FA</option>
                                    <option>TD</option>
                                    <option>TS</option>
                                    <option>TX</option>
                                    <option>ZZZ</option>
                                    <option>VAB</option>
                                    <option>UM</option>
                                    <option>DI</option>
                                    <option>ADT</option>
                                    <option>AJ</option>
                                    <option>CAC</option>
                                    <option>COD</option>
                                    <option>EAB</option>
                                    <option>FC</option>
                                    <option>FI</option>
                                    <option>HD</option>
                                    <option>QD</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Productos:</legend>
                    <div class="row-fluid divRow">
                        <table id="productos">
                            <thead></thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <div class="row-fluid divRow">
                        <div class="span6">
                            <div class="span5"><label>Gtin: </label></div>
                            <div class="span7">
                                <input type="text" id="gtinLine">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Identificacion Comercial: </label></div>
                            <div class="span7">
                                <input type="text" id="alternateTradeItemIdentification">
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid divRow">
                        <div class="span6">
                            <div class="span5"><label>Type: </label></div>
                            <div class="span7">
                                <select id="alternateTradeItemIdentificationType">
                                    <option>BUYER_ASSIGNED</option>
                                    <option>SUPPLIER_ASSIGNED</option>
                                    <option>SERIAL_NUMBER</option>
                                    <option>GLOBAL_TRADE_ITEM_IDENTIFICATION</option>
                                </select>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Descripci&oacute;n: </label></div>
                            <div class="span7">
                                <input type="text" id="tradeItemDescriptionInformation">
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid divRow">
                        <div class="span6">
                            <div class="span5"><label>Unidad: </label></div>
                            <div class="span7">
                                <input type="text" id="invoicedQuantityService">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Value: </label></div>
                            <div class="span7">
                                <input type="text" id="invoicedQuantityValue">
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid divRow">
                        <div class="span6">
                            <div class="span5"><label>Precio bruto: </label></div>
                            <div class="span7">
                                <input type="text" id="grossPrice">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Precio neto: </label></div>
                            <div class="span7">
                                <input type="text" id="netPrice">
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid divRow">
                        <div class="span6">
                            <div class="span5"><label>Cantidad bruta: </label></div>
                            <div class="span7">
                                <input type="text" id="grossAmount">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Cantidad neta: </label></div>
                            <div class="span7">
                                <input type="text" id="netAmount">
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid divRow">
                        <div class="span3 offset9">
                            <a class="btn btn-primary" id="btnLineItem"><i class="icon-white icon-plus"></i>Agregar item</a>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Cargos o descuentos:</legend>
                    <div class="row-fluid divRow">
                        <div class="span4">
                            <div class="span5"><label>Tipo servicio:</label></div>
                            <div class="span7">
                                <select id="allowanceOrChargeType">
                                    <option value="ALLOWANCE">Descuento</option>
                                    <option value="CHARGE">Cargo</option>
                                </select>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="span5"><label>Tipo descuento:</label></div>
                            <div class="span7">
                                <select id="allowanceOrChargeType">
                                    <option>AA</option>
                                    <option>ADS</option>
                                    <option>ADO</option>
                                    <option>ABZ</option>
                                    <option>DA</option>
                                    <option>EAA</option>
                                    <option>PI</option>
                                    <option>TAE</option>
                                    <option>SAB</option>
                                    <option>RAA</option>
                                    <option>PAD</option>
                                    <option>FG</option>
                                    <option>FA</option>
                                    <option>TD</option>
                                    <option>TS</option>
                                    <option>TX</option>
                                    <option>ZZZ</option>
                                    <option>VAB</option>
                                    <option>UM</option>
                                    <option>DI</option>
                                    <option>ADT</option>
                                    <option>AJ</option>
                                    <option>CAC</option>
                                    <option>COD</option>
                                    <option>EAB</option>
                                    <option>FC</option>
                                    <option>FI</option>
                                    <option>HD</option>
                                    <option>QD</option>
                                </select>
                            </div>
                        </div>
                        <div class="span4">
                            <div class="span5"><label>Monto: </label></div>
                            <div class="span7">
                                <div class="input-prepend input-append">
                                    <span class="add-on">$</span>
                                    <input id="totalAmountCharge" value="0.00" type="text">
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
    </div>
</div>