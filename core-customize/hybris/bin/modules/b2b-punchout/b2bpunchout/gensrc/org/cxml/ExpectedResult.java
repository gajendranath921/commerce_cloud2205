//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.11.30 at 05:02:27 PM IST 
//


package org.cxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "minimumLimit",
    "maximumLimit",
    "propertyValue"
})
@XmlRootElement(name = "ExpectedResult")
public class ExpectedResult {

    @XmlAttribute(name = "targetValue")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String targetValue;
    @XmlAttribute(name = "valuePrecision")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String valuePrecision;
    @XmlAttribute(name = "qualitativeValue")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String qualitativeValue;
    @XmlElement(name = "MinimumLimit")
    protected MinimumLimit minimumLimit;
    @XmlElement(name = "MaximumLimit")
    protected MaximumLimit maximumLimit;
    @XmlElement(name = "PropertyValue")
    protected PropertyValue propertyValue;

    /**
     * Gets the value of the targetValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetValue() {
        return targetValue;
    }

    /**
     * Sets the value of the targetValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetValue(String value) {
        this.targetValue = value;
    }

    /**
     * Gets the value of the valuePrecision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValuePrecision() {
        return valuePrecision;
    }

    /**
     * Sets the value of the valuePrecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValuePrecision(String value) {
        this.valuePrecision = value;
    }

    /**
     * Gets the value of the qualitativeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualitativeValue() {
        return qualitativeValue;
    }

    /**
     * Sets the value of the qualitativeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualitativeValue(String value) {
        this.qualitativeValue = value;
    }

    /**
     * Gets the value of the minimumLimit property.
     * 
     * @return
     *     possible object is
     *     {@link MinimumLimit }
     *     
     */
    public MinimumLimit getMinimumLimit() {
        return minimumLimit;
    }

    /**
     * Sets the value of the minimumLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumLimit }
     *     
     */
    public void setMinimumLimit(MinimumLimit value) {
        this.minimumLimit = value;
    }

    /**
     * Gets the value of the maximumLimit property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumLimit }
     *     
     */
    public MaximumLimit getMaximumLimit() {
        return maximumLimit;
    }

    /**
     * Sets the value of the maximumLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumLimit }
     *     
     */
    public void setMaximumLimit(MaximumLimit value) {
        this.maximumLimit = value;
    }

    /**
     * Gets the value of the propertyValue property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyValue }
     *     
     */
    public PropertyValue getPropertyValue() {
        return propertyValue;
    }

    /**
     * Sets the value of the propertyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyValue }
     *     
     */
    public void setPropertyValue(PropertyValue value) {
        this.propertyValue = value;
    }

}
