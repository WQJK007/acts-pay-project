package com.unicom.acts.pay.syncserv.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.unicom.skyark.component.common.SkyArkPropertyNamingStrategy;

/**
 * 同步账本到内存库信息
 *
 * @author Wangkh
 */
@JsonNaming(SkyArkPropertyNamingStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccountDepositReqInfo {
    private String acctBalanceId;
    private String acctId;
    private String userId;
    private String depositCode;
    private String oddMoney;
    private String evenMoney;
    private String limitMoney;
    private String limitMode;
    private String startCycleId;
    private String endCycleId;
    private String startDate;
    private String endDate;
    private String oweFee;
    private String validTag;
    private String freezeFee;
    private String privateTag;
    private String openCycleId;
    private String updateTime;
    private String limitLeft;

    public String getAcctBalanceId() {
        return acctBalanceId;
    }

    public void setAcctBalanceId(String acctBalanceId) {
        this.acctBalanceId = acctBalanceId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepositCode() {
        return depositCode;
    }

    public void setDepositCode(String depositCode) {
        this.depositCode = depositCode;
    }

    public String getOddMoney() {
        return oddMoney;
    }

    public void setOddMoney(String oddMoney) {
        this.oddMoney = oddMoney;
    }

    public String getEvenMoney() {
        return evenMoney;
    }

    public void setEvenMoney(String evenMoney) {
        this.evenMoney = evenMoney;
    }

    public String getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(String limitMoney) {
        this.limitMoney = limitMoney;
    }

    public String getLimitMode() {
        return limitMode;
    }

    public void setLimitMode(String limitMode) {
        this.limitMode = limitMode;
    }

    public String getStartCycleId() {
        return startCycleId;
    }

    public void setStartCycleId(String startCycleId) {
        this.startCycleId = startCycleId;
    }

    public String getEndCycleId() {
        return endCycleId;
    }

    public void setEndCycleId(String endCycleId) {
        this.endCycleId = endCycleId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOweFee() {
        return oweFee;
    }

    public void setOweFee(String oweFee) {
        this.oweFee = oweFee;
    }

    public String getValidTag() {
        return validTag;
    }

    public void setValidTag(String validTag) {
        this.validTag = validTag;
    }

    public String getFreezeFee() {
        return freezeFee;
    }

    public void setFreezeFee(String freezeFee) {
        this.freezeFee = freezeFee;
    }

    public String getPrivateTag() {
        return privateTag;
    }

    public void setPrivateTag(String privateTag) {
        this.privateTag = privateTag;
    }

    public String getOpenCycleId() {
        return openCycleId;
    }

    public void setOpenCycleId(String openCycleId) {
        this.openCycleId = openCycleId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getLimitLeft() {
        return limitLeft;
    }

    public void setLimitLeft(String limitLeft) {
        this.limitLeft = limitLeft;
    }

    @Override
    public String toString() {
        return "SyncDepositInfoReq{" +
                "acctBalanceId='" + acctBalanceId + '\'' +
                ", acctId='" + acctId + '\'' +
                ", userId='" + userId + '\'' +
                ", depositCode='" + depositCode + '\'' +
                ", oddMoney='" + oddMoney + '\'' +
                ", evenMoney='" + evenMoney + '\'' +
                ", limitMoney='" + limitMoney + '\'' +
                ", limitMode='" + limitMode + '\'' +
                ", startCycleId='" + startCycleId + '\'' +
                ", endCycleId='" + endCycleId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", oweFee='" + oweFee + '\'' +
                ", validTag='" + validTag + '\'' +
                ", freezeFee='" + freezeFee + '\'' +
                ", privateTag='" + privateTag + '\'' +
                ", openCycleId='" + openCycleId + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", limitLeft='" + limitLeft + '\'' +
                '}';
    }
}
