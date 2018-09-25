package com.unicom.acts.pay.syncserv.domain;

/**
 * 微服务请求路由信息
 *
 * @author Wangkh
 */
public class UrlRouteParam {
    private String provinceCode;
    private String eparchyCode;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getEparchyCode() {
        return eparchyCode;
    }

    public void setEparchyCode(String eparchyCode) {
        this.eparchyCode = eparchyCode;
    }

    @Override
    public String toString() {
        return "UrlRouteParam{" +
                "provinceCode='" + provinceCode + '\'' +
                ", eparchyCode='" + eparchyCode + '\'' +
                '}';
    }
}
