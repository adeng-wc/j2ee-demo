package com.adeng.mybatis.springmvc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author
 * @create 2018-03-25 下午12:32
 */
@ComponentScan
@MapperScan("com.adeng.mybatis.springmvc.demo.dao.mapper")
public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);

    }
}
