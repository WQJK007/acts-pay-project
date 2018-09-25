package com.unicom.acts.pay.syncserv.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.unicom.skyark.component.common.SkyArkPropertyNamingStrategy;

import java.util.List;

/**
 * 信控短信MQ信息
 *
 * @author Wangkh
 */
@JsonNaming(SkyArkPropertyNamingStrategy.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreditSmsMsgInfo {
    private JFCreditMQInfo jfCreditMQInfo;
    private LeaveRealFeeMQInfo leaveRealFeeMQInfo;
    private RecvCreditMQInfo recvCreditMQInfo;
    private List<SmsMQInfo> smsMQInfos;
    private CreditSmsMsgKey creditSmsCheckInfo;

    public JFCreditMQInfo getJfCreditMQInfo() {
        return jfCreditMQInfo;
    }

    public void setJfCreditMQInfo(JFCreditMQInfo jfCreditMQInfo) {
        this.jfCreditMQInfo = jfCreditMQInfo;
    }

    public LeaveRealFeeMQInfo getLeaveRealFeeMQInfo() {
        return leaveRealFeeMQInfo;
    }

    public void setLeaveRealFeeMQInfo(LeaveRealFeeMQInfo leaveRealFeeMQInfo) {
        this.leaveRealFeeMQInfo = leaveRealFeeMQInfo;
    }

    public RecvCreditMQInfo getRecvCreditMQInfo() {
        return recvCreditMQInfo;
    }

    public void setRecvCreditMQInfo(RecvCreditMQInfo recvCreditMQInfo) {
        this.recvCreditMQInfo = recvCreditMQInfo;
    }

    public List<SmsMQInfo> getSmsMQInfos() {
        return smsMQInfos;
    }

    public void setSmsMQInfos(List<SmsMQInfo> smsMQInfos) {
        this.smsMQInfos = smsMQInfos;
    }

    public CreditSmsMsgKey getCreditSmsCheckInfo() {
        return creditSmsCheckInfo;
    }

    public void setCreditSmsCheckInfo(CreditSmsMsgKey creditSmsCheckInfo) {
        this.creditSmsCheckInfo = creditSmsCheckInfo;
    }

    @Override
    public String toString() {
        return "CreditSmsMsgInfo{" +
                "jfCreditMQInfo=" + jfCreditMQInfo +
                ", leaveRealFeeMQInfo=" + leaveRealFeeMQInfo +
                ", recvCreditMQInfo=" + recvCreditMQInfo +
                ", smsMQInfos=" + smsMQInfos +
                ", creditSmsCheckInfo=" + creditSmsCheckInfo +
                '}';
    }
}
