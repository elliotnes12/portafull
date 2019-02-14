package mx.xpd.service;

public class CancelacionProductivoProxy implements mx.xpd.service.CancelacionProductivo_PortType {
  private String _endpoint = null;
  private mx.xpd.service.CancelacionProductivo_PortType cancelacionProductivo_PortType = null;
  
  public CancelacionProductivoProxy() {
    _initCancelacionProductivoProxy();
  }
  
  public CancelacionProductivoProxy(String endpoint) {
    _endpoint = endpoint;
    _initCancelacionProductivoProxy();
  }
  
  private void _initCancelacionProductivoProxy() {
    try {
      cancelacionProductivo_PortType = (new mx.xpd.service.CancelacionProductivo_ServiceLocator()).getCancelacionProductivoPort();
      if (cancelacionProductivo_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cancelacionProductivo_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cancelacionProductivo_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cancelacionProductivo_PortType != null)
      ((javax.xml.rpc.Stub)cancelacionProductivo_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.xpd.service.CancelacionProductivo_PortType getCancelacionProductivo_PortType() {
    if (cancelacionProductivo_PortType == null)
      _initCancelacionProductivoProxy();
    return cancelacionProductivo_PortType;
  }
  
  public mx.xpd.service.RespuestaCancelacion cancelar(java.lang.String usuario, java.lang.String token, byte[] xmlBytes) throws java.rmi.RemoteException{
    if (cancelacionProductivo_PortType == null)
      _initCancelacionProductivoProxy();
    return cancelacionProductivo_PortType.cancelar(usuario, token, xmlBytes);
  }
  
  
}