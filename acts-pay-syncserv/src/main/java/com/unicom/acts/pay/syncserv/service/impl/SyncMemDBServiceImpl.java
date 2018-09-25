package com.unicom.acts.pay.syncserv.service.impl;

import com.unicom.acts.pay.dao.DepositDao;
import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.domain.AcctBalanceRel;
import com.unicom.acts.pay.syncserv.domain.*;
import com.unicom.acts.pay.syncserv.service.SyncMemDBService;
import com.unicom.skyark.component.common.constants.SysTypes;
import com.unicom.skyark.component.exception.SkyArkException;
import com.unicom.skyark.component.web.data.RequestEntity;
import com.unicom.skyark.component.web.data.Rsp;
import com.unicom.skyark.component.web.rest.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnProperty(name = ActsPayPubDef.BATCH_DEAL_MODE, havingValue = "false", matchIfMissing = true)
public class SyncMemDBServiceImpl implements SyncMemDBService {
    private static final Logger logger = LoggerFactory.getLogger(SyncMemDBServiceImpl.class);
    @Autowired
    private RestClient restClient;
    @Autowired
    private DepositDao depositDao;

    @Override
    public void syncDepositInfoToMemDB(String eparchyCode, String provinceCode, String acctId) {
        UrlRouteParam routeParam = new UrlRouteParam();
        routeParam.setEparchyCode(eparchyCode);
        routeParam.setProvinceCode(provinceCode);
        List<AccountDeposit> accountDeposits = depositDao.getAcctDepositByAcctId(acctId);
        if (!CollectionUtils.isEmpty(accountDeposits)) {
            syncAccountDepositToMemDB(routeParam, accountDeposits);
        }
        List<AcctBalanceRel> acctBalanceRels = depositDao.getAcctBalanceRelByAcctId(acctId);
        if (!CollectionUtils.isEmpty(acctBalanceRels)) {
            syscAcctBalanceRelToMemDB(routeParam, acctBalanceRels);
        }
    }

    @Override
    public void syncAccountDepositToMemDB(UrlRouteParam routeParam, List<AccountDeposit> accountDeposits) {
        RequestEntity requestEntity = new RequestEntity();
        String[] param = new String[]{routeParam.getProvinceCode(), routeParam.getEparchyCode()};
        requestEntity.setUriPaths(param);
        List<AccountDepositReqInfo> syncAcctDepositList = new ArrayList(accountDeposits.size());
        for (AccountDeposit accountDeposit : accountDeposits) {
            AccountDepositReqInfo syncAcctDeposit = new AccountDepositReqInfo();
            //修改请求参数类型
            syncAcctDeposit.setAcctBalanceId(accountDeposit.getAcctBalanceId());
            syncAcctDeposit.setAcctId(accountDeposit.getAcctId());
            syncAcctDeposit.setUserId(accountDeposit.getUserId());
            syncAcctDeposit.setDepositCode(String.valueOf(accountDeposit.getDepositCode()));
            syncAcctDeposit.setOddMoney(String.valueOf(accountDeposit.getMoney()));
            syncAcctDeposit.setEvenMoney("0");
            syncAcctDeposit.setLimitMode(String.valueOf(accountDeposit.getLimitMode()));
            syncAcctDeposit.setLimitMoney(String.valueOf(accountDeposit.getLimitMoney()));
            syncAcctDeposit.setLimitLeft(String.valueOf(accountDeposit.getLimitLeft()));
            syncAcctDeposit.setStartCycleId(String.valueOf(accountDeposit.getStartCycleId()));
            syncAcctDeposit.setEndCycleId(String.valueOf(accountDeposit.getEndCycleId()));
            syncAcctDeposit.setStartDate(accountDeposit.getStartDate());
            syncAcctDeposit.setEndDate(accountDeposit.getEndDate());
            syncAcctDeposit.setOweFee(String.valueOf(accountDeposit.getOweFee()));
            syncAcctDeposit.setValidTag(String.valueOf(accountDeposit.getValidTag()));
            syncAcctDeposit.setFreezeFee(String.valueOf(accountDeposit.getFreezeFee()));
            syncAcctDeposit.setPrivateTag(String.valueOf(accountDeposit.getPrivateTag()));
            syncAcctDeposit.setOpenCycleId(String.valueOf(accountDeposit.getOpenCycleId()));
            syncAcctDeposit.setUpdateTime(accountDeposit.getUpdateTime());
            syncAcctDepositList.add(syncAcctDeposit);
        }
        AcctDepositReq acctDepositReq = new AcctDepositReq();
        acctDepositReq.setDepositDetailinfoList(syncAcctDepositList);
        requestEntity.setRequestBody(acctDepositReq);
        //账本数据同步快力方公共微服务
        try {
            Rsp rsp = this.restClient.callSkyArkMicroService("accounting",
                    "syncacctdeposit", HttpMethod.POST, requestEntity);
            if (!SysTypes.SYS_SUCCESS_CODE.equals(rsp.getRspCode())) {
                throw new SkyArkException(rsp.getRspCode(), rsp.getRspDesc());
            }
            logger.info("账本数据同步快立方成功");
        } catch (Exception ex) {
            throw new SkyArkException("账本数据同步快立方失败!" + ex.getMessage());
        }

    }

    @Override
    public void syscAcctBalanceRelToMemDB(UrlRouteParam routeParam, List<AcctBalanceRel> acctBalanceRels) {
        RequestEntity requestEntity = new RequestEntity();
        String[] param = new String[]{routeParam.getProvinceCode(), routeParam.getEparchyCode()};
        requestEntity.setUriPaths(param);
        List<AcctBalanceRelReqInfo> acctBalanceRelReqs = new ArrayList(acctBalanceRels.size());
        for (AcctBalanceRel acctBalanceRel : acctBalanceRels) {
            AcctBalanceRelReqInfo acctBalanceRelReqInfo = new AcctBalanceRelReqInfo();
            acctBalanceRelReqInfo.setAcctId(acctBalanceRel.getAcctId());
            acctBalanceRelReqInfo.setAcctBalanceId(acctBalanceRel.getAcctBalanceId());
            acctBalanceRelReqInfo.setAcctBalanceId2(acctBalanceRel.getAcctBalanceId2());
            acctBalanceRelReqInfo.setPartitionId(acctBalanceRel.getAcctId().substring(acctBalanceRel.getAcctId().length() - 4));
            acctBalanceRelReqInfo.setRate(String.valueOf(acctBalanceRel.getRate()));
            acctBalanceRelReqs.add(acctBalanceRelReqInfo);
        }
        AcctBalanceRelReq acctBalanceRelReq = new AcctBalanceRelReq();
        acctBalanceRelReq.setAcctbalanceRelList(acctBalanceRelReqs);
        requestEntity.setRequestBody(acctBalanceRelReq);
        //账本数据同步快力方公共微服务
        try {
            Rsp rsp = this.restClient.callSkyArkMicroService("accounting",
                    "syncacctbalancerel", HttpMethod.POST, requestEntity);
            if (!SysTypes.SYS_SUCCESS_CODE.equals(rsp.getRspCode())) {
                throw new SkyArkException(rsp.getRspCode(), rsp.getRspDesc());
            }
            logger.info("账本关系数据同步快立方成功");
        } catch (Exception ex) {
            throw new SkyArkException("账本关系数据同步快立方失败!" + ex.getMessage());
        }
    }
}
