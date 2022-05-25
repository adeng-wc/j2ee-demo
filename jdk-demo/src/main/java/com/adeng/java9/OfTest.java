package com.adeng.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * of 创建不可修改的集合
 *
 * @author wengcheng on 2022/5/24
 */
public class OfTest {

    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "xiaomi", "13xiang");
        Map<Integer, String> numbers = Map.of(1, "one", 2, "two", 3, "three");
        Set<String> colors = Set.of("yellow", "red", "baoqiang");

    }
}
