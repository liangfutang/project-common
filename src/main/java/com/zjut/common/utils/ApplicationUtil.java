package com.zjut.common.utils;

import java.util.Optional;

public class ApplicationUtil {
    private final static String ENV_KEY = "ENV_TYPE";

    /**
     * 获取当前服务的环境
     * @return
     */
    public static String getEnv() {
        String env = null;
        String envStr = Optional.ofNullable(System.getenv(ENV_KEY)).orElse("local");
        switch (envStr){
            case "development": env = "开发环境"; break;
            case "testing": env = "测试环境"; break;
            case "staging": env = "演示环境"; break;
            case "production": env = "生产环境"; break;
            default:env = "未知环境";
        }
        return env;
    }
}
