package com.unicom.acts.pay.syncserv.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.unicom.skyark.component.common.SkyArkPropertyNamingStrategy;

/**
 * 同步账本比例关系到内存库信息
 *
 * @author Wangkh
 */
@JsonNaming(SkyArkPropertyNamingStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AcctBalanceRelReqInfo {
    private String acctBalanceId;
    private String acctId;
    private String acctBalanceId2;
    private String partitionId;
    private String rate;

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

    public String getAcctBalanceId2() {
        return acctBalanceId2;
    }

    public void setAcctBalanceId2(String acctBalanceId2) {
        this.acctBalanceId2 = acctBalanceId2;
    }

    public String getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(String partitionId) {
        this.partitionId = partitionId;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "SyncAcctBalanceRelReq{" +
                "acctBalanceId='" + acctBalanceId + '\'' +
                ", acctId='" + acctId + '\'' +
                ", acctBalanceId2='" + acctBalanceId2 + '\'' +
                ", partitionId='" + partitionId + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
