/**
 * ValidaService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.recibe.mvc;

public interface ValidaService_PortType extends java.rmi.Remote {
    public mx.xpd.recibe.mvc.RespuestaValida agregaMail(java.lang.String rfc, java.lang.String usuario, java.lang.String contrasena, java.lang.String correo, java.lang.String passwordCorreo, java.lang.String urlServidor, java.lang.String puerto) throws java.rmi.RemoteException;
    public java.lang.String[] validarZip(java.lang.String usuario, java.lang.String contrasena, byte[] zip) throws java.rmi.RemoteException;
    public mx.xpd.recibe.mvc.RespuestaValida validar(java.lang.String usuario, java.lang.String contrasena, byte[] cfdi) throws java.rmi.RemoteException;
}
