//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.11.30 at 05:02:27 PM IST 
//


package org.cxml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contact",
    "idReference",
    "pCard",
    "natureOfBusiness",
    "incorporationType",
    "accountCurrency"
})
@XmlRootElement(name = "PaymentPartner")
public class PaymentPartner {

    @XmlElement(name = "Contact", required = true)
    protected Contact contact;
    @XmlElement(name = "IdReference")
    protected List<IdReference> idReference;
    @XmlElement(name = "PCard")
    protected PCard pCard;
    @XmlElement(name = "NatureOfBusiness")
    protected String natureOfBusiness;
    @XmlElement(name = "IncorporationType")
    protected String incorporationType;
    @XmlElement(name = "AccountCurrency")
    protected AccountCurrency accountCurrency;

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link Contact }
     *     
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contact }
     *     
     */
    public void setContact(Contact value) {
        this.contact = value;
    }

    /**
     * Gets the value of the idReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdReference }
     * 
     * 
     */
    public List<IdReference> getIdReference() {
        if (idReference == null) {
            idReference = new ArrayList<IdReference>();
        }
        return this.idReference;
    }

    /**
     * Gets the value of the pCard property.
     * 
     * @return
     *     possible object is
     *     {@link PCard }
     *     
     */
    public PCard getPCard() {
        return pCard;
    }

    /**
     * Sets the value of the pCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link PCard }
     *     
     */
    public void setPCard(PCard value) {
        this.pCard = value;
    }

    /**
     * Gets the value of the natureOfBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    /**
     * Sets the value of the natureOfBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNatureOfBusiness(String value) {
        this.natureOfBusiness = value;
    }

    /**
     * Gets the value of the incorporationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncorporationType() {
        return incorporationType;
    }

    /**
     * Sets the value of the incorporationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncorporationType(String value) {
        this.incorporationType = value;
    }

    /**
     * Gets the value of the accountCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link AccountCurrency }
     *     
     */
    public AccountCurrency getAccountCurrency() {
        return accountCurrency;
    }

    /**
     * Sets the value of the accountCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountCurrency }
     *     
     */
    public void setAccountCurrency(AccountCurrency value) {
        this.accountCurrency = value;
    }

}
