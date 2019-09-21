package com.zjut.common.utils;

public class StringUtil {

    public static boolean isEmpty(String content) {
        if (content==null || "".equals(content)) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String content) {
        return !isEmpty(content);
    }
}
