package com.zjut.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    private static ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    /**
     * 取出网关塞进来的username，如没获取到，给定一个默认的参数
     * @return
     */
    public static String getLoginUserName() {
        HttpServletRequest request = attributes.getRequest();
        String username = request.getHeader("x-username");
        return StringUtils.isNotBlank(username) ? username : "system";
    }

    /**
     * 取出网关塞进来的 uid
     * @return
     */
    public static String getLoginUserId() {
        HttpServletRequest request = attributes.getRequest();
        String uid = request.getHeader("x-uid");
        if (StringUtils.isBlank(uid)) {
            return null;
        }
        return uid;
    }
    
    /**
     * 取出网关塞进来的 businessId
     * @return
     */
    public static String getBusinessId() {
        HttpServletRequest request = attributes.getRequest();
        String businessId = request.getHeader("x-business-id");
        if (StringUtils.isBlank(businessId)) {
            return null;
        }
        return businessId;
    }
}
