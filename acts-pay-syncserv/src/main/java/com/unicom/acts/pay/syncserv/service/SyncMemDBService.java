package com.unicom.acts.pay.syncserv.service;

import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.domain.AcctBalanceRel;
import com.unicom.acts.pay.syncserv.domain.UrlRouteParam;
import com.unicom.skyark.component.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 同步内存库信息
 *
 * @author Wangkh
 */
public interface SyncMemDBService extends IBaseService {
    /**
     * 同步账本信息到内存库
     *
     * @param eparchyCode
     * @param provinceCode
     * @param acctId
     */
    void syncDepositInfoToMemDB(String eparchyCode, String provinceCode, String acctId);

    /**
     * 同步账本数据到内存库
     *
     * @param accountDeposits
     */
    void syncAccountDepositToMemDB(UrlRouteParam routeParam, List<AccountDeposit> accountDeposits);

    /**
     * 同步比例关系到内存数据库
     *
     * @param acctBalanceRels
     */
    void syscAcctBalanceRelToMemDB(UrlRouteParam routeParam, List<AcctBalanceRel> acctBalanceRels);
}
