
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CSOwner.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CSOwner">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Caller"/>
 *     &lt;enumeration value="Recipient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CSOwner")
@XmlEnum
public enum CSOwner {

    @XmlEnumValue("Caller")
    CALLER("Caller"),
    @XmlEnumValue("Recipient")
    RECIPIENT("Recipient");
    private final String value;

    CSOwner(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CSOwner fromValue(String v) {
        for (CSOwner c: CSOwner.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
