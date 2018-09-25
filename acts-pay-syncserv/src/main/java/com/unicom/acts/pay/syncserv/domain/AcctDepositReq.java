package com.unicom.acts.pay.syncserv.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.unicom.skyark.component.common.SkyArkPropertyNamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 账本同步快立方请求消息
 *
 * @author Wangkh
 */

@JsonNaming(SkyArkPropertyNamingStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AcctDepositReq {
    List<AccountDepositReqInfo> depositDetailinfoList = new ArrayList();

    public List<AccountDepositReqInfo> getDepositDetailinfoList() {
        return depositDetailinfoList;
    }

    public void setDepositDetailinfoList(List<AccountDepositReqInfo> depositDetailinfoList) {
        this.depositDetailinfoList = depositDetailinfoList;
    }

    @Override
    public String toString() {
        return "AcctDepositReq{" +
                "depositDetailinfoList=" + depositDetailinfoList +
                '}';
    }
}
