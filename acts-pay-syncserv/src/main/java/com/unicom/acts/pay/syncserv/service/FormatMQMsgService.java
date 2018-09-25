package com.unicom.acts.pay.syncserv.service;

import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.domain.ActsAccessLog;
import com.unicom.acts.pay.domain.ActsPayLog;
import com.unicom.acts.pay.syncserv.domain.AccessLogMQInfo;
import com.unicom.acts.pay.syncserv.domain.DepositMQInfo;
import com.unicom.acts.pay.syncserv.domain.PayLogMQInfo;
import com.unicom.skyark.component.service.IBaseService;

import java.util.List;

/**
 * MQ消息格式化转换
 *
 * @author Wangkh
 */
public interface FormatMQMsgService extends IBaseService {
    /**
     * 缴费日志MQ信息格式化为缴费日志
     *
     * @param payLogMQInfos
     * @return
     */
    List<ActsPayLog> genPayLogs(List<PayLogMQInfo> payLogMQInfos);

    /**
     * 存取款日志MQ信息格式化为存取款日志
     *
     * @param accessLogMQInfos
     * @return
     */
    List<ActsAccessLog> genAccessLogs(List<AccessLogMQInfo> accessLogMQInfos);

    /**
     * 账本MQ信息格式化为账本
     *
     * @param depositMQInfos
     * @return
     */
    List<AccountDeposit> genAccountDeposit(List<DepositMQInfo> depositMQInfos);
}
