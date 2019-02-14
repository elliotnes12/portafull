package mx.xpd.cfdi.cxp.constantes;

public class ConstantesCxP {

	/** 
	 * Constantes para la conexion con el servicio API Rest de cuentasporpagar.com
	 * @author: Jorge L. Miñon Morales
     * @version: 25/02/2015
	 */
	
	// ======================================
	// ============ DESARROLLO ==============
	// ======================================	
	public static final String URL_CXP = "URL_CXP";
	public static final String USER_CXP = "USER_CXP";
	public static final String PWD_CXP = "PWD_CXP";	
		
	public static final String PAIS = "/mx/";
	public static final String USUARIOS = "/usuarios";
	
	// ==================================================
	// ======== STATUS HTTP LISTA INQUILINOS ============
	// ==================================================
	public static final int SUCCESS_TENANT_LIST = 200;
	public static final int UNAUTHENTICATED_TENANTS_LIST = 401;
	public static final int WITHOUT_AUTHORITY_TENANTS_LIST = 403;
	
	// ==================================================
	// ======== STATUS HTTP OBTENER INQUILINO ===========
	// ==================================================
	public static final int SUCCESS_GET_TENANT = 200;
	public static final int UNAUTHENTICATED_GET_TENANT = 401;
	public static final int WITHOUT_AUTHORITY_GET_TENANT = 403;
	public static final int TENANT_NOT_FOUND = 404;
	
	// ==================================================
	// ======== STATUS HTTP INGRESAR INQUILINO ==========
	// ==================================================
	public static final int SUCCESS_SET_TENANT = 202;
	public static final int UNAUTHENTICATED_SET_TENANT = 401;
	public static final int WITHOUT_AUTHORITY_SET_TENANT = 403;	
	
	// ==================================================
	// ======== STATUS HTTP INGRESAR USUARIO ============
	// ==================================================
	public static final int SUCCESS_SET_USER = 201;
	public static final int UNAUTHENTICATED_SET_USER = 401;
	public static final int WITHOUT_AUTHORITY_SET_USER = 403;
	public static final int INVALID_USER = 422;	
		
	// ===============================================
	// ==== ROL DEFAULT PARA CREACION DE USUARIO =====
	// ===============================================
	public static final String ADMINISTRATOR_ROLE = "administrador";
	// -- 
	public static final String CONSULTANT_ROLE = "consultante";
	public static final String CAPTURIST_ROLE = "capturista";
			
}

