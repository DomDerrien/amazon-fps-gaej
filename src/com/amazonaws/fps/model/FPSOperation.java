
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FPSOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FPSOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pay"/>
 *     &lt;enumeration value="Refund"/>
 *     &lt;enumeration value="Settle"/>
 *     &lt;enumeration value="SettleDebt"/>
 *     &lt;enumeration value="WriteOffDebt"/>
 *     &lt;enumeration value="FundPrepaid"/>
 *     &lt;enumeration value="Reserve"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FPSOperation")
@XmlEnum
public enum FPSOperation {

    @XmlEnumValue("Pay")
    PAY("Pay"),
    @XmlEnumValue("Refund")
    REFUND("Refund"),
    @XmlEnumValue("Settle")
    SETTLE("Settle"),
    @XmlEnumValue("SettleDebt")
    SETTLE_DEBT("SettleDebt"),
    @XmlEnumValue("WriteOffDebt")
    WRITE_OFF_DEBT("WriteOffDebt"),
    @XmlEnumValue("FundPrepaid")
    FUND_PREPAID("FundPrepaid"),
    @XmlEnumValue("Reserve")
    RESERVE("Reserve");
    private final String value;

    FPSOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FPSOperation fromValue(String v) {
        for (FPSOperation c: FPSOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
