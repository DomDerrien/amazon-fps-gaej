
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionalRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionalRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sender"/>
 *     &lt;enumeration value="Caller"/>
 *     &lt;enumeration value="Recipient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionalRole")
@XmlEnum
public enum TransactionalRole {

    @XmlEnumValue("Sender")
    SENDER("Sender"),
    @XmlEnumValue("Caller")
    CALLER("Caller"),
    @XmlEnumValue("Recipient")
    RECIPIENT("Recipient");
    private final String value;

    TransactionalRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionalRole fromValue(String v) {
        for (TransactionalRole c: TransactionalRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
