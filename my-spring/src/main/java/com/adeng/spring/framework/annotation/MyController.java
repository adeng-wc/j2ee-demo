package com.adeng.spring.framework.annotation;

import java.lang.annotation.*;

/**
 * 用于标注Controller组件
 *
 * @Author: Adengdeng
 * @Date: Create in 下午11:36 2018
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {
    String value() default "";
}
