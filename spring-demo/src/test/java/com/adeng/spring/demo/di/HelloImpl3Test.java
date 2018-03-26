package com.adeng.spring.demo.di;

import com.adeng.spring.demo.HelloApi;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author
 * @create 2018-03-25 下午1:54
 */
public class HelloImpl3Test {


    @Test
    public void testConstructorDependencyInjectTest() {
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("di/helloworld.xml");

        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();

        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();

        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();

        HelloApi byStaticFactory = beanFactory.getBean("byStaticFactory", HelloApi.class);
        byStaticFactory.sayHello();

        HelloApi byInstanceFactory = beanFactory.getBean("byInstanceFactory", HelloApi.class);
        byInstanceFactory.sayHello();

        HelloApi setterBean = beanFactory.getBean("setterBean", HelloApi.class);
        setterBean.sayHello();

        /* 查找方法注入 */
        System.out.println("=======singleton sayHello======");
        HelloApi helloImpl51 = beanFactory.getBean("helloImpl51", HelloApi.class);
        helloImpl51.sayHello();

        helloImpl51 = beanFactory.getBean("helloImpl51", HelloApi.class);
        helloImpl51.sayHello();

        System.out.println("=======prototype sayHello======");
        HelloApi helloImpl52 = beanFactory.getBean("helloImpl52", HelloApi.class);
        helloImpl52.sayHello();

        helloImpl52 = beanFactory.getBean("helloImpl52", HelloApi.class);
        helloImpl52.sayHello();

        /* 替换方法注入 */
        Printer printer = beanFactory.getBean("printer", Printer.class);
        printer.print("我将被替换");
    }

}
