//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.14 at 04:50:52 PM CAT 
//


package com.transportsystem.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.transportsystem.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.transportsystem.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPathDetailsRequest }
     * 
     */
    public GetPathDetailsRequest createGetPathDetailsRequest() {
        return new GetPathDetailsRequest();
    }

    /**
     * Create an instance of {@link GetPathDetailsResponse }
     * 
     */
    public GetPathDetailsResponse createGetPathDetailsResponse() {
        return new GetPathDetailsResponse();
    }

    /**
     * Create an instance of {@link PathDetails }
     * 
     */
    public PathDetails createPathDetails() {
        return new PathDetails();
    }

}
