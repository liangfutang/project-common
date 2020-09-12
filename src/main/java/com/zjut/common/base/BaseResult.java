package com.zjut.common.base;


import com.zjut.common.enums.ResultCode;
import org.springframework.http.HttpStatus;

public class BaseResult<T> extends BaseObject {

    private Boolean isSuccess = Boolean.FALSE;
    private String code = ResultCode.FAILURE.getCode();
    private String message;
    private String hint;

    private HttpStatus httpStatus = HttpStatus.OK;

    private T data;
    /**
     * 操作会话Id
     */
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void error(HttpStatus httpStatus, ResultCode resultCode, String hint, String sessionId) {
        this.httpStatus = httpStatus;
        this.code = resultCode.getCode();
        this.message = resultCode.getName();
        this.hint = hint;
        this.sessionId = sessionId;
    }

    public void error(HttpStatus httpStatus, ResultCode resultCode, String hint) {
        this.httpStatus = httpStatus;
        this.code = resultCode.getCode();
        this.message = resultCode.getName();
        this.hint = hint;
    }

    public void error(HttpStatus httpStatus, ResultCode resultCode) {
        this.httpStatus = httpStatus;
        this.code = resultCode.getCode();
        this.message = resultCode.getName();
    }
}