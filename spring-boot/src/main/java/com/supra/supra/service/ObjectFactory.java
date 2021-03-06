//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.25 at 07:14:35 AM GST 
//


package com.supra.supra.service;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.supra.supra.service package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.supra.supra.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookRequest }
     * 
     */
    public BookRequest createBookRequest() {
        return new BookRequest();
    }

    /**
     * Create an instance of {@link ShiporderRequest }
     * 
     */
    public ShiporderRequest createShiporderRequest() {
        return new ShiporderRequest();
    }

    /**
     * Create an instance of {@link BookRequest.Character }
     * 
     */
    public BookRequest.Character createBookRequestCharacter() {
        return new BookRequest.Character();
    }

    /**
     * Create an instance of {@link BookResponse }
     * 
     */
    public BookResponse createBookResponse() {
        return new BookResponse();
    }

    /**
     * Create an instance of {@link ShiporderRequest.Shipto }
     * 
     */
    public ShiporderRequest.Shipto createShiporderRequestShipto() {
        return new ShiporderRequest.Shipto();
    }

    /**
     * Create an instance of {@link ShiporderRequest.Item }
     * 
     */
    public ShiporderRequest.Item createShiporderRequestItem() {
        return new ShiporderRequest.Item();
    }

    /**
     * Create an instance of {@link ShiporderResponse }
     * 
     */
    public ShiporderResponse createShiporderResponse() {
        return new ShiporderResponse();
    }

}
