
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ABT"/>
 *     &lt;enumeration value="CC"/>
 *     &lt;enumeration value="ACH"/>
 *     &lt;enumeration value="Debt"/>
 *     &lt;enumeration value="Prepaid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethod")
@XmlEnum
public enum PaymentMethod {

    ABT("ABT"),
    CC("CC"),
    ACH("ACH"),
    @XmlEnumValue("Debt")
    DEBT("Debt"),
    @XmlEnumValue("Prepaid")
    PREPAID("Prepaid");
    private final String value;

    PaymentMethod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentMethod fromValue(String v) {
        for (PaymentMethod c: PaymentMethod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
