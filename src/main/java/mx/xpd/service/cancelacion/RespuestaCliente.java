/**
 * RespuestaCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.xpd.service.cancelacion;

public class RespuestaCliente  implements java.io.Serializable {
    private java.lang.String codigo;

    private java.lang.String mensaje;

    private java.lang.String responseCancelar;

    private java.lang.String responseConsulta;

    private java.lang.String responseRelacionados;

    private java.lang.String idTransaccion;

    private byte[] pdf;

    private mx.xpd.service.cancelacion.XmlRelacionado[] xmlRelacionados;

    public RespuestaCliente() {
    }

    public RespuestaCliente(
           java.lang.String codigo,
           java.lang.String mensaje,
           java.lang.String responseCancelar,
           java.lang.String responseConsulta,
           java.lang.String responseRelacionados,
           java.lang.String idTransaccion,
           byte[] pdf,
           mx.xpd.service.cancelacion.XmlRelacionado[] xmlRelacionados) {
           this.codigo = codigo;
           this.mensaje = mensaje;
           this.responseCancelar = responseCancelar;
           this.responseConsulta = responseConsulta;
           this.responseRelacionados = responseRelacionados;
           this.idTransaccion = idTransaccion;
           this.pdf = pdf;
           this.xmlRelacionados = xmlRelacionados;
    }


    /**
     * Gets the codigo value for this RespuestaCliente.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this RespuestaCliente.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the mensaje value for this RespuestaCliente.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this RespuestaCliente.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the responseCancelar value for this RespuestaCliente.
     * 
     * @return responseCancelar
     */
    public java.lang.String getResponseCancelar() {
        return responseCancelar;
    }


    /**
     * Sets the responseCancelar value for this RespuestaCliente.
     * 
     * @param responseCancelar
     */
    public void setResponseCancelar(java.lang.String responseCancelar) {
        this.responseCancelar = responseCancelar;
    }


    /**
     * Gets the responseConsulta value for this RespuestaCliente.
     * 
     * @return responseConsulta
     */
    public java.lang.String getResponseConsulta() {
        return responseConsulta;
    }


    /**
     * Sets the responseConsulta value for this RespuestaCliente.
     * 
     * @param responseConsulta
     */
    public void setResponseConsulta(java.lang.String responseConsulta) {
        this.responseConsulta = responseConsulta;
    }


    /**
     * Gets the responseRelacionados value for this RespuestaCliente.
     * 
     * @return responseRelacionados
     */
    public java.lang.String getResponseRelacionados() {
        return responseRelacionados;
    }


    /**
     * Sets the responseRelacionados value for this RespuestaCliente.
     * 
     * @param responseRelacionados
     */
    public void setResponseRelacionados(java.lang.String responseRelacionados) {
        this.responseRelacionados = responseRelacionados;
    }


    /**
     * Gets the idTransaccion value for this RespuestaCliente.
     * 
     * @return idTransaccion
     */
    public java.lang.String getIdTransaccion() {
        return idTransaccion;
    }


    /**
     * Sets the idTransaccion value for this RespuestaCliente.
     * 
     * @param idTransaccion
     */
    public void setIdTransaccion(java.lang.String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }


    /**
     * Gets the pdf value for this RespuestaCliente.
     * 
     * @return pdf
     */
    public byte[] getPdf() {
        return pdf;
    }


    /**
     * Sets the pdf value for this RespuestaCliente.
     * 
     * @param pdf
     */
    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }


    /**
     * Gets the xmlRelacionados value for this RespuestaCliente.
     * 
     * @return xmlRelacionados
     */
    public mx.xpd.service.cancelacion.XmlRelacionado[] getXmlRelacionados() {
        return xmlRelacionados;
    }


    /**
     * Sets the xmlRelacionados value for this RespuestaCliente.
     * 
     * @param xmlRelacionados
     */
    public void setXmlRelacionados(mx.xpd.service.cancelacion.XmlRelacionado[] xmlRelacionados) {
        this.xmlRelacionados = xmlRelacionados;
    }

    public mx.xpd.service.cancelacion.XmlRelacionado getXmlRelacionados(int i) {
        return this.xmlRelacionados[i];
    }

    public void setXmlRelacionados(int i, mx.xpd.service.cancelacion.XmlRelacionado _value) {
        this.xmlRelacionados[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaCliente)) return false;
        RespuestaCliente other = (RespuestaCliente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.responseCancelar==null && other.getResponseCancelar()==null) || 
             (this.responseCancelar!=null &&
              this.responseCancelar.equals(other.getResponseCancelar()))) &&
            ((this.responseConsulta==null && other.getResponseConsulta()==null) || 
             (this.responseConsulta!=null &&
              this.responseConsulta.equals(other.getResponseConsulta()))) &&
            ((this.responseRelacionados==null && other.getResponseRelacionados()==null) || 
             (this.responseRelacionados!=null &&
              this.responseRelacionados.equals(other.getResponseRelacionados()))) &&
            ((this.idTransaccion==null && other.getIdTransaccion()==null) || 
             (this.idTransaccion!=null &&
              this.idTransaccion.equals(other.getIdTransaccion()))) &&
            ((this.pdf==null && other.getPdf()==null) || 
             (this.pdf!=null &&
              java.util.Arrays.equals(this.pdf, other.getPdf()))) &&
            ((this.xmlRelacionados==null && other.getXmlRelacionados()==null) || 
             (this.xmlRelacionados!=null &&
              java.util.Arrays.equals(this.xmlRelacionados, other.getXmlRelacionados())));
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getResponseCancelar() != null) {
            _hashCode += getResponseCancelar().hashCode();
        }
        if (getResponseConsulta() != null) {
            _hashCode += getResponseConsulta().hashCode();
        }
        if (getResponseRelacionados() != null) {
            _hashCode += getResponseRelacionados().hashCode();
        }
        if (getIdTransaccion() != null) {
            _hashCode += getIdTransaccion().hashCode();
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
        if (getXmlRelacionados() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getXmlRelacionados());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getXmlRelacionados(), i);
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
        new org.apache.axis.description.TypeDesc(RespuestaCliente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://concretepage.com/soap", "respuestaCliente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCancelar");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "responseCancelar"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "responseConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseRelacionados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "responseRelacionados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTransaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "idTransaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pdf");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "pdf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "hexBinary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("xmlRelacionados");
        elemField.setXmlName(new javax.xml.namespace.QName("http://concretepage.com/soap", "xmlRelacionados"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://concretepage.com/soap", "xmlRelacionado"));
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
