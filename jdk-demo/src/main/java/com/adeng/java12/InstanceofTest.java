package com.adeng.java12;

/**
 * @author wengcheng on 2022/5/25
 */
public class InstanceofTest {
    public static void main(String[] args) {
        Object obj = "Hello Java 12!";
        if (obj instanceof String str) {
            int length = str.length();
        }
    }
}
