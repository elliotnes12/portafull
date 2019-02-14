/**
 * CancelacionPortServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service.cancelacion;

public class CancelacionPortServiceLocator extends org.apache.axis.client.Service implements mx.xpd.service.cancelacion.CancelacionPortService {

    public CancelacionPortServiceLocator() {
    }


    public CancelacionPortServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CancelacionPortServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CancelacionPortSoap11
    private java.lang.String CancelacionPortSoap11_address = "http://cancelacionxpd.expidetufactura.com.mx:1080/coreCancelacionPruebas/soapws";

    public java.lang.String getCancelacionPortSoap11Address() {
        return CancelacionPortSoap11_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CancelacionPortSoap11WSDDServiceName = "CancelacionPortSoap11";

    public java.lang.String getCancelacionPortSoap11WSDDServiceName() {
        return CancelacionPortSoap11WSDDServiceName;
    }

    public void setCancelacionPortSoap11WSDDServiceName(java.lang.String name) {
        CancelacionPortSoap11WSDDServiceName = name;
    }

    public mx.xpd.service.cancelacion.CancelacionPort getCancelacionPortSoap11() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CancelacionPortSoap11_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCancelacionPortSoap11(endpoint);
    }

    public mx.xpd.service.cancelacion.CancelacionPort getCancelacionPortSoap11(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.xpd.service.cancelacion.CancelacionPortSoap11Stub _stub = new mx.xpd.service.cancelacion.CancelacionPortSoap11Stub(portAddress, this);
            _stub.setPortName(getCancelacionPortSoap11WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCancelacionPortSoap11EndpointAddress(java.lang.String address) {
        CancelacionPortSoap11_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.xpd.service.cancelacion.CancelacionPort.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.xpd.service.cancelacion.CancelacionPortSoap11Stub _stub = new mx.xpd.service.cancelacion.CancelacionPortSoap11Stub(new java.net.URL(CancelacionPortSoap11_address), this);
                _stub.setPortName(getCancelacionPortSoap11WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CancelacionPortSoap11".equals(inputPortName)) {
            return getCancelacionPortSoap11();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://concretepage.com/soap", "CancelacionPortService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://concretepage.com/soap", "CancelacionPortSoap11"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CancelacionPortSoap11".equals(portName)) {
            setCancelacionPortSoap11EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
