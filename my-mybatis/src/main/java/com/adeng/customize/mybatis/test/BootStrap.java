package com.adeng.customize.mybatis.test;


import com.adeng.customize.mybatis.core.config.Configuration;
import com.adeng.customize.mybatis.core.executor.Executor;
import com.adeng.customize.mybatis.core.session.SqlSession;
import com.adeng.customize.mybatis.test.mapper.TestMapper;
import com.adeng.customize.mybatis.test.model.Test;

import java.io.IOException;

/**
 * Created by w11282 on 2018/4/3.
 */
public class BootStrap {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String scanPath = "com.adeng.customize.mybatis.test";
        Configuration configuration = new Configuration(scanPath);
        configuration.build();

        Executor executor = configuration.newExecutor();

        SqlSession sqlSession = new SqlSession(configuration, executor);

        TestMapper mapper = sqlSession.getMapper(TestMapper.class);

        Test test = mapper.selectByPrimaryKey(1);

        System.out.println(test.toString());
//        List<Test> tests = mapper.selectAll();
    }
}
