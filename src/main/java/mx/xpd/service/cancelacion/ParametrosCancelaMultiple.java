/**
 * ParametrosCancelaMultiple.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service.cancelacion;

public class ParametrosCancelaMultiple  implements java.io.Serializable {
    private java.lang.String noCertificado;

    private java.lang.String rfcEmisor;

    private java.lang.String rfcReceptor;

    private java.lang.String total;

    private java.lang.String uuid;

    private java.lang.String xmlB64;

    public ParametrosCancelaMultiple() {
    }

    public ParametrosCancelaMultiple(
           java.lang.String noCertificado,
           java.lang.String rfcEmisor,
           java.lang.String rfcReceptor,
           java.lang.String total,
           java.lang.String uuid,
           java.lang.String xmlB64) {
           this.noCertificado = noCertificado;
           this.rfcEmisor = rfcEmisor;
           this.rfcReceptor = rfcReceptor;
           this.total = total;
           this.uuid = uuid;
           this.xmlB64 = xmlB64;
    }


    /**
     * Gets the noCertificado value for this ParametrosCancelaMultiple.
     * 
     * @return noCertificado
     */
    public java.lang.String getNoCertificado() {
        return noCertificado;
    }


    /**
     * Sets the noCertificado value for this ParametrosCancelaMultiple.
     * 
     * @param noCertificado
     */
    public void setNoCertificado(java.lang.String noCertificado) {
        this.noCertificado = noCertificado;
    }


    /**
     * Gets the rfcEmisor value for this ParametrosCancelaMultiple.
     * 
     * @return rfcEmisor
     */
    public java.lang.String getRfcEmisor() {
        return rfcEmisor;
    }


    /**
     * Sets the rfcEmisor value for this ParametrosCancelaMultiple.
     * 
     * @param rfcEmisor
     */
    public void setRfcEmisor(java.lang.String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }


    /**
     * Gets the rfcReceptor value for this ParametrosCancelaMultiple.
     * 
     * @return rfcReceptor
     */
    public java.lang.String getRfcReceptor() {
        return rfcReceptor;
    }


    /**
     * Sets the rfcReceptor value for this ParametrosCancelaMultiple.
     * 
     * @param rfcReceptor
     */
    public void setRfcReceptor(java.lang.String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }


    /**
     * Gets the total value for this ParametrosCancelaMultiple.
     * 
     * @return total
     */
    public java.lang.String getTotal() {
        return total;
    }


    /**
     * Sets the total value for this ParametrosCancelaMultiple.
     * 
     * @param total
     */
    public void setTotal(java.lang.String total) {
        this.total = total;
    }


    /**
     * Gets the uuid value for this ParametrosCancelaMultiple.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this ParametrosCancelaMultiple.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }


    /**
     * Gets the xmlB64 value for this ParametrosCancelaMultiple.
     * 
     * @return xmlB64
     */
    public java.lang.String getXmlB64() {
        return xmlB64;
    }


    /**
     * Sets the xmlB64 value for this ParametrosCancelaMultiple.
     * 
     * @param xmlB64
     */
    public void setXmlB64(java.lang.String xmlB64) {
        this.xmlB64 = xmlB64;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ParametrosCancelaMultiple)) return false;
        ParametrosCancelaMultiple other = (ParametrosCancelaMultiple) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.noCertificado==null && other.getNoCertificado()==null) || 
             (this.noCertificado!=null &&
              this.noCertificado.equals(other.getNoCertificado()))) &&
            ((this.rfcEmisor==null && other.getRfcEmisor()==null) || 
             (this.rfcEmisor!=null &&
              this.rfcEmisor.equals(other.getRfcEmisor()))) &&
            ((this.rfcReceptor==null && other.getRfcReceptor()==null) || 
             (this.rfcReceptor!=null &&
              this.rfcReceptor.equals(other.getRfcReceptor()))) &&
            ((this.total==null && other.getTotal()==null) || 
             (this.total!=null &&
              this.total.equals(other.getTotal()))) &&
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid()))) &&
            ((this.xmlB64==null && other.getXmlB64()==null) || 
             (this.xmlB64!=null &&
              this.xmlB64.equals(other.getXmlB64())));
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
        if (getNoCertificado() != null) {
            _hashCode += getNoCertificado().hashCode();
        }
        if (getRfcEmisor() != null) {
            _hashCode += getRfcEmisor().hashCode();
        }
        if (getRfcReceptor() != null) {
            _hashCode += getRfcReceptor().hashCode();
        }
        if (getTotal() != null) {
            _hashCode += getTotal().hashCode();
        }
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        if (getXmlB64() != null) {
            _hashCode += getXmlB64().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ParametrosCancelaMultiple.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://concretepage.com/soap", "parametrosCancelaMultiple"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noCertificado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "noCertificado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcEmisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "rfcEmisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcReceptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "rfcReceptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "total"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlB64");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "xmlB64"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
