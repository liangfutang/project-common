package com.zjut.common.enums;

/**
 * 返回错误码
 */
public enum ResultCode {

    OK("200", "操作成功"),
    SUCCESS("1000", "操作成功"),
    FAILURE("1010", "操作失败");

    private String code;
    private String name;
    private ResultCode(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
