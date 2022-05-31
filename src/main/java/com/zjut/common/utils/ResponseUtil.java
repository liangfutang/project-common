package com.zjut.common.utils;

import com.zjut.common.base.BaseResult;
import com.zjut.common.base.PageResult;
import com.zjut.common.enums.ResultCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 对返回结果做封装
 */
public class ResponseUtil {

    public static ResponseEntity<?> wrapSuccessResult() {
        BaseResult<Object> result = getBaseResult((Object)null, true, ResultCodeEnum.SUCCESS.getCode(), (String)null);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<?> wrapSuccessResult(T data) {
        BaseResult<Object> result = getBaseResult(data, true, ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<?> wrapSuccessResult(T data, String code) {
        BaseResult<Object> result = getBaseResult(data, true, code, (String)null);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<?> wrapSuccessResult(T data, String code, String message) {
        if (data instanceof PageResult) {
            ((PageResult)data).setCode(code);
            ((PageResult)data).setMessage(message);
            ((PageResult)data).setSuccess(true);
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            BaseResult<Object> result = getBaseResult(data, true, code, message);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    public static <T> ResponseEntity<?> wrapFailureResult(T data) {
        BaseResult<Object> result = getBaseResult(data, false, ResultCodeEnum.FAILURE.getCode(), ResultCodeEnum.FAILURE.getMessage());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<?> wrapFailureResult(T data, String code) {
        BaseResult<Object> result = getBaseResult(data, false, code, (String)null);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<?> wrapFailureResult(String code, String message) {
        BaseResult<Object> result = getBaseResult((Object)null, false, code, message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<?> wrapFailureResult(T data, String code, String message) {
        BaseResult<Object> result = getBaseResult(data, false, code, message);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private static <T> BaseResult<T> getBaseResult(T data, boolean success, String code, String message) {
        BaseResult<T> result = new BaseResult<>();
        result.setData(data);
        result.setSuccess(success);
        result.setCode(code);
        result.setMessage(message);
        if (StringUtils.isEmpty(result.getSessionId())) {
            result.setSessionId(TraceIdUtil.getTraceId());
        }

        return result;
    }

    private ResponseUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
