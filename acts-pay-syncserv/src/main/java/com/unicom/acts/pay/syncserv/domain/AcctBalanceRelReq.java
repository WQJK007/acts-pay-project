package com.unicom.acts.pay.syncserv.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.unicom.skyark.component.common.SkyArkPropertyNamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 账本关系同步快立方请求消息体
 */
@JsonNaming(SkyArkPropertyNamingStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AcctBalanceRelReq {
    List<AcctBalanceRelReqInfo> acctbalanceRelList = new ArrayList();

    public List<AcctBalanceRelReqInfo> getAcctbalanceRelList() {
        return acctbalanceRelList;
    }

    public void setAcctbalanceRelList(List<AcctBalanceRelReqInfo> acctbalanceRelList) {
        this.acctbalanceRelList = acctbalanceRelList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"acctbalanceRelList\":")
                .append(acctbalanceRelList);
        sb.append('}');
        return sb.toString();
    }
}
