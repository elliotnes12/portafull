<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseSpei">
            Complemento SPEI Tercero a Tercero
        </a>
    </div>
    <div id="collapseSpei" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <div class="span4">
                    <div class="span5"><label>Fecha Operaci&oacute;n :</label></div>
                    <div class="span7">
                        <div id="mfechaSpei" class="input-append">
                            <input type="text" id="fechaSpei" name="fechaSpei" class="spei" />
                            <span class="add-on">
                                <i class="icon-calendar"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="span4">
                    <div class="span5"><label>Hora :</label></div>
                    <div class="span7">
                        <input type="text" class="spei" name="horaSpei" id="horaSpei" placeholder="hh:mm:ss" maxlength="8" />
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>Clave SPEI del Participante Emisor:</label></div>
                        <div class="span7">
                            <input type="text" class="spei" id="claveSpei" name="claveSpei" maxlength="5" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Sello:</label></div>
                        <div class="span7">
                            <input type="text" class="spei" id="selloSpei" name="selloSpei" />
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span6">
                        <div class="span5"><label>N&uacute;mero Certificado:</label></div>
                        <div class="span7">
                            <input type="text" class="spei" id="numeroCertificado" name="numeroCertificado" maxlength="20" />
                        </div>
                    </div>
                    <div class="span6">
                        <div class="span5"><label>Cadena CDA:</label></div>
                        <div class="span7">
                            <input type="text" class="spei" id="cadenaCDA" name="cadenaCDA" maxlength="841" />
                        </div>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <fieldset>
                    <legend>Ordenante</legend>
                    <div class="row">
                        <fieldset>
                            <div class="span6">
                                <div class="span5"><label>Banco Emisor:</label></div>
                                <div class="span7">
                                    <input type="text" class="ordenante" id="bancoOrdenante" name="bancoOrdenante" maxlength="40" />
                                </div>
                            </div>
                            <div class="span6">
                                <div class="span5"><label>Nombre:</label></div>
                                <div class="span7">
                                    <input type="text" class="ordenante" id="nombreOrdenanteSpei" name="nombreOrdenanteSpei" maxlength="40" />
                                </div>
                            </div>
                        </fieldset>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Tipo Cuenta:</label></div>
                            <div class="span7">
                                <input type="text" class="ordenante" id="tipoCuentaOrdenanteSpei" name="tipoCuentaOrdenanteSpei" maxlength="2" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Cuenta:</label></div>
                            <div class="span7">
                                <input type="text" class="ordenante" id="cuentaOrdenanteSpei" name="cuentaOrdenanteSpei" maxlength="20" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>R.F.C. :</label></div>
                            <div class="span7">
                                <input type="text" class="ordenante" id="rfcOrdenanteSpei" name="rfcOrdenanteSpei" />
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="row-fluid">
                <fieldset>
                    <legend>Beneficiario</legend>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Banco Receptor:</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="bancoReceptor" name="bancoReceptor" maxlength="40" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Nombre:</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="nombreBeneficiarioSpei" name="nombreBeneficiarioSpei" maxlength="40" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>Tipo Cuenta:</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="tipoCuentaBeneficiarioSpei" name="tipoCuentaBeneficiarioSpei" maxlength="2" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Cuenta:</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="cuentaBeneficiarioSpei" name="cuentaBeneficiarioSpei" maxlength="20" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>R.F.C. :</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="rfcBeneficiarioSpei" name="rfcBeneficiarioSpei" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Concepto:</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="conceptoSpei" name="conceptoSpei" maxlength="40" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6">
                            <div class="span5"><label>I.V.A. :</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="ivaSpei" name="ivaSpei" maxlength="19" />
                            </div>
                        </div>
                        <div class="span6">
                            <div class="span5"><label>Monto:</label></div>
                            <div class="span7">
                                <input type="text" class="beneficiario" id="montoSpei" name="montoSpei" maxlength="19" />
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
        <div class="row-fluid">
            <div class="span2 offset9">
                <input type="button" id="addSpei" value="Agregar" class="btn btn-primary" />
            </div>
        </div>
    </div><!-- accord inner -->
</div><!-- accord group -->