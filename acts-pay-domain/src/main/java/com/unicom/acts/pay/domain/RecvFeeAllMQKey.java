package com.unicom.acts.pay.domain;


public class RecvFeeAllMQKey {
    private String acctId;
    private String chargeId;
    private String cycleStatus;
    private String tradeCheckType;

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

    public String getCycleStatus() {
        return cycleStatus;
    }

    public void setCycleStatus(String cycleStatus) {
        this.cycleStatus = cycleStatus;
    }

    public String getTradeCheckType() {
        return tradeCheckType;
    }

    public void setTradeCheckType(String tradeCheckType) {
        this.tradeCheckType = tradeCheckType;
    }

    @Override
    public String toString() {
        return "RecvFeeAllMQKey{" +
                "acctId='" + acctId + '\'' +
                ", chargeId='" + chargeId + '\'' +
                ", cycleStatus='" + cycleStatus + '\'' +
                ", tradeCheckType='" + tradeCheckType + '\'' +
                '}';
    }
}
