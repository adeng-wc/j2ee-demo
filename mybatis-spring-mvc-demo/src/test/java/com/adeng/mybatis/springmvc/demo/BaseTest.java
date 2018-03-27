package com.adeng.mybatis.springmvc.demo;

import com.adeng.mybatis.springmvc.demo.config.DataSourceConfig;
import com.adeng.mybatis.springmvc.demo.config.MybatisConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试抽象类
 *
 * @author
 * @create 2018-03-27 下午10:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, MybatisConfig.class})
public abstract class BaseTest {

}
