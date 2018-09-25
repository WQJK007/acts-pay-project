package com.unicom.acts.pay.syncserv.service;

import com.unicom.acts.pay.syncserv.domain.SyncCommInDbInfo;
import com.unicom.skyark.component.service.IBaseService;

/**
 * 账务交易入库方法
 *
 * @author Wangkh
 */
public interface SyncCommInDbService extends IBaseService {

    /**
     * 账务交易日志入库
     *
     * @param syncCommInDbInfo
     */
    void tradeFeeInDb(SyncCommInDbInfo syncCommInDbInfo);
}
