package com.adeng.customize.mybatis.test.plugins;


import com.adeng.customize.mybatis.core.executor.Executor;
import com.adeng.customize.mybatis.core.handler.StatementHandler;
import com.adeng.customize.mybatis.core.plugin.*;
import sun.plugin2.main.server.ResultHandler;

/**
 * Created by James
 * From 咕泡学院出品
 * 老师咨询 QQ 2904270631
 */
@Intercepts({@Signature(type = Executor.class,
        method = "query",
        args = {StatementHandler.class, Object.class, ResultHandler.class})})
public class TestPlugin implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("invoke TestPlugin ");
        return invocation.proceed();
    }

    /**
     * 利用代理包装target
     *
     * @param target
     * @return
     */
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
