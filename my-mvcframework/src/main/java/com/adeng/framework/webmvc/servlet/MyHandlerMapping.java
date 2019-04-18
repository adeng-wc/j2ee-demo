package com.adeng.framework.webmvc.servlet;

import com.adeng.framework.webmvc.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * url 和 method 方法关联
 *
 * @author hzwengcheng 2019-03-29 17:49
 */
public class MyHandlerMapping {

    /*
        正则
     */
    private Pattern pattern;
    private Method method;
    private Object controller;
    private Class<?>[] paramTypes;
    /*
        参数的名字作为key,参数的顺序，位置作为值
     */
    public Map<String, Integer> paramIndexMapping;

    public MyHandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.method = method;
        this.controller = controller;

        this.paramTypes = method.getParameterTypes();
        this.paramIndexMapping = new HashMap<>();
        putParamIndexMapping(method);
    }

    private void putParamIndexMapping(Method method) {

        //提取方法中加了注解的参数
        //把方法上的注解拿到，得到的是一个二维数组
        //因为一个参数可以有多个注解，而一个方法又有多个参数
        Annotation[][] pa = method.getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation a : pa[i]) {
                if (a instanceof MyRequestParam) {
                    String paramName = ((MyRequestParam) a).value();
                    if (!"".equals(paramName.trim())) {
                        paramIndexMapping.put(paramName, i);
                    }
                }
            }
        }

        //提取方法中的request和response参数
        Class<?>[] paramsTypes = method.getParameterTypes();
        for (int i = 0; i < paramsTypes.length; i++) {
            Class<?> type = paramsTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                paramIndexMapping.put(type.getName(), i);
            }
        }
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Method getMethod() {
        return method;
    }

    public Object getController() {
        return controller;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public Map<String, Integer> getParamIndexMapping() {
        return paramIndexMapping;
    }
}
