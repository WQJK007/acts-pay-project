package com.unicom.acts.pay.syncserv.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.unicom.skyark.component.common.SkyArkPropertyNamingStrategy;

/**
 * 余额转账MQ消息key
 *
 * @author Wangkh
 */
@JsonNaming(SkyArkPropertyNamingStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TransFeeMQMsgKey {
    /**
     * @see #acctId 账户标识
     */
    private String acctId;
    /**
     * @see #chargeId 交易流水
     */
    private String chargeId;
    /**
     * @see #outerTradeId 外围交易流水
     */
    private String outerTradeId;

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getOuterTradeId() {
        return outerTradeId;
    }

    public void setOuterTradeId(String outerTradeId) {
        this.outerTradeId = outerTradeId;
    }

    @Override
    public String toString() {
        return "TransFeeMQMsgKey{" +
                "acctId='" + acctId + '\'' +
                ", chargeId='" + chargeId + '\'' +
                ", outerTradeId='" + outerTradeId + '\'' +
                '}';
    }
}
