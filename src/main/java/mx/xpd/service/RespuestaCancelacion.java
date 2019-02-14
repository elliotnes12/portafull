/**
 * RespuestaCancelacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service;

public class RespuestaCancelacion  implements java.io.Serializable {
    private java.lang.String acuse;

    private java.lang.String codEstatus;

    private java.lang.String codMensaje;

    private java.lang.String[] estatusUUIDs;

    private java.lang.String[] uuids;

    public RespuestaCancelacion() {
    }

    public RespuestaCancelacion(
           java.lang.String acuse,
           java.lang.String codEstatus,
           java.lang.String codMensaje,
           java.lang.String[] estatusUUIDs,
           java.lang.String[] uuids) {
           this.acuse = acuse;
           this.codEstatus = codEstatus;
           this.codMensaje = codMensaje;
           this.estatusUUIDs = estatusUUIDs;
           this.uuids = uuids;
    }


    /**
     * Gets the acuse value for this RespuestaCancelacion.
     * 
     * @return acuse
     */
    public java.lang.String getAcuse() {
        return acuse;
    }


    /**
     * Sets the acuse value for this RespuestaCancelacion.
     * 
     * @param acuse
     */
    public void setAcuse(java.lang.String acuse) {
        this.acuse = acuse;
    }


    /**
     * Gets the codEstatus value for this RespuestaCancelacion.
     * 
     * @return codEstatus
     */
    public java.lang.String getCodEstatus() {
        return codEstatus;
    }


    /**
     * Sets the codEstatus value for this RespuestaCancelacion.
     * 
     * @param codEstatus
     */
    public void setCodEstatus(java.lang.String codEstatus) {
        this.codEstatus = codEstatus;
    }


    /**
     * Gets the codMensaje value for this RespuestaCancelacion.
     * 
     * @return codMensaje
     */
    public java.lang.String getCodMensaje() {
        return codMensaje;
    }


    /**
     * Sets the codMensaje value for this RespuestaCancelacion.
     * 
     * @param codMensaje
     */
    public void setCodMensaje(java.lang.String codMensaje) {
        this.codMensaje = codMensaje;
    }


    /**
     * Gets the estatusUUIDs value for this RespuestaCancelacion.
     * 
     * @return estatusUUIDs
     */
    public java.lang.String[] getEstatusUUIDs() {
        return estatusUUIDs;
    }


    /**
     * Sets the estatusUUIDs value for this RespuestaCancelacion.
     * 
     * @param estatusUUIDs
     */
    public void setEstatusUUIDs(java.lang.String[] estatusUUIDs) {
        this.estatusUUIDs = estatusUUIDs;
    }

    public java.lang.String getEstatusUUIDs(int i) {
        return this.estatusUUIDs[i];
    }

    public void setEstatusUUIDs(int i, java.lang.String _value) {
        this.estatusUUIDs[i] = _value;
    }


    /**
     * Gets the uuids value for this RespuestaCancelacion.
     * 
     * @return uuids
     */
    public java.lang.String[] getUuids() {
        return uuids;
    }


    /**
     * Sets the uuids value for this RespuestaCancelacion.
     * 
     * @param uuids
     */
    public void setUuids(java.lang.String[] uuids) {
        this.uuids = uuids;
    }

    public java.lang.String getUuids(int i) {
        return this.uuids[i];
    }

    public void setUuids(int i, java.lang.String _value) {
        this.uuids[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaCancelacion)) return false;
        RespuestaCancelacion other = (RespuestaCancelacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acuse==null && other.getAcuse()==null) || 
             (this.acuse!=null &&
              this.acuse.equals(other.getAcuse()))) &&
            ((this.codEstatus==null && other.getCodEstatus()==null) || 
             (this.codEstatus!=null &&
              this.codEstatus.equals(other.getCodEstatus()))) &&
            ((this.codMensaje==null && other.getCodMensaje()==null) || 
             (this.codMensaje!=null &&
              this.codMensaje.equals(other.getCodMensaje()))) &&
            ((this.estatusUUIDs==null && other.getEstatusUUIDs()==null) || 
             (this.estatusUUIDs!=null &&
              java.util.Arrays.equals(this.estatusUUIDs, other.getEstatusUUIDs()))) &&
            ((this.uuids==null && other.getUuids()==null) || 
             (this.uuids!=null &&
              java.util.Arrays.equals(this.uuids, other.getUuids())));
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
        if (getAcuse() != null) {
            _hashCode += getAcuse().hashCode();
        }
        if (getCodEstatus() != null) {
            _hashCode += getCodEstatus().hashCode();
        }
        if (getCodMensaje() != null) {
            _hashCode += getCodMensaje().hashCode();
        }
        if (getEstatusUUIDs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEstatusUUIDs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEstatusUUIDs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getUuids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUuids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUuids(), i);
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
        new org.apache.axis.description.TypeDesc(RespuestaCancelacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.xpd.mx/", "respuestaCancelacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acuse");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acuse"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codEstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codEstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codMensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codMensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatusUUIDs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatusUUIDs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uuids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
