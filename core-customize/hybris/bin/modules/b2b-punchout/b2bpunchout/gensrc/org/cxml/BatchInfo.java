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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "BatchInfo")
public class BatchInfo {

    @XmlAttribute(name = "requiresBatch")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String requiresBatch;

    /**
     * Gets the value of the requiresBatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequiresBatch() {
        return requiresBatch;
    }

    /**
     * Sets the value of the requiresBatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequiresBatch(String value) {
        this.requiresBatch = value;
    }

}
