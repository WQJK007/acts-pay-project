package com.unicom.acts.pay.dao;

import com.unicom.acts.pay.domain.AccessLogFee;
import com.unicom.acts.pay.domain.PayLogFee;
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
     * @param payLogFee
     * @param provinceCode
     * @return
     */
    long insertPayLog(PayLogFee payLogFee, String provinceCode);

    /**
     * 新增存取款日志数据
     *
     * @param accessLogFeeList
     * @param provinceCode
     */
    void insertAccessLog(List<AccessLogFee> accessLogFeeList, String provinceCode);

}
