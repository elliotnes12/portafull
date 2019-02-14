<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTurista">
            Complemento Turista Pasajero Extranjero
        </a>
    </div>
    <div id="collapseTurista" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <div class="span8">
                    <div class="span4"><label>Fecha de Tr&aacute;nsito: </label></div>
                    <div class="span4">
                        <div id="mfechaTransito" class="input-append">
                            <input type="text" class="turista" id="fechaTransito" name="fechaTransito" />
                                <span class="add-on">
                                    <i class="icon-calendar"></i>
                                </span>
                        </div>
                    </div>
                    <div class="span4">
                        <input type="text" class="turista" name="horaTransito" id="horaTransito" placeholder="hh:mm:ss" />
                    </div>
                </div>
                <div class="span4">
                    <div class="span6"><label>Tipo de Tr&aacute;nsito: </label></div>
                    <div class="span6">
                        <select name="tipoTransito"  class="turista">
                            <option value="">  </option>
                            <option value="Arribo"> Arribo </option>
                            <option value="Salida"> Salida </option>
                        </select>
                    </div>
                </div>
            </div>
            <fieldset>
                <legend>Datos Tr&aacute;nsito</legend>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Via:</label></div>
                        <div class="span7">
                            <select name="via"  class="datosTransito">
                                <option value="">  </option>
                                <option value="Aérea"> A&eacute;rea </option>
                                <option value="Marítima"> Mar&iacute;tima </option>
                                <option value="Terrestre"> Terrestre </option>
                            </select>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Tipo Id:</label></div>
                        <div class="span7">
                            <input type="text" class="datosTransito" name="tipoIdTurista" id="tipoIdTurista" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero Id:</label></div>
                        <div class="span7">
                            <input type="text" class="datosTransito" name="numeroIdTurista" id="numeroIdTurista" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Nacionalidad:</label></div>
                        <div class="span7">
                            <input type="text" class="datosTransito" name="nacionalidadTurista" id="nacionalidadTurista" />
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Empresa Transporte:</label></div>
                        <div class="span7">
                            <input type="text" class="datosTransito" name="empresaTransporte" id="empresaTransporte" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Id Transporte:</label></div>
                        <div class="span7">
                            <input type="text" class="datosTransito" name="idTransporteTurista" id="idTransporteTurista" />
                        </div>
                    </div>
                </div>
            </fieldset>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->