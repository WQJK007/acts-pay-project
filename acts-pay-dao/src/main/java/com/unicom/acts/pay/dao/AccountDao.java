package com.unicom.acts.pay.dao;

import com.unicom.skyark.component.dao.IBaseDao;
import com.unicom.acts.pay.domain.AcctPaymentCycle;

/**
 * 账户资料相关查询
 *
 * @author Wangkh
 */
public interface AccountDao extends IBaseDao {
    /**
     * 账户自定义缴费期
     *
     * @param acctId
     * @param provinceCode
     * @return
     */
    AcctPaymentCycle getAcctPaymentCycle(String acctId, String provinceCode);

    /**
     * 获取账户表行锁
     * 待删除
     *
     * @param acctId
     * @param provinceCode
     * @return
     */
    int genLockAccount(String acctId, String provinceCode);
}
