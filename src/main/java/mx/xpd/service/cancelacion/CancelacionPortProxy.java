package mx.xpd.service.cancelacion;

public class CancelacionPortProxy implements mx.xpd.service.cancelacion.CancelacionPort {
  private String _endpoint = null;
  private mx.xpd.service.cancelacion.CancelacionPort cancelacionPort = null;
  
  public CancelacionPortProxy() {
    _initCancelacionPortProxy();
  }
  
  public CancelacionPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initCancelacionPortProxy();
  }
  
  private void _initCancelacionPortProxy() {
    try {
      cancelacionPort = (new mx.xpd.service.cancelacion.CancelacionPortServiceLocator()).getCancelacionPortSoap11();
      if (cancelacionPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cancelacionPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cancelacionPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cancelacionPort != null)
      ((javax.xml.rpc.Stub)cancelacionPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.xpd.service.cancelacion.CancelacionPort getCancelacionPort() {
    if (cancelacionPort == null)
      _initCancelacionPortProxy();
    return cancelacionPort;
  }
  
  public mx.xpd.service.cancelacion.RespuestaCliente[] cancelacionMultiple(mx.xpd.service.cancelacion.CancelacionMultipleRequest cancelacionMultipleRequest) throws java.rmi.RemoteException{
    if (cancelacionPort == null)
      _initCancelacionPortProxy();
    return cancelacionPort.cancelacionMultiple(cancelacionMultipleRequest);
  }
  
  
}