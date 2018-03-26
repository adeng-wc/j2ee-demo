package com.adeng.mybatis.springmvc.demo.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * DataSource相关的配置类
 *
 * @author
 * @create 2018-03-25 上午11:06
 */
@Configuration
@ComponentScan(basePackages = "com.adeng.mybatis.springmvc.demo")
@PropertySource("classpath:config/app.properties")
public class DataSourceConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;


    @Bean(name = "dataSource")
    public DataSource dataSource() {

        DataSource dataSource = new PooledDataSource(driver, url, username, password);

        return dataSource;
    }

 /*   @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }*/

  /*  @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory.getObject();
    }*/

 /*   *//**
     * 必须加上static
     *//*
    @Bean
    public static PropertySourcesPlaceholderConfigurer loadProperties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        return configurer;
    }*/

}
