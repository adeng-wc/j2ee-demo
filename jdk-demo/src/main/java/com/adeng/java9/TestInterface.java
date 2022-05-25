package com.adeng.java9;

/**
 * @author wengcheng on 2022/5/24
 */
public interface TestInterface {

    String test();

    // 接口默认方法
    default String defaultTest() {
        privateTest();
        return "default";
    }


    private String privateTest() {
        System.out.println("private method staticTest");
        return "static";
    }
}
