package com.adeng.patterns.creational.prototype;

import java.util.Arrays;

/**
 * @author hzwengcheng 2019-03-27 10:44
 */
public class Test {

    public static void main(String[] args) throws Exception {

        StudentPrototype student1 = new StudentPrototype();
        student1.name = "A";
        student1.age = 18;
        student1.courses = Arrays.asList(new Course("化学"), new Course("数学"));


        StudentPrototype student2 = student1.clone();


        /*
            调用深克隆，引用类型的内存地址都不同了
         */
        System.out.println(student1 == student2);
        System.out.println(student1.age == student2.age);
        System.out.println(student1.name == student2.name);
        System.out.println(student1.courses == student2.courses);
    }
}
