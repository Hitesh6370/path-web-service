//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.14 at 04:50:52 PM CAT 
//


package com.transportsystem.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="PathDetails" type="{http://transportsystem.com/soap}PathDetails"/>
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
    "pathDetails"
})
@XmlRootElement(name = "GetPathDetailsResponse")
public class GetPathDetailsResponse {

    @XmlElement(name = "PathDetails", required = true)
    protected PathDetails pathDetails;

    /**
     * Gets the value of the pathDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PathDetails }
     *     
     */
    public PathDetails getPathDetails() {
        return pathDetails;
    }

    /**
     * Sets the value of the pathDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PathDetails }
     *     
     */
    public void setPathDetails(PathDetails value) {
        this.pathDetails = value;
    }

}
