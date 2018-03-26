package com.adeng.spring.demo.di;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * 替换方法注入：也叫“MethodReplacer”注入，
 * 和查找注入方法不一样的是，他主要用来替换方法体。
 * 通过首先定义一个MethodReplacer接口实现
 *
 * @author
 * @create 2018-03-25 下午5:27
 */
public class PrinterReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {

        System.out.println("Print Replacer");
        //注意此处不能再通过反射调用了,否则会产生循环调用，知道内存溢出
        //method.invoke(obj, new String[]{"hehe"});
        return null;
    }
}
