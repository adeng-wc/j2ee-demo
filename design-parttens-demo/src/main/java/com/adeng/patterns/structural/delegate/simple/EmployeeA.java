package com.adeng.patterns.structural.delegate.simple;

/**
 * 员工A
 *
 * @author hzwengcheng 2019-03-27 16:19
 */
public class EmployeeA implements Employee{

    public void makeDoc(){
        System.out.println("写文档");
    }

    @Override
    public void make() {
        System.out.println("work");
    }
}
