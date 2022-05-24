package com.adeng.random.demo;

import java.util.Random;

/**
 * @author wengcheng on 2022/5/24
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random1 = new Random(10000);
        Random random2 = new Random(10000);

        for (int i = 0; i < 5; i++) {
//            System.out.println(random1.nextInt() + " = " + random2.nextInt());
            System.out.println(random1.nextInt());
        }
        System.out.println("-------");
        for (int i = 0; i < 5; i++) {
//            System.out.println(random1.nextInt() + " = " + random2.nextInt());
            System.out.println(random2.nextInt());
        }
    }
}
