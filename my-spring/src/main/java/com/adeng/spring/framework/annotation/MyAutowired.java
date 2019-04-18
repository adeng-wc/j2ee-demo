package com.adeng.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * 用于标注依赖注入的参数。
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:36 2018
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
    String value() default "";
}
