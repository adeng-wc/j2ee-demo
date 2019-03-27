package com.adeng.patterns.structural.delegate.simple;

/**
 * 项目负责人
 *
 * @author hzwengcheng 2019-03-27 16:19
 */
public class Leader {

    public void makeProject(){
        EmployeeA a = new EmployeeA();
        a.makeDoc();

        EmployeeB b = new EmployeeB();
        b.makeCode();
    }
}
