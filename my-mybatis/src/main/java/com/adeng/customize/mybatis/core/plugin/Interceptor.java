package com.adeng.customize.mybatis.core.plugin;

/**
 * 插件需要实现的拦截器接口
 */
public interface Interceptor {

    /**
     * 拦截器调用方法
     *
     * @param invocation 方法签名的调用对象
     * @return
     * @throws Throwable
     */
    Object intercept(Invocation invocation) throws Throwable;

    /**
     * 用代理，用plugin插件包装target
     *
     * @param target
     * @return
     */
    Object plugin(Object target);

}
