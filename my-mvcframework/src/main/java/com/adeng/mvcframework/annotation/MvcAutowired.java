package com.adeng.mvcframework.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标注依赖注入的参数。
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:36 2018
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MvcAutowired {
    String value() default "";
}
