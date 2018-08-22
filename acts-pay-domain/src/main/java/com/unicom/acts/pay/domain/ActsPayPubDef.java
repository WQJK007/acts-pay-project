package com.unicom.acts.pay.domain;

/**
 * 账务常量定义
 *
 * @author Wangkh
 */
public class ActsPayPubDef {
    private ActsPayPubDef() {
    }

    ;
    //RDS参数库
    public static final String ACT_RDS_DBCONN = "rds";
    //账务中心数据库
    public static final String ACTING_DRDS_DBCONN = "acting";
    //账户中心数据库
    public static final String ACTS_DRDS_DBCONN = "acts";
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
