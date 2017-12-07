
package com.andrzej.zyczenia;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.andrzej.zyczenia package.
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

    private final static QName _Zyczenia_QNAME = new QName("", "com/andrzej/zyczenia");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.andrzej.zyczenia
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ZyczeniaType }
     * 
     */
    public ZyczeniaType createZyczeniaType() {
        return new ZyczeniaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZyczeniaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "com/andrzej/zyczenia")
    public JAXBElement<ZyczeniaType> createZyczenia(ZyczeniaType value) {
        return new JAXBElement<ZyczeniaType>(_Zyczenia_QNAME, ZyczeniaType.class, null, value);
    }

}
