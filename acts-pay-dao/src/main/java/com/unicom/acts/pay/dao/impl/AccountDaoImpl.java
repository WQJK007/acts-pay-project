package com.unicom.acts.pay.dao.impl;

import com.unicom.acts.pay.dao.AccountDao;
import com.unicom.acts.pay.domain.AcctPaymentCycle;
import com.unicom.skyark.component.jdbc.DbTypes;
import com.unicom.skyark.component.jdbc.dao.impl.JdbcBaseDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountDaoImpl extends JdbcBaseDao implements AccountDao {

    @Override
    public AcctPaymentCycle getAcctPaymentCycle(String acctId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT A.OFFSET_DAYS, A.OFFSET_MONTHS, A.BUNDLE_MONTHS,");
        sql.append("DATE_FORMAT(B.IN_DATE, '%Y%m') IN_DATE FROM TD_B_PAYMENT_CYCLE A,");
        sql.append("TF_F_ACCT_PAYMENT_CYCLE B WHERE A.PAYMENT_CYCLE_TYPE = B.PAYMENT_CYCLE_TYPE ");
        sql.append("AND B.ACCT_ID = :VACCT_ID AND B.ACT_TAG = '1'");
        Map<String, String> param = new HashMap<>();
        param.put("VACCT_ID", acctId);
        List<AcctPaymentCycle> results = this.getJdbcTemplate(DbTypes.ACTS_DRDS)
                .query(sql.toString(), param, new AcctPaymentCycleRowMapper());
        if (!CollectionUtils.isEmpty(results)) {
            return results.get(0);
        }
        return null;
    }

    @Override
    public int genLockAccount(String acctId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT 1 FROM TF_F_ACCOUNT WHERE ACCT_ID = TO_NUMBER(:VACCT_ID) ");
        sql.append("FOR UPDATE NOWAIT");
        Map<String, String> param = new HashMap<>();
        param.put("VACCT_ID", acctId);
        return this.getJdbcTemplate(DbTypes.ACTS_DRDS).update(sql.toString(), param);
    }

    //账户自定义缴费期
    private class AcctPaymentCycleRowMapper implements RowMapper<AcctPaymentCycle> {
        @Override
        public AcctPaymentCycle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            AcctPaymentCycle acctPaymentCycle = new AcctPaymentCycle();
            acctPaymentCycle.setOffDays(resultSet.getInt("OFFSET_DAYS"));
            acctPaymentCycle.setOffMonths(resultSet.getInt("OFFSET_MONTHS"));
            acctPaymentCycle.setBundleMonths(resultSet.getInt("BUNDLE_MONTHS"));
            acctPaymentCycle.setInDate(resultSet.getString("IN_DATE"));
            return acctPaymentCycle;
        }
    }
}
