package com.adeng.customize.mybatis.core.plugin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法签名，返回类型，方法名，参数类型
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Signature {
    Class<?> type();

    String method();

    Class<?>[] args();
}
