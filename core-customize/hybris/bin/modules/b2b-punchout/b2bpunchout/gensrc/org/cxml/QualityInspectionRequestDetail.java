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
    "qualityInspectionCharacteristic"
})
@XmlRootElement(name = "QualityInspectionRequestDetail")
public class QualityInspectionRequestDetail {

    @XmlElement(name = "QualityInspectionCharacteristic", required = true)
    protected List<QualityInspectionCharacteristic> qualityInspectionCharacteristic;

    /**
     * Gets the value of the qualityInspectionCharacteristic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the qualityInspectionCharacteristic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQualityInspectionCharacteristic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QualityInspectionCharacteristic }
     * 
     * 
     */
    public List<QualityInspectionCharacteristic> getQualityInspectionCharacteristic() {
        if (qualityInspectionCharacteristic == null) {
            qualityInspectionCharacteristic = new ArrayList<QualityInspectionCharacteristic>();
        }
        return this.qualityInspectionCharacteristic;
    }

}
