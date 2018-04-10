package com.adeng.customize.mybatis.core.plugin;

import java.lang.annotation.*;

/**
 * plugin标记的注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Intercepts {
    Signature[] value();
}
