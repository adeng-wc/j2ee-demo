package com.adeng.spring.demo.di;

import com.adeng.spring.demo.HelloApi;

/**
 * 抽像类
 * <p>
 * 需要容器对其进行子类化处理，
 * 还定义了一个抽象方法createPrototypePrinter用于创建“prototype”Bean，
 * createSingletonPrinter方法用于创建“singleton”Bean，
 * 此处注意方法会被Spring拦截，不会执行方法体代码：
 *
 * 使用<lookup-method name="方法名" bean="bean名字"/>配置；
 * 其中name属性指定方法名，bean属性指定方法需返回的Bean。
 *
 * @author
 * @create 2018-03-25 下午5:13
 */
public abstract class HelloImpl5 implements HelloApi {

    private Printer printer;

    public void sayHello() {
        printer.print("setter");
        createPrototypePrinter().print("prototype");
        createSingletonPrinter().print("singleton");
    }

    public abstract Printer createPrototypePrinter();

    public Printer createSingletonPrinter() {
        System.out.println("该方法不会被执行，如果输出就错了");
        return new Printer();
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
