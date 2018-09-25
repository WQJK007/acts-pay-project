package com.unicom.acts.pay.syncserv.service.impl;

import com.unicom.acts.pay.dao.DepositDao;
import com.unicom.acts.pay.dao.WriteOffLogDao;
import com.unicom.acts.pay.domain.AccountDeposit;
import com.unicom.acts.pay.syncserv.domain.SyncCommInDbInfo;
import com.unicom.acts.pay.syncserv.service.SyncCommInDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyncCommInDbServiceImpl implements SyncCommInDbService {
    private static final Logger logger = LoggerFactory.getLogger(SyncCommInDbServiceImpl.class);
    @Autowired
    private WriteOffLogDao writeOffLogDao;
    @Autowired
    private DepositDao depositDao;

    @Override
    public void tradeFeeInDb(SyncCommInDbInfo syncCommInDbInfo) {
        logger.info("tradeFeeInDb begin");
        //缴费日志入库
        writeOffLogDao.insertPayLog(syncCommInDbInfo.getPayLogs());
        //存取款日志入库
        writeOffLogDao.insertAccessLog(syncCommInDbInfo.getActsAccessLogs());

        //账本信息入库
        for (AccountDeposit accountDeposit : syncCommInDbInfo.getAccountDeposits()) {
            if ('1' == accountDeposit.getNewFlag()) {
                depositDao.insertAccountDeposit(accountDeposit);
            } else {
                depositDao.updateAccountDeposit(accountDeposit);
            }
        }
        logger.info("tradeFeeInDb end");
    }
}
