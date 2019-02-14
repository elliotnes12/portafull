/**
 * 
 */
package mx.xpd.cfdi.constantes;

/**
 * Archivo de constanstes con las URLs de los servicios
 * que usa el portal
 * 
 * @author XPD
 *
 */
public interface URLConstants {
	/** Dominio o IP del portal */
	String DOMAIN_PORTAL = "portal.expidetufactura.com.mx";
		
	/** URL principal del portal */
	String URL_PORTAL = "http://" + DOMAIN_PORTAL;
	
	/** URL segura del portal */
	String SECURE_URL_PORTAL = "https://" + DOMAIN_PORTAL + ":8443";

	/** URL para addendas */
	//String ADDENDAS = URL_PORTAL + "/addendas/";
	//String ADDENDAS = "http://169.57.13.228/apps/addendas/";
	String ADDENDAS = "https://xpdportal1.expidetufactura.com.mx/apps/addendasportal33/";

	/** URL para addendas de retenciones */
	//String ADDENDAS = URL_PORTAL + "/addendasRetenciones/";
	String ADDENDAS_RETENCIONES = "http://169.57.13.228/apps/addendasRetenciones/";
	
	/** URL del servicio web que convierte numero a letra */
	String WS_NUMERO_LETRA = URL_PORTAL + ":86/ws/numero_a_letra_ireport.php?numero=";
	
	/** URL para cambio de password */
	String CAMBIO_PASSWORD = "https://xpdportal1.expidetufactura.com.mx:8443/CFDI33/j_spring_security_check?j_username=:tenant&j_password=:password&rfc=admin&paso=1";
	//String CAMBIO_PASSWORD = "http://169.57.13.230:8080/CFDI33/j_spring_security_check?j_username=:tenant&j_password=:password&rfc=admin&paso=1";
	
	/** URL Login */
	String LOGIN = "https://xpdportal1.expidetufactura.com.mx:8443/CFDI33/login";
	//String LOGIN = "http://169.57.13.230:8080/CFDI33/login";
	
	/** URL Firmar Manifiesto */
	String FIRMAR_MANIFIESTO = "http://portal1.expidetufactura.com.mx:8080/FirmarManifiesto/";
	
	/** URL de la plantilla de nomina */
	String PLANTILLA_NOMINA = URL_PORTAL + ":86/nomina/plantilla12_33.xlsm";
	
	/** URL de la plantilla de nomina */
	String PLANTILLA_EMPLEADOS = URL_PORTAL + "/nomina/plantillaEmpleados.xlsx";
	
	/** URL de la plantilla de empleados */
	String PLANTILLA_EMPLEADOSNOMINA = URL_PORTAL + ":86/nomina/plantillaEmpleadosNomina33.xlsx";
	
	/** URL del servicio de validacion de recibe tu factura */
	String VALIDA_SERVICE = "http://xpdsystem.expidetufactura.com.mx:8080/RecibeFactura/ValidaService";
	
	/** URL de la plantilla de nomina */
	String MANUAL_RESETEO_CONTRASENIA = URL_PORTAL + ":86/nomina/Funcionalidad_Reseteo_Contrasenia.pdf";
	
	/** URL de Manual Portal */
	String MANUAL_PORTAL33 = URL_PORTAL + ":86/nomina/ManualPortalV3.3.pdf";
	
	/** URL de Manual Portal */
	String EMISIONRECIBOPAGO_DOC = URL_PORTAL + ":86/nomina/EmisionDelReciboDePago.pptx";
	
	/** URL de Manual Portal */
	String USOSCOMPROBANTERECIBOPAGO_DOC = URL_PORTAL + ":86/nomina/UsosDelComprobanteDeReciboDePago.pptx";
	
	/** URL de Manual Nuevo Esquema Cancelación */
	String MANUAL_NUEVA_CANCELACION = URL_PORTAL + ":86/nomina/Manual_cancelacion_PortalXPDv3.3.pdf";
	
	/** URL de Info Recomienda */
	String INFO_RECOMIENDA = URL_PORTAL + ":86/nomina/recomienda.pdf";
	
	/** URL de Guía de Llenado Comprobante Pagos */
	String GUIALLENADOCOMPPAGOS_DOC = URL_PORTAL + ":86/nomina/GuiaLlenadoComprobantePago.pdf";
}
