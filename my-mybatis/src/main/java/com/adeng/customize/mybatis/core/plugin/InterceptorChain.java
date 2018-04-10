package com.adeng.customize.mybatis.core.plugin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author
 * @create 2018-04-10 下午9:49
 */
public class InterceptorChain {

    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public List<Interceptor> getInterceptors() {
        return Collections.unmodifiableList(interceptors);
    }

    /**
     * 将executor用代理一层层包装
     * @param target executor
     * @return
     */
    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

}
