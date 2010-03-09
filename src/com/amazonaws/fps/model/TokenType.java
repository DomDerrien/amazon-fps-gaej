
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TokenType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SingleUse"/>
 *     &lt;enumeration value="MultiUse"/>
 *     &lt;enumeration value="Recurring"/>
 *     &lt;enumeration value="Unrestricted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TokenType")
@XmlEnum
public enum TokenType {

    @XmlEnumValue("SingleUse")
    SINGLE_USE("SingleUse"),
    @XmlEnumValue("MultiUse")
    MULTI_USE("MultiUse"),
    @XmlEnumValue("Recurring")
    RECURRING("Recurring"),
    @XmlEnumValue("Unrestricted")
    UNRESTRICTED("Unrestricted");
    private final String value;

    TokenType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TokenType fromValue(String v) {
        for (TokenType c: TokenType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
