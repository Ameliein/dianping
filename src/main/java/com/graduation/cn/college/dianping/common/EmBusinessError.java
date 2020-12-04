package com.graduation.cn.college.dianping.common;

public enum EmBusinessError {

    //通用的错误类型10000开头
    NO_OBJECT_FOUND(10001,"requested object don't exist"),
    UNKNOWN_ERROR(10002,"unknown error"),
    NO_HANDLER_FOUND(10003,"can't find the excurtive loaction operation"),
    BIND_EXCEPTION_ERROR(10004,"request parameter error"),
    PARAMETER_VALIDATION_ERROR(10005,"Parameter validation error"),

    //用户服务相关的错误类型20000开头
    REGISTER_DUP_FAIL(20001,"user had already exist!"),

    LOGIN_FAIL(20002,"phone number or password error"),
    //admin相关错误
    ADMIN_SHOULD_LOGIN(30001,"管理员需要先登录"),

    CATEGORY_NAME_DUPLICATED(40001,"品类名已存在"),
    ;


    private Integer errCode;
    private String errMsg;

    EmBusinessError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
