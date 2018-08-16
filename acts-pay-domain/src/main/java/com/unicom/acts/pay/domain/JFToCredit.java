package com.unicom.acts.pay.domain;

/**
 * TI_O_JFTOCREDIT_BIGACCT,TI_O_JFTOCREDIT表对象
 *
 * @author Wangkh
 */
public class JFToCredit {
    private String userId;
    private String acctId;
    private String tradeTypeCode;
    private String tradeId;
    private String writeOffMode;
    private long realFee;
    private long leaveRealFee;
    private String recoverTag;
    private String cancelTag;
    private String batchTag;
    private String processTag;
    private String remark;
    private String updateStaffId;
    private String updateDepartId;
    private String updateTime;
    private String processTime1;
    private String processRemark1;
    private String processTime2;
    private String processRemark2;
    private String provinceCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getTradeTypeCode() {
        return tradeTypeCode;
    }

    public void setTradeTypeCode(String tradeTypeCode) {
        this.tradeTypeCode = tradeTypeCode;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getWriteOffMode() {
        return writeOffMode;
    }

    public void setWriteOffMode(String writeOffMode) {
        this.writeOffMode = writeOffMode;
    }

    public long getRealFee() {
        return realFee;
    }

    public void setRealFee(long realFee) {
        this.realFee = realFee;
    }

    public long getLeaveRealFee() {
        return leaveRealFee;
    }

    public void setLeaveRealFee(long leaveRealFee) {
        this.leaveRealFee = leaveRealFee;
    }

    public String getRecoverTag() {
        return recoverTag;
    }

    public void setRecoverTag(String recoverTag) {
        this.recoverTag = recoverTag;
    }

    public String getCancelTag() {
        return cancelTag;
    }

    public void setCancelTag(String cancelTag) {
        this.cancelTag = cancelTag;
    }

    public String getBatchTag() {
        return batchTag;
    }

    public void setBatchTag(String batchTag) {
        this.batchTag = batchTag;
    }

    public String getProcessTag() {
        return processTag;
    }

    public void setProcessTag(String processTag) {
        this.processTag = processTag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdateStaffId() {
        return updateStaffId;
    }

    public void setUpdateStaffId(String updateStaffId) {
        this.updateStaffId = updateStaffId;
    }

    public String getUpdateDepartId() {
        return updateDepartId;
    }

    public void setUpdateDepartId(String updateDepartId) {
        this.updateDepartId = updateDepartId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getProcessTime1() {
        return processTime1;
    }

    public void setProcessTime1(String processTime1) {
        this.processTime1 = processTime1;
    }

    public String getProcessRemark1() {
        return processRemark1;
    }

    public void setProcessRemark1(String processRemark1) {
        this.processRemark1 = processRemark1;
    }

    public String getProcessTime2() {
        return processTime2;
    }

    public void setProcessTime2(String processTime2) {
        this.processTime2 = processTime2;
    }

    public String getProcessRemark2() {
        return processRemark2;
    }

    public void setProcessRemark2(String processRemark2) {
        this.processRemark2 = processRemark2;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
