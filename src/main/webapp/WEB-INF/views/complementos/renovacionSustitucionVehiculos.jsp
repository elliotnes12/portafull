    <div class="accordion-group">
	    <div class="accordion-heading">
	        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseRenovacionSustVehiculo">
	            Complemento Renovaci&oacute;n y Sustituci&oacute;n de Veh&iacute;culo
	        </a>
	    </div>
	    <div id="collapseRenovacionSustVehiculo" class="accordion-body collapse">
	        <div class="accordion-inner">
	            <fieldset>
	                <div class="row-fluid">
	                    <div class="span6">
	                        <div class="span5"><label>Tipo Decreto: </label></div>
	                        <div class="span7">
	                            <select class="renovSustVehiculos" name="tipoDeDecreto" id="tipoDeDecreto">
	                                <option value="">Seleccionar</option>
	                                <option value="01"> Decreto por el que se fomenta la renovaci&oacute;n del parque vehicular del autotransporte  </option>
	                                <option value="02"> Decreto por el que se otorgan medidas para la sustituci&oacute;n de veh&iacute;culos de autotransporte de pasaje y carga </option>
	                            </select>
	                        </div>
	                    </div>
	                </div>
	            </fieldset>
	            <div id="renovacion" style="display: none;">
	            	<div class="row">
	   	                <div class="span6">
	   	                    <div class="span5"><label>Veh&iacute;culo Enajenado: </label></div>
	   	                    <div class="span7">
	   	                         <select class="decretoRenovVehicular" name="vehEnajRenovacion" id="vehEnajRenovacion">
	   	                                <option value="">Seleccionar</option>
	   	                                <option value="01"> Nuevo  </option>
	   	                                <option value="02"> Seminuevo </option>
	   	                            </select>
	   	                    </div>
	   	                </div>
	 	            </div> 
	                <div class="DecretoRenovaciónVehicular row-fluid">
	                    <h4 class="blue">Decreto Renovaci&oacute;n Vehicular:</h4>
	    	            <div class="row" id="decretoRenovacionNuevo" >
	                        <fieldset>
	                            <legend>Veh&iacute;culo Nuevo o Seminuevo</legend>
	                            <div class="row-fluid">
	                                <fieldset>
	                                    <div class="row">
	                                        <div class="span6">
	                                            <div class="span5"><label>A&ntilde;o: </label></div>
	    		                                    <div class="span7">
	    		                                        <span class="VehiculoNuvoRenovacion">
	    		                                            <input type="text" name="anioVehiculoNuvo"  id="anioVehiculoNuvo" class="VehiculoNuvoRenovacion" maxlength = "4" />
	    		                                        </span>
	    		                                    </div>
	                                        </div>
	                                        <div class="span6">
	                                            <div class="span5"><label>Modelo: </label></div>
	                                            <div class="span7">
	    	                                        <span class="VehiculoNuvoRenovacion">
	    	                                            <input type="text" name="modeloVehiculoNuvo"  id="modeloVehiculoNuvo" class="VehiculoNuvoRenovacion"  />
	    	                                        </span>
	    	                                    </div>
	                                        </div>
	                                    </div>
	                                    <div class="row">
	                                   		<div class="span6">
	                                            <div class="span5"><label>N&uacute;mero de placas: </label></div>
	                                            <div class="span7">
	                                                <input type="text" name="numeroPlacasVehiculoNuvo"  id="numeroPlacasVehiculoNuvo" class="VehiculoNuvoRenovacion" maxlength = "10" />
	                                            </div>
	                                        </div>
	                                        <div class="span6">
	                                            <div class="span5"><label>R.F.C.: </label></div>
	                                            <div class="span7">
	                                                <input type="text" name="rfcVehiculoNuvo"  id="rfcVehiculoNuvo" class="VehiculoNuvoRenovacion" maxlength = "17" />
	                                            </div>
	                                        </div>
	                                    </div>
	                               </fieldset>
	                            </div>
	                       </fieldset>
	                   </div>  
	                    <div class="row" id="decretoRenovacionUsado" >
	                       <fieldset>
	                           <legend>Veh&iacute;culos Usados</legend>
	                           <div class="row-fluid">
	                               <fieldset>
	                                   <div class="row">
	                                       <div class="span6">
	                                           <div class="span5"><label for="precioVehUsadoRenovacion">Precio Veh&iacute;culo Usado</label></div>
	                                           <div class="span7">
	                                               <input type="text" id="precioVehUsadoRenovacion" name="precioVehUsadoRenovacion" class="VehiculosUsadosRenovacion" />
	                                           </div>
	                                       </div>
	                                       <div class="span6">
	                                           <div class="span5"><label>Tipo Veh&iacute;culo: </label></div>
	                                           <div class="span7">
	    	                                       <select class="VehiculosUsadosRenovacion" name="tipoVehRenovacion" id="tipoVehRenovacion">
	    	                                       	<option value="">Seleccionar</option>
	    	                                		<option value="01">Tractocamiones tipo quinta rueda</option>
	    	                                		<option value="02">Camiones unitarios de 2 ejes con peso bruto vehicular m&iacute;nimo de 11,794 kg </option>
	    	                                		<option value="03">Camiones unitarios de 3 ejes con peso bruto vehicular m&iacute;nimo de 14,500 kg </option>
	    	                                		<option value="04">Autobuses integrales con capacidad de m&aacute;s de 30 asientos </option>
	    	                                		<option value="05">Autobuses convencionales con capacidad de m&aacute;s de 30 asientos </option>
	    	                                		<option value="06">Veh&iacute;culos destinados al transporte de personas de 15 pasajeros o m&aacute;s, con una antig&uuml;edad de m&aacute;s de 8 a&ntilde;os </option>
	    	                                		<option value="07">Plataforma o Chas&iacute;s para autobuses integrales a los que se les pueda instalar m&aacute;s de 30 asientos</option>
	    	                                		<option value="08">Plataforma o Chas&iacute;s para autobuses convencionales a los que se les pueda instalar m&aacute;s de 30 asientos</option>
	    	                                       </select>
	                                           </div>
	                                       </div>
	                                   </div>
	                                   <div class="row">
	                                       <div class="span6">
	                                           <div class="span5"><label>Marca: </label></div>
	                                           <div class="span7">
	                                               <span class="VehiculosUsadosRenovacion">
	                                                   <input type="text" name="marcaRenovacion"  id="marcaRenovacion" class="VehiculosUsadosRenovacion" maxlength = "50" />
	                                               </span>
	                                           </div>
	                                       </div>
	                                       <div class="span6">
	    	                                   <div class="span5"><label>Tipo o Clase: </label></div>
	    	                                   <div class="span7">
	    	                                       <span class="VehiculosUsadosRenovacion">
	    	                                           <input type="text" name="tipooClaseRenovacion" id="tipooClaseRenovacion" class="VehiculosUsadosRenovacion" maxlength = "50" />
	    	                                       </span>
	    	                                   </div>
	    	                               </div>
	                                   </div>
	                               </fieldset>
	                           </div>
	                           <fieldset>
	                               <div class="row">
	                                   <div class="span6">
	                                       <div class="span5"><label>A&ntilde;o: </label></div>
	                                       <div class="span7">
	                                           <span class="VehiculosUsadosRenovacion">
	                                               <input type="text" name="anioRenovacion"  id="anioRenovacion" class="VehiculosUsadosRenovacion" maxlength = "4" />
	                                           </span>
	                                       </div>
	                                   </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>Modelo: </label></div>
	                                       <div class="span7">
	                                           <span class="VehiculosUsadosRenovacion">
	                                               <input type="text" name="modeloRenovacion"  id="modeloRenovacion" class="VehiculosUsadosRenovacion"  />
	                                           </span>
	                                       </div>
	                                   </div>
	                               </div>
	                           </fieldset>
	                           <fieldset>
	                               <div class="row">
	                                   <div class="span6">
	                                       <div class="span5"><label>NIV: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="nivRenovacion"  id="nivRenovacion" class="VehiculosUsadosRenovacion" maxlength = "17" />
	                                       </div>
	                                   </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>N&uacute;mero Serie: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="numSerieRenovacion"  id="numSerieRenovacion" class="VehiculosUsadosRenovacion" maxlength = "17" />
	                                       </div>
	                                   </div>
	                               </div>
	                               <div class="row">
	                               		<div class="span6">
	                                        <div class="span5"><label>N&uacute;mero de placas: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="numPlacasRenovacion"  id="numPlacasRenovacion" class="VehiculosUsadosRenovacion" maxlength = "10" />
	                                        </div>
	                                    </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>N&uacute;mero de Motor: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="numMotorRenovacion"  id="numMotorRenovacion" class="VehiculosUsadosRenovacion" maxlength = "17" />
	                                       </div>
	                                   </div>
	                               </div>
	                               <div class="row">
	                               		<div class="span6">
	                                        <div class="span5"><label>N&uacute;mero de tarjeta de circulaci&oacute;n: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="numFolTarjCirRenovacion"  id="numFolTarjCirRenovacion" class="VehiculosUsadosRenovacion" maxlength = "40" />
	                                        </div>
	                                    </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>N&uacute;mero de pedimento: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="numPedImRenovacion"  id="numPedImRenovacion" class="VehiculosUsadosRenovacion" maxlength = "40" />
	                                       </div>
	                                   </div>
	                               </div>
	                               <div class="row">
	                               	    <div class="span6">
	                                        <div class="span5"><label>Aduana: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="aduanaRenovacion"  id="aduanaRenovacion" class="VehiculosUsadosRenovacion"  />
	                                        </div>
	                                    </div>
	                                    <div class="span6">
	                                       <div class="span5"><label>Fecha Regularizaci&oacute;n: </label></div>
	                                       <div class="span7">
	    		                                <div id="mfechaRegularizacionRenovacion" class="input-append">
	    		                                    <input type="text" id="fechaRegularizacionRenovacion" name="fechaRegularizacionRenovacion" class="VehiculosUsadosRenovacion">
	    		                                    <span class="add-on">
	    		                                        <i class="icon-calendar"></i>
	    		                                    </span>
	    		                                </div>
	                                		</div>
	                                   </div>
	                               </div>
	                               <div class="row">
	                               		<div class="span6">
	                                        <div class="span5"><label>Folio fiscal: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="foliofiscalRenovacion"  id="foliofiscalRenovacion" class="VehiculosUsadosRenovacion" maxlength = "36" />
	                                        </div>
	                                    </div>
	                               </div>
	                           </fieldset>
	                       </fieldset>
	    	               <div class="row">
	    	                   <div class="span2 offset9">
	    	                       <a id="btnUsadosRenovacion" class="btn btn-primary">Agregar</a>
	    	                   </div>
	    	                </div>
	    	                <div id="mUsadosRenovacion" class="overloadedTable clear separate">
	            				<table id="tablaUsadosRenovacion" class="table-striped table-hover table-bordered text-center">
	            					<thead>
	            						<tr>
	            							<th class="span1">Precio</th>
	            							<th class="span1">Tipo</th>
	            							<th class="span1">Marca</th>
	            							<th class="span1">Clase</th>
	            							<th class="span1">A&ntilde;o</th>
	            							<th class="span1">Modelo</th>
	            							<th class="span1">NIV</th>
	            							<th class="span1">N.Serie</th>										
	            							<th class="span1">N.Placas</th>
	            							<th class="span1">N.Motor</th>
	            							<th class="span1">N.T.Cir</th>
	            							<th class="span1">N.Ped</th>
	            							<th class="span1">Aduana</th>
	            							<th class="span1">Fecha</th>
	            							<th class="span1">FolioF.</th>
	            							<th class="span1"></th>
	            						</tr>
	            					</thead>
	            					<tbody>
	            					</tbody>
	            				</table>
	    			        </div>
	                    </div>
	                </div>
	            </div>
	            <div id="sustitucion" style="display: none;">
	            	<div class="row">
	   	                <div class="span6">
	   	                    <div class="span5"><label>Veh&iacute;culo Enajenado: </label></div>
	   	                    <div class="span7">
	   	                         <select class="decretoSustVehicular" name="vehEnajSustitucion" id="vehEnajSustitucion">
	   	                                <option value="">Seleccionar</option>
	   	                                <option value="01"> Nuevo  </option>
	   	                                <option value="02"> Seminuevo </option>
	   	                            </select>
	   	                    </div>
	   	                </div>
	 	            </div> 
	                <div class="DecretoSustitucionVehicular row-fluid">
	                    <h4 class="blue">Decreto Sustituci&oacute;n Vehicular:</h4>
	                    <div class="row" id="decretoSustitucionUsado">
	                       <fieldset>
	                           <legend>Veh&iacute;culo Usado</legend>
	                           <div class="row-fluid">
	                               <fieldset>
	                                   <div class="row">
	                                       <div class="span6">
	                                           <div class="span5"><label for="precioVehUsadoSustitucion">Precio Veh&iacute;culo Usado</label></div>
	                                           <div class="span7">
	                                               <input type="text" id="precioVehUsadoSustitucion" name="precioVehUsadoSustitucion" class="VehiculosUsadosSustitucion" />
	                                           </div>
	                                       </div>
	                                       <div class="span6">
	                                           <div class="span5"><label>Tipo Vehículo: </label></div>
	                                           <div class="span7">
	    	                                       <select class="VehiculosUsadosSustitucion" name="tipoVehSustitucion" id="tipoVehSustitucion">
	    	                                       	<option value="">Seleccionar</option>
	    	                                		<option value="01">Tractocamiones tipo quinta rueda</option>
	    	                                		<option value="02">Camiones unitarios de 2 ejes con peso bruto vehicular m&iacute;nimo de 11,794 kg </option>
	    	                                		<option value="03">Camiones unitarios de 3 ejes con peso bruto vehicular m&iacute;nimo de 14,500 kg </option>
	    	                                		<option value="04">Autobuses integrales con capacidad de m&aacute;s de 30 asientos </option>
	    	                                		<option value="05">Autobuses convencionales con capacidad de m&aacute;s de 30 asientos </option>
	    	                                		<option value="06">Veh&iacute;culos destinados al transporte de personas de 15 pasajeros o m&aacute;s, con una antig&uuml;edad de m&aacute;s de 8 a&ntilde;os </option>
	    	                                       </select>
	                                           </div>
	                                       </div>
	                                   </div>
	                                   <div class="row">
	                                       <div class="span6">
	                                           <div class="span5"><label>Marca: </label></div>
	                                           <div class="span7">
	                                               <span class="VehiculosUsadosSustitucion">
	                                                   <input type="text" name="marcaSustitucion"  id="marcaSustitucion" class="VehiculosUsadosSustitucion" maxlength = "50" />
	                                               </span>
	                                           </div>
	                                       </div>
	                                       <div class="span6">
	    	                                   <div class="span5"><label>Tipo o Clase: </label></div>
	    	                                   <div class="span7">
	    	                                       <span class="VehiculosUsadosSustitucion">
	    	                                           <input type="text" name="tipooClaseSustitucion" id="tipooClaseSustitucion" class="VehiculosUsadosSustitucion" maxlength = "50" />
	    	                                       </span>
	    	                                   </div>
	    	                               </div>
	                                   </div>
	                               </fieldset>
	                           </div>
	                           <fieldset>
	                               <div class="row">
	                                   <div class="span6">
	                                       <div class="span5"><label>A&ntilde;o: </label></div>
	                                       <div class="span7">
	                                           <span class="VehiculosUsadosSustitucion">
	                                               <input type="text" name="anioSustitucion"  id="anioSustitucion" class="VehiculosUsadosSustitucion" maxlength = "4" />
	                                           </span>
	                                       </div>
	                                   </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>Modelo: </label></div>
	                                       <div class="span7">
	                                           <span class="VehiculosUsadosSustitucion">
	                                               <input type="text" name="modeloSustitucion"  id="modeloSustitucion" class="VehiculosUsadosSustitucion"  />
	                                           </span>
	                                       </div>
	                                   </div>
	                               </div>
	                           </fieldset>
	                           <fieldset>
	                               <div class="row">
	                                   <div class="span6">
	                                       <div class="span5"><label>NIV: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="nivSustitucion"  id="nivSustitucion" class="VehiculosUsadosSustitucion" maxlength = "17" />
	                                       </div>
	                                   </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>N&uacute;mero Serie: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="numSerieSustitucion"  id="numSerieSustitucion" class="VehiculosUsadosSustitucion" maxlength = "17" />
	                                       </div>
	                                   </div>
	                               </div>
	                               <div class="row">
	                               		<div class="span6">
	                                        <div class="span5"><label>N&uacute;mero de placas: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="numPlacasSustitucion"  id="numPlacasSustitucion" class="VehiculosUsadosSustitucion" maxlength = "10" />
	                                        </div>
	                                    </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>N&uacute;mero de Motor: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="numMotorSustitucion"  id="numMotorSustitucion" class="VehiculosUsadosSustitucion" maxlength = "17" />
	                                       </div>
	                                   </div>
	                               </div>
	                               <div class="row">
	                               		<div class="span6">
	                                        <div class="span5"><label>N&uacute;mero de tarjeta de circulaci&oacute;n: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="numFolTarjCirSustitucion"  id="numFolTarjCirSustitucion" class="VehiculosUsadosSustitucion" maxlength = "40" />
	                                        </div>
	                                    </div>
	                                    <div class="span6">
	                                       <div class="span5"><label>N&uacute;mero de Folio Aviso Intenci&oacute;n: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="numFolAvisointSustitucion"  id="numFolAvisointSustitucion" class="VehiculosUsadosSustitucion" maxlength = "20" />
	                                       </div>
	                                   </div>
	                               </div>
	                               <div class="row">
	                               		<div class="span6">
	                                       <div class="span5"><label>N&uacute;mero de pedimento: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="numPedImSustitucion"  id="numPedImSustitucion" class="VehiculosUsadosSustitucion" maxlength = "40" />
	                                       </div>
	                                   </div>
	                               		<div class="span6">
	                                        <div class="span5"><label>Aduana: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="aduanaSustitucion"  id="aduanaSustitucion" class="VehiculosUsadosSustitucion"  />
	                                        </div>
	                                    </div>
	                               </div>
	                               <div class="row">
	                               		<div class="span6">
	                                       <div class="span5"><label>Fecha Regularizaci&oacute;n: </label></div>
	                                       <div class="span7">
	    		                                <div id="mfechaRegularizacionSustitucion" class="input-append">
	    		                                    <input type="text" id="fechaRegularizacionSustitucion" name="fechaRegularizacionSustitucion" class="VehiculosUsadosSustitucion">
	    		                                    <span class="add-on">
	    		                                        <i class="icon-calendar"></i>
	    		                                    </span>
	    		                                </div>
	                                		</div>
	                                   </div>
	                               		<div class="span6">
	                                        <div class="span5"><label>Folio fiscal: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="foliofiscalSustitucion"  id="foliofiscalSustitucion" class="VehiculosUsadosSustitucion" maxlength = "36" />
	                                        </div>
	                                    </div>
	                               </div>
	                           </fieldset>
	                       </fieldset>
	                   </div>
	                   <div class="row" id="decretoSustitucionNuevo" >
	                       <fieldset>
	                           <legend>Veh&iacute;culo Nuevo o Seminuevo</legend>
	                           <div class="row-fluid">
	                               <fieldset>
	                                   <div class="row">
	                                       <div class="span6">
	                                           <div class="span5"><label>A&ntilde;o: </label></div>
	    		                                   <div class="span7">
	    		                                       <span class="VehiculoNuvoSustitucion">
	    		                                           <input type="text" name="anioVehiculoNuvo"  id="anioVehiculoNuvo" class="VehiculoNuvoSustitucion" maxlength = "4" />
	    		                                       </span>
	    		                                   </div>
	                                       </div>
	                                       <div class="span6">
	                                           <div class="span5"><label>Modelo: </label></div>
	                                           <div class="span7">
	    	                                       <span class="VehiculoNuvoSustitucion">
	    	                                           <input type="text" name="modeloVehiculoNuvo"  id="modeloVehiculoNuvo" class="VehiculoNuvoSustitucion"  />
	    	                                       </span>
	    	                                   </div>
	                                       </div>
	                                   </div>
	                                   <div class="row">
	                               		<div class="span6">
	                                        <div class="span5"><label>N&uacute;mero de placas: </label></div>
	                                        <div class="span7">
	                                            <input type="text" name="numeroPlacasVehiculoNuvo"  id="numeroPlacasVehiculoNuvo" class="VehiculoNuvoSustitucion" maxlength = "10" />
	                                        </div>
	                                    </div>
	                                   <div class="span6">
	                                       <div class="span5"><label>R.F.C.: </label></div>
	                                       <div class="span7">
	                                           <input type="text" name="rfcVehiculoNuvo"  id="rfcVehiculoNuvo" class="VehiculoNuvoSustitucion" maxlength = "17" />
	                                       </div>
	                                   </div>
	                               </div>
	                               </fieldset>
	                           </div>
	                       </fieldset>
	                   </div>
	                </div>
	            </div>
	        </div>
	    </div><!-- accord inner -->
</div><!-- accord group -->
