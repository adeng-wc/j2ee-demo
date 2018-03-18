package com.adeng.java.util.concurrent;

import org.junit.Test;

import java.util.Random;

public class BinaryTest {



    @Test
    public void test1() {

        int n = new Random().nextInt() - 1; //110000

        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println("--------------------------");
        n |= n >>> 1;
        /*
            n =      110000
            n >>> 1 = 11000;
            110000 与
            011000 或
          = 111000
         */
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        /*
            n =       111000
            n >>> 2 = 001110;
            111000 与
            001110 或
          = 111110
         */
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        /*
            n =      111110
            n >>> 4 =000011;
            111110 与
            000011 或
          = 111111
         */
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(n));

    }

}
