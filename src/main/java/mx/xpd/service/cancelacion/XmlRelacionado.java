/**
 * XmlRelacionado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service.cancelacion;

public class XmlRelacionado  implements java.io.Serializable {
    private java.lang.String xml;

    private java.lang.String uuid;

    private java.lang.String emisor;

    private java.lang.String receptor;

    private java.lang.String tipo;

    private byte[] pdf;

    public XmlRelacionado() {
    }

    public XmlRelacionado(
           java.lang.String xml,
           java.lang.String uuid,
           java.lang.String emisor,
           java.lang.String receptor,
           java.lang.String tipo,
           byte[] pdf) {
           this.xml = xml;
           this.uuid = uuid;
           this.emisor = emisor;
           this.receptor = receptor;
           this.tipo = tipo;
           this.pdf = pdf;
    }


    /**
     * Gets the xml value for this XmlRelacionado.
     * 
     * @return xml
     */
    public java.lang.String getXml() {
        return xml;
    }


    /**
     * Sets the xml value for this XmlRelacionado.
     * 
     * @param xml
     */
    public void setXml(java.lang.String xml) {
        this.xml = xml;
    }


    /**
     * Gets the uuid value for this XmlRelacionado.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this XmlRelacionado.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }


    /**
     * Gets the emisor value for this XmlRelacionado.
     * 
     * @return emisor
     */
    public java.lang.String getEmisor() {
        return emisor;
    }


    /**
     * Sets the emisor value for this XmlRelacionado.
     * 
     * @param emisor
     */
    public void setEmisor(java.lang.String emisor) {
        this.emisor = emisor;
    }


    /**
     * Gets the receptor value for this XmlRelacionado.
     * 
     * @return receptor
     */
    public java.lang.String getReceptor() {
        return receptor;
    }


    /**
     * Sets the receptor value for this XmlRelacionado.
     * 
     * @param receptor
     */
    public void setReceptor(java.lang.String receptor) {
        this.receptor = receptor;
    }


    /**
     * Gets the tipo value for this XmlRelacionado.
     * 
     * @return tipo
     */
    public java.lang.String getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this XmlRelacionado.
     * 
     * @param tipo
     */
    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }


    /**
     * Gets the pdf value for this XmlRelacionado.
     * 
     * @return pdf
     */
    public byte[] getPdf() {
        return pdf;
    }


    /**
     * Sets the pdf value for this XmlRelacionado.
     * 
     * @param pdf
     */
    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof XmlRelacionado)) return false;
        XmlRelacionado other = (XmlRelacionado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.xml==null && other.getXml()==null) || 
             (this.xml!=null &&
              this.xml.equals(other.getXml()))) &&
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid()))) &&
            ((this.emisor==null && other.getEmisor()==null) || 
             (this.emisor!=null &&
              this.emisor.equals(other.getEmisor()))) &&
            ((this.receptor==null && other.getReceptor()==null) || 
             (this.receptor!=null &&
              this.receptor.equals(other.getReceptor()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo()))) &&
            ((this.pdf==null && other.getPdf()==null) || 
             (this.pdf!=null &&
              java.util.Arrays.equals(this.pdf, other.getPdf())));
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
        if (getXml() != null) {
            _hashCode += getXml().hashCode();
        }
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        if (getEmisor() != null) {
            _hashCode += getEmisor().hashCode();
        }
        if (getReceptor() != null) {
            _hashCode += getReceptor().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        if (getPdf() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPdf());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPdf(), i);
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
        new org.apache.axis.description.TypeDesc(XmlRelacionado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://concretepage.com/soap", "xmlRelacionado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xml");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "xml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emisor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "emisor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receptor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "receptor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "pdf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
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
