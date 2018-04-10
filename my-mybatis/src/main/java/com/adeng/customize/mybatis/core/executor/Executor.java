package com.adeng.customize.mybatis.core.executor;

public interface Executor {

    <T> T query(String sql, Class entiry);

}
