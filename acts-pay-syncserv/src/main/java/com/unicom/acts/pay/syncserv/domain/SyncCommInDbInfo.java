package com.unicom.acts.pay.syncserv.domain;

import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.domain.ActsAccessLog;
import com.unicom.acts.pay.domain.ActsPayLog;

import java.util.List;

/**
 * MQ消息常用类型
 *
 * @author Wangkh
 */
public class SyncCommInDbInfo {
    private List<ActsPayLog> payLogs;
    private List<ActsAccessLog> actsAccessLogs;
    private List<AccountDeposit> accountDeposits;

    public List<ActsPayLog> getPayLogs() {
        return payLogs;
    }

    public void setPayLogs(List<ActsPayLog> payLogs) {
        this.payLogs = payLogs;
    }

    public List<ActsAccessLog> getActsAccessLogs() {
        return actsAccessLogs;
    }

    public void setActsAccessLogs(List<ActsAccessLog> actsAccessLogs) {
        this.actsAccessLogs = actsAccessLogs;
    }

    public List<AccountDeposit> getAccountDeposits() {
        return accountDeposits;
    }

    public void setAccountDeposits(List<AccountDeposit> accountDeposits) {
        this.accountDeposits = accountDeposits;
    }

    @Override
    public String toString() {
        return "SyncCommInDbInfo{" +
                "payLogs=" + payLogs +
                ", actsAccessLogs=" + actsAccessLogs +
                ", accountDeposits=" + accountDeposits +
                '}';
    }
}
