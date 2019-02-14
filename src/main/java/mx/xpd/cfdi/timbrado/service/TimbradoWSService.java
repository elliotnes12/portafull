/**
 * TimbradoWSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.cfdi.timbrado.service;

public interface TimbradoWSService extends javax.xml.rpc.Service {
    public java.lang.String getTimbradoPortAddress();

    public mx.xpd.cfdi.timbrado.service.Timbrado getTimbradoPort() throws javax.xml.rpc.ServiceException;

    public mx.xpd.cfdi.timbrado.service.Timbrado getTimbradoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
