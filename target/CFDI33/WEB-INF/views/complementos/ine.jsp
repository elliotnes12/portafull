<div class="accordion-group">
    <div class="accordion-heading">
        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseINE">
            Complemento INE
        </a>
    </div>
    <div id="collapseINE" class="accordion-body collapse">
        <div class="accordion-inner">
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Tipo Proceso: </label></div>
                    <div class="span7">
                        <select class="ine" name="tipoProceso" id="tipoProceso">
                            <option value="">Seleccionar</option>
                            <option value="Ordinario"> Ordinario </option>
                            <option value="Precampaña"> Precampaña </option>
                            <option value="Campaña"> Campaña </option>
                        </select>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Tipo Comit&eacute;: </label></div>
                    <div class="span7">
                        <select class="ine" name="tipoComite" id="tipoComite">
                            <option value="">Seleccionar</option>
                            <option value="Ejecutivo Nacional"> Ejecutivo Nacional </option>
                            <option value="Ejecutivo Estatal"> Ejecutivo Estatal </option>
                            <option value="Directivo Estatal"> Directivo Estatal </option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Clave Contabilidad: </label></div>
                    <div class="span7">
                        <input type="text" name="idContabilidad" id="idContabilidad" class="ine" maxlength = "6"/>
                    </div>
                </div>
            </div>
            <legend>Contabilidad</legend>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Clave Contabilidad Estatal: </label></div>
                    <div class="span7">
                        <input type="text" name="idContabilidadEstatal" id="idContabilidadEstatal" maxlength = "6"/>
                    </div>
                </div>
                <div class="span3 offset3">
                    <a id="btnContabilidadEstatal" class="btn btn-primary">
                        <i class="icon-white icon-plus"></i>
                        Agregar
                    </a>
                </div>
            </div>
            <legend>Entidad</legend>
            <div class="row-fluid">
                <div class="span6">
                    <div class="span5"><label>Clave Entidad: </label></div>
                    <div class="span7">
                        <select class="ineEntidad" name="claveEntidad" id="claveEntidad">
                            <option value="">Seleccionar</option>
                            <option value="AGU">Aguascalientes</option>
							<option value="BCN">Baja California</option>
							<option value="BCS">Baja California Sur</option>
							<option value="CAM">Campeche</option>
							<option value="CHP">Chiapas</option>
							<option value="CHH">Chihuahua</option>
							<option value="COA">Coahuila</option>
							<option value="COL">Colima</option>
							<option value="CR1">Circunscripción 1</option>
							<option value="CR2">Circunscripción 2</option>
							<option value="CR3">Circunscripción 3</option>
							<option value="CR4">Circunscripción 4</option>
							<option value="CR5">Circunscripción 5</option>
							<option value="DIF">Ciudad de México</option>
							<option value="DUR">Durango</option>
							<option value="GUA">Guanajuato</option>
							<option value="GRO">Guerrero</option>
							<option value="HID">Hidalgo</option>
							<option value="JAL">Jalisco</option>
							<option value="MEX">México</option>
							<option value="MIC">Michoacán</option>
							<option value="MOR">Morelos</option>
							<option value="NAC">Nacional</option>
							<option value="NAY">Nayarit</option>
							<option value="NLE">Nuevo León</option>
							<option value="OAX">Oaxaca</option>
							<option value="PUE">Puebla</option>
							<option value="QUE">Querétaro</option>
							<option value="ROO">Quintana Roo</option>
							<option value="SLP">San Luis Potosí</option>
							<option value="SIN">Sinaloa</option>
							<option value="SON">Sonora</option>
							<option value="TAB">Tabasco</option>
							<option value="TAM">Tamaulipas</option>
							<option value="TLA">Tlaxcala</option>
							<option value="VER">Veracruz</option>
							<option value="YUC">Yucatán</option>
							<option value="ZAC">Zacatecas</option>
                        </select>
                    </div>
                </div>
                <div class="span6">
                    <div class="span5"><label>Ámbito: </label></div>
                    <div class="span7">
                        <select class="ineEntidad" name="ambito" id="ambito">
                            <option value="">Seleccionar</option>
                            <option value="Local"> Local </option>
                            <option value="Federal"> Federal </option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span3 offset9">
                    <a id="btnINEEntidades" class="btn btn-primary">
                        <i class="icon-white icon-plus"></i>
                        Agregar
                    </a>
                </div>
            </div>
        </div><!-- accord inner -->
    </div>
</div><!-- accord group -->