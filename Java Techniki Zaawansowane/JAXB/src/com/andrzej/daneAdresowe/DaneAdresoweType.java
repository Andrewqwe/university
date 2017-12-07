
package com.andrzej.daneAdresowe;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for daneAdresoweType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="daneAdresoweType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imie" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazwisko" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="miasto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name="daneAdresowe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "daneAdresoweType", propOrder = {
    "imie",
    "nazwisko",
    "miasto",
    "adres"
})
public class DaneAdresoweType {

    @XmlElement(required = true)
    protected String imie;
    @XmlElement(required = true)
    protected String nazwisko;
    @XmlElement(required = true)
    protected String miasto;
    @XmlElement(required = true)
    protected String adres;

    /**
     * Gets the value of the imie property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets the value of the imie property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImie(String value) {
        this.imie = value;
    }

    /**
     * Gets the value of the nazwisko property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Sets the value of the nazwisko property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazwisko(String value) {
        this.nazwisko = value;
    }

    /**
     * Gets the value of the miasto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiasto() {
        return miasto;
    }

    /**
     * Sets the value of the miasto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiasto(String value) {
        this.miasto = value;
    }

    /**
     * Gets the value of the adres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdres() {
        return adres;
    }

    /**
     * Sets the value of the adres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdres(String value) {
        this.adres = value;
    }

    @Override
    public String toString() {
        return "DaneAdresoweType{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", miasto='" + miasto + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
