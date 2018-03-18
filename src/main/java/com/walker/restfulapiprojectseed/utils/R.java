package com.walker.restfulapiprojectseed.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 固定返回类型
 * Created by wangshun on 2018/3/18
 **/
public class R {
    public static final R SUCCESS = new R(1000, "success");
    public static final R SYSTEM_BUSY = new R(2000, "The system is too busy,please try again later");
    //序列化errorCode 属性为 error_code
    @JsonProperty("error_code")
    private Integer errorCode;
    @JsonProperty("error_Msg")
    private String errorMsg;
    @JsonProperty("extra")
    private Object extra;

    public R(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public R(Object extra) {
        this.errorCode = 1000;
        this.errorMsg = "success";
        this.extra = extra;

    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
