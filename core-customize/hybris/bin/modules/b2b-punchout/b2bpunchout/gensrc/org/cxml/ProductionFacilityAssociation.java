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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "productionFacility",
    "organizationalUnit",
    "shipTo"
})
@XmlRootElement(name = "ProductionFacilityAssociation")
public class ProductionFacilityAssociation {

    @XmlAttribute(name = "operation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String operation;
    @XmlElement(name = "ProductionFacility", required = true)
    protected ProductionFacility productionFacility;
    @XmlElement(name = "OrganizationalUnit", required = true)
    protected OrganizationalUnit organizationalUnit;
    @XmlElement(name = "ShipTo")
    protected ShipTo shipTo;

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        if (operation == null) {
            return "new";
        } else {
            return operation;
        }
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the productionFacility property.
     * 
     * @return
     *     possible object is
     *     {@link ProductionFacility }
     *     
     */
    public ProductionFacility getProductionFacility() {
        return productionFacility;
    }

    /**
     * Sets the value of the productionFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductionFacility }
     *     
     */
    public void setProductionFacility(ProductionFacility value) {
        this.productionFacility = value;
    }

    /**
     * Gets the value of the organizationalUnit property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationalUnit }
     *     
     */
    public OrganizationalUnit getOrganizationalUnit() {
        return organizationalUnit;
    }

    /**
     * Sets the value of the organizationalUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationalUnit }
     *     
     */
    public void setOrganizationalUnit(OrganizationalUnit value) {
        this.organizationalUnit = value;
    }

    /**
     * Gets the value of the shipTo property.
     * 
     * @return
     *     possible object is
     *     {@link ShipTo }
     *     
     */
    public ShipTo getShipTo() {
        return shipTo;
    }

    /**
     * Sets the value of the shipTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipTo }
     *     
     */
    public void setShipTo(ShipTo value) {
        this.shipTo = value;
    }

}
