package com.adeng.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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


    @Test
    public void test() throws InterruptedException {

        List<String> list = Arrays.asList("1", "2", "3");

        list = list.parallelStream().map(e -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("test" + Thread.currentThread().getName());

            return e + "sre";

        }).collect(Collectors.toList());

        Thread.sleep(1000);
        System.out.println("----------------------");


        System.out.println(list);
    }
}
