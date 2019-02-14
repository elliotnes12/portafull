/**
 * CancelacionMultipleRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service.cancelacion;

public class CancelacionMultipleRequest  implements java.io.Serializable {
    private java.lang.String usuario;

    private java.lang.String contrasena;

    private java.lang.String correo;

    private java.lang.String correoCopia;

    private java.lang.Boolean pdfGenerar;

    private java.lang.String pdfNoPlantilla;

    private java.lang.String telefono;

    private mx.xpd.service.cancelacion.ParametrosCancelaMultiple[] parametros;

    public CancelacionMultipleRequest() {
    }

    public CancelacionMultipleRequest(
           java.lang.String usuario,
           java.lang.String contrasena,
           java.lang.String correo,
           java.lang.String correoCopia,
           java.lang.Boolean pdfGenerar,
           java.lang.String pdfNoPlantilla,
           java.lang.String telefono,
           mx.xpd.service.cancelacion.ParametrosCancelaMultiple[] parametros) {
           this.usuario = usuario;
           this.contrasena = contrasena;
           this.correo = correo;
           this.correoCopia = correoCopia;
           this.pdfGenerar = pdfGenerar;
           this.pdfNoPlantilla = pdfNoPlantilla;
           this.telefono = telefono;
           this.parametros = parametros;
    }


    /**
     * Gets the usuario value for this CancelacionMultipleRequest.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this CancelacionMultipleRequest.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the contrasena value for this CancelacionMultipleRequest.
     * 
     * @return contrasena
     */
    public java.lang.String getContrasena() {
        return contrasena;
    }


    /**
     * Sets the contrasena value for this CancelacionMultipleRequest.
     * 
     * @param contrasena
     */
    public void setContrasena(java.lang.String contrasena) {
        this.contrasena = contrasena;
    }


    /**
     * Gets the correo value for this CancelacionMultipleRequest.
     * 
     * @return correo
     */
    public java.lang.String getCorreo() {
        return correo;
    }


    /**
     * Sets the correo value for this CancelacionMultipleRequest.
     * 
     * @param correo
     */
    public void setCorreo(java.lang.String correo) {
        this.correo = correo;
    }


    /**
     * Gets the correoCopia value for this CancelacionMultipleRequest.
     * 
     * @return correoCopia
     */
    public java.lang.String getCorreoCopia() {
        return correoCopia;
    }


    /**
     * Sets the correoCopia value for this CancelacionMultipleRequest.
     * 
     * @param correoCopia
     */
    public void setCorreoCopia(java.lang.String correoCopia) {
        this.correoCopia = correoCopia;
    }


    /**
     * Gets the pdfGenerar value for this CancelacionMultipleRequest.
     * 
     * @return pdfGenerar
     */
    public java.lang.Boolean getPdfGenerar() {
        return pdfGenerar;
    }


    /**
     * Sets the pdfGenerar value for this CancelacionMultipleRequest.
     * 
     * @param pdfGenerar
     */
    public void setPdfGenerar(java.lang.Boolean pdfGenerar) {
        this.pdfGenerar = pdfGenerar;
    }


    /**
     * Gets the pdfNoPlantilla value for this CancelacionMultipleRequest.
     * 
     * @return pdfNoPlantilla
     */
    public java.lang.String getPdfNoPlantilla() {
        return pdfNoPlantilla;
    }


    /**
     * Sets the pdfNoPlantilla value for this CancelacionMultipleRequest.
     * 
     * @param pdfNoPlantilla
     */
    public void setPdfNoPlantilla(java.lang.String pdfNoPlantilla) {
        this.pdfNoPlantilla = pdfNoPlantilla;
    }


    /**
     * Gets the telefono value for this CancelacionMultipleRequest.
     * 
     * @return telefono
     */
    public java.lang.String getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this CancelacionMultipleRequest.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }


    /**
     * Gets the parametros value for this CancelacionMultipleRequest.
     * 
     * @return parametros
     */
    public mx.xpd.service.cancelacion.ParametrosCancelaMultiple[] getParametros() {
        return parametros;
    }


    /**
     * Sets the parametros value for this CancelacionMultipleRequest.
     * 
     * @param parametros
     */
    public void setParametros(mx.xpd.service.cancelacion.ParametrosCancelaMultiple[] parametros) {
        this.parametros = parametros;
    }

    public mx.xpd.service.cancelacion.ParametrosCancelaMultiple getParametros(int i) {
        return this.parametros[i];
    }

    public void setParametros(int i, mx.xpd.service.cancelacion.ParametrosCancelaMultiple _value) {
        this.parametros[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CancelacionMultipleRequest)) return false;
        CancelacionMultipleRequest other = (CancelacionMultipleRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.contrasena==null && other.getContrasena()==null) || 
             (this.contrasena!=null &&
              this.contrasena.equals(other.getContrasena()))) &&
            ((this.correo==null && other.getCorreo()==null) || 
             (this.correo!=null &&
              this.correo.equals(other.getCorreo()))) &&
            ((this.correoCopia==null && other.getCorreoCopia()==null) || 
             (this.correoCopia!=null &&
              this.correoCopia.equals(other.getCorreoCopia()))) &&
            ((this.pdfGenerar==null && other.getPdfGenerar()==null) || 
             (this.pdfGenerar!=null &&
              this.pdfGenerar.equals(other.getPdfGenerar()))) &&
            ((this.pdfNoPlantilla==null && other.getPdfNoPlantilla()==null) || 
             (this.pdfNoPlantilla!=null &&
              this.pdfNoPlantilla.equals(other.getPdfNoPlantilla()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              this.telefono.equals(other.getTelefono()))) &&
            ((this.parametros==null && other.getParametros()==null) || 
             (this.parametros!=null &&
              java.util.Arrays.equals(this.parametros, other.getParametros())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getContrasena() != null) {
            _hashCode += getContrasena().hashCode();
        }
        if (getCorreo() != null) {
            _hashCode += getCorreo().hashCode();
        }
        if (getCorreoCopia() != null) {
            _hashCode += getCorreoCopia().hashCode();
        }
        if (getPdfGenerar() != null) {
            _hashCode += getPdfGenerar().hashCode();
        }
        if (getPdfNoPlantilla() != null) {
            _hashCode += getPdfNoPlantilla().hashCode();
        }
        if (getTelefono() != null) {
            _hashCode += getTelefono().hashCode();
        }
        if (getParametros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getParametros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getParametros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CancelacionMultipleRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://concretepage.com/soap", ">cancelacionMultipleRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrasena");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "contrasena"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "correo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correoCopia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "correoCopia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdfGenerar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "pdfGenerar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdfNoPlantilla");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "pdfNoPlantilla"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametros");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "parametros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://concretepage.com/soap", "parametrosCancelaMultiple"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
