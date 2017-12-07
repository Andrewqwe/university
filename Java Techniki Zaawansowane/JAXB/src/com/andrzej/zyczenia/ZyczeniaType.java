
package com.andrzej.zyczenia;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for zyczeniaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zyczeniaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tytul" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tresc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="zyczenia")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zyczeniaType", propOrder = {
    "tytul",
    "tresc"
})
public class ZyczeniaType {

    @XmlElement(required = true)
    protected String tytul;
    @XmlElement(required = true)
    protected String tresc;

    /**
     * Gets the value of the tytul property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTytul() {
        return tytul;
    }

    /**
     * Sets the value of the tytul property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTytul(String value) {
        this.tytul = value;
    }

    /**
     * Gets the value of the tresc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTresc() {
        return tresc;
    }

    /**
     * Sets the value of the tresc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTresc(String value) {
        this.tresc = value;
    }

    @Override
    public String toString() {
        return "ZyczeniaType{" +
                "tytul='" + tytul + '\'' +
                ", tresc='" + tresc + '\'' +
                '}';
    }
}
