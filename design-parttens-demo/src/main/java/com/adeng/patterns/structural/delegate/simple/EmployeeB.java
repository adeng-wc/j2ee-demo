package com.adeng.patterns.structural.delegate.simple;

/**
 * 员工B
 *
 * @author hzwengcheng 2019-03-27 16:19
 */
public class EmployeeB implements Employee{

    public void makeCode() {
        System.out.println("写代码");
    }

    @Override
    public void make() {
        System.out.println("work");
    }
}
