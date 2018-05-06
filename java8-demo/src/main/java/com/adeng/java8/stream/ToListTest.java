package com.adeng.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hzwengcheng 2018-05-03 12:38
 */
public class ToListTest {

    public static void main(String[] args) {
        List<String> activityList = new ArrayList<>();

        List<String> strings = activityList.stream().map(str -> str + "!!!").collect(Collectors.toList());

        System.out.println(strings.toString());
        System.out.println(strings.size());
    }
}
