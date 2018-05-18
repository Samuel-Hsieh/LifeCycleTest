package com.example.samuel.lifecyclestest.ReqApi;

/**
 * Created by samuel on 2018/5/18.
 */
public interface IReqApi {

    @ReqType(reqType = ReqType.ReqTypeEnum.GET)
    @ReqUrl(reqUrl = "deerlight.com/api/v2/login")
    String login(@ReqParam(value = "userId") String userId, @ReqParam(value = "pwd") String pwd, ReqApi.ApiCallback callback);

}
