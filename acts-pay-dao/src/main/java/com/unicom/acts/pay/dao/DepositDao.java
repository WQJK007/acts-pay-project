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
     * @param provinceCode
     * @return
     */
    List<AccountDeposit> getAcctDepositByAcctId(String acctId, String provinceCode);

    /**
     * 根据账户标识查询账本销账关系
     *
     * @param acctId
     * @param provinceCode
     * @return
     */
    List<AcctBalanceRel> getAcctBalanceRelByAcctId(String acctId, String provinceCode);

    /**
     * 新增账本记录
     *
     * @param accountDeposit
     * @param provinceCode
     * @return
     */
    long insertAccountDeposit(AccountDeposit accountDeposit, String provinceCode);

    /**
     * 更新账本信息
     *
     * @param accountDeposit
     * @param provinceCode
     * @return
     */
    long updateAccountDeposit(AccountDeposit accountDeposit, String provinceCode);

    /**
     * 更账户账本新往月欠费
     *
     * @param acctId
     * @param oweFee
     * @param openCycleId
     * @param provinceCode
     * @return
     */
    long updateAcctDepoistOweFee(String acctId, long oweFee, int openCycleId, String provinceCode);

    /**
     * 更新账本往月欠费
     *
     * @param acctId
     * @param acctBalanceId
     * @param oweFee
     * @param openCycleId
     * @param provinceCode
     * @return
     */
    long updateAcctDepoistOweFeeByAcctBalanceId(String acctId, String acctBalanceId, long oweFee, int openCycleId, String provinceCode);

}
