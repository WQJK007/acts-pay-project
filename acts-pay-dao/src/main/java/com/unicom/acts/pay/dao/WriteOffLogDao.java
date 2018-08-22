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
     * @param provinceCode
     * @return
     */
    boolean isExistsPayLog(String acctId, String chargrId, String provinceCode);

    /**
     * 新增缴费日志记录
     *
     * @param actsPayLog
     * @param provinceCode
     * @return
     */
    long insertPayLog(ActsPayLog actsPayLog, String provinceCode);

    /**
     * 新增存取款日志数据
     *
     * @param actsAccessLogList
     * @param provinceCode
     */
    void insertAccessLog(List<ActsAccessLog> actsAccessLogList, String provinceCode);

}
