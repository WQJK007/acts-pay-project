package com.unicom.acts.pay.domain;

import java.util.List;

/**
 * MQ消息常用类型
 *
 * @author Wangkh
 */
public class SyncCommonInfo {
    private PayLogFee payLogFee;
    private List<AccessLogFee> accessLogFees;
    private List<AccountDeposit> accountDeposits;
    private RecvCreditMQInfo recvCreditMQInfo;
    private List<JFCreditMQInfo> jfCreditMQInfoList;
    private List<LeaveRealFeeMQInfo> leaveRealFeeMQInfoList;
    private List<SmsMQInfo> smsMQInfoList;

    public PayLogFee getPayLogFee() {
        return payLogFee;
    }

    public void setPayLogFee(PayLogFee payLogFee) {
        this.payLogFee = payLogFee;
    }

    public List<AccessLogFee> getAccessLogFees() {
        return accessLogFees;
    }

    public void setAccessLogFees(List<AccessLogFee> accessLogFees) {
        this.accessLogFees = accessLogFees;
    }

    public List<AccountDeposit> getAccountDeposits() {
        return accountDeposits;
    }

    public void setAccountDeposits(List<AccountDeposit> accountDeposits) {
        this.accountDeposits = accountDeposits;
    }

    public RecvCreditMQInfo getRecvCreditMQInfo() {
        return recvCreditMQInfo;
    }

    public void setRecvCreditMQInfo(RecvCreditMQInfo recvCreditMQInfo) {
        this.recvCreditMQInfo = recvCreditMQInfo;
    }

    public List<JFCreditMQInfo> getJfCreditMQInfoList() {
        return jfCreditMQInfoList;
    }

    public void setJfCreditMQInfoList(List<JFCreditMQInfo> jfCreditMQInfoList) {
        this.jfCreditMQInfoList = jfCreditMQInfoList;
    }

    public List<LeaveRealFeeMQInfo> getLeaveRealFeeMQInfoList() {
        return leaveRealFeeMQInfoList;
    }

    public void setLeaveRealFeeMQInfoList(List<LeaveRealFeeMQInfo> leaveRealFeeMQInfoList) {
        this.leaveRealFeeMQInfoList = leaveRealFeeMQInfoList;
    }

    public List<SmsMQInfo> getSmsMQInfoList() {
        return smsMQInfoList;
    }

    public void setSmsMQInfoList(List<SmsMQInfo> smsMQInfoList) {
        this.smsMQInfoList = smsMQInfoList;
    }
}
