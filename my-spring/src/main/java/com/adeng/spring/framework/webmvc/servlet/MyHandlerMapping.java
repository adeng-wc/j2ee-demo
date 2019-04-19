package com.adeng.spring.framework.webmvc.servlet;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * url 和 Method 的映射
 *
 * @author hzwengcheng 2019-04-17 17:45
 */
@Data
public class MyHandlerMapping {
    private Pattern pattern;
    private Method method;
    private Object controller;
    private Class<?>[] paramTypes;

    public MyHandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;

        this.paramTypes = method.getParameterTypes();
    }
}
