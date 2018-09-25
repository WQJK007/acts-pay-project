package com.unicom.acts.pay.dao;

import com.unicom.acts.pay.domain.ActsAccessLog;
import com.unicom.acts.pay.domain.ActsPayLog;
import com.unicom.skyark.component.dao.IBaseDao;

import java.util.List;

/**
 * 缴费销账相关日志表CRUD操作，主要包括以下表
 * TF_B_WRITEOFFLOG，TF_B_ACCESSLOG，TF_B_WRITESNAP_LOG
 *
 * @author Wangkh
 */
public interface WriteOffLogDao extends IBaseDao {
    /**
     * 校验是否存在缴费日志
     *
     * @param acctId
     * @param chargrId
     * @return
     */
    boolean isExistsPayLog(String acctId, String chargrId);

    /**
     * 新增缴费日志记录
     *
     * @param actsPayLogs
     * @return
     */
    void insertPayLog(List<ActsPayLog> actsPayLogs);

    /**
     * 新增存取款日志数据
     *
     * @param actsAccessLogList
     */
    void insertAccessLog(List<ActsAccessLog> actsAccessLogList);

}
