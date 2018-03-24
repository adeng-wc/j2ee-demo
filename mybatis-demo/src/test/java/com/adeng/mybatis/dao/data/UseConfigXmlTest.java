package com.adeng.mybatis.dao.data;

import com.adeng.mybatis.dao.ContractMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis使用config.xml启动
 *
 * @author
 * @create 2018-03-25 上午12:50
 */
public class UseConfigXmlTest {


    @Test
    public void test1() throws IOException {

        String resource = "com/adeng/mybatis/dao/data/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        ContractMapper mapper = sqlSession.getMapper(ContractMapper.class);

        System.out.println(   mapper.selectByPrimaryKey(1));
    }

}
