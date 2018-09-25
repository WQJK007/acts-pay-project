package com.unicom.acts.pay.syncserv.domain;

/**
 * 余额转账MQ消息key
 *
 * @author Wangkh
 */
public class CreditSmsMsgKey {
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
