/**
 * TimbradoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.cfdi.timbrado.service;

import java.rmi.Remote;

public class TimbradoWSServiceLocator extends org.apache.axis.client.Service implements mx.xpd.cfdi.timbrado.service.TimbradoWSService {

    public TimbradoWSServiceLocator() {
    }


    public TimbradoWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TimbradoWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TimbradoPort
    private java.lang.String TimbradoPort_address = "http://184.173.65.10:8080/pruebas/TimbradoWS";

    public java.lang.String getTimbradoPortAddress() {
        return TimbradoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TimbradoPortWSDDServiceName = "TimbradoPort";

    public java.lang.String getTimbradoPortWSDDServiceName() {
        return TimbradoPortWSDDServiceName;
    }

    public void setTimbradoPortWSDDServiceName(java.lang.String name) {
        TimbradoPortWSDDServiceName = name;
    }

    public mx.xpd.cfdi.timbrado.service.Timbrado getTimbradoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TimbradoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTimbradoPort(endpoint);
    }

    public mx.xpd.cfdi.timbrado.service.Timbrado getTimbradoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.xpd.cfdi.timbrado.service.TimbradoWSServiceSoapBindingStub _stub = new mx.xpd.cfdi.timbrado.service.TimbradoWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTimbradoPortWSDDServiceName());
            return (Timbrado) _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTimbradoPortEndpointAddress(java.lang.String address) {
        TimbradoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.xpd.cfdi.timbrado.service.Timbrado.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.xpd.cfdi.timbrado.service.TimbradoWSServiceSoapBindingStub _stub = new mx.xpd.cfdi.timbrado.service.TimbradoWSServiceSoapBindingStub(new java.net.URL(TimbradoPort_address), this);
                _stub.setPortName(getTimbradoPortWSDDServiceName());
                return (Remote) _stub;
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
        if ("TimbradoPort".equals(inputPortName)) {
            return getTimbradoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.timbrado.xpd.mx/", "TimbradoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.timbrado.xpd.mx/", "TimbradoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TimbradoPort".equals(portName)) {
            setTimbradoPortEndpointAddress(address);
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
