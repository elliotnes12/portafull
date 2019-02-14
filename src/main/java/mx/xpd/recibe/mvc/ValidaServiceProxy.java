package mx.xpd.recibe.mvc;

public class ValidaServiceProxy implements mx.xpd.recibe.mvc.ValidaService_PortType {
  private String _endpoint = null;
  private mx.xpd.recibe.mvc.ValidaService_PortType validaService_PortType = null;
  
  public ValidaServiceProxy() {
    _initValidaServiceProxy();
  }
  
  public ValidaServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initValidaServiceProxy();
  }
  
  private void _initValidaServiceProxy() {
    try {
      validaService_PortType = (new mx.xpd.recibe.mvc.ValidaService_ServiceLocator()).getValidaServicePort();
      if (validaService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)validaService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)validaService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (validaService_PortType != null)
      ((javax.xml.rpc.Stub)validaService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.xpd.recibe.mvc.ValidaService_PortType getValidaService_PortType() {
    if (validaService_PortType == null)
      _initValidaServiceProxy();
    return validaService_PortType;
  }
  
  public mx.xpd.recibe.mvc.RespuestaValida agregaMail(java.lang.String rfc, java.lang.String usuario, java.lang.String contrasena, java.lang.String correo, java.lang.String passwordCorreo, java.lang.String urlServidor, java.lang.String puerto) throws java.rmi.RemoteException{
    if (validaService_PortType == null)
      _initValidaServiceProxy();
    return validaService_PortType.agregaMail(rfc, usuario, contrasena, correo, passwordCorreo, urlServidor, puerto);
  }
  
  public java.lang.String[] validarZip(java.lang.String usuario, java.lang.String contrasena, byte[] zip) throws java.rmi.RemoteException{
    if (validaService_PortType == null)
      _initValidaServiceProxy();
    return validaService_PortType.validarZip(usuario, contrasena, zip);
  }
  
  public mx.xpd.recibe.mvc.RespuestaValida validar(java.lang.String usuario, java.lang.String contrasena, byte[] cfdi) throws java.rmi.RemoteException{
    if (validaService_PortType == null)
      _initValidaServiceProxy();
    return validaService_PortType.validar(usuario, contrasena, cfdi);
  }
  
  
}