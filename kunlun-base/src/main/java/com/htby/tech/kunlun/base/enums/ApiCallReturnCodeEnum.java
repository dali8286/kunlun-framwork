package com.htby.tech.kunlun.base.enums;

/**
 * Api调用返回码
 *
 * @author vincent0116
 * @date 2018/11/6
 */
public enum ApiCallReturnCodeEnum {

    ERROR(-1, "系统异常"),
    SUCCESS(200, "请求成功"),
    FORBIDDEN(403, "拒绝服务"),
    NOT_FOUND(404, "资源不存在"),
    SIGN_ERROR(11001, "验签错误"),
    PARAMS_ERROR(11002, "参数错误"),
    PARAMS_CONTENT_TYPE_ERROR(11003, "请求Content-Type错误"),
    REQUEST_METHOD_NOT_SUPPORTED_ERROR(11004, "请求METHOD错误"),
    INTERNAL_EXCEPTION_ERROR(12001, "请求异常"),
    USER_ERROR(21001, "用户类错误"),
    NO_TOKEN_RELOGIN(91000, "登录失效,重新登录");

    private Integer code;
    private String message;

    ApiCallReturnCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
