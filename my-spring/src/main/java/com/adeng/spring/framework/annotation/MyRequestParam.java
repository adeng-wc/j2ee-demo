package com.adeng.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * 用于标注URL请求参数
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:36 2018
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
    String value() default "";
}
