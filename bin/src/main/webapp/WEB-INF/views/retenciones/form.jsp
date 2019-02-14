<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    <jsp:useBean id="random" class="java.util.Random" scope="application" />
    <jsp:include page="/WEB-INF/views/layout/header.jsp" />


    <style>
    h4.blue {
         background: #26296B;
         color: white;
         padding: 2px;
         font-size: 15px;
         font-weight: bold;
         border: 1px solid #26296B;
    }

    .tablaTotal {
         background:  #f5f5f5;
         margin: 0 auto;
         width: 98%;
    }

    .txt-none {
         color: #f5f5f5;
    }

    .invoice {
         width: 90%;
        /*     width: 1024px; */
        margin: 0 auto;
        padding: 10px;
        -moz-box-shadow: 3px 3px 10px 3px #777777;
        -webkit-box-shadow: 3px 3px 10px 3px #777777;
        box-shadow: 3px 3px 10px 3px #777777;
    }

    .invoice label {
         font-size: 15px !important;
         margin-left: 7px;
    }
    input{ height: auto !important; }
    select{ height: 26px !important; }
    input,
    select,
    .add-on {
         padding: 2px !important;
         font-size: 13px !important;
    }

    .obligatorio {
         background: #DEF2F6 !important;
    }

    .mTabla {
         margin-top: 10px;
         height: 100px;
          max-height: 200px;
          overflow: auto;
        width: 98%;
        margin: 0 auto;
    }

    .mTabla th {
         background: #26296B;
         color: white;
         padding: 3px;
    }

    #formRetenciones select, #formRetenciones input, #formRetenciones textarea{width: 100%;}
    /*#formRetenciones input{width: 100%;}*/
    #formRetenciones input.fecha{cursor: pointer;text-align: right;}
    #formRetenciones div.input-prepend{width: 95%;}
    #formRetenciones input.right{text-align: right;}
    #divSeries div.contenido{display: inline-block;margin-left: 0;}
    #divSeries label{
        display: block;
        border:1px solid;
        margin: 0;
        text-align: center;
    }
    #formRetenciones .accordion-heading a:hover, td a:hover {
        color: #9E8531;
        text-decoration: none;
    }
    #formRetenciones .accordion-heading a, td a {
        color: #202c6c;
        text-decoration: none;
    }
</style>

<div class="invoice container form-inline">
	<%--<form:form method="post" id="formRetencionesFile" enctype="multipart/form-data"  modelAttribute="uploadedFile" action="timbrarRetencionesFile">
        <table>
        <tr>
        <td>Timbrar Retenciones: </td>
        <td><input type="file" name="file" />
        </td>
        <td style="color: red; font-style: italic;"><form:errors
        path="file" />
        </td>
        </tr>
        <tr>
        <td> </td>
        <td><input type="submit" class="btn btn-primary" value="Subir Retenciones" />
        </td>
        <td> </td>
        </tr>
        </table>
    </form:form>--%>
	<form name="retenciones" id="formRetenciones">
		<div id="header-invoice" class="container-fluid">
		    <div class="row-fluid">
		        <div class="span2 "><!-- Logotipo -->
		            <img src="<c:url value="/images/logo/" />${datosE.tenantId}" class="img-polaroid">
		        </div>
		        <div class="span6"><!-- Datos Fiscales del Emisor -->
		            <div class="row-fluid">
		                <div class="span4">
		                    <label><b>Raz&oacute;n Social: </b></label>
		                </div>
		                <div class="span6">
		                    <span>${datosE.razonSocial}
		                    <input type="hidden" name="NomDenRazSocE" class="emisor" value="${datosE.razonSocial}" /></span>
		                </div>
		            </div>
		            <div class="row-fluid">
		                <div class="span4"><label><b>R.F.C. Emisor: </b></label></div>
		                <div class="span6"><span>${datosE.rfc}<input type="hidden" name=RFCEmisor class="emisor" value="${datosE.rfc}" /></span></div>
		            </div>
		            <div class="row-fluid">
		                <div class="span4"><label for="CURPE"><b>C.U.R.P.: </b></label></div>
		                <div class="span6"><input type="text" id="CURPE" maxlength="20" size="20" name="CURPE" class="emisor" /></div>
		            </div>
		            <p>
		            	<b>Código Postal</b>
		                <span>${datosE.codigoPostal}<input type="hidden" name="codigoPostal"  value="${datosE.codigoPostal}" /></span>
		            </p>
		        </div>
		        <div class="span4 row-fluid" id="divSeries" style="margin-top: 5px">
		            <h6>COMPROBANTE FISCAL DIGITAL A TRAV&Eacute;S DE INTERNET</h6>
		            <input type="hidden" name="tipoDeComprobante" value="${tipoComprobante}" class="retenciones"/>
		            <div style="margin: auto;margin-bottom: 10px;width: 90%">
			            <div class="contenido" style="width: 45%">
			                <label for="FolioInt">Folio</label>
			                <input type="text" id="FolioInt" name="FolioInt" class="retenciones text-center" placeholder="" />
			            </div>
			            <div class="contenido" style="width: 45%;height: 26px !important;">
			                <label for="FechaExp">Fecha</label>
			                <select name="FechaExp" id="FechaExp" class="retenciones text-center">
			                    <option value="${fecha}" selected="selected">${fn:substring(fecha, 0, 10)}</option>
			                </select>
			            </div>
		            </div>
		            <%-- <table class="span3 blue table-bordered">
		                <tr><th><label>Folio</label></th></tr>
		                <tr><td><input type="text" id="FolioInt" name="FolioInt" class="retenciones text-center" placeholder=""></td></tr>
		            </table>
		            <table class="span3 blue table-bordered">
		                <tr><th><label>Fecha</label></th></tr>
		                <tr><td>
		                <select name="FechaExp" id="FechaExp" class="retenciones text-center">
		                    <option value="${fecha}" selected="selected">${fn:substring(fecha, 0, 10)}</option>
		                </select>

		                </td></tr>
		            </table> --%>
		        <!-- </div>

		        <div class="span4" style="margin: 0; padding: 0; height: 36px; margin-top: 3px;"> -->
		            <div class="row-fluid">
		                <div class="span5">
		                    <span><b>Tipo de CFDI: </b> &nbsp;</span>
		                </div>
		                <div class="span7">
		                    <select id="btnTipoComprobante">
		                        <option value="fa" ${tipoComprobante == "rp" ? "selected" : ""}>Retenciones</option>
		                        <option value="fa" ${tipoComprobante == "fa" ? "selected" : ""}>Factura</option>
		                        <option value="rh" ${tipoComprobante == "rh" ? "selected" : ""}>Recibo de Honorarios</option>
		                        <option value="ra" ${tipoComprobante == "ra" ? "selected" : ""}>Recibo de Arrendamiento</option>
		                        <option value="ca" ${tipoComprobante == "ca" ? "selected" : ""}>Nota de Cargo</option>
		                        <option value="cr" ${tipoComprobante == "cr" ? "selected" : ""}>Nota de Cr&eacute;dito</option>
		                        <option value="rd" ${tipoComprobante == "rd" ? "selected" : ""}>Recibo de Donativo</option>
		                        <option value="cp" ${tipoComprobante == "cp" ? "selected" : ""}>Carta Porte</option>
		                        <option value="fa" ${tipoComprobante == "rn" ? "selected" : ""}>Recibo de n&oacute;mina</option>
		                        <option value="pa" ${tipoComprobante == "pa" ? "selected" : ""}>Pagos</option>
		                    </select>
		                </div>
		            </div>
		        </div>
		    </div>
		</div><!-- fin header -->
		<div class="panelReceptor">
		    <h4 class="blue">Retenci&oacute;n:</h4>
		    <div class="row-fluid">
		        <div class="span6">
		            <div class="span5">
		                 <label for="CveRetenc">Clave Retenci&oacute;n: </label>
		            </div>
		            <div class="span7">
		                <select id="CveRetenc" name="CveRetenc" class="retenciones">
		                    <option value="">Seleccionar</option>
		                    <option value="01">Servicios profesionales</option>
		                    <option value="02">Regal&iacute;as por derechos de autor</option>
		                    <option value="03">Autotransporte terrestre de carga</option>
		                    <option value="04">Servicios prestados por comisionistas</option>
		                    <option value="05">Arrendamiento</option>
		                    <option value="06">Enajenación de acciones</option>
		                    <option value="07">Enajenaci&oacute;n de bienes objeto de la LIEPS, a trav&eacute;s de mediadores, agentes, representantes, corredores, consignatarios o distribuidores</option>
		                    <option value="08">Enajenaci&oacute;n de bienes inmuebles consignada en escritura p&uacute;blica</option>
		                    <option value="09">Enajenaci&oacute;n de otros bienes, no consignada en escritura p&uacute;blica</option>
		                    <option value="10">Adquisici&oacute;n de desperdicios industriales</option>
		                    <option value="11">Adquisici&oacute;n de bienes consignada en escritura p&uacute;blica</option>
		                    <option value="12">Adquisici&oacute;n de otros bienes, no consignada en escritura p&uacute;blica</option>
		                    <option value="13">Otros retiros de AFORE</option>
		                    <option value="14">Dividendos o utilidades distribuidas</option>
		                    <option value="15">Remanente distribuible</option>
		                    <option value="16">Intereses</option>
		                    <option value="17">Arrendamiento en fideicomiso</option>
		                    <option value="18">Pagos realizados a favor de residentes en el extranjero</option>
		                    <option value="19">Enajenaci&oacute;n de acciones u operaciones en bolsa de valores</option>
		                    <option value="20">Obtención de premios</option>
		                    <option value="21">Fideicomisos que no realizan actividades empresariales</option>
		                    <option value="22">Planes personales de retiro</option>
		                    <option value="23">Intereses reales deducibles por créditos hipotecarios</option>
		                    <option value="24">Operaciones Financieras Derivadas de Capital</option>
		                    <option value="25">Otro tipo de retenciones</option>
		                </select>
		            </div>
		        </div>
		        <div class="span6">
		            <div class="span5"><label for="DescRetenc">Descripci&oacute;n: </label></div>
		            <div class="span7"><input type="text" id="DescRetenc" name="DescRetenc" autocomplete="off" class="obligatorio retenciones" placeholder="Descripci&oacute;n:" /></div>
		        </div>
		    </div>
		    <div class="row-fluid">
		        <h4 class="blue">Datos del Receptor:</h4>
		        <div class="divRow panelReceptor-body">
		           	<div class="span6">
		               	<div class="span5"><label for="nacionalidad">Nacionalidad: </label></div>
		               	<div class="span7">
		               		<select name="nacionalidad" id="nacionalidad" class="obligatorio receptor nacionalidad">
			                   	<option value="">Seleccionar</option>
			                   	<option value="Nacional">Nacional</option>
			                	<option value="Extranjero">Extranjero</option>
		               		</select>
		               	</div>
		        	</div>
		        	<div class="span6"></div>
		        </div>
		        <div class="divRow row-fluid">
		            <div id ="Nacional" class="box" style="display: none;">
		            	<div class="row-fluid">
			                <div class="span9">
				                <div class="span4"><label for="nomDenRazSocR">Nombre o Denominaci&oacute;n Social: </label></div>
				                <div class="span8"><input class="span7 receptorNacional obligatorio " id="nomDenRazSocR" autocomplete="off" name="nomDenRazSocR" type="text" placeholder="Nombre o Denominaci&oacute;n Social" /></div>
			                </div>
			            </div>
		                <div class="row-fluid">
			            	<div class="span9">
				                <div class="span4"><label for="rfcRecep">R.F.C.: </label></div>
				                <div class="span8"><input type="text" id="rfcRecep" name="rfcRecep" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio receptorNacional" placeholder="R.F.C. Receptor" /></div>
			                </div>
		                </div>
		                <div class="row-fluid">
			                <div class="span9">
			                	<div class="span4"><label for="curpR">C.U.R.P.: </label></div>
			                	<div class="span8"><input class="span7 receptorNacional obligatorio " id="curpR" autocomplete="off" name="curpR" type="text" placeholder="CURP" /></div>
			                </div>
		                </div>
		            </div>
		            <div id ="Extranjero" class="box" style="display: none;">
		            	<div class="row-fluid">
			            	<div class="span9">
				            	<div class="span4"><label for="numRegIdTrib">N&uacute;mero de Registro de Identificaci&oacute;n Fiscal: </label></div>
				               	<div class="span8"><input class="span7 receptorExtranjero obligatorio " id="numRegIdTrib" autocomplete="off" name="numRegIdTrib" type="text" placeholder="N&uacute;mero de Registro de Identificaci&oacute;n Fiscal" /></div>
			               	</div>
		               	</div>
		               	<div class="row-fluid">
		               		<div class="span9">
				               	<div class="span4"><label for="nomDenRazSocREx">Nombre o Denominaci&oacute;n Social: </label></div>
				               	<div class="span8"><input class="span7 receptorExtranjero obligatorio " id="nomDenRazSocREx" autocomplete="off" name="nomDenRazSocREx" type="text" placeholder="Nombre o Denominaci&oacute;n Social" /></div>
				            </div>
		               	</div>
		            </div>
		        </div>
		          <!-- </div> -->
		    </div>
		</div><!-- panelReceptor -->
		<div class="panelPeriodo">
		  	<h4 class="blue">Per&iacute;odo:</h4>
		  	<div class="panelPeriodo-body row-fluid">
		  		<div class="span4">
			   		<div class="span5"><label for="mesIni">Mes Inicio: </label></div>
			   		<div class="span7">
			   			<select name="mesIni" id="mesIni" class="obligatorio periodo">
					       	<option value="">Seleccionar</option>
					        <option value="1">1</option>
					        <option value="2">2</option>
					        <option value="3">3</option>
					        <option value="4">4</option>
					        <option value="5">5</option>
					        <option value="6">6</option>
					        <option value="7">7</option>
					        <option value="8">8</option>
					        <option value="9">9</option>
					        <option value="10">10</option>
					        <option value="11">11</option>
					        <option value="12">12</option>
				    	</select>
				    </div>
		  		</div>
			    <div class="span4">
			   		<div class="span5"><label for="mesFin">Mes Final: </label></div>
			   		<div class="span7">
				   		<select name="mesFin" id="mesFin" class="obligatorio periodo">
				           	<option value="">Seleccionar</option>
				            <option value="1">1</option>
				            <option value="2">2</option>
				            <option value="3">3</option>
				            <option value="4">4</option>
				            <option value="5">5</option>
				            <option value="6">6</option>
				            <option value="7">7</option>
				            <option value="8">8</option>
				            <option value="9">9</option>
				            <option value="10">10</option>
				            <option value="11">11</option>
				            <option value="12">12</option>
				       	</select>
				       	</div>
			    </div>
		       	<div class="span4">
			   		<div class="span5"><label for="ejerc">Ejercicio: </label></div>
			   		<div class="span7">
			   			<select name="ejerc" id="ejerc" class="obligatorio periodo">
				        	<option value="">Seleccionar</option>
				            <option value="2004">2004</option>
				            <option value="2005">2005</option>
				            <option value="2006">2006</option>
				            <option value="2007">2007</option>
				            <option value="2008">2008</option>
				            <option value="2009">2009</option>
				            <option value="2010">2010</option>
				            <option value="2011">2011</option>
				            <option value="2012">2012</option>
				            <option value="2013">2013</option>
				            <option value="2014">2014</option>
				            <option value="2015">2015</option>
				            <option value="2016">2016</option>
				            <option value="2017">2017</option>
				            <option value="2018">2018</option>
				            <option value="2019">2019</option>
				            <option value="2020">2020</option>
				            <option value="2021">2021</option>
				            <option value="2022">2022</option>
				            <option value="2023">2023</option>
				            <option value="2024">2024</option>
				       	</select>
				    </div>
		       	</div>
		   </div>
		</div><!-- panelPeriodo -->
		<div class="panelTotales">
		 	<h4 class="blue">Totales:</h4>
		  	<div class="panelTotales-body">
		  		<div class="row-fluid divRow">
		  			<div class="span6">
				   		<div class="span5"><label for="montoTotOperacion">Monto Total Operaci&oacute;n: </label></div>
				   		<div class="span7"><input class="span2 totales obligatorio " id="montoTotOperacion" autocomplete="off" name="montoTotOperacion" type="text" placeholder="Monto Total Operaci&oacute;n" /></div>
			   		</div>
			   		<div class="span6">
				   		<div class="span5"><label for="montoTotGrav">Monto Total Gravado: </label></div>
				   		<div class="span7"><input class="span2 totales obligatorio " id="montoTotGrav" autocomplete="off" name="montoTotGrav" type="text" placeholder="Monto Total Gravado" /></div>
			   		</div>
		   		</div>
		   		<div class="row-fluid divRow">
		   			<div class="span6">
				   		<div class="span5"><label for="montoTotExent">Monto Total Exento: </label></div>
				   		<div class="span7"><input class="span2 totales obligatorio " id="montoTotExent" autocomplete="off" name="montoTotExent" type="text" placeholder="Monto Total Exento" /></div>
			   		</div>
			   		<div class="span6">
				   		<div class="span5"><label for="montoTotRet">Monto Total Retenciones: </label></div>
				   		<div class="span7"><input class="span2 totales obligatorio " id="montoTotRet" autocomplete="off" name="montoTotRet" type="text" placeholder="Monto Total Retenciones" /></div>
			   		</div>
		   		</div>
		  	</div>
		</div><!-- panelTotales -->
		<br>
		<div id="formAgregarImpuesto"><!--Impuestos -->
		    <h4 class="blue">Agregar Impuesto</h4>
		    <div class="form-inline">
		        <div class="row-fluid">
		           	<div class="span6">
			           	<div class="span5"><label for="baseRet">Base del Impuesto: </label></div>
			           	<div class="span7"><input type="text" id="baseRet" name="baseRet" class="input" /></div>
		           	</div>
		           	<div class="span6">
			           	<div class="span5"><label for="impuesto">Tipo Impuesto: </label></div>
			           	<div class="span7">
			           		<select id="impuesto" name="impuesto" module="retenciones" class="obligatorio impuesto">
				               	<option value="">Seleccionar</option>
				                <option value="01">ISR</option>
				                <option value="02">IVA</option>
				                <option value="03">IEPS</option>
				            </select>
				        </div>
		           	</div>
		        </div>
		        <div class="row-fluid">
		           	<div class="span6">
			           	<div class="span5"><label for="montoRet">Importe: </label></div>
			           	<div class="span7"><input type="text" id="montoRet" name="montoRet" class="input" /></div>
					</div>
					<div class="span6">
						<div class="span5"><label for="tipoPagoRet">Tipo de Pago: </label></div>
			           	<div class="span7">
				           	<select name="tipoPagoRet" id="tipoPagoRet" module="retenciones" class="obligatorio tipoPagoRet">
				               	<option value="">Seleccionar</option>
								<option value="Pago definitivo">Pago definitivo</option>
				                <option value="Pago provisional">Pago provisional</option>
				           	</select>
				        </div>
		           	</div>
		       	</div>
		       	<div class="row-fluid">
		       		<div class="span2 offset10">
		           		<a href="#" id="btnAgregarImpuesto" class="btn btn-primary"><i class="icon-plus icon-white"></i> Agregar</a>
		           	</div>
		       	</div>
		    </div>
		    <div id="mImpuestos" style="overflow-y: auto;">
		        <table id="tablaImpuestos" class="table table-striped table-hover table-bordered text-center">
		            <thead>
		               	<tr>
			                <th>Base del Impuesto</th>
			                <th>Tipo Impuesto</th>
			                <th>Importe</th>
			                <th>Tipo de Pago</th>
			                <th>Eliminar</th>
		               	</tr>
		            </thead>
		       		<tbody></tbody>
		        </table>
		    </div>
	    </div><!-- Fin impuestos -->
	    <div class="row-fluid">
	    <%--------------------------- Complementos ------------------------------------------------%>
	        <div class="accordion form-inline" id="accordion2">
	            <%-- Complemento Arrendamiento en Fideicomiso --%>
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseArrFid">
	                        Arrendamiento en Fideicomiso
	                    </a>
	                    <div id="collapseArrFid" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="pagProvEfecPorFiduc">Importe Pago Efectuado: </label></div>
			                            <div class="span7"><input type="text" id="pagProvEfecPorFiduc" name="pagProvEfecPorFiduc" class="input arrFid" /></div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="rendimFideicom">Importe de los Rendimientos Obtenidos: </label></div>
			                            <div class="span7"><input type="text" id="rendimFideicom" name="rendimFideicom" class="input arrFid" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="deduccCorresp">Importe de las Deducciones: </label></div>
			                            <div class="span7"><input type="text" id="deduccCorresp" name="deduccCorresp" class="input arrFid" /></div>
			                        </div>
			                        <div class="span6">
		                            	<div class="span5"><label for="montTotRetArr">Monto Total de la Retenci&oacute;n: </label></div>
		                            	<div class="span7"><input type="text" id="montTotRetArr" name="montTotRetArr" class="input arrFid" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
		                            	<div class="span5"><label for="montResFiscDistFibras">Monto del Resultado Fiscal Distribuido por FIBRAS: </label></div>
		                            	<div class="span7"><input type="text" id="montResFiscDistFibras" name="montResFiscDistFibras" class="input arrFid" /></div>
		                            </div>
		                            <div class="span6">
		                            	<div class="span5"><label for="montOtrosConceptDistr">Monto Otros Conceptos Distribuidos: </label></div>
		                            	<div class="span7"><input type="text" id="montOtrosConceptDistr" name="montOtrosConceptDistr" class="input arrFid" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span10">
		                            	<div class="span3"><label for="descrMontOtrosConceptDistr">Descripci&oacute;n Conceptos Distribuidos: </label></div>
		                            	<div class="span7"><input type="text" id="descrMontOtrosConceptDistr" name="descrMontOtrosConceptDistr" class="input arrFid" /></div>
		                            </div>
		                        </div>
		                    </div>
	                	</div>
	                </div>
	            </div>
	            <%-- Complemento Intereses --%>
	            <div class="accordion-group" style="clear: both;">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseIntereses">
	                        Intereses
	                    </a>
	                    <div id="collapseIntereses" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid">
		                        	<div class="span6">
		                            	<div class="span5"><label for="sistFinanciero">¿Provienen del Sistema Financiero? </label></div>
			                            <div class="span7">
			                            	<select name="sistFinanciero" id="sistFinanciero" class="intereses">
				                                <option value="">Seleccionar</option>
				                                <option value="SI">SI</option>
				                                <option value="NO">NO</option>
				                            </select>
				                        </div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="retiroAORESRetInt">¿Fueron Retirados en el Periodo o Ejercicio? </label></div>
			                            <div class="span7">
				                            <select name="retiroAORESRetInt" id="retiroAORESRetInt" class="intereses">
				                                <option value="">Seleccionar</option>
				                                <option value="SI">SI</option>
				                                <option value="NO">NO</option>
				                            </select>
				                        </div>
			                        </div>
		                        </div>
		                        <div class="row-fluid">
			                        <div class="span6">
			                            <div class="span5"><label for="operFinancDerivad">¿Corresponden a Operaciones Financieras Derivadas? </label></div>
			                            <div class="span7">
			                            	<select name="operFinancDerivad" id="operFinancDerivad" class="intereses">
				                                <option value="">Seleccionar</option>
				                                <option value="SI">SI</option>
				                                <option value="NO">NO</option>
				                            </select>
				                        </div>
			                        </div>
		                        	<div class="span6">
			                            <div class="span5"><label for="montIntNominal">Importe del Interes Nominal </label></div>
			                            <div class="span7"><input type="text" id="montIntNominal" name="montIntNominal" class="input intereses" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
			                        <div class="span6">
			                            <div class="span5"><label for="montIntReal">Monto de los Intereses Reales </label></div>
			                            <div class="span7"><input type="text" id="montIntReal" name="montIntReal" class="input intereses" /></div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="perdida">P&eacute;rdida </label></div>
			                            <div class="span7"><input type="text" id="perdida" name="perdida" class="input intereses" /></div>
			                        </div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	            <%-- Intereses hipotecarios --%>
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseInterHipot">
	                        Intereses Hipotecarios
	                    </a>
	                    <div id="collapseInterHipot" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="creditoDeInstFinanc">¿Cr&eacute;dito Otorgado por Instituci&oacute;n Financiera? </label></div>
			                            <div class="span7">
			                            	<select name="creditoDeInstFinanc" id="creditoDeInstFinanc" class="interesesHipot">
				                                <option value="">Seleccionar</option>
				                                <option value="SI">SI</option>
				                                <option value="NO">NO</option>
				                            </select>
				                        </div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="saldoInsoluto">Saldo Insoluto: </label></div>
			                            <div class="span7"><input type="text" id="saldoInsoluto" name="saldoInsoluto" class="input interesesHipot" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="propDeducDelCredit">Proporci&oacute;n Deducible del Cr&eacute;dito: </label></div>
			                            <div class="span7"><input type="text" id="propDeducDelCredit" name="propDeducDelCredit" class="input interesesHipot" /></div>
		                        	</div>
		                        	<div class="span6">
			                            <div class="span5"><label for="montTotIntNominalesDev">Monto Total Intereses Nominales Devengados: </label></div>
			                            <div class="span7"><input type="text" id="montTotIntNominalesDev" name="montTotIntNominalesDev" class="input interesesHipot" /></div>
		                        	</div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="montTotIntNominalesDevYPag">Monto Total Intereses Nominales Devengados y Pagados: </label></div>
			                            <div class="span7"><input type="text" id="montTotIntNominalesDevYPag" name="montTotIntNominalesDevYPag" class="input interesesHipot" /></div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="montTotIntRealPagDeduc">Monto Total Intereses Reales Pagados Deducibles: </label></div>
			                            <div class="span7"><input type="text" id="montTotIntRealPagDeduc" name="montTotIntRealPagDeduc" class="input interesesHipot" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span10">
			                            <div class="span3"><label for="numContrato">N&uacute;mero de Contrato: </label></div>
			                            <div class="span7">
			                            	<textarea id="numContrato" name="numContrato" autocomplete="off" class="interesesHipot" rows="2"></textarea>
			                            </div>
		                        	</div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	            <!-- Operaciones Derivados -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOpDerivados">
	                        Operaciones con Derivados
	                    </a>
	                    <div id="collapseOpDerivados" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid">
		                        	<div class="span6">
				                        <div class="span5"><label for="montGanAcum">Monto Ganancia Acumulable: </label></div>
				                        <div class="span7"><input type="text" id="montGanAcum" name="montGanAcum" class="input opDerivados" /></div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="montPerdDed">Monto P&eacute;rdida Deducible: </label></div>
			                            <div class="span7"><input type="text" id="montPerdDed" name="montPerdDed" class="input opDerivados" /></div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	            <!-- Planes de Retiro -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapsePlanRetiro">
	                        Planes de Retiro
	                    </a>
	                    <div id="collapsePlanRetiro" class="accordion-body collapse">
	                        <div class="accordion-inner">
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="sistemaFinanc">¿Son del Sistema Financiero? </label></div>
		                                <div class="span7">
			                                <select name="sistemaFinanc" id="sistemaFinanc" class="planesRetiro">
			                                    <option value="">Seleccionar</option>
			                                    <option value="SI">SI</option>
			                                    <option value="NO">NO</option>
			                                </select>
			                            </div>
	                                </div>
	                                <div class="span6">
		                                <div class="span5"><label for="montTotAportAnioInmAnterior">Monto Total Aportaciones Actualizadas: </label></div>
		                                <div class="span7"><input type="text" id="montTotAportAnioInmAnterior" name="montTotAportAnioInmAnterior" class="input planesRetiro" /></div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="montIntRealesDevengAniooInmAnt">Monto de los Intereses Reales Devengados o Percibidos: </label></div>
		                                <div class="span7"><input type="text" id="montIntRealesDevengAniooInmAnt" name="montIntRealesDevengAniooInmAnt" class="input planesRetiro" /></div>
	                                </div>
	                                <div class="span6">
		                                <div class="span5"><label for="huboRetirosAnioInmAntPer">¿Hubo Retiros de Recursos Invertidos y sus Rendimientos? </label></div>
		                                <div class="span7">
			                                <select name="huboRetirosAnioInmAntPer" id="huboRetirosAnioInmAntPer" class="planesRetiro">
			                                    <option value="">Seleccionar</option>
			                                    <option value="SI">SI</option>
			                                    <option value="NO">NO</option>
			                                </select>
			                            </div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                                <div class="span6">
		                                <div class="span5"><label for="montTotRetiradoAnioInmAntPer">Monto Total del Retiro </label></div>
		                                <div class="span7"><input type="text" id="montTotRetiradoAnioInmAntPer" name="montTotRetiradoAnioInmAntPer" class="input planesRetiro" /></div>
	                                </div>
	                                <div class="span6">
		                                <div class="span5"><label for="montTotExentRetiradoAnioInmAnt">Monto Total Exento del Retiro: </label></div>
		                                <div class="span7"><input type="text" id="montTotExentRetiradoAnioInmAnt" name="montTotExentRetiradoAnioInmAnt" class="input planesRetiro" /></div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="montTotExedenteAnioInmAnt">Monto Total Excedente del Monto Exento del Retiro</label></div>
		                                <div class="span7"><input type="text" id="montTotExedenteAnioInmAnt" name="montTotExedenteAnioInmAnt" class="input planesRetiro" /></div>
	                            	</div>
	                            	<div class="span6">
		                                <div class="span5"><label for="huboRetirosAnioInmAnt">¿Se realizaron Retiros?</label></div>
		                                <div class="span7">
			                                <select name="huboRetirosAnioInmAnt" id="huboRetirosAnioInmAnt" class="planesRetiro">
			                                    <option value="">Seleccionar</option>
			                                    <option value="SI">SI</option>
			                                    <option value="NO">NO</option>
			                                </select>
			                            </div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="montTotRetiradoAnioInmAnt">Monto Total del Retiro</label></div>
		                                <div class="span7"><input type="text" id="montTotRetiradoAnioInmAnt" name="montTotRetiradoAnioInmAnt" class="input planesRetiro" /></div>
	                                </div>
	                                <div class="span6"></div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <!-- Planes de Retiro 1.1-->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapsePlanRetiro11">
	                        Planes de Retiro 1.1
	                    </a>
	                    <div id="collapsePlanRetiro11" class="accordion-body collapse">
	                        <div class="accordion-inner">
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="sistemaFinanc11">¿Son del Sistema Financiero? </label></div>
		                                <div class="span7">
			                                <select name="sistemaFinanc11" id="sistemaFinanc11" class="planesRetiro11">
			                                    <option value="">Seleccionar</option>
			                                    <option value="SI">SI</option>
			                                    <option value="NO">NO</option>
			                                </select>
			                            </div>
	                                </div>
	                                <div class="span6">
		                                <div class="span5"><label for="montTotAportAnioInmAnterior11">Monto Total Aportaciones Actualizadas: </label></div>
		                                <div class="span7"><input type="text" id="montTotAportAnioInmAnterior11" name="montTotAportAnioInmAnterior11" class="input planesRetiro11" /></div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="montIntRealesDevengAniooInmAnt11">Monto de los Intereses Reales Devengados o Percibidos: </label></div>
		                                <div class="span7"><input type="text" id="montIntRealesDevengAniooInmAnt11" name="montIntRealesDevengAniooInmAnt11" class="input planesRetiro11" /></div>
	                                </div>
	                                <div class="span6">
		                                <div class="span5"><label for="huboRetirosAnioInmAntPer11">¿Hubo Retiros de Recursos Invertidos y sus Rendimientos? </label></div>
		                                <div class="span7">
			                                <select name="huboRetirosAnioInmAntPer11" id="huboRetirosAnioInmAntPer11" class="planesRetiro11">
			                                    <option value="">Seleccionar</option>
			                                    <option value="SI">SI</option>
			                                    <option value="NO">NO</option>
			                                </select>
			                            </div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                                <div class="span6">
		                                <div class="span5"><label for="montTotRetiradoAnioInmAntPer11">Monto Total del Retiro </label></div>
		                                <div class="span7"><input type="text" id="montTotRetiradoAnioInmAntPer11" name="montTotRetiradoAnioInmAntPer11" class="input planesRetiro11" /></div>
	                                </div>
	                                <div class="span6">
		                                <div class="span5"><label for="montTotExentRetiradoAnioInmAnt11">Monto Total Exento del Retiro: </label></div>
		                                <div class="span7"><input type="text" id="montTotExentRetiradoAnioInmAnt11" name="montTotExentRetiradoAnioInmAnt11" class="input planesRetiro11" /></div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="montTotExedenteAnioInmAnt11">Monto Total Excedente del Monto Exento del Retiro</label></div>
		                                <div class="span7"><input type="text" id="montTotExedenteAnioInmAnt11" name="montTotExedenteAnioInmAnt11" class="input planesRetiro11" /></div>
	                            	</div>
	                            	<div class="span6">
		                                <div class="span5"><label for="huboRetirosAnioInmAnt11">¿Se realizaron Retiros?</label></div>
		                                <div class="span7">
			                                <select name="huboRetirosAnioInmAnt11" id="huboRetirosAnioInmAnt11" class="planesRetiro11">
			                                    <option value="">Seleccionar</option>
			                                    <option value="SI">SI</option>
			                                    <option value="NO">NO</option>
			                                </select>
			                            </div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
	                            	<div class="span6">
		                                <div class="span5"><label for="montTotRetiradoAnioInmAnt11">Monto Total de Retiros</label></div>
		                                <div class="span7"><input type="text" id="montTotRetiradoAnioInmAnt11" name="montTotRetiradoAnioInmAnt11" class="input planesRetiro11" /></div>
	                                </div>
	                                 <div class="span6">
		                                <div class="span5"><label for="numReferencia11">Número de Referencia: </label></div>
		                                <div class="span7"><input type="text" id="numReferencia11" name="numReferencia11" class="input planesRetiro11" maxlength="300"/></div>
	                                </div>
	                            </div>
	                            <div class="row-fluid">
				                <fieldset>
				                    <legend>Aportaciones o Depósitos:</legend>
				                    <h4 class="blue">Aportación o Depósito:</h4>
				                    <div id="mAportacionODeposito">
				                        <table id="tablaAportacionODeposito" class="table table-striped table-hover table-bordered text-center">
				                            <thead>
				                                <tr>
				                                    <th class="span1">Tipo</th>
				                                    <th class="span1">Monto</th>
				                                    <th class="span4">RFC Fiduciaria</th>
				                                    <th class="span1"></th>
				                                </tr>
				                            </thead>
				                            <tbody>
				                            </tbody>
				                        </table>
				                    </div>
				                    <div class="row-fluid">
				                        <div class="row-fluid">
				                            <div class="span6">
				                                <div class="span5"><label>Tipo Aportacion / Deposito:</label></div>
				                                <div class="span7">
				                                    <select name="tipoAportacionODeposito" id="tipoAportacionODeposito" class="aportacionODeposito">
					                                    <option value="">Seleccionar</option>
					                                    <option value="a">Aportaciones voluntarias o complementarias efectuadas en términos del artículo 151, fracción V de la LISR</option>
					                                    <option value="b">Depósitos a cuentas especiales, prima de seguros o adquisición de acciones, efectuadas en términos al artículo 185 de la LISR</option>
					                                    <option value="c">Aportaciones adicionales efectuadas en términos del artículo 258</option>
					                                </select>
				                                </div>
				                            </div>
			                            </div>
				                        <div class="row-fluid">
				                            <div class="span6">
				                                <div class="span5"><label>Monto:</label></div>
				                                <div class="span7">
				                                    <input type="text" class="aportacionODeposito" id="montAportODep" name="montAportODep" />
				                                </div>
				                            </div>
				                            <div class="span6">
				                                <div class="span5"><label>RFC Fiduciaria:</label></div>
				                                <div class="span7">
				                                    <input type="text" class="aportacionODeposito" id="rfcFiduciaria" name="rfcFiduciaria" />
				                                </div>
				                            </div>
				                        </div>
				                        <div class="row">
				                            <div class="span2 offset9">
				                                <input type="button" id="addAportacionODeposito" value="Agregar" class="btn btn-primary" />
				                            </div>
				                        </div>
				                    </div>
				                </fieldset>
				            	</div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <!-- Premios -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapsePremios">
	                        Premios
	                    </a>
	                    <div id="collapsePremios" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid">
		                            <div class="span6">
			                            <div class="span5"><label for="entidadFederativa">Entidad Federativa </label></div>
			                            <div class="span7">
				                            <select name="entidadFederativa" id="entidadFederativa" class="premios">
				                                <option value="">Seleccionar</option>
				                                <option value="01">AGUASCALIENTES</option>
				                                <option value="02">BAJA CALIFORNIA</option>
				                                <option value="03">BAJA CALIFORNIA SUR</option>
				                                <option value="04">CAMPECHE</option>
				                                <option value="09">CIUDAD DE MÉXICO</option>
				                                <option value="05">COAHUILA</option>
				                                <option value="06">COLIMA</option>
				                                <option value="07">CHIAPAS</option>
				                                <option value="08">CHIHUAHUA</option>
				                                <option value="09">DISTRITO FEDERAL</option>
				                                <option value="10">DURANGO</option>
				                                <option value="11">GUANAJUATO</option>
				                                <option value="12">GUERRERO</option>
				                                <option value="13">HIDALGO</option>
				                                <option value="14">JALISCO</option>
				                                <option value="15">MEXICO</option>
				                                <option value="16">MICHOACAN</option>
				                                <option value="17">MORELOS</option>
				                                <option value="18">NAYARIT</option>
				                                <option value="19">NUEVO LEON</option>
				                                <option value="20">OAXACA</option>
				                                <option value="21">PUEBLA</option>
				                                <option value="22">QUERETARO</option>
				                                <option value="23">QUINTANA ROO</option>
				                                <option value="24">SAN LUIS POTOSI</option>
				                                <option value="25">SINALOA</option>
				                                <option value="26">SONORA</option>
				                                <option value="27">TABASCO</option>
				                                <option value="28">TAMAULIPAS</option>
				                                <option value="29">TLAXCALA</option>
				                                <option value="30">VERACRUZ</option>
				                                <option value="31">YUCATAN</option>
				                                <option value="32">ZACATECAS</option>
				                            </select>
				                        </div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="montTotPago">Importe Pago Realizado: </label></div>
			                            <div class="span7"><input type="text" id="montTotPago" name="montTotPago" class="input premios" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="montTotPagoGrav">Importe Gravado: </label></div>
			                            <div class="span7"><input type="text" id="montTotPagoGrav" name="montTotPagoGrav" class="input premios" /></div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="montTotPagoExent">Monto Total Exento: </label></div>
			                            <div class="span7"><input type="text" id="montTotPagoExent" name="montTotPagoExent" class="input premios" /></div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	            <!-- Sector Financiero -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseSectorFin">
	                        Sector Financiero
	                    </a>
	                    <div id="collapseSectorFin" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid">
		                            <div class="span6">
			                            <div class="span5"><label for="idFideicom">Identificador o N&uacute;mero del Fideicomiso: </label></div>
			                            <div class="span7"><input type="text" id="idFideicom" name="idFideicom" class="input sectorFin" /></div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="nomFideicom">Nombre del Fideicomiso: </label></div>
			                            <div class="span7"><input type="text" id="nomFideicom" name="nomFideicom" class="input sectorFin" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span10">
			                            <div class="span3"><label for="descripFideicom">Objeto o Fin del Fideicomiso: </label></div>
			                            <div class="span7"><textarea id="descripFideicom" name="descripFideicom" autocomplete="off" class="sectorFin" rows="3"></textarea></div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	            <!-- Enajenacion de Acciones -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseEnajenacionAcc">
	                        Enajenaci&oacute;n de Acciones
	                    </a>
	                    <div id="collapseEnajenacionAcc" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid" style="margin-bottom: 10px; ">
		                        	<div class="span10">
		                            	<div class="span3"><label for="contratoIntermediacion">Descripci&oacute;n del Contrato de Intermediaci&oacute;n: </label></div>
		                            	<div class="span7"><textarea id="contratoIntermediacion" name="contratoIntermediacion" autocomplete="off" class="enajenacionAcc" rows="3"></textarea></div>
		                        	</div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="ganancia">Ganancia Obtenida: </label></div>
			                            <div class="span7"><input type="text" id="ganancia" name="ganancia" class="input enajenacionAcc" /></div>
		                        	</div>
		                        	<div class="span6">
			                            <div class="span5"><label for="perdidaEnajAcc">P&eacute;rdida: </label></div>
			                            <div class="span7"><input type="text" id="perdidaEnajAcc" name="perdidaEnajAcc" class="input enajenacionAcc" /></div>
		                        	</div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	            <!-- Pagos a Extranjeros -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapsePagosExtranjeros">
	                        Pagos a Extranjeros
	                    </a>
	                    <div id="collapsePagosExtranjeros" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div class="row-fluid">
		                            <div class="span6">
			                            <div class="span5"><label for="esBenefEfectDelCobro">¿El beneficiario del pago es la misma persona que retiene?</label></div>
			                            <div class="span7">
			                            	<select name="esBenefEfectDelCobro" id="esBenefEfectDelCobro" class="pagosExtranjeros">
			                                    <option value="">Seleccionar</option>
			                                    <option value="SI">SI</option>
			                                    <option value="NO">NO</option>
			                            	</select>
			                            </div>
		                            </div>
		                        	<div class="span6">
			                            <div class="span5"><label for="conceptoPago">Tipo de Contribuyente: </label></div>
			                            <div class="span7">
			                            	<select name="conceptoPago" id="conceptoPago" class="beneficiario">
				                                <option value="">Seleccionar</option>
				                                <option value="1">Artistas, deportistas y espect&aacute;culos p&uacute;blicos</option>
				                                <option value="2">Otras personas físicas</option>
				                                <option value="3">Persona moral</option>
				                                <option value="4">Fideicomiso</option>
				                                <option value="5">Asociaci&oacute;n en participaci&oacute;n</option>
				                                <option value="6">Organizaciones Internacionales o de gobierno</option>
				                                <option value="7">Organizaciones exentas</option>
				                                <option value="8">Agentes pagadores</option>
				                                <option value="9">Otros</option>
				                            </select>
			                            </div>
		                            </div>
		                        </div>
		                        <div class="row-fluid" style="margin-bottom: 15px">
		                        	<div class="span10">
			                            <div class="span3"><label for="descripcionConcepto">Descripci&oacute;n de la definici&oacute;n del pago: </label></div>
			                            <div class="span7"><textarea id="descripcionConcepto" name="descripcionConcepto" autocomplete="off" class="beneficiario" rows="3"></textarea></div>
		                        	</div>
		                        </div>
		                        <div id ="SI" class="benef" style="display: none;">
		                        	<div class="row-fluid">
		                        		<div class="span6">
			                               <div class="span5"><label for="rfcBenef">R.F.C. Representante Legal: </label></div>
			                               <div class="span7"><input type="text" id="rfcBenef" name="rfcBenef" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio Beneficiario" /></div>
		                               </div>
		                               <div class="span6">
			                               <div class="span5"><label for="curpBenef">C.U.R.P. Representante Legal: </label></div>
			                               <div class="span7"><input class="span7 Beneficiario obligatorio " id="curpBenef" autocomplete="off" name="curpBenef" type="text" /></div>
		                               </div>
		                        	</div>
		                        	<div class="row-fluid">
		                        		<div class="span10">
				                           <div class="span3"><label for="nomDenRazSocBenef">Nombre o Denominaci&oacute;n Social: </label></div>
				                           <div class="span7"><textarea id="nomDenRazSocBenef" name="nomDenRazSocBenef" autocomplete="off" class="Beneficiario" rows="3"></textarea></div>
		                               </div>
		                        	</div>
		                        </div>
		                        <div id ="NO" class="benef" style="display: none;">
		                         	<div class="row-fluid">
		                         		<div class="span6">
				                            <div class="span5"><label for="paisDeResidParaEfecFisc">Pa&iacute;s de Residencia: </label></div>
				                            <div class="span7">
					                            <select name="paisDeResidParaEfecFisc" id="paisDeResidParaEfecFisc" class="NoBeneficiario">
				                                    <option value="">Seleccionar</option>
				                                    <option value="AF">AFGANISTAN (EMIRATO ISLAMICO DE)</option>
				                                    <option value="AL">ALBANIA (REPUBLICA DE)</option>
				                                    <option value="DE">ALEMANIA (REPUBLICA FEDERAL DE)</option>
				                                    <option value="AD">ANDORRA (PRINCIPADO DE)</option>
				                                    <option value="AO">ANGOLA (REPUBLICA DE)</option>
				                                    <option value="AI">ANGUILA</option>
				                                    <option value="AQ">ANTARTIDA</option>
				                                    <option value="AG">ANTIGUA Y BARBUDA (COMUNIDAD BRITANICA DE NACIONES)</option>
				                                    <option value="AN">ANTILLAS NEERLANDESAS (TERRITORIO HOLANDES DE ULTRAMAR)</option>
				                                    <option value="SA">ARABIA SAUDITA (REINO DE)</option>
				                                    <option value="DZ">ARGELIA (REPUBLICA DEMOCRATICA Y POPULAR DE)</option>
				                                    <option value="AR">ARGENTINA (REPUBLICA)</option>
				                                    <option value="AM">ARMENIA (REPUBLICA DE)</option>
				                                    <option value="AW">ARUBA (TERRITORIO HOLANDES DE ULTRAMAR)</option>
				                                    <option value="AU">AUSTRALIA (COMUNIDAD DE)</option>
				                                    <option value="AT">AUSTRIA (REPUBLICA DE)</option>
				                                    <option value="AZ">AZERBAIJAN (REPUBLICA AZERBAIJANI)</option>
				                                    <option value="BS">BAHAMAS (COMUNIDAD DE LAS)</option>
				                                    <option value="BH">BAHREIN (ESTADO DE)</option>
				                                    <option value="BD">BANGLADESH (REPUBLICA POPULAR DE)</option>
				                                    <option value="BB">BARBADOS (COMUNIDAD BRITANICA DE NACIONES)</option>
				                                    <option value="BE">BELGICA (REINO DE)</option>
				                                    <option value="BZ">BELICE</option>
				                                    <option value="BJ">BENIN (REPUBLICA DE)</option>
				                                    <option value="BM">BERMUDAS</option>
				                                    <option value="BY">BIELORRUSIA (REPUBLICA DE)</option>
				                                    <option value="BO">BOLIVIA (REPUBLICA DE)</option>
				                                    <option value="BA">BOSNIA Y HERZEGOVINA</option>
				                                    <option value="BW">BOTSWANA (REPUBLICA DE)</option>
				                                    <option value="BR">BRASIL (REPUBLICA FEDERATIVA DE)</option>
				                                    <option value="BN">BRUNEI (ESTADO DE) (RESIDENCIA DE PAZ)</option>
				                                    <option value="BG">BULGARIA (REPUBLICA DE)</option>
				                                    <option value="BF">BURKINA FASO</option>
				                                    <option value="BI">BURUNDI (REPUBLICA DE)</option>
				                                    <option value="BT">BUTAN (REINO DE)</option>
				                                    <option value="CV">CABO VERDE (REPUBLICA DE)</option>
				                                    <option value="TD">CHAD (REPUBLICA DEL)</option>
				                                    <option value="KY">CAIMAN (ISLAS)</option>
				                                    <option value="KH">CAMBOYA (REINO DE)</option>
				                                    <option value="CM">CAMERUN (REPUBLICA DEL)</option>
				                                    <option value="CA">CANADA</option>
				                                    <option value="CL">CHILE (REPUBLICA DE)</option>
				                                    <option value="CN">CHINA (REPUBLICA POPULAR)</option>
				                                    <option value="CY">CHIPRE (REPUBLICA DE)</option>
				                                    <option value="VA">CIUDAD DEL VATICANO (ESTADO DE LA)</option>
				                                    <option value="CC">COCOS (KEELING, ISLAS AUSTRALIANAS)</option>
				                                    <option value="CO">COLOMBIA (REPUBLICA DE)</option>
				                                    <option value="KM">COMORAS (ISLAS)</option>
				                                    <option value="CG">CONGO (REPUBLICA DEL)</option>
				                                    <option value="CK">COOK (ISLAS)</option>
				                                    <option value="KP">COREA (REPUBLICA POPULAR DEMOCRATICA DE) (COREA DEL NORTE)</option>
				                                    <option value="KR">COREA (REPUBLICA DE) (COREA DEL SUR)</option>
				                                    <option value="CI">COSTA DE MARFIL (REPUBLICA DE LA)</option>
				                                    <option value="CR">COSTA RICA (REPUBLICA DE)</option>
				                                    <option value="HR">CROACIA (REPUBLICA DE)</option>
				                                    <option value="CU">CUBA (REPUBLICA DE)</option>
				                                    <option value="DK">DINAMARCA (REINO DE)</option>
				                                    <option value="DJ">DJIBOUTI (REPUBLICA DE)</option>
				                                    <option value="DM">DOMINICA (COMUNIDAD DE)</option>
				                                    <option value="EC">ECUADOR (REPUBLICA DEL)</option>
				                                    <option value="EG">EGIPTO (REPUBLICA ARABE DE)</option>
				                                    <option value="SV">EL SALVADOR (REPUBLICA DE)</option>
				                                    <option value="AE">EMIRATOS ARABES UNIDOS</option>
				                                    <option value="ER">ERITREA (ESTADO DE)</option>
				                                    <option value="SI">ESLOVENIA (REPUBLICA DE)</option>
				                                    <option value="ES">ESPAÑA (REINO DE)</option>
				                                    <option value="FM">ESTADO FEDERADO DE MICRONESIA</option>
				                                    <option value="US">ESTADOS UNIDOS DE AMERICA</option>
				                                    <option value="EE">ESTONIA (REPUBLICA DE)</option>
				                                    <option value="ET">ETIOPIA (REPUBLICA DEMOCRATICA FEDERAL)</option>
				                                    <option value="FJ">FIDJI (REPUBLICA DE)</option>
				                                    <option value="PH">FILIPINAS (REPUBLICA DE LAS)</option>
				                                    <option value="FI">FINLANDIA (REPUBLICA DE)</option>
				                                    <option value="FR">FRANCIA (REPUBLICA FRANCESA)</option>
				                                    <option value="GA">GABONESA (REPUBLICA)</option>
				                                    <option value="GM">GAMBIA (REPUBLICA DE LA)</option>
				                                    <option value="GE">GEORGIA (REPUBLICA DE)</option>
				                                    <option value="GH">GHANA (REPUBLICA DE)</option>
				                                    <option value="GI">GIBRALTAR (R.U.)</option>
				                                    <option value="GD">GRANADA</option>
				                                    <option value="GR">GRECIA (REPUBLICA HELENICA)</option>
				                                    <option value="GL">GROENLANDIA (DINAMARCA)</option>
				                                    <option value="GP">GUADALUPE (DEPARTAMENTO DE)</option>
				                                    <option value="GU">GUAM (E.U.A.)</option>
				                                    <option value="GT">GUATEMALA (REPUBLICA DE)</option>
				                                    <option value="GG">GUERNSEY</option>
				                                    <option value="GW">GUINEA-BISSAU (REPUBLICA DE</option>
				                                    <option value="GQ">GUINEA ECUATORIAL (REPUBLICA DE)</option>
				                                    <option value="GN">GUINEA (REPUBLICA DE)</option>
				                                    <option value="GF">GUYANA FRANCESA</option>
				                                    <option value="GY">GUYANA (REPUBLICA COOPERATIVA DE)</option>
				                                    <option value="HT">HAITI (REPUBLICA DE)</option>
				                                    <option value="HN">HU HONDURAS (REPUBLICA DE)</option>
				                                    <option value="HK">HONG KONG (REGION ADMINISTRATIVA ESPECIAL DE LA REPUBLICA)</option>
				                                    <option value="HU">HUNGRIA (REPUBLICA DE)</option>
				                                    <option value="IN">INDIA (REPUBLICA DE)</option>
				                                    <option value="ID">INDONESIA (REPUBLICA DE)</option>
				                                    <option value="IQ">IRAK (REPUBLICA DE)</option>
				                                    <option value="IR">IRAN (REPUBLICA ISLAMICA DEL)</option>
				                                    <option value="IE">IRLANDA (REPUBLICA DE)</option>
				                                    <option value="IS">ISLANDIA (REPUBLICA DE)</option>
				                                    <option value="BV">ISLA BOUVET</option>
				                                    <option value="IM">ISLA DE MAN</option>
				                                    <option value="AX">ISLAS ALAND</option>
				                                    <option value="FO">ISLAS FEROE</option>
				                                    <option value="GS">ISLAS GEORGIA Y SANDWICH DEL SUR</option>
				                                    <option value="HM">ISLAS HEARD Y MCDONALD</option>
				                                    <option value="FK">ISLAS MALVINAS (R.U.)</option>
				                                    <option value="MP">ISLAS MARIANAS SEPTENTRIONALES</option>
				                                    <option value="MH">SB ISLAS MARSHALL</option>
				                                    <option value="UM">ISLAS MENORES DE ULTRAMAR DE ESTADOS UNIDOS DE AMERICA</option>
				                                    <option value="SB">ISLAS SALOMON (COMUNIDAD BRITANICA DE NACIONES)</option>
				                                    <option value="SJ">ISLAS SVALBARD Y JAN MAYEN (NORUEGA)</option>
				                                    <option value="TK">ISLAS TOKELAU</option>
				                                    <option value="WF">ISLAS WALLIS Y FUTUNA</option>
				                                    <option value="IL">ISRAEL (ESTADO DE)</option>
				                                    <option value="IT">ITALIA (REPUBLICA ITALIANA)</option>
				                                    <option value="JM">JAMAICA</option>
				                                    <option value="JP">JAPON</option>
				                                    <option value="JE">JERSEY</option>
				                                    <option value="JO">JORDANIA (REINO HACHEMITA DE)</option>
				                                    <option value="KZ">KAZAKHSTAN (REPUBLICA DE)</option>
				                                    <option value="KE">KENYA (REPUBLICA DE)</option>
				                                    <option value="KI">KIRIBATI (REPUBLICA DE)</option>
				                                    <option value="KW">KUWAIT (ESTADO DE)</option>
				                                    <option value="KG">KYRGYZSTAN (REPUBLICA KIRGYZIA)</option>
				                                    <option value="LS">LESOTHO (REINO DE)</option>
				                                    <option value="LV">LETONIA (REPUBLICA DE)</option>
				                                    <option value="LB">LIBANO (REPUBLICA DE)</option>
				                                    <option value="LR">LIBERIA (REPUBLICA DE)</option>
				                                    <option value="LY">LIBIA (JAMAHIRIYA LIBIA ARABE POPULAR SOCIALISTA)</option>
				                                    <option value="LI">LIECHTENSTEIN (PRINCIPADO DE)</option>
				                                    <option value="LT">LITUANIA (REPUBLICA DE)</option>
				                                    <option value="LU">LUXEMBURGO (GRAN DUCADO DE)</option>
				                                    <option value="MO">MACAO</option>
				                                    <option value="MK">MACEDONIA (ANTIGUA REPUBLICA YUGOSLAVA DE)</option>
				                                    <option value="MG">MADAGASCAR (REPUBLICA DE)</option>
				                                    <option value="MY">MALASIA</option>
				                                    <option value="MW">MALAWI (REPUBLICA DE)</option>
				                                    <option value="MV">MALDIVAS (REPUBLICA DE)</option>
				                                    <option value="ML">MALI (REPUBLICA DE)</option>
				                                    <option value="MT">MALTA (REPUBLICA DE)</option>
				                                    <option value="MA">MARRUECOS (REINO DE)</option>
				                                    <option value="MQ">MARTINICA (DEPARTAMENTO DE) (FRANCIA)</option>
				                                    <option value="MU">MAURICIO (REPUBLICA DE)</option>
				                                    <option value="MR">MAURITANIA (REPUBLICA ISLAMICA DE)</option>
				                                    <option value="YT">MAYOTTE</option>
				                                    <option value="MX">MEXICO (ESTADOS UNIDOS MEXICANOS)</option>
				                                    <option value="MD">MOLDAVIA (REPUBLICA DE)</option>
				                                    <option value="MC">MONACO (PRINCIPADO DE)</option>
				                                    <option value="MN">MONGOLIA</option>
				                                    <option value="MS">MONSERRAT (ISLA)</option>
				                                    <option value="ME">MONTENEGRO</option>
				                                    <option value="MZ">MOZAMBIQUE (REPUBLICA DE)</option>
				                                    <option value="MM">MYANMAR (UNION DE)</option>
				                                    <option value="NA">NAMIBIA (REPUBLICA DE)</option>
				                                    <option value="NR">NAURU</option>
				                                    <option value="CX">NAVIDAD (CHRISTMAS) (ISLAS)</option>
				                                    <option value="NP">NEPAL (REINO DE)</option>
				                                    <option value="NI">NICARAGUA (REPUBLICA DE)</option>
				                                    <option value="NE">NIGER (REPUBLICA DE)</option>
				                                    <option value="NG">NIGERIA (REPUBLICA FEDERAL DE)</option>
				                                    <option value="NU">NIVE (ISLA)</option>
				                                    <option value="NF">NORFOLK (ISLA)</option>
				                                    <option value="NO">NORUEGA (REINO DE)</option>
				                                    <option value="NC">NUEVA CALEDONIA (TERRITORIO FRANCES DE ULTRAMAR)</option>
				                                    <option value="NZ">NUEVA ZELANDIA</option>
				                                    <option value="OM">OMAN (SULTANATO DE)</option>
				                                    <option value="PIK">PACIFICO, ISLAS DEL (ADMON. E.U.A.)</option>
				                                    <option value="NL">PAISES BAJOS (REINO DE LOS) (HOLANDA)</option>
				                                    <option value="PK">PAKISTAN (REPUBLICA ISLAMICA DE)</option>
				                                    <option value="PW">PALAU (REPUBLICA DE)</option>
				                                    <option value="PS">PALESTINA</option>
				                                    <option value="PA">PANAMA (REPUBLICA DE)</option>
				                                    <option value="PG">PAPUA NUEVA GUINEA (ESTADO INDEPENDIENTE DE)</option>
				                                    <option value="PY">PARAGUAY (REPUBLICA DEL)</option>
				                                    <option value="PE">PERU (REPUBLICA DEL)</option>
				                                    <option value="PN">PITCAIRNS (ISLAS DEPENDENCIA BRITANICA)</option>
				                                    <option value="PF">POLINESIA FRANCESA</option>
				                                    <option value="PL">POLONIA (REPUBLICA DE)</option>
				                                    <option value="PT">PORTUGAL (REPUBLICA PORTUGUESA)</option>
				                                    <option value="PR">PUERTO RICO (ESTADO LIBRE ASOCIADO DE LA COMUNIDAD DE)</option>
				                                    <option value="QA">QATAR (ESTADO DE)</option>
				                                    <option value="GB">REINO UNIDO DE LA GRAN BRETAÑA E IRLANDA DEL NORTE</option>
				                                    <option value="CZ">REPUBLICA CHECA</option>
				                                    <option value="CF">REPUBLICA CENTROAFRICANA</option>
				                                    <option value="LA">REPUBLICA DEMOCRATICA POPULAR LAOS</option>
				                                    <option value="RS">REPUBLICA DE SERBIA</option>
				                                    <option value="DO">REPUBLICA DOMINICANA</option>
				                                    <option value="SK">REPUBLICA ESLOVACA</option>
				                                    <option value="CD">REPUBLICA POPULAR DEL CONGO</option>
				                                    <option value="RW">REPUBLICA RUANDESA</option>
				                                    <option value="RE">REUNION (DEPARTAMENTO DE LA) (FRANCIA)</option>
				                                    <option value="RO">RUMANIA</option>
				                                    <option value="RU">RUSIA (FEDERACION RUSA)</option>
				                                    <option value="EH">SAHARA OCCIDENTAL (REPUBLICA ARABE SAHARAVI DEMOCRATICA)</option>
				                                    <option value="WS">SAMOA (ESTADO INDEPENDIENTE DE)</option>
				                                    <option value="AS">SAMOA AMERICANA</option>
				                                    <option value="BL">SAN BARTOLOME</option>
				                                    <option value="KN">SAN CRISTOBAL Y NIEVES (FEDERACION DE) (SAN KITTS-NEVIS)</option>
				                                    <option value="SM">SAN MARINO (SERENISIMA REPUBLICA DE)</option>
				                                    <option value="MF">SAN MARTIN</option>
				                                    <option value="PM">SAN PEDRO Y MIQUELON</option>
				                                    <option value="VC">SAN VICENTE Y LAS GRANADINAS</option>
				                                    <option value="SH">SANTA ELENA</option>
				                                    <option value="LC">SANTA LUCIA</option>
				                                    <option value="ST">SANTO TOME Y PRINCIPE (REPUBLICA DEMOCRATICA DE)</option>
				                                    <option value="SN">SENEGAL (REPUBLICA DEL)</option>
				                                    <option value="SC">SEYCHELLES (REPUBLICA DE LAS)</option>
				                                    <option value="SL">SIERRA LEONA (REPUBLICA DE)</option>
				                                    <option value="SG">SINGAPUR (REPUBLICA DE)</option>
				                                    <option value="SY">SIRIA (REPUBLICA ARABE)</option>
				                                    <option value="SO">SOMALIA</option>
				                                    <option value="LK">SRI LANKA (REPUBLICA DEMOCRATICA SOCIALISTA DE)</option>
				                                    <option value="ZA">SUDAFRICA (REPUBLICA DE)</option>
				                                    <option value="SD">SUDAN (REPUBLICA DEL)</option>
				                                    <option value="SE">SUECIA (REINO DE)</option>
				                                    <option value="CH">SUIZA (CONFEDERACION)</option>
				                                    <option value="SR">SURINAME (REPUBLICA DE)</option>
				                                    <option value="SZ">SWAZILANDIA (REINO DE)</option>
				                                    <option value="TJ">TADJIKISTAN (REPUBLICA DE)</option>
				                                    <option value="TH">TAILANDIA (REINO DE)</option>
				                                    <option value="TW">TAIWAN (REPUBLICA DE CHINA)</option>
				                                    <option value="TZ">TANZANIA (REPUBLICA UNIDA DE)</option>
				                                    <option value="IO">TERRITORIOS BRITANICOS DEL OCEANO INDICO</option>
				                                    <option value="TF">TERRITORIOS FRANCESES, AUSTRALES Y ANTARTICOS</option>
				                                    <option value="TL">TIMOR ORIENTAL</option>
				                                    <option value="TG">TOGO (REPUBLICA TOGOLESA)</option>
				                                    <option value="TO">TONGA (REINO DE)</option>
				                                    <option value="TT">TRINIDAD Y TOBAGO (REPUBLICA DE)</option>
				                                    <option value="TN">TUNEZ (REPUBLICA DE)</option>
				                                    <option value="TC">TURCAS Y CAICOS (ISLAS)</option>
				                                    <option value="TM">TURKMENISTAN (REPUBLICA DE)</option>
				                                    <option value="TR">TURQUIA (REPUBLICA DE)</option>
				                                    <option value="TV">TUVALU (COMUNIDAD BRITANICA DE NACIONES)</option>
				                                    <option value="UA">UCRANIA</option>
				                                    <option value="UG">UGANDA (REPUBLICA DE)</option>
				                                    <option value="UY">URUGUAY (REPUBLICA ORIENTAL DEL)</option>
				                                    <option value="UZ">UZBEJISTAN (REPUBLICA DE)</option>
				                                    <option value="VU">VANUATU</option>
				                                    <option value="VE">VENEZUELA (REPUBLICA DE)</option>
				                                    <option value="VN">VIETNAM (REPUBLICA SOCIALISTA DE</option>
				                                    <option value="VG">VIRGENES. ISLAS (BRITANICAS)</option>
				                                    <option value="VI">VIRGENES. ISLAS (NORTEAMERICANAS)</option>
				                                    <option value="YE">YEMEN (REPUBLICA DE)</option>
				                                    <option value="ZM">ZAMBIA (REPUBLICA DE)</option>
				                                    <option value="ZW">ZIMBABWE (REPUBLICA DE)</option>
				                            	</select>
				                            </div>
		                            	</div>
	                            	</div>
	                         	</div>
	                    	</div>
	                	</div>
	                </div>
	            </div>
	            <!-- Dividendos -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseDividendos">
	                        Dividendos
	                    </a>
	                    <div id="collapseDividendos" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <label><b>Dividendos o Utilidades Distribuidas del Per&iacute;odo o Ejercicio</b></label>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="cveTipDivOUtil">Tipo de dividendo o utilidad distribuida: </label></div>
			                            <div class="span7">
			                            	<select name="cveTipDivOUtil" id="cveTipDivOUtil" class="dividendos">
			                                    <option value="">Seleccionar</option>
			                                    <option value="01">Proviene de CUFIN</option>
			                                    <option value="02">No proviene de CUFIN</option>
			                                    <option value="03">Reembolso o reducci&oacute;n de capital</option>
			                                    <option value="04">Liquidaci&oacute;n de la persona moral</option>
			                                    <option value="05">CUFINRE</option>
			                                    <option value="06">Proviene de CUFIN al 31 de diciembre 2013.</option>
			                            	</select>
			                            </div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label for="montISRAcredRetMexico">Importe o retenci&oacute;n del dividendo o utilidad en territorio nacional: </label></div>
			                            <div class="span7"><input type="text" id="montISRAcredRetMexico" name="montISRAcredRetMexico" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio dividendos" /></div>
		                            </div>
	                        	</div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="montISRAcredRetExtranjero">Importe o retenci&oacute;n del dividendo o utilidad en territorio extranjero: </label></div>
			                            <div class="span7"><input type="text" id="montISRAcredRetExtranjero" name="montISRAcredRetExtranjero" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio dividendos" /></div>
		                        	</div>
		                        	<div class="span6">
			                            <div class="span5"><label for="montRetExtDivExt">Monto de la retenci&oacute;n en el extranjero sobre dividendos del extranjero: </label></div>
			                            <div class="span7"><input type="text" id="montRetExtDivExt" name="montRetExtDivExt" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio dividendos" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="tipoSocDistrDiv">Distribuido por: </label></div>
			                            <div class="span7">
			                            	<select name="tipoSocDistrDiv" id="tipoSocDistrDiv" class="dividendos">
			                                    <option value="">Seleccionar</option>
			                                    <option value="Sociedad Nacional">Sociedad Nacional</option>
			                                    <option value="Sociedad Extranjera">Sociedad Extranjera</option>
			                            	</select>
			                            </div>
		                        	</div>
		                        	<div class="span6">
			                            <div class="span5"><label for="montISRAcredNal">Monto del ISR acreditable: </label></div>
			                            <div class="span7"><input type="text" id="montISRAcredNal" name="montISRAcredNal" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio dividendos" /></div>
		                            </div>
		                        </div>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="montDivAcumNal">Monto del dividendo acumulable nacional: </label></div>
			                            <div class="span7"><input type="text" id="montDivAcumNal" name="montDivAcumNal" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio dividendos" /></div>
		                            </div>
		                            <div class="span6">
			                            <div class="span5"><label>Monto del dividendo acumulable extranjero: </label></div>
			                            <div class="span7"><input type="text" id="montDivAcumExt" name="montDivAcumExt" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio dividendos" /></div>
		                            </div>
		                        </div>
	                    	</div>
		                    <div class="accordion-inner">
		                        <label><b>Remanente</b></label>
		                        <div class="row-fluid">
		                        	<div class="span6">
			                            <div class="span5"><label for="proporcionRem">Porcentaje de participaci&oacute;n de sus integrantes o accionistas: </label></div>
			                            <div class="span7"><input type="text" id="proporcionRem" name="proporcionRem" onkeyup="valid(this)" onblur="valid(this)" autocomplete="off" class="obligatorio dividendos" /></div>
		                        	</div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	            <!-- Fideicomiso No Empresarial -->
	            <div class="accordion-group">
	                <div class="accordion-heading">
	                    <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFideicNoEmp">
	                        Fideicomiso No Empresarial
	                    </a>
	                    <div id="collapseFideicNoEmp" class="accordion-body collapse">
		                    <div class="accordion-inner">
		                        <div>
		                            <label class="blue"><b>Ingresos O Entradas</b></label>
		                            <div class="row-fluid">
		                            	<div class="span6">
			                                <div class="span5"><label for="montTotEntradasPeriodo">Importe total de los ingresos del periodo: </label></div>
			                                <div class="span7"><input type="text" id="montTotEntradasPeriodo" name="montTotEntradasPeriodo" class="input fideicNoEmp" /></div>
		                            	</div>
		                                <div class="span6">
			                                <div class="span5"><label for="partPropAcumDelFideicom">Parte proporcional de los ingresos acumulables del periodo: </label></div>
			                                <div class="span7"><input type="text" id="partPropAcumDelFideicom" name="partPropAcumDelFideicom" class="input fideicNoEmp" /></div>
		                                </div>
		                            </div>
		                            <div class="row-fluid">
		                                <div class="span6">
			                                <div class="span5"><label for="propDelMontTot">Proporci&oacute;n de participaci&oacute;n: </label></div>
			                                <div class="span7"><input type="text" id="propDelMontTot" name="propDelMontTot" class="input fideicNoEmp" /></div>
		                                </div>
		                                <div class="span6">
			                                <div class="span5"><label for="conceptoIntIngresos"><b>Integraci&oacute;n de los ingresos</b></label></div>
			                                <div class="span7">
			                                	<textarea id="conceptoIntIngresos" name="conceptoIntIngresos" autocomplete="off" class="fideicNoEmp" rows="3"></textarea>
			                                </div>
		                                </div>
		                            </div>
		                        </div>
		                        <div>
		                            <label class="blue"><b>Deducciones O Salidas</b></label>
		                            <div class="row-fluid">
		                            	<div class="span6">
			                                <div class="span5"><label for="montTotEgresPeriodo">Importe total de los egresos del periodo: </label></div>
			                                <div class="span7"><input type="text" id="montTotEgresPeriodo" name="montTotEgresPeriodo" class="input fideicNoEmp" /></div>
		                            	</div>
		                            	<div class="span6">
			                                <div class="span5"><label for="partPropDelFideicom">Parte proporcional de las deducciones autorizadas del periodo: </label></div>
			                                <div class="span7"><input type="text" id="partPropDelFideicom" name="partPropDelFideicom" class="input fideicNoEmp" /></div>
		                                </div>
		                            </div>
		                            <div>
		                                <div class="span6">
			                                <div class="span5"><label for="propDelMontTotSalidas">Proporci&oacute;n de participaci&oacute;n: </label></div>
			                                <div class="span7"><input type="text" id="propDelMontTotSalidas" name="propDelMontTotSalidas" class="input fideicNoEmp" /></div>
		                                </div>
		                                <div class="span6">
			                                <div class="span5"><label for="conceptoS"><b>Integraci&oacute;n de los egresos</b></label></div>
			                                <div class="span7">
			                                	<textarea id="conceptoS" name="conceptoS" autocomplete="off" class="fideicNoEmp" rows="3"></textarea>
			                                </div>
		                                </div>
		                            </div>
		                        </div>
		                        <div>
		                            <label class="blue"><b>Retenciones Efectuadas</b></label>
		                            <div class="row-fluid">
		                            	<div class="span6">
				                            <div class="span5"><label for="montRetRelPagFideic">Monto de las retenciones: </label></div>
				                            <div class="span7"><input type="text" id="montRetRelPagFideic" name="montRetRelPagFideic" class="input fideicNoEmp" /></div>
		                            	</div>
		                            	<div class="span6">
			                                <div class="span5"><label for="descRetRelPagFideic">Descripci&oacute;n de las retenciones: </label></div>
			                                <div class="span7"><input type="text" id="descRetRelPagFideic" name="descRetRelPagFideic" class="input fideicNoEmp" /></div>
		                            	</div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</form>
	<div class="row-fluid">
		<form action="${contextPath}/comprobante/vistaPreviaRetenciones" class="span3 offset3" id="formVistaPreviaRetenciones" method="post" target="_blank">
		    <input type="hidden" name="strRetenciones" class="strRetenciones">
		    <label for="vistaPrevia" class="btn btn-success">
		    	<i class="icon-eye-open icon-white"></i>
		    	Vista previa
		    </label>
		    <input type="submit" id="vistaPrevia" value="Vista Previa" class="hide">
		</form>
		<form action="${contextPath}/comprobante/timbrarRetenciones" class="span3" id="formGenerarRetenciones" method="post">
            <input type="hidden" name="strRetenciones" class="strRetenciones">
            <label for="generarRetenciones" class="btn btn-success">
            	<i class="icon-file icon-white"></i>
            	Generar Retenciones
            </label>
            <input type="submit" id="generarRetenciones" data-loading-text="Generando retenciones..." value="Generar Retenciones" class="hide">
        </form>
	</div>
</div>
    <script src="/CFDI33/static/resources/js/jquery-ui-1.10.3.custom.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/static/resources/css/redmond/jquery-ui-1.10.3.custom.min.css"/>">
    <script src="/CFDI33/static/resources/js/bootstrap-datepicker.js"></script>
    <!--<script src="<c:url value="/static/resources/js/retenciones.js?${random.nextInt()}" />"></script>-->
	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-122238418-1"></script>
	<script>
	  window.dataLayer = window.dataLayer || [];
	  function gtag(){dataLayer.push(arguments);}
	  gtag('js', new Date());
	  gtag('config', 'UA-122238418-1');
	</script>
    <c:choose>
         <c:when test="${secure}">
             <script src="https://portal1.expidetufactura.com.mx:447/js/retenciones33.js?${random.nextInt()}" charset="UTF-8" /></script>
         </c:when>
         <c:otherwise>
             <script src="http://portal.expidetufactura.com.mx:86/js/retenciones33.js?${random.nextInt()}" charset="UTF-8" /></script>
         </c:otherwise>
    </c:choose>