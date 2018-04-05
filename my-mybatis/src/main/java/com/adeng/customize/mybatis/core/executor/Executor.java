package com.adeng.customize.mybatis.core.executor;

import com.adeng.customize.mybatis.core.config.Configuration;
import com.adeng.customize.mybatis.core.handler.StatementHandler;

/**
 * 执行
 * Created by w11282 on 2018/4/3.
 */
public class Executor {

    private Configuration configuration;

    public Executor(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T query(String sql, Class entiry) {
        StatementHandler statementHandler = new StatementHandler(configuration);
        return statementHandler.query(sql, entiry);
    }
}
