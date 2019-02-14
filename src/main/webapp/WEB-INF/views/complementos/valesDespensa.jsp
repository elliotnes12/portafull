<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseDespensa">
            Complemento Vales de Despensa
        </a>
    </div>
    <div id="collapseDespensa" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Tipo Operaci&oacute;n:</label></div>
                    <div class="span7">
                        <input name="tipoOperacion"  id="tipoOperacion" class="despensa" value="monedero electrónico" readonly="true"/>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Registro Patronal: </label></div>
                    <div class="span7">
                        <input type="text" id="registroPatronal" name="registroPatronal" class="despensa" maxlength="20"/>
                    </div>
                </div>
            </div>
            <div class="">
                <div class="span6">
                    <div class="span5"><label>N&uacute;mero de cuenta: </label></div>
                    <div class="span7">
                        <input type="text" id="numeroDeCuentaValesDespensa" name="numeroDeCuentaValesDespensa" class="despensa" maxlength="20"/>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Total: </label></div>
                    <div class="span7">
                        <div class="input-prepend input-append">
                            <span class="add-on">$</span>
                            <input name="totalValesDespensa" id="totalValesDespensa" value="0.00" type="text" class="despensa"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <table class="table" id="tablaConceptosDespensa">
                    <thead>
                        <tr>
                            <th>Identificador</th>
                            <th>Fecha</th>
                            <th>R.F.C.</th>
                            <th>C.U.R.P.</th>
                            <th>Nombre</th>
                            <th>Num. Seguridad Social</th>
                            <th>Importe</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <h4 class="blue">Conceptos Despensa:</h4>
                <div class="">
                    <div class="span6">
                        <div class="span5"><label>Identificador:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoDespensa" name="identificadorValesDespensa" maxlength="20"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Fecha:</label></div>
                        <div class="span7">
                            <input type="text" id="fechaValesDespensa" class="conceptoDespensa" name="fechaValesDespensa"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Hora:</label></div>
                        <div class="span7">
                            <input type="text" id="horaValesDespensa" class="conceptoDespensa" name="horaValesDespensa" maxlength="2"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Minutos:</label></div>
                        <div class="span7">
                            <input type="text" id="minutosValesDespensa" class="conceptoDespensa" name="minutosValesDespensa" maxlength="2"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>Segundos:</label></div>
                        <div class="span7">
                            <input type="text" id="segundosValesDespensa" class="conceptoDespensa" name="segundosValesDespensa" maxlength="2"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>RFC:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoDespensa" name="rfcValesDespensa"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        <div class="span5"><label>C.U.R.P. :</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoDespensa" name="curpValesDespensa"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Nombre:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoDespensa" name="nombreValesDespensa"/>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span6">
                        
                        <div class="span5"><label>Num. Seguridad Social:</label></div>
                        <div class="span7">
                            <input type="text" class="conceptoDespensa" name="numSeguridadSocial" maxlength="15"/>
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Importe:</label></div>
                        <div class="span6">
                            <div class="input-prepend input-append">
                                <span class="add-on">$</span>
                                <input name="importeValesDespensa" value="0.00" type="text" class="conceptoDespensa"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row-fluid">
                    <div class="span3 offset9">
                        <a id="btnConceptoDespensa" class="btn btn-primary">
                            <i class="icon-white icon-plus"></i>
                            Agregar
                        </a>
                    </div>
                </div>
            </div>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->