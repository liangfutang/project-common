package com.zjut.common.enums;

/**
 * 返回错误码
 */
public enum ResultCode {

    OK("200", "操作成功"),
    SUCCESS("1000", "操作成功"),
    FAILURE("1010", "操作失败"),
    INTERNAL_SERVER_ERROR("8500", "服务器端内部异常");  //500

    private String code;
    private String name;

    ResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
