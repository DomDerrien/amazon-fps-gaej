
package com.amazonaws.fps.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarketplaceRefundPolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MarketplaceRefundPolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MasterTxnOnly"/>
 *     &lt;enumeration value="MarketplaceTxnOnly"/>
 *     &lt;enumeration value="MasterAndMarketplaceTxn"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MarketplaceRefundPolicy")
@XmlEnum
public enum MarketplaceRefundPolicy {

    @XmlEnumValue("MasterTxnOnly")
    MASTER_TXN_ONLY("MasterTxnOnly"),
    @XmlEnumValue("MarketplaceTxnOnly")
    MARKETPLACE_TXN_ONLY("MarketplaceTxnOnly"),
    @XmlEnumValue("MasterAndMarketplaceTxn")
    MASTER_AND_MARKETPLACE_TXN("MasterAndMarketplaceTxn");
    private final String value;

    MarketplaceRefundPolicy(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MarketplaceRefundPolicy fromValue(String v) {
        for (MarketplaceRefundPolicy c: MarketplaceRefundPolicy.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
