package com.adeng.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * 用于标注URL请求路径的映射
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:36 2018
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {
    String value() default "";
}
