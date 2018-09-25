package com.unicom.acts.pay.syncserv.domain;

/**
 * 账务常量定义
 *
 * @author Wangkh
 */
public class ActsPayPubDef {
    private ActsPayPubDef() {
    }

    public static final String BATCH_DEAL_MODE = "batchMode";

    //非抵扣期
    public static final String ORDER_CYCLE_STATUS = "0";

    //抵扣期
    public static final String DRECV_CYCLE_STATUS = "1";

    //回检TF_B_PAYLOG
    public static final String CHECK_TYPE_PAYLOG = "0";

    //回检TF_B_PAYLOG_DMN
    public static final String CHECK_TYPE_PAYLOGDMN = "1";

    //回检TF_B_ASYN_WORK
    public static final String CHECK_TYPE_ASYNWORK = "2";

    //Topic类型
    public static final String SYNC_MQTYPE_ORDER = "DEVACT_SYNCDEPO_TEST2";
}
