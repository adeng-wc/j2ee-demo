package com.adeng.random.demo;

import org.apache.commons.math3.random.MersenneTwister;

/**
 * @author wengcheng on 2022/5/24
 */
public class Mt19937Test {

    public static void main(String[] args) {
        MersenneTwister mt1 = new MersenneTwister(1000);
        MersenneTwister mt2 = new MersenneTwister(1000);

        for (int i = 0; i < 5; i++) {
            System.out.println(mt1.nextInt() + " == " + mt2.nextInt());
        }
    }
}
