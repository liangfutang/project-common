package com.zjut.common.utils;

import com.zjut.common.constants.Constants;
import org.apache.commons.lang3.StringUtils;

/**
 * 做数字相关操作的工具
 */
public class NumberUtil {

    /**
     * 判断传进来的字符串是不是正整数，包含零(传进来0也做正整数处理)
     * 入参为空时抛出异常
     * @param str
     */
    public static boolean isPositiveNumber(String str) {
        if (StringUtils.isBlank(str)) {
            throw new RuntimeException("非法入参");
        }
        return str.matches(Constants.POSITIVE_REGEX);
    }

    /**
     * 判断传进来的字符串是不是正整数，不包括零
     * 入参为空时抛出异常
     * @param str
     * @return
     */
    public static boolean isPositiveNumberNoInclZiro(String str) {
        if (StringUtils.isBlank(str)) {
            throw new RuntimeException("非法入参");
        }
        return str.matches(Constants.POSITIVE_REGEX) && !"0".equals(str);
    }

}
