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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "idReference",
    "allowedValues",
    "expectedResult",
    "sampleDefinition",
    "comments",
    "extrinsic"
})
@XmlRootElement(name = "QualityInspectionCharacteristic")
public class QualityInspectionCharacteristic {

    @XmlAttribute(name = "characteristicID", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String characteristicID;
    @XmlAttribute(name = "operationNumber", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String operationNumber;
    @XmlAttribute(name = "workCenter")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String workCenter;
    @XmlAttribute(name = "procedure")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String procedure;
    @XmlAttribute(name = "isLocked")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isLocked;
    @XmlAttribute(name = "allowDefectRecording")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String allowDefectRecording;
    @XmlAttribute(name = "characteristicType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String characteristicType;
    @XmlAttribute(name = "isQuantitative")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isQuantitative;
    @XmlAttribute(name = "recordingType")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String recordingType;
    @XmlAttribute(name = "expirationDate")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String expirationDate;
    @XmlAttribute(name = "inspectionPoint")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String inspectionPoint;
    @XmlAttribute(name = "version")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String version;
    @XmlAttribute(name = "isAdHoc")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isAdHoc;
    @XmlElement(name = "Description")
    protected Description description;
    @XmlElement(name = "IdReference")
    protected List<IdReference> idReference;
    @XmlElement(name = "AllowedValues", required = true)
    protected AllowedValues allowedValues;
    @XmlElement(name = "ExpectedResult")
    protected ExpectedResult expectedResult;
    @XmlElement(name = "SampleDefinition")
    protected SampleDefinition sampleDefinition;
    @XmlElement(name = "Comments")
    protected Comments comments;
    @XmlElement(name = "Extrinsic")
    protected List<Extrinsic> extrinsic;

    /**
     * Gets the value of the characteristicID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristicID() {
        return characteristicID;
    }

    /**
     * Sets the value of the characteristicID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristicID(String value) {
        this.characteristicID = value;
    }

    /**
     * Gets the value of the operationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationNumber() {
        return operationNumber;
    }

    /**
     * Sets the value of the operationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationNumber(String value) {
        this.operationNumber = value;
    }

    /**
     * Gets the value of the workCenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkCenter() {
        return workCenter;
    }

    /**
     * Sets the value of the workCenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkCenter(String value) {
        this.workCenter = value;
    }

    /**
     * Gets the value of the procedure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcedure() {
        return procedure;
    }

    /**
     * Sets the value of the procedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcedure(String value) {
        this.procedure = value;
    }

    /**
     * Gets the value of the isLocked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsLocked() {
        return isLocked;
    }

    /**
     * Sets the value of the isLocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLocked(String value) {
        this.isLocked = value;
    }

    /**
     * Gets the value of the allowDefectRecording property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowDefectRecording() {
        return allowDefectRecording;
    }

    /**
     * Sets the value of the allowDefectRecording property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowDefectRecording(String value) {
        this.allowDefectRecording = value;
    }

    /**
     * Gets the value of the characteristicType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacteristicType() {
        return characteristicType;
    }

    /**
     * Sets the value of the characteristicType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacteristicType(String value) {
        this.characteristicType = value;
    }

    /**
     * Gets the value of the isQuantitative property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsQuantitative() {
        return isQuantitative;
    }

    /**
     * Sets the value of the isQuantitative property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsQuantitative(String value) {
        this.isQuantitative = value;
    }

    /**
     * Gets the value of the recordingType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordingType() {
        return recordingType;
    }

    /**
     * Sets the value of the recordingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordingType(String value) {
        this.recordingType = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the inspectionPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectionPoint() {
        return inspectionPoint;
    }

    /**
     * Sets the value of the inspectionPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectionPoint(String value) {
        this.inspectionPoint = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the isAdHoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAdHoc() {
        return isAdHoc;
    }

    /**
     * Sets the value of the isAdHoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAdHoc(String value) {
        this.isAdHoc = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
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
     * Gets the value of the allowedValues property.
     * 
     * @return
     *     possible object is
     *     {@link AllowedValues }
     *     
     */
    public AllowedValues getAllowedValues() {
        return allowedValues;
    }

    /**
     * Sets the value of the allowedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedValues }
     *     
     */
    public void setAllowedValues(AllowedValues value) {
        this.allowedValues = value;
    }

    /**
     * Gets the value of the expectedResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExpectedResult }
     *     
     */
    public ExpectedResult getExpectedResult() {
        return expectedResult;
    }

    /**
     * Sets the value of the expectedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpectedResult }
     *     
     */
    public void setExpectedResult(ExpectedResult value) {
        this.expectedResult = value;
    }

    /**
     * Gets the value of the sampleDefinition property.
     * 
     * @return
     *     possible object is
     *     {@link SampleDefinition }
     *     
     */
    public SampleDefinition getSampleDefinition() {
        return sampleDefinition;
    }

    /**
     * Sets the value of the sampleDefinition property.
     * 
     * @param value
     *     allowed object is
     *     {@link SampleDefinition }
     *     
     */
    public void setSampleDefinition(SampleDefinition value) {
        this.sampleDefinition = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link Comments }
     *     
     */
    public Comments getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comments }
     *     
     */
    public void setComments(Comments value) {
        this.comments = value;
    }

    /**
     * Gets the value of the extrinsic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extrinsic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtrinsic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extrinsic }
     * 
     * 
     */
    public List<Extrinsic> getExtrinsic() {
        if (extrinsic == null) {
            extrinsic = new ArrayList<Extrinsic>();
        }
        return this.extrinsic;
    }

}
