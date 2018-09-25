package com.unicom.acts.pay.dao;

import com.unicom.skyark.component.dao.IBaseDao;
import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.domain.AcctBalanceRel;

import java.util.List;

/**
 * 账管相关数据库操作
 *
 * @author Wangkh
 */
public interface DepositDao extends IBaseDao {
    /**
     * 根据账户标识查询账本
     *
     * @param acctId
     * @return
     */
    List<AccountDeposit> getAcctDepositByAcctId(String acctId);

    /**
     * 根据账户标识查询账本销账关系
     *
     * @param acctId
     * @return
     */
    List<AcctBalanceRel> getAcctBalanceRelByAcctId(String acctId);

    /**
     * 新增账本记录
     *
     * @param accountDeposit
     * @return
     */
    long insertAccountDeposit(AccountDeposit accountDeposit);

    /**
     * 更新账本信息
     *
     * @param accountDeposit
     * @return
     */
    long updateAccountDeposit(AccountDeposit accountDeposit);

    /**
     * 更账户账本新往月欠费
     *
     * @param acctId
     * @param oweFee
     * @param openCycleId
     * @return
     */
    long updateAcctDepoistOweFee(String acctId, long oweFee, int openCycleId);

    /**
     * 更新账本往月欠费
     *
     * @param acctId
     * @param acctBalanceId
     * @param oweFee
     * @param openCycleId
     * @return
     */
    long updateAcctDepoistOweFeeByAcctBalanceId(String acctId, String acctBalanceId, long oweFee, int openCycleId);

}
