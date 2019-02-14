package mx.xpd.cfdi.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import mx.xpd.cfdi.domain.cfdi.Complemento;
import mx.xpd.cfdi.domain.cfdi.Comprobante;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.AlternateTradeItemIdentification;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.GrossPrice;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.NetPrice;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TotalLineAmount;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TotalLineAmount.GrossAmount;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TotalLineAmount.NetAmount;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TradeItemDescriptionInformation;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TradeItemIdentification;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.HorasExtra;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.HorasExtras;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Nomina;
import mx.xpd.cfdi.domain.cfdi.complementos.notarios.NotariosPublicos;
import mx.xpd.cfdi.domain.cfdi.complementos.notarios.NotariosPublicos.DatosAdquiriente;
import mx.xpd.cfdi.domain.cfdi.complementos.notarios.NotariosPublicos.DatosAdquiriente.DatosAdquirientesCopSC;
import mx.xpd.cfdi.domain.cfdi.complementos.notarios.NotariosPublicos.DatosAdquiriente.DatosAdquirientesCopSC.DatosAdquirienteCopSC;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

class  Numero_a_Letra {

    private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
        "setecientos ", "ochocientos ", "novecientos "};

   public Numero_a_Letra() {
   }

    public String Convertir(String numero, boolean mayusculas) {
        String literal = "";
        String parte_decimal;    
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        numero = numero.replace(".", ",");
        //si el numero no tiene parte decimal, se le agrega ,00
        if(numero.indexOf(",")==-1){
            numero = numero + ",00";
        }
        //se valida formato de entrada -> 0,00 y 999 999 999,00
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            //se divide el numero 0000000,00 -> entero y decimal
            String Num[] = numero.split(",");            
            //de da formato al numero decimal
            parte_decimal = Num[1] + "/100 Bolivianos.";
            //se convierte el numero a literal
            if (Integer.parseInt(Num[0]) == 0) {//si el valor es cero
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                literal = getDecenas(Num[0]);
            } else {//sino unidades -> 9
                literal = getUnidades(Num[0]);
            }
            //devuelve el resultado en mayusculas o minusculas
            if (mayusculas) {
                return (literal + parte_decimal).toUpperCase();
            } else {
                return (literal + parte_decimal);
            }
        } else {//error, no se puede convertir
            return literal = null;
        }
    }

    /* funciones para convertir los numeros a literales */

    private String getUnidades(String numero) {// 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private String getDecenas(String num) {// 99                        
        int n = Integer.parseInt(num);
        if (n < 10) {//para casos como -> 01 - 09
            return getUnidades(num);
        } else if (n > 19) {//para 20...99
            String u = getUnidades(num);
            if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {//numeros entre 11 y 19
            return DECENAS[n - 10];
        }
    }

    private String getCentenas(String num) {// 999 o 099
        if( Integer.parseInt(num)>99 ){//es centena
            if (Integer.parseInt(num) == 100) {//caso especial
                return " cien ";
            } else {
                 return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            } 
        }else{//por Ej. 099 
            //se quita el 0 antes de convertir a decenas
            return getDecenas(Integer.parseInt(num)+"");            
        }        
    }

    private String getMiles(String numero) {// 999 999
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n="";
        //se comprueba que miles tenga valor entero
        if (Integer.parseInt(m) > 0) {
            n = getCentenas(m);           
            return n + "mil " + getCentenas(c);
        } else {
            return "" + getCentenas(c);
        }

    }

    private String getMillones(String numero) { //000 000 000        
        //se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        //se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if(millon.length()>1){
            n = getCentenas(millon) + "millones ";
        }else{
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);        
    }
}
public class Main {

	private static String getXMLComprobante(Comprobante cfdi) {
		String result = null;
		try {
			//DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    //dbf.setNamespaceAware(true);
		    //Document doc = dbf.newDocumentBuilder().newDocument();
		    JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd");
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//jaxbMarshaller.marshal(cfdi, doc);
			
			StringWriter strXML = new StringWriter(); 
			jaxbMarshaller.marshal(cfdi, strXML);
			result = strXML.toString().replace("<cfdi:ImpuestosLocales", "<implocal:ImpuestosLocales "
					+ "xsi:schemaLocation=\"http://www.sat.gob.mx/implocal http://www.sat.gob.mx/sitio_internet/cfd/implocal/implocal.xsd\""
					+ "").replace("cfdi:ImpuestosLocales", "implocal:ImpuestosLocales");
		} catch(Exception e) {
			
			e.printStackTrace();
		} finally {
			return result;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		
		
		NotariosPublicos not = new NotariosPublicos();
		
		DatosAdquirienteCopSC das = new DatosAdquirienteCopSC();
		das.setApellidoMaterno("www");
		das.setApellidoPaterno("ssa");
		
		DatosAdquirientesCopSC da1 = new DatosAdquirientesCopSC();
		
		da1.getDatosAdquirienteCopSC().add(das);
		
		DatosAdquiriente dA = new DatosAdquiriente();
		
		dA.setCoproSocConyugalE("si");
		dA.setDatosAdquirientesCopSC(da1);
		
		not.setDatosAdquiriente(dA);
		
		Gson gg = new Gson();
		System.out.println(gg.toJson(not));
		
		
		
		if (true)
			 return;
		
		
		if (true) {
			return;
		}
		
		
		
		Detallista d = new Detallista();
		
		LineItem li = new LineItem();
		
		TradeItemIdentification t = new TradeItemIdentification();
		t.setGtin("1");
		li.setTradeItemIdentification(t);
		AlternateTradeItemIdentification a = new AlternateTradeItemIdentification();
		a.setType("BUYER_ASSIGNED");
		a.setValue("1");
		TradeItemDescriptionInformation td =  new TradeItemDescriptionInformation();
		td.setLanguage("ES");
		td.setLongText("Perro Chihuahua");
		
		GrossPrice p = new GrossPrice();
		p.setAmount(new BigDecimal(500));
		
		NetPrice n = new NetPrice();
		n.setAmount(new BigDecimal(500));
		
		
		TotalLineAmount tl = new TotalLineAmount();
		
		GrossAmount ga = new GrossAmount();
		ga.setAmount(new BigDecimal(1500));
		
		NetAmount na = new NetAmount();
		ga.setAmount(new BigDecimal(1500));
		
		
		tl.setGrossAmount(ga);
		tl.setNetAmount(na);
		li.setTotalLineAmount(tl);
		
		li.setGrossPrice(p);
		
		
		
		d.setContentVersion("1.0");
		d.getLineItem().add(li);
		
		
		li = new LineItem();
		
		t = new TradeItemIdentification();
		t.setGtin("1");
		li.setTradeItemIdentification(t);
		a = new AlternateTradeItemIdentification();
		a.setType("BUYER_ASSIGNED");
		a.setValue("1");
		td =  new TradeItemDescriptionInformation();
		td.setLanguage("ES");
		td.setLongText("Perro 2");
		
		p = new GrossPrice();
		p.setAmount(new BigDecimal(500));
		
		n = new NetPrice();
		n.setAmount(new BigDecimal(500));
		
		
		tl = new TotalLineAmount();
		
		ga = new GrossAmount();
		ga.setAmount(new BigDecimal(1500));
		
		na = new NetAmount();
		ga.setAmount(new BigDecimal(1500));
		
		
		AlternateTradeItemIdentification al = new AlternateTradeItemIdentification();
		
		al.setType("ok");
		al.setValue("123");
		
		li.getAlternateTradeItemIdentification().add(al);
		
		tl.setGrossAmount(ga);
		tl.setNetAmount(na);
		li.setTotalLineAmount(tl);
		
		li.setGrossPrice(p);
		
		
		
		d.setContentVersion("1.0");
		d.getLineItem().add(li);
		
		Gson g = new Gson();
		System.out.println(g.toJson(d));
		
		
		
		if (true)
			 return;
		
		Comprobante cfdi = new Comprobante();
		
		HorasExtra hE = new HorasExtra();
		hE.setDias(2);
		hE.setImportePagado(222.2);
		
		HorasExtras hors = new HorasExtras();
		List<HorasExtra> list = new ArrayList<HorasExtra>();
		list.add(hE);
		
		hE = new HorasExtra();
		hE.setDias(21);
		hE.setImportePagado(222.2);
		list.add(hE);
		hors.setHorasExtra(list);
		
		Nomina nom = new Nomina();
		nom.setVersion("1.0");
		nom.setHorasExtras(hors);
		Complemento com = new Complemento();
		com.setNomina(nom);
		cfdi.setComplemento(com);
		cfdi.setVersion("3.2");
		Gson gson = new Gson();
		
		System.out.println(gson.toJsonTree(cfdi));
		
		if (true) return;
		
		
	
	
		String strComprobante = " {   'lugarExpedicion': 'Miahuatlan de Porfirio Diaz, Oaxaca',   'tipoDeComprobante': 'fa',   'folio': '2',   'fecha': '2014-02-10T10:54:37',   'metodoDePago': 'Efectivo',   'moneda': 'Peso',   'tipoCambio': '1.0',   'formaDePago': 'Pago en una sola exhibición',   'subTotal': '1310',   'totalDescuento': '0',   'totalIEPS': '0',   'totalIVA': '209.6',   'totalIVARetenido': '',   'totalISRRetenido': '',   'totalDeRetenciones': '0.00',   'totalDeTraslados': '0.00',   'total': '1519.6',   'emisor': {    'nombre': 'MARIA TERESA MARTINEZ',    'rfc': 'MATE580608NG1',    'domicilioFiscal': {     'calle': 'AV. 3 DE OCTUBRE',     'noExterior': '515',     'colonia': 'SANTA CECILIA',     'ciudad': 'OAXACA',     'localidad': 'MIAHUATLAN  DE PORFIRIO DIAZ',     'municipio': 'MIAHUATLAN  DE PORFIRIO DIAZ',     'estado': 'Oaxaca',     'pais': 'México',     'codigoPostal': '70800'    }   },   'receptor': {    'nombre': 'SOCTON CONSTRUCCIONES SA. DE CV.',    'rfc': 'SCO840831CG2',    'email': 'socton2@prodigy.net.mx',    'domicilio': {     'calle': 'AV PALMA CAMEDOR',     'noExterior': '314',     'colonia': 'FRACC LAS PALMAS',     'codigoPostal': '29040',     'municipio': 'TUXTLA GUTIERREZ',     'localidad': 'CHIAPAS ',     'pais': 'México',     'estado': 'Chiapas'    }   },   'conceptos': {    'conceptos': [     {      'cantidad': 1,      'unidad': 'Pieza',      'valorUnitario': 550,      'iva': 88,      'descripcion': 'juego de balatas',      'importe': 550     },     {      'cantidad': 2,      'unidad': 'Pieza',      'valorUnitario': 130,      'iva': 41.6,      'descripcion': 'calibradores de freno',      'importe': 260     },     {      'cantidad': 1,      'unidad': 'Pieza',      'valorUnitario': 500,      'iva': 80,      'descripcion': 'balero trasero',      'importe': 500     }    ]   },   'impuestos': {    'totalImpuestosTrasladados': 209.6,    'traslados': {     'traslados': [      {       'tasa': 16,       'importe': 209.6,       'impuesto': 'IVA'      }     ]    }   },   'complemento': {    'impuestosLocales': {     'trasladosLocales': {      'trasladosLocales': [       {        'tipoImpuesto': 'Traslado',        'impLoc': '',        'tasade': '0.0.',        'importe': '0'       }      ]     },     'totalDeTraslados': '0.00',     'totalDeRetenciones': '0.00'    }   },   'observaciones': '',   'descuento': 0 }";
		
		//strComprobante = "{ 'lugarExpedicion': 'Puebla, Puebla', 'tipoDeComprobante': 'rn', 'serie': 'A', 'fecha': '2014-01-07T15:10:13', 'observaciones': '', 'subTotal': '48', 'totalDescuento': '24', 'totalISRRetenido': '0', 'total': '24', 'emisor': {  'nombre': 'CPA Control de Comprobantes Digitales S. de R.L. de C.V.',  'rfc': 'AAD990814BP7',  'domicilioFiscal': {   'calle': 'Privada 29 B Sur',   'noExterior': '3306',   'colonia': 'El Vergel',   'localidad': 'Puebla',   'municipio': 'Puebla',   'estado': 'Puebla',   'pais': 'México',   'codigoPostal': '12400'  } }, 'receptor': {  'nombre': 'AAD990814BP7',  'rfc': 'AAD990814BP7',  'domicilio': {} }, 'complemento': {  'nomina': {   'percepciones': [    {     'percepcion': {      'tipoPercepcion': '019',      'concepto': [       'Horas extra',       'Pago de nómina'      ],      'id': '0',      'clave': '1',      'importeGravado': '12',      'importeExento': '12',      'totalGravado': '0.00',      'totalExento': '0.00',      'cantiad': '1',      'unidad': 'Servicio',      'valorUnitario': '0.00',      'importe': '0.00',      'eliminado': false     }    },    {     'percepcion': {      'tipoPercepcion': '019',      'concepto': [       'Horas extra',       'Pago de nómina'      ],      'id': '1',      'clave': '1',      'importeGravado': '12',      'importeExento': '12',      'totalGravado': '12',      'totalExento': '12',      'cantiad': '1',      'unidad': 'Servicio',      'valorUnitario': '24',      'importe': '24',      'eliminado': false     }    }   ],   'deducciones': [    {     'deduccion': {      'tipoDeduccion': '019',      'concepto': 'Cuotas sindicales',      'id': '0',      'clave': '1',      'importeGravado': '12',      'importeExento': '12',      'totalGravado': '0.00',      'totalExento': '0.00',      'eliminado': false     }    }   ]  } }} ";
		
		strComprobante = 
				"{" + 
						" 'lugarExpedicion': 'AcuÃ±a, Coahuila de Zaragoza'," + 
						" 'tipoDeComprobante': 'fa'," + 
						" 'folio': '1'," + 
						" 'fecha': '2014-02-10T17:44:01'," + 
						" 'metodoDePago': 'TRANSFERENCIA'," + 
						" 'numCtaPago': 'No identificado'," + 
						" 'moneda': 'Peso'," + 
						" 'tipoCambio': '1.0'," + 
						" 'formaDePago': 'Pago en una sola exhibición'," + 
						" 'subTotal': '46158.72'," + 
						" 'totalDescuento': '0'," + 
						" 'totalIEPS': '0'," + 
						" 'totalIVA': '7385.4'," + 
						" 'totalIVARetenido': '4923.60'," + 
						" 'totalISRRetenido': ''," + 
						" 'totalDeRetenciones': '0.00'," + 
						" 'totalDeTraslados': '0.00'," + 
						" 'total': '48620.52'," + 
						" 'emisor': {" + 
						"  'nombre': 'ELVIA DIONICIA HERNANDEZ NAVARRO'," + 
						"  'rfc': 'HENE840621Q22'," + 
						"  'domicilioFiscal': {" + 
						"   'calle': 'POPOTLA'," + 
						"   'noExterior': '1635'," + 
						"   'colonia': 'AEROPUERTO'," + 
						"   'ciudad': 'ACUÃ??A'," + 
						"   'municipio': 'AcuÃ?Â±a'," + 
						"   'estado': 'Coahuila'," + 
						"   'pais': 'MÃ©xico'," + 
						"   'codigoPostal': '26230'" + 
						"  }" + 
						" }," + 
						" 'receptor': {" + 
						"  'nombre': 'CADENA COMERCIAL OXXO S.A DE C.V'," + 
						"  'rfc': 'CCO8605231N4'," + 
						"  'email': 'despacholoal@hotmail.com'," + 
						"  'domicilio': {" + 
						"   'calle': 'PASEO DE LA CIENCIA'," + 
						"   'noExterior': '802'," + 
						"   'colonia': 'TECNOLOGICO'," + 
						"   'codigoPostal': '26080'," + 
						"   'municipio': 'PIEDRAS NEGRAS'," + 
						"   'pais': 'México'," + 
						"   'estado': 'Coahuila'" + 
						"  }" + 
						" }," + 
						" 'conceptos': {" + 
						"  'conceptos': [" + 
						"   {" + 
						"    'cantidad': 1," + 
						"    'unidad': 'No Aplica'," + 
						"    'valorUnitario': 46158.72," + 
						"    'iva': 7385.4," + 
						"    'descripcion': 'COMISION DEL MES DE ENERO 2014'," + 
						"    'importe': 46158.72" + 
						"   }" + 
						"  ]" + 
						" }," + 
						" 'impuestos': {" + 
						"  'totalImpuestosTrasladados': 7385.4," + 
						"  'traslados': {" + 
						"   'traslados': [" + 
						"    {" + 
						"     'tasa': 16," + 
						"     'importe': 7385.4," + 
						"     'impuesto': 'IVA'" + 
						"    }" + 
						"   ]" + 
						"  }," + 
						"  'retenidos': {" + 
						"   'retenciones': [" + 
						"    {" + 
						"     'impuesto': 'IVA'," + 
						"     'importe': 4923.6" + 
						"    }" + 
						"   ]" + 
						"  }," + 
						"  'totalImpuestosRetenidos': 4923.6" + 
						" }," + 
						" 'observaciones': ''," + 
						" 'descuento': 0" + 
						"}";
		
		
		
		//omprobante
		cfdi  = gson.fromJson(strComprobante,  Comprobante.class);
		
		System.out.println(getXMLComprobante(cfdi));
		
		if (true) return;
		
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitMatrix = null;
		try {
		    bitMatrix = writer.encode("re=AAD990814BP7&rr=XAXX010101000&tt=167.03&id=1a03cd20-75f9-4941-ac89-2407e1f847b7", BarcodeFormat.QR_CODE, 300, 300);
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		    MatrixToImageWriter.writeToFile(bitMatrix, "png", new File("/home/jorge/cfdi/algo.png"));
		    MatrixToImageWriter.writeToStream(bitMatrix, "png", out);
		    InputStream in = new ByteArrayInputStream(out.toByteArray());		
		    
		    JasperReport report = null; //JasperCompileManager.compileReport("/home/jorge/cfdi/plantillas/plantilla.jrxml");
		    
		    report = (JasperReport) JRLoader.loadObjectFromFile("/home/jorge/cfdi/plantillas/plantilla.jasper");
		    
		    HashMap<String, Object> map = new HashMap<String, Object>();
		    map.put("imageQR", in);
		    
		    JRXmlDataSource ds = new JRXmlDataSource("/home/jorge/cfdi/xml/AAD990814BP7/52f4b447-3fac-4aa2-9ef2-97d0dba73461.xml"); 
		    
		    JasperPrint print = JasperFillManager.fillReport(report, map, ds);
		    JasperExportManager.exportReportToPdfFile(print, "/home/jorge/cfdi/plantillas/algo.pdf");
		    
		    
		} catch(Exception e) {
			
			e.getCause().getMessage();
			
			e.printStackTrace();
		}
	}

}
