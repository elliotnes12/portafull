/**
 * CancelacionProductivo_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service;

public interface CancelacionProductivo_PortType extends java.rmi.Remote {
    public mx.xpd.service.RespuestaCancelacion cancelar(java.lang.String usuario, java.lang.String token, byte[] xmlBytes) throws java.rmi.RemoteException;
}
