package com.zjut.common.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BaseObject implements Serializable {


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
