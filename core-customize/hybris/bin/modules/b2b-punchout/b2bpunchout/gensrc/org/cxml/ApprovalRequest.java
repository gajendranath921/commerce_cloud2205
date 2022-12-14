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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "approvalRequestHeader",
    "acceptanceItemOrApprovalItem"
})
@XmlRootElement(name = "ApprovalRequest")
public class ApprovalRequest {

    @XmlElement(name = "ApprovalRequestHeader", required = true)
    protected ApprovalRequestHeader approvalRequestHeader;
    @XmlElements({
        @XmlElement(name = "AcceptanceItem", type = AcceptanceItem.class),
        @XmlElement(name = "ApprovalItem", type = ApprovalItem.class)
    })
    protected List<Object> acceptanceItemOrApprovalItem;

    /**
     * Gets the value of the approvalRequestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ApprovalRequestHeader }
     *     
     */
    public ApprovalRequestHeader getApprovalRequestHeader() {
        return approvalRequestHeader;
    }

    /**
     * Sets the value of the approvalRequestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApprovalRequestHeader }
     *     
     */
    public void setApprovalRequestHeader(ApprovalRequestHeader value) {
        this.approvalRequestHeader = value;
    }

    /**
     * Gets the value of the acceptanceItemOrApprovalItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acceptanceItemOrApprovalItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcceptanceItemOrApprovalItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AcceptanceItem }
     * {@link ApprovalItem }
     * 
     * 
     */
    public List<Object> getAcceptanceItemOrApprovalItem() {
        if (acceptanceItemOrApprovalItem == null) {
            acceptanceItemOrApprovalItem = new ArrayList<Object>();
        }
        return this.acceptanceItemOrApprovalItem;
    }

}
