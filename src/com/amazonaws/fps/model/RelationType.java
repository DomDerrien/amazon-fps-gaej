
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RelationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Refund"/>
 *     &lt;enumeration value="Parent"/>
 *     &lt;enumeration value="MarketplaceFee"/>
 *     &lt;enumeration value="RefundReversal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelationType")
@XmlEnum
public enum RelationType {

    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("Parent")
    PARENT("Parent"),
    @XmlEnumValue("MarketplaceFee")
    MARKETPLACE_FEE("MarketplaceFee"),
    @XmlEnumValue("RefundReversal")
    REFUND_REVERSAL("RefundReversal");
    private final String value;

    RelationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelationType fromValue(String v) {
        for (RelationType c: RelationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
