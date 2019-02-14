<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseAero">
            Complemento Aerol&iacute;neas
        </a>
    </div>
    <div id="collapseAero" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <div class="span6">
                    <div class="span4"><label>TUA: </label></div>
                    <div class="span8">
                        <input type="text" id="tua" name="tua" class="aerolineas"/>
                    </div>
                </div>
            </div>
            <fieldset>
                <legend>Otros Cargos</legend>
                <div class="row">
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>Total Cargos:</label></div>
                            <div class="span7">
                                <input type="text" name="TotalCargos" id="TotalCargos" readonly="true"/>
                            </div>
                        </div>
                    </div>
                    <h4 class="blue">Cargo:</h4>
                    <div class="row-fluid">
                        <div class="span6">
                            <div class="span5"><label>C&oacute;digo Cargo:</label></div>
                            <div class="span7">
                                <input type="text" class="cargoAerolineas" name="codigoCargo" id="codigoCargo" maxlength="8"/>
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Importe:</label></div>
                            <div class="span7">
                                <input type="text" class="cargoAerolineas" name="importeCargo" id="importeCargo"/>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span3 offset9">
                            <input type="button" id="addCargoAerolineas" value="Agregar" class="btn btn-primary" />
                        </div>
                    </div>
                </div>
            </fieldset>

        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->