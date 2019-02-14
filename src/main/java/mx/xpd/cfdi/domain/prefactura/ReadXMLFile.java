package mx.xpd.cfdi.domain.prefactura;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadXMLFile extends DefaultHandler {
	String xml = "";
	private Prefactura prefactura;
	private List<Concepto> conceptos;
	private Impuestos impuestos;
	private Concepto concepto;
	private List<Traslado> traslados;
	private List<Retencion> retenciones;
	private List<InformacionAduanera> aduanas;
	private List<Parte> partes;
	private List<CfdiRelacionado> cfdisRelacionados;
	
	public ReadXMLFile(String xml) {
		prefactura = new Prefactura();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//prefactura.setCondicionespago(condicionespago);
		if(localName.contains(ConstantesPrefactura.NODO_COMPROBANTE)){
			prefactura.setFecha(attributes.getValue(ConstantesPrefactura.ATRIB_FECHA));
			prefactura.setFolio(attributes.getValue(ConstantesPrefactura.ATRIB_FOLIO));
			prefactura.setFormaPago(attributes.getValue(ConstantesPrefactura.ATRIB_FORMAPAGO));
			prefactura.setLugarExpedicion(attributes.getValue(ConstantesPrefactura.ATRIB_LUGAREXPEDICION));
			prefactura.setMetodoPago(attributes.getValue(ConstantesPrefactura.ATRIB_METODOPAGO));
			prefactura.setMoneda(attributes.getValue(ConstantesPrefactura.ATRIB_MONEDA));
			prefactura.setSerie(attributes.getValue(ConstantesPrefactura.ATRIB_SERIE));
			prefactura.setTipoCambio(attributes.getValue(ConstantesPrefactura.ATRIB_TIPOCAMBIO));
			prefactura.setTipoComprobante(attributes.getValue(ConstantesPrefactura.ATRIB_TIPODECOMPROBANTE));
			prefactura.setRegimenFiscal(attributes.getValue(ConstantesPrefactura.ATRIB_REGIMENFISCAL));
			prefactura.setObservaciones(attributes.getValue(ConstantesPrefactura.ATRIB_OBSERVACIONES));
			
			prefactura.setCondicionespago(attributes.getValue(ConstantesPrefactura.ATRIB_CONDICIONES_PAGO));
			prefactura.setConfirmacion(attributes.getValue(ConstantesPrefactura.ATRIB_CONFIRMACION));
			prefactura.setTipoRelacion(attributes.getValue(ConstantesPrefactura.ATRIB_TIPO_RELACION));
			
		}else if(localName.contains(ConstantesPrefactura.NODO_RECEPTOR)){
			prefactura.setReceptorEmail(attributes.getValue(ConstantesPrefactura.ATRIB_EMAIL));
			prefactura.setReceptorNombre(attributes.getValue(ConstantesPrefactura.ATRIB_NOMBRE));
			prefactura.setReceptorNumRegIdTrib(attributes.getValue(ConstantesPrefactura.ATRIB_NUMREGIDTRIB));
			prefactura.setReceptorResidenciaFiscal(attributes.getValue(ConstantesPrefactura.ATRIB_RESIDENCIAFISCAL));
			prefactura.setReceptorRfc(attributes.getValue(ConstantesPrefactura.ATRIB_RFC));
			prefactura.setReceptorUsoCfdi(attributes.getValue(ConstantesPrefactura.ATRIB_USOCFDI));
			
		}else if(localName.contains(ConstantesPrefactura.NODO_EMISOR)){
			prefactura.setEmisorNombre(attributes.getValue(ConstantesPrefactura.ATRIB_NOMBRE));
			prefactura.setEmisorRfc(attributes.getValue(ConstantesPrefactura.ATRIB_RFC));
			
		}else if(localName.contains(ConstantesPrefactura.NODO_CONCEPTOS)){
			conceptos = new ArrayList<Concepto>();
		}else if(localName.contains(ConstantesPrefactura.NODO_CONCEPTO)){
			concepto = new Concepto();
			concepto.setCantidad(attributes.getValue(ConstantesPrefactura.ATRIB_CANTIDAD));
			concepto.setClaveProdServ(attributes.getValue(ConstantesPrefactura.ATRIB_CLAVEPRODSERV));
			concepto.setClaveUnidad(attributes.getValue(ConstantesPrefactura.ATRIB_CLAVEUNIDAD));
			concepto.setDescripcion(attributes.getValue(ConstantesPrefactura.ATRIB_DESCRIPCION));
			concepto.setDescuento(attributes.getValue(ConstantesPrefactura.ATRIB_DESCUENTO));
			concepto.setIeps(attributes.getValue(ConstantesPrefactura.ATRIB_IEPS));
			concepto.setImporte(attributes.getValue(ConstantesPrefactura.ATRIB_IMPORTE));
			concepto.setIva(attributes.getValue(ConstantesPrefactura.ATRIB_IVA));
			concepto.setIvaRetenido(attributes.getValue(ConstantesPrefactura.ATRIB_IVA_RETENIDO));
			concepto.setNoIdentificacion(attributes.getValue(ConstantesPrefactura.ATRIB_NO_IDENTIFICACION));
			concepto.setUnidad(attributes.getValue(ConstantesPrefactura.ATRIB_UNIDAD));
			concepto.setValorUnitario(attributes.getValue(ConstantesPrefactura.ATRIB_VALORUNITARIO));
			
			CuentaPredial cta = new CuentaPredial();
			cta.setNumero(attributes.getValue(ConstantesPrefactura.ATRIB_CUENTA_PREDIAL));
			concepto.setCuentaPredial(cta);
		}else if(localName.contains(ConstantesPrefactura.NODO_IMPUESTOS)){
			impuestos = new Impuestos();
		}else if(localName.contains(ConstantesPrefactura.NODO_TRASLADOS)){
			traslados = new ArrayList<Traslado>();
		}else if(localName.contains(ConstantesPrefactura.NODO_TRASLADO)){
			Traslado traslado = new Traslado();
			
			float cantidad = (concepto.getCantidad() != null && !concepto.getCantidad().isEmpty()) ? Float.parseFloat(concepto.getCantidad()) : 0F;
			float valorUnitario = (concepto.getValorUnitario() != null && !concepto.getValorUnitario().isEmpty()) ? Float.parseFloat(concepto.getValorUnitario()) : 0F;
			
			DecimalFormat df = new DecimalFormat("#.000000");
			traslado.setBase(df.format(cantidad * valorUnitario));
			
			traslado.setImpuesto(attributes.getValue(ConstantesPrefactura.ATRIB_IMPUESTO));
			traslado.setTasaOCuota((attributes.getValue(ConstantesPrefactura.ATRIB_TASAOCUOTA) != null) ? attributes.getValue(ConstantesPrefactura.ATRIB_TASAOCUOTA) : "0");
			
			float base = (traslado.getBase() != null && !traslado.getBase().isEmpty()) ? Float.parseFloat(traslado.getBase()) : 0F;
			float tasaOCuota = (traslado.getTasaOCuota() != null && !traslado.getTasaOCuota().isEmpty()) ? Float.parseFloat(traslado.getTasaOCuota()) : 0F;
			
			df = new DecimalFormat("#.00");
			traslado.setImporte(df.format(base * tasaOCuota));
			
			traslado.setTipoFactor(attributes.getValue(ConstantesPrefactura.ATRIB_TIPOFACTOR));
			traslados.add(traslado);
		}else if(localName.contains(ConstantesPrefactura.NODO_RETENCIONES)){
			retenciones = new ArrayList<Retencion>();
		}else if(localName.contains(ConstantesPrefactura.NODO_RETENCION)){
			Retencion retencion = new Retencion();
			
			float cantidad = (concepto.getCantidad() != null && !concepto.getCantidad().isEmpty()) ? Float.parseFloat(concepto.getCantidad()) : 0F;
			float valorUnitario = (concepto.getValorUnitario() != null && !concepto.getValorUnitario().isEmpty()) ? Float.parseFloat(concepto.getValorUnitario()) : 0F;
			
			DecimalFormat df = new DecimalFormat("#.000000");
			retencion.setBase(df.format(cantidad * valorUnitario));
			
			retencion.setImpuesto(attributes.getValue(ConstantesPrefactura.ATRIB_IMPUESTO));
			retencion.setTasaOCuota((attributes.getValue(ConstantesPrefactura.ATRIB_TASAOCUOTA) != null) ? attributes.getValue(ConstantesPrefactura.ATRIB_TASAOCUOTA) : "0");
			//retencion.setTasaOCuota(attributes.getValue(ConstantesPrefactura.ATRIB_TASAOCUOTA));
			
			float base = (retencion.getBase() != null && !retencion.getBase().isEmpty()) ? Float.parseFloat(retencion.getBase()) : 0F;
			float tasaOCuota = (retencion.getTasaOCuota() != null && !retencion.getTasaOCuota().isEmpty()) ? Float.parseFloat(retencion.getTasaOCuota()) : 0F;
			
			df = new DecimalFormat("#.00");
			retencion.setImporte(df.format(base * tasaOCuota));
			
			retencion.setTipoFactor(attributes.getValue(ConstantesPrefactura.ATRIB_TIPOFACTOR));
			retenciones.add(retencion);
		}else if(localName.contains(ConstantesPrefactura.NODO_ADUANAS)){
			aduanas = new ArrayList<InformacionAduanera>();
		}else if(localName.contains(ConstantesPrefactura.NODO_INFORMACION_ADUANERA)){
			InformacionAduanera informacionAduanera = new InformacionAduanera();
			informacionAduanera.setNumeroPedimento(attributes.getValue(ConstantesPrefactura.ATRIB_NUMERO_PEDIMENTO));
			aduanas.add(informacionAduanera);
		}else if(localName.contains(ConstantesPrefactura.NODO_PARTE)){
			if(partes == null)
				partes = new ArrayList<Parte>();
			
			Parte parte = new Parte();
			parte.setCantidad(attributes.getValue(ConstantesPrefactura.ATRIB_CANTIDAD));
			parte.setClaveProdServ(attributes.getValue(ConstantesPrefactura.ATRIB_CLAVEPRODSERV));
			parte.setDescripcion(attributes.getValue(ConstantesPrefactura.ATRIB_DESCRIPCION));
			parte.setImporte(attributes.getValue(ConstantesPrefactura.ATRIB_IMPORTE));
			parte.setNoIdentificacion(attributes.getValue(ConstantesPrefactura.ATRIB_NOIDENTIFICACION));
			parte.setUnidad(attributes.getValue(ConstantesPrefactura.ATRIB_UNIDAD));
			parte.setValorUnitario(attributes.getValue(ConstantesPrefactura.ATRIB_VALORUNITARIO));
			partes.add(parte);
		} else if(localName.contains(ConstantesPrefactura.NODO_CFDIS_RELACIONADOS)){
			cfdisRelacionados = new ArrayList<CfdiRelacionado>();
		} else if(localName.contains(ConstantesPrefactura.NODO_CFDI_RELACIONADO)){
			CfdiRelacionado cfdi = new CfdiRelacionado();
			cfdi.setUuid(attributes.getValue(ConstantesPrefactura.ATRIB_UUID));
			cfdisRelacionados.add(cfdi);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName.contains(ConstantesPrefactura.NODO_RETENCIONES)){
			impuestos.setRetenciones(retenciones);
		}else if(localName.contains(ConstantesPrefactura.NODO_TRASLADOS)){
			impuestos.setTraslados(traslados);
		}else if(localName.contains(ConstantesPrefactura.NODO_CONCEPTO)){
			if(concepto != null){
				concepto.setImpuestos(impuestos);
				concepto.setInformacionAduanera(aduanas);
				concepto.setPartes(partes);
				conceptos.add(concepto);
			}	
			partes = null;
			concepto = null;
		}else if(localName.contains(ConstantesPrefactura.NODO_COMPROBANTE)){
			prefactura.setCfdisRelacionados(cfdisRelacionados);
			prefactura.setConceptos(conceptos);
			conceptos = null;
			cfdisRelacionados = null;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		System.err.println(new String(ch, start, length));
	}

	public Prefactura getPrefactura() {
		return prefactura;
	}
}
