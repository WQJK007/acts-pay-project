package com.unicom.acts.pay.dao.impl;

import com.unicom.acts.pay.dao.DepositDao;
import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.domain.AcctBalanceRel;
import com.unicom.skyark.component.jdbc.DbTypes;
import com.unicom.skyark.component.jdbc.dao.impl.JdbcBaseDao;
import com.unicom.skyark.component.util.StringUtil;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepositDaoImpl extends JdbcBaseDao implements DepositDao {
    @Override
    public List<AccountDeposit> getAcctDepositByAcctId(String acctId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ACCT_BALANCE_ID,ACCT_ID,USER_ID,");
        sql.append("DEPOSIT_CODE,DEPOSIT_MONEY,INIT_MONEY,MONEY,");
        sql.append("LIMIT_MONEY,LIMIT_MODE,INVOICE_FEE,PRINT_FEE,START_CYCLE_ID,");
        sql.append("END_CYCLE_ID,DATE_FORMAT(START_DATE,'%Y-%m-%d %T') START_DATE,");
        sql.append("DATE_FORMAT(END_DATE,'%Y-%m-%d %T') END_DATE,OWE_FEE,");
        sql.append("VALID_TAG,FREEZE_FEE,PRIVATE_TAG,PROVINCE_CODE,PROVINCE_CODE,");
        sql.append("EPARCHY_CODE,VERSION_NO,IFNULL(ACTION_CODE,-1) ACTION_CODE,");
        sql.append("OPEN_CYCLE_ID,DATE_FORMAT(UPDATE_TIME,'%Y-%m-%d %T') UPDATE_TIME,");
        sql.append("RSRV_INFO2,RSRV_INFO1,RSRV_FEE2,RSRV_FEE1,LIMIT_LEFT FROM TF_F_ACCOUNTDEPOSIT ");
        sql.append("WHERE ACCT_ID=:VACCT_ID");
        Map<String, String> param = new HashMap<>();
        param.put("VACCT_ID", acctId);
        return this.getJdbcTemplate(DbTypes.ACTS_DRDS).query(sql.toString(), param, new PAcctDepositMapper());
    }

    @Override
    public List<AcctBalanceRel> getAcctBalanceRelByAcctId(String acctId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ACCT_BALANCE_ID,ACCT_BALANCE_ID2,ACCT_ID,RATE ");
        sql.append("FROM TF_F_ACCTBALANCE_REL WHERE ACCT_ID = :VACCT_ID ");
        Map<String, String> param = new HashMap<>();
        param.put("VACCT_ID", acctId);
        return this.getJdbcTemplate(DbTypes.ACTS_DRDS).query(sql.toString(), param, new PAcctBalanceRelMapper());
    }

    @Override
    public long insertAccountDeposit(AccountDeposit accountDeposit) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO TF_F_ACCOUNTDEPOSIT(ACCT_BALANCE_ID,ACCT_ID,");
        sql.append("USER_ID,DEPOSIT_CODE,DEPOSIT_MONEY,INIT_MONEY,MONEY,");
        sql.append("LIMIT_MONEY,LIMIT_MODE,INVOICE_FEE,PRINT_FEE,START_CYCLE_ID,END_CYCLE_ID,");
        sql.append("START_DATE,END_DATE,OWE_FEE,VALID_TAG,FREEZE_FEE,PRIVATE_TAG,PROVINCE_CODE,");
        sql.append("EPARCHY_CODE,VERSION_NO,ACTION_CODE,OPEN_CYCLE_ID,UPDATE_TIME,RSRV_INFO2,");
        sql.append("RSRV_INFO1,RSRV_FEE2,RSRV_FEE1,LIMIT_LEFT) VALUES ");
        sql.append("(:VACCT_BALANCE_ID,:VACCT_ID,");
        sql.append(":VUSER_ID,:VDEPOSIT_CODE,:VDEPOSIT_MONEY,");
        sql.append(":VINIT_MONEY,:VMONEY,:VLIMIT_MONEY,:VLIMIT_MODE,:VINVOICE_FEE,");
        sql.append(":VPRINT_FEE,:VSTART_CYCLE_ID,:VEND_CYCLE_ID,");
        sql.append("STR_TO_DATE(:VSTART_DATE,'%Y-%m-%d %T'),");
        sql.append("STR_TO_DATE(:VEND_DATE,'%Y-%m-%d %T'),");
        sql.append(":VOWE_FEE,:VVALID_TAG,:VFREEZE_FEE,:VPRIVATE_TAG,");
        sql.append(":VPROVINCE_CODE,:VEPARCHY_CODE,:VVERSION_NO,:VACTION_CODE,:VOPEN_CYCLE_ID,");
        sql.append("STR_TO_DATE(:VUPDATE_TIME,'%Y-%m-%d %T'),");
        sql.append(":VRSRV_INFO2,:VRSRV_INFO1,:VRSRV_FEE2,");
        sql.append(":VRSRV_FEE1,:VLIMIT_LEFT)");
        Map<String, String> param = new HashMap<>();
        param.put("VACCT_BALANCE_ID", accountDeposit.getAcctBalanceId());
        param.put("VACCT_ID", accountDeposit.getAcctId());
        param.put("VUSER_ID", accountDeposit.getUserId());
        param.put("VDEPOSIT_CODE", String.valueOf(accountDeposit.getDepositCode()));
        param.put("VDEPOSIT_MONEY", String.valueOf(accountDeposit.getDepositMoney()));
        param.put("VINIT_MONEY", String.valueOf(accountDeposit.getInitMoney()));
        param.put("VMONEY", String.valueOf(accountDeposit.getMoney()));
        param.put("VLIMIT_MONEY", String.valueOf(accountDeposit.getLimitMoney()));
        param.put("VLIMIT_MODE", String.valueOf(accountDeposit.getLimitMode()));
        param.put("VINVOICE_FEE", String.valueOf(accountDeposit.getInvoiceFee()));
        param.put("VPRINT_FEE", String.valueOf(accountDeposit.getPrintFee()));
        param.put("VSTART_CYCLE_ID", String.valueOf(accountDeposit.getStartCycleId()));
        param.put("VEND_CYCLE_ID", String.valueOf(accountDeposit.getEndCycleId()));
        param.put("VSTART_DATE", accountDeposit.getStartDate());
        param.put("VEND_DATE", accountDeposit.getEndDate());
        param.put("VOWE_FEE", String.valueOf(accountDeposit.getOweFee()));
        param.put("VVALID_TAG", String.valueOf(accountDeposit.getValidTag()));
        param.put("VFREEZE_FEE", String.valueOf(accountDeposit.getFreezeFee()));
        param.put("VPRIVATE_TAG", String.valueOf(accountDeposit.getPrivateTag()));
        param.put("VPROVINCE_CODE", accountDeposit.getProvinceCode());
        param.put("VEPARCHY_CODE", accountDeposit.getEparchyCode());
        param.put("VVERSION_NO", String.valueOf(accountDeposit.getVersionNo()));
        param.put("VACTION_CODE", String.valueOf(accountDeposit.getActionCode()));
        param.put("VOPEN_CYCLE_ID", String.valueOf(accountDeposit.getOpenCycleId()));
        param.put("VUPDATE_TIME", accountDeposit.getUpdateTime());
        param.put("VRSRV_INFO2", accountDeposit.getRsrvInfo2());
        param.put("VRSRV_INFO1", accountDeposit.getRsrvInfo1());
        param.put("VRSRV_FEE2", String.valueOf(accountDeposit.getRsrvFee2()));
        param.put("VRSRV_FEE1", String.valueOf(accountDeposit.getRsrvFee1()));
        param.put("VLIMIT_LEFT", String.valueOf(accountDeposit.getLimitLeft()));
        return this.getJdbcTemplate(DbTypes.ACTS_DRDS).update(sql.toString(), param);
    }

    @Override
    public long updateAccountDeposit(AccountDeposit accountDeposit) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE TF_F_ACCOUNTDEPOSIT SET DEPOSIT_MONEY = :VDEPOSIT_MONEY,");
        sql.append("INIT_MONEY = :VINIT_MONEY,MONEY = :VMONEY,LIMIT_MONEY = :VLIMIT_MONEY,");
        sql.append("INVOICE_FEE = :VINVOICE_FEE,PRINT_FEE = :VPRINT_FEE,");
        sql.append("OWE_FEE = :VOWE_FEE,VERSION_NO = VERSION_NO + 1,");
        sql.append("UPDATE_TIME = STR_TO_DATE(:VUPDATE_TIME, '%Y-%m-%d %T') ");
        sql.append("WHERE ACCT_BALANCE_ID = :VACCT_BALANCE_ID ");
        sql.append("AND ACCT_ID = :VACCT_ID ");
        sql.append("AND VERSION_NO = :VVERSION_NO");
        Map<String, String> param = new HashMap<>();
        param.put("VACCT_BALANCE_ID", accountDeposit.getAcctBalanceId());
        param.put("VACCT_ID", accountDeposit.getAcctId());
        param.put("VDEPOSIT_MONEY", String.valueOf(accountDeposit.getDepositMoney()));
        param.put("VINIT_MONEY", String.valueOf(accountDeposit.getInitMoney()));
        param.put("VMONEY", String.valueOf(accountDeposit.getMoney()));
        param.put("VLIMIT_MONEY", String.valueOf(accountDeposit.getLimitMoney()));
        param.put("VINVOICE_FEE", String.valueOf(accountDeposit.getInvoiceFee()));
        param.put("VPRINT_FEE", String.valueOf(accountDeposit.getPrintFee()));
        param.put("VOWE_FEE", String.valueOf(accountDeposit.getOweFee()));
        param.put("VVERSION_NO", String.valueOf(accountDeposit.getVersionNo()));
        param.put("VUPDATE_TIME", accountDeposit.getUpdateTime());
        return this.getJdbcTemplate(DbTypes.ACTS_DRDS).update(sql.toString(), param);
    }

    @Override
    public long updateAcctDepoistOweFee(String acctId, long oweFee, int openCycleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE TF_F_ACCOUNTDEPOSIT SET OWE_FEE = :VOWE_FEE,");
        sql.append("OPEN_CYCLE_ID = :VOPEN_CYCLE_ID WHERE ACCT_ID = :VACCT_ID ");
        Map<String, String> param = new HashMap<>();
        param.put("VOWE_FEE", String.valueOf(oweFee));
        param.put("VOPEN_CYCLE_ID", String.valueOf(openCycleId));
        param.put("VACCT_ID", String.valueOf(acctId));
        return this.getJdbcTemplate(DbTypes.ACTS_DRDS).update(sql.toString(), param);
    }

    @Override
    public long updateAcctDepoistOweFeeByAcctBalanceId(String acctId, String acctBalanceId, long oweFee, int openCycleId) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE TF_F_ACCOUNTDEPOSIT SET OWE_FEE=:VOWE_FEE,");
        sql.append("OPEN_CYCLE_ID=:VOPEN_CYCLE_ID ");
        sql.append("WHERE ACCT_ID = :VACCT_ID AND ACCT_BALANCE_ID=:VACCT_BALANCE_ID");
        Map<String, String> param = new HashMap<>();
        param.put("VOWE_FEE", String.valueOf(oweFee));
        param.put("VOPEN_CYCLE_ID", String.valueOf(openCycleId));
        param.put("VACCT_ID", acctId);
        param.put("VACCT_BALANCE_ID", acctBalanceId);
        return this.getJdbcTemplate(DbTypes.ACTS_DRDS).update(sql.toString(), param);
    }


    //账本结果集
    class PAcctDepositMapper implements RowMapper<AccountDeposit> {
        @Override
        public AccountDeposit mapRow(ResultSet resultSet, int i) throws SQLException {
            AccountDeposit pAcctDeposit = new AccountDeposit();
            pAcctDeposit.setAcctBalanceId(resultSet.getString("ACCT_BALANCE_ID"));
            pAcctDeposit.setAcctId(resultSet.getString("ACCT_ID"));
            pAcctDeposit.setUserId(resultSet.getString("USER_ID"));
            pAcctDeposit.setDepositCode(resultSet.getInt("DEPOSIT_CODE"));
            pAcctDeposit.setDepositMoney(resultSet.getLong("DEPOSIT_MONEY"));
            pAcctDeposit.setInitMoney(resultSet.getLong("INIT_MONEY"));
            pAcctDeposit.setMoney(resultSet.getLong("MONEY"));
            pAcctDeposit.setLimitMode(StringUtil.firstOfString(resultSet.getString("LIMIT_MODE")));
            pAcctDeposit.setLimitMoney(resultSet.getLong("LIMIT_MONEY"));
            pAcctDeposit.setLimitLeft(resultSet.getLong("LIMIT_LEFT"));
            pAcctDeposit.setInvoiceFee(resultSet.getLong("INVOICE_FEE"));
            pAcctDeposit.setPrintFee(resultSet.getLong("PRINT_FEE"));
            pAcctDeposit.setStartCycleId(resultSet.getInt("START_CYCLE_ID"));
            pAcctDeposit.setEndCycleId(resultSet.getInt("END_CYCLE_ID"));
            pAcctDeposit.setStartDate(resultSet.getString("START_DATE"));
            pAcctDeposit.setEndDate(resultSet.getString("END_DATE"));
            pAcctDeposit.setOweFee(resultSet.getLong("OWE_FEE"));
            pAcctDeposit.setFreezeFee(resultSet.getLong("FREEZE_FEE"));
            pAcctDeposit.setPrivateTag(StringUtil.firstOfString(resultSet.getString("PRIVATE_TAG")));
            pAcctDeposit.setActionCode(resultSet.getInt("ACTION_CODE"));
            pAcctDeposit.setVersionNo(resultSet.getInt("VERSION_NO"));
            pAcctDeposit.setUpdateTime(resultSet.getString("UPDATE_TIME"));
            pAcctDeposit.setValidTag(StringUtil.firstOfString(resultSet.getString("VALID_TAG")));
            pAcctDeposit.setOpenCycleId(resultSet.getInt("OPEN_CYCLE_ID"));
            pAcctDeposit.setEparchyCode(resultSet.getString("EPARCHY_CODE"));
            pAcctDeposit.setProvinceCode(resultSet.getString("PROVINCE_CODE"));
            pAcctDeposit.setRsrvInfo1(resultSet.getString("RSRV_INFO1"));
            pAcctDeposit.setRsrvInfo2(resultSet.getString("RSRV_INFO2"));
            pAcctDeposit.setRsrvFee1(resultSet.getInt("RSRV_FEE1"));
            pAcctDeposit.setRsrvFee2(resultSet.getInt("RSRV_FEE2"));
            return pAcctDeposit;
        }
    }

    //帐本关系表结果集
    class PAcctBalanceRelMapper implements RowMapper<AcctBalanceRel> {
        @Override
        public AcctBalanceRel mapRow(ResultSet resultSet, int i) throws SQLException {
            AcctBalanceRel pAcctBalanceRel = new AcctBalanceRel();
            pAcctBalanceRel.setAcctBalanceId(resultSet.getString("ACCT_BALANCE_ID"));
            pAcctBalanceRel.setAcctId(resultSet.getString("ACCT_ID"));
            pAcctBalanceRel.setAcctBalanceId2(resultSet.getString("ACCT_BALANCE_ID2"));
            pAcctBalanceRel.setRate(resultSet.getInt("RATE"));
            return pAcctBalanceRel;
        }
    }
}
