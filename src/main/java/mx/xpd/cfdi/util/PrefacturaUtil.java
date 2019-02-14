package mx.xpd.cfdi.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import mx.xpd.cfdi.domain.prefactura.CfdiRelacionado;
import mx.xpd.cfdi.domain.prefactura.ConstantesPrefactura;
import mx.xpd.cfdi.domain.prefactura.InformacionAduanera;
import mx.xpd.cfdi.domain.prefactura.Parte;
import mx.xpd.cfdi.domain.prefactura.Prefactura;
import mx.xpd.cfdi.domain.prefactura.Traslado;
import mx.xpd.cfdi.domain.prefactura.ValidadorXml;
import mx.xpd.cfdi.exception.ErrorHandlerXmlReader;

public class PrefacturaUtil {

	/**
	 *valida sintaxis del XML leido, cfdi 3.3
	 *
	 *@param xml: cadena xml leida
	 *@return Objeto <b>ValidadorXml</b> que contiene en el atributo respuesta (true o false); en caso de ser false, en el atributo mensaje contendra el mensaje de la excepcion.
	 *@author Carlos Palalia Lopez
	 * 
	 * **/
	public ValidadorXml validarSintaxisXml(String xml){
		ValidadorXml respuesta = new ValidadorXml();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);

			SAXParser parser = factory.newSAXParser();
			
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			
			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(new ErrorHandlerXmlReader());
			reader.parse(is);
			respuesta.setCorrecto(true);
		} catch (Exception e) {
			respuesta.setCorrecto(false);
			respuesta.setMensaje("XML malformado: " + e.getMessage());
		}
		return respuesta;
	}
	
	
	/**
	 *valida los atributos requeridos para cfdi 3.3
	 *
	 *@param prefactura: xml parseado a objeto que se cargara como plantilla
	 *@return Objeto <b>ValidadorXml<b/> que contiene en el atributo respuesta (true o false); en caso de ser false, en el atributo mensaje contendra el nombre del atributo requerido.
	 *@author Carlos Palalia Lopez
	 * 
	 * **/
	public ValidadorXml validarCamposRequeridos(Prefactura prefactura){
		ValidadorXml respuesta = new ValidadorXml();
		respuesta.setCorrecto(true);
		String requeridoValue = "=\"requerido\" />";
		
		//validar conceptos
		if(prefactura.getConceptos() != null && prefactura.getConceptos().size() > 0){
			for (mx.xpd.cfdi.domain.prefactura.Concepto itemConcepto : prefactura.getConceptos()) {
				if(itemConcepto.getCantidad() == null){
					respuesta.setCorrecto(false);
					respuesta.setMensaje("<Concepto cantidad" + requeridoValue);
					break;
				} else if(itemConcepto.getImporte() == null || itemConcepto.getImporte().isEmpty()){
					respuesta.setCorrecto(false);
					respuesta.setMensaje("<Concepto importe" + requeridoValue);
					break;
				} else if(itemConcepto.getClaveProdServ() == null || itemConcepto.getClaveProdServ().isEmpty()){
					respuesta.setCorrecto(false);
					respuesta.setMensaje("<Concepto ClaveProdServ" + requeridoValue);
					break;
				} else if(itemConcepto.getClaveUnidad() == null || itemConcepto.getClaveUnidad().isEmpty()){
					respuesta.setCorrecto(false);
					respuesta.setMensaje("<Concepto ClaveUnidad" + requeridoValue);
					break;
				} else if(itemConcepto.getDescripcion() == null || itemConcepto.getDescripcion().isEmpty()){
					respuesta.setCorrecto(false);
					respuesta.setMensaje("<Concepto Descripcion" + requeridoValue);
					break;
				} else if(itemConcepto.getValorUnitario() == null || itemConcepto.getValorUnitario().isEmpty()){
					respuesta.setCorrecto(false);
					respuesta.setMensaje("<Concepto ValorUnitario" + requeridoValue);
					break;
				}
				
				if(itemConcepto.getImpuestos() != null){
					if(itemConcepto.getImpuestos().getTraslados() != null && itemConcepto.getImpuestos().getTraslados().size() > 0){
						for (Traslado itemTraslado : itemConcepto.getImpuestos().getTraslados()) {
							if(itemTraslado.getBase() == null || itemTraslado.getBase().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Traslado Base" + requeridoValue);
								break;
							} else if(itemTraslado.getImpuesto() == null || itemTraslado.getImpuesto().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Traslado Impuesto" + requeridoValue);
								break;
							} else if(itemTraslado.getTipoFactor() == null || itemTraslado.getTipoFactor().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Traslado TipoFactor" + requeridoValue);
								break;
							}
							if(itemTraslado.getTipoFactor().toUpperCase().contains("EXENTO")){
								if(itemTraslado.getImporte() != null && new Float(itemTraslado.getImporte()) > 0){
									respuesta.setCorrecto(false);
									respuesta.setMensaje("<Concepto...> <Impuestos> <Traslado TipoFactor=\"Exento\"\n(Atributo importe no debe registrarse)");
									break;
								}else if(itemTraslado.getTasaOCuota() != null && new Float(itemTraslado.getTasaOCuota()) > 0){
									respuesta.setCorrecto(false);
									respuesta.setMensaje("<Concepto...> <Impuestos> <Traslado TipoFactor=\"Exento\"\n(Atributo TasaOCuota no debe registrarse)");
									break;
								} else if((itemTraslado.getImporte() != null && new Float(itemTraslado.getImporte()) > 0) && itemTraslado.getTasaOCuota() != null && new Float(itemTraslado.getTasaOCuota()) > 0){
									respuesta.setCorrecto(false);
									respuesta.setMensaje("<Concepto...> <Impuestos> <Traslado TipoFactor=\"Exento\"\n(Atributo TasaOCuota no debe registrarse)");
									break;
								}
							}
						}
						if(!respuesta.isCorrecto())
							break;
					}
					
					if(itemConcepto.getImpuestos().getRetenciones() != null && itemConcepto.getImpuestos().getRetenciones().size() > 0){
						for (mx.xpd.cfdi.domain.prefactura.Retencion itemRetencion : itemConcepto.getImpuestos().getRetenciones()) {
							if(itemRetencion.getBase() == null || itemRetencion.getBase().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Retencion Base" + requeridoValue);
								break;
							} else if(itemRetencion.getImpuesto() == null || itemRetencion.getImpuesto().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Retencion Impuesto" + requeridoValue);
								break;
							} else if(itemRetencion.getTipoFactor() == null || itemRetencion.getTipoFactor().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Retencion TipoFactor" + requeridoValue);
								break;
							} else if(itemRetencion.getTasaOCuota() == null || itemRetencion.getTasaOCuota().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Retencion TasaOCuota" + requeridoValue);
								break;
							} else if(itemRetencion.getImporte() == null || itemRetencion.getImporte().isEmpty()){
								respuesta.setCorrecto(false);
								respuesta.setMensaje("<Concepto...> <Impuestos> <Retencion Importe" + requeridoValue);
								break;
							}
						}
						if(!respuesta.isCorrecto())
							break;
					}
				}
				
			if(itemConcepto.getInformacionAduanera() != null && itemConcepto.getInformacionAduanera().size() > 0){
				for (InformacionAduanera itemInfoAduana: itemConcepto.getInformacionAduanera()) {
					if(itemInfoAduana.getNumeroPedimento() == null || itemInfoAduana.getNumeroPedimento().isEmpty()){
						respuesta.setCorrecto(false);
						respuesta.setMensaje("<Concepto...> <InformacionAduanera NumeroPedimento" + requeridoValue);
						break;
					}
				}
				if(!respuesta.isCorrecto())
					break;
			}
				
//				if(itemConcepto.getCuentaPredial() != null){
//					if(itemConcepto.getCuentaPredial().getNumero() == null || itemConcepto.getCuentaPredial().getNumero().isEmpty()){
//						respuesta.setCorrecto(false);
//						respuesta.setMensaje("<Concepto...> <CuentaPredial Numero" + requeridoValue);
//						break;
//					}
//				}
				
				if(itemConcepto.getPartes() != null && itemConcepto.getPartes().size() > 0){
					for (Parte itemParte : itemConcepto.getPartes()) {
						if(itemParte.getClaveProdServ() == null || itemParte.getClaveProdServ().isEmpty()){
							respuesta.setCorrecto(false);
							respuesta.setMensaje("<Concepto...> <Parte ClaveProdServ=\"requerido\" />");
							break;
						} else if(itemParte.getCantidad() == null || itemParte.getCantidad().isEmpty()){
							respuesta.setCorrecto(false);
							respuesta.setMensaje("<Concepto...> <Parte Cantidad=\"requerido\" />");
							break;
						} else if(itemParte.getDescripcion() == null || itemParte.getDescripcion().isEmpty()){
							respuesta.setCorrecto(false);
							respuesta.setMensaje("<Concepto...> <Parte Descripcion=\"requerido\" />");
							break;
						}
					}
					if(!respuesta.isCorrecto())
						break;
				}
			}
		}
		return respuesta;
	}
	
	/**
	 * Metodo que construye el xml que será descargado a un archivo
	 * @param prefactura. objeto del XML
	 * @return cadena XML construida
	 * **/
	public String buildXml(Prefactura prefactura) {
		StringWriter stringWriter = new StringWriter();
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Comprobante
			Document doc = docBuilder.newDocument();
			Element comprobanteRoot = doc.createElement(ConstantesPrefactura.NODO_COMPROBANTE);
			doc.appendChild(comprobanteRoot);

			Attr attr = doc.createAttribute(ConstantesPrefactura.ATRIB_SERIE);
			attr.setValue(prefactura.getSerie());
			comprobanteRoot.setAttributeNode(attr);

			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_FOLIO);
			attr.setValue(prefactura.getFolio());
			comprobanteRoot.setAttributeNode(attr);

			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_TIPODECOMPROBANTE);
			attr.setValue(prefactura.getTipoComprobante());
			comprobanteRoot.setAttributeNode(attr);

			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_FORMAPAGO);
			attr.setValue(prefactura.getFormaPago());
			comprobanteRoot.setAttributeNode(attr);

			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_MONEDA);
			attr.setValue(prefactura.getMoneda());
			comprobanteRoot.setAttributeNode(attr);

			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_TIPOCAMBIO);
			attr.setValue(prefactura.getTipoCambio());
			comprobanteRoot.setAttributeNode(attr);

			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_METODOPAGO);
			attr.setValue(prefactura.getMetodoPago());
			comprobanteRoot.setAttributeNode(attr);

			if(prefactura.getLugarExpedicion() != null && !prefactura.getLugarExpedicion().isEmpty()){
				attr = doc.createAttribute(ConstantesPrefactura.ATRIB_LUGAREXPEDICION);
				attr.setValue(prefactura.getLugarExpedicion());
				comprobanteRoot.setAttributeNode(attr);
			}
			
			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_REGIMENFISCAL);
			attr.setValue(prefactura.getRegimenFiscal());
			comprobanteRoot.setAttributeNode(attr);
			
			attr = doc.createAttribute(ConstantesPrefactura.ATRIB_CONDICIONES_PAGO);
			attr.setValue(prefactura.getCondicionespago());
			comprobanteRoot.setAttributeNode(attr);
			
			if(prefactura.getConfirmacion() != null && !prefactura.getConfirmacion().isEmpty()){
				attr = doc.createAttribute(ConstantesPrefactura.ATRIB_CONFIRMACION);
				attr.setValue(prefactura.getConfirmacion());
				comprobanteRoot.setAttributeNode(attr);
			}
			
			if(prefactura.getTipoRelacion() != null && !prefactura.getTipoRelacion().isEmpty()){
				attr = doc.createAttribute(ConstantesPrefactura.ATRIB_TIPO_RELACION);
				attr.setValue(prefactura.getTipoRelacion());
				comprobanteRoot.setAttributeNode(attr);
			}
			
			if(prefactura.getObservaciones() != null && !prefactura.getObservaciones().isEmpty()){
				attr = doc.createAttribute(ConstantesPrefactura.ATRIB_OBSERVACIONES);
				attr.setValue(prefactura.getObservaciones());
				comprobanteRoot.setAttributeNode(attr);
			}
			
			// Receptor
			Element receptor = doc.createElement(ConstantesPrefactura.NODO_RECEPTOR);
			comprobanteRoot.appendChild(receptor);

			Attr attrReceptor = doc.createAttribute(ConstantesPrefactura.ATRIB_NOMBRE);
			attrReceptor.setValue(prefactura.getReceptorNombre());
			receptor.setAttributeNode(attrReceptor);

			attrReceptor = doc.createAttribute(ConstantesPrefactura.ATRIB_RFC);
			attrReceptor.setValue(prefactura.getReceptorRfc());
			receptor.setAttributeNode(attrReceptor);

			attrReceptor = doc.createAttribute(ConstantesPrefactura.ATRIB_EMAIL);
			attrReceptor.setValue(prefactura.getReceptorEmail());
			receptor.setAttributeNode(attrReceptor);

			attrReceptor = doc.createAttribute(ConstantesPrefactura.ATRIB_USOCFDI);
			attrReceptor.setValue(prefactura.getReceptorUsoCfdi());
			receptor.setAttributeNode(attrReceptor);

			if(prefactura.getReceptorResidenciaFiscal() != null && !prefactura.getReceptorResidenciaFiscal().isEmpty() && !prefactura.getReceptorResidenciaFiscal().equals(ConstantesPrefactura.VALUE_DEFAULT)){
				attrReceptor = doc.createAttribute(ConstantesPrefactura.ATRIB_RESIDENCIAFISCAL);
				attrReceptor.setValue(prefactura.getReceptorResidenciaFiscal());
				receptor.setAttributeNode(attrReceptor);
			}

			if(prefactura.getReceptorNumRegIdTrib() != null && !prefactura.getReceptorNumRegIdTrib().isEmpty()){
				attrReceptor = doc.createAttribute(ConstantesPrefactura.ATRIB_NUMREGIDTRIB);
				attrReceptor.setValue(prefactura.getReceptorNumRegIdTrib());
				receptor.setAttributeNode(attrReceptor);
			}
			
			// Conceptos.
			if (prefactura.getConceptos() != null && prefactura.getConceptos().size() > 0) {
				Element conceptos = doc.createElement(ConstantesPrefactura.NODO_CONCEPTOS);
				comprobanteRoot.appendChild(conceptos);

				for (mx.xpd.cfdi.domain.prefactura.Concepto item : prefactura.getConceptos()) {
					Element concepto = doc.createElement(ConstantesPrefactura.NODO_CONCEPTO);
					conceptos.appendChild(concepto);

					Attr attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_CANTIDAD);
					attrConcepto.setValue(item.getCantidad());
					concepto.setAttributeNode(attrConcepto);

					if(item.getClaveProdServ() != null && !item.getClaveProdServ().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_CLAVEPRODSERV);
						attrConcepto.setValue(item.getClaveProdServ());
						concepto.setAttributeNode(attrConcepto);
					}

					if(item.getClaveUnidad() != null && !item.getClaveUnidad().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_CLAVEUNIDAD);
						attrConcepto.setValue(item.getClaveUnidad());
						concepto.setAttributeNode(attrConcepto);
					}

					if(item.getDescripcion() != null && !item.getDescripcion().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_DESCRIPCION);
						attrConcepto.setValue(item.getDescripcion());
						concepto.setAttributeNode(attrConcepto);
					}

					if(item.getImporte() != null && !item.getImporte().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_IMPORTE);
						attrConcepto.setValue(item.getImporte());
						concepto.setAttributeNode(attrConcepto);
					}

					if(item.getUnidad() != null && !item.getUnidad().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_UNIDAD);
						attrConcepto.setValue(item.getUnidad());
						concepto.setAttributeNode(attrConcepto);
					}
					
					if(item.getValorUnitario() != null && !item.getValorUnitario().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_VALORUNITARIO);
						attrConcepto.setValue(item.getValorUnitario());
						concepto.setAttributeNode(attrConcepto);
					}
					
					if(item.getNoIdentificacion() != null && !item.getNoIdentificacion().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_NO_IDENTIFICACION);
						attrConcepto.setValue(item.getNoIdentificacion());
						concepto.setAttributeNode(attrConcepto);
					}
					
					if(item.getDescuento() != null && !item.getDescuento().isEmpty() && new Float(item.getDescuento()) > 0){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_DESCUENTO);
						attrConcepto.setValue(item.getDescuento());
						concepto.setAttributeNode(attrConcepto);
					}
					
					if(item.getIeps() != null && !item.getIeps().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_IEPS);
						attrConcepto.setValue(item.getIeps());
						concepto.setAttributeNode(attrConcepto);
					}
					
					if(item.getIva() != null && !item.getIva().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_IVA);
						attrConcepto.setValue(item.getIva());
						concepto.setAttributeNode(attrConcepto);
					}
					
					if(item.getIvaRetenido() != null && !item.getIvaRetenido().isEmpty()){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_IVA_RETENIDO);
						attrConcepto.setValue(item.getIvaRetenido());
						concepto.setAttributeNode(attrConcepto);
					}
					
					if(item.getCuentaPredial() != null && item.getCuentaPredial() != null){
						attrConcepto = doc.createAttribute(ConstantesPrefactura.ATRIB_CUENTA_PREDIAL);
						attrConcepto.setValue(item.getCuentaPredial().getNumero());
						concepto.setAttributeNode(attrConcepto);
					}
					
					
					if (item.getImpuestos() != null) {
						Element impuestos = doc.createElement(ConstantesPrefactura.NODO_IMPUESTOS);
						concepto.appendChild(impuestos);

						if (item.getImpuestos().getTraslados() != null
								&& item.getImpuestos().getTraslados().size() > 0) {
							Element traslados = doc.createElement(ConstantesPrefactura.NODO_TRASLADOS);
							impuestos.appendChild(traslados);

							for (Traslado itemTraslado : item.getImpuestos().getTraslados()) {
								Element traslado = doc.createElement(ConstantesPrefactura.NODO_TRASLADO);
								traslados.appendChild(traslado);
								
								Attr atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_BASE);
								
								if(itemTraslado.getBase() != null && !itemTraslado.getBase().isEmpty()){
									atributo.setValue(itemTraslado.getBase());
									traslado.setAttributeNode(atributo);
								}
								
								if(itemTraslado.getImporte() != null && !itemTraslado.getImporte().isEmpty() && new Float(itemTraslado.getImporte()) > 0){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_IMPORTE);
									atributo.setValue(itemTraslado.getImporte());
									traslado.setAttributeNode(atributo);
								}
								
								if(itemTraslado.getImpuesto() != null && !itemTraslado.getImpuesto().isEmpty()){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_IMPUESTO);
									atributo.setValue(itemTraslado.getImpuesto());
									traslado.setAttributeNode(atributo);
								}
								
								if(itemTraslado.getTasaOCuota() != null && !itemTraslado.getTasaOCuota().isEmpty() && !itemTraslado.getTasaOCuota().equalsIgnoreCase("NaN")){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_TASAOCUOTA);
									atributo.setValue(itemTraslado.getTasaOCuota());
									traslado.setAttributeNode(atributo);
								}
								
								if(itemTraslado.getTipoFactor() != null && !itemTraslado.getTipoFactor().isEmpty()){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_TIPOFACTOR);
									atributo.setValue(itemTraslado.getTipoFactor());
									traslado.setAttributeNode(atributo);
								}
							}
						}

						if (item.getImpuestos().getRetenciones() != null
								&& item.getImpuestos().getRetenciones().size() > 0) {
							Element retenciones = doc.createElement(ConstantesPrefactura.NODO_RETENCIONES);
							impuestos.appendChild(retenciones);

							for (mx.xpd.cfdi.domain.prefactura.Retencion itemRetencion : item.getImpuestos()
									.getRetenciones()) {
								Element retencion = doc.createElement(ConstantesPrefactura.NODO_RETENCION);
								retenciones.appendChild(retencion);

								Attr atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_BASE);
								
								if(itemRetencion.getBase() != null && !itemRetencion.getBase().isEmpty()){
									atributo.setValue(itemRetencion.getBase());
									retencion.setAttributeNode(atributo);
								}
								
								if(itemRetencion.getImporte() != null && !itemRetencion.getImporte().isEmpty()){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_IMPORTE);
									atributo.setValue(itemRetencion.getImporte());
									retencion.setAttributeNode(atributo);
								}
								
								if(itemRetencion.getImpuesto() != null && !itemRetencion.getImpuesto().isEmpty()){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_IMPUESTO);
									atributo.setValue(itemRetencion.getImpuesto());
									retencion.setAttributeNode(atributo);
								}
								
								if(itemRetencion.getTasaOCuota() != null && !itemRetencion.getTasaOCuota().isEmpty()){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_TASAOCUOTA);
									atributo.setValue(itemRetencion.getTasaOCuota());
									retencion.setAttributeNode(atributo);
								}
								
								if(itemRetencion.getTipoFactor() != null && !itemRetencion.getTipoFactor().isEmpty()){
									atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_TIPOFACTOR);
									atributo.setValue(itemRetencion.getTipoFactor());
									retencion.setAttributeNode(atributo);
								}
							}
						}
					}

					if (item.getPartes() != null && item.getPartes().size() > 0) {
						for (Parte itemParte : item.getPartes()) {
							Element parte = doc.createElement(ConstantesPrefactura.NODO_PARTE);
							concepto.appendChild(parte);

							Attr atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_CANTIDAD);
							
							if(itemParte.getCantidad() != null && !itemParte.getCantidad().isEmpty()){
								atributo.setValue(itemParte.getCantidad());
								parte.setAttributeNode(atributo);
							}
							
							if(itemParte.getClaveProdServ() != null && !itemParte.getClaveProdServ().isEmpty()){
								atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_CLAVEPRODSERV);
								atributo.setValue(itemParte.getClaveProdServ());
								parte.setAttributeNode(atributo);
							}
							
							if(itemParte.getDescripcion() != null && !itemParte.getDescripcion().isEmpty()){
								atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_DESCRIPCION);
								atributo.setValue(itemParte.getDescripcion());
								parte.setAttributeNode(atributo);
							}
							
							if(itemParte.getImporte() != null && !itemParte.getImporte().isEmpty()){
								atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_IMPORTE);
								atributo.setValue(itemParte.getImporte());
								parte.setAttributeNode(atributo);
							}
							
							if(itemParte.getNoIdentificacion() != null && !itemParte.getNoIdentificacion().isEmpty()){
								atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_NOIDENTIFICACION);
								atributo.setValue(itemParte.getNoIdentificacion());
								parte.setAttributeNode(atributo);
							}
							
							if(itemParte.getUnidad() != null && !itemParte.getUnidad().isEmpty()){
								atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_UNIDAD);
								atributo.setValue(itemParte.getUnidad());
								parte.setAttributeNode(atributo);
							}
							
							if(itemParte.getValorUnitario() != null && !itemParte.getValorUnitario().isEmpty()){
								atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_VALORUNITARIO);
								atributo.setValue(itemParte.getValorUnitario());
								parte.setAttributeNode(atributo);
							}
							
						}
					}
					
					if (item.getInformacionAduanera() != null && item.getInformacionAduanera().size() > 0) {
						Element aduanas = doc.createElement(ConstantesPrefactura.NODO_ADUANAS);
						concepto.appendChild(aduanas);
						
						for (InformacionAduanera itemAduana : item.getInformacionAduanera()) {
							if(itemAduana.getNumeroPedimento() != null && !itemAduana.getNumeroPedimento().isEmpty()){
								Element informacionAduanera = doc.createElement(ConstantesPrefactura.NODO_INFORMACION_ADUANERA);
								aduanas.appendChild(informacionAduanera);
								
								Attr atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_NUMERO_PEDIMENTO);
								atributo.setValue(itemAduana.getNumeroPedimento());
								informacionAduanera.setAttributeNode(atributo);
							}
							
						}
					}
				}
			}

			//Cfdis relacionados.
			if (prefactura.getCfdisRelacionados() != null && prefactura.getCfdisRelacionados().size() > 0) {
				Element relacionados = doc.createElement(ConstantesPrefactura.NODO_CFDIS_RELACIONADOS);
				comprobanteRoot.appendChild(relacionados);
				
				for (CfdiRelacionado itemCfdi : prefactura.getCfdisRelacionados()) {
					
					Element cfdiRelacionado = doc.createElement(ConstantesPrefactura.NODO_CFDI_RELACIONADO);
					relacionados.appendChild(cfdiRelacionado);
					
					Attr atributo = doc.createAttribute(ConstantesPrefactura.ATRIB_UUID);
					atributo.setValue(itemCfdi.getUuid());
					cfdiRelacionado.setAttributeNode(atributo);
				}
			}
			
			DOMSource source = new DOMSource(doc);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, new javax.xml.transform.stream.StreamResult(stringWriter));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stringWriter.getBuffer().toString();
	}
}
