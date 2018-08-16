package com.unicom.acts.pay.dao.impl;

import com.unicom.acts.pay.dao.WriteOffLogDao;
import com.unicom.acts.pay.domain.AccessLogFee;
import com.unicom.acts.pay.domain.PayLogFee;
import com.unicom.skyark.component.jdbc.dao.impl.JdbcBaseDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class WriteOffLogDaoImpl extends JdbcBaseDao implements WriteOffLogDao {
    @Override
    public boolean isExistsPayLog(String acctId, String chargrId, String provinceCode) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT 1 FROM TF_B_PAYLOG WHERE ACCT_ID = :VACCT_ID ");
        sql.append("AND CHARGE_ID = :VCHARGE_ID");
        Map param = new HashMap();
        param.put("VACCT_ID", acctId);
        param.put("VCHARGE_ID", chargrId);
        List<String> resultList = this.getJdbcTemplate(provinceCode).queryForList(sql.toString(), param, String.class);
        if (!CollectionUtils.isEmpty(resultList)) {
            return true;
        }
        return false;
    }

    @Override
    public long insertPayLog(PayLogFee payLogFee, String provinceCode) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO TF_B_PAYLOG(CHARGE_ID,PROVINCE_CODE,EPARCHY_CODE,");
        sql.append("CITY_CODE,CUST_ID,USER_ID,SERIAL_NUMBER,NET_TYPE_CODE,ACCT_ID,CHANNEL_ID,");
        sql.append("PAYMENT_ID,PAY_FEE_MODE_CODE,PAYMENT_OP,RECV_FEE,LIMIT_MONEY,RECV_TIME,");
        sql.append("RECV_EPARCHY_CODE,RECV_CITY_CODE,RECV_DEPART_ID,RECV_STAFF_ID,");
        sql.append("PAYMENT_REASON_CODE,INPUT_NO,INPUT_MODE,OUTER_TRADE_ID,ACT_TAG,EXTEND_TAG,");
        sql.append("ACTION_CODE,ACTION_EVENT_ID,PAYMENT_RULE_ID,REMARK,CANCEL_TAG,CANCEL_STAFF_ID,");
        sql.append("CANCEL_DEPART_ID,CANCEL_CITY_CODE,CANCEL_EPARCHY_CODE,CANCEL_TIME,");
        sql.append("CANCEL_CHARGE_ID,RSRV_FEE1,RSRV_FEE2,RSRV_INFO1) VALUES( ");
        sql.append(":VCHARGE_ID,:VPROVINCE_CODE,:VEPARCHY_CODE,");
        sql.append(":VCITY_CODE,:VCUST_ID,:VUSER_ID,:VSERIAL_NUMBER,");
        sql.append(":VNET_TYPE_CODE,:VACCT_ID,:VCHANNEL_ID,:VPAYMENT_ID,");
        sql.append(":VPAY_FEE_MODE_CODE,:VPAYMENT_OP,:VRECV_FEE,:VLIMIT_MONEY,");
        sql.append("STR_TO_DATE(:VRECV_TIME,'%Y-%m-%d %T'),:VRECV_EPARCHY_CODE,");
        sql.append(":VRECV_CITY_CODE,:VRECV_DEPART_ID,:VRECV_STAFF_ID,:VPAYMENT_REASON_CODE,");
        sql.append(":VINPUT_NO,:VINPUT_MODE,:VOUTER_TRADE_ID,:VACT_TAG,:VEXTEND_TAG,");
        sql.append(":VACTION_CODE,:VACTION_EVENT_ID,:VPAYMENT_RULE_ID,:VREMARK,");
        sql.append(":VCANCEL_TAG,:VCANCEL_STAFF_ID,:VCANCEL_DEPART_ID,:VCANCEL_CITY_CODE,");
        sql.append(":VCANCEL_EPARCHY_CODE,STR_TO_DATE(:VCANCEL_TIME,'%Y-%m-%d %T'),");
        sql.append(":VCANCEL_CHARGE_ID,:VRSRV_FEE1,:VRSRV_FEE2,");
        sql.append(":VRSRV_INFO1)");
        Map<String, String> param = new HashMap<>();
        param.put("VCHARGE_ID", payLogFee.getChargeId());
        param.put("VPROVINCE_CODE", payLogFee.getProvinceCode());
        param.put("VEPARCHY_CODE", payLogFee.getEparchyCode());
        param.put("VCITY_CODE", payLogFee.getCityCode());
        param.put("VCUST_ID", payLogFee.getCustId());
        param.put("VUSER_ID", payLogFee.getUserId());
        param.put("VSERIAL_NUMBER", payLogFee.getSerialNumber());
        param.put("VNET_TYPE_CODE", payLogFee.getNetTypeCode());
        param.put("VACCT_ID", payLogFee.getAcctId());
        param.put("VCHANNEL_ID", payLogFee.getChannelId());
        param.put("VPAYMENT_ID", String.valueOf(payLogFee.getPaymentId()));
        param.put("VPAY_FEE_MODE_CODE", String.valueOf(payLogFee.getPayFeeModeCode()));
        param.put("VPAYMENT_OP", String.valueOf(payLogFee.getPaymentOp()));
        param.put("VRECV_FEE", String.valueOf(payLogFee.getRecvFee()));
        param.put("VLIMIT_MONEY", String.valueOf(payLogFee.getLimitMoney()));
        param.put("VRECV_TIME", payLogFee.getRecvTime());
        param.put("VRECV_EPARCHY_CODE", payLogFee.getRecvEparchyCode());
        param.put("VRECV_CITY_CODE", payLogFee.getRecvCityCode());
        param.put("VRECV_DEPART_ID", payLogFee.getRecvDepartId());
        param.put("VRECV_STAFF_ID", payLogFee.getRecvStaffId());
        param.put("VPAYMENT_REASON_CODE", String.valueOf(payLogFee.getPaymentReasonCode()));
        param.put("VINPUT_NO", payLogFee.getInputNo());
        param.put("VINPUT_MODE", String.valueOf(payLogFee.getInputMode()));
        param.put("VOUTER_TRADE_ID", payLogFee.getOuterTradeId());
        param.put("VACT_TAG", String.valueOf(payLogFee.getActTag()));
        param.put("VEXTEND_TAG", String.valueOf(payLogFee.getExtendTag()));
        param.put("VACTION_CODE", String.valueOf(payLogFee.getActionCode()));
        param.put("VACTION_EVENT_ID", payLogFee.getActionEventId());
        param.put("VPAYMENT_RULE_ID", String.valueOf(payLogFee.getPaymentRuleId()));
        param.put("VREMARK", payLogFee.getRemark());
        param.put("VCANCEL_TAG", String.valueOf(payLogFee.getCancelTag()));
        param.put("VCANCEL_STAFF_ID", payLogFee.getCancelStaffId());
        param.put("VCANCEL_DEPART_ID", payLogFee.getCancelDepartId());
        param.put("VCANCEL_CITY_CODE", payLogFee.getCancelCityCode());
        param.put("VCANCEL_EPARCHY_CODE", payLogFee.getCancelEparchyCode());
        param.put("VCANCEL_TIME", payLogFee.getCancelTime());
        param.put("VCANCEL_CHARGE_ID", payLogFee.getCancelChargeId());
        param.put("VRSRV_FEE1", String.valueOf(payLogFee.getRsrvFee1()));
        param.put("VRSRV_FEE2", String.valueOf(payLogFee.getRsrvFee2()));
        param.put("VRSRV_INFO1", payLogFee.getRsrvInfo1());
        return this.getJdbcTemplate(provinceCode).update(sql.toString(), param);
    }

    @Override
    public void insertAccessLog(List<AccessLogFee> logs, String provinceCode) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO TF_B_ACCESSLOG(ACCESS_ID,CHARGE_ID,ACCT_ID,");
        sql.append("ACCT_BALANCE_ID,DEPOSIT_CODE,OLD_BALANCE,MONEY,NEW_BALANCE,");
        sql.append("ACCESS_TAG,OPERATE_TIME,PROVINCE_CODE,EPARCHY_CODE,CANCEL_TAG,INVOICE_FEE) ");
        sql.append("VALUES(:VACCESS_ID,:VCHARGE_ID,");
        sql.append(":VACCT_ID,:VACCT_BALANCE_ID,:VDEPOSIT_CODE,");
        sql.append(" :VOLD_BALANCE,:VMONEY,:VNEW_BALANCE,");
        sql.append(":VACCESS_TAG,STR_TO_DATE(:VOPERATE_TIME,'%Y-%m-%d %T'),");
        sql.append(":VPROVINCE_CODE,:VEPARCHY_CODE,:VCANCEL_TAG,:VINVOICE_FEE)");
        List params = new ArrayList(logs.size());
        for(AccessLogFee pAccessLogFee : logs) {
            Map<String, String> param = new HashMap<>();
            param.put("VACCESS_ID", pAccessLogFee.getAccessId ());
            param.put("VCHARGE_ID", pAccessLogFee.getChargeId());
            param.put("VACCT_ID", pAccessLogFee.getAcctId ());
            param.put("VACCT_BALANCE_ID", pAccessLogFee.getAcctBalanceId ());
            param.put("VDEPOSIT_CODE", String.valueOf(pAccessLogFee.getDepositCode()));
            param.put("VACCESS_TAG", String.valueOf(pAccessLogFee.getAccessTag()));
            param.put("VOLD_BALANCE", String.valueOf(pAccessLogFee.getOldBalance()));
            param.put("VMONEY", String.valueOf(pAccessLogFee.getMoney()));
            param.put("VNEW_BALANCE", String.valueOf(pAccessLogFee.getNewBalance()));
            param.put("VOPERATE_TIME", pAccessLogFee.getOperateTime());
            param.put("VEPARCHY_CODE", pAccessLogFee.getEparchyCode());
            param.put("VPROVINCE_CODE", pAccessLogFee.getProvinceCode());
            param.put("VCANCEL_TAG", String.valueOf(pAccessLogFee.getCancelTag()));
            param.put("VINVOICE_FEE", String.valueOf(pAccessLogFee.getInvoiceFee()));
            params.add(param);
        }
        this.getJdbcTemplate(provinceCode).batchUpdate(sql.toString(), (Map<String, String>[]) params.toArray(new Map[params.size()]));

    }


}
