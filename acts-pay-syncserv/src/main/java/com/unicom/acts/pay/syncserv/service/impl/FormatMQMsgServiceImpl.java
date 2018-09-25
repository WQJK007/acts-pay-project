package com.unicom.acts.pay.syncserv.service.impl;

import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.domain.ActsAccessLog;
import com.unicom.acts.pay.domain.ActsPayLog;
import com.unicom.acts.pay.syncserv.domain.AccessLogMQInfo;
import com.unicom.acts.pay.syncserv.domain.DepositMQInfo;
import com.unicom.acts.pay.syncserv.domain.PayLogMQInfo;
import com.unicom.acts.pay.syncserv.service.FormatMQMsgService;
import com.unicom.skyark.component.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FormatMQMsgServiceImpl implements FormatMQMsgService {

    @Override
    public List<ActsPayLog> genPayLogs(List<PayLogMQInfo> payLogMQInfos) {
        List<ActsPayLog> actsPayLogs = new ArrayList(2);
        for (PayLogMQInfo payLogMQInfo : payLogMQInfos) {
            ActsPayLog payLogFee = new ActsPayLog();
            payLogFee.setChargeId(payLogMQInfo.getChargeId());
            payLogFee.setEparchyCode(payLogMQInfo.getEparchyCode());
            payLogFee.setCityCode(payLogMQInfo.getCityCode());
            payLogFee.setCustId(payLogMQInfo.getCustId());
            payLogFee.setUserId(payLogMQInfo.getUserId());
            payLogFee.setSerialNumber(payLogMQInfo.getSerialNumber());
            payLogFee.setNetTypeCode(payLogMQInfo.getNetTypeCode());
            payLogFee.setAcctId(payLogMQInfo.getAcctId());
            payLogFee.setChannelId(payLogMQInfo.getChannelId());
            payLogFee.setPaymentId(payLogMQInfo.getPaymentId());
            payLogFee.setPayFeeModeCode(payLogMQInfo.getPayFeeModeCode());
            payLogFee.setPaymentOp(payLogMQInfo.getPaymentOp());
            payLogFee.setRecvFee(payLogMQInfo.getRecvFee());
            payLogFee.setLimitMoney(payLogMQInfo.getLimitMoney());
            payLogFee.setRecvTime(payLogMQInfo.getRecvTime());
            payLogFee.setRecvProvinceCode(payLogMQInfo.getRecvProvinceCode());
            payLogFee.setRecvEparchyCode(payLogMQInfo.getRecvEparchyCode());
            payLogFee.setRecvCityCode(payLogMQInfo.getRecvCityCode());
            payLogFee.setRecvDepartId(payLogMQInfo.getRecvDepartId());
            payLogFee.setRecvStaffId(payLogMQInfo.getRecvStaffId());
            payLogFee.setPaymentReasonCode(payLogMQInfo.getPaymentReasonCode());
            payLogFee.setInputMode(payLogMQInfo.getInputMode());
            payLogFee.setInputNo(payLogMQInfo.getInputNo());
            payLogFee.setOuterTradeId(payLogMQInfo.getOuterTradeId());
            payLogFee.setActionCode(payLogMQInfo.getActionCode());
            payLogFee.setActionEventId(StringUtil.isEmptyCheckNullStr(payLogMQInfo.getActionEventId()) ? null : payLogMQInfo.getActionEventId());
            payLogFee.setActTag(payLogMQInfo.getActTag());
            payLogFee.setExtendTag(payLogMQInfo.getActTag());
            payLogFee.setPaymentRuleId(payLogMQInfo.getPaymentRuleId());
            payLogFee.setRemark(payLogMQInfo.getRemark());
            payLogFee.setProvinceCode(payLogMQInfo.getProvinceCode());
            payLogFee.setCancelStaffId(payLogMQInfo.getCancelStaffId());
            payLogFee.setCancelDepartId(payLogMQInfo.getCancelDepartId());
            payLogFee.setCancelCityCode(payLogMQInfo.getCancelCityCode());
            payLogFee.setCancelEparchyCode(payLogMQInfo.getCancelEparchyCode());
            payLogFee.setCancelChargeId(payLogMQInfo.getCancelChargeId());
            payLogFee.setCancelTime(payLogMQInfo.getCancelTime());
            payLogFee.setRsrvFee1(payLogMQInfo.getRsrvFee1());
            payLogFee.setRsrvFee2(payLogMQInfo.getRsrvFee2());
            payLogFee.setRsrvInfo1(payLogMQInfo.getRsrvInfo1());
            actsPayLogs.add(payLogFee);
        }

        return actsPayLogs;
    }

    @Override
    public List<ActsAccessLog> genAccessLogs(List<AccessLogMQInfo> accessLogMQInfos) {
        List<ActsAccessLog> actsAccessLogs = new ArrayList(accessLogMQInfos.size());
        for (AccessLogMQInfo accessLogMQInfo : accessLogMQInfos) {
            ActsAccessLog accessLogFee = new ActsAccessLog();
            accessLogFee.setAccessId(accessLogMQInfo.getAccessId());
            accessLogFee.setAcctId(accessLogMQInfo.getAcctId());
            accessLogFee.setChargeId(accessLogMQInfo.getChargeId());
            accessLogFee.setAcctBalanceId(accessLogMQInfo.getAcctBalanceId());
            accessLogFee.setDepositCode(accessLogMQInfo.getDepositCode());
            accessLogFee.setOldBalance(accessLogMQInfo.getOldBalance());
            accessLogFee.setMoney(accessLogMQInfo.getMoney());
            accessLogFee.setNewBalance(accessLogMQInfo.getNewBalance());
            accessLogFee.setAccessTag(accessLogMQInfo.getAccessTag());
            accessLogFee.setOperateTime(accessLogMQInfo.getOperateTime());
            accessLogFee.setEparchyCode(accessLogMQInfo.getEparchyCode());
            accessLogFee.setCancelTag(accessLogMQInfo.getCancelTag());
            accessLogFee.setInvoiceFee(accessLogMQInfo.getInvoiceFee());
            accessLogFee.setProvinceCode(accessLogMQInfo.getProvinceCode());
            actsAccessLogs.add(accessLogFee);
        }
        return actsAccessLogs;
    }

    @Override
    public List<AccountDeposit> genAccountDeposit(List<DepositMQInfo> depositMQInfos) {
        List<AccountDeposit> accountDeposits = new ArrayList(depositMQInfos.size());
        for (DepositMQInfo depositMQInfo : depositMQInfos) {
            AccountDeposit accountDeposit = new AccountDeposit();
            accountDeposit.setAcctBalanceId(depositMQInfo.getAcctBalanceId());
            accountDeposit.setAcctId(depositMQInfo.getAcctId());
            accountDeposit.setUserId(depositMQInfo.getUserId());
            accountDeposit.setDepositCode(depositMQInfo.getDepositCode());
            accountDeposit.setDepositMoney(depositMQInfo.getDepositMoney());
            accountDeposit.setInitMoney(depositMQInfo.getInitMoney());
            accountDeposit.setMoney(depositMQInfo.getMoney());
            accountDeposit.setLimitMode(depositMQInfo.getLimitMode());
            accountDeposit.setLimitMoney(depositMQInfo.getLimitMoney());
            accountDeposit.setLimitLeft(depositMQInfo.getLimitLeft());
            accountDeposit.setInvoiceFee(depositMQInfo.getInvoiceFee());
            accountDeposit.setPrintFee(depositMQInfo.getPrintFee());
            accountDeposit.setStartCycleId(depositMQInfo.getStartCycleId());
            accountDeposit.setEndCycleId(depositMQInfo.getEndCycleId());
            accountDeposit.setStartDate(depositMQInfo.getStartDate());
            accountDeposit.setEndDate(depositMQInfo.getEndDate());
            accountDeposit.setOweFee(depositMQInfo.getOweFee());
            accountDeposit.setValidTag(depositMQInfo.getValidTag());
            accountDeposit.setFreezeFee(depositMQInfo.getFreezeFee());
            accountDeposit.setPrivateTag(depositMQInfo.getPrivateTag());
            accountDeposit.setEparchyCode(depositMQInfo.getEparchyCode());
            accountDeposit.setBackupInfo(depositMQInfo.getBackupInfo());
            accountDeposit.setRollBackInfo(depositMQInfo.getRollBackInfo());
            accountDeposit.setVersionNo(depositMQInfo.getVersionNo());
            accountDeposit.setActionCode(depositMQInfo.getActionCode());
            accountDeposit.setOpenCycleId(depositMQInfo.getOpenCycleId());
            accountDeposit.setUpdateTime(depositMQInfo.getUpdateTime());
            accountDeposit.setRsrvFee1(depositMQInfo.getRsrvFee1());
            accountDeposit.setRsrvFee2(depositMQInfo.getRsrvFee2());
            accountDeposit.setRsrvInfo1(depositMQInfo.getRsrvInfo1());
            accountDeposit.setRsrvInfo2(depositMQInfo.getRsrvInfo2());
            accountDeposit.setProvinceCode(depositMQInfo.getProvinceCode());
            accountDeposit.setNewFlag(depositMQInfo.getNewFlag());
            accountDeposits.add(accountDeposit);
        }
        return accountDeposits;
    }
}
