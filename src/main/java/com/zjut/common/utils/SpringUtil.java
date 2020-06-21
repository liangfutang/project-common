package com.zjut.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 对Spring内存做相关操作
 */
@Component
public class SpringUtil  implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 根据bean名称获取bean对象
     * @param name
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name){
        return (T)applicationContext.getBean(name);
    }

    /**
     * 根据bean名称和要求的bean类型，获取bean对象
     * @param name
     * @param requiredType
     * @return
     */
    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * 根据对象类型获取bean对象
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<?> clazz) {
        return (T)applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        SpringUtil.applicationContext = ac;
    }
}
