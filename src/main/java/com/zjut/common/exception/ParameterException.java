package com.zjut.common.exception;


import com.zjut.common.enums.ResultCodeEnum;

/**
 * 参数异常
 * @author jack
 */
public class ParameterException extends RuntimeException {
    private String code;

    public ParameterException() {
        super(ResultCodeEnum.PARAMETER_ILLEGAL.getMessage());
        this.code = ResultCodeEnum.PARAMETER_ILLEGAL.getCode();
    }

    public ParameterException(String code, String message) {
        super(message);
        this.code = ResultCodeEnum.PARAMETER_ILLEGAL.getCode();
        this.code = code;
    }

    public ParameterException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = ResultCodeEnum.PARAMETER_ILLEGAL.getCode();
        this.code = resultCodeEnum.getCode();
    }

    public ParameterException(String message) {
        super(message);
        this.code = ResultCodeEnum.PARAMETER_ILLEGAL.getCode();
    }

    public ParameterException(String message, Throwable throwable) {
        super(message, throwable);
        this.code = ResultCodeEnum.PARAMETER_ILLEGAL.getCode();
    }

    public ParameterException(Throwable throwable) {
        super(throwable);
        this.code = ResultCodeEnum.PARAMETER_ILLEGAL.getCode();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
