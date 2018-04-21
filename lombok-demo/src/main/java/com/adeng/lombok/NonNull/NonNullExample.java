package com.adeng.lombok.NonNull;

import lombok.NonNull;

/**
 * @NonNull 不能对 "" 空字符串做检查。
 *
 * 建议在使用的时候不要对String类型使用，用户聚合参数类
 *
 * @author
 * @create 2018-04-21 21:28
 */
public class NonNullExample {
    private String name;

    public NonNullExample(@NonNull String person) {
        this.name = person.toString();
    }


    public static void main(String[] args) {

        NonNullExample nullExample = new NonNullExample("123");

        NonNullExample nullExample2 = new NonNullExample("");

    }
}
