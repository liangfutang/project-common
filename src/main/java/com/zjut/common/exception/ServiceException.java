package com.zjut.common.exception;

import com.zjut.common.enums.ResultCodeEnum;
import org.springframework.http.HttpStatus;

/**
 * 自定义全局最大的异常
 * @author jack
 */
public class ServiceException extends Exception {

    private String code;

    private HttpStatus status;

    private String hint;

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    private ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
        this.code = ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ServiceException(String code, HttpStatus status, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public ServiceException(HttpStatus status, String code, String message, String hint) {
        super(message);
        this.code = code;
        this.status = status;
        this.hint = hint;
    }

    public ServiceException(String code, HttpStatus status, String message, String sessionId) {
        super(message);
        this.code = code;
        this.status = status;
        this.sessionId = sessionId;
    }

    public ServiceException(String code, HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode();
        this.status = status;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.code = ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ServiceException(Throwable cause) {
        super(cause);
        this.code = ResultCodeEnum.INTERNAL_SERVER_ERROR.getCode();
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }


}
