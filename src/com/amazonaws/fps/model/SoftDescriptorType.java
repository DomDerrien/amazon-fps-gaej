
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoftDescriptorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SoftDescriptorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Dynamic"/>
 *     &lt;enumeration value="Static"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SoftDescriptorType")
@XmlEnum
public enum SoftDescriptorType {

    @XmlEnumValue("Dynamic")
    DYNAMIC("Dynamic"),
    @XmlEnumValue("Static")
    STATIC("Static");
    private final String value;

    SoftDescriptorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SoftDescriptorType fromValue(String v) {
        for (SoftDescriptorType c: SoftDescriptorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
