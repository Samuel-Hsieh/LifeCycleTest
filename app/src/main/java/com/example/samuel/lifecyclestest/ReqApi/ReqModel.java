package com.example.samuel.lifecyclestest.ReqApi;

/**
 * Created by samuel on 2018/5/18.
 */
public class ReqModel {

    String url;
    ReqType.ReqTypeEnum reqType;
    String param;

    public ReqModel(String url, ReqType.ReqTypeEnum reqType, String param) {
        this.url = url;
        this.reqType = reqType;
        this.param = param;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ReqType.ReqTypeEnum getReqType() {
        return reqType;
    }

    public void setReqType(ReqType.ReqTypeEnum reqType) {
        this.reqType = reqType;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
