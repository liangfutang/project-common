package com.zjut.common.enums;

/**
 * 常用错误码
 * @author jack
 */
public enum ResultCodeEnum {

    SUCCESS("1000", "操作成功"),
    FAILURE("1010", "操作失败"),
    PARAMETER_ILLEGAL("2000", "请求参数不合法"),
    INTERNAL_SERVER_ERROR("5000", "服务内部错误"),
    ;

    private String code;
    private String message;

    private ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
