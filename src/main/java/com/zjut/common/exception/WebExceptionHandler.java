package com.zjut.common.exception;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 在各自的微服务中通过继承使用该全局异常捕获
 */
public class WebExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger("error");

    public WebExceptionHandler() {
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<?> operateExp(ServiceException ex, HttpServletRequest request) {
        this.logger.error("处理" + request.getRequestURI() + "请求系统业务异常,如下:", ex.getMessage());
        HttpStatus status = ex.getStatus();

        String message = ex.getMessage();
        String businessMessage = ex.getMessage();

        Map<String, Object> jsonObject = new HashMap();
        HashMap json = new HashMap(4);
        json.put("code", ex.getCode());
        json.put("message", message);
        json.put("hint", businessMessage);
        json.put("sessionId", null);
        jsonObject.put("error", json);
        return new ResponseEntity(jsonObject, status);
    }

}
