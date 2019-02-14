package mx.xpd.cfdi.domain.cfdi.pdf.complementos.detallista;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestForPaymentIdentification",
    "specialInstruction",
    "orderIdentification",
    "additionalInformation",
    "deliveryNote",
    "buyer",
    "seller",
    "shipTo",
    "invoiceCreator",
    "customs",
    "currency",
    "paymentTerms",
    "shipmentDetail",
    "allowanceCharge",
    "lineItem",
    "totalAmount",
    "totalAllowanceCharge"
})
@XmlRootElement(name = "detallista")
public class Detallista {

    @XmlElement(required = true)
    protected Detallista.RequestForPaymentIdentification requestForPaymentIdentification;
    protected List<Detallista.SpecialInstruction> specialInstruction;
    @XmlElement(required = true)
    protected Detallista.OrderIdentification orderIdentification;
    @XmlElement(name = "AdditionalInformation", required = true)
    protected Detallista.AdditionalInformation additionalInformation;
    @XmlElement(name = "DeliveryNote")
    protected Detallista.DeliveryNote deliveryNote;
    @XmlElement(required = true)
    protected Detallista.Buyer buyer;
    protected Detallista.Seller seller;
    protected Detallista.ShipTo shipTo;
    @XmlElement(name = "InvoiceCreator")
    protected Detallista.InvoiceCreator invoiceCreator;
    @XmlElement(name = "Customs")
    protected List<Detallista.Customs> customs;
    protected List<Detallista.Currency> currency;
    protected Detallista.PaymentTerms paymentTerms;
    protected Detallista.ShipmentDetail shipmentDetail;
    protected List<Detallista.AllowanceCharge> allowanceCharge;
    protected List<Detallista.LineItem> lineItem;
    protected Detallista.TotalAmount totalAmount;
    @XmlElement(name = "TotalAllowanceCharge")
    protected List<Detallista.TotalAllowanceCharge> totalAllowanceCharge;
    @XmlAttribute
    protected String type;
    @XmlAttribute
    protected String contentVersion;
    @XmlAttribute(required = true)
    protected String documentStructureVersion;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String documentStatus;

    /**
     * Gets the value of the requestForPaymentIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.RequestForPaymentIdentification }
     *     
     */
    public Detallista.RequestForPaymentIdentification getRequestForPaymentIdentification() {
        return requestForPaymentIdentification;
    }

    /**
     * Sets the value of the requestForPaymentIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.RequestForPaymentIdentification }
     *     
     */
    public void setRequestForPaymentIdentification(Detallista.RequestForPaymentIdentification value) {
        this.requestForPaymentIdentification = value;
    }

    /**
     * Gets the value of the specialInstruction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specialInstruction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecialInstruction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Detallista.SpecialInstruction }
     * 
     * 
     */
    public List<Detallista.SpecialInstruction> getSpecialInstruction() {
        if (specialInstruction == null) {
            specialInstruction = new ArrayList<Detallista.SpecialInstruction>();
        }
        return this.specialInstruction;
    }

    /**
     * Gets the value of the orderIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.OrderIdentification }
     *     
     */
    public Detallista.OrderIdentification getOrderIdentification() {
        return orderIdentification;
    }

    /**
     * Sets the value of the orderIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.OrderIdentification }
     *     
     */
    public void setOrderIdentification(Detallista.OrderIdentification value) {
        this.orderIdentification = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.AdditionalInformation }
     *     
     */
    public Detallista.AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.AdditionalInformation }
     *     
     */
    public void setAdditionalInformation(Detallista.AdditionalInformation value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the deliveryNote property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.DeliveryNote }
     *     
     */
    public Detallista.DeliveryNote getDeliveryNote() {
        return deliveryNote;
    }

    /**
     * Sets the value of the deliveryNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.DeliveryNote }
     *     
     */
    public void setDeliveryNote(Detallista.DeliveryNote value) {
        this.deliveryNote = value;
    }

    /**
     * Gets the value of the buyer property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.Buyer }
     *     
     */
    public Detallista.Buyer getBuyer() {
        return buyer;
    }

    /**
     * Sets the value of the buyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.Buyer }
     *     
     */
    public void setBuyer(Detallista.Buyer value) {
        this.buyer = value;
    }

    /**
     * Gets the value of the seller property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.Seller }
     *     
     */
    public Detallista.Seller getSeller() {
        return seller;
    }

    /**
     * Sets the value of the seller property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.Seller }
     *     
     */
    public void setSeller(Detallista.Seller value) {
        this.seller = value;
    }

    /**
     * Gets the value of the shipTo property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.ShipTo }
     *     
     */
    public Detallista.ShipTo getShipTo() {
        return shipTo;
    }

    /**
     * Sets the value of the shipTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.ShipTo }
     *     
     */
    public void setShipTo(Detallista.ShipTo value) {
        this.shipTo = value;
    }

    /**
     * Gets the value of the invoiceCreator property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.InvoiceCreator }
     *     
     */
    public Detallista.InvoiceCreator getInvoiceCreator() {
        return invoiceCreator;
    }

    /**
     * Sets the value of the invoiceCreator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.InvoiceCreator }
     *     
     */
    public void setInvoiceCreator(Detallista.InvoiceCreator value) {
        this.invoiceCreator = value;
    }

    /**
     * Gets the value of the customs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustoms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Detallista.Customs }
     * 
     * 
     */
    public List<Detallista.Customs> getCustoms() {
        if (customs == null) {
            customs = new ArrayList<Detallista.Customs>();
        }
        return this.customs;
    }

    /**
     * Gets the value of the currency property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currency property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrency().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Detallista.Currency }
     * 
     * 
     */
    public List<Detallista.Currency> getCurrency() {
        if (currency == null) {
            currency = new ArrayList<Detallista.Currency>();
        }
        return this.currency;
    }

    /**
     * Gets the value of the paymentTerms property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.PaymentTerms }
     *     
     */
    public Detallista.PaymentTerms getPaymentTerms() {
        return paymentTerms;
    }

    /**
     * Sets the value of the paymentTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.PaymentTerms }
     *     
     */
    public void setPaymentTerms(Detallista.PaymentTerms value) {
        this.paymentTerms = value;
    }

    /**
     * Gets the value of the shipmentDetail property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.ShipmentDetail }
     *     
     */
    public Detallista.ShipmentDetail getShipmentDetail() {
        return shipmentDetail;
    }

    /**
     * Sets the value of the shipmentDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.ShipmentDetail }
     *     
     */
    public void setShipmentDetail(Detallista.ShipmentDetail value) {
        this.shipmentDetail = value;
    }

    /**
     * Gets the value of the allowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Detallista.AllowanceCharge }
     * 
     * 
     */
    public List<Detallista.AllowanceCharge> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<Detallista.AllowanceCharge>();
        }
        return this.allowanceCharge;
    }

    /**
     * Gets the value of the lineItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Detallista.LineItem }
     * 
     * 
     */
    public List<Detallista.LineItem> getLineItem() {
        if (lineItem == null) {
            lineItem = new ArrayList<Detallista.LineItem>();
        }
        return this.lineItem;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Detallista.TotalAmount }
     *     
     */
    public Detallista.TotalAmount getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Detallista.TotalAmount }
     *     
     */
    public void setTotalAmount(Detallista.TotalAmount value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the totalAllowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalAllowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Detallista.TotalAllowanceCharge }
     * 
     * 
     */
    public List<Detallista.TotalAllowanceCharge> getTotalAllowanceCharge() {
        if (totalAllowanceCharge == null) {
            totalAllowanceCharge = new ArrayList<Detallista.TotalAllowanceCharge>();
        }
        return this.totalAllowanceCharge;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "SimpleInvoiceType";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the contentVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentVersion() {
        if (contentVersion == null) {
            return "1.3.1";
        } else {
            return contentVersion;
        }
    }

    /**
     * Sets the value of the contentVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentVersion(String value) {
        this.contentVersion = value;
    }

    /**
     * Gets the value of the documentStructureVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentStructureVersion() {
        if (documentStructureVersion == null) {
            return "AMC8.1";
        } else {
            return documentStructureVersion;
        }
    }

    /**
     * Sets the value of the documentStructureVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentStructureVersion(String value) {
        this.documentStructureVersion = value;
    }

    /**
     * Gets the value of the documentStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentStatus() {
        return documentStatus;
    }

    /**
     * Sets the value of the documentStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentStatus(String value) {
        this.documentStatus = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="referenceIdentification" maxOccurs="99">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="type" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;enumeration value="AAE"/>
     *                       &lt;enumeration value="CK"/>
     *                       &lt;enumeration value="ACE"/>
     *                       &lt;enumeration value="ATZ"/>
     *                       &lt;enumeration value="DQ"/>
     *                       &lt;enumeration value="IV"/>
     *                       &lt;enumeration value="ON"/>
     *                       &lt;enumeration value="AWR"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "referenceIdentification"
    })
    public static class AdditionalInformation {

        @XmlElement(required = true)
        protected List<Detallista.AdditionalInformation.ReferenceIdentification> referenceIdentification;

        /**
         * Gets the value of the referenceIdentification property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the referenceIdentification property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReferenceIdentification().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detallista.AdditionalInformation.ReferenceIdentification }
         * 
         * 
         */
        public List<Detallista.AdditionalInformation.ReferenceIdentification> getReferenceIdentification() {
            if (referenceIdentification == null) {
                referenceIdentification = new ArrayList<Detallista.AdditionalInformation.ReferenceIdentification>();
            }
            return this.referenceIdentification;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="type" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;enumeration value="AAE"/>
         *             &lt;enumeration value="CK"/>
         *             &lt;enumeration value="ACE"/>
         *             &lt;enumeration value="ATZ"/>
         *             &lt;enumeration value="DQ"/>
         *             &lt;enumeration value="IV"/>
         *             &lt;enumeration value="ON"/>
         *             &lt;enumeration value="AWR"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class ReferenceIdentification {

            @XmlValue
            protected String value;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="specialServicesType" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="3"/>
     *               &lt;enumeration value="AA"/>
     *               &lt;enumeration value="AJ"/>
     *               &lt;enumeration value="ADO"/>
     *               &lt;enumeration value="ADT"/>
     *               &lt;enumeration value="ADS"/>
     *               &lt;enumeration value="ABZ"/>
     *               &lt;enumeration value="DA"/>
     *               &lt;enumeration value="EAA"/>
     *               &lt;enumeration value="EAB"/>
     *               &lt;enumeration value="PI"/>
     *               &lt;enumeration value="TAE"/>
     *               &lt;enumeration value="SAB"/>
     *               &lt;enumeration value="RAA"/>
     *               &lt;enumeration value="PAD"/>
     *               &lt;enumeration value="FG"/>
     *               &lt;enumeration value="FA"/>
     *               &lt;enumeration value="TD"/>
     *               &lt;enumeration value="TS"/>
     *               &lt;enumeration value="TX"/>
     *               &lt;enumeration value="TZ"/>
     *               &lt;enumeration value="ZZZ"/>
     *               &lt;enumeration value="VAB"/>
     *               &lt;enumeration value="UM"/>
     *               &lt;enumeration value="DI"/>
     *               &lt;enumeration value="CAC"/>
     *               &lt;enumeration value="COD"/>
     *               &lt;enumeration value="EAB"/>
     *               &lt;enumeration value="FC"/>
     *               &lt;enumeration value="FI"/>
     *               &lt;enumeration value="HD"/>
     *               &lt;enumeration value="QD"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="monetaryAmountOrPercentage" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="rate" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="base" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                                 &lt;length value="13"/>
     *                                 &lt;enumeration value="INVOICE_VALUE"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="allowanceChargeType" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="16"/>
     *             &lt;enumeration value="ALLOWANCE_GLOBAL"/>
     *             &lt;enumeration value="CHARGE_GLOBAL"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="settlementType" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="11"/>
     *             &lt;enumeration value="BILL_BACK"/>
     *             &lt;enumeration value="OFF_INVOICE"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="sequenceNumber">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="15"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "specialServicesType",
        "monetaryAmountOrPercentage"
    })
    public static class AllowanceCharge {

        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String specialServicesType;
        protected Detallista.AllowanceCharge.MonetaryAmountOrPercentage monetaryAmountOrPercentage;
        @XmlAttribute(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String allowanceChargeType;
        @XmlAttribute(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String settlementType;
        @XmlAttribute
        protected String sequenceNumber;

        /**
         * Gets the value of the specialServicesType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSpecialServicesType() {
            return specialServicesType;
        }

        /**
         * Sets the value of the specialServicesType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSpecialServicesType(String value) {
            this.specialServicesType = value;
        }

        /**
         * Gets the value of the monetaryAmountOrPercentage property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.AllowanceCharge.MonetaryAmountOrPercentage }
         *     
         */
        public Detallista.AllowanceCharge.MonetaryAmountOrPercentage getMonetaryAmountOrPercentage() {
            return monetaryAmountOrPercentage;
        }

        /**
         * Sets the value of the monetaryAmountOrPercentage property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.AllowanceCharge.MonetaryAmountOrPercentage }
         *     
         */
        public void setMonetaryAmountOrPercentage(Detallista.AllowanceCharge.MonetaryAmountOrPercentage value) {
            this.monetaryAmountOrPercentage = value;
        }

        /**
         * Gets the value of the allowanceChargeType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAllowanceChargeType() {
            return allowanceChargeType;
        }

        /**
         * Sets the value of the allowanceChargeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAllowanceChargeType(String value) {
            this.allowanceChargeType = value;
        }

        /**
         * Gets the value of the settlementType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSettlementType() {
            return settlementType;
        }

        /**
         * Sets the value of the settlementType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSettlementType(String value) {
            this.settlementType = value;
        }

        /**
         * Gets the value of the sequenceNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSequenceNumber() {
            return sequenceNumber;
        }

        /**
         * Sets the value of the sequenceNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSequenceNumber(String value) {
            this.sequenceNumber = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="rate" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="base" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *                       &lt;length value="13"/>
         *                       &lt;enumeration value="INVOICE_VALUE"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rate"
        })
        public static class MonetaryAmountOrPercentage {

            protected Detallista.AllowanceCharge.MonetaryAmountOrPercentage.Rate rate;

            /**
             * Gets the value of the rate property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.AllowanceCharge.MonetaryAmountOrPercentage.Rate }
             *     
             */
            public Detallista.AllowanceCharge.MonetaryAmountOrPercentage.Rate getRate() {
                return rate;
            }

            /**
             * Sets the value of the rate property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.AllowanceCharge.MonetaryAmountOrPercentage.Rate }
             *     
             */
            public void setRate(Detallista.AllowanceCharge.MonetaryAmountOrPercentage.Rate value) {
                this.rate = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *       &lt;/sequence>
             *       &lt;attribute name="base" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
             *             &lt;length value="13"/>
             *             &lt;enumeration value="INVOICE_VALUE"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "percentage"
            })
            public static class Rate {

                @XmlElement(required = true)
                protected BigDecimal percentage;
                @XmlAttribute(required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                protected String base;

                /**
                 * Gets the value of the percentage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getPercentage() {
                    return percentage;
                }

                /**
                 * Sets the value of the percentage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setPercentage(BigDecimal value) {
                    this.percentage = value;
                }

                /**
                 * Gets the value of the base property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBase() {
                    return base;
                }

                /**
                 * Sets the value of the base property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBase(String value) {
                    this.base = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="gln">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="13"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="contactInformation" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="personOrDepartmentName">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="text">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;minLength value="1"/>
     *                                   &lt;maxLength value="35"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "gln",
        "contactInformation"
    })
    public static class Buyer {

        @XmlElement(required = true)
        protected String gln;
        protected Detallista.Buyer.ContactInformation contactInformation;

        /**
         * Gets the value of the gln property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGln() {
            return gln;
        }

        /**
         * Sets the value of the gln property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGln(String value) {
            this.gln = value;
        }

        /**
         * Gets the value of the contactInformation property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.Buyer.ContactInformation }
         *     
         */
        public Detallista.Buyer.ContactInformation getContactInformation() {
            return contactInformation;
        }

        /**
         * Sets the value of the contactInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.Buyer.ContactInformation }
         *     
         */
        public void setContactInformation(Detallista.Buyer.ContactInformation value) {
            this.contactInformation = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="personOrDepartmentName">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="text">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;minLength value="1"/>
         *                         &lt;maxLength value="35"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "personOrDepartmentName"
        })
        public static class ContactInformation {

            @XmlElement(required = true)
            protected Detallista.Buyer.ContactInformation.PersonOrDepartmentName personOrDepartmentName;

            /**
             * Gets the value of the personOrDepartmentName property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.Buyer.ContactInformation.PersonOrDepartmentName }
             *     
             */
            public Detallista.Buyer.ContactInformation.PersonOrDepartmentName getPersonOrDepartmentName() {
                return personOrDepartmentName;
            }

            /**
             * Sets the value of the personOrDepartmentName property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.Buyer.ContactInformation.PersonOrDepartmentName }
             *     
             */
            public void setPersonOrDepartmentName(Detallista.Buyer.ContactInformation.PersonOrDepartmentName value) {
                this.personOrDepartmentName = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="text">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;minLength value="1"/>
             *               &lt;maxLength value="35"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "text"
            })
            public static class PersonOrDepartmentName {

                @XmlElement(required = true)
                protected String text;

                /**
                 * Gets the value of the text property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getText() {
                    return text;
                }

                /**
                 * Sets the value of the text property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setText(String value) {
                    this.text = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="currencyFunction" maxOccurs="3">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *               &lt;maxLength value="16"/>
     *               &lt;minLength value="1"/>
     *               &lt;enumeration value="BILLING_CURRENCY"/>
     *               &lt;enumeration value="PRICE_CURRENCY"/>
     *               &lt;enumeration value="PAYMENT_CURRENCY"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="rateOfChange" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="currencyISOCode" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;length value="3"/>
     *             &lt;enumeration value="MXN"/>
     *             &lt;enumeration value="XEU"/>
     *             &lt;enumeration value="USD"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "currencyFunction",
        "rateOfChange"
    })
    public static class Currency {

        @XmlElement(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected List<String> currencyFunction;
        protected BigDecimal rateOfChange;
        @XmlAttribute(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String currencyISOCode;

        /**
         * Gets the value of the currencyFunction property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the currencyFunction property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCurrencyFunction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCurrencyFunction() {
            if (currencyFunction == null) {
                currencyFunction = new ArrayList<String>();
            }
            return this.currencyFunction;
        }

        /**
         * Gets the value of the rateOfChange property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getRateOfChange() {
            return rateOfChange;
        }

        /**
         * Sets the value of the rateOfChange property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setRateOfChange(BigDecimal value) {
            this.rateOfChange = value;
        }

        /**
         * Gets the value of the currencyISOCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrencyISOCode() {
            return currencyISOCode;
        }

        /**
         * Sets the value of the currencyISOCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrencyISOCode(String value) {
            this.currencyISOCode = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="gln" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="13"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "gln"
    })
    public static class Customs {

        protected String gln;

        /**
         * Gets the value of the gln property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGln() {
            return gln;
        }

        /**
         * Sets the value of the gln property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGln(String value) {
            this.gln = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="referenceIdentification" maxOccurs="30">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="35"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ReferenceDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "referenceIdentification",
        "referenceDate"
    })
    public static class DeliveryNote {

        @XmlElement(required = true)
        protected List<String> referenceIdentification;
        @XmlElement(name = "ReferenceDate")
        protected String referenceDate;

        /**
         * Gets the value of the referenceIdentification property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the referenceIdentification property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReferenceIdentification().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getReferenceIdentification() {
            if (referenceIdentification == null) {
                referenceIdentification = new ArrayList<String>();
            }
            return this.referenceIdentification;
        }

        /**
         * Gets the value of the referenceDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public String getReferenceDate() {
            return referenceDate;
        }

        /**
         * Sets the value of the referenceDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setReferenceDate(String value) {
            this.referenceDate = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="gln" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="13"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="alternatePartyIdentification" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="type" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;length value="2"/>
     *                       &lt;enumeration value="VA"/>
     *                       &lt;enumeration value="IA"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="nameAndAddress" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="name" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="streetAddressOne" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="city" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="postalCode" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="9"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "gln",
        "alternatePartyIdentification",
        "nameAndAddress"
    })
    public static class InvoiceCreator {

        protected String gln;
        protected Detallista.InvoiceCreator.AlternatePartyIdentification alternatePartyIdentification;
        protected Detallista.InvoiceCreator.NameAndAddress nameAndAddress;

        /**
         * Gets the value of the gln property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGln() {
            return gln;
        }

        /**
         * Sets the value of the gln property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGln(String value) {
            this.gln = value;
        }

        /**
         * Gets the value of the alternatePartyIdentification property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.InvoiceCreator.AlternatePartyIdentification }
         *     
         */
        public Detallista.InvoiceCreator.AlternatePartyIdentification getAlternatePartyIdentification() {
            return alternatePartyIdentification;
        }

        /**
         * Sets the value of the alternatePartyIdentification property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.InvoiceCreator.AlternatePartyIdentification }
         *     
         */
        public void setAlternatePartyIdentification(Detallista.InvoiceCreator.AlternatePartyIdentification value) {
            this.alternatePartyIdentification = value;
        }

        /**
         * Gets the value of the nameAndAddress property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.InvoiceCreator.NameAndAddress }
         *     
         */
        public Detallista.InvoiceCreator.NameAndAddress getNameAndAddress() {
            return nameAndAddress;
        }

        /**
         * Sets the value of the nameAndAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.InvoiceCreator.NameAndAddress }
         *     
         */
        public void setNameAndAddress(Detallista.InvoiceCreator.NameAndAddress value) {
            this.nameAndAddress = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="type" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;length value="2"/>
         *             &lt;enumeration value="VA"/>
         *             &lt;enumeration value="IA"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class AlternatePartyIdentification {

            @XmlValue
            protected String value;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="name" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="streetAddressOne" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="city" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="postalCode" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="9"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
/*
        @XmlType(name = "", propOrder = {
            "name",
            "streetAddressOne",
            "city",
            "postalCode"
        })
*/        
        public static class NameAndAddress {

            protected String name;
            protected String streetAddressOne;
            protected String city;
            protected String postalCode;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the streetAddressOne property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStreetAddressOne() {
                return streetAddressOne;
            }

            /**
             * Sets the value of the streetAddressOne property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStreetAddressOne(String value) {
                this.streetAddressOne = value;
            }

            /**
             * Gets the value of the city property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCity() {
                return city;
            }

            /**
             * Sets the value of the city property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCity(String value) {
                this.city = value;
            }

            /**
             * Gets the value of the postalCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPostalCode() {
                return postalCode;
            }

            /**
             * Sets the value of the postalCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPostalCode(String value) {
                this.postalCode = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="tradeItemIdentification">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="gtin">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="14"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="alternateTradeItemIdentification" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="type" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="35"/>
     *                       &lt;enumeration value="BUYER_ASSIGNED"/>
     *                       &lt;enumeration value="SUPPLIER_ASSIGNED"/>
     *                       &lt;enumeration value="SERIAL_NUMBER"/>
     *                       &lt;enumeration value="GLOBAL_TRADE_ITEM_IDENTIFICATION"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="tradeItemDescriptionInformation" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="longText">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="language">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;length value="2"/>
     *                       &lt;enumeration value="ES"/>
     *                       &lt;enumeration value="EN"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="invoicedQuantity">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                 &lt;attribute name="unitOfMeasure" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="aditionalQuantity" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
     *                 &lt;attribute name="QuantityType" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="18"/>
     *                       &lt;enumeration value="NUM_CONSUMER_UNITS"/>
     *                       &lt;enumeration value="FREE_GOODS"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="grossPrice" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="netPrice" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AdditionalInformation" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="referenceIdentification" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="type" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                                 &lt;length value="2"/>
     *                                 &lt;enumeration value="ON"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Customs" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="gln" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;length value="13"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="alternatePartyIdentification">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="type" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                                 &lt;length value="2"/>
     *                                 &lt;enumeration value="TN"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ReferenceDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="nameAndAddress">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="name">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;minLength value="1"/>
     *                                   &lt;maxLength value="35"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="LogisticUnits" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="serialShippingContainerCode">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="type" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="3"/>
     *                                 &lt;enumeration value="BJ"/>
     *                                 &lt;enumeration value="SRV"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="palletInformation" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="palletQuantity">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="15"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="description">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="type" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                                 &lt;maxLength value="35"/>
     *                                 &lt;minLength value="1"/>
     *                                 &lt;enumeration value="EXCHANGE_PALLETS"/>
     *                                 &lt;enumeration value="RETURN_PALLETS"/>
     *                                 &lt;enumeration value="PALLET_80x100"/>
     *                                 &lt;enumeration value="CASE"/>
     *                                 &lt;enumeration value="BOX"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="transport">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="methodOfPayment">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                                   &lt;maxLength value="17"/>
     *                                   &lt;minLength value="1"/>
     *                                   &lt;enumeration value="PREPAID_BY_SELLER"/>
     *                                   &lt;enumeration value="PAID_BY_BUYER"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="extendedAttributes" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="lotNumber" maxOccurs="10">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="productionDate" type="{http://www.w3.org/2001/XMLSchema}date" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="allowanceCharge" maxOccurs="99" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="specialServicesType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                         &lt;maxLength value="3"/>
     *                         &lt;minLength value="1"/>
     *                         &lt;enumeration value="AA"/>
     *                         &lt;enumeration value="ADS"/>
     *                         &lt;enumeration value="ADO"/>
     *                         &lt;enumeration value="ABZ"/>
     *                         &lt;enumeration value="DA"/>
     *                         &lt;enumeration value="EAA"/>
     *                         &lt;enumeration value="PI"/>
     *                         &lt;enumeration value="TAE"/>
     *                         &lt;enumeration value="SAB"/>
     *                         &lt;enumeration value="RAA"/>
     *                         &lt;enumeration value="PAD"/>
     *                         &lt;enumeration value="FG"/>
     *                         &lt;enumeration value="FA"/>
     *                         &lt;enumeration value="TD"/>
     *                         &lt;enumeration value="TS"/>
     *                         &lt;enumeration value="TX"/>
     *                         &lt;enumeration value="ZZZ"/>
     *                         &lt;enumeration value="VAB"/>
     *                         &lt;enumeration value="UM"/>
     *                         &lt;enumeration value="DI"/>
     *                         &lt;enumeration value="ADT"/>
     *                         &lt;enumeration value="AJ"/>
     *                         &lt;enumeration value="CAC"/>
     *                         &lt;enumeration value="COD"/>
     *                         &lt;enumeration value="EAB"/>
     *                         &lt;enumeration value="FC"/>
     *                         &lt;enumeration value="FI"/>
     *                         &lt;enumeration value="HD"/>
     *                         &lt;enumeration value="QD"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="monetaryAmountOrPercentage">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="percentagePerUnit">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;minLength value="1"/>
     *                                   &lt;maxLength value="5"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="ratePerUnit" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="amountPerUnit">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                             &lt;minLength value="1"/>
     *                                             &lt;maxLength value="5"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="allowanceChargeType" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="16"/>
     *                       &lt;enumeration value="ALLOWANCE_GLOBAL"/>
     *                       &lt;enumeration value="CHARGE_GLOBAL"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="settlementType">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="29"/>
     *                       &lt;enumeration value="OFF_INVOICE"/>
     *                       &lt;enumeration value="CHARGE_TO_BE_PAID_BY_VENDOR"/>
     *                       &lt;enumeration value="CHARGE_TO_BE_PAID_BY_CUSTOMER"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="sequenceNumber">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="15"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="tradeItemTaxInformation" maxOccurs="99" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="taxTypeDescription">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                         &lt;length value="3"/>
     *                         &lt;enumeration value="GST"/>
     *                         &lt;enumeration value="VAT"/>
     *                         &lt;enumeration value="LAC"/>
     *                         &lt;enumeration value="AAA"/>
     *                         &lt;enumeration value="ADD"/>
     *                         &lt;enumeration value="FRE"/>
     *                         &lt;enumeration value="LOC"/>
     *                         &lt;enumeration value="STT"/>
     *                         &lt;enumeration value="OTH"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="referenceNumber" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="20"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="tradeItemTaxAmount" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="taxPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                             &lt;element name="taxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="taxCategory" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                         &lt;minLength value="0"/>
     *                         &lt;maxLength value="11"/>
     *                         &lt;enumeration value="TRANSFERIDO"/>
     *                         &lt;enumeration value="RETENIDO"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="totalLineAmount">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="grossAmount" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="netAmount">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="type" default="SimpleInvoiceLineItemType">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="32"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="number">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
     *             &lt;totalDigits value="5"/>
     *             &lt;fractionDigits value="0"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tradeItemIdentification",
        "alternateTradeItemIdentification",
        "tradeItemDescriptionInformation",
        "invoicedQuantity",
        "aditionalQuantity",
        "grossPrice",
        "netPrice",
        "additionalInformation",
        "customs",
        "logisticUnits",
        "palletInformation",
        "extendedAttributes",
        "allowanceCharge",
        "tradeItemTaxInformation",
        "totalLineAmount"
    })
    public static class LineItem {

        @XmlElement(required = true)
        protected Detallista.LineItem.TradeItemIdentification tradeItemIdentification;
        protected List<Detallista.LineItem.AlternateTradeItemIdentification> alternateTradeItemIdentification;
        protected Detallista.LineItem.TradeItemDescriptionInformation tradeItemDescriptionInformation;
        @XmlElement(required = true)
        protected Detallista.LineItem.InvoicedQuantity invoicedQuantity;
        protected List<Detallista.LineItem.AditionalQuantity> aditionalQuantity;
        protected Detallista.LineItem.GrossPrice grossPrice;
        protected Detallista.LineItem.NetPrice netPrice;
        @XmlElement(name = "AdditionalInformation")
        protected Detallista.LineItem.AdditionalInformation additionalInformation;
        @XmlElement(name = "Customs")
        protected List<Detallista.LineItem.Customs> customs;
        @XmlElement(name = "LogisticUnits")
        protected Detallista.LineItem.LogisticUnits logisticUnits;
        protected Detallista.LineItem.PalletInformation palletInformation;
        protected Detallista.LineItem.ExtendedAttributes extendedAttributes;
        protected List<Detallista.LineItem.AllowanceCharge> allowanceCharge;
        protected List<Detallista.LineItem.TradeItemTaxInformation> tradeItemTaxInformation;
        @XmlElement(required = true)
        protected Detallista.LineItem.TotalLineAmount totalLineAmount;
        @XmlAttribute
        protected String type;
        @XmlAttribute
        protected BigInteger number;

        /**
         * Gets the value of the tradeItemIdentification property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.TradeItemIdentification }
         *     
         */
        public Detallista.LineItem.TradeItemIdentification getTradeItemIdentification() {
            return tradeItemIdentification;
        }

        /**
         * Sets the value of the tradeItemIdentification property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.TradeItemIdentification }
         *     
         */
        public void setTradeItemIdentification(Detallista.LineItem.TradeItemIdentification value) {
            this.tradeItemIdentification = value;
        }

        /**
         * Gets the value of the alternateTradeItemIdentification property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the alternateTradeItemIdentification property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAlternateTradeItemIdentification().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detallista.LineItem.AlternateTradeItemIdentification }
         * 
         * 
         */
        public List<Detallista.LineItem.AlternateTradeItemIdentification> getAlternateTradeItemIdentification() {
            if (alternateTradeItemIdentification == null) {
                alternateTradeItemIdentification = new ArrayList<Detallista.LineItem.AlternateTradeItemIdentification>();
            }
            return this.alternateTradeItemIdentification;
        }

        /**
         * Gets the value of the tradeItemDescriptionInformation property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.TradeItemDescriptionInformation }
         *     
         */
        public Detallista.LineItem.TradeItemDescriptionInformation getTradeItemDescriptionInformation() {
            return tradeItemDescriptionInformation;
        }

        /**
         * Sets the value of the tradeItemDescriptionInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.TradeItemDescriptionInformation }
         *     
         */
        public void setTradeItemDescriptionInformation(Detallista.LineItem.TradeItemDescriptionInformation value) {
            this.tradeItemDescriptionInformation = value;
        }

        /**
         * Gets the value of the invoicedQuantity property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.InvoicedQuantity }
         *     
         */
        public Detallista.LineItem.InvoicedQuantity getInvoicedQuantity() {
            return invoicedQuantity;
        }

        /**
         * Sets the value of the invoicedQuantity property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.InvoicedQuantity }
         *     
         */
        public void setInvoicedQuantity(Detallista.LineItem.InvoicedQuantity value) {
            this.invoicedQuantity = value;
        }

        /**
         * Gets the value of the aditionalQuantity property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the aditionalQuantity property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAditionalQuantity().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detallista.LineItem.AditionalQuantity }
         * 
         * 
         */
        public List<Detallista.LineItem.AditionalQuantity> getAditionalQuantity() {
            if (aditionalQuantity == null) {
                aditionalQuantity = new ArrayList<Detallista.LineItem.AditionalQuantity>();
            }
            return this.aditionalQuantity;
        }

        /**
         * Gets the value of the grossPrice property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.GrossPrice }
         *     
         */
        public Detallista.LineItem.GrossPrice getGrossPrice() {
            return grossPrice;
        }

        /**
         * Sets the value of the grossPrice property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.GrossPrice }
         *     
         */
        public void setGrossPrice(Detallista.LineItem.GrossPrice value) {
            this.grossPrice = value;
        }

        /**
         * Gets the value of the netPrice property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.NetPrice }
         *     
         */
        public Detallista.LineItem.NetPrice getNetPrice() {
            return netPrice;
        }

        /**
         * Sets the value of the netPrice property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.NetPrice }
         *     
         */
        public void setNetPrice(Detallista.LineItem.NetPrice value) {
            this.netPrice = value;
        }

        /**
         * Gets the value of the additionalInformation property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.AdditionalInformation }
         *     
         */
        public Detallista.LineItem.AdditionalInformation getAdditionalInformation() {
            return additionalInformation;
        }

        /**
         * Sets the value of the additionalInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.AdditionalInformation }
         *     
         */
        public void setAdditionalInformation(Detallista.LineItem.AdditionalInformation value) {
            this.additionalInformation = value;
        }

        /**
         * Gets the value of the customs property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the customs property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCustoms().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detallista.LineItem.Customs }
         * 
         * 
         */
        public List<Detallista.LineItem.Customs> getCustoms() {
            if (customs == null) {
                customs = new ArrayList<Detallista.LineItem.Customs>();
            }
            return this.customs;
        }

        /**
         * Gets the value of the logisticUnits property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.LogisticUnits }
         *     
         */
        public Detallista.LineItem.LogisticUnits getLogisticUnits() {
            return logisticUnits;
        }

        /**
         * Sets the value of the logisticUnits property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.LogisticUnits }
         *     
         */
        public void setLogisticUnits(Detallista.LineItem.LogisticUnits value) {
            this.logisticUnits = value;
        }

        /**
         * Gets the value of the palletInformation property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.PalletInformation }
         *     
         */
        public Detallista.LineItem.PalletInformation getPalletInformation() {
            return palletInformation;
        }

        /**
         * Sets the value of the palletInformation property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.PalletInformation }
         *     
         */
        public void setPalletInformation(Detallista.LineItem.PalletInformation value) {
            this.palletInformation = value;
        }

        /**
         * Gets the value of the extendedAttributes property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.ExtendedAttributes }
         *     
         */
        public Detallista.LineItem.ExtendedAttributes getExtendedAttributes() {
            return extendedAttributes;
        }

        /**
         * Sets the value of the extendedAttributes property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.ExtendedAttributes }
         *     
         */
        public void setExtendedAttributes(Detallista.LineItem.ExtendedAttributes value) {
            this.extendedAttributes = value;
        }

        /**
         * Gets the value of the allowanceCharge property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the allowanceCharge property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAllowanceCharge().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detallista.LineItem.AllowanceCharge }
         * 
         * 
         */
        public List<Detallista.LineItem.AllowanceCharge> getAllowanceCharge() {
            if (allowanceCharge == null) {
                allowanceCharge = new ArrayList<Detallista.LineItem.AllowanceCharge>();
            }
            return this.allowanceCharge;
        }

        /**
         * Gets the value of the tradeItemTaxInformation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tradeItemTaxInformation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTradeItemTaxInformation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detallista.LineItem.TradeItemTaxInformation }
         * 
         * 
         */
        public List<Detallista.LineItem.TradeItemTaxInformation> getTradeItemTaxInformation() {
            if (tradeItemTaxInformation == null) {
                tradeItemTaxInformation = new ArrayList<Detallista.LineItem.TradeItemTaxInformation>();
            }
            return this.tradeItemTaxInformation;
        }

        /**
         * Gets the value of the totalLineAmount property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.LineItem.TotalLineAmount }
         *     
         */
        public Detallista.LineItem.TotalLineAmount getTotalLineAmount() {
            return totalLineAmount;
        }

        /**
         * Sets the value of the totalLineAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.LineItem.TotalLineAmount }
         *     
         */
        public void setTotalLineAmount(Detallista.LineItem.TotalLineAmount value) {
            this.totalLineAmount = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            if (type == null) {
                return "SimpleInvoiceLineItemType";
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the number property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNumber() {
            return number;
        }

        /**
         * Sets the value of the number property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumber(BigInteger value) {
            this.number = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="referenceIdentification" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="type" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *                       &lt;length value="2"/>
         *                       &lt;enumeration value="ON"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "referenceIdentification"
        })
        public static class AdditionalInformation {

            protected Detallista.LineItem.AdditionalInformation.ReferenceIdentification referenceIdentification;

            /**
             * Gets the value of the referenceIdentification property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.AdditionalInformation.ReferenceIdentification }
             *     
             */
            public Detallista.LineItem.AdditionalInformation.ReferenceIdentification getReferenceIdentification() {
                return referenceIdentification;
            }

            /**
             * Sets the value of the referenceIdentification property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.AdditionalInformation.ReferenceIdentification }
             *     
             */
            public void setReferenceIdentification(Detallista.LineItem.AdditionalInformation.ReferenceIdentification value) {
                this.referenceIdentification = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="type" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
             *             &lt;length value="2"/>
             *             &lt;enumeration value="ON"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class ReferenceIdentification {

                @XmlValue
                protected String value;
                @XmlAttribute(required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                protected String type;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *       &lt;attribute name="QuantityType" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="18"/>
         *             &lt;enumeration value="NUM_CONSUMER_UNITS"/>
         *             &lt;enumeration value="FREE_GOODS"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class AditionalQuantity {

            @XmlValue
            protected BigDecimal value;
            @XmlAttribute(name = "QuantityType", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String quantityType;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * Gets the value of the quantityType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuantityType() {
                return quantityType;
            }

            /**
             * Sets the value of the quantityType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuantityType(String value) {
                this.quantityType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="specialServicesType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *               &lt;maxLength value="3"/>
         *               &lt;minLength value="1"/>
         *               &lt;enumeration value="AA"/>
         *               &lt;enumeration value="ADS"/>
         *               &lt;enumeration value="ADO"/>
         *               &lt;enumeration value="ABZ"/>
         *               &lt;enumeration value="DA"/>
         *               &lt;enumeration value="EAA"/>
         *               &lt;enumeration value="PI"/>
         *               &lt;enumeration value="TAE"/>
         *               &lt;enumeration value="SAB"/>
         *               &lt;enumeration value="RAA"/>
         *               &lt;enumeration value="PAD"/>
         *               &lt;enumeration value="FG"/>
         *               &lt;enumeration value="FA"/>
         *               &lt;enumeration value="TD"/>
         *               &lt;enumeration value="TS"/>
         *               &lt;enumeration value="TX"/>
         *               &lt;enumeration value="ZZZ"/>
         *               &lt;enumeration value="VAB"/>
         *               &lt;enumeration value="UM"/>
         *               &lt;enumeration value="DI"/>
         *               &lt;enumeration value="ADT"/>
         *               &lt;enumeration value="AJ"/>
         *               &lt;enumeration value="CAC"/>
         *               &lt;enumeration value="COD"/>
         *               &lt;enumeration value="EAB"/>
         *               &lt;enumeration value="FC"/>
         *               &lt;enumeration value="FI"/>
         *               &lt;enumeration value="HD"/>
         *               &lt;enumeration value="QD"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="monetaryAmountOrPercentage">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="percentagePerUnit">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;minLength value="1"/>
         *                         &lt;maxLength value="5"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="ratePerUnit" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="amountPerUnit">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                   &lt;minLength value="1"/>
         *                                   &lt;maxLength value="5"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="allowanceChargeType" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="16"/>
         *             &lt;enumeration value="ALLOWANCE_GLOBAL"/>
         *             &lt;enumeration value="CHARGE_GLOBAL"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="settlementType">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="29"/>
         *             &lt;enumeration value="OFF_INVOICE"/>
         *             &lt;enumeration value="CHARGE_TO_BE_PAID_BY_VENDOR"/>
         *             &lt;enumeration value="CHARGE_TO_BE_PAID_BY_CUSTOMER"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="sequenceNumber">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="15"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "specialServicesType",
            "monetaryAmountOrPercentage"
        })
        public static class AllowanceCharge {

            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String specialServicesType;
            @XmlElement(required = true)
            protected Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage monetaryAmountOrPercentage;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String allowanceChargeType;
            @XmlAttribute
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String settlementType;
            @XmlAttribute
            protected String sequenceNumber;

            /**
             * Gets the value of the specialServicesType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSpecialServicesType() {
                return specialServicesType;
            }

            /**
             * Sets the value of the specialServicesType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSpecialServicesType(String value) {
                this.specialServicesType = value;
            }

            /**
             * Gets the value of the monetaryAmountOrPercentage property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage }
             *     
             */
            public Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage getMonetaryAmountOrPercentage() {
                return monetaryAmountOrPercentage;
            }

            /**
             * Sets the value of the monetaryAmountOrPercentage property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage }
             *     
             */
            public void setMonetaryAmountOrPercentage(Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage value) {
                this.monetaryAmountOrPercentage = value;
            }

            /**
             * Gets the value of the allowanceChargeType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAllowanceChargeType() {
                return allowanceChargeType;
            }

            /**
             * Sets the value of the allowanceChargeType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAllowanceChargeType(String value) {
                this.allowanceChargeType = value;
            }

            /**
             * Gets the value of the settlementType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSettlementType() {
                return settlementType;
            }

            /**
             * Sets the value of the settlementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSettlementType(String value) {
                this.settlementType = value;
            }

            /**
             * Gets the value of the sequenceNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSequenceNumber() {
                return sequenceNumber;
            }

            /**
             * Sets the value of the sequenceNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSequenceNumber(String value) {
                this.sequenceNumber = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="percentagePerUnit">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;minLength value="1"/>
             *               &lt;maxLength value="5"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="ratePerUnit" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="amountPerUnit">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;minLength value="1"/>
             *                         &lt;maxLength value="5"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "percentagePerUnit",
                "ratePerUnit"
            })
            public static class MonetaryAmountOrPercentage {

                @XmlElement(required = true)
                protected String percentagePerUnit;
                protected Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage.RatePerUnit ratePerUnit;

                /**
                 * Gets the value of the percentagePerUnit property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPercentagePerUnit() {
                    return percentagePerUnit;
                }

                /**
                 * Sets the value of the percentagePerUnit property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPercentagePerUnit(String value) {
                    this.percentagePerUnit = value;
                }

                /**
                 * Gets the value of the ratePerUnit property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage.RatePerUnit }
                 *     
                 */
                public Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage.RatePerUnit getRatePerUnit() {
                    return ratePerUnit;
                }

                /**
                 * Sets the value of the ratePerUnit property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage.RatePerUnit }
                 *     
                 */
                public void setRatePerUnit(Detallista.LineItem.AllowanceCharge.MonetaryAmountOrPercentage.RatePerUnit value) {
                    this.ratePerUnit = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="amountPerUnit">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;minLength value="1"/>
                 *               &lt;maxLength value="5"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "amountPerUnit"
                })
                public static class RatePerUnit {

                    @XmlElement(required = true)
                    protected String amountPerUnit;

                    /**
                     * Gets the value of the amountPerUnit property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAmountPerUnit() {
                        return amountPerUnit;
                    }

                    /**
                     * Sets the value of the amountPerUnit property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAmountPerUnit(String value) {
                        this.amountPerUnit = value;
                    }

                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="type" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="35"/>
         *             &lt;enumeration value="BUYER_ASSIGNED"/>
         *             &lt;enumeration value="SUPPLIER_ASSIGNED"/>
         *             &lt;enumeration value="SERIAL_NUMBER"/>
         *             &lt;enumeration value="GLOBAL_TRADE_ITEM_IDENTIFICATION"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class AlternateTradeItemIdentification {

            @XmlValue
            protected String value;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="gln" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;length value="13"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="alternatePartyIdentification">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="type" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *                       &lt;length value="2"/>
         *                       &lt;enumeration value="TN"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ReferenceDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="nameAndAddress">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="name">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;minLength value="1"/>
         *                         &lt;maxLength value="35"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class Customs {

            protected String gln;
            @XmlElement(required = true)
            protected Detallista.LineItem.Customs.AlternatePartyIdentification alternatePartyIdentification;
            @XmlElement(name = "ReferenceDate", required = true)
            protected String referenceDate;
            @XmlElement(required = true)
            protected Detallista.LineItem.Customs.NameAndAddress nameAndAddress;

            /**
             * Gets the value of the gln property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGln() {
                return gln;
            }

            /**
             * Sets the value of the gln property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGln(String value) {
                this.gln = value;
            }

            /**
             * Gets the value of the alternatePartyIdentification property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.Customs.AlternatePartyIdentification }
             *     
             */
            public Detallista.LineItem.Customs.AlternatePartyIdentification getAlternatePartyIdentification() {
                return alternatePartyIdentification;
            }

            /**
             * Sets the value of the alternatePartyIdentification property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.Customs.AlternatePartyIdentification }
             *     
             */
            public void setAlternatePartyIdentification(Detallista.LineItem.Customs.AlternatePartyIdentification value) {
                this.alternatePartyIdentification = value;
            }

            /**
             * Gets the value of the referenceDate property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public String getReferenceDate() {
                return referenceDate;
            }

            /**
             * Sets the value of the referenceDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setReferenceDate(String value) {
                this.referenceDate = value;
            }

            /**
             * Gets the value of the nameAndAddress property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.Customs.NameAndAddress }
             *     
             */
            public Detallista.LineItem.Customs.NameAndAddress getNameAndAddress() {
                return nameAndAddress;
            }

            /**
             * Sets the value of the nameAndAddress property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.Customs.NameAndAddress }
             *     
             */
            public void setNameAndAddress(Detallista.LineItem.Customs.NameAndAddress value) {
                this.nameAndAddress = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="type" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
             *             &lt;length value="2"/>
             *             &lt;enumeration value="TN"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class AlternatePartyIdentification {

                @XmlValue
                protected String value;
                @XmlAttribute(required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                protected String type;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="name">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;minLength value="1"/>
             *               &lt;maxLength value="35"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "name"
            })
            public static class NameAndAddress {

                @XmlElement(required = true)
                protected String name;

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="lotNumber" maxOccurs="10">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="productionDate" type="{http://www.w3.org/2001/XMLSchema}date" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "lotNumber"
        })
        public static class ExtendedAttributes {

            @XmlElement(required = true)
            protected List<Detallista.LineItem.ExtendedAttributes.LotNumber> lotNumber;

            /**
             * Gets the value of the lotNumber property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the lotNumber property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLotNumber().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Detallista.LineItem.ExtendedAttributes.LotNumber }
             * 
             * 
             */
            public List<Detallista.LineItem.ExtendedAttributes.LotNumber> getLotNumber() {
                if (lotNumber == null) {
                    lotNumber = new ArrayList<Detallista.LineItem.ExtendedAttributes.LotNumber>();
                }
                return this.lotNumber;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="productionDate" type="{http://www.w3.org/2001/XMLSchema}date" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class LotNumber {

                @XmlValue
                protected String value;
                @XmlAttribute
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar productionDate;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the productionDate property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getProductionDate() {
                    return productionDate;
                }

                /**
                 * Sets the value of the productionDate property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setProductionDate(XMLGregorianCalendar value) {
                    this.productionDate = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "amount"
        })
        public static class GrossPrice {

            @XmlElement(name = "Amount", required = true)
            protected BigDecimal amount;

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>decimal">
         *       &lt;attribute name="unitOfMeasure" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class InvoicedQuantity {

            @XmlValue
            protected BigDecimal value;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlSchemaType(name = "NMTOKEN")
            protected String unitOfMeasure;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setValue(BigDecimal value) {
                this.value = value;
            }

            /**
             * Gets the value of the unitOfMeasure property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnitOfMeasure() {
                return unitOfMeasure;
            }

            /**
             * Sets the value of the unitOfMeasure property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnitOfMeasure(String value) {
                this.unitOfMeasure = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="serialShippingContainerCode">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="type" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="3"/>
         *                       &lt;enumeration value="BJ"/>
         *                       &lt;enumeration value="SRV"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "serialShippingContainerCode"
        })
        public static class LogisticUnits {

            @XmlElement(required = true)
            protected Detallista.LineItem.LogisticUnits.SerialShippingContainerCode serialShippingContainerCode;

            /**
             * Gets the value of the serialShippingContainerCode property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.LogisticUnits.SerialShippingContainerCode }
             *     
             */
            public Detallista.LineItem.LogisticUnits.SerialShippingContainerCode getSerialShippingContainerCode() {
                return serialShippingContainerCode;
            }

            /**
             * Sets the value of the serialShippingContainerCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.LogisticUnits.SerialShippingContainerCode }
             *     
             */
            public void setSerialShippingContainerCode(Detallista.LineItem.LogisticUnits.SerialShippingContainerCode value) {
                this.serialShippingContainerCode = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="type" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="3"/>
             *             &lt;enumeration value="BJ"/>
             *             &lt;enumeration value="SRV"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class SerialShippingContainerCode {

                @XmlValue
                protected String value;
                @XmlAttribute(required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                protected String type;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "amount"
        })
        public static class NetPrice {

            @XmlElement(name = "Amount", required = true)
            protected BigDecimal amount;

            /**
             * Gets the value of the amount property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="palletQuantity">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="15"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="description">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="type" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *                       &lt;maxLength value="35"/>
         *                       &lt;minLength value="1"/>
         *                       &lt;enumeration value="EXCHANGE_PALLETS"/>
         *                       &lt;enumeration value="RETURN_PALLETS"/>
         *                       &lt;enumeration value="PALLET_80x100"/>
         *                       &lt;enumeration value="CASE"/>
         *                       &lt;enumeration value="BOX"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="transport">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="methodOfPayment">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *                         &lt;maxLength value="17"/>
         *                         &lt;minLength value="1"/>
         *                         &lt;enumeration value="PREPAID_BY_SELLER"/>
         *                         &lt;enumeration value="PAID_BY_BUYER"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class PalletInformation {

            @XmlElement(required = true)
            protected String palletQuantity;
            @XmlElement(required = true)
            protected Detallista.LineItem.PalletInformation.Description description;
            @XmlElement(required = true)
            protected Detallista.LineItem.PalletInformation.Transport transport;

            /**
             * Gets the value of the palletQuantity property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPalletQuantity() {
                return palletQuantity;
            }

            /**
             * Sets the value of the palletQuantity property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPalletQuantity(String value) {
                this.palletQuantity = value;
            }

            /**
             * Gets the value of the description property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.PalletInformation.Description }
             *     
             */
            public Detallista.LineItem.PalletInformation.Description getDescription() {
                return description;
            }

            /**
             * Sets the value of the description property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.PalletInformation.Description }
             *     
             */
            public void setDescription(Detallista.LineItem.PalletInformation.Description value) {
                this.description = value;
            }

            /**
             * Gets the value of the transport property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.PalletInformation.Transport }
             *     
             */
            public Detallista.LineItem.PalletInformation.Transport getTransport() {
                return transport;
            }

            /**
             * Sets the value of the transport property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.PalletInformation.Transport }
             *     
             */
            public void setTransport(Detallista.LineItem.PalletInformation.Transport value) {
                this.transport = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="type" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
             *             &lt;maxLength value="35"/>
             *             &lt;minLength value="1"/>
             *             &lt;enumeration value="EXCHANGE_PALLETS"/>
             *             &lt;enumeration value="RETURN_PALLETS"/>
             *             &lt;enumeration value="PALLET_80x100"/>
             *             &lt;enumeration value="CASE"/>
             *             &lt;enumeration value="BOX"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Description {

                @XmlValue
                protected String value;
                @XmlAttribute(required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                protected String type;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setType(String value) {
                    this.type = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="methodOfPayment">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
             *               &lt;maxLength value="17"/>
             *               &lt;minLength value="1"/>
             *               &lt;enumeration value="PREPAID_BY_SELLER"/>
             *               &lt;enumeration value="PAID_BY_BUYER"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "methodOfPayment"
            })
            public static class Transport {

                @XmlElement(required = true)
                @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                protected String methodOfPayment;

                /**
                 * Gets the value of the methodOfPayment property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMethodOfPayment() {
                    return methodOfPayment;
                }

                /**
                 * Sets the value of the methodOfPayment property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMethodOfPayment(String value) {
                    this.methodOfPayment = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="grossAmount" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="netAmount">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "grossAmount",
            "netAmount"
        })
        public static class TotalLineAmount {

            protected Detallista.LineItem.TotalLineAmount.GrossAmount grossAmount;
            @XmlElement(required = true)
            protected Detallista.LineItem.TotalLineAmount.NetAmount netAmount;

            /**
             * Gets the value of the grossAmount property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.TotalLineAmount.GrossAmount }
             *     
             */
            public Detallista.LineItem.TotalLineAmount.GrossAmount getGrossAmount() {
                return grossAmount;
            }

            /**
             * Sets the value of the grossAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.TotalLineAmount.GrossAmount }
             *     
             */
            public void setGrossAmount(Detallista.LineItem.TotalLineAmount.GrossAmount value) {
                this.grossAmount = value;
            }

            /**
             * Gets the value of the netAmount property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.TotalLineAmount.NetAmount }
             *     
             */
            public Detallista.LineItem.TotalLineAmount.NetAmount getNetAmount() {
                return netAmount;
            }

            /**
             * Sets the value of the netAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.TotalLineAmount.NetAmount }
             *     
             */
            public void setNetAmount(Detallista.LineItem.TotalLineAmount.NetAmount value) {
                this.netAmount = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "amount"
            })
            public static class GrossAmount {

                @XmlElement(name = "Amount", required = true)
                protected BigDecimal amount;

                /**
                 * Gets the value of the amount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getAmount() {
                    return amount;
                }

                /**
                 * Sets the value of the amount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setAmount(BigDecimal value) {
                    this.amount = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "amount"
            })
            public static class NetAmount {

                @XmlElement(name = "Amount", required = true)
                protected BigDecimal amount;

                /**
                 * Gets the value of the amount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getAmount() {
                    return amount;
                }

                /**
                 * Sets the value of the amount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setAmount(BigDecimal value) {
                    this.amount = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="longText">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="language">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;length value="2"/>
         *             &lt;enumeration value="ES"/>
         *             &lt;enumeration value="EN"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "longText"
        })
        public static class TradeItemDescriptionInformation {

            @XmlElement(required = true)
            protected String longText;
            @XmlAttribute
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String language;

            /**
             * Gets the value of the longText property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLongText() {
                return longText;
            }

            /**
             * Sets the value of the longText property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLongText(String value) {
                this.longText = value;
            }

            /**
             * Gets the value of the language property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLanguage() {
                return language;
            }

            /**
             * Sets the value of the language property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLanguage(String value) {
                this.language = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="gtin">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="14"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "gtin"
        })
        public static class TradeItemIdentification {

            @XmlElement(required = true)
            protected String gtin;

            /**
             * Gets the value of the gtin property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGtin() {
                return gtin;
            }

            /**
             * Sets the value of the gtin property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGtin(String value) {
                this.gtin = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="taxTypeDescription">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *               &lt;length value="3"/>
         *               &lt;enumeration value="GST"/>
         *               &lt;enumeration value="VAT"/>
         *               &lt;enumeration value="LAC"/>
         *               &lt;enumeration value="AAA"/>
         *               &lt;enumeration value="ADD"/>
         *               &lt;enumeration value="FRE"/>
         *               &lt;enumeration value="LOC"/>
         *               &lt;enumeration value="STT"/>
         *               &lt;enumeration value="OTH"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="referenceNumber" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="20"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="tradeItemTaxAmount" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="taxPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                   &lt;element name="taxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="taxCategory" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *               &lt;minLength value="0"/>
         *               &lt;maxLength value="11"/>
         *               &lt;enumeration value="TRANSFERIDO"/>
         *               &lt;enumeration value="RETENIDO"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class TradeItemTaxInformation {

            @XmlElement(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String taxTypeDescription;
            protected String referenceNumber;
            protected Detallista.LineItem.TradeItemTaxInformation.TradeItemTaxAmount tradeItemTaxAmount;
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String taxCategory;

            /**
             * Gets the value of the taxTypeDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxTypeDescription() {
                return taxTypeDescription;
            }

            /**
             * Sets the value of the taxTypeDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxTypeDescription(String value) {
                this.taxTypeDescription = value;
            }

            /**
             * Gets the value of the referenceNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReferenceNumber() {
                return referenceNumber;
            }

            /**
             * Sets the value of the referenceNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReferenceNumber(String value) {
                this.referenceNumber = value;
            }

            /**
             * Gets the value of the tradeItemTaxAmount property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.LineItem.TradeItemTaxInformation.TradeItemTaxAmount }
             *     
             */
            public Detallista.LineItem.TradeItemTaxInformation.TradeItemTaxAmount getTradeItemTaxAmount() {
                return tradeItemTaxAmount;
            }

            /**
             * Sets the value of the tradeItemTaxAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.LineItem.TradeItemTaxInformation.TradeItemTaxAmount }
             *     
             */
            public void setTradeItemTaxAmount(Detallista.LineItem.TradeItemTaxInformation.TradeItemTaxAmount value) {
                this.tradeItemTaxAmount = value;
            }

            /**
             * Gets the value of the taxCategory property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxCategory() {
                return taxCategory;
            }

            /**
             * Sets the value of the taxCategory property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxCategory(String value) {
                this.taxCategory = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="taxPercentage" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *         &lt;element name="taxAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "taxPercentage",
                "taxAmount"
            })
            public static class TradeItemTaxAmount {

                @XmlElement(required = true)
                protected BigDecimal taxPercentage;
                @XmlElement(required = true)
                protected BigDecimal taxAmount;

                /**
                 * Gets the value of the taxPercentage property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTaxPercentage() {
                    return taxPercentage;
                }

                /**
                 * Sets the value of the taxPercentage property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTaxPercentage(BigDecimal value) {
                    this.taxPercentage = value;
                }

                /**
                 * Gets the value of the taxAmount property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getTaxAmount() {
                    return taxAmount;
                }

                /**
                 * Sets the value of the taxAmount property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setTaxAmount(BigDecimal value) {
                    this.taxAmount = value;
                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="referenceIdentification" maxOccurs="30">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="type" use="required" fixed="ON">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;enumeration value="ON"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ReferenceDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "referenceIdentification",
        "referenceDate"
    })
    public static class OrderIdentification {

        @XmlElement(required = true)
        protected List<Detallista.OrderIdentification.ReferenceIdentification> referenceIdentification;
        @XmlElement(name = "ReferenceDate")
        protected String referenceDate;

        /**
         * Gets the value of the referenceIdentification property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the referenceIdentification property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReferenceIdentification().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Detallista.OrderIdentification.ReferenceIdentification }
         * 
         * 
         */
        public List<Detallista.OrderIdentification.ReferenceIdentification> getReferenceIdentification() {
            if (referenceIdentification == null) {
                referenceIdentification = new ArrayList<Detallista.OrderIdentification.ReferenceIdentification>();
            }
            return this.referenceIdentification;
        }

        /**
         * Gets the value of the referenceDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public String getReferenceDate() {
            return referenceDate;
        }

        /**
         * Sets the value of the referenceDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setReferenceDate(String value) {
            this.referenceDate = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="type" use="required" fixed="ON">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;enumeration value="ON"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class ReferenceIdentification {

            @XmlValue
            protected String value;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                if (type == null) {
                    return "ON";
                } else {
                    return type;
                }
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="netPayment" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence minOccurs="0">
     *                   &lt;element name="paymentTimePeriod" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="timePeriodDue">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="value">
     *                                         &lt;simpleType>
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                             &lt;minLength value="1"/>
     *                                             &lt;maxLength value="5"/>
     *                                           &lt;/restriction>
     *                                         &lt;/simpleType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="timePeriod" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                                           &lt;minLength value="1"/>
     *                                           &lt;maxLength value="6"/>
     *                                           &lt;enumeration value="DAYS"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="netPaymentTermsType" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;maxLength value="22"/>
     *                       &lt;minLength value="1"/>
     *                       &lt;enumeration value="BASIC_NET"/>
     *                       &lt;enumeration value="END_OF_MONTH"/>
     *                       &lt;enumeration value="BASIC_DISCOUNT_OFFERED"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="discountPayment" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="percentage">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="5"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="discountType" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;maxLength value="28"/>
     *                       &lt;minLength value="1"/>
     *                       &lt;enumeration value="ALLOWANCE_BY_PAYMENT_ON_TIME"/>
     *                       &lt;enumeration value="SANCTION"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="paymentTermsEvent">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;maxLength value="15"/>
     *             &lt;minLength value="1"/>
     *             &lt;enumeration value="DATE_OF_INVOICE"/>
     *             &lt;enumeration value="EFFECTIVE_DATE"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="PaymentTermsRelationTime">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="15"/>
     *             &lt;enumeration value="REFERENCE_AFTER"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "netPayment",
        "discountPayment"
    })
    public static class PaymentTerms {

        protected Detallista.PaymentTerms.NetPayment netPayment;
        protected Detallista.PaymentTerms.DiscountPayment discountPayment;
        @XmlAttribute
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String paymentTermsEvent;
        @XmlAttribute(name = "PaymentTermsRelationTime")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String paymentTermsRelationTime;

        /**
         * Gets the value of the netPayment property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.PaymentTerms.NetPayment }
         *     
         */
        public Detallista.PaymentTerms.NetPayment getNetPayment() {
            return netPayment;
        }

        /**
         * Sets the value of the netPayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.PaymentTerms.NetPayment }
         *     
         */
        public void setNetPayment(Detallista.PaymentTerms.NetPayment value) {
            this.netPayment = value;
        }

        /**
         * Gets the value of the discountPayment property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.PaymentTerms.DiscountPayment }
         *     
         */
        public Detallista.PaymentTerms.DiscountPayment getDiscountPayment() {
            return discountPayment;
        }

        /**
         * Sets the value of the discountPayment property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.PaymentTerms.DiscountPayment }
         *     
         */
        public void setDiscountPayment(Detallista.PaymentTerms.DiscountPayment value) {
            this.discountPayment = value;
        }

        /**
         * Gets the value of the paymentTermsEvent property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentTermsEvent() {
            return paymentTermsEvent;
        }

        /**
         * Sets the value of the paymentTermsEvent property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentTermsEvent(String value) {
            this.paymentTermsEvent = value;
        }

        /**
         * Gets the value of the paymentTermsRelationTime property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentTermsRelationTime() {
            return paymentTermsRelationTime;
        }

        /**
         * Sets the value of the paymentTermsRelationTime property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentTermsRelationTime(String value) {
            this.paymentTermsRelationTime = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="percentage">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="5"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="discountType" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;maxLength value="28"/>
         *             &lt;minLength value="1"/>
         *             &lt;enumeration value="ALLOWANCE_BY_PAYMENT_ON_TIME"/>
         *             &lt;enumeration value="SANCTION"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "percentage"
        })
        public static class DiscountPayment {

            @XmlElement(required = true)
            protected String percentage;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String discountType;

            /**
             * Gets the value of the percentage property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPercentage() {
                return percentage;
            }

            /**
             * Sets the value of the percentage property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPercentage(String value) {
                this.percentage = value;
            }

            /**
             * Gets the value of the discountType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDiscountType() {
                return discountType;
            }

            /**
             * Sets the value of the discountType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDiscountType(String value) {
                this.discountType = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence minOccurs="0">
         *         &lt;element name="paymentTimePeriod" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="timePeriodDue">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="value">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                   &lt;minLength value="1"/>
         *                                   &lt;maxLength value="5"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                           &lt;attribute name="timePeriod" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *                                 &lt;minLength value="1"/>
         *                                 &lt;maxLength value="6"/>
         *                                 &lt;enumeration value="DAYS"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="netPaymentTermsType" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;maxLength value="22"/>
         *             &lt;minLength value="1"/>
         *             &lt;enumeration value="BASIC_NET"/>
         *             &lt;enumeration value="END_OF_MONTH"/>
         *             &lt;enumeration value="BASIC_DISCOUNT_OFFERED"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "paymentTimePeriod"
        })
        public static class NetPayment {

            protected Detallista.PaymentTerms.NetPayment.PaymentTimePeriod paymentTimePeriod;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String netPaymentTermsType;

            /**
             * Gets the value of the paymentTimePeriod property.
             * 
             * @return
             *     possible object is
             *     {@link Detallista.PaymentTerms.NetPayment.PaymentTimePeriod }
             *     
             */
            public Detallista.PaymentTerms.NetPayment.PaymentTimePeriod getPaymentTimePeriod() {
                return paymentTimePeriod;
            }

            /**
             * Sets the value of the paymentTimePeriod property.
             * 
             * @param value
             *     allowed object is
             *     {@link Detallista.PaymentTerms.NetPayment.PaymentTimePeriod }
             *     
             */
            public void setPaymentTimePeriod(Detallista.PaymentTerms.NetPayment.PaymentTimePeriod value) {
                this.paymentTimePeriod = value;
            }

            /**
             * Gets the value of the netPaymentTermsType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNetPaymentTermsType() {
                return netPaymentTermsType;
            }

            /**
             * Sets the value of the netPaymentTermsType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNetPaymentTermsType(String value) {
                this.netPaymentTermsType = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="timePeriodDue">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="value">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                         &lt;minLength value="1"/>
             *                         &lt;maxLength value="5"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *                 &lt;attribute name="timePeriod" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
             *                       &lt;minLength value="1"/>
             *                       &lt;maxLength value="6"/>
             *                       &lt;enumeration value="DAYS"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "timePeriodDue"
            })
            public static class PaymentTimePeriod {

                @XmlElement(required = true)
                protected Detallista.PaymentTerms.NetPayment.PaymentTimePeriod.TimePeriodDue timePeriodDue;

                /**
                 * Gets the value of the timePeriodDue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Detallista.PaymentTerms.NetPayment.PaymentTimePeriod.TimePeriodDue }
                 *     
                 */
                public Detallista.PaymentTerms.NetPayment.PaymentTimePeriod.TimePeriodDue getTimePeriodDue() {
                    return timePeriodDue;
                }

                /**
                 * Sets the value of the timePeriodDue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Detallista.PaymentTerms.NetPayment.PaymentTimePeriod.TimePeriodDue }
                 *     
                 */
                public void setTimePeriodDue(Detallista.PaymentTerms.NetPayment.PaymentTimePeriod.TimePeriodDue value) {
                    this.timePeriodDue = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="value">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *               &lt;minLength value="1"/>
                 *               &lt;maxLength value="5"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *       &lt;attribute name="timePeriod" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
                 *             &lt;minLength value="1"/>
                 *             &lt;maxLength value="6"/>
                 *             &lt;enumeration value="DAYS"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class TimePeriodDue {

                    @XmlElement(required = true)
                    protected String value;
                    @XmlAttribute(required = true)
                    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
                    protected String timePeriod;

                    /**
                     * Gets the value of the value property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getValue() {
                        return value;
                    }

                    /**
                     * Sets the value of the value property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setValue(String value) {
                        this.value = value;
                    }

                    /**
                     * Gets the value of the timePeriod property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTimePeriod() {
                        return timePeriod;
                    }

                    /**
                     * Sets the value of the timePeriod property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTimePeriod(String value) {
                        this.timePeriod = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entityType">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *               &lt;enumeration value="INVOICE"/>
     *               &lt;enumeration value="DEBIT_NOTE"/>
     *               &lt;enumeration value="CREDIT_NOTE"/>
     *               &lt;enumeration value="LEASE_RECEIPT"/>
     *               &lt;enumeration value="HONORARY_RECEIPT"/>
     *               &lt;enumeration value="PARTIAL_INVOICE"/>
     *               &lt;enumeration value="TRANSPORT_DOCUMENT"/>
     *               &lt;enumeration value="AUTO_INVOICE"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entityType"
    })
    public static class RequestForPaymentIdentification {

        @XmlElement(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String entityType;

        /**
         * Gets the value of the entityType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEntityType() {
            return entityType;
        }

        /**
         * Sets the value of the entityType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEntityType(String value) {
            this.entityType = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="gln">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="13"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="alternatePartyIdentification">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="type" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="40"/>
     *                       &lt;enumeration value="SELLER_ASSIGNED_IDENTIFIER_FOR_A_PARTY"/>
     *                       &lt;enumeration value="IEPS_REFERENCE"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "gln",
        "alternatePartyIdentification"
    })
    public static class Seller {

        @XmlElement(required = true)
        protected String gln;
        @XmlElement(required = true)
        protected Detallista.Seller.AlternatePartyIdentification alternatePartyIdentification;

        /**
         * Gets the value of the gln property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGln() {
            return gln;
        }

        /**
         * Sets the value of the gln property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGln(String value) {
            this.gln = value;
        }

        /**
         * Gets the value of the alternatePartyIdentification property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.Seller.AlternatePartyIdentification }
         *     
         */
        public Detallista.Seller.AlternatePartyIdentification getAlternatePartyIdentification() {
            return alternatePartyIdentification;
        }

        /**
         * Sets the value of the alternatePartyIdentification property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.Seller.AlternatePartyIdentification }
         *     
         */
        public void setAlternatePartyIdentification(Detallista.Seller.AlternatePartyIdentification value) {
            this.alternatePartyIdentification = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="type" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="40"/>
         *             &lt;enumeration value="SELLER_ASSIGNED_IDENTIFIER_FOR_A_PARTY"/>
         *             &lt;enumeration value="IEPS_REFERENCE"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class AlternatePartyIdentification {

            @XmlValue
            protected String value;
            @XmlAttribute(required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            protected String type;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the type property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * Sets the value of the type property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ShipmentDetail {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="gln" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="13"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="nameAndAddress" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="name" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="streetAddressOne" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="city" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="postalCode" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="9"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "gln",
        "nameAndAddress"
    })
    public static class ShipTo {

        protected String gln;
        protected Detallista.ShipTo.NameAndAddress nameAndAddress;

        /**
         * Gets the value of the gln property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGln() {
            return gln;
        }

        /**
         * Sets the value of the gln property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGln(String value) {
            this.gln = value;
        }

        /**
         * Gets the value of the nameAndAddress property.
         * 
         * @return
         *     possible object is
         *     {@link Detallista.ShipTo.NameAndAddress }
         *     
         */
        public Detallista.ShipTo.NameAndAddress getNameAndAddress() {
            return nameAndAddress;
        }

        /**
         * Sets the value of the nameAndAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link Detallista.ShipTo.NameAndAddress }
         *     
         */
        public void setNameAndAddress(Detallista.ShipTo.NameAndAddress value) {
            this.nameAndAddress = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="name" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="streetAddressOne" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="city" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="postalCode" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="9"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nameAndStreetAddressOneAndCity"
        })
        public static class NameAndAddress {
/*
            @XmlElementRefs({
                @XmlElementRef(name = "streetAddressOne", namespace = "http://www.sat.gob.mx/detallista", type = JAXBElement.class),
                @XmlElementRef(name = "postalCode", namespace = "http://www.sat.gob.mx/detallista", type = JAXBElement.class),
                @XmlElementRef(name = "name", namespace = "http://www.sat.gob.mx/detallista", type = JAXBElement.class),
                @XmlElementRef(name = "city", namespace = "http://www.sat.gob.mx/detallista", type = JAXBElement.class)
            })
*/
            protected List<String> nameAndStreetAddressOneAndCity;

            /**
             * Gets the value of the nameAndStreetAddressOneAndCity property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the nameAndStreetAddressOneAndCity property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getNameAndStreetAddressOneAndCity().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * 
             * 
             */
            public List<String> getNameAndStreetAddressOneAndCity() {
                if (nameAndStreetAddressOneAndCity == null) {
                    nameAndStreetAddressOneAndCity = new ArrayList<String>();
                }
                return this.nameAndStreetAddressOneAndCity;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="text" maxOccurs="15">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="255"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="code" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;maxLength value="3"/>
     *             &lt;minLength value="1"/>
     *             &lt;enumeration value="AAB"/>
     *             &lt;enumeration value="DUT"/>
     *             &lt;enumeration value="PUR"/>
     *             &lt;enumeration value="ZZZ"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SpecialInstruction {

    	@XmlElement(required = true)
        protected String text;
        @XmlAttribute(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String code;

        /**
         * Gets the value of the content property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the content property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * {@link JAXBElement }{@code <}{@link String }{@code >}
         * 
         * 
         */
        public String getText() {
        	return text;
        }
        
        public void setText(String text) {
        	this.text = text;
        }
        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="specialServicesType" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="3"/>
     *               &lt;enumeration value="AA"/>
     *               &lt;enumeration value="ADS"/>
     *               &lt;enumeration value="ADO"/>
     *               &lt;enumeration value="ABZ"/>
     *               &lt;enumeration value="DA"/>
     *               &lt;enumeration value="EAA"/>
     *               &lt;enumeration value="PI"/>
     *               &lt;enumeration value="TAE"/>
     *               &lt;enumeration value="SAB"/>
     *               &lt;enumeration value="RAA"/>
     *               &lt;enumeration value="PAD"/>
     *               &lt;enumeration value="FG"/>
     *               &lt;enumeration value="FA"/>
     *               &lt;enumeration value="TD"/>
     *               &lt;enumeration value="TS"/>
     *               &lt;enumeration value="TX"/>
     *               &lt;enumeration value="ZZZ"/>
     *               &lt;enumeration value="VAB"/>
     *               &lt;enumeration value="UM"/>
     *               &lt;enumeration value="DI"/>
     *               &lt;enumeration value="ADT"/>
     *               &lt;enumeration value="AJ"/>
     *               &lt;enumeration value="CAC"/>
     *               &lt;enumeration value="COD"/>
     *               &lt;enumeration value="EAB"/>
     *               &lt;enumeration value="FC"/>
     *               &lt;enumeration value="FI"/>
     *               &lt;enumeration value="HD"/>
     *               &lt;enumeration value="QD"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="allowanceOrChargeType" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="9"/>
     *             &lt;enumeration value="ALLOWANCE"/>
     *             &lt;enumeration value="CHARGE"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "specialServicesType",
        "amount"
    })
    public static class TotalAllowanceCharge {

        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String specialServicesType;
        @XmlElement(name = "Amount")
        protected BigDecimal amount;
        @XmlAttribute(required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String allowanceOrChargeType;

        /**
         * Gets the value of the specialServicesType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSpecialServicesType() {
            return specialServicesType;
        }

        /**
         * Sets the value of the specialServicesType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSpecialServicesType(String value) {
            this.specialServicesType = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the allowanceOrChargeType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAllowanceOrChargeType() {
            return allowanceOrChargeType;
        }

        /**
         * Sets the value of the allowanceOrChargeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAllowanceOrChargeType(String value) {
            this.allowanceOrChargeType = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "amount"
    })
    public static class TotalAmount {

        @XmlElement(name = "Amount", required = true)
        protected BigDecimal amount;

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

    }

}

	