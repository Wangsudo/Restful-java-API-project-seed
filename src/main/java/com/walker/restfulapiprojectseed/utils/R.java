package com.walker.restfulapiprojectseed.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 固定返回类型
 * Created by wangshun on 2018/3/18
 **/
public class R <T> {
    //序列化errorCode 属性为 error_code
    @JsonProperty("error_code")
    private Integer errorCode;
    @JsonProperty("error_Msg")
    private String errorMsg;
    @JsonProperty("extra")
    private T extra;

    private R(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public R(T extra) {
        this.errorCode = ErroCodeSet.SUCCESS;
        this.errorMsg = ErroCodeSet.SUCCESS_MSG;
        this.extra = extra;

    }

    public static R ok(){
        return new R(ErroCodeSet.SUCCESS,ErroCodeSet.SUCCESS_MSG);
    }

    public R getMsg(String msg){
        return new R(ErroCodeSet.SUCCESS,msg);
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

    public void setExtra(T extra) {
        this.extra = extra;
    }
}
