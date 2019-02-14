/**
 * CancelacionProductivo_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service;

public class CancelacionProductivo_ServiceLocator extends org.apache.axis.client.Service implements mx.xpd.service.CancelacionProductivo_Service {

    public CancelacionProductivo_ServiceLocator() {
    }


    public CancelacionProductivo_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CancelacionProductivo_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CancelacionProductivoPort
    private java.lang.String CancelacionProductivoPort_address = null;

    public java.lang.String getCancelacionProductivoPortAddress() {
        return CancelacionProductivoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CancelacionProductivoPortWSDDServiceName = "CancelacionProductivoPort";

    public java.lang.String getCancelacionProductivoPortWSDDServiceName() {
        return CancelacionProductivoPortWSDDServiceName;
    }

    public void setCancelacionProductivoPortWSDDServiceName(java.lang.String name) {
        CancelacionProductivoPortWSDDServiceName = name;
    }

    public mx.xpd.service.CancelacionProductivo_PortType getCancelacionProductivoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CancelacionProductivoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCancelacionProductivoPort(endpoint);
    }

    public mx.xpd.service.CancelacionProductivo_PortType getCancelacionProductivoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.xpd.service.CancelacionProductivoSoapBindingStub _stub = new mx.xpd.service.CancelacionProductivoSoapBindingStub(portAddress, this);
            _stub.setPortName(getCancelacionProductivoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCancelacionProductivoPortEndpointAddress(java.lang.String address) {
        CancelacionProductivoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.xpd.service.CancelacionProductivo_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.xpd.service.CancelacionProductivoSoapBindingStub _stub = new mx.xpd.service.CancelacionProductivoSoapBindingStub(new java.net.URL(CancelacionProductivoPort_address), this);
                _stub.setPortName(getCancelacionProductivoPortWSDDServiceName());
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
        if ("CancelacionProductivoPort".equals(inputPortName)) {
            return getCancelacionProductivoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.xpd.mx/", "CancelacionProductivo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.xpd.mx/", "CancelacionProductivoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CancelacionProductivoPort".equals(portName)) {
            setCancelacionProductivoPortEndpointAddress(address);
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
